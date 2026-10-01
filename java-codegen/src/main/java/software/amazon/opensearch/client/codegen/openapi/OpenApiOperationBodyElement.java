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
package software.amazon.opensearch.client.codegen.openapi;

import static software.amazon.opensearch.client.codegen.utils.Functional.ifNonnull;

import io.swagger.v3.oas.models.media.Content;
import java.util.Optional;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import software.amazon.opensearch.client.codegen.utils.Clone;
import software.amazon.opensearch.client.codegen.utils.json.JsonGenerator;

public abstract class OpenApiOperationBodyElement<Self extends OpenApiOperationBodyElement<Self>> extends OpenApiRefElement<Self> {
    @Nullable
    private OpenApiContent content;

    OpenApiOperationBodyElement(@Nonnull AbstractBuilder<Self, ?> builder, @Nonnull Class<Self> clazz) {
        super(builder, clazz);
        setContent(builder.content);
    }

    OpenApiOperationBodyElement(@Nullable String $ref, @Nullable Content content, @Nonnull Class<Self> clazz) {
        super($ref, clazz);
        setContent(ifNonnull(content, OpenApiContent::new));
    }

    @Override
    void initialize(@Nullable OpenApiElement<?> parent, @Nonnull JsonPointer pointer) {
        super.initialize(parent, pointer);
        initializeChild("content", content);
    }

    @Nonnull
    public Optional<OpenApiContent> getContent() {
        return Optional.ofNullable(content);
    }

    public void setContent(@Nullable OpenApiContent content) {
        this.content = content;
        initializeChild("content", content);
    }

    @Override
    protected void toJsonInner(JsonGenerator generator) {
        super.toJsonInner(generator);
        if (content != null) {
            generator.writeField("content", content);
        }
    }

    @Nonnull
    <Builder extends AbstractBuilder<Self, Builder>> Builder toBuilder(@Nonnull Builder builder) {
        return super.toBuilder(builder).withContent(ifNonnull(content, Clone::clone));
    }

    protected static abstract class AbstractBuilder<
        Element extends OpenApiOperationBodyElement<Element>,
        Builder extends AbstractBuilder<Element, Builder>> extends OpenApiRefElement.AbstractBuilder<Element, Builder> {
        @Nullable
        private OpenApiContent content;

        AbstractBuilder() {}

        @Nonnull
        public Builder withContent(@Nullable OpenApiContent content) {
            this.content = content;
            return self();
        }
    }
}
