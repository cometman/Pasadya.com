package com.google.code.jqwicket.ui.ckeditor;

import com.google.code.jqwicket.ui.GenericJQComponentBehavior;
import org.apache.wicket.markup.html.IHeaderContributor;
import org.apache.wicket.markup.html.IHeaderResponse;
import org.apache.wicket.request.cycle.RequestCycle;
import org.apache.wicket.request.resource.PackageResourceReference;
import org.apache.wicket.request.resource.ResourceReference;

import java.util.UUID;

/**
 * Generic, selector based CKEditor behavior.
 *
 * @author mkalina
 */
public class GenericCKEditorBehavior extends
        GenericJQComponentBehavior<CKEditorOptions> implements ICKEditor,
        IHeaderContributor {

    private static final long serialVersionUID = 1L;

    private static final ResourceReference baseRef = new PackageResourceReference(
            CKEditorOptions.class, "");

    public GenericCKEditorBehavior(CharSequence selector) {
        this(selector, new CKEditorOptions());
    }

    public GenericCKEditorBehavior(CharSequence selector,
                                   CKEditorOptions options) {
        super(selector, options);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.google.code.jqwicket.IJQWidget#getName()
     */
    public CharSequence getName() {
        return JQ_COMPONENT_NAME;
    }

    /**
     * {@inheritDoc}
     */
    public void renderHead(IHeaderResponse response) {
        CharSequence baseUrl = RequestCycle.get().urlFor(baseRef, null);
        StringBuffer buf = new StringBuffer();
        buf.append(String.format("var CKEDITOR_BASEPATH = '%s';\n", baseUrl));
        buf.append(String
                .format("function CKEDITOR_GETURL(resource){\n"
                        + " return resource.indexOf('%s') >= 0 ? resource : '%s' + resource;\n"
                        + "}", baseUrl, baseUrl));
        response.renderJavaScript(buf, UUID.randomUUID().toString());
    }

}
