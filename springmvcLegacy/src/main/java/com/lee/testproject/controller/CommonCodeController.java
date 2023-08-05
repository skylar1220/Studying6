package com.lee.testproject.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.lee.testproject.dao.service.CommonService;

@Controller
public class CommonCodeController {
	@Autowired
	CommonService commonService ;
	
	@GetMapping("/comcode")
	public ModelAndView comcode() {
		return new ModelAndView("home");
	}
	
	@PostMapping("/comcode")
	@ResponseBody 
	public List<Map<String, Object>> commoncode(){
		List<Map<String, Object>> lists = commonService.getCode();
//		List<Map<String, Object>> lists = new ArrayList<Map<String,Object>>();
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("descriptioin", "딸기");
//		map.put("id", "1");
//		lists.add(map);
//		
//		map = new HashMap<String, Object>();
//		map.put("descriptioin", "사과");
//		map.put("id", "2");
//		lists.add(map);
		return lists;
	}
}
