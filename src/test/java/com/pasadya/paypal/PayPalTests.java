package com.pasadya.paypal;
import static org.junit.Assert.*;

import org.junit.Test;

import com.pasadya.data.IShopDAO;
import com.pasadya.data.MemberVO;
import com.pasadya.data.ShopFactory;

public class PayPalTests {
	
	IShopDAO dao = ShopFactory.getInstance();
	@Test
	public void canCreatePayPalTestTransaction(){
		MemberVO member = dao.getMemberInformation("cometman", true);
		member.addToCart(dao.getShopItemByID(1));
	
		PayPalTransaction ppt = PayPalTransaction.getInstance();
	
		ppt.processTransaction(member, "5105105105105100", "0115", "123");
	}

}
