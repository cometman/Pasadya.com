package com.pasadya.shop;

import java.util.Locale;

import org.apache.wicket.Session;
import org.apache.wicket.protocol.http.WebSession;
import org.apache.wicket.request.Request;

import com.pasadya.data.MemberVO;

public class UserSession extends WebSession {
	
	public static UserSession get(){
		return (UserSession) Session.get();		
	}
	
	private MemberVO member;

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
	
	public synchronized void setMember(MemberVO member){
		this.member = member;
		dirty();
	}

}