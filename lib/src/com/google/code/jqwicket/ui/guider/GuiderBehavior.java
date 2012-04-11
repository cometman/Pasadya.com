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

import com.google.code.jqwicket.JQBehavior;
import com.google.code.jqwicket.Utils;
import com.google.code.jqwicket.api.IJQFunction;
import com.google.code.jqwicket.api.JQuery;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.request.resource.JavaScriptResourceReference;

/**
 * @author mkalina
 */
public class GuiderBehavior extends JQBehavior implements IGuider {

    private static final long serialVersionUID = 1L;

    public GuiderBehavior(GuiderItem... items) {
        if (Utils.isNotEmpty(items)) {
            for (GuiderItem item : items) {
                addOptionsResources(item.getOptions());
                addJQStatements(item.toJQStatement());
            }
        }
    }

    protected void addOptionsResources(GuiderOptions options) {
        JavaScriptResourceReference[] jsRefs = options
                .getJsResourceReferences();

        if (Utils.isDeploymentMode()
                && Utils.isNotEmpty(options.getJsResourceReferencesMin())) {
            jsRefs = options.getJsResourceReferencesMin();
        }

        CharSequence[] jsUrls = options.getJsResourceUrls();

        if (Utils.isDeploymentMode()
                && Utils.isNotEmpty(options.getJsResourceUrlsMin())) {
            jsUrls = options.getJsResourceUrlsMin();
        }

        this.addJsResourceReferences(jsRefs);
        this.addJsResourceUrls(jsUrls);
        this.addCssResourceReferences(options.getCssResourceReferences());
        this.addCssResourceUrls(options.getCssResourceUrls());
    }

    /**
     * {@inheritDoc}
     *
     * @see com.google.code.jqwicket.ui.guider.IGuider#show(java.lang.CharSequence)
     */
    public IJQFunction show(CharSequence id) {
        return JQuery.$f(JQuery.js(IGuider.JQ_COMPONENT_NAME).chain("show", id));
    }

    /**
     * {@inheritDoc}
     *
     * @see com.google.code.jqwicket.ui.guider.IGuider#show(java.lang.CharSequence, org.apache.wicket.ajax.AjaxRequestTarget)
     */
    public void show(CharSequence id, AjaxRequestTarget ajaxRequestTarget) {
        chain(ajaxRequestTarget, this.show(id));
    }

    /**
     * {@inheritDoc}
     *
     * @see com.google.code.jqwicket.ui.guider.IGuider#next()
     */
    public IJQFunction next() {
        return JQuery.$f(JQuery.js(IGuider.JQ_COMPONENT_NAME).chain("next"));
    }

    /**
     * {@inheritDoc}
     *
     * @see com.google.code.jqwicket.ui.guider.IGuider#next(org.apache.wicket.ajax.AjaxRequestTarget)
     */
    public void next(AjaxRequestTarget ajaxRequestTarget) {
        chain(ajaxRequestTarget, this.next());
    }

    /**
     * {@inheritDoc}
     *
     * @see com.google.code.jqwicket.ui.guider.IGuider#hideAll()
     */
    public IJQFunction hideAll() {
        return JQuery.$f(JQuery.js(IGuider.JQ_COMPONENT_NAME).chain("hideAll"));
    }

    /**
     * {@inheritDoc}
     *
     * @see com.google.code.jqwicket.ui.guider.IGuider#hideAll(org.apache.wicket.ajax.AjaxRequestTarget)
     */
    public void hideAll(AjaxRequestTarget ajaxRequestTarget) {
        chain(ajaxRequestTarget, this.hideAll());
    }

    protected void chain(AjaxRequestTarget ajaxRequestTarget,
                         IJQFunction function) {
        ajaxRequestTarget.appendJavaScript(String.valueOf(function
                .toString(true)));
    }

}
