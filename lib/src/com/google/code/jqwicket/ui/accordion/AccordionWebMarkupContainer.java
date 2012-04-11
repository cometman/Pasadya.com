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
package com.google.code.jqwicket.ui.accordion;


import com.google.code.jqwicket.api.IJQFunction;
import com.google.code.jqwicket.ui.JQUIWebMarkupContainer;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.model.IModel;

/**
 * @author mkalina
 * 
 */
public class AccordionWebMarkupContainer extends
		JQUIWebMarkupContainer<AccordionBehavior, AccordionOptions> implements
		IAccordion {

	private static final long serialVersionUID = 1L;

	public AccordionWebMarkupContainer(String id) {
		this(id, new AccordionOptions());
	}

	public AccordionWebMarkupContainer(String id, IModel<?> model) {
		this(id, model, new AccordionOptions());
	}

	public AccordionWebMarkupContainer(String id, AccordionOptions options) {
		super(id, options);
	}

	public AccordionWebMarkupContainer(String id, IModel<?> model,
			AccordionOptions options) {
		super(id, model, options);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.JQUIWebMarkupContainer#newJQComponentBehavior(com.google.code.jqwicket.ui.JQOptions)
	 */
	@Override
	protected AccordionBehavior newJQComponentBehavior(AccordionOptions options) {
		return new AccordionBehavior(options);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.accordion.IAccordion#activate(int)
	 */
	public IJQFunction activate(int index) {
		return this.behavior.activate(index);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.accordion.IAccordion#activate(org.apache.wicket.ajax.AjaxRequestTarget,
	 *      int)
	 */
	public void activate(AjaxRequestTarget ajaxRequestTarget, int index) {
		this.behavior.activate(ajaxRequestTarget, index);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.accordion.IAccordion#activate(java.lang.CharSequence)
	 */
	public IJQFunction activate(CharSequence selector) {
		return this.behavior.activate(selector);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.accordion.IAccordion#activate(org.apache.wicket.ajax.AjaxRequestTarget,
	 *      java.lang.CharSequence)
	 */
	public void activate(AjaxRequestTarget ajaxRequestTarget,
			CharSequence selector) {
		this.behavior.activate(ajaxRequestTarget, selector);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.accordion.IAccordion#activate(boolean)
	 */
	public IJQFunction activate(boolean activate) {
		return this.behavior.activate(activate);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.accordion.IAccordion#activate(org.apache.wicket.ajax.AjaxRequestTarget,
	 *      boolean)
	 */
	public void activate(AjaxRequestTarget ajaxRequestTarget, boolean activate) {
		this.behavior.activate(ajaxRequestTarget, activate);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.accordion.IAccordion#resize()
	 */
	public IJQFunction resize() {
		return this.behavior.resize();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.accordion.IAccordion#resize(org.apache.wicket.ajax.AjaxRequestTarget)
	 */
	public void resize(AjaxRequestTarget ajaxRequestTarget) {
		this.behavior.resize(ajaxRequestTarget);
	}

}
