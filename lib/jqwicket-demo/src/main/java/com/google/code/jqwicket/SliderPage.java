package com.google.code.jqwicket;

import com.google.code.jqwicket.ui.slider.SliderBehavior;
import com.google.code.jqwicket.ui.slider.SliderOptions;
import org.apache.wicket.ajax.AbstractDefaultAjaxBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.request.cycle.RequestCycle;

import static com.google.code.jqwicket.api.JQuery.js;
import static com.google.code.jqwicket.api.JQuery.wicketAjaxGet;

public class SliderPage extends DemoPage {

    public SliderPage() {

        add(new WebMarkupContainer("slider").add(new SliderBehavior(
                new SliderOptions().min(10).max(100).value(20))));

        add(new AjaxSlider("ajaxSlider") {
            private static final long serialVersionUID = 1L;

            @Override
            public void onValueChanged(AjaxRequestTarget target, int newValue) {
                target.prependJavaScript("alert('Value received on server: "
                        + newValue + "');");
            }
        });

    }

    public abstract static class AjaxSlider extends WebMarkupContainer {

        private static final long serialVersionUID = 1L;

        public AjaxSlider(String id) {
            super(id);
            super.setOutputMarkupId(true);
        }

        public abstract void onValueChanged(AjaxRequestTarget target, int newValue);

        @Override
        protected void onInitialize() {
            super.onInitialize();
            AbstractDefaultAjaxBehavior ajaxBehavior = new AbstractDefaultAjaxBehavior() {
                private static final long serialVersionUID = 1L;

                @Override
                protected void respond(AjaxRequestTarget target) {
                    String sliderValue = RequestCycle.get().getRequest()
                            .getRequestParameters().getParameterValue("sv").toString();
                    if (Utils.isNotBlank(sliderValue)) {
                        onValueChanged(target, Integer.valueOf(sliderValue));
                    }
                }
            };
            super.add(ajaxBehavior);
            super.add(new SliderBehavior(new SliderOptions()
                    .changeEvent(wicketAjaxGet(
                            ajaxBehavior,
                            new MapBuilder<String, Object>().add("sv",
                                    js("ui.value")).build()))));
        }

    }

    /**
     * {@inheritDoc}
     *
     * @see com.google.code.jqwicket.DemoPage#getExampleTitle()
     */
    @Override
    protected String getExampleTitle() {
        return "JQuery UI Slider example";
    }

    /**
     * {@inheritDoc}
     *
     * @see com.google.code.jqwicket.DemoPage#getExampleDescription()
     */
    @Override
    protected String getExampleDescription() {
        return "This example demonstrates JQuery UI Slider integration";
    }

}
