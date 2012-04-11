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
package com.google.code.jqwicket.ui.blockui;

import com.google.code.jqwicket.api.AbstractJQOptions;
import com.google.code.jqwicket.api.IJQFunction;
import com.google.code.jqwicket.api.IJQStatement;
import org.apache.wicket.request.resource.JavaScriptResourceReference;

import static com.google.code.jqwicket.api.JQuery.$f;
import static com.google.code.jqwicket.api.JQuery.js;

/**
 * @author mkalina
 */
public class BlockUIOptions extends AbstractJQOptions<BlockUIOptions> {

    private static final long serialVersionUID = 1L;

    public static final JavaScriptResourceReference JS_RESOURCE = new JavaScriptResourceReference(
            BlockUIOptions.class, "jquery.blockUI.js");

    public BlockUIOptions() {
        this.setJsResourceReferences(JS_RESOURCE);
        this.setJsResourceReferencesMin(JS_RESOURCE);
    }

    /**
     * message displayed when blocking (use null for no message)
     *
     * @param message
     * @return
     */
    public BlockUIOptions message(CharSequence message) {
        return super.put("message", message);
    }

    /**
     * styles for the message when blocking; if you wish to disable these and use an external stylesheet then do this in
     * your code: $.blockUI.defaults.css = {};
     * <p/>
     * <br> defaults:<br>
     * <p/>
     * <pre>
     * css: {
     *         padding:        0,
     *         margin:         0,
     *         width:          '30%',
     *         top:            '40%',
     *         left:           '35%',
     *         textAlign:      'center',
     *         color:          '#000',
     *         border:         '3px solid #aaa',
     *         backgroundColor:'#fff',
     *         cursor:         'wait'
     *     }
     * </pre>
     *
     * @param css
     * @return
     */
    public BlockUIOptions css(CharSequence css) {
        return super.put("css", css);
    }

    /**
     * styles for the overlay <br> <br> defaults:<br>
     * <p/>
     * <pre>
     * overlayCSS:  {
     *         backgroundColor: '#000',
     *         opacity:         0.6
     *     }
     * </pre>
     *
     * @param overlayCSS
     * @return
     */
    public BlockUIOptions overlayCSS(CharSequence overlayCSS) {
        return super.put("overlayCSS", overlayCSS);
    }

    /**
     * styles applied when using $.growlUI <br> defaults:<br>
     * <p/>
     * <pre>
     * growlCSS: {
     *         width:    '350px',
     *         top:      '10px',
     *         left:     '',
     *         right:    '10px',
     *         border:   'none',
     *         padding:  '5px',
     *         opacity:   0.6,
     *         cursor:    null,
     *         color:    '#fff',
     *         backgroundColor: '#000',
     *         '-webkit-border-radius': '10px',
     *         '-moz-border-radius':    '10px'
     *     }
     * </pre>
     *
     * @param growlCSS
     * @return
     */
    public BlockUIOptions growlCSS(CharSequence growlCSS) {
        return super.put("growlCSS", growlCSS);
    }

    /**
     * IE issues: 'about:blank' fails on HTTPS and javascript:false is s-l-o-w (hat tip to Jorge H. N. de Vasconcelos) <br>
     * default:<br>
     * <p/>
     * <pre>
     * iframeSrc: /^https/i.test(window.location.href || '') ? 'javascript:false' : 'about:blank'
     * </pre>
     *
     * @param iframeSrc
     * @return
     */
    public BlockUIOptions iframeSrc(CharSequence iframeSrc) {
        return super.put("iframeSrc", iframeSrc);
    }

    /**
     * force usage of iframe in non-IE browsers (handy for blocking applets) <br> default:<br>
     * <p/>
     * <pre>
     * forceIframe: false
     * </pre>
     *
     * @param forceIframe
     * @return
     */
    public BlockUIOptions forceIframe(boolean forceIframe) {
        return super.put("forceIframe", forceIframe);
    }

    /**
     * z-index for the blocking overlay <br> default:<br>
     * <p/>
     * <pre>
     * baseZ: 1000
     * </pre>
     *
     * @param baseZ
     * @return
     */
    public BlockUIOptions baseZ(int baseZ) {
        return super.put("baseZ", baseZ);
    }

    /**
     * set these to true to have the message automatically centered (only effects element blocking (page block controlled
     * via css above) )<br> default:<br>
     * <p/>
     * <pre>
     * centerX: true
     * </pre>
     *
     * @param centerX
     * @return
     */
    public BlockUIOptions centerX(boolean centerX) {
        return super.put("centerX", centerX);
    }

    /**
     * set these to true to have the message automatically centered <br> default:<br>
     * <p/>
     * <pre>
     * centerY: true
     * </pre>
     *
     * @param centerY
     * @return
     */
    public BlockUIOptions centerY(boolean centerY) {
        return super.put("centerY", centerY);
    }

    /**
     * allow body element to be stetched in ie6; this makes blocking look better on "short" pages. disable if you wish to
     * prevent changes to the body height <br> default:<br>
     * <p/>
     * <pre>
     * allowBodyStretch: true
     * </pre>
     *
     * @param allowBodyStretch
     * @return
     */
    public BlockUIOptions allowBodyStretch(boolean allowBodyStretch) {
        return super.put("allowBodyStretch", allowBodyStretch);
    }

    /**
     * enable if you want key and mouse events to be disabled for content that is blocked <br> default:<br>
     * <p/>
     * <pre>
     * bindEvents: true
     * </pre>
     *
     * @param bindEvents
     * @return
     */
    public BlockUIOptions bindEvents(boolean bindEvents) {
        return super.put("bindEvents", bindEvents);
    }

    /**
     * be default blockUI will supress tab navigation from leaving blocking content (if bindEvents is true)<br>
     * default:<br>
     * <p/>
     * <pre>
     * constrainTabKey: true
     * </pre>
     *
     * @param constrainTabKey
     * @return
     */
    public BlockUIOptions constrainTabKey(boolean constrainTabKey) {
        return super.put("constrainTabKey", constrainTabKey);
    }

    /**
     * fadeIn time in millis; set to 0 to disable fadeIn on block<br> default:<br>
     * <p/>
     * <pre>
     * fadeIn:  200
     * </pre>
     *
     * @param fadeIn
     * @return
     */
    public BlockUIOptions fadeIn(int fadeIn) {
        return super.put("fadeIn", fadeIn);
    }

    /**
     * fadeOut time in millis; set to 0 to disable fadeOut on unblock <br> default:<br>
     * <p/>
     * <pre>
     * fadeOut:  400
     * </pre>
     *
     * @param fadeOut
     * @return
     */
    public BlockUIOptions fadeOut(int fadeOut) {
        return super.put("fadeOut", fadeOut);
    }

    /**
     * time in millis to wait before auto-unblocking; set to 0 to disable auto-unblock <br> default:<br>
     * <p/>
     * <pre>
     * timeout: 0
     * </pre>
     *
     * @param timeout
     * @return
     */
    public BlockUIOptions timeout(int timeout) {
        return super.put("timeout", timeout);
    }

    /**
     * disable if you don't want to show the overlay <br> default:<br>
     * <p/>
     * <pre>
     * showOverlay: true
     * </pre>
     *
     * @param showOverlay
     * @return
     */
    public BlockUIOptions showOverlay(boolean showOverlay) {
        return super.put("showOverlay", showOverlay);
    }

    /**
     * if true, focus will be placed in the first available input field when page blocking<br> default:<br>
     * <p/>
     * <pre>
     * focusInput: true
     * </pre>
     *
     * @param focusInput
     * @return
     */
    public BlockUIOptions focusInput(boolean focusInput) {
        return super.put("focusInput", focusInput);
    }

    /**
     * suppresses the use of overlay styles on FF/Linux (due to performance issues with opacity)<br> default:<br>
     * <p/>
     * <pre>
     * applyPlatformOpacityRules: true
     * </pre>
     *
     * @param applyPlatformOpacityRules
     * @return
     */
    public BlockUIOptions applyPlatformOpacityRules(
            boolean applyPlatformOpacityRules) {
        return super
                .put("applyPlatformOpacityRules", applyPlatformOpacityRules);
    }

    /**
     * don't ask; if you really must know: <a href="http://groups.google.com/group/jquery-
     * en/browse_thread/thread/36640a8730503595 /2f6a79a77a78e493#2f6a79a77a78e493 ">http://groups.google.com/group/jquery-
     * en/browse_thread/thread/36640a8730503595 /2f6a79a77a78e493#2f6a79a77a78e493</a> <br> default:<br>
     * <p/>
     * <pre>
     * quirksmodeOffsetHack: 4
     * </pre>
     *
     * @param quirksmodeOffsetHack
     * @return
     */
    public BlockUIOptions quirksmodeOffsetHack(int quirksmodeOffsetHack) {
        return super.put("quirksmodeOffsetHack", quirksmodeOffsetHack);
    }

    /**
     * callback method invoked when unblocking has completed; the callback is passed the element that has been unblocked
     * (which is the window object for page blocks) and the options that were passed to the unblock call:
     * onUnblock(element, options)<br>
     * <p/>
     * default:<br>
     * <p/>
     * <pre>
     * onUnblock: null
     * </pre>
     *
     * @param callbackBody
     * @return
     */
    public BlockUIOptions itemVisibleInEvent(CharSequence callbackBody) {
        return this.itemVisibleInEvent(js(callbackBody));
    }

    /**
     * callback method invoked when unblocking has completed; the callback is passed the element that has been unblocked
     * (which is the window object for page blocks) and the options that were passed to the unblock call:
     * onUnblock(element, options)<br>
     * <p/>
     * default:<br>
     * <p/>
     * <pre>
     * onUnblock: null
     * </pre>
     *
     * @param callbackBody
     * @return
     */
    public BlockUIOptions itemVisibleInEvent(IJQStatement callbackBody) {
        return this.itemVisibleInEvent($f(callbackBody).withParams("element",
                "options"));
    }

    /**
     * callback method invoked when unblocking has completed; the callback is passed the element that has been unblocked
     * (which is the window object for page blocks) and the options that were passed to the unblock call:
     * onUnblock(element, options)<br>
     * <p/>
     * default:<br>
     * <p/>
     * <pre>
     * onUnblock: null
     * </pre>
     *
     * @param callback
     * @return
     */
    public BlockUIOptions itemVisibleInEvent(IJQFunction callback) {
        super.put("onUnblock", callback);
        return this;
    }
}
