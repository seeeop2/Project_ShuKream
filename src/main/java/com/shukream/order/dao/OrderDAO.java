package com.shukream.order.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shukream.order.vo.OrderVO;
import com.shukream.products.vo.ProductsVO;

@Repository("orderDAO")
public class OrderDAO {

	@Autowired
	SqlSession sqlSession;
	
	public void checkOut(OrderVO vo) {
//		insertBids();
//		insertOrder();
		sqlSession.insert("mapper.order.checkOut", vo);
	}
	
	public void insertOrder() {
		sqlSession.insert("mapper.order.insertOrder");
	}

	public Map<String, Object> selectAsks(String asks_idx) {
		return sqlSession.selectOne("mapper.order.selectAsks",asks_idx);
	}

	public Map<String, Object> selectProduct(int product_id) {
		return sqlSession.selectOne("mapper.order.selectProduct",product_id);
	}

	public void insertNewBids(Map<String, Object> paramMap) {
		sqlSession.insert("mapper.order.insertNewBids",paramMap);
	}

}
