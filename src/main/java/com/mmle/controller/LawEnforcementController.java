package com.mmle.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mmle.entity.Exploration;
import com.mmle.entity.FishBoat;
import com.mmle.entity.LawEnforcement;
import com.mmle.entity.PenaltyDecision;
import com.mmle.entity.Record;
import com.mmle.service.ExplorationService;
import com.mmle.service.LawEnforcementService;
import com.mmle.service.PenaltyDecisionService;
import com.mmle.service.RecordService;
import com.mmle.utils.DTO;

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
		if(lawEnforcementService.add(lawEnforcement)){
			map.put("msg", "success");
		}else{
			map.put("msg", "failure");
		}
		return map;
	}
	
	@RequestMapping(value="delete")
	public @ResponseBody Map<String, Object> deleteLawEnforcement(@RequestBody DTO data)throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		int id = data.getLawEnforcement().getId();
		if(lawEnforcementService.delete(id)){
			map.put("msg", "success");
		}else{
			map.put("msg", "failure");
		}
		return map;
	}
	
	@RequestMapping(value="update")
	public @ResponseBody Map<String, Object> updateLawEnforcement(@RequestBody DTO data)throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		LawEnforcement lawEnforcement = data.getLawEnforcement();
		if(lawEnforcementService.update(lawEnforcement)){
			map.put("msg", "success");
		}else{
			map.put("msg", "failure");
		}
		return map;
	}
	
	@RequestMapping(value="addRecord")
	public @ResponseBody Map<String, Object> addRecord(@RequestBody DTO data)throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		Record record = data.getRecord();
		if(recordService.add(record)){
			map.put("msg", "success");
		}else{
			map.put("msg", "failure");
		}
		return map;
	}
	
	@RequestMapping(value="updateRecord")
	public @ResponseBody Map<String, Object> updateRecord(@RequestBody DTO data)throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		Record record = data.getRecord();
		if(recordService.update(record)){
			map.put("msg", "success");
		}else{
			map.put("msg", "failure");
		}
		return map;
	}
	
	@RequestMapping(value="addExploration")
	public @ResponseBody Map<String, Object> addExploration(@RequestBody DTO data)throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		Exploration exploration = data.getExploration();
		if(explorationService.add(exploration)){
			map.put("msg", "success");
		}else{
			map.put("msg", "failure");
		}
		return map;
	}
	
	@RequestMapping(value="updateExploration")
	public @ResponseBody Map<String, Object> updateExploration(@RequestBody DTO data)throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		Exploration exploration = data.getExploration();
		if(explorationService.update(exploration)){
			map.put("msg", "success");
		}else{
			map.put("msg", "failure");
		}
		return map;
	}
	
	@RequestMapping(value="addPenaltyDecision")
	public @ResponseBody Map<String, Object> addPenaltyDecision(@RequestBody DTO data)throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		PenaltyDecision penaltyDecision = data.getPenaltyDecision();
		if(penaltyDecisionService.add(penaltyDecision)){
			map.put("msg", "success");
		}else{
			map.put("msg", "failure");
		}
		return map;
	}
	
	@RequestMapping(value="updatePenaltyDecision")
	public @ResponseBody Map<String, Object> updatePenaltyDecision(@RequestBody DTO data)throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		PenaltyDecision penaltyDecision = data.getPenaltyDecision();
		if(penaltyDecisionService.update(penaltyDecision)){
			map.put("msg", "success");
		}else{
			map.put("msg", "failure");
		}
		return map;
	}
	

	
}
