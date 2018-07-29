package club.fsCommunity.common.pojo;

import java.util.List;

public class LayuiTableData {

	private int code;
	private String msg;
	private long count;
	private List<?> data; // List<?> 说明泛型类型不确定
                          // List<T> 泛型类型是确定的；需要在类上声明泛型，在new LayuiTableData<T> 的时候，T已经确定
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}
	public List<?> getData() {
		return data;
	}
	public void setData(List<?> data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return "LayuiTableData [code=" + code + ", msg=" + msg + ", count="
				+ count + ", data=" + data + "]";
	}
	
}
