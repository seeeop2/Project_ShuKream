package com.shukream.home.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.shukream.products.vo.ProductImageVO;

@Repository("homeDAO")
public class HomeDAO {
	@Autowired
	private SqlSession sqlSession;
	
	public List<Map<String,Object>> selectKeywordSearch(String searchWord) throws DataAccessException {
	   return sqlSession.selectList("mapper.home.wordSearch",searchWord);
	}
	
	public List<Map<String, List<ProductImageVO>>> selectMainProductsList (String option) throws DataAccessException {
		return sqlSession.selectList("mapper.home.selectMainProductsList",option);
	}
}
