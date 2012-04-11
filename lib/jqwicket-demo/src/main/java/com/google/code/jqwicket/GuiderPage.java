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

import com.google.code.jqwicket.ui.guider.*;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.link.ExternalLink;

/**
 * @author mkalina
 */
public class GuiderPage extends DemoPage {

    public GuiderPage() {

        WebMarkupContainer myGuider = new WebMarkupContainer("myGuider");

        GuiderItem item1 = new GuiderItem(
                new GuiderOptions()
                        .buttons(new GuiderNextButton(Utils.i18n("button.next", this)))
                        .description(
                                "Guiders are a user interface "
                                        + "design pattern for introducing features of software. This dialog box, "
                                        + "for example, is the first in a series of guiders that "
                                        + "together make up a guide.")
                        .id("first").next("second").overlay(true)
                        .title("Welcome to Guiders.js!"), true);

        GuiderItem item2 = new GuiderItem(new GuiderOptions()
                .attachTo(myGuider)
                .buttons(new GuiderCloseButton("Close"), new GuiderNextButton("Next"))
                .descriptionI18N("item2.description", this).id("second")
                .next("third").position(12).titleI18N("item2.title", this));

        GuiderItem item3 = new GuiderItem(
                new GuiderOptions()
                        .attachTo(myGuider)
                        .buttons(new GuiderButton("Close, then click on the element.", "guiders.hideAll"),
                                new GuiderButton("Next")
                        )
                        .description(
                                "Custom event handlers can be used to hide and show guiders. "
                                        + "This allows you to interactively show the user how to use your software "
                                        + "by having them complete steps. To try it, click on the clock.")
                        .id("third").next("fourth").position(4)
                        .title("You can advance guiders from custom event handlers.")
                        .width(500));

        GuiderItem item4 = new GuiderItem(
                new GuiderOptions()
                        .attachTo(myGuider)
                        .buttons(new GuiderButton("Exit Guide", "guiders.hideAll"), new GuiderButton("Continue",
                                "guiders.next"))
                        .buttonCustomHTML(
                                "<input type='checkbox' id='stop_showing' />"
                                        + "<label for='stop_showing' class='stopper'>Stop showing these. (Not implemented)"
                                        + "</label>")
                        .descriptionI18N("item4.description", this)
                        .id("fourth").next("fifth").position(7)
                        .titleI18N("item4.title", this, "dynamically")
                        .width(600));

        GuiderItem item5 = new GuiderItem(
                new GuiderOptions()
                        .attachTo(myGuider)
                        .buttons(new GuiderButton("Next"))
                        .description(
                                "Guiders can also be used to introduce of brand new features to existing users."
                                        + "Here is an image example <br/><br/> <img src='http://lorempixum.com/400/200/sports/' style='border: 1px solid #333;' />")
                        .id("fifth").next("finally").overlay(true)
                        .title("How else can I use guiders?").width(550));

        GuiderItem item6 = new GuiderItem(
                new GuiderOptions()
                        .buttons(
                                new GuiderButton("Close")
                                        .classString("primary-button"))
                        .description(
                                "To get started, have a look at this HTML file, then emulate it for use "
                                        + "in your own project. You can also see "
                                        + "Guiders in action on our site, <a href='http://www.optimizely.com/guiders'>www.optimizely.com</a>")
                        .id("finally").overlay(true)
                        .title("Great, so how do I get started?").width(500));

        GuiderBehavior guider = new GuiderBehavior(item1, item2, item3, item4,
                item5, item6);

        myGuider.add(JQBehaviors.mouseClick(guider.next()));

        add(myGuider);
        add(guider);

        add(new ExternalLink("showGuide", "#").add(JQBehaviors.mouseClick(guider.show("second"))));
    }

    /**
     * {@inheritDoc}
     *
     * @see com.google.code.jqwicket.DemoPage#getExampleTitle()
     */
    @Override
    protected String getExampleTitle() {
        return "JQuery Guider Plugin example";
    }

}
