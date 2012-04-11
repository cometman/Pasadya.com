package com.google.code.jqwicket;

import org.apache.wicket.markup.html.WebMarkupContainer;

import com.google.code.jqwicket.ui.prettygallery.PrettyGalleryBehavior;

public class PrettyGalleryPage extends DemoPage {

	public PrettyGalleryPage() {
		add(new WebMarkupContainer("prettyGallery")
				.add(new PrettyGalleryBehavior()));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.DemoPage#getExampleTitle()
	 */
	@Override
	protected String getExampleTitle() {
		return "JQuery PrettyGallery Plugin example";
	}

}
