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

package software.amazon.opensearch.client.aos._types.query_dsl;

import jakarta.json.stream.JsonGenerator;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import software.amazon.opensearch.client.aos._types.GeoShapeRelation;
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

// typedef: _types.query_dsl.XyShapeQueryField

@JsonpDeserializable
@Generated("software.amazon.opensearch.client.codegen.CodeGenerator")
public class XyShapeQueryField implements PlainJsonSerializable, ToCopyableBuilder<XyShapeQueryField.Builder, XyShapeQueryField> {

    @Nullable
    private final FieldLookup indexedShape;

    @Nullable
    private final GeoShapeRelation relation;

    @Nonnull
    private final XyShape shape;

    // ---------------------------------------------------------------------------------------------

    private XyShapeQueryField(Builder builder) {
        this.indexedShape = builder.indexedShape;
        this.relation = builder.relation;
        this.shape = ApiTypeHelper.requireNonNull(builder.shape, this, "shape");
    }

    public static XyShapeQueryField of(Function<XyShapeQueryField.Builder, ObjectBuilder<XyShapeQueryField>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code indexed_shape}
     */
    @Nullable
    public final FieldLookup indexedShape() {
        return this.indexedShape;
    }

    /**
     * API name: {@code relation}
     */
    @Nullable
    public final GeoShapeRelation relation() {
        return this.relation;
    }

    /**
     * Required - API name: {@code shape}
     */
    @Nonnull
    public final XyShape shape() {
        return this.shape;
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
        if (this.indexedShape != null) {
            generator.writeKey("indexed_shape");
            this.indexedShape.serialize(generator, mapper);
        }

        if (this.relation != null) {
            generator.writeKey("relation");
            this.relation.serialize(generator, mapper);
        }

        generator.writeKey("shape");
        this.shape.serialize(generator, mapper);
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
     * Builder for {@link XyShapeQueryField}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, XyShapeQueryField> {
        @Nullable
        private FieldLookup indexedShape;
        @Nullable
        private GeoShapeRelation relation;
        private XyShape shape;

        public Builder() {}

        private Builder(XyShapeQueryField o) {
            this.indexedShape = o.indexedShape;
            this.relation = o.relation;
            this.shape = o.shape;
        }

        private Builder(Builder o) {
            this.indexedShape = o.indexedShape;
            this.relation = o.relation;
            this.shape = o.shape;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code indexed_shape}
         */
        @Nonnull
        public final Builder indexedShape(@Nullable FieldLookup value) {
            this.indexedShape = value;
            return this;
        }

        /**
         * API name: {@code indexed_shape}
         */
        @Nonnull
        public final Builder indexedShape(Function<FieldLookup.Builder, ObjectBuilder<FieldLookup>> fn) {
            return indexedShape(fn.apply(new FieldLookup.Builder()).build());
        }

        /**
         * API name: {@code relation}
         */
        @Nonnull
        public final Builder relation(@Nullable GeoShapeRelation value) {
            this.relation = value;
            return this;
        }

        /**
         * Required - API name: {@code shape}
         */
        @Nonnull
        public final Builder shape(XyShape value) {
            this.shape = value;
            return this;
        }

        /**
         * Required - API name: {@code shape}
         */
        @Nonnull
        public final Builder shape(Function<XyShape.Builder, ObjectBuilder<XyShape>> fn) {
            return shape(fn.apply(new XyShape.Builder()).build());
        }

        /**
         * Builds a {@link XyShapeQueryField}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public XyShapeQueryField build() {
            _checkSingleUse();

            return new XyShapeQueryField(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link XyShapeQueryField}
     */
    public static final JsonpDeserializer<XyShapeQueryField> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        XyShapeQueryField::setupXyShapeQueryFieldDeserializer
    );

    protected static void setupXyShapeQueryFieldDeserializer(ObjectDeserializer<XyShapeQueryField.Builder> op) {
        op.add(Builder::indexedShape, FieldLookup._DESERIALIZER, "indexed_shape");
        op.add(Builder::relation, GeoShapeRelation._DESERIALIZER, "relation");
        op.add(Builder::shape, XyShape._DESERIALIZER, "shape");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.indexedShape);
        result = 31 * result + Objects.hashCode(this.relation);
        result = 31 * result + this.shape.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        XyShapeQueryField other = (XyShapeQueryField) o;
        return Objects.equals(this.indexedShape, other.indexedShape)
            && Objects.equals(this.relation, other.relation)
            && this.shape.equals(other.shape);
    }
}
