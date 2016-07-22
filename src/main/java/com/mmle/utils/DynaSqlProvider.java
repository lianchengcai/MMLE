package com.mmle.utils;

import org.apache.ibatis.jdbc.SQL;

import com.mmle.entity.User;

/**
 * @Title: DynaSqlProvider.java
 * @Package com.mmle.utils
 * @Description: TODO(用一句话描述该文件做什么)
 * @author lbb
 * @date 2016年7月22日 下午7:30:24
 * @version V1.0
 */
public class DynaSqlProvider {
	public String insertUser(final User user) {
		return new SQL() {
			{
				INSERT_INTO("tbl_user");
				if (user.getName() != null) {
					VALUES("name", "#{name}");
				}
				if (user.getAccount() != null) {
					VALUES("account", "#{account}");
				}
				if (user.getPassword() != null) {
					VALUES("password", "#{password}");
				}
				if (user.getRoleId()!= null) {
					VALUES("role_id", "#{roleId}");
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

}
