package com.shukream.favorites.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shukream.favorites.dao.FavoritesDAO;
import com.shukream.favorites.vo.FavoritesVO;
import com.shukream.home.dao.HomeDAO;
import com.shukream.favorites.vo.LikeVO;

@Service("favoritesService ")
public class FavoritesService{

	@Autowired
	private FavoritesDAO favoritesDAO ;


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


	public void removeLikeList(LikeVO likeVO) {
		
		favoritesDAO.deleteLikeList(likeVO);
		
	}
	
		
	



}
