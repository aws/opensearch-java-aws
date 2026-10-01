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

package software.amazon.opensearch.client.aos.ultrawarm;

import jakarta.json.stream.JsonGenerator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import software.amazon.opensearch.client.json.JsonData;
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

// typedef: ultrawarm.to_cold.Response

@JsonpDeserializable
@Generated("software.amazon.opensearch.client.codegen.CodeGenerator")
public class ToColdResponse implements PlainJsonSerializable, ToCopyableBuilder<ToColdResponse.Builder, ToColdResponse> {

    @Nullable
    private final Boolean acknowledged;

    @Nonnull
    private final List<Map<String, JsonData>> failedIndices;

    // ---------------------------------------------------------------------------------------------

    private ToColdResponse(Builder builder) {
        this.acknowledged = builder.acknowledged;
        this.failedIndices = ApiTypeHelper.unmodifiable(builder.failedIndices);
    }

    public static ToColdResponse of(Function<ToColdResponse.Builder, ObjectBuilder<ToColdResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code acknowledged}
     */
    @Nullable
    public final Boolean acknowledged() {
        return this.acknowledged;
    }

    /**
     * API name: {@code failed_indices}
     */
    @Nonnull
    public final List<Map<String, JsonData>> failedIndices() {
        return this.failedIndices;
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
        if (this.acknowledged != null) {
            generator.writeKey("acknowledged");
            generator.write(this.acknowledged);
        }

        if (ApiTypeHelper.isDefined(this.failedIndices)) {
            generator.writeKey("failed_indices");
            generator.writeStartArray();
            for (Map<String, JsonData> item0 : this.failedIndices) {
                generator.writeStartObject();
                if (item0 != null) {
                    for (Map.Entry<String, JsonData> item1 : item0.entrySet()) {
                        generator.writeKey(item1.getKey());
                        item1.getValue().serialize(generator, mapper);
                    }
                }
                generator.writeEnd();
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
     * Builder for {@link ToColdResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ToColdResponse> {
        @Nullable
        private Boolean acknowledged;
        @Nullable
        private List<Map<String, JsonData>> failedIndices;

        public Builder() {}

        private Builder(ToColdResponse o) {
            this.acknowledged = o.acknowledged;
            this.failedIndices = _listCopy(o.failedIndices);
        }

        private Builder(Builder o) {
            this.acknowledged = o.acknowledged;
            this.failedIndices = _listCopy(o.failedIndices);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code acknowledged}
         */
        @Nonnull
        public final Builder acknowledged(@Nullable Boolean value) {
            this.acknowledged = value;
            return this;
        }

        /**
         * API name: {@code failed_indices}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>failedIndices</code>.
         * </p>
         */
        @Nonnull
        public final Builder failedIndices(List<Map<String, JsonData>> list) {
            this.failedIndices = _listAddAll(this.failedIndices, list);
            return this;
        }

        /**
         * API name: {@code failed_indices}
         *
         * <p>
         * Adds one or more values to <code>failedIndices</code>.
         * </p>
         */
        @Nonnull
        public final Builder failedIndices(Map<String, JsonData> value, Map<String, JsonData>... values) {
            this.failedIndices = _listAdd(this.failedIndices, value, values);
            return this;
        }

        /**
         * Builds a {@link ToColdResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ToColdResponse build() {
            _checkSingleUse();

            return new ToColdResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ToColdResponse}
     */
    public static final JsonpDeserializer<ToColdResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ToColdResponse::setupToColdResponseDeserializer
    );

    protected static void setupToColdResponseDeserializer(ObjectDeserializer<ToColdResponse.Builder> op) {
        op.add(Builder::acknowledged, JsonpDeserializer.booleanDeserializer(), "acknowledged");
        op.add(
            Builder::failedIndices,
            JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER)),
            "failed_indices"
        );
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.acknowledged);
        result = 31 * result + Objects.hashCode(this.failedIndices);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ToColdResponse other = (ToColdResponse) o;
        return Objects.equals(this.acknowledged, other.acknowledged) && Objects.equals(this.failedIndices, other.failedIndices);
    }
}
