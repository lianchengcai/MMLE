package com.mmle.dynaSql;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.scripting.xmltags.WhereSqlNode;

import com.mmle.entity.FishBoat;
import com.mmle.entity.User;

/**
 * @Title: DynaSqlProvider.java
 * @Package com.mmle.dynaSql
 * @Description: 渔船的动态sql
 * @author clc
 * @date 2016年7月23日 下午1:45:32
 * @version V1.0
 */
public class FishBoatDynaSql {
	
	private static final String TABLE_NAME = "tbl_fish_boat";  
	
	public String insertFishBoat(final FishBoat fishBoat) {
		return new SQL() {
			{
				INSERT_INTO(TABLE_NAME);
				if (fishBoat.getBoatId() != null) {
					VALUES("boat_id", "#{boatId}");
				}
				if (fishBoat.getBoatName() != null) {
					VALUES("boat_name", "#{boatName}");
				}
				if (fishBoat.getBoatLlocation() != null) {
					VALUES("boat_llocation", "#{boatLlocation}");
				}
				if (fishBoat.getHomePort()!= null) {
					VALUES("home_port", "#{homePort}");
				}
				if (fishBoat.getLength() != null) {
					VALUES("length", "#{length}");
				}
				if (fishBoat.getWidth() != null) {
					VALUES("width", "#{width}");
				}
				if (fishBoat.getTotalWeight() != null) {
					VALUES("total_weight", "#{totalWeight}");
				}
				if (fishBoat.getFishPermitNo() != null) {
					VALUES("fish_permit_no", "#{fishPermitNo}");
				}
				if (fishBoat.getFishPermitTime() != null) {
					VALUES("fish_permit_time", "#{fishPermitTime}");
				}
				if (fishBoat.getSubstitutingNo() != null) {
					VALUES("substituting_no", "#{substitutingNo}");
				}
				if (fishBoat.getSubstitutingTime() != null) {
					VALUES("substituting_time", "#{substitutingTime}");
				}
				if (fishBoat.getCreateTime() != null) {
					VALUES("create_time", "#{createTime}");
				}
				if (fishBoat.getIfNoPermit() != null) {
					VALUES("if_no_permit", "#{ifNoPermit}");
				}
				if (fishBoat.getState() != null) {
					VALUES("state", "#{state}");
				}
				if (fishBoat.getFlag() != null) {
					VALUES("flag", "#{flag}");
				}
				
			}
		}.toString();
	}
	
	public String updateFishBoat(final FishBoat fishBoat){
		return new SQL() {
			{
				UPDATE(TABLE_NAME);
				if (fishBoat.getBoatName() != null) {
					SET("boat_name = #{boatName}");
				}
				if (fishBoat.getBoatLlocation() != null) {
					SET("boat_llocation = #{boatLlocation}");
				}
				if (fishBoat.getHomePort()!= null) {
					SET("home_port = #{homePort}");
				}
				if (fishBoat.getLength() != null) {
					SET("length = #{length}");
				}
				if (fishBoat.getWidth() != null) {
					SET("width = #{width}");
				}
				if (fishBoat.getTotalWeight() != null) {
					SET("total_weight = #{totalWeight}");
				}
				if (fishBoat.getFishPermitNo() != null) {
					SET("fish_permit_no = #{fishPermitNo}");
				}
				if (fishBoat.getFishPermitTime() != null) {
					SET("fish_permit_time = #{fishPermitTime}");
				}
				if (fishBoat.getSubstitutingNo() != null) {
					SET("substituting_no = #{substitutingNo}");
				}
				if (fishBoat.getSubstitutingTime() != null) {
					SET("substituting_time = #{substitutingTime}");
				}
				if (fishBoat.getCreateTime() != null) {
					SET("create_time = #{createTime}");
				}
				if (fishBoat.getIfNoPermit() != null) {
					SET("if_no_permit = #{ifNoPermit}");
				}
				if (fishBoat.getState() != null) {
					SET("state = #{state}");
				}
				if (fishBoat.getFlag() != null) {
					SET("flag = #{flag}");
				}
				
				WHERE("boat_id = #{boatId}");
			}
		}.toString();
	}
	
	public String selectFishBoat(final Map<String, Object> map){
		FishBoat fishBoat = (FishBoat) map.get("fishBoat");
		Integer start = (Integer)map.get("start");
		Integer end = (Integer)map.get("end");
		StringBuffer s = new StringBuffer();
		s.append("select * from ");
		s.append(TABLE_NAME);
		s.append(" where 1=1 ");
		if(fishBoat!=null){
			if (fishBoat.getBoatName() != null) {
				s.append("and boat_name LIKE '%");
				s.append(fishBoat.getBoatName());
				s.append("%' ");
			}
			if (fishBoat.getBoatId() != null) {
				s.append("and boat_id LIKE '%");
				s.append(fishBoat.getBoatId());
				s.append("%' ");
			} 
			if (fishBoat.getSubstitutingTime()!=null) {
				s.append("and substituting_time >'");
				s.append(fishBoat.getSubstitutingTime());
				s.append("' ");
			}
			if (fishBoat.getBoatLlocation() != null) {
				s.append("and boat_llocation LIKE '%");
				s.append(fishBoat.getBoatLlocation());
				s.append("%' ");
			}
			if (fishBoat.getFlag() != null) {
				s.append("and flag =");
				s.append(fishBoat.getFlag());
				s.append(" ");
			}
			if (fishBoat.getIfNoPermit() != null) {
				s.append("and if_no_permit =");
				s.append(fishBoat.getIfNoPermit());
				s.append(" ");
			}
			if (fishBoat.getState() != null) {
				s.append("and state =");
				s.append(fishBoat.getState());
				s.append(" ");
			}
		}
		if(start != null && end != null && end!=0 ){
			s.append("limit ");
			s.append(start);
			s.append(",");
			s.append(end);
			
		}
		return s.toString();
	}
	
	public String selectFishBoatCount(final FishBoat fishBoat){
		StringBuffer s = new StringBuffer();
		s.append("select count(*) from ");
		s.append(TABLE_NAME);
		s.append(" where 1=1 ");
		if(fishBoat==null)return s.toString();
		if (fishBoat.getBoatName() != null) {
			s.append("and boat_name LIKE '%");
			s.append(fishBoat.getBoatName());
			s.append("%' ");
		}
		if (fishBoat.getBoatId() != null) {
			s.append("and boat_id LIKE '%");
			s.append(fishBoat.getBoatId());
			s.append("%' ");
		} 
		if (fishBoat.getFishPermitTime()!=null) {
			s.append("and fishPermitTime <'");
			s.append(fishBoat.getFishPermitTime());
			s.append("' ");
		}
		if (fishBoat.getBoatLlocation() != null) {
			s.append("and boat_llocation LIKE '%");
			s.append(fishBoat.getBoatLlocation());
			s.append("%' ");
		}
		if (fishBoat.getIfNoPermit() != null) {
			s.append("and if_no_permit =");
			s.append(fishBoat.getIfNoPermit());
			s.append(" ");
		}
		if (fishBoat.getState() != null) {
			s.append("and state =");
			s.append(fishBoat.getState());
			s.append(" ");
		}
		if (fishBoat.getFlag() != null) {
			s.append("and flag =");
			s.append(fishBoat.getFlag());
			s.append(" ");
		}
		return s.toString();
	}

}
