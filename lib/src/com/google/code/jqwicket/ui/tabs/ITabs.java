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
package com.google.code.jqwicket.ui.tabs;


import com.google.code.jqwicket.IJQUIWidget;
import com.google.code.jqwicket.api.IJQFunction;
import org.apache.wicket.ajax.AjaxRequestTarget;

/**
 * @author mkalina
 * 
 */
public interface ITabs extends IJQUIWidget<TabsOptions> {

	static final CharSequence JQ_COMPONENT_NAME = "tabs";

	/**
	 * Add a new tab. The second argument is either a URL consisting of a
	 * fragment identifier only to create an in-page tab or a full url (relative
	 * or absolute, no cross-domain support) to turn the new tab into an Ajax
	 * (remote) tab. The third is the zero-based position where to insert the
	 * new tab. Optional, by default a new tab is appended at the end.
	 */
	IJQFunction add(CharSequence url, CharSequence label);

	/**
	 * Add a new tab. The second argument is either a URL consisting of a
	 * fragment identifier only to create an in-page tab or a full url (relative
	 * or absolute, no cross-domain support) to turn the new tab into an Ajax
	 * (remote) tab. The third is the zero-based position where to insert the
	 * new tab. Optional, by default a new tab is appended at the end.
	 */
	IJQFunction add(CharSequence url, CharSequence label, Integer index);

	/**
	 * Add a new tab. The second argument is either a URL consisting of a
	 * fragment identifier only to create an in-page tab or a full url (relative
	 * or absolute, no cross-domain support) to turn the new tab into an Ajax
	 * (remote) tab. The third is the zero-based position where to insert the
	 * new tab. Optional, by default a new tab is appended at the end.
	 * 
	 * @param ajaxRequestTarget
	 */
	void add(AjaxRequestTarget ajaxRequestTarget, CharSequence url,
			CharSequence label, Integer index);

	/**
	 * Add a new tab. The second argument is either a URL consisting of a
	 * fragment identifier only to create an in-page tab or a full url (relative
	 * or absolute, no cross-domain support) to turn the new tab into an Ajax
	 * (remote) tab. The third is the zero-based position where to insert the
	 * new tab. Optional, by default a new tab is appended at the end.
	 * 
	 * @param ajaxRequestTarget
	 */
	void add(AjaxRequestTarget ajaxRequestTarget, CharSequence url,
			CharSequence label);

	/**
	 * Remove a tab. The second argument is the zero-based index of the tab to
	 * be removed.
	 */
	IJQFunction remove(int index);

	/**
	 * Remove a tab. The index argument is the zero-based index of the tab to be
	 * removed.
	 * 
	 * @param ajaxRequestTarget
	 */
	void remove(AjaxRequestTarget ajaxRequestTarget, int index);

	/**
	 * Enable a disabled tab.
	 */
	IJQFunction enable(int index);

	/**
	 * Enable a disabled tab.
	 * 
	 * @param ajaxRequestTarget
	 */
	void enable(AjaxRequestTarget ajaxRequestTarget, int index);

	/**
	 * Disable a tab.
	 */
	IJQFunction disable(int index);

	/**
	 * Disable a tab.
	 * 
	 * @param ajaxRequestTarget
	 */
	void disable(AjaxRequestTarget ajaxRequestTarget, int index);

	/**
	 * Select a tab, as if it were clicked.
	 */
	IJQFunction select(int index);

	/**
	 * Select a tab, as if it were clicked.
	 * 
	 * @param ajaxRequestTarget
	 */
	void select(AjaxRequestTarget ajaxRequestTarget, int index);

	/**
	 * Reload the content of an Ajax tab programmatically. This method always
	 * loads the tab content from the remote location, even if cache is set to
	 * true.
	 */
	IJQFunction load(int index);

	/**
	 * Reload the content of an Ajax tab programmatically. This method always
	 * loads the tab content from the remote location, even if cache is set to
	 * true.
	 * 
	 * @param ajaxRequestTarget
	 */
	void load(AjaxRequestTarget ajaxRequestTarget, int index);

	/**
	 * Change the url from which an Ajax (remote) tab will be loaded. The
	 * specified URL will be used for subsequent loads. Note that you can not
	 * only change the URL for an existing remote tab with this method, but also
	 * turn an in-page tab into a remote tab.
	 */
	IJQFunction url(int index, CharSequence url);

	/**
	 * Change the url from which an Ajax (remote) tab will be loaded. The
	 * specified URL will be used for subsequent loads. Note that you can not
	 * only change the URL for an existing remote tab with this method, but also
	 * turn an in-page tab into a remote tab.
	 * 
	 * @param ajaxRequestTarget
	 */
	void url(AjaxRequestTarget ajaxRequestTarget, int index, CharSequence url);

	/**
	 * Retrieve the number of tabs of the first matched tab pane.
	 */
	IJQFunction length();

	/**
	 * Retrieve the number of tabs of the first matched tab pane.
	 * 
	 * @param ajaxRequestTarget
	 */
	void length(AjaxRequestTarget ajaxRequestTarget);

	/**
	 * Terminate all running tab ajax requests and animations.
	 */
	IJQFunction abort();

	/**
	 * Terminate all running tab ajax requests and animations.
	 * 
	 * @param ajaxRequestTarget
	 */
	void abort(AjaxRequestTarget ajaxRequestTarget);

	/**
	 * Set up an automatic rotation through tabs of a tab pane. The first
	 * argument is an amount of time in milliseconds until the next tab in the
	 * cycle gets activated. Use 0 or null to stop the rotation. The second
	 * controls whether or not to continue the rotation after a tab has been
	 * selected by a user.
	 */
	IJQFunction rotate(int ms, boolean continuing);

	/**
	 * Set up an automatic rotation through tabs of a tab pane. The second
	 * argument is an amount of time in milliseconds until the next tab in the
	 * cycle gets activated. Use 0 or null to stop the rotation. The third
	 * controls whether or not to continue the rotation after a tab has been
	 * selected by a user.
	 * 
	 * @param ajaxRequestTarget
	 */
	void rotate(AjaxRequestTarget ajaxRequestTarget, int ms, boolean continuing);

}
