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
package com.google.code.jqwicket.ui;

import com.google.code.jqwicket.api.JQLiteral;

/**
 * @author mkalina
 * 
 */
public class XYPosition implements CharSequence {

	private JQLiteral buf;

	public XYPosition(int x, int y) {
		this.buf = JQLiteral._raw(new StringBuffer().append("[").append(x)
				.append(",").append(y).append("]"));
	}

	public int length() {
		return this.buf.length();
	}

	public char charAt(int index) {
		return this.buf.charAt(index);
	}

	public CharSequence subSequence(int start, int end) {
		return this.buf.subSequence(start, end);
	}

	@Override
	public String toString() {
		return String.valueOf(this.buf);
	}

}
