package com.shukream.home.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shukream.home.service.HomeService;

@Controller
@RequestMapping(value="/home")
public class HomeController {
	
	@Autowired
	HomeService homeService;

	@ResponseBody
	@RequestMapping(value="/wordSearch.do", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8" )
	public String wordSearch(@RequestParam("searchWord") String searchWord) {
		
		List<String> wordList = homeService.wordSearch(searchWord);
		JSONArray jsonArr = new JSONArray();
		if(wordList != null) {
			for(String word : wordList) {
				JSONObject jsonObj = new JSONObject();
				jsonObj.put("word", word);
				jsonArr.add(jsonObj);
			}
		}
		
		return jsonArr.toString();
		
	}
}
