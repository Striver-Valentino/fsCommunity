package club.fsCommunity.async.handler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import club.fsCommunity.async.EventHandler;
import club.fsCommunity.async.EventModel;
import club.fsCommunity.async.EventType;
import club.fsCommunity.common.utils.GeneralUtils;
import club.fsCommunity.mapper.EnrollMapper;
import club.fsCommunity.pojo.Enroll;
import club.fsCommunity.pojo.Game;
import club.fsCommunity.service.EnrollService;
import club.fsCommunity.service.GameService;


@Service
public class EnrollHandler implements EventHandler {
	
	@Autowired
	private EnrollService enrollService;
	
	@Autowired
	private GameService gameService;
	

	@Override
	public void doHandle(EventModel eventModel) {
		
		System.out.println("正在计算 报名信息 能力分值");
		
		String enrollId = eventModel.getExt("enrollId");
		List<Enroll> list = enrollService.selectEnrollByEnrollId(enrollId);
		
		Integer score = GeneralUtils.calAbilityScore(list.get(0));
		
		Map<String, Object> map = enrollService.updateEnrollAbilityScore(enrollId, score);
		
		System.out.println("计算 报名信息 能力分值 完成");
		
		if(map.containsKey("updateEnrollScoreSuc")){
			System.out.println("更新能力分值成功：" + (String)map.get("updateEnrollScoreSuc"));
		}else{
			System.out.println("更新能力分值出错：" + (String)map.get("updateEnrollScoreError"));
		}
		
		
		
		
		String gameId = eventModel.getExt("gameId");
		Map<String, Object> map2 = gameService.applyCountAddOne(gameId);
		
		System.out.println("对应 的 赛事   报名 人数+1，gameId:" + gameId);
		
		if(map2.containsKey("applyCountAddOneSuc")){
			System.out.println("赛事  报名人数更新成功：" + (String)map.get("applyCountAddOneSuc"));
		}else{
			System.out.println("赛事  报名人数更新出错：" + (String)map.get("applyCountAddOneError"));
		}
		
	}

	@Override
	public List<EventType> getSupportEventTypes() {
		List<EventType> list = new ArrayList<EventType>();
		list.add(EventType.ENROLLSUC);
		
		return list;
	}

}
