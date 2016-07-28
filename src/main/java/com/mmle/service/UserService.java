package com.mmle.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mmle.dao.UserDao;
import com.mmle.entity.Role;
import com.mmle.entity.User;
import com.mmle.serviceImple.IUserService;
import com.mmle.utils.SaltUtils;

/**
 * @Title: UserService.java
 * @Package com.mmle.service
 * @Description: TODO(用一句话描述该文件做什么)
 * @author lbb
 * @date 2016年7月22日 下午9:52:09
 * @version V1.0
 */
@Service
public class UserService implements IUserService {
	@Resource
	UserDao userDao;

	/**
	 * 新增用户
	 * 
	 * @param user
	 * @return
	 */
	public Map<String, Object> insertUser(User user) {
		String salt=SaltUtils.getRandomSalt();
		user.setSalt(salt);
		user.setPassword(SaltUtils.getMd5Password(user.getPassword(), salt));
		Map<String, Object> map = new HashMap<>();
		if (userDao.getUser(user.getAccount()) != null) {
			map.put("code", "101");
			return map;
		}
		if (userDao.insertUser(user) == 1) {
			map.put("code", 1);
		} else {
			map.put("code", 0);
		}
		return map;
	}

	/**
	 * 用户登录
	 * 
	 * @param user
	 * @return
	 */
	public Map<String, Object> login(User form) {
		Map<String, Object> map = new HashMap<>();
		User user = userDao.getUser(form.getAccount());
		if (user == null) {
			map.put("code", 0);
			return map;
		} 
		String salt=user.getSalt();
		if(!("".equalsIgnoreCase(salt)|| null==salt)){
			user.setPassword(SaltUtils.getMd5Password(form.getPassword(), salt));
		}
		if (userDao.login(user) != null) {
			map.put("code", 1);
		} else {
			map.put("code", 0);
		}
		return map;
	}

	/**
	 * 返回用户列表
	 * 
	 * @return
	 */
	public Map<String, Object> getAllUser() {
		Map<String, Object> map = new HashMap<>();
		List<User> users = userDao.getAllUser();
		map.put("users", users);
		return map;
	}

	/**
	 * 更新、伪删除用户
	 * 
	 * @param user
	 * @return
	 */
	public Map<String, Object> updateUser(User user) {
		Map<String, Object> map = new HashMap<>();
		if (userDao.updateUser(user) == 1) {
			map.put("code", 1);
		} else {
			map.put("code", 0);
		}
		return map;
	}
	
	public Map<String, Object> resetUser(User user) {
		String salt=SaltUtils.getRandomSalt();
		user.setSalt(salt);
		user.setPassword(SaltUtils.getMd5Password(user.getPassword(), salt));
		Map<String, Object> map = new HashMap<>();
		if (userDao.updateUser(user) == 1) {
			map.put("code", 1);
		} else {
			map.put("code", 0);
		}
		return map;
	}

	/**
	 * 根据工号获取指定用户信息
	 * 
	 * @param account
	 * @return
	 */
	public Map<String, Object> getUser(String account) {
		Map<String, Object> map = new HashMap<>();
		User user = userDao.getUser(account);
		map.put("user", user);
		return map;
	}

	public Map<String, Object> modifyUserPassword(User user) {
		Map<String, Object> map = new HashMap<>();
		String salt=SaltUtils.getRandomSalt();
		user.setSalt(salt);
		user.setPassword(SaltUtils.getMd5Password(user.getPassword(), salt));
		if (userDao.updateUser(user) == 1) {
			map.put("code", 1);
		} else {
			map.put("code", 0);
		}
		return map;
	}

	public User ifLogin(User user) {
		User u =userDao.getUser(user.getAccount());
		if(u == null)return null;
		String salt = u.getSalt();
		String paw =SaltUtils.getMd5Password(user.getPassword(), salt);
		System.out.println(paw);
		System.out.println(u.getPassword());
		if(paw.equals(u.getPassword())){
			u.setPassword("");
			u.setSalt("");
			return u;
		}
		return null;
	}

	public Map<String, Object> getUserPage(Integer currentPage, Integer size) {
		Map<String, Object> map = new HashMap<>();
		currentPage = currentPage != null ? currentPage : 1;
		size = size != null ? size : 10;
		Integer offset = (currentPage - 1) * size;
		Map<String, Object> query = new HashMap<>();
		query.put("offset", offset);
		query.put("size", size);
		Integer rowCount = 0;
		Integer totalPage = 0;
		List<User> users=userDao.getUserPage(query);
		rowCount = userDao.getAllCount();
		map.put("code", 1);
		map.put("users", users);
		map.put("currentPage", currentPage);
		map.put("size", size);
		if (rowCount % size != 0) {
			totalPage = rowCount / size + 1;
		} else {
			totalPage = rowCount / size;
		}
		map.put("totalPage", totalPage);
		return map;
	}

}
