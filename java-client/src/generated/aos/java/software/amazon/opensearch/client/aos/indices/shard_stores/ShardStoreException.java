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

package software.amazon.opensearch.client.aos.indices.shard_stores;

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

// typedef: indices.shard_stores.ShardStoreException

/**
 * The exception information for a shard store.
 */
@JsonpDeserializable
@Generated("software.amazon.opensearch.client.codegen.CodeGenerator")
public class ShardStoreException implements PlainJsonSerializable, ToCopyableBuilder<ShardStoreException.Builder, ShardStoreException> {

    @Nonnull
    private final String reason;

    @Nonnull
    private final String type;

    // ---------------------------------------------------------------------------------------------

    private ShardStoreException(Builder builder) {
        this.reason = ApiTypeHelper.requireNonNull(builder.reason, this, "reason");
        this.type = ApiTypeHelper.requireNonNull(builder.type, this, "type");
    }

    public static ShardStoreException of(Function<ShardStoreException.Builder, ObjectBuilder<ShardStoreException>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - The reason for the store exception.
     * <p>
     * API name: {@code reason}
     * </p>
     */
    @Nonnull
    public final String reason() {
        return this.reason;
    }

    /**
     * Required - The type of store exception.
     * <p>
     * API name: {@code type}
     * </p>
     */
    @Nonnull
    public final String type() {
        return this.type;
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
        generator.writeKey("reason");
        generator.write(this.reason);

        generator.writeKey("type");
        generator.write(this.type);
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
     * Builder for {@link ShardStoreException}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ShardStoreException> {
        private String reason;
        private String type;

        public Builder() {}

        private Builder(ShardStoreException o) {
            this.reason = o.reason;
            this.type = o.type;
        }

        private Builder(Builder o) {
            this.reason = o.reason;
            this.type = o.type;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - The reason for the store exception.
         * <p>
         * API name: {@code reason}
         * </p>
         */
        @Nonnull
        public final Builder reason(String value) {
            this.reason = value;
            return this;
        }

        /**
         * Required - The type of store exception.
         * <p>
         * API name: {@code type}
         * </p>
         */
        @Nonnull
        public final Builder type(String value) {
            this.type = value;
            return this;
        }

        /**
         * Builds a {@link ShardStoreException}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ShardStoreException build() {
            _checkSingleUse();

            return new ShardStoreException(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ShardStoreException}
     */
    public static final JsonpDeserializer<ShardStoreException> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ShardStoreException::setupShardStoreExceptionDeserializer
    );

    protected static void setupShardStoreExceptionDeserializer(ObjectDeserializer<ShardStoreException.Builder> op) {
        op.add(Builder::reason, JsonpDeserializer.stringDeserializer(), "reason");
        op.add(Builder::type, JsonpDeserializer.stringDeserializer(), "type");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.reason.hashCode();
        result = 31 * result + this.type.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ShardStoreException other = (ShardStoreException) o;
        return this.reason.equals(other.reason) && this.type.equals(other.type);
    }
}
