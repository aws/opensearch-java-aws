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

import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Nonnull;
import software.amazon.opensearch.client.codegen.utils.Either;
import software.amazon.opensearch.client.codegen.utils.builder.ObjectBuilderBase;

public final class TypeParameterDiamond {
    @Nonnull
    private final Either<TypeRef[], TypeParameterDefinition[]> params;

    private TypeParameterDiamond(Builder builder) {
        this.params = Objects.requireNonNull(builder.params, "params must not be null");
    }

    public void toString(@Nonnull StringBuilder out) {
        Objects.requireNonNull(out, "out must not be null");
        var params = this.params.fold(Function.identity(), Function.identity());
        out.append("<");
        for (var i = 0; i < params.length; i++) {
            if (i > 0) {
                out.append(", ");
            }
            out.append(params[i].toString());
        }
        out.append(">");
    }

    public TypeRef[] getParamTypes() {
        return params.getLeft();
    }

    public TypeParameterDefinition[] getTypeParameterDefinitions() {
        return params.getRight();
    }

    @Override
    public @Nonnull String toString() {
        var out = new StringBuilder();
        toString(out);
        return out.toString();
    }

    @Nonnull
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends ObjectBuilderBase<TypeParameterDiamond, Builder> {
        private Either<TypeRef[], TypeParameterDefinition[]> params;

        private Builder() {}

        @Nonnull
        @Override
        protected TypeParameterDiamond construct() {
            return new TypeParameterDiamond(this);
        }

        @Nonnull
        public Builder withParams(@Nonnull TypeRef... params) {
            this.params = Either.left(Objects.requireNonNull(params, "params must not be null"));
            return this;
        }

        @Nonnull
        public Builder withParams(@Nonnull TypeParameterDefinition... params) {
            this.params = Either.right(Objects.requireNonNull(params, "params must not be null"));
            return this;
        }
    }
}
