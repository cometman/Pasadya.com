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


import com.google.code.jqwicket.IJQUIWidget;
import com.google.code.jqwicket.api.IJQFunction;
import com.google.code.jqwicket.ui.XYPosition;
import org.apache.wicket.ajax.AjaxRequestTarget;

/**
 * @author mkalina
 * 
 */
public interface IGenericDatePicker<T extends AbstractDatePickerOptions<T>>
		extends IJQUIWidget<T> {

	/**
	 * Open a datepicker in a "dialog" box.
	 */
	IJQFunction dialog(CharSequence date, IJQFunction onSelect, T options,
			XYPosition position);

	/**
	 * Open a datepicker in a "dialog" box.
	 * 
	 * @param ajaxRequestTarget
	 */
	void dialog(AjaxRequestTarget ajaxRequestTarget, CharSequence date,
			IJQFunction onSelect, T options, XYPosition position);

	/**
	 * Close a previously opened date picker.
	 */
	IJQFunction hide();

	/**
	 * Close a previously opened date picker.
	 * 
	 * @param ajaxRequestTarget
	 */
	void hide(AjaxRequestTarget ajaxRequestTarget);

	/**
	 * Call up a previously attached date picker.
	 */
	IJQFunction show();

	/**
	 * Call up a previously attached date picker.
	 * 
	 * @param ajaxRequestTarget
	 */
	void show(AjaxRequestTarget ajaxRequestTarget);

	/**
	 * Redraw a date picker, after having made some external modifications.
	 */
	IJQFunction refresh();

	/**
	 * Redraw a date picker, after having made some external modifications.
	 * 
	 * @param ajaxRequestTarget
	 */
	void refresh(AjaxRequestTarget ajaxRequestTarget);

	/**
	 * Sets the current date for the datepicker.
	 */
	IJQFunction setDate(CharSequence date);

	/**
	 * Sets the current date for the datepicker.
	 * 
	 * @param ajaxRequestTarget
	 */
	void setDate(AjaxRequestTarget ajaxRequestTarget, CharSequence date);

	/**
	 * Sets the current date for the datepicker.
	 */
	IJQFunction setDate(int date);

	/**
	 * Sets the current date for the datepicker.
	 * 
	 * @param ajaxRequestTarget
	 */
	void setDate(AjaxRequestTarget ajaxRequestTarget, int date);
}
