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
package com.google.code.jqwicket.ui.progressbar;


import com.google.code.jqwicket.api.IJQFunction;
import com.google.code.jqwicket.ui.JQUIWebMarkupContainer;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.model.IModel;

/**
 * @author mkalina
 *
 */
public class ProgressbarWebMarkupContainer extends
		JQUIWebMarkupContainer<ProgressbarBehavior, ProgressbarOptions> implements
		IProgressbar {

	private static final long serialVersionUID = 1L;

	public ProgressbarWebMarkupContainer(String id) {
		this(id, new ProgressbarOptions());
	}

	public ProgressbarWebMarkupContainer(String id, IModel<?> model) {
		super(id, model, new ProgressbarOptions());
	}

	public ProgressbarWebMarkupContainer(String id, ProgressbarOptions options) {
		super(id, options);
	}

	public ProgressbarWebMarkupContainer(String id, IModel<?> model,
			ProgressbarOptions options) {
		super(id, model, options);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.JQUIWebMarkupContainer#newJQComponentBehavior(com.google.code.jqwicket.ui.JQOptions)
	 */
	@Override
	protected ProgressbarBehavior newJQComponentBehavior(
			ProgressbarOptions options) {
		return new ProgressbarBehavior(options);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.progressbar.IProgressbar#value(int)
	 */
	public IJQFunction value(int value) {
		return this.behavior.value(value);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.progressbar.IProgressbar#value(org.apache.wicket.ajax.AjaxRequestTarget,
	 *      int)
	 */
	public void value(AjaxRequestTarget ajaxRequestTarget, int value) {
		this.behavior.value(ajaxRequestTarget, value);
	}

}
