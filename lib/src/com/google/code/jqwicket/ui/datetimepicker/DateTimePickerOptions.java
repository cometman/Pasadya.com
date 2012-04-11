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
package com.google.code.jqwicket.ui.datetimepicker;


import com.google.code.jqwicket.ui.datepicker.AbstractDatePickerOptions;
import org.apache.wicket.request.resource.CssResourceReference;
import org.apache.wicket.request.resource.JavaScriptResourceReference;

/**
 * @author mkalina
 */
public class DateTimePickerOptions extends
        AbstractDatePickerOptions<DateTimePickerOptions> {

    private static final long serialVersionUID = 1L;

    private static final JavaScriptResourceReference jsResource = new JavaScriptResourceReference(
            DateTimePickerOptions.class, "jquery-ui-timepicker-addon-0.9.6.js");

    private static final CssResourceReference cssResource = new CssResourceReference(
            DateTimePickerOptions.class, "jquery-ui-timepicker-addon-0.9.6.css");

    public DateTimePickerOptions() {
        this.setJsResourceReferences(jsResource);
        this.setCssResourceReferences(cssResource);
    }

    public DateTimePickerOptions ampm(boolean ampm) {
        return super.put("ampm", ampm);
    }

    /**
     * Change the format (default is "hh:mm tt")
     * <p/>
     * h - Hour with no leading 0<br/> hh - Hour with leading 0<br/> m - Minute with no leading 0<br/> mm - Minute with
     * leading 0<br/> s - Second with no leading 0<br/> ss - Second with leading 0<br/> t - a or p for AM/PM tt<br/> A - or
     * P for AM/PM<br/> T - am or pm for AM/PM<br/> TT - AM or PM for AM/PM
     *
     * @param timeFormat
     * @return
     */
    public DateTimePickerOptions timeFormat(CharSequence timeFormat) {
        return super.put("timeFormat", timeFormat);
    }

    /**
     * Place holder between date and time, default=" "
     *
     * @param separator
     * @return
     */
    public DateTimePickerOptions separator(CharSequence separator) {
        return super.put("separator", separator);
    }

    /**
     * Show the hour, default=true
     *
     * @param showHour
     * @return
     */
    public DateTimePickerOptions showHour(boolean showHour) {
        return super.put("showHour", showHour);
    }

    /**
     * Show the minute, default=true
     *
     * @param showMinute
     * @return
     */
    public DateTimePickerOptions showMinute(boolean showMinute) {
        return super.put("showMinute", showMinute);
    }

    /**
     * Show the second, default=false
     *
     * @param showSecond
     * @return
     */
    public DateTimePickerOptions showSecond(boolean showSecond) {
        return super.put("showSecond", showSecond);
    }

    /**
     * hour steps, default=1
     *
     * @param stepHour
     * @return
     */
    public DateTimePickerOptions stepHour(int stepHour) {
        return super.put("stepHour", stepHour);
    }

    /**
     * minute steps, default=1
     *
     * @param stepMinute
     * @return
     */
    public DateTimePickerOptions stepMinute(int stepMinute) {
        return super.put("stepMinute", stepMinute);
    }

    /**
     * second steps, default=1
     *
     * @param stepSecond
     * @return
     */
    public DateTimePickerOptions stepSecond(int stepSecond) {
        return super.put("stepSecond", stepSecond);
    }

    /**
     * Default hour. default=0
     *
     * @param hour
     * @return
     */
    public DateTimePickerOptions hour(int hour) {
        return super.put("hour", hour);
    }

    /**
     * Default minute. default=0
     *
     * @param minute
     * @return
     */
    public DateTimePickerOptions minute(int minute) {
        return super.put("minute", minute);
    }

    /**
     * Default second. default=0
     *
     * @param second
     * @return
     */
    public DateTimePickerOptions second(int second) {
        return super.put("second", second);
    }

    /**
     * Set the time range. For instance if you only want to allow the user to choose times between 8AM and 5PM.<br/>
     * default=0
     *
     * @param hourMin
     * @return
     */
    public DateTimePickerOptions hourMin(int hourMin) {
        return super.put("hourMin", hourMin);
    }

    /**
     * Set the time range. For instance if you only want to allow the user to choose times between 8AM and 5PM.<br/>
     * default=23
     *
     * @param hourMax
     * @return
     */
    public DateTimePickerOptions hourMax(int hourMax) {
        return super.put("hourMax", hourMax);
    }

    /**
     * Set the time range. For instance if you only want to allow the user to choose times between 8AM and 5PM.<br/>
     * default=0
     *
     * @param minuteMin
     * @return
     */
    public DateTimePickerOptions minuteMin(int minuteMin) {
        return super.put("minuteMin", minuteMin);
    }

    /**
     * Set the time range. For instance if you only want to allow the user to choose times between 8AM and 5PM.<br/>
     * default=59
     *
     * @param minuteMax
     * @return
     */
    public DateTimePickerOptions minuteMax(int minuteMax) {
        return super.put("minuteMax", minuteMax);
    }

    /**
     * Set the time range. For instance if you only want to allow the user to choose times between 8AM and 5PM.<br/>
     * default=0
     *
     * @param secondMin
     * @return
     */
    public DateTimePickerOptions secondMin(int secondMin) {
        return super.put("secondMin", secondMin);
    }

    /**
     * Set the time range. For instance if you only want to allow the user to choose times between 8AM and 5PM.<br/>
     * default=59
     *
     * @param secondMax
     * @return
     */
    public DateTimePickerOptions secondMax(int secondMax) {
        return super.put("secondMax", secondMax);
    }

    /**
     * Default="Choose Time"
     *
     * @param timeOnlyTitle
     * @return
     */
    public DateTimePickerOptions timeOnlyTitle(CharSequence timeOnlyTitle) {
        return super.put("timeOnlyTitle", timeOnlyTitle);
    }

    /**
     * default="Time"
     *
     * @param timeText
     * @return
     */
    public DateTimePickerOptions timeText(CharSequence timeText) {
        return super.put("timeText", timeText);
    }

    /**
     * default="Hour"
     *
     * @param hourText
     * @return
     */
    public DateTimePickerOptions hourText(CharSequence hourText) {
        return super.put("hourText", hourText);
    }

    /**
     * default="Minute"
     *
     * @param minuteText
     * @return
     */
    public DateTimePickerOptions minuteText(CharSequence minuteText) {
        return super.put("minuteText", minuteText);
    }

    /**
     * default="Second"
     *
     * @param secondText
     * @return
     */
    public DateTimePickerOptions secondText(CharSequence secondText) {
        return super.put("secondText", secondText);
    }

    /**
     * To show numbered grids under the sliders you may use the following option<br/> default=0
     *
     * @param hourGrid
     * @return
     */
    public DateTimePickerOptions hourGrid(int hourGrid) {
        return super.put("hourGrid", hourGrid);
    }

    /**
     * To show numbered grids under the sliders you may use the following option<br/> default=0
     *
     * @param minuteGrid
     * @return
     */
    public DateTimePickerOptions minuteGrid(int minuteGrid) {
        return super.put("minuteGrid", minuteGrid);
    }

    /**
     * To show numbered grids under the sliders you may use the following option<br/> default=0
     *
     * @param secondGrid
     * @return
     */
    public DateTimePickerOptions secondGrid(int secondGrid) {
        return super.put("secondGrid", secondGrid);
    }
}
