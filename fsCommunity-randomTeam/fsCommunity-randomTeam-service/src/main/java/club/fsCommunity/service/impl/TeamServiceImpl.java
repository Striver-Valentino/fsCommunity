package club.fsCommunity.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import club.fsCommunity.async.EventModel;
import club.fsCommunity.async.EventProducer;
import club.fsCommunity.async.EventType;
import club.fsCommunity.common.pojo.LayuiTableData;
import club.fsCommunity.common.utils.GeneralUtils;
import club.fsCommunity.common.utils.RedisKeyUtil;
import club.fsCommunity.common.utils.randomNumberUtil;
import club.fsCommunity.jedis.JedisAdapter;
import club.fsCommunity.mapper.EnrollMapper;
import club.fsCommunity.mapper.GameMapper;
import club.fsCommunity.mapper.TeamMapper;
import club.fsCommunity.pojo.Enroll;
import club.fsCommunity.pojo.EnrollExample;
import club.fsCommunity.pojo.Game;
import club.fsCommunity.pojo.EnrollExample.Criteria;
import club.fsCommunity.pojo.Team;
import club.fsCommunity.pojo.TeamExample;
import club.fsCommunity.pojo.User;
import club.fsCommunity.service.EnrollService;
import club.fsCommunity.service.TeamService;
import club.fsCommunity.service.UserService;

@Service
public class TeamServiceImpl implements TeamService,InitializingBean {
	
	@Autowired
	private TeamMapper teamMapper;
	
	@Autowired
	private EnrollMapper enrollMapper;
	
	@Autowired
	private GameMapper gameMapper;
	
	@Autowired
	private JedisAdapter jedisAdapter;
	
	@Autowired
	private EnrollService enrollService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private EventProducer eventProducer;
	
	private Set<String> lineupSet;
	
	
	
	
	@Override
	public void afterPropertiesSet() throws Exception {
		lineupSet = new HashSet<String>();
		
		lineupSet.add("CPFPG");

		lineupSet.add("CPFSG");

		lineupSet.add("CPFSW");

		lineupSet.add("CSFPG");

		lineupSet.add("CSFSG");

		lineupSet.add("CSFSW");

		lineupSet.add("CSWPG");

		lineupSet.add("CSWSG");
		
		lineupSet.add("CSWSW");

		lineupSet.add("CSGPG");

		lineupSet.add("CSGSG");

		lineupSet.add("CPGPG");

		lineupSet.add("PFPFPG");

		lineupSet.add("PFPFSG");

		lineupSet.add("PFPFSW");

		lineupSet.add("PFSFPG");

		lineupSet.add("PFSFSG");

		lineupSet.add("PFSFSW");

		lineupSet.add("PFSWPG");

		lineupSet.add("PFSWSG");

		lineupSet.add("PFSWSW");
		
		System.out.println("所有阵容初始化完成");
		
	}
	
	
	
	
	
	
	

	
	@Override
	public Map<String, Object> addTeam(String userIdMember1,String userIdMember2,String userIdMember3,String lineup,String gameId) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		Team team = new Team();
		
		team.setTeamId(randomNumberUtil.generateTeamID());
		team.setMember1(userIdMember1);
		team.setMember2(userIdMember2);
		team.setMember3(userIdMember3);
		team.setStatus(0);
		team.setGameId(gameId);
		team.setLineup(lineup);
		
		System.out.println("userIdMember1:" + userIdMember1);
		System.out.println("userIdMember2:" + userIdMember2);
		System.out.println("userIdMember3:" + userIdMember3);
		
		System.out.println("userService.selectUserById(userIdMember1):" + userService.selectUserById(userIdMember1));
		System.out.println("userService.selectUserById(userIdMember2):" + userService.selectUserById(userIdMember2));
		System.out.println("userService.selectUserById(userIdMember3):" + userService.selectUserById(userIdMember3));
		
		team.setName(userService.selectUserById(userIdMember1).getGameName() + "-" + 
				     userService.selectUserById(userIdMember2).getGameName() + "-" + 
				     userService.selectUserById(userIdMember3).getGameName()
		);
		
		team.setMember1GameName(userService.selectUserById(userIdMember1).getGameName());
		team.setMember2GameName(userService.selectUserById(userIdMember2).getGameName());
		team.setMember3GameName(userService.selectUserById(userIdMember3).getGameName());
		
		
		teamMapper.insert(team);
		
		map.put("team", team);
		
		map.put("addTeamSuc", "addTeamSuc");
		
		return map;
	}



	
	@Override
	public Map<String, Object> startGroup(String gameId) {
		
		Map<String,Object> map = new HashMap<String,Object>();
		
		if(gameId == null || "".equals(gameId)){
			map.put("groupError", "你要分组的赛事不存在");
			return map;
		}
		
		Game game2 = gameMapper.selectByPrimaryKey(gameId);
		if(game2 == null){
			map.put("groupError", "你要分组的赛事不存在");
			return map;
		}
		
		
		// 查询 一个 赛事 的 所有 报名信息
		EnrollExample example = new EnrollExample();
		Criteria criteria = example.createCriteria();
		criteria.andGameIdEqualTo(gameId);
		List<Enroll> enrollList = enrollMapper.selectByExample(example);
		
		System.out.println("报名人数_enrollList.size():" + enrollList.size());
		
		if(enrollList.size() < 6){
			map.put("groupError", "报名人数少于6人，暂时不能分组");
			return map;
		}
		
		
		
		
		
		System.out.println("开始分组startGroup");
		
		
		for (Enroll enroll : enrollList) {
			Integer score = enroll.getAbilityScore(); 
			
			jedisAdapter.zadd(
					RedisKeyUtil.getStartGroupKey(gameId),
					score,
					enroll.getEnrollId()
			);
			
		}
		
		Set<String> set = jedisAdapter.zrange(RedisKeyUtil.getStartGroupKey(gameId), 0, -1);
		
		if(jedisAdapter.exists(RedisKeyUtil.getGroupListKey(gameId))){
			jedisAdapter.del(RedisKeyUtil.getGroupListKey(gameId));
		}
		
		for (String enrollId : set) {
			System.out.println("Sorted Sets _ enrollId:" + enrollId);
			
			jedisAdapter.lpush(RedisKeyUtil.getGroupListKey(gameId), enrollId);
			
		}
		
		Long listLen = jedisAdapter.llen(RedisKeyUtil.getGroupListKey(gameId));
		Integer num = 0;
		String key = RedisKeyUtil.getGroupListKey(gameId);
		
		List<Team> teamList = new ArrayList<Team>();
		
		while(listLen > 2){
			
			System.out.println("现在listLen的值：" + listLen);
			
			if(num == 0){
				
				String enrollId1 = jedisAdapter.lpop(key);
				
				String enrollId2 = jedisAdapter.rpop(key);
				
				String enrollId3 = jedisAdapter.lpop(key);
				
				String lineup = "";
				
				Long listLenTemp = listLen-2;
				System.out.println("循环前listLenTemp:" + listLenTemp);
				
				while("".equals(lineup) && listLenTemp > 1){
					String newEnrollId3 = jedisAdapter.lpop(key);
					
					jedisAdapter.rpush(key, enrollId3);
					
					enrollId3 = newEnrollId3;
					
					System.out.println("现在的listLenTemp:" + listLenTemp);
					
					lineup = judgeLineup(enrollId1, enrollId2, enrollId3, key ,gameId,teamList);
					listLenTemp--;
				}
				
				if("".equals(lineup)){
					
					Enroll enroll1 = enrollService.selectEnrollByEnrollId(enrollId1).get(0);
					Enroll enroll2 = enrollService.selectEnrollByEnrollId(enrollId2).get(0);
					Enroll enroll3 = enrollService.selectEnrollByEnrollId(enrollId3).get(0);
					
					String userIdMember1 = enroll1.getUserId();
					String userIdMember2 = enroll2.getUserId();
					String userIdMember3 = enroll3.getUserId();
					
					Map<String, Object> map2 = addTeam(userIdMember1, userIdMember2, userIdMember3, "随便组的", gameId);
					teamList.add((Team)map2.get("team"));
				}
				
			}else if(num == 1){
				
				
				String enrollId1 = jedisAdapter.rpop(key);
				
				String enrollId2 = jedisAdapter.lpop(key);
				
				String enrollId3 = jedisAdapter.rpop(key);
				
				String lineup = "";
				
				Long listLenTemp = listLen-2;
				System.out.println("循环前listLenTemp:" + listLenTemp);
				
				while("".equals(lineup) && listLenTemp > 1){
					String newEnrollId3 = jedisAdapter.rpop(key);
					
					jedisAdapter.lpush(key, enrollId3);
					
					enrollId3 = newEnrollId3;
					
					System.out.println("现在的listLenTemp:" + listLenTemp);
					
					lineup = judgeLineup(enrollId1, enrollId2, enrollId3, key ,gameId,teamList);
					listLenTemp--;
				}
				
				if("".equals(lineup)){
					
					Enroll enroll1 = enrollService.selectEnrollByEnrollId(enrollId1).get(0);
					Enroll enroll2 = enrollService.selectEnrollByEnrollId(enrollId2).get(0);
					Enroll enroll3 = enrollService.selectEnrollByEnrollId(enrollId3).get(0);
					
					String userIdMember1 = enroll1.getUserId();
					String userIdMember2 = enroll2.getUserId();
					String userIdMember3 = enroll3.getUserId();
					
					Map<String, Object> map2 = addTeam(userIdMember1, userIdMember2, userIdMember3, "随便组的", gameId);
					teamList.add((Team)map2.get("team"));
					
				}
				
			}
			
			
			if(num == 0){
				num++;
			}
			if(num == 1){
				num--;
			}
			
			listLen = listLen - 3;
			
		}
		
		
		
		
		
		
		
		eventProducer.fireEvent(new EventModel(EventType.GROUPTEAMSUC)
				.setActorId(gameId)
				.setExt("teamList", JSON.toJSONString(teamList))
		);
		
		map.put("startGroupSuc", "startGroupSuc");
		
		return map;
	}

	
	
	
	private String judgeLineup(String enrollId1,String enrollId2,String enrollId3,String key,String gameId,List<Team> teamList){
		
		Enroll enroll1 = enrollService.selectEnrollByEnrollId(enrollId1).get(0);
		Enroll enroll2 = enrollService.selectEnrollByEnrollId(enrollId2).get(0);
		Enroll enroll3 = enrollService.selectEnrollByEnrollId(enrollId3).get(0);
		
		String userIdMember1 = enroll1.getUserId();
		String userIdMember2 = enroll2.getUserId();
		String userIdMember3 = enroll3.getUserId();
		
		
		List<String> list1 = JSON.parseObject(enroll1.getPosition(),List.class);
		List<String> list2 = JSON.parseObject(enroll2.getPosition(),List.class);
		List<String> list3 = JSON.parseObject(enroll3.getPosition(),List.class);
		
		String lineup = "";
		
		loop:for (int i = 0; i < list1.size(); i++) {
			for (int j = 0; j < list2.size(); j++) {
				for (int j2 = 0; j2 < list3.size(); j2++) {
					
					
					lineup = GeneralUtils.posSort(list1.get(i), list2.get(j), list3.get(j2));
					
					System.out.println("judgeLineup_组成的阵容是：" + lineup);
					
					if(lineupSet.contains(lineup)){
						System.out.println("judgeLineup_组队成功，阵容：" + lineup);
						Map<String, Object> map = addTeam(userIdMember1, userIdMember2, userIdMember3, lineup, gameId);
						teamList.add((Team)map.get("team"));
						break loop; 
						
					}else{
						System.out.println("不符合阵容规范");
						lineup = "";
					}
				}
			}
		}
		
		
			
		
		return lineup;
	}








	
	@Override
	public LayuiTableData selectAllTeamByGameId(String gameId,Integer page,Integer limit) {
		
		PageHelper.startPage(page, limit);
		
		TeamExample example = new TeamExample();
		club.fsCommunity.pojo.TeamExample.Criteria criteria = example.createCriteria();
		criteria.andGameIdEqualTo(gameId);
		List<Team> list = teamMapper.selectByExampleWithBLOBs(example);
		
		PageInfo<Team> pageInfo = new PageInfo<Team>(list);
		
		LayuiTableData data = new LayuiTableData();
		data.setCode(0);
		data.setMsg("");
		data.setCount(pageInfo.getTotal());
		data.setData(list);
		
		return data;
	}


	
	@Override
	public List<Team> selectTeamByTeamId(String teamId) {
		
		TeamExample example = new TeamExample();
		club.fsCommunity.pojo.TeamExample.Criteria criteria = example.createCriteria();
		criteria.andTeamIdEqualTo(teamId);
		List<Team> list = teamMapper.selectByExampleWithBLOBs(example);
		
		return list;
	}


	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
