package com.shukream.teamproject;

import java.util.ArrayList;
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
import com.shukream.member.dao.MemberDAO;
import com.shukream.member.vo.MemberVO;
import com.shukream.products.dao.ProductsDAO;
import com.shukream.products.vo.ProductsVO;
import com.shukream.products.vo.ProductsVOWithIMG;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
    "file:src/main/webapp/WEB-INF/spring/*-context.xml",
    "file:src/main/webapp/WEB-INF/spring/appServlet/*-context.xml"
})

@WebAppConfiguration
public class DAOTest2 {

  private static final Logger logger = LoggerFactory.getLogger(DAOTest2.class);

  @Autowired
  private MemberDAO memberdao;
  
  

//=======================product 목록 다 가져오기=================================
//  @Test 
//  public void testemailCheck() throws Exception{
//    
//	 Map email = new HashMap();
//	 email.put("user_email1", "sdsf@naver.com");
//	 email.put("user_email2", "sdsf@naver.com");
//	 Map email2 = memberdao.emailCheck(email);
//	 
//	 logger.info("\n\n----Products List---- " + email2);
//
//  }


}