package com.shukream.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shukream.shop.dao.ShopDAO;
import com.shukream.shop.vo.ProductsVO;

@Service("shopService")
public class ShopService {
	
	@Autowired
	ShopDAO shopDAO;

	public List<ProductsVO> shopMainProductsList() {
		return shopDAO.shopMainProductsList();
	}

}
