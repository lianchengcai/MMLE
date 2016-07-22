package com.mmle.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
