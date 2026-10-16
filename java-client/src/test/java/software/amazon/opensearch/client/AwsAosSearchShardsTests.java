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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.StringReader;
import org.junit.Test;
import software.amazon.opensearch.client.aos.core.SearchShardsResponse;
import software.amazon.opensearch.client.json.jackson.JacksonJsonpMapper;

public class AwsAosSearchShardsTests {
    @Test
    public void decodesNodesWithMetadataOmittedByAos() {
        SearchShardsResponse response = decode(
            "{\"nodes\":{\"node-1\":{\"name\":\"test-node\",\"ephemeral_id\":\"ephemeral-1\"}},\"indices\":{},\"shards\":[]}"
        );

        assertEquals("test-node", response.nodes().get("node-1").name());
        assertEquals("ephemeral-1", response.nodes().get("node-1").ephemeralId());
        assertTrue(response.nodes().get("node-1").attributes().isEmpty());
        assertNull(response.nodes().get("node-1").transportAddress());
    }

    @Test
    public void preservesNodeMetadataWhenPresent() {
        SearchShardsResponse response = decode(
            "{\"nodes\":{\"node-1\":{\"name\":\"test-node\",\"ephemeral_id\":\"ephemeral-1\","
                + "\"attributes\":{\"zone\":\"test-zone\"},\"transport_address\":\"127.0.0.1:9300\"}},\"indices\":{},\"shards\":[]}"
        );

        assertEquals("test-zone", response.nodes().get("node-1").attributes().get("zone"));
        assertEquals("127.0.0.1:9300", response.nodes().get("node-1").transportAddress());
    }

    private static SearchShardsResponse decode(String json) {
        JacksonJsonpMapper mapper = new JacksonJsonpMapper();
        try (jakarta.json.stream.JsonParser parser = mapper.jsonProvider().createParser(new StringReader(json))) {
            return SearchShardsResponse._DESERIALIZER.deserialize(parser, mapper);
        }
    }
}
