package com.pasadya.shop;

import java.io.Serializable;

import org.apache.wicket.IClusterable;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pasadya.HomePage;
import com.pasadya.data.IShopDAO;
import com.pasadya.data.ShopFactory;
import com.pasadya.pages.RegisterPage;

public class LoginForm extends Panel {

	private static final long serialVersionUID = -9131583353866285340L;
	private Form<Void> loginForm = new Form<Void>("form");
	private IShopDAO shopDAO = ShopFactory.getInstance();
	private Logger log = LoggerFactory.getLogger(LoginForm.class);

	public LoginForm(String id) {
		super(id);

		final Input input = new Input();

		setDefaultModel(new CompoundPropertyModel<Input>(input));

		Label registerLabel = new Label("registerLabel", "Register");
		Label buttonLabel = new Label("buttonLabel", "Submit");
		BookmarkablePageLink<Void> registerLink = new BookmarkablePageLink<Void>(
				"registerLink", RegisterPage.class);

		TextField<String> username = new TextField<String>("username");
		PasswordTextField password = new PasswordTextField("password");

		loginForm.add(username);
		loginForm.add(password);

		AjaxButton submitButton = new AjaxButton("submitButton") {

			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
				System.out.println("Submitted");
				if (shopDAO.authenticateUser(input.username, input.password)) {
					UserSession.get().setMember(
							shopDAO.getMemberInformation(input.username, true));
					setResponsePage(HomePage.class);
//					UserSession.get().setCartPanel(new CartPanel("cartPanel"));
//					UserSession.get().getCartPanel().updateCartPanel();
				} else {
					log.error("Invalid login for user [" + input.username + "]");
				}

			}

			@Override
			protected void onError(AjaxRequestTarget target, Form<?> form) {
				// TODO Auto-generated method stub

			}
		};
		add(loginForm);
		loginForm.add(submitButton);
		submitButton.add(buttonLabel);
		loginForm.add(registerLink);
		registerLink.add(registerLabel);
	}

	private static class Input implements Serializable {
		public String username = "";
		public String password = "";
	}

}
