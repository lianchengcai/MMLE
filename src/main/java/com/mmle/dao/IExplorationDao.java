package com.mmle.dao;



import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.springframework.stereotype.Repository;

import com.mmle.dynaSql.ExplorationDynaSql;
import com.mmle.entity.Exploration;
import com.mmle.entity.FishBoat;


/**   
 * @Title: IFishBoatDao.java 
 * @Package com.mmle.dao 
 * @Description: 现场勘查持久层
 * @author clc
 * @date 2016年7月23日 下午1:56:20
 * @version V1.0   
 */
@Repository
public interface IExplorationDao {
	@InsertProvider(type = ExplorationDynaSql.class, method = "insertExploration")
	int insertExploration(Exploration exploration);
	
	@Select("select * from tbl_exploration where boat_id=#{id}")
	FishBoat selectExplorationById(int id);
	
	@Update("update tbl_exploration set flag=0 where id=#{id}")
	int deleteExplorationById(int id);
	
	@UpdateProvider(type = ExplorationDynaSql.class, method = "updateExploration")
	int updateExploration(Exploration exploration);
	
	@Select("select * from tbl_exploration where lawEnforcement_id=#{lawEnforcementId}")
	Exploration selectExplorationByLawEnforcementId(String lawEnforcementId);
}
