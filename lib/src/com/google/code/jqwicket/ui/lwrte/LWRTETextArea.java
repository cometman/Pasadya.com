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
package com.google.code.jqwicket.ui.lwrte;

import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.model.IModel;

/**
 * @author mkalina
 * 
 */
public class LWRTETextArea<T> extends TextArea<T> {

	private static final long serialVersionUID = 1L;

	public LWRTETextArea(String id) {
		this(id, new LWRTEOptions());
	}

	public LWRTETextArea(String id, LWRTEOptions options) {
		super(id);
		super.add(new LWRTEBehavior(options));
	}

	public LWRTETextArea(String id, IModel<T> model) {
		this(id, new LWRTEOptions(), model);
	}

	public LWRTETextArea(String id, LWRTEOptions options, IModel<T> model) {
		super(id, model);
		super.add(new LWRTEBehavior(options));
	}

}
