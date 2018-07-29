package club.fsCommunity.common.utils;

import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import club.fsCommunity.pojo.GameExample;
import club.fsCommunity.pojo.LoginTicket;

public class randomNumberUtil {

	/**
	 * Java语言 根据当前时间  随机生成ID的方法
	 * @return
	 */
	public static String getGuid(){
		StringBuffer now = new StringBuffer(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()));
		int n = (int)(Math.random() * 90000.0D + 10000.0D);
		return now.append(n).toString();
	}
	
	/**
	 * Java语言 根据当前时间  随机生成ID的方法
	 * @return
	 */
	public static String getZcbhid(){
		StringBuffer now = new StringBuffer(new SimpleDateFormat("yyyyMMdd").format(new Date()));
		int n = (int)(Math.random() * 9000.0D + 1000.0D);
		return now.append(n).toString();
	}
	
	/**
	 * 得到UUID
	 * @return
	 */
	public static String getUUID(){
		return UUID.randomUUID().toString().replace("-", "");
	}
	
	/**
	 * 生成用户id
	 * @return
	 */
	public static String generateUserID(){
		return "user" + getUUID();
	}
	
	/**
	 * 生成赛事id
	 * @return
	 */
	public static String generateGameID(){
		return "game" + getUUID();
	}
	
	/**
	 * 生成 报名信息表 id
	 * @return
	 */
	public static String generateEnrollID(){
		return "enroll" + getUUID();
	}
	
	/**
	 * 生成站内信 id
	 * @return
	 */
	public static String generateMessageID(){
		return "mess" + getUUID();
	}
	
	/**
	 * 生成 队伍 id
	 * @return
	 */
	public static String generateTeamID(){
		return "team" + getUUID();
	}
	
	/**
	 * 生成 对阵情况 id
	 * @return
	 */
	public static String generateTeamVsID(){
		return "teamvs" + getUUID();
	}
	
	/**
	 * 生成 注册时的 邮箱激活码
	 * @return
	 */
	public static String generateEmailActiveCode(){
		return "ACT" + getUUID() + "EMAIL";
	}
	
	/**
	 * 生成 LoginTicket 对象的id
	 * @return
	 */
	public static String generateTicketID(){
		return "ticket" + getUUID();
	}
	
	/**
	 * 生成 LoginTicket对象 的 ticket票 字符串
	 * @param userId
	 * @return
	 */
	public static String generateTicketStr(){
		return "clubfsticket" + getUUID();
	}
	
	/**
	 * 生成 Codekeys ID
	 * @return
	 */
	public static String generateCodekeysID(){
		return "codekeys" + getUUID();
	}
	
	/**
	 * 生成盐加密的 随机字符串
	 * @return
	 */
	public static String generateSalt(){
		return getUUID().substring(0,10);
	}
	
	/**
	 * 生成MD5加密的密码
	 * @param key
	 * @return
	 */
	public static String MD5(String key) {
        char hexDigits[] = {
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
        };
        try {
            byte[] btInput = key.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
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
            //logger.error("生成MD5失败", e);
            return null;
        }
    }
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		System.out.println(getGuid());
		
		System.out.println(getZcbhid());
		
		System.out.println(getUUID());
		
		System.out.println(generateUserID());
		
	}
	
	
	
	
	
}
