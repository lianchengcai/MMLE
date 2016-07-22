package cn.fjnu.stumarket.dao;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import cn.fjnu.stumarket.Enum.TableEnum;
import cn.fjnu.stumarket.utils.SystemUtil;
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"classpath*:springmvc.xml","classpath*:applicationContext.xml","classpath*:applicationContext-shiro.xml"})
@ActiveProfiles("production")
public class ISysTableKeyDaoTest {
	@Autowired
	SystemUtil systemUtil;
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		String key=systemUtil.gerneratorKey(TableEnum.permission);
		System.out.println(key);
	}

}
