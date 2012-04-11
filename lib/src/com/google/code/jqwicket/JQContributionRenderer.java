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

import com.google.code.jqwicket.api.IJQStatement;
import com.google.code.jqwicket.api.JQuery;
import org.apache.wicket.Application;
import org.apache.wicket.Component;
import org.apache.wicket.MetaDataKey;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.javascript.IJavaScriptCompressor;
import org.apache.wicket.markup.html.IHeaderResponse;
import org.apache.wicket.request.cycle.RequestCycle;
import org.apache.wicket.request.resource.CssResourceReference;
import org.apache.wicket.request.resource.JavaScriptResourceReference;

import java.util.*;

import static com.google.code.jqwicket.Utils.isEmpty;

/**
 * Wicket's behavior implementation able to render all necessary jquery/css resources gathered from the component
 * hierarchy to the html-page head section.
 *
 * @author mkalina
 */
public class JQContributionRenderer extends Behavior {

    private static final long serialVersionUID = 1L;

    private static final MetaDataKey<JQContributionRenderer> KEY = new MetaDataKey<JQContributionRenderer>() {
        private static final long serialVersionUID = 1L;
    };

    public static JQContributionRenderer get() {
        JQContributionRenderer target = RequestCycle.get().getMetaData(KEY);
        if (target == null) {
            target = new JQContributionRenderer();
            RequestCycle.get().setMetaData(KEY, target);
        }
        return target;
    }

    private Set<IJQHeaderContributor> contributors;

    JQContributionRenderer() {
    }


    public JQContributionRenderer addContributors(Collection<? extends IJQHeaderContributor> contributors) {

        if (this.contributors == null)
            this.contributors = new LinkedHashSet<IJQHeaderContributor>();

        if (Utils.isNotEmpty(contributors))
            this.contributors.addAll(contributors);

        return this;
    }

    public JQContributionRenderer addContributor(IJQHeaderContributor contributor) {

        if (this.contributors == null)
            this.contributors = new LinkedHashSet<IJQHeaderContributor>();

        this.contributors.add(contributor);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void renderHead(Component component, IHeaderResponse response) {

        if (isEmpty(this.contributors))
            return;

        JQContributionConfig config = JQContributionConfig.get();
        JQHeaderContributionTarget target = new JQHeaderContributionTarget();
        for (IJQHeaderContributor c : this.contributors) {
            c.contribute(target);
        }

        if (!target.hasResourcesToRender())
            return;

        // 1. render global javascripts
        this.renderJavaScriptOutsideDocumentReady(response, target.getJQStatementsOutsideDocumentReady());

        // 2. render resources from global config
        this.renderJsResources(response,
                Arrays.asList(config.getJqueryCoreJsUrl()), Arrays.asList(config.getJqueryCoreJsResourceReference()));
        this.renderJsResources(response,
                Arrays.asList(config.getJqueryUiJsUrl()), Arrays.asList(config.getJqueryUiJsResourceReference()));
        this.renderCssResources(response,
                Arrays.asList(config.getJqueryUiCssUrl()), Arrays.asList(config.getJqueryUiCssResourceReference()));


        // 3. render resource explicitly added to the target
        this.renderJsResources(response, target.getJsResourceUrls(), target.getJsResourceReferences());
        this.renderCssResources(response, target.getCssResourceUrls(), target.getCssResourceReferences());

        // 4. render "documentReady"-script
        this.renderJavaScriptInsideDocumentReady(response, target.getJQStatementsInsideDocumentReady());

        // clear contributors after rendering
        this.contributors.clear();
    }

    private void renderJsResources(IHeaderResponse response, Collection<CharSequence> urls,
                                   Collection<JavaScriptResourceReference> refs) {
        JQContributionConfig config = JQContributionConfig.get();
        if (config.isRenderJavascriptResourceRefsBeforeUrls()) {
            this.renderJsResourcesRefs(response, refs);
            this.renderJsResourcesUrls(response, urls);
        } else {
            this.renderJsResourcesUrls(response, urls);
            this.renderJsResourcesRefs(response, refs);
        }
    }

    private void renderCssResources(IHeaderResponse response, Collection<CharSequence> urls,
                                    Collection<CssResourceReference> refs) {
        JQContributionConfig config = JQContributionConfig.get();
        if (config.isRenderCssResourceRefsBeforeUrls()) {
            this.renderCssResourcesRefs(response, refs);
            this.renderCssResourcesUrls(response, urls);
        } else {
            this.renderCssResourcesUrls(response, urls);
            this.renderCssResourcesRefs(response, refs);
        }
    }


    private void renderJsResourcesUrls(IHeaderResponse response, Collection<CharSequence> resources) {
        for (CharSequence url : resources) {
            response.renderJavaScriptReference(determineResourcesUrl(url));
        }
    }

    private void renderJsResourcesRefs(IHeaderResponse response, Collection<JavaScriptResourceReference> resources) {
        for (JavaScriptResourceReference ref : resources) {
            if (ref != null)
                response.renderJavaScriptReference(ref);
        }
    }

    private void renderCssResourcesUrls(IHeaderResponse response, Collection<CharSequence> resources) {
        for (CharSequence url : resources) {
            response.renderCSSReference(determineResourcesUrl(url));
        }
    }


    private void renderCssResourcesRefs(IHeaderResponse response, Collection<CssResourceReference> resources) {
        for (CssResourceReference ref : resources) {
            if (ref != null)
                response.renderCSSReference(ref);
        }
    }


    private String determineResourcesUrl(CharSequence url) {
        if (Utils.isBlank(url))
            throw new IllegalArgumentException("url cannot be empty or null");

        String urlString = String.valueOf(url);
        if (urlString.toLowerCase().startsWith("http://") || urlString.toLowerCase().startsWith("https://"))
            return urlString;

        RequestCycle rc = RequestCycle.get();
        return rc.getUrlRenderer().renderContextRelativeUrl(urlString);
    }


    private void renderJavaScriptOutsideDocumentReady(IHeaderResponse response, Collection<IJQStatement> statements) {

        if (isEmpty(statements))
            return;

        StringBuffer buf = new StringBuffer();
        for (IJQStatement s : statements) {
            buf.append(s);
        }
        response.renderJavaScript(compressJavaScript(buf), UUID.randomUUID().toString());
    }

    private void renderJavaScriptInsideDocumentReady(IHeaderResponse response, Collection<IJQStatement> statements) {

        if (isEmpty(statements))
            return;

        JQContributionConfig config = JQContributionConfig.get();

        StringBuffer script = new StringBuffer();
        if (Utils.isNotBlank(config.getNonConflictAlias())) {
            script.append("var ").append(config.getNonConflictAlias())
                    .append(" = jQuery.noConflict();\n");
        }

        script.append(compressJavaScript(JQuery.documentReady(statements)));

        if (Utils.isNotBlank(script))
            response.renderOnDomReadyJavaScript(script.toString());
    }

    private CharSequence compressJavaScript(CharSequence script) {

        final IJavaScriptCompressor compressor;

        if (JQContributionConfig.get().isUseYuiJavascriptCompressor())
            compressor = YuiJavascriptCompressor.get();
        else
            compressor = Application.get().getResourceSettings().getJavaScriptCompressor();

        return (compressor != null && Utils.isNotBlank(script)) ?
                compressor.compress(String.valueOf(script)) : script;
    }
}
