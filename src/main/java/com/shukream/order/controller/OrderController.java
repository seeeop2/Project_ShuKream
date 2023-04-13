package com.shukream.order.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.shukream.order.service.OrderService;
import com.shukream.order.vo.OrderVO;

@Controller
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	OrderService orderService;
		
	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

	//체크아웃 페이지에서 주문을 눌렀을 때 이동하는곳(주문 완료페이지)
	@RequestMapping(value="/orderDetail.do", method = RequestMethod.POST)
	public ModelAndView orderDetail(
									@ModelAttribute("orderVO") OrderVO vo,
									HttpServletRequest request) {
		
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		
		System.out.println(vo.toString());
		orderService.checkOut(vo);
		
		
		mav.addObject("order",vo);
		
		return mav;
		
	}
}
