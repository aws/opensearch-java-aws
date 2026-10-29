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
import java.io.StringWriter;
import org.junit.Test;
import software.amazon.opensearch.client.json.JsonpMapper;
import software.amazon.opensearch.client.json.JsonpSerializable;
import software.amazon.opensearch.client.json.jackson.JacksonJsonpMapper;

public class AwsTermsLookupTests {
    private static final JsonpMapper MAPPER = new JacksonJsonpMapper();

    @Test
    public void aosTermsLookupSerializesAllProperties() {
        software.amazon.opensearch.client.aos._types.query_dsl.TermsLookup lookup =
            new software.amazon.opensearch.client.aos._types.query_dsl.TermsLookup.Builder().id("id").index("index").path("path").build();

        assertEquals("{\"id\":\"id\",\"index\":\"index\",\"path\":\"path\"}", toJson(lookup));
        assertEquals(toJson(lookup), toJson(lookup.toBuilder().build()));
    }

    @Test
    public void aossTermsLookupSerializesAllProperties() {
        software.amazon.opensearch.client.aoss._types.query_dsl.TermsLookup lookup =
            new software.amazon.opensearch.client.aoss._types.query_dsl.TermsLookup.Builder().id("id").index("index").path("path").build();

        assertEquals("{\"id\":\"id\",\"index\":\"index\",\"path\":\"path\"}", toJson(lookup));
        assertEquals(toJson(lookup), toJson(lookup.toBuilder().build()));
    }

    private static String toJson(JsonpSerializable value) {
        StringWriter writer = new StringWriter();
        try (JsonGenerator generator = MAPPER.jsonProvider().createGenerator(writer)) {
            value.serialize(generator, MAPPER);
        }
        return writer.toString();
    }
}
