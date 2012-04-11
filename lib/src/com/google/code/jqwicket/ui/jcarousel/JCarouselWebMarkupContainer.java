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
package com.google.code.jqwicket.ui.jcarousel;


import com.google.code.jqwicket.ui.JQWebMarkupContainer;
import org.apache.wicket.model.IModel;

/**
 * @author mkalina
 * 
 */
public class JCarouselWebMarkupContainer extends
		JQWebMarkupContainer<JCarouselBehavior, JCarouselOptions> implements
		IJCarousel {

	private static final long serialVersionUID = 1L;

	public JCarouselWebMarkupContainer(String id) {
		this(id, new JCarouselOptions());
	}

	public JCarouselWebMarkupContainer(String id, IModel<?> model) {
		this(id, model, new JCarouselOptions());
	}

	public JCarouselWebMarkupContainer(String id, IModel<?> model,
			JCarouselOptions options) {
		super(id, model, options);
	}

	public JCarouselWebMarkupContainer(String id, JCarouselOptions options) {
		super(id, options);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.JQUIWebMarkupContainer#newJQComponentBehavior(com.google.code.jqwicket.ui.IJQOptions)
	 */
	@Override
	protected JCarouselBehavior newJQComponentBehavior(JCarouselOptions options) {
		return new JCarouselBehavior(options);
	}

}
