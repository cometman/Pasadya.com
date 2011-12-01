package com.pasadya;

import org.apache.wicket.protocol.http.WebApplication;

import com.pasadya.shop.Shop;

/**
 * Application object for your web application. If you want to run this application without deploying, run the Start class.
 * 
 * @see com.pasadya.Start#main(String[])
 */
public class WicketApplication extends WebApplication
{    	
	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	@Override
	public Class<HomePage> getHomePage()
	{
		return HomePage.class;
	}

	/**
	 * @see org.apache.wicket.Application#init()
	 */
	@Override
	public void init()
	{
		mountPage("/shop", Shop.class);
	}
}
