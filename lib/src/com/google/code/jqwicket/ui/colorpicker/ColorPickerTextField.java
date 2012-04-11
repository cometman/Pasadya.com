/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.code.jqwicket.ui.colorpicker;

import com.google.code.jqwicket.JQHeaderContributionTarget;
import com.google.code.jqwicket.api.IJQFunction;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.IModel;

import static com.google.code.jqwicket.api.JQuery.*;

/**
 * @author mkalina
 * 
 * @param <T>
 *            the model object's type
 */
public class ColorPickerTextField<T> extends TextField<T> implements
		IColorPicker {

	private static final long serialVersionUID = 1L;

	protected ColorPickerBehavior behavior;

	public ColorPickerTextField(String id) {
		this(id, new ColorPickerOptions());
	}

	public ColorPickerTextField(String id, ColorPickerOptions options) {
		super(id);
		this.add(this.behavior = this.newColorPickerBehavior(options));
	}

	public ColorPickerTextField(String id, Class<T> type) {
		this(id, type, new ColorPickerOptions());
	}

	public ColorPickerTextField(String id, Class<T> type,
			ColorPickerOptions options) {
		super(id, type);
		this.add(this.behavior = this.newColorPickerBehavior(options));
	}

	public ColorPickerTextField(String id, IModel<T> model) {
		this(id, model, new ColorPickerOptions());
	}

	public ColorPickerTextField(String id, IModel<T> model,
			ColorPickerOptions options) {
		super(id, model);
		this.add(this.behavior = this.newColorPickerBehavior(options));
	}

	public ColorPickerTextField(String id, IModel<T> model, Class<T> type) {
		this(id, model, type, new ColorPickerOptions());
	}

	public ColorPickerTextField(String id, IModel<T> model, Class<T> type,
			ColorPickerOptions options) {
		super(id, model, type);
		this.add(this.behavior = this.newColorPickerBehavior(options));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.IJQWidget#getName()
	 */
	public CharSequence getName() {
		return this.behavior.getName();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.IJQWidget#getOptions()
	 */
	public ColorPickerOptions getOptions() {
		return this.behavior.getOptions();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.IJQHeaderContributor#contribute(com.google.code.jqwicket.JQHeaderContributionTarget)
	 */
	public void contribute(JQHeaderContributionTarget target) {
		// do nothing here because the underlying behavior already contributes
		// necessary scripts to the jquery target.
	}

	protected ColorPickerBehavior newColorPickerBehavior(
			ColorPickerOptions options) {

		if (!options.containsKey("onSubmit"))
			options.onSubmitEvent($f("$(el).val(hex);$(el).ColorPickerHide();")
					.withParams("hsb", "hex", "rgb", "el"));

		if (!options.containsKey("onBeforeShow"))
			options.onBeforeShowEvent($this().chain("ColorPickerSetColor",
					"this.value"));

		ColorPickerBehavior b = new ColorPickerBehavior(options);
		b.addJQStatements($(this).chain("keyup",
				$f("$(this).ColorPickerSetColor(this.value);")));
		return b;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.colorpicker.IColorPicker#show()
	 */
	public IJQFunction show() {
		return this.behavior.show();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.colorpicker.IColorPicker#show(org.apache.wicket.ajax.AjaxRequestTarget)
	 */
	public void show(AjaxRequestTarget ajaxRequestTarget) {
		this.behavior.show(ajaxRequestTarget);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.colorpicker.IColorPicker#hide()
	 */
	public IJQFunction hide() {
		return this.behavior.hide();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.colorpicker.IColorPicker#hide(org.apache.wicket.ajax.AjaxRequestTarget)
	 */
	public void hide(AjaxRequestTarget ajaxRequestTarget) {
		this.behavior.hide(ajaxRequestTarget);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.colorpicker.IColorPicker#setColor(java.lang.CharSequence)
	 */
	public IJQFunction setColor(CharSequence color) {
		return this.behavior.setColor(color);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.colorpicker.IColorPicker#setColor(org.apache.wicket.ajax.AjaxRequestTarget,
	 *      java.lang.CharSequence)
	 */
	public void setColor(AjaxRequestTarget ajaxRequestTarget, CharSequence color) {
		this.behavior.setColor(ajaxRequestTarget, color);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.colorpicker.IColorPicker#setColor(int,
	 *      int, int)
	 */
	public IJQFunction setColor(int r, int g, int b) {
		return this.behavior.setColor(r, g, b);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.colorpicker.IColorPicker#setColor(org.apache.wicket.ajax.AjaxRequestTarget,
	 *      int, int, int)
	 */
	public void setColor(AjaxRequestTarget ajaxRequestTarget, int r, int g,
			int b) {
		this.behavior.setColor(ajaxRequestTarget, r, g, b);
	}

}
