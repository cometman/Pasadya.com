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
package com.google.code.jqwicket.ui.tabs;


import com.google.code.jqwicket.api.IJQFunction;
import com.google.code.jqwicket.ui.JQUIWebMarkupContainer;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.model.IModel;

/**
 * @author mkalina
 */
public class TabsWebMarkupContainer extends
        JQUIWebMarkupContainer<TabsBehavior, TabsOptions> implements ITabs {

    private static final long serialVersionUID = 1L;

    public TabsWebMarkupContainer(String id) {
        this(id, new TabsOptions());
    }

    public TabsWebMarkupContainer(String id, TabsOptions options) {
        super(id, options);
    }

    public TabsWebMarkupContainer(String id, IModel<?> model) {
        this(id, model, new TabsOptions());
    }

    public TabsWebMarkupContainer(String id, IModel<?> model,
                                  TabsOptions options) {
        super(id, model, options);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected TabsBehavior newJQComponentBehavior(TabsOptions options) {
        return new TabsBehavior(options);
    }

    /**
     * {@inheritDoc}
     */
    public IJQFunction add(CharSequence url, CharSequence label) {
        return this.behavior.add(url, label);
    }

    /**
     * {@inheritDoc}
     */
    public IJQFunction add(CharSequence url, CharSequence label, Integer index) {
        return this.behavior.add(url, label, index);
    }

    /**
     * {@inheritDoc}
     */
    public void add(AjaxRequestTarget ajaxRequestTarget, CharSequence url,
                    CharSequence label) {
        this.behavior.add(ajaxRequestTarget, url, label);
    }

    /**
     * {@inheritDoc}
     */
    public void add(AjaxRequestTarget ajaxRequestTarget, CharSequence url,
                    CharSequence label, Integer index) {
        this.behavior.add(ajaxRequestTarget, url, label, index);
    }

    /**
     * {@inheritDoc}
     */
    public IJQFunction remove(int index) {
        return this.behavior.remove(index);
    }

    /**
     * {@inheritDoc}
     */
    public void remove(AjaxRequestTarget ajaxRequestTarget, int index) {
        this.behavior.remove(ajaxRequestTarget, index);

    }

    /**
     * {@inheritDoc}
     */
    public IJQFunction enable(int index) {
        return this.behavior.enable(index);
    }

    /**
     * {@inheritDoc}
     */
    public void enable(AjaxRequestTarget ajaxRequestTarget, int index) {
        this.behavior.enable(ajaxRequestTarget, index);
    }

    /**
     * {@inheritDoc}
     */
    public IJQFunction disable(int index) {
        return this.behavior.disable(index);
    }

    /**
     * {@inheritDoc}
     */
    public void disable(AjaxRequestTarget ajaxRequestTarget, int index) {
        this.behavior.disable(ajaxRequestTarget, index);
    }

    /**
     * {@inheritDoc}
     */
    public IJQFunction select(int index) {
        return this.behavior.select(index);
    }

    /**
     * {@inheritDoc}
     */
    public void select(AjaxRequestTarget ajaxRequestTarget, int index) {
        this.behavior.select(ajaxRequestTarget, index);
    }

    /**
     * {@inheritDoc}
     */
    public IJQFunction load(int index) {
        return this.behavior.load(index);
    }

    /**
     * {@inheritDoc}
     */
    public void load(AjaxRequestTarget ajaxRequestTarget, int index) {
        this.behavior.load(ajaxRequestTarget, index);
    }

    /**
     * {@inheritDoc}
     */
    public IJQFunction url(int index, CharSequence url) {
        return this.behavior.url(index, url);
    }

    /**
     * {@inheritDoc}
     */
    public void url(AjaxRequestTarget ajaxRequestTarget, int index,
                    CharSequence url) {
        this.behavior.url(ajaxRequestTarget, index, url);

    }

    /**
     * {@inheritDoc}
     */
    public IJQFunction length() {
        return this.behavior.length();
    }

    /**
     * {@inheritDoc}
     */
    public void length(AjaxRequestTarget ajaxRequestTarget) {
        this.behavior.length(ajaxRequestTarget);
    }

    /**
     * {@inheritDoc}
     */
    public IJQFunction abort() {
        return this.behavior.abort();
    }

    /**
     * {@inheritDoc}
     */
    public void abort(AjaxRequestTarget ajaxRequestTarget) {
        this.behavior.abort(ajaxRequestTarget);
    }

    /**
     * {@inheritDoc}
     */
    public IJQFunction rotate(int ms, boolean continuing) {
        return this.behavior.rotate(ms, continuing);
    }

    /**
     * {@inheritDoc}
     */
    public void rotate(AjaxRequestTarget ajaxRequestTarget, int ms,
                       boolean continuing) {
        this.behavior.rotate(ajaxRequestTarget, ms, continuing);
    }

}
