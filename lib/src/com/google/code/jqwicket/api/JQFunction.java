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
package com.google.code.jqwicket.api;

import com.google.code.jqwicket.Utils;

import java.io.Serializable;

import static com.google.code.jqwicket.Utils.isNotEmpty;
import static com.google.code.jqwicket.Utils.semicolon;

/**
 * See {@link IJQFunction}.
 * 
 * @author max
 * 
 */
class JQFunction implements IJQFunction, Serializable {

	private static final long serialVersionUID = 1L;

	private CharSequence name;

	private CharSequence[] params;

	private CharSequence body;

	JQFunction(CharSequence... bodyStatements) {
		this.body = (bodyStatements != null ? Utils.join(Utils.walk(
				bodyStatements, new Utils.IArrayWalkCallback<CharSequence>() {
					public CharSequence onElement(int index, CharSequence obj) {
						return semicolon(obj);
					}
				}), "\n") : "");
	}

	public IJQFunction withParams(CharSequence... params) {
		this.params = params;
		return this;
	}

	public IJQFunction withName(CharSequence name) {
		this.name = name;
		return this;
	}

	public int length() {
		return this.toString().length();
	}

	public char charAt(int index) {
		return this.toString().charAt(index);
	}

	public CharSequence subSequence(int start, int end) {
		return this.toString().subSequence(start, end);
	}

	@Override
	public String toString() {
		return toString(false);
	}

	public CharSequence[] getParams() {
		return params;
	}

	public CharSequence getName() {
		return name;
	}

	public CharSequence toStringBodyOnly() {
		return body;
	}

	public String toString(boolean renderFunctionBodyOnly) {
		if (renderFunctionBodyOnly)
			return String.valueOf(this.body);

		StringBuffer sb = new StringBuffer();
		sb.append("function");

		if (Utils.isNotBlank(this.name)) {
			sb.append(" ").append(this.name);
		}

		sb.append("(");
		if (isNotEmpty(params)) {
			sb.append(Utils.join(params, ","));
		}
		sb.append("){").append(toStringBodyOnly()).append("}");
		return sb.toString();
	}

	public IJQStatement toStatement() {
		return JQuery.js(this.body);
	}

}
