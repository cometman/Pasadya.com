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

import java.io.Serializable;

/**
 * Interface representing anonymous javascript function.
 *
 * @author mkalina
 */
public interface IJQFunction extends Serializable, CharSequence {

    /**
     * Defines the name of the javascript function to render.
     *
     * @param name
     * @return
     */
    IJQFunction withName(CharSequence name);

    /**
     * Defines the parameters of the javascript function to render.
     *
     * @param args
     * @return
     */
    IJQFunction withParams(CharSequence... args);

    /**
     * Returns the name of the function.
     *
     * @return
     */
    CharSequence getName();

    /**
     * Returns the arrray of parameters.
     *
     * @return
     */
    CharSequence[] getParams();

    /**
     * @param renderFunctionBodyOnly
     * @return
     */
    String toString(boolean renderFunctionBodyOnly);

    /**
     * Returns function body only as {@link IJQStatement}.
     *
     * @return function body only
     */
    IJQStatement toStatement();
}
