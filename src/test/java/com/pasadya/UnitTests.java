package com.pasadya;

import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import com.pasadya.data.IShopDAO;
import com.pasadya.data.MemberVO;
import com.pasadya.data.ShopFactory;
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
		UserSession session = UserSession.get();
		MemberVO testMember = new MemberVO();
		testMember.setFname("Clay");
		testMember.setLname("Selby");		
		session.setMember(testMember);			
		assertNotNull(session.getMember());
		assertTrue(session.isAuthenticated());
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
	
	@Test
	public void canAddNewMember() {
		tempMember.setFname("bob");
		tempMember.setLname("selby");
		tempMember.setUsername("xena");
		tempMember.setPassword("horray");
		tempMember.setEmail("msn@gmail.com");
		
		shopDAO.setMemberInformation(tempMember);
		
		assertTrue(shopDAO.getMemberInformation(tempMember.getUsername(), true).getUsername().equals("xena"));
		System.out.println("TESTING");
		System.out.println(shopDAO.getMemberInformation(tempMember.getUsername(), true).getFname());
	}
	
	// This is the last test (It starts the server)
	@Test
	public void serverDidStart(){
		try {
			Start.main(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
