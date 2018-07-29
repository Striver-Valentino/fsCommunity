package club.fsCommunity.async.handler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import club.fsCommunity.async.EventHandler;
import club.fsCommunity.async.EventModel;
import club.fsCommunity.async.EventType;
import club.fsCommunity.common.utils.RedisKeyUtil;
import club.fsCommunity.jedis.JedisAdapter;
import club.fsCommunity.pojo.Team;
import club.fsCommunity.pojo.TeamVs;
import club.fsCommunity.service.GameService;
import club.fsCommunity.service.TeamVsService;

/**
 * 处理 赛事分组成功 的 处理器
 * @author Administrator
 *
 */
@Service
public class GroupTeamHandler implements EventHandler {
	
	@Autowired
	private JedisAdapter jedisAdapter;
	
	@Autowired
	private TeamVsService teamVsService;
	
	@Autowired
	private GameService gameService;
	
	

	@Override
	public void doHandle(EventModel eventModel) {
		
		/**
		 * 分组完成后，teamSet 里的 队伍 都放到 redis 的 set 中
		 */
		String teamListJson = eventModel.getExt("teamList");
		System.out.println("GroupTeamHandler_teamSetJson:" + teamListJson);
		//Set<Team> teamSet = JSON.parseObject(teamSetJson,HashSet.class); // com.alibaba.fastjson 反序列化  Set 会有 一定能难度，最好用 list 或 map
		List<Team> teamList = JSON.parseArray(teamListJson,Team.class);
		
		String gameId = eventModel.getActorId();
		
		if(jedisAdapter.exists(RedisKeyUtil.getGroupTeamKey(gameId))){ // 如果存在这个 key，先删除，然后 下面 再重新 建一个
			jedisAdapter.del(RedisKeyUtil.getGroupTeamKey(gameId));
		}
		
		for (Team team : teamList) {
			System.out.println("GroupTeamHandler 加入到redis的set：" + team.getTeamId());
			jedisAdapter.sadd(RedisKeyUtil.getGroupTeamKey(gameId), team.getTeamId());
		}
		
		/**
		 * 从 set 里 每次  取出  两个 队伍，为 一组 对阵
		 */
		long teamCount = jedisAdapter.scard(RedisKeyUtil.getGroupTeamKey(gameId));
		System.out.println("GroupTeamHandler_teamCount:" + teamCount);
		while(teamCount>=2){
			String team1Id = jedisAdapter.spop(RedisKeyUtil.getGroupTeamKey(gameId));
			String team2Id = jedisAdapter.spop(RedisKeyUtil.getGroupTeamKey(gameId));
			
			System.out.println("GroupTeamHandler_team1Id:" + team1Id);
			System.out.println("GroupTeamHandler_team2Id:" + team2Id);
			
			teamVsService.addTeamVs(team1Id, team2Id, gameId);
			
			teamCount = teamCount-2;
		}
		
		
		
		/**
		 * 把 对应 的 赛事 的 分组状态 改为1，表示 已经 分组
		 */
		Map<String, Object> map = gameService.updateGroupStatus(gameId);
		System.out.println("更新分组状态，gameId:" + gameId);
		
		if(map.containsKey("updateGroupStatusSuc")){
			System.out.println("赛事  更新分组状态 成功：" + (String)map.get("updateGroupStatusSuc"));
		}else{
			System.out.println("赛事  更新分组状态 出错：" + (String)map.get("updateGroupStatusError"));
		}
		
	}

	@Override
	public List<EventType> getSupportEventTypes() {
		List<EventType> list = new ArrayList<EventType>();
		list.add(EventType.GROUPTEAMSUC);
		
		return list;
	}

}
