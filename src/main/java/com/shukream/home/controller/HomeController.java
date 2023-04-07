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
	    List<Map<String, Object>> productList = homeService.wordSearch(word);
//	    System.out.println(productList);
	    JSONArray jsonArray = new JSONArray();
	    for (Map<String, Object> product : productList) {
	        JSONObject jsonObject = new JSONObject();
	        jsonObject.putAll(product);
//	        jsonObject.put("model_number", product.get("MODEL_NUMBER"));
//	        jsonObject.put("product_id", product.get("PRODUCT_ID"));
//	        jsonObject.put("product_name", product.get("PRODUCT_NAME"));
//	        jsonObject.put("product_price", product.get("PRODUCT_PRICE"));
//	        jsonObject.put("ticker_number", product.get("TICKER_NUMBER"));
//	        jsonObject.put("img_product_idx", product.get("IMG_PRODUCT_IDX"));
	        jsonArray.add(jsonObject);
	    }
	    JSONObject result = new JSONObject();
	    result.put("products", jsonArray);
	    return result.toString();
			}
	
		
	}
