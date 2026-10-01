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

package software.amazon.opensearch.client.aoss._types.query_dsl;

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
import software.amazon.opensearch.client.util.ApiTypeHelper;
import software.amazon.opensearch.client.util.CopyableBuilder;
import software.amazon.opensearch.client.util.ObjectBuilder;
import software.amazon.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.query_dsl.XyShapeQuery

@JsonpDeserializable
@Generated("software.amazon.opensearch.client.codegen.CodeGenerator")
public class XyShapeQuery extends QueryBase implements QueryVariant, ToCopyableBuilder<XyShapeQuery.Builder, XyShapeQuery> {

    @Nonnull
    private final String field;

    @Nullable
    private final Boolean ignoreUnmapped;

    @Nonnull
    private final XyShapeQueryField xyShape;

    // ---------------------------------------------------------------------------------------------

    private XyShapeQuery(Builder builder) {
        super(builder);
        this.field = ApiTypeHelper.requireNonNull(builder.field, this, "field");
        this.ignoreUnmapped = builder.ignoreUnmapped;
        this.xyShape = ApiTypeHelper.requireNonNull(builder.xyShape, this, "xyShape");
    }

    public static XyShapeQuery of(Function<XyShapeQuery.Builder, ObjectBuilder<XyShapeQuery>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Query} variant kind.
     */
    @Override
    public Query.Kind _queryKind() {
        return Query.Kind.XyShape;
    }

    /**
     * Required -
     */
    @Nonnull
    public final String field() {
        return this.field;
    }

    /**
     * API name: {@code ignore_unmapped}
     */
    @Nullable
    public final Boolean ignoreUnmapped() {
        return this.ignoreUnmapped;
    }

    /**
     * Required -
     */
    @Nonnull
    public final XyShapeQueryField xyShape() {
        return this.xyShape;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        generator.writeKey(this.field);
        this.xyShape.serialize(generator, mapper);
        if (this.ignoreUnmapped != null) {
            generator.writeKey("ignore_unmapped");
            generator.write(this.ignoreUnmapped);
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
     * Builder for {@link XyShapeQuery}.
     */
    public static class Builder extends QueryBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, XyShapeQuery> {
        private String field;
        @Nullable
        private Boolean ignoreUnmapped;
        private XyShapeQueryField xyShape;

        public Builder() {}

        private Builder(XyShapeQuery o) {
            super(o);
            this.field = o.field;
            this.ignoreUnmapped = o.ignoreUnmapped;
            this.xyShape = o.xyShape;
        }

        private Builder(Builder o) {
            super(o);
            this.field = o.field;
            this.ignoreUnmapped = o.ignoreUnmapped;
            this.xyShape = o.xyShape;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        @Override
        @Nonnull
        protected Builder self() {
            return this;
        }

        /**
         * Required -
         */
        @Nonnull
        public final Builder field(String value) {
            this.field = value;
            return this;
        }

        /**
         * API name: {@code ignore_unmapped}
         */
        @Nonnull
        public final Builder ignoreUnmapped(@Nullable Boolean value) {
            this.ignoreUnmapped = value;
            return this;
        }

        /**
         * Required -
         */
        @Nonnull
        public final Builder xyShape(XyShapeQueryField value) {
            this.xyShape = value;
            return this;
        }

        /**
         * Required -
         */
        @Nonnull
        public final Builder xyShape(Function<XyShapeQueryField.Builder, ObjectBuilder<XyShapeQueryField>> fn) {
            return xyShape(fn.apply(new XyShapeQueryField.Builder()).build());
        }

        /**
         * Builds a {@link XyShapeQuery}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public XyShapeQuery build() {
            _checkSingleUse();

            return new XyShapeQuery(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link XyShapeQuery}
     */
    public static final JsonpDeserializer<XyShapeQuery> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        XyShapeQuery::setupXyShapeQueryDeserializer
    );

    protected static void setupXyShapeQueryDeserializer(ObjectDeserializer<XyShapeQuery.Builder> op) {
        setupQueryBaseDeserializer(op);
        op.add(Builder::ignoreUnmapped, JsonpDeserializer.booleanDeserializer(), "ignore_unmapped");
        op.setUnknownFieldHandler((builder, name, parser, mapper) -> {
            builder.field(name);
            builder.xyShape(XyShapeQueryField._DESERIALIZER.deserialize(parser, mapper));
        });
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + this.field.hashCode();
        result = 31 * result + Objects.hashCode(this.ignoreUnmapped);
        result = 31 * result + this.xyShape.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        XyShapeQuery other = (XyShapeQuery) o;
        return this.field.equals(other.field)
            && Objects.equals(this.ignoreUnmapped, other.ignoreUnmapped)
            && this.xyShape.equals(other.xyShape);
    }
}
