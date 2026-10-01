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
package software.amazon.opensearch.client.codegen.transformer.overrides;

import java.util.Optional;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import software.amazon.opensearch.client.codegen.utils.builder.ObjectBuilderBase;
import software.amazon.opensearch.client.codegen.utils.builder.ObjectMapBuilderBase;

public final class PathParameterOverride {
    @Nullable
    private final String name;

    private PathParameterOverride(Builder builder) {
        this.name = builder.name;
    }

    @Nonnull
    public Optional<String> getName() {
        return Optional.ofNullable(name);
    }

    @Nonnull
    public static Builder builder() {
        return new Builder();
    }

    @Nonnull
    public static MapBuilder mapBuilder() {
        return new MapBuilder();
    }

    public static final class Builder extends ObjectBuilderBase<PathParameterOverride, Builder> {
        @Nullable
        private String name;

        private Builder() {}

        @Nonnull
        @Override
        protected PathParameterOverride construct() {
            return new PathParameterOverride(this);
        }

        @Nonnull
        public Builder withName(@Nullable String value) {
            this.name = value;
            return this;
        }
    }

    public static final class MapBuilder extends ObjectMapBuilderBase<String, PathParameterOverride, Builder, MapBuilder> {
        private MapBuilder() {}

        @Nonnull
        @Override
        protected Builder valueBuilder() {
            return builder();
        }
    }
}
