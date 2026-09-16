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

import java.util.Collections;
import javax.annotation.Nonnull;
import software.amazon.awssdk.opensearch.client.codegen.openapi.JsonPointer;
import software.amazon.awssdk.opensearch.client.codegen.openapi.OpenApiResponse;
import software.amazon.awssdk.opensearch.client.codegen.openapi.OpenApiSchema;
import software.amazon.awssdk.opensearch.client.codegen.openapi.reference.RelativeRef;
import software.amazon.awssdk.opensearch.client.codegen.openapi.walker.OpenApiVisitorBase;

public final class ResponseSchemaVisitor extends OpenApiVisitorBase {
    @Nonnull
    @Override
    public OpenApiResponse visitResponseEnd(@Nonnull OpenApiResponse response) {
        response.getContent().ifPresent(content -> {
            content.entries().forEach(entry -> {
                var mediaType = entry.getValue();
                var schema = mediaType.getSchema().orElse(null);

                if (schema != null
                    && schema.get$ref()
                        .map(RelativeRef::getPointer)
                        .flatMap(JsonPointer::getLastKey)
                        .map(k -> k.endsWith("Base"))
                        .orElse(false)) {
                    mediaType.setSchema(
                        OpenApiSchema.builder()
                            .withTypes(schema.getTypes().orElse(null))
                            .with$extends(schema)
                            .withProperties(Collections.emptyMap())
                            .withRequired(Collections.emptySet())
                            .build()
                    );
                }
            });
        });
        return response;
    }
}
