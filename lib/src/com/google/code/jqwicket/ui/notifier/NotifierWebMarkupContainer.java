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
import com.google.code.jqwicket.ui.JQUIWebMarkupContainer;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.model.IModel;

/**
 * @author mkalina
 *
 */
/**
 * @author mkalina
 *
 */
/**
 * @author mkalina
 * 
 */
public class NotifierWebMarkupContainer extends
		JQUIWebMarkupContainer<NotifierBehavior, NotifierOptions> implements
		INotifier {

	private static final long serialVersionUID = 1L;

	public NotifierWebMarkupContainer(String id) {
		this(id, new NotifierOptions());
	}

	public NotifierWebMarkupContainer(String id, IModel<?> model) {
		this(id, model, new NotifierOptions());
	}

	public NotifierWebMarkupContainer(String id, IModel<?> model,
			NotifierOptions options) {
		super(id, model, options);
	}

	public NotifierWebMarkupContainer(String id, NotifierOptions options) {
		super(id, options);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.JQUIWebMarkupContainer#newJQComponentBehavior(com.google.code.jqwicket.api.IJQOptions)
	 */
	@Override
	protected NotifierBehavior newJQComponentBehavior(NotifierOptions options) {
		return new NotifierBehavior(options);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.notifier.INotifier#create(java.lang.CharSequence,
	 *      java.lang.CharSequence)
	 */
	public IJQFunction create(CharSequence title, CharSequence text) {
		return this.behavior.create(title, text);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.notifier.INotifier#create(org.apache.wicket.ajax.AjaxRequestTarget,
	 *      java.lang.CharSequence, java.lang.CharSequence)
	 */
	public void create(AjaxRequestTarget ajaxRequestTarget, CharSequence title,
			CharSequence text) {
		this.behavior.create(ajaxRequestTarget, title, text);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.notifier.INotifier#create(com.google.code.jqwicket.api.IJQOptions)
	 */
	public IJQFunction create(IJQOptions<?> msg) {
		return this.behavior.create(msg);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.notifier.INotifier#create(org.apache.wicket.ajax.AjaxRequestTarget,
	 *      com.google.code.jqwicket.api.IJQOptions)
	 */
	public void create(AjaxRequestTarget ajaxRequestTarget, IJQOptions<?> msg) {
		this.behavior.create(ajaxRequestTarget, msg);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.notifier.INotifier#create(java.lang.CharSequence,
	 *      com.google.code.jqwicket.api.IJQOptions)
	 */
	public IJQFunction create(CharSequence template, IJQOptions<?> msg) {
		return this.behavior.create(template, msg);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.notifier.INotifier#create(org.apache.wicket.ajax.AjaxRequestTarget,
	 *      java.lang.CharSequence, com.google.code.jqwicket.api.IJQOptions)
	 */
	public void create(AjaxRequestTarget ajaxRequestTarget,
			CharSequence template, IJQOptions<?> msg) {
		this.behavior.create(ajaxRequestTarget, template, msg);
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
		return this.behavior.create(template, msg, options);
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
		this.behavior.create(ajaxRequestTarget, template, msg, options);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.notifier.INotifier#open()
	 */
	public IJQFunction open() {
		return this.behavior.open();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.notifier.INotifier#open(org.apache.wicket.ajax.AjaxRequestTarget)
	 */
	public void open(AjaxRequestTarget ajaxRequestTarget) {
		this.behavior.open(ajaxRequestTarget);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.notifier.INotifier#close()
	 */
	public IJQFunction close() {
		return this.behavior.close();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.notifier.INotifier#close(org.apache.wicket.ajax.AjaxRequestTarget)
	 */
	public void close(AjaxRequestTarget ajaxRequestTarget) {
		this.behavior.close(ajaxRequestTarget);

	}
}
