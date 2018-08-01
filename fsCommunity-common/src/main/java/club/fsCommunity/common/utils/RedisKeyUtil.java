package club.fsCommunity.common.utils;

public class RedisKeyUtil {


	private static String SPLIT = ":";
	
	private static String BIZ_LIKE = "LIKE";
	private static String BIZ_DISLIKE = "DISLIKE";
	private static String BIZ_EVENT = "EVENT";
	
	private static String BIZ_GROUPSORTED = "GROUPSORTED";
	
	private static String BIZ_GROUPLIST = "GROUPLIST";
	
	private static String BIZ_GROUPTEAMSET = "GROUPTEAMSET";
	
	
	
	public static String getEventQueueKey(){
		return BIZ_EVENT;
	} 
	
	public static String getStartGroupKey(String gameId){
		return BIZ_GROUPSORTED + SPLIT + gameId;
	} 
	
	public static String getGroupListKey(String gameId){
		return BIZ_GROUPLIST + SPLIT + gameId;
	}
	
	public static String getGroupTeamKey(String gameId){
		return BIZ_GROUPTEAMSET + SPLIT + gameId;
	}
	
}
