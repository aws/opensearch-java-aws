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
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import software.amazon.opensearch.client.aos._types.RequestBase;
import software.amazon.opensearch.client.errors.ErrorResponse;
import software.amazon.opensearch.client.transport.Endpoint;
import software.amazon.opensearch.client.transport.endpoints.SimpleEndpoint;
import software.amazon.opensearch.client.util.ApiTypeHelper;
import software.amazon.opensearch.client.util.CopyableBuilder;
import software.amazon.opensearch.client.util.ObjectBuilder;
import software.amazon.opensearch.client.util.ToCopyableBuilder;

// typedef: ml.get_message_traces.Request

/**
 * Get a message traces.
 */
@Generated("software.amazon.opensearch.client.codegen.CodeGenerator")
public final class GetMessageTracesRequest extends RequestBase
    implements
        ToCopyableBuilder<GetMessageTracesRequest.Builder, GetMessageTracesRequest> {

    @Nullable
    private final Integer maxResults;

    @Nonnull
    private final String messageId;

    @Nullable
    private final Integer nextToken;

    // ---------------------------------------------------------------------------------------------

    private GetMessageTracesRequest(Builder builder) {
        super(builder);
        this.maxResults = builder.maxResults;
        this.messageId = ApiTypeHelper.requireNonNull(builder.messageId, this, "messageId");
        this.nextToken = builder.nextToken;
    }

    public static GetMessageTracesRequest of(Function<GetMessageTracesRequest.Builder, ObjectBuilder<GetMessageTracesRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code max_results}
     */
    @Nullable
    public final Integer maxResults() {
        return this.maxResults;
    }

    /**
     * Required - API name: {@code message_id}
     */
    @Nonnull
    public final String messageId() {
        return this.messageId;
    }

    /**
     * API name: {@code next_token}
     */
    @Nullable
    public final Integer nextToken() {
        return this.nextToken;
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
     * Builder for {@link GetMessageTracesRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, GetMessageTracesRequest> {
        @Nullable
        private Integer maxResults;
        private String messageId;
        @Nullable
        private Integer nextToken;

        public Builder() {}

        private Builder(GetMessageTracesRequest o) {
            super(o);
            this.maxResults = o.maxResults;
            this.messageId = o.messageId;
            this.nextToken = o.nextToken;
        }

        private Builder(Builder o) {
            super(o);
            this.maxResults = o.maxResults;
            this.messageId = o.messageId;
            this.nextToken = o.nextToken;
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
         * API name: {@code max_results}
         */
        @Nonnull
        public final Builder maxResults(@Nullable Integer value) {
            this.maxResults = value;
            return this;
        }

        /**
         * Required - API name: {@code message_id}
         */
        @Nonnull
        public final Builder messageId(String value) {
            this.messageId = value;
            return this;
        }

        /**
         * API name: {@code next_token}
         */
        @Nonnull
        public final Builder nextToken(@Nullable Integer value) {
            this.nextToken = value;
            return this;
        }

        /**
         * Builds a {@link GetMessageTracesRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GetMessageTracesRequest build() {
            _checkSingleUse();

            return new GetMessageTracesRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    @Override
    protected void applyQueryParameters(@Nonnull Map<String, String> params) {
        super.applyQueryParameters(params);
        if (this.maxResults != null) {
            params.put("max_results", String.valueOf(this.maxResults));
        }
        if (this.nextToken != null) {
            params.put("next_token", String.valueOf(this.nextToken));
        }
    }

    /**
     * Endpoint "{@code ml.get_message_traces}".
     */
    public static final Endpoint<GetMessageTracesRequest, GetMessageTracesResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "GET",
        // Request path
        request -> {
            StringBuilder buf = new StringBuilder();
            buf.append("/_plugins/_ml/memory/message/");
            SimpleEndpoint.pathEncode(request.messageId, buf);
            buf.append("/traces");
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
        GetMessageTracesResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.maxResults);
        result = 31 * result + this.messageId.hashCode();
        result = 31 * result + Objects.hashCode(this.nextToken);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GetMessageTracesRequest other = (GetMessageTracesRequest) o;
        return Objects.equals(this.maxResults, other.maxResults)
            && this.messageId.equals(other.messageId)
            && Objects.equals(this.nextToken, other.nextToken);
    }
}
