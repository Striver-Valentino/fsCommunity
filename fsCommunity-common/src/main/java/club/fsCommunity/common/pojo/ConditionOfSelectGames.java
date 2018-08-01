package club.fsCommunity.common.pojo;

import club.fsCommunity.pojo.Game;

public class ConditionOfSelectGames extends Game {

	private String statusStr;
	
	private String StartDate1;
	
	private String StartDate2;

	
	
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
