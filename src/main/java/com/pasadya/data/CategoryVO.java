package com.pasadya.data;

import java.io.Serializable;

public class CategoryVO implements Serializable{

	private static final long serialVersionUID = -5008400523369514123L;
	
	private String categoryName;
	private String categoryDescription;
	private int categoryID;
	private int parentCategory;
	
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCategoryDescription() {
		return categoryDescription;
	}
	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}
	public int getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(int i) {
		this.categoryID = i;
	}
	public int getParentCategory() {
		return parentCategory;
	}
	public void setParentCategory(int parentCategory) {
		this.parentCategory = parentCategory;
	} 
	
}
