package com.mmle.dynaSql;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.scripting.xmltags.WhereSqlNode;

import com.mmle.entity.Exploration;
import com.mmle.entity.User;

/**
 * @Title: DynaSqlProvider.java
 * @Package com.mmle.dynaSql
 * @Description: 用户的动态sql
 * @author dsj
 * @date 2016年7月23日 下午1:45:32
 * @version V1.0
 */
public class UserDynaSql {
	
	private static final String TABLE_NAME = "tbl_user";  
	
	public String insertUser(final User user) {
		return new SQL() {
			{
				INSERT_INTO(TABLE_NAME);
				if (user.getName() != null) {
					VALUES("name", "#{name}");
				}
				if (user.getAccount() != null) {
					VALUES("account", "#{account}");
				}
				if (user.getPassword() != null) {
					VALUES("password", "#{password}");
				}
				if (user.getRole()!= null) {
					VALUES("role_id", "#{role.roleId}");
				}
				if (user.getRemark()!= null) {
					VALUES("remark", "#{remark}");
				}
				if (user.getSalt()!= null) {
					VALUES("salt", "#{salt}");
				}
				if (user.getFlag()!= null) {
					VALUES("flag", "#{flag}");
				}
				
			}
		}.toString();
	}
	
	public String updateUser(final User user){
		return new SQL() {
			{
				UPDATE(TABLE_NAME);
				if (user.getName() != null) {
					SET("name= #{name}");
				}
				if (user.getPassword() != null) {
					SET("password=#{password}");
				}
				if (user.getRole()!= null) {
					SET("role_id=#{role.roleId}");
				}
				if (user.getRemark()!= null) {
					SET("remark=#{remark}");
				}
				if (user.getSalt()!= null) {
					SET("salt=#{salt}");
				}
				if (user.getFlag()!= null) {
					SET("flag=#{flag}");
				}
				WHERE("account = #{account}");
			}
		}.toString();
	}
}
