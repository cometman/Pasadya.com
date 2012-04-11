package com.google.code.jqwicket;

import com.google.code.jqwicket.ui.liscroll.LiScrollWebMarkupContainer;

public class LiScrollPage extends DemoPage {

	public LiScrollPage() {
		add(new LiScrollWebMarkupContainer("ticker01"));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.DemoPage#getExampleTitle()
	 */
	@Override
	protected String getExampleTitle() {
		return "JQuery LiScroll Plugin example";
	}

}
