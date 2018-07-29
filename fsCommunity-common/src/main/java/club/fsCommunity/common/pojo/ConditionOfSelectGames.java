package club.fsCommunity.common.pojo;

import club.fsCommunity.pojo.Game;

/**
 * signUpGame.jsp 赛事报名页面，搜索条件 封装成的 实体类
 * 继承 Game类，因为 根据条件查询，这个 “条件”，其实就是 Game 的属性（ConditionOfSelectGames 其实 就是 一个 Game 类）。
 * @author Administrator
 *
 */
public class ConditionOfSelectGames extends Game {

	private String statusStr; // 状态，0：未开始；1：进行中；2：截止报名；3：已结束；4：已取消。显示的是： 未开始；进行中；截止报名；已结束；已取消。
	
	private String StartDate1; // 搜索 “开始时间” 第一个框
	
	private String StartDate2; // 搜索 “开始时间” 第二个框

	
	
	public String getStatusStr() {
		return statusStr;
	}

	public void setStatusStr(String statusStr) {
		this.statusStr = statusStr;
	}

	public String getStartDate1() {
		return StartDate1;
	}

	public void setStartDate1(String startDate1) {
		StartDate1 = startDate1;
	}

	public String getStartDate2() {
		return StartDate2;
	}

	public void setStartDate2(String startDate2) {
		StartDate2 = startDate2;
	}

	@Override
	public String toString() {
		return "ConditionOfSelectGames [statusStr=" + statusStr
				+ ", StartDate1=" + StartDate1 + ", StartDate2=" + StartDate2
				+ ", getStatusStr()=" + getStatusStr() + ", getStartDate1()="
				+ getStartDate1() + ", getStartDate2()=" + getStartDate2()
				+ ", getId()=" + getId() + ", getName()=" + getName()
				+ ", getApplyCount()=" + getApplyCount() + ", getStatus()="
				+ getStatus() + ", getStartDate()=" + getStartDate()
				+ ", getEndDate()=" + getEndDate() + ", getLaunchUserId()="
				+ getLaunchUserId() + ", getSponsorName()=" + getSponsorName()
				+ ", getUndertakeName()=" + getUndertakeName()
				+ ", getSupportName()=" + getSupportName()
				+ ", getSignUpLine()=" + getSignUpLine() + ", getLaunchDate()="
				+ getLaunchDate() + ", getEdge()=" + getEdge()
				+ ", getLaunchUserName()=" + getLaunchUserName()
				+ ", getDescr()=" + getDescr() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

}
