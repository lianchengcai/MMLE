package com.mmle.dao;

import java.util.List;


import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.springframework.stereotype.Repository;

import com.mmle.dynaSql.FishBoatDynaSql;
import com.mmle.entity.FishBoat;


/**   
 * @Title: IFishBoatDao.java 
 * @Package com.mmle.dao 
 * @Description: 渔船信息持久层
 * @author clc
 * @date 2016年7月23日 下午1:56:20
 * @version V1.0   
 */
@Repository
public interface IFishBoatDao {
	@InsertProvider(type = FishBoatDynaSql.class, method = "insertFishBoat")
	int insertFishBoat(FishBoat fishBoat);
	
	@Select("select * from tbl_fish_boat where boat_id=#{boatId}")
	FishBoat selectFishBoatById(String boatId);
	
	@Update("update tbl_fish_boat set flag=0 where boat_id=#{boatId}")
	int deleteFishBoatById(String boatId);
	
	@UpdateProvider(type = FishBoatDynaSql.class, method = "updateFishBoat")
	int updateFishBoat(FishBoat fishBoat);
	
	@SelectProvider(type = FishBoatDynaSql.class, method = "selectFishBoat")
	List<FishBoat> selectFishBoatByConditions(@Param("fishBoat") FishBoat fishBoat,@Param("start") Integer start,@Param("end") Integer end);
	
	@SelectProvider(type = FishBoatDynaSql.class, method = "selectFishBoatCount")
	int selectFishBoatCount(FishBoat fishBoat);
}
