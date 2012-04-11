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
package com.google.code.jqwicket.ui;

import com.google.code.jqwicket.IJQWidget;
import com.google.code.jqwicket.JQBehavior;
import com.google.code.jqwicket.JQHeaderContributionTarget;
import com.google.code.jqwicket.Utils;
import com.google.code.jqwicket.api.IJQFunction;
import com.google.code.jqwicket.api.IJQOptions;
import com.google.code.jqwicket.api.IJQStatement;
import org.apache.wicket.Component;
import org.apache.wicket.Page;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.request.resource.JavaScriptResourceReference;

import static com.google.code.jqwicket.api.JQuery.$;
import static com.google.code.jqwicket.api.JQuery.$f;

/**
 * Abstract component behavior for JQuery components.
 *
 * @param <T>
 * @author mkalina
 */
public abstract class JQComponentBehavior<T extends IJQOptions<T>> extends
        JQBehavior implements IJQWidget<T> {

    private static final long serialVersionUID = 1L;

    protected T options;

    public JQComponentBehavior(T options) {
        this.options = options;
        this.addResourcesFromOptions();
    }

    protected void addResourcesFromOptions() {

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
     * @see com.google.code.jqwicket.IJQUIWidget#getOptions()
     */
    public T getOptions() {
        return this.options;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.google.code.jqwicket.JQBehavior#contributeInternal(com.google.code.jqwicket.JQHeaderContributionTarget)
     */
    @Override
    protected void contributeInternal(JQHeaderContributionTarget target) {
        if (!Page.class.isAssignableFrom(this.component.getClass()))
            target.addJQStatements($(this.component).chain(this.getName(),
                    this.options));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void beforeRender(Component component) {
        super.beforeRender(component);

        if (AjaxRequestTarget.get() != null) {
            JQHeaderContributionTarget ajaxTarget = new JQHeaderContributionTarget();
            contributeInternal(ajaxTarget);
            for (IJQStatement s : ajaxTarget
                    .getJQStatementsInsideDocumentReady()) {
                AjaxRequestTarget.get().appendJavaScript(String.valueOf(s));
            }
        }
    }

    protected IJQFunction chain(CharSequence... methodArgs) {
        return $f($(this.component).chain(this.getName(), methodArgs));
    }

    protected void chain(AjaxRequestTarget ajaxRequestTarget, IJQFunction function) {
        ajaxRequestTarget.appendJavaScript(String.valueOf(function
                .toString(true)));
    }

}
