package com.pasadya.data;

import java.util.List;

public class CartHelper {
	private static CartHelper instance = null;

	protected CartHelper() {

	}
	
	public static CartHelper getInstance(){
		if (instance == null){
			instance = new CartHelper();
		}
		return instance;
	}

	private List<CartVO> cartItems;

	public List<CartVO> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartVO> cartItems) {
		this.cartItems = cartItems;
	}

}
