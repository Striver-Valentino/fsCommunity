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
	
	// 所有可能 的 阵容  的 集合
	private Set<String> lineupSet;
	
	
	
	/**
	 * 初始化 TeamServiceImpl 的时候 ，就会 执行 这个方法
	 */
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
	
	
	
	
	
	
	

	/**
	 * 增加一支队伍
	 */
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
		
		// 设置 队伍 名称
		team.setName(userService.selectUserById(userIdMember1).getGameName() + "-" + 
				     userService.selectUserById(userIdMember2).getGameName() + "-" + 
				     userService.selectUserById(userIdMember3).getGameName()
		);
		
		// 设置队员游戏昵称
		team.setMember1GameName(userService.selectUserById(userIdMember1).getGameName());
		team.setMember2GameName(userService.selectUserById(userIdMember2).getGameName());
		team.setMember3GameName(userService.selectUserById(userIdMember3).getGameName());
		
		
		teamMapper.insert(team);
		
		map.put("team", team);
		
		map.put("addTeamSuc", "addTeamSuc");
		
		return map;
	}



	/**
	 * 开始分组
	 */
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
		
		
		
		/**
		 * 如果以上检查没问题，下面正式开始分组
		 */
		
		System.out.println("开始分组startGroup");
		
		/**
		 * 计算 每一个 Enroll 的 分值，然后 放到 redis 的 Sorted Sets 里 排序，接着 根据 排序 来 分组。
		 * 
		 * 先放到 Sorted Sets 里 排序，然后 把 排好序的 放到 list 中。
		 * 
		 * 分好组的同时，所有 队伍 对象 也都 生成好。
		 * 
		 */
		for (Enroll enroll : enrollList) {
			Integer score = enroll.getAbilityScore(); // 可以优化，在 报名成功时，生成 一个 事件，放进事件队列，然后在处理器里 把 enroll 的 abilityScore 计算好  存数据库里，然后 直接 get 出来即可。
			//Integer score = GeneralUtils.calAbilityScore(enroll);
			
			jedisAdapter.zadd(
					RedisKeyUtil.getStartGroupKey(gameId),
					score,
					enroll.getEnrollId()
			);
			
		}
		
		// 所有 enroll 与 分值  放进  Sorted Sets 里 后 ，再 从小到大 拿出来，从 左边 一个个 地 放进 list
		Set<String> set = jedisAdapter.zrange(RedisKeyUtil.getStartGroupKey(gameId), 0, -1);
		
		if(jedisAdapter.exists(RedisKeyUtil.getGroupListKey(gameId))){ // 如果存在这个 key，先删除，然后 下面 再重新 建一个
			jedisAdapter.del(RedisKeyUtil.getGroupListKey(gameId));
		}
		
		// 虽然返回的是 set ，但是 顺序 是 排好的 （set 是无序的）
		for (String enrollId : set) {
			System.out.println("Sorted Sets _ enrollId:" + enrollId);
			
			jedisAdapter.lpush(RedisKeyUtil.getGroupListKey(gameId), enrollId); // 如果 key 不存在，会  新 建一个
			
		}
		
		// 从 list 取出 排好序的 enrollId ，顺序是 从左边取一次，从右边取一次，从左边取一次，从右边取一次，从左边取一次，从右边取一次，......  交替进行。
		Long listLen = jedisAdapter.llen(RedisKeyUtil.getGroupListKey(gameId));
		Integer num = 0;
		String key = RedisKeyUtil.getGroupListKey(gameId);
		
		// 队伍 集合，用来保存 生成 的 所有 队伍，放到 redis 中，在异步处理中，由 handler 从 redis里 取出来，生成 对阵 情况。 
		List<Team> teamList = new ArrayList<Team>();
		
		while(listLen > 2){
			
			System.out.println("现在listLen的值：" + listLen);
			
			if(num == 0){
				// 先从左边取
				
				// 取出 enrollId 后 ，找出 对应的 userId ，用于 组队（生成 Team 对象）
				String enrollId1 = jedisAdapter.lpop(key); // 返回的是  enrollId
				
				String enrollId2 = jedisAdapter.rpop(key);
				
				String enrollId3 = jedisAdapter.lpop(key);
				
				String lineup = "";
				
				Long listLenTemp = listLen-2; // 保证 第一次 能进入 下面的 while 循环
				System.out.println("循环前listLenTemp:" + listLenTemp);
				
				while("".equals(lineup) && listLenTemp > 1){ // 如果  lineup 是空 ，说明 阵容不符合 规范
					// 再 从 redis 的 list 拿出 一个enrollId，然后  把  enrollId3  放回 list（从 反方向 右边 放回去）
					String newEnrollId3 = jedisAdapter.lpop(key);
					
					jedisAdapter.rpush(key, enrollId3);
					
					enrollId3 = newEnrollId3;
					
					// 获得 实时 元素个数
					//listLenTemp = jedisAdapter.llen(RedisKeyUtil.getGroupListKey(gameId)) - 2;
					System.out.println("现在的listLenTemp:" + listLenTemp);
					
					lineup = judgeLineup(enrollId1, enrollId2, enrollId3, key ,gameId,teamList);
					listLenTemp--;
				}
				
				if("".equals(lineup)){ // 如果  lineup 还是空 ，说明  遍历了所有参赛者   阵容  都  不符合 规范，只能 随便 组了
					// 直接 拿 当前 的 enrollId1, enrollId2, enrollId3 组队。
					
					Enroll enroll1 = enrollService.selectEnrollByEnrollId(enrollId1).get(0);
					Enroll enroll2 = enrollService.selectEnrollByEnrollId(enrollId2).get(0);
					Enroll enroll3 = enrollService.selectEnrollByEnrollId(enrollId3).get(0);
					
					// 查询出 报名信息 对应的 用户id
					String userIdMember1 = enroll1.getUserId();
					String userIdMember2 = enroll2.getUserId();
					String userIdMember3 = enroll3.getUserId();
					
					Map<String, Object> map2 = addTeam(userIdMember1, userIdMember2, userIdMember3, "随便组的", gameId);
					teamList.add((Team)map2.get("team"));
				}
				
			}else if(num == 1){
				// 先从右边取
				
				
				// 取出 enrollId 后 ，找出 对应的 userId ，用于 组队（生成 Team 对象）
				String enrollId1 = jedisAdapter.rpop(key); // 返回的是  enrollId
				
				String enrollId2 = jedisAdapter.lpop(key);
				
				String enrollId3 = jedisAdapter.rpop(key);
				
				String lineup = "";
				
				Long listLenTemp = listLen-2; // 保证 第一次 能进入 下面的 while 循环
				System.out.println("循环前listLenTemp:" + listLenTemp);
				
				while("".equals(lineup) && listLenTemp > 1){ // 如果  lineup 是空 ，说明 阵容不符合 规范
					// 再 从 redis 的 list 拿出 一个enrollId，然后  把  enrollId3  放回 list（从 反方向 左边 放回去）
					String newEnrollId3 = jedisAdapter.rpop(key);
					
					jedisAdapter.lpush(key, enrollId3);
					
					enrollId3 = newEnrollId3;
					
					// 获得 实时 元素个数
					//listLenTemp = jedisAdapter.llen(RedisKeyUtil.getGroupListKey(gameId)) - 2;
					System.out.println("现在的listLenTemp:" + listLenTemp);
					
					lineup = judgeLineup(enrollId1, enrollId2, enrollId3, key ,gameId,teamList);
					listLenTemp--;
				}
				
				if("".equals(lineup)){ // 如果  lineup 还是空 ，说明  遍历了所有参赛者   阵容  都  不符合 规范，只能 随便 组了
					// 直接 拿 当前 的 enrollId1, enrollId2, enrollId3 组队。
					
					Enroll enroll1 = enrollService.selectEnrollByEnrollId(enrollId1).get(0);
					Enroll enroll2 = enrollService.selectEnrollByEnrollId(enrollId2).get(0);
					Enroll enroll3 = enrollService.selectEnrollByEnrollId(enrollId3).get(0);
					
					// 查询出 报名信息 对应的 用户id
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
		
		
		
		/**
		 * 分组完成后，teamList 里的 队伍 都放到 redis 的 set 中 （一个 新的 set）
		 */
		/*for (Team team : teamList) {
			jedisAdapter.sadd(RedisKeyUtil.getGroupTeamKey(gameId), team.getTeamId());
		}*/
		
		/**
		 * 生成分组成功 事件，在异步里，把 对阵 情况 生成。 还要把 对应 的 赛事 的 分组状态 改为1，表示 已经 分组。
		 */
		eventProducer.fireEvent(new EventModel(EventType.GROUPTEAMSUC)
				.setActorId(gameId)
				.setExt("teamList", JSON.toJSONString(teamList))
		);
		
		map.put("startGroupSuc", "startGroupSuc");
		
		return map;
	}

	
	
	/**
	 * 判断 阵容 是否 符合 规范
	 */
	private String judgeLineup(String enrollId1,String enrollId2,String enrollId3,String key,String gameId,List<Team> teamList){
		
		Enroll enroll1 = enrollService.selectEnrollByEnrollId(enrollId1).get(0);
		Enroll enroll2 = enrollService.selectEnrollByEnrollId(enrollId2).get(0);
		Enroll enroll3 = enrollService.selectEnrollByEnrollId(enrollId3).get(0);
		
		// 查询出 报名信息 对应的 用户id
		String userIdMember1 = enroll1.getUserId();
		String userIdMember2 = enroll2.getUserId();
		String userIdMember3 = enroll3.getUserId();
		
		/**
		 * 判断 3个  报名信息中 的 参赛职业 是否  符合 阵容 要求。
		 * 如果 不符合，就 放回 redis 的 list 中 （从左边取的，从左边放回；从右边取的，从右边放回）
		 */
		List<String> list1 = JSON.parseObject(enroll1.getPosition(),List.class);
		List<String> list2 = JSON.parseObject(enroll2.getPosition(),List.class);
		List<String> list3 = JSON.parseObject(enroll3.getPosition(),List.class);
		
		String lineup = "";
		
		loop:for (int i = 0; i < list1.size(); i++) {
			for (int j = 0; j < list2.size(); j++) {
				for (int j2 = 0; j2 < list3.size(); j2++) {
					
					// 参赛职业 排序，便于 与 lineupSet 的内容 比对
					
					lineup = GeneralUtils.posSort(list1.get(i), list2.get(j), list3.get(j2));
					
					System.out.println("judgeLineup_组成的阵容是：" + lineup);
					
					if(lineupSet.contains(lineup)){
						// 组队成功
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
		
		/*if("".equals(lineup)){ // 说明 不符合 阵容 规范
			// 再 拿出 一个enrollId，然后  把 enroll3 放回 list
			String lpop = jedisAdapter.lpop(key);
			
			jedisAdapter.lpush(key, enrollId3);
			
			
			
			
			
			
		}*/
			
		
		return lineup;
	}








	/**
	 * 查询 一个赛事的 所有 队伍
	 */
	@Override
	public LayuiTableData selectAllTeamByGameId(String gameId,Integer page,Integer limit) {
		
		//开始分页
		PageHelper.startPage(page, limit);
		
		TeamExample example = new TeamExample();
		club.fsCommunity.pojo.TeamExample.Criteria criteria = example.createCriteria();
		criteria.andGameIdEqualTo(gameId);
		List<Team> list = teamMapper.selectByExampleWithBLOBs(example);
		
		// 得到分页信息
		PageInfo<Team> pageInfo = new PageInfo<Team>(list);
		
		LayuiTableData data = new LayuiTableData();
		data.setCode(0);
		data.setMsg("");
		data.setCount(pageInfo.getTotal());
		data.setData(list);
		
		return data;
	}


	/**
	 * 根据 队伍id 查询 队伍
	 */
	@Override
	public List<Team> selectTeamByTeamId(String teamId) {
		
		TeamExample example = new TeamExample();
		club.fsCommunity.pojo.TeamExample.Criteria criteria = example.createCriteria();
		criteria.andTeamIdEqualTo(teamId);
		List<Team> list = teamMapper.selectByExampleWithBLOBs(example);
		
		return list;
	}


	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
