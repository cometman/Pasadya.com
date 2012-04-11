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
import com.google.code.jqwicket.api.JQLiteral;
import org.apache.wicket.request.resource.JavaScriptResourceReference;

/**
 * @author mkalina
 */
public class GMapOptions extends AbstractJQOptions<GMapOptions> {

    private static final long serialVersionUID = 1L;

    public static final JavaScriptResourceReference JS_RESOURCE = new JavaScriptResourceReference(
            GMapOptions.class, "jquery.gmap-1.1.0.js");

    public static final JavaScriptResourceReference JS_RESOURCE_MIN = new JavaScriptResourceReference(
            GMapOptions.class, "jquery.gmap-1.1.0-min.js");

    public enum MapType {

        /**
         * displays the default road map view.
         */
        G_NORMAL_MAP,

        /**
         * displays Google Earth satellite images
         */
        G_SATELLITE_MAP,

        /**
         * isplays a mixture of normal and satellite views
         */
        G_HYBRID_MAP,

        /**
         * displays a physical map based on terrain information
         */
        G_PHYSICAL_MAP;

    }

    public enum ControlType {

        GSMALLMAPCONTROL("GSmallMapControl"), GLARGEMAPCONTROL(
                "GLargeMapControl"), GSMALLZOOMCONTROL("GSmallZoomControl"), GLARGEMAPCONTROL3D(
                "GLargeMapControl3D"), GSMALLZOOMCONTROL3D(
                "GSmallZoomControl3D"), GSCALECONTROL("GScaleControl"), GMAPTYPECONTROL(
                "GMapTypeControl"), GMENUMAPTYPECONTROL("GMenuMapTypeControl"), GHIERARCHICALMAPTYPECONTROL(
                "GHierarchicalMapTypeControl"), GOVERVIEWMAPCONTROL(
                "GOverviewMapControl"), GNAVLABELCONTROL("GNavLabelControl");

        private CharSequence control;

        private ControlType(CharSequence control) {
            this.control = control;
        }

        public CharSequence render() {
            return this.control;
        }

        public CharSequence render(boolean withTrailingSemicolon) {
            throw new UnsupportedOperationException(
                    "Method render(withTrailingSemicolon) is not supported!");
        }

    }

    private CharSequence apiKey;

    public GMapOptions(CharSequence apiKey) {
        this.apiKey = apiKey;
        this.setJsResourceReferences(JS_RESOURCE);
        this.setJsResourceReferencesMin(JS_RESOURCE_MIN);
    }

    public CharSequence getApiKey() {
        return apiKey;
    }

    /**
     * Address on which the viewport will be centered.<br> Default: ""
     *
     * @param address
     * @return
     */
    public GMapOptions address(CharSequence address) {
        return super.put("address", address);
    }

    /**
     * Point (latitude) on which the viewport will be centered. If not given and no markers are defined the viewport
     * defaults to world view.<br> Default: 0
     *
     * @param latitude
     * @return
     */
    public GMapOptions latitude(float latitude) {
        return super.put("latitude", latitude);
    }

    /**
     * Point (longitude) on which the viewport will be centered. If not given and no markers are defined the viewport
     * defaults to world view.<br> Default: 0
     *
     * @param longitude
     * @return
     */
    public GMapOptions longitude(float longitude) {
        return super.put("longitude", longitude);
    }

    /**
     * Zoom value from 1 to 19 where 19 is the greatest and 1 the smallest.<br> Default: 1
     *
     * @param zoom
     * @return
     */
    public GMapOptions zoom(int zoom) {
        return super.put("zoom", zoom);
    }

    /**
     * List of points beeing marked on the map. Every entry in this array has to be in JSON. If at least one entry is given
     * the viewport will be centered to the first point/address.<br> Default: []
     *
     * @param markers
     * @return
     */
    public GMapOptions markers(GMapMarker... markers) {
        return super.put("markers", markers);
    }

    /**
     * @param controls
     * @return
     */
    public GMapOptions controls(boolean controls) {
        return super.put("controls", controls);
    }

    /**
     * A simple array of string values representing the function names (without "()") to add controls. Please refer to the
     * Google Maps API for possible values. If empty the default map controls will be applied.<br> Default: []
     *
     * @param controls
     * @return
     */
    public GMapOptions controls(ControlType... controls) {
        CharSequence[] csCOntrols = new CharSequence[controls.length];
        for (int i = 0; i < controls.length; i++) {
            csCOntrols[i] = controls[i].control;
        }
        return super.put("controls", csCOntrols);
    }

    /**
     * Set to false to disable zooming with your mouses scrollwheel. If "controls" is not set this option will be ignored
     * (because default map controls are applied).<br> Default: true
     *
     * @param scrollwheel
     * @return
     */
    public GMapOptions scrollwheel(boolean scrollwheel) {
        return super.put("scrollwheel", scrollwheel);
    }

    /**
     * Predefined variable for setting the map type.<br> Default: G_NORMAL_MAP
     *
     * @param type
     * @return
     */
    public GMapOptions maptype(MapType type) {
        return super.put("maptype", JQLiteral._raw(type));
    }

    /**
     * HTML string to get prepended to a marker's info window. Useful for styling through CSS<br> Default: <div
     * class="gmap_marker">
     *
     * @param html_prepend
     * @return
     */
    public GMapOptions html_prepend(CharSequence html_prepend) {
        return super.put("html_prepend", html_prepend);
    }

    /**
     * HTML string to get appended to a marker's info window.<br> Default: </div>
     *
     * @param html_append
     * @return
     */
    public GMapOptions html_append(CharSequence html_append) {
        return super.put("html_append", html_append);
    }

    /**
     * Subset of properties for defining a custom marker image for all markers.
     *
     * @param icon
     * @return
     */
    public GMapOptions icon(GMapIcon icon) {
        return super.put("icon", icon);
    }
}
