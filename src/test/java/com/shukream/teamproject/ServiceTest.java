package com.shukream.teamproject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
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

  @Test
  public void testSelectLowAsks() throws Exception{
    
    int result = shopdetailsService.SelectLowAsks();
    logger.info("\n SelectLowAsks Result : " +result);
  }

  
}