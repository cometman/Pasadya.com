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
package com.google.code.jqwicket.ui.validationengine;

import com.google.code.jqwicket.Utils;

import java.io.Serializable;

import static com.google.code.jqwicket.Utils.quote;

/**
 * @author mkalina
 * 
 */
public abstract class ValidationRule<T extends ValidationRule<T>> implements
		Serializable, CharSequence {

	private static final long serialVersionUID = 1L;

	private CharSequence name;

	private CharSequence[] alertTextErrors;

	public ValidationRule(CharSequence name, CharSequence... alertTextErrors) {
		this.name = name;
		this.alertTextErrors = alertTextErrors;
	}

	protected abstract CharSequence customPayloadToJson();

	public char charAt(int index) {
		return toString().charAt(index);
	}

	public int length() {
		return toString().length();
	}

	public CharSequence subSequence(int start, int end) {
		return toString().subSequence(start, end);
	}

	@Override
	public String toString() {
		StringBuffer buf = new StringBuffer();
		buf.append(quote(name)).append(":");
		buf.append("{");
		buf.append(this.customPayloadToJson());
		if (Utils.isNotEmpty(alertTextErrors)) {
			buf.append(",");
			for (int i = 0; i < alertTextErrors.length; i++) {
				if (i > 0)
					buf.append(",");
				buf.append("'alertText");
				if (i > 0)
					buf.append(i + 1);
				buf.append("':").append(quote(alertTextErrors[i]));
			}
		}
		buf.append("}");
		return buf.toString();
	}
}
