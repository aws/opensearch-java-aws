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
package software.amazon.awssdk.opensearch.client.generic;

import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import jakarta.json.stream.JsonGenerator;
import jakarta.json.stream.JsonParser;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import software.amazon.awssdk.opensearch.client.json.JsonpDeserializer;
import software.amazon.awssdk.opensearch.client.json.JsonpMapper;

public final class Bodies {
    private static final String APPLICATION_JSON = "application/json; charset=UTF-8";

    private Bodies() {}

    public static <C> C json(Body body, JsonpDeserializer<C> deserializer, JsonpMapper jsonpMapper) {
        try (JsonParser parser = jsonpMapper.jsonProvider().createParser(body.body())) {
            return deserializer.deserialize(parser, jsonpMapper);
        }
    }

    public static <C> C json(Body body, Class<C> clazz, JsonpMapper jsonpMapper) {
        try (JsonParser parser = jsonpMapper.jsonProvider().createParser(body.body())) {
            return jsonpMapper.deserialize(parser, clazz);
        }
    }

    public static <C> Body json(C value, JsonpMapper jsonpMapper) throws IOException {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            try (JsonGenerator generator = jsonpMapper.jsonProvider().createGenerator(baos)) {
                jsonpMapper.serialize(value, generator);
            }
            return Body.from(baos.toByteArray(), APPLICATION_JSON);
        }
    }

    public static Body json(final JsonObjectBuilder builder) {
        return json(builder.build());
    }

    public static Body json(final JsonObject json) {
        return json(json.toString());
    }

    public static Body json(String str) {
        return Body.from(str.getBytes(StandardCharsets.UTF_8), APPLICATION_JSON);
    }
}
