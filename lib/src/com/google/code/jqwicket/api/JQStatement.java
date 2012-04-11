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
package com.google.code.jqwicket.api;

import com.google.code.jqwicket.JQBehavior;
import com.google.code.jqwicket.Utils;
import org.apache.wicket.Component;

import java.io.Serializable;

import static com.google.code.jqwicket.Utils.join;
import static com.google.code.jqwicket.api.JQLiteral._;

/**
 * {@link IJQOptions} interface implementation. See {@link IJQOptions} for further details.
 *
 * @author mkalina
 */
class JQStatement implements IJQStatement, Serializable {

    private static final long serialVersionUID = 1L;

    private StringBuffer buf;

    JQStatement() {
        this.buf = new StringBuffer();
    }

    /*
      * (non-Javadoc)
      *
      * @see java.lang.CharSequence#length()
      */
    public int length() {
        return buf.length();
    }

    /*
      * (non-Javadoc)
      *
      * @see java.lang.CharSequence#charAt(int)
      */
    public char charAt(int index) {
        return buf.charAt(index);
    }

    /*
      * (non-Javadoc)
      *
      * @see java.lang.CharSequence#subSequence(int, int)
      */
    public CharSequence subSequence(int start, int end) {
        return buf.subSequence(start, end);
    }

    /*
      * (non-Javadoc)
      *
      * @see java.lang.Object#toString()
      */
    @Override
    public String toString() {
        return toString(true);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.google.code.jqwicket.api.IJQStatement#toString(boolean)
     */
    public String toString(boolean renderWithTrailingSemicolon) {
        return this.buf.toString().trim()
                + (renderWithTrailingSemicolon ? ";" : "");
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#appendJavascript(java.lang.
      * CharSequence)
      */
    public IJQStatement appendRawCharSequence(CharSequence js) {
        this.buf.append(js);
        return this;
    }

    /*
      * (non-Javadoc)
      *
      * @see com.google.code.jqwicket.api.IJQStatement#appendProperty(java.lang.
      * CharSequence)
      */
    public IJQStatement appendProperty(CharSequence propertyName) {
        this.buf.append(".").append(propertyName);
        return this;
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#chain(java.lang.CharSequence,
      * java.lang.CharSequence[])
      */
    public IJQStatement chain(CharSequence methodName,
                              CharSequence... methodArgs) {
        this.buf.append(".").append(methodName).append("(");
        this.buf.append(join(methodArgs, ",",
                new Utils.IJoinCallback<CharSequence>() {

                    public CharSequence toCharSequence(CharSequence obj) {
                        return JQLiteral._(obj);
                    }

                }));
        this.buf.append(")");
        return this;
    }

    /*
      * (non-Javadoc)
      *
      * @see com.google.code.jqwicket.api.IJQStatement#jquery()
      */
    public IJQStatement jquery() {
        this.buf.append(".").append("jquery");
        return this;
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#add(java.lang.CharSequence,
      * java.lang.CharSequence[])
      */
    public IJQStatement add(CharSequence... args) {
        return chain("add", args);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#add(org.apache.wicket.Component
      * , java.lang.CharSequence[])
      */
    public IJQStatement add(Component component, CharSequence... args) {
        return add(joinToArray(S.id(component), args));
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#addClass(java.lang.CharSequence
      * )
      */
    public IJQStatement addClass(CharSequence arg) {
        return chain("addClass", arg);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#after(java.lang.CharSequence[])
      */
    public IJQStatement after(CharSequence... args) {
        return chain("after", args);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#ajax(java.lang.CharSequence[])
      */
    public IJQStatement ajax(CharSequence... args) {
        return chain("ajax", args);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#ajaxComplete(java.lang.CharSequence
      * )
      */
    public IJQStatement ajaxComplete(CharSequence handler) {
        return chain("ajaxComplete", handler);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#ajaxError(java.lang.CharSequence
      * )
      */
    public IJQStatement ajaxError(CharSequence handler) {
        return chain("ajaxError", handler);
    }

    /*
      * (non-Javadoc)
      *
      * @see com.google.code.jqwicket.api.IJQStatement#ajaxPrefilter(java.lang.
      * CharSequence[])
      */
    public IJQStatement ajaxPrefilter(CharSequence... args) {
        return chain("ajaxPrefilter", args);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#ajaxSend(java.lang.CharSequence
      * )
      */
    public IJQStatement ajaxSend(CharSequence handler) {
        return chain("ajaxSend", handler);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#ajaxSetup(java.lang.CharSequence
      * )
      */
    public IJQStatement ajaxSetup(CharSequence options) {
        return chain("ajaxSetup", options);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#ajaxStart(java.lang.CharSequence
      * )
      */
    public IJQStatement ajaxStart(CharSequence handler) {
        return chain("ajaxStart", handler);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#ajaxStop(java.lang.CharSequence
      * )
      */
    public IJQStatement ajaxStop(CharSequence handler) {
        return chain("ajaxStop", handler);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#ajaxSuccess(java.lang.CharSequence
      * )
      */
    public IJQStatement ajaxSuccess(CharSequence handler) {
        return chain("ajaxSuccess", handler);
    }

    /*
      * (non-Javadoc)
      *
      * @see com.google.code.jqwicket.api.IJQStatement#andSelf()
      */
    public IJQStatement andSelf() {
        return chain("andSelf");
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#animate(java.lang.CharSequence
      * [])
      */
    public IJQStatement animate(CharSequence... args) {
        return chain("animate", args);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#append(java.lang.CharSequence
      * [])
      */
    public IJQStatement append(CharSequence... args) {
        return chain("append", args);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#appendTo(java.lang.CharSequence
      * )
      */
    public IJQStatement appendTo(CharSequence target) {
        return chain("appendTo", target);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#attr(java.lang.CharSequence[])
      */
    public IJQStatement attr(CharSequence... args) {
        return chain("attr", args);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#before(java.lang.CharSequence
      * [])
      */
    public IJQStatement before(CharSequence... args) {
        return chain("before", args);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#bind(java.lang.CharSequence[])
      */
    public IJQStatement bind(CharSequence... args) {
        return chain("bind", args);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#blur(java.lang.CharSequence[])
      */
    public IJQStatement blur(CharSequence... args) {
        return chain("blur", args);
    }

    /*
      * (non-Javadoc)
      *
      * @see com.google.code.jqwicket.api.IJQStatement#browser()
      */
    public IJQStatement browser() {
        this.buf.append(".browser");
        return this;
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#change(java.lang.CharSequence
      * [])
      */
    public IJQStatement change(CharSequence... args) {
        return chain("change", args);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#children(java.lang.CharSequence
      * [])
      */
    public IJQStatement children(CharSequence... args) {
        return chain("children", args);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#children(org.apache.wicket.
      * Component)
      */
    public IJQStatement children(Component component) {
        return chain("children", S.id(component));
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#clearQueue(java.lang.CharSequence
      * [])
      */
    public IJQStatement clearQueue(CharSequence... args) {
        return chain("clearQueue", args);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#click(java.lang.CharSequence[])
      */
    public IJQStatement click(CharSequence... args) {
        return chain("click", args);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#clone(java.lang.CharSequence[])
      */
    public IJQStatement clone(CharSequence... args) {
        return chain("clone", args);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#closest(java.lang.CharSequence
      * [])
      */
    public IJQStatement closest(CharSequence... args) {
        return chain("closest", args);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#closest(org.apache.wicket.Component
      * , java.lang.CharSequence[])
      */
    public IJQStatement closest(Component component, CharSequence... args) {
        return chain("closest", joinToArray(S.id(component), args));
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#contains(java.lang.CharSequence
      * , java.lang.CharSequence)
      */
    public IJQStatement contains(CharSequence container, CharSequence contained) {
        return chain("contains", new CharSequence[]{container, contained});
    }

    /*
      * (non-Javadoc)
      *
      * @see com.google.code.jqwicket.api.IJQStatement#contents()
      */
    public IJQStatement contents() {
        return chain("contents");
    }

    /*
      * (non-Javadoc)
      *
      * @see com.google.code.jqwicket.api.IJQStatement#context()
      */
    public IJQStatement context() {
        this.buf.append("context");
        return this;
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#css(java.lang.CharSequence[])
      */
    public IJQStatement css(CharSequence... args) {
        return chain("css", args);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#data(java.lang.CharSequence[])
      */
    public IJQStatement data(CharSequence... args) {
        return chain("data", args);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#dblclick(java.lang.CharSequence
      * [])
      */
    public IJQStatement dblclick(CharSequence... args) {
        return chain("dblclick", args);
    }

    /*
      * (non-Javadoc)
      *
      * @see com.google.code.jqwicket.api.IJQStatement#deferredAlways(java.lang.
      * CharSequence)
      */
    public IJQStatement deferredAlways(CharSequence alwaysCallbacks) {
        return chain("always", alwaysCallbacks);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#deferredDone(java.lang.CharSequence
      * [])
      */
    public IJQStatement deferredDone(CharSequence... doneCallbacks) {
        return chain("done", doneCallbacks);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#deferredFail(java.lang.CharSequence
      * [])
      */
    public IJQStatement deferredFail(CharSequence... failCallbacks) {
        return chain("fail", failCallbacks);
    }

    /*
      * (non-Javadoc)
      *
      * @see com.google.code.jqwicket.api.IJQStatement#deferredIsRejected()
      */
    public IJQStatement deferredIsRejected() {
        return chain("isRejected");
    }

    /*
      * (non-Javadoc)
      *
      * @see com.google.code.jqwicket.api.IJQStatement#deferredIsResolved()
      */
    public IJQStatement deferredIsResolved() {
        return chain("isResolved");
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#deferredPipe(java.lang.CharSequence
      * [])
      */
    public IJQStatement deferredPipe(CharSequence... args) {
        return chain("pipe", args);
    }

    /*
      * (non-Javadoc)
      *
      * @see com.google.code.jqwicket.api.IJQStatement#deferredPromise(java.lang.
      * CharSequence[])
      */
    public IJQStatement deferredPromise(CharSequence... args) {
        return chain("promise", args);
    }

    /*
      * (non-Javadoc)
      *
      * @see com.google.code.jqwicket.api.IJQStatement#deferredReject(java.lang.
      * CharSequence)
      */
    public IJQStatement deferredReject(CharSequence args) {
        return chain("reject", args);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#deferredRejectWith(java.lang
      * .CharSequence[])
      */
    public IJQStatement deferredRejectWith(CharSequence... args) {
        return chain("rejectWith", args);
    }

    /*
      * (non-Javadoc)
      *
      * @see com.google.code.jqwicket.api.IJQStatement#deferredResolve(java.lang.
      * CharSequence)
      */
    public IJQStatement deferredResolve(CharSequence args) {
        return chain("resolve", args);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#deferredResolveWith(java.lang
      * .CharSequence[])
      */
    public IJQStatement deferredResolveWith(CharSequence... args) {
        return chain("resolveWith", args);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#deferredThen(java.lang.CharSequence
      * , java.lang.CharSequence)
      */
    public IJQStatement deferredThen(CharSequence doneCallbacks,
                                     CharSequence failCallbacks) {
        return chain("then",
                new CharSequence[]{doneCallbacks, failCallbacks});
    }

    /*
      * (non-Javadoc)
      *
      * @see com.google.code.jqwicket.api.IJQStatement#delay(int,
      * java.lang.CharSequence[])
      */
    public IJQStatement delay(int duration, CharSequence... args) {
        return chain("delay", joinToArray(_(duration), args));
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#delegate(java.lang.CharSequence
      * [])
      */
    public IJQStatement delegate(CharSequence... args) {
        return chain("delegate", args);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#dequeue(java.lang.CharSequence
      * [])
      */
    public IJQStatement dequeue(CharSequence... args) {
        return chain("dequeue", args);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#detach(java.lang.CharSequence
      * [])
      */
    public IJQStatement detach(CharSequence... args) {
        return chain("detach", args);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#detach(org.apache.wicket.Component
      * )
      */
    public IJQStatement detach(Component component) {
        return chain("detach", S.id(component));
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#die(java.lang.CharSequence[])
      */
    public IJQStatement die(CharSequence... args) {
        return chain("die", args);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#each(java.lang.CharSequence,
      * java.lang.CharSequence)
      */
    public IJQStatement each(CharSequence collection, CharSequence callback) {
        return chain("each", collection, callback);
    }

    /**
     * {@inheritDoc}
     */
    public IJQStatement effect(CharSequence... args) {
        return chain("effect", args);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#each(java.lang.CharSequence)
      */
    public IJQStatement each(CharSequence function) {
        return chain("each", function);
    }

    /*
      * (non-Javadoc)
      *
      * @see com.google.code.jqwicket.api.IJQStatement#empty()
      */
    public IJQStatement empty() {
        return chain("empty");
    }

    /*
      * (non-Javadoc)
      *
      * @see com.google.code.jqwicket.api.IJQStatement#end()
      */
    public IJQStatement end() {
        return chain("end");
    }

    /*
      * (non-Javadoc)
      *
      * @see com.google.code.jqwicket.api.IJQStatement#eq(int)
      */
    public IJQStatement eq(int index) {
        return chain("eq", _(index));
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#error(java.lang.CharSequence[])
      */
    public IJQStatement error(CharSequence... args) {
        return chain("error", args);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#extend(java.lang.CharSequence,
      * java.lang.CharSequence[])
      */
    public IJQStatement extend(CharSequence... args) {
        return chain("extend", args);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#fadeIn(java.lang.CharSequence
      * [])
      */
    public IJQStatement fadeIn(CharSequence... args) {
        return chain("fadeIn", args);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#fadeOut(java.lang.CharSequence
      * [])
      */
    public IJQStatement fadeOut(CharSequence... args) {
        return chain("fadeOut", args);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#fadeTo(java.lang.CharSequence,
      * java.lang.CharSequence, java.lang.CharSequence[])
      */
    public IJQStatement fadeTo(CharSequence duration, CharSequence opacity,
                               CharSequence... other) {
        return chain("fadeTo",
                join(new CharSequence[]{duration, opacity}, other));
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#fadeToggle(java.lang.CharSequence
      * [])
      */
    public IJQStatement fadeToggle(CharSequence... args) {
        return chain("fadeToggle", args);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#filter(java.lang.CharSequence)
      */
    public IJQStatement filter(CharSequence arg) {
        return chain("filter", arg);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#filter(org.apache.wicket.Component
      * )
      */
    public IJQStatement filter(Component component) {
        return chain("filter", S.id(component));
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#find(java.lang.CharSequence)
      */
    public IJQStatement find(CharSequence arg) {
        return chain("find", arg);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#find(org.apache.wicket.Component
      * )
      */
    public IJQStatement find(Component component) {
        return chain("find", S.id(component));
    }

    /*
      * (non-Javadoc)
      *
      * @see com.google.code.jqwicket.api.IJQStatement#first()
      */
    public IJQStatement first() {
        return chain("first");
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#focus(java.lang.CharSequence[])
      */
    public IJQStatement focus(CharSequence... args) {
        return chain("focus", args);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#focusin(java.lang.CharSequence
      * [])
      */
    public IJQStatement focusin(CharSequence... args) {
        return chain("focusin", args);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#focusout(java.lang.CharSequence
      * [])
      */
    public IJQStatement focusout(CharSequence... args) {
        return chain("focusout", args);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#get(java.lang.CharSequence[])
      */
    public IJQStatement get(CharSequence... args) {
        return chain("get", args);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#getJSON(java.lang.CharSequence,
      * java.lang.CharSequence[])
      */
    public IJQStatement getJSON(CharSequence url, CharSequence... args) {
        return chain("getJSON", joinToArray(url, args));
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#getScript(java.lang.CharSequence
      * , java.lang.CharSequence[])
      */
    public IJQStatement getScript(CharSequence url, CharSequence... args) {
        return chain("getScript", joinToArray(url, args));
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#globalEval(java.lang.CharSequence
      * )
      */
    public IJQStatement globalEval(CharSequence code) {
        return chain("globalEval", code);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#grep(java.lang.CharSequence,
      * java.lang.CharSequence)
      */
    public IJQStatement grep(CharSequence array, CharSequence function) {
        return chain("grep", array, function);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#grep(java.lang.CharSequence,
      * java.lang.CharSequence, boolean)
      */
    public IJQStatement grep(CharSequence array, CharSequence function,
                             boolean invert) {
        return chain("grep", array, function, _(invert));
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#has(java.lang.CharSequence)
      */
    public IJQStatement has(CharSequence selector) {
        return chain("has", selector);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#has(org.apache.wicket.Component
      * )
      */
    public IJQStatement has(Component component) {
        return chain("has", S.id(component));
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#hasClass(java.lang.CharSequence
      * )
      */
    public IJQStatement hasClass(CharSequence className) {
        return chain("hasClass", className);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#hasData(java.lang.CharSequence)
      */
    public IJQStatement hasData(CharSequence element) {
        return chain("hasData", element);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#height(java.lang.CharSequence
      * [])
      */
    public IJQStatement height(CharSequence... args) {
        return chain("height", args);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#hide(java.lang.CharSequence[])
      */
    public IJQStatement hide(CharSequence... args) {
        return chain("hide", args);
    }

    /*
      * (non-Javadoc)
      *
      * @see com.google.code.jqwicket.api.IJQStatement#holdReady(boolean)
      */
    public IJQStatement holdReady(boolean hold) {
        return chain("holdReady", _(hold));
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#hover(java.lang.CharSequence[])
      */
    public IJQStatement hover(CharSequence... args) {
        return chain("hover", args);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#html(java.lang.CharSequence[])
      */
    public IJQStatement html(CharSequence... args) {
        return chain("html", args);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#inArray(java.lang.CharSequence,
      * java.lang.CharSequence)
      */
    public IJQStatement inArray(CharSequence value, CharSequence array) {
        return chain("inArray", value, array);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#index(java.lang.CharSequence[])
      */
    public IJQStatement index(CharSequence... args) {
        return chain("index", args);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#index(org.apache.wicket.Component
      * )
      */
    public IJQStatement index(Component component) {
        return chain("index", S.id(component));
    }

    /*
      * (non-Javadoc)
      *
      * @see com.google.code.jqwicket.api.IJQStatement#innerHeight()
      */
    public IJQStatement innerHeight() {
        return chain("innerHeight");
    }

    /*
      * (non-Javadoc)
      *
      * @see com.google.code.jqwicket.api.IJQStatement#innerWidth()
      */
    public IJQStatement innerWidth() {
        return chain("innerWidth");
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#insertAfter(java.lang.CharSequence
      * )
      */
    public IJQStatement insertAfter(CharSequence target) {
        return chain("insertAfter", target);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#insertAfter(org.apache.wicket
      * .Component)
      */
    public IJQStatement insertAfter(Component component) {
        return chain("insertAfter", S.id(component));
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#insertBefore(java.lang.CharSequence
      * )
      */
    public IJQStatement insertBefore(CharSequence target) {
        return chain("insertBefore", target);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#insertBefore(org.apache.wicket
      * .Component)
      */
    public IJQStatement insertBefore(Component component) {
        return chain("insertBefore", S.id(component));
    }

    /*
      * (non-Javadoc)
      *
      * @see com.google.code.jqwicket.api.IJQStatement#is(java.lang.CharSequence)
      */
    public IJQStatement is(CharSequence arg) {
        return chain("is", arg);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#is(org.apache.wicket.Component)
      */
    public IJQStatement is(Component component) {
        return chain("is", S.id(component));
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#isArray(java.lang.CharSequence)
      */
    public IJQStatement isArray(CharSequence obj) {
        return chain("isArray", obj);
    }

    /*
      * (non-Javadoc)
      *
      * @see com.google.code.jqwicket.api.IJQStatement#isEmptyObject(java.lang.
      * CharSequence)
      */
    public IJQStatement isEmptyObject(CharSequence obj) {
        return chain("isEmptyObject", obj);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#isFunction(java.lang.CharSequence
      * )
      */
    public IJQStatement isFunction(CharSequence obj) {
        return chain("isFunction", obj);
    }

    /*
      * (non-Javadoc)
      *
      * @see com.google.code.jqwicket.api.IJQStatement#isPlainObject(java.lang.
      * CharSequence)
      */
    public IJQStatement isPlainObject(CharSequence obj) {
        return chain("isPlainObject", obj);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#isWindow(java.lang.CharSequence
      * )
      */
    public IJQStatement isWindow(CharSequence obj) {
        return chain("isWindow", obj);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#isXMLDoc(java.lang.CharSequence
      * )
      */
    public IJQStatement isXMLDoc(CharSequence node) {
        return chain("isXMLDoc", node);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#keydown(java.lang.CharSequence
      * [])
      */
    public IJQStatement keydown(CharSequence... args) {
        return chain("keydown", args);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#keypress(java.lang.CharSequence
      * [])
      */
    public IJQStatement keypress(CharSequence... args) {
        return chain("keypress", args);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#keyup(java.lang.CharSequence[])
      */
    public IJQStatement keyup(CharSequence... args) {
        return chain("keyup", args);
    }

    /*
      * (non-Javadoc)
      *
      * @see com.google.code.jqwicket.api.IJQStatement#last()
      */
    public IJQStatement last() {
        return chain("last");
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#live(java.lang.CharSequence[])
      */
    public IJQStatement live(CharSequence... args) {
        return chain("live", args);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#load(java.lang.CharSequence[])
      */
    public IJQStatement load(CharSequence... args) {
        return chain("load", args);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#makeArray(java.lang.CharSequence
      * )
      */
    public IJQStatement makeArray(CharSequence obj) {
        return chain("makeArray", obj);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#map(java.lang.CharSequence[])
      */
    public IJQStatement map(CharSequence... args) {
        return chain("map", args);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#merge(java.lang.CharSequence,
      * java.lang.CharSequence)
      */
    public IJQStatement merge(CharSequence first, CharSequence second) {
        return chain("merge", first, second);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#mousedown(java.lang.CharSequence
      * [])
      */
    public IJQStatement mousedown(CharSequence... args) {
        return chain("mousedown", args);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#mouseenter(java.lang.CharSequence
      * [])
      */
    public IJQStatement mouseenter(CharSequence... args) {
        return chain("mouseenter", args);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#mouseleave(java.lang.CharSequence
      * [])
      */
    public IJQStatement mouseleave(CharSequence... args) {
        return chain("mouseleave", args);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#mousemove(java.lang.CharSequence
      * [])
      */
    public IJQStatement mousemove(CharSequence... args) {
        return chain("mousemove", args);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#mouseout(java.lang.CharSequence
      * [])
      */
    public IJQStatement mouseout(CharSequence... args) {
        return chain("mouseout", args);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#mouseover(java.lang.CharSequence
      * [])
      */
    public IJQStatement mouseover(CharSequence... args) {
        return chain("mouseover", args);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#mouseup(java.lang.CharSequence
      * [])
      */
    public IJQStatement mouseup(CharSequence... args) {
        return chain("mouseup", args);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#next(java.lang.CharSequence[])
      */
    public IJQStatement next(CharSequence... selector) {
        return chain("next", selector);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#next(org.apache.wicket.Component
      * )
      */
    public IJQStatement next(Component component) {
        return chain("next", S.id(component));
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#nextAll(java.lang.CharSequence
      * [])
      */
    public IJQStatement nextAll(CharSequence... selector) {
        return chain("nextAll", selector);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#nextAll(org.apache.wicket.Component
      * )
      */
    public IJQStatement nextAll(Component component) {
        return chain("nextAll", S.id(component));
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#nextUntil(java.lang.CharSequence
      * [])
      */
    public IJQStatement nextUntil(CharSequence... selector) {
        return chain("nextUntil", selector);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#nextUntil(org.apache.wicket
      * .Component)
      */
    public IJQStatement nextUntil(Component component) {
        return chain("nextUntil", S.id(component));
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#noConflict(java.lang.CharSequence
      * [])
      */
    public IJQStatement noConflict(CharSequence... args) {
        return chain("noConflict", args);
    }

    /*
      * (non-Javadoc)
      *
      * @see com.google.code.jqwicket.api.IJQStatement#noop()
      */
    public IJQStatement noop() {
        return chain("noop");
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#not(java.lang.CharSequence)
      */
    public IJQStatement not(CharSequence arg) {
        return chain("not", arg);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#not(org.apache.wicket.Component
      * )
      */
    public IJQStatement not(Component component) {
        return chain("not", S.id(component));
    }

    /*
      * (non-Javadoc)
      *
      * @see com.google.code.jqwicket.api.IJQStatement#now()
      */
    public IJQStatement now() {
        return chain("now");
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#offset(java.lang.CharSequence
      * [])
      */
    public IJQStatement offset(CharSequence... args) {
        return chain("offset", args);
    }

    /*
      * (non-Javadoc)
      *
      * @see com.google.code.jqwicket.api.IJQStatement#offsetParent()
      */
    public IJQStatement offsetParent() {
        return chain("offsetParent");
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#one(java.lang.CharSequence,
      * java.lang.CharSequence[])
      */
    public IJQStatement one(CharSequence eventType, CharSequence... args) {
        return chain("one", joinToArray(eventType, args));
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#outerHeight(java.lang.CharSequence
      * [])
      */
    public IJQStatement outerHeight(CharSequence... args) {
        return chain("outerHeight", args);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#outerWidth(java.lang.CharSequence
      * [])
      */
    public IJQStatement outerWidth(CharSequence... args) {
        return chain("outerWidth", args);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#param(java.lang.CharSequence,
      * java.lang.CharSequence[])
      */
    public IJQStatement param(CharSequence param, CharSequence... args) {
        return chain("param", joinToArray(param, args));
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#parent(java.lang.CharSequence
      * [])
      */
    public IJQStatement parent(CharSequence... selector) {
        return chain("parent", selector);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#parent(org.apache.wicket.Component
      * )
      */
    public IJQStatement parent(Component component) {
        return chain("parent", S.id(component));
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#parents(java.lang.CharSequence
      * [])
      */
    public IJQStatement parents(CharSequence... selector) {
        return chain("parents", selector);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#parents(org.apache.wicket.Component
      * )
      */
    public IJQStatement parents(Component component) {
        return chain("parents", S.id(component));
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#parentsUntil(java.lang.CharSequence
      * [])
      */
    public IJQStatement parentsUntil(CharSequence... selector) {
        return chain("parentsUntil", selector);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#parentsUntil(org.apache.wicket
      * .Component)
      */
    public IJQStatement parentsUntil(Component component) {
        return chain("parentsUntil", S.id(component));
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#parseJSON(java.lang.CharSequence
      * )
      */
    public IJQStatement parseJSON(CharSequence json) {
        return chain("parseJSON", json);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#parseXML(java.lang.CharSequence
      * )
      */
    public IJQStatement parseXML(CharSequence data) {
        return chain("parseXML", data);
    }

    /*
      * (non-Javadoc)
      *
      * @see com.google.code.jqwicket.api.IJQStatement#position()
      */
    public IJQStatement position() {
        return chain("position");
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#post(java.lang.CharSequence,
      * java.lang.CharSequence[])
      */
    public IJQStatement post(CharSequence url, CharSequence... args) {
        return chain("post", joinToArray(url, args));
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#prepend(java.lang.CharSequence
      * [])
      */
    public IJQStatement prepend(CharSequence... args) {
        return chain("prepend", args);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#prependTo(java.lang.CharSequence
      * )
      */
    public IJQStatement prependTo(CharSequence target) {
        return chain("prependTo", target);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#prependTo(org.apache.wicket
      * .Component)
      */
    public IJQStatement prependTo(Component component) {
        return chain("prependTo", S.id(component));
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#prev(java.lang.CharSequence[])
      */
    public IJQStatement prev(CharSequence... selector) {
        return chain("prev", selector);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#prev(org.apache.wicket.Component
      * )
      */
    public IJQStatement prev(Component component) {
        return chain("prev", S.id(component));
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#prevAll(java.lang.CharSequence
      * [])
      */
    public IJQStatement prevAll(CharSequence... selector) {
        return chain("prevAll", selector);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#prevAll(org.apache.wicket.Component
      * )
      */
    public IJQStatement prevAll(Component component) {
        return chain("prevAll", S.id(component));
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#prevUntil(java.lang.CharSequence
      * [])
      */
    public IJQStatement prevUntil(CharSequence... selector) {
        return chain("prevUntil", selector);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#prevUntil(org.apache.wicket
      * .Component)
      */
    public IJQStatement prevUntil(Component component) {
        return chain("prevUntil", S.id(component));
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#promise(java.lang.CharSequence
      * [])
      */
    public IJQStatement promise(CharSequence... args) {
        return chain("promise", args);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#prop(java.lang.CharSequence[])
      */
    public IJQStatement prop(CharSequence... args) {
        return chain("prop", args);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#proxy(java.lang.CharSequence,
      * java.lang.CharSequence)
      */
    public IJQStatement proxy(CharSequence first, CharSequence second) {
        return chain("proxy", first, second);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#pushStack(java.lang.CharSequence
      * , java.lang.CharSequence[])
      */
    public IJQStatement pushStack(CharSequence elements, CharSequence... args) {
        return chain("pushStack", joinToArray(elements, args));
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#queue(java.lang.CharSequence[])
      */
    public IJQStatement queue(CharSequence... args) {
        return chain("queue", args);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#ready(java.lang.CharSequence)
      */
    public IJQStatement ready(CharSequence handler) {
        return chain("ready", handler);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#remove(java.lang.CharSequence
      * [])
      */
    public IJQStatement remove(CharSequence... selector) {
        return chain("remove", selector);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#remove(org.apache.wicket.Component
      * )
      */
    public IJQStatement remove(Component component) {
        return chain("remove", S.id(component));
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#removeAttr(java.lang.CharSequence
      * )
      */
    public IJQStatement removeAttr(CharSequence attributeName) {
        return chain("removeAttr", attributeName);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#removeClass(java.lang.CharSequence
      * [])
      */
    public IJQStatement removeClass(CharSequence... args) {
        return chain("removeClass", args);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#removeData(java.lang.CharSequence
      * [])
      */
    public IJQStatement removeData(CharSequence... args) {
        return chain("removeData", args);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#removeProp(java.lang.CharSequence
      * , java.lang.CharSequence)
      */
    public IJQStatement removeProp(CharSequence propertyName, CharSequence value) {
        return chain("removeProp", propertyName, value);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#replaceAll(java.lang.CharSequence
      * )
      */
    public IJQStatement replaceAll(CharSequence target) {
        return chain("replaceAll", target);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#replaceAll(org.apache.wicket
      * .Component)
      */
    public IJQStatement replaceAll(Component component) {
        return chain("replaceAll", S.id(component));
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#replaceWith(java.lang.CharSequence
      * )
      */
    public IJQStatement replaceWith(CharSequence arg) {
        return chain("replaceWith", arg);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#resize(java.lang.CharSequence
      * [])
      */
    public IJQStatement resize(CharSequence... args) {
        return chain("resize", args);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#scroll(java.lang.CharSequence
      * [])
      */
    public IJQStatement scroll(CharSequence... args) {
        return chain("scroll", args);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#scrollLeft(java.lang.CharSequence
      * [])
      */
    public IJQStatement scrollLeft(CharSequence... args) {
        return chain("scrollLeft", args);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#scrollTop(java.lang.CharSequence
      * [])
      */
    public IJQStatement scrollTop(CharSequence... args) {
        return chain("scrollTop", args);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#select(java.lang.CharSequence
      * [])
      */
    public IJQStatement select(CharSequence... args) {
        return chain("select", args);
    }

    /*
      * (non-Javadoc)
      *
      * @see com.google.code.jqwicket.api.IJQStatement#serialize()
      */
    public IJQStatement serialize() {
        return chain("serialize");
    }

    /*
      * (non-Javadoc)
      *
      * @see com.google.code.jqwicket.api.IJQStatement#serializeArray()
      */
    public IJQStatement serializeArray() {
        return chain("serializeArray");
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#show(java.lang.CharSequence[])
      */
    public IJQStatement show(CharSequence... args) {
        return chain("show", args);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#siblings(java.lang.CharSequence
      * [])
      */
    public IJQStatement siblings(CharSequence... selector) {
        return chain("siblings", selector);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#siblings(org.apache.wicket.
      * Component)
      */
    public IJQStatement siblings(Component component) {
        return chain("siblings", S.id(component));
    }

    /*
      * (non-Javadoc)
      *
      * @see com.google.code.jqwicket.api.IJQStatement#size()
      */
    public IJQStatement size() {
        return chain("size");
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#slice(java.lang.CharSequence,
      * java.lang.CharSequence[])
      */
    public IJQStatement slice(CharSequence start, CharSequence... end) {
        return chain("slice", joinToArray(start, end));
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#slideDown(java.lang.CharSequence
      * [])
      */
    public IJQStatement slideDown(CharSequence... args) {
        return chain("slideDown", args);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#slideToggle(java.lang.CharSequence
      * [])
      */
    public IJQStatement slideToggle(CharSequence... args) {
        return chain("slideToggle", args);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#slideUp(java.lang.CharSequence
      * [])
      */
    public IJQStatement slideUp(CharSequence... args) {
        return chain("slideUp", args);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#stop(java.lang.CharSequence[])
      */
    public IJQStatement stop(CharSequence... args) {
        return chain("stop", args);
    }

    /*
      * (non-Javadoc)
      *
      * @see com.google.code.jqwicket.api.IJQStatement#sub()
      */
    public IJQStatement sub() {
        return chain("sub");
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#submit(java.lang.CharSequence
      * [])
      */
    public IJQStatement submit(CharSequence... args) {
        return chain("submit", args);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#text(java.lang.CharSequence[])
      */
    public IJQStatement text(CharSequence... args) {
        return chain("text", args);
    }

    /*
      * (non-Javadoc)
      *
      * @see com.google.code.jqwicket.api.IJQStatement#toArray()
      */
    public IJQStatement toArray() {
        return chain("toArray");
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#toggle(java.lang.CharSequence
      * [])
      */
    public IJQStatement toggle(CharSequence... args) {
        return chain("toggle", args);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#toggleClass(java.lang.CharSequence
      * [])
      */
    public IJQStatement toggleClass(CharSequence... args) {
        return chain("toggleClass", args);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#trigger(java.lang.CharSequence,
      * java.lang.CharSequence[])
      */
    public IJQStatement trigger(CharSequence event, CharSequence... args) {
        return chain("trigger", joinToArray(event, args));
    }

    /*
      * (non-Javadoc)
      *
      * @see com.google.code.jqwicket.api.IJQStatement#triggerHandler(java.lang.
      * CharSequence, java.lang.CharSequence)
      */
    public IJQStatement triggerHandler(CharSequence eventType,
                                       CharSequence extraParameters) {
        return chain("triggerHandler", eventType, extraParameters);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#trim(java.lang.CharSequence)
      */
    public IJQStatement trim(CharSequence str) {
        return chain("trim", str);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#type(java.lang.CharSequence)
      */
    public IJQStatement type(CharSequence obj) {
        return chain("type", obj);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#unbind(java.lang.CharSequence
      * [])
      */
    public IJQStatement unbind(CharSequence... args) {
        return chain("unbind", args);
    }

    /*
      * (non-Javadoc)
      *
      * @see com.google.code.jqwicket.api.IJQStatement#unwrap()
      */
    public IJQStatement unwrap() {
        return chain("unwrap");
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#val(java.lang.CharSequence[])
      */
    public IJQStatement val(CharSequence... args) {
        return chain("val", args);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#when(java.lang.CharSequence)
      */
    public IJQStatement when(CharSequence deferreds) {
        return chain("when", deferreds);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#width(java.lang.CharSequence[])
      */
    public IJQStatement width(CharSequence... args) {
        return chain("width", args);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#wrapAll(java.lang.CharSequence)
      */
    public IJQStatement wrapAll(CharSequence wrappingElement) {
        return chain("wrapAll", wrappingElement);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#wrapAll(org.apache.wicket.Component
      * )
      */
    public IJQStatement wrapAll(Component component) {
        return chain("wrapAll", S.id(component));
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#wrapInner(java.lang.CharSequence
      * )
      */
    public IJQStatement wrapInner(CharSequence arg) {
        return chain("wrapInner", arg);
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * com.google.code.jqwicket.api.IJQStatement#wrapInner(org.apache.wicket
      * .Component)
      */
    public IJQStatement wrapInner(Component component) {
        return chain("wrapInner", S.id(component));
    }

    private CharSequence[] joinToArray(CharSequence first,
                                       CharSequence... other) {
        return join(new CharSequence[]{first}, other);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.google.code.jqwicket.api.IJQStatement#toJQBehavior()
     */
    public JQBehavior toJQBehavior() {
        return new JQBehavior(this);
    }
}
