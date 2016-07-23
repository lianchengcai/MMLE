package com.mmle.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mmle.entity.FishBoat;
import com.mmle.service.FishBoatService;
import com.mmle.utils.DTO;
import com.mmle.utils.PageUtil;

@Controller
@RequestMapping(value="fishBoat")
public class FishBoatController {

	@Resource
	private FishBoatService fishBoatService;
	
	@RequestMapping(value="add")
	public @ResponseBody Map<String, Object> addFishBoat(@RequestBody DTO data)throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		FishBoat fishBoat = data.getFishBoat();
		if(fishBoatService.add(fishBoat)){
			map.put("msg", "success");
		}else{
			map.put("msg", "failure");
		}
		return map;
	}
	
	@RequestMapping(value="getPageList")
	public @ResponseBody Map<String, Object> getFishBoatList(@RequestBody DTO data)throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		FishBoat fishBoat = data.getFishBoat();
		int currentPage = data.getCurrentPage();
		int size = data.getSize();
		PageUtil<FishBoat> fishBoatPage = fishBoatService.getFishBoatPage(fishBoat, currentPage, size);
		map.put("fishBoatPage", fishBoatPage);
		return map;
	}
	
	@RequestMapping(value="delete")
	public @ResponseBody Map<String, Object> deleteFishBoat(@RequestBody DTO data)throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		String boatId = data.getFishBoat().getBoatId();
		if(fishBoatService.delete(boatId)){
			map.put("msg", "success");
		}else{
			map.put("msg", "failure");
		}
		return map;
	}
	
	@RequestMapping(value="update")
	public @ResponseBody Map<String, Object> updateFishBoat(@RequestBody DTO data)throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		FishBoat fishBoat = data.getFishBoat();
		if(fishBoatService.update(fishBoat)){
			map.put("msg", "success");
		}else{
			map.put("msg", "failure");
		}
		return map;
	}
	
	
	
	
}
