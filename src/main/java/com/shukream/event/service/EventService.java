package com.shukream.event.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shukream.event.dao.EventDAO;

// 어노테이션 기호로 eventservice 설정하기
@Service("eventservice")
public class EventService {
	
	// EventDAO 자동 주입시키기
	@Autowired
	private EventDAO eventDAO;
	
	
}
