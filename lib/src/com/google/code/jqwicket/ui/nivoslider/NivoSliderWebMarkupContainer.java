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
package com.google.code.jqwicket.ui.nivoslider;


import com.google.code.jqwicket.ui.JQWebMarkupContainer;
import org.apache.wicket.model.IModel;

/**
 * @author mkalina
 * 
 */
public class NivoSliderWebMarkupContainer extends
		JQWebMarkupContainer<NivoSliderBehavior, NivoSliderOptions> implements
		INivoSlider {

	private static final long serialVersionUID = 1L;

	public NivoSliderWebMarkupContainer(String id) {
		this(id, new NivoSliderOptions());
	}

	public NivoSliderWebMarkupContainer(String id, IModel<?> model) {
		this(id, model, new NivoSliderOptions());
	}

	public NivoSliderWebMarkupContainer(String id, IModel<?> model,
			NivoSliderOptions options) {
		super(id, model, options);
	}

	public NivoSliderWebMarkupContainer(String id, NivoSliderOptions options) {
		super(id, options);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.JQUIWebMarkupContainer#newJQComponentBehavior(com.google.code.jqwicket.ui.IJQOptions)
	 */
	@Override
	protected NivoSliderBehavior newJQComponentBehavior(
			NivoSliderOptions options) {
		return new NivoSliderBehavior(options);
	}

}
