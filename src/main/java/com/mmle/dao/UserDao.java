package com.mmle.dao;

import org.apache.ibatis.annotations.InsertProvider;
import org.springframework.stereotype.Repository;

import com.mmle.entity.User;
import com.mmle.utils.DynaSqlProvider;


/**   
 * @Title: UserDao.java 
 * @Package com.mmle.dao 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author lbb
 * @date 2016年7月22日 下午9:39:20 
 * @version V1.0   
 */
@Repository
public interface UserDao {
	@InsertProvider(type = DynaSqlProvider.class, method = "insertUser")
	int insertUser(User user);
}
