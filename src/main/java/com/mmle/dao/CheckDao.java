package com.mmle.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.springframework.stereotype.Repository;

import com.mmle.dynaSql.FishBoatDynaSql;
import com.mmle.entity.Check;
import com.mmle.entity.FishBoat;
import com.mmle.utils.DynaSqlProvider;

/**   
 * @Title: ChcekDao.java 
 * @Package com.mmle.dao 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author lbb
 * @date 2016年7月23日 下午10:05:37 
 * @version V1.0   
 */
@Repository
public interface CheckDao {

	@InsertProvider(type=DynaSqlProvider.class,method="addCheck")
	@Options(useGeneratedKeys=true,keyProperty="checkId")
	int addCheck(Check check);

	@Select("select * from tbl_check where type like concat('%', #{type}, '%') order by check_time limit ${offset},${size}")
	@Results({
		//这两个映射要看其他人的方法怎么写
		@Result(property="boat",column="boat",one=@One(select="com.mmle.dao.IFishBoatDao.selectFishBoatById")),
		@Result(property="cas",column="case_id",one=@One(select="com.mmle.dao.CaseDao.getCaseByCaseId")),
	})
	List<Check> getCheckByType(Map<String, Object> query);

	@Select("select * from tbl_check where title like concat('%', #{title}, '%') order by check_time limit ${offset},${size}")
	@Results({
		//这两个映射要看其他人的方法怎么写
		@Result(property="boat",column="boat",one=@One(select="com.mmle.dao.IFishBoatDao.selectFishBoatById")),
		@Result(property="cas",column="case_id",one=@One(select="com.mmle.dao.CaseDao.getCaseByCaseId")),
	})
	List<Check> getCheckByTitle(Map<String, Object> query);

	@Select("select * from tbl_check where check_man =#{checkMan} order by check_time limit ${offset},${size}")
	@Results({
		//这两个映射要看其他人的方法怎么写
		@Result(property="boat",column="boat",one=@One(select="com.mmle.dao.IFishBoatDao.selectFishBoatById")),
		@Result(property="cas",column="case_id",one=@One(select="com.mmle.dao.CaseDao.getCaseByCaseId")),
	})
	List<Check> getcheckByCheckMan(Map<String, Object> query);

	@Select("select count(*) from tbl_check where type like concat('%', #{type}, '%') ")
	int getCheckCountByType(String type);

	@Select("select count(*) from tbl_check where title like concat('%', #{title}, '%')")
	int getCheckCountByTitle(String title);

	@Select("select count(*) from tbl_check where check_man =#{account} ")
	int getcheckCountByCheckMan(String account);

	@Select("select * from tbl_check")
	@Results({
		//这两个映射要看其他人的方法怎么写
		@Result(property="boat",column="boat",one=@One(select="com.mmle.dao.IFishBoatDao.selectFishBoatById")),
		@Result(property="cas",column="case_id",one=@One(select="com.mmle.dao.CaseDao.getCaseByCaseId")),
	})
	List<Check> getAllCheck();

	@UpdateProvider(type=DynaSqlProvider.class,method="updateCheck")
	int updateCheck(Check check);

	@Delete("delete from tbl_check where check_id = #{checkId}")
	int deleteCheck(Integer checkId);
	
	@SelectProvider(type = DynaSqlProvider.class, method = "getCheck")
	@Results({
		//这两个映射要看其他人的方法怎么写
		@Result(property="boat",column="boat",one=@One(select="com.mmle.dao.IFishBoatDao.selectFishBoatById")),
		@Result(property="cas",column="case_id",one=@One(select="com.mmle.dao.CaseDao.getCaseByCaseId")),
	})
	List<Check> getCheck(Map<String, Object> query);

	@SelectProvider(type = DynaSqlProvider.class, method = "getCheckCountByCondition")
	Integer getCheckCountByCondition(Check check);
}
