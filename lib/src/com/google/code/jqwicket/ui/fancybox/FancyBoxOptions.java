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
package com.google.code.jqwicket.ui.fancybox;

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
public class FancyBoxOptions extends AbstractJQOptions<FancyBoxOptions> {

    private static final long serialVersionUID = 1L;

    public static final JavaScriptResourceReference JS_RESOURCE = new JavaScriptResourceReference(
            FancyBoxOptions.class, "jquery.fancybox-1.3.4.js");

    public static final JavaScriptResourceReference JS_RESOURCE_MIN = new JavaScriptResourceReference(
            FancyBoxOptions.class, "jquery.fancybox-1.3.4.pack.js");

    public static final CssResourceReference CSS_RESOURCE = new CssResourceReference(
            FancyBoxOptions.class, "jquery.fancybox-1.3.4.css");

    public FancyBoxOptions() {
        this.setJsResourceReferences(JS_RESOURCE);
        this.setJsResourceReferencesMin(JS_RESOURCE_MIN);
        this.setCssResourceReferences(CSS_RESOURCE);
    }

    /**
     * Space between FancyBox wrapper and content.<br> Default: 10
     *
     * @param padding
     * @return
     */
    public FancyBoxOptions padding(int padding) {
        return super.put("padding", padding);
    }

    /**
     * Space between viewport and FancyBox wrapper<br> Default: 20
     *
     * @param margin
     * @return
     */
    public FancyBoxOptions margin(int margin) {
        return super.put("margin", margin);
    }

    /**
     * When true, transparency of content is changed for elastic transitions<br> Default: false
     *
     * @param opacity
     * @return
     */
    public FancyBoxOptions opacity(boolean opacity) {
        return super.put("opacity", opacity);
    }

    /**
     * When true, 'overlayShow' is set to 'true' and 'hideOnOverlayClick', 'hideOnContentClick', 'enableEscapeButton',
     * 'showCloseButton' are set to 'false'<br> Default: false
     *
     * @param modal
     * @return
     */
    public FancyBoxOptions modal(boolean modal) {
        return super.put("modal", modal);
    }

    /**
     * When true, galleries will be cyclic, allowing you to keep pressing next/back.<br> Default: false
     *
     * @param cyclic
     * @return
     */
    public FancyBoxOptions cyclic(boolean cyclic) {
        return super.put("cyclic", cyclic);
    }

    /**
     * Set the overflow CSS property to create or hide scrollbars. Can be set to 'auto', 'yes', or 'no'<br> Default:
     * auto
     *
     * @param scrolling
     * @return
     */
    public FancyBoxOptions scrolling(CharSequence scrolling) {
        return super.put("scrolling", scrolling);
    }

    /**
     * Width for content types 'iframe' and 'swf'. Also set for inline content if 'autoDimensions' is set to 'false'<br>
     * Default: 560
     *
     * @param width
     * @return
     */
    public FancyBoxOptions width(int width) {
        return super.put("width", width);
    }

    /**
     * Width for content types 'iframe' and 'swf'. Also set for inline content if 'autoDimensions' is set to 'false'<br>
     * Default: 560
     *
     * @param width
     * @return
     */
    public FancyBoxOptions width(CharSequence width) {
        return super.put("width", width);
    }

    /**
     * Height for content types 'iframe' and 'swf'. Also set for inline content if 'autoDimensions' is set to
     * 'false'<br> Default: 340
     *
     * @param height
     * @return
     */
    public FancyBoxOptions height(int height) {
        return super.put("height", height);
    }

    /**
     * Height for content types 'iframe' and 'swf'. Also set for inline content if 'autoDimensions' is set to
     * 'false'<br> Default: 340
     *
     * @param height
     * @return
     */
    public FancyBoxOptions height(CharSequence height) {
        return super.put("height", height);
    }

    /**
     * If true, FancyBox is scaled to fit in viewport<br> Default: true
     *
     * @param autoScale
     * @return
     */
    public FancyBoxOptions autoScale(boolean autoScale) {
        return super.put("autoScale", autoScale);
    }

    /**
     * or inline and ajax views, resizes the view to the element recieves. Make sure it has dimensions otherwise this
     * will give unexpected results<br> Default: true
     *
     * @param autoDimensions
     * @return
     */
    public FancyBoxOptions autoDimensions(boolean autoDimensions) {
        return super.put("autoDimensions", autoDimensions);
    }

    /**
     * When true, FancyBox is centered while scrolling page<br> Default: false
     *
     * @param centerOnScroll
     * @return
     */
    public FancyBoxOptions centerOnScroll(boolean centerOnScroll) {
        return super.put("centerOnScroll", centerOnScroll);
    }

    /**
     * Ajax options <br> Note: 'error' and 'success' will be overwritten by FancyBox <br> Default: {}
     *
     * @param ajax
     * @return
     */
    public FancyBoxOptions ajax(CharSequence ajax) {
        return super.put("ajax", ajax);
    }

    /**
     * Params to put on the swf object<br> Default: {wmode: 'transparent'}
     *
     * @param swf
     * @return
     */
    public FancyBoxOptions swf(CharSequence swf) {
        return super.put("swf", swf);
    }

    /**
     * Toggle if clicking the overlay should close FancyBox<br> Default: true
     *
     * @param hideOnOverlayClick
     * @return
     */
    public FancyBoxOptions hideOnOverlayClick(boolean hideOnOverlayClick) {
        return super.put("hideOnOverlayClick", hideOnOverlayClick);
    }

    /**
     * Toggle if clicking the content should close FancyBox<br> Default: false
     *
     * @param hideOnContentClick
     * @return
     */
    public FancyBoxOptions hideOnContentClick(boolean hideOnContentClick) {
        return super.put("hideOnContentClick", hideOnContentClick);
    }

    /**
     * Toggle overlay<br> Default: true
     *
     * @param overlayShow
     * @return
     */
    public FancyBoxOptions overlayShow(boolean overlayShow) {
        return super.put("overlayShow", overlayShow);
    }

    /**
     * Opacity of the overlay (from 0 to 1; default - 0.3)<br> Default: 0.3
     *
     * @param overlayOpacity
     * @return
     */
    public FancyBoxOptions overlayOpacity(float overlayOpacity) {
        return super.put("overlayOpacity", overlayOpacity);
    }

    /**
     * Color of the overlay<br> Default: '#666'
     *
     * @param overlayColor
     * @return
     */
    public FancyBoxOptions overlayColor(CharSequence overlayColor) {
        return super.put("overlayColor", overlayColor);
    }

    /**
     * Toggle title<br> Default: true
     *
     * @param titleShow
     * @return
     */
    public FancyBoxOptions titleShow(boolean titleShow) {
        return super.put("titleShow", titleShow);
    }

    /**
     * The position of title. Can be set to 'outside', 'inside' or 'over'<br> Default: 'outside'
     *
     * @param titlePosition
     * @return
     */
    public FancyBoxOptions titlePosition(CharSequence titlePosition) {
        return super.put("titlePosition", titlePosition);
    }

    /**
     * Callback to customize title area. You can set any html - custom image counter or even custom navigation
     *
     * @param callback
     * @return
     */
    public FancyBoxOptions titleFormat(IJQFunction callback) {
        return super.put("titleFormat", callback);
    }

    /**
     * Callback to customize title area. You can set any html - custom image counter or even custom navigation
     *
     * @param callbackBody
     * @return
     */
    public FancyBoxOptions titleFormat(IJQStatement callbackBody) {
        return this.titleFormat($f(callbackBody).withParams("title",
                "currentArray", "currentIndex", "currentOpts"));
    }

    /**
     * Callback to customize title area. You can set any html - custom image counter or even custom navigation
     *
     * @param callbackBody
     * @return
     */
    public FancyBoxOptions titleFormat(CharSequence callbackBody) {
        return this.titleFormat(js(callbackBody));
    }

    /**
     * The transition type. Can be set to 'elastic', 'fade' or 'none'<br> Default: fade
     *
     * @param transitionIn
     * @return
     */
    public FancyBoxOptions transitionIn(CharSequence transitionIn) {
        return super.put("transitionIn", transitionIn);
    }

    /**
     * The transition type. Can be set to 'elastic', 'fade' or 'none'<br> Default: fade
     *
     * @param transitionOut
     * @return
     */
    public FancyBoxOptions transitionOut(CharSequence transitionOut) {
        return super.put("transitionOut", transitionOut);
    }

    /**
     * Speed of the fade and elastic transitions, in milliseconds<br> Default: 300
     *
     * @param speedIn
     * @return
     */
    public FancyBoxOptions speedIn(int speedIn) {
        return super.put("speedIn", speedIn);
    }

    /**
     * Speed of the fade and elastic transitions, in milliseconds<br> Default: 300
     *
     * @param speedOut
     * @return
     */
    public FancyBoxOptions speedOut(int speedOut) {
        return super.put("speedOut", speedOut);
    }

    /**
     * Speed of resizing when changing gallery items, in milliseconds<br> Default: 300
     *
     * @param changeSpeed
     * @return
     */
    public FancyBoxOptions changeSpeed(int changeSpeed) {
        return super.put("changeSpeed", changeSpeed);
    }

    /**
     * Speed of the content fading while changing gallery items<br> Default: fast
     *
     * @param changeFade
     * @return
     */
    public FancyBoxOptions changeFade(CharSequence changeFade) {
        return super.put("changeFade", changeFade);
    }

    /**
     * Easing used for elastic animations<br> Default: swing
     *
     * @param easingIn
     * @return
     */
    public FancyBoxOptions easingIn(CharSequence easingIn) {
        return super.put("easingIn", easingIn);
    }

    /**
     * Easing used for elastic animations<br> Default: swing
     *
     * @param easingOut
     * @return
     */
    public FancyBoxOptions easingOut(CharSequence easingOut) {
        return super.put("easingOut", easingOut);
    }

    /**
     * Toggle close button<br> Default: true
     *
     * @param showCloseButton
     * @return
     */
    public FancyBoxOptions showCloseButton(boolean showCloseButton) {
        return super.put("showCloseButton", showCloseButton);
    }

    /**
     * Toggle navigation arrows<br> Default: true
     *
     * @param showNavArrows
     * @return
     */
    public FancyBoxOptions showNavArrows(boolean showNavArrows) {
        return super.put("showNavArrows", showNavArrows);
    }

    /**
     * Toggle if pressing Esc button closes FancyBox<br> Default: true
     *
     * @param enableEscapeButton
     * @return
     */
    public FancyBoxOptions enableEscapeButton(boolean enableEscapeButton) {
        return super.put("enableEscapeButton", enableEscapeButton);
    }

    /**
     * Forces content type. Can be set to 'image', 'ajax', 'iframe', 'swf' or 'inline'
     *
     * @param type
     * @return
     */
    public FancyBoxOptions type(CharSequence type) {
        return super.put("type", type);
    }

    /**
     * Forces content source
     *
     * @param href
     * @return
     */
    public FancyBoxOptions href(CharSequence href) {
        return super.put("href", href);
    }

    /**
     * Forces title
     *
     * @param title
     * @return
     */
    public FancyBoxOptions title(CharSequence title) {
        return super.put("title", title);
    }

    /**
     * Forces content (can be any html data)
     *
     * @param content
     * @return
     */
    public FancyBoxOptions content(CharSequence content) {
        return super.put("content", content);
    }

    /**
     * Sets object whos position and dimensions will be used by 'elastic' transition
     *
     * @param orig
     * @return
     */
    public FancyBoxOptions orig(CharSequence orig) {
        return super.put("orig", orig);
    }

    /**
     * Custom start index of manually created gallery
     *
     * @param index
     * @return
     */
    public FancyBoxOptions index(int index) {
        return super.put("index", index);
    }

    /**
     * Will be called right before attempting to load the content
     *
     * @param callbackBody
     * @return
     */
    public FancyBoxOptions startEvent(CharSequence callbackBody) {
        return this.startEvent(js(callbackBody));
    }

    /**
     * Will be called right before attempting to load the content
     *
     * @param callbackBody
     * @return
     */
    public FancyBoxOptions startEvent(IJQStatement callbackBody) {
        return this.startEvent($f(callbackBody));
    }

    /**
     * Will be called right before attempting to load the content
     *
     * @param callback
     * @return
     */
    public FancyBoxOptions startEvent(IJQFunction callback) {
        return super.put("onStart", callback);
    }

    /**
     * Will be called after loading is canceled
     *
     * @param callbackBody
     * @return
     */
    public FancyBoxOptions cancelEvent(CharSequence callbackBody) {
        return this.cancelEvent(js(callbackBody));
    }

    /**
     * Will be called after loading is canceled
     *
     * @param callbackBody
     * @return
     */
    public FancyBoxOptions cancelEvent(IJQStatement callbackBody) {
        return this.cancelEvent($f(callbackBody));
    }

    /**
     * Will be called after loading is canceled
     *
     * @param callback
     * @return
     */
    public FancyBoxOptions cancelEvent(IJQFunction callback) {
        return super.put("onCancel", callback);
    }

    /**
     * Will be called once the content is displayed
     *
     * @param callbackBody
     * @return
     */
    public FancyBoxOptions completeEvent(CharSequence callbackBody) {
        return this.completeEvent(js(callbackBody));
    }

    /**
     * Will be called once the content is displayed
     *
     * @param callbackBody
     * @return
     */
    public FancyBoxOptions completeEvent(IJQStatement callbackBody) {
        return this.completeEvent($f(callbackBody));
    }

    /**
     * Will be called once the content is displayed
     *
     * @param callback
     * @return
     */
    public FancyBoxOptions completeEvent(IJQFunction callback) {
        return super.put("onComplete", callback);
    }

    /**
     * Will be called just before closing
     *
     * @param callbackBody
     * @return
     */
    public FancyBoxOptions cleanupEvent(CharSequence callbackBody) {
        return this.cleanupEvent(js(callbackBody));
    }

    /**
     * Will be called just before closing
     *
     * @param callbackBody
     * @return
     */
    public FancyBoxOptions cleanupEvent(IJQStatement callbackBody) {
        return this.cleanupEvent($f(callbackBody));
    }

    /**
     * Will be called just before closing
     *
     * @param callback
     * @return
     */
    public FancyBoxOptions cleanupEvent(IJQFunction callback) {
        return super.put("onCleanup", callback);
    }

    /**
     * Will be called once FancyBox is closed
     *
     * @param callbackBody
     * @return
     */
    public FancyBoxOptions closedEvent(CharSequence callbackBody) {
        return this.closedEvent(js(callbackBody));
    }

    /**
     * Will be called once FancyBox is closed
     *
     * @param callbackBody
     * @return
     */
    public FancyBoxOptions closedEvent(IJQStatement callbackBody) {
        return this.closedEvent($f(callbackBody));
    }

    /**
     * Will be called once FancyBox is closed
     *
     * @param callback
     * @return
     */
    public FancyBoxOptions closedEvent(IJQFunction callback) {
        return super.put("onClosed", callback);
    }
}
