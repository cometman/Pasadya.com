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

import com.google.code.jqwicket.api.AbstractJQOptions;
import com.google.code.jqwicket.api.IJQFunction;
import com.google.code.jqwicket.api.IJQStatement;
import com.google.code.jqwicket.ui.XYPosition;

import static com.google.code.jqwicket.api.JQuery.$f;
import static com.google.code.jqwicket.api.JQuery.js;

/**
 * @author mkalina
 * 
 */
public class SortableOptions extends AbstractJQOptions<SortableOptions> {

	private static final long serialVersionUID = 1L;

	public enum Axis {
		X, Y;
	}

	/**
	 * Disables (true) or enables (false) the sortable. Can be set when
	 * initialising (first creating) the sortable. Default:false
	 * 
	 * @param disabled
	 * @return
	 */
	public SortableOptions disabled(boolean disabled) {
		super.put("disabled", disabled);
		return this;
	}

	/**
	 * Defines where the helper that moves with the mouse is being appended to
	 * during the drag (for example, to resolve overlap/zIndex issues).
	 * Default:'parent'
	 * 
	 * @param appendTo
	 * @return
	 */
	public SortableOptions appendTo(CharSequence appendTo) {
		super.put("appendTo", appendTo);
		return this;
	}

	/**
	 * If defined, the items can be dragged only horizontally or vertically.
	 * Possible values:'x', 'y'. Default:false
	 * 
	 * @param axis
	 * @return
	 */
	public SortableOptions axis(Axis axis) {
		super.put("axis", axis);
		return this;
	}

	/**
	 * Prevents sorting if you start on elements matching the selector.
	 * Default:':input,option'
	 * 
	 * @param selector
	 * @return
	 */
	public SortableOptions cancel(CharSequence selector) {
		super.put("cancel", selector);
		return this;
	}

	/**
	 * Takes a jQuery selector with items that also have sortables applied. If
	 * used, the sortable is now connected to the other one-way, so you can drag
	 * from this sortable to the other. Default:false
	 * 
	 * @param selector
	 * @return
	 */
	public SortableOptions connectWith(CharSequence selector) {
		super.put("connectWith", selector);
		return this;
	}

	/**
	 * Constrains dragging to within the bounds of the specified element - can
	 * be a DOM element, 'parent', 'document', 'window', or a jQuery selector.
	 * 
	 * @param selector
	 * @return
	 */
	public SortableOptions containment(CharSequence selector) {
		super.put("containment", selector);
		return this;
	}

	/**
	 * Defines the cursor that is being shown while sorting. Default:'auto'
	 * 
	 * @param cursor
	 * @return
	 */
	public SortableOptions cursor(CharSequence cursor) {
		super.put("cursor", cursor);
		return this;
	}

	/**
	 * Moves the sorting element or helper so the cursor always appears to drag
	 * from the same position. Coordinates can be given as a hash using a
	 * combination of one or two keys: { top, left, right, bottom }.
	 * Default:false
	 * 
	 * @param cursorAt
	 * @return
	 */
	public SortableOptions cursorAt(CharSequence cursorAt) {
		super.put("cursorAt", cursorAt);
		return this;
	}

	/**
	 * Time in milliseconds to define when the sorting should start. It helps
	 * preventing unwanted drags when clicking on an element. Default:0
	 * 
	 * @param delay
	 * @return
	 */
	public SortableOptions delay(int delay) {
		super.put("delay", delay);
		return this;
	}

	/**
	 * Tolerance, in pixels, for when sorting should start. If specified,
	 * sorting will not start until after mouse is dragged beyond distance. Can
	 * be used to allow for clicks on elements within a handle.
	 * 
	 * @param distance
	 * @return
	 */
	public SortableOptions distance(int distance) {
		super.put("distance", distance);
		return this;
	}

	/**
	 * If false items from this sortable can't be dropped to an empty linked
	 * sortable. Default:true
	 * 
	 * @param dropOnEmpty
	 * @return
	 */
	public SortableOptions dropOnEmpty(boolean dropOnEmpty) {
		super.put("dropOnEmpty", dropOnEmpty);
		return this;
	}

	/**
	 * If true, forces the helper to have a size. Default:false
	 * 
	 * @param forceHelperSize
	 * @return
	 */
	public SortableOptions forceHelperSize(boolean forceHelperSize) {
		super.put("forceHelperSize", forceHelperSize);
		return this;
	}

	/**
	 * If true, forces the placeholder to have a size. Default:false
	 * 
	 * @param forcePlaceholderSize
	 * @return
	 */
	public SortableOptions forcePlaceholderSize(boolean forcePlaceholderSize) {
		super.put("forcePlaceholderSize", forcePlaceholderSize);
		return this;
	}

	/**
	 * Snaps the sorting element or helper to a grid, every x and y pixels.
	 * Array values: [x, y]. Default:false
	 * 
	 * @param grid
	 * @return
	 */
	public SortableOptions grid(XYPosition grid) {
		super.put("grid", grid);
		return this;
	}

	/**
	 * Restricts sort start click to the specified element. Default:false
	 * 
	 * @param selector
	 * @return
	 */
	public SortableOptions handle(CharSequence selector) {
		super.put("handle", selector);
		return this;
	}

	/**
	 * Allows for a helper element to be used for dragging display. The supplied
	 * function receives the event and the element being sorted, and should
	 * return a DOMElement to be used as a custom proxy helper. Possible values:
	 * 'original', 'clone'. Default:'original'
	 * 
	 * @param helper
	 * @return
	 */
	public SortableOptions helper(CharSequence helper) {
		super.put("helper", helper);
		return this;
	}

	/**
	 * Allows for a helper element to be used for dragging display. The supplied
	 * function receives the event and the element being sorted, and should
	 * return a DOMElement to be used as a custom proxy helper. Possible values:
	 * 'original', 'clone'. Default:'original'
	 * 
	 * @param helper
	 * @return
	 */
	public SortableOptions helper(IJQFunction callback) {
		super.put("helper", callback);
		return this;
	}

	/**
	 * Specifies which items inside the element should be sortable.<br>
	 * Default:'> *'
	 * 
	 * @param selector
	 * @return
	 */
	public SortableOptions items(CharSequence selector) {
		super.put("items", selector);
		return this;
	}

	/**
	 * Defines the opacity of the helper while sorting. From 0.01 to 1.
	 * Default:false
	 * 
	 * @param opacity
	 * @return
	 */
	public SortableOptions opacity(float opacity) {
		super.put("opacity", opacity);
		return this;
	}

	/**
	 * Class that gets applied to the otherwise white space. Default:false
	 * 
	 * @param placeholder
	 * @return
	 */
	public SortableOptions placeholder(CharSequence placeholder) {
		super.put("placeholder", placeholder);
		return this;
	}

	/**
	 * If set to true, the item will be reverted to its new DOM position with a
	 * smooth animation. Optionally, it can also be set to a number that
	 * controls the duration of the animation in ms. Default:false
	 * 
	 * @param revert
	 * @return
	 */
	public SortableOptions revert(boolean revert) {
		super.put("revert", revert);
		return this;
	}

	/**
	 * If set to true, the item will be reverted to its new DOM position with a
	 * smooth animation. Optionally, it can also be set to a number that
	 * controls the duration of the animation in ms. Default:false
	 * 
	 * @param revert
	 * @return
	 */
	public SortableOptions revert(int revert) {
		super.put("revert", revert);
		return this;
	}

	/**
	 * If set to true, the page scrolls when coming to an edge. Default:true
	 * 
	 * @param scroll
	 * @return
	 */
	public SortableOptions scroll(boolean scroll) {
		super.put("scroll", scroll);
		return this;
	}

	/**
	 * Defines how near the mouse must be to an edge to start scrolling.
	 * Default:20
	 * 
	 * @param scrollSensitivity
	 * @return
	 */
	public SortableOptions scrollSensitivity(int scrollSensitivity) {
		super.put("scrollSensitivity", scrollSensitivity);
		return this;
	}

	/**
	 * The speed at which the window should scroll once the mouse pointer gets
	 * within the scrollSensitivity distance. Default:20
	 * 
	 * @param scrollSpeed
	 * @return
	 */
	public SortableOptions scrollSpeed(int scrollSpeed) {
		super.put("scrollSpeed", scrollSpeed);
		return this;
	}

	/**
	 * This is the way the reordering behaves during drag. Possible values:
	 * 'intersect', 'pointer'. In some setups, 'pointer' is more natural. <br>
	 * intersect: draggable overlaps the droppable at least 50%<br>
	 * pointer: mouse pointer overlaps the droppable<br>
	 * 
	 * @param tolerance
	 * @return
	 */
	public SortableOptions tolerance(CharSequence tolerance) {
		super.put("tolerance", tolerance);
		return this;
	}

	/**
	 * Z-index for element/helper while being sorted. Default:1000
	 * 
	 * @param zIndex
	 * @return
	 */
	public SortableOptions zIndex(int zIndex) {
		super.put("zIndex", zIndex);
		return this;
	}

	/**
	 * This event is triggered when sorting starts.
	 * 
	 * @param callbackBody
	 * @return
	 */
	public SortableOptions startEvent(CharSequence callbackBody) {
		return this.startEvent(js(callbackBody));
	}

	/**
	 * This event is triggered when sorting starts.
	 * 
	 * @param callbackBody
	 * @return
	 */
	public SortableOptions startEvent(IJQStatement callbackBody) {
		return this.startEvent($f(callbackBody).withParams("event", "ui"));
	}

	/**
	 * This event is triggered when sorting starts.
	 * 
	 * @param callback
	 * @return
	 */
	public SortableOptions startEvent(IJQFunction callback) {
		super.put("start", callback);
		return this;
	}

	/**
	 * This event is triggered during sorting.
	 * 
	 * @param callbackBody
	 * @return
	 */
	public SortableOptions sortEvent(CharSequence callbackBody) {
		return this.sortEvent(js(callbackBody));
	}

	/**
	 * This event is triggered during sorting.
	 * 
	 * @param callbackBody
	 * @return
	 */
	public SortableOptions sortEvent(IJQStatement callbackBody) {
		return this.sortEvent($f(callbackBody).withParams("event", "ui"));
	}

	/**
	 * This event is triggered during sorting.
	 * 
	 * @param callback
	 * @return
	 */
	public SortableOptions sortEvent(IJQFunction callback) {
		super.put("sort", callback);
		return this;
	}

	/**
	 * This event is triggered during sorting, but only when the DOM position
	 * has changed.
	 * 
	 * @param callbackBody
	 * @return
	 */
	public SortableOptions changeEvent(CharSequence callbackBody) {
		return this.changeEvent(js(callbackBody));
	}

	/**
	 * This event is triggered during sorting, but only when the DOM position
	 * has changed.
	 * 
	 * @param callbackBody
	 * @return
	 */
	public SortableOptions changeEvent(IJQStatement callbackBody) {
		return this.changeEvent($f(callbackBody).withParams("event", "ui"));
	}

	/**
	 * This event is triggered during sorting, but only when the DOM position
	 * has changed.
	 * 
	 * @param callback
	 * @return
	 */
	public SortableOptions changeEvent(IJQFunction callback) {
		super.put("change", callback);
		return this;
	}

	/**
	 * This event is triggered when sorting stops, but when the
	 * placeholder/helper is still available.
	 * 
	 * @param callbackBody
	 * @return
	 */
	public SortableOptions beforeStopEvent(CharSequence callbackBody) {
		return this.beforeStopEvent(js(callbackBody));
	}

	/**
	 * This event is triggered when sorting stops, but when the
	 * placeholder/helper is still available.
	 * 
	 * @param callbackBody
	 * @return
	 */
	public SortableOptions beforeStopEvent(IJQStatement callbackBody) {
		return this.beforeStopEvent($f(callbackBody).withParams("event", "ui"));
	}

	/**
	 * This event is triggered when sorting stops, but when the
	 * placeholder/helper is still available.
	 * 
	 * @param callback
	 * @return
	 */
	public SortableOptions beforeStopEvent(IJQFunction callback) {
		super.put("beforeStop", callback);
		return this;
	}

	/**
	 * This event is triggered when sorting has stopped.
	 * 
	 * @param callbackBody
	 * @return
	 */
	public SortableOptions stopEvent(CharSequence callbackBody) {
		return this.stopEvent(js(callbackBody));
	}

	/**
	 * This event is triggered when sorting has stopped.
	 * 
	 * @param callbackBody
	 * @return
	 */
	public SortableOptions stopEvent(IJQStatement callbackBody) {
		return this.stopEvent($f(callbackBody).withParams("event", "ui"));
	}

	/**
	 * This event is triggered when sorting has stopped.
	 * 
	 * @param callback
	 * @return
	 */
	public SortableOptions stopEvent(IJQFunction callback) {
		super.put("stop", callback);
		return this;
	}

	/**
	 * This event is triggered when the user stopped sorting and the DOM
	 * position has changed.
	 * 
	 * @param callbackBody
	 * @return
	 */
	public SortableOptions updateEvent(CharSequence callbackBody) {
		return this.updateEvent(js(callbackBody));
	}

	/**
	 * This event is triggered when the user stopped sorting and the DOM
	 * position has changed.
	 * 
	 * @param callbackBody
	 * @return
	 */
	public SortableOptions updateEvent(IJQStatement callbackBody) {
		return this.updateEvent($f(callbackBody).withParams("event", "ui"));
	}

	/**
	 * This event is triggered when the user stopped sorting and the DOM
	 * position has changed.
	 * 
	 * @param callback
	 * @return
	 */
	public SortableOptions updateEvent(IJQFunction callback) {
		super.put("update", callback);
		return this;
	}

	/**
	 * This event is triggered when a connected sortable list has received an
	 * item from another list.
	 * 
	 * @param callbackBody
	 * @return
	 */
	public SortableOptions receiveEvent(CharSequence callbackBody) {
		return this.receiveEvent(js(callbackBody));
	}

	/**
	 * This event is triggered when a connected sortable list has received an
	 * item from another list.
	 * 
	 * @param callbackBody
	 * @return
	 */
	public SortableOptions receiveEvent(IJQStatement callbackBody) {
		return this.receiveEvent($f(callbackBody).withParams("event", "ui"));
	}

	/**
	 * This event is triggered when a connected sortable list has received an
	 * item from another list.
	 * 
	 * @param callback
	 * @return
	 */
	public SortableOptions receiveEvent(IJQFunction callback) {
		super.put("receive", callback);
		return this;
	}

	/**
	 * This event is triggered when a sortable item has been dragged out from
	 * the list and into another.
	 * 
	 * @param callbackBody
	 * @return
	 */
	public SortableOptions removeEvent(CharSequence callbackBody) {
		return this.removeEvent(js(callbackBody));
	}

	/**
	 * This event is triggered when a sortable item has been dragged out from
	 * the list and into another.
	 * 
	 * @param callbackBody
	 * @return
	 */
	public SortableOptions removeEvent(IJQStatement callbackBody) {
		return this.removeEvent($f(callbackBody).withParams("event", "ui"));
	}

	/**
	 * This event is triggered when a sortable item has been dragged out from
	 * the list and into another.
	 * 
	 * @param callback
	 * @return
	 */
	public SortableOptions removeEvent(IJQFunction callback) {
		super.put("remove", callback);
		return this;
	}

	/**
	 * This event is triggered when a sortable item is moved into a connected
	 * list.
	 * 
	 * @param callbackBody
	 * @return
	 */
	public SortableOptions overEvent(CharSequence callbackBody) {
		return this.overEvent(js(callbackBody));
	}

	/**
	 * This event is triggered when a sortable item is moved into a connected
	 * list.
	 * 
	 * @param callbackBody
	 * @return
	 */
	public SortableOptions overEvent(IJQStatement callbackBody) {
		return this.overEvent($f(callbackBody).withParams("event", "ui"));
	}

	/**
	 * This event is triggered when a sortable item is moved into a connected
	 * list.
	 * 
	 * @param callback
	 * @return
	 */
	public SortableOptions overEvent(IJQFunction callback) {
		super.put("over", callback);
		return this;
	}

	/**
	 * This event is triggered when a sortable item is moved away from a
	 * connected list.
	 * 
	 * @param callbackBody
	 * @return
	 */
	public SortableOptions outEvent(CharSequence callbackBody) {
		return this.outEvent(js(callbackBody));
	}

	/**
	 * This event is triggered when a sortable item is moved away from a
	 * connected list.
	 * 
	 * @param callbackBody
	 * @return
	 */
	public SortableOptions outEvent(IJQStatement callbackBody) {
		return this.outEvent($f(callbackBody).withParams("event", "ui"));
	}

	/**
	 * This event is triggered when a sortable item is moved away from a
	 * connected list.
	 * 
	 * @param callback
	 * @return
	 */
	public SortableOptions outEvent(IJQFunction callback) {
		super.put("out", callback);
		return this;
	}

	/**
	 * This event is triggered when using connected lists, every connected list
	 * on drag start receives it.
	 * 
	 * @param callbackBody
	 * @return
	 */
	public SortableOptions activateEvent(CharSequence callbackBody) {
		return this.activateEvent(js(callbackBody));
	}

	/**
	 * This event is triggered when using connected lists, every connected list
	 * on drag start receives it.
	 * 
	 * @param callbackBody
	 * @return
	 */
	public SortableOptions activateEvent(IJQStatement callbackBody) {
		return this.activateEvent($f(callbackBody).withParams("event", "ui"));
	}

	/**
	 * This event is triggered when using connected lists, every connected list
	 * on drag start receives it.
	 * 
	 * @param callback
	 * @return
	 */
	public SortableOptions activateEvent(IJQFunction callback) {
		super.put("activate", callback);
		return this;
	}

	/**
	 * This event is triggered when sorting was stopped, is propagated to all
	 * possible connected lists.
	 * 
	 * @param callbackBody
	 * @return
	 */
	public SortableOptions deactivateEvent(CharSequence callbackBody) {
		return this.deactivateEvent(js(callbackBody));
	}

	/**
	 * This event is triggered when sorting was stopped, is propagated to all
	 * possible connected lists.
	 * 
	 * @param callbackBody
	 * @return
	 */
	public SortableOptions deactivateEvent(IJQStatement callbackBody) {
		return this.deactivateEvent($f(callbackBody).withParams("event", "ui"));
	}

	/**
	 * This event is triggered when sorting was stopped, is propagated to all
	 * possible connected lists.
	 * 
	 * @param callback
	 * @return
	 */
	public SortableOptions deactivateEvent(IJQFunction callback) {
		super.put("deactivate", callback);
		return this;
	}

}
