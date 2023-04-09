package com.shukream.teamproject;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.shukream.products.dao.ProductsDAO;
import com.shukream.products.vo.ProductsVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
    "file:src/main/webapp/WEB-INF/spring/*-context.xml",
    "file:src/main/webapp/WEB-INF/spring/appServlet/*-context.xml"
})

@WebAppConfiguration
public class ProductsDAOTest {

  private static final Logger logger = LoggerFactory.getLogger(ProductsDAOTest.class);

  @Autowired
  private ProductsDAO productsDAO;
  
  @Test
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
    
}
  
  
  
