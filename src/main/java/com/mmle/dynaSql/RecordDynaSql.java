package com.mmle.dynaSql;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.scripting.xmltags.WhereSqlNode;

import com.mmle.entity.Record;
import com.mmle.entity.User;

/**
 * @Title: DynaSqlProvider.java
 * @Package com.mmle.dynaSql
 * @Description: 渔船的动态sql
 * @author clc
 * @date 2016年7月23日 下午1:45:32
 * @version V1.0
 */
public class RecordDynaSql {
	
	private static final String TABLE_NAME = "tbl_record";  
	
	public String insertRecord(final Record record) {
		return new SQL() {
			{
				INSERT_INTO(TABLE_NAME);
				if (record.getLocation() != null) {
					VALUES("location", "#{location}");
				}
				if (record.getStartDate() != null) {
					VALUES("start_date", "#{startDate}");
				}
				if (record.getEndDate() != null) {
					VALUES("end_date", "#{endDate}");
				}
				if (record.getAsk()!= null) {
					VALUES("ask", "#{ask}");
				}
				if (record.getRecorder() != null) {
					VALUES("recorder", "#{recorder}");
				}
				if (record.getDepartmentName() != null) {
					VALUES("department_name", "#{departmentName}");
				}
				if (record.getAccount() != null) {
					VALUES("account", "#{account}");
				}
				if (record.getViolateRule() != null) {
					VALUES("violate_rule", "#{violateRule}");
				}
				if (record.getContent() != null) {
					VALUES("content", "#{content}");
				}
				if (record.getAsked() != null) {
					VALUES("asked", "#{asked}");
				}
				if (record.getFeedbackOne() != null) {
					VALUES("feedback_one", "#{feedbackOne}");
				}
				if (record.getFeedbackTwo() != null) {
					VALUES("feedback_two", "#{feedbackTwo}");
				}
				if (record.getLawEnforcementId() != null) {
					VALUES("law_enforcement_id", "#{lawEnforcementId}");
				}
				if (record.getFlag() != null) {
					VALUES("flag", "#{flag}");
				}
			}
		}.toString();
	}
	
	public String updateRecord(final Record record){
		return new SQL() {
			{
				UPDATE(TABLE_NAME);
				if (record.getLocation() != null) {
					SET("location = #{location}");
				}
				if (record.getStartDate() != null) {
					SET("start_date = #{startDate}");
				}
				if (record.getEndDate() != null) {
					SET("end_date = #{endDate}");
				}
				if (record.getAsk()!= null) {
					SET("ask = #{ask}");
				}
				if (record.getRecorder() != null) {
					SET("recorder = #{recorder}");
				}
				if (record.getDepartmentName() != null) {
					SET("department_name = #{departmentName}");
				}
				if (record.getAccount() != null) {
					SET("account = #{account}");
				}
				if (record.getViolateRule() != null) {
					SET("violate_rule = #{violateRule}");
				}
				if (record.getContent() != null) {
					SET("content = #{content}");
				}
				if (record.getAsked() != null) {
					SET("asked = #{asked}");
				}
				if (record.getFeedbackOne() != null) {
					SET("feedback_one = #{feedbackOne}");
				}
				if (record.getFeedbackTwo() != null) {
					SET("feedback_two = #{feedbackTwo}");
				}
				if (record.getLawEnforcementId() != null) {
					SET("law_enforcement_id = #{lawEnforcementId}");
				}
				if (record.getFlag() != null) {
					SET("flag = #{flag}");
				}
				WHERE("id = #{id}");
			}
		}.toString();
	}
	

}
