package com.mmle.dynaSql;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.mmle.entity.LawEnforcement;

/**
 * @Title: DynaSqlProvider.java
 * @Package com.mmle.dynaSql
 * @Description: 渔船的动态sql
 * @author clc
 * @date 2016年7月23日 下午1:45:32
 * @version V1.0
 */
public class LawEnforcementDynaSql {
	
	private static final String TABLE_NAME = "tbl_law_enforcement";  
	
	public String insertLawEnforcement(final LawEnforcement lawEnforcement) {
		return new SQL() {
			{
				INSERT_INTO(TABLE_NAME);
				if (lawEnforcement.getCaseId() != null) {
					VALUES("case_id", "#{caseId}");
				}
				if (lawEnforcement.getCaseName() != null) {
					VALUES("case_name", "#{caseName}");
				}
				if (lawEnforcement.getDate() != null) {
					VALUES("date", "#{date}");
				}
				if (lawEnforcement.getState() != null) {
					VALUES("state", "#{state}");
				}
				if (lawEnforcement.getProcessMan()!= null) {
					VALUES("process_man", "#{processMan}");
				}
				if (lawEnforcement.getLawEnforcementMan() != null) {
					VALUES("law_enforcement_man", "#{lawEnforcementMan}");
				}
				if (lawEnforcement.getFlag() != null) {
					VALUES("flag", "#{flag}");
				}
				
			}
		}.toString();
	}
	
	public String updateLawEnforcement(final LawEnforcement lawEnforcement){
		return new SQL() {
			{
				UPDATE(TABLE_NAME);
				if (lawEnforcement.getCaseId() != null) {
					SET("case_id = #{caseId}");
				}
				if (lawEnforcement.getCaseName() != null) {
					SET("case_name = #{caseName}");
				}
				if (lawEnforcement.getDate() != null) {
					SET("date = #{date}");
				}
				if (lawEnforcement.getState() != null) {
					SET("state = #{state}");
				}
				if (lawEnforcement.getProcessMan()!= null) {
					SET("process_man = #{processMan}");
				}
				if (lawEnforcement.getLawEnforcementMan() != null) {
					SET("law_enforcement_man = #{lawEnforcementMan}");
				}
				if (lawEnforcement.getFlag() != null) {
					SET("flag = #{flag}");
				}
				WHERE("id = #{id}");
			}
		}.toString();
	}
	
	public String selectLawEnforcement(Map<String, Object> map){
		LawEnforcement lawEnforcement = (LawEnforcement) map.get("lawEnforcement");
		Integer start = (Integer)map.get("start");
		Integer end = (Integer)map.get("end");
		StringBuffer s = new StringBuffer();
		s.append("select * from ");
		s.append(TABLE_NAME);
		s.append(" where 1=1 ");
		if (lawEnforcement.getCaseId() != null) {
			s.append("and case_id = ");
			s.append(lawEnforcement.getCaseId());
			s.append(" ");
		}
		if (lawEnforcement.getState() != null) {
			s.append("and state = ");
			s.append(lawEnforcement.getState());
			s.append(" ");
		} 
		if (lawEnforcement.getCaseName()!=null) {
			s.append("and case_name LIKE '%");
			s.append(lawEnforcement.getCaseName());
			s.append("%' ");
		}
		if (lawEnforcement.getProcessMan()!=null) {
			s.append("and process_man LIKE '%");
			s.append(lawEnforcement.getProcessMan());
			s.append("%' ");
		}
		if (lawEnforcement.getLawEnforcementMan() != null) {
			s.append("and law_enforcement_man LIKE '%");
			s.append(lawEnforcement.getProcessMan());
			s.append("%' ");
		}
		if (lawEnforcement.getFlag() != null) {
			s.append("and flag =");
			s.append(lawEnforcement.getFlag());
			s.append(" ");
		}
		if(start != null && start!=0  && end != null && end!=0 && end>start){
			s.append("limit ");
			s.append(start);
			s.append(",");
			s.append(end);
			
		}
		return s.toString();
	}

}
