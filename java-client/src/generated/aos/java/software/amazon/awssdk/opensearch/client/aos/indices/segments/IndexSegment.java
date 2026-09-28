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

package software.amazon.awssdk.opensearch.client.aos.indices.segments;

import jakarta.json.stream.JsonGenerator;
import java.util.List;
import java.util.Map;
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

// typedef: indices.segments.IndexSegment

/**
 * The segment information for an index.
 */
@JsonpDeserializable
@Generated("software.amazon.awssdk.opensearch.client.codegen.CodeGenerator")
public class IndexSegment implements PlainJsonSerializable, ToCopyableBuilder<IndexSegment.Builder, IndexSegment> {

    @Nonnull
    private final Map<String, List<ShardsSegment>> shards;

    // ---------------------------------------------------------------------------------------------

    private IndexSegment(Builder builder) {
        this.shards = ApiTypeHelper.unmodifiableRequired(builder.shards, this, "shards");
    }

    public static IndexSegment of(Function<IndexSegment.Builder, ObjectBuilder<IndexSegment>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - The segment information for each shard.
     * <p>
     * API name: {@code shards}
     * </p>
     */
    @Nonnull
    public final Map<String, List<ShardsSegment>> shards() {
        return this.shards;
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
        generator.writeKey("shards");
        generator.writeStartObject();
        for (Map.Entry<String, List<ShardsSegment>> item0 : this.shards.entrySet()) {
            generator.writeKey(item0.getKey());
            generator.writeStartArray();
            if (item0.getValue() != null) {
                for (ShardsSegment item1 : item0.getValue()) {
                    item1.serialize(generator, mapper);
                }
            }
            generator.writeEnd();
        }
        generator.writeEnd();
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
     * Builder for {@link IndexSegment}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, IndexSegment> {
        private Map<String, List<ShardsSegment>> shards;

        public Builder() {}

        private Builder(IndexSegment o) {
            this.shards = _mapCopy(o.shards);
        }

        private Builder(Builder o) {
            this.shards = _mapCopy(o.shards);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - The segment information for each shard.
         * <p>
         * API name: {@code shards}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>shards</code>.
         * </p>
         */
        @Nonnull
        public final Builder shards(Map<String, List<ShardsSegment>> map) {
            this.shards = _mapPutAll(this.shards, map);
            return this;
        }

        /**
         * Required - The segment information for each shard.
         * <p>
         * API name: {@code shards}
         * </p>
         *
         * <p>
         * Adds an entry to <code>shards</code>.
         * </p>
         */
        @Nonnull
        public final Builder shards(String key, List<ShardsSegment> value) {
            this.shards = _mapPut(this.shards, key, value);
            return this;
        }

        /**
         * Builds a {@link IndexSegment}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public IndexSegment build() {
            _checkSingleUse();

            return new IndexSegment(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link IndexSegment}
     */
    public static final JsonpDeserializer<IndexSegment> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        IndexSegment::setupIndexSegmentDeserializer
    );

    protected static void setupIndexSegmentDeserializer(ObjectDeserializer<IndexSegment.Builder> op) {
        op.add(
            Builder::shards,
            JsonpDeserializer.stringMapDeserializer(JsonpDeserializer.arrayDeserializer(ShardsSegment._DESERIALIZER)),
            "shards"
        );
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.shards.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        IndexSegment other = (IndexSegment) o;
        return this.shards.equals(other.shards);
    }
}
