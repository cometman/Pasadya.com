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
package com.google.code.jqwicket.ui.datepicker;

import com.google.code.jqwicket.api.AbstractJQOptions;
import com.google.code.jqwicket.api.IJQFunction;
import com.google.code.jqwicket.api.IJQStatement;

import static com.google.code.jqwicket.api.JQuery.$f;
import static com.google.code.jqwicket.api.JQuery.js;

/**
 * @author mkalina
 * 
 */
public abstract class AbstractDatePickerOptions<T extends AbstractDatePickerOptions<T>>
		extends AbstractJQOptions<T> {

	private static final long serialVersionUID = 1L;

	/**
	 * Disables (true) or enables (false) the datepicker. Can be set when
	 * initialising (first creating) the datepicker. Default:false
	 * 
	 * @param disabled
	 * @return
	 */
	public T disabled(boolean disabled) {
		return super.put("disabled", disabled);
	}

	/**
	 * The jQuery selector for another field that is to be updated with the
	 * selected date from the datepicker. Use the altFormat setting to change
	 * the format of the date within this field. Leave as blank for no alternate
	 * field. Default:''
	 * 
	 * @param selector
	 * @return
	 */
	public T altField(CharSequence selector) {
		return super.put("altField", selector);
	}

	/**
	 * The dateFormat to be used for the altField option. This allows one date
	 * format to be shown to the user for selection purposes, while a different
	 * format is actually sent behind the scenes. For a full list of the
	 * possible formats see the formatDate function. Default:''
	 * 
	 * @param altFormat
	 * @return
	 */
	public T altFormat(CharSequence altFormat) {
		return super.put("altFormat", altFormat);
	}

	/**
	 * The text to display after each date field, e.g. to show the required
	 * format. Default:''
	 * 
	 * @param autoSize
	 * @return
	 */
	public T appendText(CharSequence appendText) {
		return super.put("appendText", appendText);
	}

	/**
	 * Set to true to automatically resize the input field to accomodate dates
	 * in the current dateFormat. Default:false
	 * 
	 * @param autoSize
	 * @return
	 */
	public T autoSize(boolean autoSize) {
		return super.put("autoSize", autoSize);
	}

	/**
	 * The URL for the popup button image. If set, buttonText becomes the alt
	 * value and is not directly displayed. Default:''
	 * 
	 * @param buttonImage
	 * @return
	 */
	public T buttonImage(CharSequence buttonImage) {
		return super.put("buttonImage", buttonImage);
	}

	/**
	 * Set to true to place an image after the field to use as the trigger
	 * without it appearing on a button. Default:false
	 * 
	 * @param buttonImageOnly
	 * @return
	 */
	public T buttonImageOnly(boolean buttonImageOnly) {
		return super.put("buttonImageOnly", buttonImageOnly);
	}

	/**
	 * The text to display on the trigger button. Use in conjunction with showOn
	 * equal to 'button' or 'both'. Default:'...'
	 * 
	 * @param buttonText
	 * @return
	 */
	public T buttonText(CharSequence buttonText) {
		return super.put("buttonText", buttonText);

	}

	/**
	 * function to calculate the week of the year for a given date. The default
	 * implementation uses the ISO 8601 definition: weeks start on a Monday; the
	 * first week of the year contains the first Thursday of the year.
	 * Default:$.datepicker.iso8601Week
	 * 
	 * @param function
	 * @return
	 */
	public T calculateWeek(IJQFunction function) {
		return super.put("calculateWeek", function);

	}

	/**
	 * function to calculate the week of the year for a given date. The default
	 * implementation uses the ISO 8601 definition: weeks start on a Monday; the
	 * first week of the year contains the first Thursday of the year.
	 * Default:$.datepicker.iso8601Week
	 * 
	 * @param js
	 * @param args
	 * @return
	 */
	public T calculateWeek(CharSequence js, CharSequence... args) {
		return super.put("calculateWeek", $f(js).withParams(args));

	}

	/**
	 * 
	 * Allows you to change the month by selecting from a drop-down list. You
	 * can enable this feature by setting the attribute to true. Default:false
	 * 
	 * @param changeMonth
	 * @return
	 */
	public T changeMonth(boolean changeMonth) {
		return super.put("changeMonth", changeMonth);

	}

	/**
	 * Allows you to change the year by selecting from a drop-down list. You can
	 * enable this feature by setting the attribute to true. Use the yearRange
	 * option to control which years are made available for selection.
	 * Default:false
	 * 
	 * @param changeYear
	 * @return
	 */
	public T changeYear(boolean changeYear) {
		return super.put("changeYear", changeYear);

	}

	/**
	 * The text to display for the close link. This attribute is one of the
	 * regionalisation attributes. Use the showButtonPanel to display this
	 * button. Default:'Done'
	 * 
	 * @param closeText
	 * @return
	 */
	public T closeText(CharSequence closeText) {
		return super.put("closeText", closeText);

	}

	/**
	 * When true entry in the input field is constrained to those characters
	 * allowed by the current dateFormat. Default:true
	 * 
	 * @param constrainInput
	 * @return
	 */
	public T constrainInput(boolean constrainInput) {
		return super.put("constrainInput", constrainInput);

	}

	/**
	 * The text to display for the current day link. This attribute is one of
	 * the regionalisation attributes. Use the showButtonPanel to display this
	 * button. Default:'Today'
	 * 
	 * @param currentText
	 * @return
	 */
	public T currentText(CharSequence currentText) {
		return super.put("currentText", currentText);

	}

	/**
	 * The format for parsed and displayed dates. This attribute is one of the
	 * regionalisation attributes. For a full list of the possible formats see
	 * the formatDate function. Default:'mm/dd/yy'
	 * 
	 * @param dateFormat
	 * @return
	 */
	public T dateFormat(CharSequence dateFormat) {
		return super.put("dateFormat", dateFormat);

	}

	/**
	 * The list of long day names, starting from Sunday, for use as requested
	 * via the dateFormat setting. They also appear as popup hints when hovering
	 * over the corresponding column headings. This attribute is one of the
	 * regionalisation attributes.<br>
	 * Default:['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday',
	 * 'Friday', 'Saturday']
	 * 
	 * @param dayNames
	 * @return
	 */
	public T dayNames(CharSequence... dayNames) {
		return super.put("dayNames", dayNames);

	}

	/**
	 * The list of minimised day names, starting from Sunday, for use as column
	 * headers within the datepicker. This attribute is one of the
	 * regionalisation attributes.<br>
	 * Default:['Su', 'Mo', 'Tu', 'We', 'Th', 'Fr', 'Sa']
	 * 
	 * @param dayNamesMin
	 * @return
	 */
	public T dayNamesMin(CharSequence... dayNamesMin) {
		return super.put("dayNamesMin", dayNamesMin);

	}

	/**
	 * The list of abbreviated day names, starting from Sunday, for use as
	 * requested via the dateFormat setting. This attribute is one of the
	 * regionalisation attributes. <br>
	 * Default:['Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat']
	 * 
	 * @param dayNamesMin
	 * @return
	 */
	public T dayNamesShort(CharSequence... dayNamesShort) {
		return super.put("dayNamesShort", dayNamesShort);

	}

	/**
	 * Set the date to highlight on first opening if the field is blank. Specify
	 * either an actual date via a Date object or as a string in the current
	 * dateFormat, or a number of days from today (e.g. +7) or a string of
	 * values and periods ('y' for years, 'm' for months, 'w' for weeks, 'd' for
	 * days, e.g. '+1m +7d'), or null for today. Default:null
	 * 
	 * @param defaultDate
	 * @return
	 */
	public T defaultDate(CharSequence defaultDate) {
		return super.put("defaultDate", defaultDate);

	}

	/**
	 * Set the date to highlight on first opening if the field is blank. Specify
	 * either an actual date via a Date object or as a string in the current
	 * dateFormat, or a number of days from today (e.g. +7) or a string of
	 * values and periods ('y' for years, 'm' for months, 'w' for weeks, 'd' for
	 * days, e.g. '+1m +7d'), or null for today. Default:null
	 * 
	 * @param defaultDate
	 * @return
	 */
	public T defaultDate(int defaultDate) {
		return super.put("defaultDate", defaultDate);

	}

	/**
	 * Control the speed at which the datepicker appears, it may be a time in
	 * milliseconds or a string representing one of the three predefined speeds
	 * ("slow", "normal", "fast"). Default:'normal'
	 * 
	 * @param duration
	 * @return
	 */
	public T duration(CharSequence duration) {
		return super.put("duration", duration);

	}

	/**
	 * Control the speed at which the datepicker appears, it may be a time in
	 * milliseconds or a string representing one of the three predefined speeds
	 * ("slow", "normal", "fast"). Default:'normal'
	 * 
	 * @param duration
	 * @return
	 */
	public T duration(int duration) {
		return super.put("duration", duration);

	}

	/**
	 * Set the first day of the week: Sunday is 0, Monday is 1, ... This
	 * attribute is one of the regionalisation attributes. Default:0
	 * 
	 * @param firstDay
	 * @return
	 */
	public T firstDay(int firstDay) {
		return super.put("firstDay", firstDay);

	}

	/**
	 * When true the current day link moves to the currently selected date
	 * instead of today. Default:false
	 * 
	 * @param gotoCurrent
	 * @return
	 */
	public T gotoCurrent(boolean gotoCurrent) {
		return super.put("gotoCurrent", gotoCurrent);

	}

	/**
	 * Normally the previous and next links are disabled when not applicable
	 * (see minDate/maxDate). You can hide them altogether by setting this
	 * attribute to true. Default:false
	 * 
	 * @param hideIfNoPrevNext
	 * @return
	 */
	public T hideIfNoPrevNext(boolean hideIfNoPrevNext) {
		return super.put("hideIfNoPrevNext", hideIfNoPrevNext);

	}

	/**
	 * True if the current language is drawn from right to left. This attribute
	 * is one of the regionalisation attributes. Default:false
	 * 
	 * @param isRTL
	 * @return
	 */
	public T isRTL(boolean isRTL) {
		return super.put("isRTL", isRTL);

	}

	/**
	 * Set a maximum selectable date via a Date object or as a string in the
	 * current dateFormat, or a number of days from today (e.g. +7) or a string
	 * of values and periods ('y' for years, 'm' for months, 'w' for weeks, 'd'
	 * for days, e.g. '+1m +1w'), or null for no limit. Default:null
	 * 
	 * @param maxDate
	 * @return
	 */
	public T maxDate(CharSequence maxDate) {
		return super.put("maxDate", maxDate);

	}

	/**
	 * Set a maximum selectable date via a Date object or as a string in the
	 * current dateFormat, or a number of days from today (e.g. +7) or a string
	 * of values and periods ('y' for years, 'm' for months, 'w' for weeks, 'd'
	 * for days, e.g. '+1m +1w'), or null for no limit. Default:null
	 * 
	 * @param maxDate
	 * @return
	 */
	public T maxDate(int maxDate) {
		return super.put("maxDate", maxDate);

	}

	/**
	 * Set a minimum selectable date via a Date object or as a string in the
	 * current dateFormat, or a number of days from today (e.g. +7) or a string
	 * of values and periods ('y' for years, 'm' for months, 'w' for weeks, 'd'
	 * for days, e.g. '-1y -1m'), or null for no limit. Default:null
	 * 
	 * @param minDate
	 * @return
	 */
	public T minDate(CharSequence minDate) {
		return super.put("minDate", minDate);

	}

	/**
	 * Set a minimum selectable date via a Date object or as a string in the
	 * current dateFormat, or a number of days from today (e.g. +7) or a string
	 * of values and periods ('y' for years, 'm' for months, 'w' for weeks, 'd'
	 * for days, e.g. '-1y -1m'), or null for no limit. Default:null
	 * 
	 * @param minDate
	 * @return
	 */
	public T minDate(int minDate) {
		return super.put("minDate", minDate);

	}

	/**
	 * The list of full month names, for use as requested via the dateFormat
	 * setting. This attribute is one of the regionalisation attributes. <br>
	 * Default:['January', 'February', 'March', 'April', 'May', 'June', 'July',
	 * 'August', 'September', 'October', 'November', 'December']
	 * 
	 * @param monthNames
	 * @return
	 */
	public T monthNames(CharSequence... monthNames) {
		return super.put("monthNames", monthNames);

	}

	/**
	 * The list of abbreviated month names, as used in the month header on each
	 * datepicker and as requested via the dateFormat setting. This attribute is
	 * one of the regionalisation attributes. <br>
	 * Default:['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep',
	 * 'Oct', 'Nov', 'Dec']
	 * 
	 * @param monthNamesShort
	 * @return
	 */
	public T monthNamesShort(CharSequence... monthNamesShort) {
		return super.put("monthNamesShort", monthNamesShort);

	}

	/**
	 * When true the formatDate function is applied to the prevText, nextText,
	 * and currentText values before display, allowing them to display the
	 * target month names for example. Default:false
	 * 
	 * @param navigationAsDateFormat
	 * @return
	 */
	public T navigationAsDateFormat(boolean navigationAsDateFormat) {
		return super.put("navigationAsDateFormat", navigationAsDateFormat);

	}

	/**
	 * The text to display for the next month link. This attribute is one of the
	 * regionalisation attributes. With the standard ThemeRoller styling, this
	 * value is replaced by an icon. Default:'Next'
	 * 
	 * @param nextText
	 * @return
	 */
	public T nextText(CharSequence nextText) {
		return super.put("nextText", nextText);

	}

	/**
	 * Set how many months to show at once. The value can be a straight integer,
	 * or can be a two-element array to define the number of rows and columns to
	 * display. Default:1
	 * 
	 * @param numberOfMonths
	 * @return
	 */
	public T numberOfMonths(int numberOfMonths) {
		return super.put("numberOfMonths", numberOfMonths);

	}

	/**
	 * Set how many months to show at once. The value can be a straight integer,
	 * or can be a two-element array to define the number of rows and columns to
	 * display. Default:1
	 * 
	 * @param numberOfMonthRows
	 * @param numberOfMonthColumns
	 * @return
	 */
	public T numberOfMonths(int numberOfMonthRows, int numberOfMonthColumns) {
		return super.put("numberOfMonths", new int[] { numberOfMonthRows,
				numberOfMonthColumns });
	}

	/**
	 * The text to display for the previous month link. This attribute is one of
	 * the regionalisation attributes. With the standard ThemeRoller styling,
	 * this value is replaced by an icon. Default:'Prev'
	 * 
	 * @param prevText
	 * @return
	 */
	public T prevText(CharSequence prevText) {
		return super.put("prevText", prevText);
	}

	/**
	 * When true days in other months shown before or after the current month
	 * are selectable. This only applies if showOtherMonths is also true.
	 * Default:false
	 * 
	 * @param selectOtherMonths
	 * @return
	 */
	public T selectOtherMonths(boolean selectOtherMonths) {
		return super.put("selectOtherMonths", selectOtherMonths);
	}

	/**
	 * Set the cutoff year for determining the century for a date (used in
	 * conjunction with dateFormat 'y'). If a numeric value (0-99) is provided
	 * then this value is used directly. If a string value is provided then it
	 * is converted to a number and added to the current year. Once the cutoff
	 * year is calculated, any dates entered with a year value less than or
	 * equal to it are considered to be in the current century, while those
	 * greater than it are deemed to be in the previous century. Default:'+10'
	 * 
	 * @param shortYearCutoff
	 * @return
	 */
	public T shortYearCutoff(CharSequence shortYearCutoff) {
		return super.put("shortYearCutoff", shortYearCutoff);
	}

	/**
	 * Set the cutoff year for determining the century for a date (used in
	 * conjunction with dateFormat 'y'). If a numeric value (0-99) is provided
	 * then this value is used directly. If a string value is provided then it
	 * is converted to a number and added to the current year. Once the cutoff
	 * year is calculated, any dates entered with a year value less than or
	 * equal to it are considered to be in the current century, while those
	 * greater than it are deemed to be in the previous century. Default:'+10'
	 * 
	 * @param shortYearCutoff
	 * @return
	 */
	public T shortYearCutoff(int shortYearCutoff) {
		return super.put("shortYearCutoff", shortYearCutoff);
	}

	/**
	 * Set the name of the animation used to show/hide the datepicker. Use
	 * 'show' (the default), 'slideDown', 'fadeIn', any of the show/hide jQuery
	 * UI effects, or '' for no animation.Default:'show'
	 * 
	 * @param showAnim
	 * @return
	 */
	public T showAnim(CharSequence showAnim) {
		return super.put("showAnim", showAnim);
	}

	/**
	 * Whether to show the button panel. Default:false
	 * 
	 * @param showButtonPanel
	 * @return
	 */
	public T showButtonPanel(boolean showButtonPanel) {
		return super.put("showButtonPanel", showButtonPanel);
	}

	/**
	 * Specify where in a multi-month display the current month shows, starting
	 * from 0 at the top/left. Default:0
	 * 
	 * @param showCurrentAtPos
	 * @return
	 */
	public T showCurrentAtPos(int showCurrentAtPos) {
		return super.put("showCurrentAtPos", showCurrentAtPos);
	}

	/**
	 * Whether to show the month after the year in the header. This attribute is
	 * one of the regionalisation attributes. Default:false
	 * 
	 * @param showMonthAfterYear
	 * @return
	 */
	public T showMonthAfterYear(boolean showMonthAfterYear) {
		return super.put("showMonthAfterYear", showMonthAfterYear);
	}

	/**
	 * Have the datepicker appear automatically when the field receives focus
	 * ('focus'), appear only when a button is clicked ('button'), or appear
	 * when either event takes place ('both'). Default:'focus'
	 * 
	 * @param showOn
	 * @return
	 */
	public T showOn(CharSequence showOn) {
		return super.put("showOn", showOn);
	}

	/**
	 * If using one of the jQuery UI effects for showAnim, you can provide
	 * additional settings for that animation via this option. Default:{}
	 * 
	 * @param showOptions
	 * @return
	 */
	public T showOptions(CharSequence showOptions) {
		return super.put("showOptions", showOptions);
	}

	/**
	 * Display dates in other months (non-selectable) at the start or end of the
	 * current month. To make these days selectable use selectOtherMonths.
	 * Default:false
	 * 
	 * @param showOtherMonths
	 * @return
	 */
	public T showOtherMonths(boolean showOtherMonths) {
		return super.put("showOtherMonths", showOtherMonths);
	}

	/**
	 * When true a column is added to show the week of the year. The
	 * calculateWeek option determines how the week of the year is calculated.
	 * You may also want to change the firstDay option. Default:false
	 * 
	 * @param showWeek
	 * @return
	 */
	public T showWeek(boolean showWeek) {
		return super.put("showWeek", showWeek);
	}

	/**
	 * Set how many months to move when clicking the Previous/Next links.
	 * Default:1
	 * 
	 * @param stepMonths
	 * @return
	 */
	public T stepMonths(int stepMonths) {
		return super.put("stepMonths", stepMonths);
	}

	/**
	 * The text to display for the week of the year column heading. This
	 * attribute is one of the regionalisation attributes. Use showWeek to
	 * display this column. Default:'Wk'
	 * 
	 * @param weekHeader
	 * @return
	 */
	public T weekHeader(CharSequence weekHeader) {
		return super.put("weekHeader", weekHeader);
	}

	/**
	 * Control the range of years displayed in the year drop-down: either
	 * relative to today's year (-nn:+nn), relative to the currently selected
	 * year (c-nn:c+nn), absolute (nnnn:nnnn), or combinations of these formats
	 * (nnnn:-nn). Note that this option only affects what appears in the
	 * drop-down, to restrict which dates may be selected use the minDate and/or
	 * maxDate options. Default:'c-10:c+10'
	 * 
	 * @param yearRange
	 * @return
	 */
	public T yearRange(CharSequence yearRange) {
		return super.put("yearRange", yearRange);
	}

	/**
	 * Additional text to display after the year in the month headers. This
	 * attribute is one of the regionalisation attributes. Default:''
	 * 
	 * @param yearSuffix
	 * @return
	 */
	public T yearSuffix(CharSequence yearSuffix) {
		return super.put("yearSuffix", yearSuffix);
	}

	/**
	 * Can be a function that takes an input field and current datepicker
	 * instance and returns an options object to update the datepicker with. It
	 * is called just before the datepicker is displayed.
	 * 
	 * @param callbackBody
	 * @return
	 */
	public T beforeShowEvent(CharSequence callbackBody) {
		return this.beforeShowEvent(js(callbackBody));
	}

	/**
	 * Can be a function that takes an input field and current datepicker
	 * instance and returns an options object to update the datepicker with. It
	 * is called just before the datepicker is displayed.
	 * 
	 * @param callbackBody
	 * @return
	 */
	public T beforeShowEvent(IJQStatement callbackBody) {
		return this.beforeShowEvent($f(callbackBody).withParams("input", "inst"));
	}

	/**
	 * Can be a function that takes an input field and current datepicker
	 * instance and returns an options object to update the datepicker with. It
	 * is called just before the datepicker is displayed.
	 * 
	 * @param callback
	 * @return
	 */
	public T beforeShowEvent(IJQFunction callback) {
		return super.put("beforeShow", callback);
	}

	/**
	 * The function takes a date as a parameter and must return an array with
	 * [0] equal to true/false indicating whether or not this date is
	 * selectable, [1] equal to a CSS class name(s) or '' for the default
	 * presentation, and [2] an optional popup tooltip for this date. It is
	 * called for each day in the datepicker before it is displayed.
	 * 
	 * @param callbackBody
	 * @return
	 */
	public T beforeShowDayEvent(CharSequence callbackBody) {
		return this.beforeShowDayEvent(js(callbackBody));
	}

	/**
	 * The function takes a date as a parameter and must return an array with
	 * [0] equal to true/false indicating whether or not this date is
	 * selectable, [1] equal to a CSS class name(s) or '' for the default
	 * presentation, and [2] an optional popup tooltip for this date. It is
	 * called for each day in the datepicker before it is displayed.
	 * 
	 * @param callbackBody
	 * @return
	 */
	public T beforeShowDayEvent(IJQStatement callbackBody) {
		return this.beforeShowDayEvent($f(callbackBody).withParams("date"));
	}

	/**
	 * The function takes a date as a parameter and must return an array with
	 * [0] equal to true/false indicating whether or not this date is
	 * selectable, [1] equal to a CSS class name(s) or '' for the default
	 * presentation, and [2] an optional popup tooltip for this date. It is
	 * called for each day in the datepicker before it is displayed.
	 * 
	 * @param callback
	 * @return
	 */
	public T beforeShowDayEvent(IJQFunction callback) {
		return super.put("beforeShowDay", callback);

	}

	/**
	 * Allows you to define your own event when the datepicker moves to a new
	 * month and/or year. The function receives the selected year, month (1-12),
	 * and the datepicker instance as parameters. this refers to the associated
	 * input field.
	 * 
	 * @param callbackBody
	 * @return
	 */
	public T onChangeMonthYearEvent(CharSequence callbackBody) {
		return this.onChangeMonthYearEvent(js(callbackBody));
	}

	/**
	 * Allows you to define your own event when the datepicker moves to a new
	 * month and/or year. The function receives the selected year, month (1-12),
	 * and the datepicker instance as parameters. this refers to the associated
	 * input field.
	 * 
	 * @param callbackBody
	 * @return
	 */
	public T onChangeMonthYearEvent(IJQStatement callbackBody) {
		return this.onChangeMonthYearEvent($f(callbackBody).withParams("year",
				"month", "inst"));
	}

	/**
	 * Allows you to define your own event when the datepicker moves to a new
	 * month and/or year. The function receives the selected year, month (1-12),
	 * and the datepicker instance as parameters. this refers to the associated
	 * input field.
	 * 
	 * @param callback
	 * @return
	 */
	public T onChangeMonthYearEvent(IJQFunction callback) {
		return super.put("onChangeMonthYear", callback);
	}

	/**
	 * Allows you to define your own event when the datepicker is closed,
	 * whether or not a date is selected. The function receives the selected
	 * date as text ('' if none) and the datepicker instance as parameters. this
	 * refers to the associated input field.
	 * 
	 * @param callbackBody
	 * @return
	 */
	public T onCloseEvent(CharSequence callbackBody) {
		return this.onCloseEvent(js(callbackBody));
	}

	/**
	 * Allows you to define your own event when the datepicker is closed,
	 * whether or not a date is selected. The function receives the selected
	 * date as text ('' if none) and the datepicker instance as parameters. this
	 * refers to the associated input field.
	 * 
	 * @param callbackBody
	 * @return
	 */
	public T onCloseEvent(IJQStatement callbackBody) {
		return this.onCloseEvent($f(callbackBody).withParams("dateText", "inst"));
	}

	/**
	 * Allows you to define your own event when the datepicker is closed,
	 * whether or not a date is selected. The function receives the selected
	 * date as text ('' if none) and the datepicker instance as parameters. this
	 * refers to the associated input field.
	 * 
	 * @param callback
	 * @return
	 */
	public T onCloseEvent(IJQFunction callback) {
		return super.put("onClose", callback);

	}

	/**
	 * Allows you to define your own event when the datepicker is selected. The
	 * function receives the selected date as text and the datepicker instance
	 * as parameters. this refers to the associated input field.
	 * 
	 * @param callbackBody
	 * @return
	 */
	public T onSelectEvent(CharSequence callbackBody) {
		return this.onSelectEvent(js(callbackBody));
	}

	/**
	 * Allows you to define your own event when the datepicker is selected. The
	 * function receives the selected date as text and the datepicker instance
	 * as parameters. this refers to the associated input field.
	 * 
	 * @param callbackBody
	 * @return
	 */
	public T onSelectEvent(IJQStatement callbackBody) {
		return this
				.onSelectEvent($f(callbackBody).withParams("dateText", "inst"));
	}

	/**
	 * Allows you to define your own event when the datepicker is selected. The
	 * function receives the selected date as text and the datepicker instance
	 * as parameters. this refers to the associated input field.
	 * 
	 * @param callback
	 * @return
	 */
	public T onSelectEvent(IJQFunction callback) {
		return super.put("onSelect", callback);
	}
}
