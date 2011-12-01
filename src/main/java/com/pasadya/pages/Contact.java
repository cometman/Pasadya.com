package com.pasadya.pages;

import org.apache.wicket.markup.html.image.Image;
import org.apache.wicket.request.resource.PackageResourceReference;

import com.pasadya.HomePage;
import com.pasadya.PasadyaBasePage;

public class Contact extends PasadyaBasePage {
	public Contact() {
		Image contactImage = new Image("contactImage", new PackageResourceReference(HomePage.class, "assets/images/contactLady.png"));
		add(contactImage);
	}

	private static final long serialVersionUID = -7976498426827274467L;

}
