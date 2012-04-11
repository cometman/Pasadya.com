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
package com.google.code.jqwicket.ui.datepicker;


import com.google.code.jqwicket.JQHeaderContributionTarget;
import com.google.code.jqwicket.api.IJQFunction;
import com.google.code.jqwicket.api.IJQOptions;
import com.google.code.jqwicket.ui.XYPosition;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.IModel;

/**
 * @author mkalina
 * 
 * @param <T>
 *            the model object's type
 */
public abstract class AbstractDatePickerTextField<T, O extends AbstractDatePickerOptions<O>, B extends AbstractDatePickerBehavior<O>>
		extends TextField<T> implements IGenericDatePicker<O> {

	private static final long serialVersionUID = 1L;

	protected B behavior;

	public AbstractDatePickerTextField(String id, O options) {
		super(id);
		this.add(this.behavior = this.newDatePickerBehavior(options));
	}

	public AbstractDatePickerTextField(String id, Class<T> type, O options) {
		super(id, type);
		this.add(this.behavior = this.newDatePickerBehavior(options));
	}

	public AbstractDatePickerTextField(String id, IModel<T> model, O options) {
		super(id, model);
		this.add(this.behavior = this.newDatePickerBehavior(options));
	}

	public AbstractDatePickerTextField(String id, IModel<T> model,
			Class<T> type, O options) {
		super(id, model, type);
		this.add(this.behavior = this.newDatePickerBehavior(options));
	}

	/**
	 * Creates new concrete date picker behavior
	 * 
	 * @param options
	 * @return
	 */
	protected abstract B newDatePickerBehavior(O options);

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.IJQUIWidget#destroy()
	 */
	public IJQFunction destroy() {
		return behavior.destroy();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.IJQUIWidget#destroy(org.apache.wicket.ajax.AjaxRequestTarget)
	 */
	public void destroy(AjaxRequestTarget ajaxRequestTarget) {
		behavior.destroy(ajaxRequestTarget);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.IJQUIWidget#disable()
	 */
	public IJQFunction disable() {
		return behavior.disable();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.IJQUIWidget#disable(org.apache.wicket.ajax.AjaxRequestTarget)
	 */
	public void disable(AjaxRequestTarget ajaxRequestTarget) {
		behavior.disable(ajaxRequestTarget);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.IJQUIWidget#enable()
	 */
	public IJQFunction enable() {
		return behavior.enable();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.IJQUIWidget#enable(org.apache.wicket.ajax.AjaxRequestTarget)
	 */
	public void enable(AjaxRequestTarget ajaxRequestTarget) {
		behavior.enable(ajaxRequestTarget);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.IJQUIWidget#option(java.lang.CharSequence,
	 *      java.lang.CharSequence)
	 */
	public IJQFunction option(CharSequence optionName, CharSequence optionValue) {
		return behavior.option(optionName, optionValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.IJQUIWidget#option(org.apache.wicket.ajax.AjaxRequestTarget,
	 *      java.lang.CharSequence, java.lang.CharSequence)
	 */
	public void option(AjaxRequestTarget ajaxRequestTarget,
			CharSequence optionName, CharSequence optionValue) {
		behavior.option(ajaxRequestTarget, optionName, optionValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.datepicker.IDatePicker#dialog(java.lang.CharSequence,
	 *      com.google.code.jqwicket.api.IJQFunction,
	 *      com.google.code.jqwicket.ui.datepicker.DatePickerOptions,
	 *      com.google.code.jqwicket.ui.XYPosition)
	 */
	public IJQFunction dialog(CharSequence date, IJQFunction onSelect, O options,
			XYPosition position) {
		return behavior.dialog(date, onSelect, options, position);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.datepicker.IDatePicker#dialog(org.apache.wicket.ajax.AjaxRequestTarget,
	 *      java.lang.CharSequence, com.google.code.jqwicket.api.IJQFunction,
	 *      com.google.code.jqwicket.ui.datepicker.DatePickerOptions,
	 *      com.google.code.jqwicket.ui.XYPosition)
	 */
	public void dialog(AjaxRequestTarget ajaxRequestTarget, CharSequence date,
			IJQFunction onSelect, O options, XYPosition position) {
		behavior.dialog(ajaxRequestTarget, date, onSelect, options, position);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.datepicker.IDatePicker#hide()
	 */
	public IJQFunction hide() {
		return behavior.hide();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.datepicker.IDatePicker#hide(org.apache.wicket.ajax.AjaxRequestTarget)
	 */
	public void hide(AjaxRequestTarget ajaxRequestTarget) {
		behavior.hide(ajaxRequestTarget);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.datepicker.IDatePicker#show()
	 */
	public IJQFunction show() {
		return behavior.show();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.datepicker.IDatePicker#show(org.apache.wicket.ajax.AjaxRequestTarget)
	 */
	public void show(AjaxRequestTarget ajaxRequestTarget) {
		behavior.show(ajaxRequestTarget);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.datepicker.IDatePicker#refresh()
	 */
	public IJQFunction refresh() {
		return behavior.refresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.datepicker.IDatePicker#refresh(org.apache.wicket.ajax.AjaxRequestTarget)
	 */
	public void refresh(AjaxRequestTarget ajaxRequestTarget) {
		behavior.refresh(ajaxRequestTarget);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.datepicker.IDatePicker#setDate(java.lang.CharSequence)
	 */
	public IJQFunction setDate(CharSequence date) {
		return behavior.setDate(date);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.datepicker.IDatePicker#setDate(org.apache.wicket.ajax.AjaxRequestTarget,
	 *      java.lang.CharSequence)
	 */
	public void setDate(AjaxRequestTarget ajaxRequestTarget, CharSequence date) {
		behavior.setDate(ajaxRequestTarget, date);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.datepicker.IDatePicker#setDate(int)
	 */
	public IJQFunction setDate(int date) {
		return behavior.setDate(date);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.datepicker.IDatePicker#setDate(org.apache.wicket.ajax.AjaxRequestTarget,
	 *      int)
	 */
	public void setDate(AjaxRequestTarget ajaxRequestTarget, int date) {
		behavior.setDate(ajaxRequestTarget, date);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.IJQUIWidget#getName()
	 */
	public CharSequence getName() {
		return this.behavior.getName();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.IJQUIWidget#getOptions()
	 */
	public O getOptions() {
		return this.behavior.getOptions();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.IJQUIWidget#options(com.google.code.jqwicket.api.IJQOptions)
	 */
	public IJQFunction options(IJQOptions<?> options) {
		return this.behavior.options(options);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.IJQUIWidget#options(org.apache.wicket.ajax.AjaxRequestTarget,
	 *      com.google.code.jqwicket.api.IJQOptions)
	 */
	public void options(AjaxRequestTarget ajaxRequestTarget,
			IJQOptions<?> options) {
		this.behavior.options(ajaxRequestTarget, options);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.IJQUIWidget#widget()
	 */
	public IJQFunction widget() {
		return this.behavior.widget();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.IJQUIWidget#widget(org.apache.wicket.ajax.AjaxRequestTarget)
	 */
	public void widget(AjaxRequestTarget ajaxRequestTarget) {
		this.behavior.widget(ajaxRequestTarget);
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

}
