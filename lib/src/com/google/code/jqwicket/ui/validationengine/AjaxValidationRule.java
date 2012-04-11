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
import org.apache.wicket.behavior.AbstractAjaxBehavior;
import org.apache.wicket.request.cycle.RequestCycle;
import org.apache.wicket.request.handler.TextRequestHandler;
import org.apache.wicket.request.http.WebRequest;

import java.io.Serializable;

import static com.google.code.jqwicket.Utils.isNotBlank;
import static com.google.code.jqwicket.Utils.quote;

/**
 * Validation rule implementation defining ajax callback method to execute on field validation.
 *
 * @author mkalina
 */
public abstract class AjaxValidationRule extends
        ValidationRule<AjaxValidationRule> {

    private static final long serialVersionUID = 1L;

    private AbstractAjaxBehavior ajaxBehavior;

    private CharSequence alertTextOk;

    private CharSequence alertTextLoad;

    public AjaxValidationRule(CharSequence name, CharSequence alertTextOk,
                              CharSequence alertTextLoad, CharSequence... alertTextErrors) {
        super(name, alertTextErrors);
        this.alertTextOk = alertTextOk;
        this.alertTextLoad = alertTextLoad;
    }

    public static class ExecutionContext implements Serializable {

        private static final long serialVersionUID = 1L;
        private String validationRuleName;
        private String componentId;
        private String value;
        private String extraData;

        public ExecutionContext(String validationRuleName, String componentId,
                                String value, String extraData) {
            this.validationRuleName = validationRuleName;
            this.componentId = componentId;
            this.value = value;
            this.extraData = extraData;
        }

        public String getValidationRuleName() {
            return validationRuleName;
        }

        public String getComponentId() {
            return componentId;
        }

        public String getValue() {
            return value;
        }

        public String getExtraData() {
            return extraData;
        }

    }

    protected abstract boolean execute(ExecutionContext ctx);

    protected AbstractAjaxBehavior newAjaxBehavior() {
        return new AbstractAjaxBehavior() {

            private static final long serialVersionUID = 1L;

            public void onRequest() {
                WebRequest req = (WebRequest) RequestCycle.get().getRequest();
                String validateError = req.getRequestParameters().getParameterValue("validateError").toString();
                String validateId = req.getRequestParameters().getParameterValue("validateId").toString();

                boolean result = execute(new ExecutionContext(validateError,
                        validateId, req.getRequestParameters().getParameterValue("validateValue").toString(),
                        req.getRequestParameters().getParameterValue("extraData").toString()));

                StringBuffer buf = new StringBuffer("{'jsonValidateReturn':");
                buf.append("[").append(Utils.quote(validateId));
                buf.append(",").append(Utils.quote(validateError));
                buf.append(",").append(Utils.quote(String.valueOf(result)));
                buf.append("]}");
                RequestCycle.get().scheduleRequestHandlerAfterCurrent(
                        new TextRequestHandler(buf.toString()));
            }
        };
    }

    public AbstractAjaxBehavior getAjaxBehavior() {
        if (this.ajaxBehavior == null) {
            this.ajaxBehavior = this.newAjaxBehavior();
        }
        return ajaxBehavior;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.google.code.jqwicket.ui.validationengine.ValidationRule#customPayloadToJson()
     */
    @Override
    protected CharSequence customPayloadToJson() {
        StringBuffer buf = new StringBuffer();
        buf.append(quote("file")).append(":")
                .append(quote(this.getAjaxBehavior().getCallbackUrl()));
        if (isNotBlank(this.alertTextOk)) {
            buf.append(",").append(quote("alertTextOk")).append(":")
                    .append(quote(this.alertTextOk));
        }
        if (isNotBlank(this.alertTextLoad)) {
            buf.append(",").append(quote("alertTextLoad")).append(":")
                    .append(quote(this.alertTextLoad));
        }
        return buf;
    }

}
