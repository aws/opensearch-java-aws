/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
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

package org.opensearch.client.opensearch.search_relevance;

import jakarta.json.stream.JsonGenerator;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: search_relevance.put_experiments.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class PutExperimentsResponse
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<PutExperimentsResponse.Builder, PutExperimentsResponse> {

    @Nullable
    private final String experimentId;

    @Nullable
    private final String experimentResult;

    // ---------------------------------------------------------------------------------------------

    private PutExperimentsResponse(Builder builder) {
        this.experimentId = builder.experimentId;
        this.experimentResult = builder.experimentResult;
    }

    public static PutExperimentsResponse of(Function<PutExperimentsResponse.Builder, ObjectBuilder<PutExperimentsResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code experiment_id}
     */
    @Nullable
    public final String experimentId() {
        return this.experimentId;
    }

    /**
     * API name: {@code experiment_result}
     */
    @Nullable
    public final String experimentResult() {
        return this.experimentResult;
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
        if (this.experimentId != null) {
            generator.writeKey("experiment_id");
            generator.write(this.experimentId);
        }

        if (this.experimentResult != null) {
            generator.writeKey("experiment_result");
            generator.write(this.experimentResult);
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
     * Builder for {@link PutExperimentsResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, PutExperimentsResponse> {
        @Nullable
        private String experimentId;
        @Nullable
        private String experimentResult;

        public Builder() {}

        private Builder(PutExperimentsResponse o) {
            this.experimentId = o.experimentId;
            this.experimentResult = o.experimentResult;
        }

        private Builder(Builder o) {
            this.experimentId = o.experimentId;
            this.experimentResult = o.experimentResult;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code experiment_id}
         */
        @Nonnull
        public final Builder experimentId(@Nullable String value) {
            this.experimentId = value;
            return this;
        }

        /**
         * API name: {@code experiment_result}
         */
        @Nonnull
        public final Builder experimentResult(@Nullable String value) {
            this.experimentResult = value;
            return this;
        }

        /**
         * Builds a {@link PutExperimentsResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public PutExperimentsResponse build() {
            _checkSingleUse();

            return new PutExperimentsResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link PutExperimentsResponse}
     */
    public static final JsonpDeserializer<PutExperimentsResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        PutExperimentsResponse::setupPutExperimentsResponseDeserializer
    );

    protected static void setupPutExperimentsResponseDeserializer(ObjectDeserializer<PutExperimentsResponse.Builder> op) {
        op.add(Builder::experimentId, JsonpDeserializer.stringDeserializer(), "experiment_id");
        op.add(Builder::experimentResult, JsonpDeserializer.stringDeserializer(), "experiment_result");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.experimentId);
        result = 31 * result + Objects.hashCode(this.experimentResult);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        PutExperimentsResponse other = (PutExperimentsResponse) o;
        return Objects.equals(this.experimentId, other.experimentId) && Objects.equals(this.experimentResult, other.experimentResult);
    }
}
