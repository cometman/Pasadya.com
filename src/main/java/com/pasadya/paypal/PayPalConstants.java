package com.pasadya.paypal;

import com.pasadya.data.MemberVO;

import paypal.payflow.Invoice;
import paypal.payflow.PayflowAPI;
import paypal.payflow.PayflowConnectionData;
import paypal.payflow.UserInfo;

public class PayPalConstants {
	public static final UserInfo USER_INFO = new UserInfo("cometman", "danie26",
			"PayPal", "Halflife87");
	
	public static PayPalConstants _instance;

	// Should not be invoked
	private PayPalConstants() {

	}

	

	public PayPalConstants getInstance() {
		if (_instance == null) {
			_instance = new PayPalConstants();
		}
		return _instance;
	}
}
