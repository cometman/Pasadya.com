package com.google.code.jqwicket;

import org.apache.wicket.markup.html.WebMarkupContainer;

import com.google.code.jqwicket.ui.uploadify.UploadifyBehavior;
import com.google.code.jqwicket.ui.uploadify.UploadifyOptions;

public class UploadifyPage extends DemoPage {

	public UploadifyPage() {
		add(new WebMarkupContainer("file_upload").add(new UploadifyBehavior(
				new UploadifyOptions().script("http://localhost:8080/jqwicket-demo/_up")
						.scriptAccess("always").auto(true).multi(true))));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.DemoPage#getExampleTitle()
	 */
	@Override
	protected String getExampleTitle() {
		return "JQuery Uploadify Plugin example";
	}

}
