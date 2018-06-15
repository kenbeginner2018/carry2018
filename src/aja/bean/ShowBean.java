package aja.bean;

import java.io.Serializable;

public class ShowBean implements Serializable {

	private int ShowId;
	private String ShowName;

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

}
