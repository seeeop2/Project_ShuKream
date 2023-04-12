package com.shukream.teamproject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
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
import com.shukream.products.dao.ProductsDAO;
import com.shukream.products.vo.ProductsVO;

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
  private BidsDAO bisDAO;
  
  int random1to5 = (int) (Math.random()*4) + 1;
  

  
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
  
  @Test @Ignore
  public void testInsertAsksAlot() throws Exception{
    
    //A상품
    AsksVO asksvo = new AsksVO();
    asksvo.setAsks_size_idx(260);
    
    for(int i = 0 ; i <500; i++) {
      int price = 100000;
      
      if(price==0) {
        return;
      }
      
      int random1to3 = (int) (Math.random()*3) + 1;
      String random1to3String = Integer.toString(random1to3);
      logger.info(random1to3String);
      if(random1to3 == 1) {
        logger.info("plus");
        price = doForPlus(price,asksvo);
      } else if(random1to3 == 2) {
        logger.info("stay");
        price = doForStay(price,asksvo);
      } else {
        logger.info("minus");
        price = doForMinus(price,asksvo);
      }
    }
  }
  
  @Test @Ignore
  public void testInsertBids() throws Exception{
    
    BidsVO bidsVO = new BidsVO();
    
    bidsVO.setBids_size_idx(250);
    bidsVO.setBids_price(200000);
    
    Calendar cal = Calendar.getInstance();
    cal.setTime(new Date());
    
    bidsVO.setBids_regdate(cal.getTime());
    
    int result = bisDAO.insertBids(bidsVO);
    logger.info("\n Insert Bids Result " +result);
  }
  
  @Test
  public void testSelectLowAsksAll() throws Exception{
    
    List list = new ArrayList();
    list.add(250);
    list.add(260);
    
    
    List result = new ArrayList();
    Map map = new HashMap();
    map.put(250, asksDAO.selectLowAsksAll(250));
    map.put(260,asksDAO.selectLowAsksAll(260));
    logger.info("map :" + map);
    logger.info("map :" + map.get(250));
    result.add(asksDAO.selectLowAsksAll(250));
    result.add(asksDAO.selectLowAsksAll(260));
    logger.info("\n Insert Bids Result :" + result);
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
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
  
}