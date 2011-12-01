package com.pasadya.shop;

import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

import com.pasadya.data.ItemVO;

public class ShopItemPanel extends Panel {

	private static final long serialVersionUID = -7036000686913087775L;

	public ShopItemPanel(String id, final IModel<ItemVO> modelObject) {
		super(id, modelObject);	
		
	
		
//		add(new Label("itemName", modelObject.getObject().getItemName()));
		
	}

}
