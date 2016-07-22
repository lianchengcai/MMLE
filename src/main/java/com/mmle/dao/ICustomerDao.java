package com.mmle.dao;




import java.util.List;

import org.springframework.stereotype.Repository;

import com.mmle.entity.Customer;


@Repository
public interface ICustomerDao {
	
	   //添加客户表的信息
	    public int insertCustomer(Customer customer);
	    
		//通过电话号码删除客户的信息
		public int deleteCustomerByTelephone(String telephone);
		
		//更改客户的信息
		public int updateCustomer(Customer customer);
		
		//通过电话号码查询出客户信息
		public Customer selectCustomerByTelephone(String telephone);
		
		public List<String> selectCustomerByLevel(Short level);
		
		
}
