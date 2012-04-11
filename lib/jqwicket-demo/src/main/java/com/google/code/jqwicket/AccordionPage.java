package com.google.code.jqwicket;

import static com.google.code.jqwicket.api.JQuery.$;

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;

import com.google.code.jqwicket.JQBehaviors;
import com.google.code.jqwicket.ui.accordion.AccordionBehavior;
import com.google.code.jqwicket.ui.accordion.AccordionWebMarkupContainer;

public class AccordionPage extends DemoPage {

	public AccordionPage() {

		AccordionWebMarkupContainer a1 = new AccordionWebMarkupContainer(
				"accordion-component");
		Label label = new Label("accordion.label", "Hello WORLD!");
		label.add(JQBehaviors.js($(label).css("color", "red")));
		a1.add(label);

		add(a1);

		add(new WebMarkupContainer("accordion-behavior")
				.add(new AccordionBehavior()));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.DemoPage#getExampleTitle()
	 */
	@Override
	protected String getExampleTitle() {
		return "JQuery UI Accordion example";
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.DemoPage#getExampleDescription()
	 */
	@Override
	protected String getExampleDescription() {
		return "This example demonstrates JQuery UI Accordion integration";
	}

}
