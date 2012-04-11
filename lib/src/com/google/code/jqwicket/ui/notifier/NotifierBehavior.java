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
package com.google.code.jqwicket.ui.notifier;

import com.google.code.jqwicket.api.IJQFunction;
import com.google.code.jqwicket.api.IJQOptions;
import com.google.code.jqwicket.api.JQOptions;
import com.google.code.jqwicket.ui.JQUIComponentBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;

/**
 * @author mkalina
 * 
 */
public class NotifierBehavior extends JQUIComponentBehavior<NotifierOptions>
		implements INotifier {

	private static final long serialVersionUID = 1L;

	public NotifierBehavior() {
		this(new NotifierOptions());
	}

	public NotifierBehavior(NotifierOptions options) {
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

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.notifier.INotifier#create(java.lang.CharSequence,
	 *      java.lang.CharSequence)
	 */
	public IJQFunction create(CharSequence title, CharSequence text) {
		return create(new JQOptions().put("title", title).put("text", text));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.notifier.INotifier#create(org.apache.wicket.ajax.AjaxRequestTarget,
	 *      java.lang.CharSequence, java.lang.CharSequence)
	 */
	public void create(AjaxRequestTarget ajaxRequestTarget, CharSequence title,
			CharSequence text) {
		chain(ajaxRequestTarget, this.create(title, text));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.notifier.INotifier#create(com.google.code.jqwicket.api.IJQOptions)
	 */
	public IJQFunction create(IJQOptions<?> msg) {
		return chain("create", msg);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.notifier.INotifier#create(org.apache.wicket.ajax.AjaxRequestTarget,
	 *      com.google.code.jqwicket.api.IJQOptions)
	 */
	public void create(AjaxRequestTarget ajaxRequestTarget, IJQOptions<?> msg) {
		chain(ajaxRequestTarget, this.create(msg));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.notifier.INotifier#create(java.lang.CharSequence,
	 *      com.google.code.jqwicket.api.IJQOptions)
	 */
	public IJQFunction create(CharSequence template, IJQOptions<?> msg) {
		return chain("create", template, msg);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.notifier.INotifier#create(org.apache.wicket.ajax.AjaxRequestTarget,
	 *      java.lang.CharSequence, com.google.code.jqwicket.api.IJQOptions)
	 */
	public void create(AjaxRequestTarget ajaxRequestTarget,
			CharSequence template, IJQOptions<?> msg) {
		chain(ajaxRequestTarget, create(template, msg));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.notifier.INotifier#create(java.lang.CharSequence,
	 *      com.google.code.jqwicket.api.IJQOptions,
	 *      com.google.code.jqwicket.api.IJQOptions)
	 */
	public IJQFunction create(CharSequence template, IJQOptions<?> msg,
			IJQOptions<?> options) {
		return chain("create", template, msg, options);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.notifier.INotifier#create(org.apache.wicket.ajax.AjaxRequestTarget,
	 *      java.lang.CharSequence, com.google.code.jqwicket.api.IJQOptions,
	 *      com.google.code.jqwicket.api.IJQOptions)
	 */
	public void create(AjaxRequestTarget ajaxRequestTarget,
			CharSequence template, IJQOptions<?> msg, IJQOptions<?> options) {
		chain(ajaxRequestTarget, create(template, msg, options));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.notifier.INotifier#open()
	 */
	public IJQFunction open() {
		return chain("open");
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.notifier.INotifier#open(org.apache.wicket.ajax.AjaxRequestTarget)
	 */
	public void open(AjaxRequestTarget ajaxRequestTarget) {
		chain(ajaxRequestTarget, open());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.notifier.INotifier#close()
	 */
	public IJQFunction close() {
		return chain("close");
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.notifier.INotifier#close(org.apache.wicket.ajax.AjaxRequestTarget)
	 */
	public void close(AjaxRequestTarget ajaxRequestTarget) {
		chain(ajaxRequestTarget, close());
	}

}
