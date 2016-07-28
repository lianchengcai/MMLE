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
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.lang.ObjectUtils.Null;
import org.springframework.objenesis.instantiator.perc.PercInstantiator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.mmle.dao.CheckDao;
import com.mmle.dao.UserDao;
import com.mmle.entity.Case;
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

	public Map<String, Object> addCheck(Check check, MultipartFile[] pic,String path) {
		Map<String, Object> map = new HashMap<>();
		if (pic != null) {
			// 接收图片并保持在服务器
			ArrayList<Integer> arr = new ArrayList<>();
			System.out.println(pic.length);
			for (int i = 0; i < pic.length; i++) {
				MultipartFile file = pic[i];
				if (!file.isEmpty()) {
					InputStream in = null;
					OutputStream out = null;
					try {
						// String rootPath =
						// System.getProperty("catalina.home");
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
		}
		if (check.getState()==true) {
			Case cas = new Case();
			cas.setCaseId(1);
			check.setCas(cas);
		}
		if (checkDao.addCheck(check) == 1) {
			map.put("code", 1);
		} else {
			map.put("code", 0);
		}
		return map;
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
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
				if (check.getCheckMan() != null) {
					List<User> users = userDao.getUserByName(check.getCheckMan());
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
		if (check != null) {
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
		System.out.println(offset+" "+size);
		Integer rowCount = 0;
		Integer totalPage = 0;
		query.put("check", check);
		checks = checkDao.getCheck(query);
		map.put("code", 1);
		map.put("checks", checks);
		map.put("currentPage", currentPage);
		map.put("size", size);
		rowCount = checkDao.getCheckCountByCondition(check);
		if (rowCount % size != 0) {
			totalPage = rowCount / size + 1;
		} else {
			totalPage = rowCount / size;
		}
		map.put("totalPage", totalPage);
		return map;
	}

	@Override
	public Map<String, Object> addCheck1(Check check) {
		Map<String, Object> map = new HashMap<>();
		if (check.getState()==true) {
			Case cas = new Case();
			cas.setCaseId(1);
			check.setCas(cas);
		}
		if (checkDao.addCheck(check) == 1) {
			map.put("code", 1);
		} else {
			map.put("code", 0);
		}
		return map;
	}

//	@Override
//	public Map<String, Object> addCheck2(HttpServletRequest request) {
//		request.setCharacterEncoding("UTF-8");
//		request.setCharacterEncoding("UTF-8");
//		DiskFileItemFactory factory = new DiskFileItemFactory();
////		String path = "J:/upload";
//		
//		//String path="/home/penglian/tools/upload/image"; //上传文件存放目录linux下
//		String path=request.getServletContext().getRealPath("/images"); //上传文件存放目录windows下
//		String imagePath = "";
//		String date = "";
//		factory.setRepository(new File(path));
//		factory.setSizeThreshold(1024 * 1024);
//		ServletFileUpload upload = new ServletFileUpload(factory);
//
//		try {
//			// List<FileItem> list =
//			// (List<FileItem>)upload.parseRequest(request);
//			List<FileItem> list = (List<FileItem>) upload.parseRequest(request);
//			for (FileItem item : list) {
//				String name = item.getFieldName();
//				System.out.println("name:" + name);
//				if (item.isFormField()) {
//					String value = item.getString();
//					System.out.println("value:" + value);
//					date = value;
//					request.setAttribute(name, value);
//				} else {
//					String value = item.getName();
//					int start = value.lastIndexOf("\\");
//					String filename = value.substring(start + 1);
//					System.out.println("filename:" + filename);
//					imagePath = path + "/" + filename;
//					request.setAttribute(name, filename);
//
//					OutputStream out = new FileOutputStream(new File(path,
//							filename));
//					InputStream in = item.getInputStream();
//
//					int length = 0;
//					byte[] buf = new byte[1024];
//					System.out.println("文件大小:" + item.getSize());
//
//					while ((length = in.read(buf)) != -1) {
//						out.write(buf, 0, length);
//					}
//					in.close();
//					out.close();
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		System.out.println("imagePath" + imagePath);
//		Connection connection = null;
//		PreparedStatement statement = null;
//		int result = 0;
//		String sql = "update sendorder set image=" + "'" + imagePath + "'"
//				+ " where date=" + "'"+date+"'";
//		result = ConnectUpdate.coon_update(sql, connection, statement);
//		System.out.println("result:" + result);
//	}
//
//	}
	//}
}
