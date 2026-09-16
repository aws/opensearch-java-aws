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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import software.amazon.awssdk.http.SdkHttpClient;
import software.amazon.awssdk.http.apache.ApacheHttpClient;
import software.amazon.awssdk.http.apache5.Apache5HttpClient;
import software.amazon.awssdk.http.urlconnection.UrlConnectionHttpClient;
import software.amazon.awssdk.utils.SdkAutoCloseable;

public class AwsSdk2TransportApacheDetectionTests {
    @Test
    public void nullReturnsFalse() {
        assertFalse(AwsSdk2Transport.isAwsSdkApacheHttpClient(null));
    }

    @Test
    public void urlConnectionReturnsFalse() {
        try (SdkHttpClient client = UrlConnectionHttpClient.builder().build()) {
            assertFalse(AwsSdk2Transport.isAwsSdkApacheHttpClient(client));
        }
    }

    @Test
    public void apacheV4ReturnsTrue() {
        try (SdkHttpClient client = ApacheHttpClient.builder().build()) {
            assertTrue(AwsSdk2Transport.isAwsSdkApacheHttpClient(client));
        }
    }

    @Test
    public void apacheV5ReturnsTrue() {
        try (SdkHttpClient client = Apache5HttpClient.builder().build()) {
            assertTrue(AwsSdk2Transport.isAwsSdkApacheHttpClient(client));
        }
    }

    @Test
    public void nonHttpClientWithMatchingNameReturnsFalse() {
        SdkAutoCloseable notAnHttpClient = () -> {};
        assertFalse(AwsSdk2Transport.isAwsSdkApacheHttpClient(notAnHttpClient));
    }
}
