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

	public int insertShipInfo(OrderVO vo) {
	vo.setPrimary_address(vo.getSample4_postcode()+vo.getSample4_roadAddress()+vo.getSample4_jibunAddress()+vo.getSample4_detailAddress()+vo.getSample4_extraAddress());	
		return orderDAO.insertShipInfo(vo);
	}

	public Map<String, Object> selectAsks(String asks_idx) {
		return orderDAO.selectAsks(asks_idx);
	}

	public Map<String, Object> selectProduct(int product_id) {
		return orderDAO.selectProduct(product_id);
	}

	public int insertNewBids(Map<String, Object> paramMap) {
		return orderDAO.insertNewBids(paramMap);
	}

	public int insertOrders(Map<String, Object> paramMap) {
		//인덱스를 받야아햠.
		return orderDAO.insertOrders(paramMap);
	}

	public void updateAsks(Map<String, Object> paramMap) {
		orderDAO.updateAsks(paramMap);
	}

	public void updateBids(Map<String, Object> paramMap) {
		orderDAO.updateBids(paramMap);
		
	}

	public int insertNewAsks(Map<String, Object> paramMap) {
		return orderDAO.insertNewAsks(paramMap);
	}

	public Map<String, Object> selectBids(String bids_idx) {
		return orderDAO.selectBids(bids_idx);
	}

}
