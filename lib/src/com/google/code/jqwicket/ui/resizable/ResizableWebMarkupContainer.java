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
package com.google.code.jqwicket.ui.resizable;


import com.google.code.jqwicket.ui.JQUIWebMarkupContainer;
import org.apache.wicket.model.IModel;

/**
 * @author mkalina
 *
 */
public class ResizableWebMarkupContainer extends
		JQUIWebMarkupContainer<ResizableBehavior, ResizableOptions> implements
		IResizable {

	private static final long serialVersionUID = 1L;

	public ResizableWebMarkupContainer(String id) {
		this(id, new ResizableOptions());
	}

	public ResizableWebMarkupContainer(String id, IModel<?> model) {
		this(id, model, new ResizableOptions());
	}

	public ResizableWebMarkupContainer(String id, IModel<?> model,
			ResizableOptions options) {
		super(id, model, options);
	}

	public ResizableWebMarkupContainer(String id, ResizableOptions options) {
		super(id, options);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.JQUIWebMarkupContainer#newJQComponentBehavior(com.google.code.jqwicket.ui.JQOptions)
	 */
	@Override
	protected ResizableBehavior newJQComponentBehavior(ResizableOptions options) {
		return new ResizableBehavior(options);
	}

}
