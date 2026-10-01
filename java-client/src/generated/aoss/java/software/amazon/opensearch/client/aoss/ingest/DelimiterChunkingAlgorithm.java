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

package software.amazon.opensearch.client.aoss.ingest;

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

// typedef: ingest.DelimiterChunkingAlgorithm

@JsonpDeserializable
@Generated("software.amazon.opensearch.client.codegen.CodeGenerator")
public class DelimiterChunkingAlgorithm
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<DelimiterChunkingAlgorithm.Builder, DelimiterChunkingAlgorithm> {

    @Nullable
    private final String delimiter;

    @Nullable
    private final Integer maxChunkLimit;

    // ---------------------------------------------------------------------------------------------

    private DelimiterChunkingAlgorithm(Builder builder) {
        this.delimiter = builder.delimiter;
        this.maxChunkLimit = builder.maxChunkLimit;
    }

    public static DelimiterChunkingAlgorithm of(
        Function<DelimiterChunkingAlgorithm.Builder, ObjectBuilder<DelimiterChunkingAlgorithm>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The string delimiter to split on.
     * <p>
     * API name: {@code delimiter}
     * </p>
     */
    @Nullable
    public final String delimiter() {
        return this.delimiter;
    }

    /**
     * API name: {@code max_chunk_limit}
     */
    @Nullable
    public final Integer maxChunkLimit() {
        return this.maxChunkLimit;
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
        if (this.delimiter != null) {
            generator.writeKey("delimiter");
            generator.write(this.delimiter);
        }

        if (this.maxChunkLimit != null) {
            generator.writeKey("max_chunk_limit");
            generator.write(this.maxChunkLimit);
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
     * Builder for {@link DelimiterChunkingAlgorithm}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, DelimiterChunkingAlgorithm> {
        @Nullable
        private String delimiter;
        @Nullable
        private Integer maxChunkLimit;

        public Builder() {}

        private Builder(DelimiterChunkingAlgorithm o) {
            this.delimiter = o.delimiter;
            this.maxChunkLimit = o.maxChunkLimit;
        }

        private Builder(Builder o) {
            this.delimiter = o.delimiter;
            this.maxChunkLimit = o.maxChunkLimit;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The string delimiter to split on.
         * <p>
         * API name: {@code delimiter}
         * </p>
         */
        @Nonnull
        public final Builder delimiter(@Nullable String value) {
            this.delimiter = value;
            return this;
        }

        /**
         * API name: {@code max_chunk_limit}
         */
        @Nonnull
        public final Builder maxChunkLimit(@Nullable Integer value) {
            this.maxChunkLimit = value;
            return this;
        }

        /**
         * Builds a {@link DelimiterChunkingAlgorithm}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public DelimiterChunkingAlgorithm build() {
            _checkSingleUse();

            return new DelimiterChunkingAlgorithm(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link DelimiterChunkingAlgorithm}
     */
    public static final JsonpDeserializer<DelimiterChunkingAlgorithm> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        DelimiterChunkingAlgorithm::setupDelimiterChunkingAlgorithmDeserializer
    );

    protected static void setupDelimiterChunkingAlgorithmDeserializer(ObjectDeserializer<DelimiterChunkingAlgorithm.Builder> op) {
        op.add(Builder::delimiter, JsonpDeserializer.stringDeserializer(), "delimiter");
        op.add(Builder::maxChunkLimit, JsonpDeserializer.integerDeserializer(), "max_chunk_limit");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.delimiter);
        result = 31 * result + Objects.hashCode(this.maxChunkLimit);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        DelimiterChunkingAlgorithm other = (DelimiterChunkingAlgorithm) o;
        return Objects.equals(this.delimiter, other.delimiter) && Objects.equals(this.maxChunkLimit, other.maxChunkLimit);
    }
}
