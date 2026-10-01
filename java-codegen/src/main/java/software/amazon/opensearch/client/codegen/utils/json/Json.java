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
package software.amazon.opensearch.client.codegen.utils.json;

import com.fasterxml.jackson.core.JsonFactory;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Objects;
import javax.annotation.Nonnull;

public final class Json {
    private static final JsonFactory FACTORY = JsonFactory.builder().build();

    private Json() {}

    static JsonException convertException(IOException ioe) {
        if (ioe instanceof com.fasterxml.jackson.core.JsonGenerationException) {
            return new JsonGenerationException(ioe.getMessage(), ioe);
            // } else if (ioe instanceof com.fasterxml.jackson.core.JsonParseException) {
            // JsonParseException jpe = (JsonParseException) ioe;
            // return new JsonParsingException(ioe.getMessage(), jpe, new JacksonJsonpLocation(jpe.getLocation()));
        } else {
            return new JsonException("JSON exception", ioe);
        }
    }

    @Nonnull
    public static JsonGenerator createGenerator(@Nonnull Writer writer, boolean prettyPrint) {
        try {
            var generator = FACTORY.createGenerator(Objects.requireNonNull(writer, "writer must not be null"));
            if (prettyPrint) {
                generator.useDefaultPrettyPrinter();
            }
            return new JacksonJsonGenerator(generator);
        } catch (IOException e) {
            throw convertException(e);
        }
    }

    public static void toJson(@Nonnull ToJson value, @Nonnull Writer writer, boolean prettyPrint) {
        Objects.requireNonNull(value, "value must not be null");
        try (var generator = createGenerator(writer, prettyPrint)) {
            value.toJson(generator);
        } catch (IOException e) {
            throw convertException(e);
        }
    }

    @Nonnull
    public static String toJsonString(@Nonnull ToJson value, boolean prettyPrint) {
        var sw = new StringWriter();
        toJson(value, sw, prettyPrint);
        return sw.toString();
    }
}
