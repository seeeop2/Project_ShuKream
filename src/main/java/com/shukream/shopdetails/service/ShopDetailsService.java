package com.shukream.shopdetails.service;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.context.annotation.Role;
import org.springframework.stereotype.Service;
import com.shukream.asks.dao.AsksDAO;
import com.shukream.asks.vo.AsksVO;
import com.shukream.bids.dao.BidsDAO;
import com.shukream.bids.vo.BidsVO;
import com.shukream.orders.dao.OrdersDAO;
import com.shukream.products.dao.ProductsDAO;
import com.shukream.products.vo.ProductsVO;
import com.shukream.products.vo.ProductsVOWithIMG;

@Service
public class ShopDetailsService {

  private static final Logger logger = LoggerFactory.getLogger(ShopDetailsService.class);

  @Autowired
  AsksDAO asksdao;
  
  @Autowired
  BidsDAO bidsdao;
  
  @Autowired
  ProductsDAO productsdao;
  
  @Autowired
  OrdersDAO orderdao;
  
  public int InsertAsks(AsksVO asksvo) {
    return asksdao.insertAsks(asksvo);
  }
  
  public int InsertBids(BidsVO bidsvo) {
    return bidsdao.insertBids(bidsvo);
  }
  public int SelectLowAsks() {
    return asksdao.selectLowAsks();
  }
  
  public Map selectLowAsksAll(int product_id) {
    
    Map result = new LinkedHashMap();
    for(int i = 220; i<=300;i=i+5) {
      HashMap<String, Object> map = new HashMap<String, Object>();
      map.put("product_id",product_id );
      map.put("size1", i);
      map.put("size2", i);
      result.put(i,asksdao.selectLowAsksAll(map));
    }
    return result;
  }
  
  public Map selectLowBidsAll(int product_id) {
    
    Map result = new LinkedHashMap();
    for(int i = 220; i<=300;i=i+5) {
      HashMap<String, Object> map = new HashMap<String, Object>();
      map.put("product_id",product_id );
      map.put("size1", i);
      map.put("size2", i);
      result.put(i,bidsdao.selectLowBidsAll(map));
    }
    return result;
  }

  public String SelectProduct(int product_id) {
    
    Map map = new HashMap();
    map.put("product_id", product_id);
    map.put("detail","detail");
    map.put("main","main");
    
    Map map2 = new HashMap();
    map2 = productsdao.selectProduct(map);
    String imgNameMain = (String) map2.get("IMG_FILE");
    return imgNameMain;
  }
  
  public String selectProductDetail(int product_id) {
    
    Map map = new HashMap();
    map.put("product_id", product_id);
    map.put("detail","detail");
    map.put("main","main");
    
    Map map2 = new HashMap();
    map2 = productsdao.selectProductDetail(map);
    String imgNameDetail =(String) map2.get("IMG_FILE");
    return imgNameDetail;
  }
  

  
  public ProductsVOWithIMG selectProductOne(int product_id) {
    return productsdao.selectProductOne(product_id);
  }

  public int SelectLowBids() {
    return bidsdao.selectLowBids();
  }
  
//  public int SelectLatestOrder(int product_id) {
//    Map map = new HashMap();
//    map.put("product_id1", product_id);
//    map.put("product_id2",product_id);
//    map.put("product_id3",product_id);
//    
//    
//    Map askMap=orderdao.SelectLatestOrderAsk(map);
//    Map bidMap=orderdao.SelectLatestOrderBid(map);
    
    
    
//    int latestMoney = Integer.parseInt(String.valueOf(map1.get("ASKS_PRICE")));
//    return latestMoney;
//  }
  public int SelectLatestMoney(int product_id){
    
    int latest = 0;
    
    Map map1 = new HashMap();
    map1.put("product_id1", product_id);
    map1.put("product_id2", product_id);
    
    Map result = orderdao.SelectLatestOrderAsk(map1);
    Map result2 = orderdao.SelectLatestOrderBid(map1);
    
    String askDate = (String) result.get("ASKS_REGDATE1");
    String bidDate = (String) result2.get("BIDS_REGDATE1");

    if (bidDate.equals("0") && askDate.equals("0")) {
      latest = 0;
    } else {
    if(askDate.equals("0")) {
      latest = Integer.parseInt(String.valueOf(result2.get("BIDS_PRICE")));
    } else if( bidDate.equals("0")) {
      latest = Integer.parseInt(String.valueOf(result.get("ASKS_PRICE")));
    } /*else if (bidDate.equals("0") && askDate.equals("0")) {
      latest = 0;
    }*/ else {
      
      try {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date askDate1 = format.parse(askDate);
        Date bidDate1 = format.parse(bidDate);
        
        int result3 = askDate1.compareTo(bidDate1); //0 -> 동일한 날짜
                                                     //result<0   ->askdate가 더 빠르다!
                                                      //result>0   ->biddate가 더 빠르다!
        logger.info("\n result3 " + result3);
        if(result3==0) {
          latest = Integer.parseInt(String.valueOf(result.get("ASKS_PRICE")));
        } else if ( result3 <0) {
          latest = Integer.parseInt(String.valueOf(result2.get("BIDS_PRICE")));
        } else {
          latest = Integer.parseInt(String.valueOf(result.get("ASKS_PRICE")));
        }
        
        logger.info("\n latest " + latest);
        
        
        logger.info("\n selectLatestOrderAsk " + askDate);
        logger.info("\n SelectLatestOrderBid " + bidDate);
      } catch(ParseException e) {
        e.printStackTrace();
      }
    }
      
    }
    logger.info("\n latest " + latest);
    return latest;
  }
  
}
