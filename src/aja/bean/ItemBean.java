package aja.bean;

import java.io.Serializable;

public class ItemBean implements Serializable {
	private String ItemName;
	private int ItemPrice;
	private String ItemImage;
	private String ItemDetail;
	private int ItemStock;
	private String CategoryName;

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
	public String getItemImage() {
		return ItemImage;
	}
	public void setItemImage(String itemImage) {
		ItemImage = itemImage;
	}
	public String getItemDetail() {
		return ItemDetail;
	}
	public void setItemDetail(String itemDetail) {
		ItemDetail = itemDetail;
	}
	public int getItemStock() {
		return ItemStock;
	}
	public void setItemStock(int itemStock) {
		ItemStock = itemStock;
	}
	public String getCategoryName() {
		return CategoryName;
	}
	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}



}
