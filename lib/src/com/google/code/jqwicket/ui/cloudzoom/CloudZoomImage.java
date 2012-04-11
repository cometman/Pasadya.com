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
package com.google.code.jqwicket.ui.cloudzoom;

import java.io.Serializable;

/**
 * @author mkalina
 * 
 */
public class CloudZoomImage implements Serializable {

	private static final long serialVersionUID = 1L;

	private CharSequence bigImageUrl;

	private CharSequence smallImageUrl;

	private CharSequence imageTitle;

	private CharSequence imageAlt;

	public CloudZoomImage(CharSequence bigImageUrl, CharSequence smallImageUrl) {
		this(bigImageUrl, smallImageUrl, null, null);
	}

	public CloudZoomImage(CharSequence bigImageUrl, CharSequence smallImageUrl,
			CharSequence imageTitle, CharSequence imageAlt) {
		this.bigImageUrl = bigImageUrl;
		this.smallImageUrl = smallImageUrl;
		this.imageTitle = imageTitle;
		this.imageAlt = imageAlt;
	}

	public CharSequence getBigImageUrl() {
		return bigImageUrl;
	}

	public CharSequence getSmallImageUrl() {
		return smallImageUrl;
	}

	public CharSequence getImageTitle() {
		return imageTitle;
	}

	public CharSequence getImageAlt() {
		return imageAlt;
	}

}
