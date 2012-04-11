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
package com.google.code.jqwicket.ui.jcarousel;

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
public class JCarouselOptions extends AbstractJQOptions<JCarouselOptions> {

    private static final long serialVersionUID = 1L;

    public static final JavaScriptResourceReference JS_RESOURCE = new JavaScriptResourceReference(
            JCarouselOptions.class, "jquery.jcarousel.js");

    public static final JavaScriptResourceReference JS_RESOURCE_MIN = new JavaScriptResourceReference(
            JCarouselOptions.class, "jquery.jcarousel.min.js");

    public static final CssResourceReference CSS_RESOURCE_TANGO = new CssResourceReference(
            JCarouselOptions.class, "skins/tango/skin.css");

    public static final CssResourceReference CSS_RESOURCE_IE7 = new CssResourceReference(
            JCarouselOptions.class, "skins/ie7/skin.css");

    public JCarouselOptions() {
        this.setJsResourceReferences(JS_RESOURCE);
        this.setJsResourceReferencesMin(JS_RESOURCE_MIN);
        this.setCssResourceReferences(CSS_RESOURCE_TANGO);
    }

    /**
     * Specifies wether the carousel appears in horizontal or vertical orientation. Changes the carousel from a
     * left/right style to a up/down style carousel. Default: false
     *
     * @param vertical
     * @return
     */
    public JCarouselOptions vertical(boolean vertical) {
        super.put("vertical", vertical);
        return this;
    }

    /**
     * Specifies wether the carousel appears in RTL (Right-To-Left) mode. Default: false
     *
     * @param rtl
     * @return
     */
    public JCarouselOptions rtl(boolean rtl) {
        super.put("rtl", rtl);
        return this;
    }

    /**
     * The index of the item to start with. Default: 1
     *
     * @param start
     * @return
     */
    public JCarouselOptions start(int start) {
        super.put("start", start);
        return this;
    }

    /**
     * The index of the first available item at initialisation. Default: 1
     *
     * @param offset
     * @return
     */
    public JCarouselOptions offset(int offset) {
        super.put("offset", offset);
        return this;
    }

    /**
     * The number of total items. Default: Number of existing <li>elements if size is not passed explicitly
     *
     * @param size
     * @return
     */
    public JCarouselOptions size(int size) {
        super.put("size", size);
        return this;
    }

    /**
     * The number of items to scroll by. Default: 3
     *
     * @param scroll
     * @return
     */
    public JCarouselOptions scroll(int scroll) {
        super.put("scroll", scroll);
        return this;
    }

    /**
     * If passed, the width/height of the items will be calculated and set depending on the width/height of the
     * clipping, so that exactly that number of items will be visible. Default: null
     *
     * @param visible
     * @return
     */
    public JCarouselOptions visible(int visible) {
        super.put("visible", visible);
        return this;
    }

    /**
     * The speed of the scroll animation as string in jQuery terms ("slow" or "fast") or milliseconds as integer (See
     * jQuery Documentation). If set to 0, animation is turned off. Default: "fast"
     *
     * @param speed
     * @return
     */
    public JCarouselOptions animation(CharSequence speed) {
        super.put("animation", speed);
        return this;
    }

    /**
     * The speed of the scroll animation as string in jQuery terms ("slow" or "fast") or milliseconds as integer (See
     * jQuery Documentation). If set to 0, animation is turned off. Default: "fast"
     *
     * @param speed
     * @return
     */
    public JCarouselOptions animation(int speed) {
        super.put("animation", speed);
        return this;
    }

    /**
     * The name of the easing effect that you want to use (See jQuery Documentation). Default: null
     *
     * @param easing
     * @return
     */
    public JCarouselOptions easing(CharSequence easing) {
        super.put("easing", easing);
        return this;
    }

    /**
     * Specifies how many seconds to periodically autoscroll the content. If set to 0 (default) then autoscrolling is
     * turned off. Default: 0
     *
     * @param auto
     * @return
     */
    public JCarouselOptions auto(int auto) {
        super.put("auto", auto);
        return this;
    }

    /**
     * Specifies whether to wrap at the first/last item (or both) and jump back to the start/end. Options are "first",
     * "last", "both" or "circular" as string. If set to null, wrapping is turned off (default). Default: null
     *
     * @param wrap
     * @return
     */
    public JCarouselOptions wrap(CharSequence wrap) {
        super.put("wrap", wrap);
        return this;
    }

    /**
     * The HTML markup for the auto-generated next button. If set to null, no next-button is created. Default:
     * &lt;div&gt;&lt;/div&gt;
     *
     * @param buttonNextHTML
     * @return
     */
    public JCarouselOptions buttonNextHTML(CharSequence buttonNextHTML) {
        super.put("buttonNextHTML", buttonNextHTML);
        return this;
    }

    /**
     * The HTML markup for the auto-generated prev button. If set to null, no prev-button is created. Default:
     * &lt;div&gt;&lt;/div&gt;
     *
     * @param buttonPrevHTML
     * @return
     */
    public JCarouselOptions buttonPrevHTML(CharSequence buttonPrevHTML) {
        super.put("buttonPrevHTML", buttonPrevHTML);
        return this;
    }

    /**
     * Specifies the event which triggers the next scroll. Default: "click"
     *
     * @param buttonNextEvent
     * @return
     */
    public JCarouselOptions buttonNextEvent(CharSequence buttonNextEvent) {
        super.put("buttonNextEvent", buttonNextEvent);
        return this;
    }

    /**
     * Specifies the event which triggers the prev scroll. Default: "click"
     *
     * @param buttonPrevEvent
     * @return
     */
    public JCarouselOptions buttonPrevEvent(CharSequence buttonPrevEvent) {
        super.put("buttonPrevEvent", buttonPrevEvent);
        return this;
    }

    /**
     * If, for some reason, jCarousel can not detect the width of an item, you can set a fallback dimension (width or
     * height, depending on the orientation) here to ensure correct calculations. Default: null
     *
     * @param itemFallbackDimension
     * @return
     */
    public JCarouselOptions itemFallbackDimension(int itemFallbackDimension) {
        super.put("itemFallbackDimension", itemFallbackDimension);
        return this;
    }

    /**
     * JavaScript function that is called right after initialisation of the carousel. Two parameters are passed: The
     * instance of the requesting carousel and the state of the carousel initialisation (init, reset or reload)
     *
     * @param callbackBody
     * @return
     */
    public JCarouselOptions initEvent(CharSequence callbackBody) {
        return this.initEvent(js(callbackBody));
    }

    /**
     * JavaScript function that is called right after initialisation of the carousel. Two parameters are passed: The
     * instance of the requesting carousel and the state of the carousel initialisation (init, reset or reload)
     *
     * @param callbackBody
     * @return
     */
    public JCarouselOptions initEvent(IJQStatement callbackBody) {
        return this.initEvent($f(callbackBody).withParams("carousel", "state"));
    }

    /**
     * JavaScript function that is called right after initialisation of the carousel. Two parameters are passed: The
     * instance of the requesting carousel and the state of the carousel initialisation (init, reset or reload)
     *
     * @param callback
     * @return
     */
    public JCarouselOptions initEvent(IJQFunction callback) {
        super.put("initCallback", callback);
        return this;
    }

    /**
     * JavaScript function that is called when the carousel requests a set of items to be loaded. Two parameters are
     * passed: The instance of the requesting carousel and the state of the carousel action (prev, next or init).
     * Alternatively, you can pass a hash of one or two functions which are triggered before and/or after animation.
     *
     * @param callbackBody
     * @return
     */
    public JCarouselOptions initLoadEvent(CharSequence callbackBody) {
        return this.initLoadEvent(js(callbackBody));
    }

    /**
     * JavaScript function that is called when the carousel requests a set of items to be loaded. Two parameters are
     * passed: The instance of the requesting carousel and the state of the carousel action (prev, next or init).
     * Alternatively, you can pass a hash of one or two functions which are triggered before and/or after animation.
     *
     * @param callbackBody
     * @return
     */
    public JCarouselOptions initLoadEvent(IJQStatement callbackBody) {
        return this.initLoadEvent($f(callbackBody).withParams("carousel",
                "state"));
    }

    /**
     * JavaScript function that is called when the carousel requests a set of items to be loaded. Two parameters are
     * passed: The instance of the requesting carousel and the state of the carousel action (prev, next or init).
     * Alternatively, you can pass a hash of one or two functions which are triggered before and/or after animation.
     *
     * @param callback
     * @return
     */
    public JCarouselOptions initLoadEvent(IJQFunction callback) {
        super.put("itemLoadCallback", callback);
        return this;
    }

    /**
     * JavaScript function that is called (after the scroll animation) when an item becomes the first one in the visible
     * range of the carousel. Four parameters are passed: The instance of the requesting carousel and the <li>object
     * itself, the index which indicates the position of the item in the list and the state of the carousel action
     * (prev, next or init). Alternatively, you can pass a hash of one or two functions which are triggered before
     * and/or after animation.
     *
     * @param callbackBody
     * @return
     */
    public JCarouselOptions itemFirstInEvent(CharSequence callbackBody) {
        return this.itemFirstInEvent(js(callbackBody));
    }

    /**
     * JavaScript function that is called (after the scroll animation) when an item becomes the first one in the visible
     * range of the carousel. Four parameters are passed: The instance of the requesting carousel and the
     * &lt;li&gt;object itself, the index which indicates the position of the item in the list and the state of the
     * carousel action (prev, next or init). Alternatively, you can pass a hash of one or two functions which are
     * triggered before and/or after animation.
     *
     * @param callbackBody
     * @return
     */
    public JCarouselOptions itemFirstInEvent(IJQStatement callbackBody) {
        return this.itemFirstInEvent($f(callbackBody).withParams("carousel",
                "obj", "indx", "state"));
    }

    /**
     * JavaScript function that is called (after the scroll animation) when an item becomes the first one in the visible
     * range of the carousel. Four parameters are passed: The instance of the requesting carousel and the <li>object
     * itself, the index which indicates the position of the item in the list and the state of the carousel action
     * (prev, next or init). Alternatively, you can pass a hash of one or two functions which are triggered before
     * and/or after animation.
     *
     * @param callback
     * @return
     */
    public JCarouselOptions itemFirstInEvent(IJQFunction callback) {
        super.put("itemFirstInCallback", callback);
        return this;
    }

    /**
     * JavaScript function that is called (after the scroll animation) when an item isn't longer the first one in the
     * visible range of the carousel. Four parameters are passed: The instance of the requesting carousel and the
     * <li>object itself, the index which indicates the position of the item in the list and the state of the carousel
     * action (prev, next or init). Alternatively, you can pass a hash of one or two functions which are triggered
     * before and/or after animation.
     *
     * @param callbackBody
     * @return
     */
    public JCarouselOptions itemFirstOutEvent(CharSequence callbackBody) {
        return this.itemFirstOutEvent(js(callbackBody));
    }

    /**
     * JavaScript function that is called (after the scroll animation) when an item isn't longer the first one in the
     * visible range of the carousel. Four parameters are passed: The instance of the requesting carousel and the
     * <li>object itself, the index which indicates the position of the item in the list and the state of the carousel
     * action (prev, next or init). Alternatively, you can pass a hash of one or two functions which are triggered
     * before and/or after animation.
     *
     * @param callbackBody
     * @return
     */
    public JCarouselOptions itemFirstOutEvent(IJQStatement callbackBody) {
        return this.itemFirstOutEvent($f(callbackBody).withParams("carousel",
                "obj", "indx", "state"));
    }

    /**
     * JavaScript function that is called (after the scroll animation) when an item isn't longer the first one in the
     * visible range of the carousel. Four parameters are passed: The instance of the requesting carousel and the
     * <li>object itself, the index which indicates the position of the item in the list and the state of the carousel
     * action (prev, next or init). Alternatively, you can pass a hash of one or two functions which are triggered
     * before and/or after animation.
     *
     * @param callback
     * @return
     */
    public JCarouselOptions itemFirstOutEvent(IJQFunction callback) {
        super.put("itemFirstOutCallback", callback);
        return this;
    }

    /**
     * JavaScript function that is called (after the scroll animation) when an item becomes the last one in the visible
     * range of the carousel. Four parameters are passed: The instance of the requesting carousel and the <li>object
     * itself, the index which indicates the position of the item in the list and the state of the carousel action
     * (prev, next or init). Alternatively, you can pass a hash of one or two functions which are triggered before
     * and/or after animation.
     *
     * @param callbackBody
     * @return
     */
    public JCarouselOptions itemLastInEvent(CharSequence callbackBody) {
        return this.itemLastInEvent(js(callbackBody));
    }

    /**
     * JavaScript function that is called (after the scroll animation) when an item becomes the last one in the visible
     * range of the carousel. Four parameters are passed: The instance of the requesting carousel and the <li>object
     * itself, the index which indicates the position of the item in the list and the state of the carousel action
     * (prev, next or init). Alternatively, you can pass a hash of one or two functions which are triggered before
     * and/or after animation.
     *
     * @param callbackBody
     * @return
     */
    public JCarouselOptions itemLastInEvent(IJQStatement callbackBody) {
        return this.itemLastInEvent($f(callbackBody).withParams("carousel",
                "obj", "indx", "state"));
    }

    /**
     * JavaScript function that is called (after the scroll animation) when an item becomes the last one in the visible
     * range of the carousel. Four parameters are passed: The instance of the requesting carousel and the <li>object
     * itself, the index which indicates the position of the item in the list and the state of the carousel action
     * (prev, next or init). Alternatively, you can pass a hash of one or two functions which are triggered before
     * and/or after animation.
     *
     * @param callback
     * @return
     */
    public JCarouselOptions itemLastInEvent(IJQFunction callback) {
        super.put("itemLastInCallback", callback);
        return this;
    }

    /**
     * JavaScript function that is called when an item isn't longer the last one in the visible range of the carousel.
     * Four parameters are passed: The instance of the requesting carousel and the <li>object itself, the index which
     * indicates the position of the item in the list and the state of the carousel action (prev, next or init).
     * Alternatively, you can pass a hash of one or two functions which are triggered before and/or after animation.
     *
     * @param callbackBody
     * @return
     */
    public JCarouselOptions itemLastOutEvent(CharSequence callbackBody) {
        return this.itemLastOutEvent(js(callbackBody));
    }

    /**
     * JavaScript function that is called when an item isn't longer the last one in the visible range of the carousel.
     * Four parameters are passed: The instance of the requesting carousel and the <li>object itself, the index which
     * indicates the position of the item in the list and the state of the carousel action (prev, next or init).
     * Alternatively, you can pass a hash of one or two functions which are triggered before and/or after animation.
     *
     * @param callbackBody
     * @return
     */
    public JCarouselOptions itemLastOutEvent(IJQStatement callbackBody) {
        return this.itemLastOutEvent($f(callbackBody).withParams("carousel",
                "obj", "indx", "state"));
    }

    /**
     * JavaScript function that is called when an item isn't longer the last one in the visible range of the carousel.
     * Four parameters are passed: The instance of the requesting carousel and the <li>object itself, the index which
     * indicates the position of the item in the list and the state of the carousel action (prev, next or init).
     * Alternatively, you can pass a hash of one or two functions which are triggered before and/or after animation.
     *
     * @param callback
     * @return
     */
    public JCarouselOptions itemLastOutEvent(IJQFunction callback) {
        super.put("itemLastOutCallback", callback);
        return this;
    }

    /**
     * JavaScript function that is called (after the scroll animation) when an item is in the visible range of the
     * carousel. Four parameters are passed: The instance of the requesting carousel and the <li>object itself, the
     * index which indicates the position of the item in the list and the state of the carousel action (prev, next or
     * init). Alternatively, you can pass a hash of one or two functions which are triggered before and/or after
     * animation.
     *
     * @param callbackBody
     * @return
     */
    public JCarouselOptions itemVisibleInEvent(CharSequence callbackBody) {
        return this.itemVisibleInEvent(js(callbackBody));
    }

    /**
     * JavaScript function that is called (after the scroll animation) when an item is in the visible range of the
     * carousel. Four parameters are passed: The instance of the requesting carousel and the <li>object itself, the
     * index which indicates the position of the item in the list and the state of the carousel action (prev, next or
     * init). Alternatively, you can pass a hash of one or two functions which are triggered before and/or after
     * animation.
     *
     * @param callbackBody
     * @return
     */
    public JCarouselOptions itemVisibleInEvent(IJQStatement callbackBody) {
        return this.itemVisibleInEvent($f(callbackBody).withParams("carousel",
                "obj", "indx", "state"));
    }

    /**
     * JavaScript function that is called (after the scroll animation) when an item is in the visible range of the
     * carousel. Four parameters are passed: The instance of the requesting carousel and the <li>object itself, the
     * index which indicates the position of the item in the list and the state of the carousel action (prev, next or
     * init). Alternatively, you can pass a hash of one or two functions which are triggered before and/or after
     * animation.
     *
     * @param callback
     * @return
     */
    public JCarouselOptions itemVisibleInEvent(IJQFunction callback) {
        super.put("itemVisibleInCallback", callback);
        return this;
    }

    /**
     * JavaScript function that is called (after the scroll animation) when an item isn't longer in the visible range of
     * the carousel. Four parameters are passed: The instance of the requesting carousel and the <li>object itself, the
     * index which indicates the position of the item in the list and the state of the carousel action (prev, next or
     * init). Alternatively, you can pass a hash of one or two functions which are triggered before and/or after
     * animation.
     *
     * @param callbackBody
     * @return
     */
    public JCarouselOptions itemVisibleOutEvent(CharSequence callbackBody) {
        return this.itemVisibleOutEvent(js(callbackBody));
    }

    /**
     * JavaScript function that is called (after the scroll animation) when an item isn't longer in the visible range of
     * the carousel. Four parameters are passed: The instance of the requesting carousel and the <li>object itself, the
     * index which indicates the position of the item in the list and the state of the carousel action (prev, next or
     * init). Alternatively, you can pass a hash of one or two functions which are triggered before and/or after
     * animation.
     *
     * @param callbackBody
     * @return
     */
    public JCarouselOptions itemVisibleOutEvent(IJQStatement callbackBody) {
        return this.itemVisibleOutEvent($f(callbackBody).withParams("carousel",
                "obj", "indx", "state"));
    }

    /**
     * JavaScript function that is called (after the scroll animation) when an item isn't longer in the visible range of
     * the carousel. Four parameters are passed: The instance of the requesting carousel and the <li>object itself, the
     * index which indicates the position of the item in the list and the state of the carousel action (prev, next or
     * init). Alternatively, you can pass a hash of one or two functions which are triggered before and/or after
     * animation.
     *
     * @param callback
     * @return
     */
    public JCarouselOptions itemVisibleOutEvent(IJQFunction callback) {
        super.put("itemVisibleOutCallback", callback);
        return this;
    }
}
