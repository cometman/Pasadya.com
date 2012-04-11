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
package com.google.code.jqwicket;

import com.google.code.jqwicket.api.JQLiteral;
import com.google.code.jqwicket.api.JQOptions;
import com.google.code.jqwicket.api.JQuery;
import com.google.code.jqwicket.api.S;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.PropertyModel;

/**
 * @author mkalina
 */
public class GenericJQBehaviorPage extends DemoPage {

    public GenericJQBehaviorPage() {

        // add JQBehavior, that displays alert while click the link with id =
        // link0
        add(new JQBehavior(S.id("link0").to$()
                .click(JQuery.$f("alert('hello world!')"))));

        // add JQBehavior to the label
        Label label = new Label("label",
                "I'm a wicket label. Click me to see an alert!");
        label.add(JQBehaviors.mouseClick("alert('clicked!')"));
        add(label);

        // add JQBehavior to some static html element
        add(new JQBehavior(S
                .id("censoredA")
                .to$()
                .click(JQuery.$f(
                        S.id("censoredDiv")
                                .to$()
                                .fadeIn(JQLiteral._raw(3000),
                                        JQuery.$f(S.id("censoredSpan").to$()
                                                .fadeIn(JQLiteral._raw(100)))),
                        "return false;"))));


        add(new JQBehavior(
                S.id("play").to$().click(JQuery.$f(
                        S.id("testDIV").to$().animate(JQOptions.valueOf("top:'300', left:'10', height:'toggle', " +
                                "width:'toggle'"), JQLiteral._raw(1000))
                )),
                S.id("back").to$().click(JQuery.$f(
                        S.id("testDIV").to$().animate(JQOptions.valueOf("top:'40', left:'300', height:'toggle', " +
                                "width:'toggle'"), JQLiteral._raw(1000))
                ))

        ));

        add(new ShakeForm("shakeForm"));

    }


    private static class ShakeForm extends Form<Void> {

        private String value;

        private boolean shakeAlreadyAdded = false;

        public ShakeForm(String id) {
            super(id);
            add(new TextField<String>("shakeValue", new PropertyModel<String>(this, "value")).setRequired(true));
            add(new FeedbackPanel("feedbackPanel"));
        }

        @Override
        protected void onSubmit() {
            // value submitted...
        }


        @Override
        protected void onError() {
            if (!shakeAlreadyAdded)  {
                add(new JQBehavior(S.id("shakeContainer").to$().effect("shake", JQOptions.valueOf("times:2"),
                        JQLiteral._raw(70))));
                shakeAlreadyAdded = true;
            }
        }
    }


    /**
     * {@inheritDoc}
     *
     * @see com.google.code.jqwicket.DemoPage#getExampleTitle()
     */
    @Override
    protected String getExampleTitle() {
        return "Low-level JQBehavior example";
    }

    /**
     * {@inheritDoc}
     *
     * @see com.google.code.jqwicket.DemoPage#getExampleDescription()
     */
    @Override
    protected String getExampleDescription() {
        return "This example demonstrates how to use pre-implemented JQBehavior class "
                + "to add jquery support to the wicket components";
    }
}
