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
package com.google.code.jqwicket.ui.uniform;


import com.google.code.jqwicket.api.AbstractJQOptions;
import org.apache.wicket.request.resource.CssResourceReference;
import org.apache.wicket.request.resource.JavaScriptResourceReference;

/**
 * @author mkalina
 */
public class UniformOptions extends AbstractJQOptions<UniformOptions> {

    private static final long serialVersionUID = 1L;

    public static final JavaScriptResourceReference JS_RESOURCE_MIN = new JavaScriptResourceReference(
            UniformOptions.class, "jquery.uniform.min.js");

    public static final JavaScriptResourceReference JS_RESOURCE = new JavaScriptResourceReference(
            UniformOptions.class, "jquery.uniform.js");

    public static final CssResourceReference CSS_RESOURCE_DEFAULT = new CssResourceReference(
            UniformOptions.class, "theme/uniform/css/uniform.default.css");

    public static final CssResourceReference CSS_RESOURCE_ARISTO = new CssResourceReference(
            UniformOptions.class, "theme/aristo/css/uniform.aristo.css");

    public UniformOptions() {
        this.setJsResourceReferences(JS_RESOURCE);
        this.setJsResourceReferencesMin(JS_RESOURCE_MIN);
        this.setCssResourceReferences(CSS_RESOURCE_DEFAULT);
    }

    /**
     * Default: "selector". <br/> Sets the class given to the wrapper div for select elements.
     * <p/>
     * <pre>
     * $("select").uniform({selectClass: 'mySelectClass'});
     * </pre>
     *
     * @param selectClass
     * @return
     */
    public UniformOptions selectClass(CharSequence selectClass) {
        super.put("selectClass", selectClass);
        return this;
    }

    /**
     * Default: "radio" <br/> Sets the class given to the wrapper div for radio elements.
     * <p/>
     * <pre>
     * $(":radio").uniform({radioClass: 'myRadioClass'});
     * </pre>
     *
     * @param radioClass
     * @return
     */
    public UniformOptions radioClass(CharSequence radioClass) {
        super.put("radioClass", radioClass);
        return this;
    }

    /**
     * Default: "checker" <br/> Sets the class given to the wrapper div for checkbox elements.
     * <p/>
     * <pre>
     * $(":checkbox").uniform({checkboxClass: 'myCheckClass'});
     * </pre>
     *
     * @param checkboxClass
     * @return
     */
    public UniformOptions checkboxClass(CharSequence checkboxClass) {
        super.put("checkboxClass", checkboxClass);
        return this;
    }

    /**
     * Default: "uploader"<br/> Sets the class given to the wrapper div for file upload elements.
     * <p/>
     * <pre>
     * $(":file").uniform({fileClass: 'myFileClass'});
     * </pre>
     *
     * @param fileClass
     * @return
     */
    public UniformOptions fileClass(CharSequence fileClass) {
        super.put("fileClass", fileClass);
        return this;
    }

    /**
     * Default: "filename"<br/> Sets the class given to div inside a file upload container that spits out the filename.
     * <p/>
     * <pre>
     * $(":file").uniform({filenameClass: 'myFilenameClass'});
     * </pre>
     *
     * @param filenameClass
     * @return
     */
    public UniformOptions filenameClass(CharSequence filenameClass) {
        super.put("filenameClass", filenameClass);
        return this;
    }

    /**
     * Default: "action"<br/> Sets the class given to div inside a file upload container that acts as the "Choose file"
     * button.
     * <p/>
     * <pre>
     * $(":file").uniform({fileBtnClass: 'myFileBtnClass'});
     * </pre>
     *
     * @param fileBtnClass
     * @return
     */
    public UniformOptions fileBtnClass(CharSequence fileBtnClass) {
        super.put("fileBtnClass", fileBtnClass);
        return this;
    }

    /**
     * Default: "No file selected"<br/> Sets the text written in the filename div of a file upload input when there is
     * no file selected.
     * <p/>
     * <pre>
     * $(":file").uniform({fileDefaultText: 'Select a file please'});
     * </pre>
     *
     * @param fileDefaultText
     * @return
     */
    public UniformOptions fileDefaultText(CharSequence fileDefaultText) {
        super.put("fileDefaultText", fileDefaultText);
        return this;
    }

    /**
     * Default: "Choose File"<br/> Sets the text written on the action button inside a file upload input. <br/>
     * <p/>
     * <pre>
     * $(":file").uniform({fileBtnText: 'Choose&hellip;'});
     * </pre>
     *
     * @param fileBtnText
     * @return
     */
    public UniformOptions fileBtnText(CharSequence fileBtnText) {
        super.put("fileBtnText", fileBtnText);
        return this;
    }

    /**
     * Default: "checked"<br/> Sets the class given to elements when they are checked (radios and checkboxes).
     * <p/>
     * <pre>
     * $(":radio, :checkbox").uniform({checkedClass: 'myCheckedClass'});
     * </pre>
     *
     * @param checkedClass
     * @return
     */
    public UniformOptions checkedClass(CharSequence checkedClass) {
        super.put("checkedClass", checkedClass);
        return this;
    }

    /**
     * Default: "focus"<br/> Sets the class given to elements when they are focused.
     * <p/>
     * <pre>
     * $("select").uniform({focusClass: 'myFocusClass'});
     * </pre>
     *
     * @param focusClass
     * @return
     */
    public UniformOptions focusClass(CharSequence focusClass) {
        super.put("focusClass", focusClass);
        return this;
    }

    /**
     * Default: "disabled"<br/> Sets the class given to elements when they are disabled.
     * <p/>
     * <pre>
     * $("select").uniform({disabledClass: 'myDisabledClass'});
     * </pre>
     *
     * @param disabledClass
     * @return
     */
    public UniformOptions disabledClass(CharSequence disabledClass) {
        super.put("disabledClass", disabledClass);
        return this;
    }

    /**
     * Default: "active"<br/> Sets the class given to elements when they are active (pressed).
     * <p/>
     * <pre>
     * $("select").uniform({activeClass: 'myActiveClass'});
     * </pre>
     *
     * @param activeClass
     * @return
     */
    public UniformOptions activeClass(CharSequence activeClass) {
        super.put("activeClass", activeClass);
        return this;
    }

    /**
     * Default: "hover"<br/> Sets the class given to elements when they are currently hovered.
     * <p/>
     * <pre>
     * $("select").uniform({hoverClass: 'myHoverClass'});
     * </pre>
     *
     * @param hoverClass
     * @return
     */
    public UniformOptions hoverClass(CharSequence hoverClass) {
        super.put("hoverClass", hoverClass);
        return this;
    }

    /**
     * Default: true<br/> If true, sets an ID on the container div of each form element. The ID is a prefixed version of
     * the same ID of the form element.
     * <p/>
     * <pre>
     * $("select").uniform({useID: false});
     * </pre>
     *
     * @param useID
     * @return
     */
    public UniformOptions useID(boolean useID) {
        super.put("useID", useID);
        return this;
    }

    /**
     * Default: "uniform"<br/> If useID is set to true, this string is prefixed to element ID’s and attached to the
     * container div of each uniformed element. If you have a checkbox with the ID of "remember-me" the container div
     * would have the ID "uniform-remember-me".
     * <p/>
     * <pre>
     * $("select").uniform({idPrefix: 'container'});
     * </pre>
     *
     * @param idPrefix
     * @return
     */
    public UniformOptions idPrefix(CharSequence idPrefix) {
        super.put("idPrefix", idPrefix);
        return this;
    }

    /**
     * Default: false<br/> This parameter allows you to use a jQuery-style selector to point to a "reset" button in your
     * form if you have one. Use false if you have no "reset" button, or a selector string that points to the reset
     * button if you have one.
     * <p/>
     * <pre>
     * $("select").uniform({resetSelector: 'input[type="reset"]'});
     * </pre>
     *
     * @param resetSelector
     * @return
     */
    public UniformOptions resetSelector(CharSequence resetSelector) {
        super.put("resetSelector", resetSelector);
        return this;
    }

    /**
     * Default: false<br/> This parameter allows you to use a jQuery-style selector to point to a "reset" button in your
     * form if you have one. Use false if you have no "reset" button, or a selector string that points to the reset
     * button if you have one.
     * <p/>
     * <pre>
     * $("select").uniform({resetSelector: 'input[type="reset"]'});
     * </pre>
     *
     * @param resetSelector
     * @return
     */
    public UniformOptions resetSelector(boolean resetSelector) {
        super.put("resetSelector", resetSelector);
        return this;
    }
}
