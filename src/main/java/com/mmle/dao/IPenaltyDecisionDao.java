package com.mmle.dao;


import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.springframework.stereotype.Repository;

import com.mmle.dynaSql.FishBoatDynaSql;
import com.mmle.dynaSql.PenaltyDecisionDynaSql;
import com.mmle.entity.FishBoat;
import com.mmle.entity.PenaltyDecision;


/**   
 * @Title: IFishBoatDao.java 
 * @Package com.mmle.dao 
 * @Description: 渔船信息持久层
 * @author clc
 * @date 2016年7月23日 下午1:56:20
 * @version V1.0   
 */
@Repository
public interface IPenaltyDecisionDao {
	@InsertProvider(type = PenaltyDecisionDynaSql.class, method = "insertPenaltyDecision")
	int insertPenaltyDecision(PenaltyDecision penaltyDecision);
	
	@Select("select * from tbl_penalty_decision where id=#{id}")
	FishBoat selectPenaltyDecisionById(int id);
	
	@Update("update tbl_penalty_decision set flag=0 where id=#{id}")
	int deletePenaltyDecisionById(int id);
	
	@UpdateProvider(type = PenaltyDecisionDynaSql.class, method = "updatePenaltyDecision")
	int updatePenaltyDecision(PenaltyDecision penaltyDecision);
	
	@Select("select * from tbl_penalty_decision where law_enforcement_id=#{lawEnforcementId}")
	PenaltyDecision selectPenaltyDecisionByLawEnforcementId(int lawEnforcementId);
}
