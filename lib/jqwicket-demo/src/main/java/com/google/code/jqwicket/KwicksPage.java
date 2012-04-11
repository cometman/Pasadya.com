package com.google.code.jqwicket;

import org.apache.wicket.markup.html.WebMarkupContainer;

import com.google.code.jqwicket.ui.kwicks.KwicksBehavior;
import com.google.code.jqwicket.ui.kwicks.KwicksOptions;

public class KwicksPage extends DemoPage {

	public KwicksPage() {
		add(new WebMarkupContainer("kwicks").add(new KwicksBehavior(
				new KwicksOptions().max(205).spacing(5))));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.DemoPage#getExampleTitle()
	 */
	@Override
	protected String getExampleTitle() {
		return "JQuery Kwicks Plugin example";
	}

}
