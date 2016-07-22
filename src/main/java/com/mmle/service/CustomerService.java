package com.mmle.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.mail.search.AddressStringTerm;

import org.springframework.stereotype.Service;

import com.mmle.dao.ICustomerDao;
import com.mmle.entity.Customer;
import com.mmle.serviceImple.ICustomerService;
import com.mmle.utils.SaltUtils;





@Service
public class CustomerService implements ICustomerService{

	@Resource
	private ICustomerDao customerDao;

	
	/**
	 * 手机账号密码登录
	 * @param telephone
	 * @param password
	 * @return
	 */
	public Customer getLoginMessage(String telephone, String password) {
		Customer customer = customerDao.selectCustomerByTelephone(telephone);
		if(customer == null ) return null;
		String salt = customer.getSalt();
		String Md5Password = SaltUtils.getMd5Password(password, salt);
		if(Md5Password.equals(customer.getPassword())){
			customer.setLocked((short)0);
			customer.setLockedTime(null);
			customerDao.updateCustomer(customer);
			customer.setPassword("");
			customer.setSalt("");
			return customer;
		}else{
			int loginFailCount = customer.getLocked()+1;
			Customer newCustomer = new Customer();
			newCustomer.setLocked((short)(loginFailCount+1));
			newCustomer.setTelephone(telephone);
			newCustomer.setLockedTime(new Date());
			customerDao.updateCustomer(newCustomer);
			return null;
		}

	}

}
