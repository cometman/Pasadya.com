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
package com.google.code.jqwicket.ui.droppable;

import com.google.code.jqwicket.api.AbstractJQOptions;
import com.google.code.jqwicket.api.IJQFunction;
import com.google.code.jqwicket.api.IJQStatement;

import static com.google.code.jqwicket.api.JQuery.$f;
import static com.google.code.jqwicket.api.JQuery.js;

/**
 * @author mkalina
 * 
 */
public class DroppableOptions extends AbstractJQOptions<DroppableOptions> {

	private static final long serialVersionUID = 1L;

	public enum Axis {
		X, Y;
	}

	public enum SnapMode {
		INNER, OUTER, BOTH;
	}

	/**
	 * Disables (true) or enables (false) the droppable. Can be set when
	 * initialising (first creating) the droppable. Default:false
	 * 
	 * @param disabled
	 * @return
	 */
	public DroppableOptions disabled(boolean disabled) {
		super.put("disabled", disabled);
		return this;
	}

	/**
	 * All draggables that match the selector will be accepted. If a function is
	 * specified, the function will be called for each draggable on the page
	 * (passed as the first argument to the function), to provide a custom
	 * filter. The function should return true if the draggable should be
	 * accepted. Default:'*'
	 * 
	 * @param selector
	 * @return
	 */
	public DroppableOptions accept(CharSequence selector) {
		super.put("accept", selector);
		return this;
	}

	/**
	 * All draggables that match the selector will be accepted. If a function is
	 * specified, the function will be called for each draggable on the page
	 * (passed as the first argument to the function), to provide a custom
	 * filter. The function should return true if the draggable should be
	 * accepted. Default:'*'
	 * 
	 * @param selector
	 * @return
	 */
	public DroppableOptions accept(IJQFunction callback) {
		super.put("accept", callback);
		return this;
	}

	/**
	 * If specified, the class will be added to the droppable while an
	 * acceptable draggable is being dragged. Default:false
	 * 
	 * @param selector
	 * @return
	 */
	public DroppableOptions activeClass(CharSequence selector) {
		super.put("activeClass", selector);
		return this;
	}

	/**
	 * If set to false, will prevent the ui-droppable class from being added.
	 * This may be desired as a performance optimization when calling
	 * .droppable() init on many hundreds of elements. Default:true
	 * 
	 * @param addClasses
	 * @return
	 */
	public DroppableOptions addClasses(boolean addClasses) {
		super.put("addClasses", addClasses);
		return this;
	}

	/**
	 * If true, will prevent event propagation on nested droppables.
	 * Default:false
	 * 
	 * @param greedy
	 * @return
	 */
	public DroppableOptions greedy(boolean greedy) {
		super.put("greedy", greedy);
		return this;
	}

	/**
	 * If specified, the class will be added to the droppable while an
	 * acceptable draggable is being hovered. Default:false
	 * 
	 * @param hoverClass
	 * @return
	 */
	public DroppableOptions hoverClass(CharSequence hoverClass) {
		super.put("hoverClass", hoverClass);
		return this;
	}

	/**
	 * Used to group sets of draggable and droppable items, in addition to
	 * droppable's accept option. A draggable with the same scope value as a
	 * droppable will be accepted. Default:'default'
	 * 
	 * @param scope
	 * @return
	 */
	public DroppableOptions scope(CharSequence scope) {
		super.put("scope", scope);
		return this;
	}

	/**
	 * Specifies which mode to use for testing whether a draggable is 'over' a
	 * droppable. Possible values: 'fit', 'intersect', 'pointer', 'touch'. <br>
	 * <br>
	 * fit: draggable overlaps the droppable entirely<br>
	 * intersect: draggable overlaps the droppable at least 50%<br>
	 * pointer: mouse pointer overlaps the droppable<br>
	 * touch: draggable overlaps the droppable any amount <br>
	 * Default:'intersect'
	 * 
	 * @param snapTolerance
	 * @return
	 */
	public DroppableOptions tolerance(CharSequence tolerance) {
		super.put("tolerance", tolerance);
		return this;
	}

	/**
	 * This event is triggered any time an accepted draggable starts dragging.
	 * This can be useful if you want to make the droppable 'light up' when it
	 * can be dropped on.
	 * 
	 * @param callbackBody
	 * @return
	 */
	public DroppableOptions activateEvent(CharSequence callbackBody) {
		return this.activateEvent(js(callbackBody));
	}

	/**
	 * This event is triggered any time an accepted draggable starts dragging.
	 * This can be useful if you want to make the droppable 'light up' when it
	 * can be dropped on.
	 * 
	 * @param callbackBody
	 * @return
	 */
	public DroppableOptions activateEvent(IJQStatement callbackBody) {
		return this.activateEvent($f(callbackBody).withParams("event", "ui"));
	}

	/**
	 * This event is triggered any time an accepted draggable starts dragging.
	 * This can be useful if you want to make the droppable 'light up' when it
	 * can be dropped on.
	 * 
	 * @param callback
	 * @return
	 */
	public DroppableOptions activateEvent(IJQFunction callback) {
		super.put("activate", callback);
		return this;
	}

	/**
	 * This event is triggered any time an accepted draggable stops dragging.
	 * 
	 * @param callbackBody
	 * @return
	 */
	public DroppableOptions deactivateEvent(CharSequence callbackBody) {
		return this.deactivateEvent(js(callbackBody));
	}

	/**
	 * This event is triggered any time an accepted draggable stops dragging.
	 * 
	 * @param callbackBody
	 * @return
	 */
	public DroppableOptions deactivateEvent(IJQStatement callbackBody) {
		return this.deactivateEvent($f(callbackBody).withParams("event", "ui"));
	}

	/**
	 * This event is triggered any time an accepted draggable stops dragging.
	 * 
	 * @param callback
	 * @return
	 */
	public DroppableOptions deactivateEvent(IJQFunction callback) {
		super.put("deactivate", callback);
		return this;
	}

	/**
	 * This event is triggered as an accepted draggable is dragged 'over'
	 * (within the tolerance of) this droppable.
	 * 
	 * @param callbackBody
	 * @return
	 */
	public DroppableOptions overEvent(CharSequence callbackBody) {
		return this.overEvent(js(callbackBody));
	}

	/**
	 * This event is triggered as an accepted draggable is dragged 'over'
	 * (within the tolerance of) this droppable.
	 * 
	 * @param callbackBody
	 * @return
	 */
	public DroppableOptions overEvent(IJQStatement callbackBody) {
		return this.overEvent($f(callbackBody).withParams("event", "ui"));
	}

	/**
	 * This event is triggered as an accepted draggable is dragged 'over'
	 * (within the tolerance of) this droppable.
	 * 
	 * @param callback
	 * @return
	 */
	public DroppableOptions overEvent(IJQFunction callback) {
		super.put("over", callback);
		return this;
	}

	/**
	 * This event is triggered when an accepted draggable is dragged out (within
	 * the tolerance of) this droppable.
	 * 
	 * @param callbackBody
	 * @return
	 */
	public DroppableOptions outEvent(CharSequence callbackBody) {
		return this.outEvent(js(callbackBody));
	}

	/**
	 * This event is triggered when an accepted draggable is dragged out (within
	 * the tolerance of) this droppable.
	 * 
	 * @param callbackBody
	 * @return
	 */
	public DroppableOptions outEvent(IJQStatement callbackBody) {
		return this.outEvent($f(callbackBody).withParams("event", "ui"));
	}

	/**
	 * This event is triggered when an accepted draggable is dragged out (within
	 * the tolerance of) this droppable.
	 * 
	 * @param callback
	 * @return
	 */
	public DroppableOptions outEvent(IJQFunction callback) {
		super.put("out", callback);
		return this;
	}

	/**
	 * This event is triggered when an accepted draggable is dropped 'over'
	 * (within the tolerance of) this droppable. In the callback, $(this)
	 * represents the droppable the draggable is dropped on. ui.draggable
	 * represents the draggable.
	 * 
	 * @param callbackBody
	 * @return
	 */
	public DroppableOptions dropEvent(CharSequence callbackBody) {
		return this.dropEvent(js(callbackBody));
	}

	/**
	 * This event is triggered when an accepted draggable is dropped 'over'
	 * (within the tolerance of) this droppable. In the callback, $(this)
	 * represents the droppable the draggable is dropped on. ui.draggable
	 * represents the draggable.
	 * 
	 * @param callbackBody
	 * @return
	 */
	public DroppableOptions dropEvent(IJQStatement callbackBody) {
		return this.dropEvent($f(callbackBody).withParams("event", "ui"));
	}

	/**
	 * This event is triggered when an accepted draggable is dropped 'over'
	 * (within the tolerance of) this droppable. In the callback, $(this)
	 * represents the droppable the draggable is dropped on. ui.draggable
	 * represents the draggable.
	 * 
	 * @param callback
	 * @return
	 */
	public DroppableOptions dropEvent(IJQFunction callback) {
		super.put("drop", callback);
		return this;
	}

}
