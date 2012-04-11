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
package com.google.code.jqwicket.event;

/**
 * Enumeration describing all possible jquery mouse events.
 * 
 * @author mkalina
 * 
 */
public enum MouseEvent implements IJQEvent {

	CLICK("click"), //
	DBLCLICK("dblclick"), //
	FOCUSIN("focusin"), //
	FOCUSOUT("focusout"), //
	HOVER("hover"), //
	DOWN("mousedown"), //
	ENTER("mouseenter"), //
	LEAVE("mouseleave"), //
	MOVE("mousemove"), //
	OUT("mouseout"), //
	OVER("mouseover"), //
	UP("mouseup"), //
	TOGGLE("toggle");

	private CharSequence event;

	private MouseEvent(CharSequence event) {
		this.event = event;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.event.IJQEvent#getName()
	 */
	public CharSequence getName() {
		return this.event;
	}

	public int length() {
		return this.getName().length();
	}

	public char charAt(int index) {
		return this.getName().charAt(index);
	}

	public CharSequence subSequence(int start, int end) {
		return this.getName().subSequence(start, end);
	}

}
