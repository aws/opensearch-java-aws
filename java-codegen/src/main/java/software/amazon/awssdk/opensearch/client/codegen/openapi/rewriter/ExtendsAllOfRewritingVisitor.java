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

import javax.annotation.Nonnull;
import software.amazon.awssdk.opensearch.client.codegen.openapi.OpenApiSchema;
import software.amazon.awssdk.opensearch.client.codegen.openapi.walker.OpenApiVisitorBase;

public final class ExtendsAllOfRewritingVisitor extends OpenApiVisitorBase {
    @Nonnull
    @Override
    public OpenApiSchema visitSchemaEnd(@Nonnull OpenApiSchema schema) {
        if (schema.hasAllOf()) {
            var allOf = schema.getAllOf().orElseThrow();
            if (allOf.size() == 1 && allOf.get(0).has$ref()) {
                schema.setAllOf(null);
                schema.set$extends(allOf.get(0));
            } else if (allOf.size() == 2 && allOf.get(0).has$ref()) {
                String title = schema.getTitle().orElse(null);
                String description = schema.getDescription().orElse(null);
                schema = allOf.get(1);
                schema.set$extends(allOf.get(0));
                if (title != null) {
                    schema.setTitle(title);
                }
                if (description != null) {
                    schema.setDescription(description);
                }
            }
        }

        return schema;
    }
}
