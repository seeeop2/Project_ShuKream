package com.shukream.products.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.shukream.products.vo.ProductsVO;
import com.shukream.products.vo.ProductsVOWithIMG;

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
  public Map selectProduct(Map map) {
    return sqlSession.selectOne("mapper.products.selectProduct", map);
  }

  public Map selectProductDetail(Map map) {
    return sqlSession.selectOne("mapper.products.selectProductDetail", map);
  }

  public ProductsVOWithIMG selectProductOne(int product_id) {
    return sqlSession.selectOne("mapper.products.selectProductOne", product_id);
  }

  public List<ProductsVO> selectRankFour(int product_id) {
    return sqlSession.selectList("mapper.products.selectRankFour", product_id);
  }
  
}
