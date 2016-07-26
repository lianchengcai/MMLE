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
import com.mmle.entity.Case;
import com.mmle.entity.CaseType;
import com.mmle.entity.User;
import com.mmle.utils.DTO;

/**
 * @Title: CaseControllerTest.java
 * @Package com.mmle.controller
 * @Description: TODO(用一句话描述该文件做什么)
 * @author lbb
 * @date 2016年7月23日 下午1:47:22
 * @version V1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath*:springmvc.xml", "classpath*:applicationContext.xml",
		"classpath*:applicationContext-shiro.xml" })
@ActiveProfiles("production")
public class CaseControllerTest {
	@Autowired
	WebApplicationContext wac;

	MockMvc mockMvc;

	@Before()
	public void setup() {
		mockMvc = webAppContextSetup(wac).build();
	}

	// @Test
	public void getCaseInfo() throws Exception {
		DTO data = new DTO();
		Case cas = new Case();
		CaseType caseType = new CaseType();
		caseType.setTypeId(1);
		cas.setCaseType(caseType);
		data.setCas(cas);
		ObjectMapper mapper = new ObjectMapper();
		// mapper.configure(SerializationConfig.Feature.INDENT_OUTPUT,
		// Boolean.TRUE);

		String json = mapper.writeValueAsString(data);

		System.out.println("Java2Json: " + json);

		data = mapper.readValue(json, DTO.class);

		System.out.println("Json2Java: " + mapper.writeValueAsString(data));

		MvcResult result = mockMvc.perform(
				MockMvcRequestBuilders.post("/getCaseInfo").contentType(MediaType.APPLICATION_JSON).content(json))
				.andExpect(status().isOk()).andReturn();
		System.out.println(result.getResponse().getContentAsString());
	}

	// @Test
	public void addCaseInfo() throws Exception {
		DTO data = new DTO();
		Case cas = new Case();
		cas.setCaseName("捕捞的渔获物中的幼鱼超过规定比例");
		CaseType caseType = new CaseType();
		caseType.setName("渔港管理");
		cas.setCaseType(caseType);
		data.setCas(cas);
		ObjectMapper mapper = new ObjectMapper();
		// mapper.configure(SerializationConfig.Feature.INDENT_OUTPUT,
		// Boolean.TRUE);

		String json = mapper.writeValueAsString(data);

		System.out.println("Java2Json: " + json);

		data = mapper.readValue(json, DTO.class);

		System.out.println("Json2Java: " + mapper.writeValueAsString(data));

		MvcResult result = mockMvc.perform(
				MockMvcRequestBuilders.post("/addCaseInfo").contentType(MediaType.APPLICATION_JSON).content(json))
				.andExpect(status().isOk()).andReturn();
		System.out.println(result.getResponse().getContentAsString());
	}

   // @Test
	public void deleteCaseInfo() throws Exception {
		DTO data = new DTO();
		Case cas = new Case();
		cas.setCaseId(6);
		data.setCas(cas);
		ObjectMapper mapper = new ObjectMapper();
		// mapper.configure(SerializationConfig.Feature.INDENT_OUTPUT,
		// Boolean.TRUE);

		String json = mapper.writeValueAsString(data);

		System.out.println("Java2Json: " + json);

		data = mapper.readValue(json, DTO.class);

		System.out.println("Json2Java: " + mapper.writeValueAsString(data));

		MvcResult result = mockMvc.perform(
				MockMvcRequestBuilders.post("/deleteCaseInfo").contentType(MediaType.APPLICATION_JSON).content(json))
				.andExpect(status().isOk()).andReturn();
		System.out.println(result.getResponse().getContentAsString());
	}

	// @Test
	public void updateCaseInfo() throws Exception {
		DTO data = new DTO();
		Case cas = new Case();
		cas.setCaseId(6);
		cas.setCaseName("fei");
		data.setCas(cas);
		ObjectMapper mapper = new ObjectMapper();
		// mapper.configure(SerializationConfig.Feature.INDENT_OUTPUT,
		// Boolean.TRUE);

		String json = mapper.writeValueAsString(data);

		System.out.println("Java2Json: " + json);

		data = mapper.readValue(json, DTO.class);

		System.out.println("Json2Java: " + mapper.writeValueAsString(data));

		MvcResult result = mockMvc.perform(
				MockMvcRequestBuilders.post("/updateCaseInfo").contentType(MediaType.APPLICATION_JSON).content(json))
				.andExpect(status().isOk()).andReturn();
		System.out.println(result.getResponse().getContentAsString());
	}

	// @Test
	public void updateCaseType() throws Exception {
		DTO data = new DTO();
		CaseType caseType = new CaseType();
		caseType.setFlag(true);
		caseType.setTypeId(1);
		// caseType.setFlag(1);
		data.setCaseType(caseType);
		ObjectMapper mapper = new ObjectMapper();
		// mapper.configure(SerializationConfig.Feature.INDENT_OUTPUT,
		// Boolean.TRUE);

		String json = mapper.writeValueAsString(data);

		System.out.println("Java2Json: " + json);

		data = mapper.readValue(json, DTO.class);

		System.out.println("Json2Java: " + mapper.writeValueAsString(data));

		MvcResult result = mockMvc.perform(
				MockMvcRequestBuilders.post("/updateCaseType").contentType(MediaType.APPLICATION_JSON).content(json))
				.andExpect(status().isOk()).andReturn();
		System.out.println(result.getResponse().getContentAsString());
	}

	// @Test
	public void insertCaseType() throws Exception {
		DTO data = new DTO();
		CaseType caseType = new CaseType();
		caseType.setName("船员是管理");
		data.setCaseType(caseType);
		ObjectMapper mapper = new ObjectMapper();
		// mapper.configure(SerializationConfig.Feature.INDENT_OUTPUT,
		// Boolean.TRUE);

		String json = mapper.writeValueAsString(data);

		System.out.println("Java2Json: " + json);

		data = mapper.readValue(json, DTO.class);

		System.out.println("Json2Java: " + mapper.writeValueAsString(data));

		MvcResult result = mockMvc.perform(
				MockMvcRequestBuilders.post("/addCaseType").contentType(MediaType.APPLICATION_JSON).content(json))
				.andExpect(status().isOk()).andReturn();
		System.out.println(result.getResponse().getContentAsString());
	}

	@Test
	public void deleteCaseType() throws Exception {
		DTO data = new DTO();
		CaseType caseType = new CaseType();
		caseType.setTypeId(6);
		data.setCaseType(caseType);
		ObjectMapper mapper = new ObjectMapper();
		// mapper.configure(SerializationConfig.Feature.INDENT_OUTPUT,
		// Boolean.TRUE);

		String json = mapper.writeValueAsString(data);

		System.out.println("Java2Json: " + json);

		data = mapper.readValue(json, DTO.class);

		System.out.println("Json2Java: " + mapper.writeValueAsString(data));

		MvcResult result = mockMvc.perform(
				MockMvcRequestBuilders.post("/deleteCaseType").contentType(MediaType.APPLICATION_JSON).content(json))
				.andExpect(status().isOk()).andReturn();
		System.out.println(result.getResponse().getContentAsString());
	}
}
