package com.pasadya.shop;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.PropertyModel;

import com.pasadya.data.CartHelper;
import com.pasadya.data.CartVO;
import com.pasadya.data.ItemVO;

public class CartPanel extends Panel {

	private static final long serialVersionUID = 6389058347628289461L;
	private UserSession userSession = UserSession.get();
	private CartPanel currentPanel;
	private RepeatingView repeatingView;
	private List<ItemVO> cartListOfItems = new ArrayList<ItemVO>();
	private WebMarkupContainer wmc = new WebMarkupContainer("wmc");

	public CartPanel(String id) {
		super(id);
		setOutputMarkupId(true);
		currentPanel = this;
		ItemVO testItem = new ItemVO();
		testItem.setItemName("First Item");
		testItem.setItemPrice("23.00");
		testItem.setItemDescription("Stuff here");
		testItem.setItemCategory("Art");
		System.out.println("hi");
		repeatingView = new RepeatingView("listView");
		repeatingView.setOutputMarkupId(true);
		wmc.setOutputMarkupId(true);
		add(wmc);
		wmc.add(repeatingView);

	}

	public CartPanel updateCartPanel() {
		System.out.println("testing");

		cartListOfItems = UserSession.get().getMember().getCart().getCartList();

		for (ItemVO cartItem : cartListOfItems) {
			add(new Label(repeatingView.newChildId(), cartItem.getItemName()));
			add(new Label(repeatingView.newChildId(), cartItem.getItemPrice()));
			System.out.println("Add to cart" + cartItem.getItemName());
			System.out.println("populated here");
		}
		repeatingView.setOutputMarkupId(true);

		return this;
	}

}
