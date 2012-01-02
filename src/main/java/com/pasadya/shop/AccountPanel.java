package com.pasadya.shop;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;

import com.pasadya.HomePage;

public class AccountPanel extends Panel {

	private Label logoutLabel = new Label("logoutLabel", "Logoff");

	public AccountPanel(String id) {
		super(id);
		String cartHeading = "Welcome, please sign in or register";

		AjaxLink<Void> logout = new AjaxLink<Void>("logoutButton") {

			@Override
			public void onClick(AjaxRequestTarget arg0) {
				UserSession.get().setMember(null);
				UserSession.get().isAuthenticated();
				setResponsePage(HomePage.class);
			}
		};

		logout.add(logoutLabel);
		logout.setVisible(false);
		logoutLabel.setVisible(false);

		if (UserSession.get().isAuthenticated()) {
			cartHeading = "Welcome, "
					+ UserSession.get().getMember().getFname();
			logout.setVisible(true);
			logoutLabel.setVisible(true);

		}
		add(new Label("accountHeading", cartHeading));

		LoginForm loginForm = new LoginForm("loginForm");
		add(loginForm);

		add(logout);

		if (!UserSession.get().isAuthenticated()) {
			loginForm.setVisible(true);

		} else {
			loginForm.setVisible(false);
		}
	}
}
