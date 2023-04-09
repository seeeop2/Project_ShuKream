package com.shukream.products.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.shukream.products.vo.ProductsVO;

@Repository
public class ProductsDAO {
  
  @Autowired
  private SqlSession sqlSession;
  
  public List<ProductsVO> getProductsList(){
    return sqlSession.selectList("mapper.products.getProductsList");
  }
}
