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
package com.google.code.jqwicket.ui.sortable;


import com.google.code.jqwicket.IJQUIWidget;
import com.google.code.jqwicket.api.IJQFunction;
import com.google.code.jqwicket.api.IJQOptions;
import org.apache.wicket.ajax.AjaxRequestTarget;

/**
 * @author mkalina
 * 
 */
public interface ISortable extends IJQUIWidget<SortableOptions> {

	static final CharSequence JQ_COMPONENT_NAME = "sortable";

	/**
	 * Serializes the sortable's item id's into a form/ajax submittable string.
	 * Calling this method produces a hash that can be appended to any url to
	 * easily submit a new item order back to the server.
	 */
	IJQFunction serialize();

	/**
	 * Serializes the sortable's item id's into a form/ajax submittable string.
	 * Calling this method produces a hash that can be appended to any url to
	 * easily submit a new item order back to the server.
	 * 
	 * @param ajaxRequestTarget
	 */
	void serialize(AjaxRequestTarget ajaxRequestTarget);

	/**
	 * Serializes the sortable's item id's into a form/ajax submittable string.
	 * Calling this method produces a hash that can be appended to any url to
	 * easily submit a new item order back to the server.
	 */
	IJQFunction serialize(IJQOptions<?> options);

	/**
	 * Serializes the sortable's item id's into a form/ajax submittable string.
	 * Calling this method produces a hash that can be appended to any url to
	 * easily submit a new item order back to the server.
	 * 
	 * @param ajaxRequestTarget
	 */
	void serialize(AjaxRequestTarget ajaxRequestTarget, IJQOptions<?> options);

	/**
	 * Serializes the sortable's item id's into an array of string. If you have<br>
	 * 
	 * <pre>
	 * &lt;ul id="a_sortable"&gt;&lt;br&gt;
	 * &lt;li id="hello"&gt;Hello&lt;/li&gt;&lt;br&gt;
	 * &lt;li id="goodbye"&gt;Good bye&lt;/li&gt;&lt;br&gt;
	 * &lt;/ul&gt;
	 * </pre>
	 * 
	 * and do <br>
	 * 
	 * <pre>
	 * var result = $('#a_sortable').sortable('toArray');
	 * </pre>
	 * 
	 * then <br>
	 * result[0] will contain "hello" and result[1] will contain "goodbye".
	 */
	IJQFunction toArray();

	/**
	 * Serializes the sortable's item id's into an array of string. If you have<br>
	 * 
	 * <pre>
	 * &lt;ul id="a_sortable"&gt;&lt;br&gt;
	 * &lt;li id="hello"&gt;Hello&lt;/li&gt;&lt;br&gt;
	 * &lt;li id="goodbye"&gt;Good bye&lt;/li&gt;&lt;br&gt;
	 * &lt;/ul&gt;
	 * </pre>
	 * 
	 * and do <br>
	 * 
	 * <pre>
	 * var result = $('#a_sortable').sortable('toArray');
	 * </pre>
	 * 
	 * then <br>
	 * result[0] will contain "hello" and result[1] will contain "goodbye".
	 * 
	 * @param ajaxRequestTarget
	 */
	void toArray(AjaxRequestTarget ajaxRequestTarget);

	/**
	 * Refresh the sortable items. Custom trigger the reloading of all sortable
	 * items, causing new items to be recognized.
	 */
	IJQFunction refresh();

	/**
	 * Refresh the sortable items. Custom trigger the reloading of all sortable
	 * items, causing new items to be recognized.
	 * 
	 * @param ajaxRequestTarget
	 */
	void refresh(AjaxRequestTarget ajaxRequestTarget);

	/**
	 * Refresh the cached positions of the sortables' items. Calling this method
	 * refreshes the cached item positions of all sortables. This is usually
	 * done automatically by the script and slows down performance. Use wisely.
	 */
	IJQFunction refreshPositions();

	/**
	 * Refresh the cached positions of the sortables' items. Calling this method
	 * refreshes the cached item positions of all sortables. This is usually
	 * done automatically by the script and slows down performance. Use wisely.
	 * 
	 * @param ajaxRequestTarget
	 */
	void refreshPositions(AjaxRequestTarget ajaxRequestTarget);

	/**
	 * Cancels a change in the current sortable and reverts it back to how it
	 * was before the current sort started. Useful in the stop and receive
	 * callback functions..
	 */
	IJQFunction cancel();

	/**
	 * Cancels a change in the current sortable and reverts it back to how it
	 * was before the current sort started. Useful in the stop and receive
	 * callback functions..
	 * 
	 * @param ajaxRequestTarget
	 */
	void cancel(AjaxRequestTarget ajaxRequestTarget);
}
