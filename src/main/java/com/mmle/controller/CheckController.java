package com.mmle.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mmle.serviceImple.ICheckService;
import com.mmle.utils.DTO;

import ch.qos.logback.classic.Logger;

/**   
 * @Title: CheckController.java 
 * @Package com.mmle.controller 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author lbb
 * @date 2016年7月23日 下午8:31:38 
 * @version V1.0   
 */
@Controller
public class CheckController {
	@Resource
	ICheckService checkService ;
	
	private static Logger log = (Logger) LoggerFactory.getLogger(CaseController.class);

	@RequestMapping("addCheck")
	@ResponseBody
	public Map<String, Object> addCheck(@RequestBody DTO data){
		log.info("addCheck:"+data.toString());
		Map<String, Object> map = checkService.addCheck(data.getCheck(),data.getPic());
		return map;
	}
	
	@RequestMapping("getCheck")
	@ResponseBody
	public Map<String, Object> getCheck(@RequestBody DTO data){
		log.info("getCheck:"+data.toString());
		Map<String, Object> map = checkService.getCheck(data.getCheck(),data.getSize(),data.getCurrentPage());
		return map;
	}
	
	@RequestMapping("updateCheck")
	@ResponseBody
	public Map<String, Object> updateCheck(@RequestBody DTO data){
		log.info("updateCheck:"+data.toString());
		Map<String, Object> map = checkService.updateCheck(data.getCheck());
		return map;
	}
	
	@RequestMapping("deleteCheck")
	@ResponseBody
	public Map<String, Object> deleteCheck(@RequestBody DTO data){
		log.info("deleteCheck:"+data.toString());
		Map<String, Object> map = checkService.deleteCheck(data.getCheck().getCheckId());
		return map;
	}
}
