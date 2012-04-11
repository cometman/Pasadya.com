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

import com.google.code.jqwicket.api.S;
import com.google.code.jqwicket.ui.accordion.AccordionWebMarkupContainer;
import com.google.code.jqwicket.ui.draggable.DraggableOptions;
import com.google.code.jqwicket.ui.droppable.DroppableOptions;
import org.apache.wicket.ajax.AbstractDefaultAjaxBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.request.cycle.RequestCycle;

import java.util.Map;

import static com.google.code.jqwicket.api.JQLiteral._raw;
import static com.google.code.jqwicket.api.JQuery.*;

/**
 * @author mkalina
 */
public class DNDPage extends DemoPage {

    private static final Map<String, String> labels = new MapBuilder<String, String>()
            .add("lolcatShirt", "Lolcat Shirt")
            .add("cheezeburgerShirt", "Cheezeburger Shirt")
            .add("buckitShirt", "Buckit Shirt")
            .add("zebraStriped", "Zebra Striped")
            .add("blackLeather", "Black Leather")
            .add("alligatorLeather", "Alligator Leather").build();

    public DNDPage() {

        // Create accordion containing dummy products
        AccordionWebMarkupContainer accordion = new AccordionWebMarkupContainer(
                "catalog");
        for (Map.Entry<String, String> e : labels.entrySet()) {
            accordion.add(new Label(e.getKey(), e.getValue()).add(JQBehaviors
                    .draggable(new DraggableOptions().appendTo("body").helper(
                            "clone"))));
        }
        add(accordion);

        // Create shopping cart webmarkup container
        WebMarkupContainer cartContainer = new WebMarkupContainer(
                "cartContainer");
        add(cartContainer);

        // added ajax behavior to the shopping cart that responds to the page
        // with simple javascript alert
        final AbstractDefaultAjaxBehavior behave = new AbstractDefaultAjaxBehavior() {
            private static final long serialVersionUID = 1L;

            @Override
            protected void respond(AjaxRequestTarget target) {
                String product = RequestCycle.get().getRequest()
                        .getRequestParameters().getParameterValue("product").toString();
                if (Utils.isNotBlank(product))
                    target.appendJavaScript("alert('product \"" + product
                            + "\" added on the serverside!')");
            }
        };
        cartContainer.add(behave);

        // make shopping cart container droppable
        // and implement onDropEvent to send the ajax request to the shopping
        // cart!
        Map<String, Object> ajaxGetParams = new MapBuilder<String, Object>()
                .add("product", js("ui.draggable.text()")).build();

        DroppableOptions options = new DroppableOptions()
                .activeClass("ui-state-default")
                .hoverClass("ui-state-hover")
                .accept(":not(.ui-sortable-helper)")
                .dropEvent(
                        $f(
                                $this().find(S.clazz("placeholder")).remove(),
                                $("<li></li>")
                                        .text(_raw("ui.draggable.text()"))
                                        .appendTo(_raw("this")),
                                wicketAjaxGet(behave, ajaxGetParams)//
                        ).withParams("event", "ui") //
                );
        cartContainer.add(JQBehaviors.droppable(options));

    }

    /**
     * {@inheritDoc}
     *
     * @see com.google.code.jqwicket.DemoPage#getExampleTitle()
     */
    @Override
    protected String getExampleTitle() {
        return "Low-Level drag'n'drop example";
    }

    /**
     * {@inheritDoc}
     *
     * @see com.google.code.jqwicket.DemoPage#getExampleDescription()
     */
    @Override
    protected String getExampleDescription() {
        return "This example demonstrates low-Level drag'n'drop";
    }

}
