/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package software.amazon.awssdk.opensearch.client.codegen.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class NamespaceTests {
    @Test
    public void customRootPackageAndClientNameAreApplied() {
        var root = new Namespace("software.amazon.awssdk.opensearch.client.aos", "OpenSearchAos");

        assertEquals("software.amazon.awssdk.opensearch.client.aos", root.getPackageName());
        assertEquals("OpenSearchAosClient", root.getClientClassName(false, false));
        assertEquals("OpenSearchAosAsyncClient", root.getClientClassName(true, false));
        assertEquals("OpenSearchAosClientBase", root.getClientClassName(false, true));

        var indices = root.child("indices");
        assertEquals("software.amazon.awssdk.opensearch.client.aos.indices", indices.getPackageName());
        assertEquals("OpenSearchIndicesClient", indices.getClientClassName(false, false));
    }
}
