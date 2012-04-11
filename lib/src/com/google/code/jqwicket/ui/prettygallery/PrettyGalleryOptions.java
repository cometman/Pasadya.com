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
package com.google.code.jqwicket.ui.prettygallery;


import com.google.code.jqwicket.api.AbstractJQOptions;
import org.apache.wicket.request.resource.CssResourceReference;
import org.apache.wicket.request.resource.JavaScriptResourceReference;

/**
 * @author mkalina
 */
public class PrettyGalleryOptions extends
        AbstractJQOptions<PrettyGalleryOptions> {

    private static final long serialVersionUID = 1L;

    private static final JavaScriptResourceReference jsResource = new JavaScriptResourceReference(
            PrettyGalleryOptions.class, "js/jquery.prettyGallery.js");

    private static final JavaScriptResourceReference jsResourceMin = new JavaScriptResourceReference(
            PrettyGalleryOptions.class, "js/jquery.prettyGallery.min.js");

    private static final CssResourceReference cssResource = new CssResourceReference(
            PrettyGalleryOptions.class, "css/prettyGallery.css");

    public PrettyGalleryOptions() {
        this.setJsResourceReferences(jsResource);
        this.setJsResourceReferencesMin(jsResourceMin);
        this.setCssResourceReferences(cssResource);
    }

    /**
     * Default: 2
     *
     * @param itemsPerPage
     * @return
     */
    public PrettyGalleryOptions itemsPerPage(int itemsPerPage) {
        return super.put("itemsPerPage", itemsPerPage);
    }

    /**
     * fast / normal / slow<br/> Default: normal
     *
     * @param animationSpeed
     * @return
     */
    public PrettyGalleryOptions animationSpeed(CharSequence animationSpeed) {
        return super.put("animationSpeed", animationSpeed);
    }

    /**
     * top / bottom / both<br/> Default: top
     *
     * @param navigation
     * @return
     */
    public PrettyGalleryOptions navigation(CharSequence navigation) {
        return super.put("navigation", navigation);
    }

    /**
     * The content in the page "1 of 2"<br/> Default: ' of '
     *
     * @param of_label
     * @return
     */
    public PrettyGalleryOptions of_label(CharSequence of_label) {
        return super.put("of_label", of_label);
    }

    /**
     * The title of the previous link<br/> Default: 'Previous page'
     *
     * @param previous_title_label
     * @return
     */
    public PrettyGalleryOptions previous_title_label(
            CharSequence previous_title_label) {
        return super.put("previous_title_label", previous_title_label);
    }

    /**
     * The title of the next link <br/> Default: 'Next page'
     *
     * @param next_title_label
     * @return
     */
    public PrettyGalleryOptions next_title_label(CharSequence next_title_label) {
        return super.put("next_title_label", next_title_label);
    }

    /**
     * The content of the previous link<br/> Default: 'Previous'
     *
     * @param previous_label
     * @return
     */
    public PrettyGalleryOptions previous_label(CharSequence previous_label) {
        return super.put("previous_label", previous_label);
    }

    /**
     * The content of the next link<br/> Default: 'Next'
     *
     * @param next_label
     * @return
     */
    public PrettyGalleryOptions next_label(CharSequence next_label) {
        return super.put("next_label", next_label);
    }
}
