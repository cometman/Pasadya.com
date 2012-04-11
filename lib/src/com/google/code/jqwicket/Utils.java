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
import org.apache.wicket.Application;
import org.apache.wicket.Component;
import org.apache.wicket.RuntimeConfigurationType;
import org.apache.wicket.model.Model;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;

/**
 * Collection of utility methods
 *
 * @author mkalina
 *         <p/>
 *         Parts of the source code are taken from Apache's commons-lang project.
 */
public class Utils {

    Utils() {
    }

    /**
     * Returns true, if wicket runs in development mode. Otherwise returns false.
     *
     * @return true, if wicket runs in development mode. Otherwise returns false.
     */
    public static boolean isDevelopmentMode() {
        return RuntimeConfigurationType.DEVELOPMENT.equals(Application.get()
                .getConfigurationType());
    }

    /**
     * Returns true, if wicket runs in deployment mode. Otherwise returns false.
     *
     * @return true, if wicket runs in deployment mode. Otherwise returns false.
     */
    public static boolean isDeploymentMode() {
        return RuntimeConfigurationType.DEPLOYMENT.equals(Application.get()
                .getConfigurationType());
    }

    /**
     * Returns localized string resource.
     *
     * @param key  is a resource key
     * @param args is an (optional) array of arguments.
     * @return
     */
    public static CharSequence i18n(CharSequence key, CharSequence... args) {
        return i18n(key, null, args);
    }

    /**
     * Returns localized string resource.
     *
     * @param key
     * @param component
     * @param args
     * @return
     */
    public static CharSequence i18n(CharSequence key, Component component,
                                    CharSequence... args) {
        return Application.get().getResourceSettings().getLocalizer()
                .getString(String.valueOf(key), component, Model.of(args));
    }

    /**
     * Returns true if the given array is null or empty. Otherwise returns false.
     *
     * @param array is an array to check.
     * @return true if the given array is null or empty. Otherwise returns false.
     */
    public static boolean isEmpty(Object[] array) {
        if (array == null || array.length == 0) {
            return true;
        }
        return false;
    }

    /**
     * Returns true if the given array is not null and not empty. Otherwise returns false.
     *
     * @param array is an array to check.
     * @return true if the given array is not null and not empty. Otherwise returns false.
     */
    public static boolean isNotEmpty(Object[] array) {
        return (array != null && array.length != 0);
    }

    /**
     * Returns true if the given string is null, empty or contains only whitespaces. Otherwise returns false.
     *
     * @param str is a string to check.
     * @return true if the given string is null, empty or contains only whitespaces. Otherwise returns false.
     */
    public static boolean isBlank(String str) {
        int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if ((Character.isWhitespace(str.charAt(i)) == false)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }

    public static boolean isNotBlank(CharSequence str) {
        return !isBlank(str);
    }

    public static boolean isEmpty(Collection<?> coll) {
        return (coll == null || coll.isEmpty());
    }

    public static boolean isNotEmpty(Collection<?> coll) {
        return !isEmpty(coll);
    }

    public static final boolean isBlank(CharSequence value) {
        return (value == null || isBlank(value.toString()));
    }

    /**
     * Surrounds given value with quotes.
     *
     * @param value
     * @return
     */
    public static final CharSequence quote(CharSequence value) {
        return value != null ? new StringBuffer().append("'").append(value)
                .append("'") : null;
    }

    /**
     * Quotes each element in the given array.
     *
     * @param value
     * @return
     */
    public static final CharSequence[] quote(CharSequence[] value) {
        if (isEmpty(value))
            return null;

        return walk(value, new IArrayWalkCallback<CharSequence>() {
            public CharSequence onElement(int index, CharSequence obj) {
                return quote(obj);
            }
        });
    }

    /**
     * Surrounds given value with double-quotes.
     *
     * @param value
     * @return
     */
    public static final CharSequence dblquote(CharSequence value) {
        return value != null ? new StringBuffer().append("\"").append(value)
                .append("\"") : null;
    }

    /**
     * Double-Quotes each element in the given array.
     *
     * @param value
     * @return
     */
    public static final CharSequence[] dblquote(CharSequence[] value) {
        if (isEmpty(value))
            return null;

        return walk(value, new IArrayWalkCallback<CharSequence>() {
            public CharSequence onElement(int index, CharSequence obj) {
                return dblquote(obj);
            }
        });
    }

    public static final CharSequence semicolon(CharSequence value) {
        if (isBlank(value))
            return "";

        return value.toString().trim().endsWith(";") ? value : value + ";";
    }

    public static final <T> CharSequence join(T[] objects, String separator) {
        return join(objects, separator, new IJoinCallback<T>() {
            public CharSequence toCharSequence(T obj) {
                return String.valueOf(obj);
            }
        });
    }

    public static final CharSequence join(int[] objects, String separator) {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < objects.length; i++) {
            buf.append(objects[i]);
            if (i < (objects.length - 1))
                buf.append(separator);
        }
        return buf;
    }

    public static final CharSequence join(float[] objects, String separator) {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < objects.length; i++) {
            buf.append(objects[i]);
            if (i < (objects.length - 1))
                buf.append(separator);
        }
        return buf;
    }

    public static final CharSequence join(boolean[] objects, String separator) {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < objects.length; i++) {
            buf.append(objects[i]);
            if (i < (objects.length - 1))
                buf.append(separator);
        }
        return buf;
    }

    public static final <T> CharSequence join(T[] objects,
                                              CharSequence separator, IJoinCallback<T> callback) {

        if (isEmpty(objects))
            return "";

        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < objects.length; i++) {
            if (objects[i] != null)
                buf.append(callback.toCharSequence(objects[i]));

            if (i < (objects.length - 1) && objects[i + 1] != null)
                buf.append(separator);

        }
        return buf;

    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public static CharSequence toJson(Map<CharSequence, ? extends Object> map) {
        StringBuffer sb = new StringBuffer();
        sb.append("{");
        if (map != null) {
            int count = 0;
            for (Map.Entry<CharSequence, ? extends Object> option : map
                    .entrySet()) {
                Object value = option.getValue();
                if (value == null)
                    continue;

                CharSequence jsonValue;
                if (value instanceof Map) {
                    jsonValue = "[" + toJson((Map) value) + "]";
                } else if (value instanceof int[]) {
                    jsonValue = toJson((int[]) value);
                } else if (value instanceof float[]) {
                    jsonValue = toJson((float[]) value);
                } else if (value instanceof boolean[]) {
                    jsonValue = toJson((boolean[]) value);
                } else if (value instanceof CharSequence[]) {
                    jsonValue = toJson((CharSequence[]) value);
                } else if (value instanceof Object[]) {
                    jsonValue = toJson((Object[]) value);
                } else
                    jsonValue = String.valueOf(value);

                sb.append(option.getKey()).append(":").append(jsonValue);
                if (count < (map.size() - 1)) {
                    sb.append(", ");
                }
                count++;
            }
        }
        sb.append("}");
        return JQLiteral._raw(sb);
    }

    public static CharSequence toJson(int[] args) {
        return new StringBuilder().append("[").append(join(args, ","))
                .append("]");
    }

    public static CharSequence toJson(float[] args) {
        return new StringBuilder().append("[").append(join(args, ","))
                .append("]");
    }

    public static CharSequence toJson(boolean[] args) {
        return new StringBuilder().append("[").append(join(args, ","))
                .append("]");
    }

    public static CharSequence toJson(CharSequence[] args) {
        return new StringBuilder().append("[").append(join(args, ","))
                .append("]");
    }

    public static CharSequence toJson(CharSequence[][] args) {
        StringBuilder buf = new StringBuilder("[");
        for (int i = 0; i < args.length; i++) {
            if (i != 0)
                buf.append(",");
            buf.append(Utils.toJson(Utils.dblquote(args[i])));

        }
        buf.append("]");
        return buf;
    }

    public static CharSequence toJson(Object[] args) {
        return new StringBuilder().append("[").append(join(args, ","))
                .append("]");
    }

    @SuppressWarnings("unchecked")
    public static <T> T[] walk(T[] array, IArrayWalkCallback<T> callback) {

        if (array == null)
            return null;

        T[] result = (T[]) Array.newInstance(array.getClass()
                .getComponentType(), array.length);
        for (int i = 0; i < array.length; i++) {
            result[i] = callback.onElement(i, array[i]);
        }

        return (T[]) result;
    }

    public static interface IJoinCallback<T> {

        CharSequence toCharSequence(T obj);
    }

    public static interface IArrayWalkCallback<T> {

        T onElement(int index, T obj);
    }

    // Substring between
    // -----------------------------------------------------------------------

    /**
     * <p> Gets the String that is nested in between two instances of the same String. </p> <p/> <p> A <code>null</code>
     * input String returns <code>null</code>. A <code>null</code> tag returns <code>null</code>. </p>
     * <p/>
     * <pre>
     * StringUtils.substringBetween(null, *)            = null
     * StringUtils.substringBetween("", "")             = ""
     * StringUtils.substringBetween("", "tag")          = null
     * StringUtils.substringBetween("tagabctag", null)  = null
     * StringUtils.substringBetween("tagabctag", "")    = ""
     * StringUtils.substringBetween("tagabctag", "tag") = "abc"
     * </pre>
     *
     * @param str the String containing the substring, may be null
     * @param tag the String before and after the substring, may be null
     * @return the substring, <code>null</code> if no match
     * @since 2.0
     */
    public static String substringBetween(String str, String tag) {
        return substringBetween(str, tag, tag);
    }

    /**
     * <p> Gets the String that is nested in between two Strings. Only the first match is returned. </p> <p/> <p> A
     * <code>null</code> input String returns <code>null</code>. A <code>null</code> open/close returns
     * <code>null</code> (no match). An empty ("") open and close returns an empty string. </p>
     * <p/>
     * <pre>
     * StringUtils.substringBetween("wx[b]yz", "[", "]") = "b"
     * StringUtils.substringBetween(null, *, *)          = null
     * StringUtils.substringBetween(*, null, *)          = null
     * StringUtils.substringBetween(*, *, null)          = null
     * StringUtils.substringBetween("", "", "")          = ""
     * StringUtils.substringBetween("", "", "]")         = null
     * StringUtils.substringBetween("", "[", "]")        = null
     * StringUtils.substringBetween("yabcz", "", "")     = ""
     * StringUtils.substringBetween("yabcz", "y", "z")   = "abc"
     * StringUtils.substringBetween("yabczyabcz", "y", "z")   = "abc"
     * </pre>
     *
     * @param str   the String containing the substring, may be null
     * @param open  the String before the substring, may be null
     * @param close the String after the substring, may be null
     * @return the substring, <code>null</code> if no match
     * @since 2.0
     */
    public static String substringBetween(String str, String open, String close) {
        if (str == null || open == null || close == null) {
            return null;
        }
        int start = str.indexOf(open);
        if (start != -1) {
            int end = str.indexOf(close, start + open.length());
            if (end != -1) {
                return str.substring(start + open.length(), end);
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public static <T> T[] join(T[] array1, T[] array2) {

        if (array1 == null) {
            return clone(array2);
        } else if (array2 == null) {
            return clone(array1);
        }

        T[] joinedArray = (T[]) Array.newInstance(array1.getClass()
                .getComponentType(), array1.length + array2.length);
        System.arraycopy(array1, 0, joinedArray, 0, array1.length);
        try {
            System.arraycopy(array2, 0, joinedArray, array1.length,
                    array2.length);
        } catch (ArrayStoreException ase) {
            // Check if problem was due to incompatible types
            /*
                * We do this here, rather than before the copy because: - it would
                * be a wasted check most of the time - safer, in case check turns
                * out to be too strict
                */
            final Class<?> type1 = array1.getClass().getComponentType();
            final Class<?> type2 = array2.getClass().getComponentType();
            if (!type1.isAssignableFrom(type2)) {
                throw new IllegalArgumentException("Cannot store "
                        + type2.getName() + " in an array of "
                        + type1.getName());
            }
            throw ase; // No, so rethrow original
        }
        return joinedArray;

    }

    public static <T> T[] clone(T[] array) {
        if (array == null) {
            return null;
        }
        return (T[]) array.clone();
    }
}
