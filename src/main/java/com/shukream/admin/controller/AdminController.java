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

import com.shukream.favorites.service.FavoritesService;
import com.shukream.favorites.vo.FavoritesVO;
import com.shukream.favorites.vo.LikeVO;
import com.shukream.shop.vo.Pagination;

@Controller("adminController")
@RequestMapping(value = "/admin")
public class AdminController {

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

	@RequestMapping(value = "/admin.do", method = RequestMethod.GET)
	public ModelAndView list( HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("1");
		
		ModelAndView mav = new ModelAndView();

		String viewName = (String) request.getAttribute("viewName");
		logger.info(viewName);

	    mav.setViewName(viewName);
		
		return mav;
	
		}
	


	
	}
	
	
