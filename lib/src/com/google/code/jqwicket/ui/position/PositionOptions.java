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
package com.google.code.jqwicket.ui.position;

import com.google.code.jqwicket.api.AbstractJQOptions;
import com.google.code.jqwicket.api.IJQFunction;

/**
 * @author mkalina
 * 
 */
public class PositionOptions extends AbstractJQOptions<PositionOptions> {

	private static final long serialVersionUID = 1L;

	/**
	 * Defines which position on the element being positioned to align with the
	 * target element: "horizontal vertical" alignment. A single value such as
	 * "right" will default to "right center", "top" will default to
	 * "center top" (following CSS convention). Acceptable values: "top",
	 * "center", "bottom", "left", "right". Example: "left top" or
	 * "center center"
	 * 
	 * @param selector
	 * @return
	 */
	public PositionOptions my(CharSequence my) {
		super.put("my", my);
		return this;
	}

	/**
	 * Defines which position on the target element to align the positioned
	 * element against: "horizontal vertical" alignment. A single value such as
	 * "right" will default to "right center", "top" will default to
	 * "center top" (following CSS convention). Acceptable values: "top",
	 * "center", "bottom", "left", "right". Example: "left top" or
	 * "center center"
	 * 
	 * @param at
	 * @return
	 */
	public PositionOptions at(CharSequence at) {
		super.put("at", at);
		return this;
	}

	/**
	 * Element to position against. If you provide a selector, the first
	 * matching element will be used. If you provide a jQuery object, the first
	 * element will be used. If you provide an event object, the pageX and pageY
	 * properties will be used. Example: "#top-menu"
	 * 
	 * @param selector
	 * @return
	 */
	public PositionOptions of(CharSequence selector) {
		super.put("of", selector);
		return this;
	}

	/**
	 * Add these left-top values to the calculated position, eg. "50 50" (left
	 * top) A single value such as "50" will apply to both.
	 * 
	 * @param offset
	 * @return
	 */
	public PositionOptions offset(CharSequence offset) {
		super.put("offset", offset);
		return this;
	}

	/**
	 * When the positioned element overflows the window in some direction, move
	 * it to an alternative position. Similar to my and at, this accepts a
	 * single value or a pair for horizontal/vertical, eg. "flip", "fit",
	 * "fit flip", "fit none". <br>
	 * <br>
	 * flip: to the opposite side and the collision detection is run again to
	 * see if it will fit. If it won't fit in either position, the center option
	 * should be used as a fall back.<br>
	 * fit: so the element keeps in the desired direction, but is re-positioned
	 * so it fits.<br>
	 * none: not do collision detection.
	 * 
	 * @param collision
	 * @return
	 */
	public PositionOptions collision(CharSequence collision) {
		super.put("collision", collision);
		return this;
	}

	/**
	 * When specified the actual property setting is delegated to this callback.
	 * Receives a single parameter which is a hash of top and left values for
	 * the position that should be set.
	 * 
	 * @param callback
	 * @return
	 */
	public PositionOptions using(IJQFunction callback) {
		super.put("using", callback);
		return this;
	}

}
