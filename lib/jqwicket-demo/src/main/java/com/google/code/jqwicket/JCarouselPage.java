package com.google.code.jqwicket;

import com.google.code.jqwicket.ui.jcarousel.JCarouselWebMarkupContainer;

public class JCarouselPage extends DemoPage {

	public JCarouselPage() {
		add(new JCarouselWebMarkupContainer("mycarousel"));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.DemoPage#getExampleTitle()
	 */
	@Override
	protected String getExampleTitle() {
		return "JQuery JCarousel Plugin example";
	}

}
