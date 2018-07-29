package club.fsCommunity.async;

import java.util.HashMap;
import java.util.Map;

/**
 * 事件 实体，放到 事件队列里 的 东西
 * @author Administrator
 *
 */
public class EventModel {

	private EventType eventType; // 事件类型
	private String actorId; // 事件触发者id
	
	// entityType 与 entityId 表示 被触发 对象，某个 类 里 的 某个 id 对应 的 对象，扩展了 适用 范围
	private int entityType;
	private String entityId;
	
	private String entityOwnerId; // 被触发 对象 的 拥有者
	
	// 因为 触发事件 的时候，还会涉及 很多信息，这些信息 可以称为 现场信息，
    // 把 现场信息 用 一个 Map 来记录。
	private Map<String, String> exts = new HashMap<String, String>();
	
	
	// 默认 的构造函数，JSON.parseObject(value,clazz) 会调用 这个 构造函数
	public EventModel(){
		
	}
	
	// 通过 事件类型 构造EventModel
	public EventModel(EventType eventType){
		this.eventType = eventType;
	}
	
	// 封装 exts 的 get、put 方法
	public String getExt(String key){
		return exts.get(key);
	}
	
	public EventModel setExt(String key,String value){
		exts.put(key, value);
		return this; // 设置好 exts 后，把 当前 EventModel 对象 返回
	}
	
	
	
	
	
	
	
	
	/**
     * 以下 所有 setter 方法 都把 当前 EventModel 对象 返回，这样 写代码 会更方便。
     */

	public EventType getEventType() {
		return eventType;
	}

	public EventModel setEventType(EventType eventType) {
		this.eventType = eventType;
		return this;
	}

	public String getActorId() {
		return actorId;
	}

	public EventModel setActorId(String actorId) {
		this.actorId = actorId;
		return this;
	}

	public int getEntityType() {
		return entityType;
	}

	public EventModel setEntityType(int entityType) {
		this.entityType = entityType;
		return this;
	}

	public String getEntityId() {
		return entityId;
	}

	public EventModel setEntityId(String entityId) {
		this.entityId = entityId;
		return this;
	}

	public String getEntityOwnerId() {
		return entityOwnerId;
	}

	public EventModel setEntityOwnerId(String entityOwnerId) {
		this.entityOwnerId = entityOwnerId;
		return this;
	}

	public Map<String, String> getExts() {
		return exts;
	}

	// 这个 setter 方法 就 不用 返回 EventModel 了
	public void setExts(Map<String, String> exts) {
		this.exts = exts;
	}
	
}
