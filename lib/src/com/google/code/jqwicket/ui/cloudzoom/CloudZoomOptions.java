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
package com.google.code.jqwicket.ui.cloudzoom;


import com.google.code.jqwicket.api.AbstractJQOptions;
import org.apache.wicket.request.resource.CssResourceReference;
import org.apache.wicket.request.resource.JavaScriptResourceReference;

/**
 * @author mkalina
 */
public class CloudZoomOptions extends AbstractJQOptions<CloudZoomOptions> {

    private static final long serialVersionUID = 1L;

    public static final JavaScriptResourceReference JS_RESOURCE = new JavaScriptResourceReference(
            CloudZoomOptions.class, "cloud-zoom.1.0.2.js");

    public static final JavaScriptResourceReference JS_RESOURCE_MIN = new JavaScriptResourceReference(
            CloudZoomOptions.class, "cloud-zoom.1.0.2.min.js");

    public static final CssResourceReference CSS_RESOURCE = new CssResourceReference(
            CloudZoomOptions.class, "cloud-zoom.css");

    private CloudZoomImage image;

    private CloudZoomGalleryImage[] galleryImages;

    public CloudZoomOptions(CloudZoomImage image,
                            CloudZoomGalleryImage... galleryImages) {
        this.setJsResourceReferences(JS_RESOURCE);
        this.setJsResourceReferencesMin(JS_RESOURCE_MIN);
        this.setCssResourceReferences(CSS_RESOURCE);
        this.image = image;
        this.galleryImages = galleryImages;
    }

    public CloudZoomImage getImage() {
        return image;
    }

    public CloudZoomGalleryImage[] getGalleryImages() {
        return this.galleryImages;
    }

    public boolean hasGalleryImages() {
        return this.galleryImages != null && this.galleryImages.length > 0;
    }

    /**
     * The width of the zoom window in pixels. If 'auto' is specified, the width will be the same as the small image.<br>
     * Default: 'auto'
     *
     * @param zoomWidth
     * @return
     */
    public CloudZoomOptions zoomWidth(CharSequence zoomWidth) {
        return super.put("zoomWidth", zoomWidth);
    }

    /**
     * The height of the zoom window in pixels. If 'auto' is specified, the height will be the same as the small image.<br>
     * Default: 'auto'
     *
     * @param zoomHeight
     * @return
     */
    public CloudZoomOptions zoomHeight(CharSequence zoomHeight) {
        return super.put("zoomHeight", zoomHeight);
    }

    /**
     * Specifies the position of the zoom window relative to the small image. Allowable values are 'left', 'right', 'top',
     * 'bottom', 'inside' or you can specifiy the id of an html element to place the zoom window in e.g. position:
     * 'element1'<br> Default: 'right'
     *
     * @param position
     * @return
     */
    public CloudZoomOptions position(CharSequence position) {
        return super.put("position", position);
    }

    /**
     * Allows you to fine tune the x-position of the zoom window in pixels.<br> Default: 0
     *
     * @param adjustX
     * @return
     */
    public CloudZoomOptions adjustX(int adjustX) {
        return super.put("adjustX", adjustX);
    }

    /**
     * Allows you to fine tune the y-position of the zoom window in pixels.<br> Default: 0
     *
     * @param adjustY
     * @return
     */
    public CloudZoomOptions adjustY(int adjustY) {
        return super.put("adjustY", adjustY);
    }

    /**
     * Specifies a tint colour which will cover the small image. Colours should be specified in hex format, e.g. '#aa00aa'.
     * Does not work with softFocus.
     *
     * @param tint
     * @return
     */
    public CloudZoomOptions tint(CharSequence tint) {
        return super.put("tint", tint);
    }

    /**
     * Opacity of the tint, where 0 is fully transparent, and 1 is fully opaque.<br> Default: 0.5
     *
     * @param tintOpacity
     * @return
     */
    public CloudZoomOptions tintOpacity(float tintOpacity) {
        return super.put("tintOpacity", tintOpacity);
    }

    /**
     * Opacity of the lens mouse pointer, where 0 is fully transparent, and 1 is fully opaque. In tint and soft-focus
     * modes, it will always be transparent.<br> Default: 0.5
     *
     * @param lensOpacity
     * @return
     */
    public CloudZoomOptions lensOpacity(float lensOpacity) {
        return super.put("lensOpacity", lensOpacity);
    }

    /**
     * Applies a subtle blur effect to the small image. Set to true or false. Does not work with tint.<br> Default: false
     *
     * @param softFocus
     * @return
     */
    public CloudZoomOptions softFocus(boolean softFocus) {
        return super.put("softFocus", softFocus);
    }

    /**
     * Amount of smoothness/drift of the zoom image as it moves. The higher the number, the smoother/more drifty the
     * movement will be. 1 = no smoothing.<br> Default: 3
     *
     * @param smoothMove
     * @return
     */
    public CloudZoomOptions smoothMove(int smoothMove) {
        return super.put("smoothMove", smoothMove);
    }

    /**
     * Shows the title tag of the image. True or false.<br> Default: true
     *
     * @param showTitle
     * @return
     */
    public CloudZoomOptions showTitle(boolean showTitle) {
        return super.put("showTitle", showTitle);
    }

    /**
     * Specifies the opacity of the title if displayed, where 0 is fully transparent, and 1 is fully opaque.<br> Default:
     * 0.5
     *
     * @param titleOpacity
     * @return
     */
    public CloudZoomOptions titleOpacity(float titleOpacity) {
        return super.put("titleOpacity", titleOpacity);
    }

}
