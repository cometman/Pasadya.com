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

import org.apache.wicket.model.IModel;

/**
 * @author mkalina
 * 
 */
public abstract class AbstractDatePickerRequiredTextField<T, O extends AbstractDatePickerOptions<O>, B extends AbstractDatePickerBehavior<O>>
		extends AbstractDatePickerTextField<T, O, B> {

	private static final long serialVersionUID = 1L;

	public AbstractDatePickerRequiredTextField(String id, Class<T> type,
			O options) {
		super(id, type, options);
		super.setRequired(true);
	}

	public AbstractDatePickerRequiredTextField(String id, IModel<T> model,
			Class<T> type, O options) {
		super(id, model, type, options);
		super.setRequired(true);
	}

	public AbstractDatePickerRequiredTextField(String id, IModel<T> model,
			O options) {
		super(id, model, options);
		super.setRequired(true);
	}

	public AbstractDatePickerRequiredTextField(String id, O options) {
		super(id, options);
		super.setRequired(true);
	}

}
