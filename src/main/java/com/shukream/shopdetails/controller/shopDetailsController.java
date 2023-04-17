package com.shukream.shopdetails.controller;

import java.util.Collections;
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
import com.shukream.products.vo.ProductsVOWithIMG;
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

    String imgNameMain = shopDetailsService.SelectProduct(product_id);
    String imgNameDetail = shopDetailsService.selectProductDetail(product_id);
    Map map =shopDetailsService.selectHighBidsAll(product_id);
    Map map2 = shopDetailsService.selectLowAsksAll(product_id);
    System.out.println("map = " + map);
    ProductsVOWithIMG productvo = shopDetailsService.selectProductOne(product_id);
    
    int latestMoney = shopDetailsService.SelectLatestMoney(product_id);
    
    model.addAttribute("lowAsks", shopDetailsService.SelectLowAsks());
    model.addAttribute("lowBids", shopDetailsService.SelectLowBids());
    model.addAttribute("product_id", product_id);
    model.addAttribute("productvo", productvo);
    model.addAttribute("imgNameMain", imgNameMain);
    model.addAttribute("imgNameDetail", imgNameDetail);
    model.addAttribute("theLowestAsks",map2);
    model.addAttribute("theHighestBids",map);
    model.addAttribute("latestMoney",latestMoney);
    return viewName;
  }
  
  @RequestMapping(value = "/getMoneyForModal.do", method = RequestMethod.GET)
  public void getMoneyForModal() {
    
    
    
  }

}
