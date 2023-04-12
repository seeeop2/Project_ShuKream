package com.shukream.shopdetails.service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shukream.asks.dao.AsksDAO;
import com.shukream.asks.vo.AsksVO;
import com.shukream.bids.dao.BidsDAO;
import com.shukream.bids.vo.BidsVO;
import com.shukream.products.dao.ProductsDAO;
import com.shukream.products.vo.ProductsVO;
import com.shukream.products.vo.ProductsVOWithIMG;

@Service
public class ShopDetailsService {

  @Autowired
  AsksDAO asksdao;
  
  @Autowired
  BidsDAO bidsdao;
  
  @Autowired
  ProductsDAO productsdao;
  
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
  
  public int SelectLatestOrder(int product_id) {
    Map map = new HashMap();
    map.put("product_id1", product_id);
    map.put("product_id2",product_id);
    
    Map map1=asksdao.SelectLatestOrder(map);
    int latestMoney = Integer.parseInt(String.valueOf(map1.get("ASKS_PRICE")));
    return latestMoney;
  }
}
