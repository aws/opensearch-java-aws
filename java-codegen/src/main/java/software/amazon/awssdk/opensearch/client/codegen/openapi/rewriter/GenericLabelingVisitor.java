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

import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Stream;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import software.amazon.awssdk.opensearch.client.codegen.openapi.OpenApiSchema;
import software.amazon.awssdk.opensearch.client.codegen.openapi.walker.OpenApiVisitorBase;
import software.amazon.awssdk.opensearch.client.codegen.openapi.walker.OpenApiWalker;
import software.amazon.awssdk.opensearch.client.codegen.openapi.walker.ZippedOpenApiVisitorBase;
import software.amazon.awssdk.opensearch.client.codegen.openapi.walker.ZippedOpenApiWalker;

public final class GenericLabelingVisitor extends OpenApiVisitorBase {
    @Nonnull
    private final OpenApiWalker walker;

    public GenericLabelingVisitor(@Nonnull OpenApiWalker walker) {
        this.walker = Objects.requireNonNull(walker, "walker cannot be null");
    }

    private OpenApiSchema resolve(OpenApiSchema schema) {
        return schema.has$ref() ? walker.walkSchema(schema.resolve(), this) : schema;
    }

    @Override
    @Nonnull
    public OpenApiSchema visitSchemaEnd(@Nonnull OpenApiSchema schema) {
        if (schema.has$ref()) {
            var resolved = resolve(schema);
            schema.setIsGeneric(resolved.isGeneric());
            schema.setIsInstantiatedGeneric(resolved.isInstantiatedGeneric());
            schema.setIsGenericTypeParameter(resolved.isGenericTypeParameter());
        } else if (schema.isGenericTypeParameter()) {
            schema.setIsGeneric(true);
            schema.setIsInstantiatedGeneric(false);
        } else {
            schema.setIsInstantiatedGeneric(isInstantiatedGeneric(schema));
            schema.setIsGeneric(isGeneric(schema));
        }
        return schema;
    }

    private boolean isInstantiatedGeneric(OpenApiSchema schema) {
        var $extends = schema.get$extends().orElse(null);
        if ($extends == null || !$extends.isGeneric()) {
            return false;
        }
        var visitor = new IsInstantiatedGenericVisitor();
        new ZippedOpenApiWalker().walkSchema(resolve($extends), schema, visitor);
        return visitor.result != null && visitor.result;
    }

    private static final class IsInstantiatedGenericVisitor extends ZippedOpenApiVisitorBase {
        private Boolean result = null;

        @Override
        public void visitSchemaEnd(@Nullable OpenApiSchema left, @Nullable OpenApiSchema right) {
            boolean thisPair;

            if (left == null) {
                thisPair = true;
            } else if (left.getPointer().getLastKey().map("$extends"::equals).orElse(false)) {
                return;
            } else if (!left.isGeneric()) {
                thisPair = right == null || left.isEquivalentTo(right);
            } else if (right == null) {
                thisPair = false;
            } else if (left.isGenericTypeParameter()) {
                thisPair = true;
            } else if (left.hasOneOf()) {
                thisPair = right.hasOneOf() && left.getOneOf().orElseThrow().size() == right.getOneOf().orElseThrow().size();
            } else {
                var lTypes = left.getTypes().orElseThrow();
                var rTypes = right.getTypes().orElseThrow();
                thisPair = lTypes.equals(rTypes);
            }

            if (result == null) {
                result = thisPair;
            } else {
                result &= thisPair;
            }
        }
    }

    private boolean isGeneric(OpenApiSchema schema) {
        if (schema.isInstantiatedGeneric()) {
            var visitor = new ZippedOpenApiVisitorBase() {
                private boolean result = false;

                @Override
                public void visitSchemaEnd(@Nullable OpenApiSchema left, @Nullable OpenApiSchema right) {
                    if (left != null && left.isGenericTypeParameter()) {
                        result |= right == null || right.isGenericTypeParameter();
                    }
                }
            };
            new ZippedOpenApiWalker().walkSchema(resolve(schema.get$extends().orElseThrow()), schema, visitor);
            return visitor.result;
        }

        return Stream.of(
            schema.getAllOf().stream().flatMap(List::stream),
            schema.getAnyOf().stream().flatMap(List::stream),
            schema.getOneOf().stream().flatMap(List::stream),
            schema.getItems().stream(),
            schema.getPropertyNames().stream(),
            schema.getAdditionalProperties().stream(),
            schema.getProperties().stream().flatMap(m -> m.values().stream()),
            schema.get$extends().stream()
        ).flatMap(Function.identity()).anyMatch(OpenApiSchema::isGeneric);
    }
}
