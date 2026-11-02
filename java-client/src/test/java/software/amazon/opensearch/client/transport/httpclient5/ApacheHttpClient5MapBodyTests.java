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

import java.util.Collections;
import org.apache.hc.core5.http.HttpHost;
import org.junit.Test;
import software.amazon.opensearch.client.aos.ltr.CreateFeatureRequest;
import software.amazon.opensearch.client.aos.ltr.CreateFeaturesetRequest;
import software.amazon.opensearch.client.json.JsonData;
import software.amazon.opensearch.client.transport.HttpTransportTestServer;
import software.amazon.opensearch.client.transport.endpoints.SimpleEndpoint;

public class ApacheHttpClient5MapBodyTests {
    @Test
    public void sendsFreeFormBodyForCreateFeatureset() throws Exception {
        CreateFeaturesetRequest request = CreateFeaturesetRequest.of(
            r -> r.id("my_set").body("featureset", JsonData.of(Collections.singletonMap("name", "my_set")))
        );
        HttpTransportTestServer.CapturedRequest captured = send(
            request,
            ((SimpleEndpoint<CreateFeaturesetRequest, ?>) CreateFeaturesetRequest._ENDPOINT).withResponseDeserializer(
                JsonData._DESERIALIZER
            )
        );

        assertEquals("PUT", captured.method);
        assertEquals("/_ltr/_featureset/my_set", captured.path);
        assertEquals("{\"featureset\":{\"name\":\"my_set\"}}", captured.body);
    }

    @Test
    public void sendsFreeFormBodyForCreateFeature() throws Exception {
        CreateFeatureRequest request = CreateFeatureRequest.of(r -> r.id("my_feature").body("feature", JsonData.of("value")));
        HttpTransportTestServer.CapturedRequest captured = send(
            request,
            ((SimpleEndpoint<CreateFeatureRequest, ?>) CreateFeatureRequest._ENDPOINT).withResponseDeserializer(JsonData._DESERIALIZER)
        );

        assertEquals("PUT", captured.method);
        assertEquals("/_ltr/_feature/my_feature", captured.path);
        assertEquals("{\"feature\":\"value\"}", captured.body);
    }

    private static <R> HttpTransportTestServer.CapturedRequest send(R request, SimpleEndpoint<R, JsonData> endpoint) throws Exception {
        try (
            HttpTransportTestServer server = new HttpTransportTestServer();
            ApacheHttpClient5Transport transport = ApacheHttpClient5TransportBuilder.builder(HttpHost.create(server.baseUrl())).build()
        ) {
            transport.performRequest(request, endpoint, null);
            return server.awaitRequest();
        }
    }
}
