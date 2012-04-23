package com.pasadya.shop;

import java.util.List;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.pasadya.HomePage;
import com.pasadya.PasadyaBasePage;
import com.pasadya.data.CartVO;
import com.pasadya.data.ItemVO;
import com.pasadya.data.ShopFactory;

public class ItemPage extends PasadyaBasePage {

	private static final long serialVersionUID = -873933482539533648L;

	// Create a new item page for a selected item (based on item id)
	private ItemVO itemVO;
	private CartVO cart;
	private UserSession session = UserSession.get();

	public ItemPage(PageParameters pars) {
		if (pars.get("id") != null) {
			if (itemVO != null) {
				buildPage();
			} else {
				if (loadItemFromDatabase(pars.get("id").toInt())) {
					buildPage();
				} else {
					setResponsePage(HomePage.class);
				}
			}
		} else {
			setResponsePage(HomePage.class);
		}
	}

	// Fetch item information from the DAO
	public void setShopItem(ItemVO item) {
		if (item != null) {
			itemVO = item;
		} else {
			return;
		}
	}

	// Load the item from the database if not done already. This is normally
	// done when users visits the shop page.
	public boolean loadItemFromDatabase(int id) {
		try {
			itemVO = ShopFactory.getInstance().getShopItemByID(id);
			return true;
		} catch (Exception e) {
			// Was unable to get the item
			return false;
		}

	}

	// Load the fetched information into the page

	public void buildPage() {
		add(new Label("itemName", itemVO.getItemName()));
		add(new Label("itemPrice", itemVO.getItemPrice()));
		add(new Label("itemDescription", itemVO.getItemDescription()));

		AjaxLink<Void> addToCart = new AjaxLink<Void>("addToCart") {
			
			private static final long serialVersionUID = 6137009651387150983L;

			@Override
			public void onClick(AjaxRequestTarget target) {
				addItemToCart(itemVO);
				setOutputMarkupId(true);
				cartPanel.updateCartPanel();
				target.add(cartPanel);
				System.out.println("Cart Model" + UserSession.get().getCartModel().getObject().size());
			}
		};

		add(addToCart);
		addToCart.add(new Label("addToCartLabel", "Add to Cart"));

	}

	public void addItemToCart(ItemVO item) {
		if (UserSession.get().getMember() != null) {
			UserSession.get().getMember().getCart().addToCart(item);
		} else {
			System.out.println("Register or check out anon!");
		}
	}
}
