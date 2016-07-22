package com.mmle.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mmle.entity.User;
import com.mmle.utils.DTO;

/**   
 * @Title: UserControllerTest.java 
 * @Package com.mmle.controller 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author lbb
 * @date 2016年7月22日 下午10:11:36 
 * @version V1.0   
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath*:springmvc.xml", "classpath*:applicationContext.xml" ,	"classpath*:applicationContext-shiro.xml"})
@ActiveProfiles("production")
public class UserControllerTest {
	@Autowired
	WebApplicationContext wac;
	

	MockMvc mockMvc;

	@Before()
	public void setup() {
		mockMvc = webAppContextSetup(wac).build();
	}
	@Test
		public void inserUser() throws Exception {
			DTO data = new DTO();
			User user = new User();
			user.setAccount("1111");
			user.setName("李冰冰");
			user.setPassword("123");
			user.setRoleId(1);
			data.setUser(user);
			ObjectMapper mapper = new ObjectMapper();
		//	mapper.configure(SerializationConfig.Feature.INDENT_OUTPUT, Boolean.TRUE);

			String json = mapper.writeValueAsString(data);

			System.out.println("Java2Json: " + json);

			data = mapper.readValue(json, DTO.class);

			System.out.println("Json2Java: " + mapper.writeValueAsString(data));

			MvcResult result = mockMvc
					.perform(
							MockMvcRequestBuilders.post("/insertUser")  
							.contentType(MediaType.APPLICATION_JSON)
				            .content(json))
				            .andExpect(status().isOk())
				            .andReturn();
			System.out.println(result.getResponse().getContentAsString());
		}
}
