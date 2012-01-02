package com.pasadya.data;

import java.util.List;

public class CartVO {
	private List<ItemVO> item;
	private int quantity;
	private String total;

	public List<ItemVO> getItem() {
		return item;
	}

	public void setItem(List<ItemVO> item) {
		this.item = item;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}
}
