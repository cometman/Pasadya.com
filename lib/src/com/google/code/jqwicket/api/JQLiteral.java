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

import java.io.Serializable;

/**
 * This class represents a single javascript literal. By setting the {@link #mode} property you can surround the wrapped
 * character sequence with quotes, double quotes or let it as it is. Default surrounding mode is {@link
 * Mode#DBLQUOTED}.
 *
 * @author mkalina
 */
public class JQLiteral implements CharSequence, Serializable {

    private static final long serialVersionUID = 1L;

    public static enum Mode {

        QUOTED, DBLQUOTED, RAW;
    }

    private Mode mode = Mode.QUOTED;

    protected CharSequence buf;

    private JQLiteral(CharSequence s, Mode mode) {
        this.buf = s;
        this.mode = mode;
    }

    public int length() {
        return buf.length();
    }

    public char charAt(int index) {
        return buf.charAt(index);
    }

    @Override
    public String toString() {
        return buf.toString();
    }

    public CharSequence subSequence(int start, int end) {
        return buf.subSequence(start, end);
    }

    public Mode getMode() {
        return mode;
    }

    /**
     * Builds new literal instance with default mode {@link Mode#DBLQUOTED}.
     *
     * @param literal
     * @return new JQLiteral instance
     */
    public static final JQLiteral _(Object literal) {
        return _dblquoted(literal);
    }

    /**
     * Builds new literal instance with   mode {@link Mode#QUOTED}.
     *
     * @param literal
     * @return new JQLiteral instance
     */
    public static final JQLiteral _quoted(Object literal) {
        return _(literal, Mode.QUOTED);
    }

    /**
     * Builds new literal instance with default mode {@link Mode#DBLQUOTED}.
     *
     * @param literal
     * @return new JQLiteral instance
     */
    public static final JQLiteral _dblquoted(Object literal) {
        return _(literal, Mode.DBLQUOTED);
    }

    /**
     * Builds new literal instance with   mode {@link Mode#RAW}.
     *
     * @param literal
     * @return new JQLiteral instance
     */
    public static final JQLiteral _raw(Object literal) {
        return _(literal, Mode.RAW);
    }

    public static final JQLiteral _(final Object literal, final Mode mode) {

        if (literal == null)
            return null;

        if (literal instanceof JQLiteral)
            return (JQLiteral) literal;

        if (literal instanceof IJQStatement) {
            return new JQLiteral(((IJQStatement) literal).toString(), Mode.RAW);
        }

        if (literal instanceof IJQFunction) {
            return new JQLiteral(((IJQFunction) literal).toString(), Mode.RAW);
        }

        if (literal instanceof IJQOptions<?>) {
            return new JQLiteral(((IJQOptions<?>) literal).toString(), Mode.RAW);
        }

        CharSequence str = String.valueOf(literal);

        if (mode == Mode.QUOTED)
            return new JQLiteral(Utils.quote(str), mode);

        if (mode == Mode.DBLQUOTED)
            return new JQLiteral(Utils.dblquote(str), mode);

        return new JQLiteral(str, Mode.RAW);
    }

}
