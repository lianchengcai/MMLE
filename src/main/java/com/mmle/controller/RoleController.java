package com.mmle.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mmle.entity.User;
import com.mmle.service.RoleService;
import com.mmle.service.UserService;
import com.mmle.utils.DTO;

import ch.qos.logback.classic.Logger;

/**   
 * @Title: RoleController.java 
 * @Package com.mmle.controller 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author dsj
 * @date 2016年7月25日 下午23:06:38 
 * @version V1.0   
 */
@Controller
public class RoleController {
	@Resource
	RoleService roleService;
	
	private static Logger log = (Logger) LoggerFactory.getLogger(RoleController.class);

	@RequestMapping("/insertRole")
	@ResponseBody
	public Map<String, Object> insertUser(@RequestBody DTO data) {
		System.out.println("insertRole"+data.toString());
		Map<String, Object> map = roleService.insertRole(data.getRole());
		return map;
		
	}
	
	@RequestMapping("/updateRole")
	@ResponseBody
	public Map<String, Object> updateUser(@RequestBody DTO data) {
		System.out.println("updateUser"+data.toString());
		Map<String, Object> map = roleService.updateRole(data.getRole());
		return map;
		
	}
	
	@RequestMapping("/getAllRole")
	@ResponseBody
	public Map<String, Object> getAllRole() {
		Map<String, Object> map =roleService.getAllRole();
		return map;
		
	}
	
	@RequestMapping("/getRole")
	@ResponseBody
	public Map<String, Object> getRole(@RequestBody DTO data) {
		Map<String, Object> map =roleService.getRole(data.getRole().getRoleId());
		return map;
		
	}
	
	@RequestMapping("getRolePage")
	@ResponseBody
	public Map<String, Object> getCaseTypePage(@RequestBody DTO data)throws Exception{
		Map<String, Object> map = roleService.getRolePage(data.getCurrentPage(),data.getSize()); 
		return map;
	}
	
}
