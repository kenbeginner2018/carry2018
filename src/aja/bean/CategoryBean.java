package aja.bean;

import java.io.Serializable;

public class CategoryBean implements Serializable {
	private int CategoryId;
	private String CategoryName;

	public int getCategoryId() {
		return CategoryId;
	}
	public void setCategoryId(int categoryId) {
		CategoryId = categoryId;
	}
	public String getCategoryName() {
		return CategoryName;
	}
	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}

}
