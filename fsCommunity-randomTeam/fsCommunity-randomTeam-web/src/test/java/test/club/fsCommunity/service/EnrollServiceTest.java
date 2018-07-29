package test.club.fsCommunity.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.fastjson.JSON;

import club.fsCommunity.mapper.EnrollMapper;
import club.fsCommunity.mapper.GameMapper;
import club.fsCommunity.mapper.UserMapper;
import club.fsCommunity.pojo.Enroll;
import club.fsCommunity.pojo.EnrollExample;
import club.fsCommunity.pojo.Game;
import club.fsCommunity.pojo.GameExample;
import club.fsCommunity.pojo.GameExample.Criteria;
import club.fsCommunity.service.EnrollService;
import club.fsCommunity.service.GameService;

public class EnrollServiceTest {

	ApplicationContext ac = new ClassPathXmlApplicationContext(
			new String[]{"/spring/applicationContext-dao.xml", 
					"/spring/applicationContext-jedis.xml",
					"/spring/applicationContext-service.xml",
					"/spring/applicationContext-trans.xml",
					"/spring/springmvc.xml"
			});
	
	EnrollService enrollService = (EnrollService) ac.getBean("enrollService");
	EnrollMapper enrollMapper = (EnrollMapper) ac.getBean("enrollMapper");
	
	@Test
	public void testSelectEnrollByUserId() {
		
		String userId = "user240d35299ad34e06a170cc3bee2b0421";
		
		EnrollExample example = new EnrollExample();
		club.fsCommunity.pojo.EnrollExample.Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		List<Enroll> list = enrollMapper.selectByExampleWithBLOBs(example);
		
		System.out.println("list:"+list);
		
	}
	
	// 测试 list 转 json
	@Test
	public void testList2Json(){
		List<String> list = new ArrayList<String>();
		list.add("C");
		list.add("SF");
		list.add("PG");
		System.out.println("原来的list:" + list);
		
		String jsonString = JSON.toJSONString(list);
		System.out.println("转化为 json 的 list:" + jsonString);
		
		List list2 = JSON.parseObject(jsonString,List.class);
		System.out.println("由json还原为list:" + list2);
	}

}
