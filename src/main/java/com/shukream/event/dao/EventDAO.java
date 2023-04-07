package com.shukream.event.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.ModelAndView;

@Repository("eventDAO")
public class EventDAO {
	
	// SQL Session 주입
	@Autowired
	private SqlSession sqlSession;
	
	
	
	
	public int checkdcnt(String id)throws DataAccessException{
		
		// 변수 d_cnt를 생성 후 초기화 시킨다.
		int d_cnt = 0;
		
		// sqlsession을 이용해서 id를 매개변수로 넘겨주고, db에 접근해서 d_cnt의 값을 반환받는다.
		d_cnt = sqlSession.selectOne("mapper.event.checkdcnt", id);
		
		
		System.out.println(d_cnt);
		
		// 조회 해온 d_cnt를 반환 시킨다.
		
		return d_cnt;
	}
	

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
