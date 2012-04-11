package com.google.code.jqwicket;

import org.apache.wicket.markup.html.form.CheckBox;

import com.google.code.jqwicket.ui.datepicker.DatePickerTextField;
import com.google.code.jqwicket.ui.uniform.GenericUniformBehavior;

public class UniformPage extends DemoPage {

	public UniformPage() {
		add(new GenericUniformBehavior("input, textarea, select, button"));
		add(new CheckBox("uniform.checkbox"));
		add(new DatePickerTextField<String>("dateOfBirth"));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.DemoPage#getExampleTitle()
	 */
	@Override
	protected String getExampleTitle() {
		return "JQuery UI Uniform Plugin example";
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.DemoPage#getExampleDescription()
	 */
	@Override
	protected String getExampleDescription() {
		return "This example demonstrates JQuery UI Uniform Plugin integration";
	}
}
