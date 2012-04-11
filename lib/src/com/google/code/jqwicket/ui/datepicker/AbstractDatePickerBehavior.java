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

import com.google.code.jqwicket.api.IJQFunction;
import com.google.code.jqwicket.ui.JQUIComponentBehavior;
import com.google.code.jqwicket.ui.XYPosition;
import org.apache.wicket.ajax.AjaxRequestTarget;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mkalina
 * 
 */
public abstract class AbstractDatePickerBehavior<T extends AbstractDatePickerOptions<T>>
		extends JQUIComponentBehavior<T> implements IGenericDatePicker<T> {

	private static final long serialVersionUID = 1L;

	public AbstractDatePickerBehavior(T options) {
		super(options);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.datepicker.IGenericDatePicker#dialog(java.lang.CharSequence,
	 *      com.google.code.jqwicket.api.IJQFunction,
	 *      com.google.code.jqwicket.ui.datepicker.AbstractDatePickerOptions,
	 *      com.google.code.jqwicket.ui.XYPosition)
	 */
	public IJQFunction dialog(CharSequence date, IJQFunction onSelect,
			T options, XYPosition position) {

		List<CharSequence> args = new ArrayList<CharSequence>();
		args.add("dialog");
		args.add(date);
		if (onSelect != null)
			args.add(onSelect);
		if (options != null)
			args.add(options);
		if (position != null)
			args.add(position);

		return chain(args.toArray(new CharSequence[args.size()]));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.datepicker.IGenericDatePicker#dialog(org.apache.wicket.ajax.AjaxRequestTarget,
	 *      java.lang.CharSequence, com.google.code.jqwicket.api.IJQFunction,
	 *      com.google.code.jqwicket.ui.datepicker.AbstractDatePickerOptions,
	 *      com.google.code.jqwicket.ui.XYPosition)
	 */
	public void dialog(AjaxRequestTarget ajaxRequestTarget, CharSequence date,
			IJQFunction onSelect, T options, XYPosition position) {
		chain(ajaxRequestTarget, this.dialog(date, onSelect, options, position));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.datepicker.IDatePicker#hide()
	 */
	public IJQFunction hide() {
		return chain("hide");
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.datepicker.IDatePicker#hide(org.apache.wicket.ajax.AjaxRequestTarget)
	 */
	public void hide(AjaxRequestTarget ajaxRequestTarget) {
		chain(ajaxRequestTarget, this.hide());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.datepicker.IDatePicker#show()
	 */
	public IJQFunction show() {
		return chain("hide");
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.datepicker.IDatePicker#show(org.apache.wicket.ajax.AjaxRequestTarget)
	 */
	public void show(AjaxRequestTarget ajaxRequestTarget) {
		chain(ajaxRequestTarget, this.show());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.datepicker.IDatePicker#refresh()
	 */
	public IJQFunction refresh() {
		return chain("refresh");
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.datepicker.IDatePicker#refresh(org.apache.wicket.ajax.AjaxRequestTarget)
	 */
	public void refresh(AjaxRequestTarget ajaxRequestTarget) {
		chain(ajaxRequestTarget, this.refresh());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.datepicker.IDatePicker#setDate(java.lang.CharSequence)
	 */
	public IJQFunction setDate(CharSequence date) {
		return chain("setDate", date);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.datepicker.IDatePicker#setDate(org.apache.wicket.ajax.AjaxRequestTarget,
	 *      java.lang.CharSequence)
	 */
	public void setDate(AjaxRequestTarget ajaxRequestTarget, CharSequence date) {
		chain(ajaxRequestTarget, this.setDate(date));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.datepicker.IDatePicker#setDate(int)
	 */
	public IJQFunction setDate(int date) {
		return chain("setDate", String.valueOf(date));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.datepicker.IDatePicker#setDate(org.apache.wicket.ajax.AjaxRequestTarget,
	 *      int)
	 */
	public void setDate(AjaxRequestTarget ajaxRequestTarget, int date) {
		chain(ajaxRequestTarget, this.setDate(date));
	}

}
