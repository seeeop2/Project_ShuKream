package com.shukream.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shukream.order.dao.OrderDAO;
import com.shukream.order.vo.OrderVO;

@Service
public class OrderService {
	
	@Autowired
	OrderDAO orderDAO;

	public void checkOut(OrderVO vo) {
	vo.setPrimary_address(vo.getSample4_postcode()+vo.getSample4_roadAddress()+vo.getSample4_jibunAddress()+vo.getSample4_detailAddress()+vo.getSample4_extraAddress());	
		orderDAO.checkOut(vo);
	}

}
