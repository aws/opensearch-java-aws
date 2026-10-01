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

package software.amazon.opensearch.client.aos.ml;

import jakarta.json.stream.JsonGenerator;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import software.amazon.opensearch.client.json.JsonpDeserializable;
import software.amazon.opensearch.client.json.JsonpDeserializer;
import software.amazon.opensearch.client.json.JsonpMapper;
import software.amazon.opensearch.client.json.ObjectBuilderDeserializer;
import software.amazon.opensearch.client.json.ObjectDeserializer;
import software.amazon.opensearch.client.json.PlainJsonSerializable;
import software.amazon.opensearch.client.util.CopyableBuilder;
import software.amazon.opensearch.client.util.ObjectBuilder;
import software.amazon.opensearch.client.util.ObjectBuilderBase;
import software.amazon.opensearch.client.util.ToCopyableBuilder;

// typedef: ml.ColumnMeta

@JsonpDeserializable
@Generated("software.amazon.opensearch.client.codegen.CodeGenerator")
public class ColumnMeta implements PlainJsonSerializable, ToCopyableBuilder<ColumnMeta.Builder, ColumnMeta> {

    @Nullable
    private final ColumnType columnType;

    @Nullable
    private final String name;

    // ---------------------------------------------------------------------------------------------

    private ColumnMeta(Builder builder) {
        this.columnType = builder.columnType;
        this.name = builder.name;
    }

    public static ColumnMeta of(Function<ColumnMeta.Builder, ObjectBuilder<ColumnMeta>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code column_type}
     */
    @Nullable
    public final ColumnType columnType() {
        return this.columnType;
    }

    /**
     * API name: {@code name}
     */
    @Nullable
    public final String name() {
        return this.name;
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
        if (this.columnType != null) {
            generator.writeKey("column_type");
            this.columnType.serialize(generator, mapper);
        }

        if (this.name != null) {
            generator.writeKey("name");
            generator.write(this.name);
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
     * Builder for {@link ColumnMeta}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ColumnMeta> {
        @Nullable
        private ColumnType columnType;
        @Nullable
        private String name;

        public Builder() {}

        private Builder(ColumnMeta o) {
            this.columnType = o.columnType;
            this.name = o.name;
        }

        private Builder(Builder o) {
            this.columnType = o.columnType;
            this.name = o.name;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code column_type}
         */
        @Nonnull
        public final Builder columnType(@Nullable ColumnType value) {
            this.columnType = value;
            return this;
        }

        /**
         * API name: {@code name}
         */
        @Nonnull
        public final Builder name(@Nullable String value) {
            this.name = value;
            return this;
        }

        /**
         * Builds a {@link ColumnMeta}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ColumnMeta build() {
            _checkSingleUse();

            return new ColumnMeta(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ColumnMeta}
     */
    public static final JsonpDeserializer<ColumnMeta> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ColumnMeta::setupColumnMetaDeserializer
    );

    protected static void setupColumnMetaDeserializer(ObjectDeserializer<ColumnMeta.Builder> op) {
        op.add(Builder::columnType, ColumnType._DESERIALIZER, "column_type");
        op.add(Builder::name, JsonpDeserializer.stringDeserializer(), "name");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.columnType);
        result = 31 * result + Objects.hashCode(this.name);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ColumnMeta other = (ColumnMeta) o;
        return Objects.equals(this.columnType, other.columnType) && Objects.equals(this.name, other.name);
    }
}
