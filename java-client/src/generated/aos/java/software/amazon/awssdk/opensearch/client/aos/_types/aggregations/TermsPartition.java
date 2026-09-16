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

// typedef: _types.aggregations.TermsPartition

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class TermsPartition implements PlainJsonSerializable, ToCopyableBuilder<TermsPartition.Builder, TermsPartition> {

    private final int numPartitions;

    private final int partition;

    // ---------------------------------------------------------------------------------------------

    private TermsPartition(Builder builder) {
        this.numPartitions = ApiTypeHelper.requireNonNull(builder.numPartitions, this, "numPartitions");
        this.partition = ApiTypeHelper.requireNonNull(builder.partition, this, "partition");
    }

    public static TermsPartition of(Function<TermsPartition.Builder, ObjectBuilder<TermsPartition>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - The number of partitions.
     * <p>
     * API name: {@code num_partitions}
     * </p>
     */
    public final int numPartitions() {
        return this.numPartitions;
    }

    /**
     * Required - The partition number for this request.
     * <p>
     * API name: {@code partition}
     * </p>
     */
    public final int partition() {
        return this.partition;
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
        generator.writeKey("num_partitions");
        generator.write(this.numPartitions);

        generator.writeKey("partition");
        generator.write(this.partition);
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
     * Builder for {@link TermsPartition}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, TermsPartition> {
        private Integer numPartitions;
        private Integer partition;

        public Builder() {}

        private Builder(TermsPartition o) {
            this.numPartitions = o.numPartitions;
            this.partition = o.partition;
        }

        private Builder(Builder o) {
            this.numPartitions = o.numPartitions;
            this.partition = o.partition;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - The number of partitions.
         * <p>
         * API name: {@code num_partitions}
         * </p>
         */
        @Nonnull
        public final Builder numPartitions(int value) {
            this.numPartitions = value;
            return this;
        }

        /**
         * Required - The partition number for this request.
         * <p>
         * API name: {@code partition}
         * </p>
         */
        @Nonnull
        public final Builder partition(int value) {
            this.partition = value;
            return this;
        }

        /**
         * Builds a {@link TermsPartition}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public TermsPartition build() {
            _checkSingleUse();

            return new TermsPartition(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link TermsPartition}
     */
    public static final JsonpDeserializer<TermsPartition> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        TermsPartition::setupTermsPartitionDeserializer
    );

    protected static void setupTermsPartitionDeserializer(ObjectDeserializer<TermsPartition.Builder> op) {
        op.add(Builder::numPartitions, JsonpDeserializer.integerDeserializer(), "num_partitions");
        op.add(Builder::partition, JsonpDeserializer.integerDeserializer(), "partition");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Integer.hashCode(this.numPartitions);
        result = 31 * result + Integer.hashCode(this.partition);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        TermsPartition other = (TermsPartition) o;
        return this.numPartitions == other.numPartitions && this.partition == other.partition;
    }
}
