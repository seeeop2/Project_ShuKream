package com.shukream.orders.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shukream.order.vo.OrderVO;

@Repository
public class OrdersDAO {

  @Autowired
  private SqlSession sqlSession;
  
  public Map SelectLatestOrderAsk(Map map) {
    return sqlSession.selectOne("mapper.orders.selectLatestOrderAsk",map);
  }
  
  public Map SelectLatestOrderBid(Map map) {
    return sqlSession.selectOne("mapper.orders.selectLatestOrderBid",map);
  }
  
  public List selectForChart(Map map) {
    return sqlSession.selectList("mapper.orders.selectForChart",map);
  }
  
  //주문시 SHIPPING_INFORMATION에 데이터를 넣음
	@Transactional
	public int insertShipInfo(OrderVO vo) {
		sqlSession.insert("mapper.orders.insertShipInfo", vo);
		int shipInfoIdx = sqlSession.selectOne("mapper.orders.selectShipInfoIdxFromDual");
		return shipInfoIdx;
	}
	
	//즉시구매 또는 즉시판매의 경우 바로 orders 테이블에 asks, bids idx를 연결해서 데이터를 넣어줘야함
	@Transactional
	public int insertOrders(Map<String, Object> paramMap) {
		sqlSession.insert("mapper.orders.insertOrders",paramMap);
		int orderIdx = sqlSession.selectOne("mapper.orders.selectOrderIdxFromDual");
		return orderIdx;
	}

	//판매입찰에 등록된 상품을 구매로 넘어올시 해당 asks_idx(판매입찰인덱스)를 받아 해당 정보를 조회 
	public Map<String, Object> selectAsks(String asks_idx) {
		return sqlSession.selectOne("mapper.orders.selectAsks",asks_idx);
	}

	//위의 selectAsks로 받은 product_id를 연결해서 아이템도 같이 조회 해감
	public Map<String, Object> selectProduct(int product_id) {
		return sqlSession.selectOne("mapper.orders.selectProduct",product_id);
	}

	//주문이 들어가면 새로운 구매입찰을 생성해야 함
	@Transactional
	public int insertNewBids(Map<String, Object> paramMap) {
		sqlSession.insert("mapper.orders.insertNewBids",paramMap);
		int bidsIdx = sqlSession.selectOne("mapper.orders.selectBidsIdxFromDual");
		return bidsIdx;
	}

	public void updateAsks(Map<String, Object> paramMap) {
		sqlSession.update("mapper.orders.updateAsks",paramMap);
	}

	public void updateBids(Map<String, Object> paramMap) {
		sqlSession.update("mapper.orders.updateBids",paramMap);
		
	}

	@Transactional
	public int insertNewAsks(Map<String, Object> paramMap) {
		sqlSession.insert("mapper.orders.insertNewAsks",paramMap);
		int asksIdx = sqlSession.selectOne("mapper.orders.selectAsksIdxFromDual");
		return asksIdx;
	}

	public Map<String, Object> selectBids(String bids_idx) {
		return sqlSession.selectOne("mapper.orders.selectBids",bids_idx);
	}

  public Map selectAskByIdWithSize(Map map) {
    return sqlSession.selectOne("mapper.orders.selectAskByIdWithSize",map);
  }
  public Map selectBidByIdWithSize(Map map) {
    return sqlSession.selectOne("mapper.orders.selectBidByIdWithSize",map);
  }
  
  
}
