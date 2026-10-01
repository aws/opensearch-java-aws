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

import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import software.amazon.opensearch.client.codegen.openapi.reference.RelativeRef;
import software.amazon.opensearch.client.codegen.utils.json.JsonGenerator;

public abstract class OpenApiRefElement<Self extends OpenApiRefElement<Self>> extends OpenApiElement<Self> {
    @Nullable
    private RelativeRef $ref;
    @Nonnull
    private final Class<Self> clazz;

    OpenApiRefElement(@Nonnull AbstractBuilder<Self, ?> builder, @Nonnull Class<Self> clazz) {
        super(builder);
        this.$ref = builder.$ref;
        this.clazz = Objects.requireNonNull(clazz, "clazz must not be null");
    }

    OpenApiRefElement(@Nullable String $ref, @Nonnull Class<Self> clazz) {
        this.$ref = ifNonnull($ref, RelativeRef::parse);
        this.clazz = Objects.requireNonNull(clazz, "clazz must not be null");
    }

    public boolean has$ref() {
        return $ref != null;
    }

    @Nonnull
    public Optional<RelativeRef> get$ref() {
        return Optional.ofNullable($ref);
    }

    public void set$ref(@Nullable RelativeRef $ref) {
        this.$ref = $ref;
    }

    @Nonnull
    public Self resolve() {
        if ($ref == null) {
            return self();
        }
        return resolve(getSpecification().orElseThrow(() -> new IllegalStateException("Cannot resolve $ref without a specification")));
    }

    @Nonnull
    public Self resolve(@Nonnull OpenApiSpecification specification) {
        if ($ref == null) {
            return self();
        }
        Objects.requireNonNull(specification, "specification must not be null");
        var resolved = $ref.resolveIn(specification).orElseThrow(() -> new IllegalStateException("Failed to resolve $ref: " + $ref));
        if (!clazz.isInstance(resolved)) {
            throw new IllegalStateException("Resolved $ref is not an instance of " + clazz.getSimpleName());
        }
        return clazz.cast(resolved);
    }

    @Override
    protected void toJsonInner(JsonGenerator generator) {
        if ($ref != null) {
            generator.writeField("$ref", $ref.toString());
        }
    }

    @Nonnull
    <Builder extends AbstractBuilder<Self, Builder>> Builder toBuilder(@Nonnull Builder builder) {
        return super.toBuilder(builder).with$ref($ref);
    }

    public static abstract class AbstractBuilder<
        Element extends OpenApiRefElement<Element>,
        Builder extends AbstractBuilder<Element, Builder>> extends OpenApiElement.AbstractBuilder<Element, Builder> {
        @Nullable
        private RelativeRef $ref;

        AbstractBuilder() {}

        @Nonnull
        public Builder with$ref(@Nullable RelativeRef $ref) {
            this.$ref = $ref;
            return self();
        }
    }
}
