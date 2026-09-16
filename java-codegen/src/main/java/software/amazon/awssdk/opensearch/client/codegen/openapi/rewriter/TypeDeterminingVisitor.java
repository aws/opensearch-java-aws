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
package software.amazon.awssdk.opensearch.client.codegen.openapi.rewriter;

import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import software.amazon.awssdk.opensearch.client.codegen.openapi.OpenApiSchema;
import software.amazon.awssdk.opensearch.client.codegen.openapi.OpenApiSchemaType;
import software.amazon.awssdk.opensearch.client.codegen.openapi.walker.OpenApiVisitorBase;
import software.amazon.awssdk.opensearch.client.codegen.openapi.walker.OpenApiWalker;

public final class TypeDeterminingVisitor extends OpenApiVisitorBase {
    @Nonnull
    private final OpenApiWalker walker;

    public TypeDeterminingVisitor(@Nonnull OpenApiWalker walker) {
        this.walker = Objects.requireNonNull(walker, "walker cannot be null");
    }

    @Override
    @Nonnull
    public OpenApiSchema visitSchemaEnd(@Nonnull OpenApiSchema schema) {
        if (schema.getTypes().isEmpty()) {
            schema.setTypes(determineTypes(schema).orElse(null));
        }
        return schema;
    }

    private Optional<Set<OpenApiSchemaType>> determineTypes(OpenApiSchema schema) {
        if (schema.has$ref()) {
            return walker.walkSchema(schema.resolve(), this).getTypes();
        } else if (schema.hasAllOf()) {
            Set<OpenApiSchemaType> types = null;
            for (var subSchema : schema.getAllOf().orElseThrow()) {
                if (types == null) {
                    types = new HashSet<>(subSchema.getTypes().orElseThrow());
                } else {
                    types.retainAll(subSchema.getTypes().orElseThrow());
                }
            }
            return Optional.ofNullable(types);
        } else if (schema.hasAnyOf() || schema.hasOneOf()) {
            return Optional.of(
                schema.getAnyOf()
                    .or(schema::getOneOf)
                    .orElseThrow()
                    .stream()
                    .flatMap(s -> s.getTypes().orElseThrow().stream())
                    .collect(Collectors.toSet())
            );
        } else if (schema.has$extends()) {
            return walker.walkSchema(schema.get$extends().orElseThrow(), this).getTypes();
        } else {
            return Optional.of(OpenApiSchemaType.ALL_TYPES);
        }
    }
}
