package club.fsCommunity.service;

import java.util.List;

import club.fsCommunity.common.pojo.LayuiTableData;
import club.fsCommunity.pojo.Game;

public interface indexService {

	LayuiTableData showAllGames(Integer page,Integer limit);
}
