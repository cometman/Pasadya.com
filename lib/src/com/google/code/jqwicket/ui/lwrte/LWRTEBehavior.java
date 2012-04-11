package com.google.code.jqwicket.ui.lwrte;

import com.google.code.jqwicket.ui.JQComponentBehavior;

/**
 * @author mkalina
 */
public class LWRTEBehavior extends JQComponentBehavior<LWRTEOptions> implements
		ILWRTEditor {

	private static final long serialVersionUID = 1L;

	public LWRTEBehavior() {
		this(new LWRTEOptions());
	}

	public LWRTEBehavior(LWRTEOptions options) {
		super(options);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.IJQWidget#getName()
	 */
	public CharSequence getName() {
		return JQ_COMPONENT_NAME;
	}

}
