package com.shukream.bids.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.shukream.asks.vo.AsksVO;
import com.shukream.bids.vo.BidsVO;

@Repository
public class BidsDAO {

  @Autowired
  private SqlSession sqlSession;
  
  public int insertBids(BidsVO bidsvo) {
    return sqlSession.insert("mapper.bids.insertBids",bidsvo);
  }
  
}
