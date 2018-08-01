package club.fsCommunity.common.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

import club.fsCommunity.pojo.Game;

public class DisplayGamesTable extends Game {
	
	private String startDateDisplay;
	private String endDateDisplay;
	private String signUpLineDisplay;
	private String launchDateDisplay;
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
