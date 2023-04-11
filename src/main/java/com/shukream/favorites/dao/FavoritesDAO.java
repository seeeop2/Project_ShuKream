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
	@Autowired
	private FavoritesVO favoritesVO;
	@Autowired
	private LikeVO likeVO;
	
		
	
	public List<LikeVO> selectLikeList(LikeVO likeVO)throws Exception {

		List<LikeVO> likeList =(List)sqlSession.selectList("mapper.favorites.selectLikeList",likeVO);

		return likeList;
	}
/*	
	public List<FavoritesVO> selectFavoritesList(List<LikeVO> myLikeList) throws Exception{
		
		List<FavoritesVO> myFavoritesList;
		
		myFavoritesList = sqlSession.selectList("mapper.favorites.selectFavoritesList",myLikeList);
		
		System.out.println("favoritesList:"+ myFavoritesList);
		
		return myFavoritesList;
	}
*/



	public void deleteLikeList(LikeVO likeVO) {
		
		sqlSession.delete("mapper.favorites.deleteLikeList",likeVO);
		
	}
}
