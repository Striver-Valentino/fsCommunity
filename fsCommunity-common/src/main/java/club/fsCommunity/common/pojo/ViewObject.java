package club.fsCommunity.common.pojo;

import java.util.HashMap;
import java.util.Map;

/**
 * ViewObject：方便传递任何数据到 jsp
 *             专门用于 视图展示 的对象
 * @author Administrator
 *
 */
public class ViewObject {

	// 内部 只维护了一个 Map
	private Map<String, Object> objs = new HashMap<String, Object>();
	
	public void set(String key,Object value){
		objs.put(key, value);
	}
	
	public Object get(String key){
		return objs.get(key);
	}

	
	
	public Map<String, Object> getObjs() {
		return objs;
	}

	public void setObjs(Map<String, Object> objs) {
		this.objs = objs;
	}
	
}
