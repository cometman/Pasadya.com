package com.google.code.jqwicket;

import com.google.code.jqwicket.ui.mobilymap.MobilyMapOptions;
import com.google.code.jqwicket.ui.mobilymap.MobilyMapWebMarkupContainer;

public class MobilyMapPage extends DemoPage {

	public MobilyMapPage() {
		add(new MobilyMapWebMarkupContainer("europeMap",
				new MobilyMapOptions().outsideButtons(".map_buttons a")));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.DemoPage#getExampleTitle()
	 */
	@Override
	protected String getExampleTitle() {
		return "JQuery MobilyMap Plugin example";
	}

}
