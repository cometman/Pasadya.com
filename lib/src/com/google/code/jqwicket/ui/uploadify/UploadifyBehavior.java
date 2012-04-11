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
package com.google.code.jqwicket.ui.uploadify;

import com.google.code.jqwicket.api.IJQFunction;
import com.google.code.jqwicket.api.IJQOptions;
import com.google.code.jqwicket.ui.JQComponentBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.request.cycle.RequestCycle;

/**
 * @author mkalina
 */
public class UploadifyBehavior extends JQComponentBehavior<UploadifyOptions>
        implements IUploadify {

    private static final long serialVersionUID = 1L;

    public UploadifyBehavior() {
        this(new UploadifyOptions());
    }

    public UploadifyBehavior(UploadifyOptions options) {
        super(options);
        if (!options.containsKey("uploader"))
            options.put(
                    "uploader", RequestCycle.get().urlFor(UploadifyOptions.SWF_UPLOADIFY_RESOURCE, null));

        if (!options.containsKey("expressInstall"))
            options.put(
                    "expressInstall", RequestCycle.get().urlFor(UploadifyOptions.SWF_EXPRESS_INSTALL_RESOURCE, null));

        if (!options.containsKey("cancelImg"))
            options.put(
                    "cancelImg", RequestCycle.get().urlFor(UploadifyOptions.PNG_CANCEL_RESOURCE, null));
    }

    /**
     * {@inheritDoc}
     */
    public CharSequence getName() {
        return JQ_COMPONENT_NAME;
    }

    /**
     * {@inheritDoc}
     */
    public IJQFunction uploadify() {
        return chain("uploadify");
    }

    /**
     * {@inheritDoc}
     */
    public void uploadify(AjaxRequestTarget ajaxRequestTarget) {
        chain(ajaxRequestTarget, this.uploadify());

    }

    /**
     * {@inheritDoc}
     */
    public IJQFunction uploadify(IJQOptions<?> options) {
        return chain("uploadify", options);
    }

    /**
     * {@inheritDoc}
     */
    public void uploadify(AjaxRequestTarget ajaxRequestTarget, IJQOptions<?> options) {
        chain(ajaxRequestTarget, this.uploadify(options));
    }

    /**
     * {@inheritDoc}
     */
    public IJQFunction uploadifyCancel(CharSequence id) {
        return chain("uploadifyCancel", id);
    }

    /**
     * {@inheritDoc}
     */
    public void uploadifyCancel(AjaxRequestTarget ajaxRequestTarget, CharSequence id) {
        chain(ajaxRequestTarget, this.uploadifyCancel(id));
    }

    /**
     * {@inheritDoc}
     */
    public IJQFunction uploadifyClearQueue() {
        return chain("uploadifyClearQueue");
    }

    /**
     * {@inheritDoc}
     */
    public void uploadifyClearQueue(AjaxRequestTarget ajaxRequestTarget) {
        chain(ajaxRequestTarget, this.uploadifyClearQueue());
    }

    /**
     * {@inheritDoc}
     */
    public IJQFunction uploadifySettings(CharSequence name, CharSequence value) {
        return chain("uploadifySettings", name, value);
    }

    /**
     * {@inheritDoc}
     */
    public void uploadifySettings(AjaxRequestTarget ajaxRequestTarget,
                                  CharSequence name, CharSequence value) {
        chain(ajaxRequestTarget, this.uploadifySettings(name, value));

    }

    /**
     * {@inheritDoc}
     */
    public IJQFunction uploadifySettings(CharSequence name, CharSequence value,
                                         boolean resetObject) {
        return chain("uploadifySettings", name, value,
                String.valueOf(resetObject));
    }

    /**
     * {@inheritDoc}
     */
    public void uploadifySettings(AjaxRequestTarget ajaxRequestTarget,
                                  CharSequence name, CharSequence value, boolean resetObject) {
        chain(ajaxRequestTarget,
                this.uploadifySettings(name, value, resetObject));

    }

    /**
     * {@inheritDoc}
     */
    public IJQFunction uploadifyUpload() {
        return chain("uploadifyUpload");
    }

    /**
     * {@inheritDoc}
     */
    public void uploadifyUpload(AjaxRequestTarget ajaxRequestTarget) {
        chain(ajaxRequestTarget, this.uploadifyUpload());
    }

    /**
     * {@inheritDoc}
     */
    public IJQFunction uploadifyUpload(CharSequence id) {
        return chain("uploadifyUpload", id);
    }

    /**
     * {@inheritDoc}
     */
    public void uploadifyUpload(AjaxRequestTarget ajaxRequestTarget, CharSequence id) {
        chain(ajaxRequestTarget, this.uploadifyUpload(id));
    }

}
