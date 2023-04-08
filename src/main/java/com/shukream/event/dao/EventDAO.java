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
		
		System.out.println("EventDAO -> checkuser 메소드 호출!");
		
		
		// sqlsession을 이용해서 id를 매개변수로 넘겨주고, db에 접근해서 d_cnt의 값을 반환받는다.
		List<EventVO>checkuser = sqlSession.selectList("mapper.event.checkuser", id);
		
		
		System.out.println(checkuser);
		
		// 조회 해온 d_cnt를 반환 시킨다.
		
		return checkuser;
	}
	

	public EventVO addcoupon(EventVO coupon, String id) {
		
		System.out.println("EventDAO -> addcoupon 메소드 호출!");
		
		System.out.println(coupon.getMember_id());
		System.out.println(coupon.getA_cnt());
		System.out.println(coupon.getU_cnt());
		System.out.println(coupon.getD_cnt());
		System.out.println(coupon.getD_ticket());
		System.out.println(coupon.getD_contents());
		
		sqlSession.insert("mapper.event.addcoupon", coupon);
		
		return coupon;
		
	}


}
