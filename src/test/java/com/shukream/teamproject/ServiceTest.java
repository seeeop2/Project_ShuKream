package com.shukream.teamproject;

import java.util.HashMap;
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
import com.shukream.order.service.OrderService;
import com.shukream.shopdetails.service.ShopDetailsService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
    "file:src/main/webapp/WEB-INF/spring/*-context.xml",
    "file:src/main/webapp/WEB-INF/spring/appServlet/*-context.xml"
})

@WebAppConfiguration
public class ServiceTest {

  private static final Logger logger = LoggerFactory.getLogger(ServiceTest.class);

  @Autowired
  private ShopDetailsService shopdetailsService;
  
  @Autowired
  private OrderService orderService;

  @Test @Ignore
  public void SelectLatestMoney() throws Exception{
    
    int product_id = 39;
    int result = shopdetailsService.SelectLatestMoney(product_id);
    logger.info("\n result " + result);
  }
  
  @Test @Ignore
  public void selectLowAsksAll() throws Exception{
    
    int product_id = 43;
    Map result = shopdetailsService.selectLowAsksAll(product_id);
    
    logger.info("\n result " + result);
  }
  @Test @Ignore
  public void selectLowBidsAll() throws Exception{
    
    int product_id = 43;
    Map result = shopdetailsService.selectHighBidsAll(product_id);
    
    logger.info("\n result " + result);
  }
  
  @Test 
  public void selectBidByIdWithSize() throws Exception{
    Map map = new HashMap();
    String product_id = "43";
    String product_size_idx = "220";

    String me = orderService.selectBidByIdWithSize(product_id,product_size_idx);

    logger.info("\n selectLatestOrderBId " + me);
  }
  
  
}