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

package software.amazon.opensearch.client.aos.core.search;

import jakarta.json.stream.JsonGenerator;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
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

// typedef: core.search.LaplaceSmoothingModel

@JsonpDeserializable
@Generated("software.amazon.opensearch.client.codegen.CodeGenerator")
public class LaplaceSmoothingModel
    implements
        SmoothingModelVariant,
        PlainJsonSerializable,
        ToCopyableBuilder<LaplaceSmoothingModel.Builder, LaplaceSmoothingModel> {

    private final double alpha;

    // ---------------------------------------------------------------------------------------------

    private LaplaceSmoothingModel(Builder builder) {
        this.alpha = ApiTypeHelper.requireNonNull(builder.alpha, this, "alpha");
    }

    public static LaplaceSmoothingModel of(Function<LaplaceSmoothingModel.Builder, ObjectBuilder<LaplaceSmoothingModel>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link SmoothingModel} variant kind.
     */
    @Override
    public SmoothingModel.Kind _smoothingModelKind() {
        return SmoothingModel.Kind.Laplace;
    }

    /**
     * Required - API name: {@code alpha}
     */
    public final double alpha() {
        return this.alpha;
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
        generator.writeKey("alpha");
        generator.write(this.alpha);
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
     * Builder for {@link LaplaceSmoothingModel}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, LaplaceSmoothingModel> {
        private Double alpha;

        public Builder() {}

        private Builder(LaplaceSmoothingModel o) {
            this.alpha = o.alpha;
        }

        private Builder(Builder o) {
            this.alpha = o.alpha;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code alpha}
         */
        @Nonnull
        public final Builder alpha(double value) {
            this.alpha = value;
            return this;
        }

        /**
         * Builds a {@link LaplaceSmoothingModel}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public LaplaceSmoothingModel build() {
            _checkSingleUse();

            return new LaplaceSmoothingModel(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link LaplaceSmoothingModel}
     */
    public static final JsonpDeserializer<LaplaceSmoothingModel> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        LaplaceSmoothingModel::setupLaplaceSmoothingModelDeserializer
    );

    protected static void setupLaplaceSmoothingModelDeserializer(ObjectDeserializer<LaplaceSmoothingModel.Builder> op) {
        op.add(Builder::alpha, JsonpDeserializer.doubleDeserializer(), "alpha");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Double.hashCode(this.alpha);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        LaplaceSmoothingModel other = (LaplaceSmoothingModel) o;
        return this.alpha == other.alpha;
    }
}
