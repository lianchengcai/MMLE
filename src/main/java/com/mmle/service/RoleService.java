package com.mmle.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mmle.dao.IRoleDao;
import com.mmle.dao.UserDao;
import com.mmle.entity.Role;
import com.mmle.entity.User;
import com.mmle.serviceImple.IUserService;

/**
 * @Title: RoleService.java
 * @Package com.mmle.service
 * @Description: TODO(用一句话描述该文件做什么)
 * @author dsj
 * @date 2016年7月25日 下午23:52:09
 * @version V1.0
 */
@Service
public class RoleService implements IUserService {
	@Resource
	IRoleDao iRoleDao;

	/**
	 * 新增角色
	 * @param role
	 * @return
	 */
	public Map<String, Object> insertRole(Role role) {
		Map<String, Object> map = new HashMap<>();
		if (iRoleDao.insertRole(role) == 1) {
			map.put("code", 1);
		} else {
			map.put("code", 0);
		}
		return map;
	}


	/**
	 * 返回用角色列表
	 * @return
	 */
	public Map<String, Object> getAllRole() {
		Map<String,Object> map = new HashMap<>();
		List<Role> roles = iRoleDao.getAllRole();
		map.put("roles", roles);
		return map;
	}


	/**
	 * 更新、伪删除角色
	 * @param user
	 * @return
	 */
	public Map<String, Object> updateRole(Role role) {
		Map<String, Object> map = new HashMap<>();
		if (iRoleDao.updateRole(role)==1) {
			map.put("code", 1);
		}else {
			map.put("code", 0);
		}
		return map;
	}


	/**
	 * 根据角色主键获取指定角色
	 * @param account
	 * @return
	 */
	public Map<String, Object> getRole(int roleId) {
		Map<String,Object> map = new HashMap<>();
		Role role=iRoleDao.getRole(roleId);
		map.put("role", role);
		return map;
	}

}
