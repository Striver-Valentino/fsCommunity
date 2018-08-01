package club.fsCommunity.common.utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import club.fsCommunity.common.pojo.DisplayGamesTable;
import club.fsCommunity.pojo.Game;

public class PojoConvertUtils {

	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public static List<DisplayGamesTable> GameConvertDisplay(List<Game> gameList){
		
		List<DisplayGamesTable> displayList = new ArrayList<DisplayGamesTable>();
		
		for (Game game : gameList) {
			DisplayGamesTable displayGamesTable = new DisplayGamesTable();
			
			BeanUtils.copyProperties(game, displayGamesTable);
			
			String startDateDisplay = sdf.format(game.getStartDate());
			
			String signUpLineDisplay = null;
			if(game.getSignUpLine()!=null){
				signUpLineDisplay = sdf.format(game.getSignUpLine());
			}
			
			String endDateDisplay = null;
			if(game.getEndDate()!=null){
				endDateDisplay = sdf.format(game.getEndDate());
			}
			
			String launchDateDisplay = null;
			if(game.getLaunchDate()!=null){
				launchDateDisplay = sdf.format(game.getLaunchDate());
			}
			
			String statusDisplay = null;
			if(game.getStatus() == 0){
				statusDisplay = "未开始";
			}else if(game.getStatus() == 1){
				statusDisplay = "进行中";
			}else if(game.getStatus() == 2){
				statusDisplay = "截止报名";
			}else if(game.getStatus() == 3){
				statusDisplay = "已结束";
			}else if(game.getStatus() == 4){
				statusDisplay = "已取消";
			}
			
			displayGamesTable.setStartDateDisplay(startDateDisplay);
			displayGamesTable.setSignUpLineDisplay(signUpLineDisplay);
			displayGamesTable.setStatusDisplay(statusDisplay);
			
			displayGamesTable.setEndDateDisplay(endDateDisplay);
			displayGamesTable.setLaunchDateDisplay(launchDateDisplay);
			
			displayList.add(displayGamesTable);
		}
		
		return displayList;
		
	}
}
