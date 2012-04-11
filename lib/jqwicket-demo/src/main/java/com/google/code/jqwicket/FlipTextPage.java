package com.google.code.jqwicket;

import com.google.code.jqwicket.ui.mb.fliptext.FlipTextOptions;
import com.google.code.jqwicket.ui.mb.fliptext.FlipTextWebMarkupContainer;

public class FlipTextPage extends DemoPage {

	public FlipTextPage() {
		add(new FlipTextWebMarkupContainer("tb"));
		add(new FlipTextWebMarkupContainer("bt", new FlipTextOptions(false)));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.DemoPage#getExampleTitle()
	 */
	@Override
	protected String getExampleTitle() {
		return "JQuery FlipText Plugin example";
	}

}
