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

import com.google.code.jqwicket.Utils;
import com.google.code.jqwicket.api.IJQFunction;
import com.google.code.jqwicket.api.JQOptions;
import com.google.code.jqwicket.ui.JQComponentBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;

import static com.google.code.jqwicket.api.JQuery.$;
import static com.google.code.jqwicket.api.JQuery.$f;

/**
 * @author mkalina
 * 
 */
public class ColorPickerBehavior extends
        JQComponentBehavior<ColorPickerOptions> implements IColorPicker {

	private static final long serialVersionUID = 1L;

	public ColorPickerBehavior() {
		this(new ColorPickerOptions());
	}

	public ColorPickerBehavior(ColorPickerOptions options) {
		super(options);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.IJQUIWidget#getName()
	 */
	public CharSequence getName() {
		return JQ_COMPONENT_NAME;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.colorpicker.IColorPicker#show()
	 */
	public IJQFunction show() {
		return $f($(this.component).chain("ColorPickerShow"));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.colorpicker.IColorPicker#show(org.apache.wicket.ajax.AjaxRequestTarget)
	 */
	public void show(AjaxRequestTarget ajaxRequestTarget) {
		chain(ajaxRequestTarget, this.show());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.colorpicker.IColorPicker#hide()
	 */
	public IJQFunction hide() {
		return $f($(this.component).chain("ColorPickerHide"));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.colorpicker.IColorPicker#hide(org.apache.wicket.ajax.AjaxRequestTarget)
	 */
	public void hide(AjaxRequestTarget ajaxRequestTarget) {
		chain(ajaxRequestTarget, this.hide());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.colorpicker.IColorPicker#setColor(java.lang.String)
	 */
	public IJQFunction setColor(CharSequence color) {
		return $f($(this.component).chain("ColorPickerSetColor",
				Utils.quote(color)));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.colorpicker.IColorPicker#setColor(org.apache.wicket.ajax.AjaxRequestTarget,
	 *      java.lang.String)
	 */
	public void setColor(AjaxRequestTarget ajaxRequestTarget, CharSequence color) {
		chain(ajaxRequestTarget, this.setColor(color));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.colorpicker.IColorPicker#setColor(int,
	 *      int, int)
	 */
	public IJQFunction setColor(int r, int g, int b) {
		return $f($(this.component).chain("ColorPickerSetColor",
				new JQOptions().put("r", r).put("g", g).put("b", b)));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.colorpicker.IColorPicker#setColor(org.apache.wicket.ajax.AjaxRequestTarget,
	 *      int, int, int)
	 */
	public void setColor(AjaxRequestTarget ajaxRequestTarget, int r, int g,
			int b) {
		chain(ajaxRequestTarget, this.setColor(r, g, b));
	}

}
