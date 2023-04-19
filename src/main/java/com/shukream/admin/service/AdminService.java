package com.shukream.admin.service;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shukream.admin.dao.AdminDAO;
import com.shukream.asks.vo.AsksVO;
import com.shukream.bids.vo.BidsVO;
import com.shukream.favorites.vo.LikeVO;


@Service("adminService")
public class AdminService {
	
	@Autowired
	private AdminDAO adminDAO;
	@Autowired
	private AsksVO asksVO;
	@Autowired
	private BidsVO bidsVO;
	
	
	public List<AsksVO> asksList() {
		
		return adminDAO.asksList();
		
	}
	
	public List<BidsVO> bidsList() {
		
		return adminDAO.bidsList();
		
	}

	public int asksOrderChange(String asks_order_number, int asks_order_state_idx) {
		AsksVO asksVO = new AsksVO();
		asksVO.setAsks_order_number(asks_order_number);
		asksVO.setAsks_order_state_idx(asks_order_state_idx);
		
		return adminDAO.asksOrderChange(asksVO);
	}

	public int bidsOrderChange(String bids_order_number, int bids_order_state_idx) {
		BidsVO bidsVO = new BidsVO();
		bidsVO.setBids_order_number(bids_order_number);
		bidsVO.setBids_order_state_idx(bids_order_state_idx);
		return adminDAO.bidsOrderChange(bidsVO);
	}
	
	
}
