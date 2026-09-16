/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
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
