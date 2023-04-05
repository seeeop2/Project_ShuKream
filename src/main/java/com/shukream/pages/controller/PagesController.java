package com.shukream.pages.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value ="/pages")
public class PagesController {

  private static final Logger logger = LoggerFactory.getLogger(PagesController.class);

  @RequestMapping(value = "/about.do", method = RequestMethod.GET)
  public ModelAndView about(HttpServletRequest request, HttpServletResponse response) {

    ModelAndView mav = new ModelAndView();
    
    String viewName = (String) request.getAttribute("viewName");
    logger.info(viewName);
    
    mav.setViewName(viewName);

    return mav;
  }


  @RequestMapping(value = "/shoppingCart.do", method = RequestMethod.GET)
  public ModelAndView shoppingCart(HttpServletRequest request, HttpServletResponse response) {

    ModelAndView mav = new ModelAndView();
    
    String viewName = (String) request.getAttribute("viewName");
    logger.info(viewName);
    
    mav.setViewName(viewName);

    return mav;
  }
  
  @RequestMapping(value = "/blogDetails.do", method = RequestMethod.GET)
  public ModelAndView blogDetails(HttpServletRequest request, HttpServletResponse response) {

    ModelAndView mav = new ModelAndView();
    
    String viewName = (String) request.getAttribute("viewName");
    logger.info(viewName);
    
    mav.setViewName(viewName);

    return mav;
  }
  
  @RequestMapping(value = "/checkOut.do", method = RequestMethod.GET)
  public ModelAndView checkOut(HttpServletRequest request, HttpServletResponse response) {

    ModelAndView mav = new ModelAndView();
    
    String viewName = (String) request.getAttribute("viewName");
    logger.info(viewName);
    
    mav.setViewName(viewName);

    return mav;
  }
  
  
  
  
  
}
