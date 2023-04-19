package com.shukream.admin.controller;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shukream.admin.service.AdminService;
import com.shukream.asks.vo.AsksVO;
import com.shukream.bids.vo.BidsVO;

@Controller("adminController")
@RequestMapping(value = "/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	@Autowired
	private AsksVO asksVO;
	@Autowired
	private BidsVO bidsVO;
	
	
	
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

	@RequestMapping(value = "/admin.do", method = RequestMethod.GET)
	public ModelAndView list( HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();		
		ModelAndView mav = new ModelAndView();

		String viewName = (String) request.getAttribute("viewName");
		logger.info(viewName);
		
	
		List<AsksVO> asksVO = adminService.asksList();
		List<BidsVO> bidsVO = adminService.bidsList();

		System.out.println("asksVO:"+asksVO);
		System.out.println("bidsVO:"+bidsVO);
		
	    mav.setViewName(viewName);
		session.setAttribute("asksVO", asksVO);
		session.setAttribute("bidsVO", bidsVO);
		return mav;
	
		}
	
	@RequestMapping(value = "/asksOrderChange.do", method = RequestMethod.POST)
	public ModelAndView asksOrderChange(@RequestParam("ASKS_ORDER_NUMBER") String asks_order_number,   
			 							@RequestParam("ASKS_ORDER_STATE_IDX") int asks_order_state_idx,   
										HttpServletRequest request, 
										HttpServletResponse response) throws Exception {
		
		String viewName = (String) request.getAttribute("viewName");
		logger.info(viewName);
		
		int result = adminService.asksOrderChange(asks_order_number, asks_order_state_idx);
		
		PrintWriter out = response.getWriter();
		
		out.print(result);
		
		return null;
		
	}
	
	@RequestMapping(value = "/bidsOrderChange.do", method = RequestMethod.POST)
	public ModelAndView bidsOrderChange(@RequestParam("BIDS_ORDER_NUMBER") String bids_order_number,   
										@RequestParam("BIDS_ORDER_STATE_IDX") int bids_order_state_idx,   
										HttpServletRequest request, 
										HttpServletResponse response) throws Exception {
		System.out.println("bidsOrderChange시작");
		
		String viewName = (String) request.getAttribute("viewName");
		logger.info(viewName);

		System.out.println("bids_order_number:"+bids_order_number);
		System.out.println("bids_order_state_idx:"+bids_order_state_idx);
		
		int result = adminService.bidsOrderChange(bids_order_number, bids_order_state_idx);
		System.out.println("result:"+result);
		
		PrintWriter out = response.getWriter();
		
		out.print(result);
		
		return null;
		
	}
	
	
	}
	
	
