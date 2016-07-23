package com.mmle.dao;

import java.util.List;


import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.springframework.stereotype.Repository;

import com.mmle.dynaSql.LawEnforcementDynaSql;
import com.mmle.entity.FishBoat;
import com.mmle.entity.LawEnforcement;


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
	int insertLawEnforcement(LawEnforcement lawEnforcement);
	
	@Select("select * from tbl_law_enforcement where id=#{id}")
	FishBoat selectLawEnforcementById(int id);
	
	@Update("update tbl_law_enforcement set flag=0 where id=#{id}")
	int deleteLawEnforcementById(int id);
	
	@UpdateProvider(type = LawEnforcementDynaSql.class, method = "updateLawEnforcement")
	int updateLawEnforcement(LawEnforcement lawEnforcement);
	
	@SelectProvider(type = LawEnforcementDynaSql.class, method = "selectLawEnforcement")
	List<LawEnforcement> selectLawEnforcementByConditions(@Param("fishBoat") LawEnforcement lawEnforcement,@Param("start") Integer start,@Param("end") Integer end);
}
