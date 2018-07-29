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
import club.fsCommunity.service.IndexService;

@Service
public class IndexServiceImpl implements IndexService {
	
	@Autowired
	private GameMapper gameMapper;

	

}
