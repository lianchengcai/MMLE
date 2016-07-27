package com.mmle.controller;


import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mmle.entity.Exploration;
import com.mmle.entity.FishBoat;
import com.mmle.entity.LawEnMessage;
import com.mmle.entity.LawEnforcement;
import com.mmle.entity.PenaltyDecision;
import com.mmle.entity.Record;
import com.mmle.utils.DTO;

import net.sf.json.JSONObject;



@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"classpath*:springmvc.xml","classpath*:applicationContext.xml","classpath*:applicationContext-shiro.xml"})
@ActiveProfiles("production")
public class LawEnforcementControllerTest {

	@Resource
	LawEnforcementController lawEnforcementController;
	
	MockMvc mockMvc;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void insert() throws Exception {
		
		DTO data = new DTO();
		LawEnforcement lawEnforcement = new LawEnforcement();
		lawEnforcement.setCaseId(123);
		lawEnforcement.setCaseName("测试执法表");
		lawEnforcement.setLawEnforcementMan("50009998");
		data.setLawEnforcement(lawEnforcement);
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(data);
		System.out.println("Java2Json: " + json);
		
		Map<String, Object> map = lawEnforcementController.addLawEnforcement(data);
		JSONObject j = JSONObject.fromObject(map);
		System.out.println(j.toString());
	
	}
	
	@Test
	public void addExploration() throws Exception {
		DTO data = new DTO();
		Exploration exploration = new Exploration();
		exploration.setExplorationStartTime(new Date());
		exploration.setExplorationEndTime(new Date());
		exploration.setExplorationLocation("勘查地点");
		exploration.setParties("当事人");
		exploration.setSituation("现场勘查情况");
		exploration.setAccount("990-889");
		exploration.setLawEnforcementId(9);
		exploration.setState(true);
		exploration.setWitnesses("见证人");
		data.setExploration(exploration);
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(data);
		System.out.println("Java2Json: " + json);
		
		lawEnforcementController.addExploration(data);
	}
	
	@Test
	public void addRecord() throws Exception {
		DTO data = new DTO();
		
		Record record = new Record();
		record.setLocation("地点");
		record.setStartDate(new Date());
		record.setEndDate(new Date());
		record.setAsk("蔡-曾");
		record.setRecorder("999");
		record.setDepartmentName("单位名称");
		record.setAccount("999-999");
		record.setViolateRule("违反条款");
		record.setContent("违反内容");
		record.setAsked("被询问人");
		record.setFeedbackOne(true);
		record.setFeedbackTwo("用户信息详情");
		record.setLawEnforcementId(9);
		
		
		data.setRecord(record);
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(data);
		System.out.println("Java2Json: " + json);
		
		lawEnforcementController.addRecord(data);
	}
	
	@Test
	public void addPenaltyDecision() throws Exception {
		DTO data = new DTO();
		
		PenaltyDecision penaltyDecision = new PenaltyDecision();
		penaltyDecision.setPartiesInformation("当时人信息");
		penaltyDecision.setViolateContent("违法内容");
		penaltyDecision.setEvidence("证据");
		penaltyDecision.setViolateRule("违法条款");
		penaltyDecision.setBasis("违反条款依据");
		penaltyDecision.setLocation("缴纳罚款位置");
		penaltyDecision.setLawEnforcementId(9);
		
		
		data.setPenaltyDecision(penaltyDecision);
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(data);
		System.out.println("Java2Json: " + json);
		
		lawEnforcementController.addPenaltyDecision(data);
	}
	
	@Test
	public void selectlawEnforcement() throws Exception {
		DTO data = new DTO();
		LawEnforcement lawEnforcement = new LawEnforcement();
		lawEnforcement.setId(50);
		data.setLawEnforcement(lawEnforcement);
	
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(data);
		System.out.println("Java2Json: " + json);
		
		String map = lawEnforcementController.getLawEnforcement(data);
		
		
		System.out.println(JSONObject.fromObject(map).toString());
	}
	
	@Test
	public void selectlawEnMessage() throws Exception {
		DTO data = new DTO();
		LawEnMessage lawEnMessage = new LawEnMessage();
		lawEnMessage.setLawEnforcementMan("88888888");
		data.setLawEnMessage(lawEnMessage);
	
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(data);
		System.out.println("Java2Json: " + json);
		
		Map<String, Object> map = lawEnforcementController.getPage(data);
		
		
		System.out.println(JSONObject.fromObject(map).toString());
	}
	
	@Test
	public void updatelawEnMessage() throws Exception {
		DTO data = new DTO();
		LawEnforcement lawEnforcement = new LawEnforcement();
		lawEnforcement.setId(50);
		lawEnforcement.setReason("为什么！");
		lawEnforcement.setPass(true);
		data.setLawEnforcement(lawEnforcement);
		
		Map<String, Object> map = lawEnforcementController.updateLawEnforcement(data);
		
		
		System.out.println(JSONObject.fromObject(map).toString());
	}
}
