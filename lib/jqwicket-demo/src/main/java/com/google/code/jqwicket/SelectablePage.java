package com.google.code.jqwicket;

import org.apache.wicket.markup.html.WebMarkupContainer;

import com.google.code.jqwicket.JQBehaviors;

public class SelectablePage extends DemoPage {

	public SelectablePage() {
		add(new WebMarkupContainer("selectable").add(JQBehaviors.selectable()));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.DemoPage#getExampleTitle()
	 */
	@Override
	protected String getExampleTitle() {
		return "JQuery UI Selectable example";
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.DemoPage#getExampleDescription()
	 */
	@Override
	protected String getExampleDescription() {
		return "This example demonstrates JQuery UI Selectable integration";
	}
}
