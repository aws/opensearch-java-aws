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

package software.amazon.awssdk.opensearch.client.aos.indices;

import jakarta.json.stream.JsonGenerator;
import java.util.Map;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import software.amazon.awssdk.opensearch.client.aos.indices.shard_stores.IndicesShardStores;
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

// typedef: indices.shard_stores.Response

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ShardStoresResponse implements PlainJsonSerializable, ToCopyableBuilder<ShardStoresResponse.Builder, ShardStoresResponse> {

    @Nonnull
    private final Map<String, IndicesShardStores> indices;

    // ---------------------------------------------------------------------------------------------

    private ShardStoresResponse(Builder builder) {
        this.indices = ApiTypeHelper.unmodifiableRequired(builder.indices, this, "indices");
    }

    public static ShardStoresResponse of(Function<ShardStoresResponse.Builder, ObjectBuilder<ShardStoresResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code indices}
     */
    @Nonnull
    public final Map<String, IndicesShardStores> indices() {
        return this.indices;
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
        generator.writeKey("indices");
        generator.writeStartObject();
        for (Map.Entry<String, IndicesShardStores> item0 : this.indices.entrySet()) {
            generator.writeKey(item0.getKey());
            item0.getValue().serialize(generator, mapper);
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
     * Builder for {@link ShardStoresResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ShardStoresResponse> {
        private Map<String, IndicesShardStores> indices;

        public Builder() {}

        private Builder(ShardStoresResponse o) {
            this.indices = _mapCopy(o.indices);
        }

        private Builder(Builder o) {
            this.indices = _mapCopy(o.indices);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code indices}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>indices</code>.
         * </p>
         */
        @Nonnull
        public final Builder indices(Map<String, IndicesShardStores> map) {
            this.indices = _mapPutAll(this.indices, map);
            return this;
        }

        /**
         * Required - API name: {@code indices}
         *
         * <p>
         * Adds an entry to <code>indices</code>.
         * </p>
         */
        @Nonnull
        public final Builder indices(String key, IndicesShardStores value) {
            this.indices = _mapPut(this.indices, key, value);
            return this;
        }

        /**
         * Required - API name: {@code indices}
         *
         * <p>
         * Adds a value to <code>indices</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder indices(String key, Function<IndicesShardStores.Builder, ObjectBuilder<IndicesShardStores>> fn) {
            return indices(key, fn.apply(new IndicesShardStores.Builder()).build());
        }

        /**
         * Builds a {@link ShardStoresResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ShardStoresResponse build() {
            _checkSingleUse();

            return new ShardStoresResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ShardStoresResponse}
     */
    public static final JsonpDeserializer<ShardStoresResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ShardStoresResponse::setupShardStoresResponseDeserializer
    );

    protected static void setupShardStoresResponseDeserializer(ObjectDeserializer<ShardStoresResponse.Builder> op) {
        op.add(Builder::indices, JsonpDeserializer.stringMapDeserializer(IndicesShardStores._DESERIALIZER), "indices");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.indices.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ShardStoresResponse other = (ShardStoresResponse) o;
        return this.indices.equals(other.indices);
    }
}
