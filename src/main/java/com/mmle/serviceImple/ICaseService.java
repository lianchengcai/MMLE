package com.mmle.serviceImple;

import java.util.Map;

import com.mmle.entity.Case;
import com.mmle.entity.CaseType;

/**   
 * @Title: ICaseService.java 
 * @Package com.mmle.serviceImple 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author lbb
 * @date 2016年7月23日 下午2:46:52 
 * @version V1.0   
 */
public interface ICaseService {
	public Map<String, Object> getCaseType();
	public Map<String, Object> addCaseInfo(Case cas);
	//public Map<String, Object> getCaseInfo(Case cas);
	public Map<String, Object> getCaseTypePage(CaseType caseType, Integer currentPage, Integer size);
	public Map<String, Object> deleteCaseInfo(Case cas);
	public Map<String, Object> updateCaseInfo(Case cas);
	public Map<String, Object> updateCaseType(CaseType caseType);
	public Map<String, Object> addCaseType(CaseType caseType);
	public Map<String, Object> deleteCaseType(CaseType caseType);
	public Map<String, Object> getCaseInfo(Case cas,Integer currentPage,Integer size);

}
