package club.fsCommunity.async.handler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import club.fsCommunity.async.EventHandler;
import club.fsCommunity.async.EventModel;
import club.fsCommunity.async.EventType;

/**
 * 处理 点赞事件 的 Handler，实现了 EventHandler
 * @author Administrator
 *
 */
@Service
public class LikeHandler implements EventHandler {

	@Override
	public void doHandle(EventModel eventModel) {
		System.out.println("Liked");
		
	}

	@Override
	public List<EventType> getSupportEventTypes() {
		List<EventType> list = new ArrayList<EventType>();
		list.add(EventType.LIKE);
		
		return list;
	}

}
