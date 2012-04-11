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
package com.google.code.jqwicket.ui.prettypopin;

import com.google.code.jqwicket.api.AbstractJQOptions;
import com.google.code.jqwicket.api.IJQFunction;
import com.google.code.jqwicket.api.IJQStatement;
import org.apache.wicket.request.cycle.RequestCycle;
import org.apache.wicket.request.resource.CssResourceReference;
import org.apache.wicket.request.resource.JavaScriptResourceReference;

import static com.google.code.jqwicket.api.JQuery.$f;
import static com.google.code.jqwicket.api.JQuery.js;

/**
 * @author mkalina
 */
public class PrettyPopinOptions extends AbstractJQOptions<PrettyPopinOptions> {

    private static final long serialVersionUID = 1L;

    private static final JavaScriptResourceReference jsResource = new JavaScriptResourceReference(
            PrettyPopinOptions.class, "js/jquery.prettyPopin.js");

    private static final JavaScriptResourceReference jsResourceMin = new JavaScriptResourceReference(
            PrettyPopinOptions.class, "js/jquery.prettyPopin.min.js");

    private static final CssResourceReference cssResource = new CssResourceReference(
            PrettyPopinOptions.class, "css/prettyPopin.css");

    private static final CssResourceReference ajaxloaderGif = new CssResourceReference(
            PrettyPopinOptions.class, "images/prettyPopin/loader.gif");

    public PrettyPopinOptions() {
        this.setJsResourceReferences(jsResource);
        this.setJsResourceReferencesMin(jsResourceMin);
        this.setCssResourceReferences(cssResource);
        this.loader_path(RequestCycle.get().urlFor(ajaxloaderGif, null));
    }

    public PrettyPopinOptions modal(boolean modal) {
        return super.put("modal", modal);
    }

    public PrettyPopinOptions width(boolean width) {
        return super.put("width", width);
    }

    public PrettyPopinOptions width(int width) {
        return super.put("width", width);
    }

    public PrettyPopinOptions height(boolean height) {
        return super.put("height", height);
    }

    public PrettyPopinOptions height(int height) {
        return super.put("height", height);
    }

    public PrettyPopinOptions opacity(float opacity) {
        return super.put("opacity", opacity);
    }

    /**
     * Animation speed: slow/medium/fast<br/> Default: fast
     *
     * @param animationSpeed
     * @return
     */
    public PrettyPopinOptions animationSpeed(CharSequence animationSpeed) {
        return super.put("animationSpeed", animationSpeed);
    }

    public PrettyPopinOptions animationSpeed(int animationSpeed) {
        return super.put("animationSpeed", animationSpeed);
    }

    public PrettyPopinOptions followScroll(boolean followScroll) {
        return super.put("followScroll", followScroll);
    }

    public PrettyPopinOptions loader_path(CharSequence loaderPath) {
        return super.put("loader_path", loaderPath);
    }

    /**
     * callback called when closing the popin
     *
     * @param callbackBody
     * @return
     */
    public PrettyPopinOptions callback(CharSequence callbackBody) {
        return this.callback(js(callbackBody));
    }

    /**
     * callback called when closing the popin
     *
     * @param callbackBody
     * @return
     */
    public PrettyPopinOptions callback(IJQStatement callbackBody) {
        return this.callback($f(callbackBody));
    }

    /**
     * callback called when closing the popin
     *
     * @param callback
     * @return
     */
    public PrettyPopinOptions callback(IJQFunction callback) {
        return super.put("callback", callback);
    }

}
