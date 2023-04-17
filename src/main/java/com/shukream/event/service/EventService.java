package com.shukream.event.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.shukream.event.dao.EventDAO;
import com.shukream.event.vo.EventVO;

// 어노테이션 기호로 eventservice 설정하기
@Service("eventservice")
public class EventService {
	
	// EventDAO 자동 주입시키기
	@Autowired
	private EventDAO eventDAO;
	
	// checkdcnt로 전달받은 id session 을 매개 변수로 받아 service로 가져온다.
	public List<EventVO> checkuser(String id) {
		
		System.out.println("EventService -> checkuser 메소드 호출!");
		
		return eventDAO.checkuser(id);
		
	}

	// 쿠폰4종으로 전달받은 ticket을 매개변수로 받아 service로 가져온다.
	public EventVO addcoupon(EventVO coupon, String id) {
		
		return eventDAO.addcoupon(coupon, id);
	}
	
	// 이메일로 현재 보유하고 있는 쿠폰을 조회 합니다.
	public List<EventVO> checkcoupon(String id) {

		return eventDAO.checkcoupon(id);
	}


	
	
}
