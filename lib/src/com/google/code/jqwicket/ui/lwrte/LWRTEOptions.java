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
package com.google.code.jqwicket.ui.lwrte;

import com.google.code.jqwicket.Utils;
import com.google.code.jqwicket.api.AbstractJQOptions;
import com.google.code.jqwicket.api.JQLiteral;
import org.apache.wicket.request.resource.CssResourceReference;
import org.apache.wicket.request.resource.JavaScriptResourceReference;

/**
 * @author mkalina
 */
public class LWRTEOptions extends AbstractJQOptions<LWRTEOptions> {

    private static final long serialVersionUID = 1L;

    private static final JavaScriptResourceReference jsResource = new JavaScriptResourceReference(
            LWRTEOptions.class, "jquery.rte.js");

    private static final JavaScriptResourceReference jsDefaultToolbarResouce = new JavaScriptResourceReference(
            LWRTEOptions.class, "jquery.rte.tb.js");

    private static final CssResourceReference cssDefaultResouce = new CssResourceReference(
            LWRTEOptions.class, "jquery.rte.css");

    public LWRTEOptions() {
        this(jsDefaultToolbarResouce, cssDefaultResouce);
        this.css("default.css").controlsRte("rte_toolbar")
                .controlsHtml("html_toolbar");
    }

    public LWRTEOptions(JavaScriptResourceReference jsToolbarResource) {
        this(jsToolbarResource, cssDefaultResouce);
        this.css("default.css");
    }

    public LWRTEOptions(CssResourceReference cssResouce) {
        this(jsDefaultToolbarResouce, cssResouce);
        this.css("default.css").controlsRte("rte_toolbar")
                .controlsHtml("html_toolbar");
    }

    public LWRTEOptions(JavaScriptResourceReference jsToolbarResource,
                        CssResourceReference cssResouce) {
        this.setJsResourceReferences(jsResource, jsToolbarResource);
        this.setCssResourceReferences(cssResouce);
    }

    public LWRTEOptions css(CharSequence... css) {
        return super.put("css",
                Utils.walk(css, new Utils.IArrayWalkCallback<CharSequence>() {
                    public CharSequence onElement(int index, CharSequence obj) {
                        return JQLiteral._(obj);
                    }
                }));
    }

    public LWRTEOptions frameClass(CharSequence frameClass) {
        return super.put("frame_class", frameClass);
    }

    public LWRTEOptions baseUrl(CharSequence baseUrl) {
        return super.put("base_url", baseUrl);
    }

    public LWRTEOptions width(int width) {
        return super.put("width", width);
    }

    public LWRTEOptions width(CharSequence width) {
        return super.put("width", width);
    }

    public LWRTEOptions height(int height) {
        return super.put("height", height);
    }

    public LWRTEOptions height(CharSequence height) {
        return super.put("height", height);
    }

    public LWRTEOptions controlsRte(CharSequence controlsRte) {
        return super.put("controls_rte", JQLiteral._raw(controlsRte));
    }

    public LWRTEOptions controlsHtml(CharSequence controlsHtml) {
        return super.put("controls_html", JQLiteral._raw(controlsHtml));
    }
}
