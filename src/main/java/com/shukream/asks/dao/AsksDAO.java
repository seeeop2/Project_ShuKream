package com.shukream.asks.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.shukream.asks.vo.AsksVO;

@Repository
public class AsksDAO {

  @Autowired
  private SqlSession sqlSession;
  
  public int insertAsks(AsksVO asksvo) {
    return sqlSession.insert("mapper.asks.insertAsks",asksvo);
  }
  public int selectLowAsks() {
    return sqlSession.selectOne("mapper.asks.selectLowAsks");
  }
  public int selectLowAsksAll(int size) {
    return sqlSession.selectOne("mapper.asks.selectLowAsksAll", size);
  }
  
  
}
