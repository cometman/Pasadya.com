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
package com.google.code.jqwicket.ui.uniform;

import com.google.code.jqwicket.IJQWidget;

import static com.google.code.jqwicket.api.JQuery.$;

/**
 * Generic, jquery selector based uniform behavior. This behavior can be added
 * to any wicket component/page and will render uniform javascripts based on
 * given selector.
 * 
 * @author mkalina
 * 
 */
public class GenericUniformBehavior extends AbstractUniformBehavior implements
		IJQWidget<UniformOptions> {

	private static final long serialVersionUID = 1L;

	public GenericUniformBehavior(CharSequence selector) {
		this(selector, new UniformOptions());
	}

	public GenericUniformBehavior(CharSequence selector, UniformOptions options) {
		super(options);
		this.contributeSelector(selector);
	}

	protected void contributeSelector(CharSequence selector) {
		this.addJQStatements($(selector).chain(this.getName(), this.options));
	}

}
