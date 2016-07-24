package com.mmle.serviceImple;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.mmle.entity.Check;

/**   
 * @Title: ICheckService.java 
 * @Package com.mmle.serviceImple 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author lbb
 * @date 2016年7月23日 下午10:04:50 
 * @version V1.0   
 */
public interface ICheckService {
	public Map<String, Object> addCheck(Check check, MultipartFile[] multipartFiles);

	public Map<String, Object> getCheck(Check check, Integer size, Integer currentPage);

	public Map<String, Object> updateCheck(Check check);

	public Map<String, Object> deleteCheck(Check check);
	
	public Map<String, Object> getCheck2(Check check, Integer size, Integer currentPage);


}
