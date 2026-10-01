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
package software.amazon.opensearch.client.codegen.renderer;

import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.Template;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import javax.annotation.Nonnull;
import software.amazon.opensearch.client.codegen.exceptions.JavaFormatterException;
import software.amazon.opensearch.client.codegen.exceptions.RenderException;
import software.amazon.opensearch.client.codegen.model.Shape;
import software.amazon.opensearch.client.codegen.utils.builder.ObjectBuilderBase;

public final class TemplateRenderer {
    @Nonnull
    private final Mustache.Compiler compiler;
    @Nonnull
    private final TemplateGlobalContext context;
    @Nonnull
    private final JavaCodeFormatter javaCodeFormatter;
    @Nonnull
    private final ConcurrentHashMap<String, Template> templateCache = new ConcurrentHashMap<>();

    private TemplateRenderer(@Nonnull Builder builder) {
        Objects.requireNonNull(builder, "builder must not be null");
        this.compiler = Mustache.compiler()
            .escapeHTML(false)
            .withLoader(Objects.requireNonNull(builder.templateLoader, "templateLoader must not be null"))
            .withFormatter(Objects.requireNonNull(builder.valueFormatter, "valueFormatter must not be null"))
            .withCollector(new TemplateObjectCollector());
        this.context = TemplateGlobalContext.builder().withRenderer(this).build();
        this.javaCodeFormatter = Objects.requireNonNull(builder.javaCodeFormatter, "javaCodeFormatter must not be null");
    }

    public void render(String templateName, Object context, Writer out) throws RenderException {
        try {
            var template = templateCache.computeIfAbsent(templateName, compiler::loadTemplate);
            template.execute(context, this.context, out);
        } catch (Throwable e) {
            throw new RenderException("Failed to render: " + context, e);
        }
    }

    public String render(String templateName, Object context) throws RenderException {
        var out = new StringWriter();
        render(templateName, context, out);
        return out.toString();
    }

    public void renderJava(Shape shape, File outputFile) throws RenderException {
        var classBody = render(shape.getTemplateName(), shape);
        var classHeader = render("Partials/ClassHeader", shape);

        try (Writer fileWriter = new FileWriter(outputFile)) {
            fileWriter.write(classHeader);
            fileWriter.write("\n\n");
            fileWriter.write(classBody);
        } catch (IOException e) {
            throw new RenderException("Unable to write rendered output to: " + outputFile, e);
        }

        try {
            javaCodeFormatter.format(outputFile);
        } catch (JavaFormatterException e) {
            // throw new RenderException("Unable to format rendered output: " + outputFile, e);
        }
    }

    @Nonnull
    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder extends ObjectBuilderBase<TemplateRenderer, Builder> {
        private TemplateValueFormatter valueFormatter;
        private TemplateLoader templateLoader;
        private JavaCodeFormatter javaCodeFormatter;

        private Builder() {}

        @Nonnull
        @Override
        protected TemplateRenderer construct() {
            return new TemplateRenderer(this);
        }

        @Nonnull
        public Builder withValueFormatter(@Nonnull Function<TemplateValueFormatter.Builder, TemplateValueFormatter.Builder> configurator) {
            this.valueFormatter = Objects.requireNonNull(configurator, "configurator must not be null")
                .apply(TemplateValueFormatter.builder())
                .build();
            return this;
        }

        @Nonnull
        public Builder withTemplateLoader(@Nonnull TemplateLoader templateLoader) {
            this.templateLoader = Objects.requireNonNull(templateLoader, "templateLoader must not be null");
            return this;
        }

        @Nonnull
        public Builder withJavaCodeFormatter(@Nonnull JavaCodeFormatter javaCodeFormatter) {
            this.javaCodeFormatter = Objects.requireNonNull(javaCodeFormatter, "javaCodeFormatter must not be null");
            return this;
        }
    }
}
