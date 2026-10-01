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

package software.amazon.opensearch.client.aoss._types.mapping;

import jakarta.json.stream.JsonGenerator;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import software.amazon.opensearch.client.aoss._types.XyLocation;
import software.amazon.opensearch.client.json.JsonpDeserializable;
import software.amazon.opensearch.client.json.JsonpDeserializer;
import software.amazon.opensearch.client.json.JsonpMapper;
import software.amazon.opensearch.client.json.ObjectBuilderDeserializer;
import software.amazon.opensearch.client.json.ObjectDeserializer;
import software.amazon.opensearch.client.util.CopyableBuilder;
import software.amazon.opensearch.client.util.ObjectBuilder;
import software.amazon.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.mapping.XyPointProperty

@JsonpDeserializable
@Generated("software.amazon.opensearch.client.codegen.CodeGenerator")
public class XyPointProperty extends DocValuesPropertyBase
    implements
        PropertyVariant,
        ToCopyableBuilder<XyPointProperty.Builder, XyPointProperty> {

    @Nullable
    private final Boolean ignoreMalformed;

    @Nullable
    private final Boolean ignoreZValue;

    @Nullable
    private final XyLocation nullValue;

    // ---------------------------------------------------------------------------------------------

    private XyPointProperty(Builder builder) {
        super(builder);
        this.ignoreMalformed = builder.ignoreMalformed;
        this.ignoreZValue = builder.ignoreZValue;
        this.nullValue = builder.nullValue;
    }

    public static XyPointProperty of(Function<XyPointProperty.Builder, ObjectBuilder<XyPointProperty>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Property} variant kind.
     */
    @Override
    public Property.Kind _propertyKind() {
        return Property.Kind.XyPoint;
    }

    /**
     * API name: {@code ignore_malformed}
     */
    @Nullable
    public final Boolean ignoreMalformed() {
        return this.ignoreMalformed;
    }

    /**
     * API name: {@code ignore_z_value}
     */
    @Nullable
    public final Boolean ignoreZValue() {
        return this.ignoreZValue;
    }

    /**
     * API name: {@code null_value}
     */
    @Nullable
    public final XyLocation nullValue() {
        return this.nullValue;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        generator.write("type", "xy_point");
        super.serializeInternal(generator, mapper);
        if (this.ignoreMalformed != null) {
            generator.writeKey("ignore_malformed");
            generator.write(this.ignoreMalformed);
        }

        if (this.ignoreZValue != null) {
            generator.writeKey("ignore_z_value");
            generator.write(this.ignoreZValue);
        }

        if (this.nullValue != null) {
            generator.writeKey("null_value");
            this.nullValue.serialize(generator, mapper);
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
     * Builder for {@link XyPointProperty}.
     */
    public static class Builder extends DocValuesPropertyBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, XyPointProperty> {
        @Nullable
        private Boolean ignoreMalformed;
        @Nullable
        private Boolean ignoreZValue;
        @Nullable
        private XyLocation nullValue;

        public Builder() {}

        private Builder(XyPointProperty o) {
            super(o);
            this.ignoreMalformed = o.ignoreMalformed;
            this.ignoreZValue = o.ignoreZValue;
            this.nullValue = o.nullValue;
        }

        private Builder(Builder o) {
            super(o);
            this.ignoreMalformed = o.ignoreMalformed;
            this.ignoreZValue = o.ignoreZValue;
            this.nullValue = o.nullValue;
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
         * API name: {@code ignore_malformed}
         */
        @Nonnull
        public final Builder ignoreMalformed(@Nullable Boolean value) {
            this.ignoreMalformed = value;
            return this;
        }

        /**
         * API name: {@code ignore_z_value}
         */
        @Nonnull
        public final Builder ignoreZValue(@Nullable Boolean value) {
            this.ignoreZValue = value;
            return this;
        }

        /**
         * API name: {@code null_value}
         */
        @Nonnull
        public final Builder nullValue(@Nullable XyLocation value) {
            this.nullValue = value;
            return this;
        }

        /**
         * API name: {@code null_value}
         */
        @Nonnull
        public final Builder nullValue(Function<XyLocation.Builder, ObjectBuilder<XyLocation>> fn) {
            return nullValue(fn.apply(new XyLocation.Builder()).build());
        }

        /**
         * Builds a {@link XyPointProperty}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public XyPointProperty build() {
            _checkSingleUse();

            return new XyPointProperty(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link XyPointProperty}
     */
    public static final JsonpDeserializer<XyPointProperty> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        XyPointProperty::setupXyPointPropertyDeserializer
    );

    protected static void setupXyPointPropertyDeserializer(ObjectDeserializer<XyPointProperty.Builder> op) {
        setupDocValuesPropertyBaseDeserializer(op);
        op.add(Builder::ignoreMalformed, JsonpDeserializer.booleanDeserializer(), "ignore_malformed");
        op.add(Builder::ignoreZValue, JsonpDeserializer.booleanDeserializer(), "ignore_z_value");
        op.add(Builder::nullValue, XyLocation._DESERIALIZER, "null_value");

        op.ignore("type");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.ignoreMalformed);
        result = 31 * result + Objects.hashCode(this.ignoreZValue);
        result = 31 * result + Objects.hashCode(this.nullValue);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        XyPointProperty other = (XyPointProperty) o;
        return Objects.equals(this.ignoreMalformed, other.ignoreMalformed)
            && Objects.equals(this.ignoreZValue, other.ignoreZValue)
            && Objects.equals(this.nullValue, other.nullValue);
    }
}
