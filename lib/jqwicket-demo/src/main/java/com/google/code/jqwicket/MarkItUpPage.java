package com.google.code.jqwicket;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.PropertyModel;

import com.google.code.jqwicket.ui.markitup.MarkItUpTextArea;

public class MarkItUpPage extends DemoPage {

	public MarkItUpPage() {
		add(new MarkItUpForm("markitupform"));
	}

	private static class MarkItUpForm extends Form<Void> {

		private static final long serialVersionUID = 1L;

		private String value;

		public MarkItUpForm(String id) {
			super(id);
			add(new MarkItUpTextArea<String>("markitup",
					new PropertyModel<String>(this, "value")));

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
		return "JQuery MarkItUp Plugin example";
	}

}
