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

package software.amazon.awssdk.opensearch.client.aos.ultrawarm;

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

// typedef: ultrawarm.to_cold.Request

/**
 * Migrate a warm index to cold storage. Requires start_time and end_time query parameters bounding the index's data.
 */
@Generated("software.amazon.awssdk.opensearch.client.codegen.CodeGenerator")
public final class ToColdRequest extends RequestBase implements ToCopyableBuilder<ToColdRequest.Builder, ToColdRequest> {

    @Nonnull
    private final String endTime;

    @Nonnull
    private final String index;

    @Nonnull
    private final String startTime;

    // ---------------------------------------------------------------------------------------------

    private ToColdRequest(Builder builder) {
        super(builder);
        this.endTime = ApiTypeHelper.requireNonNull(builder.endTime, this, "endTime");
        this.index = ApiTypeHelper.requireNonNull(builder.index, this, "index");
        this.startTime = ApiTypeHelper.requireNonNull(builder.startTime, this, "startTime");
    }

    public static ToColdRequest of(Function<ToColdRequest.Builder, ObjectBuilder<ToColdRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code end_time}
     */
    @Nonnull
    public final String endTime() {
        return this.endTime;
    }

    /**
     * Required - API name: {@code index}
     */
    @Nonnull
    public final String index() {
        return this.index;
    }

    /**
     * Required - API name: {@code start_time}
     */
    @Nonnull
    public final String startTime() {
        return this.startTime;
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
     * Builder for {@link ToColdRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, ToColdRequest> {
        private String endTime;
        private String index;
        private String startTime;

        public Builder() {}

        private Builder(ToColdRequest o) {
            super(o);
            this.endTime = o.endTime;
            this.index = o.index;
            this.startTime = o.startTime;
        }

        private Builder(Builder o) {
            super(o);
            this.endTime = o.endTime;
            this.index = o.index;
            this.startTime = o.startTime;
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
         * Required - API name: {@code end_time}
         */
        @Nonnull
        public final Builder endTime(String value) {
            this.endTime = value;
            return this;
        }

        /**
         * Required - API name: {@code index}
         */
        @Nonnull
        public final Builder index(String value) {
            this.index = value;
            return this;
        }

        /**
         * Required - API name: {@code start_time}
         */
        @Nonnull
        public final Builder startTime(String value) {
            this.startTime = value;
            return this;
        }

        /**
         * Builds a {@link ToColdRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ToColdRequest build() {
            _checkSingleUse();

            return new ToColdRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    @Override
    protected void applyQueryParameters(@Nonnull Map<String, String> params) {
        super.applyQueryParameters(params);
        params.put("end_time", this.endTime);
        params.put("start_time", this.startTime);
    }

    /**
     * Endpoint "{@code ultrawarm.to_cold}".
     */
    public static final Endpoint<ToColdRequest, ToColdResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "POST",
        // Request path
        request -> {
            StringBuilder buf = new StringBuilder();
            buf.append("/_ultrawarm/migration/");
            SimpleEndpoint.pathEncode(request.index, buf);
            buf.append("/_cold");
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
        ToColdResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.endTime.hashCode();
        result = 31 * result + this.index.hashCode();
        result = 31 * result + this.startTime.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ToColdRequest other = (ToColdRequest) o;
        return this.endTime.equals(other.endTime) && this.index.equals(other.index) && this.startTime.equals(other.startTime);
    }
}
