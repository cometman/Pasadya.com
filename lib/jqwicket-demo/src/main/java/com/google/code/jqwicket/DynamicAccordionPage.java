package com.google.code.jqwicket;

import java.util.Arrays;
import java.util.List;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;

import com.google.code.jqwicket.ui.accordion.AccordionWebMarkupContainer;

public class DynamicAccordionPage extends DemoPage {

	public static class AccordionItem {

		private String title;

		private String content;

		public AccordionItem(String title, String content) {
			this.title = title;
			this.content = content;
		}

	}

	private static List<AccordionItem> items = Arrays.asList(new AccordionItem(
			"title 1", "content 1"), new AccordionItem("title 2", "content 2"),
			new AccordionItem("title 4", "content 3"), new AccordionItem(
					"title 5", "content 4"), new AccordionItem("title 6",
					"content 5"));

	public DynamicAccordionPage() {

		AccordionWebMarkupContainer accordion = new AccordionWebMarkupContainer(
				"accordion");

		accordion.add(new ListView<AccordionItem>("repeater", items) {
			private static final long serialVersionUID = 1L;

			protected void populateItem(ListItem<AccordionItem> item) {
				AccordionItem obj = item.getModelObject();
				item.add(new Label("title", obj.title));
				item.add(new Label("content", obj.content));
			}
		});

		add(accordion);
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
		return "This example demonstrates JQuery UI Accordion integration by creating accordion items dynamically";
	}

}
