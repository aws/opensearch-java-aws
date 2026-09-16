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
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
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

// typedef: indices.NumericFielddata

/**
 * The configuration for numeric field data.
 */
@JsonpDeserializable
@Generated("software.amazon.awssdk.opensearch.client.codegen.CodeGenerator")
public class NumericFielddata implements PlainJsonSerializable, ToCopyableBuilder<NumericFielddata.Builder, NumericFielddata> {

    @Nonnull
    private final NumericFielddataFormat format;

    // ---------------------------------------------------------------------------------------------

    private NumericFielddata(Builder builder) {
        this.format = ApiTypeHelper.requireNonNull(builder.format, this, "format");
    }

    public static NumericFielddata of(Function<NumericFielddata.Builder, ObjectBuilder<NumericFielddata>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code format}
     */
    @Nonnull
    public final NumericFielddataFormat format() {
        return this.format;
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
        generator.writeKey("format");
        this.format.serialize(generator, mapper);
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
     * Builder for {@link NumericFielddata}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, NumericFielddata> {
        private NumericFielddataFormat format;

        public Builder() {}

        private Builder(NumericFielddata o) {
            this.format = o.format;
        }

        private Builder(Builder o) {
            this.format = o.format;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code format}
         */
        @Nonnull
        public final Builder format(NumericFielddataFormat value) {
            this.format = value;
            return this;
        }

        /**
         * Builds a {@link NumericFielddata}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public NumericFielddata build() {
            _checkSingleUse();

            return new NumericFielddata(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link NumericFielddata}
     */
    public static final JsonpDeserializer<NumericFielddata> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        NumericFielddata::setupNumericFielddataDeserializer
    );

    protected static void setupNumericFielddataDeserializer(ObjectDeserializer<NumericFielddata.Builder> op) {
        op.add(Builder::format, NumericFielddataFormat._DESERIALIZER, "format");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.format.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        NumericFielddata other = (NumericFielddata) o;
        return this.format.equals(other.format);
    }
}
