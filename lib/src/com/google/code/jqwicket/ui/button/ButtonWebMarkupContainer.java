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


import com.google.code.jqwicket.api.IJQFunction;
import com.google.code.jqwicket.ui.JQUIWebMarkupContainer;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.model.IModel;

/**
 * @author mkalina
 *
 */
public class ButtonWebMarkupContainer extends
		JQUIWebMarkupContainer<ButtonBehavior, ButtonOptions> implements IButton {

	private static final long serialVersionUID = 1L;

	public ButtonWebMarkupContainer(String id) {
		this(id, new ButtonOptions());
	}

	public ButtonWebMarkupContainer(String id, IModel<?> model) {
		super(id, model, new ButtonOptions());
	}

	public ButtonWebMarkupContainer(String id, ButtonOptions options) {
		super(id, options);
	}

	public ButtonWebMarkupContainer(String id, IModel<?> model,
			ButtonOptions options) {
		super(id, model, options);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.JQUIWebMarkupContainer#newJQComponentBehavior(com.google.code.jqwicket.ui.JQOptions)
	 */
	@Override
	protected ButtonBehavior newJQComponentBehavior(ButtonOptions options) {
		return new ButtonBehavior(options);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.button.IButton#refresh()
	 */
	public IJQFunction refresh() {
		return this.behavior.refresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.button.IButton#refresh(org.apache.wicket.ajax.AjaxRequestTarget)
	 */
	public void refresh(AjaxRequestTarget ajaxRequestTarget) {
		this.behavior.refresh(ajaxRequestTarget);
	}

}
