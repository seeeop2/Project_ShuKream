package com.shukream.shop.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shukream.shop.dao.ShopDAO;
import com.shukream.shop.vo.Pagination;

@Service("shopService")
public class ShopService {
	
	@Autowired
	ShopDAO shopDAO;

	//메인페이징처리
	public List<Map<String, Object>> shopMainProductsList(int page, int size, String opt, String division) {
		
		int totalCount = shopDAO.shopMainProductCount(opt,division);
		Pagination pagination = new Pagination(page, size, totalCount);
		int startIndex = pagination.getStartIndex();
		int endIndex = pagination.getEndIndex();
		
		return shopDAO.shopMainProductsList(startIndex,endIndex,opt,division);
	}
	//메인 페이징 처리
	public int shopMainProductCount(String opt, String division) {
		return shopDAO.shopMainProductCount(opt,division);
	}
	
}
