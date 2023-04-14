package com.shukream.order.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shukream.order.service.OrderService;
import com.shukream.order.vo.OrderVO;
import com.shukream.products.vo.ProductsVO;

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
		
//		HttpSession session =  request.getSession();
//		String type = (String) session.getAttribute("type");
		
		
		System.out.println(vo.toString());
		orderService.checkOut(vo);
		
		//주문상세 페이지 삭제예정? 주문 완료시 마이페이지로 이동하기?
		
		mav.addObject("order",vo);
		
		return mav;
		
	}
	
	@RequestMapping(value="/buy.do")
	public ModelAndView buy (
							@RequestParam(value = "asks_idx",required = false) String asks_idx,
//							@RequestParam("size") String size,
							HttpServletRequest request) {
		
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		System.out.println(viewName);
		
		String type = "buy";
		
		
		Map<String, Object> buyAsks = orderService.selectAsks(asks_idx);
		System.out.println(buyAsks);
		int product_id = Integer.parseInt(buyAsks.get("ASKS_PRODUCT_ID").toString());
		System.out.println(product_id);
		Map<String, Object> product = orderService.selectProduct(product_id);
		
		mav.addObject("buyAsks",buyAsks);
		mav.addObject("product",product);
		mav.addObject("type",type);
		
		return mav;
		
	}
}
