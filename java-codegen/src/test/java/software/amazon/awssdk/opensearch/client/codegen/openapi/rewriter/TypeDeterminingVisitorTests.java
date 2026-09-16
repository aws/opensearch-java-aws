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

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import software.amazon.awssdk.opensearch.client.codegen.openapi.OpenApiSchema;
import software.amazon.awssdk.opensearch.client.codegen.openapi.OpenApiSchemaType;
import software.amazon.awssdk.opensearch.client.codegen.openapi.walker.OpenApiWalker;

public class TypeDeterminingVisitorTests {
    @Test
    public void inheritsTypeFromExtendsSchema() {
        var schema = OpenApiSchema.builder().with$extends(OpenApiSchema.emptyObject()).build();

        var rewritten = new TypeDeterminingVisitor(new OpenApiWalker()).visitSchemaEnd(schema);

        assertEquals(OpenApiSchemaType.Object, rewritten.getSingleType().orElseThrow());
    }
}
