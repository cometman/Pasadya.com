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
package com.google.code.jqwicket.ui.kwicks;


import com.google.code.jqwicket.api.AbstractJQOptions;
import org.apache.wicket.request.resource.CssResourceReference;
import org.apache.wicket.request.resource.JavaScriptResourceReference;

/**
 * @author mkalina
 */
public class KwicksOptions extends AbstractJQOptions<KwicksOptions> {

    private static final long serialVersionUID = 1L;

    public static final JavaScriptResourceReference JS_RESOURCE = new JavaScriptResourceReference(
            KwicksOptions.class, "jquery.kwicks-1.5.1.js");

    public static final JavaScriptResourceReference JS_RESOURCE_MIN = new JavaScriptResourceReference(
            KwicksOptions.class, "jquery.kwicks-1.5.1.pack.js");

    public static final CssResourceReference CSS_RESOURCE = new CssResourceReference(
            KwicksOptions.class, "kwicks.css");

    /**
     * Initialize default options with "max" value of 200.
     */
    public KwicksOptions() {
        super.put("max", 200);
        this.setJsResourceReferences(JS_RESOURCE);
        this.setJsResourceReferencesMin(JS_RESOURCE_MIN);
        this.setCssResourceReferences(CSS_RESOURCE);
    }

    /**
     * The width or height (in pixels) of a fully expanded kwick element. If isVertical is true, then max refers to the
     * height - otherwise it is the width.
     * <p/>
     * You must provide max OR min, but not both.
     *
     * @param max
     * @return
     */
    public KwicksOptions max(int max) {
        return super.put("max", max);
    }

    /**
     * The width or height (in pixels) of a fully collapsed kwick element. If isVertical is true, then min refers to the
     * height - otherwise it is the width.
     * <p/>
     * You must provide max OR min, but not both.
     *
     * @param min
     * @return
     */
    public KwicksOptions min(int min) {
        return super.put("min", min);
    }

    /**
     * Kwicks will align vertically if true. Defaults to false
     *
     * @param vertical
     * @return
     */
    public KwicksOptions vertical(boolean vertical) {
        return super.put("isVertical", vertical);
    }

    /**
     * One kwick will always be expanded if true. Defaults to false
     *
     * @param sticky
     * @return
     */
    public KwicksOptions sticky(boolean sticky) {
        return super.put("sticky", sticky);
    }

    /**
     * The initially expanded kwick (if and only if sticky is true). Note: Zero based, left-to-right (or top-to-bottom).
     * Defaults to 0
     *
     * @param defaultKwick
     * @return
     */
    public KwicksOptions defaultKwick(int defaultKwick) {
        return super.put("defaultKwick", defaultKwick);
    }

    /**
     * The event that triggers the expand effect. Other likely candidates are click and dblclick. Defaults to 'mouseover'
     *
     * @param event
     * @return
     */
    public KwicksOptions event(String event) {
        return super.put("event", event);
    }

    /**
     * The number of milliseconds required for each animation to complete. Defaults to 200
     *
     * @param duration
     * @return
     */
    public KwicksOptions duration(int duration) {
        return super.put("duration", duration);
    }

    /**
     * A custom easing function for the animation (requires easing plugin).
     *
     * @param easing
     * @return
     */
    public KwicksOptions easing(String easing) {
        return super.put("easing", easing);
    }

    /**
     * The width (in pixels) separating each kwick element. Defaults to 0
     *
     * @param spacing
     * @return
     */
    public KwicksOptions spacing(int spacing) {
        return super.put("spacing", spacing);
    }
}
