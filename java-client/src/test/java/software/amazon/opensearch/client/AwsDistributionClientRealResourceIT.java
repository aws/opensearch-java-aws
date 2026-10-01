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
package software.amazon.opensearch.client;

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
import software.amazon.awssdk.regions.Region;
import software.amazon.opensearch.client.aos.OpenSearchClient;
import software.amazon.opensearch.client.aos.core.InfoResponse;
import software.amazon.opensearch.client.aoss.core.SearchResponse;
import software.amazon.opensearch.client.transport.httpclient5.ApacheHttpClient5Transport;
import software.amazon.opensearch.client.transport.httpclient5.ApacheHttpClient5TransportBuilder;

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
            OpenSearchClient client = new OpenSearchClient(transport);
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
            software.amazon.opensearch.client.aoss.OpenSearchClient client = software.amazon.opensearch.client.aoss.OpenSearchClient.create(
                httpClient,
                endpoint,
                Region.US_EAST_1,
                null
            );
            SearchResponse<Map> response = client.search(request -> request, Map.class);
            assertNotNull(response.hits());
        }
    }
}
