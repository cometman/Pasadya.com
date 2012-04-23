package com.pasadya;

import java.util.List;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.behavior.SimpleAttributeModifier;
import org.apache.wicket.markup.html.IHeaderResponse;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.image.Image;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.ExternalLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.request.resource.PackageResourceReference;

import com.pasadya.data.ItemVO;
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
	public CartPanel cartPanel;
	private static final long serialVersionUID = 1L;
	private AjaxLink<Void> cartLink;
	private BookmarkablePageLink<Void> shopLink = new BookmarkablePageLink<Void>(
			"shop", Shop.class);
	private BookmarkablePageLink<Void> aboutLink = new BookmarkablePageLink<Void>(
			"about", About.class);
	private BookmarkablePageLink<Void> homeLink = new BookmarkablePageLink<Void>(
			"home", HomePage.class);
	private BookmarkablePageLink<Void> contactLink = new BookmarkablePageLink<Void>(
			"contact", Contact.class);
	private BookmarkablePageLink<Void> infoLink = new BookmarkablePageLink<Void>(
			"info", HomePage.class);

	public PasadyaBasePage() {
		ExternalLink blogLink;
		add(shopLink);
		add(aboutLink);
		add(infoLink);
		add(homeLink);
		add(contactLink);

		add(new Image("mainPageLogo", new PackageResourceReference(
				HomePage.class, "assets/images/PasadyaBananas.png")));
		blogLink = new ExternalLink("blog",
				"http://www.hellopasadya.blogspot.com");
		add(blogLink);
		// blogLink.add(new Label("blogLabel", "blog"));

		// add(new Link<String>("	") {
		// private static final long serialVersionUID = 1L;
		//
		// @Override
		// public void onClick() {
		// setShopPageParam("art");
		// setResponsePage(Shop.class, parm);
		// }
		// });
		//
		// add(new Link<String>("kids") {
		// private static final long serialVersionUID = 1L;
		//
		// @Override
		// public void onClick() {
		// setShopPageParam("kids");
		// setResponsePage(Shop.class, parm);
		// }
		// });
		//
		// add(new Link<String>("babies") {
		// private static final long serialVersionUID = 1L;
		//
		// @Override
		// public void onClick() {
		// setShopPageParam("babies");
		// setResponsePage(Shop.class, parm);
		// }
		// });
		//
		// add(new Link<String>("weddings") {
		// private static final long serialVersionUID = 1L;
		//
		// @Override
		// public void onClick() {
		// setShopPageParam("weddings");
		// setResponsePage(Shop.class, parm);
		// }
		// });

		// Add the account/cart panel

		AccountPanel accountPanel = new AccountPanel("accountPanel");
		add(accountPanel);

		if (cartPanel == null) {
			cartPanel = new CartPanel("cartPanel", UserSession.get()
					.getCartModel());
		}

		add(cartPanel);

		// Label cartLabel = new Label("cartLabel", "cart Test");
		//
		// cartLink = new AjaxLink<Void>("cartLink") {
		//
		// @Override
		// public void onClick(AjaxRequestTarget target) {
		//
		// cartPanel = cartPanel.getCartPanel();
		//
		//
		// }
		// };

		// cartLink.add(new AttributeModifier("onclick",
		// ".cartPannel.toggle(slow)"));
		// add(cartLink);
		// cartLink.add(cartLabel);

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
