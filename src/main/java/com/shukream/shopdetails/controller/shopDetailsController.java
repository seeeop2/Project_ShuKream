package com.shukream.shopdetails.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.shukream.shopdetails.service.ShopDetailsService;

@Controller
@RequestMapping(value = "/shop")
public class shopDetailsController {
  
  @Autowired
  private ShopDetailsService shopDetailsService;

  private static final Logger logger = LoggerFactory.getLogger(shopDetailsController.class);

  
  @RequestMapping(value = "/shopDetails.do", method = RequestMethod.GET)
  public String ShopDetailsMain(HttpServletRequest request, HttpServletResponse response,Model model) {

//    ModelAndView mav = new ModelAndView();
//    
//    String viewName = (String) request.getAttribute("viewName");
//    logger.info(viewName);
//    
//    mav.setViewName(viewName);
//
//    return mav;
    
    //model로 변경
    String viewName = (String) request.getAttribute("viewName");
    logger.info(viewName);
    
    model.addAttribute("lowAsks", shopDetailsService.SelectLowAsks());

    return viewName;
    
  }
  

}
