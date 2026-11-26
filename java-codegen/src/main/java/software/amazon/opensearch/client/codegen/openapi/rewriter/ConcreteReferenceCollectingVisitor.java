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
package software.amazon.opensearch.client.codegen.openapi.rewriter;

import java.util.HashSet;
import java.util.Set;
import javax.annotation.Nonnull;
import software.amazon.opensearch.client.codegen.openapi.JsonPointer;
import software.amazon.opensearch.client.codegen.openapi.OpenApiSchema;
import software.amazon.opensearch.client.codegen.openapi.walker.OpenApiVisitorBase;

/**
 * Collects the schemas that another component schema uses directly, rather than as its base. A response body referencing a schema is not
 * counted, because its class extends that schema.
 */
public final class ConcreteReferenceCollectingVisitor extends OpenApiVisitorBase {
    private static final String COMPONENTS_SCHEMAS_PREFIX = OpenApiSchema.COMPONENTS_SCHEMAS + "/";

    private final Set<JsonPointer> referenced = new HashSet<>();

    @Nonnull
    public Set<JsonPointer> getReferenced() {
        return referenced;
    }

    @Override
    public OpenApiSchema visitSchemaStart(@Nonnull OpenApiSchema schema) {
        var pointer = schema.getPointer();
        if (schema.has$ref()
            && pointer.toString().startsWith(COMPONENTS_SCHEMAS_PREFIX)
            && !pointer.getLastKey().map("$extends"::equals).orElse(false)) {
            referenced.add(schema.resolve().getPointer());
        }
        return null;
    }
}
