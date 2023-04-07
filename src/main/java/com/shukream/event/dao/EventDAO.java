package com.shukream.event.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.ModelAndView;

@Repository("eventDAO")
public class EventDAO {
	
	// SQL Session 주입
	@Autowired
	private SqlSession sqlSession;

	public ModelAndView freeshipping() {
		
		return null;
	}

	public ModelAndView freestore() {
		// TODO Auto-generated method stub
		return null;
	}

	public ModelAndView freecharge() {
		// TODO Auto-generated method stub
		return null;
	}

	public ModelAndView OTL() {
		// TODO Auto-generated method stub
		return null;
	}

}
