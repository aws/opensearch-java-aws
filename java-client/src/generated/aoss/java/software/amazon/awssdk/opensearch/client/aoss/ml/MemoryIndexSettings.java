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

package software.amazon.awssdk.opensearch.client.aoss.ml;

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

// typedef: ml.MemoryIndexSettings

@JsonpDeserializable
@Generated("software.amazon.awssdk.opensearch.client.codegen.CodeGenerator")
public class MemoryIndexSettings implements PlainJsonSerializable, ToCopyableBuilder<MemoryIndexSettings.Builder, MemoryIndexSettings> {

    @Nullable
    private final Index index;

    // ---------------------------------------------------------------------------------------------

    private MemoryIndexSettings(Builder builder) {
        this.index = builder.index;
    }

    public static MemoryIndexSettings of(Function<MemoryIndexSettings.Builder, ObjectBuilder<MemoryIndexSettings>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code index}
     */
    @Nullable
    public final Index index() {
        return this.index;
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
        if (this.index != null) {
            generator.writeKey("index");
            this.index.serialize(generator, mapper);
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
     * Builder for {@link MemoryIndexSettings}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, MemoryIndexSettings> {
        @Nullable
        private Index index;

        public Builder() {}

        private Builder(MemoryIndexSettings o) {
            this.index = o.index;
        }

        private Builder(Builder o) {
            this.index = o.index;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code index}
         */
        @Nonnull
        public final Builder index(@Nullable Index value) {
            this.index = value;
            return this;
        }

        /**
         * API name: {@code index}
         */
        @Nonnull
        public final Builder index(Function<Index.Builder, ObjectBuilder<Index>> fn) {
            return index(fn.apply(new Index.Builder()).build());
        }

        /**
         * Builds a {@link MemoryIndexSettings}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public MemoryIndexSettings build() {
            _checkSingleUse();

            return new MemoryIndexSettings(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link MemoryIndexSettings}
     */
    public static final JsonpDeserializer<MemoryIndexSettings> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        MemoryIndexSettings::setupMemoryIndexSettingsDeserializer
    );

    protected static void setupMemoryIndexSettingsDeserializer(ObjectDeserializer<MemoryIndexSettings.Builder> op) {
        op.add(Builder::index, Index._DESERIALIZER, "index");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.index);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        MemoryIndexSettings other = (MemoryIndexSettings) o;
        return Objects.equals(this.index, other.index);
    }
}
