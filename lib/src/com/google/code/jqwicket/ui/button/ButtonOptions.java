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
package com.google.code.jqwicket.ui.button;

import com.google.code.jqwicket.api.AbstractJQOptions;

/**
 * @author mkalina
 * 
 */
public class ButtonOptions extends AbstractJQOptions<ButtonOptions> {

	private static final long serialVersionUID = 1L;

	public ButtonOptions disabled(boolean disabled) {
		return super.put("disabled", disabled);
	}

	public ButtonOptions text(boolean text) {
		return super.put("text", text);
	}

	public ButtonOptions icons(CharSequence icons) {
		return super.put("icons", icons);
	}

	public ButtonOptions label(CharSequence label) {
		return super.put("label", label);
	}
}
