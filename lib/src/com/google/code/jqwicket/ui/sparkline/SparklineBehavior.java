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
package com.google.code.jqwicket.ui.sparkline;

import com.google.code.jqwicket.JQHeaderContributionTarget;
import com.google.code.jqwicket.Utils;
import com.google.code.jqwicket.api.JQLiteral;
import com.google.code.jqwicket.ui.JQComponentBehavior;

import static com.google.code.jqwicket.api.JQuery.$;

/**
 * @author mkalina
 * 
 */
public class SparklineBehavior extends JQComponentBehavior<SparklineOptions>
		implements ISparkline {

	private static final long serialVersionUID = 1L;

	public SparklineBehavior() {
		this(new SparklineOptions());
	}

	public SparklineBehavior(SparklineOptions options) {
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
		target.addJQStatements($(this.component).chain(
				this.getName(),
				this.options.hasValues() ? JQLiteral._raw(Utils
						.toJson(this.options.getValues())) : "html",
				this.options));
	}
}
