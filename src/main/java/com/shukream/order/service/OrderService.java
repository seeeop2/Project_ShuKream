package com.shukream.order.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shukream.order.vo.OrderVO;
import com.shukream.orders.dao.OrdersDAO;

@Service
public class OrderService {
	
	@Autowired
	OrdersDAO orderDAO;

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
	public String selectAskByIdWithSize(String product_id, String product_idx) {
	  Map map = new HashMap();
	  map.put("product_id", product_id);
	  map.put("product_size_idx", product_idx);
    map.put("product_id2", product_id);
	  Map resultMap = orderDAO.selectAskByIdWithSize(map);

	  String ASKS_IDX = String.valueOf(resultMap.get("ASKS_IDX_"));
	  return ASKS_IDX;
  }

  public String selectBidByIdWithSize(String product_id, String product_idx) {
    Map map = new HashMap();
    map.put("product_id", product_id);
    map.put("product_size_idx", product_idx);
    map.put("product_id2", product_id);
    Map resultMap = orderDAO.selectBidByIdWithSize(map);

    String BIDS_IDX = String.valueOf(resultMap.get("BIDS_IDX_"));
    return BIDS_IDX;
  }

}
