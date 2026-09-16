/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package software.amazon.awssdk.opensearch.client.transport.aws;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

public class AwsSdk2TransportHostTests {
    @Test
    public void acceptsBareHost() {
        assertEquals("collection.aoss.us-east-1.on.aws", AwsSdk2Transport.normalizeHost("collection.aoss.us-east-1.on.aws"));
    }

    @Test
    public void acceptsHttpsEndpoint() {
        assertEquals("collection.aoss.us-east-1.on.aws", AwsSdk2Transport.normalizeHost("https://collection.aoss.us-east-1.on.aws"));
    }

    @Test
    public void acceptsHttpsEndpointWithPortAndTrailingSlash() {
        assertEquals("localhost:9200", AwsSdk2Transport.normalizeHost("https://localhost:9200/"));
    }

    @Test
    public void rejectsHttpEndpoint() {
        assertThrows(IllegalArgumentException.class, () -> AwsSdk2Transport.normalizeHost("http://collection.aoss.us-east-1.on.aws"));
    }

    @Test
    public void rejectsEndpointWithPath() {
        assertThrows(
            IllegalArgumentException.class,
            () -> AwsSdk2Transport.normalizeHost("https://collection.aoss.us-east-1.on.aws/index")
        );
    }
}
