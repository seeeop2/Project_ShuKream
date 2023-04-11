package com.shukream.home.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.shukream.home.dao.HomeDAO;
import com.shukream.products.vo.ImageFileVO;

@Service("homeService")
public class HomeService {

	@Autowired
	private HomeDAO homeDAO;
	
	public List<Map<String,Object>> wordSearch(String searchWord) {
		
		return homeDAO.selectKeywordSearch(searchWord);
	}

	public Map<String, List<ImageFileVO>> selectMainProductsList () throws DataAccessException {
		
		Map<String, List<ImageFileVO>> mainProductMap = new HashMap<String, List<ImageFileVO>>();
		
		//베스트셀러(우선 판매가격으로 정렬)
		mainProductMap.put("bestSeller",homeDAO.selectMainProductsList("PRODUCT_PRICE"));
		//신상품
		mainProductMap.put("newArrivals", homeDAO.selectMainProductsList("PRODUCT_RELEASE_DATE"));
		//인기아이템(우선 상품인덱스로 정렬)
		mainProductMap.put("popularItems", homeDAO.selectMainProductsList("PRODUCT_ID"));
		
		return mainProductMap;
	}
}
