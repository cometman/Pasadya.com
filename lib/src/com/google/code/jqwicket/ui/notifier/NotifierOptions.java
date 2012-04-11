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
package com.google.code.jqwicket.ui.notifier;

import com.google.code.jqwicket.api.AbstractJQOptions;
import com.google.code.jqwicket.api.IJQFunction;
import com.google.code.jqwicket.api.IJQStatement;
import org.apache.wicket.request.resource.CssResourceReference;
import org.apache.wicket.request.resource.JavaScriptResourceReference;

import static com.google.code.jqwicket.api.JQuery.$f;
import static com.google.code.jqwicket.api.JQuery.js;

/**
 * @author mkalina
 */
public class NotifierOptions extends AbstractJQOptions<NotifierOptions> {

    private static final long serialVersionUID = 1L;

    public static final JavaScriptResourceReference JS_RESOURCE = new JavaScriptResourceReference(
            NotifierOptions.class, "jquery.notify.js");

    public static final JavaScriptResourceReference JS_RESOURCE_MIN = new JavaScriptResourceReference(
            NotifierOptions.class, "jquery.notify.min.js");

    public static final CssResourceReference CSS_RESOURCE = new CssResourceReference(
            NotifierOptions.class, "ui.notify.css");

    public enum Stack {
        BELOW, ABOVE;
    }

    public NotifierOptions() {
        this.setJsResourceReferences(JS_RESOURCE);
        this.setJsResourceReferencesMin(JS_RESOURCE_MIN);
        this.setCssResourceReferences(CSS_RESOURCE);
    }

    /**
     * The amount of time in milliseconds to fade notifications in and out. Default: 500
     *
     * @param speed is a speed value to use
     * @return
     */
    public NotifierOptions speed(int speed) {
        super.put("speed", speed);
        return this;
    }

    /**
     * Notifications will automatically close after this amount of time, in milliseconds. Set to 0 or false to create a
     * &ldquo;sticky&rdquo; notifications. Default: 5000
     *
     * @param expires
     * @return
     */
    public NotifierOptions expires(int expires) {
        super.put("expires", expires);
        return this;
    }

    /**
     * Notifications will automatically close after this amount of time, in milliseconds. Set to 0 or false to create a
     * &ldquo;sticky&rdquo; notifications. Default: 5000
     *
     * @param expires
     * @return
     */
    public NotifierOptions expires(boolean expires) {
        super.put("expires", expires);
        return this;
    }

    /**
     * Notifications will stack downwards if set to &ldquo;below&rdquo; (default), or upwards if set to
     * &ldquo;above.&rdquo; Default: below
     *
     * @param stack
     * @return
     */
    public NotifierOptions stack(Stack stack) {
        super.put("stack", stack);
        return this;
    }

    /**
     * A boolean value denoting whether or not the widget should apply its own styling classes. Set to false to roll
     * your own notification themes (including ThemeRoller). You could simply overwrite the included CSS, but using this
     * option allows you to create default AND custom notifications within the same containers, as well as maintain a
     * clear upgrade path as you won’t have to touch any of the included files. Default: false
     *
     * @param custom
     * @return
     */
    public NotifierOptions custom(boolean custom) {
        super.put("custom", custom);
        return this;
    }

    /**
     * Fires before the notification opens. If false is returned inside this callback, the notification will not open.
     *
     * @param callbackBody
     * @return
     */
    public NotifierOptions beforeOpenEvent(CharSequence callbackBody) {
        return this.beforeOpenEvent(js(callbackBody));
    }

    /**
     * Fires before the notification opens. If false is returned inside this callback, the notification will not open.
     *
     * @param callbackBody
     * @return
     */
    public NotifierOptions beforeOpenEvent(IJQStatement callbackBody) {
        return this.beforeOpenEvent($f(callbackBody));
    }

    /**
     * Fires before the notification opens. If false is returned inside this callback, the notification will not open.
     *
     * @param callback
     * @return
     */
    public NotifierOptions beforeOpenEvent(IJQFunction callback) {
        super.put("beforeopen", callback);
        return this;
    }

    /**
     * Fires after the notification opens.
     *
     * @param callbackBody
     * @return
     */
    public NotifierOptions openEvent(CharSequence callbackBody) {
        return this.openEvent(js(callbackBody));
    }

    /**
     * Fires after the notifcation opens.
     *
     * @param callbackBody
     * @return
     */
    public NotifierOptions openEvent(IJQStatement callbackBody) {
        return this.openEvent($f(callbackBody));
    }

    /**
     * Fires after the notifcation opens.
     *
     * @param callback
     * @return
     */
    public NotifierOptions openEvent(IJQFunction callback) {
        super.put("open", callback);
        return this;
    }

    /**
     * Fires after the notifcation closes.
     *
     * @param callbackBody
     * @return
     */
    public NotifierOptions closeEvent(CharSequence callbackBody) {
        return this.closeEvent(js(callbackBody));
    }

    /**
     * Fires after the notifcation closes.
     *
     * @param callbackBody
     * @return
     */
    public NotifierOptions closeEvent(IJQStatement callbackBody) {
        return this.closeEvent($f(callbackBody));
    }

    /**
     * Fires after the notifcation closes.
     *
     * @param callback
     * @return
     */
    public NotifierOptions closeEvent(IJQFunction callback) {
        super.put("close", callback);
        return this;
    }

    /**
     * Fires if the user clicks anywhere in the notification itself (not on the close link(s), if present). Useful if
     * you want to close the notification or perform some other action once the user has acknowledged the notice. The
     * callback receives two parameters as arguments: the event object, and the notification instance object.
     *
     * @param callbackBody
     * @return
     */
    public NotifierOptions clickEvent(CharSequence callbackBody) {
        return this.clickEvent(js(callbackBody));
    }

    /**
     * Fires if the user clicks anywhere in the notification itself (not on the close link(s), if present). Useful if
     * you want to close the notification or perform some other action once the user has acknowledged the notice. The
     * callback receives two parameters as arguments: the event object, and the notification instance object.
     *
     * @param callbackBody
     * @return
     */
    public NotifierOptions clickEvent(IJQStatement callbackBody) {
        return this.clickEvent($f(callbackBody).withParams("e", "instance"));
    }

    /**
     * Fires if the user clicks anywhere in the notification itself (not on the close link(s), if present). Useful if
     * you want to close the notification or perform some other action once the user has acknowledged the notice. The
     * callback receives two parameters as arguments: the event object, and the notification instance object.
     *
     * @param callback
     * @return
     */
    public NotifierOptions clickEvent(IJQFunction callback) {
        super.put("click", callback);
        return this;
    }

}
