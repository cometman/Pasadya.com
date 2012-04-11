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
import com.google.code.jqwicket.ui.JQUIComponentBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;
import static com.google.code.jqwicket.api.JQLiteral._raw;

/**
 * @author mkalina
 */
public class TabsBehavior extends JQUIComponentBehavior<TabsOptions> implements
        ITabs {

    private static final long serialVersionUID = 1L;

    public TabsBehavior() {
        this(new TabsOptions());
    }

    public TabsBehavior(TabsOptions options) {
        super(options);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.google.code.jqwicket.IJQUIWidget#getName()
     */
    public CharSequence getName() {
        return JQ_COMPONENT_NAME;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.google.code.jqwicket.ui.tabs.ITabs#add(java.lang.CharSequence, java.lang.CharSequence)
     */
    public IJQFunction add(CharSequence url, CharSequence label) {
        return this.add(url, label, null);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.google.code.jqwicket.ui.tabs.ITabs#add(java.lang.CharSequence, java.lang.CharSequence,
     *      java.lang.Integer)
     */
    public IJQFunction add(CharSequence url, CharSequence label, Integer index) {
        if (index != null)
            return chain("add", url, label, _raw(index));
        else
            return chain("add", url, label);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.google.code.jqwicket.ui.tabs.ITabs#add(org.apache.wicket.ajax.AjaxRequestTarget, java.lang.CharSequence,
     *      java.lang.CharSequence)
     */
    public void add(AjaxRequestTarget ajaxRequestTarget, CharSequence url,
                    CharSequence label) {
        chain(ajaxRequestTarget, this.add(url, label, null));
    }

    /**
     * {@inheritDoc}
     *
     * @see com.google.code.jqwicket.ui.tabs.ITabs#add(org.apache.wicket.ajax.AjaxRequestTarget, java.lang.CharSequence,
     *      java.lang.CharSequence, java.lang.Integer)
     */
    public void add(AjaxRequestTarget ajaxRequestTarget, CharSequence url,
                    CharSequence label, Integer index) {
        chain(ajaxRequestTarget, this.add(url, label, index));
    }

    /**
     * {@inheritDoc}
     *
     * @see com.google.code.jqwicket.ui.tabs.ITabs#remove(int)
     */
    public IJQFunction remove(int index) {
        return chain("remove", _raw(index));
    }

    /**
     * {@inheritDoc}
     *
     * @see com.google.code.jqwicket.ui.tabs.ITabs#remove(org.apache.wicket.ajax.AjaxRequestTarget, int)
     */
    public void remove(AjaxRequestTarget ajaxRequestTarget, int index) {
        chain(ajaxRequestTarget, this.remove(index));
    }

    /**
     * {@inheritDoc}
     *
     * @see com.google.code.jqwicket.ui.tabs.ITabs#enable(int)
     */
    public IJQFunction enable(int index) {
        return chain("enable", _raw(index));
    }

    /**
     * {@inheritDoc}
     *
     * @see com.google.code.jqwicket.ui.tabs.ITabs#enable(org.apache.wicket.ajax.AjaxRequestTarget, int)
     */
    public void enable(AjaxRequestTarget ajaxRequestTarget, int index) {
        chain(ajaxRequestTarget, this.enable(index));
    }

    /**
     * {@inheritDoc}
     *
     * @see com.google.code.jqwicket.ui.tabs.ITabs#disable(int)
     */
    public IJQFunction disable(int index) {
        return chain("disable", _raw(index));
    }

    /**
     * {@inheritDoc}
     *
     * @see com.google.code.jqwicket.ui.tabs.ITabs#disable(org.apache.wicket.ajax.AjaxRequestTarget, int)
     */
    public void disable(AjaxRequestTarget ajaxRequestTarget, int index) {
        chain(ajaxRequestTarget, this.disable(index));
    }

    /**
     * {@inheritDoc}
     *
     * @see com.google.code.jqwicket.ui.tabs.ITabs#select(int)
     */
    public IJQFunction select(int index) {
        return chain("select", _raw(index));
    }

    /**
     * {@inheritDoc}
     *
     * @see com.google.code.jqwicket.ui.tabs.ITabs#select(org.apache.wicket.ajax.AjaxRequestTarget, int)
     */
    public void select(AjaxRequestTarget ajaxRequestTarget, int index) {
        chain(ajaxRequestTarget, this.select(index));
    }

    /**
     * {@inheritDoc}
     *
     * @see com.google.code.jqwicket.ui.tabs.ITabs#load(int)
     */
    public IJQFunction load(int index) {
        return chain("load", _raw(index));
    }

    /**
     * {@inheritDoc}
     *
     * @see com.google.code.jqwicket.ui.tabs.ITabs#load(org.apache.wicket.ajax.AjaxRequestTarget, int)
     */
    public void load(AjaxRequestTarget ajaxRequestTarget, int index) {
        chain(ajaxRequestTarget, this.load(index));
    }

    /**
     * {@inheritDoc}
     *
     * @see com.google.code.jqwicket.ui.tabs.ITabs#url(int, java.lang.CharSequence)
     */
    public IJQFunction url(int index, CharSequence url) {
        return chain("url", _raw(index));
    }

    /**
     * {@inheritDoc}
     *
     * @see com.google.code.jqwicket.ui.tabs.ITabs#url(org.apache.wicket.ajax.AjaxRequestTarget, int,
     *      java.lang.CharSequence)
     */
    public void url(AjaxRequestTarget ajaxRequestTarget, int index,
                    CharSequence url) {
        chain(ajaxRequestTarget, this.url(index, url));
    }

    /**
     * {@inheritDoc}
     *
     * @see com.google.code.jqwicket.ui.tabs.ITabs#length()
     */
    public IJQFunction length() {
        return chain("length");
    }

    /**
     * {@inheritDoc}
     *
     * @see com.google.code.jqwicket.ui.tabs.ITabs#length(org.apache.wicket.ajax.AjaxRequestTarget)
     */
    public void length(AjaxRequestTarget ajaxRequestTarget) {
        chain(ajaxRequestTarget, this.length());
    }

    /**
     * {@inheritDoc}
     *
     * @see com.google.code.jqwicket.ui.tabs.ITabs#abort()
     */
    public IJQFunction abort() {
        return chain("abort");
    }

    /**
     * {@inheritDoc}
     *
     * @see com.google.code.jqwicket.ui.tabs.ITabs#abort(org.apache.wicket.ajax.AjaxRequestTarget)
     */
    public void abort(AjaxRequestTarget ajaxRequestTarget) {
        chain(ajaxRequestTarget, this.abort());
    }

    /**
     * {@inheritDoc}
     *
     * @see com.google.code.jqwicket.ui.tabs.ITabs#rotate(int, boolean)
     */
    public IJQFunction rotate(int ms, boolean continuing) {
        return chain("rotate", _raw(ms), String.valueOf(continuing));
    }

    /**
     * {@inheritDoc}
     *
     * @see com.google.code.jqwicket.ui.tabs.ITabs#rotate(org.apache.wicket.ajax.AjaxRequestTarget, int, boolean)
     */
    public void rotate(AjaxRequestTarget ajaxRequestTarget, int ms,
                       boolean continuing) {
        chain(ajaxRequestTarget, this.rotate(ms, continuing));
    }

}
