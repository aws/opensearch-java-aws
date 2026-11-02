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

package software.amazon.opensearch.client.aos.ltr;

import jakarta.json.stream.JsonGenerator;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import software.amazon.opensearch.client.aos._types.RequestBase;
import software.amazon.opensearch.client.errors.ErrorResponse;
import software.amazon.opensearch.client.json.JsonData;
import software.amazon.opensearch.client.json.JsonpDeserializable;
import software.amazon.opensearch.client.json.JsonpDeserializer;
import software.amazon.opensearch.client.json.JsonpMapper;
import software.amazon.opensearch.client.json.PlainJsonSerializable;
import software.amazon.opensearch.client.transport.Endpoint;
import software.amazon.opensearch.client.transport.endpoints.SimpleEndpoint;
import software.amazon.opensearch.client.util.ApiTypeHelper;
import software.amazon.opensearch.client.util.CopyableBuilder;
import software.amazon.opensearch.client.util.ObjectBuilder;
import software.amazon.opensearch.client.util.ToCopyableBuilder;

// typedef: ltr.update_feature.Request

/**
 * Update a feature in the default feature store.
 */
@JsonpDeserializable
@Generated("software.amazon.opensearch.client.codegen.CodeGenerator")
public final class UpdateFeatureRequest extends RequestBase
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<UpdateFeatureRequest.Builder, UpdateFeatureRequest> {

    @Nonnull
    private final Map<String, JsonData> body;

    @Nonnull
    private final String id;

    @Nullable
    private final String routing;

    @Nullable
    private final String store;

    // ---------------------------------------------------------------------------------------------

    private UpdateFeatureRequest(Builder builder) {
        super(builder);
        this.body = ApiTypeHelper.unmodifiableRequired(builder.body, this, "body");
        this.id = ApiTypeHelper.requireNonNull(builder.id, this, "id");
        this.routing = builder.routing;
        this.store = builder.store;
    }

    public static UpdateFeatureRequest of(Function<UpdateFeatureRequest.Builder, ObjectBuilder<UpdateFeatureRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - Request body.
     */
    @Nonnull
    public final Map<String, JsonData> body() {
        return this.body;
    }

    /**
     * Required - The name of the feature.
     * <p>
     * API name: {@code id}
     * </p>
     */
    @Nonnull
    public final String id() {
        return this.id;
    }

    /**
     * Specific routing value.
     * <p>
     * API name: {@code routing}
     * </p>
     */
    @Nullable
    public final String routing() {
        return this.routing;
    }

    /**
     * The name of the feature store.
     * <p>
     * API name: {@code store}
     * </p>
     */
    @Nullable
    public final String store() {
        return this.store;
    }

    /**
     * Serialize this value to JSON.
     */
    @Override
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
        for (Map.Entry<String, JsonData> item0 : this.body.entrySet()) {
            generator.writeKey(item0.getKey());
            item0.getValue().serialize(generator, mapper);
        }
        generator.writeEnd();
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
     * Builder for {@link UpdateFeatureRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, UpdateFeatureRequest> {
        private Map<String, JsonData> body;
        private String id;
        @Nullable
        private String routing;
        @Nullable
        private String store;

        public Builder() {}

        private Builder(UpdateFeatureRequest o) {
            super(o);
            this.body = _mapCopy(o.body);
            this.id = o.id;
            this.routing = o.routing;
            this.store = o.store;
        }

        private Builder(Builder o) {
            super(o);
            this.body = _mapCopy(o.body);
            this.id = o.id;
            this.routing = o.routing;
            this.store = o.store;
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
         * Required - Request body.
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>body</code>.
         * </p>
         */
        @Nonnull
        public final Builder body(Map<String, JsonData> map) {
            this.body = _mapPutAll(this.body, map);
            return this;
        }

        /**
         * Required - Request body.
         *
         * <p>
         * Adds an entry to <code>body</code>.
         * </p>
         */
        @Nonnull
        public final Builder body(String key, JsonData value) {
            this.body = _mapPut(this.body, key, value);
            return this;
        }

        /**
         * Required - The name of the feature.
         * <p>
         * API name: {@code id}
         * </p>
         */
        @Nonnull
        public final Builder id(String value) {
            this.id = value;
            return this;
        }

        /**
         * Specific routing value.
         * <p>
         * API name: {@code routing}
         * </p>
         */
        @Nonnull
        public final Builder routing(@Nullable String value) {
            this.routing = value;
            return this;
        }

        /**
         * The name of the feature store.
         * <p>
         * API name: {@code store}
         * </p>
         */
        @Nonnull
        public final Builder store(@Nullable String value) {
            this.store = value;
            return this;
        }

        /**
         * Builds a {@link UpdateFeatureRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public UpdateFeatureRequest build() {
            _checkSingleUse();

            return new UpdateFeatureRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    public static final JsonpDeserializer<UpdateFeatureRequest> _DESERIALIZER = createUpdateFeatureRequestDeserializer();

    protected static JsonpDeserializer<UpdateFeatureRequest> createUpdateFeatureRequestDeserializer() {
        JsonpDeserializer<Map<String, JsonData>> valueDeserializer = JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER);
        return JsonpDeserializer.of(
            valueDeserializer.acceptedEvents(),
            (parser, mapper) -> new Builder().body(valueDeserializer.deserialize(parser, mapper)).build()
        );
    }

    // ---------------------------------------------------------------------------------------------

    @Override
    protected void applyQueryParameters(@Nonnull Map<String, String> params) {
        super.applyQueryParameters(params);
        if (this.routing != null) {
            params.put("routing", this.routing);
        }
    }

    /**
     * Endpoint "{@code ltr.update_feature}".
     */
    public static final Endpoint<UpdateFeatureRequest, UpdateFeatureResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "POST",
        // Request path
        request -> {
            final int _id = 1 << 0;
            final int _store = 1 << 1;

            int propsSet = 0;

            propsSet |= _id;
            if (request.store() != null) propsSet |= _store;

            if (propsSet == (_id)) {
                StringBuilder buf = new StringBuilder();
                buf.append("/_ltr/_feature/");
                SimpleEndpoint.pathEncode(request.id, buf);
                return buf.toString();
            }
            if (propsSet == (_store | _id)) {
                StringBuilder buf = new StringBuilder();
                buf.append("/_ltr/");
                SimpleEndpoint.pathEncode(request.store, buf);
                buf.append("/_feature/");
                SimpleEndpoint.pathEncode(request.id, buf);
                return buf.toString();
            }

            throw SimpleEndpoint.noPathTemplateFound("path");
        },
        // Request parameters
        request -> {
            Map<String, String> params = new HashMap<>();
            request.applyQueryParameters(params);
            return params;
        },
        SimpleEndpoint.emptyMap(),
        true,
        UpdateFeatureResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.body.hashCode();
        result = 31 * result + this.id.hashCode();
        result = 31 * result + Objects.hashCode(this.routing);
        result = 31 * result + Objects.hashCode(this.store);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        UpdateFeatureRequest other = (UpdateFeatureRequest) o;
        return this.body.equals(other.body)
            && this.id.equals(other.id)
            && Objects.equals(this.routing, other.routing)
            && Objects.equals(this.store, other.store);
    }
}
