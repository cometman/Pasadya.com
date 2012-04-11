package com.google.code.jqwicket.ui.liscroll;

import com.google.code.jqwicket.ui.JQComponentBehavior;

/**
 * 
 * @author cschaedel
 */
public class LiScrollBehavior extends JQComponentBehavior<LiScrollOptions>
		implements ILiScroll {

	private static final long serialVersionUID = 1L;

	public LiScrollBehavior() {
		this(new LiScrollOptions());
	}

	public LiScrollBehavior(LiScrollOptions options) {
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
