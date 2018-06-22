package aja.bean;

import java.io.Serializable;
import java.util.Date;

public class ShowBean implements Serializable {

	private int ShowId;
	private String ShowName;
	private String showimage;
	private Date showStartDay;
	private Date showEndDay;

	public String getShowimage() {
		return showimage;
	}
	public void setShowimage(String showimage) {
		this.showimage = showimage;
	}
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
		return showStartDay;
	}
	public void setShowStartDay(Date showStartDay) {
		this.showStartDay = showStartDay;
	}
	public Date getShowEndDay() {
		return showEndDay;
	}
	public void setShowEndDay(Date showEndDay) {
		this.showEndDay = showEndDay;
	}

}
