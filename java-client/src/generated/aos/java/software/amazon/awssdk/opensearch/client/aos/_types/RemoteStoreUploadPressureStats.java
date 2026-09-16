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

package software.amazon.awssdk.opensearch.client.aos._types;

import jakarta.json.stream.JsonGenerator;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import software.amazon.awssdk.opensearch.client.json.JsonpDeserializable;
import software.amazon.awssdk.opensearch.client.json.JsonpDeserializer;
import software.amazon.awssdk.opensearch.client.json.JsonpMapper;
import software.amazon.awssdk.opensearch.client.json.ObjectBuilderDeserializer;
import software.amazon.awssdk.opensearch.client.json.ObjectDeserializer;
import software.amazon.awssdk.opensearch.client.json.PlainJsonSerializable;
import software.amazon.awssdk.opensearch.client.util.ApiTypeHelper;
import software.amazon.awssdk.opensearch.client.util.CopyableBuilder;
import software.amazon.awssdk.opensearch.client.util.ObjectBuilder;
import software.amazon.awssdk.opensearch.client.util.ObjectBuilderBase;
import software.amazon.awssdk.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.RemoteStoreUploadPressureStats

/**
 * Statistics related to segment store upload backpressure.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class RemoteStoreUploadPressureStats
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<RemoteStoreUploadPressureStats.Builder, RemoteStoreUploadPressureStats> {

    private final long totalRejections;

    // ---------------------------------------------------------------------------------------------

    private RemoteStoreUploadPressureStats(Builder builder) {
        this.totalRejections = ApiTypeHelper.requireNonNull(builder.totalRejections, this, "totalRejections");
    }

    public static RemoteStoreUploadPressureStats of(
        Function<RemoteStoreUploadPressureStats.Builder, ObjectBuilder<RemoteStoreUploadPressureStats>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - The total number of requests rejected due to segment store upload backpressure.
     * <p>
     * API name: {@code total_rejections}
     * </p>
     */
    public final long totalRejections() {
        return this.totalRejections;
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
        generator.writeKey("total_rejections");
        generator.write(this.totalRejections);
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
     * Builder for {@link RemoteStoreUploadPressureStats}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, RemoteStoreUploadPressureStats> {
        private Long totalRejections;

        public Builder() {}

        private Builder(RemoteStoreUploadPressureStats o) {
            this.totalRejections = o.totalRejections;
        }

        private Builder(Builder o) {
            this.totalRejections = o.totalRejections;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - The total number of requests rejected due to segment store upload backpressure.
         * <p>
         * API name: {@code total_rejections}
         * </p>
         */
        @Nonnull
        public final Builder totalRejections(long value) {
            this.totalRejections = value;
            return this;
        }

        /**
         * Builds a {@link RemoteStoreUploadPressureStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public RemoteStoreUploadPressureStats build() {
            _checkSingleUse();

            return new RemoteStoreUploadPressureStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link RemoteStoreUploadPressureStats}
     */
    public static final JsonpDeserializer<RemoteStoreUploadPressureStats> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        RemoteStoreUploadPressureStats::setupRemoteStoreUploadPressureStatsDeserializer
    );

    protected static void setupRemoteStoreUploadPressureStatsDeserializer(ObjectDeserializer<RemoteStoreUploadPressureStats.Builder> op) {
        op.add(Builder::totalRejections, JsonpDeserializer.longDeserializer(), "total_rejections");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Long.hashCode(this.totalRejections);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        RemoteStoreUploadPressureStats other = (RemoteStoreUploadPressureStats) o;
        return this.totalRejections == other.totalRejections;
    }
}
