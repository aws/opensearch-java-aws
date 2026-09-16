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

package software.amazon.awssdk.opensearch.client.aoss.ml;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import software.amazon.awssdk.opensearch.client.aoss._types.RequestBase;
import software.amazon.awssdk.opensearch.client.errors.ErrorResponse;
import software.amazon.awssdk.opensearch.client.transport.Endpoint;
import software.amazon.awssdk.opensearch.client.transport.endpoints.SimpleEndpoint;
import software.amazon.awssdk.opensearch.client.util.ApiTypeHelper;
import software.amazon.awssdk.opensearch.client.util.CopyableBuilder;
import software.amazon.awssdk.opensearch.client.util.ObjectBuilder;
import software.amazon.awssdk.opensearch.client.util.ToCopyableBuilder;

// typedef: ml.delete_connector.Request

/**
 * Deletes a standalone connector.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class DeleteConnectorRequest extends RequestBase
    implements
        ToCopyableBuilder<DeleteConnectorRequest.Builder, DeleteConnectorRequest> {

    @Nonnull
    private final String connectorId;

    // ---------------------------------------------------------------------------------------------

    private DeleteConnectorRequest(Builder builder) {
        super(builder);
        this.connectorId = ApiTypeHelper.requireNonNull(builder.connectorId, this, "connectorId");
    }

    public static DeleteConnectorRequest of(Function<DeleteConnectorRequest.Builder, ObjectBuilder<DeleteConnectorRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code connector_id}
     */
    @Nonnull
    public final String connectorId() {
        return this.connectorId;
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
     * Builder for {@link DeleteConnectorRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, DeleteConnectorRequest> {
        private String connectorId;

        public Builder() {}

        private Builder(DeleteConnectorRequest o) {
            super(o);
            this.connectorId = o.connectorId;
        }

        private Builder(Builder o) {
            super(o);
            this.connectorId = o.connectorId;
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
         * Required - API name: {@code connector_id}
         */
        @Nonnull
        public final Builder connectorId(String value) {
            this.connectorId = value;
            return this;
        }

        /**
         * Builds a {@link DeleteConnectorRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public DeleteConnectorRequest build() {
            _checkSingleUse();

            return new DeleteConnectorRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code ml.delete_connector}".
     */
    public static final Endpoint<DeleteConnectorRequest, DeleteConnectorResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "DELETE",
        // Request path
        request -> {
            StringBuilder buf = new StringBuilder();
            buf.append("/_plugins/_ml/connectors/");
            SimpleEndpoint.pathEncode(request.connectorId, buf);
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
        DeleteConnectorResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.connectorId.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        DeleteConnectorRequest other = (DeleteConnectorRequest) o;
        return this.connectorId.equals(other.connectorId);
    }
}
