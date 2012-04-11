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
package com.google.code.jqwicket.ui.sortable;


import com.google.code.jqwicket.api.IJQFunction;
import com.google.code.jqwicket.api.IJQOptions;
import com.google.code.jqwicket.ui.JQUIComponentBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;

/**
 * @author mkalina
 * 
 */
public class SortableBehavior extends JQUIComponentBehavior<SortableOptions>
		implements ISortable {

	private static final long serialVersionUID = 1L;

	public SortableBehavior() {
		this(new SortableOptions());
	}

	public SortableBehavior(SortableOptions options) {
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
	 * @see com.google.code.jqwicket.ui.sortable.ISortable#serialize()
	 */
	public IJQFunction serialize() {
		return chain("serialize");
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.sortable.ISortable#serialize(org.apache.wicket.ajax.AjaxRequestTarget)
	 */
	public void serialize(AjaxRequestTarget ajaxRequestTarget) {
		chain(ajaxRequestTarget, this.serialize());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.sortable.ISortable#serialize(com.google.code.jqwicket.api.IJQOptions)
	 */
	public IJQFunction serialize(IJQOptions<?> options) {
		return chain("serialize");
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.sortable.ISortable#serialize(org.apache.wicket.ajax.AjaxRequestTarget,
	 *      com.google.code.jqwicket.api.IJQOptions)
	 */
	public void serialize(AjaxRequestTarget ajaxRequestTarget,
			IJQOptions<?> options) {
		chain(ajaxRequestTarget, this.serialize(options));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.sortable.ISortable#toArray()
	 */
	public IJQFunction toArray() {
		return chain("toArray");
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.sortable.ISortable#toArray(org.apache.wicket.ajax.AjaxRequestTarget)
	 */
	public void toArray(AjaxRequestTarget ajaxRequestTarget) {
		chain(ajaxRequestTarget, this.toArray());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.sortable.ISortable#refresh()
	 */
	public IJQFunction refresh() {
		return chain("refresh");
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.sortable.ISortable#refresh(org.apache.wicket.ajax.AjaxRequestTarget)
	 */
	public void refresh(AjaxRequestTarget ajaxRequestTarget) {
		chain(ajaxRequestTarget, this.refresh());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.sortable.ISortable#refreshPositions()
	 */
	public IJQFunction refreshPositions() {
		return chain("refreshPositions");
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.sortable.ISortable#refreshPositions(org.apache.wicket.ajax.AjaxRequestTarget)
	 */
	public void refreshPositions(AjaxRequestTarget ajaxRequestTarget) {
		chain(ajaxRequestTarget, this.refreshPositions());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.sortable.ISortable#cancel()
	 */
	public IJQFunction cancel() {
		return chain("cancel");
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.sortable.ISortable#cancel(org.apache.wicket.ajax.AjaxRequestTarget)
	 */
	public void cancel(AjaxRequestTarget ajaxRequestTarget) {
		chain(ajaxRequestTarget, this.cancel());
	}

}
