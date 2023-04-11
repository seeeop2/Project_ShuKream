package com.shukream.home.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.shukream.products.vo.ImageFileVO;

@Repository("homeDAO")
public class HomeDAO {
	@Autowired
	private SqlSession sqlSession;
	
	public List<Map<String,Object>> selectKeywordSearch(String searchWord) throws DataAccessException {
	   return sqlSession.selectList("mapper.home.wordSearch",searchWord);
	}
	
	public List<ImageFileVO> selectMainProductsList (String option) throws DataAccessException {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("option", option);
		return sqlSession.selectList("mapper.home.selectMainProductsList",paramMap);
	}
}
