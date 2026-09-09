/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package software.amazon.awssdk.opensearch.client;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.nio.charset.StandardCharsets;
import java.util.Collections;
import org.junit.Test;
import software.amazon.awssdk.opensearch.client.aos.core.BulkRequest;
import software.amazon.awssdk.opensearch.client.aos.core.bulk.BulkOperation;
import software.amazon.awssdk.opensearch.client.aos.core.bulk.IndexOperation;
import software.amazon.awssdk.opensearch.client.json.jackson.JacksonJsonpMapper;
import software.amazon.awssdk.opensearch.client.util.OpenSearchRequestBodyBuffer;

public class AwsHandwrittenApiTests {
    @Test
    public void aosClientExposesHandwrittenApis() throws Exception {
        Class<?> client = software.amazon.awssdk.opensearch.client.aos.OpenSearchClient.class;
        Class<?> asyncClient = software.amazon.awssdk.opensearch.client.aos.OpenSearchAsyncClient.class;

        assertApis(client, "aos");
        assertApis(asyncClient, "aos");
        assertNotNull(client.getMethod("termvectors", software.amazon.awssdk.opensearch.client.aos.core.TermvectorsRequest.class));
        assertNotNull(asyncClient.getMethod("termvectors", software.amazon.awssdk.opensearch.client.aos.core.TermvectorsRequest.class));
    }

    @Test
    public void aossClientExposesSupportedHandwrittenApis() throws Exception {
        Class<?> client = software.amazon.awssdk.opensearch.client.aoss.OpenSearchClient.class;
        Class<?> asyncClient = software.amazon.awssdk.opensearch.client.aoss.OpenSearchAsyncClient.class;

        assertApis(client, "aoss");
        assertApis(asyncClient, "aoss");
        assertFalse(hasMethod(client, "termvectors"));
        assertFalse(hasMethod(asyncClient, "termvectors"));
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

    private static void assertApis(Class<?> client, String distribution) throws Exception {
        String corePackage = "software.amazon.awssdk.opensearch.client." + distribution + ".core.";
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
