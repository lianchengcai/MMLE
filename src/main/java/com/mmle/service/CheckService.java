package com.mmle.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
public class CheckService implements ICheckService {
	@Resource
	CheckDao checkDao;
	@Resource
	UserDao userDao;

	public Map<String, Object> addCheck(Check check, MultipartFile[] pic) {
		Map<String, Object> map = new HashMap<>();
		// 接收图片并保持在服务器
		String path = "F:/tomcatImg";
		ArrayList<Integer> arr = new ArrayList<>();
		System.out.println(pic.length);
		for (int i = 0; i < pic.length; i++) {
			MultipartFile file = pic[i];
			if (!file.isEmpty()) {
				InputStream in = null;
				OutputStream out = null;
				try {
					// String rootPath = System.getProperty("catalina.home");
					File dir = new File(path);
					if (!dir.exists())
						dir.mkdirs();
					String newFileName = dir.getAbsolutePath() + File.separator + file.getOriginalFilename();
					// 文件名********************
					File serverFile = new File(newFileName);
					if (i == 1) {
						check.setBoatImage(newFileName);
					}
					if (i == 2) {
						check.setManImage(newFileName);
					}
					in = file.getInputStream();
					out = new FileOutputStream(serverFile);
					System.out.println(serverFile.getAbsolutePath());
					byte[] b = new byte[1024];
					int len = 0;
					while ((len = in.read(b)) > 0) {
						out.write(b, 0, len);
					}
					out.close();
					in.close();
				} catch (Exception e) {
					arr.add(i);
				} finally {
					if (out != null) {
						try {
							out.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						out = null;
					}
					if (in != null) {
						try {
							in.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						in = null;
					}
				}
			} else {
				arr.add(i);
			}
		}
		if (checkDao.addCheck(check) == 1) {
			map.put("code", 1);
		} else {
			map.put("code", 0);
		}
		return map;
	}

	@Override
	public Map<String, Object> getCheck(Check check, Integer size, Integer currentPage) {
		currentPage = currentPage != null ? currentPage : 1;
		size = size != null ? size : 10;
		int offset = (currentPage - 1) * size;
		Map<String, Object> map = new HashMap<>();
		List<Check> checks = new ArrayList<>();
		Map<String, Object> query = new HashMap<>();
		query.put("offset", offset);
		query.put("size", size);
		int rowCount = 0;
		if (check != null) {
			if (check.getType() != null) {
				query.put("type", check.getType());
				checks = checkDao.getCheckByType(query);
				rowCount = checkDao.getCheckCountByType(check.getType());
			}
			if (check.getTitle() != null) {
				query.put("title", check.getTitle());
				checks = checkDao.getCheckByTitle(query);
				rowCount = checkDao.getCheckCountByTitle(check.getTitle());
			}
			if (check.getCheckMan() != null) {
				if (check.getCheckMan().getName() != null) {
					List<User> users = userDao.getUserByName(check.getCheckMan().getName());
					for (User user : users) {
						query.put("checkMan", user.getAccount());
						checks = checkDao.getcheckByCheckMan(query);
						rowCount = checkDao.getcheckCountByCheckMan(user.getAccount());
					}
				}
			}
		} else {
			checks = checkDao.getAllCheck();
			rowCount = checks.size();
		}
		map.put("code", 1);
		map.put("checks", checks);
		map.put("currentPage", currentPage);
		map.put("size", size);
		map.put("totalPage", rowCount);
		return map;
	}

	@Override
	public Map<String, Object> updateCheck(Check check) {
		Map<String, Object> map = new HashMap<>();
		if (check != null) {
			if (checkDao.updateCheck(check) == 1) {
				map.put("code", 1);
			} else {
				map.put("code", 0);
			}
		} else {
			map.put("code", 0);
		}
		return map;
	}

	@Override
	public Map<String, Object> deleteCheck(Check check) {
		Map<String, Object> map = new HashMap<>();
		if (check!= null) {
			check.setFlag(false);
			if (checkDao.updateCheck(check) == 1) {
				map.put("code", 1);
			} else {
				map.put("code", 0);
			}
		} else {
			map.put("code", 0);
		}
		return map;
	}

	@Override
	public Map<String, Object> getCheck2(Check check, Integer size, Integer currentPage) {
		currentPage = currentPage != null ? currentPage : 1;
		size = size != null ? size : 10;
		Integer offset = (currentPage - 1) * size;
		Map<String, Object> map = new HashMap<>();
		List<Check> checks = new ArrayList<>();
		Map<String, Object> query = new HashMap<>();
		query.put("offset", offset);
		query.put("size", size);
		Integer rowCount = 0;
		query.put("check", check);
		checks = checkDao.getCheck(query);
		rowCount = checks.size();
		map.put("code", 1);
		map.put("checks", checks);
		map.put("currentPage", currentPage);
		map.put("size", size);
		map.put("totalPage", rowCount);
		return map;
	}

}
