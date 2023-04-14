package com.shukream.order.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shukream.order.dao.OrderDAO;
import com.shukream.order.vo.OrderVO;
import com.shukream.products.vo.ProductsVO;

@Service
public class OrderService {
	
	@Autowired
	OrderDAO orderDAO;

	public void checkOut(OrderVO vo) {
	vo.setPrimary_address(vo.getSample4_postcode()+vo.getSample4_roadAddress()+vo.getSample4_jibunAddress()+vo.getSample4_detailAddress()+vo.getSample4_extraAddress());	
		orderDAO.checkOut(vo);
	}

	public Map<String, Object> selectAsks(String asks_idx) {
		return orderDAO.selectAsks(asks_idx);
	}

	public Map<String, Object> selectProduct(int product_id) {
		return orderDAO.selectProduct(product_id);
	}

	public void insertNewBids(Map<String, Object> paramMap) {
		orderDAO.insertNewBids(paramMap);
	}

}
