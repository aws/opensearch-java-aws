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

import io.swagger.v3.oas.models.media.Discriminator;
import java.util.Optional;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import software.amazon.opensearch.client.codegen.utils.Maps;
import software.amazon.opensearch.client.codegen.utils.builder.ToBuilder;
import software.amazon.opensearch.client.codegen.utils.json.JsonGenerator;

public class OpenApiDiscriminator extends OpenApiElement<OpenApiDiscriminator> implements ToBuilder<OpenApiDiscriminator.Builder> {
    @Nullable
    private final String propertyName;
    @Nullable
    private final String defaultValue;

    private OpenApiDiscriminator(@Nonnull Builder builder) {
        this.propertyName = builder.propertyName;
        this.defaultValue = builder.defaultValue;
    }

    OpenApiDiscriminator(@Nonnull Discriminator discriminator) {
        this.propertyName = discriminator.getPropertyName();
        var extensions = discriminator.getExtensions();
        this.defaultValue = (String) Maps.tryGet(extensions, "x-default").orElse(null);
    }

    @Nonnull
    public Optional<String> getPropertyName() {
        return Optional.ofNullable(propertyName);
    }

    @Nonnull
    public Optional<String> getDefaultValue() {
        return Optional.ofNullable(defaultValue);
    }

    @Override
    public @Nonnull OpenApiDiscriminator clone() {
        return toBuilder().build();
    }

    @Override
    protected void toJsonInner(JsonGenerator generator) {
        if (propertyName != null) {
            generator.writeField("propertyName", propertyName);
        }
        if (defaultValue != null) {
            generator.writeField("x-default", defaultValue);
        }
    }

    @Override
    public @Nonnull Builder toBuilder() {
        return new Builder().withPropertyName(propertyName).withDefaultValue(defaultValue);
    }

    @Nonnull
    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder extends OpenApiElement.AbstractBuilder<OpenApiDiscriminator, Builder> {
        @Nullable
        private String propertyName;
        @Nullable
        private String defaultValue;

        private Builder() {}

        @Override
        @Nonnull
        public OpenApiDiscriminator construct() {
            return new OpenApiDiscriminator(this);
        }

        @Nonnull
        public Builder withPropertyName(@Nullable String propertyName) {
            this.propertyName = propertyName;
            return this;
        }

        @Nonnull
        public Builder withDefaultValue(@Nullable String defaultValue) {
            this.defaultValue = defaultValue;
            return this;
        }
    }
}
