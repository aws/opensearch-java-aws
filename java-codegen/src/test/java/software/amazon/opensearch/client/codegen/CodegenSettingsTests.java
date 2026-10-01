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
package software.amazon.opensearch.client.codegen;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class CodegenSettingsTests {
    @Test
    public void validatesJavaPackages() {
        assertEquals(
            "software.amazon.opensearch.client.aos",
            CodegenSettings.requireJavaPackage("software.amazon.opensearch.client.aos", "package")
        );
        assertThrows(IllegalArgumentException.class, () -> CodegenSettings.requireJavaPackage("not-a-package", "package"));
    }

    @Test
    public void validatesRootClientNames() {
        assertEquals("OpenSearchAoss", CodegenSettings.requireJavaTypePrefix("OpenSearchAoss", "client name"));
        assertThrows(IllegalArgumentException.class, () -> CodegenSettings.requireJavaTypePrefix("OpenSearch-Aoss", "client name"));
    }
}
