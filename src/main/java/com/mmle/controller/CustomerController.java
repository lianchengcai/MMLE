package com.mmle.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.mail.Address;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.springframework.format.datetime.joda.ReadablePartialPrinter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mmle.entity.Customer;
import com.mmle.service.CustomerService;
import com.mmle.utils.DateJsonValueProcessor;

import net.sf.ezmorph.object.DateMorpher;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.JSONUtils;


@Controller
@RequestMapping(value="/customer")
public class CustomerController {

	@Resource
	private CustomerService customerService;

	@Resource
	private SessionDAO sessionDao;
	
	
	
	/**
	 * 通过手机号和密码登录
	 * @param telephone
	 * @param password
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/loginByPw", produces = "application/json;charset=utf-8")
	public @ResponseBody String loginByPw(@RequestBody String json,HttpServletResponse response){
		
		try {
			json = URLDecoder.decode(json, "utf-8");
			if(json.endsWith("=")){
				json = json.substring(0, json.length()-1);
			}
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		//跨域
		response.addHeader("Access-Control-Allow-Origin", "*");
		json = "{\"telephone\": \"151597969323\",\"password\": \"123456\"}";
		Map<String, Object> map = new HashMap<String, Object>();
		JSONObject jsonobject = JSONObject.fromObject(json);
		String telephone = jsonobject.getString("telephone");
		String password = jsonobject.getString("password");
		
		Customer customer = customerService.getLoginMessage(telephone,password);
		if(customer != null){
//			HttpSession session = request.getSession();
//			session.setAttribute("customer", customer);
			map.put("msg", "success");
			map.put("customer", customer);
		}else{
			map.put("msg", "failure");
		}
		
		JsonConfig config = new JsonConfig(); 
		config.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor("yyyy-MM-dd hh:mm:ss")); 
		JSONObject result = JSONObject.fromObject(map,config);
		
		return result.toString();
	}

	
//	@RequestMapping(value="loginByPw")
//	public @ResponseBody Map<String, Object> loginByPw(String telephone,String password,
//			HttpServletRequest request){
//		Map<String, Object> json = new HashMap<String, Object>();
//		return json;
//	}
}
