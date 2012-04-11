package com.google.code.jqwicket;

import com.google.code.jqwicket.ui.nivoslider.NivoSliderOptions;
import com.google.code.jqwicket.ui.nivoslider.NivoSliderOptions.Effect;
import com.google.code.jqwicket.ui.nivoslider.NivoSliderWebMarkupContainer;

public class NivoSliderPage extends DemoPage {

	public NivoSliderPage() {
		add(new NivoSliderWebMarkupContainer("slider", new NivoSliderOptions()
				.effect(Effect.FOLD, Effect.SLICE_UP_DOWN_LEFT).captionOpacity(
						0.2f)).setMarkupId("slider"));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.DemoPage#getExampleTitle()
	 */
	@Override
	protected String getExampleTitle() {
		return "JQuery NivoSlider Plugin example";
	}

}
