package club.fsCommunity.common.utils;

import java.util.Calendar;
import java.util.Date;

import club.fsCommunity.pojo.Enroll;

/**
 * 集中写整个系统通用的工具类
 * @author Administrator
 *
 */
public class GeneralUtils {

	public static String WEBSITE_DOMAIN_NAME = "http://localhost:8080";
	
	// 七牛 图片 存储 的 访问前缀
	public static String QINIU_DOMAIN_PREFIX = "http://pbjixg82v.bkt.clouddn.com/";
	
	// 图片文件后缀集合，方便判断一个文件是否是图片文件
	public static String[] IMAGE_FILE_EXT = new String[] {"png","bmp","jpg","jpeg"};
	
	// 判断 一个 扩展名 ext 是否 符合 上传的要求
    public static boolean isFileAllowed(String fileExt){
        for (String ext : IMAGE_FILE_EXT) {
            if(ext.equals(fileExt)){
                return true;
            }
        }
        return false;
    }
	
	
    /**
     * 根据 fromId 与 toId 的 大小 生成 conversationId（会话id）
     * @param fromId
     * @param toId
     * @return
     */
    public static String generateConversationId(String fromId,String toId){
    	String conversationId = "";
    	if( fromId.compareTo(toId) > 0 ){ // 较大的 放前面
    		conversationId = fromId + "_" + toId;
    	} else {
    		conversationId = toId + "_" + fromId;
    	}
    	
    	return conversationId;
    	
    }
	
    
    /**
	 * 计算    最后过期时间（注册时间+有效天数），主要用在 激活邮件中 的 激活链接 有效期
	 */
    public static Date callLastTime(Date regtime,int dayCount) {
		//日历对象
		Calendar c = Calendar.getInstance();
		c.setTime(regtime);
		//把日历 +dayCount 天
		c.add(Calendar.DATE, dayCount); //根据日历的规则，为给定的 日历字段 添加或减去指定的时间量（单位：天）
		//返回 +dayCount 天 后的时间
		return c.getTime();
	}
    
    /**
     * 计算 用户 报名 信息 的 能力分数
     * @return
     */
    public static Integer calAbilityScore(Enroll enroll){
    	
    	Integer score = 0;
    	
    	if("SSS".equals(enroll.getRating())){
    		score = 8;
    	}else if("SS".equals(enroll.getRating())){
    		score = 7;
    	}else if("S".equals(enroll.getRating())){
    		score = 6;
    	}else if("AAA".equals(enroll.getRating())){
    		score = 5;
    	}else if("AA".equals(enroll.getRating())){
    		score = 4;
    	}else if("A".equals(enroll.getRating())){
    		score = 3;
    	}else if("B".equals(enroll.getRating())){
    		score = 2;
    	}else if("C".equals(enroll.getRating())){
    		score = 1;
    	}
    	
    	return score;
    }
    
    /**
     * 参赛职业 排序
     * @param enroll
     * @return
     */
    public static String posSort(String pos1,String pos2,String pos3){
    	
    	String lineup = "";
    	
    	if( posScore(pos1) > posScore(pos2) ){
    		
    		if( posScore(pos2) > posScore(pos3) ){
    			
    			lineup = pos1 + pos2 + pos3;
    			
    		}else{
    			if( posScore(pos1) > posScore(pos3) ){
        			
        			lineup = pos1 + pos3 + pos2;
        			
        		}else{
        			lineup = pos3 + pos1 + pos2;
        		}
    		}
    		
    	}else{ // pos2 比 pos1 大 的时候
    		if( posScore(pos2) > posScore(pos3) ){ // 并且 pos2 比 pos3 大
    			if( posScore(pos1) > posScore(pos3) ){
    				lineup = pos2 + pos1 + pos3;
    			}else{

    				lineup = pos2 + pos3 + pos1;
    				
    			}
    		}else{ // pos2 比 pos3 小
    			lineup = pos3 + pos2 + pos1;
    			
    		}
    		
    	}
    	
    	return lineup;
    }
    
    /**
     * 计算 一个 参赛职业 的 分数
     * @param pos
     * @return
     */
    public static Integer posScore(String pos){
    	
    	Integer score = 0;
    	
    	if("C".equals(pos)){
    		score = 6;
    	}else if("PF".equals(pos)){
    		score = 5;
    	}else if("SF".equals(pos)){
    		score = 4;
    	}else if("SW".equals(pos)){
    		score = 3;
    	}else if("SG".equals(pos)){
    		score = 2;
    	}else if("PG".equals(pos)){
    		score = 1;
    	}
    	
    	return score;
    }
    
    
    
    
    
    
    
    
    
	
	
	
	
	
	
	
}
