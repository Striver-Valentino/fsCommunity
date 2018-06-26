package club.fsCommunity.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import club.fsCommunity.mapper.GameMapper;
import club.fsCommunity.pojo.Game;
import club.fsCommunity.service.GameService;

@Service("GameService")
public class GameServiceImpl implements GameService {

	@Autowired
	private GameMapper gameMapper;
	
	@Override
	public int addGame(Game game) {
		return gameMapper.insert(game);
	}

}
