package club.fsCommunity.async;
public enum EventType {
	LIKE(0),
    COMMENT(1),
    LOGIN(2),
    MAIL(3),
	REG(4),
	ENROLLSUC(5),
	GROUPTEAMSUC(6);
	private int value;
	EventType(int value){
		this.value = value;
	}
	public int getValue() {
		return value;
	}
	
}
