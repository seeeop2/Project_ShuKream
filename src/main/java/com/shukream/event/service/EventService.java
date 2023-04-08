package com.shukream.event.service;

import java.util.List;

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
		
		System.out.println("EventService -> checkdcnt 메소드 호출!");
		
		return eventDAO.checkuser(id);
		
	}

	// freeshipping으로 전달받은 ticket을 매개변수로 받아 service로 가져온다.
	public ModelAndView freeshipping(String ticket) {
		
		return eventDAO.freeshipping();
	}
	
	// freestore으로 전달받은 ticket을 매개변수로 받아 service로 가져온다.
	public ModelAndView freestore(String ticket) {
		
		return eventDAO.freestore();
	}
	
	// freecharge으로 전달받은 ticket을 매개변수로 받아 service로 가져온다.
	public ModelAndView freecharge(String ticket) {
		
		return eventDAO.freecharge();
	}

	// OTL으로 전달받은 ticket을 매개변수로 받아 service로 가져온다.
	public ModelAndView OTL(String ticket) {
		
		return  eventDAO.OTL();
	}

	
	
}
