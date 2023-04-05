package com.shukream.event.controller;


import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

// 컨트롤러로 사용하기 위한 Bean 생성
// 1차 주소 : http://localhost:8090/teamproject/event/*.do
@Controller
@RequestMapping(value = "/event")
public class EventController {

 // log4j 객체 생성
  private static final Logger logger = LoggerFactory.getLogger(EventController.class);
  
  // #1 ) 2차 주소 : http://localhost:8090/teamproject/event/main.do
  // 가져오는 방식 : GET 방식으로 적용 
  @RequestMapping(value = "/main.do", method = RequestMethod.GET)
  public ModelAndView main(HttpServletRequest request, HttpServletResponse response) {
	  
	  
	// ModelANdView 객체 생성
    ModelAndView mav = new ModelAndView();
    
    // Viewname 가져오기
    String viewName = (String) request.getAttribute("viewName");
    
    // Viewname에 대한 info 생성
    logger.info(viewName);
    
    // ModelAndView 객체에 viewName을 셋팅
    mav.setViewName(viewName);

    // ModelAndView 반환
    return mav;
  }
  
  // #2 ) 2차 주소 : http://localhost:8090/teamproject/event/detail.do
  // 가져오는 방식 : GET 방식으로 적용 
  @RequestMapping(value = "/detail.do", method = RequestMethod.GET)
  public ModelAndView detail(HttpServletRequest request, HttpServletResponse response) {
	  
	  
	// ModelANdView 객체 생성
    ModelAndView mav = new ModelAndView();
    
    // Viewname 가져오기
    String viewName = (String) request.getAttribute("viewName");
    
    // Viewname에 대한 info 생성
    logger.info(viewName);
    
    // ModelAndView 객체에 viewName을 셋팅
    mav.setViewName(viewName);

    // ModelAndView 반환
    return mav;
  }
  
  // #3 ) 2차 주소 : http://localhost:8090/teamproject/event/detailresult.do
  // 가져오는 방식 : GET 방식으로 적용 
  @RequestMapping(value = "/detailresult.do", method = RequestMethod.GET)
  public ModelAndView detailresult(HttpServletRequest request, HttpServletResponse response) {
	  
	  
	// ModelANdView 객체 생성
    ModelAndView mav = new ModelAndView();
    
    // Viewname 가져오기
    String viewName = (String) request.getAttribute("viewName");
    
    // Viewname에 대한 info 생성
    logger.info(viewName);
    
    // ModelAndView 객체에 viewName을 셋팅
    mav.setViewName(viewName);

    // ModelAndView 반환
    return mav;
  }
  
  

}
