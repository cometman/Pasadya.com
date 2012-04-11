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

import com.google.code.jqwicket.api.AbstractJQOptions;
import com.google.code.jqwicket.api.IJQFunction;
import com.google.code.jqwicket.api.IJQStatement;
import org.apache.wicket.request.resource.JavaScriptResourceReference;

import static com.google.code.jqwicket.api.JQuery.$f;
import static com.google.code.jqwicket.api.JQuery.js;

/**
 * @author mkalina
 */
public class TabsOptions extends AbstractJQOptions<TabsOptions> {

    private static final long serialVersionUID = 1L;

    private static final JavaScriptResourceReference jsCookieResource = new JavaScriptResourceReference(
            TabsOptions.class, "jquery.cookie.js");

    /**
     * Disables (true) or enables (false) the tabs. Can be set when initialising (first creating) the tabs. Default:false
     *
     * @param disabled
     * @return
     */
    public TabsOptions disabled(boolean disabled) {
        return super.put("disabled", disabled);
    }

    /**
     * Additional Ajax options to consider when loading tab content. Default:null
     *
     * @param ajaxOptions
     * @return
     */
    public TabsOptions ajaxOptions(CharSequence ajaxOptions) {
        return super.put("ajaxOptions", ajaxOptions);
    }

    /**
     * Whether or not to cache remote tabs content, e.g. load only once or with every click. Cached content is being lazy
     * loaded, e.g once and only once for the first click. Note that to prevent the actual Ajax requests from being cached
     * by the browser you need to provide an extra cache: false flag to ajaxOptions. Default:false
     *
     * @param cache
     * @return
     */
    public TabsOptions cache(boolean cache) {
        return super.put("cache", cache);
    }

    /**
     * Set to true to allow an already selected tab to become unselected again upon reselection. Default:false
     *
     * @param collapsible
     * @return
     */
    public TabsOptions collapsible(boolean collapsible) {
        return super.put("collapsible", collapsible);
    }

    /**
     * Store the latest selected tab in a cookie. The cookie is then used to determine the initially selected tab if the
     * selected option is not defined. Requires cookie plugin. The object needs to have key/value pairs of the form the
     * cookie plugin expects as options. Available options (example): { expires: 7, path: '/', domain: 'jquery.com',
     * secure: true }. Since jQuery UI 1.7 it is also possible to define the cookie name being used via name property.
     * Default:null
     *
     * @param cookie
     * @return
     */
    public TabsOptions cookie(CharSequence cookie) {
        return super.put("cookie", cookie)
                .addJsResourceReferences(jsCookieResource)
                .addJsResourceReferencesMin(jsCookieResource);
    }

    /**
     * An array containing the position of the tabs (zero-based index) that should be disabled on initialization.
     * Default:[]
     *
     * @param disabled
     * @return
     */
    public TabsOptions disabled(int... disabled) {
        return super.put("disabled", disabled);
    }

    /**
     * The type of event to be used for selecting a tab. Default:'click'
     *
     * @param event
     * @return
     */
    public TabsOptions event(CharSequence event) {
        return super.put("event", event);
    }

    /**
     * Enable animations for hiding and showing tab panels. The duration option can be a string representing one of the
     * three predefined speeds ("slow", "normal", "fast") or the duration in milliseconds to run an animation (default is
     * "normal"). Default:null
     *
     * @param fx
     * @return
     */
    public TabsOptions fx(CharSequence fx) {
        return super.put("fx", fx);
    }

    /**
     * If the remote tab, its anchor element that is, has no title attribute to generate an id from, an id/fragment
     * identifier is created from this prefix and a unique id returned by $.data(el), for example "ui-tabs-54".
     * Default:'ui-tabs-'
     *
     * @param idPrefix
     * @return
     */
    public TabsOptions idPrefix(CharSequence idPrefix) {
        return super.put("idPrefix", idPrefix);
    }

    /**
     * HTML template from which a new tab panel is created in case of adding a tab with the add method or when creating a
     * panel for a remote tab on the fly.
     *
     * @param panelTemplate
     * @return
     */
    public TabsOptions panelTemplate(CharSequence panelTemplate) {
        return super.put("panelTemplate", panelTemplate);
    }

    /**
     * Zero-based index of the tab to be selected on initialization. To set all tabs to unselected pass -1 as value.
     *
     * @param selected
     * @return
     */
    public TabsOptions selected(int selected) {
        return super.put("selected", selected);
    }

    /**
     * The HTML content of this string is shown in a tab title while remote content is loading. Pass in empty string to
     * deactivate that behavior. An span element must be present in the A tag of the title, for the spinner content to be
     * visible.
     *
     * @param spinner
     * @return
     */
    public TabsOptions spinner(CharSequence spinner) {
        return super.put("spinner", spinner);
    }

    /**
     * HTML template from which a new tab is created and added. The placeholders #{href} and #{label} are replaced with the
     * url and tab label that are passed as arguments to the add method.
     *
     * @param tabTemplate
     * @return
     */
    public TabsOptions tabTemplate(CharSequence tabTemplate) {
        return super.put("tabTemplate", tabTemplate);
    }

    /**
     * This event is triggered when clicking a tab.
     *
     * @param callbackBody
     * @return
     */
    public TabsOptions selectEvent(CharSequence callbackBody) {
        return this.selectEvent(js(callbackBody));
    }

    /**
     * This event is triggered when clicking a tab.
     *
     * @param callbackBody
     * @return
     */
    public TabsOptions selectEvent(IJQStatement callbackBody) {
        return this.selectEvent($f(callbackBody).withParams("event", "ui"));
    }

    /**
     * This event is triggered when clicking a tab.
     *
     * @param callback
     * @return
     */
    public TabsOptions selectEvent(IJQFunction callback) {
        return super.put("select", callback);
    }

    /**
     * This event is triggered after the content of a remote tab has been loaded.
     *
     * @param callbackBody
     * @return
     */
    public TabsOptions loadEvent(CharSequence callbackBody) {
        return this.loadEvent(js(callbackBody));
    }

    /**
     * This event is triggered after the content of a remote tab has been loaded.
     *
     * @param callbackBody
     * @return
     */
    public TabsOptions loadEvent(IJQStatement callbackBody) {
        return this.loadEvent($f(callbackBody).withParams("event", "ui"));
    }

    /**
     * This event is triggered after the content of a remote tab has been loaded.
     *
     * @param callback
     * @return
     */
    public TabsOptions loadEvent(IJQFunction callback) {
        return super.put("load", callback);
    }

    /**
     * This event is triggered when a tab is shown.
     *
     * @param callbackBody
     * @return
     */
    public TabsOptions showEvent(CharSequence callbackBody) {
        return this.showEvent(js(callbackBody));
    }

    /**
     * This event is triggered when a tab is shown.
     *
     * @param callbackBody
     * @return
     */
    public TabsOptions showEvent(IJQStatement callbackBody) {
        return this.showEvent($f(callbackBody).withParams("event", "ui"));
    }

    /**
     * This event is triggered when a tab is shown.
     *
     * @param callback
     * @return
     */
    public TabsOptions showEvent(IJQFunction callback) {
        return super.put("show", callback);
    }

    /**
     * This event is triggered when a tab is added.
     *
     * @param callbackBody
     * @return
     */
    public TabsOptions addEvent(CharSequence callbackBody) {
        return this.addEvent(js(callbackBody));
    }

    /**
     * This event is triggered when a tab is added.
     *
     * @param callbackBody
     * @return
     */
    public TabsOptions addEvent(IJQStatement callbackBody) {
        return this.addEvent($f(callbackBody).withParams("event", "ui"));
    }

    /**
     * This event is triggered when a tab is added.
     *
     * @param callback
     * @return
     */
    public TabsOptions addEvent(IJQFunction callback) {
        return super.put("add", callback);
    }

    /**
     * This event is triggered when a tab is removed.
     *
     * @param callbackBody
     * @return
     */
    public TabsOptions removeEvent(CharSequence callbackBody) {
        return this.removeEvent(js(callbackBody));
    }

    /**
     * This event is triggered when a tab is removed.
     *
     * @param callbackBody
     * @return
     */
    public TabsOptions removeEvent(IJQStatement callbackBody) {
        return this.removeEvent($f(callbackBody).withParams("event", "ui"));
    }

    /**
     * This event is triggered when a tab is removed.
     *
     * @param callback
     * @return
     */
    public TabsOptions removeEvent(IJQFunction callback) {
        return super.put("remove", callback);
    }

    /**
     * This event is triggered when a tab is enabled.
     *
     * @param callbackBody
     * @return
     */
    public TabsOptions enableEvent(CharSequence callbackBody) {
        return this.enableEvent(js(callbackBody));
    }

    /**
     * This event is triggered when a tab is enabled.
     *
     * @param callbackBody
     * @return
     */
    public TabsOptions enableEvent(IJQStatement callbackBody) {
        return this.enableEvent($f(callbackBody).withParams("event", "ui"));
    }

    /**
     * This event is triggered when a tab is enabled.
     *
     * @param callback
     * @return
     */
    public TabsOptions enableEvent(IJQFunction callback) {
        return super.put("enable", callback);
    }

    /**
     * This event is triggered when a tab is disabled.
     *
     * @param callbackBody
     * @return
     */
    public TabsOptions disableEvent(CharSequence callbackBody) {
        return this.disableEvent(js(callbackBody));
    }

    /**
     * This event is triggered when a tab is disabled.
     *
     * @param callbackBody
     * @return
     */
    public TabsOptions disableEvent(IJQStatement callbackBody) {
        return this.disableEvent($f(callbackBody).withParams("event", "ui"));
    }

    /**
     * This event is triggered when a tab is disabled.
     *
     * @param callback
     * @return
     */
    public TabsOptions disableEvent(IJQFunction callback) {
        return super.put("disable", callback);
    }

}
