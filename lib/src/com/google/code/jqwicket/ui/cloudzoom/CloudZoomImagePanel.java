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

import com.google.code.jqwicket.Utils;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.image.Image;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author mkalina
 * 
 */
public class CloudZoomImagePanel extends Panel {

	private static final long serialVersionUID = 1L;

	public CloudZoomImagePanel(String id, CloudZoomImage image,
			CloudZoomGalleryImage... galleryImages) {
		this(id, new CloudZoomOptions(image, galleryImages));
	}

	@SuppressWarnings("unchecked")
	public CloudZoomImagePanel(String id, final CloudZoomOptions options) {
		super(id);

		add(new CloudZoomBehavior(options));

		// add default zoom image
		final CloudZoomImage img = options.getImage();
		final WebMarkupContainer bigImage = this.newCloudZoomLink(
				"cloudZoom-bigImage", img, getDefaultCssClass(),
				Utils.substringBetween(String.valueOf(options), "{", "}"));
		bigImage.add(this.newCloudZoomImage("cloudZoom-smallImage",
				img.getSmallImageUrl(), img.getImageAlt(), img.getImageTitle()));
		add(bigImage);

		// add gallery images
		add(new ListView<CloudZoomGalleryImage>("gallery-repeater",
				options.hasGalleryImages() ? Arrays.asList(options
						.getGalleryImages()) : Collections.EMPTY_LIST) {

			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(ListItem<CloudZoomGalleryImage> item) {
				final CloudZoomGalleryImage img = item.getModelObject();

				WebMarkupContainer link = newCloudZoomLink(
						"thumbnail-bigImage",
						img,
						getGalleryCssClass(),
						new StringBuffer().append("useZoom: ")
								.append(Utils.quote(bigImage.getMarkupId()))
								.append(", smallImage:")
								.append(Utils.quote(img.getSmallImageUrl())));

				link.add(newCloudZoomImage(
						"thumbnail-smallImage",
						img.hasThumbnailUrl() ? img.getThumbnailUrl() : img
								.getSmallImageUrl(), null, null));

				item.add(link);

			}

			@Override
			public boolean isVisible() {
				return options.hasGalleryImages();
			}
		});
	}

	protected WebMarkupContainer newCloudZoomLink(final String id,
			final CloudZoomImage img, final CharSequence cssClass,
			final CharSequence rel) {

		final WebMarkupContainer link = new WebMarkupContainer(id) {
			private static final long serialVersionUID = 1L;

			@Override
			protected void onComponentTag(ComponentTag tag) {
				super.onComponentTag(tag);
				tag.put("class", cssClass);
				tag.put("href", img.getBigImageUrl());
				tag.put("rel", rel);
			}
		};
		link.setOutputMarkupId(true);
		return link;
	}

	protected Image newCloudZoomImage(final String id, final CharSequence url,
			final CharSequence alt, final CharSequence title) {
		return new Image(id) {
			private static final long serialVersionUID = 1L;

			@Override
			protected void onComponentTag(ComponentTag tag) {
				tag.put("src", url);
				if (alt != null)
					tag.put("alt", alt);
				if (title != null)
					tag.put("title", title);
			}
		};
	}

	protected CharSequence getDefaultCssClass() {
		return "cloud-zoom";
	}

	protected CharSequence getGalleryCssClass() {
		return "cloud-zoom-gallery";
	}
}
