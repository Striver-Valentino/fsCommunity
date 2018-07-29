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

	/**
     * 处理 队列里 事件 的 类；
     * 它需要组织 有关 的 Handler 来 处理事件（因为 一个事件 可能需要 多个 Handler 处理）
     */
	
	private ApplicationContext applicationContext;
	
	@Autowired
	JedisAdapter jedisAdapter;
	
	/**
     * 每一个类型的事件 对应 处理它自己 的 所有 Handler（用 list 来装）；
     * 把这个 config 初始化 好，以后 每来一个 事件，都能 找到 对应的 所有 Handler，然后 依次执行 即可。
     */
	private Map<EventType, List<EventHandler>> config = new HashMap<EventType, List<EventHandler>>();
	
	
	
	
	
	
	/**
	 * 实现 ApplicationContextAware 的 setApplicationContext 方法，得到 ApplicationContext 对象，可以 知道 整个 spring 容器
     * 的情况，就可以 收集 所有 实现 EventHandler接口 的 类（前提 是 这些类 也要在 spring 容器中，只要 在这些类上 加上 @Component 或  @Service 即可）
	 */
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {

		this.applicationContext = applicationContext;
	}

	
	
	/**
	 * 因为 EventConsumer 实现了 InitializingBean 接口，所以 在 spring
     * 容器里 初始化 EventConsumer 时，会 执行 afterPropertiesSet() 方法。
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		
		/**
         * 把 所有 实现 EventHandler接口 的 类 收集起来，
         * 然后 做一个路由：哪种 事件 需要 哪些 Handler；
         * 这个路由功能 在初始化 时 就 准备好，方便 后面使用。
         */
		
		// getBeansOfType 根据 类型 得到 bean
		Map<String, EventHandler> beans = applicationContext.getBeansOfType(EventHandler.class);
		
		// 遍历，只需要 遍历  Map<String, EventHandler> 的 value 即可，key 可以不用管。
		if(beans != null){
			for (Map.Entry<String, EventHandler> entry : beans.entrySet()) {
				// 得到 一个 Handler 关心 的 所有 EventType
				List<EventType> eventTypes = entry.getValue().getSupportEventTypes();
				
				for (EventType type : eventTypes) {
					if(!config.containsKey(type)){ // 确保 EventType 在 config 里对应 的 EventHandler 的 List 不为空
						config.put(type, new ArrayList<EventHandler>());
					}
					config.get(type).add(entry.getValue()); // 逐渐 记录 处理 EventType 所需要 的 所有 Handler
				}
			}
		}
		
		
		// 以上 初始化 工作 做完后，开启一个线程；事件队列 是一个 阻塞 的 队列。
        /**
         * 这个 线程 要做的是，不断地 从 事件队列里 取 事件，然后 交给 响应 的 Handler 处理。
         */
		
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				while(true){
					String key = RedisKeyUtil.getEventQueueKey();  // 事件队列 的 key 是固定的 "EVENT" ，可以在 RedisKeyUtil 类 里面看
					
					// 事件队列 是一个 阻塞 的 队列 ，里面 有 事件，就去处理，没有 就 什么都不做。与 jedis.brpop 方法 呼应。
                    // 根据 key 从 事件队列 里 取出数据，因为 在 EventProducer 里 是用 lpush 从 左边 插进去的，所以 在这里 要从 右边 拉出来。
					// 超时参数设为 0 表示阻塞时间可以无限期延长；即 一直 等待，队列里 有事件 就 取事件，没有 就 等待。配合 while (true) 就可以 不断地 取 队列里 的 事件。
					List<String> events = jedisAdapter.brpop(0, key);
					
					for (String message : events) {// brpop命令，假如在指定时间内没有任何元素被弹出，则返回一个 nil 和等待时长。
                                                   // 反之，返回一个含有两个元素的列表，第一个元素是被弹出元素所属的 key ，第二个元素是被弹出元素的值。
						if(message.equals(key)){   // 先 过滤掉  被弹出元素所属的 key ；message 其实是一个 json数据，但 json 也是 String 的一种。
							continue;
						}
						
						// 反序列化 json
						EventModel eventModel = JSON.parseObject(message,EventModel.class);
						
						//接下来 要 对取出的事件 用 Handler 处理
						
						if(!config.containsKey(eventModel.getEventType())){
							System.out.println("不能识别的事件");
							continue; // 没有对应的 Handler ，就 跳过去。
						}
						
						// 每个 Handler 去处理
						for (EventHandler handler : config.get(eventModel.getEventType())) {
							handler.doHandle(eventModel);
						}
						
					}
				}
				
			}
		});
		
		thread.start(); // 这个 线程 是 spring 容器 初始化 之后 就 开始运行的，并且是 一直 运行，因为有 while (true)
			
	}

	
	
	
	
}
