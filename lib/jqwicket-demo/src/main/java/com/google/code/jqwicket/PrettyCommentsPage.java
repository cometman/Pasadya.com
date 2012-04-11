package com.google.code.jqwicket;

import org.apache.wicket.markup.html.form.TextArea;

import com.google.code.jqwicket.ui.prettycomments.PrettyCommentsBehavior;

public class PrettyCommentsPage extends DemoPage {

	public PrettyCommentsPage() {
		add(new TextArea<String>("commentBox1")
				.add(new PrettyCommentsBehavior()));
		add(new TextArea<String>("commentBox2")
				.add(new PrettyCommentsBehavior()));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.DemoPage#getExampleTitle()
	 */
	@Override
	protected String getExampleTitle() {
		return "JQuery PrettyComments Plugin example";
	}

}
