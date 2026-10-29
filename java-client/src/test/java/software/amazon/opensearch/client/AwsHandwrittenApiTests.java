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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.nio.charset.StandardCharsets;
import java.util.Collections;
import org.junit.Test;
import software.amazon.opensearch.client.aos.core.BulkRequest;
import software.amazon.opensearch.client.aos.core.bulk.BulkOperation;
import software.amazon.opensearch.client.aos.core.bulk.IndexOperation;
import software.amazon.opensearch.client.json.jackson.JacksonJsonpMapper;
import software.amazon.opensearch.client.util.OpenSearchRequestBodyBuffer;

public class AwsHandwrittenApiTests {
    @Test
    public void aosClientExposesHandwrittenApis() throws Exception {
        Class<?> client = software.amazon.opensearch.client.aos.OpenSearchClient.class;
        Class<?> asyncClient = software.amazon.opensearch.client.aos.OpenSearchAsyncClient.class;

        assertApis(client, "aos");
        assertApis(asyncClient, "aos");
        assertNotNull(client.getMethod("termvectors", software.amazon.opensearch.client.aos.core.TermvectorsRequest.class));
        assertNotNull(asyncClient.getMethod("termvectors", software.amazon.opensearch.client.aos.core.TermvectorsRequest.class));
    }

    @Test
    public void aossClientExposesSupportedHandwrittenApis() throws Exception {
        Class<?> client = software.amazon.opensearch.client.aoss.OpenSearchClient.class;
        Class<?> asyncClient = software.amazon.opensearch.client.aoss.OpenSearchAsyncClient.class;

        assertApis(client, "aoss");
        assertApis(asyncClient, "aoss");
        assertFalse(hasMethod(client, "termvectors"));
        assertFalse(hasMethod(asyncClient, "termvectors"));
    }

    @Test
    public void aossHandwrittenRequestsDoNotExposeRefresh() {
        assertFalse(hasMethod(software.amazon.opensearch.client.aoss.core.BulkRequest.Builder.class, "refresh"));
        assertFalse(hasMethod(software.amazon.opensearch.client.aoss.core.CreateRequest.Builder.class, "refresh"));
        assertFalse(hasMethod(software.amazon.opensearch.client.aoss.core.IndexRequest.Builder.class, "refresh"));
        assertFalse(hasMethod(software.amazon.opensearch.client.aoss.core.MgetRequest.Builder.class, "refresh"));
        assertFalse(hasMethod(software.amazon.opensearch.client.aoss.core.UpdateRequest.Builder.class, "refresh"));
    }

    @Test
    public void aosHandwrittenRequestsRetainRefresh() {
        assertTrue(hasMethod(software.amazon.opensearch.client.aos.core.BulkRequest.Builder.class, "refresh"));
        assertTrue(hasMethod(software.amazon.opensearch.client.aos.core.CreateRequest.Builder.class, "refresh"));
        assertTrue(hasMethod(software.amazon.opensearch.client.aos.core.IndexRequest.Builder.class, "refresh"));
        assertTrue(hasMethod(software.amazon.opensearch.client.aos.core.MgetRequest.Builder.class, "refresh"));
        assertTrue(hasMethod(software.amazon.opensearch.client.aos.core.UpdateRequest.Builder.class, "refresh"));
    }

    @Test
    public void bulkRequestUsesNdJson() throws Exception {
        BulkOperation operation = new BulkOperation.Builder().index(
            new IndexOperation.Builder<>().index("books").id("1").document(Collections.singletonMap("title", "OpenSearch")).build()
        ).build();
        BulkRequest request = new BulkRequest.Builder().operations(operation).build();

        OpenSearchRequestBodyBuffer buffer = new OpenSearchRequestBodyBuffer(new JacksonJsonpMapper(), Integer.MAX_VALUE);
        buffer.addContent(request);
        buffer.close();

        String body = new String(buffer.getByteArray(), StandardCharsets.UTF_8);
        assertTrue(buffer.isNdJson());
        assertTrue(body.endsWith("\n"));
        assertTrue(body.contains("\"index\""));
        assertTrue(body.contains("\"title\":\"OpenSearch\""));
    }

    @Test
    public void fieldValueExposesMissingSortConstants() {
        assertEquals(
            software.amazon.opensearch.client.aos._types.FieldValue.of("_first"),
            software.amazon.opensearch.client.aos._types.FieldValue.FIRST
        );
        assertEquals(
            software.amazon.opensearch.client.aos._types.FieldValue.of("_last"),
            software.amazon.opensearch.client.aos._types.FieldValue.LAST
        );
        assertEquals(
            software.amazon.opensearch.client.aoss._types.FieldValue.of("_first"),
            software.amazon.opensearch.client.aoss._types.FieldValue.FIRST
        );
        assertEquals(
            software.amazon.opensearch.client.aoss._types.FieldValue.of("_last"),
            software.amazon.opensearch.client.aoss._types.FieldValue.LAST
        );
    }

    private static void assertApis(Class<?> client, String distribution) throws Exception {
        String corePackage = "software.amazon.opensearch.client." + distribution + ".core.";
        assertNotNull(client.getMethod("bulk", Class.forName(corePackage + "BulkRequest")));
        assertNotNull(client.getMethod("create", Class.forName(corePackage + "CreateRequest")));
        assertNotNull(client.getMethod("index", Class.forName(corePackage + "IndexRequest")));
        assertNotNull(client.getMethod("mget", Class.forName(corePackage + "MgetRequest"), Class.class));
        assertNotNull(client.getMethod("msearch", Class.forName(corePackage + "MsearchRequest"), Class.class));
        assertNotNull(client.getMethod("update", Class.forName(corePackage + "UpdateRequest"), Class.class));
    }

    private static boolean hasMethod(Class<?> client, String name) {
        for (java.lang.reflect.Method method : client.getMethods()) {
            if (method.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
}
