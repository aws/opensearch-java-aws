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

package software.amazon.awssdk.opensearch.client.aos.security;

import jakarta.json.stream.JsonGenerator;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import software.amazon.awssdk.opensearch.client.aos._types.RequestBase;
import software.amazon.awssdk.opensearch.client.errors.ErrorResponse;
import software.amazon.awssdk.opensearch.client.json.JsonpDeserializable;
import software.amazon.awssdk.opensearch.client.json.JsonpDeserializer;
import software.amazon.awssdk.opensearch.client.json.JsonpMapper;
import software.amazon.awssdk.opensearch.client.json.ObjectBuilderDeserializer;
import software.amazon.awssdk.opensearch.client.json.ObjectDeserializer;
import software.amazon.awssdk.opensearch.client.json.PlainJsonSerializable;
import software.amazon.awssdk.opensearch.client.transport.Endpoint;
import software.amazon.awssdk.opensearch.client.transport.endpoints.SimpleEndpoint;
import software.amazon.awssdk.opensearch.client.util.ApiTypeHelper;
import software.amazon.awssdk.opensearch.client.util.CopyableBuilder;
import software.amazon.awssdk.opensearch.client.util.ObjectBuilder;
import software.amazon.awssdk.opensearch.client.util.ToCopyableBuilder;

// typedef: security.generate_obo_token.Request

/**
 * Generates a <code>On-Behalf-Of</code> token for the current user.
 */
@JsonpDeserializable
@Generated("software.amazon.awssdk.opensearch.client.codegen.CodeGenerator")
public final class GenerateOboTokenRequest extends RequestBase
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<GenerateOboTokenRequest.Builder, GenerateOboTokenRequest> {

    @Nonnull
    private final String description;

    @Nullable
    private final String duration;

    @Nullable
    private final String service;

    // ---------------------------------------------------------------------------------------------

    private GenerateOboTokenRequest(Builder builder) {
        super(builder);
        this.description = ApiTypeHelper.requireNonNull(builder.description, this, "description");
        this.duration = builder.duration;
        this.service = builder.service;
    }

    public static GenerateOboTokenRequest of(Function<GenerateOboTokenRequest.Builder, ObjectBuilder<GenerateOboTokenRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - The description supplied by the user to describe the token.
     * <p>
     * API name: {@code description}
     * </p>
     */
    @Nonnull
    public final String description() {
        return this.description;
    }

    /**
     * A duration in seconds.
     * <p>
     * API name: {@code duration}
     * </p>
     */
    @Nullable
    public final String duration() {
        return this.duration;
    }

    /**
     * The name of the service when generating a token for that service.
     * <p>
     * API name: {@code service}
     * </p>
     */
    @Nullable
    public final String service() {
        return this.service;
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
        generator.writeKey("description");
        generator.write(this.description);

        if (this.duration != null) {
            generator.writeKey("duration");
            generator.write(this.duration);
        }

        if (this.service != null) {
            generator.writeKey("service");
            generator.write(this.service);
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
     * Builder for {@link GenerateOboTokenRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, GenerateOboTokenRequest> {
        private String description;
        @Nullable
        private String duration;
        @Nullable
        private String service;

        public Builder() {}

        private Builder(GenerateOboTokenRequest o) {
            super(o);
            this.description = o.description;
            this.duration = o.duration;
            this.service = o.service;
        }

        private Builder(Builder o) {
            super(o);
            this.description = o.description;
            this.duration = o.duration;
            this.service = o.service;
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
         * Required - The description supplied by the user to describe the token.
         * <p>
         * API name: {@code description}
         * </p>
         */
        @Nonnull
        public final Builder description(String value) {
            this.description = value;
            return this;
        }

        /**
         * A duration in seconds.
         * <p>
         * API name: {@code duration}
         * </p>
         */
        @Nonnull
        public final Builder duration(@Nullable String value) {
            this.duration = value;
            return this;
        }

        /**
         * The name of the service when generating a token for that service.
         * <p>
         * API name: {@code service}
         * </p>
         */
        @Nonnull
        public final Builder service(@Nullable String value) {
            this.service = value;
            return this;
        }

        /**
         * Builds a {@link GenerateOboTokenRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GenerateOboTokenRequest build() {
            _checkSingleUse();

            return new GenerateOboTokenRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link GenerateOboTokenRequest}
     */
    public static final JsonpDeserializer<GenerateOboTokenRequest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        GenerateOboTokenRequest::setupGenerateOboTokenRequestDeserializer
    );

    protected static void setupGenerateOboTokenRequestDeserializer(ObjectDeserializer<GenerateOboTokenRequest.Builder> op) {
        op.add(Builder::description, JsonpDeserializer.stringDeserializer(), "description");
        op.add(Builder::duration, JsonpDeserializer.stringDeserializer(), "duration");
        op.add(Builder::service, JsonpDeserializer.stringDeserializer(), "service");
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code security.generate_obo_token}".
     */
    public static final Endpoint<GenerateOboTokenRequest, GenerateOboTokenResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "POST",
        // Request path
        request -> "/_plugins/_security/api/generateonbehalfoftoken",
        // Request parameters
        request -> {
            Map<String, String> params = new HashMap<>();
            request.applyQueryParameters(params);
            return params;
        },
        SimpleEndpoint.emptyMap(),
        true,
        GenerateOboTokenResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.description.hashCode();
        result = 31 * result + Objects.hashCode(this.duration);
        result = 31 * result + Objects.hashCode(this.service);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GenerateOboTokenRequest other = (GenerateOboTokenRequest) o;
        return this.description.equals(other.description)
            && Objects.equals(this.duration, other.duration)
            && Objects.equals(this.service, other.service);
    }
}
