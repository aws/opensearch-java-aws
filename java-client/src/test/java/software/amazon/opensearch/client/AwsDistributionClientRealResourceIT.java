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
import org.junit.Assume;
import org.junit.Test;
import software.amazon.awssdk.http.SdkHttpClient;
import software.amazon.awssdk.http.urlconnection.UrlConnectionHttpClient;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.regions.providers.DefaultAwsRegionProviderChain;
import software.amazon.opensearch.client.aos.OpenSearchClient;
import software.amazon.opensearch.client.aos.core.InfoResponse;
import software.amazon.opensearch.client.aoss.core.SearchResponse;

/**
 * Opt-in smoke tests for real AOS and AOSS resources.
 *
 * <p>AOS requires {@code OPENSEARCH_TEST_AOS_ENDPOINT} and AOSS requires {@code OPENSEARCH_TEST_AOSS_ENDPOINT}. Both
 * sign requests with SigV4 using credentials and the region (for example {@code AWS_REGION}) from the AWS SDK default
 * provider chains.
 */
public class AwsDistributionClientRealResourceIT {
    @Test
    public void aosInfoWithSigV4() throws Exception {
        String endpoint = System.getenv("OPENSEARCH_TEST_AOS_ENDPOINT");
        Assume.assumeNotNull(endpoint);

        try (SdkHttpClient httpClient = UrlConnectionHttpClient.builder().build()) {
            OpenSearchClient client = OpenSearchClient.create(httpClient, endpoint, region(), null);
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
                region(),
                null
            );
            SearchResponse<Map> response = client.search(request -> request, Map.class);
            assertNotNull(response.hits());
        }
    }

    private static Region region() {
        return new DefaultAwsRegionProviderChain().getRegion();
    }
}
