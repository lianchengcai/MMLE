package com.mmle.dao;

import java.util.List;


import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.springframework.stereotype.Repository;

import com.mmle.dynaSql.FishBoatDynaSql;
import com.mmle.dynaSql.LawEnforcementDynaSql;
import com.mmle.entity.FishBoat;
import com.mmle.entity.LawEnMessage;
import com.mmle.entity.LawEnforcement;
import com.mmle.entity.LawEnforcementExtend;


/**   
 * @Title: IFishBoatDao.java 
 * @Package com.mmle.dao 
 * @Description: 渔船信息持久层
 * @author clc
 * @date 2016年7月23日 下午1:56:20
 * @version V1.0   
 */
@Repository
public interface ILawEnforcementDao {
	@InsertProvider(type = LawEnforcementDynaSql.class, method = "insertLawEnforcement")
	@Options(useGeneratedKeys=true,keyProperty="id")
	int insertLawEnforcement(LawEnforcement lawEnforcement);
	
	@Select("select * from tbl_law_enforcement where id=#{id}")
	FishBoat selectLawEnforcementById(int id);
	
	@Update("update tbl_law_enforcement set flag=0 where id=#{id}")
	int deleteLawEnforcementById(int id);
	
	@UpdateProvider(type = LawEnforcementDynaSql.class, method = "updateLawEnforcement")
	int updateLawEnforcement(LawEnforcement lawEnforcement);

	@SelectProvider(type = LawEnforcementDynaSql.class, method = "selectLawEnforcement")
	List<LawEnforcementExtend> selectLawEnforcementExtendByConditions(@Param("lawEnforcement") LawEnforcement lawEnforcement,@Param("start") Integer start,@Param("end") Integer end);

	
	@SelectProvider(type = LawEnforcementDynaSql.class, method = "selectLawEnforcement")
	List<LawEnforcement> selectLawEnforcementByConditions(@Param("lawEnforcement") LawEnforcement lawEnforcement,@Param("start") Integer start,@Param("end") Integer end);

	@SelectProvider(type = LawEnforcementDynaSql.class, method = "selectLawEnforcementCount")
	int selectLawEnforcementCount(LawEnforcement lawEnforcement);

	@Select("select count(*) from tbl_law_enforcement where law_enforcement_man=#{lawEnforcementMan}")
	int selectLawEnMessageCount(String lawEnforcementMan);

	@Select("select * from tbl_law_enforcement where law_enforcement_man=#{lawEnforcementMan}")
	List<LawEnMessage> selectLawEnMessageByUserId(String lawEnforcementMan);
	
	
	@SelectProvider(type = LawEnforcementDynaSql.class, method = "selectLawEnforcement")
	List<LawEnMessage> selectLawEnMessageByConditions(@Param("lawEnforcement") LawEnforcement lawEnforcement,@Param("start") Integer start,@Param("end") Integer end);

	@SelectProvider(type = LawEnforcementDynaSql.class, method = "selectLawEnforcement")
	int selectLawEnMessageCount(LawEnforcement lawEnforcement);
	
}
