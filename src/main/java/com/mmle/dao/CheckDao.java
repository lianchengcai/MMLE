package com.mmle.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.mmle.entity.Check;
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
		@Result(property="boat",column="boat",one=@One(select="com.mmle.dao.FishBoat.getFishBoatById")),
		@Result(property="checkMan",column="check_man",one=@One(select="com.mmle.dao.UserDao.getUserById")),
	})
	List<Check> getCheckByType(Map<String, Object> query);

	@Select("select * from tbl_check where title like concat('%', #{title}, '%') order by check_time limit ${offset},${size}")
	@Results({
		//这两个映射要看其他人的方法怎么写
		@Result(property="boat",column="boat",one=@One(select="com.mmle.dao.FishBoat.getFishBoatById")),
		@Result(property="checkMan",column="check_man",one=@One(select="com.mmle.dao.UserDao.getUserById")),
	})
	List<Check> getCheckByTitle(Map<String, Object> query);

	@Select("select * from tbl_check where check_man =#{checkMan} order by check_time limit ${offset},${size}")
	@Results({
		//这两个映射要看其他人的方法怎么写
		@Result(property="boat",column="boat",one=@One(select="com.mmle.dao.FishBoat.getFishBoatById")),
		@Result(property="checkMan",column="check_man",one=@One(select="com.mmle.dao.UserDao.getUserById")),
	})
	List<Check> getcheckByCheckMan(Map<String, Object> query);

	@Select("select count(*) from tbl_check where type like concat('%', #{type}, '%') ")
	int getCheckCountByType(Integer type);

	@Select("select * from tbl_check where title like concat('%', #{title}, '%')")
	int getCheckCountByTitle(String title);

	@Select("select * from tbl_check where check_man =#{account} ")
	int getcheckCountByCheckMan(String account);

	@Select("select * from tbl_check")
	@Results({
		//这两个映射要看其他人的方法怎么写
		@Result(property="boat",column="boat",one=@One(select="com.mmle.dao.FishBoat.getFishBoatById")),
		@Result(property="checkMan",column="check_man",one=@One(select="com.mmle.dao.UserDao.getUserById")),
	})
	List<Check> getAllCheck();

}
