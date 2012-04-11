package com.google.code.jqwicket.ui.kwicks;

import com.google.code.jqwicket.ui.JQComponentBehavior;

/**
 * @author mkalina
 * 
 */
public class KwicksBehavior extends JQComponentBehavior<KwicksOptions>
		implements IKwicks {

	private static final long serialVersionUID = 1L;

	public KwicksBehavior() {
		this(new KwicksOptions());
	}

	public KwicksBehavior(KwicksOptions options) {
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
