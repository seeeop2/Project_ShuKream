package com.shukream.event.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("eventDAO")
public class EventDAO {
	
	// SQL Session 주입
	@Autowired
	private SqlSession sqlSession;

}
