package com.mmle.dynaSql;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.scripting.xmltags.WhereSqlNode;

import com.mmle.entity.PenaltyDecision;
import com.mmle.entity.User;

/**
 * @Title: DynaSqlProvider.java
 * @Package com.mmle.dynaSql
 * @Description: 渔船的动态sql
 * @author clc
 * @date 2016年7月23日 下午1:45:32
 * @version V1.0
 */
public class PenaltyDecisionDynaSql {
	
	private static final String TABLE_NAME = "tbl_penalty_decision";  
	
	public String insertPenaltyDecision(final PenaltyDecision penaltyDecision) {
		return new SQL() {
			{
				INSERT_INTO(TABLE_NAME);
				if (penaltyDecision.getPartiesInformation() != null) {
					VALUES("parties_information", "#{partiesInformation}");
				}
				if (penaltyDecision.getViolateContent() != null) {
					VALUES("violate_content", "#{violateContent}");
				}
				if (penaltyDecision.getEvidence()!= null) {
					VALUES("evidence", "#{evidence}");
				}
				if (penaltyDecision.getViolateRule() != null) {
					VALUES("violate_rule", "#{violateRule}");
				}
				if (penaltyDecision.getBasis() != null) {
					VALUES("basis", "#{basis}");
				}
				if (penaltyDecision.getLocation() != null) {
					VALUES("location", "#{location}");
				}
				if (penaltyDecision.getDate() != null) {
					VALUES("date", "#{date}");
				}
				if (penaltyDecision.getLawEnforcementId() != null) {
					VALUES("law_enforcement_id", "#{lawEnforcementId}");
				}
				if (penaltyDecision.getFlag() != null) {
					VALUES("flag", "#{flag}");
				}
			}
		}.toString();
	}
	
	public String updatePenaltyDecision(final PenaltyDecision penaltyDecision){
		return new SQL() {
			{
				UPDATE(TABLE_NAME);
				if (penaltyDecision.getPartiesInformation() != null) {
					SET("parties_information = #{partiesInformation}");
				}
				if (penaltyDecision.getViolateContent() != null) {
					SET("violate_content = #{violateContent}");
				}
				if (penaltyDecision.getEvidence()!= null) {
					SET("evidence = #{evidence}");
				}
				if (penaltyDecision.getViolateRule() != null) {
					SET("violateRule = #{violateRule}");
				}
				if (penaltyDecision.getBasis() != null) {
					SET("basis = #{basis}");
				}
				if (penaltyDecision.getLocation() != null) {
					SET("location = #{location}");
				}
				if (penaltyDecision.getDate() != null) {
					SET("date = #{date}");
				}
				if (penaltyDecision.getLawEnforcementId() != null) {
					SET("law_enforcement_id = #{lawEnforcementId}");
				}
				if (penaltyDecision.getFlag() != null) {
					SET("flag = #{flag}");
				}
				WHERE("id = #{id}");
			}
		}.toString();
	}
	

}
