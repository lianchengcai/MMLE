package com.mmle.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mmle.entity.Case;
import com.mmle.entity.CaseType;
import com.mmle.service.CaseService;
import com.mmle.utils.DTO;

import ch.qos.logback.classic.Logger;

/**   
 * @Title: CaseController.java 
 * @Package com.mmle.controller 
 * @Description: TODO(执法案由控制层) 
 * @author lbb
 * @date 2016年7月23日 上午11:34:32 
 * @version V1.0   
 */
@Controller
public class CaseController {
	@Resource
	CaseService caseService;
	private static Logger log = (Logger) LoggerFactory.getLogger(CaseController.class);
	
	/**
	 * 
	 * @Title: getCaseType 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @return
	 * @param @throws Exception    设定文件 
	 * @return Map<String,Object>    返回类型 
	 * @throws
	 */
	@RequestMapping("getCaseType")
	@ResponseBody
	public Map<String, Object> getCaseType()throws Exception{
		Map<String, Object> map = caseService.getCaseType(); 
		return map;
	}
	
	@RequestMapping("getCaseInfo")
	@ResponseBody
	public Map<String, Object> getCaseInfo(@RequestBody DTO data)throws Exception{
		log.info("getCaseInfo:"+data.toString());
		Case cas = data.getCas();
		Map<String, Object> map = caseService.getCaseInfo(cas); 
		return map;
	}
	
	@RequestMapping("addCaseInfo")
	@ResponseBody
	public Map<String, Object> addCaseInfo(@RequestBody DTO data)throws Exception{
		log.info("addCaseInfo:"+data.toString());
		Case cas = data.getCas();
		Map<String, Object> map = caseService.addCaseInfo(cas); 
		return map;
	}
	
	@RequestMapping("addCaseType")
	@ResponseBody
	public Map<String, Object> addCaseType(@RequestBody DTO data)throws Exception{
		log.info("addCaseType:"+data.toString());
		CaseType caseType = data.getCaseType();
		Map<String, Object> map = caseService.addCaseType(caseType); 
		return map;
	}
	
	@RequestMapping("deleteCaseInfo")
	@ResponseBody
	public Map<String, Object> deleteCaseInfo(@RequestBody DTO data)throws Exception{
		log.info("deleteCaseInfo:"+data.toString());
		Case cas = data.getCas();
		Map<String, Object> map = caseService.deleteCaseInfo(cas); 
		return map;
	}
	
	@RequestMapping("deleteCaseType")
	@ResponseBody
	public Map<String, Object> deleteCaseType(@RequestBody DTO data)throws Exception{
		log.info("deleteCaseType:"+data.toString());
		CaseType caseType = data.getCaseType();
		Map<String, Object> map = caseService.deleteCaseType(caseType); 
		return map;
	}
	@RequestMapping("updateCaseInfo")
	@ResponseBody
	public Map<String, Object> updateCaseInfo(@RequestBody DTO data)throws Exception{
		log.info("updateCaseInfo:"+data.toString());
		Case cas = data.getCas();
		Map<String, Object> map = caseService.updateCaseInfo(cas); 
		return map;
	}
	
	@RequestMapping("updateCaseType")
	@ResponseBody
	public Map<String, Object> updateCaseType(@RequestBody DTO data)throws Exception{
		log.info("updateCaseType:"+data.toString());
		CaseType caseType = data.getCaseType();
		Map<String, Object> map = caseService.updateCaseType(caseType); 
		return map;
	}
}
