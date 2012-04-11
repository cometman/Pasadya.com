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
package com.google.code.jqwicket.ui.resizable;

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
public class ResizableOptions extends AbstractJQOptions<ResizableOptions> {

	private static final long serialVersionUID = 1L;

	/**
	 * Disables (true) or enables (false) the resizable. Can be set when
	 * initialising (first creating) the resizable. Default:false
	 * 
	 * @param disabled
	 * @return
	 */
	public ResizableOptions disabled(boolean disabled) {
		super.put("disabled", disabled);
		return this;
	}

	/**
	 * Resize these elements synchronous when resizing.
	 * 
	 * @param selector
	 * @return
	 */
	public ResizableOptions alsoResize(CharSequence selector) {
		super.put("alsoResize", selector);
		return this;
	}

	/**
	 * Animates to the final size after resizing.
	 * 
	 * @param animate
	 * @return
	 */
	public ResizableOptions animate(boolean animate) {
		super.put("animate", animate);
		return this;
	}

	/**
	 * Duration time for animating, in milliseconds. Other possible values:
	 * 'slow', 'normal', 'fast'. Default:'slow'
	 * 
	 * @param duration
	 * @return
	 */
	public ResizableOptions animateDuration(int duration) {
		super.put("animateDuration", duration);
		return this;
	}

	/**
	 * Duration time for animating, in milliseconds. Other possible values:
	 * 'slow', 'normal', 'fast'. Default:'slow'
	 * 
	 * @param duration
	 * @return
	 */
	public ResizableOptions animateDuration(CharSequence duration) {
		super.put("animateDuration", duration);
		return this;
	}

	/**
	 * Easing effect for animating.
	 * 
	 * @param easing
	 * @return
	 */
	public ResizableOptions animateEasing(CharSequence easing) {
		super.put("animateEasing", easing);
		return this;
	}

	/**
	 * If set to true, resizing is constrained by the original aspect ratio.
	 * Otherwise a custom aspect ratio can be specified, such as 9 / 16, or 0.5.
	 * Default:false
	 * 
	 * @param aspectRatio
	 * @return
	 */
	public ResizableOptions aspectRatio(boolean aspectRatio) {
		super.put("aspectRatio", aspectRatio);
		return this;
	}

	/**
	 * If set to true, resizing is constrained by the original aspect ratio.
	 * Otherwise a custom aspect ratio can be specified, such as 9 / 16, or 0.5.
	 * Default:false
	 * 
	 * @param aspectRatio
	 * @return
	 */
	public ResizableOptions aspectRatio(float aspectRatio) {
		super.put("aspectRatio", aspectRatio);
		return this;
	}

	/**
	 * If set to true, automatically hides the handles except when the mouse
	 * hovers over the element. Default:false
	 * 
	 * @param autoHide
	 * @return
	 */
	public ResizableOptions autoHide(boolean autoHide) {
		super.put("autoHide", autoHide);
		return this;
	}

	/**
	 * Prevents resizing if you start on elements matching the selector.
	 * Default:':input,option'
	 * 
	 * @param selector
	 * @return
	 */
	public ResizableOptions cancel(CharSequence selector) {
		super.put("cancel", selector);
		return this;
	}

	/**
	 * Constrains resizing to within the bounds of the specified element.
	 * Possible values: 'parent', 'document', a DOMElement, or a Selector.
	 * Default:false
	 * 
	 * @param selector
	 * @return
	 */
	public ResizableOptions containment(CharSequence selector) {
		super.put("containment", selector);
		return this;
	}

	/**
	 * Tolerance, in milliseconds, for when resizing should start. If specified,
	 * resizing will not start until after mouse is moved beyond duration. This
	 * can help prevent unintended resizing when clicking on an element.
	 * Default:0
	 * 
	 * @param delay
	 * @return
	 */
	public ResizableOptions delay(int delay) {
		super.put("delay", delay);
		return this;
	}

	/**
	 * Tolerance, in pixels, for when resizing should start. If specified,
	 * resizing will not start until after mouse is moved beyond distance. This
	 * can help prevent unintended resizing when clicking on an element.
	 * Default:1
	 * 
	 * @param distance
	 * @return
	 */
	public ResizableOptions distance(int distance) {
		super.put("distance", distance);
		return this;
	}

	/**
	 * If set to true, a semi-transparent helper element is shown for resizing.
	 * Default:false
	 * 
	 * @param ghost
	 * @return
	 */
	public ResizableOptions ghost(int ghost) {
		super.put("ghost", ghost);
		return this;
	}

	/**
	 * Snaps the resizing element to a grid, every x and y pixels. Array values:
	 * [x, y]. Default:false
	 * 
	 * @param grid
	 * @return
	 */
	public ResizableOptions grid(XYPosition grid) {
		super.put("grid", grid);
		return this;
	}

	/**
	 * If specified as a string, should be a comma-split list of any of the
	 * following: 'n, e, s, w, ne, se, sw, nw, all'. The necessary handles will
	 * be auto-generated by the plugin. Default:'e, s, se'
	 * 
	 * 
	 * If specified as an object, the following keys are supported: { n, e, s,
	 * w, ne, se, sw, nw }. The value of any specified should be a jQuery
	 * selector matching the child element of the resizable to use as that
	 * handle. If the handle is not a child of the resizable, you can pass in
	 * the DOMElement or a valid jQuery object directly. Default:'e, s, se'
	 * 
	 * @param handles
	 * @return
	 */
	public ResizableOptions handles(CharSequence handles) {
		super.put("handles", handles);
		return this;
	}

	/**
	 * This is the css class that will be added to a proxy element to outline
	 * the resize during the drag of the resize handle. Once the resize is
	 * complete, the original element is sized. Default:false
	 * 
	 * @param helper
	 * @return
	 */
	public ResizableOptions helper(CharSequence helper) {
		super.put("helper", helper);
		return this;
	}

	/**
	 * This is the maximum height the resizable should be allowed to resize to.
	 * Default:null
	 * 
	 * @param maxHeight
	 * @return
	 */
	public ResizableOptions maxHeight(int maxHeight) {
		super.put("maxHeight", maxHeight);
		return this;
	}

	/**
	 * This is the maximum width the resizable should be allowed to resize to.
	 * Default:null
	 * 
	 * @param maxWidth
	 * @return
	 */
	public ResizableOptions maxWidth(int maxWidth) {
		super.put("maxWidth", maxWidth);
		return this;
	}

	/**
	 * This is the minimum height the resizable should be allowed to resize to.
	 * Default:10
	 * 
	 * @param minHeight
	 * @return
	 */
	public ResizableOptions minHeight(int minHeight) {
		super.put("minHeight", minHeight);
		return this;
	}

	/**
	 * This is the minimum width the resizable should be allowed to resize to.
	 * Default:10
	 * 
	 * @param minWidth
	 * @return
	 */
	public ResizableOptions minWidth(int minWidth) {
		super.put("minWidth", minWidth);
		return this;
	}

	/**
	 * This event is triggered at the start of a resize operation.
	 * 
	 * @param callbackBody
	 * @return
	 */
	public ResizableOptions startEvent(CharSequence callbackBody) {
		return this.startEvent(js(callbackBody));
	}

	/**
	 * This event is triggered at the start of a resize operation.
	 * 
	 * @param callbackBody
	 * @return
	 */
	public ResizableOptions startEvent(IJQStatement callbackBody) {
		return this.startEvent($f(callbackBody).withParams("event", "ui"));
	}

	/**
	 * This event is triggered at the start of a resize operation.
	 * 
	 * @param callback
	 * @return
	 */
	public ResizableOptions startEvent(IJQFunction callback) {
		super.put("start", callback);
		return this;
	}

	/**
	 * This event is triggered during the resize, on the drag of the resize
	 * handler.
	 * 
	 * @param callbackBody
	 * @return
	 */
	public ResizableOptions resizeEvent(CharSequence callbackBody) {
		return this.resizeEvent(js(callbackBody));
	}

	/**
	 * This event is triggered during the resize, on the drag of the resize
	 * handler.
	 * 
	 * @param callbackBody
	 * @return
	 */
	public ResizableOptions resizeEvent(IJQStatement callbackBody) {
		return this.resizeEvent($f(callbackBody).withParams("event", "ui"));
	}

	/**
	 * This event is triggered during the resize, on the drag of the resize
	 * handler.
	 * 
	 * @param callback
	 * @return
	 */
	public ResizableOptions resizeEvent(IJQFunction callback) {
		super.put("resize", callback);
		return this;
	}

	/**
	 * This event is triggered at the end of a resize operation.
	 * 
	 * @param callbackBody
	 * @return
	 */
	public ResizableOptions stopEvent(CharSequence callbackBody) {
		return this.stopEvent(js(callbackBody));
	}

	/**
	 * This event is triggered at the end of a resize operation.
	 * 
	 * @param callbackBody
	 * @return
	 */
	public ResizableOptions stopEvent(IJQStatement callbackBody) {
		return this.stopEvent($f(callbackBody).withParams("event", "ui"));
	}

	/**
	 * This event is triggered at the end of a resize operation.
	 * 
	 * @param callback
	 * @return
	 */
	public ResizableOptions stopEvent(IJQFunction callback) {
		super.put("stop", callback);
		return this;
	}
}
