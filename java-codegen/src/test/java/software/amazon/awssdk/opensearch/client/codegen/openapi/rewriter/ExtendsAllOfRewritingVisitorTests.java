/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package software.amazon.awssdk.opensearch.client.codegen.openapi.rewriter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.List;
import org.junit.jupiter.api.Test;
import software.amazon.awssdk.opensearch.client.codegen.openapi.OpenApiSchema;
import software.amazon.awssdk.opensearch.client.codegen.openapi.reference.RelativeRef;

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
