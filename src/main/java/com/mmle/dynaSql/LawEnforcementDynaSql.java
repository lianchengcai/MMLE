package com.mmle.dynaSql;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.mmle.entity.FishBoat;
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
				if (lawEnforcement.getPass() != null) {
					VALUES("pass", "#{pass}");
				}
				if (lawEnforcement.getReason() != null) {
					VALUES("reason", "#{reason}");
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
				if (lawEnforcement.getPass() != null) {
					SET("pass = #{pass}");
				}
				if (lawEnforcement.getReason() != null) {
					SET("reason = #{reason}");
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
		if (lawEnforcement.getPass() != null) {
			s.append("and pass = ");
			s.append(lawEnforcement.getPass());
			s.append(" ");
		} 
		if (lawEnforcement.getReason() != null) {
			s.append("and reason = ");
			s.append(lawEnforcement.getReason());
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
			s.append(lawEnforcement.getLawEnforcementMan());
			s.append("%' ");
		}
		if (lawEnforcement.getFlag() != null) {
			s.append("and flag =");
			s.append(lawEnforcement.getFlag());
			s.append(" ");
		}
		if(start != null && end != null && end!=0){
			s.append("limit ");
			s.append(start);
			s.append(",");
			s.append(end);
			
		}
		return s.toString();
	}
	
	public String selectLawEnforcementCount(final LawEnforcement lawEnforcement){
		StringBuffer s = new StringBuffer();
		s.append("select count(*) from ");
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
		if (lawEnforcement.getPass() != null) {
			s.append("and pass = ");
			s.append(lawEnforcement.getPass());
			s.append(" ");
		} 
		if (lawEnforcement.getReason() != null) {
			s.append("and reason = ");
			s.append(lawEnforcement.getReason());
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
			s.append(lawEnforcement.getLawEnforcementMan());
			s.append("%' ");
		}
		if (lawEnforcement.getFlag() != null) {
			s.append("and flag =");
			s.append(lawEnforcement.getFlag());
			s.append(" ");
		}
		return s.toString();
	}
	
	public String selectLEPageByTimeCount(Map<String, Object> map){
		LawEnforcement lawEnforcement = (LawEnforcement) map.get("lawEnforcement");
		Date lawStartTime = (Date)map.get("lawStartTime");
		Date lawEndTime = (Date)map.get("lawEndTime");
		StringBuffer s = new StringBuffer();
		s.append("select count(*) from ");
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
		if (lawEnforcement.getPass() != null) {
			s.append("and pass = ");
			s.append(lawEnforcement.getPass());
			s.append(" ");
		} 
		if (lawEnforcement.getReason() != null) {
			s.append("and reason = ");
			s.append(lawEnforcement.getReason());
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
			s.append(lawEnforcement.getLawEnforcementMan());
			s.append("%' ");
		}
		if(lawStartTime!=null && lawEndTime!=null){
			SimpleDateFormat sdf =   new SimpleDateFormat( " yyyy-MM-dd HH:mm:ss " );
			String startTimeStr = sdf.format(lawStartTime);
			String endTimeStr = sdf.format(lawEndTime);
			s.append("and date>='"+startTimeStr);
			s.append("' and date<='"+endTimeStr);
			s.append("' ");
		}
		if (lawEnforcement.getFlag() != null) {
			s.append("and flag =");
			s.append(lawEnforcement.getFlag());
			s.append(" ");
		}
		return s.toString();
	}

	public String selectLEPageByTimeByConditions(Map<String, Object> map){
		LawEnforcement lawEnforcement = (LawEnforcement) map.get("lawEnforcement");
		Date lawStartTime = (Date)map.get("lawStartTime");
		Date lawEndTime = (Date)map.get("lawEndTime");
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
		if (lawEnforcement.getPass() != null) {
			s.append("and pass = ");
			s.append(lawEnforcement.getPass());
			s.append(" ");
		} 
		if (lawEnforcement.getReason() != null) {
			s.append("and reason = ");
			s.append(lawEnforcement.getReason());
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
			s.append(lawEnforcement.getLawEnforcementMan());
			s.append("%' ");
		}
		if (lawEnforcement.getFlag() != null) {
			s.append("and flag =");
			s.append(lawEnforcement.getFlag());
			s.append(" ");
		}
		if(lawStartTime!=null && lawEndTime!=null){
			SimpleDateFormat sdf =   new SimpleDateFormat( " yyyy-MM-dd HH:mm:ss " );
			String startTimeStr = sdf.format(lawStartTime);
			String endTimeStr = sdf.format(lawEndTime);
			s.append("and date>='"+startTimeStr);
			s.append("' and date<='"+endTimeStr);
			s.append("' ");
		}
		if(start != null && end != null && end!=0){
			s.append("limit ");
			s.append(start);
			s.append(",");
			s.append(end);
			
		}
		return s.toString();
	}

}
