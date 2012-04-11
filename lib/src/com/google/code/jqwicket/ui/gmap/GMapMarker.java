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
package com.google.code.jqwicket.ui.gmap;

import com.google.code.jqwicket.api.AbstractJQOptions;

/**
 * @author mkalina
 * 
 */
public class GMapMarker extends AbstractJQOptions<GMapMarker> {

	private static final long serialVersionUID = 1L;

	/**
	 * Address where the marker will be drawn
	 * 
	 * @param address
	 * @return
	 */
	public GMapMarker address(CharSequence address) {
		return super.put("address", address);
	}

	/**
	 * Point (latitude) on the map where the marker will be drawn
	 * 
	 * @param latitude
	 * @return
	 */
	public GMapMarker latitude(float latitude) {
		return super.put("latitude", latitude);
	}

	/**
	 * Point (longitude) on the map where the marker will be drawn
	 * 
	 * @param longitude
	 * @return
	 */
	public GMapMarker longitude(float longitude) {
		return super.put("longitude", longitude);
	}

	/**
	 * Content that will be shown within the info window for this marker. If
	 * empty no info window will be shown when the user clicks the marker.<br>
	 * Default: ""
	 * 
	 * @param html
	 * @return
	 */
	public GMapMarker html(CharSequence html) {
		return super.put("html", html);
	}

	/**
	 * If true the info window for this marker will be shown when the map
	 * finished loading. If "html" is empty this option will be ignored.<br>
	 * Default: false
	 * 
	 * @param popup
	 * @return
	 */
	public GMapMarker popup(boolean popup) {
		return super.put("popup", popup);
	}

	/**
	 * Subset of properties for defining a custom image for the current marker.
	 * Please see the global "icon" property below for a list of options.
	 * 
	 * @param icon
	 * @return
	 */
	public GMapMarker icon(GMapIcon icon) {
		return super.put("icon", icon);
	}

}
