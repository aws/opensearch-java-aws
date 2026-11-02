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

import jakarta.json.stream.JsonGenerator;
import jakarta.json.stream.JsonParser;
import java.io.StringReader;
import java.io.StringWriter;
import org.junit.Test;
import software.amazon.opensearch.client.json.JsonpDeserializer;
import software.amazon.opensearch.client.json.JsonpMapper;
import software.amazon.opensearch.client.json.JsonpSerializable;
import software.amazon.opensearch.client.json.jackson.JacksonJsonpMapper;

public class AwsMultisearchBodyTests {
    private static final JsonpMapper MAPPER = new JacksonJsonpMapper();
    private static final String BODY_JSON = "{\"query\":{\"match_all\":{}},\"search_pipeline\":\"my_pipeline\"}";

    @Test
    public void aosMultisearchBodySupportsSearchPipeline() {
        software.amazon.opensearch.client.aos.core.msearch.RequestItem item =
            new software.amazon.opensearch.client.aos.core.msearch.RequestItem.Builder().header(h -> h.index("index"))
                .body(b -> b.query(q -> q.matchAll(m -> m)).searchPipeline("my_pipeline"))
                .build();
        assertEquals("my_pipeline", item.body().searchPipeline());
        assertEquals(BODY_JSON, toJson(item.body()));

        software.amazon.opensearch.client.aos.core.msearch.MultisearchBody parsed = fromJson(
            BODY_JSON,
            software.amazon.opensearch.client.aos.core.msearch.MultisearchBody._DESERIALIZER
        );
        assertEquals("my_pipeline", parsed.searchPipeline());
        assertEquals(BODY_JSON, toJson(parsed));
    }

    @Test
    public void aossMultisearchBodySupportsSearchPipeline() {
        software.amazon.opensearch.client.aoss.core.msearch.RequestItem item =
            new software.amazon.opensearch.client.aoss.core.msearch.RequestItem.Builder().header(h -> h.index("index"))
                .body(b -> b.query(q -> q.matchAll(m -> m)).searchPipeline("my_pipeline"))
                .build();
        assertEquals("my_pipeline", item.body().searchPipeline());
        assertEquals(BODY_JSON, toJson(item.body()));

        software.amazon.opensearch.client.aoss.core.msearch.MultisearchBody parsed = fromJson(
            BODY_JSON,
            software.amazon.opensearch.client.aoss.core.msearch.MultisearchBody._DESERIALIZER
        );
        assertEquals("my_pipeline", parsed.searchPipeline());
        assertEquals(BODY_JSON, toJson(parsed));
    }

    private static <T> T fromJson(String json, JsonpDeserializer<T> deserializer) {
        try (JsonParser parser = MAPPER.jsonProvider().createParser(new StringReader(json))) {
            return deserializer.deserialize(parser, MAPPER);
        }
    }

    private static String toJson(JsonpSerializable value) {
        StringWriter writer = new StringWriter();
        try (JsonGenerator generator = MAPPER.jsonProvider().createGenerator(writer)) {
            value.serialize(generator, MAPPER);
        }
        return writer.toString();
    }
}
