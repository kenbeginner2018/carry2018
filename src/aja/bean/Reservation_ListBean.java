package aja.bean;

import java.io.Serializable;

public class Reservation_ListBean implements Serializable {

	private int ReservNo;
	private int TotalCount;
	private int TotalPrice;
	private int DeliveryFlag;

	public int getReservNo() {
		return ReservNo;
	}
	public void setReservNo(int reservNo) {
		ReservNo = reservNo;
	}
	public int getTotalCount() {
		return TotalCount;
	}
	public void setTotalCount(int totalCount) {
		TotalCount = totalCount;
	}
	public int getTotalPrice() {
		return TotalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		TotalPrice = totalPrice;
	}
	public int getDeliveryFlag() {
		return DeliveryFlag;
	}
	public void setDeliveryFlag(int deliveryFlag) {
		DeliveryFlag = deliveryFlag;
	}

}
