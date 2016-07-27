package com.mmle.dynaSql;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.scripting.xmltags.WhereSqlNode;

import com.mmle.entity.Exploration;
import com.mmle.entity.Role;
import com.mmle.entity.User;

/**
 * @Title: DynaSqlProvider.java
 * @Package com.mmle.dynaSql
 * @Description: 角色的动态sql
 * @author dsj
 * @date 2016年7月23日 下午1:45:32
 * @version V1.0
 */
public class RoleDynaSql {
	
	private static final String TABLE_NAME = "tbl_role";  
	
	public String insertRole(final Role role) {
		return new SQL() {
			{
				INSERT_INTO(TABLE_NAME);
				if (role.getName() != null) {
					VALUES("name", "#{name}");
				}
				if (role.getFlag() != null) {
					VALUES("flag", "#{flag}");
				}
			}
		}.toString();
	}
	
	public String updateRole(final Role role){
		return new SQL() {
			{
				UPDATE(TABLE_NAME);
				if (role.getName() != null) {
					SET("name= #{name}");
				}
				if (role.getPermissionId() != null) {
					SET("permission_id=#{permissionId}");
				}

				if (role.getFlag()!= null) {
					SET("flag=#{flag}");
				}
				WHERE("role_id = #{roleId}");
			}
		}.toString();
	}
}
