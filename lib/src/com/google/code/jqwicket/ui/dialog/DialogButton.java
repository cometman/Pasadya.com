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
package com.google.code.jqwicket.ui.dialog;

import com.google.code.jqwicket.api.IJQFunction;
import com.google.code.jqwicket.api.IJQOptions;
import com.google.code.jqwicket.api.JQOptions;

import java.io.Serializable;

/**
 * @author mkalina
 * 
 */
public class DialogButton implements Serializable, CharSequence {

	private static final long serialVersionUID = 1L;

	private IJQOptions<?> options;

	public DialogButton(CharSequence name, IJQFunction callback) {
		this.options = new JQOptions().put("text", name).put("click", callback);
	}

	public int length() {
		return options.length();
	}

	public char charAt(int index) {
		return options.charAt(index);
	}

	public CharSequence subSequence(int start, int end) {
		return options.subSequence(start, end);
	}

	@Override
	public String toString() {
		return this.options.toString();
	}

}
