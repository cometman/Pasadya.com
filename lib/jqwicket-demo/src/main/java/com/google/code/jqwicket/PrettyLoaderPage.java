package com.google.code.jqwicket;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.form.Button;

import com.google.code.jqwicket.ui.prettyloader.PrettyLoaderBehavior;

public class PrettyLoaderPage extends DemoPage {

	private PrettyLoaderBehavior prettyLoader;

	public PrettyLoaderPage() {
		add(this.prettyLoader = new PrettyLoaderBehavior());

		add(new Button("showPrettyLoader").add(JQBehaviors
				.mouseClick(this.prettyLoader.show())));
		add(new Button("showPrettyLoader2Seconds").add(JQBehaviors
				.mouseClick(this.prettyLoader.show(2000))));
		add(new Button("hidePrettyLoader").add(JQBehaviors
				.mouseClick(this.prettyLoader.hide())));

		add(new AjaxLink<Void>("ajaxLoadingLink") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick(AjaxRequestTarget target) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					;
				}
				prettyLoader.hide(target);
			}
		}.add(JQBehaviors.mouseClick(this.prettyLoader.show())));

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.DemoPage#getExampleTitle()
	 */
	@Override
	protected String getExampleTitle() {
		return "JQuery PrettyLoader Plugin example";
	}

}
