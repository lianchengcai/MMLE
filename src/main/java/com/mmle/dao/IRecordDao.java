package com.mmle.dao;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.springframework.stereotype.Repository;

import com.mmle.dynaSql.RecordDynaSql;
import com.mmle.entity.Record;


/**   
 * @Title: IFishBoatDao.java 
 * @Package com.mmle.dao 
 * @Description: 渔船信息持久层
 * @author clc
 * @date 2016年7月23日 下午1:56:20
 * @version V1.0   
 */
@Repository
public interface IRecordDao {
	@InsertProvider(type = RecordDynaSql.class, method = "insertRecord")
	int insertRecord(Record record);
	
	@Select("select * from tbl_record where id=#{id}")
	Record selectRecordById(int id);
	
	@Update("update tbl_record set flag=0 where id=#{id}")
	int deleteRecordById(String id);
	
	@UpdateProvider(type = RecordDynaSql.class, method = "updateRecord")
	int updateRecord(Record record);
	
	@Select("select * from tbl_record where lawEnforcement_id=#{lawEnforcementId}")
	Record selectRecordByLawEnforcementId(int lawEnforcementId);
}
