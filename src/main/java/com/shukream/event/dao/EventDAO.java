package com.shukream.event.dao;

import java.util.List;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.ModelAndView;

import com.shukream.event.vo.EventVO;

@Repository("eventDAO")
public class EventDAO {
	
	// SQL Session 주입
	@Autowired
	private SqlSession sqlSession;

	
	public List<EventVO> checkuser(String id)throws DataAccessException{
		
		System.out.println("EventDAO -> checkdcnt 메소드 호출!");
		
		
		// sqlsession을 이용해서 id를 매개변수로 넘겨주고, db에 접근해서 d_cnt의 값을 반환받는다.
		List<EventVO>checkuser = sqlSession.selectList("mapper.event.checkuser", id);
		
		
		System.out.println(checkuser);
		
		// 조회 해온 d_cnt를 반환 시킨다.
		
		return checkuser;
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
