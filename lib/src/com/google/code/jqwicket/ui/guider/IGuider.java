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
package com.google.code.jqwicket.ui.guider;

import com.google.code.jqwicket.api.IJQFunction;
import org.apache.wicket.ajax.AjaxRequestTarget;

/**
 * Implementation of the <a href="https://github.com/jeff-optimizely/Guiders-JS/">Guiders JQuery plugin</a>
 * @author mkalina
 * 
 */
public interface IGuider {

    static final CharSequence JQ_COMPONENT_NAME = "guiders";

	/**
	 * show a guider with specific id
	 * 
	 * @param id
	 * @return
	 */
	IJQFunction show(CharSequence id);

	/**
	 * show a guider with specific id within the ajax request
	 * 
	 * @param ajaxRequestTarget
	 */
	void show(CharSequence id, AjaxRequestTarget ajaxRequestTarget);

	/**
	 * hides the last shown guider, if shown, and advances to the next guider
	 * 
	 * @return the associated JsStatement
	 */
	IJQFunction next();

	/**
	 * hides the last shown guider, if shown, and advances to the next guider
	 * within the ajax request
	 * 
	 * @param ajaxRequestTarget
	 */
	void next(AjaxRequestTarget ajaxRequestTarget);

	/**
	 * hides all guiders
	 * 
	 * @return the associated JsStatement
	 */
	IJQFunction hideAll();

	/**
	 * hides all guiders within the ajax request
	 * 
	 * @param ajaxRequestTarget
	 */
	void hideAll(AjaxRequestTarget ajaxRequestTarget);
}
