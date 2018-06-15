package aja.bean;

import java.io.Serializable;
import java.sql.Date;

public class Manager_ShowBean implements Serializable {

	private int ShowId;
	private String ShowName;
	private Date ShowStartDay;
	private Date ShowEndDay;
	private int ShowFlag;

	public int getShowId() {
		return ShowId;
	}
	public void setShowId(int showId) {
		ShowId = showId;
	}
	public String getShowName() {
		return ShowName;
	}
	public void setShowName(String showName) {
		ShowName = showName;
	}
	public Date getShowStartDay() {
		return ShowStartDay;
	}
	public void setShowStartDay(Date showStartDay) {
		ShowStartDay = showStartDay;
	}
	public Date getShowEndDay() {
		return ShowEndDay;
	}
	public void setShowEndDay(Date showEndDay) {
		ShowEndDay = showEndDay;
	}
	public int getShowFlag() {
		return ShowFlag;
	}
	public void setShowFlag(int showFlag) {
		ShowFlag = showFlag;
	}

}
