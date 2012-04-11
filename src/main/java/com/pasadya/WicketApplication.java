package com.pasadya;

import org.apache.wicket.Session;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Response;

import com.google.code.jqwicket.JQComponentOnBeforeRenderListener;
import com.google.code.jqwicket.JQContributionConfig;
import com.pasadya.shop.Shop;
import com.pasadya.shop.UserSession;

/**
 * Application object for your web application. If you want to run this
 * application without deploying, run the Start class.
 * 
 * @see com.pasadya.Start#main(String[])
 */
public class WicketApplication extends WebApplication {
	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	@Override
	public Session newSession(Request request, Response reponse) {
		return new UserSession(request);
	}

	@Override
	public Class<HomePage> getHomePage() {
		return HomePage.class;
	}

	/**
	 * @see org.apache.wicket.Application#init()
	 */
	@Override
	public void init() {
		mountPage("/shop", Shop.class);
		getComponentPreOnBeforeRenderListeners().add(
				new JQComponentOnBeforeRenderListener(
						new JQContributionConfig().withDefaultJQueryUi()));

	}
}
