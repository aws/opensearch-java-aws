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
import software.amazon.opensearch.client.json.JsonpMapper;
import software.amazon.opensearch.client.json.JsonpSerializable;
import software.amazon.opensearch.client.json.jackson.JacksonJsonpMapper;

public class AwsMatchOnlyTextPropertyTests {
    private static final JsonpMapper MAPPER = new JacksonJsonpMapper();
    private static final String JSON = "{\"type\":\"match_only_text\",\"analyzer\":\"standard\",\"search_analyzer\":\"whitespace\"}";

    @Test
    public void aosMatchOnlyTextPropertySupportsAnalyzers() {
        software.amazon.opensearch.client.aos._types.mapping.Property property;
        try (JsonParser parser = MAPPER.jsonProvider().createParser(new StringReader(JSON))) {
            property = software.amazon.opensearch.client.aos._types.mapping.Property._DESERIALIZER.deserialize(parser, MAPPER);
        }
        assertEquals(software.amazon.opensearch.client.aos._types.mapping.Property.Kind.MatchOnlyText, property._kind());
        assertEquals("standard", property.matchOnlyText().analyzer());
        assertEquals("whitespace", property.matchOnlyText().searchAnalyzer());

        assertEquals(
            JSON,
            toJson(
                software.amazon.opensearch.client.aos._types.mapping.Property.of(
                    p -> p.matchOnlyText(m -> m.analyzer("standard").searchAnalyzer("whitespace"))
                )
            )
        );
    }

    @Test
    public void aossMatchOnlyTextPropertySupportsAnalyzers() {
        software.amazon.opensearch.client.aoss._types.mapping.Property property;
        try (JsonParser parser = MAPPER.jsonProvider().createParser(new StringReader(JSON))) {
            property = software.amazon.opensearch.client.aoss._types.mapping.Property._DESERIALIZER.deserialize(parser, MAPPER);
        }
        assertEquals(software.amazon.opensearch.client.aoss._types.mapping.Property.Kind.MatchOnlyText, property._kind());
        assertEquals("standard", property.matchOnlyText().analyzer());
        assertEquals("whitespace", property.matchOnlyText().searchAnalyzer());

        assertEquals(
            JSON,
            toJson(
                software.amazon.opensearch.client.aoss._types.mapping.Property.of(
                    p -> p.matchOnlyText(m -> m.analyzer("standard").searchAnalyzer("whitespace"))
                )
            )
        );
    }

    private static String toJson(JsonpSerializable value) {
        StringWriter writer = new StringWriter();
        try (JsonGenerator generator = MAPPER.jsonProvider().createGenerator(writer)) {
            value.serialize(generator, MAPPER);
        }
        return writer.toString();
    }
}
