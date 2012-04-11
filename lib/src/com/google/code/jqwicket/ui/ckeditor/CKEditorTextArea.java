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
package com.google.code.jqwicket.ui.ckeditor;

import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.model.IModel;

/**
 * @author mkalina
 * 
 */
public class CKEditorTextArea<T> extends TextArea<T> {

	private static final long serialVersionUID = 1L;

	protected CKEditorBehavior behavior;

	public CKEditorTextArea(String id) {
		this(id, new CKEditorOptions());
	}

	public CKEditorTextArea(String id, CKEditorOptions options) {
		super(id);
		add(this.behavior = newBehavior(options));
	}

	public CKEditorTextArea(String id, IModel<T> model) {
		this(id, new CKEditorOptions(), model);
	}

	public CKEditorTextArea(String id, CKEditorOptions options, IModel<T> model) {
		super(id, model);
		add(behavior = newBehavior(options));
	}

	protected CKEditorBehavior newBehavior(CKEditorOptions options) {
		return new CKEditorBehavior(options);
	}
}
