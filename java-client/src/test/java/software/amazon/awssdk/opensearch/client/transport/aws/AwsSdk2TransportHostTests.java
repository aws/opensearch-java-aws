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
