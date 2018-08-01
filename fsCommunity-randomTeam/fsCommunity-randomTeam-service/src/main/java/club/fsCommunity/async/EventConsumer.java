package club.fsCommunity.async;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSON;
import club.fsCommunity.common.utils.RedisKeyUtil;
import club.fsCommunity.jedis.JedisAdapter;
@Service
public class EventConsumer implements InitializingBean,ApplicationContextAware {
	private ApplicationContext applicationContext;
	@Autowired
	JedisAdapter jedisAdapter;
	private Map<EventType, List<EventHandler>> config = new HashMap<EventType, List<EventHandler>>();
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		Map<String, EventHandler> beans = applicationContext.getBeansOfType(EventHandler.class);
		if(beans != null){
			for (Map.Entry<String, EventHandler> entry : beans.entrySet()) {
				List<EventType> eventTypes = entry.getValue().getSupportEventTypes();
				for (EventType type : eventTypes) {
					if(!config.containsKey(type)){
						config.put(type, new ArrayList<EventHandler>());
					}
					config.get(type).add(entry.getValue());
				}
			}
		}
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				while(true){
					String key = RedisKeyUtil.getEventQueueKey(); 
					List<String> events = jedisAdapter.brpop(0, key);
					for (String message : events) {
						if(message.equals(key)){ 
							continue;
						}
						EventModel eventModel = JSON.parseObject(message,EventModel.class);
						if(!config.containsKey(eventModel.getEventType())){
							System.out.println("不能识别的事件");
							continue;
						}
						for (EventHandler handler : config.get(eventModel.getEventType())) {
							handler.doHandle(eventModel);
						}
					}
				}
			}
		});
		thread.start(); 
	}
}
