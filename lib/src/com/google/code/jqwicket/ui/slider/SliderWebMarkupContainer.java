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
package com.google.code.jqwicket.ui.slider;


import com.google.code.jqwicket.api.IJQFunction;
import com.google.code.jqwicket.ui.JQUIWebMarkupContainer;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.model.IModel;

/**
 * @author mkalina
 *
 */
public class SliderWebMarkupContainer extends
		JQUIWebMarkupContainer<SliderBehavior, SliderOptions> implements ISlider {

	private static final long serialVersionUID = 1L;

	public SliderWebMarkupContainer(String id) {
		this(id, new SliderOptions());
	}

	public SliderWebMarkupContainer(String id, IModel<?> model) {
		this(id, model, new SliderOptions());
	}

	public SliderWebMarkupContainer(String id, IModel<?> model,
			SliderOptions options) {
		super(id, model, options);
	}

	public SliderWebMarkupContainer(String id, SliderOptions options) {
		super(id, options);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.JQUIWebMarkupContainer#newJQComponentBehavior(com.google.code.jqwicket.ui.JQOptions)
	 */
	@Override
	protected SliderBehavior newJQComponentBehavior(SliderOptions options) {
		return new SliderBehavior(options);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.slider.ISlider#value(int)
	 */
	public IJQFunction value(int value) {
		return this.behavior.value(value);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.slider.ISlider#value(int,
	 *      org.apache.wicket.ajax.AjaxRequestTarget)
	 */
	public void value(int value, AjaxRequestTarget ajaxRequestTarget) {
		this.behavior.value(value, ajaxRequestTarget);
	}

}
