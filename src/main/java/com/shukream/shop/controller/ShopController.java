package com.shukream.shop.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shukream.shop.service.ShopService;
import com.shukream.shop.vo.Pagination;

@Controller
@RequestMapping(value = "/shop")
public class ShopController {
	
	@Autowired
	ShopService shopService;

  private static final Logger logger = LoggerFactory.getLogger(ShopController.class);

  @RequestMapping(value = "/list.do", method = RequestMethod.GET)
  public ModelAndView list(
		  				@RequestParam(name="opt", required = false) String opt,
		  				@RequestParam(name="division", required = false) String division,
		  				@RequestParam(name="page", defaultValue = "1") int page,
		  				@RequestParam(name="size", defaultValue = "6") int size,
		  				HttpServletRequest request, HttpServletResponse response) {

    ModelAndView mav = new ModelAndView();
    
    List<Map<String, Object>> productList = shopService.shopMainProductsList(page,size,opt,division);
    	
    
    int totalCount = shopService.shopMainProductCount(opt,division);
    Pagination pagination = new Pagination(page, size, totalCount);
    
    
    String viewName = (String) request.getAttribute("viewName");
    logger.info(viewName);
    
    mav.addObject("products",productList);
    mav.addObject("pagination", pagination);
    mav.addObject("totalCount",totalCount);
    mav.addObject("opt",opt);
    mav.addObject("division",division);
    mav.setViewName(viewName);

    return mav;
  }
  

}
