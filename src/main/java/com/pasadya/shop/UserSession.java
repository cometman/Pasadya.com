package com.pasadya.shop;

import java.util.List;
import java.util.Locale;

import org.apache.wicket.Session;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.protocol.http.WebSession;
import org.apache.wicket.request.Request;

import com.pasadya.data.CartVO;
import com.pasadya.data.ItemVO;
import com.pasadya.data.MemberVO;

public class UserSession extends WebSession {

	private MemberVO member;
	private LoadableDetachableModel cartModel;

	public static UserSession get() {
		return (UserSession) Session.get();
	}

	// private CartVO cart;

	public UserSession(Request request) {
		super(request);

		cartModel = new LoadableDetachableModel<List<ItemVO>>() {

			@Override
			protected List<ItemVO> load() {
				return getMember().getCart().getCartList();
			}
		};
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
	public LoadableDetachableModel<List<ItemVO>> getCartModel(){
		return cartModel;
	}

}
