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
package com.google.code.jqwicket.ui.guider;

import com.google.code.jqwicket.api.AbstractJQOptions;
import com.google.code.jqwicket.api.JQLiteral;

/**
 * @author mkalina
 * 
 */
public class GuiderButton extends AbstractJQOptions<GuiderButton> {

	private static final long serialVersionUID = 1L;

	public GuiderButton() {
	}

	public GuiderButton(CharSequence name) {
		this.name(name);
	}

	public GuiderButton(CharSequence name, CharSequence onclick) {
		this.name(name).onclick(onclick);
	}

	public GuiderButton name(CharSequence name) {
		return this.put("name", name);
	}

	public GuiderButton onclick(CharSequence onclick) {
		return this.put("onclick", JQLiteral._raw(onclick));
	}

	public GuiderButton classString(CharSequence classString) {
		return this.put("classString", classString);
	}

}
