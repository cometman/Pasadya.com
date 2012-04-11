package com.google.code.jqwicket;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.PropertyModel;

import com.google.code.jqwicket.ui.lwrte.LWRTETextArea;

public class LWRTEPage extends DemoPage {

	public LWRTEPage() {
		add(new LWRTEForm("lwrteform"));
	}

	private static class LWRTEForm extends Form<Void> {

		private static final long serialVersionUID = 1L;

		private String value;

		public LWRTEForm(String id) {
			super(id);
			add(new LWRTETextArea<String>("lwrte", new PropertyModel<String>(
					this, "value")));

		}

		@Override
		protected void onSubmit() {
			System.out.println("submitted: " + value);
		}

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.DemoPage#getExampleTitle()
	 */
	@Override
	protected String getExampleTitle() {
		return "JQuery Lightweight Rich TextEdtior Plugin example";
	}

}
