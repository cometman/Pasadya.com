package com.google.code.jqwicket;

import org.apache.wicket.markup.html.WebMarkupContainer;

import com.google.code.jqwicket.ui.datetimepicker.DateTimePickerBehavior;
import com.google.code.jqwicket.ui.datetimepicker.DateTimePickerOptions;
import com.google.code.jqwicket.ui.datetimepicker.DateTimePickerTextField;
import com.google.code.jqwicket.ui.datetimepicker.TimePickerTextField;

public class DateTimePickerPage extends DemoPage {

	public DateTimePickerPage() {

		add(new DateTimePickerTextField<String>("datetimepicker"));
		add(new TimePickerTextField<String>("timepicker",
				new DateTimePickerOptions().hourGrid(3)));

		add(new WebMarkupContainer("datetimepicker.inline")
				.add(new DateTimePickerBehavior()));

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.DemoPage#getExampleTitle()
	 */
	@Override
	protected String getExampleTitle() {
		return "JQuery UI DateTimePicker example";
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.DemoPage#getExampleDescription()
	 */
	@Override
	protected String getExampleDescription() {
		return "This example demonstrates JQuery UI DateTimePicker integration";
	}

}
