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
package com.google.code.jqwicket.ui.selectable;

import com.google.code.jqwicket.api.AbstractJQOptions;
import com.google.code.jqwicket.api.IJQFunction;
import com.google.code.jqwicket.api.IJQStatement;

import static com.google.code.jqwicket.api.JQuery.$f;
import static com.google.code.jqwicket.api.JQuery.js;

/**
 * @author mkalina
 * 
 */
public class SelectableOptions extends AbstractJQOptions<SelectableOptions> {

	private static final long serialVersionUID = 1L;

	public enum Tolerance {
		TOUCH, FIT;
	}

	/**
	 * Disables (true) or enables (false) the selectable. Can be set when
	 * initialising (first creating) the selectable. Default:false
	 * 
	 * @param disabled
	 * @return
	 */
	public SelectableOptions disabled(boolean disabled) {
		super.put("disabled", disabled);
		return this;
	}

	/**
	 * This determines whether to refresh (recalculate) the position and size of
	 * each selectee at the beginning of each select operation. If you have many
	 * many items, you may want to set this to false and call the refresh method
	 * manually. Default:true
	 * 
	 * @param autoRefresh
	 * @return
	 */
	public SelectableOptions autoRefresh(boolean autoRefresh) {
		super.put("autoRefresh", autoRefresh);
		return this;
	}

	/**
	 * Prevents selecting if you start on elements matching the selector.
	 * Default:':input,option'
	 * 
	 * @param selector
	 * @return
	 */
	public SelectableOptions cancel(CharSequence selector) {
		super.put("cancel", selector);
		return this;
	}

	/**
	 * Time in milliseconds to define when the selecting should start. It helps
	 * preventing unwanted selections when clicking on an element. Default:0
	 * 
	 * @param delay
	 * @return
	 */
	public SelectableOptions delay(int delay) {
		super.put("delay", delay);
		return this;
	}

	/**
	 * Tolerance, in pixels, for when selecting should start. If specified,
	 * selecting will not start until after mouse is dragged beyond distance.
	 * Default:0
	 * 
	 * @param distance
	 * @return
	 */
	public SelectableOptions distance(int distance) {
		super.put("distance", distance);
		return this;
	}

	/**
	 * The matching child elements will be made selectees (able to be selected).
	 * Default:'*'
	 * 
	 * @param selector
	 * @return
	 */
	public SelectableOptions filter(CharSequence selector) {
		super.put("filter", selector);
		return this;
	}

	/**
	 * Possible values: 'touch', 'fit'. <br>
	 * fit: draggable overlaps the droppable entirely<br>
	 * touch: draggable overlaps the droppable any amount<br>
	 * <br>
	 * Default:'touch'
	 * 
	 * @param tolerance
	 * @return
	 */
	public SelectableOptions tolerance(Tolerance tolerance) {
		super.put("tolerance", tolerance);
		return this;
	}

	/**
	 * This event is triggered at the end of the select operation, on each
	 * element added to the selection.
	 * 
	 * @param callbackBody
	 * @return
	 */
	public SelectableOptions selectedEvent(CharSequence callbackBody) {
		return this.selectedEvent(js(callbackBody));
	}

	/**
	 * This event is triggered at the end of the select operation, on each
	 * element added to the selection.
	 * 
	 * @param callbackBody
	 * @return
	 */
	public SelectableOptions selectedEvent(IJQStatement callbackBody) {
		return this.selectedEvent($f(callbackBody).withParams("event", "ui"));
	}

	/**
	 * This event is triggered at the end of the select operation, on each
	 * element added to the selection.
	 * 
	 * @param callback
	 * @return
	 */
	public SelectableOptions selectedEvent(IJQFunction callback) {
		super.put("selected", callback);
		return this;
	}

	/**
	 * This event is triggered during the select operation, on each element
	 * added to the selection.
	 * 
	 * @param callbackBody
	 * @return
	 */
	public SelectableOptions selectingEvent(CharSequence callbackBody) {
		return this.selectingEvent(js(callbackBody));
	}

	/**
	 * This event is triggered during the select operation, on each element
	 * added to the selection.
	 * 
	 * 
	 * @param callbackBody
	 * @return
	 */
	public SelectableOptions selectingEvent(IJQStatement callbackBody) {
		return this.selectingEvent($f(callbackBody).withParams("event", "ui"));
	}

	/**
	 * This event is triggered during the select operation, on each element
	 * added to the selection.
	 * 
	 * @param callback
	 * @return
	 */
	public SelectableOptions selectingEvent(IJQFunction callback) {
		super.put("selecting", callback);
		return this;
	}

	/**
	 * This event is triggered at the beginning of the select operation.
	 * 
	 * @param callbackBody
	 * @return
	 */
	public SelectableOptions startEvent(CharSequence callbackBody) {
		return this.startEvent(js(callbackBody));
	}

	/**
	 * This event is triggered at the beginning of the select operation.
	 * 
	 * @param callbackBody
	 * @return
	 */
	public SelectableOptions startEvent(IJQStatement callbackBody) {
		return this.startEvent($f(callbackBody).withParams("event", "ui"));
	}

	/**
	 * This event is triggered at the beginning of the select operation.
	 * 
	 * @param callback
	 * @return
	 */
	public SelectableOptions startEvent(IJQFunction callback) {
		super.put("start", callback);
		return this;
	}

	/**
	 * This event is triggered at the end of the select operation.
	 * 
	 * @param callbackBody
	 * @return
	 */
	public SelectableOptions stopEvent(CharSequence callbackBody) {
		return this.stopEvent(js(callbackBody));
	}

	/**
	 * This event is triggered at the end of the select operation.
	 * 
	 * @param callbackBody
	 * @return
	 */
	public SelectableOptions stopEvent(IJQStatement callbackBody) {
		return this.stopEvent($f(callbackBody).withParams("event", "ui"));
	}

	/**
	 * This event is triggered at the end of the select operation.
	 * 
	 * @param callback
	 * @return
	 */
	public SelectableOptions stopEvent(IJQFunction callback) {
		super.put("stop", callback);
		return this;
	}

	/**
	 * This event is triggered at the end of the select operation, on each
	 * element removed from the selection.
	 * 
	 * @param callbackBody
	 * @return
	 */
	public SelectableOptions unselectedEvent(CharSequence callbackBody) {
		return this.unselectedEvent(js(callbackBody));
	}

	/**
	 * This event is triggered at the end of the select operation, on each
	 * element removed from the selection.
	 * 
	 * @param callbackBody
	 * @return
	 */
	public SelectableOptions unselectedEvent(IJQStatement callbackBody) {
		return this.unselectedEvent($f(callbackBody).withParams("event", "ui"));
	}

	/**
	 * This event is triggered at the end of the select operation, on each
	 * element removed from the selection.
	 * 
	 * @param callback
	 * @return
	 */
	public SelectableOptions unselectedEvent(IJQFunction callback) {
		super.put("unselected", callback);
		return this;
	}

	/**
	 * This event is triggered during the select operation, on each element
	 * removed from the selection.
	 * 
	 * @param callbackBody
	 * @return
	 */
	public SelectableOptions unselectingEvent(CharSequence callbackBody) {
		return this.unselectingEvent(js(callbackBody));
	}

	/**
	 * This event is triggered during the select operation, on each element
	 * removed from the selection.
	 * 
	 * @param callbackBody
	 * @return
	 */
	public SelectableOptions unselectingEvent(IJQStatement callbackBody) {
		return this
				.unselectingEvent($f(callbackBody).withParams("event", "ui"));
	}

	/**
	 * This event is triggered during the select operation, on each element
	 * removed from the selection.
	 * 
	 * @param callback
	 * @return
	 */
	public SelectableOptions unselectingEvent(IJQFunction callback) {
		super.put("unselecting", callback);
		return this;
	}

}
