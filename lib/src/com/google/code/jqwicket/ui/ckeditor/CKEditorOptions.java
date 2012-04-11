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
package com.google.code.jqwicket.ui.ckeditor;

import com.google.code.jqwicket.api.AbstractJQOptions;
import com.google.code.jqwicket.api.IJQFunction;
import com.google.code.jqwicket.api.JQLiteral;
import org.apache.wicket.request.resource.JavaScriptResourceReference;

/**
 * @author mkalina
 * 
 */
public class CKEditorOptions extends AbstractJQOptions<CKEditorOptions> {

	private static final long serialVersionUID = 1L;

	private static final JavaScriptResourceReference jsCKEditorResource = new JavaScriptResourceReference(
			CKEditorOptions.class, "ckeditor-3.5.js");

	private static final JavaScriptResourceReference jsCKEditorAdapterResource = new JavaScriptResourceReference(
			CKEditorOptions.class, "ckeditor-jqueryadapter-3.5.js");

	public enum EnterMode {
		ENTER_P("CKEDITOR.ENTER_P"), ENTER_BR("CKEDITOR.ENTER_BR"), ENTER_DIV(
				"CKEDITOR.ENTER_DIV");

		private CharSequence value;

		private EnterMode(CharSequence value) {
			this.value = value;
		}

		public CharSequence getValue() {
			return value;
		}
	}

	public CKEditorOptions() {
		this.setJsResourceReferences(jsCKEditorResource,
				jsCKEditorAdapterResource);
	}

	/**
	 * The maximum height to which the editor can reach using AutoGrow. Zero
	 * means unlimited. Defined in: plugins/autogrow/plugin.js. <br/>
	 * Default Value: 0
	 * 
	 * @param autoGrow_maxHeight
	 * @return options
	 */
	public CKEditorOptions autoGrow_maxHeight(int autoGrow_maxHeight) {
		return super.put("autoGrow_maxHeight", autoGrow_maxHeight);
	}

	/**
	 * The minimum height to which the editor can reach using AutoGrow. Defined
	 * in: plugins/autogrow/plugin.js.<br/>
	 * Default Value: 200
	 * 
	 * @param autoGrow_minHeight
	 * @return options
	 */
	public CKEditorOptions autoGrow_minHeight(int autoGrow_minHeight) {
		return super.put("autoGrow_minHeight", autoGrow_minHeight);
	}

	/**
	 * Whether the replaced element (usually a textarea) is to be updated
	 * automatically when posting the form containing the editor.<br/>
	 * Default Value: true
	 * 
	 * @param autoUpdateElement
	 * @return options
	 */
	public CKEditorOptions autoUpdateElement(boolean autoUpdateElement) {
		return super.put("autoUpdateElement", autoUpdateElement);
	}

	/**
	 * The base Z-index for floating dialogs and popups.<br/>
	 * Default Value: 10000
	 * 
	 * @param baseFloatZIndex
	 * @return options
	 */
	public CKEditorOptions baseFloatZIndex(int baseFloatZIndex) {
		return super.put("baseFloatZIndex", baseFloatZIndex);
	}

	/**
	 * The base href URL used to resolve relative and absolute URLs in the
	 * editor content.<br/>
	 * Default Value: '' (empty)
	 * 
	 * @param baseHref
	 * @return options
	 */
	public CKEditorOptions baseHref(CharSequence baseHref) {
		return super.put("baseHref", baseHref);
	}

	/**
	 * A list of keystrokes to be blocked if not defined in the
	 * CKEDITOR.config.keystrokes setting. In this way it is possible to block
	 * the default browser behavior for those keystrokes. Defined in:
	 * plugins/keystrokes/plugin.js.<br/>
	 * Default Value:<br>
	 * 
	 * <pre>
	 * // This is actually the default value.
	 * config.blockedKeystrokes =
	 * [
	 *     CKEDITOR.CTRL + 66 / * B * /,
	 *     CKEDITOR.CTRL + 73 / * I * /,
	 *     CKEDITOR.CTRL + 85 / * U * /
	 * ];
	 * </pre>
	 * 
	 * @param blockedKeystrokes
	 * @return options
	 */
	public CKEditorOptions blockedKeystrokes(CharSequence... blockedKeystrokes) {
		return super.put("blockedKeystrokes", blockedKeystrokes);
	}

	/**
	 * Sets the "class" attribute to be used on the body element of the editing
	 * area. This can be useful when reusing the original CSS file you're using
	 * on your live website and you want to assing to the editor the same class
	 * name you're using for the region that'll hold the contents. In this way,
	 * class specific CSS rules will be enabled.<br/>
	 * Default Value: '' (empty)
	 * 
	 * @param bodyClass
	 * @return options
	 */
	public CKEditorOptions bodyClass(CharSequence bodyClass) {
		return super.put("bodyClass", bodyClass);
	}

	/**
	 * Sets the "id" attribute to be used on the body element of the editing
	 * area. This can be useful when reusing the original CSS file you're using
	 * on your live website and you want to assing to the editor the same id
	 * you're using for the region that'll hold the contents. In this way, id
	 * specific CSS rules will be enabled.<br/>
	 * 
	 * Default Value: '' (empty)
	 * 
	 * @param bodyId
	 * @return options
	 */
	public CKEditorOptions bodyId(CharSequence bodyId) {
		return super.put("bodyId", bodyId);
	}

	/**
	 * Whether to show the browser native context menu when the CTRL or the META
	 * (Mac) key is pressed while opening the context menu. Defined in:
	 * plugins/contextmenu/plugin.js.<br/>
	 * 
	 * Default Value: true
	 * 
	 * @param browserContextMenuOnCtrl
	 * @return options
	 */
	public CKEditorOptions browserContextMenuOnCtrl(
			boolean browserContextMenuOnCtrl) {
		return super.put("browserContextMenuOnCtrl", browserContextMenuOnCtrl);
	}

	/**
	 * Holds the style definition to be used to apply the text background color.
	 * Defined in: plugins/colorbutton/plugin.js.<br/>
	 * 
	 * Default:<br/>
	 * 
	 * <pre>
	 * // This is basically the default setting value.
	 * config.colorButton_backStyle =
	 *     {
	 *         element : 'span',
	 *         styles : { 'background-color' : '#(color)' }
	 *     };
	 * </pre>
	 * 
	 * @param colorButton_backStyle
	 * @return options
	 */
	public CKEditorOptions colorButton_backStyle(
			CharSequence colorButton_backStyle) {
		return super.put("colorButton_backStyle", colorButton_backStyle);
	}

	/**
	 * Defines the colors to be displayed in the color selectors. It's a string
	 * containing the hexadecimal notation for HTML colors, without the "#"
	 * prefix. Since 3.3: A name may be optionally defined by prefixing the
	 * entries with the name and the slash character. For example,
	 * "FontColor1/FF9900" will be displayed as the color #FF9900 in the
	 * selector, but will be outputted as "FontColor1". Defined in:
	 * plugins/colorbutton/plugin.js.<br/>
	 * 
	 * Default Value:
	 * '000,800000,8B4513,2F4F4F,008080,000080,4B0082,696969,B22222,A52A2A,DAA52
	 * 0 , 0 0 6 4 0 0 , 4 0 E 0 D 0 , 0 0 0 0 C D , 8 0 0 0 8 0 , 8 0 8 0 8 0 ,
	 * F 0 0 , F F 8 C 0 0 , F F D 7 0 0 , 0 0 8 0 0 0 , 0 F F , 0 0 F , E E 8 2
	 * E E , A 9 A 9 A 9 , F F A 0 7 A , F F A 5 0 0 , F F F F 0 0 , 0 0 F F 0 0
	 * , A F E E E E , A D D 8 E 6 , D D A 0 D D , D 3 D 3 D 3 , F F F 0 F 5 , F
	 * A E B D 7 , F F F F E 0 , F 0 F F F 0 , F 0 F F F F , F 0 F 8 F F , E 6 E
	 * 6 F A , F F F '
	 * 
	 * 
	 * @param colorButton_colors
	 * @return options
	 */
	public CKEditorOptions colorButton_colors(CharSequence colorButton_colors) {
		return super.put("colorButton_colors", colorButton_colors);
	}

	/**
	 * Holds the style definition to be used to apply the text foreground color.
	 * Defined in: plugins/colorbutton/plugin.js.<br/>
	 * 
	 * Default:<br/>
	 * 
	 * <pre>
	 * // This is basically the default setting value.
	 * config.colorButton_foreStyle =
	 *     {
	 *         element : 'span',
	 *         styles : { 'color' : '#(color)' }
	 *     };
	 * </pre>
	 * 
	 * @param colorButton_foreStyle
	 * @return options
	 */
	public CKEditorOptions colorButton_foreStyle(
			CharSequence colorButton_foreStyle) {
		return super.put("colorButton_foreStyle", colorButton_foreStyle);
	}

	/**
	 * The CSS file(s) to be used to apply style to the contents. It should
	 * reflect the CSS used in the final pages where the contents are to be
	 * used. <br/>
	 * Default Value: '<CKEditor folder>/contents.css'
	 * 
	 * @param contentsCss
	 * @return options
	 */
	public CKEditorOptions contentsCss(CharSequence... contentsCss) {
		return super.put("contentsCss", contentsCss);
	}

	/**
	 * The writting direction of the language used to write the editor contents.
	 * Allowed values are:<br/>
	 * <ul>
	 * <li>'ui' - which indicate content direction will be the same with the
	 * user interface language direction;</li>
	 * <li>'ltr' - for Left-To-Right language (like English);</li>
	 * <li>'rtl' - for Right-To-Left languages (like Arabic).</li>
	 * </ul>
	 * <br/>
	 * Default Value: 'ui'
	 * 
	 * @param contentsLangDirection
	 * @return options
	 */
	public CKEditorOptions contentsLangDirection(
			CharSequence contentsLangDirection) {
		return super.put("contentsLangDirection", contentsLangDirection);
	}

	/**
	 * Language code of the writting language which is used to author the editor
	 * contents.<br/>
	 * Default Value: Same value with editor's UI language.
	 * 
	 * @param contentsLanguage
	 * @return options
	 */
	public CKEditorOptions contentsLanguage(CharSequence contentsLanguage) {
		return super.put("contentsLanguage", contentsLanguage);
	}

	/**
	 * A comma separated list of plugins that are not related to editor
	 * instances. Reserved to plugins that extend the core code only.
	 * 
	 * There are no ways to override this setting, except by editing the source
	 * code of CKEditor (_source/core/config.js).
	 * 
	 * @param corePlugins
	 * @return options
	 */
	public CKEditorOptions corePlugins(CharSequence corePlugins) {
		return super.put("corePlugins", corePlugins);
	}

	/**
	 * The style definition to be used to apply the bold style in the text.
	 * Defined in: plugins/basicstyles/plugin.js.<br/>
	 * Example:<br/>
	 * 
	 * <pre>
	 * config.coreStyles_bold = { element : 'span', attributes : {'class': 'Bold'} };
	 * </pre>
	 * 
	 * @param coreStyles_bold
	 * @return options
	 */
	public CKEditorOptions coreStyles_bold(CharSequence coreStyles_bold) {
		return super.put("coreStyles_bold", coreStyles_bold);
	}

	/**
	 * The style definition to be used to apply the italic style in the text.
	 * Defined in: plugins/basicstyles/plugin.js.<br/>
	 * Example:<br/>
	 * 
	 * <pre>
	 * config.coreStyles_italic = { element : 'span', attributes : {'class': 'Italic'} };
	 * </pre>
	 * 
	 * @param coreStyles_italic
	 * @return options
	 */
	public CKEditorOptions coreStyles_italic(CharSequence coreStyles_italic) {
		return super.put("coreStyles_italic", coreStyles_italic);
	}

	/**
	 * The style definition to be used to apply the strike style in the text.
	 * Defined in: plugins/basicstyles/plugin.js.<br/>
	 * Example:<br/>
	 * 
	 * <pre>
	 * config.coreStyles_strike = { element : 'span', attributes : {'class': 'StrikeThrough'}, overrides : 'strike' };
	 * </pre>
	 * 
	 * @param coreStyles_strike
	 * @return options
	 */
	public CKEditorOptions coreStyles_strike(CharSequence coreStyles_strike) {
		return super.put("coreStyles_strike", coreStyles_strike);
	}

	/**
	 * The style definition to be used to apply the subscript style in the text.
	 * Defined in: plugins/basicstyles/plugin.js.<br/>
	 * Example:<br/>
	 * 
	 * <pre>
	 * config.coreStyles_subscript = { element : 'span', attributes : {'class': 'Subscript'}, overrides : 'sub' };
	 * </pre>
	 * 
	 * @param coreStyles_subscript
	 * @return options
	 */
	public CKEditorOptions coreStyles_subscript(
			CharSequence coreStyles_subscript) {
		return super.put("coreStyles_subscript", coreStyles_subscript);
	}

	/**
	 * The style definition to be used to apply the superscript style in the
	 * text. Defined in: plugins/basicstyles/plugin.js.<br/>
	 * Example:<br/>
	 * 
	 * <pre>
	 * config.coreStyles_superscript = { element : 'span', attributes : {'class': 'Superscript'}, overrides : 'sup' };
	 * </pre>
	 * 
	 * @param coreStyles_superscript
	 * @return options
	 */
	public CKEditorOptions coreStyles_superscript(
			CharSequence coreStyles_superscript) {
		return super.put("coreStyles_superscript", coreStyles_superscript);
	}

	/**
	 * The style definition to be used to apply the underline style in the text.
	 * Defined in: plugins/basicstyles/plugin.js. <br/>
	 * Example:<br/>
	 * 
	 * <pre>
	 * config.coreStyles_underline = { element : 'span', attributes : {'class': 'Underline'}};
	 * </pre>
	 * 
	 * @param coreStyles_underline
	 * @return options
	 */
	public CKEditorOptions coreStyles_underline(
			CharSequence coreStyles_underline) {
		return super.put("coreStyles_underline", coreStyles_underline);
	}

	/**
	 * The URL path for the custom configuration file to be loaded. If not
	 * overloaded with inline configurations, it defaults to the "config.js"
	 * file present in the root of the CKEditor installation directory.
	 * 
	 * CKEditor will recursively load custom configuration files defined inside
	 * other custom configuration files.
	 * 
	 * <br/>
	 * Default Value: '<CKEditor folder>/config.js'
	 * 
	 * @param customConfig
	 * @return options
	 */
	public CKEditorOptions customConfig(CharSequence customConfig) {
		return super.put("customConfig", customConfig);
	}

	/**
	 * The language to be used if CKEDITOR.config.language is left empty and
	 * it's not possible to localize the editor to the user language.<br/>
	 * 
	 * Default Value: 'en'
	 * 
	 * @param defaultLanguage
	 * @return options
	 */
	public CKEditorOptions defaultLanguage(CharSequence defaultLanguage) {
		return super.put("defaultLanguage", defaultLanguage);
	}

	/**
	 * The color of the dialog background cover. It should be a valid CSS color
	 * string. Defined in: plugins/dialog/plugin.js.<br/>
	 * Default Value: 'white'
	 * 
	 * @param dialog_backgroundCoverColor
	 * @return options
	 */
	public CKEditorOptions dialog_backgroundCoverColor(
			CharSequence dialog_backgroundCoverColor) {
		return super.put("dialog_backgroundCoverColor",
				dialog_backgroundCoverColor);
	}

	/**
	 * The opacity of the dialog background cover. It should be a number within
	 * the range [0.0, 1.0]. Defined in: plugins/dialog/plugin.js.<br/>
	 * 
	 * Default Value: 0.5
	 * 
	 * @param dialog_backgroundCoverOpacity
	 * @return options
	 */
	public CKEditorOptions dialog_backgroundCoverOpacity(
			float dialog_backgroundCoverOpacity) {
		return super.put("dialog_backgroundCoverOpacity",
				dialog_backgroundCoverOpacity);
	}

	/**
	 * The guideline to follow when generating the dialog buttons. There are 3
	 * possible options:<br/>
	 * <ul>
	 * <li>'OS' - the buttons will be displayed in the default order of the
	 * user's OS;</li>
	 * <li>'ltr' - for Left-To-Right order;</li>
	 * <li>'rtl' - for Right-To-Left order.</li>
	 * </ul>
	 * <br/>
	 * Default Value: 'OS'
	 * 
	 * @param dialog_buttonsOrder
	 * @return options
	 */
	public CKEditorOptions dialog_buttonsOrder(CharSequence dialog_buttonsOrder) {
		return super.put("dialog_buttonsOrder", dialog_buttonsOrder);
	}

	/**
	 * The distance of magnetic borders used in moving and resizing dialogs,
	 * measured in pixels. Defined in: plugins/dialog/plugin.js.<br/>
	 * Default Value: 20
	 * 
	 * @param dialog_magnetDistance
	 * @return options
	 */
	public CKEditorOptions dialog_magnetDistance(int dialog_magnetDistance) {
		return super.put("dialog_magnetDistance", dialog_magnetDistance);
	}

	/**
	 * If the dialog has more than one tab, put focus into the first tab as soon
	 * as dialog is opened. Defined in: plugins/dialog/plugin.js.<br/>
	 * Default Value: false
	 * 
	 * @param dialog_startupFocusTab
	 * @return options
	 */
	public CKEditorOptions dialog_startupFocusTab(boolean dialog_startupFocusTab) {
		return super.put("dialog_startupFocusTab", dialog_startupFocusTab);
	}

	/**
	 * Disables the built-in spell checker while typing natively available in
	 * the browser (currently Firefox and Safari only).
	 * 
	 * Even if word suggestions will not appear in the CKEditor context menu,
	 * this feature is useful to help quickly identifying misspelled words.
	 * 
	 * This setting is currently compatible with Firefox only due to limitations
	 * in other browsers. Defined in: plugins/wysiwygarea/plugin.js.<br/>
	 * 
	 * <br/>
	 * Default Value: true
	 * 
	 * @param disableNativeSpellChecker
	 * @return options
	 */
	public CKEditorOptions disableNativeSpellChecker(
			boolean disableNativeSpellChecker) {
		return super
				.put("disableNativeSpellChecker", disableNativeSpellChecker);
	}

	/**
	 * Disables the "table tools" offered natively by the browser (currently
	 * Firefox only) to make quick table editing operations, like adding or
	 * deleting rows and columns. Defined in: plugins/wysiwygarea/plugin.js.<br/>
	 * 
	 * Default Value: true
	 * 
	 * @param disableNativeTableHandles
	 * @return options
	 */
	public CKEditorOptions disableNativeTableHandles(
			boolean disableNativeTableHandles) {
		return super
				.put("disableNativeTableHandles", disableNativeTableHandles);
	}

	/**
	 * Disables the ability of resize objects (image and tables) in the editing
	 * area. Defined in: plugins/wysiwygarea/plugin.js.<br/>
	 * 
	 * Default Value: false
	 * 
	 * @param disableObjectResizing
	 * @return options
	 */
	public CKEditorOptions disableObjectResizing(boolean disableObjectResizing) {
		return super.put("disableObjectResizing", disableObjectResizing);
	}

	/**
	 * Disables inline styling on read-only elements. Defined in:
	 * plugins/styles/plugin.js.<br/>
	 * 
	 * Default Value: false
	 * 
	 * @param disableReadonlyStyling
	 * @return options
	 */
	public CKEditorOptions disableReadonlyStyling(boolean disableReadonlyStyling) {
		return super.put("disableReadonlyStyling", disableReadonlyStyling);
	}

	/**
	 * Sets the doctype to be used when loading the editor content as HTML.<br/>
	 * 
	 * Default Value: <code>'&lt;!DOCTYPE html PUBLIC
	 * "-//W3C//DTD XHTML 1.0 Transitional//EN"
	 * "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"&gt;'</code>
	 * 
	 * @param docType
	 * @return options
	 */
	public CKEditorOptions docType(CharSequence docType) {
		return super.put("docType", docType);
	}

	/**
	 * Whether to render or not the editing block area in the editor interface.
	 * Defined in: plugins/editingblock/plugin.js.<br/>
	 * 
	 * Default Value: true
	 * 
	 * @param editingBlock
	 * @return options
	 */
	public CKEditorOptions editingBlock(boolean editingBlock) {
		return super.put("editingBlock", editingBlock);
	}

	/**
	 * The e-mail address anti-spam protection option. The protection will be
	 * applied when creating or modifying e-mail links through the editor
	 * interface. Two methods of protection can be choosed:<br/>
	 * <ul>
	 * <li>The e-mail parts (name, domain and any other query string) are
	 * assembled into a function call pattern. Such function must be provided by
	 * the developer in the pages that will use the contents.</li>
	 * <li>Only the e-mail address is obfuscated into a special string that has
	 * no meaning for humans or spam bots, but which is properly rendered and
	 * accepted by the browser.</li>
	 * </ul>
	 * <br/>
	 * Both approaches require JavaScript to be enabled. Defined in:
	 * plugins/link/dialogs/link.js. <br/>
	 * Example:<br/>
	 * 
	 * <pre>
	 * // href="javascript:mt('tester','ckeditor.com','subject','body')"
	 * config.emailProtection = 'mt(NAME,DOMAIN,SUBJECT,BODY)';
	 * </pre>
	 * 
	 * <br/>
	 * Default Value: '' (empty string = disabled)
	 * 
	 * @param emailProtection
	 * @return options
	 */
	public CKEditorOptions emailProtection(CharSequence emailProtection) {
		return super.put("emailProtection", emailProtection);
	}

	/**
	 * Allow context-sensitive tab key behaviors, including the following
	 * scenarios: When selection is anchored inside table cells:<br/>
	 * <ul>
	 * <li>If TAB is pressed, select the contents of the "next" cell. If in the
	 * last cell in the table, add a new row to it and focus its first cell.</li>
	 * <li>If SHIFT+TAB is pressed, select the contents of the "previous" cell.
	 * Do nothing when it's in the first cell.</li>
	 * </ul>
	 * <br/>
	 * Defined in: plugins/tab/plugin.js. <br/>
	 * Default Value: true
	 * 
	 * @param enableTabKeyTools
	 * @return options
	 */
	public CKEditorOptions enableTabKeyTools(boolean enableTabKeyTools) {
		return super.put("enableTabKeyTools", enableTabKeyTools);
	}

	/**
	 * Sets the behavior for the ENTER key. It also dictates other behaviour
	 * rules in the editor, like whether the <br>
	 * element is to be used as a paragraph separator when indenting text. The
	 * allowed values are the following constants, and their relative behavior:<br/>
	 * <ul>
	 * <li>CKEDITOR.ENTER_P (1): new &lt;p&gt; paragraphs are created;</li>
	 * <li>CKEDITOR.ENTER_BR (2): lines are broken with &lt;br&gt; elements;</li>
	 * <li>CKEDITOR.ENTER_DIV (3): new &lt;div&gt; blocks are created.</li>
	 * </ul>
	 * Note: It's recommended to use the CKEDITOR.ENTER_P value because of its
	 * semantic value and correctness. The editor is optimized for this value.
	 * 
	 * @param enterMode
	 * @return options
	 */
	public CKEditorOptions enterMode(int enterMode) {
		return super.put("enterMode", enterMode);
	}

	/**
	 * Sets the behavior for the ENTER key. It also dictates other behaviour
	 * rules in the editor, like whether the <br>
	 * element is to be used as a paragraph separator when indenting text. The
	 * allowed values are the following constants, and their relative behavior:<br/>
	 * <ul>
	 * <li>CKEDITOR.ENTER_P (1): new &lt;p&gt; paragraphs are created;</li>
	 * <li>CKEDITOR.ENTER_BR (2): lines are broken with &lt;br&gt; elements;</li>
	 * <li>CKEDITOR.ENTER_DIV (3): new &lt;div&gt; blocks are created.</li>
	 * </ul>
	 * Note: It's recommended to use the CKEDITOR.ENTER_P value because of its
	 * semantic value and correctness. The editor is optimized for this value.
	 * 
	 * @param enterMode
	 * @return options
	 */
	public CKEditorOptions enterMode(EnterMode enterMode) {
		return super.put("enterMode", JQLiteral._raw(enterMode.value));
	}

	/**
	 * Whether to use HTML entities in the output. Defined in:
	 * plugins/entities/plugin.js.<br/>
	 * 
	 * Default Value: true
	 * 
	 * @param entities
	 * @return options
	 */
	public CKEditorOptions entities(boolean entities) {
		return super.put("entities", entities);
	}

	/**
	 * An additional list of entities to be used. It's a string containing each
	 * entry separated by a comma. Entities names or number must be used,
	 * exclusing the "&" preffix and the ";" termination. Defined in:
	 * plugins/entities/plugin.js.<br/>
	 * 
	 * Default Value: '#39' // The single quote (') character.
	 * 
	 * @param entities_additional
	 * @return options
	 */
	public CKEditorOptions entities_additional(CharSequence entities_additional) {
		return super.put("entities_additional", entities_additional);
	}

	/**
	 * Whether to convert some symbols, mathematical symbols, and Greek letters
	 * to HTML entities. This may be more relevant for users typing text written
	 * in Greek. The list of entities can be found at the W3C HTML 4.01
	 * Specification, section 24.3.1. Defined in: plugins/entities/plugin.js.<br/>
	 * 
	 * Default Value: true
	 * 
	 * @param entities_greek
	 * @return options
	 */
	public CKEditorOptions entities_greek(boolean entities_greek) {
		return super.put("entities_greek", entities_greek);
	}

	/**
	 * Whether to convert some Latin characters (Latin alphabet No. 1, ISO
	 * 8859-1) to HTML entities. The list of entities can be found at the W3C
	 * HTML 4.01 Specification, section 24.2.1. Defined in:
	 * plugins/entities/plugin.js.<br/>
	 * 
	 * Default Value: true
	 * 
	 * @param entities_latin
	 * @return options
	 */
	public CKEditorOptions entities_latin(boolean entities_latin) {
		return super.put("entities_latin", entities_latin);
	}

	/**
	 * List of additional plugins to be loaded. This is a tool setting which
	 * makes it easier to add new plugins, whithout having to touch and possibly
	 * breaking the CKEDITOR.config.plugins setting.<br/>
	 * 
	 * Example:<br/>
	 * 
	 * <pre>
	 * config.extraPlugins = 'myplugin,anotherplugin';
	 * </pre>
	 * 
	 * @param extraPlugins
	 * @return options
	 */
	public CKEditorOptions extraPlugins(CharSequence extraPlugins) {
		return super.put("extraPlugins", extraPlugins);
	}

	/**
	 * The location of an external file browser, that should be launched when
	 * "Browse Server" button is pressed. If configured, the "Browse Server"
	 * button will appear in Link, Image and Flash dialogs. Defined in:
	 * plugins/filebrowser/plugin.js.<br/>
	 * 
	 * Default Value: '' (empty string = disabled)
	 * 
	 * @param filebrowserBrowseUrl
	 * @return options
	 */
	public CKEditorOptions filebrowserBrowseUrl(
			CharSequence filebrowserBrowseUrl) {
		return super.put("filebrowserBrowseUrl", filebrowserBrowseUrl);
	}

	/**
	 * The location of an external file browser, that should be launched when
	 * "Browse Server" button is pressed in the Flash dialog. If not set,
	 * CKEditor will use CKEDITOR.config.filebrowserBrowseUrl. Defined in:
	 * plugins/filebrowser/plugin.js.<br/>
	 * 
	 * Default Value: '' (empty string = disabled)
	 * 
	 * @param filebrowserFlashBrowseUrl
	 * @return options
	 */
	public CKEditorOptions filebrowserFlashBrowseUrl(
			CharSequence filebrowserFlashBrowseUrl) {
		return super
				.put("filebrowserFlashBrowseUrl", filebrowserFlashBrowseUrl);
	}

	/**
	 * The location of a script that handles file uploads in the Flash dialog.
	 * If not set, CKEditor will use CKEDITOR.config.filebrowserUploadUrl.
	 * Defined in: plugins/filebrowser/plugin.js.<br/>
	 * 
	 * Default Value: '' (empty string = disabled)
	 * 
	 * @param filebrowserFlashUploadUrl
	 * @return options
	 */
	public CKEditorOptions filebrowserFlashUploadUrl(
			CharSequence filebrowserFlashUploadUrl) {
		return super
				.put("filebrowserFlashUploadUrl", filebrowserFlashUploadUrl);
	}

	/**
	 * The location of an external file browser, that should be launched when
	 * "Browse Server" button is pressed in the Link tab of Image dialog. If not
	 * set, CKEditor will use CKEDITOR.config.filebrowserBrowseUrl. Defined in:
	 * plugins/filebrowser/plugin.js.<br/>
	 * 
	 * efault Value: '' (empty string = disabled)
	 * 
	 * @param filebrowserImageBrowseLinkUrl
	 * @return options
	 */
	public CKEditorOptions filebrowserImageBrowseLinkUrl(
			CharSequence filebrowserImageBrowseLinkUrl) {
		return super.put("filebrowserImageBrowseLinkUrl",
				filebrowserImageBrowseLinkUrl);
	}

	/**
	 * The location of an external file browser, that should be launched when
	 * "Browse Server" button is pressed in the Image dialog. If not set,
	 * CKEditor will use CKEDITOR.config.filebrowserBrowseUrl. Defined in:
	 * plugins/filebrowser/plugin.js.<br/>
	 * 
	 * Default Value: '' (empty string = disabled)
	 * 
	 * @param filebrowserImageBrowseUrl
	 * @return options
	 */
	public CKEditorOptions filebrowserImageBrowseUrl(
			CharSequence filebrowserImageBrowseUrl) {
		return super
				.put("filebrowserImageBrowseUrl", filebrowserImageBrowseUrl);
	}

	/**
	 * The location of a script that handles file uploads in the Image dialog.
	 * If not set, CKEditor will use CKEDITOR.config.filebrowserUploadUrl.
	 * Defined in: plugins/filebrowser/plugin.js.<br/>
	 * Default Value: '' (empty string = disabled)
	 * 
	 * @param filebrowserImageUploadUrl
	 * @return options
	 */
	public CKEditorOptions filebrowserImageUploadUrl(
			CharSequence filebrowserImageUploadUrl) {
		return super
				.put("filebrowserImageUploadUrl", filebrowserImageUploadUrl);
	}

	/**
	 * The location of a script that handles file uploads. If set, the "Upload"
	 * tab will appear in "Link", "Image" and "Flash" dialogs. Defined in:
	 * plugins/filebrowser/plugin.js.<br/>
	 * 
	 * Default Value: '' (empty string = disabled)
	 * 
	 * @param filebrowserUploadUrl
	 * @return options
	 */
	public CKEditorOptions filebrowserUploadUrl(
			CharSequence filebrowserUploadUrl) {
		return super.put("filebrowserUploadUrl", filebrowserUploadUrl);
	}

	/**
	 * The "features" to use in the file browser popup window. Defined in:
	 * plugins/filebrowser/plugin.js.<br/>
	 * 
	 * 
	 * Default Value:
	 * 'location=no,menubar=no,toolbar=no,dependent=yes,minimizable=no,modal=yes
	 * , a l w a y s R a i s e d = y e s , r e s i z a b l e = y e s , s c r o l
	 * l b a r s = y e s '
	 * 
	 * @param filebrowserWindowFeatures
	 * @return options
	 */
	public CKEditorOptions filebrowserWindowFeatures(
			CharSequence filebrowserWindowFeatures) {
		return super
				.put("filebrowserWindowFeatures", filebrowserWindowFeatures);
	}

	/**
	 * Whether a filler text (non-breaking space entity - ) will be inserted
	 * into empty block elements in HTML output, this is used to render block
	 * elements properly with line-height; When a function is instead specified,
	 * it'll be passed a CKEDITOR.htmlParser.element to decide whether adding
	 * the filler text by expecting a boolean return value. Defined in:
	 * plugins/htmldataprocessor/plugin.js.<br/>
	 * 
	 * Default Value: true
	 * 
	 * @param fillEmptyBlocks
	 * @return options
	 */
	public CKEditorOptions fillEmptyBlocks(boolean fillEmptyBlocks) {
		return super.put("fillEmptyBlocks", fillEmptyBlocks);
	}

	/**
	 * Whether a filler text (non-breaking space entity - ) will be inserted
	 * into empty block elements in HTML output, this is used to render block
	 * elements properly with line-height; When a function is instead specified,
	 * it'll be passed a CKEDITOR.htmlParser.element to decide whether adding
	 * the filler text by expecting a boolean return value. Defined in:
	 * plugins/htmldataprocessor/plugin.js.<br/>
	 * 
	 * Default Value: true
	 * 
	 * <br/>
	 * Example:<br/>
	 * 
	 * <pre>
	 * config.fillEmptyBlocks = function( element )
	 * {
	 * 	if ( element.attributes[ 'class' ].indexOf ( 'clear-both' ) != -1 )
	 * 		return false;
	 * }
	 * </pre>
	 * 
	 * @param callback
	 * @return options
	 */
	public CKEditorOptions fillEmptyBlocks(IJQFunction callback) {
		return super.put("fillEmptyBlocks", callback);
	}

	/**
	 * Defines the style to be used to highlight results with the find dialog.
	 * Defined in: plugins/find/plugin.js.<br/>
	 * 
	 * Example:<br/>
	 * 
	 * <pre>
	 * // Highlight search results with blue on yellow.
	 * config.find_highlight =
	 *     {
	 *         element : 'span',
	 *         styles : { 'background-color' : '#ff0', 'color' : '#00f' }
	 *     };
	 * </pre>
	 * 
	 * @param find_highlight
	 * @return options
	 */
	public CKEditorOptions find_highlight(CharSequence find_highlight) {
		return super.put("find_highlight", find_highlight);
	}

	/**
	 * The text to be displayed in the Font combo is none of the available
	 * values matches the current cursor position or text selection. Defined in:
	 * plugins/font/plugin.js.<br/>
	 * 
	 * Example:<br/>
	 * 
	 * <pre>
	 * // If the default site font is Arial, we may making it more explicit to the end user.
	 * config.font_defaultLabel = 'Arial';
	 * </pre>
	 * 
	 * @param font_defaultLabel
	 * @return options
	 */
	public CKEditorOptions font_defaultLabel(CharSequence font_defaultLabel) {
		return super.put("font_defaultLabel", font_defaultLabel);
	}

	/**
	 * The list of fonts names to be displayed in the Font combo in the toolbar.
	 * Entries are separated by semi-colons (;), while it's possible to have
	 * more than one font for each entry, in the HTML way (separated by comma).
	 * A display name may be optionally defined by prefixing the entries with
	 * the name and the slash character. For example,
	 * "Arial/Arial, Helvetica, sans-serif" will be displayed as "Arial" in the
	 * list, but will be outputted as "Arial, Helvetica, sans-serif". Defined
	 * in: plugins/font/plugin.js. <br/>
	 * 
	 * Example:<br/>
	 * 
	 * <pre>
	 * config.font_names = 'Arial;Times New Roman;Verdana';
	 * </pre>
	 * 
	 * @param font_names
	 * @return options
	 */
	public CKEditorOptions font_names(CharSequence font_names) {
		return super.put("font_names", font_names);
	}

	/**
	 * The style definition to be used to apply the font in the text. Defined
	 * in: plugins/font/plugin.js.<br/>
	 * 
	 * Example:<br/>
	 * 
	 * <pre>
	 * // This is actually the default value for it.
	 * config.font_style =
	 *     {
	 *         element		: 'span',
	 *         styles		: { 'font-family' : '#(family)' },
	 *         overrides	: [ { element : 'font', attributes : { 'face' : null } } ]
	 *     };
	 * </pre>
	 * 
	 * @param font_style
	 * @return options
	 */
	public CKEditorOptions font_style(CharSequence font_style) {
		return super.put("font_style", font_style);
	}

	/**
	 * The text to be displayed in the Font Size combo is none of the available
	 * values matches the current cursor position or text selection. Defined in:
	 * plugins/font/plugin.js.<br/>
	 * 
	 * Example:<br/>
	 * 
	 * <pre>
	 * // If the default site font size is 12px, we may making it more explicit to the end user.
	 * config.fontSize_defaultLabel = '12px';
	 * </pre>
	 * 
	 * @param fontSize_defaultLabel
	 * @return options
	 */
	public CKEditorOptions fontSize_defaultLabel(
			CharSequence fontSize_defaultLabel) {
		return super.put("fontSize_defaultLabel", fontSize_defaultLabel);
	}

	/**
	 * The list of fonts size to be displayed in the Font Size combo in the
	 * toolbar. Entries are separated by semi-colons (;). Any kind of "CSS like"
	 * size can be used, like "12px", "2.3em", "130%", "larger" or "x-small". A
	 * display name may be optionally defined by prefixing the entries with the
	 * name and the slash character. For example, "Bigger Font/14px" will be
	 * displayed as "Bigger Font" in the list, but will be outputted as "14px".
	 * Defined in: plugins/font/plugin.js.<br/>
	 * 
	 * Example:<br/>
	 * 
	 * <pre>
	 * config.fontSize_sizes = '12 Pixels/12px;Big/2.3em;30 Percent More/130%;Bigger/larger;Very Small/x-small';
	 * </pre>
	 * 
	 * <br/>
	 * Default Value:
	 * '8/8px;9/9px;10/10px;11/11px;12/12px;14/14px;16/16px;18/18px;20/20px;22/2
	 * 2 p x ; 2 4 / 2 4 p x ; 2 6 / 2 6 p x ; 2 8 / 2 8 p x ; 3 6 / 3 6 p x ; 4
	 * 8 / 4 8 p x ; 7 2 / 7 2 p x '
	 * 
	 * @param fontSize_sizes
	 * @return options
	 */
	public CKEditorOptions fontSize_sizes(CharSequence fontSize_sizes) {
		return super.put("fontSize_sizes", fontSize_sizes);
	}

	/**
	 * The style definition to be used to apply the font size in the text.
	 * Defined in: plugins/font/plugin.js.<br/>
	 * 
	 * Example:<br/>
	 * 
	 * <pre>
	 * // This is actually the default value for it.
	 * config.fontSize_style =
	 *     {
	 *         element		: 'span',
	 *         styles		: { 'font-size' : '#(size)' },
	 *         overrides	: [ { element : 'font', attributes : { 'size' : null } } ]
	 *     };
	 * </pre>
	 * 
	 * 
	 * @param fontSize_style
	 * @return options
	 */
	public CKEditorOptions fontSize_style(CharSequence fontSize_style) {
		return super.put("fontSize_style", fontSize_style);
	}

	/**
	 * Force the respect of CKEDITOR.config.enterMode as line break regardless
	 * of the context, E.g. If CKEDITOR.config.enterMode is set to
	 * CKEDITOR.ENTER_P, press enter key inside a 'div' will create a new
	 * paragraph with 'p' instead of 'div'. <br/>
	 * Default Value: false
	 * 
	 * @param forceEnterMode
	 * @return options
	 */
	public CKEditorOptions forceEnterMode(boolean forceEnterMode) {
		return super.put("forceEnterMode", forceEnterMode);
	}

	/**
	 * Whether to force all pasting operations to insert on plain text into the
	 * editor, loosing any formatting information possibly available in the
	 * source text. Defined in: plugins/pastetext/plugin.js.<br/>
	 * 
	 * Default Value: false
	 * 
	 * @param forcePasteAsPlainText
	 * @return options
	 */
	public CKEditorOptions forcePasteAsPlainText(boolean forcePasteAsPlainText) {
		return super.put("forcePasteAsPlainText", forcePasteAsPlainText);
	}

	/**
	 * Whether to force using "&" instead of "&amp;" in elements attributes
	 * values, it's not recommended to change this setting for compliance with
	 * the W3C XHTML 1.0 standards (C.12, XHTML 1.0). Defined in:
	 * plugins/htmldataprocessor/plugin.js.
	 * 
	 * <br/>
	 * 
	 * Default Value: false
	 * 
	 * @param forceSimpleAmpersand
	 * @return options
	 */
	public CKEditorOptions forceSimpleAmpersand(boolean forceSimpleAmpersand) {
		return super.put("forceSimpleAmpersand", forceSimpleAmpersand);
	}

	/**
	 * The style definition to be used to apply the "Address" format. Defined
	 * in: plugins/format/plugin.js.<br/>
	 * 
	 * Example:<br/>
	 * 
	 * <pre>
	 * config.format_address = { element : 'address', attributes : { class : 'styledAddress' } };
	 * </pre>
	 * 
	 * @param format_address
	 * @return options
	 */
	public CKEditorOptions format_address(CharSequence format_address) {
		return super.put("format_address", format_address);
	}

	/**
	 * The style definition to be used to apply the "Normal (DIV)" format.
	 * Defined in: plugins/format/plugin.js.<br/>
	 * 
	 * Example:<br/>
	 * 
	 * <pre>
	 * config.format_div = { element : 'div', attributes : { class : 'normalDiv' } };
	 * </pre>
	 * 
	 * @param format_div
	 * @return options
	 */
	public CKEditorOptions format_div(CharSequence format_div) {
		return super.put("format_div", format_div);
	}

	/**
	 * The style definition to be used to apply the "Heading 1" format. Defined
	 * in: plugins/format/plugin.js.<br/>
	 * 
	 * Example:<br/>
	 * 
	 * <pre>
	 * config.format_h1 = { element : 'h1', attributes : { class : 'contentTitle1' } };
	 * </pre>
	 * 
	 * @param format_h1
	 * @return options
	 */
	public CKEditorOptions format_h1(CharSequence format_h1) {
		return super.put("format_h1", format_h1);
	}

	/**
	 * The style definition to be used to apply the "Heading 2" format. Defined
	 * in: plugins/format/plugin.js.<br/>
	 * 
	 * Example:<br/>
	 * 
	 * <pre>
	 * config.format_h2 = { element : 'h2', attributes : { class : 'contentTitle2' } };
	 * </pre>
	 * 
	 * @param format_h2
	 * @return options
	 */
	public CKEditorOptions format_h2(CharSequence format_h2) {
		return super.put("format_h2", format_h2);
	}

	/**
	 * The style definition to be used to apply the "Heading 3" format. Defined
	 * in: plugins/format/plugin.js.<br/>
	 * 
	 * Example:<br/>
	 * 
	 * <pre>
	 * config.format_h3 = { element : 'h3', attributes : { class : 'contentTitle3' } };
	 * </pre>
	 * 
	 * @param format_h3
	 * @return options
	 */
	public CKEditorOptions format_h3(CharSequence format_h3) {
		return super.put("format_h3", format_h3);
	}

	/**
	 * The style definition to be used to apply the "Heading 4" format. Defined
	 * in: plugins/format/plugin.js.<br/>
	 * 
	 * Example:<br/>
	 * 
	 * <pre>
	 * config.format_h4 = { element : 'h4', attributes : { class : 'contentTitle4' } };
	 * </pre>
	 * 
	 * @param format_h4
	 * @return options
	 */
	public CKEditorOptions format_h4(CharSequence format_h4) {
		return super.put("format_h4", format_h4);
	}

	/**
	 * The style definition to be used to apply the "Heading 5" format. Defined
	 * in: plugins/format/plugin.js.<br/>
	 * 
	 * Example:<br/>
	 * 
	 * <pre>
	 * config.format_h5 = { element : 'h5', attributes : { class : 'contentTitle5' } };
	 * </pre>
	 * 
	 * @param format_h5
	 * @return options
	 */
	public CKEditorOptions format_h5(CharSequence format_h5) {
		return super.put("format_h5", format_h5);
	}

	/**
	 * The style definition to be used to apply the "Heading 6" format. Defined
	 * in: plugins/format/plugin.js.<br/>
	 * 
	 * Example:<br/>
	 * 
	 * <pre>
	 * config.format_h6 = { element : 'h6', attributes : { class : 'contentTitle6' } };
	 * </pre>
	 * 
	 * @param format_h6
	 * @return options
	 */
	public CKEditorOptions format_h6(CharSequence format_h6) {
		return super.put("format_h6", format_h6);
	}

	/**
	 * The style definition to be used to apply the "Normal" format. Defined in:
	 * plugins/format/plugin.js.<br/>
	 * 
	 * Example:<br/>
	 * 
	 * <pre>
	 * config.format_p = { element : 'p', attributes : { class : 'normalPara' } };
	 * </pre>
	 * 
	 * @param format_p
	 * @return options
	 */
	public CKEditorOptions format_p(CharSequence format_p) {
		return super.put("format_p", format_p);
	}

	/**
	 * The style definition to be used to apply the "Formatted" format. Defined
	 * in: plugins/format/plugin.js. <br/>
	 * 
	 * Example:<br/>
	 * 
	 * <pre>
	 * config.format_pre = { element : 'pre', attributes : { class : 'code' } };
	 * </pre>
	 * 
	 * @param format_pre
	 * @return options
	 */
	public CKEditorOptions format_pre(CharSequence format_pre) {
		return super.put("format_pre", format_pre);
	}

	/**
	 * A list of semi colon separated style names (by default tags) representing
	 * the style definition for each entry to be displayed in the Format combo
	 * in the toolbar. Each entry must have its relative definition
	 * configuration in a setting named "format_(tagName)". For example, the "p"
	 * entry has its definition taken from config.format_p. Defined in:
	 * plugins/format/plugin.js.<br/>
	 * 
	 * Default Value: 'p;h1;h2;h3;h4;h5;h6;pre;address;div'
	 * 
	 * 
	 * @param format_tags
	 * @return options
	 */
	public CKEditorOptions format_tags(CharSequence format_tags) {
		return super.put("format_tags", format_tags);
	}

	/**
	 * Indicates whether the contents to be edited are being inputted as a full
	 * HTML page. A full page includes the <html>, <head> and <body> tags. The
	 * final output will also reflect this setting, including the <body>
	 * contents only if this setting is disabled.<br/>
	 * 
	 * Default Value: false
	 * 
	 * @param fullPage
	 * @return options
	 */
	public CKEditorOptions fullPage(boolean fullPage) {
		return super.put("fullPage", fullPage);
	}

	/**
	 * The height of editing area( content ), in relative or absolute, e.g.
	 * 30px, 5em. Note: Percentage unit is not supported yet. e.g. 30%.<br/>
	 * 
	 * Default Value: '200'
	 * 
	 * @param height
	 * @return options
	 */
	public CKEditorOptions height(int height) {
		return super.put("height", height);
	}

	/**
	 * The height of editing area( content ), in relative or absolute, e.g.
	 * 30px, 5em. Note: Percentage unit is not supported yet. e.g. 30%.<br/>
	 * 
	 * Default Value: '200'
	 * 
	 * @param height
	 * @return options
	 */
	public CKEditorOptions height(CharSequence height) {
		return super.put("height", height);
	}

	/**
	 * Whether escape HTML when editor update original input element. Defined
	 * in: core/editor.js.<br/>
	 * 
	 * Default Value: false
	 * 
	 * @param htmlEncodeOutput
	 * @return options
	 */
	public CKEditorOptions htmlEncodeOutput(boolean htmlEncodeOutput) {
		return super.put("htmlEncodeOutput", htmlEncodeOutput);
	}

	/**
	 * Whether the editor must output an empty value ("") if it's contents is
	 * made by an empty paragraph only. Defined in:
	 * plugins/wysiwygarea/plugin.js.<br/>
	 * 
	 * Default Value: true
	 * 
	 * @param ignoreEmptyParagraph
	 * @return options
	 */
	public CKEditorOptions ignoreEmptyParagraph(boolean ignoreEmptyParagraph) {
		return super.put("ignoreEmptyParagraph", ignoreEmptyParagraph);
	}

	/**
	 * Padding text to set off the image in preview area. Defined in:
	 * plugins/image/plugin.js.<br/>
	 * 
	 * Default Value: "Lorem ipsum dolor..." placehoder text.
	 * 
	 * @param image_previewText
	 * @return options
	 */
	public CKEditorOptions image_previewText(CharSequence image_previewText) {
		return super.put("image_previewText", image_previewText);
	}

	/**
	 * Whether to remove links when emptying the link URL field in the image
	 * dialog. Defined in: plugins/image/plugin.js.<br/>
	 * 
	 * Default Value: true
	 * 
	 * @param image_removeLinkByEmptyURL
	 * @return options
	 */
	public CKEditorOptions image_removeLinkByEmptyURL(
			boolean image_removeLinkByEmptyURL) {
		return super.put("image_removeLinkByEmptyURL",
				image_removeLinkByEmptyURL);
	}

	/**
	 * List of classes to use for indenting the contents. If it's null, no
	 * classes will be used and instead the #indentUnit and #indentOffset
	 * properties will be used. Defined in: plugins/indent/plugin.js.<br/>
	 * 
	 * Example:<br/>
	 * 
	 * <pre>
	 * // Use the classes 'Indent1', 'Indent2', 'Indent3'
	 * config.indentClasses = ['Indent1', 'Indent2', 'Indent3'];
	 * </pre>
	 * 
	 * @param indentClasses
	 * @return options
	 */
	public CKEditorOptions indentClasses(CharSequence... indentClasses) {
		return super.put("indentClasses", indentClasses);
	}

	/**
	 * Size of each indentation step Defined in: plugins/indent/plugin.js.<br/>
	 * 
	 * Default Value: 40
	 * 
	 * @param indentOffset
	 * @return options
	 */
	public CKEditorOptions indentOffset(int indentOffset) {
		return super.put("indentOffset", indentOffset);
	}

	/**
	 * Unit for the indentation style Defined in: plugins/indent/plugin.js.<br/>
	 * 
	 * Default Value: 'px'
	 * 
	 * @param indentUnit
	 * @return options
	 */
	public CKEditorOptions indentUnit(CharSequence indentUnit) {
		return super.put("indentUnit", indentUnit);
	}

	/**
	 * A list associating keystrokes to editor commands. Each element in the
	 * list is an array where the first item is the keystroke, and the second is
	 * the name of the command to be executed. Defined in:
	 * plugins/keystrokes/plugin.js.<br/>
	 * 
	 * 
	 * Example:<br/>
	 * 
	 * <pre>
	 * // This is actually the default value.
	 * config.keystrokes =
	 * [
	 *     [ CKEDITOR.ALT + 121 / * F10 * /, 'toolbarFocus' ],
	 *     [ CKEDITOR.ALT + 122 / * F11 * /, 'elementsPathFocus' ],
	 *     [ CKEDITOR.SHIFT + 121 / * F10 * /, 'contextMenu' ],
	 *     [ CKEDITOR.CTRL + 90 / * Z * /, 'undo' ],
	 *     [ CKEDITOR.CTRL + 89 / * Y * /, 'redo' ],
	 *     [ CKEDITOR.CTRL + CKEDITOR.SHIFT + 90 / * Z * /, 'redo' ],
	 *     [ CKEDITOR.CTRL + 76 / * L * /, 'link' ],
	 *     [ CKEDITOR.CTRL + 66 / * B * /, 'bold' ],
	 *     [ CKEDITOR.CTRL + 73 / * I * /, 'italic' ],
	 *     [ CKEDITOR.CTRL + 85 / * U * /, 'underline' ],
	 *     [ CKEDITOR.ALT + 109 / * - * /, 'toolbarCollapse' ]
	 * ];
	 * </pre>
	 * 
	 * @param keystrokes
	 * @return options
	 */
	public CKEditorOptions keystrokes(CharSequence... keystrokes) {
		return super.put("keystrokes", keystrokes);
	}

	/**
	 * The user interface language localization to use. If empty, the editor
	 * automatically localize the editor to the user language, if supported,
	 * otherwise the CKEDITOR.config.defaultLanguage language is used.<br/>
	 * 
	 * 
	 * Default Value: '' (empty)
	 * 
	 * @param language
	 * @return options
	 */
	public CKEditorOptions language(CharSequence language) {
		return super.put("language", language);
	}

	/**
	 * A comma separated list of items group names to be displayed in the
	 * context menu. The items order will reflect the order in this list if no
	 * priority has been definted in the groups. Defined in:
	 * plugins/menu/plugin.js.<br/>
	 * 
	 * Default Value:
	 * 'clipboard,form,tablecell,tablecellproperties,tablerow,tablecolumn,table,
	 * a n c h o r , l i n k , i m a g e , f l a s h , c h e c k b o x , r a d i
	 * o , t e x t f i e l d , h i d d e n f i e l d , i m a g e b u t t o n , b
	 * u t t o n , s e l e c t , t e x t a r e a '
	 * 
	 * @param menu_groups
	 * @return options
	 */
	public CKEditorOptions menu_groups(CharSequence menu_groups) {
		return super.put("menu_groups", menu_groups);
	}

	/**
	 * The file that provides the MS Word cleanup function for pasting
	 * operations. Note: This is a global configuration shared by all editor
	 * instances present in the page. Defined in:
	 * plugins/pastefromword/plugin.js.<br/>
	 * 
	 * Example:<br/>
	 * 
	 * <pre>
	 * // Load from 'pastefromword' plugin 'filter' sub folder (custom.js file).
	 * config.pasteFromWordCleanupFile = 'custom';
	 * </pre>
	 * 
	 * <br/>
	 * Default Value: 'default'
	 * 
	 * @param pasteFromWordCleanupFile
	 * @return options
	 */
	public CKEditorOptions pasteFromWordCleanupFile(
			CharSequence pasteFromWordCleanupFile) {
		return super.put("pasteFromWordCleanupFile", pasteFromWordCleanupFile);
	}

	/**
	 * Whether to transform MS Word outline numbered headings into lists.
	 * Defined in: plugins/pastefromword/filter/default.js.<br/>
	 * 
	 * Default Value: false
	 * 
	 * @param pasteFromWordNumberedHeadingToList
	 * @return options
	 */
	public CKEditorOptions pasteFromWordNumberedHeadingToList(
			boolean pasteFromWordNumberedHeadingToList) {
		return super.put("pasteFromWordNumberedHeadingToList",
				pasteFromWordNumberedHeadingToList);
	}

	/**
	 * Whether to prompt the user about the clean up of content being pasted
	 * from MS Word. Defined in: plugins/pastefromword/plugin.js.<br/>
	 * 
	 * 
	 * Default Value: undefined
	 * 
	 * @param pasteFromWordPromptCleanup
	 * @return options
	 */
	public CKEditorOptions pasteFromWordPromptCleanup(
			boolean pasteFromWordPromptCleanup) {
		return super.put("pasteFromWordPromptCleanup",
				pasteFromWordPromptCleanup);
	}

	/**
	 * Whether to ignore all font related formatting styles, including:<br/>
	 * <ul>
	 * <li>font size;</li>
	 * <li>font family;</li>
	 * <li>font foreground/background color.</li>
	 * </ul>
	 * Defined in: plugins/pastefromword/filter/default.js. <br/>
	 * 
	 * Default Value: true
	 * 
	 * @param pasteFromWordRemoveFontStyles
	 * @return options
	 */
	public CKEditorOptions pasteFromWordRemoveFontStyles(
			boolean pasteFromWordRemoveFontStyles) {
		return super.put("pasteFromWordRemoveFontStyles",
				pasteFromWordRemoveFontStyles);
	}

	/**
	 * Whether to remove element styles that can't be managed with the editor.
	 * Note that this doesn't handle the font specific styles, which depends on
	 * the CKEDITOR.config.pasteFromWordRemoveFontStyles setting instead.
	 * Defined in: plugins/pastefromword/filter/default.js.<br/>
	 * 
	 * Default Value: true
	 * 
	 * @param pasteFromWordRemoveStyles
	 * @return options
	 */
	public CKEditorOptions pasteFromWordRemoveStyles(
			boolean pasteFromWordRemoveStyles) {
		return super
				.put("pasteFromWordRemoveStyles", pasteFromWordRemoveStyles);
	}

	/**
	 * Comma separated list of plugins to load and initialize for an editor
	 * instance. This should be rarely changed, using instead the
	 * CKEDITOR.config.extraPlugins and CKEDITOR.config.removePlugins for
	 * customizations.
	 * 
	 * @param plugins
	 * @return options
	 */
	public CKEditorOptions plugins(CharSequence plugins) {
		return super.put("plugins", plugins);
	}

	/**
	 * List of regular expressions to be executed over the input HTML,
	 * indicating HTML source code that matched must not present in WYSIWYG mode
	 * for editing.<br/>
	 * 
	 * Example:<br/>
	 * 
	 * <pre>
	 * config.protectedSource.push( /<\?[\s\S]*?\?>/g );   // PHP Code
	 * config.protectedSource.push( /<%[\s\S]*?%>/g );   // ASP Code
	 * config.protectedSource.push( /(]+>[\s|\S]*?<\/asp:[^\>]+>)|(]+\/>)/gi );   // ASP.Net Code
	 * </pre>
	 * 
	 * <br/>
	 * Default Value: [] (empty array)
	 * 
	 * @param protectedSource
	 * @return options
	 */
	public CKEditorOptions protectedSource(CharSequence... protectedSource) {
		return super.put("protectedSource", protectedSource);
	}

	/**
	 * The dialog contents to removed. It's a string composed by dialog name and
	 * tab name with a colon between them. Separate each pair with semicolon
	 * (see example). Note: All names are case-sensitive. Note: Be cautious when
	 * specifying dialog tabs that are mandatory, like "info", dialog
	 * functionality might be broken because of this! Defined in:
	 * plugins/dialog/plugin.js.<br/>
	 * 
	 * Example:<br/>
	 * 
	 * <pre>
	 * config.removeDialogTabs = 'flash:advanced;image:Link';
	 * </pre>
	 * 
	 * <br/>
	 * Default Value: ''
	 * 
	 * @param removeDialogTabs
	 * @return options
	 */
	public CKEditorOptions removeDialogTabs(CharSequence removeDialogTabs) {
		return super.put("removeDialogTabs", removeDialogTabs);
	}

	/**
	 * A comma separated list of elements attributes to be removed when
	 * executing the "remove format" command. Defined in:
	 * plugins/removeformat/plugin.js.<br/>
	 * 
	 * Default Value: 'class,style,lang,width,height,align,hspace,valign'
	 * 
	 * @param removeFormatAttributes
	 * @return options
	 */
	public CKEditorOptions removeFormatAttributes(
			CharSequence removeFormatAttributes) {
		return super.put("removeFormatAttributes", removeFormatAttributes);
	}

	/**
	 * A comma separated list of elements to be removed when executing the
	 * "remove " format" command. Note that only inline elements are allowed.
	 * Defined in: plugins/removeformat/plugin.js.<br/>
	 * 
	 * Default Value:
	 * 'b,big,code,del,dfn,em,font,i,ins,kbd,q,samp,small,span,strike,strong,sub
	 * , s u p , t t , u , v a r '
	 * 
	 * @param removeFormatTags
	 * @return options
	 */
	public CKEditorOptions removeFormatTags(CharSequence removeFormatTags) {
		return super.put("removeFormatTags", removeFormatTags);
	}

	/**
	 * List of plugins that must not be loaded. This is a tool setting which
	 * makes it easier to avoid loading plugins definied in the
	 * CKEDITOR.config.plugins setting, whithout having to touch it and
	 * potentially breaking it. <br/>
	 * 
	 * Example:<br/>
	 * 
	 * <pre>
	 * config.removePlugins = 'elementspath,save,font';
	 * </pre>
	 * 
	 * @param removePlugins
	 * @return options
	 */
	public CKEditorOptions removePlugins(CharSequence removePlugins) {
		return super.put("removePlugins", removePlugins);
	}

	/**
	 * The directions to which the editor resizing is enabled. Possible values
	 * are "both", "vertical" and "horizontal". Defined in:
	 * plugins/resize/plugin.js.<br/>
	 * 
	 * Default Value: 'both'
	 * 
	 * @param resize_dir
	 * @return options
	 */
	public CKEditorOptions resize_dir(CharSequence resize_dir) {
		return super.put("resize_dir", resize_dir);
	}

	/**
	 * Whether to enable the resizing feature. If disabled the resize handler
	 * will not be visible. Defined in: plugins/resize/plugin.js.<br/>
	 * 
	 * 
	 * Default Value: true
	 * 
	 * @param resize_enabled
	 * @return options
	 */
	public CKEditorOptions resize_enabled(boolean resize_enabled) {
		return super.put("resize_enabled", resize_enabled);
	}

	/**
	 * The maximum editor height, in pixels, when resizing it with the resize
	 * handle. Defined in: plugins/resize/plugin.js.<br/>
	 * 
	 * Default Value: 3000
	 * 
	 * @param resize_maxHeight
	 * @return options
	 */
	public CKEditorOptions resize_maxHeight(int resize_maxHeight) {
		return super.put("resize_maxHeight", resize_maxHeight);
	}

	/**
	 * The maximum editor width, in pixels, when resizing it with the resize
	 * handle. Defined in: plugins/resize/plugin.js.<br/>
	 * 
	 * Default Value: 3000
	 * 
	 * @param resize_maxWidth
	 * @return options
	 */
	public CKEditorOptions resize_maxWidth(int resize_maxWidth) {
		return super.put("resize_maxWidth", resize_maxWidth);
	}

	/**
	 * The minimum editor width, in pixels, when resizing it with the resize
	 * handle. Note: It fallbacks to editor's actual width if that's smaller
	 * than the default value. Defined in: plugins/resize/plugin.js.<br/>
	 * 
	 * Default Value: 750
	 * 
	 * @param resize_minWidth
	 * @return options
	 */
	public CKEditorOptions resize_minWidth(int resize_minWidth) {
		return super.put("resize_minWidth", resize_minWidth);
	}

	/**
	 * If enabled (true), turns on SCAYT automatically after loading the editor.
	 * Defined in: plugins/scayt/plugin.js.<br/>
	 * 
	 * Default Value: false
	 * 
	 * 
	 * @param scayt_autoStartup
	 * @return options
	 */
	public CKEditorOptions scayt_autoStartup(boolean scayt_autoStartup) {
		return super.put("scayt_autoStartup", scayt_autoStartup);
	}

	/**
	 * Customizes the display of SCAYT context menu commands ("Add Word",
	 * "Ignore" and "Ignore All"). It must be a string with one or more of the
	 * following words separated by a pipe ("|"):<br/>
	 * <ul>
	 * <li>"off": disables all options.</li>
	 * <li>"all": enables all options.</li>
	 * <li>"ignore": enables the "Ignore" option.</li>
	 * <li>"ignoreall": enables the "Ignore All" option.</li>
	 * <li>"add": enables the "Add Word" option.</li>
	 * </ul>
	 * Defined in: plugins/scayt/plugin.js. <br/>
	 * Default Value: 'all'
	 * 
	 * @param scayt_contextCommands
	 * @return options
	 */
	public CKEditorOptions scayt_contextCommands(
			CharSequence scayt_contextCommands) {
		return super.put("scayt_contextCommands", scayt_contextCommands);
	}

	/**
	 * Define order of placing of SCAYT context menu items by groups. It must be
	 * a string with one or more of the following words separated by a pipe
	 * ("|"):<br/>
	 * <ul>
	 * <li>'suggest' - main suggestion word list,</li>
	 * <li>'moresuggest' - more suggestions word list,</li>
	 * <li>'control' - SCAYT commands, such as 'Ignore' and 'Add Word'</li>
	 * </ul>
	 * Defined in: plugins/scayt/plugin.js. <br/>
	 * Default Value: 'suggest|moresuggest|control'
	 * 
	 * @param scayt_contextMenuItemsOrder
	 * @return options
	 */
	public CKEditorOptions scayt_contextMenuItemsOrder(
			CharSequence scayt_contextMenuItemsOrder) {
		return super.put("scayt_contextMenuItemsOrder",
				scayt_contextMenuItemsOrder);
	}

	/**
	 * Links SCAYT to custom dictionaries. It's a string containing dictionary
	 * ids separared by commas (","). Available only for licensed version.
	 * Further details at
	 * http://wiki.spellchecker.net/doku.php?id=custom_dictionary_support .
	 * Defined in: plugins/scayt/plugin.js.<br/>
	 * Default Value: ''
	 * 
	 * @param scayt_customDictionaryIds
	 * @return options
	 */
	public CKEditorOptions scayt_customDictionaryIds(
			CharSequence scayt_customDictionaryIds) {
		return super
				.put("scayt_customDictionaryIds", scayt_customDictionaryIds);
	}

	/**
	 * Sets the customer ID for SCAYT. Required for migration from free version
	 * with banner to paid version. Defined in: plugins/scayt/plugin.js.<br/>
	 * 
	 * Default Value: ''
	 * 
	 * @param scayt_customerid
	 * @return options
	 */
	public CKEditorOptions scayt_customerid(CharSequence scayt_customerid) {
		return super.put("scayt_customerid", scayt_customerid);
	}

	/**
	 * Defines the number of SCAYT suggestions to show in the main context menu.
	 * The possible values are:<br/>
	 * <ul>
	 * <li>0 (zero): All suggestions are displayed in the main context menu.</li>
	 * <li>Positive number: The maximum number of suggestions to shown in
	 * context menu. Other entries will be shown in "More Suggestions" sub-menu.
	 * </li>
	 * <li>Negative number: No suggestions are shown in the main context menu.
	 * All entries will be listed in the "Suggestions" sub-menu.</li>
	 * </ul>
	 * Defined in: plugins/scayt/plugin.js. <br/>
	 * 
	 * Default Value: 5
	 * 
	 * @param scayt_maxSuggestions
	 * @return options
	 */
	public CKEditorOptions scayt_maxSuggestions(int scayt_maxSuggestions) {
		return super.put("scayt_maxSuggestions", scayt_maxSuggestions);
	}

	/**
	 * Enables/disables the "More Suggestions" sub-menu in the context menu. The
	 * possible values are "on" or "off". Defined in: plugins/scayt/plugin.js.<br/>
	 * 
	 * Default Value: 'on'
	 * 
	 * @param scayt_moreSuggestions
	 * @return options
	 */
	public CKEditorOptions scayt_moreSuggestions(
			CharSequence scayt_moreSuggestions) {
		return super.put("scayt_moreSuggestions", scayt_moreSuggestions);
	}

	/**
	 * Sets the default spellchecking language for SCAYT. Defined in:
	 * plugins/scayt/plugin.js.<br/>
	 * 
	 * Default Value: 'en_US'
	 * 
	 * @param scayt_sLang
	 * @return options
	 */
	public CKEditorOptions scayt_sLang(CharSequence scayt_sLang) {
		return super.put("scayt_sLang", scayt_sLang);
	}

	/**
	 * Set the URL to SCAYT core. Required to switch to licensed version of
	 * SCAYT application. Further details at
	 * http://wiki.spellchecker.net/doku.php?id=3rd:wysiwyg:fckeditor:wscckf3l .
	 * Defined in: plugins/scayt/plugin.js.
	 * 
	 * <br/>
	 * 
	 * Example:
	 * 
	 * <pre>
	 * config.scayt_srcUrl = &quot;http://my-host/spellcheck/lf/scayt/scayt.js&quot;;
	 * </pre>
	 * 
	 * <br/>
	 * 
	 * Default Value: ''
	 * 
	 * @param scayt_srcUrl
	 * @return options
	 */
	public CKEditorOptions scayt_srcUrl(CharSequence scayt_srcUrl) {
		return super.put("scayt_srcUrl", scayt_srcUrl);
	}

	/**
	 * Sets the visibility of the SCAYT tabs in the settings dialog and toolbar
	 * button. The value must contain a "1" (enabled) or "0" (disabled) number
	 * for each of the following entries, in this precise order, separated by a
	 * comma (","): "Options", "Languages" and "Dictionary". Defined in:
	 * plugins/scayt/plugin.js.<br/>
	 * 
	 * Default Value: '1,1,1'
	 * 
	 * @param scayt_uiTabs
	 * @return options
	 */
	public CKEditorOptions scayt_uiTabs(CharSequence scayt_uiTabs) {
		return super.put("scayt_uiTabs", scayt_uiTabs);
	}

	/**
	 * Makes it possible to activate a custom dictionary on SCAYT. The user
	 * dictionary name must be used. Available only for licensed version.
	 * Defined in: plugins/scayt/plugin.js.<br/>
	 * 
	 * Default Value: ''
	 * 
	 * @param scayt_userDictionaryName
	 * @return options
	 */
	public CKEditorOptions scayt_userDictionaryName(
			CharSequence scayt_userDictionaryName) {
		return super.put("scayt_userDictionaryName", scayt_userDictionaryName);
	}

	/**
	 * Just like the CKEDITOR.config.enterMode setting, it defines the behavior
	 * for the SHIFT+ENTER key. The allowed values are the following constants,
	 * and their relative behavior:<br/>
	 * <ul>
	 * <li>CKEDITOR.ENTER_P (1): new &lt;p&gt; paragraphs are created;</li>
	 * <li>CKEDITOR.ENTER_BR (2): lines are broken with &lt;br&gt; elements;</li>
	 * <li>CKEDITOR.ENTER_DIV (3): new &lt;div&gt; blocks are created.</li>
	 * </ul>
	 * 
	 * @param shiftEnterMode
	 * @return options
	 */
	public CKEditorOptions shiftEnterMode(int shiftEnterMode) {
		return super.put("shiftEnterMode", shiftEnterMode);
	}

	/**
	 * Just like the CKEDITOR.config.enterMode setting, it defines the behavior
	 * for the SHIFT+ENTER key. The allowed values are the following constants,
	 * and their relative behavior:<br/>
	 * <ul>
	 * <li>CKEDITOR.ENTER_P (1): new &lt;p&gt; paragraphs are created;</li>
	 * <li>CKEDITOR.ENTER_BR (2): lines are broken with &lt;br&gt; elements;</li>
	 * <li>CKEDITOR.ENTER_DIV (3): new &lt;div&gt; blocks are created.</li>
	 * </ul>
	 * 
	 * @param shiftEnterMode
	 * @return options
	 */
	public CKEditorOptions shiftEnterMode(CharSequence shiftEnterMode) {
		return super.put("shiftEnterMode", shiftEnterMode);
	}

	/**
	 * The skin to load. It may be the name of the skin folder inside the editor
	 * installation path, or the name and the path separated by a comma.<br/>
	 * 
	 * Default Value: 'default'
	 * 
	 * @param skin
	 * @return options
	 */
	public CKEditorOptions skin(CharSequence skin) {
		return super.put("skin", skin);
	}

	/**
	 * The number of columns to be generated by the smilies matrix. Defined in:
	 * plugins/smiley/plugin.js.<br/>
	 * 
	 * Default Value: 8
	 * 
	 * @param smiley_columns
	 * @return options
	 */
	public CKEditorOptions smiley_columns(int smiley_columns) {
		return super.put("smiley_columns", smiley_columns);
	}

	/**
	 * The description to be used for each of the smileys defined in the
	 * CKEDITOR.config.smiley_images setting. Each entry in this array list must
	 * match its relative pair in the CKEDITOR.config.smiley_images setting.
	 * Defined in: plugins/smiley/plugin.js.<br/>
	 * 
	 * Default:<br/>
	 * 
	 * <pre>
	 * // Default settings.
	 * config.smiley_descriptions =
	 *     [
	 *         'smiley', 'sad', 'wink', 'laugh', 'frown', 'cheeky', 'blush', 'surprise',
	 *         'indecision', 'angry', 'angel', 'cool', 'devil', 'crying', 'enlightened', 'no',
	 *         'yes', 'heart', 'broken heart', 'kiss', 'mail'
	 *     ];
	 * </pre>
	 * 
	 * @param smiley_descriptions
	 * @return options
	 */
	public CKEditorOptions smiley_descriptions(
			CharSequence... smiley_descriptions) {
		return super.put("smiley_descriptions", smiley_descriptions);
	}

	/**
	 * The file names for the smileys to be displayed. These files must be
	 * contained inside the URL path defined with the
	 * CKEDITOR.config.smiley_path setting. Defined in:
	 * plugins/smiley/plugin.js.<br/>
	 * 
	 * Default:<br/>
	 * 
	 * <pre>
	 * // This is actually the default value.
	 * config.smiley_images = [
	 *     'regular_smile.gif','sad_smile.gif','wink_smile.gif','teeth_smile.gif','confused_smile.gif','tounge_smile.gif',
	 *     'embaressed_smile.gif','omg_smile.gif','whatchutalkingabout_smile.gif','angry_smile.gif','angel_smile.gif','shades_smile.gif',
	 *     'devil_smile.gif','cry_smile.gif','lightbulb.gif','thumbs_down.gif','thumbs_up.gif','heart.gif',
	 *     'broken_heart.gif','kiss.gif','envelope.gif'];
	 * </pre>
	 * 
	 * @param smiley_images
	 * @return options
	 */
	public CKEditorOptions smiley_images(CharSequence... smiley_images) {
		return super.put("smiley_images", smiley_images);
	}

	/**
	 * The base path used to build the URL for the smiley images. It must end
	 * with a slash. Defined in: plugins/smiley/plugin.js.<br/>
	 * 
	 * Default Value: + 'plugins/smiley/images/'
	 * 
	 * @param smiley_path
	 * @return options
	 */
	public CKEditorOptions smiley_path(CharSequence smiley_path) {
		return super.put("smiley_path", smiley_path);
	}

	/**
	 * The list of special characters visible in Special Character dialog.
	 * Defined in: plugins/specialchar/plugin.js.<br/>
	 * 
	 * Example:<br/>
	 * 
	 * <pre>
	 * config.specialChars = [ '"', '’', [ '&custom;', 'Custom label' ] ];
	 * config.specialChars = config.specialChars.concat( [ '"', [ '’', 'Custom label' ] ] );
	 * </pre>
	 * 
	 * @param specialChars
	 * @return options
	 */
	public CKEditorOptions specialChars(CharSequence... specialChars) {
		return super.put("specialChars", specialChars);
	}

	/**
	 * The mode to load at the editor startup. It depends on the plugins loaded.
	 * By default, the "wysiwyg" and "source" modes are available. Defined in:
	 * plugins/editingblock/plugin.js.<br/>
	 * 
	 * Default Value: 'wysiwyg'
	 * 
	 * @param startupMode
	 * @return options
	 */
	public CKEditorOptions startupMode(CharSequence startupMode) {
		return super.put("startupMode", startupMode);
	}

	/**
	 * Whether to automaticaly enable the "show block" command when the editor
	 * loads. (StartupShowBlocks in FCKeditor) Defined in:
	 * plugins/showblocks/plugin.js.<br/>
	 * 
	 * Default Value: false
	 * 
	 * @param startupOutlineBlocks
	 * @return options
	 */
	public CKEditorOptions startupOutlineBlocks(boolean startupOutlineBlocks) {
		return super.put("startupOutlineBlocks", startupOutlineBlocks);
	}

	/**
	 * Whether to automatically enable the "show borders" command when the
	 * editor loads. (ShowBorders in FCKeditor) Defined in:
	 * plugins/showborders/plugin.js.<br/>
	 * 
	 * Default Value: true
	 * 
	 * @param startupShowBorders
	 * @return options
	 */
	public CKEditorOptions startupShowBorders(boolean startupShowBorders) {
		return super.put("startupShowBorders", startupShowBorders);
	}

	/**
	 * The "styles definition set" to use in the editor. They will be used in
	 * the styles combo and the Style selector of the div container. The styles
	 * may be defined in the page containing the editor, or can be loaded on
	 * demand from an external file. In the second case, if this setting
	 * contains only a name, the styles definition file will be loaded from the
	 * "styles" folder inside the styles plugin folder. Otherwise, this setting
	 * has the "name:url" syntax, making it possible to set the URL from which
	 * loading the styles file. Previously this setting was available as
	 * config.stylesCombo_stylesSet
	 * 
	 * Defined in: plugins/styles/plugin.js.<br/>
	 * 
	 * Example:<br/>
	 * 
	 * <pre>
	 * // Load from the styles' styles folder (mystyles.js file).
	 * config.stylesSet = 'mystyles';
	 * 
	 * // Load from a relative URL.
	 * config.stylesSet = 'mystyles:/editorstyles/styles.js';
	 * 
	 * // Load from a full URL.
	 * config.stylesSet = 'mystyles:http://www.example.com/editorstyles/styles.js';
	 * 
	 * // Load from a list of definitions.
	 * config.stylesSet = [
	 *  { name : 'Strong Emphasis', element : 'strong' },
	 * { name : 'Emphasis', element : 'em' }, ... ];
	 * </pre>
	 * 
	 * <br/>
	 * Default Value: 'default'
	 * 
	 * @param stylesSet
	 * @return options
	 */
	public CKEditorOptions stylesSet(CharSequence stylesSet) {
		return super.put("stylesSet", stylesSet);
	}

	/**
	 * The "styles definition set" to use in the editor. They will be used in
	 * the styles combo and the Style selector of the div container. The styles
	 * may be defined in the page containing the editor, or can be loaded on
	 * demand from an external file. In the second case, if this setting
	 * contains only a name, the styles definition file will be loaded from the
	 * "styles" folder inside the styles plugin folder. Otherwise, this setting
	 * has the "name:url" syntax, making it possible to set the URL from which
	 * loading the styles file. Previously this setting was available as
	 * config.stylesCombo_stylesSet
	 * 
	 * Defined in: plugins/styles/plugin.js.<br/>
	 * 
	 * Example:<br/>
	 * 
	 * <pre>
	 * // Load from the styles' styles folder (mystyles.js file).
	 * config.stylesSet = 'mystyles';
	 * 
	 * // Load from a relative URL.
	 * config.stylesSet = 'mystyles:/editorstyles/styles.js';
	 * 
	 * // Load from a full URL.
	 * config.stylesSet = 'mystyles:http://www.example.com/editorstyles/styles.js';
	 * 
	 * // Load from a list of definitions.
	 * config.stylesSet = [
	 *  { name : 'Strong Emphasis', element : 'strong' },
	 * { name : 'Emphasis', element : 'em' }, ... ];
	 * </pre>
	 * 
	 * <br/>
	 * Default Value: 'default'
	 * 
	 * @param stylesSet
	 * @return options
	 */
	public CKEditorOptions stylesSet(CharSequence... stylesSet) {
		return super.put("stylesSet", stylesSet);
	}

	/**
	 * The editor tabindex value.<br/>
	 * Default Value: 0 (zero)
	 * 
	 * @param tabIndex
	 * @return options
	 */
	public CKEditorOptions tabIndex(int tabIndex) {
		return super.put("tabIndex", tabIndex);
	}

	/**
	 * Intructs the editor to add a number of spaces (&nbsp;) to the text when
	 * hitting the TAB key. If set to zero, the TAB key will be used to move the
	 * cursor focus to the next element in the page, out of the editor focus.
	 * Defined in: plugins/tab/plugin.js.<br/>
	 * 
	 * Default Value: 0
	 * 
	 * @param tabSpaces
	 * @return options
	 */
	public CKEditorOptions tabSpaces(int tabSpaces) {
		return super.put("tabSpaces", tabSpaces);
	}

	/**
	 * The list of templates definition files to load. Defined in:
	 * plugins/templates/plugin.js.<br/>
	 * 
	 * Example:<br/>
	 * 
	 * <pre>
	 * config.templates_files =
	 *     [
	 *         '/editor_templates/site_default.js',
	 *         'http://www.example.com/user_templates.js
	 *     ];
	 * </pre>
	 * 
	 * <br/>
	 * Default Value: [ 'plugins/templates/templates/default.js' ]
	 * 
	 * @param templates_files
	 * @return options
	 */
	public CKEditorOptions templates_files(CharSequence... templates_files) {
		return super.put("templates_files", templates_files);
	}

	/**
	 * Whether the "Replace actual contents" checkbox is checked by default in
	 * the Templates dialog. Defined in: plugins/templates/plugin.js.<br/>
	 * 
	 * Default Value: true
	 * 
	 * @param templates_replaceContent
	 * @return options
	 */
	public CKEditorOptions templates_replaceContent(
			boolean templates_replaceContent) {
		return super.put("templates_replaceContent", templates_replaceContent);
	}

	/**
	 * The theme to be used to build the UI.<br/>
	 * Default Value: 'default'
	 * 
	 * @param theme
	 * @return options
	 */
	public CKEditorOptions theme(CharSequence theme) {
		return super.put("theme", theme);
	}

	/**
	 * The toolbox (alias toolbar) definition. It is a toolbar name or an array
	 * of toolbars (strips), each one being also an array, containing a list of
	 * UI items. Defined in: plugins/toolbar/plugin.js.<br/>
	 * 
	 * Example:<br/>
	 * 
	 * <pre>
	 * // Defines a toolbar with only one strip containing the "Source" button, a
	 * // separator and the "Bold" and "Italic" buttons.
	 * config.toolbar =
	 * [
	 *     [ 'Source', '-', 'Bold', 'Italic' ]
	 * ];
	 * 
	 * // Load toolbar_Name where Name = Basic.
	 * config.toolbar = 'Basic';
	 * </pre>
	 * 
	 * <br/>
	 * Default Value: 'Full'
	 * 
	 * @param toolbar
	 * @return options
	 */
	public CKEditorOptions toolbar(CharSequence toolbar) {
		return super.put("toolbar", toolbar);
	}

	/**
	 * The toolbox (alias toolbar) definition. It is a toolbar name or an array
	 * of toolbars (strips), each one being also an array, containing a list of
	 * UI items. Defined in: plugins/toolbar/plugin.js.<br/>
	 * 
	 * Example:<br/>
	 * 
	 * <pre>
	 * // Defines a toolbar with only one strip containing the "Source" button, a
	 * // separator and the "Bold" and "Italic" buttons.
	 * config.toolbar =
	 * [
	 *     [ 'Source', '-', 'Bold', 'Italic' ]
	 * ];
	 * 
	 * // Load toolbar_Name where Name = Basic.
	 * config.toolbar = 'Basic';
	 * </pre>
	 * 
	 * <br/>
	 * Default Value: 'Full'
	 * 
	 * @param toolbar
	 * @return options
	 */
	public CKEditorOptions toolbar(CharSequence[][] toolbar) {
		return super.put("toolbar", toolbar);
	}

	/**
	 * The toolbar definition. It is an array of toolbars (strips), each one
	 * being also an array, containing a list of UI items. Note that this
	 * setting is composed by "toolbar_" added by the toolbar name, which in
	 * this case is called "Basic". This second part of the setting name can be
	 * anything. You must use this name in the CKEDITOR.config.toolbar setting,
	 * so you instruct the editor which toolbar_(name) setting to you. Defined
	 * in: plugins/toolbar/plugin.js.<br/>
	 * 
	 * Example:<br/>
	 * 
	 * <pre>
	 * // Defines a toolbar with only one strip containing the "Source" button, a
	 * // separator and the "Bold" and "Italic" buttons.
	 * config.toolbar_Basic =
	 * [
	 *     [ 'Source', '-', 'Bold', 'Italic' ]
	 * ];
	 * config.toolbar = 'Basic';
	 * </pre>
	 * 
	 * @param toolbar_Basic
	 * @return options
	 */
	public CKEditorOptions toolbar_Basic(CharSequence[][] toolbar_Basic) {
		return super.put("toolbar_Basic", toolbar_Basic);
	}

	/**
	 * This is the default toolbar definition used by the editor. It contains
	 * all editor features. Defined in: plugins/toolbar/plugin.js.<br/>
	 * 
	 * Default:<br/>
	 * 
	 * <pre>
	 * // This is actually the default value.
	 * config.toolbar_Full =
	 * [
	 *     ['Source','-','Save','NewPage','Preview','-','Templates'],
	 *     ['Cut','Copy','Paste','PasteText','PasteFromWord','-','Print', 'SpellChecker', 'Scayt'],
	 *     ['Undo','Redo','-','Find','Replace','-','SelectAll','RemoveFormat'],
	 *     ['Form', 'Checkbox', 'Radio', 'TextField', 'Textarea', 'Select', 'Button', 'ImageButton', 'HiddenField'],
	 *     '/',
	 *     ['Bold','Italic','Underline','Strike','-','Subscript','Superscript'],
	 *     ['NumberedList','BulletedList','-','Outdent','Indent','Blockquote','CreateDiv'],
	 *     ['JustifyLeft','JustifyCenter','JustifyRight','JustifyBlock'],
	 *     ['BidiLtr', 'BidiRtl' ],
	 *     ['Link','Unlink','Anchor'],
	 *     ['Image','Flash','Table','HorizontalRule','Smiley','SpecialChar','PageBreak','Iframe'],
	 *     '/',
	 *     ['Styles','Format','Font','FontSize'],
	 *     ['TextColor','BGColor'],
	 *     ['Maximize', 'ShowBlocks','-','About']
	 * ];
	 * </per>
	 * 
	 * @param toolbar_Full
	 * @return options
	 */
	public CKEditorOptions toolbar_Full(CharSequence[][] toolbar_Full) {
		return super.put("toolbar_Full", toolbar_Full);
	}

	/**
	 * Whether the toolbar can be collapsed by the user. If disabled, the
	 * collapser button will not be displayed. Defined in:
	 * plugins/toolbar/plugin.js.<br/>
	 * 
	 * Default Value: true
	 * 
	 * @param toolbarCanCollapse
	 * @return options
	 */
	public CKEditorOptions toolbarCanCollapse(boolean toolbarCanCollapse) {
		return super.put("toolbarCanCollapse", toolbarCanCollapse);
	}

	/**
	 * The "theme space" to which rendering the toolbar. For the default theme,
	 * the recommended options are "top" and "bottom". Defined in:
	 * plugins/toolbar/plugin.js.<br/>
	 * 
	 * Default Value: 'top'
	 * 
	 * @param toolbarLocation
	 * @return options
	 */
	public CKEditorOptions toolbarLocation(CharSequence toolbarLocation) {
		return super.put("toolbarLocation", toolbarLocation);
	}

	/**
	 * Whether the toolbar must start expanded when the editor is loaded.
	 * Defined in: plugins/toolbar/plugin.js.<br/>
	 * 
	 * Default Value: true
	 * 
	 * @param toolbarStartupExpanded
	 * @return options
	 */
	public CKEditorOptions toolbarStartupExpanded(boolean toolbarStartupExpanded) {
		return super.put("toolbarStartupExpanded", toolbarStartupExpanded);
	}

	/**
	 * Indicates that some of the editor features, like alignment and text
	 * direction, should used the "computed value" of the feature to indicate
	 * it's on/off state, instead of using the "real value".
	 * 
	 * If enabled, in a left to right written document, the "Left Justify"
	 * alignment button will show as active, even if the aligment style is not
	 * explicitly applied to the current paragraph in the editor.<br/>
	 * 
	 * Default Value: true
	 * 
	 * @param useComputedState
	 * @return options
	 */
	public CKEditorOptions useComputedState(boolean useComputedState) {
		return super.put("useComputedState", useComputedState);
	}

	/**
	 * The editor width in CSS size format or pixel integer.<br/>
	 * 
	 * Default Value: '' (empty)
	 * 
	 * @param width
	 * @return options
	 */
	public CKEditorOptions width(int width) {
		return super.put("width", width);
	}

	/**
	 * The editor width in CSS size format or pixel integer.<br/>
	 * 
	 * Default Value: '' (empty)
	 * 
	 * @param width
	 * @return options
	 */
	public CKEditorOptions width(CharSequence width) {
		return super.put("width", width);
	}
}
