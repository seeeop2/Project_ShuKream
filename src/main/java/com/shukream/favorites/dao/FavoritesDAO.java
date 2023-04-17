package com.shukream.favorites.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.shukream.bids.vo.BidsVO;
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

	public List<Map<String, Object>> myLikeList(int start, int end, String email) {
		Map paramMap = new HashMap();
		paramMap.put("start", start);
		paramMap.put("end", end);
		paramMap.put("email", email);
		
		return sqlSession.selectList("mapper.favorites.myLikeList",paramMap);
	}


	public int myLikeCount(String like_mem_id) {

		return sqlSession.selectOne("mapper.favorites.myLikeCount",like_mem_id);
				
	}

	public int LikeCheck(LikeVO likeVO) {
       
        return sqlSession.selectOne("mapper.favorites.LikeCheck",likeVO); 
	}



	public void deleteLike(LikeVO likeVO) {
		
		sqlSession.delete("mapper.favorites.deleteLike",likeVO);
		
	}


	  public int insertLike(LikeVO likeVO) {
      	System.out.println("3");
		  return sqlSession.insert("mapper.favorites.insertLike",likeVO);
		  }






}
