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
package software.amazon.opensearch.client.codegen.model.types;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import software.amazon.opensearch.client.codegen.utils.Strings;
import software.amazon.opensearch.client.codegen.utils.builder.ObjectBuilderBase;

public final class TypeParameterDefinition {
    @Nonnull
    private final String name;
    @Nullable
    private final Type extendsType;

    private TypeParameterDefinition(Builder builder) {
        this.name = Strings.requireNonBlank(builder.name, "name must not be blank");
        this.extendsType = builder.extendsType;
    }

    @Nonnull
    public String getName() {
        return name;
    }

    @Nullable
    public Type getExtends() {
        return extendsType;
    }

    @Nonnull
    public TypeParameterRef toRef() {
        return new TypeParameterRef(name);
    }

    @Override
    public String toString() {
        return name + (extendsType != null ? " extends " + extendsType : "");
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder extends ObjectBuilderBase<TypeParameterDefinition, Builder> {
        private String name;
        private Type extendsType;

        private Builder() {}

        @Nonnull
        @Override
        protected TypeParameterDefinition construct() {
            return new TypeParameterDefinition(this);
        }

        @Nonnull
        public Builder withName(@Nonnull String name) {
            this.name = Strings.requireNonBlank(name, "name must not be blank");
            return this;
        }

        @Nonnull
        public Builder withExtends(@Nullable Type type) {
            this.extendsType = type;
            return this;
        }
    }
}
