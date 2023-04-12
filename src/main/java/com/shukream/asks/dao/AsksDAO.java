package com.shukream.asks.dao;

import java.util.HashMap;
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
  public int selectLowAsksAll(HashMap<String, Object> map) {
    int result = sqlSession.selectOne("mapper.asks.selectLowAsksAll", map );
    return result;
  }
  public AsksVO SelectLowAsksRownum(int size) {
    AsksVO result = sqlSession.selectOne("mapper.asks.selectLowAsksRownum", size );
    return result;
  }
  
  public AsksVO test(HashMap<String, Object> map) {
    AsksVO result = sqlSession.selectOne("mapper.asks.test", map );
    return result;
  }
  
  
  
}
