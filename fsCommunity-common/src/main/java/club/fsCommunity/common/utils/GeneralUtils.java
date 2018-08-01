package club.fsCommunity.common.utils;

import java.util.Calendar;
import java.util.Date;

import club.fsCommunity.pojo.Enroll;

public class GeneralUtils {

	public static String WEBSITE_DOMAIN_NAME = "http://localhost:8080";
	
	public static String QINIU_DOMAIN_PREFIX = "http://pbjixg82v.bkt.clouddn.com/";
	
	public static String[] IMAGE_FILE_EXT = new String[] {"png","bmp","jpg","jpeg"};
	
    public static boolean isFileAllowed(String fileExt){
        for (String ext : IMAGE_FILE_EXT) {
            if(ext.equals(fileExt)){
                return true;
            }
        }
        return false;
    }
	
	
    public static String generateConversationId(String fromId,String toId){
    	String conversationId = "";
    	if( fromId.compareTo(toId) > 0 ){
    		conversationId = fromId + "_" + toId;
    	} else {
    		conversationId = toId + "_" + fromId;
    	}
    	
    	return conversationId;
    	
    }
	
    
    public static Date callLastTime(Date regtime,int dayCount) {
		Calendar c = Calendar.getInstance();
		c.setTime(regtime);
		c.add(Calendar.DATE, dayCount); 
		return c.getTime();
	}
    
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
    		
    	}else{ 
    		if( posScore(pos2) > posScore(pos3) ){ 
    			if( posScore(pos1) > posScore(pos3) ){
    				lineup = pos2 + pos1 + pos3;
    			}else{

    				lineup = pos2 + pos3 + pos1;
    				
    			}
    		}else{ 
    			lineup = pos3 + pos2 + pos1;
    			
    		}
    		
    	}
    	
    	return lineup;
    }
    
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
