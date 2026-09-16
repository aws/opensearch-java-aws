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

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import software.amazon.awssdk.opensearch.client.aos._types.RequestBase;
import software.amazon.awssdk.opensearch.client.errors.ErrorResponse;
import software.amazon.awssdk.opensearch.client.transport.Endpoint;
import software.amazon.awssdk.opensearch.client.transport.endpoints.SimpleEndpoint;
import software.amazon.awssdk.opensearch.client.util.ApiTypeHelper;
import software.amazon.awssdk.opensearch.client.util.CopyableBuilder;
import software.amazon.awssdk.opensearch.client.util.ObjectBuilder;
import software.amazon.awssdk.opensearch.client.util.ToCopyableBuilder;

// typedef: ml.get_agentic_memory.Request

/**
 * <p>
 * Get a specific memory by its type and ID.
 * </p>
 * <p>
 * <strong>Minimum version:</strong> <code>3.3</code>
 * </p>
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class GetAgenticMemoryRequest extends RequestBase
    implements
        ToCopyableBuilder<GetAgenticMemoryRequest.Builder, GetAgenticMemoryRequest> {

    @Nonnull
    private final String id;

    @Nonnull
    private final String memoryContainerId;

    @Nonnull
    private final MemoryType type;

    // ---------------------------------------------------------------------------------------------

    private GetAgenticMemoryRequest(Builder builder) {
        super(builder);
        this.id = ApiTypeHelper.requireNonNull(builder.id, this, "id");
        this.memoryContainerId = ApiTypeHelper.requireNonNull(builder.memoryContainerId, this, "memoryContainerId");
        this.type = ApiTypeHelper.requireNonNull(builder.type, this, "type");
    }

    public static GetAgenticMemoryRequest of(Function<GetAgenticMemoryRequest.Builder, ObjectBuilder<GetAgenticMemoryRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code id}
     */
    @Nonnull
    public final String id() {
        return this.id;
    }

    /**
     * Required - API name: {@code memory_container_id}
     */
    @Nonnull
    public final String memoryContainerId() {
        return this.memoryContainerId;
    }

    /**
     * Required - API name: {@code type}
     */
    @Nonnull
    public final MemoryType type() {
        return this.type;
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
     * Builder for {@link GetAgenticMemoryRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, GetAgenticMemoryRequest> {
        private String id;
        private String memoryContainerId;
        private MemoryType type;

        public Builder() {}

        private Builder(GetAgenticMemoryRequest o) {
            super(o);
            this.id = o.id;
            this.memoryContainerId = o.memoryContainerId;
            this.type = o.type;
        }

        private Builder(Builder o) {
            super(o);
            this.id = o.id;
            this.memoryContainerId = o.memoryContainerId;
            this.type = o.type;
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
         * Required - API name: {@code id}
         */
        @Nonnull
        public final Builder id(String value) {
            this.id = value;
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
         * Required - API name: {@code type}
         */
        @Nonnull
        public final Builder type(MemoryType value) {
            this.type = value;
            return this;
        }

        /**
         * Builds a {@link GetAgenticMemoryRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GetAgenticMemoryRequest build() {
            _checkSingleUse();

            return new GetAgenticMemoryRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code ml.get_agentic_memory}".
     */
    public static final Endpoint<GetAgenticMemoryRequest, GetAgenticMemoryResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "GET",
        // Request path
        request -> {
            StringBuilder buf = new StringBuilder();
            buf.append("/_plugins/_ml/memory_containers/");
            SimpleEndpoint.pathEncode(request.memoryContainerId, buf);
            buf.append("/memories/");
            SimpleEndpoint.pathEncode(request.type.jsonValue(), buf);
            buf.append("/");
            SimpleEndpoint.pathEncode(request.id, buf);
            return buf.toString();
        },
        // Request parameters
        request -> {
            Map<String, String> params = new HashMap<>();
            request.applyQueryParameters(params);
            return params;
        },
        SimpleEndpoint.emptyMap(),
        false,
        GetAgenticMemoryResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.id.hashCode();
        result = 31 * result + this.memoryContainerId.hashCode();
        result = 31 * result + this.type.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GetAgenticMemoryRequest other = (GetAgenticMemoryRequest) o;
        return this.id.equals(other.id) && this.memoryContainerId.equals(other.memoryContainerId) && this.type.equals(other.type);
    }
}
