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
package com.google.code.jqwicket.ui.blockui;


import com.google.code.jqwicket.api.IJQFunction;
import com.google.code.jqwicket.ui.JQWebMarkupContainer;
import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.model.IModel;

/**
 * @author mkalina
 * 
 */
public class BlockUIWebMarkupContainer extends
		JQWebMarkupContainer<BlockUIBehavior, BlockUIOptions> implements
		IBlockUI {

	private static final long serialVersionUID = 1L;

	public BlockUIWebMarkupContainer(String id) {
		this(id, new BlockUIOptions());
	}

	public BlockUIWebMarkupContainer(String id, IModel<?> model) {
		this(id, model, new BlockUIOptions());
	}

	public BlockUIWebMarkupContainer(String id, IModel<?> model,
			BlockUIOptions options) {
		super(id, model, options);
	}

	public BlockUIWebMarkupContainer(String id, BlockUIOptions options) {
		super(id, options);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.JQUIWebMarkupContainer#newJQComponentBehavior(com.google.code.jqwicket.ui.IJQOptions)
	 */
	@Override
	protected BlockUIBehavior newJQComponentBehavior(BlockUIOptions options) {
		return new BlockUIBehavior(options);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.blockui.IBlockUI#block()
	 */
	public IJQFunction block() {
		return this.behavior.block();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.blockui.IBlockUI#block(org.apache.wicket.ajax.AjaxRequestTarget)
	 */
	public void block(AjaxRequestTarget ajaxRequestTarget) {
		this.behavior.block(ajaxRequestTarget);

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.blockui.IBlockUI#block(com.google.code.jqwicket.ui.blockui.BlockUIOptions)
	 */
	public IJQFunction block(BlockUIOptions options) {
		return this.behavior.block(options);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.blockui.IBlockUI#block(com.google.code.jqwicket.ui.blockui.BlockUIOptions,
	 *      org.apache.wicket.ajax.AjaxRequestTarget)
	 */
	public void block(BlockUIOptions options,
			AjaxRequestTarget ajaxRequestTarget) {
		this.behavior.block(options, ajaxRequestTarget);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.blockui.IBlockUI#block(java.lang.CharSequence)
	 */
	public IJQFunction block(CharSequence selector) {
		return this.behavior.block(selector);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.blockui.IBlockUI#block(java.lang.CharSequence,
	 *      org.apache.wicket.ajax.AjaxRequestTarget)
	 */
	public void block(CharSequence selector, AjaxRequestTarget ajaxRequestTarget) {
		this.behavior.block(selector, ajaxRequestTarget);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.blockui.IBlockUI#block(java.lang.CharSequence,
	 *      com.google.code.jqwicket.ui.blockui.BlockUIOptions)
	 */
	public IJQFunction block(CharSequence selector, BlockUIOptions options) {
		return this.behavior.block(selector, options);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.blockui.IBlockUI#block(java.lang.CharSequence,
	 *      com.google.code.jqwicket.ui.blockui.BlockUIOptions,
	 *      org.apache.wicket.ajax.AjaxRequestTarget)
	 */
	public void block(CharSequence selector, BlockUIOptions options,
			AjaxRequestTarget ajaxRequestTarget) {
		this.behavior.block(selector, options, ajaxRequestTarget);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.blockui.IBlockUI#block(org.apache.wicket.Component)
	 */
	public IJQFunction block(Component component) {
		return this.behavior.block(component);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.blockui.IBlockUI#block(org.apache.wicket.Component,
	 *      org.apache.wicket.ajax.AjaxRequestTarget)
	 */
	public void block(Component component, AjaxRequestTarget ajaxRequestTarget) {
		this.behavior.block(component, ajaxRequestTarget);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.blockui.IBlockUI#block(org.apache.wicket.Component,
	 *      com.google.code.jqwicket.ui.blockui.BlockUIOptions)
	 */
	public IJQFunction block(Component component, BlockUIOptions options) {
		return this.behavior.block(component, options);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.blockui.IBlockUI#block(org.apache.wicket.Component,
	 *      com.google.code.jqwicket.ui.blockui.BlockUIOptions,
	 *      org.apache.wicket.ajax.AjaxRequestTarget)
	 */
	public void block(Component component, BlockUIOptions options,
			AjaxRequestTarget ajaxRequestTarget) {
		this.behavior.block(component, options, ajaxRequestTarget);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.blockui.IBlockUI#unblock()
	 */
	public IJQFunction unblock() {
		return this.behavior.unblock();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.blockui.IBlockUI#unblock(org.apache.wicket.ajax.AjaxRequestTarget)
	 */
	public void unblock(AjaxRequestTarget ajaxRequestTarget) {
		this.behavior.unblock(ajaxRequestTarget);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.blockui.IBlockUI#unblock(com.google.code.jqwicket.ui.blockui.BlockUIOptions)
	 */
	public IJQFunction unblock(BlockUIOptions options) {
		return this.behavior.unblock(options);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.blockui.IBlockUI#unblock(com.google.code.jqwicket.ui.blockui.BlockUIOptions,
	 *      org.apache.wicket.ajax.AjaxRequestTarget)
	 */
	public void unblock(BlockUIOptions options,
			AjaxRequestTarget ajaxRequestTarget) {
		this.behavior.unblock(options, ajaxRequestTarget);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.blockui.IBlockUI#unblock(java.lang.CharSequence)
	 */
	public IJQFunction unblock(CharSequence selector) {
		return this.behavior.unblock(selector);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.blockui.IBlockUI#unblock(java.lang.CharSequence,
	 *      org.apache.wicket.ajax.AjaxRequestTarget)
	 */
	public void unblock(CharSequence selector,
			AjaxRequestTarget ajaxRequestTarget) {
		this.behavior.unblock(selector, ajaxRequestTarget);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.blockui.IBlockUI#unblock(java.lang.CharSequence,
	 *      com.google.code.jqwicket.ui.blockui.BlockUIOptions)
	 */
	public IJQFunction unblock(CharSequence selector, BlockUIOptions options) {
		return this.behavior.unblock(selector, options);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.blockui.IBlockUI#unblock(java.lang.CharSequence,
	 *      com.google.code.jqwicket.ui.blockui.BlockUIOptions,
	 *      org.apache.wicket.ajax.AjaxRequestTarget)
	 */
	public void unblock(CharSequence selector, BlockUIOptions options,
			AjaxRequestTarget ajaxRequestTarget) {
		this.behavior.unblock(selector, options, ajaxRequestTarget);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.blockui.IBlockUI#unblock(org.apache.wicket.Component)
	 */
	public IJQFunction unblock(Component component) {
		return this.behavior.unblock(component);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.blockui.IBlockUI#unblock(org.apache.wicket.Component,
	 *      org.apache.wicket.ajax.AjaxRequestTarget)
	 */
	public void unblock(Component component, AjaxRequestTarget ajaxRequestTarget) {
		this.behavior.unblock(component, ajaxRequestTarget);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.blockui.IBlockUI#unblock(org.apache.wicket.Component,
	 *      com.google.code.jqwicket.ui.blockui.BlockUIOptions)
	 */
	public IJQFunction unblock(Component component, BlockUIOptions options) {
		return this.behavior.unblock(component, options);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.blockui.IBlockUI#unblock(org.apache.wicket.Component,
	 *      com.google.code.jqwicket.ui.blockui.BlockUIOptions,
	 *      org.apache.wicket.ajax.AjaxRequestTarget)
	 */
	public void unblock(Component component, BlockUIOptions options,
			AjaxRequestTarget ajaxRequestTarget) {
		this.behavior.unblock(component, options, ajaxRequestTarget);
	}

}
