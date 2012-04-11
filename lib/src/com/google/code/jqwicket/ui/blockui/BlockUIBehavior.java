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

import com.google.code.jqwicket.JQHeaderContributionTarget;
import com.google.code.jqwicket.api.IJQFunction;
import com.google.code.jqwicket.api.S;
import com.google.code.jqwicket.ui.JQComponentBehavior;
import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;

import static com.google.code.jqwicket.api.JQuery.$;
import static com.google.code.jqwicket.api.JQuery.$f;

/**
 * @author mkalina
 * 
 */
public class BlockUIBehavior extends JQComponentBehavior<BlockUIOptions>
		implements IBlockUI {

	private static final long serialVersionUID = 1L;

	public BlockUIBehavior() {
		this(new BlockUIOptions());
	}

	public BlockUIBehavior(BlockUIOptions options) {
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
	 * @see com.google.code.jqwicket.ui.JQComponentBehavior#contributeInternal(com.google.code.jqwicket.JQHeaderContributionTarget)
	 */
	@Override
	protected void contributeInternal(JQHeaderContributionTarget target) {
		; // do nothing
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.blockui.IBlockUI#block()
	 */
	public IJQFunction block() {
		return this.block(this.options);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.blockui.IBlockUI#block(org.apache.wicket.ajax.AjaxRequestTarget)
	 */
	public void block(AjaxRequestTarget ajaxRequestTarget) {
		this.block(this.options, ajaxRequestTarget);

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.blockui.IBlockUI#block(com.google.code.jqwicket.ui.blockui.BlockUIOptions)
	 */
	public IJQFunction block(BlockUIOptions options) {
		return $f($().chain("blockUI", options != null ? options : ""));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.blockui.IBlockUI#block(com.google.code.jqwicket.ui.blockui.BlockUIOptions,
	 *      org.apache.wicket.ajax.AjaxRequestTarget)
	 */
	public void block(BlockUIOptions options,
			AjaxRequestTarget ajaxRequestTarget) {
		this.chain(ajaxRequestTarget, this.block(options));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.blockui.IBlockUI#block(org.apache.wicket.Component)
	 */
	public IJQFunction block(Component component) {
		return this.block(S.id(component));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.blockui.IBlockUI#block(org.apache.wicket.Component,
	 *      org.apache.wicket.ajax.AjaxRequestTarget)
	 */
	public void block(Component component, AjaxRequestTarget ajaxRequestTarget) {
		this.block(S.id(component), ajaxRequestTarget);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.blockui.IBlockUI#block(org.apache.wicket.Component,
	 *      com.google.code.jqwicket.ui.blockui.BlockUIOptions)
	 */
	public IJQFunction block(Component component, BlockUIOptions options) {
		return this.block(S.id(component), options);
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
		this.block(S.id(component), options, ajaxRequestTarget);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.blockui.IBlockUI#block(java.lang.CharSequence)
	 */
	public IJQFunction block(CharSequence selector) {
		return this.block(selector, this.options);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.blockui.IBlockUI#block(java.lang.CharSequence,
	 *      org.apache.wicket.ajax.AjaxRequestTarget)
	 */
	public void block(CharSequence selector, AjaxRequestTarget ajaxRequestTarget) {
		this.block(selector, this.options, ajaxRequestTarget);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.blockui.IBlockUI#block(java.lang.CharSequence,
	 *      com.google.code.jqwicket.ui.blockui.BlockUIOptions)
	 */
	public IJQFunction block(CharSequence selector, BlockUIOptions options) {
		return $f($(selector).chain("block", options != null ? options : ""));
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
		this.chain(ajaxRequestTarget, this.block(selector, options));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.blockui.IBlockUI#unblock()
	 */
	public IJQFunction unblock() {
		return this.unblock(this.options);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.blockui.IBlockUI#unblock(org.apache.wicket.ajax.AjaxRequestTarget)
	 */
	public void unblock(AjaxRequestTarget ajaxRequestTarget) {
		this.unblock(this.options, ajaxRequestTarget);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.blockui.IBlockUI#unblock(com.google.code.jqwicket.ui.blockui.BlockUIOptions)
	 */
	public IJQFunction unblock(BlockUIOptions options) {
		return $f($().chain("unblockUI", options != null ? options : ""));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.blockui.IBlockUI#unblock(com.google.code.jqwicket.ui.blockui.BlockUIOptions,
	 *      org.apache.wicket.ajax.AjaxRequestTarget)
	 */
	public void unblock(BlockUIOptions options,
			AjaxRequestTarget ajaxRequestTarget) {
		this.chain(ajaxRequestTarget, this.unblock(options));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.blockui.IBlockUI#unblock(java.lang.CharSequence)
	 */
	public IJQFunction unblock(CharSequence selector) {
		return unblock(selector, this.options);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.blockui.IBlockUI#unblock(java.lang.CharSequence,
	 *      org.apache.wicket.ajax.AjaxRequestTarget)
	 */
	public void unblock(CharSequence selector,
			AjaxRequestTarget ajaxRequestTarget) {
		this.chain(ajaxRequestTarget, this.unblock(selector));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.blockui.IBlockUI#unblock(java.lang.CharSequence,
	 *      com.google.code.jqwicket.ui.blockui.BlockUIOptions)
	 */
	public IJQFunction unblock(CharSequence selector, BlockUIOptions options) {
		return $f($(selector).chain("unblock", options != null ? options : ""));
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
		this.chain(ajaxRequestTarget, this.unblock(selector, options));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.blockui.IBlockUI#unblock(org.apache.wicket.Component)
	 */
	public IJQFunction unblock(Component component) {
		return this.unblock(S.id(component));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.blockui.IBlockUI#unblock(org.apache.wicket.Component,
	 *      org.apache.wicket.ajax.AjaxRequestTarget)
	 */
	public void unblock(Component component, AjaxRequestTarget ajaxRequestTarget) {
		this.chain(ajaxRequestTarget, this.unblock(component));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.blockui.IBlockUI#unblock(org.apache.wicket.Component,
	 *      com.google.code.jqwicket.ui.blockui.BlockUIOptions)
	 */
	public IJQFunction unblock(Component component, BlockUIOptions options) {
		return this.unblock(S.id(component), options);
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
		this.chain(ajaxRequestTarget, this.unblock(component, options));
	}

}
