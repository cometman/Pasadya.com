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
package com.google.code.jqwicket.ui.colorpicker;


import com.google.code.jqwicket.IJQWidget;
import com.google.code.jqwicket.api.IJQFunction;
import org.apache.wicket.ajax.AjaxRequestTarget;

/**
 * Implementation of the <a href="http://www.eyecon.ro/colorpicker/">Color
 * Picker jquery plugin</a>
 * 
 * @author mkalina
 * 
 */
public interface IColorPicker extends IJQWidget<ColorPickerOptions> {

	static final CharSequence JQ_COMPONENT_NAME = "ColorPicker";

	/**
	 * Method to show the color picker.
	 * 
	 * @return the associated JsStatement
	 */
	IJQFunction show();

	/**
	 * Method to show the color picker within the ajax request
	 * 
	 * @param ajaxRequestTarget
	 */
	void show(AjaxRequestTarget ajaxRequestTarget);

	/**
	 * Method to hide the color picker.
	 * 
	 * @return the associated JsStatement
	 */
	IJQFunction hide();

	/**
	 * Method to hide the color picker within the ajax request
	 * 
	 * @param ajaxRequestTarget
	 */
	void hide(AjaxRequestTarget ajaxRequestTarget);

	/**
	 * Method to set the color .
	 * 
	 * @return the associated JsStatement
	 */
	IJQFunction setColor(CharSequence color);

	/**
	 * Method to set the color within the ajax request
	 * 
	 * @param ajaxRequestTarget
	 */
	void setColor(AjaxRequestTarget ajaxRequestTarget, CharSequence color);

	/**
	 * Method to set the color .
	 * 
	 * @return the associated JsStatement
	 */
	IJQFunction setColor(int r, int g, int b);

	/**
	 * Method to set the color within the ajax request
	 * 
	 * @param ajaxRequestTarget
	 */
	void setColor(AjaxRequestTarget ajaxRequestTarget, int r, int g, int b);
}
