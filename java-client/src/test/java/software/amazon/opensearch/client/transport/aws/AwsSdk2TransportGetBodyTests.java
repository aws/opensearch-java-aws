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
package software.amazon.opensearch.client.transport.aws;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.concurrent.ExecutionException;
import org.junit.Test;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.http.AbortableInputStream;
import software.amazon.awssdk.http.ExecutableHttpRequest;
import software.amazon.awssdk.http.HttpExecuteRequest;
import software.amazon.awssdk.http.HttpExecuteResponse;
import software.amazon.awssdk.http.SdkHttpClient;
import software.amazon.awssdk.http.SdkHttpMethod;
import software.amazon.awssdk.http.SdkHttpResponse;
import software.amazon.awssdk.http.apache.ApacheHttpClient;
import software.amazon.awssdk.http.urlconnection.UrlConnectionHttpClient;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.utils.IoUtils;
import software.amazon.opensearch.client.aos.cat.PitSegmentsRequest;
import software.amazon.opensearch.client.aos.core.ClearScrollRequest;
import software.amazon.opensearch.client.aos.ml.GetProfileModelsRequest;
import software.amazon.opensearch.client.aos.ml.GetProfileRequest;
import software.amazon.opensearch.client.aos.ml.GetProfileTasksRequest;
import software.amazon.opensearch.client.aoss.OpenSearchAsyncClient;
import software.amazon.opensearch.client.aoss.OpenSearchClient;
import software.amazon.opensearch.client.aoss.snapshot.GetSnapshotRequest;
import software.amazon.opensearch.client.errors.ErrorResponse;
import software.amazon.opensearch.client.generic.Requests;
import software.amazon.opensearch.client.generic.Response;
import software.amazon.opensearch.client.json.JsonData;
import software.amazon.opensearch.client.transport.Endpoint;
import software.amazon.opensearch.client.transport.HttpTransportTestServer;
import software.amazon.opensearch.client.transport.TransportException;
import software.amazon.opensearch.client.transport.endpoints.DelegatingJsonEndpoint;
import software.amazon.opensearch.client.transport.endpoints.SimpleEndpoint;

public class AwsSdk2TransportGetBodyTests {
    @Test
    public void rejectsUrlConnectionGetWithExplicitEmptyJsonBodyBeforeSigning() {
        try (SdkHttpClient http = UrlConnectionHttpClient.builder().build()) {
            OpenSearchClient client = new OpenSearchClient(transportWithoutCredentials(http));
            TransportException error = assertThrows(
                TransportException.class,
                () -> client.generic().execute(Requests.builder().method("GET").endpoint("/").json("{}").build())
            );

            assertTrue(error.getMessage().contains("UrlConnectionHttpClient"));
            assertTrue(error.getMessage().contains("AwsCrtHttpClient"));
        }
    }

    @Test
    public void omitsUnsetOptionalGetBodiesWithUrlConnection() throws Exception {
        assertUrlConnectionExchange(
            GetSnapshotRequest.of(r -> r.repository("aoss-automated").snapshot("_all")),
            GetSnapshotRequest._ENDPOINT,
            "GET",
            "/_snapshot/aoss-automated/_all",
            ""
        );
        assertUrlConnectionExchange(GetProfileRequest.of(r -> r), GetProfileRequest._ENDPOINT, "GET", "/_plugins/_ml/profile", "");
        assertUrlConnectionExchange(
            GetProfileModelsRequest.of(r -> r),
            GetProfileModelsRequest._ENDPOINT,
            "GET",
            "/_plugins/_ml/profile/models",
            ""
        );
        assertUrlConnectionExchange(
            GetProfileModelsRequest.of(r -> r.modelId("model-1")),
            GetProfileModelsRequest._ENDPOINT,
            "GET",
            "/_plugins/_ml/profile/models/model-1",
            ""
        );
        assertUrlConnectionExchange(
            GetProfileTasksRequest.of(r -> r),
            GetProfileTasksRequest._ENDPOINT,
            "GET",
            "/_plugins/_ml/profile/tasks",
            ""
        );
        assertUrlConnectionExchange(
            GetProfileTasksRequest.of(r -> r.taskId("task-1")),
            GetProfileTasksRequest._ENDPOINT,
            "GET",
            "/_plugins/_ml/profile/tasks/task-1",
            ""
        );
    }

    @Test
    public void unsetSnapshotBodyAlsoReachesSigningWithAwsApache() throws Exception {
        try (SdkHttpClient http = ApacheHttpClient.builder().build()) {
            OpenSearchClient client = new OpenSearchClient(transportWithoutCredentials(http));
            AssertionError error = assertThrows(
                AssertionError.class,
                () -> client.snapshot().get(r -> r.repository("aoss-automated").snapshot("_all"))
            );
            assertEquals("Signing reached", error.getMessage());
        }
    }

    @Test
    public void retainsRequiredPitBodyAndExplicitMlBodyFields() throws Exception {
        assertRecordedBody(PitSegmentsRequest.of(r -> r.pitId("pit-1")), PitSegmentsRequest._ENDPOINT, "{\"pit_id\":[\"pit-1\"]}");
        assertRecordedBody(
            GetProfileRequest.of(r -> r.returnAllModels(false)),
            GetProfileRequest._ENDPOINT,
            "{\"return_all_models\":false}"
        );
        assertRecordedBody(
            GetProfileModelsRequest.of(r -> r.modelIds(Collections.emptyList())),
            GetProfileModelsRequest._ENDPOINT,
            "{\"model_ids\":[]}"
        );
        assertRecordedBody(
            GetProfileTasksRequest.of(r -> r.taskIds("task-1")),
            GetProfileTasksRequest._ENDPOINT,
            "{\"task_ids\":[\"task-1\"]}"
        );
        try (SdkHttpClient http = UrlConnectionHttpClient.builder().build()) {
            AwsSdk2Transport transport = transportWithoutCredentials(http);
            assertThrows(
                TransportException.class,
                () -> transport.performRequest(PitSegmentsRequest.of(r -> r.pitId("pit-1")), PitSegmentsRequest._ENDPOINT, null)
            );
            assertThrows(
                TransportException.class,
                () -> transport.performRequest(GetProfileRequest.of(r -> r.returnAllModels(false)), GetProfileRequest._ENDPOINT, null)
            );
        }
    }

    @Test
    public void preservesAllGeneratedDeleteBodiesWithUrlConnection() throws Exception {
        assertUrlConnectionExchange(
            ClearScrollRequest.of(r -> r.scrollId("scroll-1")),
            ClearScrollRequest._ENDPOINT,
            "DELETE",
            "/_search/scroll",
            "{\"scroll_id\":[\"scroll-1\"]}"
        );
        assertUrlConnectionExchange(
            software.amazon.opensearch.client.aos.core.DeletePitRequest.of(r -> r.pitId("pit-1")),
            software.amazon.opensearch.client.aos.core.DeletePitRequest._ENDPOINT,
            "DELETE",
            "/_search/point_in_time",
            "{\"pit_id\":[\"pit-1\"]}"
        );
        assertUrlConnectionExchange(
            software.amazon.opensearch.client.aoss.core.DeletePitRequest.of(r -> r.pitId("pit-1")),
            software.amazon.opensearch.client.aoss.core.DeletePitRequest._ENDPOINT,
            "DELETE",
            "/_search/point_in_time",
            "{\"pit_id\":[\"pit-1\"]}"
        );
    }

    @Test
    public void urlConnectionDetectionDistinguishesConcreteClients() {
        assertFalse(AwsSdk2Transport.isAwsSdkUrlConnectionHttpClient(null));
        assertFalse(AwsSdk2Transport.isAwsSdkUrlConnectionHttpClient(() -> {}));
        assertFalse(AwsSdk2Transport.isAwsSdkUrlConnectionHttpClient(new RecordingHttpClient()));
        try (
            SdkHttpClient urlConnection = UrlConnectionHttpClient.builder().build();
            SdkHttpClient apache = ApacheHttpClient.builder().build()
        ) {
            assertTrue(AwsSdk2Transport.isAwsSdkUrlConnectionHttpClient(urlConnection));
            assertFalse(AwsSdk2Transport.isAwsSdkUrlConnectionHttpClient(apache));
        }
    }

    @Test
    public void rejectsUrlConnectionGetWithSourceCollectionInAsyncRequests() throws Exception {
        try (SdkHttpClient http = UrlConnectionHttpClient.builder().build()) {
            OpenSearchAsyncClient client = new OpenSearchAsyncClient(transportWithoutCredentials(http));
            ExecutionException error = assertThrows(
                ExecutionException.class,
                () -> client.snapshot().get(r -> r.repository("aoss-automated").snapshot("_all").sourceCollectionId("source123")).get()
            );

            assertTrue(error.getCause() instanceof TransportException);
            assertTrue(error.getCause().getMessage().contains("AwsCrtHttpClient"));
        }
    }

    @Test
    public void rejectsUrlConnectionGetEvenWithZeroLengthExplicitBody() {
        try (SdkHttpClient http = UrlConnectionHttpClient.builder().build()) {
            OpenSearchClient client = new OpenSearchClient(transportWithoutCredentials(http));
            assertThrows(
                TransportException.class,
                () -> client.generic().execute(Requests.builder().method("GET").endpoint("/_snapshot/aoss-automated/_all").json("").build())
            );
        }
    }

    @Test
    public void urlConnectionGetWithoutBodyReachesSigning() {
        try (SdkHttpClient http = UrlConnectionHttpClient.builder().build()) {
            OpenSearchClient client = new OpenSearchClient(transportWithoutCredentials(http));
            AssertionError error = assertThrows(
                AssertionError.class,
                () -> client.generic().execute(Requests.builder().method("GET").endpoint("/").build())
            );
            assertEquals("Signing reached", error.getMessage());
        }
    }

    @Test
    public void preservesGetBodyAndMethodForOtherHttpClients() throws Exception {
        for (boolean async : new boolean[] { false, true }) {
            RecordingHttpClient http = new RecordingHttpClient();
            AwsSdk2Transport transport = recordingTransport(http);
            GetSnapshotRequest request = GetSnapshotRequest.of(
                r -> r.repository("aoss-automated").snapshot("_all").sourceCollectionId("source123")
            );

            if (async) {
                assertTrue(new OpenSearchAsyncClient(transport).snapshot().get(request).get().snapshots().isEmpty());
            } else {
                assertTrue(new OpenSearchClient(transport).snapshot().get(request).snapshots().isEmpty());
            }

            assertEquals(SdkHttpMethod.GET, http.request.httpRequest().method());
            assertEquals("/_snapshot/aoss-automated/_all", http.request.httpRequest().encodedPath());
            assertEquals("{\"sourceCollectionId\":\"source123\"}", http.body);
            assertTrue(http.request.httpRequest().firstMatchingHeader("Authorization").isPresent());
            assertTrue(http.request.httpRequest().firstMatchingHeader("x-amz-content-sha256").isPresent());
        }
    }

    @Test
    public void preservesBodylessGetAndPostPutBodies() throws Exception {
        RecordingHttpClient http = new RecordingHttpClient();
        OpenSearchClient client = new OpenSearchClient(recordingTransport(http));
        try (Response response = client.generic().execute(Requests.builder().method("GET").endpoint("/").build())) {
            assertEquals(200, response.getStatus());
            assertEquals(SdkHttpMethod.GET, http.request.httpRequest().method());
            assertFalse(http.request.contentStreamProvider().isPresent());
            assertNull(http.body);
        }

        for (String method : new String[] { "POST", "PUT", "DELETE" }) {
            try (
                Response response = client.generic()
                    .execute(Requests.builder().method(method).endpoint("/test-index/_doc").json("{\"value\":1}").build())
            ) {
                assertEquals(200, response.getStatus());
                assertEquals(SdkHttpMethod.fromValue(method), http.request.httpRequest().method());
                assertEquals("{\"value\":1}", http.body);
            }
        }

        try (Response response = client.generic().execute(Requests.builder().method("GET").endpoint("/").json("{}").build())) {
            assertEquals(200, response.getStatus());
            assertEquals(SdkHttpMethod.GET, http.request.httpRequest().method());
            assertEquals("{}", http.body);
        }
    }

    private static <T> void assertRecordedBody(T request, Endpoint<T, ?, ErrorResponse> endpoint, String expected) throws Exception {
        RecordingHttpClient http = new RecordingHttpClient();
        recordingTransport(http).performRequest(
            request,
            ((SimpleEndpoint<T, ?>) endpoint).withResponseDeserializer(JsonData._DESERIALIZER),
            null
        );
        assertEquals(SdkHttpMethod.GET, http.request.httpRequest().method());
        assertEquals(expected, http.body);
    }

    private static <T> void assertUrlConnectionExchange(
        T request,
        Endpoint<T, ?, ErrorResponse> endpoint,
        String method,
        String path,
        String expectedBody
    ) throws Exception {
        for (boolean async : new boolean[] { false, true }) {
            try (
                HttpTransportTestServer server = new HttpTransportTestServer();
                SdkHttpClient http = UrlConnectionHttpClient.create(server::openConnection)
            ) {
                AwsSdk2Transport transport = recordingTransport(http);
                // Exercise predicate preservation through response-parser replacement and endpoint decoration.
                DelegatingJsonEndpoint<T, JsonData, ErrorResponse> decorated = new DelegatingJsonEndpoint<>(
                    ((SimpleEndpoint<T, ?>) endpoint).withResponseDeserializer(JsonData._DESERIALIZER)
                );
                if (async) {
                    transport.performRequestAsync(request, decorated, null).get();
                } else {
                    transport.performRequest(request, decorated, null);
                }
                HttpTransportTestServer.CapturedRequest captured = server.awaitRequest();
                assertEquals(method, captured.method);
                assertEquals(path, captured.path);
                assertEquals(expectedBody, captured.body);
                assertTrue(captured.headers.containsKey("authorization"));
                if (expectedBody.isEmpty()) {
                    assertFalse(captured.headers.containsKey("content-type"));
                    assertFalse(captured.headers.containsKey("content-length"));
                    assertFalse(captured.headers.containsKey("content-encoding"));
                    assertEquals(
                        "e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855",
                        captured.headers.get("x-amz-content-sha256")
                    );
                }
            }
        }
    }

    private static AwsSdk2Transport transportWithoutCredentials(SdkHttpClient http) {
        return new AwsSdk2Transport(
            http,
            "example.invalid",
            "aoss",
            Region.US_EAST_1,
            AwsSdk2TransportOptions.builder().setCredentials(() -> {
                throw new AssertionError("Signing reached");
            }).build()
        );
    }

    private static AwsSdk2Transport recordingTransport(SdkHttpClient http) {
        return new AwsSdk2Transport(
            http,
            "example.invalid",
            "aoss",
            Region.US_EAST_1,
            AwsSdk2TransportOptions.builder()
                .setCredentials(StaticCredentialsProvider.create(AwsBasicCredentials.create("test-access-key", "test-secret-key")))
                .build()
        );
    }

    private static class RecordingHttpClient implements SdkHttpClient {
        private HttpExecuteRequest request;
        private String body;

        @Override
        public ExecutableHttpRequest prepareRequest(HttpExecuteRequest request) {
            this.request = request;
            return new ExecutableHttpRequest() {
                @Override
                public HttpExecuteResponse call() throws IOException {
                    body = null;
                    if (request.contentStreamProvider().isPresent()) {
                        try (InputStream stream = request.contentStreamProvider().get().newStream()) {
                            body = IoUtils.toUtf8String(stream);
                        }
                    }
                    return HttpExecuteResponse.builder()
                        .response(SdkHttpResponse.builder().statusCode(200).build())
                        .responseBody(
                            AbortableInputStream.create(new ByteArrayInputStream("{\"snapshots\":[]}".getBytes(StandardCharsets.UTF_8)))
                        )
                        .build();
                }

                @Override
                public void abort() {}
            };
        }

        @Override
        public void close() {}
    }
}
