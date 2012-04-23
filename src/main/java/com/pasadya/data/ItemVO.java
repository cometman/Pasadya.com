package com.pasadya.data;

import java.io.Serializable;

public class ItemVO implements Serializable {

	private static final long serialVersionUID = 7677018591081074291L;

	public String itemName;
	public String itemDescription;
	public String itemPrice;
	private Double salePrice;
	public String itemCategory;
	public int itemId;
	public String publishStatus;

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public String getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(String itemCost) {
		this.itemPrice = itemCost;
	}

	public Double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(Double salePrice) {
		this.salePrice = salePrice;
	}

	public String getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getItemId() {
		return itemId;
	}

	public ItemVO(String itemName, String itemDescription) {
		this.itemName = itemName;
		this.itemDescription = itemDescription;
	}

	public ItemVO() {

	}

	public String getPublishStatus() {
		return publishStatus;
	}

	public void setPublished() {
		publishStatus = "Y";
	}

	public void setNotPublished() {
		publishStatus = "N";
	}
}
