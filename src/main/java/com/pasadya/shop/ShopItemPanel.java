package com.pasadya.shop;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

import com.pasadya.data.ItemVO;

public class ShopItemPanel extends Panel {

	private static final long serialVersionUID = -7036000686913087775L;
	private UserSession userSession = UserSession.get();

	public ShopItemPanel(String id, final IModel<ItemVO> modelObject) {
		super(id, modelObject);

//		AjaxLink<Void> addToCartButton = new AjaxLink<Void>("addToCartButton") {
//
//			@Override
//			public void onClick(AjaxRequestTarget target) {
//				userSession.getCart(userSession.getMember()).addToCart(
//						modelObject.getObject());
//				System.out.println(userSession.getCart(userSession.getMember()).getCartList().size());
//			}
//		};
		Label addToCartLabel = new Label("addToCartLabel", "Add to Cart");
//		addToCartButton.add(addToCartLabel);
//		add(addToCartButton);
		// add(new Label("itemName", modelObject.getObject().getItemName()));

	}

}
