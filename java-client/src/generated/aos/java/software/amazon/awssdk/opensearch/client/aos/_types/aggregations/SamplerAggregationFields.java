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

package software.amazon.awssdk.opensearch.client.aos._types.aggregations;

import jakarta.json.stream.JsonGenerator;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import software.amazon.awssdk.opensearch.client.json.JsonpDeserializable;
import software.amazon.awssdk.opensearch.client.json.JsonpDeserializer;
import software.amazon.awssdk.opensearch.client.json.JsonpMapper;
import software.amazon.awssdk.opensearch.client.json.ObjectBuilderDeserializer;
import software.amazon.awssdk.opensearch.client.json.ObjectDeserializer;
import software.amazon.awssdk.opensearch.client.json.PlainJsonSerializable;
import software.amazon.awssdk.opensearch.client.util.CopyableBuilder;
import software.amazon.awssdk.opensearch.client.util.ObjectBuilder;
import software.amazon.awssdk.opensearch.client.util.ObjectBuilderBase;
import software.amazon.awssdk.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.aggregations.SamplerAggregationFields

@JsonpDeserializable
@Generated("software.amazon.awssdk.opensearch.client.codegen.CodeGenerator")
public class SamplerAggregationFields
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<SamplerAggregationFields.Builder, SamplerAggregationFields> {

    @Nullable
    private final Integer shardSize;

    // ---------------------------------------------------------------------------------------------

    private SamplerAggregationFields(Builder builder) {
        this.shardSize = builder.shardSize;
    }

    public static SamplerAggregationFields of(Function<SamplerAggregationFields.Builder, ObjectBuilder<SamplerAggregationFields>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Limits how many top-scoring documents are collected in the sample processed on each shard.
     * <p>
     * API name: {@code shard_size}
     * </p>
     */
    @Nullable
    public final Integer shardSize() {
        return this.shardSize;
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
        if (this.shardSize != null) {
            generator.writeKey("shard_size");
            generator.write(this.shardSize);
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
     * Builder for {@link SamplerAggregationFields}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, SamplerAggregationFields> {
        @Nullable
        private Integer shardSize;

        public Builder() {}

        private Builder(SamplerAggregationFields o) {
            this.shardSize = o.shardSize;
        }

        private Builder(Builder o) {
            this.shardSize = o.shardSize;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Limits how many top-scoring documents are collected in the sample processed on each shard.
         * <p>
         * API name: {@code shard_size}
         * </p>
         */
        @Nonnull
        public final Builder shardSize(@Nullable Integer value) {
            this.shardSize = value;
            return this;
        }

        /**
         * Builds a {@link SamplerAggregationFields}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public SamplerAggregationFields build() {
            _checkSingleUse();

            return new SamplerAggregationFields(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link SamplerAggregationFields}
     */
    public static final JsonpDeserializer<SamplerAggregationFields> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        SamplerAggregationFields::setupSamplerAggregationFieldsDeserializer
    );

    protected static void setupSamplerAggregationFieldsDeserializer(ObjectDeserializer<SamplerAggregationFields.Builder> op) {
        op.add(Builder::shardSize, JsonpDeserializer.integerDeserializer(), "shard_size");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.shardSize);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        SamplerAggregationFields other = (SamplerAggregationFields) o;
        return Objects.equals(this.shardSize, other.shardSize);
    }
}
