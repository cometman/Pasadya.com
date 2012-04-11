package com.google.code.jqwicket;

import com.google.code.jqwicket.ui.sparkline.SparklineOptions;
import com.google.code.jqwicket.ui.sparkline.SparklineOptions.Type;
import com.google.code.jqwicket.ui.sparkline.SparklineWebMarkupContainer;

public class SparklinePage extends DemoPage {

	public SparklinePage() {

		add(new SparklineWebMarkupContainer("inlinesparkline"));

		add(new SparklineWebMarkupContainer("dynamicsparkline",
				new SparklineOptions(new float[] { 10, 8, 5, 7, 4, 4, 1 })));
		add(new SparklineWebMarkupContainer("dynamicbar", new SparklineOptions(
				new float[] { 10, 8, 5, 7, 4, 4, 1 }).type(Type.BAR).barColor(
				"green")));
		add(new SparklineWebMarkupContainer("inlinebar", new SparklineOptions()
				.type(Type.BAR).barColor("red")));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.DemoPage#getExampleTitle()
	 */
	@Override
	protected String getExampleTitle() {
		return "JQuery Sparkline Plugin example";
	}

}
