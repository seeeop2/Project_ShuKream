package com.shukream.home.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shukream.home.dao.HomeDAO;

@Service("homeService")
public class HomeService {

	@Autowired
	private HomeDAO homeDAO;
	
	public List<Map<String,Object>> wordSearch(String searchWord) {
		
		return homeDAO.selectKeywordSearch(searchWord);
	}

}
