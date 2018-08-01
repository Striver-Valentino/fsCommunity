package club.fsCommunity.async;
import java.util.HashMap;
import java.util.Map;
public class EventModel {
	private EventType eventType;
	private String actorId;
	private int entityType;
	private String entityId;
	private String entityOwnerId; 
	
	private Map<String, String> exts = new HashMap<String, String>();
	
	public EventModel(){
	}
	
	public EventModel(EventType eventType){
		this.eventType = eventType;
	}
	
	public String getExt(String key){
		return exts.get(key);
	}
	public EventModel setExt(String key,String value){
		exts.put(key, value);
		return this; 
	}
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
	
	public void setExts(Map<String, String> exts) {
		this.exts = exts;
	}
}
