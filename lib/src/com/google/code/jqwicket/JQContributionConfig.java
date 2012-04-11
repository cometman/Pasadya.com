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
package com.google.code.jqwicket;

import org.apache.wicket.Application;
import org.apache.wicket.MetaDataKey;
import org.apache.wicket.request.resource.CssResourceReference;
import org.apache.wicket.request.resource.JavaScriptResourceReference;

import java.io.Serializable;

/**
 * Global JQWicket contribution config defining javascript/css resources that will be always rendered into the HTML-Page
 * head section as soon as some JQWicket component/behavior will be rendered.
 *
 * @author mkalina
 */
public class JQContributionConfig implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final MetaDataKey<JQContributionConfig> configKey = new MetaDataKey<JQContributionConfig>() {
        private static final long serialVersionUID = 1L;
    };

    private static final CharSequence defaultJQueryCoreJsUrl = "http://ajax.googleapis.com/ajax/libs/" +
            "jquery/1.7.1/jquery.min.js";

    private static final CharSequence defaultJQueryUiJsUrl = "http://ajax.googleapis.com/ajax/libs/" +
            "jqueryui/1.8.16/jquery-ui.min.js";

    private static final CharSequence defaultJQueryUiCssUrl = "http://ajax.googleapis.com/ajax/libs/" +
            "jqueryui/1.8.16/themes/base/jquery-ui.css";

    private CharSequence jqueryCoreJsUrl;

    private JavaScriptResourceReference jqueryCoreJsResourceReference;

    private CharSequence jqueryUiJsUrl;

    private JavaScriptResourceReference jqueryUiJsResourceReference;

    private CharSequence jqueryUiCssUrl;

    private CharSequence nonConflictAlias;

    private CssResourceReference jqueryUiCssResourceReference;

    private boolean useYuiJavascriptCompressor = false;

    private boolean renderJavascriptResourceRefsBeforeUrls = false;

    private boolean renderCssResourceRefsBeforeUrls = false;

    public static JQContributionConfig get() {
        return Application.get().getMetaData(configKey);
    }

    public static void set(JQContributionConfig config) {
        Application.get().setMetaData(configKey, config);
    }

    public JQContributionConfig() {
        this.jqueryCoreJsUrl = defaultJQueryCoreJsUrl;
    }

    public JQContributionConfig(CharSequence jqueryCoreJsUrl) {
        this.jqueryCoreJsResourceReference = null;
        this.jqueryCoreJsUrl = jqueryCoreJsUrl;
    }

    public JQContributionConfig(
            JavaScriptResourceReference jqueryCoreResourceReference) {
        this.jqueryCoreJsResourceReference = jqueryCoreResourceReference;
        this.jqueryCoreJsUrl = null;
    }

    public JQContributionConfig enableNonConflictMode(
            CharSequence nonConflictAlias) {
        this.nonConflictAlias = nonConflictAlias;
        return this;
    }

    public JQContributionConfig withDefaultJQueryUi() {
        this.jqueryUiJsUrl = defaultJQueryUiJsUrl;
        this.jqueryUiCssUrl = defaultJQueryUiCssUrl;
        this.jqueryUiJsResourceReference = null;
        this.jqueryUiCssResourceReference = null;
        return this;
    }

    public JQContributionConfig withJQueryUiJs(CharSequence url) {
        this.jqueryUiJsUrl = url;
        this.jqueryUiJsResourceReference = null;
        return this;
    }

    public JQContributionConfig withJQueryUiJs(JavaScriptResourceReference ref) {
        this.jqueryUiJsUrl = null;
        this.jqueryUiJsResourceReference = ref;
        return this;
    }

    public JQContributionConfig withJQueryUiCss(CharSequence url) {
        this.jqueryUiCssUrl = url;
        this.jqueryUiCssResourceReference = null;
        return this;
    }

    public JQContributionConfig withJQueryUiCss(CssResourceReference ref) {
        this.jqueryUiCssUrl = null;
        this.jqueryUiCssResourceReference = ref;
        return this;
    }

    public JQContributionConfig withoutJQueryUi() {
        this.jqueryUiJsUrl = null;
        this.jqueryUiCssUrl = null;
        this.jqueryUiJsResourceReference = null;
        this.jqueryUiCssResourceReference = null;
        return this;
    }

    /**
     * Configure jqwicket to use yui-compressor while rendering javascript. <br/> Note! Add yui-compressor library to
     * your project to be able to use this feature.
     *
     * @return this contribution config
     */
    public JQContributionConfig useYuiJavascriptCompressor() {
        this.useYuiJavascriptCompressor = true;
        return this;
    }

    /**
     * Configure jqwicket always to render javascript resource references before javascript resource urls.<br/> Default
     * settings is to render javascript resource urls before resource references.
     *
     * @return this contribution config
     */
    public JQContributionConfig renderJavascriptResourceRefsBeforeUrls() {
        this.renderJavascriptResourceRefsBeforeUrls = true;
        return this;
    }

    /**
     * Configure jqwicket always to render css resource references before css resource urls.<br/> Default settings is to
     * render css resource urls before resource references.
     *
     * @return this contribution config
     */
    public JQContributionConfig renderCssResourceRefsBeforeUrls() {
        this.renderCssResourceRefsBeforeUrls = true;
        return this;
    }

    public CharSequence getJqueryCoreJsUrl() {
        return jqueryCoreJsUrl;
    }

    public JavaScriptResourceReference getJqueryCoreJsResourceReference() {
        return jqueryCoreJsResourceReference;
    }

    public CharSequence getJqueryUiJsUrl() {
        return jqueryUiJsUrl;
    }

    public JavaScriptResourceReference getJqueryUiJsResourceReference() {
        return jqueryUiJsResourceReference;
    }

    public CharSequence getJqueryUiCssUrl() {
        return jqueryUiCssUrl;
    }

    public CssResourceReference getJqueryUiCssResourceReference() {
        return jqueryUiCssResourceReference;
    }

    public CharSequence getNonConflictAlias() {
        return nonConflictAlias;
    }

    public boolean isUseYuiJavascriptCompressor() {
        return useYuiJavascriptCompressor;
    }

    public boolean isRenderJavascriptResourceRefsBeforeUrls() {
        return renderJavascriptResourceRefsBeforeUrls;
    }

    public boolean isRenderCssResourceRefsBeforeUrls() {
        return renderCssResourceRefsBeforeUrls;
    }
}
