package club.fsCommunity.common.utils;

public class RedisKeyUtil {

	/**
     * 因为 redis 不一定 只 用来 做 点赞，也可以用来 统计 pv 等等，
     * 不同 的 业务 应该有 不同 的 key，以示区别；否则，一个系统 那么多 redis 处理的
     * 业务，那么多key，如果 恰好 有相同 的 key，对应的数据 就会 覆盖。
     *
     * 所以 ，要有 一套 key 的规范。
     */
	
	
	
	
	// key 开头 与 key 内容 的分隔符
	private static String SPLIT = ":";
	
	// 点赞 的 业务 的 key 以 "LIKE" 开头
	private static String BIZ_LIKE = "LIKE";
	// 点踩 的 业务 的 key 以 "DISLIKE" 开头
	private static String BIZ_DISLIKE = "DISLIKE";
	// 处理异步队列 事件 的 key 开头
	private static String BIZ_EVENT = "EVENT";
	
	private static String BIZ_GROUPSORTED = "GROUPSORTED";
	
	private static String BIZ_GROUPLIST = "GROUPLIST";
	
	private static String BIZ_GROUPTEAMSET = "GROUPTEAMSET";
	
	
	
	// 事件 队列 的 key
	public static String getEventQueueKey(){
		return BIZ_EVENT;
	} 
	
	// 赛事分组时，把 所有 报名信息 放进 redis 的 Sorted Sets 里   的 key
	public static String getStartGroupKey(String gameId){
		return BIZ_GROUPSORTED + SPLIT + gameId;
	} 
	
	// 赛事分组时，把 所有  Sorted Sets 里  排好序  的  报名信息 放进 redis 的 list 里   的 key
	public static String getGroupListKey(String gameId){
		return BIZ_GROUPLIST + SPLIT + gameId;
	}
	
	// 赛事分组后，所有 队伍 存入 redis，需要一个key
	public static String getGroupTeamKey(String gameId){
		return BIZ_GROUPTEAMSET + SPLIT + gameId;
	}
	
}
