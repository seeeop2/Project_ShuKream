package com.shukream.home;

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
import org.springframework.web.servlet.ModelAndView;

import com.shukream.home.service.HomeService;
import com.shukream.products.vo.ImageFileVO;

@Controller
public class MainController {
	
	@Autowired
	HomeService homeService;

  private static final Logger logger = LoggerFactory.getLogger(MainController.class);

  @RequestMapping(value = "/main.do", method = RequestMethod.GET)
  public ModelAndView main(HttpServletRequest request, HttpServletResponse response) {

    ModelAndView mav = new ModelAndView();
    
    String viewName = (String) request.getAttribute("viewName");
    
    Map<String, List<ImageFileVO>> mainProductMap = homeService.selectMainProductsList();
    
    logger.info(viewName);
    
    mav.addObject("mainProductMap",mainProductMap);
    mav.setViewName(viewName);

    return mav;
  }

}
