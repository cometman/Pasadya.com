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
package com.google.code.jqwicket.ui.notifier;


import com.google.code.jqwicket.IJQUIWidget;
import com.google.code.jqwicket.api.IJQFunction;
import com.google.code.jqwicket.api.IJQOptions;
import org.apache.wicket.ajax.AjaxRequestTarget;

/**
 * @author mkalina
 * 
 */
public interface INotifier extends IJQUIWidget<NotifierOptions> {

	static final CharSequence JQ_COMPONENT_NAME = "notify";

	IJQFunction create(CharSequence title, CharSequence text);

	void create(AjaxRequestTarget ajaxRequestTarget, CharSequence title,
			CharSequence text);

	IJQFunction create(IJQOptions<?> msg);

	void create(AjaxRequestTarget ajaxRequestTarget, IJQOptions<?> msg);

	IJQFunction create(CharSequence template, IJQOptions<?> msg);

	void create(AjaxRequestTarget ajaxRequestTarget, CharSequence template,
			IJQOptions<?> msg);

	IJQFunction create(CharSequence template, IJQOptions<?> msg,
			IJQOptions<?> options);

	void create(AjaxRequestTarget ajaxRequestTarget, CharSequence template,
			IJQOptions<?> msg, IJQOptions<?> options);

	IJQFunction open();

	void open(AjaxRequestTarget ajaxRequestTarget);

	IJQFunction close();

	void close(AjaxRequestTarget ajaxRequestTarget);

}
