package test.club.fsCommunity.controller;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import club.fsCommunity.pojo.Game;
import club.fsCommunity.service.GameService;
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

	@Test
	public void InitGame() {
		
		for (int i = 0; i < 20; i++) {
			Game game = new Game();
			
			game.setApplyCount(i*3);
			game.setId(String.valueOf(i*i*i*i*i*i+1+10));
			game.setName("XXX水友赛"+i*i);
			game.setOrganizerId("zhuzhizhe"+i*i);
			game.setSponsorName("发起者"+i*i);
			game.setStatus(0);
			game.setStartDate(new Date());
			game.setEndDate(new Date());
			
			gameService.addGame(game);
		}
		System.out.println("赛事已初始化");
		
	}

}
