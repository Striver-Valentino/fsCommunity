package club.fsCommunity.async;

import java.util.List;

/**
 * 事件 处理 的接口
 * @author Administrator
 *
 */
public interface EventHandler {

	/**
     * 因为 每个 事件 处理 的方式 是不一样的，所以 抽象 成接口
     */
	
	// 对事件 的 处理 的 方法
	void doHandle(EventModel eventModel);
	
	// 要关注 哪些 类型的 事件（即 这个 Handler 要去 处理 哪些 事件）
	List<EventType> getSupportEventTypes();
	
}
