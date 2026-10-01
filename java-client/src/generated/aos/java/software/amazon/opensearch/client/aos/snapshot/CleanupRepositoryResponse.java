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

package software.amazon.opensearch.client.aos.snapshot;

import jakarta.json.stream.JsonGenerator;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import software.amazon.opensearch.client.aos.snapshot.cleanup_repository.CleanupRepositoryResults;
import software.amazon.opensearch.client.json.JsonpDeserializable;
import software.amazon.opensearch.client.json.JsonpDeserializer;
import software.amazon.opensearch.client.json.JsonpMapper;
import software.amazon.opensearch.client.json.ObjectBuilderDeserializer;
import software.amazon.opensearch.client.json.ObjectDeserializer;
import software.amazon.opensearch.client.json.PlainJsonSerializable;
import software.amazon.opensearch.client.util.ApiTypeHelper;
import software.amazon.opensearch.client.util.CopyableBuilder;
import software.amazon.opensearch.client.util.ObjectBuilder;
import software.amazon.opensearch.client.util.ObjectBuilderBase;
import software.amazon.opensearch.client.util.ToCopyableBuilder;

// typedef: snapshot.cleanup_repository.Response

@JsonpDeserializable
@Generated("software.amazon.opensearch.client.codegen.CodeGenerator")
public class CleanupRepositoryResponse
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<CleanupRepositoryResponse.Builder, CleanupRepositoryResponse> {

    @Nonnull
    private final CleanupRepositoryResults results;

    // ---------------------------------------------------------------------------------------------

    private CleanupRepositoryResponse(Builder builder) {
        this.results = ApiTypeHelper.requireNonNull(builder.results, this, "results");
    }

    public static CleanupRepositoryResponse of(Function<CleanupRepositoryResponse.Builder, ObjectBuilder<CleanupRepositoryResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code results}
     */
    @Nonnull
    public final CleanupRepositoryResults results() {
        return this.results;
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
        generator.writeKey("results");
        this.results.serialize(generator, mapper);
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
     * Builder for {@link CleanupRepositoryResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, CleanupRepositoryResponse> {
        private CleanupRepositoryResults results;

        public Builder() {}

        private Builder(CleanupRepositoryResponse o) {
            this.results = o.results;
        }

        private Builder(Builder o) {
            this.results = o.results;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code results}
         */
        @Nonnull
        public final Builder results(CleanupRepositoryResults value) {
            this.results = value;
            return this;
        }

        /**
         * Required - API name: {@code results}
         */
        @Nonnull
        public final Builder results(Function<CleanupRepositoryResults.Builder, ObjectBuilder<CleanupRepositoryResults>> fn) {
            return results(fn.apply(new CleanupRepositoryResults.Builder()).build());
        }

        /**
         * Builds a {@link CleanupRepositoryResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public CleanupRepositoryResponse build() {
            _checkSingleUse();

            return new CleanupRepositoryResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link CleanupRepositoryResponse}
     */
    public static final JsonpDeserializer<CleanupRepositoryResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        CleanupRepositoryResponse::setupCleanupRepositoryResponseDeserializer
    );

    protected static void setupCleanupRepositoryResponseDeserializer(ObjectDeserializer<CleanupRepositoryResponse.Builder> op) {
        op.add(Builder::results, CleanupRepositoryResults._DESERIALIZER, "results");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.results.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        CleanupRepositoryResponse other = (CleanupRepositoryResponse) o;
        return this.results.equals(other.results);
    }
}
