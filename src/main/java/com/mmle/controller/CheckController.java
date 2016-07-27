package com.mmle.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.mmle.entity.Check;
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
	
	private static Logger log = (Logger) LoggerFactory.getLogger(CheckController.class);

	@RequestMapping("addCheck")
	@ResponseBody
	public Map<String, Object> addCheck(@RequestBody DTO data,@RequestParam MultipartFile[] pic,HttpServletRequest request){
		log.info("addCheck:"+data.toString()+pic.toString());
		String path = request.getServletContext().getRealPath("/images");
		Map<String, Object> map = checkService.addCheck(data.getCheck(),pic,path);
		return map;
	}
	
	@RequestMapping("getCheck")
	@ResponseBody
	public Map<String, Object> getCheck(@RequestBody DTO data){
		log.info("getCheck:"+data.toString());
		Map<String, Object> map = checkService.getCheck2(data.getCheck(),data.getSize(),data.getCurrentPage());
		log.info("getCheck:"+map);
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
		Map<String, Object> map = checkService.deleteCheck(data.getCheck());
		return map;
	}
}
