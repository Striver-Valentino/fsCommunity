package club.fsCommunity.common.utils;

import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import club.fsCommunity.pojo.GameExample;
import club.fsCommunity.pojo.LoginTicket;

public class randomNumberUtil {

	public static String getGuid(){
		StringBuffer now = new StringBuffer(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()));
		int n = (int)(Math.random() * 90000.0D + 10000.0D);
		return now.append(n).toString();
	}
	
	public static String getZcbhid(){
		StringBuffer now = new StringBuffer(new SimpleDateFormat("yyyyMMdd").format(new Date()));
		int n = (int)(Math.random() * 9000.0D + 1000.0D);
		return now.append(n).toString();
	}
	
	public static String getUUID(){
		return UUID.randomUUID().toString().replace("-", "");
	}
	
	public static String generateUserID(){
		return "user" + getUUID();
	}
	
	public static String generateGameID(){
		return "game" + getUUID();
	}
	
	public static String generateEnrollID(){
		return "enroll" + getUUID();
	}
	
	public static String generateMessageID(){
		return "mess" + getUUID();
	}
	
	public static String generateTeamID(){
		return "team" + getUUID();
	}
	
	public static String generateTeamVsID(){
		return "teamvs" + getUUID();
	}
	
	public static String generateEmailActiveCode(){
		return "ACT" + getUUID() + "EMAIL";
	}
	
	public static String generateTicketID(){
		return "ticket" + getUUID();
	}
	
	public static String generateTicketStr(){
		return "clubfsticket" + getUUID();
	}
	
	public static String generateCodekeysID(){
		return "codekeys" + getUUID();
	}
	
	public static String generateSalt(){
		return getUUID().substring(0,10);
	}
	
	public static String MD5(String key) {
        char hexDigits[] = {
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
        };
        try {
            byte[] btInput = key.getBytes();
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            mdInst.update(btInput);
            byte[] md = mdInst.digest();
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            return null;
        }
    }
	
	
	
	
	
}
