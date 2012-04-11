package com.google.code.jqwicket.ui.ckeditor;

import com.google.code.jqwicket.JQHeaderContributionTarget;
import com.google.code.jqwicket.api.IJQStatement;
import com.google.code.jqwicket.ui.JQComponentBehavior;
import org.apache.wicket.request.cycle.RequestCycle;
import org.apache.wicket.request.resource.PackageResourceReference;
import org.apache.wicket.request.resource.ResourceReference;

import static com.google.code.jqwicket.api.JQuery.js;

/**
 * @author mkalina
 */
public class CKEditorBehavior extends JQComponentBehavior<CKEditorOptions>
        implements ICKEditor {

    private static final long serialVersionUID = 1L;

    private static final ResourceReference baseRef = new PackageResourceReference(
            CKEditorOptions.class, "");

    public CKEditorBehavior() {
        this(new CKEditorOptions());
    }

    public CKEditorBehavior(CKEditorOptions options) {
        super(options);
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
     *
     * @see com.google.code.jqwicket.ui.JQComponentBehavior#contributeInternal(com.google.code.jqwicket.JQHeaderContributionTarget)
     */
    @Override
    protected void contributeInternal(JQHeaderContributionTarget target) {
        super.contributeInternal(target);
        CharSequence baseUrl = RequestCycle.get().urlFor(baseRef, null);
        target.addJQStatements(
                new IJQStatement[]{
                        js(String.format("var CKEDITOR_BASEPATH = '%s/';\n", baseUrl)),
                        js("function CKEDITOR_GETURL(resource){\n"
                                + "return resource.indexOf(CKEDITOR_BASEPATH) >= 0 ? resource : CKEDITOR_BASEPATH + resource;\n"
                                + "}")
                }, false);
    }

}
