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
package com.google.code.jqwicket.ui.maskedinput;

import com.google.code.jqwicket.api.AbstractJQOptions;
import com.google.code.jqwicket.api.IJQFunction;
import com.google.code.jqwicket.api.IJQStatement;
import org.apache.wicket.request.resource.JavaScriptResourceReference;

import static com.google.code.jqwicket.api.JQuery.$f;
import static com.google.code.jqwicket.api.JQuery.js;

/**
 * @author mkalina
 */
public class MaskedInputOptions extends AbstractJQOptions<MaskedInputOptions> {

    private static final long serialVersionUID = 1L;

    public static final JavaScriptResourceReference JS_RESOURCE = new JavaScriptResourceReference(
            MaskedInputOptions.class, "jquery.maskedinput-1.3.js");

    public static final JavaScriptResourceReference JS_RESOURCE_MIN = new JavaScriptResourceReference(
            MaskedInputOptions.class, "jquery.maskedinput-1.3.min.js");

    private CharSequence mask;

    public MaskedInputOptions(CharSequence mask) {
        this.setJsResourceReferences(JS_RESOURCE);
        this.setJsResourceReferencesMin(JS_RESOURCE_MIN);
        this.mask = mask;
    }

    /**
     * @return the mask
     */
    public CharSequence getMask() {
        return mask;
    }

    /**
     * Sets placeholder
     *
     * @param placeholder
     * @return
     */
    public MaskedInputOptions placeholder(CharSequence placeholder) {
        super.put("placeholder", placeholder);
        return this;
    }

    /**
     * Triggers once the mask has been completed
     *
     * @param callbackBody
     * @return
     */
    public MaskedInputOptions completedEvent(CharSequence callbackBody) {
        return this.completedEvent(js(callbackBody));
    }

    /**
     * Triggers once the mask has been completed
     *
     * @param callbackBody
     * @return
     */
    public MaskedInputOptions completedEvent(IJQStatement callbackBody) {
        return this.completedEvent($f(callbackBody));
    }

    /**
     * Triggers once the mask has been completed
     *
     * @param callback
     * @return
     */
    public MaskedInputOptions completedEvent(IJQFunction callback) {
        super.put("completed", callback);
        return this;
    }

}
