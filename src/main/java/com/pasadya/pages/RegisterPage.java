package com.pasadya.pages;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pasadya.HomePage;
import com.pasadya.PasadyaBasePage;
import com.pasadya.data.IShopDAO;
import com.pasadya.data.MemberVO;
import com.pasadya.data.RegisterMemberVO;
import com.pasadya.data.ShopFactory;
import com.pasadya.shop.UserSession;

public class RegisterPage extends PasadyaBasePage {

	// Member object only for registration
	private RegisterMemberVO member = new RegisterMemberVO();

	// The member object to set
	private MemberVO newMember = new MemberVO();
	private Logger log = LoggerFactory.getLogger(RegisterPage.class);

	private TextField fname = new TextField("fname");
	private TextField lastName = new TextField("lname");
	private TextField email = new TextField("email");
	private TextField password = new TextField("password");
	private TextField repassword = new TextField("repassword");
	private TextField username = new TextField("username");
	private IShopDAO shopDAO = ShopFactory.getInstance();

	private Label formFeedback = new Label("formFeedback",
			"Username or email already exists");

	private Label passwordFeedback = new Label("passwordFeedback",
			"The passwords do not match. Try again");

	public RegisterPage() {
		Form<Void> memberForm = new Form<Void>("newUserForm",
				new CompoundPropertyModel(member));

		Button registerButton = new Button("registerButton") {
			public void onSubmit() {
				// Check to see if user name or email already exists
				if (shopDAO.checkMemberEmail(member.getEmail())
						|| shopDAO.checkMemberUsername(member.getUsername())) {
					formFeedback.setVisible(true);
					passwordFeedback.setVisible(false);

				}
				// If does not exist, and the passwords are the same, create new
				// user in database
				else if (!member.getPassword().equals(member.getRepassword())) {
					formFeedback.setVisible(false);
					passwordFeedback.setVisible(true);
				} else {
					formFeedback.setVisible(false);
					passwordFeedback.setVisible(false);
					newMember.setFname(member.getFname());
					newMember.setLname(member.getLname());
					newMember.setUsername(member.getUsername());
					newMember.setPassword(member.getPassword());
					newMember.setEmail(member.getEmail());
					shopDAO.setMemberInformation(newMember);

					UserSession.get().setMember(newMember);
					setResponsePage(HomePage.class);
					log.info("Success! User created and logged in");
				}

				// Otherwise, prompt user to choose a different one
			}
		};

		add(memberForm);
		memberForm.add(fname);
		memberForm.add(lastName);
		memberForm.add(username);
		memberForm.add(password);
		memberForm.add(repassword);
		memberForm.add(email);
		memberForm.add(registerButton);
		add(passwordFeedback);
		add(formFeedback);
		passwordFeedback.setVisible(false);
		formFeedback.setVisible(false);
	}
}
