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
import com.mmle.service.UserService;
import com.mmle.utils.DTO;

import ch.qos.logback.classic.Logger;

/**   
 * @Title: UserController.java 
 * @Package com.mmle.controller 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author lbb
 * @date 2016年7月22日 下午9:52:38 
 * @version V1.0   
 */
@Controller
public class UserController {
	@Resource
	UserService userService;
	
	private static Logger log = (Logger) LoggerFactory.getLogger(UserController.class);

	@RequestMapping("/insertUser")
	@ResponseBody
	public Map<String, Object> insertUser(@RequestBody DTO data) {
		System.out.println("insertUser"+data.toString());
		Map<String, Object> map = userService.insertUser(data.getUser());
		return map;
		
	}
	
	@RequestMapping("/updateUser")
	@ResponseBody
	public Map<String, Object> updateUser(@RequestBody DTO data) {
		System.out.println("updateUser"+data.toString());
		Map<String, Object> map = userService.updateUser(data.getUser());
		return map;
		
	}
	
	@RequestMapping("/resetUser")
	@ResponseBody
	public Map<String, Object> resetUser(@RequestBody DTO data) {
		System.out.println("resetUser"+data.toString());
		data.getUser().setPassword("1234");
		Map<String, Object> map = userService.resetUser(data.getUser());
		return map;
		
	}
	
	@RequestMapping("/getAllUser")
	@ResponseBody
	public Map<String, Object> getAllUser() {
		Map<String, Object> map = userService.getAllUser();
		return map;
		
	}
	
	@RequestMapping("/getUser")
	@ResponseBody
	public Map<String, Object> getUser(@RequestBody DTO data) {
		Map<String, Object> map = userService.getUser(data.getUser().getAccount());
		return map;
		
	}
	
	@RequestMapping("/login")
	@ResponseBody
	public Map<String, Object> login(@RequestBody DTO data) {
		System.out.println("login"+data.toString());
		Map<String, Object> map = userService.login(data.getUser());
		return map;
	}
	
	@RequestMapping("/modifyUserPassword")
	@ResponseBody
	public Map<String, Object> modifyUserPassword(@RequestBody DTO data) {
		System.out.println("login"+data.toString());
		Map<String, Object> map = userService.modifyUserPassword(data.getUser());
		return map;
	}
	
}
