package com.google.code.jqwicket.ui.markitup;

import com.google.code.jqwicket.JQHeaderContributionTarget;
import com.google.code.jqwicket.ui.GenericJQComponentBehavior;

import static com.google.code.jqwicket.api.JQuery.$;

/**
 * Generic, selector based MarkItUp behavior.
 * 
 * @author mkalina
 */
public class GenericMarkItUpBehavior extends
        GenericJQComponentBehavior<MarkItUpOptions> implements IMarkItUp {

	private static final long serialVersionUID = 1L;

	public GenericMarkItUpBehavior(CharSequence selector) {
		this(selector, new MarkItUpOptions());
	}

	public GenericMarkItUpBehavior(CharSequence selector,
			MarkItUpOptions options) {
		super(selector, options);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.IJQWidget#getName()
	 */
	public CharSequence getName() {
		return JQ_COMPONENT_NAME;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.JQComponentBehavior#contributeInternal(com.google.code.jqwicket.JQHeaderContributionTarget)
	 */
	@Override
	protected void contributeInternal(JQHeaderContributionTarget target) {
		if (this.options.hasSet())
			target.addJQStatements($(getSelector()).chain(this.getName(),
					this.options.getSet().getName()));
		else
			target.addJQStatements($(getSelector()).chain(this.getName(),
					this.options));
	}
}
