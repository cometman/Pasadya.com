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


import com.google.code.jqwicket.IJQUIWidget;
import com.google.code.jqwicket.api.IJQFunction;
import org.apache.wicket.ajax.AjaxRequestTarget;

/**
 * @author mkalina
 * 
 */
public interface IAccordion extends IJQUIWidget<AccordionOptions> {

	static final CharSequence JQ_COMPONENT_NAME = "accordion";

	/**
	 * Activate a content part of the Accordion programmatically. The index can
	 * be a zero-indexed number to match the position of the header to close
	 */
	IJQFunction activate(int index);

	/**
	 * Activate a content part of the Accordion programmatically. The index can
	 * be a zero-indexed number to match the position of the header to close
	 * 
	 * @param ajaxRequestTarget
	 */
	void activate(AjaxRequestTarget ajaxRequestTarget, int index);

	/**
	 * Activate a content part of the Accordion programmatically. The index can
	 * be a Selector matching an element
	 */
	IJQFunction activate(CharSequence selector);

	/**
	 * Activate a content part of the Accordion programmatically. The index can
	 * be a Selector matching an element
	 * 
	 * @param ajaxRequestTarget
	 */
	void activate(AjaxRequestTarget ajaxRequestTarget, CharSequence selector);

	/**
	 * Activate a content part of the Accordion programmatically. T Pass false
	 * to close all (only possible with collapsible:true ).
	 */
	IJQFunction activate(boolean activate);

	/**
	 * Activate a content part of the Accordion programmatically. Pass false to
	 * close all (only possible with collapsible:true ).
	 * 
	 * @param ajaxRequestTarget
	 */
	void activate(AjaxRequestTarget ajaxRequestTarget, boolean activate);

	/**
	 * Get any accordion option.
	 */
	IJQFunction resize();

	/**
	 * Get any accordion option.
	 * 
	 * @param ajaxRequestTarget
	 */
	void resize(AjaxRequestTarget ajaxRequestTarget);
}
