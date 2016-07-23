package com.mmle.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mmle.dao.UserDao;
import com.mmle.entity.User;
import com.mmle.serviceImple.IUserService;

/**   
 * @Title: UserService.java 
 * @Package com.mmle.service 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author lbb
 * @date 2016年7月22日 下午9:52:09 
 * @version V1.0   
 */
@Service
public class UserService implements IUserService{
	@Resource
	UserDao userDao;
	
	public Map<String, Object> insertUser(User user) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<>();
		if (user!=null) {
			if (userDao.insertUser(user)==1) {
				map.put("code", 1);
			}
		}else {
			map.put("code", 0);
		}
		return map;
	}
	
}
