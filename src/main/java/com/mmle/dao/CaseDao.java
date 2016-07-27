package com.mmle.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.springframework.stereotype.Repository;

import com.mmle.entity.Case;
import com.mmle.entity.CaseType;
import com.mmle.entity.Check;
import com.mmle.utils.DynaSqlProvider;


/**   
 * @Title: CaseDao.java 
 * @Package com.mmle.dao 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author lbb
 * @date 2016年7月23日 上午11:44:03 
 * @version V1.0   
 */
@Repository
public interface CaseDao {

	@Select("select * from tbl_case_type where flag=1")
	List<CaseType> getCaseType();
	
	@Select("select * from tbl_case_type where type_id = #{id} and flag=1")
	List<CaseType> getCaseTypeById(Integer id);


//	@Select("select * from tbl_case and flag=1")
//	@Results({
//		@Result(property="caseType",column="case_type",one=@One(select="com.mmle.dao.CaseDao.getCaseTypeById")),
//	})
//	List<Case> getCase();
//	
	
	@SelectProvider(type = DynaSqlProvider.class, method = "getCase")
	@Results({
		@Result(property="caseType",column="case_type",one=@One(select="com.mmle.dao.CaseDao.getCaseTypeById")),
	})
	List<Case> getCase(Map<String, Object> query);

	@Select("select count(*) from tbl_case where case_type = #{typeId} and flag=1")
	Integer getCaseTypeCountById(Integer typeId);


	@Select("select * from tbl_case where case_type = #{caseType} and flag=1")
	@Results({
		@Result(property="caseType",column="case_type",one=@One(select="com.mmle.dao.CaseDao.getCaseTypeById")),
	})
	List<Case> getCaseByTypeId(Integer caseType);

	@Select("select * from tbl_case_type where name = #{name} and flag=1")
	CaseType getCaseTypeByName(String name);

	@Select("select * from tbl_case where case_name = #{caseName} and flag=1")
	@Results({
		@Result(property="caseType",column="case_type",one=@One(select="com.mmle.dao.CaseDao.getCaseTypeById")),
	})
	List<Case> getCaseByName(String caseName);

	@InsertProvider(type=DynaSqlProvider.class,method="insertCaseType")
	@Options(useGeneratedKeys=true,keyProperty="typeId")
	int insertCaseType(CaseType caseType);

	@InsertProvider(type=DynaSqlProvider.class,method="insertCase")
	@Options(useGeneratedKeys=true,keyProperty="caseId")
	int insertCase(Case cas);

	@Select("select * from  tbl_case where case_id = #{caseId} and flag=1")
	@Results({
		@Result(property="caseType",column="case_type",one=@One(select="com.mmle.dao.CaseDao.getCaseTypeById")),
	})
	Case getCaseByCaseId(Integer caseId);

	@Delete("delete from tbl_case where case_id = #{caseId} ")
	int deleteCaseInfo(Integer caseId);
	
	@UpdateProvider(type=DynaSqlProvider.class,method="updateCaseInfo")
	int updateCaseInfo(Case cas);
	
	@UpdateProvider(type=DynaSqlProvider.class,method="updateCaseType")
	int updateCaseType(CaseType caseType);

	@Delete("delete from tbl_case_type where type_id = #{typeId} ")
	int deleteCaseTypeById(Integer typeId);

	@SelectProvider(type = DynaSqlProvider.class, method = "getCaseInfoByCondition")
	Integer getCaseInfoByCondition(Case cas);

	@Select("select count(*) from  tbl_case_type where flag=1")
	Integer getAllCount();

	@Select("select * from  tbl_case_type where  flag=1 order by type_id limit ${offset},${size}")
	@Results({
		@Result(property="caseType",column="case_type",one=@One(select="com.mmle.dao.CaseDao.getCaseTypeById")),
	})
	List<CaseType> getCaseTypePage(Map<String, Object> query);
	
}
