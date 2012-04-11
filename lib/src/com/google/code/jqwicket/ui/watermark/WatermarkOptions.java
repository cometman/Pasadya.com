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
package com.google.code.jqwicket.ui.watermark;


import com.google.code.jqwicket.api.AbstractJQOptions;
import org.apache.wicket.request.resource.JavaScriptResourceReference;

/**
 * @author mkalina
 */
public class WatermarkOptions extends AbstractJQOptions<WatermarkOptions> {

    private static final long serialVersionUID = 1L;

    public static final JavaScriptResourceReference JS_RESOURCE = new JavaScriptResourceReference(
            WatermarkOptions.class, "jquery.watermark.js");

    public static final JavaScriptResourceReference JS_RESOURCE_MIN = new JavaScriptResourceReference(
            WatermarkOptions.class, "jquery.watermark.min.js");

    private CharSequence text;

    public WatermarkOptions(CharSequence text) {
        this.setJsResourceReferences(JS_RESOURCE);
        this.setJsResourceReferencesMin(JS_RESOURCE_MIN);
        this.text = text;
    }

    public WatermarkOptions className(String className) {
        return super.put("className", className);
    }

    public WatermarkOptions useNative(boolean useNative) {
        return super.put("useNative", useNative);
    }

    /**
     * The hideBeforeUnload option can be set to false to disable the automatic hiding of watermarks during the
     * beforeunload event. It is a global option that determines the behavior of all watermarks on the current page. The
     * option is not evaluated until the beforeunload event takes place, so the option can be set at any point before that.
     * The default value for this option is true.
     *
     * @param hideBeforeUnload
     * @return
     */
    public WatermarkOptions hideBeforeUnload(boolean hideBeforeUnload) {
        return super.put("hideBeforeUnload", hideBeforeUnload);
    }

    public CharSequence getText() {
        return text;
    }

}
