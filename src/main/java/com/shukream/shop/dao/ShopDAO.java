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

	public List<Map<String,Object>> shopMainProductsList(int start, int end,String opt, String division) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("start", start);
		paramMap.put("end", end);
		paramMap.put("opt", opt);
		paramMap.put("division", division);
		return sqlSession.selectList("mapper.shop.shopMainProductsList",paramMap);
	}
	
	public int shopMainProductCount(String opt, String division) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("opt", opt);
		paramMap.put("division", division);
		return sqlSession.selectOne("mapper.shop.shopMainProductCount",paramMap);
	}

	public String likeList(String email) {

		return sqlSession.selectOne("mapper.shop.likeList",email);
	}
	
}
