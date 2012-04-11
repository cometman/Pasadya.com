package com.google.code.jqwicket.ui.liscroll;


import com.google.code.jqwicket.api.AbstractJQOptions;
import org.apache.wicket.request.resource.CssResourceReference;
import org.apache.wicket.request.resource.JavaScriptResourceReference;

/**
 * @author cschaedel
 */
public class LiScrollOptions extends AbstractJQOptions<LiScrollOptions> {

    private static final long serialVersionUID = 1L;

    public static final JavaScriptResourceReference JS_RESOURCE = new JavaScriptResourceReference(
            LiScrollOptions.class, "jquery.li-scroller.1.0.js");

    public static final CssResourceReference CSS_RESOURCE = new CssResourceReference(
            LiScrollOptions.class, "li-scroller.css");

    public LiScrollOptions() {
        this.setJsResourceReferences(JS_RESOURCE);
        this.setCssResourceReferences(CSS_RESOURCE);
    }

    public LiScrollOptions travelocity(float travelocity) {
        return super.put("travelocity", travelocity);
    }
}
