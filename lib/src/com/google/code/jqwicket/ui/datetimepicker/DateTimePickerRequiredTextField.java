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
package com.google.code.jqwicket.ui.datetimepicker;


import com.google.code.jqwicket.ui.datepicker.AbstractDatePickerRequiredTextField;
import org.apache.wicket.model.IModel;

/**
 * @author mkalina
 * 
 */
public class DateTimePickerRequiredTextField<T>
		extends
		AbstractDatePickerRequiredTextField<T, DateTimePickerOptions, DateTimePickerBehavior>
		implements IDateTimePicker {

	private static final long serialVersionUID = 1L;

	public DateTimePickerRequiredTextField(String id, Class<T> type) {
		super(id, type, new DateTimePickerOptions());
	}

	public DateTimePickerRequiredTextField(String id, Class<T> type,
			DateTimePickerOptions options) {
		super(id, type, options);
	}

	public DateTimePickerRequiredTextField(String id) {
		super(id, new DateTimePickerOptions());
	}

	public DateTimePickerRequiredTextField(String id,
			DateTimePickerOptions options) {
		super(id, options);
	}

	public DateTimePickerRequiredTextField(String id, IModel<T> model,
			Class<T> type, DateTimePickerOptions options) {
		super(id, model, type, options);
	}

	public DateTimePickerRequiredTextField(String id, IModel<T> model,
			Class<T> type) {
		super(id, model, type, new DateTimePickerOptions());
	}

	public DateTimePickerRequiredTextField(String id, IModel<T> model,
			DateTimePickerOptions options) {
		super(id, model, options);
	}

	public DateTimePickerRequiredTextField(String id, IModel<T> model) {
		super(id, model, new DateTimePickerOptions());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.datepicker.AbstractDatePickerTextField#newDatePickerBehavior(com.google.code.jqwicket.ui.datepicker.AbstractDatePickerOptions)
	 */
	@Override
	protected DateTimePickerBehavior newDatePickerBehavior(
			DateTimePickerOptions options) {
		return new DateTimePickerBehavior(options);
	}

}
