package com.pasadya.shop;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;

import com.pasadya.data.CartHelper;
import com.pasadya.data.CartVO;
import com.pasadya.data.ItemVO;

public class CartPanel extends Panel {

	private static final long serialVersionUID = 6389058347628289461L;
	private UserSession userSession = UserSession.get();
	
	ListView<Void> cartList;
	public CartPanel(String id) {
		super(id);

		CartVO cart = new CartVO();
		ItemVO testItem = new ItemVO();
		testItem.setItemName("First Item");
		testItem.setItemPrice("23.00");
		testItem.setItemDescription("Stuff here");
		testItem.setItemCategory("Art");
		cart.addToCart(testItem);
		
		cartList = new ListView<Void>("listView") {

			@Override
			protected void populateItem(ListItem<Void> item) {
				for (ItemVO cartItem : userSession.getCart(
						userSession.getMember()).getCartList()) {
					item.add(new Label("itemName", cartItem.getItemName()));
					item.add(new Label("itemPrice", cartItem.getItemPrice()));
					
				}

			}
		};
		
	
		
		userSession.setCart(cart);
		add(cartList);

	}
	
	public CartPanel getCartPanel(){
		System.out.println("testing");
		System.out.println(userSession.getCart(userSession.getMember()));
		System.out.println(userSession.getCart(userSession.getMember()).getCartList().size());
		
		cartList = new ListView<Void>("listView") {

			@Override
			protected void populateItem(ListItem<Void> item) {
				for (ItemVO cartItem : userSession.getCart(
						userSession.getMember()).getCartList()) {
					item.add(new Label("itemName", cartItem.getItemName()));
					item.add(new Label("itemPrice", cartItem.getItemPrice()));
					System.out.println("populated here");
				}
				
			}
		};
		return this;
	}

}
