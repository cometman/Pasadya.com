package com.google.code.jqwicket;

import static com.google.code.jqwicket.api.JQuery.$f;

import java.util.Arrays;
import java.util.List;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.ILinkListener;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.ListDataProvider;

import com.google.code.jqwicket.api.JQOptions;
import com.google.code.jqwicket.ui.dialog.DialogOptions;
import com.google.code.jqwicket.ui.dialog.DialogWebMarkupContainer;

public class DialogPage extends DemoPage {

	private static final List<String> list = Arrays.asList("a", "b", "c");

	@SuppressWarnings("serial")
	public DialogPage() {

		final DialogWebMarkupContainer dialog = new DialogWebMarkupContainer(
				"dialog", new DialogOptions().modal(true).resizable(false));
		add(dialog);

		add(new AjaxLink<Void>("dialog.open1") {
			@Override
			public void onClick(AjaxRequestTarget target) {
				dialog.open(target);
			}
		});

		DataView<String> listview = new DataView<String>("pageable",
				new ListDataProvider<String>(list)) {

			@Override
			protected void populateItem(Item<String> item) {

				this.add(item);

				item.add(new Label("somecolumn", item.getModel()));
				final Link<Void> link = new Link<Void>("accept") {
					@Override
					public void onClick() {
						// do stuff
					}

					@Override
					protected void onComponentTag(ComponentTag tag) {
						super.onComponentTag(tag);
						tag.put("href", "#");
					}

				};
				item.add(link);

				DialogWebMarkupContainer confirm = new DialogWebMarkupContainer(
						"confirm-dialog",
						new DialogOptions()
								.modal(true)
								.resizable(false)
								.buttons(
										new JQOptions()
												.put("'Yes'",
														$f("$(this).dialog('close'); window.location = '"
																+ link.urlFor(ILinkListener.INTERFACE)
																+ "';"))
												.put("'No'",
														$f("$(this).dialog('close')"))));
				item.add(confirm);

				link.add(JQBehaviors.mouseClick(confirm.open()));

			}
		};
		add(listview);

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.DemoPage#getExampleTitle()
	 */
	@Override
	protected String getExampleTitle() {
		return "JQuery UI Dialog example";
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.DemoPage#getExampleDescription()
	 */
	@Override
	protected String getExampleDescription() {
		return "This example demonstrates JQuery UI Dialog integration";
	}

}
