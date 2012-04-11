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
package com.google.code.jqwicket.ui.validationengine;

import com.google.code.jqwicket.Utils;
import com.google.code.jqwicket.api.AbstractJQOptions;
import com.google.code.jqwicket.api.IJQFunction;
import com.google.code.jqwicket.api.IJQStatement;
import org.apache.wicket.request.resource.CssResourceReference;
import org.apache.wicket.request.resource.JavaScriptResourceReference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static com.google.code.jqwicket.api.JQuery.$f;
import static com.google.code.jqwicket.api.JQuery.js;

/**
 * @author mkalina
 */
public class ValidationEngineOptions extends
        AbstractJQOptions<ValidationEngineOptions> {

    private static final long serialVersionUID = 1L;

    private static final JavaScriptResourceReference jsValidationEngineResource = new JavaScriptResourceReference(
            ValidationEngineOptions.class, "jquery.validationEngine.js");

    private static final CssResourceReference cssResource = new CssResourceReference(
            ValidationEngineOptions.class, "validationEngine.jquery.css");

    public static final JavaScriptResourceReference JS_VALIDATION_ENGINE_RULES_EN = new JavaScriptResourceReference(
            ValidationEngineOptions.class, "jquery.validationEngine-en.js");

    public static final JavaScriptResourceReference JS_VALIDATION_ENGINE_RULES_FR = new JavaScriptResourceReference(
            ValidationEngineOptions.class, "jquery.validationEngine-fr.js");

    public static final JavaScriptResourceReference JS_VALIDATION_ENGINE_RULES_ES = new JavaScriptResourceReference(
            ValidationEngineOptions.class, "jquery.validationEngine-es.js");

    public static final JavaScriptResourceReference JS_VALIDATION_ENGINE_RULES_PT = new JavaScriptResourceReference(
            ValidationEngineOptions.class, "jquery.validationEngine-pt.js");

    public enum PromptPosition {

        TOP_LEFT("topLeft"), TOP_RIGHT("topRight"), BOTTOM_LEFT("bottomLeft"), CENTER_RIGHT(
                "centerRight"), BOTTOM_RIGHT("bottomRight");

        private CharSequence value;

        private PromptPosition(CharSequence value) {
            this.value = value;
        }

        public CharSequence getValue() {
            return value;
        }

    }

    private List<ValidationRule<?>> validationRules;

    private boolean validationRulesResourceSpecified;

    public ValidationEngineOptions(ValidationRule<?>... rules) {
        this(true, rules);
    }

    public ValidationEngineOptions(boolean useDefaultRulesResource,
                                   ValidationRule<?>... rules) {
        setJsResourceReferences(jsValidationEngineResource,
                useDefaultRulesResource ? JS_VALIDATION_ENGINE_RULES_EN : null);
        setCssResourceReferences(cssResource);
        this.addValidationRules(rules);
        this.validationRulesResourceSpecified = useDefaultRulesResource;
    }

    /**
     * @param validationEngineRules is a reference to the javascript file containing validation rule definitions.
     */
    public ValidationEngineOptions(JavaScriptResourceReference validationEngineRules) {
        setJsResourceReferences(validationEngineRules,
                jsValidationEngineResource);
        setCssResourceReferences(cssResource);
        this.validationRulesResourceSpecified = true;
    }

    /**
     * @param validationEngineRulesUrl is a url to the javascript file containing validation rule definitions.
     */
    public ValidationEngineOptions(CharSequence validationEngineRulesUrl) {
        setJsResourceUrls(validationEngineRulesUrl);
        setJsResourceReferences(jsValidationEngineResource);
        setCssResourceReferences(cssResource);
        this.validationRulesResourceSpecified = true;
    }

    /**
     * @return the validationRulesResourceSpecified
     */
    public boolean isValidationRulesResourceSpecified() {
        return validationRulesResourceSpecified;
    }

    /**
     * Adds additional custom validation rules not available in the global validation-rules javascript file.
     *
     * @param rules
     * @return
     */
    public ValidationEngineOptions addValidationRules(
            ValidationRule<?>... rules) {

        if (Utils.isEmpty(rules))
            return this;

        if (this.validationRules == null)
            this.validationRules = new ArrayList<ValidationRule<?>>();

        this.validationRules.addAll(Arrays.asList(rules));
        return this;
    }

    public List<ValidationRule<?>> getValidationRules() {
        return validationRules;
    }

    public ValidationRule<?>[] getValidationRulesAsArray() {
        if (!hasValidationRules())
            return null;
        return this.validationRules
                .toArray(new ValidationRule<?>[this.validationRules.size()]);
    }

    @SuppressWarnings("rawtypes")
    public Collection<AjaxValidationRule> getAjaxValidationRules() {
        if (!hasValidationRules())
            return null;

        List<AjaxValidationRule> ajaxRules = new ArrayList<AjaxValidationRule>();
        for (ValidationRule r : this.validationRules) {
            if (r instanceof AjaxValidationRule)
                ajaxRules.add((AjaxValidationRule) r);
        }
        return ajaxRules;
    }

    @SuppressWarnings("rawtypes")
    public Collection<FuncValidationRule> getFuncValidationRules() {
        if (!hasValidationRules())
            return null;

        List<FuncValidationRule> rules = new ArrayList<FuncValidationRule>();
        for (ValidationRule r : this.validationRules) {
            if (r instanceof FuncValidationRule)
                rules.add((FuncValidationRule) r);
        }
        return rules;
    }

    public boolean hasValidationRules() {
        return Utils.isNotEmpty(this.validationRules);
    }

    /**
     * validate only on form submit or not
     *
     * @param inlineValidation
     * @return
     */
    public ValidationEngineOptions inlineValidation(boolean inlineValidation) {
        return super.put("inlineValidation", inlineValidation);
    }

    /**
     * the event that trigger the validation in the settings, default is blur
     *
     * @param validationEventTriggers
     * @return
     */
    public ValidationEngineOptions validationEventTriggers(
            CharSequence validationEventTriggers) {
        return super.put("validationEventTriggers", validationEventTriggers);
    }

    public ValidationEngineOptions scroll(boolean scroll) {
        return super.put("scroll", scroll);
    }

    /**
     * alert will return true or false
     *
     * @param returnIsValid
     * @return
     */
    public ValidationEngineOptions returnIsValid(boolean returnIsValid) {
        return super.put("returnIsValid", returnIsValid);
    }

    /**
     * Set true if you want the engine to stay binded on submit even if the success function is fired.
     *
     * @param unbindEngine
     * @return
     */
    public ValidationEngineOptions unbindEngine(boolean unbindEngine) {
        return super.put("unbindEngine", unbindEngine);
    }

    /**
     * @param promptPosition
     * @return
     */
    public ValidationEngineOptions promptPosition(PromptPosition promptPosition) {
        return super.put("promptPosition", promptPosition.value);
    }

    /**
     * Enable Overflown mode
     *
     * @param containerOverflow
     * @return
     */
    public ValidationEngineOptions containerOverflow(boolean containerOverflow) {
        return super.put("containerOverflow", containerOverflow);
    }

    /**
     * The actual DOM element container with overflow scroll on it
     *
     * @param containerOverflowDOM
     * @return
     */
    public ValidationEngineOptions containerOverflowDOM(
            CharSequence containerOverflowDOM) {
        return super.put("containerOverflowDOM", containerOverflowDOM);
    }

    /**
     * The debug mode appears when there is something wrong with the validation engine. It has a set of trigger to look
     * upon validation and try to help you accordingly, it should help you get everything in line to get the script
     * working in your environment.
     * <p/>
     * Debug is off by default
     *
     * @param openDebug
     * @return
     */
    public ValidationEngineOptions openDebug(boolean openDebug) {
        return super.put("openDebug", openDebug);
    }

    public ValidationEngineOptions liveEvent(boolean liveEvent) {
        return super.put("liveEvent", liveEvent);
    }

    public ValidationEngineOptions ajaxSubmit(boolean ajaxSubmit) {
        return super.put("ajaxSubmit", ajaxSubmit);
    }

    /**
     * The success function first parameter is your serialized form data that you can send directly to your server.
     *
     * @param callbackBody
     * @return
     */
    public ValidationEngineOptions onSuccessEvent(CharSequence callbackBody) {
        return this.onSuccessEvent(js(callbackBody));
    }

    /**
     * The success function first parameter is your serialized form data that you can send directly to your server.
     *
     * @param callbackBody
     * @return
     */
    public ValidationEngineOptions onSuccessEvent(IJQStatement callbackBody) {
        return this.onSuccessEvent($f(callbackBody).withParams("formData"));
    }

    /**
     * The success function first parameter is your serialized form data that you can send directly to your server.
     *
     * @param callback
     * @return
     */
    public ValidationEngineOptions onSuccessEvent(IJQFunction callback) {
        super.put("success", callback);
        return this;
    }

    public ValidationEngineOptions onFailureEvent(CharSequence callbackBody) {
        return this.onFailureEvent(js(callbackBody));
    }

    public ValidationEngineOptions onFailureEvent(IJQStatement callbackBody) {
        return this.onFailureEvent($f(callbackBody).withParams("formData"));
    }

    public ValidationEngineOptions onFailureEvent(IJQFunction callback) {
        super.put("failure", callback);
        return this;
    }
}
