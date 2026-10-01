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

public final class QueryParameterOverride {
    @Nullable
    private final String name;
    @Nullable
    private final Boolean ignore;

    private QueryParameterOverride(Builder builder) {
        this.name = builder.name;
        this.ignore = builder.ignore;
    }

    @Nonnull
    public Optional<String> getName() {
        return Optional.ofNullable(name);
    }

    public boolean shouldIgnore() {
        return ignore != null && ignore;
    }

    @Nonnull
    public static Builder builder() {
        return new Builder();
    }

    @Nonnull
    public static MapBuilder mapBuilder() {
        return new MapBuilder();
    }

    public static final class Builder extends ObjectBuilderBase<QueryParameterOverride, Builder> {
        @Nullable
        private String name;
        @Nullable
        private Boolean ignore;

        private Builder() {}

        @Nonnull
        @Override
        protected QueryParameterOverride construct() {
            return new QueryParameterOverride(this);
        }

        @Nonnull
        public Builder withName(@Nullable String value) {
            this.name = value;
            return this;
        }

        @Nonnull
        public Builder withIgnore(@Nullable Boolean value) {
            this.ignore = value;
            return this;
        }
    }

    public static final class MapBuilder extends ObjectMapBuilderBase<String, QueryParameterOverride, Builder, MapBuilder> {
        private MapBuilder() {}

        @Nonnull
        @Override
        protected Builder valueBuilder() {
            return builder();
        }
    }
}
