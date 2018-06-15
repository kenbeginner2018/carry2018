package aja.bean;

import java.io.Serializable;

public class OrderBean implements Serializable {

	private String ItemName;
	private int ItemPrice;
	private int ItemCount;
	private int SubTotal;
	private int ReservNo;

	public String getItemName() {
		return ItemName;
	}
	public void setItemName(String itemName) {
		ItemName = itemName;
	}
	public int getItemPrice() {
		return ItemPrice;
	}
	public void setItemPrice(int itemPrice) {
		ItemPrice = itemPrice;
	}
	public int getItemCount() {
		return ItemCount;
	}
	public void setItemCount(int itemCount) {
		ItemCount = itemCount;
	}
	public int getSubTotal() {
		return SubTotal;
	}
	public void setSubTotal(int subTotal) {
		SubTotal = subTotal;
	}
	public int getReservNo() {
		return ReservNo;
	}
	public void setReservNo(int reservNo) {
		ReservNo = reservNo;
	}

}
