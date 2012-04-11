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
package com.google.code.jqwicket.ui.tiptip;

import com.google.code.jqwicket.api.AbstractJQOptions;
import com.google.code.jqwicket.api.IJQFunction;
import com.google.code.jqwicket.api.IJQStatement;
import org.apache.wicket.request.resource.CssResourceReference;
import org.apache.wicket.request.resource.JavaScriptResourceReference;

import static com.google.code.jqwicket.api.JQuery.$f;
import static com.google.code.jqwicket.api.JQuery.js;

/**
 * @author mkalina
 */
public class TipTipOptions extends AbstractJQOptions<TipTipOptions> {

    private static final long serialVersionUID = 1L;

    public static final JavaScriptResourceReference JS_RESOURCE = new JavaScriptResourceReference(
            TipTipOptions.class, "jquery.tipTip.js");

    public static final JavaScriptResourceReference JS_RESOURCE_MIN = new JavaScriptResourceReference(
            TipTipOptions.class, "jquery.tipTip.minified.js");

    public static final CssResourceReference CSS_RESOURCE = new CssResourceReference(
            TipTipOptions.class, "tipTip.css");

    public TipTipOptions() {
        this.setJsResourceReferences(JS_RESOURCE);
        this.setJsResourceReferencesMin(JS_RESOURCE_MIN);
        this.setCssResourceReferences(CSS_RESOURCE);
    }

    /**
     * ("hover" by default) - jQuery method TipTip is activated with. Can be set to: "hover", "focus" or "click".
     *
     * @param activation
     * @return
     */
    public TipTipOptions activation(CharSequence activation) {
        return super.put("activation", activation);
    }

    /**
     * (false by default) - When set to true the TipTip will only fadeout when you hover over the actual TipTip and then
     * hover off of it.
     *
     * @param keepAlive
     * @return
     */
    public TipTipOptions keepAlive(boolean keepAlive) {
        return super.put("keepAlive", keepAlive);
    }

    /**
     * ("200px" by default) - CSS max-width property for the TipTip element. This is a string so you can apply a percentage
     * rule or 'auto'.
     *
     * @param maxWidth
     * @return
     */
    public TipTipOptions maxWidth(CharSequence maxWidth) {
        return super.put("maxWidth", maxWidth);
    }

    /**
     * (3 by default) - Distances the TipTip popup from the element with TipTip applied to it by the number of pixels
     * specified.
     *
     * @param edgeOffset
     * @return
     */
    public TipTipOptions edgeOffset(int edgeOffset) {
        return super.put("edgeOffset", edgeOffset);
    }

    /**
     * ("bottom" by default) - Default orientation TipTip should show up as. You can set it to: "top", "bottom", "left" or
     * "right".
     *
     * @param defaultPosition
     * @return
     */
    public TipTipOptions defaultPosition(CharSequence defaultPosition) {
        return super.put("defaultPosition", defaultPosition);
    }

    /**
     * (400 by default) - Number of milliseconds to delay before showing the TipTip popup after you mouseover an element
     * with TipTip applied to it.
     *
     * @param delay
     * @return
     */
    public TipTipOptions delay(int delay) {
        return super.put("delay", delay);
    }

    /**
     * (200 by default) - Speed at which the TipTip popup will fade into view.
     *
     * @param fadeIn
     * @return
     */
    public TipTipOptions fadeIn(int fadeIn) {
        return super.put("fadeIn", fadeIn);
    }

    /**
     * (200 by default) - Speed at which the TipTip popup will fade out of view.
     *
     * @param fadeOut
     * @return
     */
    public TipTipOptions fadeOut(int fadeOut) {
        return super.put("fadeOut", fadeOut);
    }

    /**
     * ("title" by default) - HTML attribute that TipTip should pull it's content from.
     *
     * @param attribute
     * @return
     */
    public TipTipOptions attribute(CharSequence attribute) {
        return super.put("attribute", attribute);
    }

    /**
     * (false by default) - HTML or String to use as the content for TipTip. Will overwrite content from any HTML
     * attribute.
     *
     * @param content
     * @return
     */
    public TipTipOptions content(CharSequence content) {
        return super.put("content", content);
    }

    /**
     * Custom function that is run each time you mouseover an element with TipTip applied to it.
     *
     * @param callbackBody
     * @return
     */
    public TipTipOptions enterEvent(CharSequence callbackBody) {
        return this.enterEvent(js(callbackBody));
    }

    /**
     * Custom function that is run each time you mouseover an element with TipTip applied to it.
     *
     * @param callbackBody
     * @return
     */
    public TipTipOptions enterEvent(IJQStatement callbackBody) {
        return this.enterEvent($f(callbackBody));
    }

    /**
     * Custom function that is run each time you mouseover an element with TipTip applied to it.
     *
     * @param callback
     * @return
     */
    public TipTipOptions enterEvent(IJQFunction callback) {
        super.put("enter", callback);
        return this;
    }

    /**
     * Custom function that is run each time you mouseout of an element with TipTip applied to it.
     *
     * @param callbackBody
     * @return
     */
    public TipTipOptions exitEvent(CharSequence callbackBody) {
        return this.exitEvent(js(callbackBody));
    }

    /**
     * Custom function that is run each time you mouseout of an element with TipTip applied to it.
     *
     * @param callbackBody
     * @return
     */
    public TipTipOptions exitEvent(IJQStatement callbackBody) {
        return this.exitEvent($f(callbackBody));
    }

    /**
     * Custom function that is run each time you mouseout of an element with TipTip applied to it.
     *
     * @param callback
     * @return
     */
    public TipTipOptions exitEvent(IJQFunction callback) {
        super.put("exit", callback);
        return this;
    }

}
