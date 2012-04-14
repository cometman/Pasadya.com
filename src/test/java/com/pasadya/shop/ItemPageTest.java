package com.pasadya.shop;

import static org.junit.Assert.*;

import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.Test;

import com.pasadya.HomePage;
import com.pasadya.WicketApplication;

public class ItemPageTest {
	
	private WicketTester tester;
	ItemPage itemPage;
	
	@Before
	public void canCreateNewItemPageWithItemID() {
		tester = new WicketTester(new WicketApplication());
	}
	
	@Test
	public void canFetchItemBasedOnID(){
		
		tester.startPage(HomePage.class);
		tester.assertRenderedPage(HomePage.class);
		tester.clickLink("shop");
	
		PageParameters pars = new PageParameters();
		pars.add("id", "1");
		
		tester.startPage(ItemPage.class, pars);
		tester.assertRenderedPage(ItemPage.class);
		System.out.println(tester.getLastRenderedPage().toString());
		tester.assertContains("Xena Picture");
	
	}

}
