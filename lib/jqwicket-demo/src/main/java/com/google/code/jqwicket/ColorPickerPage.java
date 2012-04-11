package com.google.code.jqwicket;

import com.google.code.jqwicket.ui.colorpicker.ColorPickerTextField;

public class ColorPickerPage extends DemoPage {

	public ColorPickerPage() {
		add(new ColorPickerTextField<String>("colorpicker"));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.DemoPage#getExampleTitle()
	 */
	@Override
	protected String getExampleTitle() {
		return "JQuery ColorPicker Plugin example";
	}

}
