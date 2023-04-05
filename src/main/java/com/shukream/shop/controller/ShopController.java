package com.shukream.shop.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/shop")
public class ShopController {

  private static final Logger logger = LoggerFactory.getLogger(ShopController.class);

  @RequestMapping(value = "/list.do", method = RequestMethod.GET)
  public ModelAndView list(HttpServletRequest request, HttpServletResponse response) {

    ModelAndView mav = new ModelAndView();
    
    String viewName = (String) request.getAttribute("viewName");
    logger.info(viewName);
    
    mav.setViewName(viewName);

    return mav;
  }

}
