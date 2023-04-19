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
	


	
	}
	
	
