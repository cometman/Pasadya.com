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
package com.google.code.jqwicket.ui.draggable;

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
public class DraggableOptions extends AbstractJQOptions<DraggableOptions> {

	private static final long serialVersionUID = 1L;

	public enum Axis {
		X, Y;
	}

	public enum SnapMode {
		INNER, OUTER, BOTH;
	}

	/**
	 * Disables (true) or enables (false) the draggable. Can be set when
	 * initialising (first creating) the draggable. Default:false
	 * 
	 * @param disabled
	 * @return
	 */
	public DraggableOptions disabled(boolean disabled) {
		super.put("disabled", disabled);
		return this;
	}

	/**
	 * If set to false, will prevent the ui-draggable class from being added.
	 * This may be desired as a performance optimization when calling
	 * .draggable() init on many hundreds of elements. Default:true
	 * 
	 * @param addClasses
	 * @return
	 */
	public DraggableOptions addClasses(boolean addClasses) {
		super.put("addClasses", addClasses);
		return this;
	}

	/**
	 * The element passed to or selected by the appendTo option will be used as
	 * the draggable helper's container during dragging. By default, the helper
	 * is appended to the same container as the draggable. Default:'parent'
	 * 
	 * @param selector
	 * @return
	 */
	public DraggableOptions appendTo(CharSequence selector) {
		super.put("appendTo", selector);
		return this;
	}

	/**
	 * Constrains dragging to either the horizontal (x) or vertical (y) axis.
	 * Possible values: 'x', 'y'.
	 * 
	 * @param axis
	 * @return
	 */
	public DraggableOptions axis(Axis axis) {
		super.put("axis", axis);
		return this;
	}

	/**
	 * Prevents dragging from starting on specified elements.
	 * Default:':input,option'
	 * 
	 * @param selector
	 * @return
	 */
	public DraggableOptions cancel(CharSequence selector) {
		super.put("cancel", selector);
		return this;
	}

	/**
	 * Allows the draggable to be dropped onto the specified sortables. If this
	 * option is used (helper must be set to 'clone' in order to work
	 * flawlessly), a draggable can be dropped onto a sortable list and then
	 * becomes part of it. Default:false
	 * 
	 * @param selector
	 * @return
	 */
	public DraggableOptions connectToSortable(CharSequence selector) {
		super.put("connectToSortable", selector);
		return this;
	}

	/**
	 * Constrains dragging to within the bounds of the specified element or
	 * region. Possible string values: 'parent', 'document', 'window', [x1, y1,
	 * x2, y2].
	 * 
	 * @param selector
	 * @return
	 */
	public DraggableOptions containment(CharSequence selector) {
		super.put("containment", selector);
		return this;
	}

	/**
	 * Constrains dragging to within the bounds of the specified element or
	 * region. Possible string values: 'parent', 'document', 'window', [x1, y1,
	 * x2, y2].
	 * 
	 * @param selector
	 * @return
	 */
	public DraggableOptions containment(int[] containment) {
		super.put("containment", containment);
		return this;
	}

	/**
	 * The css cursor during the drag operation. Default:'auto'
	 * 
	 * @param cursor
	 * @return
	 */
	public DraggableOptions cursor(CharSequence cursor) {
		super.put("cursor", cursor);
		return this;
	}

	/**
	 * Sets the offset of the dragging helper relative to the mouse cursor.
	 * Coordinates can be given as a hash using a combination of one or two
	 * keys: { top, left, right, bottom }. Default:false
	 * 
	 * @param cursorAt
	 * @return
	 */
	public DraggableOptions cursorAt(CharSequence cursorAt) {
		super.put("cursorAt", cursorAt);
		return this;
	}

	/**
	 * Time in milliseconds after mousedown until dragging should start. This
	 * option can be used to prevent unwanted drags when clicking on an element.
	 * Default:0
	 * 
	 * @param delay
	 * @return
	 */
	public DraggableOptions delay(int delay) {
		super.put("delay", delay);
		return this;
	}

	/**
	 * Distance in pixels after mousedown the mouse must move before dragging
	 * should start. This option can be used to prevent unwanted drags when
	 * clicking on an element.
	 * 
	 * @param distance
	 * @return
	 */
	public DraggableOptions distance(int distance) {
		super.put("distance", distance);
		return this;
	}

	/**
	 * Snaps the dragging helper to a grid, every x and y pixels. Array values:
	 * [x, y]. Default:false
	 * 
	 * @param grid
	 * @return
	 */
	public DraggableOptions grid(XYPosition grid) {
		super.put("grid", grid);
		return this;
	}

	/**
	 * If specified, restricts drag start click to the specified element(s).
	 * Default:false
	 * 
	 * @param handle
	 * @return
	 */
	public DraggableOptions handle(CharSequence handle) {
		super.put("handle", handle);
		return this;
	}

	/**
	 * Allows for a helper element to be used for dragging display. Possible
	 * values: 'original', 'clone', Function. If a function is specified, it
	 * must return a DOMElement. Default:'original'
	 * 
	 * @param helper
	 * @return
	 */
	public DraggableOptions helper(CharSequence helper) {
		super.put("helper", helper);
		return this;
	}

	/**
	 * Allows for a helper element to be used for dragging display. Possible
	 * values: 'original', 'clone', Function. If a function is specified, it
	 * must return a DOMElement. Default:'original'
	 * 
	 * @param helper
	 * @return
	 */
	public DraggableOptions helper(IJQFunction callback) {
		super.put("helper", callback);
		return this;
	}

	/**
	 * Prevent iframes from capturing the mousemove events during a drag. Useful
	 * in combination with cursorAt, or in any case, if the mouse cursor is not
	 * over the helper. If set to true, transparent overlays will be placed over
	 * all iframes on the page. If a selector is supplied, the matched iframes
	 * will have an overlay placed over them. Default:false
	 * 
	 * @param selector
	 * @return
	 */
	public DraggableOptions iframeFix(CharSequence selector) {
		super.put("iframeFix", selector);
		return this;
	}

	/**
	 * Prevent iframes from capturing the mousemove events during a drag. Useful
	 * in combination with cursorAt, or in any case, if the mouse cursor is not
	 * over the helper. If set to true, transparent overlays will be placed over
	 * all iframes on the page. If a selector is supplied, the matched iframes
	 * will have an overlay placed over them. Default:false
	 * 
	 * @param iframeFix
	 * @return
	 */
	public DraggableOptions iframeFix(boolean iframeFix) {
		super.put("iframeFix", iframeFix);
		return this;
	}

	/**
	 * Opacity for the helper while being dragged. Default:false
	 * 
	 * @param opacity
	 * @return
	 */
	public DraggableOptions opacity(float opacity) {
		super.put("opacity", opacity);
		return this;
	}

	/**
	 * If set to true, all droppable positions are calculated on every
	 * mousemove. Caution: This solves issues on highly dynamic pages, but
	 * dramatically decreases performance. Default:false
	 * 
	 * @param refreshPositions
	 * @return
	 */
	public DraggableOptions refreshPositions(boolean refreshPositions) {
		super.put("refreshPositions", refreshPositions);
		return this;
	}

	/**
	 * If set to true, the element will return to its start position when
	 * dragging stops. Possible string values: 'valid', 'invalid'. If set to
	 * invalid, revert will only occur if the draggable has not been dropped on
	 * a droppable. For valid, it's the other way around. Default:false
	 * 
	 * @param revert
	 * @return
	 */
	public DraggableOptions revert(boolean revert) {
		super.put("revert", revert);
		return this;
	}

	/**
	 * If set to true, the element will return to its start position when
	 * dragging stops. Possible string values: 'valid', 'invalid'. If set to
	 * invalid, revert will only occur if the draggable has not been dropped on
	 * a droppable. For valid, it's the other way around. Default:false
	 * 
	 * @param revert
	 * @return
	 */
	public DraggableOptions revert(CharSequence revert) {
		super.put("revert", revert);
		return this;
	}

	/**
	 * The duration of the revert animation, in milliseconds. Ignored if revert
	 * is false. Default:500
	 * 
	 * @param revertDuration
	 * @return
	 */
	public DraggableOptions revertDuration(int revertDuration) {
		super.put("revertDuration", revertDuration);
		return this;
	}

	/**
	 * Used to group sets of draggable and droppable items, in addition to
	 * droppable's accept option. A draggable with the same scope value as a
	 * droppable will be accepted by the droppable. Default:'default'
	 * 
	 * @param scope
	 * @return
	 */
	public DraggableOptions scope(CharSequence scope) {
		super.put("scope", scope);
		return this;
	}

	/**
	 * If set to true, container auto-scrolls while dragging. Default:true
	 * 
	 * @param scroll
	 * @return
	 */
	public DraggableOptions scroll(boolean scroll) {
		super.put("scroll", scroll);
		return this;
	}

	/**
	 * Distance in pixels from the edge of the viewport after which the viewport
	 * should scroll. Distance is relative to pointer, not the draggable.
	 * Default:20
	 * 
	 * @param scrollSensitivity
	 * @return
	 */
	public DraggableOptions scrollSensitivity(int scrollSensitivity) {
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
	public DraggableOptions scrollSpeed(int scrollSpeed) {
		super.put("scrollSpeed", scrollSpeed);
		return this;
	}

	/**
	 * If set to a selector or to true (equivalent to '.ui-draggable'), the
	 * draggable will snap to the edges of the selected elements when near an
	 * edge of the element. Default:false
	 * 
	 * @param selector
	 * @return
	 */
	public DraggableOptions snap(CharSequence selector) {
		super.put("snap", selector);
		return this;
	}

	/**
	 * If set to a selector or to true (equivalent to '.ui-draggable'), the
	 * draggable will snap to the edges of the selected elements when near an
	 * edge of the element. Default:false
	 * 
	 * @param snap
	 * @return
	 */
	public DraggableOptions snap(boolean snap) {
		super.put("snap", snap);
		return this;
	}

	/**
	 * Determines which edges of snap elements the draggable will snap to.
	 * Ignored if snap is false. Possible values: 'inner', 'outer', 'both'.
	 * Default:'both'
	 * 
	 * @param snapMode
	 * @return
	 */
	public DraggableOptions snapMode(SnapMode snapMode) {
		super.put("snapMode", snapMode);
		return this;
	}

	/**
	 * The distance in pixels from the snap element edges at which snapping
	 * should occur. Ignored if snap is false. Default:20
	 * 
	 * @param snapTolerance
	 * @return
	 */
	public DraggableOptions snapTolerance(int snapTolerance) {
		super.put("snapTolerance", snapTolerance);
		return this;
	}

	/**
	 * Controls the z-Index of the set of elements that match the selector,
	 * always brings to front the dragged item. Very useful in things like
	 * window managers. Default:false
	 * 
	 * @param selector
	 * @return
	 */
	public DraggableOptions stack(CharSequence selector) {
		super.put("stack", selector);
		return this;
	}

	/**
	 * z-index for the helper while being dragged. Default:false
	 * 
	 * @param zIndex
	 * @return
	 */
	public DraggableOptions zIndex(int zIndex) {
		super.put("zIndex", zIndex);
		return this;
	}

	/**
	 * This event is triggered when dragging starts.
	 * 
	 * @param callbackBody
	 * @return
	 */
	public DraggableOptions startEvent(CharSequence callbackBody) {
		return this.startEvent(js(callbackBody));
	}

	/**
	 * This event is triggered when dragging starts.
	 * 
	 * @param callbackBody
	 * @return
	 */
	public DraggableOptions startEvent(IJQStatement callbackBody) {
		return this.startEvent($f(callbackBody).withParams("event", "ui"));
	}

	/**
	 * This event is triggered when dragging starts.
	 * 
	 * @param callback
	 * @return
	 */
	public DraggableOptions startEvent(IJQFunction callback) {
		super.put("start", callback);
		return this;
	}

	/**
	 * This event is triggered when the mouse is moved during the dragging.
	 * 
	 * @param callbackBody
	 * @return
	 */
	public DraggableOptions dragEvent(CharSequence callbackBody) {
		return this.dragEvent(js(callbackBody));
	}

	/**
	 * This event is triggered when the mouse is moved during the dragging.
	 * 
	 * @param callbackBody
	 * @return
	 */
	public DraggableOptions dragEvent(IJQStatement callbackBody) {
		return this.dragEvent($f(callbackBody).withParams("event", "ui"));
	}

	/**
	 * This event is triggered when the mouse is moved during the dragging.
	 * 
	 * @param callback
	 * @return
	 */
	public DraggableOptions dragEvent(IJQFunction callback) {
		super.put("drag", callback);
		return this;
	}

	/**
	 * This event is triggered when dragging stops.
	 * 
	 * @param callbackBody
	 * @return
	 */
	public DraggableOptions stopEvent(CharSequence callbackBody) {
		return this.stopEvent(js(callbackBody));
	}

	/**
	 * This event is triggered when dragging stops.
	 * 
	 * @param callbackBody
	 * @return
	 */
	public DraggableOptions stopEvent(IJQStatement callbackBody) {
		return this.stopEvent($f(callbackBody).withParams("event", "ui"));
	}

	/**
	 * This event is triggered when dragging stops.
	 * 
	 * @param callback
	 * @return
	 */
	public DraggableOptions stopEvent(IJQFunction callback) {
		super.put("stop", callback);
		return this;
	}

}
