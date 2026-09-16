/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package software.amazon.awssdk.opensearch.client.codegen.renderer.lambdas;

import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.Template;
import java.io.IOException;
import java.io.Writer;
import javax.annotation.Nonnull;
import software.amazon.awssdk.opensearch.client.codegen.exceptions.RenderException;
import software.amazon.awssdk.opensearch.client.codegen.renderer.TemplateFragmentUtils;
import software.amazon.awssdk.opensearch.client.codegen.renderer.TemplateGlobalContext;
import software.amazon.awssdk.opensearch.client.codegen.utils.Strings;

public abstract class TemplateRenderingLambda implements Mustache.Lambda {
    @Nonnull
    private final String templateName;

    protected TemplateRenderingLambda(@Nonnull String templateName) {
        this.templateName = Strings.requireNonBlank(templateName, "templateName must not be blank");
    }

    @Override
    public void execute(Template.Fragment fragment, Writer out) throws IOException {
        var renderer = TemplateFragmentUtils.findParentContext(fragment, TemplateGlobalContext.class).orElseThrow().getRenderer();

        try {
            var content = renderer.render(templateName, getContext(fragment));
            out.write(content.strip());
        } catch (RenderException e) {
            throw new RuntimeException(e);
        }
    }

    public abstract Object getContext(Template.Fragment fragment);
}
