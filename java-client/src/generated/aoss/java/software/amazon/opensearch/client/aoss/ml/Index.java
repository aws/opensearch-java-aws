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
//----------------------------------------------------
// THIS CODE IS GENERATED. MANUAL EDITS WILL BE LOST.
//----------------------------------------------------

package software.amazon.opensearch.client.aoss.ml;

import jakarta.json.stream.JsonGenerator;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import software.amazon.opensearch.client.json.JsonData;
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

// typedef: ml.Index

@JsonpDeserializable
@Generated("software.amazon.opensearch.client.codegen.CodeGenerator")
public class Index implements PlainJsonSerializable, ToCopyableBuilder<Index.Builder, Index> {

    @Nonnull
    private final Map<String, JsonData> metadata;

    @Nullable
    private final String numberOfReplicas;

    @Nullable
    private final String numberOfShards;

    // ---------------------------------------------------------------------------------------------

    private Index(Builder builder) {
        this.metadata = ApiTypeHelper.unmodifiable(builder.metadata);
        this.numberOfReplicas = builder.numberOfReplicas;
        this.numberOfShards = builder.numberOfShards;
    }

    public static Index of(Function<Index.Builder, ObjectBuilder<Index>> fn) {
        return fn.apply(new Builder()).build();
    }

    @Nonnull
    public final Map<String, JsonData> metadata() {
        return this.metadata;
    }

    /**
     * The number of replicas.
     * <p>
     * API name: {@code number_of_replicas}
     * </p>
     */
    @Nullable
    public final String numberOfReplicas() {
        return this.numberOfReplicas;
    }

    /**
     * The number of shards.
     * <p>
     * API name: {@code number_of_shards}
     * </p>
     */
    @Nullable
    public final String numberOfShards() {
        return this.numberOfShards;
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
        for (Map.Entry<String, JsonData> item0 : this.metadata.entrySet()) {
            generator.writeKey(item0.getKey());
            item0.getValue().serialize(generator, mapper);
        }
        if (this.numberOfReplicas != null) {
            generator.writeKey("number_of_replicas");
            generator.write(this.numberOfReplicas);
        }

        if (this.numberOfShards != null) {
            generator.writeKey("number_of_shards");
            generator.write(this.numberOfShards);
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
     * Builder for {@link Index}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, Index> {
        @Nullable
        private Map<String, JsonData> metadata;
        @Nullable
        private String numberOfReplicas;
        @Nullable
        private String numberOfShards;

        public Builder() {}

        private Builder(Index o) {
            this.metadata = _mapCopy(o.metadata);
            this.numberOfReplicas = o.numberOfReplicas;
            this.numberOfShards = o.numberOfShards;
        }

        private Builder(Builder o) {
            this.metadata = _mapCopy(o.metadata);
            this.numberOfReplicas = o.numberOfReplicas;
            this.numberOfShards = o.numberOfShards;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>metadata</code>.
         * </p>
         */
        @Nonnull
        public final Builder metadata(Map<String, JsonData> map) {
            this.metadata = _mapPutAll(this.metadata, map);
            return this;
        }

        /**
         *
         * <p>
         * Adds an entry to <code>metadata</code>.
         * </p>
         */
        @Nonnull
        public final Builder metadata(String key, JsonData value) {
            this.metadata = _mapPut(this.metadata, key, value);
            return this;
        }

        /**
         * The number of replicas.
         * <p>
         * API name: {@code number_of_replicas}
         * </p>
         */
        @Nonnull
        public final Builder numberOfReplicas(@Nullable String value) {
            this.numberOfReplicas = value;
            return this;
        }

        /**
         * The number of shards.
         * <p>
         * API name: {@code number_of_shards}
         * </p>
         */
        @Nonnull
        public final Builder numberOfShards(@Nullable String value) {
            this.numberOfShards = value;
            return this;
        }

        /**
         * Builds a {@link Index}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public Index build() {
            _checkSingleUse();

            return new Index(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link Index}
     */
    public static final JsonpDeserializer<Index> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        Index::setupIndexDeserializer
    );

    protected static void setupIndexDeserializer(ObjectDeserializer<Index.Builder> op) {
        op.add(Builder::numberOfReplicas, JsonpDeserializer.stringDeserializer(), "number_of_replicas");
        op.add(Builder::numberOfShards, JsonpDeserializer.stringDeserializer(), "number_of_shards");
        op.setUnknownFieldHandler((builder, name, parser, mapper) -> {
            if (builder.metadata == null) {
                builder.metadata = new HashMap<>();
            }
            builder.metadata.put(name, JsonData._DESERIALIZER.deserialize(parser, mapper));
        });
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.metadata);
        result = 31 * result + Objects.hashCode(this.numberOfReplicas);
        result = 31 * result + Objects.hashCode(this.numberOfShards);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Index other = (Index) o;
        return Objects.equals(this.metadata, other.metadata)
            && Objects.equals(this.numberOfReplicas, other.numberOfReplicas)
            && Objects.equals(this.numberOfShards, other.numberOfShards);
    }
}
