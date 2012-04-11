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
package com.google.code.jqwicket.api;

import org.apache.wicket.Component;

import java.io.Serializable;

/**
 * JQuery selector builder.
 *
 * @author mkalina
 */
public abstract class S implements Serializable {

    private static final long serialVersionUID = 1L;

    S() {
        ; // invisible
    }

    /**
     * Creates jquery any selector: <tt>*</tt>
     *
     * @return
     * @see <a href="http://api.jquery.com/all-selector/">http://api.jquery.com/all-selector/</a>
     */
    public static final SBuilder any() {
        return new SBuilder().any();
    }

    /**
     * Creates jquery animated selector: <tt>:animated</tt>
     *
     * @return
     * @see <a href="http://api.jquery.com/animated-selector/">http://api.jquery.com/animated-selector/</a>
     */
    public static final SBuilder animated() {
        return new SBuilder().animated();
    }

    /**
     * Creates jquery attributeContainsPrefix selector: <tt>[attribute|='value']</tt>
     *
     * @param attribute
     * @param value
     * @return
     * @see <a href="http://api.jquery.com/attribute-contains-prefix-selector/">http://api.jquery.com/attribute-contains-prefix-selector/</a>
     */
    public static final SBuilder attributeContainsPrefix(
            CharSequence attribute, CharSequence value) {
        return new SBuilder().attributeContainsPrefix(attribute, value);
    }

    /**
     * Creates jquery attributeContains selector: <tt>[attribute*='value']</tt>
     *
     * @param attribute
     * @param value
     * @return
     * @see <a href="http://api.jquery.com/attribute-contains-selector/">http://api.jquery.com/attribute-contains-selector/</a>
     */
    public static final SBuilder attributeContains(CharSequence attribute,
                                                   CharSequence value) {
        return new SBuilder().attributeContains(attribute, value);
    }

    /**
     * Creates jquery attributeContainsWord selector: <tt>[attribute~='value']</tt>
     *
     * @param attribute
     * @param value
     * @return
     * @see <a href="http://api.jquery.com/attribute-contains-word-selector/">http://api.jquery.com/attribute-contains-word-selector/</a>
     */
    public static final SBuilder attributeContainsWord(CharSequence attribute,
                                                       CharSequence value) {
        return new SBuilder().attributeContainsWord(attribute, value);
    }

    /**
     * Creates jquery attributeEndsWith selector: <tt>[attribute$='value']</tt>
     *
     * @param attribute
     * @param value
     * @return
     * @see <a href="http://api.jquery.com/attribute-ends-with-selector/">http://api.jquery.com/attribute-ends-with-selector/</a>
     */
    public static final SBuilder attributeEndsWith(CharSequence attribute,
                                                   CharSequence value) {
        return new SBuilder().attributeEndsWith(attribute, value);
    }

    /**
     * Creates jquery attributeEquals selector: <tt>[attribute='value']</tt>
     *
     * @param attribute
     * @param value
     * @return
     * @see <a href="http://api.jquery.com/attribute-equals-selector/">http://api.jquery.com/attribute-equals-selector/</a>
     */
    public static final SBuilder attributeEquals(CharSequence attribute,
                                                 CharSequence value) {
        return new SBuilder().attributeEquals(attribute, value);
    }

    /**
     * Creates jquery attributeNotEqual selector: <tt>[attribute!='value']</tt>
     *
     * @param attribute
     * @param value
     * @return
     * @see <a href="http://api.jquery.com/attribute-not-equal-selector/">http://api.jquery.com/attribute-not-equal-selector/</a>
     */
    public static final SBuilder attributeNotEqual(CharSequence attribute,
                                                   CharSequence value) {
        return new SBuilder().attributeNotEqual(attribute, value);
    }

    /**
     * Creates jquery attributeStartsWith selector: <tt>[attribute^='value']</tt>
     *
     * @param attribute
     * @param value
     * @return
     * @see <a href="http://api.jquery.com/attribute-starts-with-selector/">http://api.jquery.com/attribute-starts-with-selector/</a>
     */
    public static final SBuilder attributeStartsWith(CharSequence attribute,
                                                     CharSequence value) {
        return new SBuilder().attributeStartsWith(attribute, value);
    }

    /**
     * Creates jquery button selector: <tt>:button</tt>
     *
     * @return
     * @see <a href="http://api.jquery.com/button-selector/">http://api.jquery.com/button-selector/</a>
     */
    public static final SBuilder button() {
        return new SBuilder().button();
    }

    /**
     * Creates jquery checkbox selector: <tt>:checkbox</tt>
     *
     * @return
     * @see <a href="http://api.jquery.com/checkbox-selector/">http://api.jquery.com/checkbox-selector/</a>
     */
    public static final SBuilder checkbox() {
        return new SBuilder().checkbox();
    }

    /**
     * Creates jquery checked selector: <tt>:checked</tt>
     *
     * @return
     * @see <a href="http://api.jquery.com/checked-selector/">http://api.jquery.com/checked-selector/</a>
     */
    public static final SBuilder checked() {
        return new SBuilder().checked();
    }

    /**
     * Creates jquery child selector: <tt>parent > child</tt>
     *
     * @param parent Any valid selector.
     * @param child  A selector to filter the child elements.
     * @return
     * @see <a href="http://api.jquery.com/child-selector/">http://api.jquery.com/child-selector/</a>
     */
    public static final SBuilder child(CharSequence parent, CharSequence child) {
        return new SBuilder().child(parent, child);
    }

    /**
     * Creates jquery child selector: <tt>#parentComponentId > #childComponentId</tt>
     *
     * @param parentComponent    any parent component
     * @param childChilComponent any child component
     * @return
     * @see <a href="http://api.jquery.com/child-selector/">http://api.jquery.com/child-selector/</a>
     */
    public static final SBuilder child(Component parentComponent,
                                       Component childChilComponent) {
        return new SBuilder().child(parentComponent, childChilComponent);
    }

    /**
     * Creates jquery class selector: <tt>.clazz</tt>
     *
     * @param clazz
     * @return
     * @see <a href="http://api.jquery.com/class-selector/">http://api.jquery.com/class-selector/</a>
     */
    public static final SBuilder clazz(CharSequence clazz) {
        return new SBuilder().clazz(clazz);
    }

    /**
     * Creates jquery contains selector: <tt>:contains('text')</tt>
     *
     * @param text
     * @return
     * @see <a href="http://api.jquery.com/contains-selector/">http://api.jquery.com/contains-selector/</a>
     */
    public static final SBuilder contains(CharSequence text) {
        return new SBuilder().contains(text);
    }

    /**
     * Creates jquery descendant selector: <tt>ancestor descendant</tt>
     *
     * @param ancestor   Any valid selector.
     * @param descendant A selector to filter the descendant elements.
     * @return
     * @see <a href="http://api.jquery.com/descendant-selector/">http://api.jquery.com/descendant-selector/</a>
     */
    public static final SBuilder descendant(CharSequence ancestor,
                                            CharSequence descendant) {
        return new SBuilder().descendant(ancestor, descendant);
    }

    /**
     * Creates jquery descendant selector: <tt>#ancestorComponentId #descendantComponentId</tt>
     *
     * @param ancestorComponent   a ancestor component
     * @param descendantComponent a descendant component
     * @return
     * @see <a href="http://api.jquery.com/descendant-selector/">http://api.jquery.com/descendant-selector/</a>
     */
    public static final SBuilder descendant(Component ancestorComponent,
                                            Component descendantComponent) {
        return new SBuilder()
                .descendant(ancestorComponent, descendantComponent);
    }

    /**
     * Creates jquery disabled selector: <tt>:disabled</tt>
     *
     * @return
     * @see <a href="http://api.jquery.com/disabled-selector/">http://api.jquery.com/disabled-selector/</a>
     */
    public static final SBuilder disabled() {
        return new SBuilder().disabled();
    }

    /**
     * Creates jquery element selector: <tt>element</tt>
     *
     * @param element
     * @return
     * @see <a href="http://api.jquery.com/element-selector/">http://api.jquery.com/element-selector/</a>
     */
    public static final SBuilder element(CharSequence element) {
        return new SBuilder().element(element);
    }

    /**
     * Creates jquery empty selector: <tt>:empty</tt>
     *
     * @return
     * @see <a href="http://api.jquery.com/empty-selector/">http://api.jquery.com/empty-selector/</a>
     */
    public static final SBuilder empty() {
        return new SBuilder().empty();
    }

    /**
     * Creates jquery empty selector: <tt>:enabled</tt>
     *
     * @return
     * @see <a href="http://api.jquery.com/enabled-selector/">http://api.jquery.com/enabled-selector/</a>
     */
    public static final SBuilder enabled() {
        return new SBuilder().enabled();
    }

    /**
     * Creates jquery eq selector: <tt>:eq(index)</tt>
     *
     * @param index Zero-based index of the element to match.
     * @return
     * @see <a href="http://api.jquery.com/eq-selector/">http://api.jquery.com/eq-selector/</a>
     */
    public static final SBuilder eq(int index) {
        return new SBuilder().eq(index);
    }

    /**
     * Creates jquery even selector: <tt>:even</tt>
     *
     * @return
     * @see <a href="http://api.jquery.com/even-selector/">http://api.jquery.com/even-selector/</a>
     */
    public static final SBuilder even() {
        return new SBuilder().even();
    }

    /**
     * Creates jquery file selector: <tt>:file</tt>
     *
     * @return
     * @see <a href="http://api.jquery.com/file-selector/">http://api.jquery.com/file-selector/</a>
     */
    public static final SBuilder file() {
        return new SBuilder().file();
    }

    /**
     * Creates jquery first child selector: <tt>:first-child</tt>
     *
     * @return
     * @see <a href="http://api.jquery.com/first-child-selector/">http://api.jquery.com/first-child-selector/</a>
     */
    public static final SBuilder firstChild() {
        return new SBuilder().firstChild();
    }

    /**
     * Creates jquery first selector: <tt>:first</tt>
     *
     * @return
     * @see <a href="http://api.jquery.com/first-selector/">http://api.jquery.com/first-selector/</a>
     */
    public static final SBuilder first() {
        return new SBuilder().first();
    }

    /**
     * Creates jquery focus selector: <tt>:focus</tt>
     *
     * @return
     * @see <a href="http://api.jquery.com/focus-selector/">http://api.jquery.com/focus-selector/</a>
     */
    public static final SBuilder focus() {
        return new SBuilder().focus();
    }

    /**
     * Creates jquery gt selector: <tt>:gt(index)</tt>
     *
     * @param index Zero-based index.
     * @return
     * @see <a href="http://api.jquery.com/gt-selector/">http://api.jquery.com/gt-selector/</a>
     */
    public static final SBuilder gt(int index) {
        return new SBuilder().gt(index);
    }

    /**
     * Creates jquery has attribute selector: <tt>[attribute]</tt>
     *
     * @param attribute
     * @return
     * @see <a href="http://api.jquery.com/has-attribute-selector/">http://api.jquery.com/has-attribute-selector/</a>
     */
    public static final SBuilder hasAttribute(CharSequence attribute) {
        return new SBuilder().hasAttribute(attribute);
    }

    /**
     * Creates jquery has selector: <tt>:has(selector)</tt>
     *
     * @param selector any selector
     * @return
     * @see <a href="http://api.jquery.com/has-selector/">http://api.jquery.com/has-selector/</a>
     */
    public static final SBuilder has(CharSequence selector) {
        return new SBuilder().has(selector);
    }

    /**
     * Creates jquery has selector: <tt>:has(#componentId)</tt>
     *
     * @param component is a component to find
     * @return
     * @see <a href="http://api.jquery.com/has-selector/">http://api.jquery.com/has-selector/</a>
     */
    public static final SBuilder has(Component component) {
        return new SBuilder().has(component);
    }

    /**
     * Creates jquery header selector: <tt>:header</tt>
     *
     * @return
     * @see <a href="http://api.jquery.com/header-selector/">http://api.jquery.com/header-selector/</a>
     */
    public static final SBuilder header() {
        return new SBuilder().header();
    }

    /**
     * Creates jquery hidden selector: <tt>:hidden</tt>
     *
     * @return
     * @see <a href="http://api.jquery.com/hidden-selector/">http://api.jquery.com/hidden-selector/</a>
     */
    public static final SBuilder hidden() {
        return new SBuilder().hidden();
    }

    /**
     * Creates jquery id selector for the given wicket component: <tt>#componentId</tt>
     *
     * @return
     * @see <a href="http://api.jquery.com/id-selector/">http://api.jquery.com/id-selector/</a>
     */
    public static final SBuilder id(Component component) {
        return new SBuilder().id(component);
    }

    /**
     * Creates jquery id selector: <tt>#id</tt>
     *
     * @return
     * @see <a href="http://api.jquery.com/id-selector/">http://api.jquery.com/id-selector/</a>
     */
    public static final SBuilder id(CharSequence id) {
        return new SBuilder().id(id);
    }

    /**
     * Creates jquery image selector: <tt>:image</tt>
     *
     * @return
     * @see <a href="http://api.jquery.com/image-selector/">http://api.jquery.com/image-selector/</a>
     */
    public static final SBuilder image() {
        return new SBuilder().image();
    }

    /**
     * Creates jquery input selector: <tt>:input</tt>
     *
     * @return
     * @see <a href="http://api.jquery.com/input-selector/">http://api.jquery.com/input-selector/</a>
     */
    public static final SBuilder input() {
        return new SBuilder().input();
    }

    /**
     * Creates jquery last-child selector: <tt>:last-child</tt>
     *
     * @return
     * @see <a href="http://api.jquery.com/last-child-selector/">http://api.jquery.com/last-child-selector/</a>
     */
    public static final SBuilder lastChild() {
        return new SBuilder().lastChild();
    }

    /**
     * Creates jquery last selector: <tt>:last</tt>
     *
     * @return
     * @see <a href="http://api.jquery.com/last-selector/">http://api.jquery.com/last-selector/</a>
     */
    public static final SBuilder last() {
        return new SBuilder().last();
    }

    /**
     * Creates jquery lt selector: <tt>:lt(index)</tt>
     *
     * @param index Zero-based index.
     * @return
     * @see <a href="http://api.jquery.com/lt-selector/">http://api.jquery.com/lt-selector/</a>
     */
    public static final SBuilder lt(int index) {
        return new SBuilder().lt(index);
    }

    /**
     * Creates jquery multiple selector: <tt>selector1, selector2, ..., selectorN</tt>
     *
     * @param selectors
     * @return
     * @see <a href="http://api.jquery.com/multiple-selector/">http://api.jquery.com/multiple-selector/</a>
     */
    public static final SBuilder multiple(CharSequence... selectors) {
        return new SBuilder().multiple(selectors);
    }

    /**
     * Creates jquery multiple selector: <tt>componentId1, componentId2, ..., componentIdN</tt>
     *
     * @param components
     * @return
     * @see <a href="http://api.jquery.com/multiple-selector/">http://api.jquery.com/multiple-selector/</a>
     */
    public static final SBuilder multiple(Component... components) {
        return new SBuilder().multiple(components);
    }

    /**
     * Creates jquery next adjacent selector: <tt>prev + next</tt>
     *
     * @param prev Any valid selector.
     * @param next A selector to match the element that is next to the first selector.
     * @return
     * @see <a href="http://api.jquery.com/next-adjacent-Selector/">http://api.jquery.com/next-adjacent-Selector/</a>
     */
    public static final SBuilder nextAdjacent(CharSequence prev,
                                              CharSequence next) {
        return new SBuilder().nextAdjacent(prev, next);
    }

    /**
     * Creates jquery next adjacent selector: <tt>#prevComponentId + #nextComponentId</tt>
     *
     * @param prevComponent
     * @param nextComponent
     * @return
     * @see <a href="http://api.jquery.com/next-adjacent-Selector/">http://api.jquery.com/next-adjacent-Selector/</a>
     */
    public static final SBuilder nextAdjacent(Component prevComponent,
                                              Component nextComponent) {
        return new SBuilder().nextAdjacent(prevComponent, nextComponent);
    }

    /**
     * Creates jquery next adjacent selector: <tt>prev ~ siblings</tt>
     *
     * @param prev     Any valid selector.
     * @param siblings A selector to filter elements that are the following siblings of the first selector.
     * @return
     * @see <a href="http://api.jquery.com/next-siblings-selector/">http://api.jquery.com/next-siblings-selector/</a>
     */
    public static final SBuilder nextSiblings(CharSequence prev,
                                              CharSequence siblings) {
        return new SBuilder().nextSiblings(prev, siblings);
    }

    /**
     * Creates jquery next adjacent selector: <tt>#prevComponentId ~ #siblingComponentId</tt>
     *
     * @param prevComponent
     * @param siblingComponent
     * @return
     * @see <a href="http://api.jquery.com/next-siblings-selector/">http://api.jquery.com/next-siblings-selector/</a>
     */
    public static final SBuilder nextSiblings(Component prevComponent,
                                              Component siblingComponent) {
        return new SBuilder().nextSiblings(prevComponent, siblingComponent);
    }

    /**
     * Creates jquery not selector: <tt>:not(selector)</tt>
     *
     * @param selector
     * @return
     * @see <a href="http://api.jquery.com/not-selector/">http://api.jquery.com/not-selector/</a>
     */
    public static final SBuilder not(CharSequence selector) {
        return new SBuilder().not(selector);
    }

    /**
     * Creates jquery not selector: <tt>:not(#componentId)</tt>
     *
     * @param component
     * @return
     * @see <a href="http://api.jquery.com/not-selector/">http://api.jquery.com/not-selector/</a>
     */
    public static final SBuilder not(Component component) {
        return new SBuilder().not(component);
    }

    /**
     * Creates jquery nth-child selector: <tt>:nth-child(index)</tt>
     *
     * @param index
     * @return
     * @see <a href="http://api.jquery.com/nth-child-selector/">http://api.jquery.com/nth-child-selector/</a>
     */
    public static final SBuilder nthChild(int index) {
        return new SBuilder().nthChild(index);
    }

    /**
     * Creates jquery nth-child selector: <tt>:nth-child(equation)</tt>
     *
     * @param equation
     * @return
     * @see <a href="http://api.jquery.com/nth-child-selector/">http://api.jquery.com/nth-child-selector/</a>
     */
    public static final SBuilder nthChild(CharSequence equation) {
        return new SBuilder().nthChild(equation);
    }

    /**
     * Creates jquery odd selector: <tt>:odd</tt>
     *
     * @return
     * @see <a href="http://api.jquery.com/odd-selector/">http://api.jquery.com/odd-selector/</a>
     */
    public static final SBuilder odd() {
        return new SBuilder().odd();
    }

    /**
     * Creates jquery only-child selector: <tt>:only-child</tt>
     *
     * @return
     * @see <a href="http://api.jquery.com/only-child-selector/">http://api.jquery.com/only-child-selector/</a>
     */
    public static final SBuilder onlyChild() {
        return new SBuilder().onlyChild();
    }

    /**
     * Creates jquery parent selector: <tt>:parent</tt>
     *
     * @return
     * @see <a href="http://api.jquery.com/parent-selector/">http://api.jquery.com/parent-selector/</a>
     */
    public static final SBuilder parent() {
        return new SBuilder().parent();
    }

    /**
     * Creates jquery password selector: <tt>:password</tt>
     *
     * @return
     * @see <a href="http://api.jquery.com/password-selector/">http://api.jquery.com/password-selector/</a>
     */
    public static final SBuilder password() {
        return new SBuilder().password();
    }

    /**
     * Creates jquery radio selector: <tt>:radio</tt>
     *
     * @return
     * @see <a href="http://api.jquery.com/radio-selector/">http://api.jquery.com/radio-selector/</a>
     */
    public static final SBuilder radio() {
        return new SBuilder().radio();
    }

    /**
     * Creates jquery reset selector: <tt>:reset</tt>
     *
     * @return
     * @see <a href="http://api.jquery.com/reset-selector/">http://api.jquery.com/reset-selector/</a>
     */
    public static final SBuilder reset() {
        return new SBuilder().reset();
    }

    /**
     * Creates jquery selected selector: <tt>:selected</tt>
     *
     * @return
     * @see <a href="http://api.jquery.com/selected-selector/">http://api.jquery.com/selected-selector/</a>
     */
    public static final SBuilder selected() {
        return new SBuilder().selected();
    }

    /**
     * Creates jquery submit selector: <tt>:submit</tt>
     *
     * @return
     * @see <a href="http://api.jquery.com/submit-selector/">http://api.jquery.com/submit-selector/</a>
     */
    public static final SBuilder submit() {
        return new SBuilder().submit();
    }

    /**
     * Creates jquery text selector: <tt>:text</tt>
     *
     * @return
     * @see <a href="http://api.jquery.com/text-selector/">http://api.jquery.com/text-selector/</a>
     */
    public static final SBuilder text() {
        return new SBuilder().text();
    }

    /**
     * Creates jquery visible selector: <tt>:visible</tt>
     *
     * @return
     * @see <a href="http://api.jquery.com/visible-selector/">http://api.jquery.com/visible-selector/</a>
     */
    public static final SBuilder visible() {
        return new SBuilder().visible();
    }

    public static class SBuilder implements CharSequence, Serializable {

        private static final long serialVersionUID = 1L;

        private StringBuffer buf;

        SBuilder() {
            this.buf = new StringBuffer();
        }

        /**
         * Creates jquery not selector: <tt>:not(#componentId)</tt>
         *
         * @param component
         * @return
         * @see <a href="http://api.jquery.com/not-selector/">http://api.jquery.com/not-selector/</a>
         */
        public SBuilder not(Component component) {
            return not(id(component));
        }

        /**
         * Creates jquery visible selector: <tt>:visible</tt>
         *
         * @return
         * @see <a href="http://api.jquery.com/visible-selector/">http://api.jquery.com/visible-selector/</a>
         */
        public SBuilder visible() {
            this.buf.append(":visible");
            return this;
        }

        /**
         * Creates jquery text selector: <tt>:text</tt>
         *
         * @return
         * @see <a href="http://api.jquery.com/text-selector/">http://api.jquery.com/text-selector/</a>
         */
        public SBuilder text() {
            this.buf.append(":text");
            return this;
        }

        /**
         * Creates jquery submit selector: <tt>:submit</tt>
         *
         * @return
         * @see <a href="http://api.jquery.com/submit-selector/">http://api.jquery.com/submit-selector/</a>
         */
        public SBuilder submit() {
            this.buf.append(":submit");
            return this;
        }

        /**
         * Creates jquery selected selector: <tt>:selected</tt>
         *
         * @return
         * @see <a href="http://api.jquery.com/selected-selector/">http://api.jquery.com/selected-selector/</a>
         */
        public SBuilder selected() {
            this.buf.append(":selected");
            return this;
        }

        /**
         * Creates jquery reset selector: <tt>:reset</tt>
         *
         * @return
         * @see <a href="http://api.jquery.com/reset-selector/">http://api.jquery.com/reset-selector/</a>
         */
        public SBuilder reset() {
            this.buf.append(":reset");
            return this;
        }

        /**
         * Creates jquery radio selector: <tt>:radio</tt>
         *
         * @return
         * @see <a href="http://api.jquery.com/radio-selector/">http://api.jquery.com/radio-selector/</a>
         */
        public SBuilder radio() {
            this.buf.append(":radio");
            return this;
        }

        /**
         * Creates jquery password selector: <tt>:parent</tt>
         *
         * @return
         * @see <a href="http://api.jquery.com/password-selector/">http://api.jquery.com/password-selector/</a>
         */
        public SBuilder password() {
            this.buf.append(":password");
            return this;
        }

        /**
         * Creates jquery parent selector: <tt>:parent</tt>
         *
         * @return
         * @see <a href="http://api.jquery.com/parent-selector/">http://api.jquery.com/parent-selector/</a>
         */
        public SBuilder parent() {
            this.buf.append(":parent");
            return this;
        }

        /**
         * Creates jquery only-child selector: <tt>:only-child</tt>
         *
         * @return
         * @see <a href="http://api.jquery.com/only-child-selector/">http://api.jquery.com/only-child-selector/</a>
         */
        public SBuilder onlyChild() {
            this.buf.append(":only-child");
            return this;
        }

        /**
         * Creates jquery odd selector: <tt>:odd</tt>
         *
         * @return
         * @see <a href="http://api.jquery.com/odd-selector/">http://api.jquery.com/odd-selector/</a>
         */
        public SBuilder odd() {
            this.buf.append(":odd");
            return this;
        }

        /**
         * Creates jquery nth-child selector: <tt>:nth-child(equation)</tt>
         *
         * @param equation
         * @return
         * @see <a href="http://api.jquery.com/nth-child-selector/">http://api.jquery.com/nth-child-selector/</a>
         */
        public SBuilder nthChild(CharSequence equation) {
            this.buf.append(":nth-child(").append(equation).append(")");
            return this;
        }

        /**
         * Creates jquery nth-child selector: <tt>:nth-child(index)</tt>
         *
         * @param index
         * @return
         * @see <a href="http://api.jquery.com/nth-child-selector/">http://api.jquery.com/nth-child-selector/</a>
         */
        public SBuilder nthChild(int index) {
            this.buf.append(":nth-child(").append(index).append(")");
            return this;
        }

        /**
         * Creates jquery not selector: <tt>:not(selector)</tt>
         *
         * @param selector
         * @return
         * @see <a href="http://api.jquery.com/not-selector/">http://api.jquery.com/not-selector/</a>
         */
        public SBuilder not(CharSequence selector) {
            this.buf.append(":not(").append(selector).append(")");
            return this;
        }

        /**
         * Creates jquery next adjacent selector: <tt>prev ~ siblings</tt>
         *
         * @param prev     Any valid selector.
         * @param siblings A selector to filter elements that are the following siblings of the first selector.
         * @return
         * @see <a href="http://api.jquery.com/next-siblings-selector/">http://api.jquery.com/next-siblings-selector/</a>
         */
        public SBuilder nextSiblings(CharSequence prev, CharSequence siblings) {
            this.buf.append(prev).append(" ~ ").append(siblings);
            return this;
        }

        /**
         * Creates jquery next adjacent selector: <tt>#prevComponentId ~ #siblingComponentId</tt>
         *
         * @param prevComponent
         * @param siblingComponent
         * @return
         * @see <a href="http://api.jquery.com/next-siblings-selector/">http://api.jquery.com/next-siblings-selector/</a>
         */
        public SBuilder nextSiblings(Component prevComponent,
                                     Component siblingComponent) {
            return nextSiblings(id(prevComponent), id(siblingComponent));
        }

        /**
         * Creates jquery next adjacent selector: <tt>prev + next</tt>
         *
         * @param prev Any valid selector.
         * @param next A selector to match the element that is next to the first selector.
         * @return
         * @see <a href="http://api.jquery.com/next-adjacent-Selector/">http://api.jquery.com/next-adjacent-Selector/</a>
         */
        public SBuilder nextAdjacent(CharSequence prev, CharSequence next) {
            this.buf.append(prev).append(" + ").append(next);
            return this;
        }

        /**
         * Creates jquery next adjacent selector: <tt>#prevComponentId + #nextComponentId</tt>
         *
         * @param prevComponent
         * @param nextComponent
         * @return
         * @see <a href="http://api.jquery.com/next-adjacent-Selector/">http://api.jquery.com/next-adjacent-Selector/</a>
         */
        public SBuilder nextAdjacent(Component prevComponent,
                                     Component nextComponent) {
            return nextAdjacent(id(prevComponent), id(nextComponent));
        }

        /**
         * Creates jquery multiple selector: <tt>selector1, selector2, ..., selectorN</tt>
         *
         * @param selectors
         * @return
         * @see <a href="http://api.jquery.com/multiple-selector/">http://api.jquery.com/multiple-selector/</a>
         */
        public SBuilder multiple(CharSequence... selectors) {
            for (int i = 0; i < selectors.length; i++) {
                buf.append(i != 0 ? "," : "").append(selectors[i]);
            }
            return this;
        }

        /**
         * Creates jquery multiple selector: <tt>componentId1, componentId2, ..., componentIdN</tt>
         *
         * @param components
         * @return
         * @see <a href="http://api.jquery.com/multiple-selector/">http://api.jquery.com/multiple-selector/</a>
         */
        public SBuilder multiple(Component... components) {
            CharSequence[] ids = new CharSequence[components.length];
            for (int i = 0; i < components.length; i++) {
                ids[i] = id(components[i]);
            }
            return multiple(ids);
        }

        /**
         * Creates jquery lt selector: <tt>:lt(index)</tt>
         *
         * @param index Zero-based index.
         * @return
         * @see <a href="http://api.jquery.com/lt-selector/">http://api.jquery.com/lt-selector/</a>
         */
        public SBuilder lt(int index) {
            this.buf.append(":lt(").append(index).append(")");
            return this;
        }

        /**
         * Creates jquery last selector: <tt>:last</tt>
         *
         * @return
         * @see <a href="http://api.jquery.com/last-selector/">http://api.jquery.com/last-selector/</a>
         */
        public SBuilder last() {
            this.buf.append(":last");
            return this;
        }

        /**
         * Creates jquery last-child selector: <tt>:last-child</tt>
         *
         * @return
         * @see <a href="http://api.jquery.com/last-child-selector/">http://api.jquery.com/last-child-selector/</a>
         */
        public SBuilder lastChild() {
            this.buf.append(":last-child");
            return this;
        }

        /**
         * Creates jquery input selector: <tt>:input</tt>
         *
         * @return
         * @see <a href="http://api.jquery.com/input-selector/">http://api.jquery.com/input-selector/</a>
         */
        public SBuilder input() {
            this.buf.append(":input");
            return this;
        }

        /**
         * Creates jquery image selector: <tt>:image</tt>
         *
         * @return
         * @see <a href="http://api.jquery.com/image-selector/">http://api.jquery.com/image-selector/</a>
         */
        public SBuilder image() {
            this.buf.append(":image");
            return this;
        }

        /**
         * Creates jquery id selector for the given wicket component: <tt>#componentId</tt>
         *
         * @return
         * @see <a href="http://api.jquery.com/id-selector/">http://api.jquery.com/id-selector/</a>
         */
        public SBuilder id(Component component) {
            this.buf.append("#").append(component.getMarkupId());
            return this;
        }

        /**
         * Creates jquery id selector: <tt>#id</tt>
         *
         * @return
         * @see <a href="http://api.jquery.com/id-selector/">http://api.jquery.com/id-selector/</a>
         */
        public SBuilder id(CharSequence id) {
            this.buf.append("#").append(id);
            return this;
        }

        /**
         * Creates jquery hidden selector: <tt>:hidden</tt>
         *
         * @return
         * @see <a href="http://api.jquery.com/hidden-selector/">http://api.jquery.com/hidden-selector/</a>
         */
        public SBuilder hidden() {
            this.buf.append(":hidden");
            return this;
        }

        /**
         * Creates jquery header selector: <tt>:header</tt>
         *
         * @return
         * @see <a href="http://api.jquery.com/header-selector/">http://api.jquery.com/header-selector/</a>
         */
        public SBuilder header() {
            this.buf.append(":header");
            return this;
        }

        /**
         * Creates jquery has selector: <tt>:has(selector)</tt>
         *
         * @param selector any selector
         * @return
         * @see <a href="http://api.jquery.com/has-selector/">http://api.jquery.com/has-selector/</a>
         */
        public SBuilder has(CharSequence selector) {
            this.buf.append(":has(").append(selector).append(")");
            return this;
        }

        /**
         * Creates jquery has selector: <tt>:has(#componentId)</tt>
         *
         * @param component is a component to find
         * @return
         * @see <a href="http://api.jquery.com/has-selector/">http://api.jquery.com/has-selector/</a>
         */
        public SBuilder has(Component component) {
            return has(id(component));
        }

        /**
         * Creates jquery has attribute selector: <tt>[attribute]</tt>
         *
         * @param attribute
         * @return
         * @see <a href="http://api.jquery.com/has-attribute-selector/">http://api.jquery.com/has-attribute-selector/</a>
         */
        public SBuilder hasAttribute(CharSequence attribute) {
            this.buf.append("[").append(attribute).append("]");
            return this;
        }

        /**
         * Creates jquery gt selector: <tt>:gt(index)</tt>
         *
         * @param index Zero-based index.
         * @return
         * @see <a href="http://api.jquery.com/gt-selector/">http://api.jquery.com/gt-selector/</a>
         */
        public SBuilder gt(int index) {
            this.buf.append(":gt(").append(index).append(")");
            return this;
        }

        /**
         * Creates jquery focus selector: <tt>:focus</tt>
         *
         * @return
         * @see <a href="http://api.jquery.com/focus-selector/">http://api.jquery.com/focus-selector/</a>
         */
        public SBuilder focus() {
            this.buf.append(":focus");
            return this;
        }

        /**
         * Creates jquery first selector: <tt>:first</tt>
         *
         * @return
         * @see <a href="http://api.jquery.com/first-selector/">http://api.jquery.com/first-selector/</a>
         */
        public SBuilder first() {
            this.buf.append(":first");
            return this;
        }

        /**
         * Creates jquery first child selector: <tt>:first-child</tt>
         *
         * @return
         * @see <a href="http://api.jquery.com/first-child-selector/">http://api.jquery.com/first-child-selector/</a>
         */
        public SBuilder firstChild() {
            this.buf.append(":first-child");
            return this;
        }

        /**
         * Creates jquery file selector: <tt>:file</tt>
         *
         * @return
         * @see <a href="http://api.jquery.com/file-selector/">http://api.jquery.com/file-selector/</a>
         */
        public SBuilder file() {
            this.buf.append(":file");
            return this;
        }

        /**
         * Creates jquery even selector: <tt>:even</tt>
         *
         * @return
         * @see <a href="http://api.jquery.com/even-selector/">http://api.jquery.com/even-selector/</a>
         */
        public SBuilder even() {
            this.buf.append(":even");
            return this;
        }

        /**
         * Creates jquery eq selector: <tt>:eq(index)</tt>
         *
         * @param index Zero-based index of the element to match.
         * @return
         * @see <a href="http://api.jquery.com/eq-selector/">http://api.jquery.com/eq-selector/</a>
         */
        public SBuilder eq(int index) {
            this.buf.append(":eq(").append(index).append(")");
            return this;
        }

        /**
         * Creates jquery empty selector: <tt>:enabled</tt>
         *
         * @return
         * @see <a href="http://api.jquery.com/enabled-selector/">http://api.jquery.com/enabled-selector/</a>
         */
        public SBuilder enabled() {
            this.buf.append(":enabled");
            return this;
        }

        /**
         * Creates jquery empty selector: <tt>:empty</tt>
         *
         * @return
         * @see <a href="http://api.jquery.com/empty-selector/">http://api.jquery.com/empty-selector/</a>
         */
        public SBuilder empty() {
            this.buf.append(":empty");
            return this;
        }

        /**
         * Creates jquery element selector: <tt>element</tt>
         *
         * @param element
         * @return
         * @see <a href="http://api.jquery.com/element-selector/">http://api.jquery.com/element-selector/</a>
         */
        public SBuilder element(CharSequence element) {
            this.buf.append(element);
            return this;
        }

        /**
         * Creates jquery disabled selector: <tt>:disabled</tt>
         *
         * @return
         * @see <a href="http://api.jquery.com/disabled-selector/">http://api.jquery.com/disabled-selector/</a>
         */
        public SBuilder disabled() {
            this.buf.append(":disabled");
            return this;
        }

        /**
         * Creates jquery descendant selector: <tt>ancestor descendant</tt>
         *
         * @param ancestor   Any valid selector.
         * @param descendant A selector to filter the descendant elements.
         * @return
         * @see <a href="http://api.jquery.com/descendant-selector/">http://api.jquery.com/descendant-selector/</a>
         */
        public SBuilder descendant(CharSequence ancestor,
                                   CharSequence descendant) {
            this.buf.append(ancestor).append(" ").append(descendant);
            return this;
        }

        /**
         * Creates jquery descendant selector: <tt>#ancestorComponentId #descendantComponentId</tt>
         *
         * @param ancestorComponent   a ancestor component
         * @param descendantComponent a descendant component
         * @return
         * @see <a href="http://api.jquery.com/descendant-selector/">http://api.jquery.com/descendant-selector/</a>
         */
        public SBuilder descendant(Component ancestorComponent,
                                   Component descendantComponent) {
            return descendant(id(ancestorComponent), id(descendantComponent));
        }

        /**
         * Creates jquery contains selector: <tt>:contains('text')</tt>
         *
         * @param text
         * @return
         * @see <a href="http://api.jquery.com/contains-selector/">http://api.jquery.com/contains-selector/</a>
         */
        public SBuilder contains(CharSequence text) {
            this.buf.append(":contains('").append(text).append("')");
            return this;
        }

        /**
         * Creates jquery class selector: <tt>.clazz</tt>
         *
         * @param clazz
         * @return
         * @see <a href="http://api.jquery.com/class-selector/">http://api.jquery.com/class-selector/</a>
         */
        public SBuilder clazz(CharSequence clazz) {
            this.buf.append(".").append(clazz);
            return this;
        }

        /**
         * Creates jquery child selector: <tt>parent > child</tt>
         *
         * @param parent
         * @param child
         * @return
         * @see <a href="http://api.jquery.com/child-selector/">http://api.jquery.com/child-selector/</a>
         */
        public SBuilder child(CharSequence parent, CharSequence child) {
            this.buf.append(parent).append(" > ").append(child);
            return this;
        }

        /**
         * Creates jquery child selector: <tt>parentComponentId > childComponentId</tt>
         *
         * @param parentComponent    any parent component
         * @param childChilComponent any child component
         * @return
         * @see <a href="http://api.jquery.com/child-selector/">http://api.jquery.com/child-selector/</a>
         */
        public SBuilder child(Component parentComponent,
                              Component childChilComponent) {
            return child(id(parentComponent), id(childChilComponent));
        }

        /**
         * Creates jquery checked selector: <tt>:checked</tt>
         *
         * @return
         * @see <a href="http://api.jquery.com/checked-selector//">http://api.jquery.com/checked-selector/</a>
         */
        public SBuilder checked() {
            this.buf.append(":checked");
            return this;
        }

        /**
         * Creates jquery checkbox selector: <tt>:checkbox</tt>
         *
         * @return
         * @see <a href="http://api.jquery.com/checkbox-selector//">http://api.jquery.com/checkbox-selector/</a>
         */
        public SBuilder checkbox() {
            this.buf.append(":checkbox");
            return this;
        }

        /**
         * Creates jquery button selector: <tt>:button</tt>
         *
         * @return
         * @see <a href="http://api.jquery.com/button-selector//">http://api.jquery.com/button-selector/</a>
         */
        public SBuilder button() {
            this.buf.append(":button");
            return this;
        }

        /**
         * Creates jquery attributeStartsWith selector: <tt>[attribute^='value']</tt>
         *
         * @param attribute
         * @param value
         * @return
         * @see <a href="http://api.jquery.com/attribute-starts-with-selector/">http://api.jquery.com/attribute-starts-with-selector/</a>
         */
        public SBuilder attributeStartsWith(CharSequence attribute,
                                            CharSequence value) {
            this.buf.append("[").append(attribute).append("^='").append(value)
                    .append("']");
            return this;
        }

        /**
         * Creates jquery attributeNotEqual selector: <tt>[attribute!='value']</tt>
         *
         * @param attribute
         * @param value
         * @return
         * @see <a href="http://api.jquery.com/attribute-not-equal-selector/">http://api.jquery.com/attribute-not-equal-selector/</a>
         */
        public SBuilder attributeNotEqual(CharSequence attribute,
                                          CharSequence value) {
            this.buf.append("[").append(attribute).append("!='").append(value)
                    .append("']");
            return this;
        }

        /**
         * Creates jquery attributeEquals selector: <tt>[attribute='value']</tt>
         *
         * @param attribute
         * @param value
         * @return
         * @see <a href="http://api.jquery.com/attribute-equals-selector/">http://api.jquery.com/attribute-equals-selector/</a>
         */
        public SBuilder attributeEquals(CharSequence attribute,
                                        CharSequence value) {
            this.buf.append("[").append(attribute).append("='").append(value)
                    .append("']");
            return this;
        }

        /**
         * Creates jquery attributeEndsWith selector: <tt>[attribute$='value']</tt>
         *
         * @param attribute
         * @param value
         * @return
         * @see <a href="http://api.jquery.com/attribute-ends-with-selector/">http://api.jquery.com/attribute-ends-with-selector/</a>
         */
        public SBuilder attributeEndsWith(CharSequence attribute,
                                          CharSequence value) {
            this.buf.append("[").append(attribute).append("$='").append(value)
                    .append("']");
            return this;
        }

        /**
         * Creates jquery attributeContainsWord selector: <tt>[attribute~='value']</tt>
         *
         * @param attribute
         * @param value
         * @return
         * @see <a href="http://api.jquery.com/attribute-contains-word-selector/">http://api.jquery.com/attribute-contains-word-selector/</a>
         */
        public SBuilder attributeContainsWord(CharSequence attribute,
                                              CharSequence value) {
            this.buf.append("[").append(attribute).append("~='").append(value)
                    .append("']");
            return this;
        }

        /**
         * Creates jquery attributeContains selector: <tt>[attribute*='value']</tt>
         *
         * @param attribute
         * @param value
         * @return
         * @see <a href="http://api.jquery.com/attribute-contains-selector/">http://api.jquery.com/attribute-contains-selector/</a>
         */
        public SBuilder attributeContains(CharSequence attribute,
                                          CharSequence value) {
            this.buf.append("[").append(attribute).append("*='").append(value)
                    .append("']");
            return this;
        }

        /**
         * Creates jquery attributeContainsPrefix selector: <tt>[attribute|='value']</tt>
         *
         * @param attribute
         * @param value
         * @return
         * @see <a href="http://api.jquery.com/attribute-contains-prefix-selector/">http://api.jquery.com/attribute-contains-prefix-selector/</a>
         */
        public SBuilder attributeContainsPrefix(CharSequence attribute,
                                                CharSequence value) {
            this.buf.append("[").append(attribute).append("|='").append(value)
                    .append("']");
            return this;
        }

        /**
         * Creates jquery animated selector: <tt>:animated</tt>
         *
         * @return
         * @see <a href="http://api.jquery.com/animated-selector/">http://api.jquery.com/animated-selector/</a>
         */
        public SBuilder animated() {
            this.buf.append(":animated");
            return this;
        }

        /**
         * Creates jquery any selector: <tt>*</tt>
         *
         * @return
         * @see <a href="http://api.jquery.com/all-selector/">http://api.jquery.com/all-selector/</a>
         */
        public SBuilder any() {
            this.buf.append("*");
            return this;
        }

        /**
         * {@inheritDoc}
         *
         * @see java.lang.CharSequence#length()
         */
        public int length() {
            return buf.length();
        }

        /**
         * {@inheritDoc}
         *
         * @see java.lang.CharSequence#charAt(int)
         */
        public char charAt(int index) {
            return buf.charAt(index);
        }

        /**
         * {@inheritDoc}
         *
         * @see java.lang.CharSequence#subSequence(int, int)
         */
        public CharSequence subSequence(int start, int end) {
            return buf.subSequence(start, end);
        }

        /**
         * {@inheritDoc}
         *
         * @see java.lang.Object#toString()
         */
        @Override
        public String toString() {
            return buf.toString();
        }

        /**
         * Creates an {@link IJQStatement} from the given selector.
         *
         * @return
         */
        public IJQStatement to$() {
            return JQuery.$(this);
        }

    }

}
