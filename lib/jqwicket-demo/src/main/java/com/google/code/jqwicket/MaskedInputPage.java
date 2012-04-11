package com.google.code.jqwicket;

import org.apache.wicket.markup.html.form.TextField;

import com.google.code.jqwicket.ui.maskedinput.MaskedInputBehavior;

public class MaskedInputPage extends DemoPage {

	public MaskedInputPage() {

		add(new TextField<String>("date").add(new MaskedInputBehavior(
				"99/99/9999")));
		add(new TextField<String>("phone").add(new MaskedInputBehavior(
				"(999) 999-9999")));
		add(new TextField<String>("phoneext").add(new MaskedInputBehavior(
				"(999) 999-9999? x99999")));
		add(new TextField<String>("tin").add(new MaskedInputBehavior(
				"99-9999999")));
		add(new TextField<String>("ssn").add(new MaskedInputBehavior(
				"999-99-9999")));
		add(new TextField<String>("product").add(new MaskedInputBehavior(
				"a*-999-a999")));
		add(new TextField<String>("eyescript").add(new MaskedInputBehavior(
				"~9.99 ~9.99 999")));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.DemoPage#getExampleTitle()
	 */
	@Override
	protected String getExampleTitle() {
		return "JQuery MaskedInput Plugin example";
	}

}
