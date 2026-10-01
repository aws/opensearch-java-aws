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

package software.amazon.opensearch.client.aos.ingestion;

import jakarta.json.stream.JsonGenerator;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
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

// typedef: ingestion.IngestionStateShardFailure

@JsonpDeserializable
@Generated("software.amazon.opensearch.client.codegen.CodeGenerator")
public class IngestionStateShardFailure
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<IngestionStateShardFailure.Builder, IngestionStateShardFailure> {

    @Nonnull
    private final String error;

    private final int shard;

    // ---------------------------------------------------------------------------------------------

    private IngestionStateShardFailure(Builder builder) {
        this.error = ApiTypeHelper.requireNonNull(builder.error, this, "error");
        this.shard = ApiTypeHelper.requireNonNull(builder.shard, this, "shard");
    }

    public static IngestionStateShardFailure of(
        Function<IngestionStateShardFailure.Builder, ObjectBuilder<IngestionStateShardFailure>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - Indicates the shard level error message.
     * <p>
     * API name: {@code error}
     * </p>
     */
    @Nonnull
    public final String error() {
        return this.error;
    }

    /**
     * Required - The shard number.
     * <p>
     * API name: {@code shard}
     * </p>
     */
    public final int shard() {
        return this.shard;
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
        generator.writeKey("error");
        generator.write(this.error);

        generator.writeKey("shard");
        generator.write(this.shard);
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
     * Builder for {@link IngestionStateShardFailure}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, IngestionStateShardFailure> {
        private String error;
        private Integer shard;

        public Builder() {}

        private Builder(IngestionStateShardFailure o) {
            this.error = o.error;
            this.shard = o.shard;
        }

        private Builder(Builder o) {
            this.error = o.error;
            this.shard = o.shard;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - Indicates the shard level error message.
         * <p>
         * API name: {@code error}
         * </p>
         */
        @Nonnull
        public final Builder error(String value) {
            this.error = value;
            return this;
        }

        /**
         * Required - The shard number.
         * <p>
         * API name: {@code shard}
         * </p>
         */
        @Nonnull
        public final Builder shard(int value) {
            this.shard = value;
            return this;
        }

        /**
         * Builds a {@link IngestionStateShardFailure}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public IngestionStateShardFailure build() {
            _checkSingleUse();

            return new IngestionStateShardFailure(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link IngestionStateShardFailure}
     */
    public static final JsonpDeserializer<IngestionStateShardFailure> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        IngestionStateShardFailure::setupIngestionStateShardFailureDeserializer
    );

    protected static void setupIngestionStateShardFailureDeserializer(ObjectDeserializer<IngestionStateShardFailure.Builder> op) {
        op.add(Builder::error, JsonpDeserializer.stringDeserializer(), "error");
        op.add(Builder::shard, JsonpDeserializer.integerDeserializer(), "shard");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.error.hashCode();
        result = 31 * result + Integer.hashCode(this.shard);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        IngestionStateShardFailure other = (IngestionStateShardFailure) o;
        return this.error.equals(other.error) && this.shard == other.shard;
    }
}
