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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.List;
import org.junit.jupiter.api.Test;
import software.amazon.opensearch.client.codegen.openapi.OpenApiSchema;
import software.amazon.opensearch.client.codegen.openapi.reference.RelativeRef;

public class ExtendsAllOfRewritingVisitorTests {
    @Test
    public void rewritesSingleRefAllOfAsExtends() {
        var parent = OpenApiSchema.builder().with$ref(RelativeRef.parse("#/components/schemas/_common___Parent")).build();
        var schema = OpenApiSchema.builder().withAllOf(List.of(parent)).build();

        var rewritten = new ExtendsAllOfRewritingVisitor().visitSchemaEnd(schema);

        assertSame(schema, rewritten);
        assertFalse(rewritten.hasAllOf());
        assertSame(parent, rewritten.get$extends().orElseThrow());
    }

    @Test
    public void leavesSingleInlineAllOfUnchanged() {
        var schema = OpenApiSchema.builder().withAllOf(List.of(OpenApiSchema.emptyObject())).build();

        var rewritten = new ExtendsAllOfRewritingVisitor().visitSchemaEnd(schema);

        assertEquals(1, rewritten.getAllOf().orElseThrow().size());
        assertFalse(rewritten.has$extends());
    }
}
