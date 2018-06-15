package aja.bean;

import java.io.Serializable;

public class LoginBean implements Serializable {
	private int ReservNo;
	private String TelNo;

	public int getReservNo() {
		return ReservNo;
	}
	public void setReservNo(int reservNo) {
		ReservNo = reservNo;
	}
	public String getTelNo() {
		return TelNo;
	}
	public void setTelNo(String telNo) {
		TelNo = telNo;
	}

}
