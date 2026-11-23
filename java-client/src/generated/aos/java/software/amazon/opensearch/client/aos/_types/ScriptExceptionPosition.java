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

/*
 * Licensed to Elasticsearch B.V. under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch B.V. licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

/*
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
 */
//----------------------------------------------------
// THIS CODE IS GENERATED. MANUAL EDITS WILL BE LOST.
//----------------------------------------------------

package software.amazon.opensearch.client.aos._types;

import jakarta.json.stream.JsonGenerator;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import software.amazon.opensearch.client.json.JsonpDeserializable;
import software.amazon.opensearch.client.json.JsonpDeserializer;
import software.amazon.opensearch.client.json.JsonpMapper;
import software.amazon.opensearch.client.json.ObjectBuilderDeserializer;
import software.amazon.opensearch.client.json.ObjectDeserializer;
import software.amazon.opensearch.client.json.PlainJsonSerializable;
import software.amazon.opensearch.client.util.CopyableBuilder;
import software.amazon.opensearch.client.util.ObjectBuilder;
import software.amazon.opensearch.client.util.ObjectBuilderBase;
import software.amazon.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.ScriptExceptionPosition

/**
 * The location of the error within the script source.
 */
@JsonpDeserializable
@Generated("software.amazon.opensearch.client.codegen.CodeGenerator")
public class ScriptExceptionPosition
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<ScriptExceptionPosition.Builder, ScriptExceptionPosition> {

    @Nullable
    private final Integer end;

    @Nullable
    private final Integer offset;

    @Nullable
    private final Integer start;

    // ---------------------------------------------------------------------------------------------

    private ScriptExceptionPosition(Builder builder) {
        this.end = builder.end;
        this.offset = builder.offset;
        this.start = builder.start;
    }

    public static ScriptExceptionPosition of(Function<ScriptExceptionPosition.Builder, ObjectBuilder<ScriptExceptionPosition>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code end}
     */
    @Nullable
    public final Integer end() {
        return this.end;
    }

    /**
     * API name: {@code offset}
     */
    @Nullable
    public final Integer offset() {
        return this.offset;
    }

    /**
     * API name: {@code start}
     */
    @Nullable
    public final Integer start() {
        return this.start;
    }

    /**
     * Serialize this object to JSON.
     */
    @Override
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
        serializeInternal(generator, mapper);
        generator.writeEnd();
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        if (this.end != null) {
            generator.writeKey("end");
            generator.write(this.end);
        }

        if (this.offset != null) {
            generator.writeKey("offset");
            generator.write(this.offset);
        }

        if (this.start != null) {
            generator.writeKey("start");
            generator.write(this.start);
        }
    }

    // ---------------------------------------------------------------------------------------------

    @Override
    @Nonnull
    public Builder toBuilder() {
        return new Builder(this);
    }

    @Nonnull
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builder for {@link ScriptExceptionPosition}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ScriptExceptionPosition> {
        @Nullable
        private Integer end;
        @Nullable
        private Integer offset;
        @Nullable
        private Integer start;

        public Builder() {}

        private Builder(ScriptExceptionPosition o) {
            this.end = o.end;
            this.offset = o.offset;
            this.start = o.start;
        }

        private Builder(Builder o) {
            this.end = o.end;
            this.offset = o.offset;
            this.start = o.start;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code end}
         */
        @Nonnull
        public final Builder end(@Nullable Integer value) {
            this.end = value;
            return this;
        }

        /**
         * API name: {@code offset}
         */
        @Nonnull
        public final Builder offset(@Nullable Integer value) {
            this.offset = value;
            return this;
        }

        /**
         * API name: {@code start}
         */
        @Nonnull
        public final Builder start(@Nullable Integer value) {
            this.start = value;
            return this;
        }

        /**
         * Builds a {@link ScriptExceptionPosition}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ScriptExceptionPosition build() {
            _checkSingleUse();

            return new ScriptExceptionPosition(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ScriptExceptionPosition}
     */
    public static final JsonpDeserializer<ScriptExceptionPosition> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ScriptExceptionPosition::setupScriptExceptionPositionDeserializer
    );

    protected static void setupScriptExceptionPositionDeserializer(ObjectDeserializer<ScriptExceptionPosition.Builder> op) {
        op.add(Builder::end, JsonpDeserializer.integerDeserializer(), "end");
        op.add(Builder::offset, JsonpDeserializer.integerDeserializer(), "offset");
        op.add(Builder::start, JsonpDeserializer.integerDeserializer(), "start");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.end);
        result = 31 * result + Objects.hashCode(this.offset);
        result = 31 * result + Objects.hashCode(this.start);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ScriptExceptionPosition other = (ScriptExceptionPosition) o;
        return Objects.equals(this.end, other.end) && Objects.equals(this.offset, other.offset) && Objects.equals(this.start, other.start);
    }
}
