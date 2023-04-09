package com.shukream.home.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shukream.home.service.HomeService;

@Controller
@RequestMapping(value="/home")
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	HomeService homeService;

	@ResponseBody
	@RequestMapping(value="/wordSearch.do/{word}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8" )
	public String wordSearch(@PathVariable("word") String word) {
	    List<Map<String, Object>> productList = homeService.wordSearch(word);
	    JSONArray jsonArray = new JSONArray();
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    for (Map<String, Object> product : productList) {
	        JSONObject jsonObject = new JSONObject();
	        jsonObject.putAll(product);
	        
	        Date releaseDate = (Date) product.get("PRODUCT_RELEASE_DATE");
	        String releaseDateString = dateFormat.format(releaseDate);
	        jsonObject.put("PRODUCT_RELEASE_DATE", releaseDateString);
	        
	        jsonArray.add(jsonObject);
	    }
	    JSONObject result = new JSONObject();
	    result.put("products", jsonArray);
	    return result.toString();
			}
	
		
	}
