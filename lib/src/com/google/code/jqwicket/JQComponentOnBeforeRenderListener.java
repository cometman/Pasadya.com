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

import org.apache.wicket.Component;
import org.apache.wicket.application.IComponentOnBeforeRenderListener;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;

/**
 * Wicket's {@link IComponentOnBeforeRenderListener} implementation responsible for adding header contributor with
 * appropriate jquery resources to the component before it will be rendered.
 *
 * @author mkalina
 */
public class JQComponentOnBeforeRenderListener implements
        IComponentOnBeforeRenderListener {

    public JQComponentOnBeforeRenderListener() {
        this(new JQContributionConfig());
    }

    public JQComponentOnBeforeRenderListener(JQContributionConfig config) {
        JQContributionConfig.set(config);
    }

    /**
     * {@inheritDoc}
     */
    public void onBeforeRender(Component component) {
        if (component == null)
            return;

        if (IJQHeaderContributor.class.isAssignableFrom(component.getClass())) {
            addJQueryHeaderContributor(component, (IJQHeaderContributor) component);
        }

        addJQueryHeaderContributor(component, findJQueryBehaviors(component));
    }

    private Collection<JQBehavior> findJQueryBehaviors(Component component) {
        return new LinkedHashSet<JQBehavior>(component.getBehaviors(JQBehavior.class));
    }

    private void addJQueryHeaderContributor(Component component, IJQHeaderContributor... contributor) {

        if (Utils.isEmpty(contributor))
            return;

        addJQueryHeaderContributor(component, Arrays.asList(contributor));
    }

    private void addJQueryHeaderContributor(Component component,
                                            Collection<? extends IJQHeaderContributor> contributors) {

        if (Utils.isEmpty(contributors))
            return;

        JQContributionRenderer renderer = JQContributionRenderer.get();
        renderer.addContributors(contributors);
        component.add(renderer);
    }

}
