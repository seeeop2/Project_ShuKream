package com.shukream.order.controller;

import java.util.HashMap;
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
									@RequestParam(value="asks_idx", required = false) String asks_idx,
									@RequestParam(value="bids_idx", required = false) String bids_idx,
									@RequestParam("type") String type,
									@RequestParam("option") int option,
									@ModelAttribute("orderVO") OrderVO vo,
									HttpServletRequest request) {
		
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		
		System.out.println(vo.toString());
		System.out.println("type은?"+type);
		
		if(type.equals("buy")) {
		
			paramMap.put("asks_idx", asks_idx);
			orderService.insertNewBids(paramMap); //새로운 구매 입찰 생성(즉시구매, 구매입찰 둘다 입찰이 생겨야함)
			//option 00 -> 구매입찰 
		    //option 10 -> 즉시구매
			if(option == 10) {
//				orderService.insertShipInfo(vo);
			}
		}
		
//		orderService.checkOut(vo);
		
		//주문상세 페이지 삭제예정? 주문 완료시 마이페이지로 이동하기?
		
		mav.addObject("order",vo);
		
		return mav;
		
	}
	
	@RequestMapping(value="/checkout.do")
	public ModelAndView buy (
							@RequestParam(value = "asks_idx",required = false) String asks_idx,
							@RequestParam(value = "bids_idx",required = false) String bids_idx,
							@RequestParam(value = "type",required = false) String type,
//							@RequestParam("size") String size, 추후 확인
							HttpServletRequest request) {
		
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		System.out.println(viewName);
		
		type = "buy";
		
		
		Map<String, Object> buyAsks = orderService.selectAsks(asks_idx);
		System.out.println(buyAsks);
		int product_id = Integer.parseInt(buyAsks.get("ASKS_PRODUCT_ID").toString());
		System.out.println(product_id);
		Map<String, Object> product = orderService.selectProduct(product_id);
		
		//가격정보를 위해 담는것
		mav.addObject("buyAsks",buyAsks);
		//YOUR ORDER에 데이터 뿌려주기 위해 담는것
		mav.addObject("product",product);
		mav.addObject("type",type);
		
		return mav;
		
	}
}
