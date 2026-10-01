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
package software.amazon.opensearch.client.codegen.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class NamespaceTests {
    @Test
    public void customRootPackageAndClientNameAreApplied() {
        var root = new Namespace("software.amazon.opensearch.client.aos", "OpenSearchAos");

        assertEquals("software.amazon.opensearch.client.aos", root.getPackageName());
        assertEquals("OpenSearchAosClient", root.getClientClassName(false, false));
        assertEquals("OpenSearchAosAsyncClient", root.getClientClassName(true, false));
        assertEquals("OpenSearchAosClientBase", root.getClientClassName(false, true));

        var indices = root.child("indices");
        assertEquals("software.amazon.opensearch.client.aos.indices", indices.getPackageName());
        assertEquals("OpenSearchIndicesClient", indices.getClientClassName(false, false));
    }
}
