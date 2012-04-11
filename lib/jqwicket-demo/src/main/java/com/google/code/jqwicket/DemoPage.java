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

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.util.string.Strings;

/**
 * @author mkalina
 * 
 */
public abstract class DemoPage extends WebPage {

	public DemoPage() {
		add(new Label("exampleTitle", getExampleTitle())
				.setRenderBodyOnly(true));
		add(new Label("exampleDescription", getExampleDescription())
				.setRenderBodyOnly(true));
		add(new SourcePanel("sourcePanel", getHtmlSourceUrl(),
				getJavaSourceUrl()));
	}

	protected abstract String getExampleTitle();

	protected String getExampleDescription() {
		return null;
	}

	protected String getHtmlSourceUrl() {
		return "/" + Strings.replaceAll(this.getClass().getName(), ".", "/")
				+ ".html";
	}

	protected String getJavaSourceUrl() {
		return "/" + Strings.replaceAll(this.getClass().getName(), ".", "/")
				+ ".java";
	}

}
