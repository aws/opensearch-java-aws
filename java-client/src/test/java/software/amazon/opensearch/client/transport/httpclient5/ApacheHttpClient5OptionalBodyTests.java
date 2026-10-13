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
package software.amazon.opensearch.client.transport.httpclient5;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.apache.hc.core5.http.HttpHost;
import org.junit.Test;
import software.amazon.opensearch.client.aoss.snapshot.GetSnapshotRequest;
import software.amazon.opensearch.client.json.JsonData;
import software.amazon.opensearch.client.transport.HttpTransportTestServer;
import software.amazon.opensearch.client.transport.endpoints.SimpleEndpoint;

public class ApacheHttpClient5OptionalBodyTests {
    @Test
    public void omitsUnsetBodyAndPreservesExplicitBodyForSyncAndAsyncRequests() throws Exception {
        SimpleEndpoint<GetSnapshotRequest, JsonData> endpoint = ((SimpleEndpoint<GetSnapshotRequest, ?>) GetSnapshotRequest._ENDPOINT)
            .withResponseDeserializer(JsonData._DESERIALIZER);
        for (boolean async : new boolean[] { false, true }) {
            for (boolean withBody : new boolean[] { false, true }) {
                try (
                    HttpTransportTestServer server = new HttpTransportTestServer();
                    ApacheHttpClient5Transport transport = ApacheHttpClient5TransportBuilder.builder(HttpHost.create(server.baseUrl()))
                        .build()
                ) {
                    GetSnapshotRequest request = GetSnapshotRequest.of(
                        r -> r.repository("aoss-automated").snapshot("_all").sourceCollectionId(withBody ? "source123" : null)
                    );
                    if (async) {
                        transport.performRequestAsync(request, endpoint, null).get();
                    } else {
                        transport.performRequest(request, endpoint, null);
                    }
                    HttpTransportTestServer.CapturedRequest captured = server.awaitRequest();
                    assertEquals("GET", captured.method);
                    assertEquals("/_snapshot/aoss-automated/_all", captured.path);
                    assertEquals(withBody ? "{\"sourceCollectionId\":\"source123\"}" : "", captured.body);
                    if (!withBody) {
                        assertFalse(captured.headers.containsKey("content-type"));
                        assertFalse(captured.headers.containsKey("content-encoding"));
                    }
                }
            }
        }
    }
}
