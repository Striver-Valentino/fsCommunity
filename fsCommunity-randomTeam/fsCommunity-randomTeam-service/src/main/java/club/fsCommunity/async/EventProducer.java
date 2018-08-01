package club.fsCommunity.async;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSONObject;
import club.fsCommunity.common.utils.RedisKeyUtil;
import club.fsCommunity.jedis.JedisAdapter;
@Service
public class EventProducer {
	@Autowired
	JedisAdapter jedisAdapter;
	
	public boolean fireEvent(EventModel eventModel){
		try {
			
			String json = JSONObject.toJSONString(eventModel);
			String key = RedisKeyUtil.getEventQueueKey();
			
			jedisAdapter.lpush(key, json);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
