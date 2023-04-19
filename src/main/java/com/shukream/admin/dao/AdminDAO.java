package com.shukream.admin.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shukream.asks.vo.AsksVO;
import com.shukream.bids.vo.BidsVO;

@Repository("adminDAO")
public class AdminDAO {
	
	@Autowired
	private SqlSession sqlSession;
	@Autowired
	private AsksVO asksVO;
	@Autowired
	private BidsVO bidsVO;
	
	
	
	public List<AsksVO> asksList() {

		return sqlSession.selectList("mapper.admin.asksList");
	}
	
	public List<BidsVO> bidsList() {
		
		return sqlSession.selectList("mapper.admin.bidsList");
	}

	public int asksOrderChange(AsksVO asksVO) {
		
		return sqlSession.update("mapper.admin.asksOrderChange",asksVO); 	
		 
	}

	public int bidsOrderChange(BidsVO bidsVO) {
		
		return sqlSession.update("mapper.admin.bidsOrderChange",bidsVO); 
		
	}


}
