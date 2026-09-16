/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package software.amazon.awssdk.opensearch.client.transport.aws;

import static org.junit.Assert.assertEquals;

import java.net.URI;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.junit.Test;
import software.amazon.awssdk.opensearch.client.transport.TransportOptions;

public class AwsSdk2TransportQueryParametersTests {
    @Test
    public void appendsMultipleOptionParametersWithAmpersands() throws Exception {
        StringBuilder url = new StringBuilder("https://example.com/_search?pretty=true");
        TransportOptions transportOptions = TransportOptions.builder()
            .setParameter("first", "one")
            .setParameter("second", "two words")
            .build();
        TransportOptions requestOptions = TransportOptions.builder().setParameter("third", "three").build();

        AwsSdk2Transport.applyOptionsParams(url, transportOptions);
        AwsSdk2Transport.applyOptionsParams(url, requestOptions);

        assertEquals(1, url.chars().filter(character -> character == '?').count());
        Set<String> queryParameters = new HashSet<>(Arrays.asList(URI.create(url.toString()).getRawQuery().split("&")));
        assertEquals(new HashSet<>(Arrays.asList("pretty=true", "first=one", "second=two+words", "third=three")), queryParameters);
    }
}
