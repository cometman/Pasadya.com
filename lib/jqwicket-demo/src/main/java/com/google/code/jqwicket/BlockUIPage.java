package com.google.code.jqwicket;

import static com.google.code.jqwicket.api.JQuery.$f;
import static com.google.code.jqwicket.api.JQuery.js;

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.form.Button;

import com.google.code.jqwicket.api.IJQStatement;
import com.google.code.jqwicket.ui.blockui.BlockUIBehavior;
import com.google.code.jqwicket.ui.blockui.BlockUIOptions;

public class BlockUIPage extends DemoPage {

	public BlockUIPage() {

		BlockUIBehavior b = new BlockUIBehavior();
		add(b);

		add(new Button("blockScreenButton").add(JQBehaviors
				.mouseClick($f(new IJQStatement[] { b.block().toStatement(),
						js("setTimeout($.unblockUI, 2000)") }))));
		add(new Button("blockScreenButton2").add(JQBehaviors.mouseClick(b
				.block(new BlockUIOptions()
						.message("Custom loading message...")))));
		add(new Button("unblockScreenButton").add(JQBehaviors.mouseClick(b
				.unblock())));

		final WebMarkupContainer blockMe = new WebMarkupContainer("blockMe");
		blockMe.setOutputMarkupId(true);
		add(blockMe);

		add(new Button("blockElementButton").add(JQBehaviors.mouseClick(b
				.block(blockMe))));
		add(new Button("blockElementButton2").add(JQBehaviors.mouseClick(b
				.block(blockMe, new BlockUIOptions()
						.message("Custom loading message...")))));
		add(new Button("unblockElementButton").add(JQBehaviors.mouseClick(b
				.unblock(blockMe))));

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.DemoPage#getExampleTitle()
	 */
	@Override
	protected String getExampleTitle() {
		return "JQuery BlockUI plugin example";
	}

}
