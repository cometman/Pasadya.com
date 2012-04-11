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
package com.google.code.jqwicket.ui.sparkline;

import com.google.code.jqwicket.Utils;
import com.google.code.jqwicket.api.AbstractJQOptions;
import com.google.code.jqwicket.api.JQLiteral;
import org.apache.wicket.request.resource.JavaScriptResourceReference;

/**
 * @author mkalina
 */
public class SparklineOptions extends AbstractJQOptions<SparklineOptions> {

    private static final long serialVersionUID = 1L;

    public static final JavaScriptResourceReference JS_RESOURCE = new JavaScriptResourceReference(
            SparklineOptions.class, "jquery.sparkline-1.6.js");

    public static final JavaScriptResourceReference JS_RESOURCE_MIN = new JavaScriptResourceReference(
            SparklineOptions.class, "jquery.sparkline-1.6.min.js");

    public enum Type {
        LINE, BAR, TRISTATE, DISCRETE, BULLET, PIE, BOX;

    }

    private float[] values;

    public SparklineOptions() {
        this(null);
    }

    public SparklineOptions(float[] values) {
        this.setJsResourceReferences(JS_RESOURCE);
        this.setJsResourceReferencesMin(JS_RESOURCE_MIN);
        this.values = values;
    }

    public float[] getValues() {
        return values;
    }

    public boolean hasValues() {
        return values != null && values.length > 0;
    }

    /**
     * line (default), bar, tristate, discrete, bullet, pie or box
     *
     * @param type
     * @return
     */
    public SparklineOptions type(Type type) {
        return super.put("type", type.name().toLowerCase());
    }

    /**
     * Width of the chart - Defaults to 'auto' - May be any valid css width - 1.5em, 20px, etc (using a number without a
     * unit specifier won't do what you want) - This option does nothing for bar and tristate chars (see barWidth)
     *
     * @param width
     * @return
     */
    public SparklineOptions width(CharSequence width) {
        return super.put("width", width);
    }

    /**
     * Height of the chart - Defaults to 'auto' (line height of the containing tag)
     *
     * @param height
     * @return
     */
    public SparklineOptions height(CharSequence height) {
        return super.put("height", height);
    }

    /**
     * Used by line and discrete charts
     *
     * @param lineColor
     * @return
     */
    public SparklineOptions lineColor(CharSequence lineColor) {
        return super.put("lineColor", lineColor);
    }

    /**
     * Set to false to disable fill.
     *
     * @param fillColor
     * @return
     */
    public SparklineOptions fillColor(boolean fillColor) {
        return super.put("fillColor", fillColor);
    }

    /**
     * Specify the minimum value to use for the range of the chart - Defaults to the minimum value supplied
     *
     * @param chartRangeMin
     * @return
     */
    public SparklineOptions chartRangeMin(float chartRangeMin) {
        return super.put("chartRangeMin", chartRangeMin);
    }

    /**
     * Specify the maximum value to use for the range of the chart - Defaults to the maximum value supplied
     *
     * @param chartRangeMax
     * @return
     */
    public SparklineOptions chartRangeMax(float chartRangeMax) {
        return super.put("chartRangeMax", chartRangeMax);
    }

    /**
     * If true then don't erase any existing chart attached to the tag, but draw another chart over the top - Note that
     * width and height are ignored if an existing chart is detected.
     *
     * @param composite
     * @return
     */
    public SparklineOptions composite(boolean composite) {
        return super.put("composite", composite);
    }

    /**
     * If true then options can be specified as attributes on each tag to be transformed into a sparkline, as well as
     * passed to the sparkline() function. See also tagOptionPrefix
     *
     * @param enableTagOptions
     * @return
     */
    public SparklineOptions enableTagOptions(boolean enableTagOptions) {
        return super.put("enableTagOptions", enableTagOptions);
    }

    /**
     * String that each option passed as an attribute on a tag must begin with. Defaults to 'spark'
     *
     * @param tagOptionPrefix
     * @return
     */
    public SparklineOptions tagOptionPrefix(CharSequence tagOptionPrefix) {
        return super.put("tagOptionPrefix", tagOptionPrefix);
    }

    /**
     * The name of the tag attribute to fetch values from, if present - Defaults to 'values'
     *
     * @param tagValuesAttribute
     * @return
     */
    public SparklineOptions tagValuesAttribute(CharSequence tagValuesAttribute) {
        return super.put("tagValuesAttribute", tagValuesAttribute);
    }

    /**
     * Line Chart Option<br> Defaults to 3 pixels of width for each value in the chart
     *
     * @param defaultPixelsPerValue
     * @return
     */
    public SparklineOptions defaultPixelsPerValue(int defaultPixelsPerValue) {
        return super.put("defaultPixelsPerValue", defaultPixelsPerValue);
    }

    /**
     * Line Chart Option<br> Set to false to hide the final value marker
     *
     * @param spotColor
     * @return
     */
    public SparklineOptions spotColor(boolean spotColor) {
        return super.put("spotColor", spotColor);
    }

    /**
     * Line Chart Option<br> Set to false to hide the minimum value marker
     *
     * @param minSpotColor
     * @return
     */
    public SparklineOptions minSpotColor(boolean minSpotColor) {
        return super.put("minSpotColor", minSpotColor);
    }

    /**
     * Line Chart Option<br> Set to false to hide the maximum value marker
     *
     * @param maxSpotColor
     * @return
     */
    public SparklineOptions maxSpotColor(boolean maxSpotColor) {
        return super.put("maxSpotColor", maxSpotColor);
    }

    /**
     * Line Chart Option<br> Box Plot Option<br> In pixels (default: 1.5)
     *
     * @param spotRadius
     * @return
     */
    public SparklineOptions spotRadius(float spotRadius) {
        return super.put("spotRadius", spotRadius);
    }

    /**
     * Line Chart Option<br> In pixels (default: 1)
     *
     * @param lineWidth
     * @return
     */
    public SparklineOptions lineWidth(float lineWidth) {
        return super.put("lineWidth", lineWidth);
    }

    /**
     * Line Chart Option<br> Specify threshold values between which to draw a bar to denote the "normal" or expected
     * range of values.
     *
     * @param normalRangeMin
     * @return
     */
    public SparklineOptions normalRangeMin(float normalRangeMin) {
        return super.put("normalRangeMin", normalRangeMin);
    }

    /**
     * Line Chart Option<br> Specify threshold values between which to draw a bar to denote the "normal" or expected
     * range of values.
     *
     * @param normalRangeMax
     * @return
     */
    public SparklineOptions normalRangeMax(float normalRangeMax) {
        return super.put("normalRangeMax", normalRangeMax);
    }

    /**
     * Line Chart Option<br> Explicitly specify x-axis values
     *
     * @param xvalues
     * @return
     */
    public SparklineOptions xvalues(float[] xvalues) {
        return super.put("xvalues", xvalues);
    }

    /**
     * Line Chart Option<br> If true then the y values supplied to plot will be clipped to fall between chartRangeMin
     * and chartRangeMax - By default chartRangeMin/Max just ensure that the chart spans at least that range of values,
     * but does not constrain it
     *
     * @param chartRangeClip
     * @return
     */
    public SparklineOptions chartRangeClip(boolean chartRangeClip) {
        return super.put("chartRangeClip", chartRangeClip);
    }

    /**
     * Line Chart Option<br> Specifies the minimum value to use for the X value of the charge
     *
     * @param chartRangeMinX
     * @return
     */
    public SparklineOptions chartRangeMinX(float chartRangeMinX) {
        return super.put("chartRangeMinX", chartRangeMinX);
    }

    /**
     * Line Chart Option<br> Specifies the maximum value to use for the X value of the charge
     *
     * @param chartRangeMaxX
     * @return
     */
    public SparklineOptions chartRangeMaxX(float chartRangeMaxX) {
        return super.put("chartRangeMaxX", chartRangeMaxX);
    }

    /**
     * Bar Chart Option<br> Colour used for postive values
     *
     * @param barColor
     * @return
     */
    public SparklineOptions barColor(CharSequence barColor) {
        return super.put("barColor", barColor);
    }

    /**
     * Bar Chart Option<br> Tristate Chart Option<br> Colour used for negative values
     *
     * @param negBarColor
     * @return
     */
    public SparklineOptions negBarColor(CharSequence negBarColor) {
        return super.put("negBarColor", negBarColor);
    }

    /**
     * Bar Chart Option<br> Tristate Chart Option<br> Colour used for values equal to zero
     *
     * @param zeroColor
     * @return
     */
    public SparklineOptions zeroColor(CharSequence zeroColor) {
        return super.put("zeroColor", zeroColor);
    }

    /**
     * Bar Chart Option<br> Colour used for values equal to null - By default null values are omitted entirely, but
     * setting this adds a thin marker for the entry - This can be useful if your chart is pretty sparse; perhaps try
     * setting it to a light grey or something equally unobtrusive
     *
     * @param nullColor
     * @return
     */
    public SparklineOptions nullColor(CharSequence nullColor) {
        return super.put("nullColor", nullColor);
    }

    /**
     * Bar Chart Option<br> Tristate Chart Option<br> Width of each bar, in pixels
     *
     * @param barWidth
     * @return
     */
    public SparklineOptions barWidth(int barWidth) {
        return super.put("barWidth", barWidth);
    }

    /**
     * Bar Chart Option<br> Tristate Chart Option<br> Space between each bar, in pixels
     *
     * @param barSpacing
     * @return
     */
    public SparklineOptions barSpacing(int barSpacing) {
        return super.put("barSpacing", barSpacing);
    }

    /**
     * Bar Chart Option<br> Tristate Chart Option<br> Centers the y-axis at zero if true (default is to automatically do
     * the right thing)
     *
     * @param zeroAxis
     * @return
     */
    public SparklineOptions zeroAxis(boolean zeroAxis) {
        return super.put("zeroAxis", zeroAxis);
    }

    /**
     * Bar Chart Option<br> Tristate Chart Option<br> Map override colors to certain values - For example if you want
     * all values of -2 to appear yellow, use colorMap: { '-2': '#ff0' }. As of version 1.5 you may also pass an Array
     * of values here instead of a mapping to specifiy a color for each individual bar. For example if your chart has
     * three values 1,3,1 you can set colorMap=["red", "green", "blue"]
     *
     * @param colorMap
     * @return
     */
    public SparklineOptions colorMap(CharSequence colorMap) {
        return super.put("colorMap", JQLiteral._raw(colorMap));
    }

    /**
     * Bar Chart Option<br> Tristate Chart Option<br> Map override colors to certain values - For example if you want
     * all values of -2 to appear yellow, use colorMap: { '-2': '#ff0' }. As of version 1.5 you may also pass an Array
     * of values here instead of a mapping to specifiy a color for each individual bar. For example if your chart has
     * three values 1,3,1 you can set colorMap=["red", "green", "blue"]
     *
     * @param colorMap
     * @return
     */
    public SparklineOptions colorMap(String[] colorMap) {
        return super.put("colorMap", JQLiteral._raw(Utils.toJson(colorMap)));
    }

    /**
     * Tristate Chart Option<br> Colour for positive (win) values
     *
     * @param posBarColor
     * @return
     */
    public SparklineOptions posBarColor(CharSequence posBarColor) {
        return super.put("posBarColor", posBarColor);
    }

    /**
     * Tristate Chart Option<br> Colour for zero (draw) values
     *
     * @param zeroBarColor
     * @return
     */
    public SparklineOptions zeroBarColor(CharSequence zeroBarColor) {
        return super.put("zeroBarColor", zeroBarColor);
    }

    /**
     * Discrete Chart Option<br> Height of each line in pixels - Defaults to 30% of the graph height
     *
     * @param lineHeight
     * @return
     */
    public SparklineOptions lineHeight(int lineHeight) {
        return super.put("lineHeight", lineHeight);
    }

    /**
     * Discrete Chart Option<br> Values less than this value will be drawn using thresholdColor instead of lineColor
     *
     * @param thesholdValue
     * @return
     */
    public SparklineOptions thesholdValue(int thesholdValue) {
        return super.put("thesholdValue", thesholdValue);
    }

    /**
     * Discrete Chart Option<br>
     *
     * @param thresholdColor
     * @return
     */
    public SparklineOptions thresholdColor(CharSequence thresholdColor) {
        return super.put("thresholdColor", thresholdColor);
    }

    /**
     * Bullet Graph Option<br> Box Plot Option<br> The colour of the vertical target marker
     *
     * @param targetColor
     * @return
     */
    public SparklineOptions targetColor(CharSequence targetColor) {
        return super.put("targetColor", targetColor);
    }

    /**
     * Bullet Graph Option<br> The width of the target marker in pixels
     *
     * @param targetWidth
     * @return
     */
    public SparklineOptions targetWidth(int targetWidth) {
        return super.put("targetWidth", targetWidth);
    }

    /**
     * Bullet Graph Option<br> The color of the performance measure horizontal bar
     *
     * @param performanceColor
     * @return
     */
    public SparklineOptions performanceColor(CharSequence performanceColor) {
        return super.put("performanceColor", performanceColor);
    }

    /**
     * Bullet Graph Option<br> Colors to use for each qualitative range background color - This must be a javascript
     * array. eg ['red','green', '#22f']
     *
     * @param rangeColors
     * @return
     */
    public SparklineOptions rangeColors(String[] rangeColors) {
        return super.put("rangeColors", rangeColors);
    }

    /**
     * Pie Chart Option<br> An array of colors to use for pie slices
     *
     * @param sliceColors
     * @return
     */
    public SparklineOptions sliceColors(String[] sliceColors) {
        return super.put("sliceColors", sliceColors);
    }

    /**
     * Pie Chart Option<br> Angle in degrees to offset the first slice - Try -90 or +90
     *
     * @param offset
     * @return
     */
    public SparklineOptions offset(CharSequence offset) {
        return super.put("offset", offset);
    }

    /**
     * Box Plot Option<br> f set to false (default) then the values supplied are used to caculate the box data points
     * for you. If true then you must pre-calculate the points (see below)
     *
     * @param raw
     * @return
     */
    public SparklineOptions raw(boolean raw) {
        return super.put("raw", raw);
    }

    /**
     * Box Plot Option<br> If true (default) then outliers (values > 1.5x the IQR) are marked with circles and the
     * whiskers are placed at Q1 and Q3 instead of the least and greatest value
     *
     * @param showOutliers
     * @return
     */
    public SparklineOptions showOutliers(boolean showOutliers) {
        return super.put("showOutliers", showOutliers);
    }

    /**
     * Box Plot Option<br> Set the inter-quartile range multipler used to calculate values that qualify as an outlier -
     * Defaults to 1.5x
     *
     * @param outlierIQR
     * @return
     */
    public SparklineOptions outlierIQR(CharSequence outlierIQR) {
        return super.put("outlierIQR", outlierIQR);
    }

    /**
     * Box Plot Option<br> Line colour used to outline the box
     *
     * @param boxLineColor
     * @return
     */
    public SparklineOptions boxLineColor(CharSequence boxLineColor) {
        return super.put("boxLineColor", boxLineColor);
    }

    /**
     * Box Plot Option<br> Fill colour used for the box
     *
     * @param boxFillColor
     * @return
     */
    public SparklineOptions boxFillColor(CharSequence boxFillColor) {
        return super.put("boxFillColor", boxFillColor);
    }

    /**
     * Box Plot Option<br> Colour used to draw the whiskers
     *
     * @param whiskerColor
     * @return
     */
    public SparklineOptions whiskerColor(CharSequence whiskerColor) {
        return super.put("whiskerColor", whiskerColor);
    }

    /**
     * Box Plot Option<br> Colour used to draw the outlier circles
     *
     * @param outlierLineColor
     * @return
     */
    public SparklineOptions outlierLineColor(CharSequence outlierLineColor) {
        return super.put("outlierLineColor", outlierLineColor);
    }

    /**
     * Box Plot Option<br> Colour used to fill the outlier circles
     *
     * @param outlierFillColor
     * @return
     */
    public SparklineOptions outlierFillColor(CharSequence outlierFillColor) {
        return super.put("outlierFillColor", outlierFillColor);
    }

    /**
     * Box Plot Option<br> Colour used to draw the median line
     *
     * @param medianColor
     * @return
     */
    public SparklineOptions medianColor(CharSequence medianColor) {
        return super.put("medianColor", medianColor);
    }

    /**
     * Box Plot Option<br> If set to a value, then a small crosshair is drawn at that point to represent a target value
     *
     * @param target
     * @return
     */
    public SparklineOptions target(CharSequence target) {
        return super.put("target", target);
    }

    /**
     * Box Plot Option<br> If minvalue and maxvalue are set then the scale of the plot is fixed. By default minValue and
     * maxValue are deduced from the values supplied
     *
     * @param minValue
     * @return
     */
    public SparklineOptions minValue(float minValue) {
        return super.put("minValue", minValue);
    }

    /**
     * Box Plot Option<br> If minvalue and maxvalue are set then the scale of the plot is fixed. By default minValue and
     * maxValue are deduced from the values supplied
     *
     * @param maxValue
     * @return
     */
    public SparklineOptions maxValue(float maxValue) {
        return super.put("maxValue", maxValue);
    }
}
