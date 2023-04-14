package com.shukream.favorites.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shukream.favorites.dao.FavoritesDAO;
import com.shukream.favorites.vo.FavoritesVO;
import com.shukream.home.dao.HomeDAO;
import com.shukream.shop.vo.Pagination;
import com.shukream.favorites.vo.LikeVO;

@Service("favoritesService ")
public class FavoritesService{

	@Autowired
	private FavoritesDAO favoritesDAO ;

/*
	public Map<String, List> myLikeList(LikeVO likeVO)throws Exception {

		Map<String,List> likeMap = new HashMap<String,List>();
		List<LikeVO> myLikeList=favoritesDAO.selectLikeList(likeVO);

		
		if(myLikeList.size()==0){ 
			return null;
		}
//		List<FavoritesVO> myFavoritesList = favoritesDAO.selectFavoritesList(myLikeList);

		
//		likeMap.put("myFavoritesList",myFavoritesList);		
		likeMap.put("myLikeList",myLikeList);		
		
		return likeMap;
	}

*/	
	
	
	public List<Map<String, Object>> myLikeList(int page, int size, String email) {
		
		int totalCount = favoritesDAO.myLikeCount(email);
		Pagination pagination = new Pagination(page, size, totalCount);
		int startIndex = pagination.getStartIndex();
		int endIndex = pagination.getEndIndex();
		
		return favoritesDAO.myLikeList(startIndex,endIndex,email);
	}

	
	
	public int myLikeCount(String like_mem_id) {
		
		return favoritesDAO.myLikeCount(like_mem_id);
	
	}

	
	
	public void removeLikeList(LikeVO likeVO) {
		
		 favoritesDAO.deleteLikeList(likeVO);
		
	}



	public int LikeCheck(String product_id, String email) {
		
		LikeVO likeVO = new LikeVO();
		likeVO.setLike_mem_id(email);
		likeVO.setLike_product(product_id);
		return favoritesDAO.LikeCheck(likeVO);
	}



	public void deleteLike(String product_id, String email) {
			
		LikeVO likeVO = new LikeVO();
		likeVO.setLike_mem_id(email);
		likeVO.setLike_product(product_id);
		
		favoritesDAO.deleteLike(likeVO);
	}



	public int insertLike(LikeVO likeVO) {
    	System.out.println("2");
		return favoritesDAO.insertLike(likeVO);
	}


		
	



}
