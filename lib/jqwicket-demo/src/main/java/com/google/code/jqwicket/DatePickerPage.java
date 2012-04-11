package com.google.code.jqwicket;

import org.apache.wicket.markup.html.WebMarkupContainer;

import com.google.code.jqwicket.ui.datepicker.DatePickerBehavior;
import com.google.code.jqwicket.ui.datepicker.DatePickerTextField;

public class DatePickerPage extends DemoPage {

	public DatePickerPage() {

		add(new DatePickerTextField<String>("datepicker"));
		add(new WebMarkupContainer("datepicker.inline")
				.add(new DatePickerBehavior()));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.DemoPage#getExampleTitle()
	 */
	@Override
	protected String getExampleTitle() {
		return "JQuery UI Datepicker example";
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.DemoPage#getExampleDescription()
	 */
	@Override
	protected String getExampleDescription() {
		return "This example demonstrates JQuery UI Datepicker integration";
	}

}
