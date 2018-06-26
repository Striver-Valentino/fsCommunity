package club.fsCommunity.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import club.fsCommunity.common.pojo.LayuiTableData;
import club.fsCommunity.mapper.GameMapper;
import club.fsCommunity.pojo.Game;
import club.fsCommunity.pojo.GameExample;
import club.fsCommunity.service.indexService;

@Service
public class indexServiceImpl implements indexService {
	
	@Autowired
	private GameMapper gameMapper;

	@Override
	public LayuiTableData showAllGames(Integer page,Integer limit) {
		
		PageHelper.startPage(page, limit);
		
		GameExample example = new GameExample();
		List<Game> list = gameMapper.selectByExample(example);
		
		PageInfo<Game> pageInfo = new PageInfo<>(list);
		
		LayuiTableData layuiTableData = new LayuiTableData();
		layuiTableData.setCode(0);
		layuiTableData.setMsg("");
		layuiTableData.setCount(pageInfo.getTotal());
		layuiTableData.setData(list);
		
		return layuiTableData;
	}

}
