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
package com.google.code.jqwicket.ui.nivoslider;

import com.google.code.jqwicket.api.AbstractJQOptions;
import com.google.code.jqwicket.api.IJQFunction;
import com.google.code.jqwicket.api.IJQStatement;
import org.apache.wicket.request.resource.CssResourceReference;
import org.apache.wicket.request.resource.JavaScriptResourceReference;

import static com.google.code.jqwicket.api.JQLiteral._;
import static com.google.code.jqwicket.api.JQuery.$f;
import static com.google.code.jqwicket.api.JQuery.js;

/**
 * @author mkalina
 */
public class NivoSliderOptions extends AbstractJQOptions<NivoSliderOptions> {

    private static final long serialVersionUID = 1L;

    public static final JavaScriptResourceReference JS_RESOURCE = new JavaScriptResourceReference(
            NivoSliderOptions.class, "jquery.nivo.slider.js");

    public static final JavaScriptResourceReference JS_RESOURCE_MIN = new JavaScriptResourceReference(
            NivoSliderOptions.class, "jquery.nivo.slider.pack.js");

    public static final CssResourceReference CSS_RESOURCE = new CssResourceReference(
            NivoSliderOptions.class, "nivo-slider.css");

    public enum Effect {

        SLICE_DOWN(_("sliceDown")), SLICE_DOWN_LEFT(_("sliceDownLeft")), SLICE_UP(
                _("sliceUp")), SLICE_UP_LEFT(_("sliceUpLeft")), SLICE_UP_DOWN(
                _("sliceUpDown")), SLICE_UP_DOWN_LEFT(_("sliceUpDownLeft")), FOLD(
                _("fold")), FADE(_("fade")), RANDOM(_("random")), SLIDE_IN_RIGHT(
                _("slideInRight")), SLIDE_IN_LEFT(_("slideInLeft")), BOX_RANDOM(
                _("boxRandom")), BOX_RAIN(_("boxRain")), BOX_RAIN_REVERSE(
                _("boxRainReverse")), BOX_RAIN_GROW(_("boxRainGrow")), BOX_RAIN_GROW_REVERSE(
                _("boxRainGrowReverse"));

        private CharSequence effect;

        private Effect(CharSequence effect) {
            this.effect = effect;
        }

    }

    public NivoSliderOptions() {
        this.setJsResourceReferences(JS_RESOURCE);
        this.setJsResourceReferencesMin(JS_RESOURCE_MIN);
        this.setCssResourceReferences(CSS_RESOURCE);
    }

    /**
     * Specify sets like: 'fold,fade,sliceDown'
     *
     * @param effects
     * @return
     */
    public NivoSliderOptions effect(Effect... effects) {
        CharSequence[] se = new CharSequence[effects.length];
        for (int i = 0; i < effects.length; i++) {
            se[i] = effects[i].effect;
        }
        return super.put("effect", se);
    }

    /**
     * For slice animations
     *
     * @param slices
     * @return
     */
    public NivoSliderOptions slices(int slices) {
        return super.put("slices", slices);
    }

    /**
     * For box animations.
     *
     * @param boxCols
     * @return
     */
    public NivoSliderOptions boxCols(int boxCols) {
        return super.put("boxCols", boxCols);
    }

    /**
     * For box animations
     *
     * @param boxRows
     * @return
     */
    public NivoSliderOptions boxRows(int boxRows) {
        return super.put("boxRows", boxRows);
    }

    /**
     * Slide transition speed
     *
     * @param animSpeed
     * @return
     */
    public NivoSliderOptions animSpeed(int animSpeed) {
        return super.put("animSpeed", animSpeed);
    }

    /**
     * How long each slide will show
     *
     * @param pauseTime
     * @return
     */
    public NivoSliderOptions pauseTime(int pauseTime) {
        return super.put("pauseTime", pauseTime);
    }

    /**
     * Set starting Slide (0 index)
     *
     * @param startSlide
     * @return
     */
    public NivoSliderOptions startSlide(int startSlide) {
        return super.put("startSlide", startSlide);
    }

    /**
     * Next & Prev navigation
     *
     * @param directionNav
     * @return
     */
    public NivoSliderOptions directionNav(boolean directionNav) {
        return super.put("directionNav", directionNav);
    }

    /**
     * Only show on hover
     *
     * @param directionNavHide
     * @return
     */
    public NivoSliderOptions directionNavHide(boolean directionNavHide) {
        return super.put("directionNavHide", directionNavHide);
    }

    /**
     * 1,2,3... navigation
     *
     * @param controlNav
     * @return
     */
    public NivoSliderOptions controlNav(boolean controlNav) {
        return super.put("controlNav", controlNav);
    }

    /**
     * Use thumbnails for Control Nav
     *
     * @param controlNavThumbs
     * @return
     */
    public NivoSliderOptions controlNavThumbs(boolean controlNavThumbs) {
        return super.put("controlNavThumbs", controlNavThumbs);
    }

    /**
     * Use image rel for thumbs
     *
     * @param controlNavThumbsFromRel
     * @return
     */
    public NivoSliderOptions controlNavThumbsFromRel(
            boolean controlNavThumbsFromRel) {
        return super.put("controlNavThumbsFromRel", controlNavThumbsFromRel);
    }

    /**
     * Replace this with...
     *
     * @param controlNavThumbsSearch
     * @return
     */
    public NivoSliderOptions controlNavThumbsSearch(
            CharSequence controlNavThumbsSearch) {
        super.put("controlNavThumbsSearch", controlNavThumbsSearch);
        return this;
    }

    /**
     * ...this in thumb Image src
     *
     * @param controlNavThumbsReplace
     * @return
     */
    public NivoSliderOptions controlNavThumbsReplace(
            CharSequence controlNavThumbsReplace) {
        super.put("controlNavThumbsReplace", controlNavThumbsReplace);
        return this;
    }

    /**
     * Use left & right arrows
     *
     * @param keyboardNav
     * @return
     */
    public NivoSliderOptions keyboardNav(boolean keyboardNav) {
        super.put("keyboardNav", keyboardNav);
        return this;
    }

    /**
     * Stop animation while hovering
     *
     * @param pauseOnHover
     * @return
     */
    public NivoSliderOptions pauseOnHover(boolean pauseOnHover) {
        super.put("pauseOnHover", pauseOnHover);
        return this;
    }

    /**
     * Force manual transitions
     *
     * @param manualAdvance
     * @return
     */
    public NivoSliderOptions manualAdvance(boolean manualAdvance) {
        super.put("manualAdvance", manualAdvance);
        return this;
    }

    /**
     * Universal caption opacity
     *
     * @param captionOpacity
     * @return
     */
    public NivoSliderOptions captionOpacity(float captionOpacity) {
        super.put("captionOpacity", captionOpacity);
        return this;
    }

    /**
     * Prev directionNav text
     *
     * @param prevText
     * @return
     */
    public NivoSliderOptions prevText(CharSequence prevText) {
        super.put("prevText", prevText);
        return this;
    }

    /**
     * Next directionNav text
     *
     * @param nextText
     * @return
     */
    public NivoSliderOptions nextText(CharSequence nextText) {
        super.put("nextText", nextText);
        return this;
    }

    /**
     * Fires before change
     *
     * @param callbackBody
     * @return
     */
    public NivoSliderOptions beforeChangeEvent(CharSequence callbackBody) {
        return this.beforeChangeEvent(js(callbackBody));
    }

    /**
     * Fires before change
     *
     * @param callbackBody
     * @return
     */
    public NivoSliderOptions beforeChangeEvent(IJQStatement callbackBody) {
        return this.beforeChangeEvent($f(callbackBody));
    }

    /**
     * Fires before change.
     *
     * @param callback
     * @return
     */
    public NivoSliderOptions beforeChangeEvent(IJQFunction callback) {
        super.put("beforeChange", callback);
        return this;
    }

    /**
     * Fires after change
     *
     * @param callbackBody
     * @return
     */
    public NivoSliderOptions afterChangeEvent(CharSequence callbackBody) {
        return this.afterChangeEvent(js(callbackBody));
    }

    /**
     * Fires after change
     *
     * @param callbackBody
     * @return
     */
    public NivoSliderOptions afterChangeEvent(IJQStatement callbackBody) {
        return this.afterChangeEvent($f(callbackBody));
    }

    /**
     * Fires after change
     *
     * @param callback
     * @return
     */
    public NivoSliderOptions afterChangeEvent(IJQFunction callback) {
        super.put("afterChange", callback);
        return this;
    }

    /**
     * Triggers after all slides have been shown
     *
     * @param callbackBody
     * @return
     */
    public NivoSliderOptions slideshowEndEvent(CharSequence callbackBody) {
        return this.slideshowEndEvent(js(callbackBody));
    }

    /**
     * Triggers after all slides have been shown
     *
     * @param callbackBody
     * @return
     */
    public NivoSliderOptions slideshowEndEvent(IJQStatement callbackBody) {
        return this.slideshowEndEvent($f(callbackBody));
    }

    /**
     * Triggers after all slides have been shown
     *
     * @param callback
     * @return
     */
    public NivoSliderOptions slideshowEndEvent(IJQFunction callback) {
        super.put("slideshowEnd", callback);
        return this;
    }

    /**
     * Triggers when last slide is shown
     *
     * @param callbackBody
     * @return
     */
    public NivoSliderOptions lastSlideEvent(CharSequence callbackBody) {
        return this.lastSlideEvent(js(callbackBody));
    }

    /**
     * Triggers when last slide is shown
     *
     * @param callbackBody
     * @return
     */
    public NivoSliderOptions lastSlideEvent(IJQStatement callbackBody) {
        return this.lastSlideEvent($f(callbackBody));
    }

    /**
     * Triggers when last slide is shown
     *
     * @param callback
     * @return
     */
    public NivoSliderOptions lastSlideEvent(IJQFunction callback) {
        super.put("lastSlide", callback);
        return this;
    }

    /**
     * Triggers when slider has loaded
     *
     * @param callbackBody
     * @return
     */
    public NivoSliderOptions afterLoadEvent(CharSequence callbackBody) {
        return this.afterLoadEvent(js(callbackBody));
    }

    /**
     * Triggers when slider has loaded
     *
     * @param callbackBody
     * @return
     */
    public NivoSliderOptions afterLoadEvent(IJQStatement callbackBody) {
        return this.afterLoadEvent($f(callbackBody));
    }

    /**
     * Triggers when slider has loaded
     *
     * @param callback
     * @return
     */
    public NivoSliderOptions afterLoadEvent(IJQFunction callback) {
        super.put("afterLoad", callback);
        return this;
    }

}
