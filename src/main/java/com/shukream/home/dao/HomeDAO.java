package com.shukream.home.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository("homeDAO")
public class HomeDAO {
	@Autowired
	private SqlSession sqlSession;
	
	public List<String> selectKeywordSearch(String searchWord) throws DataAccessException {
		   List<String> list = (ArrayList)sqlSession.selectList("mapper.home.wordSearch",searchWord);
	   return list;
	
	}
}
