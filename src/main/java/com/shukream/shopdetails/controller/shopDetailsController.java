package com.shukream.shopdetails.controller;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.shukream.products.vo.ProductsVO;
import com.shukream.shopdetails.service.ShopDetailsService;

@Controller
@RequestMapping(value = "/shop")
public class shopDetailsController {
  
  @Autowired
  private ShopDetailsService shopDetailsService;

  private static final Logger logger = LoggerFactory.getLogger(shopDetailsController.class);

  
  @RequestMapping(value = "/shopDetails.do", method = RequestMethod.GET)
  public String ShopDetailsMain(HttpServletRequest request, 
                                HttpServletResponse response, 
                                Model model,
                                @RequestParam(value = "product_id", required = false) int product_id) {

    //model로 변경
    String viewName = (String) request.getAttribute("viewName");
    logger.info(viewName);
//    model.addAttribute("lowAsks", shopDetailsService.SelectLowAsks());
    List productvoList = shopDetailsService.SelectProduct(product_id);
    model.addAttribute("productvoList", productvoList);
    Map map =shopDetailsService.selectLowAsksAll();
    model.addAttribute("theLowestAsks",map);
    return viewName;
    
  }
  

}
