package com.shukream.favorites.controller;

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

@Controller("favoritesController")
@RequestMapping(value = "/favorites")
public class FavoritesController {

	@Autowired
	private FavoritesService favoritesService;
	@Autowired
	private FavoritesVO favoritesVO;
	@Autowired
	private LikeVO likeVO;

	private static final Logger logger = LoggerFactory.getLogger(FavoritesController.class);

	@RequestMapping(value = "/favoritesList.do", method = RequestMethod.GET)
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ModelAndView mav = new ModelAndView();

		HttpSession session = request.getSession();
		String viewName = (String) request.getAttribute("viewName");
		logger.info(viewName);
//		HttpSession session=request.getSession();
//		LikeVO likeVO =(LikeVO)session.getAttribute("id");	
//		String like_mem_id = likeVO.getLike_mem_id();

		String like_mem_id = "admin";

		likeVO.setLike_mem_id(like_mem_id);

		Map<String, List> likeMap = favoritesService.myLikeList(likeVO);

		mav.setViewName(viewName);

		session.setAttribute("likeMap", likeMap);

		return mav;
	}

	@RequestMapping(value = "/favoritesDel.do", method = RequestMethod.GET)
	public ModelAndView removeCartGoods(@RequestParam("like_idx") int like_idx, HttpServletRequest request,
										HttpServletResponse response) throws Exception {
//		HttpSession session=request.getSession();
//		LikeVO likeVO =(LikeVO)session.getAttribute("id");	
//		String like_mem_id = likeVO.getLike_mem_id();

		String like_mem_id = "admin";
		
		ModelAndView mav = new ModelAndView();
		
		likeVO.setLike_mem_id(like_mem_id);
		
		likeVO.setLike_idx(like_idx);
		
		favoritesService.removeLikeList(likeVO);
		mav.setViewName("redirect:/favorites/favoritesList.do");
		return mav;
	}
	 
	 
	 
	 
	 
}
