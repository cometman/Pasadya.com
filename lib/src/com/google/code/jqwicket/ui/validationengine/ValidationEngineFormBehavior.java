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

import com.google.code.jqwicket.JQContributionConfig;
import com.google.code.jqwicket.JQHeaderContributionTarget;
import com.google.code.jqwicket.Utils;
import com.google.code.jqwicket.api.JQuery;
import com.google.code.jqwicket.ui.JQComponentBehavior;
import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.html.IHeaderResponse;
import org.apache.wicket.markup.html.form.Form;

import java.util.Collection;
import java.util.UUID;

/**
 * @author mkalina
 */
public class ValidationEngineFormBehavior extends
        JQComponentBehavior<ValidationEngineOptions> implements
        IValidationEngine {

    private static final long serialVersionUID = 1L;

    public ValidationEngineFormBehavior() {
        this(new ValidationEngineOptions());
    }

    public ValidationEngineFormBehavior(ValidationEngineOptions options) {
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
     * @see com.google.code.jqwicket.JQBehavior#bind(org.apache.wicket.Component)
     */
    @Override
    public void bind(Component component) {

        super.bind(component);

        if (!options.hasValidationRules())
            return;

        Collection<AjaxValidationRule> ajaxRules = this.options
                .getAjaxValidationRules();
        if (Utils.isNotEmpty(ajaxRules)) {
            for (AjaxValidationRule r : ajaxRules) {
                component.add(r.getAjaxBehavior());
            }
        }

        Collection<FuncValidationRule> funcRules = this.options
                .getFuncValidationRules();
        if (Utils.isNotEmpty(funcRules)) {
            for (final FuncValidationRule r : funcRules) {
                component.add(new Behavior() {
                    private static final long serialVersionUID = 1L;

                    @Override
                    public void renderHead(Component component, IHeaderResponse response) {
                        response.renderJavaScript(r.getFuncDef(), UUID.randomUUID().toString());
                    }
                });
            }
        }

    }

    /**
     * {@inheritDoc}
     *
     * @see com.google.code.jqwicket.ui.JQComponentBehavior#contributeInternal(com.google.code.jqwicket.JQHeaderContributionTarget)
     */
    @Override
    protected void contributeInternal(JQHeaderContributionTarget target) {
        if (!Form.class.isAssignableFrom(this.component.getClass()))
            throw new IllegalStateException(
                    "ValidationEngineFormBehavior can only be added to the Form or its subclasses!");

        JQContributionConfig config = JQContributionConfig.get();
        CharSequence prefix = Utils.isNotBlank(config.getNonConflictAlias()) ? config
                .getNonConflictAlias() : "$";

        final StringBuffer buf = new StringBuffer();
        if (options.hasValidationRules()) {

            if (options.isValidationRulesResourceSpecified()) {

                buf.append(prefix).append(".extend(").append(prefix)
                        .append(".validationEngineLanguage.allRules, ");
                buf.append("{")
                        .append(Utils.join(options.getValidationRulesAsArray(),
                                ",\n")).append("}");
                buf.append(");\n");

            } else {

                buf.append(prefix).append(
                        ".fn.validationEngineLanguage = function() {};\n");
                buf.append(prefix).append(".validationEngineLanguage = {\n");
                buf.append("newLang: function() {\n");
                buf.append(prefix).append(
                        ".validationEngineLanguage.allRules = 	{");
                buf.append(Utils.join(options.getValidationRulesAsArray(),
                        ",\n"));
                buf.append("};\n");
                buf.append("}\n");
                buf.append("};\n");
                buf.append(prefix).append(
                        ".validationEngineLanguage.newLang();\n");

            }

        }

        if (buf.length() > 0)
            target.addJQStatements(JQuery.js(buf));

        super.contributeInternal(target);
    }
}
