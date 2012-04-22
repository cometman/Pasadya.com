package com.pasadya.shop;

import java.util.Locale;

import org.apache.wicket.Session;
import org.apache.wicket.protocol.http.WebSession;
import org.apache.wicket.request.Request;

import com.pasadya.data.CartVO;
import com.pasadya.data.MemberVO;

public class UserSession extends WebSession {

	public static UserSession get() {
		return (UserSession) Session.get();
	}

	private CartPanel cartPanel;
	private MemberVO member;

	// private CartVO cart;

	public UserSession(Request request) {
		super(request);
		setLocale(Locale.ENGLISH);
	}

	public synchronized MemberVO getMember() {
		return member;
	}

	public synchronized boolean isAuthenticated() {
		return (member != null);
	}

	public synchronized void setMember(MemberVO member) {
		this.member = member;
		dirty();
	}

	public CartPanel getCartPanel() {
		if (cartPanel == null) {
			cartPanel = new CartPanel("cartPanel");
		}
		return cartPanel;
	}

	public void setCartPanel(CartPanel cartPanel) {
		this.cartPanel = cartPanel;
	}

	// public synchronized CartVO getCart(MemberVO member) {
	// if (cart == null) {
	// cart = new CartVO();
	// }
	// return cart;
	//
	// }
	//
	// public void setCart(CartVO cart){
	// this.cart = cart;
	// }
}
