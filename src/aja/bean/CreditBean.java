package aja.bean;

import java.io.Serializable;

public class CreditBean implements Serializable {

	private int CreditNo;
	private String CreditName;
	private int SecurityCode;
	public int getCreditNo() {
		return CreditNo;
	}
	public void setCreditNo(int creditNo) {
		CreditNo = creditNo;
	}
	public String getCreditName() {
		return CreditName;
	}
	public void setCreditName(String creditName) {
		CreditName = creditName;
	}
	public int getSecurityCode() {
		return SecurityCode;
	}
	public void setSecurityCode(int securityCode) {
		SecurityCode = securityCode;
	}

}
