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

import com.google.code.jqwicket.api.IJQStatement;
import org.apache.wicket.request.resource.CssResourceReference;
import org.apache.wicket.request.resource.JavaScriptResourceReference;

import java.io.Serializable;
import java.util.*;

import static com.google.code.jqwicket.Utils.isEmpty;
import static com.google.code.jqwicket.Utils.isNotEmpty;

/**
 * @author mkalina
 */
public class JQHeaderContributionTarget implements Serializable {

    private static final long serialVersionUID = 1L;

    private Set<JavaScriptResourceReference> jsResourceReferences;

    private Set<CharSequence> jsResourceUrls;

    private Set<CssResourceReference> cssResourceReferences;

    private Set<CharSequence> cssResourceUrls;

    private Set<IJQStatement> jqStatementsInsideDocumentReady;

    private Set<IJQStatement> jqStatementsOutsideDocumentReady;

    /**
     * Adds collection of javascript resource references to this contribution target.
     *
     * @param refs is a collection of javascript resource references
     * @return this contribution target
     */
    public JQHeaderContributionTarget addJavascriptResourceReferences(Collection<JavaScriptResourceReference> refs) {
        if (isEmpty(refs))
            return this;

        if (this.jsResourceReferences == null)
            this.jsResourceReferences = new LinkedHashSet<JavaScriptResourceReference>();

        this.jsResourceReferences.addAll(refs);
        return this;
    }

    /**
     * Adds an array of javascript resource references to this contribution target.
     *
     * @param refs is an array  of javascript resource references
     * @return this contribution target
     */
    public JQHeaderContributionTarget addJavascriptResourceReferences(JavaScriptResourceReference... refs) {
        if (isEmpty(refs))
            return this;
        return this.addJavascriptResourceReferences(Arrays.asList(refs));
    }

    /**
     * Adds collection of javascript resource urls to this contribution target.
     *
     * @param urls is a collection of javascript resource urls
     * @return this contribution target
     */
    public JQHeaderContributionTarget addJavascriptResourceUrls(Collection<CharSequence> urls) {
        if (isEmpty(urls))
            return this;

        if (this.jsResourceUrls == null)
            this.jsResourceUrls = new LinkedHashSet<CharSequence>();

        this.jsResourceUrls.addAll(urls);
        return this;
    }

    /**
     * Adds an array of javascript resource urls to this contribution target.
     *
     * @param urls is an array of javascript resource urls
     * @return this contribution target
     */
    public JQHeaderContributionTarget addJavascriptResourceUrls(CharSequence... urls) {
        if (isEmpty(urls))
            return this;
        return this.addJavascriptResourceUrls(Arrays.asList(urls));
    }

    /**
     * Adds collection of css resource references to this contribution target.
     *
     * @param refs is a collection of css resource references
     * @return this contribution target
     */
    public JQHeaderContributionTarget addCssResourceReferences(Collection<CssResourceReference> refs) {
        if (isEmpty(refs))
            return this;

        if (this.cssResourceReferences == null)
            this.cssResourceReferences = new LinkedHashSet<CssResourceReference>();

        this.cssResourceReferences.addAll(refs);
        return this;
    }

    /**
     * Adds an array of css resource references to this contribution target.
     *
     * @param refs is an array of css resource references
     * @return this contribution target
     */
    public JQHeaderContributionTarget addCssResourceReferences(CssResourceReference... refs) {
        if (isEmpty(refs))
            return this;
        return this.addCssResourceReferences(Arrays.asList(refs));
    }

    /**
     * Adds collection of css resource urls to this contribution target.
     *
     * @param urls is a collection of css resource urls
     * @return this contribution target
     */
    public JQHeaderContributionTarget addCssResourceUrls(Collection<CharSequence> urls) {
        if (isEmpty(urls))
            return this;

        if (this.cssResourceUrls == null)
            this.cssResourceUrls = new LinkedHashSet<CharSequence>();

        this.cssResourceUrls.addAll(urls);
        return this;
    }

    /**
     * Adds an array of css resource urls to this contribution target.
     *
     * @param urls is an array of css resource urls
     * @return this contribution target
     */
    public JQHeaderContributionTarget addCssResourceUrls(CharSequence... urls) {
        if (isEmpty(urls))
            return this;
        return this.addCssResourceUrls(Arrays.asList(urls));
    }

    /**
     * Adds statements that will be rendered inside the "document.ready" block
     *
     * @param statements
     * @return this contribution target
     */
    public JQHeaderContributionTarget addJQStatements(Collection<IJQStatement> statements) {
        return addJQStatements(statements, true);
    }

    /**
     * Adds statements that will be rendered inside the "document.ready" block
     *
     * @param statements
     * @return this contribution target
     */
    public JQHeaderContributionTarget addJQStatements(IJQStatement... statements) {
        if (isEmpty(statements))
            return this;
        return this.addJQStatements(Arrays.asList(statements), true);
    }

    /**
     * Adds statements that will be rendered inside or outside the "document.ready" block
     *
     * @param statements
     * @param renderInsideDocumentReady
     * @return this contribution target
     */
    public JQHeaderContributionTarget addJQStatements(IJQStatement[] statements, boolean renderInsideDocumentReady) {
        if (isEmpty(statements))
            return this;
        return this.addJQStatements(Arrays.asList(statements),
                renderInsideDocumentReady);
    }

    /**
     * Adds statements that will be rendered inside or outside the "document.ready" block
     *
     * @param statements                is a collection of {@link IJQStatement}-s
     * @param renderInsideDocumentReady flag indicating whether the statement should be rendered inside or outside the
     *                                  "document.ready" block
     * @return this target
     */
    public JQHeaderContributionTarget addJQStatements(Collection<IJQStatement> statements,
                                                      boolean renderInsideDocumentReady) {

        if (isEmpty(statements))
            return this;

        if (renderInsideDocumentReady) {

            if (this.jqStatementsInsideDocumentReady == null)
                this.jqStatementsInsideDocumentReady = new LinkedHashSet<IJQStatement>();

            this.jqStatementsInsideDocumentReady.addAll(statements);

        } else {

            if (this.jqStatementsOutsideDocumentReady == null)
                this.jqStatementsOutsideDocumentReady = new LinkedHashSet<IJQStatement>();

            this.jqStatementsOutsideDocumentReady.addAll(statements);
        }

        return this;
    }

    /**
     * Returns true, if at least one resource (url, resource reference, statement..) was added to the contribution
     * target and should be rendered. Otherwise returns false.
     *
     * @return true, if there is at least one resource to render. otherwise returns false.
     */
    public boolean hasResourcesToRender() {
        return isNotEmpty(this.jsResourceReferences)
                || isNotEmpty(this.jsResourceUrls)
                || isNotEmpty(this.cssResourceReferences)
                || isNotEmpty(this.cssResourceUrls)
                || isNotEmpty(this.jqStatementsInsideDocumentReady)
                || isNotEmpty(this.jqStatementsOutsideDocumentReady);
    }

    /**
     * Returns unmodifiable collection of available javascript resource references. <br> This method will never return
     * null.
     *
     * @return unmodifiable collection of available javascript resource references
     */
    public Collection<JavaScriptResourceReference> getJsResourceReferences() {
        return this.jsResourceReferences != null ? Collections
                .unmodifiableSet(this.jsResourceReferences) : Collections
                .<JavaScriptResourceReference>emptySet();
    }

    /**
     * Returns unmodifiable collection of available javascript resource urls. <br> This method will never return null.
     *
     * @return unmodifiable collection of available javascript resource urls
     */
    public Collection<CharSequence> getJsResourceUrls() {
        return this.jsResourceUrls != null ? Collections
                .unmodifiableSet(this.jsResourceUrls) : Collections
                .<CharSequence>emptySet();
    }

    /**
     * Returns unmodifiable collection of available css resource references. <br> This method will never return null.
     *
     * @return unmodifiable collection of available css resource references
     */
    public Collection<CssResourceReference> getCssResourceReferences() {
        return this.cssResourceReferences != null ? Collections
                .unmodifiableSet(this.cssResourceReferences) : Collections
                .<CssResourceReference>emptySet();
    }

    /**
     * Returns unmodifiable collection of available css resource urls. <br> This method will never return null.
     *
     * @return unmodifiable collection of available css resource urls
     */
    public Collection<CharSequence> getCssResourceUrls() {
        return this.cssResourceUrls != null ? Collections
                .unmodifiableSet(this.cssResourceUrls) : Collections
                .<CharSequence>emptySet();
    }

    /**
     * Returns unmodifiable collection of available {@link IJQStatement}-s that will be rendered inside the "document
     * .ready" block. <br> This method will never return null.
     *
     * @return unmodifiable collection of available {@link IJQStatement}-s   that will be rendered inside the "document
     *         .ready" block.
     */
    public Collection<IJQStatement> getJQStatementsInsideDocumentReady() {
        return this.jqStatementsInsideDocumentReady != null ? Collections
                .unmodifiableSet(this.jqStatementsInsideDocumentReady)
                : Collections.<IJQStatement>emptySet();
    }

    /**
     * Returns unmodifiable collection of available {@link IJQStatement}-s that will be rendered outside  the
     * "document.ready" block. <br> This method will never return null.
     *
     * @return nmodifiable collection of available {@link IJQStatement}-s that will be rendered outside "document.ready"
     *         block
     */
    public Collection<IJQStatement> getJQStatementsOutsideDocumentReady() {
        return this.jqStatementsOutsideDocumentReady != null ? Collections
                .unmodifiableSet(this.jqStatementsOutsideDocumentReady)
                : Collections.<IJQStatement>emptySet();
    }

}
