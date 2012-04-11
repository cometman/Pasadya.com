package com.google.code.jqwicket;

import com.google.code.jqwicket.ui.gmap.GMapIcon;
import com.google.code.jqwicket.ui.gmap.GMapMarker;
import com.google.code.jqwicket.ui.gmap.GMapOptions;
import com.google.code.jqwicket.ui.gmap.GMapOptions.MapType;
import com.google.code.jqwicket.ui.gmap.GMapWebMarkupContainer;

public class GMapPage extends DemoPage {

	private String key = "ABQIAAAAnpi8w430G2G-eFRpyPB7exTH5to4oArn01q2NFRzz_-kGVeHjRTZLRM0dF3Dnc925yq4UcIZj3b_dw";

	public GMapPage() {
		add(new GMapWebMarkupContainer("map1",
				new GMapOptions(key).markers(new GMapMarker().latitude(
						47.660937f).longitude(9.569803f))));

		add(new GMapWebMarkupContainer("map2",
				new GMapOptions(key).maptype(MapType.G_PHYSICAL_MAP)));

		add(new GMapWebMarkupContainer("map3", new GMapOptions(key).markers(
				new GMapMarker().latitude(47.660937f).longitude(9.569803f)
						.html("Tettnang, Germany").popup(true)).zoom(6)));

		add(new GMapWebMarkupContainer(
				"map5",
				new GMapOptions(key)
						.controls(false)
						.scrollwheel(false)
						.markers(
								new GMapMarker()
										.latitude(47.670553f)
										.longitude(9.588479f)
										.icon(new GMapIcon()
												.image("_images/gmap/gmap_pin_orange.png")
												.iconsize(26, 46)
												.iconanchor(12, 46)
												.infowindowanchor(12, 0)),
								new GMapMarker().latitude(47.65197522925437f)
										.longitude(9.47845458984375f),
								new GMapMarker()
										.latitude(47.594996f)
										.longitude(9.600708f)
										.icon(new GMapIcon()
												.image("_images/gmap/gmap_pin_grey.png")
												.iconsize(26, 46)
												.iconanchor(12, 46)
												.infowindowanchor(12, 0))

						)
						.icon(new GMapIcon().image("_images/gmap/gmap_pin.png")
								.iconsize(26, 46).iconanchor(12, 46)
								.infowindowanchor(12, 0)).latitude(47.58969f)
						.longitude(9.473413f).zoom(10)));

		add(new GMapWebMarkupContainer("map4", new GMapOptions(key).markers(
				new GMapMarker().latitude(47.651968f).longitude(9.478485f)
						.html("_latlng"),
				new GMapMarker().address("Tettnang, Germany").html(
						"The place I live"),
				new GMapMarker().address("Langenargen, Germany").html(
						"_address")).zoom(10)));

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.DemoPage#getExampleTitle()
	 */
	@Override
	protected String getExampleTitle() {
		return "JQuery GMap Plugin example";
	}

}
