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
package com.google.code.jqwicket.ui.mb.extruder;

import com.google.code.jqwicket.Utils;
import com.google.code.jqwicket.api.AbstractJQOptions;
import com.google.code.jqwicket.api.IJQFunction;
import com.google.code.jqwicket.api.IJQStatement;
import com.google.code.jqwicket.api.JQOptions;
import com.google.code.jqwicket.ui.mb.fliptext.FlipTextOptions;
import org.apache.wicket.request.resource.CssResourceReference;
import org.apache.wicket.request.resource.JavaScriptResourceReference;

import static com.google.code.jqwicket.api.JQuery.$f;
import static com.google.code.jqwicket.api.JQuery.js;

/**
 * @author mkalina
 */
public class ExtruderOptions extends AbstractJQOptions<ExtruderOptions> {

    private static final long serialVersionUID = 1L;

    public static final JavaScriptResourceReference JS_METADATA_RESOURCE = new JavaScriptResourceReference(
            ExtruderOptions.class, "jquery.metadata.js");

    public static final JavaScriptResourceReference JS_HOVER_RESOURCE = new JavaScriptResourceReference(
            ExtruderOptions.class, "jquery.hoverIntent.min.js");

    public static final JavaScriptResourceReference JS_EXTRUDER_RESOURCE = new JavaScriptResourceReference(
            ExtruderOptions.class, "mbExtruder.js");

    public static final JavaScriptResourceReference JS_FLIPTEXT_RESOURCE = new JavaScriptResourceReference(
            FlipTextOptions.class, "jquery.mb.flipText.js");

    public static final CssResourceReference CSS_RESOURCE = new CssResourceReference(
            ExtruderOptions.class, "css/mbExtruder.css");

    public enum Position {

        TOP, LEFT, RIGHT, BOTTOM;

    }

    public enum TextOrientation {

        TB, BT;

    }

    private CharSequence title;

    private CharSequence url;

    public ExtruderOptions(CharSequence title) {
        this(title, null);
    }

    public ExtruderOptions(CharSequence title, CharSequence url) {
        this.setJsResourceReferences(JS_METADATA_RESOURCE, JS_HOVER_RESOURCE,
                JS_FLIPTEXT_RESOURCE, JS_EXTRUDER_RESOURCE);
        this.setCssResourceReferences(CSS_RESOURCE);
        this.title = title;
        this.url = url;
    }

    public CharSequence getTitle() {
        return title;
    }

    public CharSequence getUrl() {
        return url;
    }

    public CharSequence getExtruderClass() {
        JQOptions opt = new JQOptions().put("title", this.title);
        if (Utils.isNotBlank(this.url))
            opt.put("url", this.url);
        return opt;
    }

    public ExtruderOptions positionFixed(boolean positionFixed) {
        return super.put("positionFixed", positionFixed);
    }

    /**
     * the width of the sliding panel<br> Default: 350
     *
     * @param width
     * @return
     */
    public ExtruderOptions width(int width) {
        return super.put("width", width);
    }

    /**
     * the time in milliseconds to wait befor the slider will open without a click event<br> Default: 800
     *
     * @param sensibility
     * @return
     */
    public ExtruderOptions sensibility(int sensibility) {
        return super.put("sensibility", sensibility);
    }

    /**
     * to define if the slider is on top, left, right or bottom of your page <br> Default: top
     *
     * @param position
     * @return
     */
    public ExtruderOptions position(Position position) {
        return super.put("position", position.name().toLowerCase());
    }

    /**
     * the opacity of the sliding panel once it’s closed (doesn’t work in IE)<br> Default: 1
     *
     * @param extruderOpacity
     * @return
     */
    public ExtruderOptions extruderOpacity(float extruderOpacity) {
        return super.put("extruderOpacity", extruderOpacity);
    }

    /**
     * the width or height (depends on the extruder position) of the flap containing the title<br> Default: 100
     *
     * @param flapDim
     * @return
     */
    public ExtruderOptions flapDim(int flapDim) {
        return super.put("flapDim", flapDim);
    }

    public ExtruderOptions flapMargin(int flapMargin) {
        return super.put("flapMargin", flapMargin);
    }

    /**
     * &ldquo;tb&rdquo;, or &ldquo;bt&rdquo; the orientation of the text for titles in the left panel flaps
     *
     * @param textOrientation
     * @return
     */
    public ExtruderOptions textOrientation(TextOrientation textOrientation) {
        return super.put("textOrientation", textOrientation.name()
                .toLowerCase());
    }

    /**
     * the time in milliseconds for the slide transition<br> Default: 300
     *
     * @param slideTimer
     * @return
     */
    public ExtruderOptions slideTimer(int slideTimer) {
        return super.put("slideTimer", slideTimer);
    }

    /**
     * define if last subpanel should stay opened or not on next extruder open<br> Default:true
     *
     * @param hidePanelsOnClose
     * @return
     */
    public ExtruderOptions hidePanelsOnClose(boolean hidePanelsOnClose) {
        return super.put("hidePanelsOnClose", hidePanelsOnClose);
    }

    /**
     * define the time in milliseconds the extruder should close on mouse out; 0=never<br> Default: 0
     *
     * @param autoCloseTime
     * @return
     */
    public ExtruderOptions autoCloseTime(int autoCloseTime) {
        return super.put("autoCloseTime", autoCloseTime);
    }

    /**
     * define top positiony<br> Default: auto
     *
     * @param top
     * @return
     */
    public ExtruderOptions top(int top) {
        return super.put("top", top);
    }

    public ExtruderOptions accordionPanels(boolean accordionPanels) {
        return super.put("accordionPanels", accordionPanels);
    }

    public ExtruderOptions onExtOpenEvent(CharSequence callbackBody) {
        return this.onExtOpenEvent(js(callbackBody));
    }

    public ExtruderOptions onExtOpenEvent(IJQStatement callbackBody) {
        return this.onExtOpenEvent($f(callbackBody));
    }

    public ExtruderOptions onExtOpenEvent(IJQFunction callback) {
        super.put("onExtOpen", callback);
        return this;
    }

    public ExtruderOptions onExtContentLoadEvent(CharSequence callbackBody) {
        return this.onExtContentLoadEvent(js(callbackBody));
    }

    public ExtruderOptions onExtContentLoadEvent(IJQStatement callbackBody) {
        return this.onExtContentLoadEvent($f(callbackBody));
    }

    public ExtruderOptions onExtContentLoadEvent(IJQFunction callback) {
        super.put("onExtContentLoad", callback);
        return this;
    }

    public ExtruderOptions onExtCloseEvent(CharSequence callbackBody) {
        return this.onExtCloseEvent(js(callbackBody));
    }

    public ExtruderOptions onExtCloseEvent(IJQStatement callbackBody) {
        return this.onExtCloseEvent($f(callbackBody));
    }

    public ExtruderOptions onExtCloseEvent(IJQFunction callback) {
        super.put("onExtClose", callback);
        return this;
    }
}
