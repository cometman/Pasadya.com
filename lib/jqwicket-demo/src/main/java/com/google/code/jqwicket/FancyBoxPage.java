/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.code.jqwicket;

import com.google.code.jqwicket.ui.fancybox.FancyBoxOptions;
import com.google.code.jqwicket.ui.fancybox.FancyBoxWebMarkupContainer;
import com.google.code.jqwicket.ui.fancybox.GenericFancyBoxBehavior;

/**
 * @author mkalina
 * 
 */
public class FancyBoxPage extends DemoPage {

	public FancyBoxPage() {

		add(new FancyBoxWebMarkupContainer("example1"));
		add(new FancyBoxWebMarkupContainer("example2", new FancyBoxOptions()
				.overlayShow(false).transitionIn("elastic")
				.transitionOut("elastic")));
		add(new FancyBoxWebMarkupContainer("example3", new FancyBoxOptions()
				.transitionIn("none").transitionOut("none")));
		add(new FancyBoxWebMarkupContainer("example4", new FancyBoxOptions()
				.opacity(true).overlayShow(false).transitionIn("elastic")
				.transitionOut("none")));

		add(new FancyBoxWebMarkupContainer("example5"));
		add(new FancyBoxWebMarkupContainer("example6", new FancyBoxOptions()
				.titlePosition("outside").overlayColor("#000")
				.overlayOpacity(0.9f)));
		add(new FancyBoxWebMarkupContainer("example7",
				new FancyBoxOptions().titlePosition("inside")));
		add(new FancyBoxWebMarkupContainer("example8",
				new FancyBoxOptions().titlePosition("over")));

		add(new GenericFancyBoxBehavior(
				"a[rel=example_group]",
				new FancyBoxOptions()
						.transitionIn("none")
						.transitionOut("none")
						.titlePosition("over")
						.titleFormat(
								"return '<span id=\"fancybox-title-over\">Image ' + (currentIndex + 1) + ' / ' + currentArray.length + (title.length ? ' &nbsp; ' + title : '') + '</span>';")));

		add(new FancyBoxWebMarkupContainer("various1"));

		add(new FancyBoxWebMarkupContainer("various2", new FancyBoxOptions()
				.width("75%").height("75%").autoScale(false)
				.transitionIn("none").transitionOut("none").type("iframe")));

		add(new FancyBoxWebMarkupContainer("various3", new FancyBoxOptions()
				.padding(0).autoScale(false).transitionIn("none")
				.transitionOut("none")));

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.google.code.jqwicket.DemoPage#getExampleTitle()
	 */
	@Override
	protected String getExampleTitle() {
		return "JQuery Fancybox Plugin example";
	}

}
