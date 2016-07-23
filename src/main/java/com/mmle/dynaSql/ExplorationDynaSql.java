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
 * @Description: 渔船的动态sql
 * @author clc
 * @date 2016年7月23日 下午1:45:32
 * @version V1.0
 */
public class ExplorationDynaSql {
	
	private static final String TABLE_NAME = "tbl_exploration";  
	
	public String insertExploration(final Exploration exploration) {
		return new SQL() {
			{
				INSERT_INTO(TABLE_NAME);
				if (exploration.getExplorationStartTime() != null) {
					VALUES("exploration_start_time", "#{explorationStartTime}");
				}
				if (exploration.getExplorationEndTime() != null) {
					VALUES("exploration_end_time", "#{explorationEndTime}");
				}
				if (exploration.getExplorationLocation()!= null) {
					VALUES("exploration_location", "#{explorationLocation}");
				}
				if (exploration.getParties() != null) {
					VALUES("parties", "#{parties}");
				}
				if (exploration.getSituation() != null) {
					VALUES("situation", "#{situation}");
				}
				if (exploration.getAccount() != null) {
					VALUES("account", "#{account}");
				}
				if (exploration.getLawEnforcementId() != null) {
					VALUES("law_enforcement_id", "#{lawEnforcementId}");
				}
				if (exploration.getState() != null) {
					VALUES("fish_permit_time", "#{fishPermitTime}");
				}
				if (exploration.getWitnesses() != null) {
					VALUES("witnesses", "#{witnesses}");
				}
				if (exploration.getFlag() != null) {
					VALUES("flag", "#{flag}");
				}
				
			}
		}.toString();
	}
	
	public String updateExploration(final Exploration exploration){
		return new SQL() {
			{
				UPDATE(TABLE_NAME);
				if (exploration.getExplorationStartTime() != null) {
					SET("exploration_start_time = #{explorationStartTime}");
				}
				if (exploration.getExplorationEndTime() != null) {
					SET("exploration_end_time = #{explorationEndTime}");
				}
				if (exploration.getExplorationLocation()!= null) {
					SET("exploration_location = #{explorationLocation}");
				}
				if (exploration.getParties() != null) {
					SET("parties = #{parties}");
				}
				if (exploration.getSituation() != null) {
					SET("situation = #{situation}");
				}
				if (exploration.getAccount() != null) {
					SET("account = #{account}");
				}
				if (exploration.getLawEnforcementId() != null) {
					SET("law_enforcement_id = #{lawEnforcementId}");
				}
				if (exploration.getState() != null) {
					SET("fish_permit_time = #{fishPermitTime}");
				}
				if (exploration.getWitnesses() != null) {
					SET("witnesses = #{witnesses}");
				}
				if (exploration.getFlag() != null) {
					SET("flag = #{flag}");
				}
				WHERE("id = #{id}");
			}
		}.toString();
	}
}
