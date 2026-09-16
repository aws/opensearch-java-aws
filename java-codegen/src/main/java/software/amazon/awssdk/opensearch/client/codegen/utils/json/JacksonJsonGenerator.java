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
package software.amazon.awssdk.opensearch.client.codegen.utils.json;

import java.io.IOException;
import java.util.Objects;
import javax.annotation.Nonnull;

class JacksonJsonGenerator implements JsonGenerator {
    @Nonnull
    private final com.fasterxml.jackson.core.JsonGenerator generator;

    public JacksonJsonGenerator(@Nonnull com.fasterxml.jackson.core.JsonGenerator generator) {
        this.generator = Objects.requireNonNull(generator, "generator must not be null");
    }

    @Override
    public void close() throws IOException {
        generator.close();
    }

    @Override
    public void writeStartObject() {
        try {
            generator.writeStartObject();
        } catch (IOException e) {
            throw Json.convertException(e);
        }
    }

    @Override
    public void writeEndObject() {
        try {
            generator.writeEndObject();
        } catch (IOException e) {
            throw Json.convertException(e);
        }
    }

    @Override
    public void writeStartArray() {
        try {
            generator.writeStartArray();
        } catch (IOException e) {
            throw Json.convertException(e);
        }
    }

    @Override
    public void writeEndArray() {
        try {
            generator.writeEndArray();
        } catch (IOException e) {
            throw Json.convertException(e);
        }
    }

    @Override
    public void writeFieldName(@Nonnull String name) {
        Objects.requireNonNull(name, "name must not be null");
        try {
            generator.writeFieldName(name);
        } catch (IOException e) {
            throw Json.convertException(e);
        }
    }

    @Override
    public void writeNull() {
        try {
            generator.writeNull();
        } catch (IOException e) {
            throw Json.convertException(e);
        }
    }

    @Override
    public void writeString(@Nonnull String value) {
        Objects.requireNonNull(value, "value must not be null");
        try {
            generator.writeString(value);
        } catch (IOException e) {
            throw Json.convertException(e);
        }
    }

    @Override
    public void writeBoolean(boolean value) {
        try {
            generator.writeBoolean(value);
        } catch (IOException e) {
            throw Json.convertException(e);
        }
    }

    @Override
    public void writeInteger(int value) {
        try {
            generator.writeNumber(value);
        } catch (IOException e) {
            throw Json.convertException(e);
        }
    }
}
