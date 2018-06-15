package aja.bean;

import java.io.Serializable;

public class Manager_ItemBean implements Serializable {
	
	private int ItemId;
	private String ItemName;
	private String ItemDetail;
	private int ItemPrice;
	private int ItemStock;
	private String ItemImage;
	private int ShowId;
	private int CategoryId;
	private int ItemFlag;
	
	public int getItemId() {
		return ItemId;
	}
	public void setItemId(int itemId) {
		ItemId = itemId;
	}
	public String getItemName() {
		return ItemName;
	}
	public void setItemName(String itemName) {
		ItemName = itemName;
	}
	public String getItemDetail() {
		return ItemDetail;
	}
	public void setItemDetail(String itemDetail) {
		ItemDetail = itemDetail;
	}
	public int getItemPrice() {
		return ItemPrice;
	}
	public void setItemPrice(int itemPrice) {
		ItemPrice = itemPrice;
	}
	public int getItemStock() {
		return ItemStock;
	}
	public void setItemStock(int itemStock) {
		ItemStock = itemStock;
	}
	public String getItemImage() {
		return ItemImage;
	}
	public void setItemImage(String itemImage) {
		ItemImage = itemImage;
	}
	public int getShowId() {
		return ShowId;
	}
	public void setShowId(int showId) {
		ShowId = showId;
	}
	public int getCategoryId() {
		return CategoryId;
	}
	public void setCategoryId(int categoryId) {
		CategoryId = categoryId;
	}
	public int getItemFlag() {
		return ItemFlag;
	}
	public void setItemFlag(int itemFlag) {
		ItemFlag = itemFlag;
	}

}
