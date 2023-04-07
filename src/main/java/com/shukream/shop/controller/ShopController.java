package com.shukream.shop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.shukream.shop.service.ShopService;
import com.shukream.shop.vo.ProductsVO;

@Controller
@RequestMapping(value = "/shop")
public class ShopController {
	
	@Autowired
	ShopService shopService;

  private static final Logger logger = LoggerFactory.getLogger(ShopController.class);

  @RequestMapping(value = "/list.do", method = RequestMethod.GET)
  public ModelAndView list(HttpServletRequest request, HttpServletResponse response) {

    ModelAndView mav = new ModelAndView();
    
    List<ProductsVO> productsList = shopService.shopMainProductsList();
    
    String viewName = (String) request.getAttribute("viewName");
    logger.info(viewName);
    
    mav.addObject("productsList",productsList);
    mav.setViewName(viewName);

    return mav;
  }

}
