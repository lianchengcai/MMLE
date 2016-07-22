package com.mmle.serviceImple;


import com.mmle.entity.Customer;


public interface ICustomerService {

	/**
	 * 手机账号密码登录
	 * @param telephone
	 * @param password
	 * @return
	 */
	public Customer getLoginMessage(String telephone, String password);

}
