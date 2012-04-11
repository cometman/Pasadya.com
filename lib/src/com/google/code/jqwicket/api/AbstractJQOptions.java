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

import com.google.code.jqwicket.Utils;
import org.apache.wicket.request.resource.CssResourceReference;
import org.apache.wicket.request.resource.JavaScriptResourceReference;

import java.util.LinkedHashMap;
import java.util.Map;

import static com.google.code.jqwicket.Utils.isBlank;

/**
 * Base abstract {@link IJQOptions} implementation. See {@link IJQOptions} for further details.
 *
 * @param <T> type of options itself.
 * @author mkalina
 */
@SuppressWarnings("unchecked")
public abstract class AbstractJQOptions<T extends AbstractJQOptions<T>>
        implements IJQOptions<T> {

    private static final long serialVersionUID = 1L;

    protected Map<CharSequence, Object> options = new LinkedHashMap<CharSequence, Object>();

    private CssResourceReference[] cssResourceReferences;

    private JavaScriptResourceReference[] jsResourceReferencesMin;

    private JavaScriptResourceReference[] jsResourceReferences;

    private CharSequence[] cssResourceUrls;

    private CharSequence[] jsResourceUrlsMin;

    private CharSequence[] jsResourceUrls;

    public AbstractJQOptions() {
    }

    /**
     * Creates new options instance from the pure json options definition.<br> Example usage:<br>
     * <p/>
     * <pre>
     * IJQOptions&lt;?&gt; options = JQOptions.valueOf(&quot;a:1, b:23, c:'2233'&quot;);
     * </pre>
     *
     * @param options is a pure json options definition.
     * @return new options instance
     */
    public static final IJQOptions<?> valueOf(final CharSequence options) {
        return valueOf(options, JQOptions.class);
    }

    /**
     * Creates new type-safe options instance from the pure json options definition.<br> Example usage:<br>
     * <p/>
     * <pre>
     * MyOptions o = MyOptions.valueOf(&quot;a:1, b:23, c:'2233'&quot;, MyOptions.class);
     * </pre>
     *
     * @param <T>        is a resulting options type
     * @param options    is a pure json options definition.
     * @param targetType is a class of the resulting options type
     * @return new options instance
     */
    public static final <T extends IJQOptions<?>> T valueOf(
            final CharSequence options, Class<T> targetType) {
        try {
            T opts = targetType.newInstance();
            if (Utils.isBlank(options))
                return opts;

            String[] splitted = String.valueOf(options).split(",");
            for (String s : splitted) {
                opts.put(s.substring(0, s.indexOf(':')).trim(),
                        JQLiteral._raw(s.substring(s.indexOf(':') + 1).trim()));
            }

            return opts;

        } catch (Exception e) {
            throw new RuntimeException("Error creating new options instance!",
                    e);
        }

    }

    /**
     * {@inheritDoc}
     */
    public T setCssResourceReferences(CssResourceReference... refs) {
        this.cssResourceReferences = refs;
        return (T) this;
    }

    /**
     * {@inheritDoc}
     */
    public T addCssResourceReferences(CssResourceReference... refs) {
        this.cssResourceReferences = Utils.join(this.cssResourceReferences, refs);
        return (T) this;
    }

    /**
     * {@inheritDoc}
     */
    public CssResourceReference[] getCssResourceReferences() {
        return this.cssResourceReferences;
    }

    /**
     * {@inheritDoc}
     */
    public JavaScriptResourceReference[] getJsResourceReferences() {
        return this.jsResourceReferences;
    }

    /**
     * {@inheritDoc}
     */
    public T setJsResourceReferences(JavaScriptResourceReference... refs) {
        this.jsResourceReferences = refs;
        return (T) this;
    }

    /**
     * {@inheritDoc}
     */
    public T addJsResourceReferences(JavaScriptResourceReference... refs) {
        this.jsResourceReferences = Utils.join(this.jsResourceReferences, refs);
        return (T) this;
    }

    /**
     * {@inheritDoc}
     */
    public JavaScriptResourceReference[] getJsResourceReferencesMin() {
        return this.jsResourceReferencesMin;
    }

    /**
     * {@inheritDoc}
     */
    public T setJsResourceReferencesMin(JavaScriptResourceReference... refs) {
        this.jsResourceReferencesMin = refs;
        return (T) this;
    }

    /**
     * {@inheritDoc}
     */
    public T addJsResourceReferencesMin(JavaScriptResourceReference... refs) {
        this.jsResourceReferencesMin = Utils.join(this.jsResourceReferencesMin,
                refs);
        return (T) this;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.google.code.jqwicket.api.IJQOptions#setCssResourceUrls(java.lang.CharSequence[])
     */
    public T setCssResourceUrls(CharSequence... urls) {
        this.cssResourceUrls = urls;
        return (T) this;
    }

    /**
     * {@inheritDoc}
     */
    public T addCssResourceUrls(CharSequence... urls) {
        this.cssResourceUrls = Utils.join(this.cssResourceUrls, urls);
        return (T) this;
    }

    /**
     * {@inheritDoc}
     */
    public CharSequence[] getCssResourceUrls() {
        return this.cssResourceUrls;
    }

    /**
     * {@inheritDoc}
     */
    public T setJsResourceUrlsMin(CharSequence... urls) {
        this.jsResourceUrlsMin = urls;
        return (T) this;
    }

    /**
     * {@inheritDoc}
     */
    public T addJsResourceUrlsMin(CharSequence... urls) {
        this.jsResourceUrlsMin = Utils.join(this.jsResourceUrlsMin, urls);
        return (T) this;
    }

    /**
     * {@inheritDoc}
     */
    public CharSequence[] getJsResourceUrlsMin() {
        return this.jsResourceUrlsMin;
    }

    /**
     * {@inheritDoc}
     */
    public T setJsResourceUrls(CharSequence... urls) {
        this.jsResourceUrls = urls;
        return (T) this;
    }

    /**
     * {@inheritDoc}
     */
    public T addJsResourceUrls(CharSequence... urls) {
        this.jsResourceUrls = Utils.join(this.jsResourceUrls, urls);
        return (T) this;
    }

    /**
     * {@inheritDoc}
     */
    public CharSequence[] getJsResourceUrls() {
        return this.jsResourceUrls;
    }

    /**
     * {@inheritDoc}
     */
    public boolean isEmpty() {
        return this.options.isEmpty();
    }

    /**
     * {@inheritDoc}
     */
    public CharSequence get(CharSequence key) {
        return this.get(key, null);
    }

    /**
     * {@inheritDoc}
     */
    public CharSequence get(CharSequence key, CharSequence defaultValue) {
        Object object = options.get(key);
        return object != null ? object.toString() : defaultValue;
    }

    /**
     * {@inheritDoc}
     */
    public String getString(CharSequence key) {
        return String.valueOf(this.get(key));
    }

    /**
     * {@inheritDoc}
     */
    public String getString(CharSequence key, String defaultValue) {
        return String.valueOf(this.get(key, defaultValue));
    }

    /**
     * {@inheritDoc}
     */
    public Object getObject(CharSequence key) {
        return options.get(key);
    }

    /**
     * {@inheritDoc}
     */
    public IJQStatement getJQStatement(CharSequence key) {
        return (IJQStatement) options.get(key);
    }

    /**
     * {@inheritDoc}
     */
    public int getInt(CharSequence key) {
        return this.getInt(key, (Integer) null);
    }

    /**
     * {@inheritDoc}
     */
    public int getInt(CharSequence key, int defaultValue) {
        Object object = this.options.get(key);
        if (object == null)
            return defaultValue;

        return ((Integer) object).intValue();
    }

    /**
     * {@inheritDoc}
     */
    public AbstractJQOptions<?> getOptions(CharSequence key) {
        Object object = this.options.get(key);
        return (AbstractJQOptions<?>) object;
    }

    /**
     * {@inheritDoc}
     */
    public short getShort(CharSequence key) {
        return this.getShort(key, (Short) null);
    }

    /**
     * {@inheritDoc}
     */
    public short getShort(CharSequence key, short defaultValue) {
        Object object = this.options.get(key);
        if (object == null)
            return defaultValue;

        return ((Short) object).shortValue();
    }

    /**
     * {@inheritDoc}
     */
    public double getDouble(CharSequence key) {
        return this.getDouble(key, (Double) null);
    }

    /**
     * {@inheritDoc}
     */
    public double getDouble(CharSequence key, double defaultValue) {
        Object object = this.options.get(key);
        if (object == null)
            return defaultValue;
        return ((Double) object).doubleValue();
    }

    /**
     * {@inheritDoc}
     */
    public float getFloat(CharSequence key) {
        return this.getFloat(key, (Float) null);
    }

    /**
     * {@inheritDoc}
     */
    public float getFloat(CharSequence key, float defaultValue) {
        Object object = this.options.get(key);
        if (object == null)
            return defaultValue;
        return ((Float) object).floatValue();
    }

    /**
     * {@inheritDoc}
     */
    public boolean getBoolean(CharSequence key) {
        return ((Boolean) this.options.get(key)).booleanValue();
    }

    /**
     * {@inheritDoc}
     */
    public boolean getBoolean(CharSequence key, boolean defaultValue) {
        if (!this.options.containsKey(key))
            return defaultValue;

        return ((Boolean) this.options.get(key)).booleanValue();
    }

    /**
     * {@inheritDoc}
     */
    public T put(CharSequence name, IJQStatement value) {
        options.put(name, value);
        return (T) this;
    }

    /**
     * {@inheritDoc}
     */
    public T put(CharSequence name, IJQFunction value) {
        options.put(name, value);
        return (T) this;
    }

    /**
     * {@inheritDoc}
     */
    public T put(CharSequence key, CharSequence value) {
        if (isBlank(value))
            return (T) this;

        if (value instanceof JQLiteral)
            options.put(key, value);
        else
            options.put(key, JQLiteral._(value));

        return (T) this;
    }

    /**
     * {@inheritDoc}
     */
    public T put(CharSequence key, int value) {
        options.put(key, value);
        return (T) this;
    }

    /**
     * {@inheritDoc}
     */
    public T put(CharSequence key, int... values) {
        options.put(key, values);
        return (T) this;
    }

    /**
     * {@inheritDoc}
     */
    public T put(CharSequence key, double value) {
        options.put(key, value);
        return (T) this;
    }

    /**
     * {@inheritDoc}
     */
    public T put(CharSequence key, double... values) {
        options.put(key, values);
        return (T) this;
    }

    /**
     * {@inheritDoc}
     */
    public T put(CharSequence key, float value) {
        options.put(key, value);
        return (T) this;
    }

    /**
     * {@inheritDoc}
     */
    public T put(CharSequence key, float... values) {
        options.put(key, values);
        return (T) this;
    }

    /**
     * {@inheritDoc}
     */
    public T put(CharSequence key, boolean value) {
        options.put(key, value);
        return (T) this;
    }

    /**
     * {@inheritDoc}
     */
    public T put(CharSequence key, boolean... values) {
        options.put(key, values);
        return (T) this;
    }

    /**
     * {@inheritDoc}
     */
    public T put(CharSequence key, CharSequence... values) {
        if (Utils.isEmpty(values))
            return (T) this;

        options.put(key, values);
        return (T) this;
    }

    /**
     * {@inheritDoc}
     */
    public T put(CharSequence key, CharSequence[][] values) {
        if (values == null)
            return (T) this;

        options.put(key, Utils.toJson(values));
        return (T) this;
    }

    public T put(CharSequence key, Enum<?> e) {
        if (e != null) {
            this.options.put(key, JQLiteral._(e.name()));
        }
        return (T) this;
    }

    /**
     * {@inheritDoc}
     */
    public void removeOption(CharSequence key) {
        this.options.remove(key);
    }

    /**
     * {@inheritDoc}
     */
    public boolean containsKey(CharSequence key) {
        return options.containsKey(key);
    }

    private CharSequence toJson() {
        return Utils.toJson(this.options);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return String.valueOf(toJson());
    }

    public char charAt(int index) {
        return toJson().charAt(index);
    }

    public int length() {
        return toJson().length();
    }

    public CharSequence subSequence(int start, int end) {
        return toJson().subSequence(start, end);
    }

}
