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

// typedef: ml.get_tool.Request

/**
 * Get tools.
 */
@Generated("software.amazon.opensearch.client.codegen.CodeGenerator")
public final class GetToolRequest extends RequestBase implements ToCopyableBuilder<GetToolRequest.Builder, GetToolRequest> {

    @Nonnull
    private final ToolName toolName;

    // ---------------------------------------------------------------------------------------------

    private GetToolRequest(Builder builder) {
        super(builder);
        this.toolName = ApiTypeHelper.requireNonNull(builder.toolName, this, "toolName");
    }

    public static GetToolRequest of(Function<GetToolRequest.Builder, ObjectBuilder<GetToolRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code tool_name}
     */
    @Nonnull
    public final ToolName toolName() {
        return this.toolName;
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
     * Builder for {@link GetToolRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, GetToolRequest> {
        private ToolName toolName;

        public Builder() {}

        private Builder(GetToolRequest o) {
            super(o);
            this.toolName = o.toolName;
        }

        private Builder(Builder o) {
            super(o);
            this.toolName = o.toolName;
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
         * Required - API name: {@code tool_name}
         */
        @Nonnull
        public final Builder toolName(ToolName value) {
            this.toolName = value;
            return this;
        }

        /**
         * Builds a {@link GetToolRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GetToolRequest build() {
            _checkSingleUse();

            return new GetToolRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code ml.get_tool}".
     */
    public static final Endpoint<GetToolRequest, GetToolResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "GET",
        // Request path
        request -> {
            StringBuilder buf = new StringBuilder();
            buf.append("/_plugins/_ml/tools/");
            SimpleEndpoint.pathEncode(request.toolName.jsonValue(), buf);
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
        GetToolResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.toolName.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GetToolRequest other = (GetToolRequest) o;
        return this.toolName.equals(other.toolName);
    }
}
