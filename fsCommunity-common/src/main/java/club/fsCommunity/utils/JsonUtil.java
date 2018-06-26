package club.fsCommunity.utils;

import java.util.Map;
import java.util.Map.Entry;

import com.alibaba.fastjson.JSONObject;

/**
 * 把相关提示信息封装成json格式
 * @author Administrator
 *
 */
public class JsonUtil {

	public static String getJSONString(int code){
		JSONObject json = new JSONObject();
		json.put("code", code);
		return json.toJSONString();
	}
	
	public static String getJSONString(int code,String msg){
		JSONObject json = new JSONObject();
		json.put("code", code);
		json.put("mag", msg);
		return json.toJSONString();
	}
	
	public static String getJSONString(int code,Map<String,Object> map){
		JSONObject json = new JSONObject();
		json.put("code", code);
		
		for (Map.Entry<String,Object> entry : map.entrySet()) {
			json.put(entry.getKey(), entry.getValue());
		}
		
		return json.toJSONString();
	}
}
