package com.shukream.favorites.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.shukream.favorites.vo.FavoritesVO;
import com.shukream.favorites.vo.LikeVO;

@Repository("favoritesDAO")
public class FavoritesDAO {
	@Autowired
	private SqlSession sqlSession;

	public List<LikeVO> selectLikeList(LikeVO likeVO) {
		List<LikeVO> likeList =(List)sqlSession.selectList("mapper.favorites.selectLikeList",likeVO);
		return likeList;
	}

/*	
	public List<FavoritesVO> selectFavoritesList(List<LikeVO> myLikeList) {
		List<FavoritesVO> myFavoritesList;
		myFavoritesList = sqlSession.selectList("mapper.favorites.selectFavoritesList",myLikeList);
		return myFavoritesList;
	}
*/	

		

}
