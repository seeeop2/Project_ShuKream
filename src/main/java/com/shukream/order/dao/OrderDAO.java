package com.shukream.order.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shukream.order.vo.OrderVO;

@Repository("orderDAO")
public class OrderDAO {

	@Autowired
	SqlSession sqlSession;
	
	public void checkOut(OrderVO vo) {
		insertBids();
		insertOrder();
		sqlSession.insert("mapper.order.checkOut", vo);
	}
	
	public void insertBids() {
		sqlSession.insert("mapper.order.insertBids");
	}
	
	public void insertOrder() {
		sqlSession.insert("mapper.order.insertOrder");
	}

}
