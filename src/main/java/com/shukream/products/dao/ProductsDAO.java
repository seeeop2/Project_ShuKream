package com.shukream.products.dao;

import java.util.List;
import java.util.Map;
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
  
  public int addProduct(ProductsVO productsvo) {
    return sqlSession.insert("mapper.products.addProduct", productsvo);
  }
  public List selectProduct(int product_id) {
    return sqlSession.selectList("mapper.products.selectProduct", product_id);
  }
}
