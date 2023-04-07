package com.shukream.shop.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shukream.shop.vo.ProductsVO;

@Repository("shopDAO")
public class ShopDAO {

	@Autowired
	SqlSession sqlSession;

	public List<ProductsVO> shopMainProductsList() {
		
		return sqlSession.selectList("mapper.shop.shopMainProductsList");
	}
	
}
