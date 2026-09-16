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

package software.amazon.awssdk.opensearch.client.aos.ltr;

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

// typedef: ltr.CacheItemStats

@JsonpDeserializable
@Generated("software.amazon.awssdk.opensearch.client.codegen.CodeGenerator")
public class CacheItemStats implements PlainJsonSerializable, ToCopyableBuilder<CacheItemStats.Builder, CacheItemStats> {

    @Nullable
    private final Integer count;

    @Nullable
    private final Integer ram;

    // ---------------------------------------------------------------------------------------------

    private CacheItemStats(Builder builder) {
        this.count = builder.count;
        this.ram = builder.ram;
    }

    public static CacheItemStats of(Function<CacheItemStats.Builder, ObjectBuilder<CacheItemStats>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Count of cached items.
     * <p>
     * API name: {@code count}
     * </p>
     */
    @Nullable
    public final Integer count() {
        return this.count;
    }

    /**
     * Memory usage in bytes.
     * <p>
     * API name: {@code ram}
     * </p>
     */
    @Nullable
    public final Integer ram() {
        return this.ram;
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
        if (this.count != null) {
            generator.writeKey("count");
            generator.write(this.count);
        }

        if (this.ram != null) {
            generator.writeKey("ram");
            generator.write(this.ram);
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
     * Builder for {@link CacheItemStats}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, CacheItemStats> {
        @Nullable
        private Integer count;
        @Nullable
        private Integer ram;

        public Builder() {}

        private Builder(CacheItemStats o) {
            this.count = o.count;
            this.ram = o.ram;
        }

        private Builder(Builder o) {
            this.count = o.count;
            this.ram = o.ram;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Count of cached items.
         * <p>
         * API name: {@code count}
         * </p>
         */
        @Nonnull
        public final Builder count(@Nullable Integer value) {
            this.count = value;
            return this;
        }

        /**
         * Memory usage in bytes.
         * <p>
         * API name: {@code ram}
         * </p>
         */
        @Nonnull
        public final Builder ram(@Nullable Integer value) {
            this.ram = value;
            return this;
        }

        /**
         * Builds a {@link CacheItemStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public CacheItemStats build() {
            _checkSingleUse();

            return new CacheItemStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link CacheItemStats}
     */
    public static final JsonpDeserializer<CacheItemStats> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        CacheItemStats::setupCacheItemStatsDeserializer
    );

    protected static void setupCacheItemStatsDeserializer(ObjectDeserializer<CacheItemStats.Builder> op) {
        op.add(Builder::count, JsonpDeserializer.integerDeserializer(), "count");
        op.add(Builder::ram, JsonpDeserializer.integerDeserializer(), "ram");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.count);
        result = 31 * result + Objects.hashCode(this.ram);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        CacheItemStats other = (CacheItemStats) o;
        return Objects.equals(this.count, other.count) && Objects.equals(this.ram, other.ram);
    }
}
