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
package com.google.code.jqwicket;

import com.google.code.jqwicket.ui.cloudzoom.CloudZoomImage;
import com.google.code.jqwicket.ui.cloudzoom.CloudZoomImagePanel;
import com.google.code.jqwicket.ui.cloudzoom.CloudZoomOptions;

/**
 * @author mkalina
 * 
 */
public class CloudZoomPage extends DemoPage {

	public CloudZoomPage() {

		add(new CloudZoomImagePanel("cloudZoom", new CloudZoomOptions(
				new CloudZoomImage("_images/cloudzoom/bigimage.jpg",
						"_images/cloudzoom/smallimage.jpg")).adjustX(10)
				.adjustY(-4).softFocus(true).tint("#123").showTitle(true)));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.DemoPage#getExampleTitle()
	 */
	@Override
	protected String getExampleTitle() {
		return "JQuery CloudZoom Plugin example";
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.DemoPage#getExampleDescription()
	 */
	@Override
	protected String getExampleDescription() {
		return null;
	}

}
