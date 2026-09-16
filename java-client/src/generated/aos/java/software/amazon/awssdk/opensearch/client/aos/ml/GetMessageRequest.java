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

// typedef: ml.get_message.Request

/**
 * <p>
 * Get a message.
 * </p>
 * <p>
 * <strong>Minimum version:</strong> <code>2.12</code>
 * </p>
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class GetMessageRequest extends RequestBase implements ToCopyableBuilder<GetMessageRequest.Builder, GetMessageRequest> {

    @Nonnull
    private final String messageId;

    // ---------------------------------------------------------------------------------------------

    private GetMessageRequest(Builder builder) {
        super(builder);
        this.messageId = ApiTypeHelper.requireNonNull(builder.messageId, this, "messageId");
    }

    public static GetMessageRequest of(Function<GetMessageRequest.Builder, ObjectBuilder<GetMessageRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code message_id}
     */
    @Nonnull
    public final String messageId() {
        return this.messageId;
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
     * Builder for {@link GetMessageRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, GetMessageRequest> {
        private String messageId;

        public Builder() {}

        private Builder(GetMessageRequest o) {
            super(o);
            this.messageId = o.messageId;
        }

        private Builder(Builder o) {
            super(o);
            this.messageId = o.messageId;
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
         * Required - API name: {@code message_id}
         */
        @Nonnull
        public final Builder messageId(String value) {
            this.messageId = value;
            return this;
        }

        /**
         * Builds a {@link GetMessageRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GetMessageRequest build() {
            _checkSingleUse();

            return new GetMessageRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code ml.get_message}".
     */
    public static final Endpoint<GetMessageRequest, GetMessageResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "GET",
        // Request path
        request -> {
            StringBuilder buf = new StringBuilder();
            buf.append("/_plugins/_ml/memory/message/");
            SimpleEndpoint.pathEncode(request.messageId, buf);
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
        GetMessageResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.messageId.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GetMessageRequest other = (GetMessageRequest) o;
        return this.messageId.equals(other.messageId);
    }
}
