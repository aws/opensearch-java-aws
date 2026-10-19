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
import software.amazon.opensearch.client.aos.indices.segments.Segment;
import software.amazon.opensearch.client.json.jackson.JacksonJsonpMapper;

public class AwsAosSegmentsTests {
    @Test
    public void decodesSegmentWithoutAttributesOrCompoundFlag() {
        Segment segment = decode(",\"version\":\"10.4.0\"");

        assertTrue(segment.attributes().isEmpty());
        assertNull(segment.compound());
        assertEquals(4, segment.numDocs());
        assertEquals("10.4.0", segment.version());
    }

    @Test
    public void decodesSegmentWithoutVersion() {
        Segment segment = decode("");

        assertNull(segment.version());
        assertNull(segment.compound());
        assertTrue(segment.attributes().isEmpty());
    }

    @Test
    public void preservesOptionalSegmentMetadataWhenPresent() {
        Segment segment = decode(
            ",\"version\":\"10.4.0\",\"compound\":false,\"attributes\":{\"Lucene90StoredFieldsFormat.mode\":\"BEST_SPEED\"}"
        );

        assertEquals("BEST_SPEED", segment.attributes().get("Lucene90StoredFieldsFormat.mode"));
        assertEquals(Boolean.FALSE, segment.compound());
        assertEquals("10.4.0", segment.version());
    }

    private static Segment decode(String optionalFields) {
        String json = "{\"generation\":1,\"num_docs\":4,\"deleted_docs\":0,\"size_in_bytes\":4096,"
            + "\"committed\":true,\"search\":true"
            + optionalFields
            + "}";
        JacksonJsonpMapper mapper = new JacksonJsonpMapper();
        try (jakarta.json.stream.JsonParser parser = mapper.jsonProvider().createParser(new StringReader(json))) {
            return Segment._DESERIALIZER.deserialize(parser, mapper);
        }
    }
}
