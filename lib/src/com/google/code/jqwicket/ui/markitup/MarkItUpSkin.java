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
package com.google.code.jqwicket.ui.markitup;

import org.apache.wicket.request.resource.CssResourceReference;

import java.io.Serializable;

/**
 * @author mkalina
 */
public class MarkItUpSkin implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final MarkItUpSkin MARKITUP = new MarkItUpSkin(
            new CssResourceReference(MarkItUpSkin.class, "skins/markitup/style.css"));

    public static final MarkItUpSkin SIMPLE = new MarkItUpSkin(
            new CssResourceReference(MarkItUpSkin.class, "skins/simple/style.css"));

    public static final MarkItUpSkin MACOSX = new MarkItUpSkin(
            new CssResourceReference(MarkItUpSkin.class, "skins/macosx/style.css"));

    private CssResourceReference cssResource;

    public MarkItUpSkin(CssResourceReference cssResource) {
        this.cssResource = cssResource;
    }

    /**
     * @return the cssResource
     */
    public CssResourceReference getCssResource() {
        return cssResource;
    }

}
