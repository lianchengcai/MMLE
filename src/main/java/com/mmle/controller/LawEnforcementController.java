package com.mmle.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mmle.entity.Exploration;
import com.mmle.entity.LawEnMessage;
import com.mmle.entity.LawEnforcement;
import com.mmle.entity.LawEnforcementExtend;
import com.mmle.entity.PenaltyDecision;
import com.mmle.entity.Record;
import com.mmle.service.ExplorationService;
import com.mmle.service.LawEnforcementService;
import com.mmle.service.PenaltyDecisionService;
import com.mmle.service.RecordService;
import com.mmle.utils.DTO;
import com.mmle.utils.DateJsonValueProcessor;
import com.mmle.utils.PageUtil;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

@Controller
@RequestMapping("lawEnforcement")
public class LawEnforcementController {

	@Resource
	private LawEnforcementService lawEnforcementService;
	
	@Resource
	private RecordService recordService;
	
	@Resource
	private ExplorationService explorationService;
	
	@Resource
	private PenaltyDecisionService penaltyDecisionService;
	
	
	@RequestMapping(value="add")
	public @ResponseBody Map<String, Object> addLawEnforcement(@RequestBody DTO data)throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		LawEnforcement lawEnforcement = data.getLawEnforcement();
		lawEnforcement.setDate(new Date());
		lawEnforcement.setState(0);
		Integer id = lawEnforcementService.add(lawEnforcement);
		if(id==null){
			map.put("code", 0);
		}else{
			map.put("code", 1);
			map.put("id", id);
		}
		return map;
	}
	
	@RequestMapping(value="getLawEnforcementPage")
	public @ResponseBody String getLawEnforcement(@RequestBody DTO data)throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		
		Integer currentPage = data.getCurrentPage();
		Integer size = data.getSize();
		LawEnforcement lawEnforcement = data.getLawEnforcement();
		PageUtil<LawEnforcementExtend> lawEnforcementExtendPage = lawEnforcementService.getLawEnforcementPage(lawEnforcement, currentPage, size);
		map.put("lawEnforcementExtendPage", lawEnforcementExtendPage);
		
		JsonConfig config = new JsonConfig(); 
		config.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor("yyyy-MM-dd hh:mm")); 
		JSONObject result = JSONObject.fromObject(map,config);
		return result.toString();
	}
	
//	@RequestMapping(value="getLEPageByTime")
//	public @ResponseBody String getLawEnforcementByTime(@RequestBody DTO data)throws Exception{
//		Map<String, Object> map = new HashMap<String, Object>();
//		
//		Integer currentPage = data.getCurrentPage();
//		Integer size = data.getSize();
//		Date lawStartTime = data.getLawStartTime();
//		Date lawEndTime = data.getLawEndTime();
//		LawEnforcement lawEnforcement = data.getLawEnforcement();
//		PageUtil<LawEnforcementExtend> lawEnforcementExtendPage = 
//				lawEnforcementService.getLawEnforcementPage(
//						lawEnforcement, currentPage, size,lawStartTime,lawEndTime);
//		map.put("lawEnforcementExtendPage", lawEnforcementExtendPage);
//		
//		JsonConfig config = new JsonConfig(); 
//		config.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor("yyyy-MM-dd hh:mm")); 
//		JSONObject result = JSONObject.fromObject(map,config);
//		return result.toString();
//	}
	
	@RequestMapping(value="getPageByTime")
	public @ResponseBody Map<String, Object> getPageByTime(@RequestBody DTO data)throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		Date lawStartTime = data.getLawStartTime();
		Date lawEndTime = data.getLawEndTime();
		Integer currentPage = data.getCurrentPage();
		Integer size = data.getSize();
		LawEnMessage lawEnMessage = data.getLawEnMessage();
		PageUtil<LawEnMessage> lawEnMessagePage = 
				lawEnforcementService.getLawEnMessagePage(
						lawEnMessage, currentPage, size,lawStartTime,lawEndTime);
		
		map.put("lawEnMessagePage", lawEnMessagePage);
		
		return map;
	}
	
	@RequestMapping(value="getPage")
	public @ResponseBody Map<String, Object> getPage(@RequestBody DTO data)throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		
		Integer currentPage = data.getCurrentPage();
		Integer size = data.getSize();
		LawEnMessage lawEnMessage = data.getLawEnMessage();
		PageUtil<LawEnMessage> lawEnMessagePage = lawEnforcementService.getLawEnMessagePage(lawEnMessage, currentPage, size);
		
		map.put("lawEnMessagePage", lawEnMessagePage);
		
		return map;
	}
	
	@RequestMapping(value="delete")
	public @ResponseBody Map<String, Object> deleteLawEnforcement(@RequestBody DTO data)throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		int id = data.getLawEnforcement().getId();
		if(lawEnforcementService.delete(id)){
			map.put("code", 1);
		}else{
			map.put("code", 0);
		}
		return map;
	}
	
	@RequestMapping(value="update")
	public @ResponseBody Map<String, Object> updateLawEnforcement(@RequestBody DTO data)throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		LawEnforcement lawEnforcement = data.getLawEnforcement();
		System.out.println(lawEnforcement.toString());
		if(lawEnforcementService.update(lawEnforcement)){
			map.put("code", 1);
		}else{
			map.put("code", 0);
		}
		return map;
	}
	
	@RequestMapping(value="addRecord")
	public @ResponseBody Map<String, Object> addRecord(@RequestBody DTO data)throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		Record record = data.getRecord();
		record.setFlag(true);
		if(recordService.add(record)){
			map.put("code", 1);
		}else{
			map.put("code", 0);
		}
		return map;
	}
	
	@RequestMapping(value="addExploration")
	public @ResponseBody Map<String, Object> addExploration(@RequestBody DTO data)throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		Exploration exploration = data.getExploration();
		System.out.println(exploration.toString());
		exploration.setFlag(true);
		
		if(explorationService.add(exploration)){
			map.put("code", 1);
		}else{
			map.put("code", 0);
		}
		return map;
	}
	
	@RequestMapping(value="addPenaltyDecision")
	public @ResponseBody Map<String, Object> addPenaltyDecision(@RequestBody DTO data)throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		PenaltyDecision penaltyDecision = data.getPenaltyDecision();
		penaltyDecision.setDate(new Date());
		penaltyDecision.setFlag(true);
		if(penaltyDecisionService.add(penaltyDecision)){
			map.put("code", 1);
		}else{
			map.put("code", 0);
		}
		return map;
	}
	
//	@RequestMapping(value="updatePenaltyDecision")
//	public @ResponseBody Map<String, Object> updatePenaltyDecision(@RequestBody DTO data)throws Exception{
//		Map<String, Object> map = new HashMap<String, Object>();
//		PenaltyDecision penaltyDecision = data.getPenaltyDecision();
//		if(penaltyDecisionService.update(penaltyDecision)){
//			map.put("msg", "success");
//		}else{
//			map.put("msg", "failure");
//		}
//		return map;
//	}
//	
//	@RequestMapping(value="updateRecord")
//	public @ResponseBody Map<String, Object> updateRecord(@RequestBody DTO data)throws Exception{
//		Map<String, Object> map = new HashMap<String, Object>();
//		Record record = data.getRecord();
//		if(recordService.update(record)){
//			map.put("msg", "success");
//		}else{
//			map.put("msg", "failure");
//		}
//		return map;
//	}
//	@RequestMapping(value="updateExploration")
//	public @ResponseBody Map<String, Object> updateExploration(@RequestBody DTO data)throws Exception{
//		Map<String, Object> map = new HashMap<String, Object>();
//		Exploration exploration = data.getExploration();
//		if(explorationService.update(exploration)){
//			map.put("msg", "success");
//		}else{
//			map.put("msg", "failure");
//		}
//		return map;
//	}
	
	
//	@RequestMapping(value="getLawEnforcementPage")
//	public @ResponseBody Map<String, Object> getLawEnforcement(@RequestBody DTO data)throws Exception{
//		Map<String, Object> map = new HashMap<String, Object>();
//		
//		int currentPage = data.getCurrentPage();
//		int size = data.getSize();
//		LawEnforcement lawEnforcement = data.getLawEnforcement();
//		PageUtil<LawEnforcement> lawEnforcementPage = lawEnforcementService.getLawEnforcementPage(lawEnforcement, currentPage, size);
//		map.put("lawEnforcementPage", lawEnforcementPage);
//		return map;
//	}

	
}
