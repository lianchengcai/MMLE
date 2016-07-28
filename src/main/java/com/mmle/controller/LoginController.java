package com.mmle.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mmle.entity.FishBoat;
import com.mmle.entity.User;
import com.mmle.service.UserService;
import com.mmle.utils.DTO;

@Controller
@RequestMapping(value="login")
public class LoginController {

	@Resource
	UserService userService;
	
	@RequestMapping(value="web")
	public @ResponseBody Map<String, Object> webLogin(@RequestBody DTO data,HttpServletRequest request)throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		
		User user = data.getUser();
		System.out.println(user.toString());
		String validateCode = data.getValidateCode();
		HttpSession session = request.getSession();
		String vc = (String)session.getAttribute("validateCode");
		
		if(!validateCode.equals(vc)){
			map.put("code", 0);
			map.put("msg", "验证码错误");
			System.out.println("验证码错误！");
			return map;
		}
		User u = userService.ifLogin(user);
		if(u!=null){
			map.put("code", 1);
			session.setAttribute("user", u);
			session.setAttribute("account", u.getAccount());
			session.setAttribute("roleId", u.getRole().getRoleId());
		}else{
			System.out.println("账号密码错误");
			map.put("code", 0);
			map.put("msg", "failure");
		}
		return map;
	}
	
	@RequestMapping(value="phone")
	public @ResponseBody Map<String, Object> phoneLogin(@RequestBody DTO data,HttpServletRequest request)throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		User user = data.getUser();
		User u = userService.ifLogin(user);
		if(u!=null){
			System.out.println(u.toString());
			map.put("code", 1);
			map.put("user", u);
		}else{
			System.out.println("账号密码错误");
			map.put("code", 0);
			map.put("msg", "failure");
		}
		return map;
	}
	
	
	@RequestMapping(value="session")
	public @ResponseBody Map<String, Object> getSession(HttpServletRequest request)throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println("请求session");
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		System.out.println(user.toString());
		map.put("user", user);
		return map;
	}
	
}
