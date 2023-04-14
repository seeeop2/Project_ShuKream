package com.shukream.teamproject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.shukream.asks.dao.AsksDAO;
import com.shukream.asks.vo.AsksVO;
import com.shukream.bids.dao.BidsDAO;
import com.shukream.bids.vo.BidsVO;
import com.shukream.orders.dao.OrdersDAO;
import com.shukream.products.dao.ProductsDAO;
import com.shukream.products.vo.ProductsVO;
import com.shukream.products.vo.ProductsVOWithIMG;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
    "file:src/main/webapp/WEB-INF/spring/*-context.xml",
    "file:src/main/webapp/WEB-INF/spring/appServlet/*-context.xml"
})

@WebAppConfiguration
public class DAOTest {

  private static final Logger logger = LoggerFactory.getLogger(DAOTest.class);

  @Autowired
  private ProductsDAO productsDAO;
  
  @Autowired
  private AsksDAO asksDAO;
  
  @Autowired 
  private BidsDAO bidsDAO;
  
  @Autowired
  private OrdersDAO ordersDAO;
  
  int random1to5 = (int) (Math.random()*4) + 1;
  

//=======================product 목록 다 가져오기=================================
  @Test @Ignore
  public void testGetProductsList() throws Exception{
    
    List<ProductsVO> productsList = productsDAO.getProductsList();
    
    logger.info("\n\n----Products List---- ");
    
    
    if(productsList.size() > 0 ) {
      for(ProductsVO list : productsList) {
        logger.info(list.getProduct_name_en());
      } 
    }else {
        logger.info("데이터가 없습니다.");
    }
  }
//=======================product 목록에 추가하기=================================
  @Test @Ignore
  public void testaddProduct() throws Exception{
    
    ProductsVO productsvo = new ProductsVO();
    
    productsvo.setModel_number("DN3707-100");
    productsvo.setProduct_brand("Jordan");
    productsvo.setProduct_color("SUMMIT WHITE/FIRE RED/BLACK/CEMENT GREY");
    productsvo.setProduct_name_en("Jordan 3 Retro White Cement Reimagined");
    productsvo.setProduct_name_kor("조던 3 레트로 화이트 시멘트 리이매진드");
    productsvo.setProduct_price(259000);
    
    Calendar cal = Calendar.getInstance();
    cal.setTime(new Date());
    
    productsvo.setProduct_release_date(cal.getTime());
    
    int result = productsDAO.addProduct(productsvo);
    logger.info("\n Insert Product Result " +result);
  }
//=======================ASKS 목록에 다중 업로드 =================================
  @Test  @Ignore
  public void testInsertAsksAlot() throws Exception{
    
    //A상품
    AsksVO asksvo = new AsksVO();
    
    for(int j = 1; j <=50 ; j++ ) { //product_id
      asksvo.setAsks_product_id(j);
    
      for(int m = 220 ; m<=280 ; m= m+5) {  //size
        asksvo.setAsks_size_idx(m);
      
        for(int i = 0 ; i <1; i++) {
          int price = 100000;
          
          if(price==0) {
            return;
          }
        
          int random1to3 = (int) (Math.random()*3) + 1;
          
          if(random1to3 == 1) {
            price = doForPlus(price,asksvo);
          } else if(random1to3 == 2) {
            price = doForStay(price,asksvo);
          } else {
            price = doForMinus(price,asksvo);
          }
        }
      }
    }

  }
//=======================BIDS 목록에 다중 추가하기 =================================
  @Test @Ignore
  public void testInsertBids() throws Exception{
    
    //A상품
    BidsVO bidsvo = new BidsVO();
    
    for(int j = 1; j <=50 ; j++ ) { //product_id
      bidsvo.setBids_product_id(j);
    
      for(int m = 220 ; m<=280 ; m= m+5) {  //size
        bidsvo.setBids_size_idx(m);
      
        for(int i = 0 ; i <1; i++) {
          int price = 100000;
          
          if(price==0) {
            return;
          }
        
          int random1to3 = (int) (Math.random()*3) + 1;
          
          if(random1to3 == 1) {
            price = doForPlus_(price,bidsvo);
          } else if(random1to3 == 2) {
            price = doForStay_(price,bidsvo);
          } else {
            price = doForMinus_(price,bidsvo);
          }
        }
      }
    }
  }
//=======================ASKS 목록에서 낮은 가격 구하기 =================================
  @Test@Ignore
  public void testSelectLowAsksAll() throws Exception{
    
    int product_id= 43;
    LinkedHashMap result1 = new LinkedHashMap();
    for(int i = 220; i<=300;i=i+5) {
      HashMap<String, Object> map = new HashMap<String, Object>();
      map.put("product_id",product_id);
      map.put("size1", i);
      map.put("size2", i);
      int result2 = asksDAO.selectLowAsksAll(map);
      result1.put(i,result2);
    }
    
    logger.info("\n Select Result :" + result1);
  }
//=======================Bids 목록에서 가장 높은 가격 구하기 =================================
  @Test 
  public void selectLowBidsAll() throws Exception{
    
    int product_id= 43;
    LinkedHashMap result1 = new LinkedHashMap();
    for(int i = 220; i<=300;i=i+5) {
      HashMap<String, Object> map = new HashMap<String, Object>();
      map.put("product_id",product_id);
      map.put("size1", i);
      map.put("size2", i);
      int result2 = bidsDAO.selectHighBidsAll(map);
      result1.put(i,result2);
    }
    
    logger.info("\n Select Result :" + result1);
  }
//=======================shopdetails에 사진 가져오기 위함 =================================
  @Test @Ignore
  public void testSelectProduct() throws Exception{
    
    Map map = new HashMap();
    map.put("product_id", 24);
    map.put("detail","detail");
    map.put("main","main");
    
    Map result = productsDAO.selectProduct(map);
    logger.info("\n Insert Bids Result " +result);
    logger.info("\n Insert Bids Result " +result.get("PRODUCT_COLOR"));
    
  }
//=============shopdetails에 사진 가져오기 위함(vo한줄 가져온다.) ======================
  @Test @Ignore
  public void selectProductOne() throws Exception{
    int product_id = 43;
    ProductsVOWithIMG result = productsDAO.selectProductOne(product_id);
    logger.info("\n Insert Bids Result " + result);
    
  }
//=============asks'최근 거래 내역 조회 ======================

  @Test @Ignore
  public void testSelectLatestOrder() throws Exception{
    Map map1 = new HashMap();
    map1.put("product_id1", 43);
    map1.put("product_id2", 43);
    map1.put("product_id3", 43);
    
    Map result = asksDAO.SelectLatestOrder(map1);
    logger.info("\n testSelectLatestOrder " + result);
    
  }
//=====================================
  @Test @Ignore
  public void selectLatestOrderAsk() throws Exception{
    
    int latest = 0;
    
    Map map1 = new HashMap();
    map1.put("product_id1", 39);
    map1.put("product_id2", 39);
    
    Map result = ordersDAO.SelectLatestOrderAsk(map1);
    Map result2 = ordersDAO.SelectLatestOrderBid(map1);
    
    String askDate = (String) result.get("ASKS_REGDATE1");
    String bidDate = (String) result2.get("BIDS_REGDATE1");
    
    
    logger.info("\n result " + result);
    logger.info("\n result2 " + result2);
    logger.info("\n askDate " + askDate);
    logger.info("\n bidDate " + bidDate);
//  int latestMoney = Integer.parseInt(String.valueOf(map1.get("ASKS_PRICE")));

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
  }

  @Test @Ignore
  public void selectLatestOrderBId() throws Exception{
    
    Map map1 = new HashMap();
    map1.put("product_id1", 45);
    map1.put("product_id2", 45);
    map1.put("product_id3", 45);
    

    
    Map result = ordersDAO.SelectLatestOrderBid(map1);
    
    logger.info("\n selectLatestOrderBId " + result);
  }
  
  
  
  
  
  
  

//=====================For ASKS=================
  public int doForPlus(int price,AsksVO asksvo) {
    int add_price = 1000;

    for(int j=0;j<random1to5;j++) {
      price = price + add_price;
      asksvo.setAsks_price(price);
      int result = asksDAO.insertAsks(asksvo);
      logger.info("\n Insert Board Result " +result);
    }
    return price;
  }
  
  public int doForStay(int price,AsksVO asksvo) {
    int random = (int) (Math.random()*3) + 1;
    
    for(int j=0;j<random;j++) {
      asksvo.setAsks_price(price);
      int result = asksDAO.insertAsks(asksvo);
      logger.info("\n Insert Board Result " +result);
    }
    return price;
  }
  
  public int doForMinus(int price,AsksVO asksvo) {
    int minus_price = 1000;
    for(int j=0;j<random1to5;j++) {
      price = price - minus_price;
      asksvo.setAsks_price(price);
      int result = asksDAO.insertAsks(asksvo);
      logger.info("\n Insert Board Result " +result);
    }
    return price;
  }
//=====================For ASKS=================
//=====================For BIDS=================
  public int doForPlus_(int price,BidsVO bidsvo) {
    int add_price = 1000;

    for(int j=0;j<random1to5;j++) {
      price = price + add_price;
      bidsvo.setBids_price(price);
      int result = bidsDAO.insertBids(bidsvo);
      logger.info("\n Insert Board Result " +result);
    }
    return price;
  }
  
  public int doForStay_(int price,BidsVO bidsvo) {
    int random = (int) (Math.random()*3) + 1;
    
    for(int j=0;j<random;j++) {
      bidsvo.setBids_price(price);
      int result = bidsDAO.insertBids(bidsvo);
      logger.info("\n Insert Board Result " +result);
    }
    return price;
  }
  
  public int doForMinus_(int price,BidsVO bidsvo) {
    int minus_price = 1000;
    for(int j=0;j<random1to5;j++) {
      price = price - minus_price;
      bidsvo.setBids_price(price);
      int result = bidsDAO.insertBids(bidsvo);
      logger.info("\n Insert Board Result " +result);
    }
    return price;
  }
//=====================For BIDS=================

}