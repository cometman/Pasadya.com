package com.google.code.jqwicket;

import com.google.code.jqwicket.dnd.DND2Page;
import org.apache.wicket.protocol.http.WebApplication;

/**
 *
 */
public class WicketApplication extends WebApplication {

    @Override
    protected void init() {

        super.getComponentPreOnBeforeRenderListeners().add(new JQComponentOnBeforeRenderListener(
                new JQContributionConfig().withDefaultJQueryUi()));

        getMarkupSettings().setStripWicketTags(true);

        mountPage("genericjqbehavior", GenericJQBehaviorPage.class);
        mountPage("resizable", ResizablePage.class);
        mountPage("selectable", SelectablePage.class);
        mountPage("sortable", SortablePage.class);
        mountPage("accordion", AccordionPage.class);
        mountPage("dynamicaccordion", DynamicAccordionPage.class);
        mountPage("button", ButtonPage.class);
        mountPage("datepicker", DatePickerPage.class);
        mountPage("datetimepicker", DateTimePickerPage.class);
        mountPage("dialog", DialogPage.class);
        mountPage("progressbar", ProgressbarPage.class);
        mountPage("slider", SliderPage.class);
        mountPage("notifier", NotifierPage.class);
        mountPage("uniform", UniformPage.class);
        mountPage("uploadify", UploadifyPage.class);
        mountPage("nivoslider", NivoSliderPage.class);
        mountPage("maskedinput", MaskedInputPage.class);
        mountPage("colorpicker", ColorPickerPage.class);
        mountPage("jcarousel", JCarouselPage.class);
        mountPage("tabs", TabsPage.class);
        mountPage("sparkline", SparklinePage.class);
        mountPage("tiptip", TipTipPage.class);
        mountPage("cjimageflipbox", CJImageFlipboxPage.class);
        mountPage("liscroll", LiScrollPage.class);
        mountPage("fancybox", FancyBoxPage.class);
        mountPage("cloudzoom", CloudZoomPage.class);
        mountPage("gmap", GMapPage.class);
        mountPage("fliptext", FlipTextPage.class);
        mountPage("extruder", ExtruderPage.class);
        mountPage("kwicks", KwicksPage.class);
        mountPage("markitup", MarkItUpPage.class);
        mountPage("lwrte", LWRTEPage.class);
        mountPage("ckeditor", CKEditorPage.class);
        mountPage("prettyloader", PrettyLoaderPage.class);
        mountPage("prettycomments", PrettyCommentsPage.class);
        mountPage("prettypopin", PrettyPopinPage.class);
        mountPage("prettygallery", PrettyGalleryPage.class);
        mountPage("validationengine", ValidationEnginePage.class);
        mountPage("blockui", BlockUIPage.class);
        mountPage("mobilymap", MobilyMapPage.class);
        mountPage("guider", GuiderPage.class);

        mountPage("dnd", DNDPage.class);
        mountPage("dnd2", DND2Page.class);
    }

    /**
     * @see org.apache.wicket.Application#getHomePage()
     */
    public Class<GenericJQBehaviorPage> getHomePage() {
        return GenericJQBehaviorPage.class;
    }

}
