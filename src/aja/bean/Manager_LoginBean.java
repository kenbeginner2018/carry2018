package aja.bean;

import java.io.Serializable;

public class Manager_LoginBean implements Serializable {

	private int ManagerId;
	private String Password;

	public int getManagerId() {
		return ManagerId;
	}
	public void setManagerId(int managerId) {
		ManagerId = managerId;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}

}
