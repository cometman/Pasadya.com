package com.google.code.jqwicket;

import org.apache.wicket.ajax.AbstractAjaxTimerBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.util.time.Duration;

import com.google.code.jqwicket.JQBehaviors;
import com.google.code.jqwicket.ui.progressbar.ProgressbarWebMarkupContainer;

public class ProgressbarPage extends DemoPage {

	private int counter = 0;

	@SuppressWarnings("serial")
	public ProgressbarPage() {

		final ProgressbarWebMarkupContainer progressbar = new ProgressbarWebMarkupContainer(
				"progressbar");
		progressbar.add(JQBehaviors.draggable());
		add(progressbar);

		add(new AbstractAjaxTimerBehavior(Duration.seconds(1)) {
			@Override
			protected void onTimer(AjaxRequestTarget target) {
				progressbar.value(target, counter);
				counter++;
				if (counter > 100)
					counter = 0;
			}
		});
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.DemoPage#getExampleTitle()
	 */
	@Override
	protected String getExampleTitle() {
		return "JQuery UI Progressbar example";
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.DemoPage#getExampleDescription()
	 */
	@Override
	protected String getExampleDescription() {
		return "This example demonstrates JQuery UI Progressbar integration";
	}
}
