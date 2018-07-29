package club.fsCommunity.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

import club.fsCommunity.common.utils.RedisKeyUtil;
import club.fsCommunity.jedis.JedisAdapter;

@Service // 因为要给 各种 业务 使用，所以 是 一个 Service
public class EventProducer {

	/**
     * 这是 接收 事件 的 类，它 会 把 接收到的事件 放进队列；
     * 在这里 使用 redis 作为 事件队列
     */
	
	@Autowired
	JedisAdapter jedisAdapter;
	
	
	// fire ：火；发射。
    // 把 事件 发送到 队列
    // 发事件 速度是很快的，因为它 只是 发送，不处理。
	public boolean fireEvent(EventModel eventModel){
		try {
			// 序列化 为 json
			String json = JSONObject.toJSONString(eventModel);
			String key = RedisKeyUtil.getEventQueueKey();
			
			// 加入到 redis 的 list 中
			jedisAdapter.lpush(key, json);
			
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	
}
