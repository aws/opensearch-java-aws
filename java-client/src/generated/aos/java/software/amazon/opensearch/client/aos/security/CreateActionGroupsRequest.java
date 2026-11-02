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
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
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

// typedef: security.create_action_groups.Request

/**
 * Creates or replaces multiple action groups. Action groups omitted from the request are unchanged. All entries are validated before any
 * changes are written.
 */
@JsonpDeserializable
@Generated("software.amazon.opensearch.client.codegen.CodeGenerator")
public final class CreateActionGroupsRequest extends RequestBase
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<CreateActionGroupsRequest.Builder, CreateActionGroupsRequest> {

    @Nonnull
    private final Map<String, ActionGroup> body;

    // ---------------------------------------------------------------------------------------------

    private CreateActionGroupsRequest(Builder builder) {
        super(builder);
        this.body = ApiTypeHelper.unmodifiableRequired(builder.body, this, "body");
    }

    public static CreateActionGroupsRequest of(Function<CreateActionGroupsRequest.Builder, ObjectBuilder<CreateActionGroupsRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - Request body.
     */
    @Nonnull
    public final Map<String, ActionGroup> body() {
        return this.body;
    }

    /**
     * Serialize this value to JSON.
     */
    @Override
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
        for (Map.Entry<String, ActionGroup> item0 : this.body.entrySet()) {
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
     * Builder for {@link CreateActionGroupsRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, CreateActionGroupsRequest> {
        private Map<String, ActionGroup> body;

        public Builder() {}

        private Builder(CreateActionGroupsRequest o) {
            super(o);
            this.body = _mapCopy(o.body);
        }

        private Builder(Builder o) {
            super(o);
            this.body = _mapCopy(o.body);
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
        public final Builder body(Map<String, ActionGroup> map) {
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
        public final Builder body(String key, ActionGroup value) {
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
        public final Builder body(String key, Function<ActionGroup.Builder, ObjectBuilder<ActionGroup>> fn) {
            return body(key, fn.apply(new ActionGroup.Builder()).build());
        }

        /**
         * Builds a {@link CreateActionGroupsRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public CreateActionGroupsRequest build() {
            _checkSingleUse();

            return new CreateActionGroupsRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    public static final JsonpDeserializer<CreateActionGroupsRequest> _DESERIALIZER = createCreateActionGroupsRequestDeserializer();

    protected static JsonpDeserializer<CreateActionGroupsRequest> createCreateActionGroupsRequestDeserializer() {
        JsonpDeserializer<Map<String, ActionGroup>> valueDeserializer = JsonpDeserializer.stringMapDeserializer(ActionGroup._DESERIALIZER);
        return JsonpDeserializer.of(
            valueDeserializer.acceptedEvents(),
            (parser, mapper) -> new Builder().body(valueDeserializer.deserialize(parser, mapper)).build()
        );
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code security.create_action_groups}".
     */
    public static final Endpoint<CreateActionGroupsRequest, CreateActionGroupsResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "PUT",
        // Request path
        request -> "/_plugins/_security/api/actiongroups",
        // Request parameters
        request -> {
            Map<String, String> params = new HashMap<>();
            request.applyQueryParameters(params);
            return params;
        },
        SimpleEndpoint.emptyMap(),
        true,
        CreateActionGroupsResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.body.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        CreateActionGroupsRequest other = (CreateActionGroupsRequest) o;
        return this.body.equals(other.body);
    }
}
