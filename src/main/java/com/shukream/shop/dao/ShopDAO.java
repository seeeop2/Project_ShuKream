package com.shukream.shop.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository("shopDAO")
public class ShopDAO {

	@Autowired
	SqlSession sqlSession;

	public List<Map<String,Object>> shopMainProductsList(int start, int end) {
		Map<String, Integer> paramMap = new HashMap<String, Integer>();
		paramMap.put("start", start);
		paramMap.put("end", end);
		
		return sqlSession.selectList("mapper.shop.shopMainProductsList",paramMap);
	}
	
	public int shopMainProductCount() {
		return sqlSession.selectOne("mapper.shop.shopMainProductCount");
	}
	
	
}
