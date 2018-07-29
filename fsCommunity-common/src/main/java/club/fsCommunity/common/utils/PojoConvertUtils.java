package club.fsCommunity.common.utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import club.fsCommunity.common.pojo.DisplayGamesTable;
import club.fsCommunity.pojo.Game;

/**
 * 实体类 之间 转化 的 工具类
 * @author Administrator
 *
 */
public class PojoConvertUtils {

	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	/**
	 * Game 类型 转换 为 DisplayGamesTable；为了 复用性 更好，以 集合 的方式 转换。
	 * @param game
	 * @return
	 */
	public static List<DisplayGamesTable> GameConvertDisplay(List<Game> gameList){
		
		List<DisplayGamesTable> displayList = new ArrayList<DisplayGamesTable>();
		
		for (Game game : gameList) {
			DisplayGamesTable displayGamesTable = new DisplayGamesTable();
			
			/**
			 * 复制常规属性，使用的是 spring 的 BeanUtils
			 */
			BeanUtils.copyProperties(game, displayGamesTable); // copyProperties 拷贝属性的方法
			
			/**
			 * 下面处理特殊 属性（这些属性 ，也是 Game 没有，而DisplayGamesTable 有的）
			 */
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
			// 状态，0：未开始；1：进行中；2：截止报名；3：已结束；4：已取消
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
