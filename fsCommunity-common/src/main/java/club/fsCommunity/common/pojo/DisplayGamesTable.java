package club.fsCommunity.common.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

import club.fsCommunity.pojo.Game;

/**
 * 因为 Game 类型 的数据，里面的 status 属性 的值 是  0,1,2,3,4 ，不应该把这种值 显示到 页面上（其他属性也有类似问题），
 * 所以 在 Game 基础上 再封装一个类，用于显示在 页面上。
 * @author Administrator
 *
 */
public class DisplayGamesTable extends Game {
	
	// 显示到页面的 开始时间 ，字符串类型
	private String startDateDisplay;
	// 显示到页面的 结束时间 ，字符串类型
	private String endDateDisplay;
	// 显示到页面的 报名截止时间 ，字符串类型
	private String signUpLineDisplay;
	// 显示到页面的 发起赛事时间 ，字符串类型
	private String launchDateDisplay;
	// 显示到页面的 赛事状态 ，字符串类型
	private String statusDisplay;
	
	
	
	public String getStartDateDisplay() {
		return startDateDisplay;
	}
	public void setStartDateDisplay(String startDateDisplay) {
		this.startDateDisplay = startDateDisplay;
	}
	public String getEndDateDisplay() {
		return endDateDisplay;
	}
	public void setEndDateDisplay(String endDateDisplay) {
		this.endDateDisplay = endDateDisplay;
	}
	public String getSignUpLineDisplay() {
		return signUpLineDisplay;
	}
	public void setSignUpLineDisplay(String signUpLineDisplay) {
		this.signUpLineDisplay = signUpLineDisplay;
	}
	public String getLaunchDateDisplay() {
		return launchDateDisplay;
	}
	public void setLaunchDateDisplay(String launchDateDisplay) {
		this.launchDateDisplay = launchDateDisplay;
	}
	public String getStatusDisplay() {
		return statusDisplay;
	}
	public void setStatusDisplay(String statusDisplay) {
		this.statusDisplay = statusDisplay;
	}
	
	@Override
	public String toString() {
		return "DisplayGamesTable [startDateDisplay=" + startDateDisplay
				+ ", endDateDisplay=" + endDateDisplay + ", signUpLineDisplay="
				+ signUpLineDisplay + ", launchDateDisplay="
				+ launchDateDisplay + ", statusDisplay=" + statusDisplay
				+ ", getId()=" + getId() + ", getName()=" + getName()
				+ ", getApplyCount()=" + getApplyCount() + ", getStatus()="
				+ getStatus() + ", getStartDate()=" + getStartDate()
				+ ", getEndDate()=" + getEndDate() + ", getLaunchUserId()="
				+ getLaunchUserId() + ", getSponsorName()=" + getSponsorName()
				+ ", getUndertakeName()=" + getUndertakeName()
				+ ", getSupportName()=" + getSupportName()
				+ ", getSignUpLine()=" + getSignUpLine() + ", getLaunchDate()="
				+ getLaunchDate() + ", getEdge()=" + getEdge()
				+ ", getDescr()=" + getDescr() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}

}
