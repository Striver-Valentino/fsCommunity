package club.fsCommunity.async;

/**
 * 异步队列里 事件的类型，枚举类型
 * @author Administrator
 *
 */
public enum EventType {

	LIKE(0),
    COMMENT(1),
    LOGIN(2),
    MAIL(3),
	REG(4),
	ENROLLSUC(5), // 赛事报名成功 事件
	GROUPTEAMSUC(6);  // 赛事分组成功事件
	
	private int value;
	
	EventType(int value){
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	
	
	
	public static void main(String[] args) {
        /**
         * 得到枚举中所有值：只要一个类是枚举类型，它都会有一个values()方法
         */
        EventType[] values = EventType.values();
        for (EventType value : values) {
            System.out.println(value);
        }

        // 获得 某个 枚举值 的 value值
        System.out.println(EventType.LIKE.getValue()); // 打印 0
        System.out.println(EventType.LIKE); // 打印 LIKE
    }
	
}
