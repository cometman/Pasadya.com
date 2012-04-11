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
 * Enumeration describing all possible jquery state events.
 * 
 * @author mkalina
 * 
 */
public enum StateEvent implements IJQEvent {

	BLUR, CHANGE, FOCUS, LOAD, SELECT, SUBMIT, ERROR, RESIZE, SCROLL;

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.event.IJQEvent#getName()
	 */
	public CharSequence getName() {
		return this.name().toLowerCase();
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
