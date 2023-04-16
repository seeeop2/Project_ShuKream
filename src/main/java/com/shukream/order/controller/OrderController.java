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
									@RequestParam(value="product_id", required = false) String product_id,
									@RequestParam(value="ABprice", required = false) String abPrice,
									@RequestParam(value="size", required = false) String size,
									@RequestParam("type") String type,
									@RequestParam("option") String option,
									@ModelAttribute("orderVO") OrderVO vo,
									HttpServletRequest request) {
		
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		Map<String, Object> product = null;
		int shipIdx = 0;
		int orderIdx = 0;
		
		if(type.equals("buy")) {
			if(asks_idx == null || bids_idx == null) { //판매입찰테이플에 아이템이 없는 경우
				product = orderService.selectProduct(Integer.parseInt(product_id));
				if(abPrice != null && !abPrice.equals("")) {
					product.replace("PRODUCT_PRICE", abPrice);
				}
				paramMap.put("product_id", product.get("PRODUCT_ID"));
				paramMap.put("product_price", product.get("PRODUCT_PRICE"));
				paramMap.put("size", Integer.parseInt(size));
				orderService.insertNewBids(paramMap);
				
			} else {
			paramMap.put("asks_idx", asks_idx);
			//select하고 마지막에 insert된 행의 idx구하기
			int newBidsIdx = orderService.insertNewBids(paramMap); //새로운 구매 입찰 생성(즉시구매, 구매입찰 둘다 입찰이 생겨야함)
			paramMap.put("newBidsIdx", newBidsIdx);
			
			//option 00 -> 구매입찰 
		    //option 10 -> 즉시구매
			if(option.equals("10")) {
				//배송정보를 만들고
				shipIdx = orderService.insertShipInfo(vo);
				//orders테이블에 추가해야함
				//bids,asks_idx들을 받아서 넘겨줘야함.
				orderIdx = orderService.insertOrders(paramMap);
				//주문이 체결되면 asks_order_state_idx랑 asks_order_number를 업데이트 해줘야한다. 근데 order_number 업데이트??
				paramMap.put("shipIdx", shipIdx);
				paramMap.put("orderIdx",String.valueOf(orderIdx));
				orderService.updateAsks(paramMap);
				orderService.updateBids(paramMap);
			}
		}
			
		//판매로 들어온 경우
		} else { 
			if(bids_idx == null || asks_idx == null) {
				product = orderService.selectProduct(Integer.parseInt(product_id));
				if(abPrice != null && !abPrice.equals("")) {
					product.put("PRODUCT_PRICE", abPrice);
				}
				paramMap.put("product_id", product.get("PRODUCT_ID"));
				paramMap.put("product_price", product.get("PRODUCT_PRICE"));
				paramMap.put("size", size);
				orderService.insertNewAsks(paramMap);
				
			} else { 
			System.out.println("bids_idx???"+bids_idx);
			paramMap.put("bids_idx", bids_idx);
			int newAsksIdx = orderService.insertNewAsks(paramMap); //새로운 판매 입찰 생성(즉시구매, 판매입찰 둘다 입찰이 생겨야함)
			paramMap.put("newAsksIdx", newAsksIdx);
			System.out.println("newAsksIdx???" + newAsksIdx);
			//option 00 -> 판매입찰 
		    //option 10 -> 즉시판매
			if(option.equals("10")) {
				//배송정보를 만들고
				shipIdx = orderService.insertShipInfo(vo);
				//orders테이블에 추가해야함
				//bids,asks_idx들을 받아서 넘겨줘야함.
				orderIdx = orderService.insertOrders(paramMap);
				//주문이 체결되면 asks_order_state_idx랑 asks_order_number를 업데이트 해줘야한다. 근데 order_number 업데이트??
				paramMap.put("shipIdx", shipIdx);
				paramMap.put("orderIdx",String.valueOf(orderIdx));
				orderService.updateAsks(paramMap);
				orderService.updateBids(paramMap);
			}
			}
		}
		//주문상세 페이지 삭제예정? 주문 완료시 마이페이지로 이동하기?
		
		mav.addObject("order",vo);
		
		return mav;
		
	}
	
	@RequestMapping(value="/checkout.do")
	public ModelAndView buy (
							@RequestParam(value = "asks_idx",required = false) String asks_idx,
							@RequestParam(value = "bids_idx",required = false) String bids_idx,
							@RequestParam(value = "product_id",required = false) String product_idx,
							@RequestParam(value = "type",required = false) String type,
							@RequestParam(value = "size", required = false) String size,
							HttpServletRequest request) {
		
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		Map<String, Object> buyAsks = null;
		Map<String, Object> sellBids = null;
		Map<String, Object> product = null;
		System.out.println(viewName);
		
//		type = "sell"; //지금은 임의로 buy를 줬지만, 이전페이지에서 type=? 으로 넘어올예정
		
		if(type.equals("buy")) {
			if(asks_idx == null) {
				//asks_idx 즉 입찰로 구매해야 하는 상품의 경우 product만 조회 해서 다음페이지로 넘어갈것
				product = orderService.selectProduct(Integer.parseInt(product_idx));
			} else {
			buyAsks = orderService.selectAsks(asks_idx);
			System.out.println(buyAsks);
			int product_id = Integer.parseInt(buyAsks.get("ASKS_PRODUCT_ID").toString());
			product = orderService.selectProduct(product_id);
			}
			
		} else { //판매의 경우
			if(bids_idx == null) {
				//asks_idx 즉 입찰로 구매해야 하는 상품의 경우 product만 조회 해서 다음페이지로 넘어갈것
				product = orderService.selectProduct(Integer.parseInt(product_idx));
			} else { //구매 입찰에 걸려있는 상품으로 판매버튼을 눌러 넘어온경우
			sellBids = orderService.selectBids(bids_idx);
			System.out.println(sellBids);
			int product_id = Integer.parseInt(sellBids.get("BIDS_PRODUCT_ID").toString());
			product = orderService.selectProduct(product_id);
			}
		}
		
		//가격정보를 위해 담는것
		mav.addObject("buyAsks",buyAsks);
		mav.addObject("sellBids",sellBids);
		//YOUR ORDER에 데이터 뿌려주기 위해 담는것
		mav.addObject("product",product);
		mav.addObject("type",type);
		mav.addObject("size",size);
		
		return mav;
		
	}
}
