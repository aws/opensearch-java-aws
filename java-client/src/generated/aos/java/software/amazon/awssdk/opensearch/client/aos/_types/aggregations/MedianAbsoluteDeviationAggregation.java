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

package software.amazon.awssdk.opensearch.client.aos._types.aggregations;

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
import software.amazon.awssdk.opensearch.client.util.CopyableBuilder;
import software.amazon.awssdk.opensearch.client.util.ObjectBuilder;
import software.amazon.awssdk.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.aggregations.MedianAbsoluteDeviationAggregation

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class MedianAbsoluteDeviationAggregation extends FormatMetricAggregationBase
    implements
        ToCopyableBuilder<MedianAbsoluteDeviationAggregation.Builder, MedianAbsoluteDeviationAggregation> {

    @Nullable
    private final Double compression;

    // ---------------------------------------------------------------------------------------------

    private MedianAbsoluteDeviationAggregation(Builder builder) {
        super(builder);
        this.compression = builder.compression;
    }

    public static MedianAbsoluteDeviationAggregation of(
        Function<MedianAbsoluteDeviationAggregation.Builder, ObjectBuilder<MedianAbsoluteDeviationAggregation>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Limits the maximum number of nodes used by the underlying TDigest algorithm to <code>20 * compression</code>, enabling control of
     * memory usage and approximation error.
     * <p>
     * API name: {@code compression}
     * </p>
     */
    @Nullable
    public final Double compression() {
        return this.compression;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (this.compression != null) {
            generator.writeKey("compression");
            generator.write(this.compression);
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
     * Builder for {@link MedianAbsoluteDeviationAggregation}.
     */
    public static class Builder extends FormatMetricAggregationBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, MedianAbsoluteDeviationAggregation> {
        @Nullable
        private Double compression;

        public Builder() {}

        private Builder(MedianAbsoluteDeviationAggregation o) {
            super(o);
            this.compression = o.compression;
        }

        private Builder(Builder o) {
            super(o);
            this.compression = o.compression;
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
         * Limits the maximum number of nodes used by the underlying TDigest algorithm to <code>20 * compression</code>, enabling control of
         * memory usage and approximation error.
         * <p>
         * API name: {@code compression}
         * </p>
         */
        @Nonnull
        public final Builder compression(@Nullable Double value) {
            this.compression = value;
            return this;
        }

        /**
         * Builds a {@link MedianAbsoluteDeviationAggregation}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public MedianAbsoluteDeviationAggregation build() {
            _checkSingleUse();

            return new MedianAbsoluteDeviationAggregation(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link MedianAbsoluteDeviationAggregation}
     */
    public static final JsonpDeserializer<MedianAbsoluteDeviationAggregation> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        MedianAbsoluteDeviationAggregation::setupMedianAbsoluteDeviationAggregationDeserializer
    );

    protected static void setupMedianAbsoluteDeviationAggregationDeserializer(
        ObjectDeserializer<MedianAbsoluteDeviationAggregation.Builder> op
    ) {
        setupFormatMetricAggregationBaseDeserializer(op);
        op.add(Builder::compression, JsonpDeserializer.doubleDeserializer(), "compression");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.compression);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        MedianAbsoluteDeviationAggregation other = (MedianAbsoluteDeviationAggregation) o;
        return Objects.equals(this.compression, other.compression);
    }
}
