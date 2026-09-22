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

package software.amazon.awssdk.opensearch.client.aos.ml;

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

// typedef: ml.update_memory_container.Request

/**
 * Update a memory container.
 */
@JsonpDeserializable
@Generated("software.amazon.awssdk.opensearch.client.codegen.CodeGenerator")
public final class UpdateMemoryContainerRequest extends RequestBase
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<UpdateMemoryContainerRequest.Builder, UpdateMemoryContainerRequest> {

    @Nullable
    private final MemoryContainerConfiguration configuration;

    @Nullable
    private final String description;

    @Nonnull
    private final String memoryContainerId;

    @Nullable
    private final String name;

    // ---------------------------------------------------------------------------------------------

    private UpdateMemoryContainerRequest(Builder builder) {
        super(builder);
        this.configuration = builder.configuration;
        this.description = builder.description;
        this.memoryContainerId = ApiTypeHelper.requireNonNull(builder.memoryContainerId, this, "memoryContainerId");
        this.name = builder.name;
    }

    public static UpdateMemoryContainerRequest of(
        Function<UpdateMemoryContainerRequest.Builder, ObjectBuilder<UpdateMemoryContainerRequest>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code configuration}
     */
    @Nullable
    public final MemoryContainerConfiguration configuration() {
        return this.configuration;
    }

    /**
     * API name: {@code description}
     */
    @Nullable
    public final String description() {
        return this.description;
    }

    /**
     * Required - API name: {@code memory_container_id}
     */
    @Nonnull
    public final String memoryContainerId() {
        return this.memoryContainerId;
    }

    /**
     * API name: {@code name}
     */
    @Nullable
    public final String name() {
        return this.name;
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
        if (this.configuration != null) {
            generator.writeKey("configuration");
            this.configuration.serialize(generator, mapper);
        }

        if (this.description != null) {
            generator.writeKey("description");
            generator.write(this.description);
        }

        if (this.name != null) {
            generator.writeKey("name");
            generator.write(this.name);
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
     * Builder for {@link UpdateMemoryContainerRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, UpdateMemoryContainerRequest> {
        @Nullable
        private MemoryContainerConfiguration configuration;
        @Nullable
        private String description;
        private String memoryContainerId;
        @Nullable
        private String name;

        public Builder() {}

        private Builder(UpdateMemoryContainerRequest o) {
            super(o);
            this.configuration = o.configuration;
            this.description = o.description;
            this.memoryContainerId = o.memoryContainerId;
            this.name = o.name;
        }

        private Builder(Builder o) {
            super(o);
            this.configuration = o.configuration;
            this.description = o.description;
            this.memoryContainerId = o.memoryContainerId;
            this.name = o.name;
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
         * API name: {@code configuration}
         */
        @Nonnull
        public final Builder configuration(@Nullable MemoryContainerConfiguration value) {
            this.configuration = value;
            return this;
        }

        /**
         * API name: {@code configuration}
         */
        @Nonnull
        public final Builder configuration(Function<MemoryContainerConfiguration.Builder, ObjectBuilder<MemoryContainerConfiguration>> fn) {
            return configuration(fn.apply(new MemoryContainerConfiguration.Builder()).build());
        }

        /**
         * API name: {@code description}
         */
        @Nonnull
        public final Builder description(@Nullable String value) {
            this.description = value;
            return this;
        }

        /**
         * Required - API name: {@code memory_container_id}
         */
        @Nonnull
        public final Builder memoryContainerId(String value) {
            this.memoryContainerId = value;
            return this;
        }

        /**
         * API name: {@code name}
         */
        @Nonnull
        public final Builder name(@Nullable String value) {
            this.name = value;
            return this;
        }

        /**
         * Builds a {@link UpdateMemoryContainerRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public UpdateMemoryContainerRequest build() {
            _checkSingleUse();

            return new UpdateMemoryContainerRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link UpdateMemoryContainerRequest}
     */
    public static final JsonpDeserializer<UpdateMemoryContainerRequest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        UpdateMemoryContainerRequest::setupUpdateMemoryContainerRequestDeserializer
    );

    protected static void setupUpdateMemoryContainerRequestDeserializer(ObjectDeserializer<UpdateMemoryContainerRequest.Builder> op) {
        op.add(Builder::configuration, MemoryContainerConfiguration._DESERIALIZER, "configuration");
        op.add(Builder::description, JsonpDeserializer.stringDeserializer(), "description");
        op.add(Builder::name, JsonpDeserializer.stringDeserializer(), "name");
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code ml.update_memory_container}".
     */
    public static final Endpoint<UpdateMemoryContainerRequest, UpdateMemoryContainerResponse, ErrorResponse> _ENDPOINT =
        new SimpleEndpoint<>(
            // Request method
            request -> "PUT",
            // Request path
            request -> {
                StringBuilder buf = new StringBuilder();
                buf.append("/_plugins/_ml/memory_containers/");
                SimpleEndpoint.pathEncode(request.memoryContainerId, buf);
                return buf.toString();
            },
            // Request parameters
            request -> {
                Map<String, String> params = new HashMap<>();
                request.applyQueryParameters(params);
                return params;
            },
            SimpleEndpoint.emptyMap(),
            true,
            UpdateMemoryContainerResponse._DESERIALIZER
        );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.configuration);
        result = 31 * result + Objects.hashCode(this.description);
        result = 31 * result + this.memoryContainerId.hashCode();
        result = 31 * result + Objects.hashCode(this.name);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        UpdateMemoryContainerRequest other = (UpdateMemoryContainerRequest) o;
        return Objects.equals(this.configuration, other.configuration)
            && Objects.equals(this.description, other.description)
            && this.memoryContainerId.equals(other.memoryContainerId)
            && Objects.equals(this.name, other.name);
    }
}
