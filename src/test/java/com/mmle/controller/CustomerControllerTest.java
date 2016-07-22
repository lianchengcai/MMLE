package com.mmle.controller;


import javax.annotation.Resource;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"classpath*:springmvc.xml","classpath*:applicationContext.xml","classpath*:applicationContext-shiro.xml"})
@ActiveProfiles("production")
public class CustomerControllerTest {
	
	@Resource
	private MockHttpServletRequest request;
	@Resource
	private MockHttpSession session;
	@Resource
	private MockHttpServletResponse response;

	@Resource
	private CustomerController customerController;

	@Test
	public void loginByPwTest(){
		System.out.println("asf");
		String json = "{\"telephone\": \"151597969323\",\"password\": \"123456\"}";
		String result = customerController.loginByPw(json,response);
		System.out.println(result);
		
	}
	
	
}
