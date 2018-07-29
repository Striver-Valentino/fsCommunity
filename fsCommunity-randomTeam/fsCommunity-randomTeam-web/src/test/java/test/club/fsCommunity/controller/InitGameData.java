package test.club.fsCommunity.controller;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import club.fsCommunity.mapper.UserMapper;
import club.fsCommunity.pojo.Game;
import club.fsCommunity.pojo.User;
import club.fsCommunity.pojo.UserExample;
import club.fsCommunity.pojo.UserExample.Criteria;
import club.fsCommunity.service.GameService;
import club.fsCommunity.service.UserService;
import club.fsCommunity.service.impl.GameServiceImpl;

public class InitGameData {
	
	//GameService gameService = new GameServiceImpl();
	
	ApplicationContext ac = new ClassPathXmlApplicationContext(
			new String[]{"/spring/applicationContext-dao.xml", 
					"/spring/applicationContext-service.xml",
					"/spring/applicationContext-trans.xml",
					"/spring/springmvc.xml"
			});
	GameService gameService = (GameService) ac.getBean("GameService");
	UserMapper userMapper = (UserMapper) ac.getBean("userMapper");

	@Test
	public void InitGame() {
		
		for (int i = 0; i < 20; i++) {
			Game game = new Game();
			
			game.setApplyCount(i*3);
			game.setId(String.valueOf(i*i*i*i*i*i+1+10));
			game.setName("XXX水友赛"+i*i);
			game.setLaunchUserId("zhuzhizhe"+i*i);
			game.setSponsorName("发起者"+i*i);
			game.setStatus(0);
			game.setStartDate(new Date());
			game.setEndDate(new Date());
			
			gameService.addGame(game);
		}
		System.out.println("赛事已初始化");
		
	}
	
	@Test
	public void testUpdateUser(){
		
		User userRecordIpAndDate = new User();
		userRecordIpAndDate.setLastLoginIp("192.168.100.1");
		userRecordIpAndDate.setLastLoginDate(new Date());
		
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo("user240d35299ad34e06a170cc3bee2b0421");
		
		userMapper.updateByExampleSelective(userRecordIpAndDate, example);
	}

}
