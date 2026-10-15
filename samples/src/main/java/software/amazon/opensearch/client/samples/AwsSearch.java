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
package software.amazon.opensearch.client.samples;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.http.urlconnection.UrlConnectionHttpClient;
import software.amazon.awssdk.regions.Region;
import software.amazon.opensearch.client.json.JsonData;
import software.amazon.opensearch.client.json.jackson3.JacksonJsonpMapper;
import software.amazon.opensearch.client.transport.aws.AwsSdk2TransportOptions;

/**
 * Searches an existing index with IAM authentication.
 * Run with: {@code ./gradlew :samples:run -Dsamples.mainClass=AwsSearch --args=aos}
 * or use {@code --args=aoss} for OpenSearch Serverless.
 */
public class AwsSearch {
    private static final Logger LOGGER = LogManager.getLogger(AwsSearch.class);

    public static void main(String[] args) throws Exception {
        var distribution = args.length == 0 ? "aos" : args[0];
        if (args.length > 1 || (!"aos".equals(distribution) && !"aoss".equals(distribution))) {
            throw new IllegalArgumentException("Expected aos or aoss");
        }
        var endpoint = requiredEnvironmentVariable("OPENSEARCH_ENDPOINT");
        var index = requiredEnvironmentVariable("OPENSEARCH_INDEX");
        var region = Region.of(requiredEnvironmentVariable("AWS_REGION"));

        try (var httpClient = UrlConnectionHttpClient.create(); var credentials = DefaultCredentialsProvider.create()) {
            var options = AwsSdk2TransportOptions.builder().setCredentials(credentials).setMapper(new JacksonJsonpMapper()).build();

            if ("aoss".equals(distribution)) {
                // The Serverless client signs requests with the aoss service name.
                var client = software.amazon.opensearch.client.aoss.OpenSearchClient.create(httpClient, endpoint, region, options);
                var response = client.search(s -> s.index(index).size(10).query(q -> q.matchAll(m -> m)), JsonData.class);
                LOGGER.info("AOSS returned {} hits", response.hits().hits().size());
                response.hits().hits().forEach(hit -> LOGGER.info("Document {}: {}", hit.id(), hit.source()));
            } else {
                // The provisioned-domain client signs requests with the es service name.
                var client = software.amazon.opensearch.client.aos.OpenSearchClient.create(httpClient, endpoint, region, options);
                var response = client.search(s -> s.index(index).size(10).query(q -> q.matchAll(m -> m)), JsonData.class);
                LOGGER.info("AOS returned {} hits", response.hits().hits().size());
                response.hits().hits().forEach(hit -> LOGGER.info("Document {}: {}", hit.id(), hit.source()));
            }
        }
    }

    private static String requiredEnvironmentVariable(String name) {
        var value = System.getenv(name);
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Set the " + name + " environment variable");
        }
        return value;
    }
}
