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
package com.google.code.jqwicket.ui.watermark;

import com.google.code.jqwicket.IJQWidget;
import com.google.code.jqwicket.api.IJQFunction;
import org.apache.wicket.ajax.AjaxRequestTarget;


/**
 * Implementation of <a href="http://code.google.com/p/jquery-watermark/">jquery
 * watermark plugin</a>
 * 
 * @author mkalina
 * 
 */
public interface IWatermark extends IJQWidget<WatermarkOptions> {

	static final CharSequence JQ_COMPONENT_NAME = "watermark";

	IJQFunction show(CharSequence selector);

	void show(AjaxRequestTarget ajaxRequestTarget, CharSequence selector);

	IJQFunction hide(CharSequence selector);

	void hide(AjaxRequestTarget ajaxRequestTarget, CharSequence selector);

	IJQFunction showAll();

	void showAll(AjaxRequestTarget ajaxRequestTarget);
}
