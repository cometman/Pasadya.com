package com.google.code.jqwicket.ui.mobilymap;

import com.google.code.jqwicket.ui.JQWebMarkupContainer;
import org.apache.wicket.model.IModel;

/**
 * @author mkalina
 * 
 */
public class MobilyMapWebMarkupContainer extends
		JQWebMarkupContainer<MobilyMapBehavior, MobilyMapOptions> implements
		IMobilyMap {

	private static final long serialVersionUID = 1L;

	public MobilyMapWebMarkupContainer(String id) {
		this(id, new MobilyMapOptions());
	}

	public MobilyMapWebMarkupContainer(String id, IModel<?> model) {
		this(id, model, new MobilyMapOptions());
	}

	public MobilyMapWebMarkupContainer(String id, MobilyMapOptions options) {
		super(id, options);
	}

	public MobilyMapWebMarkupContainer(String id, IModel<?> model,
			MobilyMapOptions options) {
		super(id, model, options);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.ui.JQWebMarkupContainer#newJQComponentBehavior(com.google.code.jqwicket.ui.IJQOptions)
	 */
	@Override
	protected MobilyMapBehavior newJQComponentBehavior(MobilyMapOptions options) {
		return new MobilyMapBehavior(options);
	}

}
