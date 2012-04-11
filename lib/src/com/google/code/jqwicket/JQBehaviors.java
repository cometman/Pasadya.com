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

import com.google.code.jqwicket.api.IJQFunction;
import com.google.code.jqwicket.api.IJQStatement;
import com.google.code.jqwicket.event.JQEventBehavior;
import com.google.code.jqwicket.event.KeyboardEvent;
import com.google.code.jqwicket.event.MouseEvent;
import com.google.code.jqwicket.event.StateEvent;
import com.google.code.jqwicket.ui.draggable.DraggableBehavior;
import com.google.code.jqwicket.ui.draggable.DraggableOptions;
import com.google.code.jqwicket.ui.droppable.DroppableBehavior;
import com.google.code.jqwicket.ui.droppable.DroppableOptions;
import com.google.code.jqwicket.ui.resizable.ResizableBehavior;
import com.google.code.jqwicket.ui.resizable.ResizableOptions;
import com.google.code.jqwicket.ui.selectable.SelectableBehavior;
import com.google.code.jqwicket.ui.selectable.SelectableOptions;
import com.google.code.jqwicket.ui.sortable.SortableBehavior;
import com.google.code.jqwicket.ui.sortable.SortableOptions;

import static com.google.code.jqwicket.api.JQuery.$f;

/**
 * "Collection" of typical jquery behaviors that can be simply instantiated by calling static methods.
 *
 * @author mkalina
 */
public abstract class JQBehaviors {

    JQBehaviors() {
    }

    /**
     * Builds jquery behavior containing collection of jquery/javascript statements.
     *
     * @param statements
     * @return
     */
    public static final JQBehavior js(IJQStatement... statements) {
        return new JQBehavior(statements);
    }

    /**
     * Builds jquery behavior containing collection of jquery/javascript statements.
     *
     * @param statements
     * @return
     */
    public static final JQBehavior js(CharSequence... statements) {
        return new JQBehavior(statements);
    }

    /**
     * Builds jquery behavior rendering javascript callback function while proceeding javascript's "mouse over" event on
     * the component this behavior is associated with.<br> Javascript rendered to the html-page head section will look
     * like this:<br>
     * <p/>
     * <pre>
     * $(component_id).mouseover(function(arg1, arg2, ...){
     * 		... js ....
     * });
     * </pre>
     *
     * @param js
     * @param params
     * @return
     */
    public static final JQEventBehavior mouseOver(final CharSequence js, final CharSequence... params) {
        return new JQEventBehavior(MouseEvent.OVER) {

            private static final long serialVersionUID = 1L;

            @Override
            public IJQFunction callback() {
                return $f(js).withParams(params);
            }
        };
    }

    /**
     * Builds jquery behavior rendering javascript callback function while proceeding javascript's "mouse over" event on
     * the component this behavior is associated with.<br> Javascript rendered to the html-page head section will look
     * like this:<br>
     * <p/>
     * <pre>
     * $(component_id).mouseover(function(arg1, arg2, ...){
     * 		... stmt ....
     * });
     * </pre>
     *
     * @param stmt
     * @param params
     * @return
     */
    public static final JQEventBehavior mouseOver(final IJQStatement stmt, final CharSequence... params) {
        return new JQEventBehavior(MouseEvent.OVER) {

            private static final long serialVersionUID = 1L;

            @Override
            public IJQFunction callback() {
                return $f(stmt).withParams(params);
            }
        };
    }

    /**
     * Builds jquery behavior rendering javascript callback function while proceeding javascript's "mouse over" event on
     * the component this behavior is associated with.<br> Javascript rendered to the html-page head section will look
     * like this:<br>
     * <p/>
     * <pre>
     * $(component_id).mouseover(function(arg1, arg2, ...){
     * 		... function body ....
     * });
     * </pre>
     *
     * @param function
     * @return
     */
    public static final JQEventBehavior mouseOver(final IJQFunction function) {
        return new JQEventBehavior(MouseEvent.OVER) {

            private static final long serialVersionUID = 1L;

            @Override
            public IJQFunction callback() {
                return function;
            }
        };
    }

    /**
     * Builds jquery behavior rendering javascript callback function while proceeding javascript's "mouse toggle" event
     * on the component this behavior is associated with.<br> Javascript rendered to the html-page head section will
     * look like this:<br>
     * <p/>
     * <pre>
     * $(component_id).toggle(function(arg1, arg2, ...){
     * 		... js ....
     * });
     * </pre>
     *
     * @param js
     * @param params
     * @return
     */
    public static final JQEventBehavior mouseToggle(final CharSequence js, final CharSequence... params) {
        return new JQEventBehavior(MouseEvent.TOGGLE) {

            private static final long serialVersionUID = 1L;

            @Override
            public IJQFunction callback() {
                return $f(js).withParams(params);
            }
        };
    }

    /**
     * Builds jquery behavior rendering javascript callback function while proceeding javascript's "mouse toggle" event
     * on the component this behavior is associated with.<br> Javascript rendered to the html-page head section will
     * look like this:<br>
     * <p/>
     * <pre>
     * $(component_id).toggle(function(arg1, arg2, ...){
     * 		... stmt ....
     * });
     * </pre>
     *
     * @param stmt
     * @param params
     * @return
     */
    public static final JQEventBehavior mouseToggle(final IJQStatement stmt, final CharSequence... params) {
        return new JQEventBehavior(MouseEvent.TOGGLE) {

            private static final long serialVersionUID = 1L;

            @Override
            public IJQFunction callback() {
                return $f(stmt).withParams(params);
            }
        };
    }

    /**
     * Builds jquery behavior rendering javascript callback function while proceeding javascript's "mouse toggle" event
     * on the component this behavior is associated with.<br> Javascript rendered to the html-page head section will
     * look like this:<br>
     * <p/>
     * <pre>
     * $(component_id).toggle(function(arg1, arg2, ...){
     * 		... function body ....
     * });
     * </pre>
     *
     * @param function
     * @return
     */
    public static final JQEventBehavior mouseToggle(final IJQFunction function) {
        return new JQEventBehavior(MouseEvent.TOGGLE) {

            private static final long serialVersionUID = 1L;

            @Override
            public IJQFunction callback() {
                return function;
            }
        };
    }

    /**
     * Builds jquery behavior rendering javascript callback function while proceeding javascript's "mouse click" event
     * on the component this behavior is associated with.<br> Javascript rendered to the html-page head section will
     * look like this:<br>
     * <p/>
     * <pre>
     * $(component_id).click(function(arg1, arg2, ...){
     * 		... js ....
     * });
     * </pre>
     *
     * @param js
     * @param params
     * @return
     */
    public static final JQEventBehavior mouseClick(final CharSequence js, final CharSequence... params) {
        return new JQEventBehavior(MouseEvent.CLICK) {

            private static final long serialVersionUID = 1L;

            @Override
            public IJQFunction callback() {
                return $f(js).withParams(params);
            }
        };
    }

    /**
     * Builds jquery behavior rendering javascript callback function while proceeding javascript's "mouse click" event
     * on the component this behavior is associated with.<br> Javascript rendered to the html-page head section will
     * look like this:<br>
     * <p/>
     * <pre>
     * $(component_id).click(function(arg1, arg2, ...){
     * 		... stmt ....
     * });
     * </pre>
     *
     * @param stmt
     * @param params
     * @return
     */
    public static final JQEventBehavior mouseClick(final IJQStatement stmt, final CharSequence... params) {
        return new JQEventBehavior(MouseEvent.CLICK) {

            private static final long serialVersionUID = 1L;

            @Override
            public IJQFunction callback() {
                return $f(stmt).withParams(params);
            }
        };
    }

    /**
     * Builds jquery behavior rendering javascript callback function while proceeding javascript's "mouse click" event
     * on the component this behavior is associated with.<br> Javascript rendered to the html-page head section will
     * look like this:<br>
     * <p/>
     * <pre>
     * $(component_id).click(function(arg1, arg2, ...){
     * 		... function body ....
     * });
     * </pre>
     *
     * @param function
     * @return
     */
    public static final JQEventBehavior mouseClick(final IJQFunction function) {
        return new JQEventBehavior(MouseEvent.CLICK) {

            private static final long serialVersionUID = 1L;

            @Override
            public IJQFunction callback() {
                return function;
            }
        };
    }

    /**
     * Builds jquery behavior rendering javascript callback function while proceeding javascript's "mouse double click"
     * event on the component this behavior is associated with.<br> Javascript rendered to the html-page head section
     * will look like this:<br>
     * <p/>
     * <pre>
     * $(component_id).dblclick(function(arg1, arg2, ...){
     * 		... js ....
     * });
     * </pre>
     *
     * @param js
     * @param params
     * @return
     */
    public static final JQEventBehavior mouseDoubleClick(final CharSequence js, final CharSequence... params) {
        return new JQEventBehavior(MouseEvent.DBLCLICK) {

            private static final long serialVersionUID = 1L;

            @Override
            public IJQFunction callback() {
                return $f(js).withParams(params);
            }
        };
    }

    /**
     * Builds jquery behavior rendering javascript callback function while proceeding javascript's "mouse double click"
     * event on the component this behavior is associated with.<br> Javascript rendered to the html-page head section
     * will look like this:<br>
     * <p/>
     * <pre>
     * $(component_id).dblclick(function(arg1, arg2, ...){
     * 		... stmt ....
     * });
     * </pre>
     *
     * @param stmt
     * @param params
     * @return
     */
    public static final JQEventBehavior mouseDoubleClick(final IJQStatement stmt, final CharSequence... params) {
        return new JQEventBehavior(MouseEvent.DBLCLICK) {

            private static final long serialVersionUID = 1L;

            @Override
            public IJQFunction callback() {
                return $f(stmt).withParams(params);
            }
        };
    }

    /**
     * Builds jquery behavior rendering javascript callback function while proceeding javascript's "mouse double click"
     * event on the component this behavior is associated with.<br> Javascript rendered to the html-page head section
     * will look like this:<br>
     * <p/>
     * <pre>
     * $(component_id).dblclick(function(arg1, arg2, ...){
     * 		... function body ....
     * });
     * </pre>
     *
     * @param function
     * @return
     */
    public static final JQEventBehavior mouseDoubleClick(final IJQFunction function) {
        return new JQEventBehavior(MouseEvent.DBLCLICK) {

            private static final long serialVersionUID = 1L;

            @Override
            public IJQFunction callback() {
                return function;
            }
        };
    }

    /**
     * Builds jquery behavior rendering javascript callback function while proceeding javascript's "mouse focus in"
     * event on the component this behavior is associated with.<br> Javascript rendered to the html-page head section
     * will look like this:<br>
     * <p/>
     * <pre>
     * $(component_id).focusin(function(arg1, arg2, ...){
     * 		... js ....
     * });
     * </pre>
     *
     * @param js
     * @param params
     * @return
     */
    public static final JQEventBehavior focusIn(final CharSequence js, final CharSequence... params) {
        return new JQEventBehavior(MouseEvent.FOCUSIN) {

            private static final long serialVersionUID = 1L;

            @Override
            public IJQFunction callback() {
                return $f(js).withParams(params);
            }
        };
    }

    /**
     * Builds jquery behavior rendering javascript callback function while proceeding javascript's "mouse focus in"
     * event on the component this behavior is associated with.<br> Javascript rendered to the html-page head section
     * will look like this:<br>
     * <p/>
     * <pre>
     * $(component_id).focusin(function(arg1, arg2, ...){
     * 		... stmt ....
     * });
     * </pre>
     *
     * @param stmt
     * @param params
     * @return
     */
    public static final JQEventBehavior focusIn(final IJQStatement stmt, final CharSequence... params) {
        return new JQEventBehavior(MouseEvent.FOCUSIN) {

            private static final long serialVersionUID = 1L;

            @Override
            public IJQFunction callback() {
                return $f(stmt).withParams(params);
            }
        };
    }

    /**
     * Builds jquery behavior rendering javascript callback function while proceeding javascript's "mouse focus in"
     * event on the component this behavior is associated with.<br> Javascript rendered to the html-page head section
     * will look like this:<br>
     * <p/>
     * <pre>
     * $(component_id).focusin(function(arg1, arg2, ...){
     * 		... function body ....
     * });
     * </pre>
     *
     * @param function
     * @return
     */
    public static final JQEventBehavior focusIn(final IJQFunction function) {
        return new JQEventBehavior(MouseEvent.FOCUSIN) {

            private static final long serialVersionUID = 1L;

            @Override
            public IJQFunction callback() {
                return function;
            }
        };
    }

    /**
     * Builds jquery behavior rendering javascript callback function while proceeding javascript's "mouse focus out"
     * event on the component this behavior is associated with.<br> Javascript rendered to the html-page head section
     * will look like this:<br>
     * <p/>
     * <pre>
     * $(component_id).focusout(function(arg1, arg2, ...){
     * 		... js ....
     * });
     * </pre>
     *
     * @param js
     * @param params
     * @return
     */
    public static final JQEventBehavior focusOut(final CharSequence js, final CharSequence... params) {
        return new JQEventBehavior(MouseEvent.FOCUSOUT) {

            private static final long serialVersionUID = 1L;

            @Override
            public IJQFunction callback() {
                return $f(js).withParams(params);
            }
        };
    }

    /**
     * Builds jquery behavior rendering javascript callback function while proceeding javascript's "mouse focus out"
     * event on the component this behavior is associated with.<br> Javascript rendered to the html-page head section
     * will look like this:<br>
     * <p/>
     * <pre>
     * $(component_id).focusout(function(arg1, arg2, ...){
     * 		... stmt ....
     * });
     * </pre>
     *
     * @param stmt
     * @param params
     * @return
     */
    public static final JQEventBehavior focusOut(final IJQStatement stmt, final CharSequence... params) {
        return new JQEventBehavior(MouseEvent.FOCUSOUT) {

            private static final long serialVersionUID = 1L;

            @Override
            public IJQFunction callback() {
                return $f(stmt).withParams(params);
            }
        };
    }

    /**
     * Builds jquery behavior rendering javascript callback function while proceeding javascript's "mouse focus out"
     * event on the component this behavior is associated with.<br> Javascript rendered to the html-page head section
     * will look like this:<br>
     * <p/>
     * <pre>
     * $(component_id).focusout(function(arg1, arg2, ...){
     * 		... function body ....
     * });
     * </pre>
     *
     * @param function
     * @return
     */
    public static final JQEventBehavior focusOut(final IJQFunction function) {
        return new JQEventBehavior(MouseEvent.FOCUSOUT) {

            private static final long serialVersionUID = 1L;

            @Override
            public IJQFunction callback() {
                return function;
            }
        };
    }

    /**
     * Builds jquery behavior rendering javascript callback function while proceeding javascript's "mouse hover" event
     * on the component this behavior is associated with.<br> Javascript rendered to the html-page head section will
     * look like this:<br>
     * <p/>
     * <pre>
     * $(component_id).hover(function(arg1, arg2, ...){
     * 		... js ....
     * });
     * </pre>
     *
     * @param js
     * @param params
     * @return
     */
    public static final JQEventBehavior mouseHover(final CharSequence js, final CharSequence... params) {
        return new JQEventBehavior(MouseEvent.HOVER) {

            private static final long serialVersionUID = 1L;

            @Override
            public IJQFunction callback() {
                return $f(js).withParams(params);
            }
        };
    }

    /**
     * Builds jquery behavior rendering javascript callback function while proceeding javascript's "mouse hover" event
     * on the component this behavior is associated with.<br> Javascript rendered to the html-page head section will
     * look like this:<br>
     * <p/>
     * <pre>
     * $(component_id).hover(function(arg1, arg2, ...){
     * 		... stmt ....
     * });
     * </pre>
     *
     * @param stmt
     * @param params
     * @return
     */
    public static final JQEventBehavior mouseHover(final IJQStatement stmt, final CharSequence... params) {
        return new JQEventBehavior(MouseEvent.HOVER) {

            private static final long serialVersionUID = 1L;

            @Override
            public IJQFunction callback() {
                return $f(stmt).withParams(params);
            }
        };
    }

    /**
     * Builds jquery behavior rendering javascript callback function while proceeding javascript's "mouse hover" event
     * on the component this behavior is associated with.<br> Javascript rendered to the html-page head section will
     * look like this:<br>
     * <p/>
     * <pre>
     * $(component_id).hover(function(arg1, arg2, ...){
     * 		... function body ....
     * });
     * </pre>
     *
     * @param function
     * @return
     */
    public static final JQEventBehavior mouseHover(final IJQFunction function) {
        return new JQEventBehavior(MouseEvent.HOVER) {

            private static final long serialVersionUID = 1L;

            @Override
            public IJQFunction callback() {
                return function;
            }
        };
    }

    /**
     * Builds jquery behavior rendering javascript callback function while proceeding javascript's "mouse down" event on
     * the component this behavior is associated with.<br> Javascript rendered to the html-page head section will look
     * like this:<br>
     * <p/>
     * <pre>
     * $(component_id).mousedown(function(arg1, arg2, ...){
     * 		... js ....
     * });
     * </pre>
     *
     * @param js
     * @param params
     * @return
     */
    public static final JQEventBehavior mouseDown(final CharSequence js, final CharSequence... params) {
        return new JQEventBehavior(MouseEvent.DOWN) {

            private static final long serialVersionUID = 1L;

            @Override
            public IJQFunction callback() {
                return $f(js).withParams(params);
            }
        };
    }

    /**
     * Builds jquery behavior rendering javascript callback function while proceeding javascript's "mouse down" event on
     * the component this behavior is associated with.<br> Javascript rendered to the html-page head section will look
     * like this:<br>
     * <p/>
     * <pre>
     * $(component_id).mousedown(function(arg1, arg2, ...){
     * 		... stmt ....
     * });
     * </pre>
     *
     * @param stmt
     * @param params
     * @return
     */
    public static final JQEventBehavior mouseDown(final IJQStatement stmt, final CharSequence... params) {
        return new JQEventBehavior(MouseEvent.DOWN) {

            private static final long serialVersionUID = 1L;

            @Override
            public IJQFunction callback() {
                return $f(stmt).withParams(params);
            }
        };
    }

    /**
     * Builds jquery behavior rendering javascript callback function while proceeding javascript's "mouse down" event on
     * the component this behavior is associated with.<br> Javascript rendered to the html-page head section will look
     * like this:<br>
     * <p/>
     * <pre>
     * $(component_id).mousedown(function(arg1, arg2, ...){
     * 		... function body ....
     * });
     * </pre>
     *
     * @param function
     * @return
     */
    public static final JQEventBehavior mouseDown(final IJQFunction function) {
        return new JQEventBehavior(MouseEvent.DOWN) {

            private static final long serialVersionUID = 1L;

            @Override
            public IJQFunction callback() {
                return function;
            }
        };
    }

    /**
     * Builds jquery behavior rendering javascript callback function while proceeding javascript's "mouse enter" event
     * on the component this behavior is associated with.<br> Javascript rendered to the html-page head section will
     * look like this:<br>
     * <p/>
     * <pre>
     * $(component_id).mouseenter(function(arg1, arg2, ...){
     * 		... js ....
     * });
     * </pre>
     *
     * @param js
     * @param params
     * @return
     */
    public static final JQEventBehavior mouseEnter(final CharSequence js, final CharSequence... params) {
        return new JQEventBehavior(MouseEvent.ENTER) {

            private static final long serialVersionUID = 1L;

            @Override
            public IJQFunction callback() {
                return $f(js).withParams(params);
            }
        };
    }

    /**
     * Builds jquery behavior rendering javascript callback function while proceeding javascript's "mouse enter" event
     * on the component this behavior is associated with.<br> Javascript rendered to the html-page head section will
     * look like this:<br>
     * <p/>
     * <pre>
     * $(component_id).mouseenter(function(arg1, arg2, ...){
     * 		... stmt ....
     * });
     * </pre>
     *
     * @param stmt
     * @param params
     * @return
     */
    public static final JQEventBehavior mouseEnter(final IJQStatement stmt, final CharSequence... params) {
        return new JQEventBehavior(MouseEvent.ENTER) {

            private static final long serialVersionUID = 1L;

            @Override
            public IJQFunction callback() {
                return $f(stmt).withParams(params);
            }
        };
    }

    /**
     * Builds jquery behavior rendering javascript callback function while proceeding javascript's "mouse enter" event
     * on the component this behavior is associated with.<br> Javascript rendered to the html-page head section will
     * look like this:<br>
     * <p/>
     * <pre>
     * $(component_id).mouseenter(function(arg1, arg2, ...){
     * 		... function body ....
     * });
     * </pre>
     *
     * @param function
     * @return
     */
    public static final JQEventBehavior mouseEnter(final IJQFunction function) {
        return new JQEventBehavior(MouseEvent.ENTER) {

            private static final long serialVersionUID = 1L;

            @Override
            public IJQFunction callback() {
                return function;
            }
        };
    }

    /**
     * Builds jquery behavior rendering javascript callback function while proceeding javascript's "mouse leave" event
     * on the component this behavior is associated with.<br> Javascript rendered to the html-page head section will
     * look like this:<br>
     * <p/>
     * <pre>
     * $(component_id).mouseleave(function(arg1, arg2, ...){
     * 		... js ....
     * });
     * </pre>
     *
     * @param js
     * @param params
     * @return
     */
    public static final JQEventBehavior mouseLeave(final CharSequence js, final CharSequence... params) {
        return new JQEventBehavior(MouseEvent.LEAVE) {

            private static final long serialVersionUID = 1L;

            @Override
            public IJQFunction callback() {
                return $f(js).withParams(params);
            }
        };
    }

    /**
     * Builds jquery behavior rendering javascript callback function while proceeding javascript's "mouse leave" event
     * on the component this behavior is associated with.<br> Javascript rendered to the html-page head section will
     * look like this:<br>
     * <p/>
     * <pre>
     * $(component_id).mouseleave(function(arg1, arg2, ...){
     * 		... stmt ....
     * });
     * </pre>
     *
     * @param stmt
     * @param params
     * @return
     */
    public static final JQEventBehavior mouseLeave(final IJQStatement stmt, final CharSequence... params) {
        return new JQEventBehavior(MouseEvent.LEAVE) {

            private static final long serialVersionUID = 1L;

            @Override
            public IJQFunction callback() {
                return $f(stmt).withParams(params);
            }
        };
    }

    /**
     * Builds jquery behavior rendering javascript callback function while proceeding javascript's "mouse leave" event
     * on the component this behavior is associated with.<br> Javascript rendered to the html-page head section will
     * look like this:<br>
     * <p/>
     * <pre>
     * $(component_id).mouseleave(function(arg1, arg2, ...){
     * 		... function body ....
     * });
     * </pre>
     *
     * @param function
     * @return
     */
    public static final JQEventBehavior mouseLeave(final IJQFunction function) {
        return new JQEventBehavior(MouseEvent.LEAVE) {

            private static final long serialVersionUID = 1L;

            @Override
            public IJQFunction callback() {
                return function;
            }
        };
    }

    /**
     * Builds jquery behavior rendering javascript callback function while proceeding javascript's "mouse move" event on
     * the component this behavior is associated with.<br> Javascript rendered to the html-page head section will look
     * like this:<br>
     * <p/>
     * <pre>
     * $(component_id).mousemove(function(arg1, arg2, ...){
     * 		... js ....
     * });
     * </pre>
     *
     * @param js
     * @param params
     * @return
     */
    public static final JQEventBehavior mouseMove(final CharSequence js, final CharSequence... params) {
        return new JQEventBehavior(MouseEvent.MOVE) {

            private static final long serialVersionUID = 1L;

            @Override
            public IJQFunction callback() {
                return $f(js).withParams(params);
            }
        };
    }

    /**
     * Builds jquery behavior rendering javascript callback function while proceeding javascript's "mouse move" event on
     * the component this behavior is associated with.<br> Javascript rendered to the html-page head section will look
     * like this:<br>
     * <p/>
     * <pre>
     * $(component_id).mousemove(function(arg1, arg2, ...){
     * 		... stmt ....
     * });
     * </pre>
     *
     * @param stmt
     * @param params
     * @return
     */
    public static final JQEventBehavior mouseMove(final IJQStatement stmt, final CharSequence... params) {
        return new JQEventBehavior(MouseEvent.MOVE) {

            private static final long serialVersionUID = 1L;

            @Override
            public IJQFunction callback() {
                return $f(stmt).withParams(params);
            }
        };
    }

    /**
     * Builds jquery behavior rendering javascript callback function while proceeding javascript's "mouse move" event on
     * the component this behavior is associated with.<br> Javascript rendered to the html-page head section will look
     * like this:<br>
     * <p/>
     * <pre>
     * $(component_id).mousemove(function(arg1, arg2, ...){
     * 		... function body ....
     * });
     * </pre>
     *
     * @param function
     * @return
     */
    public static final JQEventBehavior mouseMove(final IJQFunction function) {
        return new JQEventBehavior(MouseEvent.MOVE) {

            private static final long serialVersionUID = 1L;

            @Override
            public IJQFunction callback() {
                return function;
            }
        };
    }

    /**
     * Builds jquery behavior rendering javascript callback function while proceeding javascript's "mouse out" event on
     * the component this behavior is associated with.<br> Javascript rendered to the html-page head section will look
     * like this:<br>
     * <p/>
     * <pre>
     * $(component_id).mouseout(function(arg1, arg2, ...){
     * 		... js ....
     * });
     * </pre>
     *
     * @param js
     * @param params
     * @return
     */
    public static final JQEventBehavior mouseOut(final CharSequence js,
                                                 final CharSequence... params) {
        return new JQEventBehavior(MouseEvent.OUT) {

            private static final long serialVersionUID = 1L;

            @Override
            public IJQFunction callback() {
                return $f(js).withParams(params);
            }
        };
    }

    /**
     * Builds jquery behavior rendering javascript callback function while proceeding javascript's "mouse out" event on
     * the component this behavior is associated with.<br> Javascript rendered to the html-page head section will look
     * like this:<br>
     * <p/>
     * <pre>
     * $(component_id).mouseout(function(arg1, arg2, ...){
     * 		... stmt ....
     * });
     * </pre>
     *
     * @param stmt
     * @param params
     * @return
     */
    public static final JQEventBehavior mouseOut(final IJQStatement stmt, final CharSequence... params) {
        return new JQEventBehavior(MouseEvent.OUT) {

            private static final long serialVersionUID = 1L;

            @Override
            public IJQFunction callback() {
                return $f(stmt).withParams(params);
            }
        };
    }

    /**
     * Builds jquery behavior rendering javascript callback function while proceeding javascript's "mouse out" event on
     * the component this behavior is associated with.<br> Javascript rendered to the html-page head section will look
     * like this:<br>
     * <p/>
     * <pre>
     * $(component_id).mouseout(function(arg1, arg2, ...){
     * 		... function body ....
     * });
     * </pre>
     *
     * @param function
     * @return
     */
    public static final JQEventBehavior mouseOut(final IJQFunction function) {
        return new JQEventBehavior(MouseEvent.OUT) {

            private static final long serialVersionUID = 1L;

            @Override
            public IJQFunction callback() {
                return function;
            }
        };
    }

    /**
     * Builds jquery behavior rendering javascript callback function while proceeding javascript's "mouse up" event on
     * the component this behavior is associated with.<br> Javascript rendered to the html-page head section will look
     * like this:<br>
     * <p/>
     * <pre>
     * $(component_id).mouseup(function(arg1, arg2, ...){
     * 		... js ....
     * });
     * </pre>
     *
     * @param js
     * @param params
     * @return
     */
    public static final JQEventBehavior mouseUp(final CharSequence js, final CharSequence... params) {
        return new JQEventBehavior(MouseEvent.UP) {

            private static final long serialVersionUID = 1L;

            @Override
            public IJQFunction callback() {
                return $f(js).withParams(params);
            }
        };
    }

    /**
     * Builds jquery behavior rendering javascript callback function while proceeding javascript's "mouse up" event on
     * the component this behavior is associated with.<br> Javascript rendered to the html-page head section will look
     * like this:<br>
     * <p/>
     * <pre>
     * $(component_id).mouseup(function(arg1, arg2, ...){
     * 		... stmt ....
     * });
     * </pre>
     *
     * @param stmt
     * @param params
     * @return
     */
    public static final JQEventBehavior mouseUp(final IJQStatement stmt, final CharSequence... params) {
        return new JQEventBehavior(MouseEvent.UP) {

            private static final long serialVersionUID = 1L;

            @Override
            public IJQFunction callback() {
                return $f(stmt).withParams(params);
            }
        };
    }

    /**
     * Builds jquery behavior rendering javascript callback function while proceeding javascript's "mouse up" event on
     * the component this behavior is associated with.<br> Javascript rendered to the html-page head section will look
     * like this:<br>
     * <p/>
     * <pre>
     * $(component_id).mouseup(function(arg1, arg2, ...){
     * 		... function body ....
     * });
     * </pre>
     *
     * @param function
     * @return
     */
    public static final JQEventBehavior mouseUp(final IJQFunction function) {
        return new JQEventBehavior(MouseEvent.UP) {

            private static final long serialVersionUID = 1L;

            @Override
            public IJQFunction callback() {
                return function;
            }
        };
    }

    /**
     * Builds jquery behavior rendering javascript callback function while proceeding javascript's "key up" event on the
     * component this behavior is associated with.<br> Javascript rendered to the html-page head section will look like
     * this:<br>
     * <p/>
     * <pre>
     * $(component_id).keyup(function(arg1, arg2, ...){
     * 		... js ....
     * });
     * </pre>
     *
     * @param js
     * @param params
     * @return
     */
    public static final JQEventBehavior keyUp(final CharSequence js, final CharSequence... params) {
        return new JQEventBehavior(KeyboardEvent.UP) {

            private static final long serialVersionUID = 1L;

            @Override
            public IJQFunction callback() {
                return $f(js).withParams(params);
            }
        };
    }

    /**
     * Builds jquery behavior rendering javascript callback function while proceeding javascript's "key up" event on the
     * component this behavior is associated with.<br> Javascript rendered to the html-page head section will look like
     * this:<br>
     * <p/>
     * <pre>
     * $(component_id).keyup(function(arg1, arg2, ...){
     * 		... stmt ....
     * });
     * </pre>
     *
     * @param stmt
     * @param params
     * @return
     */
    public static final JQEventBehavior keyUp(final IJQStatement stmt, final CharSequence... params) {
        return new JQEventBehavior(KeyboardEvent.UP) {

            private static final long serialVersionUID = 1L;

            @Override
            public IJQFunction callback() {
                return $f(stmt).withParams(params);
            }
        };
    }

    /**
     * Builds jquery behavior rendering javascript callback function while proceeding javascript's "key up" event on the
     * component this behavior is associated with.<br> Javascript rendered to the html-page head section will look like
     * this:<br>
     * <p/>
     * <pre>
     * $(component_id).keyup(function(arg1, arg2, ...){
     * 		... function body ....
     * });
     * </pre>
     *
     * @param function
     * @return
     */
    public static final JQEventBehavior keyUp(final IJQFunction function) {
        return new JQEventBehavior(KeyboardEvent.UP) {

            private static final long serialVersionUID = 1L;

            @Override
            public IJQFunction callback() {
                return function;
            }
        };
    }

    /**
     * Builds jquery behavior rendering javascript callback function while proceeding javascript's "key down" event on
     * the component this behavior is associated with.<br> Javascript rendered to the html-page head section will look
     * like this:<br>
     * <p/>
     * <pre>
     * $(component_id).keydown(function(arg1, arg2, ...){
     * 		... js ....
     * });
     * </pre>
     *
     * @param js
     * @param params
     * @return
     */
    public static final JQEventBehavior keyDown(final CharSequence js, final CharSequence... params) {
        return new JQEventBehavior(KeyboardEvent.DOWN) {

            private static final long serialVersionUID = 1L;

            @Override
            public IJQFunction callback() {
                return $f(js).withParams(params);
            }
        };
    }

    /**
     * Builds jquery behavior rendering javascript callback function while proceeding javascript's "key down" event on
     * the component this behavior is associated with.<br> Javascript rendered to the html-page head section will look
     * like this:<br>
     * <p/>
     * <pre>
     * $(component_id).keydown(function(arg1, arg2, ...){
     * 		... stmt ....
     * });
     * </pre>
     *
     * @param stmt
     * @param params
     * @return
     */
    public static final JQEventBehavior keyDown(final IJQStatement stmt, final CharSequence... params) {
        return new JQEventBehavior(KeyboardEvent.DOWN) {

            private static final long serialVersionUID = 1L;

            @Override
            public IJQFunction callback() {
                return $f(stmt).withParams(params);
            }
        };
    }

    /**
     * Builds jquery behavior rendering javascript callback function while proceeding javascript's "key down" event on
     * the component this behavior is associated with.<br> Javascript rendered to the html-page head section will look
     * like this:<br>
     * <p/>
     * <pre>
     * $(component_id).keydown(function(arg1, arg2, ...){
     * 		... function body ....
     * });
     * </pre>
     *
     * @param function
     * @return
     */
    public static final JQEventBehavior keyDown(final IJQFunction function) {
        return new JQEventBehavior(KeyboardEvent.DOWN) {

            private static final long serialVersionUID = 1L;

            @Override
            public IJQFunction callback() {
                return function;
            }
        };
    }

    /**
     * Builds jquery behavior rendering javascript callback function while proceeding javascript's "key press" event on
     * the component this behavior is associated with.<br> Javascript rendered to the html-page head section will look
     * like this:<br>
     * <p/>
     * <pre>
     * $(component_id).keypress(function(arg1, arg2, ...){
     * 		... js ....
     * });
     * </pre>
     *
     * @param js
     * @param params
     * @return
     */
    public static final JQEventBehavior keyPress(final CharSequence js, final CharSequence... params) {
        return new JQEventBehavior(KeyboardEvent.PRESS) {

            private static final long serialVersionUID = 1L;

            @Override
            public IJQFunction callback() {
                return $f(js).withParams(params);
            }
        };
    }

    /**
     * Builds jquery behavior rendering javascript callback function while proceeding javascript's "key press" event on
     * the component this behavior is associated with.<br> Javascript rendered to the html-page head section will look
     * like this:<br>
     * <p/>
     * <pre>
     * $(component_id).keypress(function(arg1, arg2, ...){
     * 		... stmt ....
     * });
     * </pre>
     *
     * @param stmt
     * @param params
     * @return
     */
    public static final JQEventBehavior keyPress(final IJQStatement stmt, final CharSequence... params) {
        return new JQEventBehavior(KeyboardEvent.PRESS) {

            private static final long serialVersionUID = 1L;

            @Override
            public IJQFunction callback() {
                return $f(stmt).withParams(params);
            }
        };
    }

    /**
     * Builds jquery behavior rendering javascript callback function while proceeding javascript's "key press" event on
     * the component this behavior is associated with.<br> Javascript rendered to the html-page head section will look
     * like this:<br>
     * <p/>
     * <pre>
     * $(component_id).keypress(function(arg1, arg2, ...){
     * 		... function body ....
     * });
     * </pre>
     *
     * @param function
     * @return
     */
    public static final JQEventBehavior keyPress(final IJQFunction function) {
        return new JQEventBehavior(KeyboardEvent.PRESS) {

            private static final long serialVersionUID = 1L;

            @Override
            public IJQFunction callback() {
                return function;
            }
        };
    }

    /**
     * Builds jquery behavior rendering javascript callback function while proceeding javascript's "blur" event on the
     * component this behavior is associated with.<br> Javascript rendered to the html-page head section will look like
     * this:<br>
     * <p/>
     * <pre>
     * $(component_id).blur(function(arg1, arg2, ...){
     * 		... js ....
     * });
     * </pre>
     *
     * @param js
     * @param params
     * @return
     */
    public static final JQEventBehavior blur(final CharSequence js, final CharSequence... params) {
        return new JQEventBehavior(StateEvent.BLUR) {

            private static final long serialVersionUID = 1L;

            @Override
            public IJQFunction callback() {
                return $f(js).withParams(params);
            }
        };
    }

    /**
     * Builds jquery behavior rendering javascript callback function while proceeding javascript's "blur" event on the
     * component this behavior is associated with.<br> Javascript rendered to the html-page head section will look like
     * this:<br>
     * <p/>
     * <pre>
     * $(component_id).blur(function(arg1, arg2, ...){
     * 		... stmt ....
     * });
     * </pre>
     *
     * @param stmt
     * @param params
     * @return
     */
    public static final JQEventBehavior blur(final IJQStatement stmt, final CharSequence... params) {
        return new JQEventBehavior(StateEvent.BLUR) {

            private static final long serialVersionUID = 1L;

            @Override
            public IJQFunction callback() {
                return $f(stmt).withParams(params);
            }
        };
    }

    /**
     * Builds jquery behavior rendering javascript callback function while proceeding javascript's "blur" event on the
     * component this behavior is associated with.<br> Javascript rendered to the html-page head section will look like
     * this:<br>
     * <p/>
     * <pre>
     * $(component_id).blur(function(arg1, arg2, ...){
     * 		... function body ....
     * });
     * </pre>
     *
     * @param function
     * @return
     */
    public static final JQEventBehavior blur(final IJQFunction function) {
        return new JQEventBehavior(StateEvent.BLUR) {

            private static final long serialVersionUID = 1L;

            @Override
            public IJQFunction callback() {
                return function;
            }
        };
    }

    /**
     * Builds jquery behavior rendering javascript callback function while proceeding javascript's "change" event on the
     * component this behavior is associated with.<br> Javascript rendered to the html-page head section will look like
     * this:<br>
     * <p/>
     * <pre>
     * $(component_id).change(function(arg1, arg2, ...){
     * 		... js ....
     * });
     * </pre>
     *
     * @param js
     * @param params
     * @return
     */
    public static final JQEventBehavior change(final CharSequence js, final CharSequence... params) {
        return new JQEventBehavior(StateEvent.CHANGE) {

            private static final long serialVersionUID = 1L;

            @Override
            public IJQFunction callback() {
                return $f(js).withParams(params);
            }
        };
    }

    /**
     * Builds jquery behavior rendering javascript callback function while proceeding javascript's "change" event on the
     * component this behavior is associated with.<br> Javascript rendered to the html-page head section will look like
     * this:<br>
     * <p/>
     * <pre>
     * $(component_id).change(function(arg1, arg2, ...){
     * 		... stmt ....
     * });
     * </pre>
     *
     * @param stmt
     * @param params
     * @return
     */
    public static final JQEventBehavior change(final IJQStatement stmt, final CharSequence... params) {
        return new JQEventBehavior(StateEvent.CHANGE) {

            private static final long serialVersionUID = 1L;

            @Override
            public IJQFunction callback() {
                return $f(stmt).withParams(params);
            }
        };
    }

    /**
     * Builds jquery behavior rendering javascript callback function while proceeding javascript's "change" event on the
     * component this behavior is associated with.<br> Javascript rendered to the html-page head section will look like
     * this:<br>
     * <p/>
     * <pre>
     * $(component_id).change(function(arg1, arg2, ...){
     * 		... function body ....
     * });
     * </pre>
     *
     * @param function
     * @return
     */
    public static final JQEventBehavior change(final IJQFunction function) {
        return new JQEventBehavior(StateEvent.CHANGE) {

            private static final long serialVersionUID = 1L;

            @Override
            public IJQFunction callback() {
                return function;
            }
        };
    }

    /**
     * Builds jquery behavior rendering javascript callback function while proceeding javascript's "error" event on the
     * component this behavior is associated with.<br> Javascript rendered to the html-page head section will look like
     * this:<br>
     * <p/>
     * <pre>
     * $(component_id).error(function(arg1, arg2, ...){
     * 		... js ....
     * });
     * </pre>
     *
     * @param js
     * @param params
     * @return
     */
    public static final JQEventBehavior error(final CharSequence js, final CharSequence... params) {
        return new JQEventBehavior(StateEvent.ERROR) {

            private static final long serialVersionUID = 1L;

            @Override
            public IJQFunction callback() {
                return $f(js).withParams(params);
            }
        };
    }

    /**
     * Builds jquery behavior rendering javascript callback function while proceeding javascript's "error" event on the
     * component this behavior is associated with.<br> Javascript rendered to the html-page head section will look like
     * this:<br>
     * <p/>
     * <pre>
     * $(component_id).error(function(arg1, arg2, ...){
     * 		... stmt ....
     * });
     * </pre>
     *
     * @param stmt
     * @param params
     * @return
     */
    public static final JQEventBehavior error(final IJQStatement stmt, final CharSequence... params) {
        return new JQEventBehavior(StateEvent.ERROR) {

            private static final long serialVersionUID = 1L;

            @Override
            public IJQFunction callback() {
                return $f(stmt).withParams(params);
            }
        };
    }

    /**
     * Builds jquery behavior rendering javascript callback function while proceeding javascript's "error" event on the
     * component this behavior is associated with.<br> Javascript rendered to the html-page head section will look like
     * this:<br>
     * <p/>
     * <pre>
     * $(component_id).error(function(arg1, arg2, ...){
     * 		... function body ....
     * });
     * </pre>
     *
     * @param function
     * @return
     */
    public static final JQEventBehavior error(final IJQFunction function) {
        return new JQEventBehavior(StateEvent.ERROR) {

            private static final long serialVersionUID = 1L;

            @Override
            public IJQFunction callback() {
                return function;
            }
        };
    }

    /**
     * Builds jquery behavior rendering javascript callback function while proceeding javascript's "focus" event on the
     * component this behavior is associated with.<br> Javascript rendered to the html-page head section will look like
     * this:<br>
     * <p/>
     * <pre>
     * $(component_id).focus(function(arg1, arg2, ...){
     * 		... js ....
     * });
     * </pre>
     *
     * @param js
     * @param params
     * @return
     */
    public static final JQEventBehavior focus(final CharSequence js, final CharSequence... params) {
        return new JQEventBehavior(StateEvent.FOCUS) {

            private static final long serialVersionUID = 1L;

            @Override
            public IJQFunction callback() {
                return $f(js).withParams(params);
            }
        };
    }

    /**
     * Builds jquery behavior rendering javascript callback function while proceeding javascript's "focus" event on the
     * component this behavior is associated with.<br> Javascript rendered to the html-page head section will look like
     * this:<br>
     * <p/>
     * <pre>
     * $(component_id).focus(function(arg1, arg2, ...){
     * 		... stmt ....
     * });
     * </pre>
     *
     * @param stmt
     * @param params
     * @return
     */
    public static final JQEventBehavior focus(final IJQStatement stmt, final CharSequence... params) {
        return new JQEventBehavior(StateEvent.FOCUS) {

            private static final long serialVersionUID = 1L;

            @Override
            public IJQFunction callback() {
                return $f(stmt).withParams(params);
            }
        };
    }

    /**
     * Builds jquery behavior rendering javascript callback function while proceeding javascript's "focus" event on the
     * component this behavior is associated with.<br> Javascript rendered to the html-page head section will look like
     * this:<br>
     * <p/>
     * <pre>
     * $(component_id).focus(function(arg1, arg2, ...){
     * 		... function body ....
     * });
     * </pre>
     *
     * @param function
     * @return
     */
    public static final JQEventBehavior focus(final IJQFunction function) {
        return new JQEventBehavior(StateEvent.FOCUS) {

            private static final long serialVersionUID = 1L;

            @Override
            public IJQFunction callback() {
                return function;
            }
        };
    }

    /**
     * Builds jquery behavior rendering javascript callback function while proceeding javascript's "load" event on the
     * component this behavior is associated with.<br> Javascript rendered to the html-page head section will look like
     * this:<br>
     * <p/>
     * <pre>
     * $(component_id).load(function(arg1, arg2, ...){
     * 		... js ....
     * });
     * </pre>
     *
     * @param js
     * @param params
     * @return
     */
    public static final JQEventBehavior load(final CharSequence js, final CharSequence... params) {
        return new JQEventBehavior(StateEvent.LOAD) {

            private static final long serialVersionUID = 1L;

            @Override
            public IJQFunction callback() {
                return $f(js).withParams(params);
            }
        };
    }

    /**
     * Builds jquery behavior rendering javascript callback function while proceeding javascript's "load" event on the
     * component this behavior is associated with.<br> Javascript rendered to the html-page head section will look like
     * this:<br>
     * <p/>
     * <pre>
     * $(component_id).load(function(arg1, arg2, ...){
     * 		... stmt ....
     * });
     * </pre>
     *
     * @param stmt
     * @param params
     * @return
     */
    public static final JQEventBehavior load(final IJQStatement stmt, final CharSequence... params) {
        return new JQEventBehavior(StateEvent.LOAD) {

            private static final long serialVersionUID = 1L;

            @Override
            public IJQFunction callback() {
                return $f(stmt).withParams(params);
            }
        };
    }

    /**
     * Builds jquery behavior rendering javascript callback function while proceeding javascript's "load" event on the
     * component this behavior is associated with.<br> Javascript rendered to the html-page head section will look like
     * this:<br>
     * <p/>
     * <pre>
     * $(component_id).load(function(arg1, arg2, ...){
     * 		... function body ....
     * });
     * </pre>
     *
     * @param function
     * @return
     */
    public static final JQEventBehavior load(final IJQFunction function) {
        return new JQEventBehavior(StateEvent.LOAD) {

            private static final long serialVersionUID = 1L;

            @Override
            public IJQFunction callback() {
                return function;
            }
        };
    }

    /**
     * Builds jquery behavior rendering javascript callback function while proceeding javascript's "resize" event on the
     * component this behavior is associated with.<br> Javascript rendered to the html-page head section will look like
     * this:<br>
     * <p/>
     * <pre>
     * $(component_id).resize(function(arg1, arg2, ...){
     * 		... js ....
     * });
     * </pre>
     *
     * @param js
     * @param params
     * @return
     */
    public static final JQEventBehavior resize(final CharSequence js, final CharSequence... params) {
        return new JQEventBehavior(StateEvent.RESIZE) {

            private static final long serialVersionUID = 1L;

            @Override
            public IJQFunction callback() {
                return $f(js).withParams(params);
            }
        };
    }

    /**
     * Builds jquery behavior rendering javascript callback function while proceeding javascript's "resize" event on the
     * component this behavior is associated with.<br> Javascript rendered to the html-page head section will look like
     * this:<br>
     * <p/>
     * <pre>
     * $(component_id).resize(function(arg1, arg2, ...){
     * 		... stmt ....
     * });
     * </pre>
     *
     * @param stmt
     * @param params
     * @return
     */
    public static final JQEventBehavior resize(final IJQStatement stmt, final CharSequence... params) {
        return new JQEventBehavior(StateEvent.RESIZE) {

            private static final long serialVersionUID = 1L;

            @Override
            public IJQFunction callback() {
                return $f(stmt).withParams(params);
            }
        };
    }

    /**
     * Builds jquery behavior rendering javascript callback function while proceeding javascript's "resize" event on the
     * component this behavior is associated with.<br> Javascript rendered to the html-page head section will look like
     * this:<br>
     * <p/>
     * <pre>
     * $(component_id).resize(function(arg1, arg2, ...){
     * 		... function body ....
     * });
     * </pre>
     *
     * @param function
     * @return
     */
    public static final JQEventBehavior resize(final IJQFunction function) {
        return new JQEventBehavior(StateEvent.RESIZE) {

            private static final long serialVersionUID = 1L;

            @Override
            public IJQFunction callback() {
                return function;
            }
        };
    }

    /**
     * Builds jquery behavior rendering javascript callback function while proceeding javascript's "scroll" event on the
     * component this behavior is associated with.<br> Javascript rendered to the html-page head section will look like
     * this:<br>
     * <p/>
     * <pre>
     * $(component_id).scroll(function(arg1, arg2, ...){
     * 		... js ....
     * });
     * </pre>
     *
     * @param js
     * @param params
     * @return
     */
    public static final JQEventBehavior scroll(final CharSequence js, final CharSequence... params) {
        return new JQEventBehavior(StateEvent.SCROLL) {

            private static final long serialVersionUID = 1L;

            @Override
            public IJQFunction callback() {
                return $f(js).withParams(params);
            }
        };
    }

    /**
     * Builds jquery behavior rendering javascript callback function while proceeding javascript's "scroll" event on the
     * component this behavior is associated with.<br> Javascript rendered to the html-page head section will look like
     * this:<br>
     * <p/>
     * <pre>
     * $(component_id).scroll(function(arg1, arg2, ...){
     * 		... stmt ....
     * });
     * </pre>
     *
     * @param stmt
     * @param params
     * @return
     */
    public static final JQEventBehavior scroll(final IJQStatement stmt, final CharSequence... params) {
        return new JQEventBehavior(StateEvent.SCROLL) {

            private static final long serialVersionUID = 1L;

            @Override
            public IJQFunction callback() {
                return $f(stmt).withParams(params);
            }
        };
    }

    /**
     * Builds jquery behavior rendering javascript callback function while proceeding javascript's "scroll" event on the
     * component this behavior is associated with.<br> Javascript rendered to the html-page head section will look like
     * this:<br>
     * <p/>
     * <pre>
     * $(component_id).scroll(function(arg1, arg2, ...){
     * 		... function body ....
     * });
     * </pre>
     *
     * @param function
     * @return
     */
    public static final JQEventBehavior scroll(final IJQFunction function) {
        return new JQEventBehavior(StateEvent.SCROLL) {

            private static final long serialVersionUID = 1L;

            @Override
            public IJQFunction callback() {
                return function;
            }
        };
    }

    /**
     * Builds jquery behavior rendering javascript callback function while proceeding javascript's "select" event on the
     * component this behavior is associated with.<br> Javascript rendered to the html-page head section will look like
     * this:<br>
     * <p/>
     * <pre>
     * $(component_id).select(function(arg1, arg2, ...){
     * 		... js ....
     * });
     * </pre>
     *
     * @param js
     * @param params
     * @return
     */
    public static final JQEventBehavior select(final CharSequence js, final CharSequence... params) {
        return new JQEventBehavior(StateEvent.SELECT) {

            private static final long serialVersionUID = 1L;

            @Override
            public IJQFunction callback() {
                return $f(js).withParams(params);
            }
        };
    }

    /**
     * Builds jquery behavior rendering javascript callback function while proceeding javascript's "select" event on the
     * component this behavior is associated with.<br> Javascript rendered to the html-page head section will look like
     * this:<br>
     * <p/>
     * <pre>
     * $(component_id).select(function(arg1, arg2, ...){
     * 		... stmt ....
     * });
     * </pre>
     *
     * @param stmt
     * @param params
     * @return
     */
    public static final JQEventBehavior select(final IJQStatement stmt, final CharSequence... params) {
        return new JQEventBehavior(StateEvent.SELECT) {

            private static final long serialVersionUID = 1L;

            @Override
            public IJQFunction callback() {
                return $f(stmt).withParams(params);
            }
        };
    }

    /**
     * Builds jquery behavior rendering javascript callback function while proceeding javascript's "select" event on the
     * component this behavior is associated with.<br> Javascript rendered to the html-page head section will look like
     * this:<br>
     * <p/>
     * <pre>
     * $(component_id).select(function(arg1, arg2, ...){
     * 		... function body ....
     * });
     * </pre>
     *
     * @param function
     * @return
     */
    public static final JQEventBehavior select(final IJQFunction function) {
        return new JQEventBehavior(StateEvent.SELECT) {

            private static final long serialVersionUID = 1L;

            @Override
            public IJQFunction callback() {
                return function;
            }
        };
    }

    /**
     * Builds jquery behavior rendering javascript callback function while proceeding javascript's "submit" event on the
     * component this behavior is associated with.<br> Javascript rendered to the html-page head section will look like
     * this:<br>
     * <p/>
     * <pre>
     * $(component_id).submit(function(arg1, arg2, ...){
     * 		... js ....
     * });
     * </pre>
     *
     * @param js
     * @param params
     * @return
     */
    public static final JQEventBehavior submit(final CharSequence js, final CharSequence... params) {
        return new JQEventBehavior(StateEvent.SUBMIT) {

            private static final long serialVersionUID = 1L;

            @Override
            public IJQFunction callback() {
                return $f(js).withParams(params);
            }
        };
    }

    /**
     * Builds jquery behavior rendering javascript callback function while proceeding javascript's "submit" event on the
     * component this behavior is associated with.<br> Javascript rendered to the html-page head section will look like
     * this:<br>
     * <p/>
     * <pre>
     * $(component_id).submit(function(arg1, arg2, ...){
     * 		... stmt ....
     * });
     * </pre>
     *
     * @param stmt
     * @param params
     * @return
     */
    public static final JQEventBehavior submit(final IJQStatement stmt, final CharSequence... params) {
        return new JQEventBehavior(StateEvent.SUBMIT) {

            private static final long serialVersionUID = 1L;

            @Override
            public IJQFunction callback() {
                return $f(stmt).withParams(params);
            }
        };
    }

    /**
     * Builds jquery behavior rendering javascript callback function while proceeding javascript's "submit" event on the
     * component this behavior is associated with.<br> Javascript rendered to the html-page head section will look like
     * this:<br>
     * <p/>
     * <pre>
     * $(component_id).submit(function(arg1, arg2, ...){
     * 		... function body ....
     * });
     * </pre>
     *
     * @param function
     * @return
     */
    public static final JQEventBehavior submit(final IJQFunction function) {
        return new JQEventBehavior(StateEvent.SUBMIT) {

            private static final long serialVersionUID = 1L;

            @Override
            public IJQFunction callback() {
                return function;
            }
        };
    }

    /**
     * Builds new wicket's behavior converting appropriate component to jquery draggable.
     *
     * @return
     */
    public static final DraggableBehavior draggable() {
        return new DraggableBehavior();
    }

    /**
     * Builds new wicket's behavior converting appropriate component to jquery draggable.
     *
     * @param options
     * @return
     */
    public static final DraggableBehavior draggable(DraggableOptions options) {
        return new DraggableBehavior(options);
    }

    /**
     * Builds new wicket's behavior converting appropriate component to jquery droppable.
     *
     * @return
     */
    public static final DroppableBehavior droppable() {
        return new DroppableBehavior();
    }

    /**
     * Builds new wicket's behavior converting appropriate component to jquery droppable.
     *
     * @param options
     * @return
     */
    public static final DroppableBehavior droppable(DroppableOptions options) {
        return new DroppableBehavior(options);
    }

    /**
     * Builds new wicket's behavior converting appropriate component to jquery resizable.
     *
     * @return
     */
    public static final ResizableBehavior resizable() {
        return new ResizableBehavior();
    }

    /**
     * Builds new wicket's behavior converting appropriate component to jquery resizable.
     *
     * @param options
     * @return
     */
    public static final ResizableBehavior resizable(ResizableOptions options) {
        return new ResizableBehavior(options);
    }

    /**
     * Builds new wicket's behavior converting appropriate component to jquery selectable.
     *
     * @return
     */
    public static final SelectableBehavior selectable() {
        return new SelectableBehavior();
    }

    /**
     * Builds new wicket's behavior converting appropriate component to jquery selectable.
     *
     * @param options
     * @return
     */
    public static final SelectableBehavior selectable(SelectableOptions options) {
        return new SelectableBehavior(options);
    }

    /**
     * Builds new wicket's behavior converting appropriate component to jquery sortable.
     *
     * @return
     */
    public static final SortableBehavior sortable() {
        return new SortableBehavior();
    }

    /**
     * Builds new wicket's behavior converting appropriate component to jquery sortable.
     *
     * @param options
     * @return
     */
    public static final SortableBehavior sortable(SortableOptions options) {
        return new SortableBehavior(options);
    }
}
