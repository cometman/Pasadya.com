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
package com.google.code.jqwicket.event;

import com.google.code.jqwicket.IJQHeaderContributor;
import com.google.code.jqwicket.JQBehavior;
import com.google.code.jqwicket.JQHeaderContributionTarget;
import com.google.code.jqwicket.api.IJQFunction;
import com.google.code.jqwicket.api.IJQStatement;

import static com.google.code.jqwicket.Utils.isNotEmpty;
import static com.google.code.jqwicket.api.JQuery.$;

/**
 * Abstract behavior for adding jquery event handling to the wicket components.
 * Subclasses should implement {@link #callback()} method by returning
 * javascript callback function executed on event.
 * 
 * @author mkalina
 * 
 */
public abstract class JQEventBehavior extends JQBehavior implements
		IJQHeaderContributor {

	private static final long serialVersionUID = 1L;

	private IJQEvent[] events;

	public JQEventBehavior(IJQEvent... events) {
		this.events = events;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.JQBehavior#contributeInternal(com.google.code.jqwicket.JQHeaderContributionTarget)
	 */
	@Override
	public void contributeInternal(JQHeaderContributionTarget target) {
		IJQFunction callback = this.callback();
		if (isNotEmpty(this.events) && callback != null) {
			IJQStatement stmt = $(this.component);
			for (IJQEvent e : this.events) {
				stmt.chain(e.getName(), callback);
			}
			target.addJQStatements(stmt);
		}
	}

	/**
	 * Returns javascript callback function executed on event.
	 * 
	 * @return javascript callback function
	 */
	public abstract IJQFunction callback();
}
