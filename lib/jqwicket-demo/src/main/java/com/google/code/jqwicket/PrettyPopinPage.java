package com.google.code.jqwicket;

import org.apache.wicket.markup.html.link.ExternalLink;
import org.apache.wicket.markup.html.link.Link;

import com.google.code.jqwicket.dnd.DND2Page;
import com.google.code.jqwicket.ui.prettypopin.PrettyPopinBehavior;
import com.google.code.jqwicket.ui.prettypopin.PrettyPopinOptions;

public class PrettyPopinPage extends DemoPage {

	public PrettyPopinPage() {

		Link<Void> linkInternal = new Link<Void>("linkInternal") {

			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				setResponsePage(DND2Page.class);
			}
		};
		linkInternal.add(new PrettyPopinBehavior(new PrettyPopinOptions()
				.width(500).height(400).followScroll(false)));
		add(linkInternal);

		ExternalLink linkExternal = new ExternalLink("linkExternal",
				"http://localhost:8080/prettypopin");
		linkExternal.add(new PrettyPopinBehavior(new PrettyPopinOptions()
				.width(500).height(400).followScroll(true)));
		add(linkExternal);

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.DemoPage#getExampleTitle()
	 */
	@Override
	protected String getExampleTitle() {
		return "JQuery Pretty Popin Plugin example";
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.DemoPage#getExampleDescription()
	 */
	@Override
	protected String getExampleDescription() {
		return "This example demonstrates JQuery Pretty Popin Plugin integration";
	}
}
