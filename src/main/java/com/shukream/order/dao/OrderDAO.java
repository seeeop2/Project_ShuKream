package com.shukream.order.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shukream.order.vo.OrderVO;
import com.shukream.products.vo.ProductsVO;

@Repository("orderDAO")
public class OrderDAO {

	@Autowired
	SqlSession sqlSession;
	
	//주문시 SHIPPING_INFORMATION에 데이터를 넣음
	@Transactional
	public int insertShipInfo(OrderVO vo) {
		sqlSession.insert("mapper.order.insertShipInfo", vo);
		int shipInfoIdx = sqlSession.selectOne("mapper.order.selectShipInfoIdxFromDual");
		return shipInfoIdx;
	}
	
	//즉시구매 또는 즉시판매의 경우 바로 orders 테이블에 asks, bids idx를 연결해서 데이터를 넣어줘야함
	@Transactional
	public int insertOrders(Map<String, Object> paramMap) {
		sqlSession.insert("mapper.order.insertOrders",paramMap);
		int orderIdx = sqlSession.selectOne("mapper.order.selectOrderIdxFromDual");
		return orderIdx;
	}

	//판매입찰에 등록된 상품을 구매로 넘어올시 해당 asks_idx(판매입찰인덱스)를 받아 해당 정보를 조회 
	public Map<String, Object> selectAsks(String asks_idx) {
		return sqlSession.selectOne("mapper.order.selectAsks",asks_idx);
	}

	//위의 selectAsks로 받은 product_id를 연결해서 아이템도 같이 조회 해감
	public Map<String, Object> selectProduct(int product_id) {
		return sqlSession.selectOne("mapper.order.selectProduct",product_id);
	}

	//주문이 들어가면 새로운 구매입찰을 생성해야 함
	@Transactional
	public int insertNewBids(Map<String, Object> paramMap) {
		sqlSession.insert("mapper.order.insertNewBids",paramMap);
		int bidsIdx = sqlSession.selectOne("mapper.order.selectBidsIdxFromDual");
		return bidsIdx;
	}

	public void updateAsks(Map<String, Object> paramMap) {
		sqlSession.update("mapper.order.updateAsks",paramMap);
	}

	public void updateBids(Map<String, Object> paramMap) {
		sqlSession.update("mapper.order.updateBids",paramMap);
		
	}

	@Transactional
	public int insertNewAsks(Map<String, Object> paramMap) {
		sqlSession.insert("mapper.order.insertNewAsks",paramMap);
		int asksIdx = sqlSession.selectOne("mapper.order.selectAsksIdxFromDual");
		return asksIdx;
	}

	public Map<String, Object> selectBids(String bids_idx) {
		return sqlSession.selectOne("mapper.order.selectBids",bids_idx);
	}

  public Map selectAskByIdWithSize(Map map) {
    return sqlSession.selectOne("mapper.order.selectAskByIdWithSize",map);
  }
  public Map selectBidByIdWithSize(Map map) {
    return sqlSession.selectOne("mapper.order.selectBidByIdWithSize",map);
  }
  

}
