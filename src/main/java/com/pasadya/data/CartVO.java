package com.pasadya.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.pasadya.shop.UserSession;

public class CartVO implements Serializable {
	private List<ItemVO> cartList;
	private int quantity;
	private String total;
	private UserSession userSession = UserSession.get();

	public CartVO() {
		if (cartList == null) {
			cartList = new ArrayList<ItemVO>();

		} else {
//			userSession.getCart(userSession.getMember());
		}
	}

	public List<ItemVO> getCartList() {
		return cartList;
	}

	public void setCartList(List<ItemVO> cartList) {
		this.cartList = cartList;
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

	public void addToCart(ItemVO item) {
		cartList.add(item);
	}
	
	public void removeItem(ItemVO item){
		cartList.remove(item);
	}
}
