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
package com.google.code.jqwicket.ui.prettyloader;

import com.google.code.jqwicket.IJQWidget;
import com.google.code.jqwicket.api.IJQFunction;
import org.apache.wicket.ajax.AjaxRequestTarget;


/**
 * Implementation of the <a
 * href="http://www.no-margin-for-errors.com/projects/prettyloader/"
 * >PrettyLoader JQuery plugin</a>
 * 
 * @author mkalina
 * 
 */
public interface IPrettyLoader extends IJQWidget<PrettyLoaderOptions> {

	static final CharSequence JQ_COMPONENT_NAME = "prettyLoader";

	/**
	 * Displays the loader.
	 * 
	 * @return
	 */
	IJQFunction show();

	/**
	 * Displays the loader.
	 * 
	 * @param ajaxRequestTarget
	 */
	void show(AjaxRequestTarget ajaxRequestTarget);

	/**
	 * Displays the loader and will hide it after given number of milliseconds.
	 * 
	 * @param milliseconds
	 * @return
	 */
	IJQFunction show(int milliseconds);

	/**
	 * Displays the loader and will hide it after given number of milliseconds.
	 * 
	 * @param ajaxRequestTarget
	 * @param milliseconds
	 */
	void show(AjaxRequestTarget ajaxRequestTarget, int milliseconds);

	/**
	 * Will hide prettyLoader
	 * 
	 * @return
	 */
	IJQFunction hide();

	/**
	 * Will hide prettyLoader
	 * 
	 * @param ajaxRequestTarget
	 */
	void hide(AjaxRequestTarget ajaxRequestTarget);
}
