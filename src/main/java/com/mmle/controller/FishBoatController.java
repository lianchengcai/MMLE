package com.mmle.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mmle.entity.FishBoat;
import com.mmle.service.FishBoatService;
import com.mmle.utils.DTO;
import com.mmle.utils.DateJsonValueProcessor;
import com.mmle.utils.PageUtil;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

@Controller
@RequestMapping(value="fishBoat")
public class FishBoatController {

	@Resource
	private FishBoatService fishBoatService;
	
	@RequestMapping(value="add")
	public @ResponseBody Map<String, Object> addFishBoat(@RequestBody DTO data)throws Exception{
		System.out.println(data.toString());
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println("添加");
		FishBoat fishBoat = data.getFishBoat();
		if(fishBoatService.add(fishBoat)){
			map.put("code", 1);
		}else{
			map.put("code", 0);
		}
		return map;
	}
	
	@RequestMapping(value="getPageList")
	public @ResponseBody String getFishBoatList(@RequestBody DTO data)throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		
		int currentPage=data.getCurrentPage();//当前页
		int size=data.getSize();//页大小
		FishBoat fishBoat = data.getFishBoat();
		PageUtil<FishBoat> fishBoatPage = fishBoatService.getFishBoatPage(fishBoat, currentPage, size);
		map.put("fishBoatPage", fishBoatPage);
		
		JsonConfig config = new JsonConfig(); 
		config.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor("yyyy-MM-dd hh:mm")); 
		JSONObject result = JSONObject.fromObject(map,config);
		return result.toString();
	}
	
	@RequestMapping(value="delete")
	public @ResponseBody Map<String, Object> deleteFishBoat(@RequestBody DTO data)throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		String boatId = data.getFishBoat().getBoatId();
		if(fishBoatService.delete(boatId)){
			map.put("code", 1);
		}else{
			map.put("code", 0);
		}
		return map;
	}
	
	@RequestMapping(value="update")
	public @ResponseBody Map<String, Object> updateFishBoat(@RequestBody DTO data)throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		FishBoat fishBoat = data.getFishBoat();
		if(fishBoatService.update(fishBoat)){
			map.put("code", 1);
		}else{
			map.put("code", 0);
		}
		return map;
	}
	
}
