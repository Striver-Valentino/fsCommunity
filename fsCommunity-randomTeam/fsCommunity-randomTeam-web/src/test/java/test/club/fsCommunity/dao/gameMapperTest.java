package test.club.fsCommunity.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import club.fsCommunity.mapper.GameMapper;
import club.fsCommunity.mapper.UserMapper;
import club.fsCommunity.pojo.Game;
import club.fsCommunity.pojo.GameExample;
import club.fsCommunity.pojo.GameExample.Criteria;
import club.fsCommunity.service.GameService;

public class gameMapperTest {

	ApplicationContext ac = new ClassPathXmlApplicationContext(
			new String[]{"/spring/applicationContext-dao.xml", 
					"/spring/applicationContext-jedis.xml",
					"/spring/applicationContext-service.xml",
					"/spring/applicationContext-trans.xml",
					"/spring/springmvc.xml"
			});
	GameService gameService = (GameService) ac.getBean("GameService");
	GameMapper gameMapper = (GameMapper) ac.getBean("gameMapper");
	
	@Test
	public void testGetGamesByName() {
		
		String gameName = "测试报名3";
		
		GameExample example = new GameExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(gameName);
		List<Game> list2 = gameMapper.selectByExampleWithBLOBs(example);
		List<Game> list = gameMapper.selectByExample(example);
		
		System.out.println("list:"+list);
		System.out.println("list2:"+list2);
		
	}

}
