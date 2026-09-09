/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package software.amazon.awssdk.opensearch.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Map;
import org.apache.hc.client5.http.auth.AuthScope;
import org.apache.hc.client5.http.auth.UsernamePasswordCredentials;
import org.apache.hc.client5.http.impl.auth.BasicCredentialsProvider;
import org.apache.hc.core5.http.HttpHost;
import org.junit.Assume;
import org.junit.Test;
import software.amazon.awssdk.http.SdkHttpClient;
import software.amazon.awssdk.http.urlconnection.UrlConnectionHttpClient;
import software.amazon.awssdk.opensearch.client.aos.OpenSearchAosClient;
import software.amazon.awssdk.opensearch.client.aos.core.InfoResponse;
import software.amazon.awssdk.opensearch.client.aoss.OpenSearchAossClient;
import software.amazon.awssdk.opensearch.client.aoss.core.SearchResponse;
import software.amazon.awssdk.opensearch.client.transport.httpclient5.ApacheHttpClient5Transport;
import software.amazon.awssdk.opensearch.client.transport.httpclient5.ApacheHttpClient5TransportBuilder;
import software.amazon.awssdk.regions.Region;

/**
 * Opt-in smoke tests for real AOS and AOSS resources.
 *
 * <p>AOS requires {@code OPENSEARCH_TEST_AOS_ENDPOINT}, {@code OPENSEARCH_TEST_AOS_USERNAME}, and
 * {@code OPENSEARCH_TEST_AOS_PASSWORD}. AOSS requires {@code OPENSEARCH_TEST_AOSS_ENDPOINT} and credentials available
 * through the AWS SDK default credential provider chain.
 */
public class AwsDistributionClientRealResourceIT {
    @Test
    public void aosInfoWithBasicAuth() throws Exception {
        String endpoint = System.getenv("OPENSEARCH_TEST_AOS_ENDPOINT");
        String username = System.getenv("OPENSEARCH_TEST_AOS_USERNAME");
        String password = System.getenv("OPENSEARCH_TEST_AOS_PASSWORD");
        Assume.assumeNotNull(endpoint, username, password);

        HttpHost host = HttpHost.create(endpoint);
        BasicCredentialsProvider credentials = new BasicCredentialsProvider();
        credentials.setCredentials(new AuthScope(host), new UsernamePasswordCredentials(username, password.toCharArray()));

        try (
            ApacheHttpClient5Transport transport = ApacheHttpClient5TransportBuilder.builder(host)
                .setHttpClientConfigCallback(builder -> builder.setDefaultCredentialsProvider(credentials))
                .build()
        ) {
            OpenSearchAosClient client = new OpenSearchAosClient(transport);
            InfoResponse response = client.info();
            assertNotNull(response.clusterName());
            assertTrue(response.version().number().startsWith("3."));
        }
    }

    @Test
    public void aossSearchWithSigV4() throws Exception {
        String endpoint = System.getenv("OPENSEARCH_TEST_AOSS_ENDPOINT");
        Assume.assumeNotNull(endpoint);

        try (SdkHttpClient httpClient = UrlConnectionHttpClient.builder().build()) {
            OpenSearchAossClient client = OpenSearchAossClient.create(httpClient, endpoint, Region.US_EAST_1, null);
            SearchResponse<Map> response = client.search(request -> request, Map.class);
            assertNotNull(response.hits());
        }
    }
}
