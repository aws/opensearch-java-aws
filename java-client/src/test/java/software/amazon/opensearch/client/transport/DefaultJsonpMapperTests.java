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
package software.amazon.opensearch.client.transport;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.apache.hc.core5.http.HttpHost;
import org.junit.Test;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.http.SdkHttpClient;
import software.amazon.awssdk.http.urlconnection.UrlConnectionHttpClient;
import software.amazon.awssdk.regions.Region;
import software.amazon.opensearch.client.aos.OpenSearchAsyncClient;
import software.amazon.opensearch.client.aos.OpenSearchClient;
import software.amazon.opensearch.client.transport.aws.AwsSdk2Transport;
import software.amazon.opensearch.client.transport.aws.AwsSdk2TransportOptions;
import software.amazon.opensearch.client.transport.httpclient5.ApacheHttpClient5Transport;
import software.amazon.opensearch.client.transport.httpclient5.ApacheHttpClient5TransportBuilder;

public class DefaultJsonpMapperTests {
    private static final String SEARCH_RESPONSE = "{\"took\":1,\"timed_out\":false,"
        + "\"_shards\":{\"total\":1,\"successful\":1,\"skipped\":0,\"failed\":0},"
        + "\"hits\":{\"total\":{\"value\":1,\"relation\":\"eq\"},\"max_score\":1.0,"
        + "\"hits\":[{\"_index\":\"test-index\",\"_id\":\"1\",\"_score\":1.0,"
        + "\"_source\":{\"title\":\"example\"}}]}}";
    private static final String INDEX_RESPONSE = "{\"_index\":\"test-index\",\"_id\":\"1\","
        + "\"_version\":1,\"result\":\"created\",\"_shards\":{\"total\":1,\"successful\":1,\"failed\":0},"
        + "\"_seq_no\":0,\"_primary_term\":1}";

    @Test
    public void awsDefaultMapperDeserializesSearchDocuments() throws Exception {
        assertAwsExchanges(false);
    }

    @Test
    public void awsDefaultMapperSerializesIndexedDocuments() throws Exception {
        assertAwsExchanges(true);
    }

    @Test
    public void apacheDefaultMapperDeserializesSearchDocuments() throws Exception {
        assertApacheExchanges(false);
    }

    @Test
    public void apacheDefaultMapperSerializesIndexedDocuments() throws Exception {
        assertApacheExchanges(true);
    }

    private static void assertAwsExchanges(boolean index) throws Exception {
        for (boolean serverless : new boolean[] { false, true }) {
            for (boolean async : new boolean[] { false, true }) {
                try (
                    HttpTransportTestServer server = new HttpTransportTestServer(index ? INDEX_RESPONSE : SEARCH_RESPONSE);
                    SdkHttpClient http = UrlConnectionHttpClient.create(server::openConnection);
                    AwsSdk2Transport transport = new AwsSdk2Transport(
                        http,
                        "example.invalid",
                        serverless ? "aoss" : "es",
                        Region.US_EAST_1,
                        AwsSdk2TransportOptions.builder()
                            .setCredentials(
                                StaticCredentialsProvider.create(AwsBasicCredentials.create("test-access-key", "test-secret-key"))
                            )
                            .build()
                    )
                ) {
                    assertExchange(transport, server, serverless, async, index);
                    assertTrue(server.awaitRequest().headers.get("authorization").contains("/" + (serverless ? "aoss" : "es") + "/"));
                }
            }
        }
    }

    private static void assertApacheExchanges(boolean index) throws Exception {
        for (boolean serverless : new boolean[] { false, true }) {
            for (boolean async : new boolean[] { false, true }) {
                try (
                    HttpTransportTestServer server = new HttpTransportTestServer(index ? INDEX_RESPONSE : SEARCH_RESPONSE);
                    ApacheHttpClient5Transport transport = ApacheHttpClient5TransportBuilder.builder(HttpHost.create(server.baseUrl()))
                        .build()
                ) {
                    assertExchange(transport, server, serverless, async, index);
                }
            }
        }
    }

    private static void assertExchange(
        OpenSearchTransport transport,
        HttpTransportTestServer server,
        boolean serverless,
        boolean async,
        boolean index
    ) throws Exception {
        if (index) {
            Document document = new Document();
            document.title = "example";
            String id;
            if (serverless) {
                id = async
                    ? new software.amazon.opensearch.client.aoss.OpenSearchAsyncClient(transport).index(
                        r -> r.index("test-index").id("1").document(document)
                    ).get().id()
                    : new software.amazon.opensearch.client.aoss.OpenSearchClient(transport).index(
                        r -> r.index("test-index").id("1").document(document)
                    ).id();
            } else {
                id = async
                    ? new OpenSearchAsyncClient(transport).index(r -> r.index("test-index").id("1").document(document)).get().id()
                    : new OpenSearchClient(transport).index(r -> r.index("test-index").id("1").document(document)).id();
            }
            assertEquals("1", id);
        } else {
            Document document;
            if (serverless) {
                document = async
                    ? new software.amazon.opensearch.client.aoss.OpenSearchAsyncClient(transport).search(
                        r -> r.index("test-index").size(1),
                        Document.class
                    ).get().hits().hits().get(0).source()
                    : new software.amazon.opensearch.client.aoss.OpenSearchClient(transport).search(
                        r -> r.index("test-index").size(1),
                        Document.class
                    ).hits().hits().get(0).source();
            } else {
                document = async
                    ? new OpenSearchAsyncClient(transport).search(r -> r.index("test-index").size(1), Document.class)
                        .get()
                        .hits()
                        .hits()
                        .get(0)
                        .source()
                    : new OpenSearchClient(transport).search(r -> r.index("test-index").size(1), Document.class)
                        .hits()
                        .hits()
                        .get(0)
                        .source();
            }
            assertEquals("example", document.title);
        }
        HttpTransportTestServer.CapturedRequest request = server.awaitRequest();
        assertEquals(index ? "PUT" : "POST", request.method);
        assertEquals(index ? "/test-index/_doc/1" : "/test-index/_search?typed_keys=true", request.path);
        assertEquals(index ? "{\"title\":\"example\"}" : "{\"size\":1}", request.body);
    }

    public static class Document {
        public String title;
    }
}
