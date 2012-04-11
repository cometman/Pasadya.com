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
package com.google.code.jqwicket.dnd;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mkalina
 */
public class ShoppingCartPanel extends DroppablePanel {

    private static final long serialVersionUID = 1L;

    private List<Product> selectedProducts = new ArrayList<Product>();

    private WebMarkupContainer selectedProductsContainer;

    public ShoppingCartPanel(String id) {
        super(id);

        selectedProductsContainer = new WebMarkupContainer(
                "selectedProductsContainer");
        selectedProductsContainer.setOutputMarkupId(true);

        selectedProductsContainer.add(new ListView<Product>(
                "selectedProductsView", selectedProducts) {

            private static final long serialVersionUID = 1L;

            @Override
            protected void populateItem(ListItem<Product> item) {
                item.add(new Label("name", item.getModelObject().name));
            }
        });

        add(selectedProductsContainer);
    }

    @Override
    public void onDrop(AjaxRequestTarget target, DraggablePanel draggable) {
        selectedProducts.add((Product) draggable.getDefaultModelObject());
        target.add(selectedProductsContainer);
    }

}
