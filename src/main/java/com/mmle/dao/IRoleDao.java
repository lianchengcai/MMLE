package com.mmle.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.mmle.dynaSql.RoleDynaSql;
import com.mmle.entity.Role;
import com.mmle.entity.User;
import com.mmle.utils.DynaSqlProvider;


/**   
 * @Title: IRoleDao.java 
 * @Package com.mmle.dao 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author dsj
 * @date 2016年7月25日 下午23:39:20 
 * @version V1.0   
 */
@Repository
public interface IRoleDao {
	@InsertProvider(type = RoleDynaSql.class, method = "insertRole")
	int insertRole(Role role);
	
	@Select("select * from tbl_role where flag=1")
	List<Role> getAllRole();

	@InsertProvider(type = RoleDynaSql.class, method = "updateRole")
	int updateRole(Role role);

	@Select("select * from tbl_role where role_id=#{roleId}")
	Role getRole(int roleId);

	@Select("select * from  tbl_role where  flag=1 order by role_id limit ${offset},${size}")
	List<Role> getRolePage(Map<String, Object> query);

	@Select("select count(*) from  tbl_role where flag=1")
	Integer getAllCount();
}
