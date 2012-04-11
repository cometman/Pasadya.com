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
import com.google.code.jqwicket.ui.JQUIWebMarkupContainer;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.model.IModel;

/**
 * @author mkalina
 *
 */
public class SortableWebMarkupContainer extends
		JQUIWebMarkupContainer<SortableBehavior, SortableOptions> implements
		ISortable {

	private static final long serialVersionUID = 1L;

	public SortableWebMarkupContainer(String id) {
		this(id, new SortableOptions());
	}

	public SortableWebMarkupContainer(String id, IModel<?> model) {
		this(id, model, new SortableOptions());
	}

	public SortableWebMarkupContainer(String id, IModel<?> model,
			SortableOptions options) {
		super(id, model, options);
	}

	public SortableWebMarkupContainer(String id, SortableOptions options) {
		super(id, options);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.JQUIWebMarkupContainer#newJQComponentBehavior(com.google.code.jqwicket.api.IJQOptions)
	 */
	@Override
	protected SortableBehavior newJQComponentBehavior(SortableOptions options) {
		return new SortableBehavior(options);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.sortable.ISortable#serialize()
	 */
	public IJQFunction serialize() {
		return this.behavior.serialize();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.sortable.ISortable#serialize(org.apache.wicket.ajax.AjaxRequestTarget)
	 */
	public void serialize(AjaxRequestTarget ajaxRequestTarget) {
		this.behavior.serialize(ajaxRequestTarget);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.sortable.ISortable#serialize(com.google.code.jqwicket.api.IJQOptions)
	 */
	public IJQFunction serialize(IJQOptions<?> options) {
		return this.behavior.serialize(options);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.sortable.ISortable#serialize(org.apache.wicket.ajax.AjaxRequestTarget,
	 *      com.google.code.jqwicket.api.IJQOptions)
	 */
	public void serialize(AjaxRequestTarget ajaxRequestTarget,
			IJQOptions<?> options) {
		this.behavior.serialize(ajaxRequestTarget, options);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.sortable.ISortable#toArray()
	 */
	public IJQFunction toArray() {
		return this.behavior.toArray();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.sortable.ISortable#toArray(org.apache.wicket.ajax.AjaxRequestTarget)
	 */
	public void toArray(AjaxRequestTarget ajaxRequestTarget) {
		this.behavior.toArray(ajaxRequestTarget);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.sortable.ISortable#refresh()
	 */
	public IJQFunction refresh() {
		return this.behavior.refresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.sortable.ISortable#refresh(org.apache.wicket.ajax.AjaxRequestTarget)
	 */
	public void refresh(AjaxRequestTarget ajaxRequestTarget) {
		this.behavior.refresh(ajaxRequestTarget);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.sortable.ISortable#refreshPositions()
	 */
	public IJQFunction refreshPositions() {
		return this.behavior.refreshPositions();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.sortable.ISortable#refreshPositions(org.apache.wicket.ajax.AjaxRequestTarget)
	 */
	public void refreshPositions(AjaxRequestTarget ajaxRequestTarget) {
		this.behavior.refreshPositions(ajaxRequestTarget);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.sortable.ISortable#cancel()
	 */
	public IJQFunction cancel() {
		return this.behavior.cancel();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.sortable.ISortable#cancel(org.apache.wicket.ajax.AjaxRequestTarget)
	 */
	public void cancel(AjaxRequestTarget ajaxRequestTarget) {
		this.behavior.cancel(ajaxRequestTarget);
	}

}
