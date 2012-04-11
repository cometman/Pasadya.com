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
package com.google.code.jqwicket.ui.guider;

import com.google.code.jqwicket.Utils;
import com.google.code.jqwicket.api.AbstractJQOptions;
import com.google.code.jqwicket.api.S;
import org.apache.wicket.Component;
import org.apache.wicket.request.resource.CssResourceReference;
import org.apache.wicket.request.resource.JavaScriptResourceReference;

/**
 * @author mkalina
 */
public class GuiderOptions extends AbstractJQOptions<GuiderOptions> {

    private static final long serialVersionUID = 1L;

    public static final JavaScriptResourceReference JS_RESOURCE = new JavaScriptResourceReference(
            GuiderOptions.class, "guiders-1.1.2.js");

    public static final CssResourceReference CSS_RESOURCE = new CssResourceReference(
            GuiderOptions.class, "guiders-1.1.2.css");

    public GuiderOptions() {
        this.setJsResourceReferences(JS_RESOURCE);
        this.setCssResourceReferences(CSS_RESOURCE);
    }

    public GuiderOptions attachTo(CharSequence selector) {
        return super.put("attachTo", selector);
    }

    public GuiderOptions attachTo(Component component) {
        return super.put("attachTo", S.id(component));
    }

    public GuiderOptions buttons(GuiderButton... buttons) {
        return super.put("buttons", buttons);
    }

    public GuiderOptions description(CharSequence description) {
        return super.put("description", description);
    }

    public GuiderOptions descriptionI18N(CharSequence descriptionKey,
                                         CharSequence... args) {
        return description(Utils.i18n(descriptionKey, args));
    }

    public GuiderOptions descriptionI18N(CharSequence descriptionKey,
                                         Component component, CharSequence... args) {
        return description(Utils.i18n(descriptionKey, component, args));
    }

    public GuiderOptions id(CharSequence id) {
        return super.put("id", id);
    }

    public GuiderOptions overlay(boolean overlay) {
        return super.put("overlay", overlay);
    }

    public GuiderOptions buttonCustomHTML(CharSequence buttonCustomHTML) {
        return super.put("buttonCustomHTML", buttonCustomHTML);
    }

    public GuiderOptions next(CharSequence id) {
        return super.put("next", id);
    }

    /**
     * 1-12 follows an analog clock, 0 means centered
     *
     * @param position
     * @return
     */
    public GuiderOptions position(int position) {
        return super.put("position", position);
    }

    public GuiderOptions title(CharSequence title) {
        return super.put("title", title);
    }

    public GuiderOptions titleI18N(CharSequence titleKey, CharSequence... args) {
        return title(Utils.i18n(titleKey, args));
    }

    public GuiderOptions titleI18N(CharSequence titleKey, Component component,
                                   CharSequence... args) {
        return title(Utils.i18n(titleKey, component, args));
    }

    public GuiderOptions width(int width) {
        return super.put("width", width);
    }
}
