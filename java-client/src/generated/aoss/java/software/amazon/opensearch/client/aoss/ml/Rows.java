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
import java.util.List;
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
import software.amazon.opensearch.client.util.ApiTypeHelper;
import software.amazon.opensearch.client.util.CopyableBuilder;
import software.amazon.opensearch.client.util.ObjectBuilder;
import software.amazon.opensearch.client.util.ObjectBuilderBase;
import software.amazon.opensearch.client.util.ToCopyableBuilder;

// typedef: ml.Rows

@JsonpDeserializable
@Generated("software.amazon.opensearch.client.codegen.CodeGenerator")
public class Rows implements PlainJsonSerializable, ToCopyableBuilder<Rows.Builder, Rows> {

    @Nonnull
    private final List<Values> values;

    // ---------------------------------------------------------------------------------------------

    private Rows(Builder builder) {
        this.values = ApiTypeHelper.unmodifiable(builder.values);
    }

    public static Rows of(Function<Rows.Builder, ObjectBuilder<Rows>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code values}
     */
    @Nonnull
    public final List<Values> values() {
        return this.values;
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
        if (ApiTypeHelper.isDefined(this.values)) {
            generator.writeKey("values");
            generator.writeStartArray();
            for (Values item0 : this.values) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
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
     * Builder for {@link Rows}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, Rows> {
        @Nullable
        private List<Values> values;

        public Builder() {}

        private Builder(Rows o) {
            this.values = _listCopy(o.values);
        }

        private Builder(Builder o) {
            this.values = _listCopy(o.values);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code values}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>values</code>.
         * </p>
         */
        @Nonnull
        public final Builder values(List<Values> list) {
            this.values = _listAddAll(this.values, list);
            return this;
        }

        /**
         * API name: {@code values}
         *
         * <p>
         * Adds one or more values to <code>values</code>.
         * </p>
         */
        @Nonnull
        public final Builder values(Values value, Values... values) {
            this.values = _listAdd(this.values, value, values);
            return this;
        }

        /**
         * API name: {@code values}
         *
         * <p>
         * Adds a value to <code>values</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder values(Function<Values.Builder, ObjectBuilder<Values>> fn) {
            return values(fn.apply(new Values.Builder()).build());
        }

        /**
         * Builds a {@link Rows}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public Rows build() {
            _checkSingleUse();

            return new Rows(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link Rows}
     */
    public static final JsonpDeserializer<Rows> _DESERIALIZER = ObjectBuilderDeserializer.lazy(Builder::new, Rows::setupRowsDeserializer);

    protected static void setupRowsDeserializer(ObjectDeserializer<Rows.Builder> op) {
        op.add(Builder::values, JsonpDeserializer.arrayDeserializer(Values._DESERIALIZER), "values");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.values);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Rows other = (Rows) o;
        return Objects.equals(this.values, other.values);
    }
}
