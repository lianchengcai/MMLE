package com.mmle.utils;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.mmle.entity.Case;
import com.mmle.entity.CaseType;
import com.mmle.entity.Check;
import com.mmle.entity.FishBoat;
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
	public String addCheck(final Check check) {
		return new SQL() {
			{
				INSERT_INTO("tbl_check");
				if (check.getBoatCheck() != null) {
					VALUES("boat_check", "#{boatCheck}");
				}
				if (check.getBoater() != null) {
					VALUES("boater", "#{boater}");
				}
				if (check.getChiefEngineer() != null) {
					VALUES("chief_engineer", "#{chiefEngineer}");
				}
				if (check.getCompass()!= null) {
					VALUES("compass", "#{compass}");
				}
				if (check.getFishing()!= null) {
					VALUES("fishing", "#{fishing}");
				}
				if (check.getNationality()!= null) {
					VALUES("nationality", "#{nationality}");
				}
				if (check.getFlag()!= null) {
					VALUES("flag", "#{flag}");
				}
				if (check.getRadar()!= null) {
					VALUES("radar", "#{radar}");
				}
				if (check.getSailing()!= null) {
					VALUES("sailing", "#{sailing}");
				}
				if (check.getSatelliteNavigation()!= null) {
					VALUES("satelliteNavigation", "#{satelliteNavigation}");
				}
				if (check.getSsb()!= null) {
					VALUES("ssb", "#{ssb}");
				}
				if (check.getBoat()!= null) {
					VALUES("boat", "#{boat.boatId}");
				}
				if (check.getBoatImage()!= null) {
					VALUES("boat_image", "#{boatImage}");
				}
				if (check.getCheckMan()!= null) {
					VALUES("check_man", "#{checkMan.account}");
				}
				if (check.getCheckTime()!= null) {
					VALUES("check_time", "#{checkTime}");
				}
				if (check.getManImage()!= null) {
					VALUES("man_image", "#{manImage}");
				}
				if (check.getTitle()!= null) {
					VALUES("title", "#{title}");
				}
				if (check.getType()!= null) {
					VALUES("type", "#{type}");
				}
				if (check.getContent()!= null) {
					VALUES("content", "#{content}");
				}
				if (check.getLocation()!= null) {
					VALUES("location", "#{location}");
				}
				if (check.getState()!= null) {
					VALUES("state", "#{state}");
				}
				if (check.getCas()!= null) {
					VALUES("case_id", "#{cas.caseId}");
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
	public String updateCheck(final Check check) {
		return new SQL() {
			{
				UPDATE("tbl_check");
				if (check.getBoatCheck()!= null) {
					SET(" boat_check= #{boatCheck}");
				}
				if (check.getBoater()!= null) {
					SET("boater = #{boater}");
				}
				if (check.getChiefEngineer() != null) {
					SET("chief_engineer = #{chiefEngineer}");
				}
				if (check.getCompass() != null) {
					SET("compass = #{compass}");
				}
				if (check.getFishing() != null) {
					SET("fishing = #{fishing}");
				}
				if (check.getNationality() != null) {
					SET("nationality = #{nationality}");
				}
				if (check.getFlag() != null) {
					SET("flag = #{flag}");
				}
				if (check.getRadar() != null) {
					SET("radar = #{radar}");
				}
				if (check.getSailing() != null) {
					SET("sailing = #{sailing}");
				}
				if (check.getSatelliteNavigation() != null) {
					SET("satelliteNavigation = #{satelliteNavigation}");
				}
				if (check.getSsb() != null) {
					SET("ssb = #{ssb}");
				}
				if (check.getBoat() != null) {
					SET("boat = #{boat.boatId}");
				}
				if (check.getBoatImage() != null) {
					SET("boat_image = #{boatImage}");
				}
				if (check.getCheckMan() != null) {
					SET("check_man = #{checkMan.account}");
				}
				if (check.getCheckTime() != null) {
					SET("check_time = #{checkTime}");
				}
				if (check.getManImage() != null) {
					SET("man_image = #{manImage}");
				}
				if (check.getTitle() != null) {
					SET("title = #{title}");
				}
				if (check.getType() != null) {
					SET("type = #{type}");
				}
				if (check.getContent() != null) {
					SET("content = #{content}");
				}
				if (check.getLocation() != null) {
					SET("location = #{location}");
				}
				if (check.getState() != null) {
					SET("state = #{state}");
				}
				WHERE("check_id = #{checkId}");
			}
		}.toString();
	}	
	
	public String getCheck(final Map<String, Object> map){
		Check check = (Check) map.get("check");
		Integer offset = (Integer)map.get("offset");
		Integer size = (Integer)map.get("size");
		System.out.println(offset+" "+size);
		StringBuffer s = new StringBuffer();
		s.append("select * from ");
		s.append("tbl_check");
		s.append(" where 1=1 ");
		if (check!=null) {
			if (check.getType() != null) {
				s.append("and type LIKE '%");
				s.append(check.getType());
				s.append("%' ");
			}
			if (check.getTitle() != null) {
				s.append("and title LIKE '%");
				s.append(check.getTitle());
				s.append("%' ");
			} 
			if (check.getCheckMan() != null) {
				if (check.getCheckMan()!=null) {
					s.append("and check_man LIKE '%");
					s.append(check.getCheckMan());
					s.append("%' ");
				}
			} 
			if (check.getFlag() != null) {
				s.append("and flag =");
				s.append(check.getFlag());
				s.append(" ");
			}
			if (check.getCheckId() != null) {
				s.append("and check_id =");
				s.append(check.getCheckId());
				s.append(" ");
			}
		}
		if(offset != null && size != null && size!=0 && size>offset){
			s.append("limit ");
			s.append(offset);
			s.append(",");
			s.append(size);
			
		}
		System.out.println(s.toString());
		return s.toString();
	}
}
