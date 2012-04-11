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

import com.google.code.jqwicket.Utils;
import com.google.code.jqwicket.api.IJQFunction;
import com.google.code.jqwicket.api.JQLiteral;
import com.google.code.jqwicket.ui.JQUIComponentBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;

/**
 * @author mkalina
 * 
 */
public class DialogBehavior extends JQUIComponentBehavior<DialogOptions>
		implements IDialog {

	private static final long serialVersionUID = 1L;

	public DialogBehavior() {
		this(new DialogOptions());
	}

	public DialogBehavior(DialogOptions options) {
		super(options);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.IJQUIWidget#getName()
	 */
	public CharSequence getName() {
		return JQ_COMPONENT_NAME;
	}

	public DialogBehavior addButtons(DialogButton... buttons) {

		if (Utils.isEmpty(buttons)) {
			this.options.removeOption("buttons");
			return this;
		}
		this.options.put("buttons", JQLiteral._raw(Utils.toJson(buttons)));
		return this;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.dialog.IDialog#open()
	 */
	public IJQFunction open() {
		return chain("open");
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.dialog.IDialog#open(org.apache.wicket.ajax.AjaxRequestTarget)
	 */
	public void open(AjaxRequestTarget ajaxRequestTarget) {
		chain(ajaxRequestTarget, this.open());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.dialog.IDialog#close()
	 */
	public IJQFunction close() {
		return chain("close");
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.dialog.IDialog#close(org.apache.wicket.ajax.AjaxRequestTarget)
	 */
	public void close(AjaxRequestTarget ajaxRequestTarget) {
		chain(ajaxRequestTarget, this.close());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.dialog.IDialog#isOpen()
	 */
	public IJQFunction isOpen() {
		return chain("isOpen");
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.dialog.IDialog#isOpen(org.apache.wicket.ajax.AjaxRequestTarget)
	 */
	public void isOpen(AjaxRequestTarget ajaxRequestTarget) {
		chain(ajaxRequestTarget, this.isOpen());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.dialog.IDialog#moveToTop()
	 */
	public IJQFunction moveToTop() {
		return chain("moveToTop");
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.dialog.IDialog#moveToTop(org.apache.wicket.ajax.AjaxRequestTarget)
	 */
	public void moveToTop(AjaxRequestTarget ajaxRequestTarget) {
		chain(ajaxRequestTarget, this.moveToTop());
	}

}
