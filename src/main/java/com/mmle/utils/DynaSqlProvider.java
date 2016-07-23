package com.mmle.utils;

import org.apache.ibatis.jdbc.SQL;

import com.mmle.entity.Case;
import com.mmle.entity.CaseType;
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
	public String insertCaseType(final CaseType caseType) {
		return new SQL() {
			{
				INSERT_INTO("tbl_case_type");
				if (caseType.getName() != null) {
					VALUES("name", "#{name}");
				}
				if (caseType.getFlag()!= null) {
					VALUES("flag", "#{flag}");
				}
			}
		}.toString();
	}
	public String insertCase(final Case cas) {
		return new SQL() {
			{
				INSERT_INTO("tbl_case");
				if (cas.getBasisPunishment() != null) {
					VALUES("basis_punishment", "#{basisPunishment}");
				}
				if (cas.getCaseName() != null) {
					VALUES("case_name", "#{caseName}");
				}
				if (cas.getCaseType() != null) {
					VALUES("case_type", "#{caseType.typeId}");
				}
				if (cas.getState()!= null) {
					VALUES("state", "#{state}");
				}
				if (cas.getTypePunishment()!= null) {
					VALUES("type_punishment", "#{typePunishment}");
				}
				if (cas.getViolateRule()!= null) {
					VALUES("violate_rule", "#{violateRule}");
				}
				if (cas.getFlag()!= null) {
					VALUES("flag", "#{flag}");
				}
			}
		}.toString();
	}
	public String updateCaseInfo(final Case cas) {
		return new SQL() {
			{
				UPDATE("tbl_case");
				if (cas.getBasisPunishment()!= null) {
					SET("basis_punishment = #{basisPunishment}");
				}
				if (cas.getCaseName()!= null) {
					SET("case_name = #{caseName}");
				}
				if (cas.getCaseType() != null) {
					SET("case_type = #{caseType.typeId}");
				}
				if (cas.getTypePunishment() != null) {
					SET("type_punishment = #{typePunishment}");
				}
				if (cas.getState() != null) {
					SET("state = #{state}");
				}
				if (cas.getViolateRule() != null) {
					SET("violate_rule = #{violateRule}");
				}
				if (cas.getFlag() != null) {
					SET("flag = #{flag}");
				}
				WHERE("case_id = #{caseId}");
			}
		}.toString();
	}	
	public String updateCaseType(final CaseType caseType) {
		return new SQL() {
			{
				UPDATE("tbl_case_type");
				if (caseType.getName() != null) {
					SET("name = #{name}");
				}
				if (caseType.getFlag() != null) {
					SET("flag = #{flag}");
				}
				WHERE("type_id = #{typeId}");
			}
		}.toString();
	}	
}
