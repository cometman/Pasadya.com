package com.google.code.jqwicket;

import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.link.Link;

import com.google.code.jqwicket.ui.button.ButtonBehavior;
import com.google.code.jqwicket.ui.button.ButtonOptions;

public class ButtonPage extends DemoPage {

	@SuppressWarnings("serial")
	public ButtonPage() {

		add(new Button("button1").add(new ButtonBehavior()));

		Button b2 = new Button("button2");
		b2.add(new ButtonBehavior());
		add(b2);

		Link<Void> b3 = new Link<Void>("button3") {
			@Override
			public void onClick() {
				// do something here
			}
		};
		b3.add(new ButtonBehavior(new ButtonOptions().label("my label")
				.disabled(true)));
		add(b3);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.DemoPage#getExampleTitle()
	 */
	@Override
	protected String getExampleTitle() {
		return "JQuery UI Button example";
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.DemoPage#getExampleDescription()
	 */
	@Override
	protected String getExampleDescription() {
		return "This example demonstrates JQuery UI Button integration";
	}

}
