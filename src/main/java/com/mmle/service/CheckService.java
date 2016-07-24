package com.mmle.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.ObjectUtils.Null;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mmle.dao.CheckDao;
import com.mmle.dao.UserDao;
import com.mmle.entity.Check;
import com.mmle.entity.User;
import com.mmle.serviceImple.ICheckService;

/**   
 * @Title: CheckService.java 
 * @Package com.mmle.service 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author lbb
 * @date 2016年7月23日 下午10:04:29 
 * @version V1.0   
 */
@Service
public class CheckService implements ICheckService{
	@Resource
	CheckDao checkDao;
	@Resource 
	UserDao userDao;
	public Map<String, Object> addCheck(Check check,MultipartFile[] multipartFiles) {
		Map<String, Object> map = new HashMap<>();
		//如果上传的照片不为空
		if (multipartFiles!=null) {
			for (int i = 0; i < multipartFiles.length; i++) {
		//		MultipartFile file = 
			}
		}
	
		if (checkDao.addCheck(check)==1) {
			map.put("code", 1);
		}else {
			map.put("code", 0);
		}
		return map;
	}

	@Override
	public Map<String, Object> getCheck(Check check, Integer size, Integer currentPage) {
		currentPage = currentPage != null ?currentPage:1;
		size = size != null ? size : 10;
		int offset = (currentPage - 1) * size;
		Map<String, Object> map = new HashMap<>();
		List<Check> checks = new ArrayList<>();
		Map<String, Object> query = new HashMap<>();
		query.put("offset", offset);
		query.put("size", size);
		int rowCount = 0;
		if (check!=null) {
			if (check.getType()!=null) {
				query.put("type", check.getType());
				checks = checkDao.getCheckByType(query);
				rowCount = checkDao.getCheckCountByType(check.getType());
			}
			if (check.getTitle()!=null) {
				query.put("title", check.getTitle());
				checks = checkDao.getCheckByTitle(query);
				rowCount = checkDao.getCheckCountByTitle(check.getTitle());
			}
			if (check.getCheckMan()!=null) {
				if (check.getCheckMan().getName()!=null) {
					List<User> users = userDao.getUserByName(check.getCheckMan().getName());
					for (User user : users) {
						query.put("checkMan", user.getAccount());
						checks = checkDao.getcheckByCheckMan(query);
						rowCount = checkDao.getcheckCountByCheckMan(user.getAccount());
					}
				}
			}
		}else {
			checks = checkDao.getAllCheck();
			rowCount = checks.size();
		}
		map.put("code", 0);
		map.put("checks", checks);
		map.put("currentPage", currentPage);
		map.put("size", size);
		map.put("totalPage", rowCount);
		return map;
	}

	@Override
	public Map<String, Object> updateCheck(Check check) {
		Map<String, Object> map = new HashMap<>();
		if (check!=null) {
			if (checkDao.updateCheck(check)==1) {
				map.put("code", 1);
			}else {
				map.put("code", 0);
			}
		}else{
			map.put("code", 0);
		}
		return map;
	}

	@Override
	public Map<String, Object> deleteCheck(Integer checkId) {
		Map<String, Object> map = new HashMap<>();
		if (checkId!=null) {
			if (checkDao.deleteCheck(checkId)==1) {
				map.put("code", 1);
			}else {
				map.put("code", 0);
			}
		}else {
			map.put("code", 0);
		}
		return map;
	}

}
