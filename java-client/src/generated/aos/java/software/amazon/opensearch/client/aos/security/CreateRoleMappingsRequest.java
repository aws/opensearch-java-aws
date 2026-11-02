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

package software.amazon.opensearch.client.aos.security;

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

// typedef: security.create_role_mappings.Request

/**
 * Creates or replaces multiple role mappings. Role mappings omitted from the request are unchanged. Every named role must exist, and all
 * entries are validated before any changes are written.
 */
@JsonpDeserializable
@Generated("software.amazon.opensearch.client.codegen.CodeGenerator")
public final class CreateRoleMappingsRequest extends RequestBase
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<CreateRoleMappingsRequest.Builder, CreateRoleMappingsRequest> {

    @Nonnull
    private final Map<String, RoleMapping> body;

    @Nullable
    private final Boolean waitForCompletion;

    // ---------------------------------------------------------------------------------------------

    private CreateRoleMappingsRequest(Builder builder) {
        super(builder);
        this.body = ApiTypeHelper.unmodifiableRequired(builder.body, this, "body");
        this.waitForCompletion = builder.waitForCompletion;
    }

    public static CreateRoleMappingsRequest of(Function<CreateRoleMappingsRequest.Builder, ObjectBuilder<CreateRoleMappingsRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - Request body.
     */
    @Nonnull
    public final Map<String, RoleMapping> body() {
        return this.body;
    }

    /**
     * If false, returns a task ID after validation and runs the configuration write and reload asynchronously.
     * <p>
     * API name: {@code wait_for_completion}
     * </p>
     */
    @Nullable
    public final Boolean waitForCompletion() {
        return this.waitForCompletion;
    }

    /**
     * Serialize this value to JSON.
     */
    @Override
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
        for (Map.Entry<String, RoleMapping> item0 : this.body.entrySet()) {
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
     * Builder for {@link CreateRoleMappingsRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, CreateRoleMappingsRequest> {
        private Map<String, RoleMapping> body;
        @Nullable
        private Boolean waitForCompletion;

        public Builder() {}

        private Builder(CreateRoleMappingsRequest o) {
            super(o);
            this.body = _mapCopy(o.body);
            this.waitForCompletion = o.waitForCompletion;
        }

        private Builder(Builder o) {
            super(o);
            this.body = _mapCopy(o.body);
            this.waitForCompletion = o.waitForCompletion;
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
        public final Builder body(Map<String, RoleMapping> map) {
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
        public final Builder body(String key, RoleMapping value) {
            this.body = _mapPut(this.body, key, value);
            return this;
        }

        /**
         * Required - Request body.
         *
         * <p>
         * Adds a value to <code>body</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder body(String key, Function<RoleMapping.Builder, ObjectBuilder<RoleMapping>> fn) {
            return body(key, fn.apply(new RoleMapping.Builder()).build());
        }

        /**
         * If false, returns a task ID after validation and runs the configuration write and reload asynchronously.
         * <p>
         * API name: {@code wait_for_completion}
         * </p>
         */
        @Nonnull
        public final Builder waitForCompletion(@Nullable Boolean value) {
            this.waitForCompletion = value;
            return this;
        }

        /**
         * Builds a {@link CreateRoleMappingsRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public CreateRoleMappingsRequest build() {
            _checkSingleUse();

            return new CreateRoleMappingsRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    public static final JsonpDeserializer<CreateRoleMappingsRequest> _DESERIALIZER = createCreateRoleMappingsRequestDeserializer();

    protected static JsonpDeserializer<CreateRoleMappingsRequest> createCreateRoleMappingsRequestDeserializer() {
        JsonpDeserializer<Map<String, RoleMapping>> valueDeserializer = JsonpDeserializer.stringMapDeserializer(RoleMapping._DESERIALIZER);
        return JsonpDeserializer.of(
            valueDeserializer.acceptedEvents(),
            (parser, mapper) -> new Builder().body(valueDeserializer.deserialize(parser, mapper)).build()
        );
    }

    // ---------------------------------------------------------------------------------------------

    @Override
    protected void applyQueryParameters(@Nonnull Map<String, String> params) {
        super.applyQueryParameters(params);
        if (this.waitForCompletion != null) {
            params.put("wait_for_completion", String.valueOf(this.waitForCompletion));
        }
    }

    /**
     * Endpoint "{@code security.create_role_mappings}".
     */
    public static final Endpoint<CreateRoleMappingsRequest, CreateRoleMappingsResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "PUT",
        // Request path
        request -> "/_plugins/_security/api/rolesmapping",
        // Request parameters
        request -> {
            Map<String, String> params = new HashMap<>();
            request.applyQueryParameters(params);
            return params;
        },
        SimpleEndpoint.emptyMap(),
        true,
        CreateRoleMappingsResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.body.hashCode();
        result = 31 * result + Objects.hashCode(this.waitForCompletion);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        CreateRoleMappingsRequest other = (CreateRoleMappingsRequest) o;
        return this.body.equals(other.body) && Objects.equals(this.waitForCompletion, other.waitForCompletion);
    }
}
