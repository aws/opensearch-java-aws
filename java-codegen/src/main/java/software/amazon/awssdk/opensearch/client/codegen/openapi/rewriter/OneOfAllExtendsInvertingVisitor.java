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
import javax.annotation.Nonnull;
import software.amazon.awssdk.opensearch.client.codegen.openapi.OpenApiSchema;
import software.amazon.awssdk.opensearch.client.codegen.openapi.walker.OpenApiVisitorBase;

public class OneOfAllExtendsInvertingVisitor extends OpenApiVisitorBase {
    @Nonnull
    @Override
    public OpenApiSchema visitSchemaEnd(@Nonnull OpenApiSchema schema) {
        if (schema.hasOneOf()) {
            var oneOf = schema.getOneOf().orElseThrow();
            var count = oneOf.size();
            var newOneOf = new OpenApiSchema[count];
            OpenApiSchema $extends = null;

            for (var i = 0; i < count; ++i) {
                var s = oneOf.get(i);
                var s$extends = s.get$extends().orElse(null);

                if (s$extends == null) {
                    return schema;
                }

                if ($extends == null) {
                    $extends = s$extends;
                } else if (!s$extends.get$ref().orElseThrow().equals($extends.get$ref().orElseThrow())) {
                    return schema;
                }

                newOneOf[i] = s.toBuilder().with$extends((OpenApiSchema) null).build();
            }

            return schema.toBuilder().withOneOf(List.of(newOneOf)).with$extends($extends).build();
        }

        return schema;
    }
}
