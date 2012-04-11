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


import com.google.code.jqwicket.Utils;
import com.google.code.jqwicket.ui.droppable.DroppableBehavior;
import com.google.code.jqwicket.ui.droppable.DroppableOptions;
import org.apache.wicket.ajax.AbstractDefaultAjaxBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.cycle.RequestCycle;
import org.apache.wicket.util.visit.IVisit;
import org.apache.wicket.util.visit.IVisitor;


/**
 * Base abstract panel for droppable components. Subclasses should implement abstract {@link #onDrop(AjaxRequestTarget,
 * DraggablePanel)} method!
 *
 * @author mkalina
 */
public abstract class DroppablePanel extends Panel {

    private static final long serialVersionUID = 1L;

    public DroppablePanel(String id, IModel<?> model) {
        super(id, model);
        initInternal();
    }

    public DroppablePanel(String id) {
        super(id);
        initInternal();
    }

    protected void initInternal() {
        super.add(new DroppableBehavior(newDroppableOptions()));
        super.add(new AbstractDefaultAjaxBehavior() {

            private static final long serialVersionUID = 1L;

            @Override
            protected void respond(AjaxRequestTarget target) {
                DraggableVisitor visitor = new DraggableVisitor(RequestCycle.get().getRequest().
                        getRequestParameters().getParameterValue("draggableId").toString());
                getPage().visitChildren(DraggablePanel.class, visitor);

                if (visitor.getDraggable() != null
                        && supports(visitor.getDraggable())) {
                    onDrop(target, visitor.getDraggable());
                }
            }

            @Override
            protected void onComponentTag(ComponentTag tag) {
                tag.put("rel", this.getCallbackUrl());
            }

        });

    }

    /**
     * Builds new default, simple droppable options. Subclasses may override this method by creating custom behavior.
     *
     * @return
     */
    protected DroppableOptions newDroppableOptions() {
        return new DroppableOptions()
                .activeClass("ui-state-default")
                .hoverClass("ui-state-hover")
                .accept(":not(.ui-sortable-helper)")
                .dropEvent(
                        "wicketAjaxGet($(this).attr('rel') + '&draggableId=' + ui.draggable.attr('id'), function(){}, function(){})");
    }

    private static class DraggableVisitor implements IVisitor<DraggablePanel, Object> {

        private String draggableId;

        private DraggablePanel draggable;

        public DraggableVisitor(String draggableId) {
            this.draggableId = draggableId;
        }

        /**
         * {@inheritDoc}
         */
        public void component(DraggablePanel component, IVisit<Object> ivisit) {

            if (Utils.isBlank(this.draggableId)) {
                ivisit.stop();
            }

            if (this.draggableId.equals(component.getMarkupId())) {
                this.draggable = component;
                ivisit.stop();
            }
        }

        public DraggablePanel getDraggable() {
            return draggable;
        }
    }

    public boolean supports(DraggablePanel draggable) {
        return true;
    }

    public abstract void onDrop(AjaxRequestTarget target,
                                DraggablePanel draggable);

}
