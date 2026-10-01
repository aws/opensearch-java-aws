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

import io.swagger.v3.oas.models.media.MediaType;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import software.amazon.opensearch.client.codegen.utils.Clone;
import software.amazon.opensearch.client.codegen.utils.builder.ToBuilder;
import software.amazon.opensearch.client.codegen.utils.json.JsonGenerator;

public final class OpenApiMediaType extends OpenApiElement<OpenApiMediaType> implements ToBuilder<OpenApiMediaType.Builder> {
    @Nullable
    private OpenApiSchema schema;

    private OpenApiMediaType(@Nonnull Builder builder) {
        super(builder);
        setSchema(builder.schema);
    }

    OpenApiMediaType(@Nonnull MediaType mediaType) {
        Objects.requireNonNull(mediaType, "mediaType must not be null");
        setSchema(ifNonnull(mediaType.getSchema(), OpenApiSchema::new));
    }

    @Override
    void initialize(@Nullable OpenApiElement<?> parent, @Nonnull JsonPointer pointer) {
        super.initialize(parent, pointer);
        initializeChild("schema", schema);
    }

    @Nonnull
    public Optional<OpenApiSchema> getSchema() {
        return Optional.ofNullable(schema);
    }

    public void setSchema(@Nullable OpenApiSchema schema) {
        this.schema = schema;
        initializeChild("schema", schema);
    }

    @Override
    public @Nonnull OpenApiMediaType clone() {
        return toBuilder().build();
    }

    @Override
    protected void toJsonInner(JsonGenerator generator) {
        if (schema != null) {
            generator.writeField("schema", schema);
        }
    }

    @Override
    public @Nonnull Builder toBuilder() {
        return super.toBuilder(builder()).withSchema(ifNonnull(schema, Clone::clone));
    }

    public static @Nonnull Builder builder() {
        return new Builder();
    }

    public static final class Builder extends OpenApiElement.AbstractBuilder<OpenApiMediaType, Builder> {
        @Nullable
        private OpenApiSchema schema;

        private Builder() {}

        @Nonnull
        @Override
        public OpenApiMediaType construct() {
            return new OpenApiMediaType(this);
        }

        @Nonnull
        public Builder withSchema(@Nullable OpenApiSchema schema) {
            this.schema = schema;
            return this;
        }
    }
}
