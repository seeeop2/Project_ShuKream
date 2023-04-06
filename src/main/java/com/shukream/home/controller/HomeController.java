package com.shukream.home.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
	@RequestMapping(value="/wordSearch.do/{word}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8" )
	public String wordSearch(@PathVariable("word") String word) {
		List<String> wordList = homeService.wordSearch(word);
		JSONObject jsonObj = new JSONObject();
				jsonObj.put("word", wordList);
				return jsonObj.toString();
			}
	
		
	}
