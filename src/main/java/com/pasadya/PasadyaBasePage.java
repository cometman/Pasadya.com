package com.pasadya;

import org.apache.wicket.markup.html.IHeaderResponse;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.image.Image;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.ExternalLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.request.resource.PackageResourceReference;

import com.pasadya.data.util.PageParametersConstants;
import com.pasadya.pages.About;
import com.pasadya.pages.Contact;
import com.pasadya.pages.Portfolio;
import com.pasadya.shop.AccountPanel;
import com.pasadya.shop.CartPanel;
import com.pasadya.shop.Shop;
import com.pasadya.shop.UserSession;

public class PasadyaBasePage extends WebPage {

	public PageParameters parm = new PageParameters();

	private static final long serialVersionUID = 1L;

	public PasadyaBasePage() {
		ExternalLink blogLink;
		add(new BookmarkablePageLink<Void>("shop", Shop.class));
		add(new BookmarkablePageLink<Void>("about", About.class));
		add(new BookmarkablePageLink<Void>("portfolio", Portfolio.class));
		add(new BookmarkablePageLink<Void>("home", HomePage.class));
		add(new BookmarkablePageLink<Void>("contact", Contact.class));

		add(new Link<String>("art") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				setShopPageParam("art");
				setResponsePage(Shop.class, parm);
			}
		});

		add(new Link<String>("kids") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				setShopPageParam("kids");
				setResponsePage(Shop.class, parm);
			}
		});

		add(new Link<String>("babies") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				setShopPageParam("babies");
				setResponsePage(Shop.class, parm);
			}
		});

		add(new Link<String>("weddings") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				setShopPageParam("weddings");
				setResponsePage(Shop.class, parm);
			}
		});

		blogLink = new ExternalLink("blogLink",
				"http://www.hellopasadya.blogspot.com");
		add(blogLink);
		blogLink.add(new Image("visitBlog", new PackageResourceReference(
				HomePage.class, "assets/images/VisitBlogImage.png")));

		// Add the account/cart panel

		AccountPanel accountPanel = new AccountPanel("accountPanel");
		add(accountPanel);
		
		CartPanel cartPanel = new CartPanel("cartPanel");
		add(cartPanel);

		// add(new Image("treeLeft", new
		// PackageResourceReference(HomePage.class,
		// "assets/images/BananaTreeLeft.png")));
	}

	// Set the parameters for the page to shop at.

	public PageParameters setShopPageParam(final String selection) {
		parm.set(PageParametersConstants.SHOP_CATEGORY, selection);
		return parm;
	}

	public void renderHead(IHeaderResponse reponse) {
		reponse.renderCSSReference(new PackageResourceReference(HomePage.class,
				"assets/css/main.css"));
		reponse.renderJavaScriptReference(new PackageResourceReference(
				HomePage.class, "menu.js"));
		reponse.renderJavaScriptReference(new PackageResourceReference(
				HomePage.class, "jquery.easing.1.3.js"));

	}

	public UserSession getUserSession() {
		return (UserSession) getUserSession();
	}

}
