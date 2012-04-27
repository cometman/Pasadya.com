package com.pasadya.shop;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.pasadya.data.CartHelper;
import com.pasadya.data.CartVO;
import com.pasadya.data.ItemVO;

public class CartPanel extends Panel {

	private static final long serialVersionUID = 6389058347628289461L;
	private UserSession userSession = UserSession.get();
	private CartPanel currentPanel;
	private RepeatingView repeatingView;

	private List<ItemVO> cartListOfItems = new ArrayList<ItemVO>();

	public CartPanel(String id, LoadableDetachableModel<List<ItemVO>> cartModel) {
		super(id);

		setOutputMarkupId(true);
		currentPanel = this;

		System.out.println("Cart Model Constructor");
		repeatingView = new RepeatingView("listView", cartModel);
		repeatingView.setOutputMarkupId(true);
		add(repeatingView);
		updateCartPanel();

	}

	public CartPanel updateCartPanel() {
		if (UserSession.get().getMember() != null) {
			cartListOfItems = UserSession.get().getMember().getCart()
					.getCartList();
				repeatingView.removeAll();
				
			for (ItemVO cartItem : cartListOfItems) {
				PageParameters parms = new PageParameters();
				parms.add("id", cartItem.getItemId());
				repeatingView.add(new Label(repeatingView.newChildId(), cartItem.getItemName()));
//				add(new Label(repeatingView.newChildId(),
//						cartItem.getItemName()));
//				add(new Label(repeatingView.newChildId(),
//						cartItem.getItemPrice()));
				System.out.println("Add to cart" + cartItem.getItemName());
				System.out.println("populated here");
			}
		}
		repeatingView.setOutputMarkupId(true);

		return this;
	}
	

}
