package com.shukream.favorites.controller;

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
	public ModelAndView list(
								@RequestParam(name="page", defaultValue = "1") int page,
								@RequestParam(name="size", defaultValue = "5") int size,
								HttpServletRequest request, HttpServletResponse response) throws Exception {

		ModelAndView mav = new ModelAndView();

		String viewName = (String) request.getAttribute("viewName");
		logger.info(viewName);

		HttpSession session = request.getSession();
		String  email = (String)session.getAttribute("email");


	 	List<Map<String, Object>> likeMap = favoritesService.myLikeList(page,size,email);
	 	
	 	int totalCount = favoritesService.myLikeCount(email);
	    Pagination pagination = new Pagination(page, size, totalCount);
		
		mav.setViewName(viewName);
		
		mav.addObject("likeMap", likeMap);
	    mav.addObject("pagination", pagination);
	    mav.addObject("totalCount",totalCount);
	    mav.setViewName(viewName);
		
	    
		return mav;
	}

	@RequestMapping(value = "/favoritesDel.do", method = RequestMethod.GET)
	public ModelAndView removeCartGoods(@RequestParam("like_idx") int like_idx, HttpServletRequest request,
										HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		String  email = (String)session.getAttribute("email");
		
		ModelAndView mav = new ModelAndView();
		
		likeVO.setLike_mem_id(email);
		
		likeVO.setLike_idx(like_idx);
		
		System.out.println(email);
		System.out.println(like_idx);
		favoritesService.removeLikeList(likeVO);
		mav.setViewName("redirect:/favorites/favoritesList.do");
		return mav;
	}
	 
	@RequestMapping(value = "/favoritesLike.do", method = RequestMethod.POST)
	public ModelAndView likeProduct(@RequestParam("PRODUCT_ID") String product_id  ,
									@RequestParam("IMG_FILE") String img_file  ,
									@RequestParam("PRODUCT_NAME_EN") String product_name_en  ,
									@RequestParam("PRODUCT_NAME_KOR") String product_name_kor  ,
									@RequestParam("PRODUCT_PRICE") int product_price  ,
									HttpServletRequest request,
									HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		String  email = (String)session.getAttribute("email");
		
		int result1 = favoritesService.LikeCheck(product_id , email);
        
		PrintWriter out = response.getWriter();
        if (result1 == 1) {// 1이면 이미 테이블에 있다 == 이미 좋아요를 눌렀다.
            
        	
        	System.out.println("좋아요 삭제");
            favoritesService.deleteLike(product_id, email);
            //int result2 = boarddao.getOnlyLikeCount(b_idx2);
            result1 = 0; 
        out.print(result1);

        }else { // 테이블에 없다면?
    		LikeVO likeVO = new LikeVO();
    		likeVO.setLike_mem_id(email);
    		likeVO.setLike_product(product_id);
    		likeVO.setLike_img_file(img_file);
    		likeVO.setLike_product_name_en(product_name_en);
    		likeVO.setLike_product_name_kor(product_name_kor);
    		likeVO.setLike_product_price(product_price);
        	
        	int result2 = favoritesService.insertLike(likeVO);
            System.out.println("result2:"+result2);
        	if (result2 == 1) {
              System.out.println("like투입성공");
              out.print(result2);
        	} else {
              System.out.println("like투입실패");
            }
          }
		return null;
        }
	
	}
	
	
