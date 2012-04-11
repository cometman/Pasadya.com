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
package com.google.code.jqwicket.ui.prettycomments;


import com.google.code.jqwicket.api.AbstractJQOptions;
import org.apache.wicket.request.resource.JavaScriptResourceReference;

/**
 * @author mkalina
 */
public class PrettyCommentsOptions extends
        AbstractJQOptions<PrettyCommentsOptions> {

    private static final long serialVersionUID = 1L;

    private static final JavaScriptResourceReference jsResource = new JavaScriptResourceReference(
            PrettyCommentsOptions.class, "prettyComments.js");

    private static final JavaScriptResourceReference jsResourceMin = new JavaScriptResourceReference(
            PrettyCommentsOptions.class, "prettyComments.min.js");

    public PrettyCommentsOptions() {
        this.setJsResourceReferences(jsResource);
        this.setJsResourceReferencesMin(jsResourceMin);
    }

    /**
     * Sets animation enabled/disabled
     *
     * @param animate
     * @return
     */
    public PrettyCommentsOptions animate(boolean animate) {
        return super.put("animate", animate);
    }

    /**
     * Sets animation speed: 'slow'/'normal'/'fast'
     *
     * @param animationSpeed
     * @return
     */
    public PrettyCommentsOptions animationSpeed(CharSequence animationSpeed) {
        return super.put("animationSpeed", animationSpeed);
    }

    /**
     * Sets max. height
     *
     * @param maxHeight
     * @return
     */
    public PrettyCommentsOptions maxHeight(int maxHeight) {
        return super.put("maxHeight", maxHeight);
    }
}
