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
package software.amazon.awssdk.opensearch.client.codegen.renderer;

import com.samskivert.mustache.Mustache;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.Nonnull;
import org.apache.commons.io.IOUtils;
import software.amazon.awssdk.opensearch.client.codegen.utils.Strings;
import software.amazon.awssdk.opensearch.client.codegen.utils.builder.ObjectBuilderBase;

public final class TemplateLoader implements Mustache.TemplateLoader {
    private static final ConcurrentHashMap<String, String> CACHE = new ConcurrentHashMap<>();
    @Nonnull
    private final String templatesResourceSubPath;

    private TemplateLoader(@Nonnull Builder builder) {
        Objects.requireNonNull(builder, "builder must not be null");
        this.templatesResourceSubPath = Strings.requireNonBlank(
            builder.templatesResourceSubPath,
            "templatesResourceSubPath must not be blank"
        );
    }

    @Nonnull
    @Override
    public Reader getTemplate(@Nonnull String name) throws Exception {
        Strings.requireNonBlank(name, "name must not be blank");
        var path = templatesResourceSubPath + name + ".mustache";

        var contents = CACHE.get(path);

        if (contents == null) {
            try {
                contents = IOUtils.resourceToString(path, StandardCharsets.UTF_8);
                CACHE.put(path, contents);
            } catch (IOException e) {
                throw new Exception("Unable to load template: " + path, e);
            }
        }

        return new StringReader(contents);
    }

    @Nonnull
    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder extends ObjectBuilderBase<TemplateLoader, Builder> {
        private String templatesResourceSubPath;

        private Builder() {}

        @Nonnull
        @Override
        protected TemplateLoader construct() {
            return new TemplateLoader(this);
        }

        @Nonnull
        public Builder withTemplatesResourceSubPath(@Nonnull String templatesResourceSubPath) {
            Strings.requireNonBlank(templatesResourceSubPath, "templatesResourceSubPath must not be blank");
            if (!templatesResourceSubPath.startsWith("/")) {
                throw new IllegalArgumentException("templatesResourceSubPath must be absolute");
            }
            if (!templatesResourceSubPath.endsWith("/")) {
                templatesResourceSubPath += "/";
            }
            this.templatesResourceSubPath = templatesResourceSubPath;
            return this;
        }
    }
}
