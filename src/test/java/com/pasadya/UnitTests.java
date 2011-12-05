package com.pasadya;

import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import com.pasadya.data.MemberVO;
import com.pasadya.shop.UserSession;

/**
 * Simple test using the WicketTester
 */
public class UnitTests {
	private WicketTester tester;

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
	
	
}
