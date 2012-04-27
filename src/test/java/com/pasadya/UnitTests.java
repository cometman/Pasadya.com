package com.pasadya;

import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import com.pasadya.data.CartVO;
import com.pasadya.data.IShopDAO;
import com.pasadya.data.ItemVO;
import com.pasadya.data.MemberVO;
import com.pasadya.data.ShopFactory;
import com.pasadya.shop.ItemPage;
import com.pasadya.shop.UserSession;

/**
 * Simple test using the WicketTester
 */
public class UnitTests {
	private WicketTester tester;
	private IShopDAO shopDAO = ShopFactory.getInstance();
	MemberVO tempMember = new MemberVO();

	@Before
	public void setUp() {
		tester = new WicketTester(new WicketApplication());
		UserSession.get().setMember(
				shopDAO.getMemberInformation("csbuiss@gmail.com", true));
		ItemVO item = new ItemVO();
		item.setItemName("Test");
		item.setItemPrice(23);
		item.setItemDescription("description");
		UserSession.get().getMember().addToCart(item);
	}

	@Test
	public void homepageRendersSuccessfully() {
		// start and render the test page
		tester.startPage(HomePage.class);

		// assert rendered page class
		tester.assertRenderedPage(HomePage.class);
	}

	@Test
	public void testSession_did_authetnicate() {
		MemberVO testMember = new MemberVO();
		testMember.setFname("Clay");
		testMember.setLname("Selby");
		assertNotNull(UserSession.get().getMember());
		assertTrue(UserSession.get().isAuthenticated());
	}

	@Test
	public void logIn_did_authenticate() {
		UserSession session = UserSession.get();
		assertTrue(session.isAuthenticated());
	}

	@Test
	public void daoCanFetchMemberUserName() {
		assertEquals(true, shopDAO.checkMemberUsername("cometman"));
	}

	@Test
	public void daoCanFetchMemberEmail() {
		assertEquals(true, shopDAO.checkMemberEmail("csbuiss@gmail.com"));
	}

	// See if we can add items to the cart
	@Test
	public void canAddXenaItemToCart() {
		// PageParameters pars = new PageParameters();
		// pars.add("id", "1");
		// ItemPage itemPage = new ItemPage(pars);

	}

	@Test
	public void sessionCartContainsItems() {
		
		assertEquals(1, UserSession.get().getMember().getCart().getCartList().size());

	}

//	// This is the last test (It starts the server)
//	@Test
//	public void serverDidStart() {
//		try {
//			Start.main(null);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

}
