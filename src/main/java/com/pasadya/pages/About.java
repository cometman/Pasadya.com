package com.pasadya.pages;

import org.apache.wicket.markup.html.image.Image;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.request.resource.PackageResourceReference;

import com.pasadya.HomePage;
import com.pasadya.PasadyaBasePage;

public class About extends PasadyaBasePage {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("rawtypes")
	public About(){
		Link homeLink;
		add(new Image("danieProfile", new PackageResourceReference(HomePage.class, "assets/images/AboutMeImage.png")));
		homeLink = new Link("homeLink") {
			
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				setResponsePage(HomePage.class);				
			}
		};
		add(homeLink);
		homeLink.add(new Image("aboutBanana", new PackageResourceReference(HomePage.class, "assets/images/AboutBananaLightUp.png")));
	}

}
