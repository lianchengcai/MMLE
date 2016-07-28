package com.mmle.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mmle.entity.Case;
import com.mmle.entity.CaseType;
import com.mmle.entity.FishBoat;
import com.mmle.utils.DTO;

import net.sf.json.JSONObject;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"classpath*:springmvc.xml","classpath*:applicationContext.xml","classpath*:applicationContext-shiro.xml"})
@ActiveProfiles("production")
public class FishBoatControllerTest {

	@Resource
	FishBoatController fishBoatController;
	
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
		FishBoat fishBoat = new FishBoat();
		fishBoat.setBoatId("789400");
		fishBoat.setBoatName("名字测试");
		fishBoat.setBoatLlocation("位置测试");
		fishBoat.setHomePort("港口测试");
		fishBoat.setFishPermitTime(new Date());
		data.setFishBoat(fishBoat);
		
		fishBoatController.addFishBoat(data);
	
	}
	
	@Test
	public void select() throws Exception {
		
		DTO data = new DTO();
		FishBoat  fishBoat = new FishBoat();
		data.setFishBoat(fishBoat);
		String map = fishBoatController.getFishBoatList(data);
		
		JSONObject jsonb = JSONObject.fromObject(map);
		System.out.println(jsonb.toString());
				
		
	}
	

}
