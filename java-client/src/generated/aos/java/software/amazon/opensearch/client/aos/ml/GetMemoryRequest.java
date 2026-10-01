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

package software.amazon.opensearch.client.aos.ml;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import software.amazon.opensearch.client.aos._types.RequestBase;
import software.amazon.opensearch.client.errors.ErrorResponse;
import software.amazon.opensearch.client.transport.Endpoint;
import software.amazon.opensearch.client.transport.endpoints.SimpleEndpoint;
import software.amazon.opensearch.client.util.ApiTypeHelper;
import software.amazon.opensearch.client.util.CopyableBuilder;
import software.amazon.opensearch.client.util.ObjectBuilder;
import software.amazon.opensearch.client.util.ToCopyableBuilder;

// typedef: ml.get_memory.Request

/**
 * Get a memory.
 */
@Generated("software.amazon.opensearch.client.codegen.CodeGenerator")
public final class GetMemoryRequest extends RequestBase implements ToCopyableBuilder<GetMemoryRequest.Builder, GetMemoryRequest> {

    @Nonnull
    private final String memoryId;

    // ---------------------------------------------------------------------------------------------

    private GetMemoryRequest(Builder builder) {
        super(builder);
        this.memoryId = ApiTypeHelper.requireNonNull(builder.memoryId, this, "memoryId");
    }

    public static GetMemoryRequest of(Function<GetMemoryRequest.Builder, ObjectBuilder<GetMemoryRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code memory_id}
     */
    @Nonnull
    public final String memoryId() {
        return this.memoryId;
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
     * Builder for {@link GetMemoryRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, GetMemoryRequest> {
        private String memoryId;

        public Builder() {}

        private Builder(GetMemoryRequest o) {
            super(o);
            this.memoryId = o.memoryId;
        }

        private Builder(Builder o) {
            super(o);
            this.memoryId = o.memoryId;
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
         * Required - API name: {@code memory_id}
         */
        @Nonnull
        public final Builder memoryId(String value) {
            this.memoryId = value;
            return this;
        }

        /**
         * Builds a {@link GetMemoryRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GetMemoryRequest build() {
            _checkSingleUse();

            return new GetMemoryRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code ml.get_memory}".
     */
    public static final Endpoint<GetMemoryRequest, GetMemoryResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "GET",
        // Request path
        request -> {
            StringBuilder buf = new StringBuilder();
            buf.append("/_plugins/_ml/memory/");
            SimpleEndpoint.pathEncode(request.memoryId, buf);
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
        GetMemoryResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.memoryId.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GetMemoryRequest other = (GetMemoryRequest) o;
        return this.memoryId.equals(other.memoryId);
    }
}
