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

package software.amazon.opensearch.client.aoss._types.aggregations;

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

// typedef: _types.aggregations.HdrMethod

@JsonpDeserializable
@Generated("software.amazon.opensearch.client.codegen.CodeGenerator")
public class HdrMethod implements PlainJsonSerializable, ToCopyableBuilder<HdrMethod.Builder, HdrMethod> {

    @Nullable
    private final Integer numberOfSignificantValueDigits;

    // ---------------------------------------------------------------------------------------------

    private HdrMethod(Builder builder) {
        this.numberOfSignificantValueDigits = builder.numberOfSignificantValueDigits;
    }

    public static HdrMethod of(Function<HdrMethod.Builder, ObjectBuilder<HdrMethod>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Specifies the resolution of values for the histogram in number of significant digits.
     * <p>
     * API name: {@code number_of_significant_value_digits}
     * </p>
     */
    @Nullable
    public final Integer numberOfSignificantValueDigits() {
        return this.numberOfSignificantValueDigits;
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
        if (this.numberOfSignificantValueDigits != null) {
            generator.writeKey("number_of_significant_value_digits");
            generator.write(this.numberOfSignificantValueDigits);
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
     * Builder for {@link HdrMethod}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, HdrMethod> {
        @Nullable
        private Integer numberOfSignificantValueDigits;

        public Builder() {}

        private Builder(HdrMethod o) {
            this.numberOfSignificantValueDigits = o.numberOfSignificantValueDigits;
        }

        private Builder(Builder o) {
            this.numberOfSignificantValueDigits = o.numberOfSignificantValueDigits;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Specifies the resolution of values for the histogram in number of significant digits.
         * <p>
         * API name: {@code number_of_significant_value_digits}
         * </p>
         */
        @Nonnull
        public final Builder numberOfSignificantValueDigits(@Nullable Integer value) {
            this.numberOfSignificantValueDigits = value;
            return this;
        }

        /**
         * Builds a {@link HdrMethod}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public HdrMethod build() {
            _checkSingleUse();

            return new HdrMethod(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link HdrMethod}
     */
    public static final JsonpDeserializer<HdrMethod> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        HdrMethod::setupHdrMethodDeserializer
    );

    protected static void setupHdrMethodDeserializer(ObjectDeserializer<HdrMethod.Builder> op) {
        op.add(Builder::numberOfSignificantValueDigits, JsonpDeserializer.integerDeserializer(), "number_of_significant_value_digits");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.numberOfSignificantValueDigits);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        HdrMethod other = (HdrMethod) o;
        return Objects.equals(this.numberOfSignificantValueDigits, other.numberOfSignificantValueDigits);
    }
}
