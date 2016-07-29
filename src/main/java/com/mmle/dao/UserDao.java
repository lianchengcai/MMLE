package com.mmle.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.mmle.dynaSql.RoleDynaSql;
import com.mmle.dynaSql.UserDynaSql;
import com.mmle.entity.User;
import com.mmle.utils.DynaSqlProvider;


/**   
 * @Title: UserDao.java 
 * @Package com.mmle.dao 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author lbb
 * @date 2016年7月22日 下午9:39:20 
 * @version V1.0   
 */
@Repository
public interface UserDao {
	@InsertProvider(type = UserDynaSql.class, method = "insertUser")
	int insertUser(User user);

	@Select("select * from tbl_user where name like concat('%', #{name}, '%')")
	List<User> getUserByName(String name);

	@Select("select * from tbl_user where account=#{account} and password=#{password}")
	User login(User user);
	
	@Select("select * from tbl_user where flag=1 and role_id=2")
	@Results({
		@Result(property="role",column="role_id",one=@One(select="com.mmle.dao.IRoleDao.getRole")),
	})
	List<User> getAllUser();

	@InsertProvider(type = UserDynaSql.class, method = "updateUser")
	int updateUser(User user);

	@Select("select * from tbl_user where account=#{account}")
	@Results({
		@Result(property="role",column="role_id",one=@One(select="com.mmle.dao.IRoleDao.getRole")),
	})
	User getUser(String account);

	@Select("select * from  tbl_user where  flag=1 order by account limit ${offset},${size}")
	@Results({
		@Result(property="role",column="role_id",one=@One(select="com.mmle.dao.IRoleDao.getRole")),
	})
	List<User> getUserPage(Map<String, Object> query);

	@Select("select count(*) from  tbl_user where flag=1")
	Integer getAllCount();
}
