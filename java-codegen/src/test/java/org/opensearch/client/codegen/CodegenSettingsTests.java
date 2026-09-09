/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class CodegenSettingsTests {
    @Test
    public void validatesJavaPackages() {
        assertEquals(
            "software.amazon.awssdk.opensearch.client.aos",
            CodegenSettings.requireJavaPackage("software.amazon.awssdk.opensearch.client.aos", "package")
        );
        assertThrows(IllegalArgumentException.class, () -> CodegenSettings.requireJavaPackage("not-a-package", "package"));
    }

    @Test
    public void validatesRootClientNames() {
        assertEquals("OpenSearchAoss", CodegenSettings.requireJavaTypePrefix("OpenSearchAoss", "client name"));
        assertThrows(IllegalArgumentException.class, () -> CodegenSettings.requireJavaTypePrefix("OpenSearch-Aoss", "client name"));
    }
}
