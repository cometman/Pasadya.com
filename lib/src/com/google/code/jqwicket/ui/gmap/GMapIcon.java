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
public class GMapIcon extends AbstractJQOptions<GMapIcon> {

	private static final long serialVersionUID = 1L;

	/**
	 * Full path to a image that indicates the marker on the map.<br>
	 * Default: http://www.google.com/mapfiles/marker.png
	 * 
	 * @param image
	 * @return
	 */
	public GMapIcon image(CharSequence image) {
		return super.put("image", image);
	}

	/**
	 * Full path to a image that indicates the shadow for the marker image on a
	 * map. This property is optional (e.g. your image already includes a drop
	 * shadow).<br>
	 * Default: http://www.google.com/mapfiles/shadow50.png
	 * 
	 * @param shadow
	 * @return
	 */
	public GMapIcon shadow(CharSequence shadow) {
		return super.put("shadow", shadow);
	}

	public GMapIcon longitude(float longitude) {
		return super.put("longitude", longitude);
	}

	/**
	 * A simple array of integer values for width and height valid for "image".<br>
	 * Default: [20, 34]
	 * 
	 * @param iconsize
	 * @return
	 */
	public GMapIcon iconsize(int... iconsize) {
		return super.put("iconsize", iconsize);
	}

	/**
	 * A simple array of integer values for width and height valid for "shadow".<br>
	 * Default: [37, 34]
	 * 
	 * @param shadowsize
	 * @return
	 */
	public GMapIcon shadowsize(int... shadowsize) {
		return super.put("shadowsize", shadowsize);
	}

	/**
	 * The pixel coordinate relative to the top left corner of the icon image at
	 * which this icon is anchored to the map.<br>
	 * Default: [9, 34]
	 * 
	 * @param iconanchor
	 * @return
	 */
	public GMapIcon iconanchor(int... iconanchor) {
		return super.put("iconanchor", iconanchor);
	}

	/**
	 * The pixel coordinate relative to the top left corner of the icon image at
	 * which the info window is anchored to this icon.<br>
	 * Default: [9, 2]
	 * 
	 * @param infowindowanchor
	 * @return
	 */
	public GMapIcon infowindowanchor(int... infowindowanchor) {
		return super.put("infowindowanchor", infowindowanchor);
	}

}
