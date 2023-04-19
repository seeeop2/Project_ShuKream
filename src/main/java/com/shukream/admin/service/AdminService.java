package com.shukream.admin.service;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shukream.admin.dao.AdminDAO;
import com.shukream.asks.vo.AsksVO;
import com.shukream.bids.vo.BidsVO;


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
	
	
}
