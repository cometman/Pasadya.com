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
package com.google.code.jqwicket.ui.uploadify;


import com.google.code.jqwicket.api.IJQFunction;
import com.google.code.jqwicket.api.IJQOptions;
import com.google.code.jqwicket.ui.JQWebMarkupContainer;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.model.IModel;

/**
 * @author mkalina
 * 
 */
public class UploadifyWebMarkupContainer extends
		JQWebMarkupContainer<UploadifyBehavior, UploadifyOptions> implements
		IUploadify {

	private static final long serialVersionUID = 1L;

	public UploadifyWebMarkupContainer(String id) {
		this(id, new UploadifyOptions());
	}

	public UploadifyWebMarkupContainer(String id, IModel<?> model) {
		this(id, model, new UploadifyOptions());
	}

	public UploadifyWebMarkupContainer(String id, IModel<?> model,
			UploadifyOptions options) {
		super(id, model, options);
	}

	public UploadifyWebMarkupContainer(String id, UploadifyOptions options) {
		super(id, options);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.JQUIWebMarkupContainer#newJQComponentBehavior(com.google.code.jqwicket.api.IJQOptions)
	 */
	@Override
	protected UploadifyBehavior newJQComponentBehavior(UploadifyOptions options) {
		return new UploadifyBehavior(options);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.uploadify.IUploadify#uploadify()
	 */
	public IJQFunction uploadify() {
		return this.behavior.uploadify();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.uploadify.IUploadify#uploadify(org.apache.wicket.ajax.AjaxRequestTarget)
	 */
	public void uploadify(AjaxRequestTarget ajaxRequestTarget) {
		this.behavior.uploadify(ajaxRequestTarget);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.uploadify.IUploadify#uploadify(com.google.code.jqwicket.api.IJQOptions)
	 */
	public IJQFunction uploadify(IJQOptions<?> options) {
		return this.behavior.uploadify(options);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.uploadify.IUploadify#uploadify(org.apache.wicket.ajax.AjaxRequestTarget,
	 *      com.google.code.jqwicket.api.IJQOptions)
	 */
	public void uploadify(AjaxRequestTarget ajaxRequestTarget,
			IJQOptions<?> options) {
		this.behavior.uploadify(ajaxRequestTarget, options);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.uploadify.IUploadify#uploadifyCancel(java.lang.CharSequence)
	 */
	public IJQFunction uploadifyCancel(CharSequence id) {
		return this.behavior.uploadifyCancel(id);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.uploadify.IUploadify#uploadifyCancel(org.apache.wicket.ajax.AjaxRequestTarget,
	 *      java.lang.CharSequence)
	 */
	public void uploadifyCancel(AjaxRequestTarget ajaxRequestTarget,
			CharSequence id) {
		this.behavior.uploadifyCancel(ajaxRequestTarget, id);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.uploadify.IUploadify#uploadifyClearQueue()
	 */
	public IJQFunction uploadifyClearQueue() {
		return this.behavior.uploadifyClearQueue();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.uploadify.IUploadify#uploadifyClearQueue(org.apache.wicket.ajax.AjaxRequestTarget)
	 */
	public void uploadifyClearQueue(AjaxRequestTarget ajaxRequestTarget) {
		this.behavior.uploadifyClearQueue(ajaxRequestTarget);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.uploadify.IUploadify#uploadifySettings(java.lang.CharSequence,
	 *      java.lang.CharSequence)
	 */
	public IJQFunction uploadifySettings(CharSequence name, CharSequence value) {
		return this.behavior.uploadifySettings(name, value);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.uploadify.IUploadify#uploadifySettings(org.apache.wicket.ajax.AjaxRequestTarget,
	 *      java.lang.CharSequence, java.lang.CharSequence)
	 */
	public void uploadifySettings(AjaxRequestTarget ajaxRequestTarget,
			CharSequence name, CharSequence value) {
		this.behavior.uploadifySettings(ajaxRequestTarget, name, value);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.uploadify.IUploadify#uploadifySettings(java.lang.CharSequence,
	 *      java.lang.CharSequence, boolean)
	 */
	public IJQFunction uploadifySettings(CharSequence name, CharSequence value,
			boolean resetObject) {
		return this.behavior.uploadifySettings(name, value, resetObject);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.uploadify.IUploadify#uploadifySettings(org.apache.wicket.ajax.AjaxRequestTarget,
	 *      java.lang.CharSequence, java.lang.CharSequence, boolean)
	 */
	public void uploadifySettings(AjaxRequestTarget ajaxRequestTarget,
			CharSequence name, CharSequence value, boolean resetObject) {
		this.behavior.uploadifySettings(ajaxRequestTarget, name, value,
				resetObject);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.uploadify.IUploadify#uploadifyUpload()
	 */
	public IJQFunction uploadifyUpload() {
		return this.behavior.uploadifyUpload();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.uploadify.IUploadify#uploadifyUpload(org.apache.wicket.ajax.AjaxRequestTarget)
	 */
	public void uploadifyUpload(AjaxRequestTarget ajaxRequestTarget) {
		this.behavior.uploadifyUpload(ajaxRequestTarget);

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.uploadify.IUploadify#uploadifyUpload(java.lang.CharSequence)
	 */
	public IJQFunction uploadifyUpload(CharSequence id) {
		return this.behavior.uploadifyUpload(id);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.uploadify.IUploadify#uploadifyUpload(org.apache.wicket.ajax.AjaxRequestTarget,
	 *      java.lang.CharSequence)
	 */
	public void uploadifyUpload(AjaxRequestTarget ajaxRequestTarget,
			CharSequence id) {
		this.behavior.uploadifyUpload(ajaxRequestTarget, id);
	}

}
