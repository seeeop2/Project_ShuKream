package com.shukream.orders.dao;

import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
  
}
