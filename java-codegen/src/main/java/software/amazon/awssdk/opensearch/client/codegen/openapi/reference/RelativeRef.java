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
package software.amazon.awssdk.opensearch.client.codegen.openapi.reference;

import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import software.amazon.awssdk.opensearch.client.codegen.openapi.JsonPointer;
import software.amazon.awssdk.opensearch.client.codegen.openapi.OpenApiElement;
import software.amazon.awssdk.opensearch.client.codegen.openapi.OpenApiSpecification;
import software.amazon.awssdk.opensearch.client.codegen.utils.Strings;

public final class RelativeRef {
    @Nonnull
    public static RelativeRef parse(@Nonnull String $ref) {
        Objects.requireNonNull($ref, "$ref must not be null");
        var fragmentIdx = $ref.indexOf('#');
        if (fragmentIdx < 0) throw new IllegalArgumentException("$ref must be a valid relative reference");

        var relativeLocation = $ref.substring(0, fragmentIdx);
        var pointer = JsonPointer.parse($ref.substring(fragmentIdx + 1));
        return new RelativeRef(relativeLocation, pointer);
    }

    @Nullable
    private final String relativeLocation;
    @Nonnull
    private final JsonPointer pointer;

    private RelativeRef(@Nullable String relativeLocation, @Nonnull JsonPointer pointer) {
        this.relativeLocation = relativeLocation;
        this.pointer = Objects.requireNonNull(pointer, "pointer must not be null");
    }

    public Optional<OpenApiElement<?>> resolveIn(OpenApiSpecification specification) {
        Objects.requireNonNull(specification, "specification must not be null");

        if (!Strings.isNullOrEmpty(relativeLocation)) {
            specification = OpenApiSpecification.retrieve(specification.getLocation().resolve(relativeLocation));
        }

        return specification.getElement(pointer);
    }

    @Nonnull
    public JsonPointer getPointer() {
        return pointer;
    }

    @Override
    public String toString() {
        return relativeLocation + '#' + pointer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        RelativeRef that = (RelativeRef) o;

        return new EqualsBuilder().append(relativeLocation, that.relativeLocation).append(pointer, that.pointer).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(relativeLocation).append(pointer).toHashCode();
    }
}
