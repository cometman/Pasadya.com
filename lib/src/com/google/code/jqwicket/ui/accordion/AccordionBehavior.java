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
import com.google.code.jqwicket.ui.JQUIComponentBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;

import static com.google.code.jqwicket.api.JQLiteral._raw;

/**
 * @author mkalina
 * 
 */
public class AccordionBehavior extends JQUIComponentBehavior<AccordionOptions>
		implements IAccordion {

	private static final long serialVersionUID = 1L;

	public AccordionBehavior() {
		this(new AccordionOptions());
	}

	public AccordionBehavior(AccordionOptions options) {
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
	 * @see com.google.code.jqwicket.ui.accordion.IAccordion#activate(int)
	 */
	public IJQFunction activate(int index) {
		return chain("activate", _raw(index));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.accordion.IAccordion#activate(org.apache.wicket.ajax.AjaxRequestTarget,
	 *      int)
	 */
	public void activate(AjaxRequestTarget ajaxRequestTarget, int index) {
		chain(ajaxRequestTarget, this.activate(index));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.accordion.IAccordion#activate(java.lang.CharSequence)
	 */
	public IJQFunction activate(CharSequence selector) {
		return chain("activate", selector);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.accordion.IAccordion#activate(org.apache.wicket.ajax.AjaxRequestTarget,
	 *      java.lang.CharSequence)
	 */
	public void activate(AjaxRequestTarget ajaxRequestTarget,
			CharSequence selector) {
		chain(ajaxRequestTarget, this.activate(selector));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.accordion.IAccordion#activate(boolean)
	 */
	public IJQFunction activate(boolean activate) {
		return chain("activate", _raw(activate));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.accordion.IAccordion#activate(org.apache.wicket.ajax.AjaxRequestTarget,
	 *      boolean)
	 */
	public void activate(AjaxRequestTarget ajaxRequestTarget, boolean activate) {
		chain(ajaxRequestTarget, this.activate(activate));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.accordion.IAccordion#resize()
	 */
	public IJQFunction resize() {
		return chain("resize");
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.accordion.IAccordion#resize(org.apache.wicket.ajax.AjaxRequestTarget)
	 */
	public void resize(AjaxRequestTarget ajaxRequestTarget) {
		chain(ajaxRequestTarget, this.resize());
	}

}
