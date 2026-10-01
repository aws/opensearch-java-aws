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

package software.amazon.opensearch.client.aos.ultrawarm;

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
import software.amazon.opensearch.client.util.CopyableBuilder;
import software.amazon.opensearch.client.util.ObjectBuilder;
import software.amazon.opensearch.client.util.ToCopyableBuilder;

// typedef: ultrawarm.list_status.Request

/**
 * List all in-progress UltraWarm migrations.
 */
@Generated("software.amazon.opensearch.client.codegen.CodeGenerator")
public final class ListStatusRequest extends RequestBase implements ToCopyableBuilder<ListStatusRequest.Builder, ListStatusRequest> {

    @Nullable
    private final String format;

    @Nullable
    private final Boolean v;

    // ---------------------------------------------------------------------------------------------

    private ListStatusRequest(Builder builder) {
        super(builder);
        this.format = builder.format;
        this.v = builder.v;
    }

    public static ListStatusRequest of(Function<ListStatusRequest.Builder, ObjectBuilder<ListStatusRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Response format, e.g. json.
     * <p>
     * API name: {@code format}
     * </p>
     */
    @Nullable
    public final String format() {
        return this.format;
    }

    /**
     * Include column headers in the text response.
     * <p>
     * API name: {@code v}
     * </p>
     */
    @Nullable
    public final Boolean v() {
        return this.v;
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
     * Builder for {@link ListStatusRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, ListStatusRequest> {
        @Nullable
        private String format;
        @Nullable
        private Boolean v;

        public Builder() {}

        private Builder(ListStatusRequest o) {
            super(o);
            this.format = o.format;
            this.v = o.v;
        }

        private Builder(Builder o) {
            super(o);
            this.format = o.format;
            this.v = o.v;
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
         * Response format, e.g. json.
         * <p>
         * API name: {@code format}
         * </p>
         */
        @Nonnull
        public final Builder format(@Nullable String value) {
            this.format = value;
            return this;
        }

        /**
         * Include column headers in the text response.
         * <p>
         * API name: {@code v}
         * </p>
         */
        @Nonnull
        public final Builder v(@Nullable Boolean value) {
            this.v = value;
            return this;
        }

        /**
         * Builds a {@link ListStatusRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ListStatusRequest build() {
            _checkSingleUse();

            return new ListStatusRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    @Override
    protected void applyQueryParameters(@Nonnull Map<String, String> params) {
        super.applyQueryParameters(params);
        if (this.format != null) {
            params.put("format", this.format);
        }
        if (this.v != null) {
            params.put("v", String.valueOf(this.v));
        }
    }

    /**
     * Endpoint "{@code ultrawarm.list_status}".
     */
    public static final Endpoint<ListStatusRequest, ListStatusResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "GET",
        // Request path
        request -> "/_ultrawarm/migration/_status",
        // Request parameters
        request -> {
            Map<String, String> params = new HashMap<>();
            request.applyQueryParameters(params);
            return params;
        },
        SimpleEndpoint.emptyMap(),
        false,
        ListStatusResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.format);
        result = 31 * result + Objects.hashCode(this.v);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ListStatusRequest other = (ListStatusRequest) o;
        return Objects.equals(this.format, other.format) && Objects.equals(this.v, other.v);
    }
}
