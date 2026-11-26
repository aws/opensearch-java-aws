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

package software.amazon.opensearch.client.aos.search_relevance;

import jakarta.json.stream.JsonGenerator;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import software.amazon.opensearch.client.aos._types.RequestBase;
import software.amazon.opensearch.client.errors.ErrorResponse;
import software.amazon.opensearch.client.json.JsonData;
import software.amazon.opensearch.client.json.JsonpDeserializable;
import software.amazon.opensearch.client.json.JsonpDeserializer;
import software.amazon.opensearch.client.json.JsonpMapper;
import software.amazon.opensearch.client.json.ObjectBuilderDeserializer;
import software.amazon.opensearch.client.json.ObjectDeserializer;
import software.amazon.opensearch.client.json.PlainJsonSerializable;
import software.amazon.opensearch.client.transport.Endpoint;
import software.amazon.opensearch.client.transport.endpoints.SimpleEndpoint;
import software.amazon.opensearch.client.util.ApiTypeHelper;
import software.amazon.opensearch.client.util.CopyableBuilder;
import software.amazon.opensearch.client.util.ObjectBuilder;
import software.amazon.opensearch.client.util.ToCopyableBuilder;

// typedef: search_relevance.put_experiments.Request

/**
 * Creates an experiment.
 */
@JsonpDeserializable
@Generated("software.amazon.opensearch.client.codegen.CodeGenerator")
public final class PutExperimentsRequest extends RequestBase
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<PutExperimentsRequest.Builder, PutExperimentsRequest> {

    @Nullable
    private final JsonData judgmentList;

    @Nonnull
    private final String querySetId;

    @Nonnull
    private final JsonData searchConfigurationList;

    private final int size;

    @Nonnull
    private final String type;

    // ---------------------------------------------------------------------------------------------

    private PutExperimentsRequest(Builder builder) {
        super(builder);
        this.judgmentList = builder.judgmentList;
        this.querySetId = ApiTypeHelper.requireNonNull(builder.querySetId, this, "querySetId");
        this.searchConfigurationList = ApiTypeHelper.requireNonNull(builder.searchConfigurationList, this, "searchConfigurationList");
        this.size = ApiTypeHelper.requireNonNull(builder.size, this, "size");
        this.type = ApiTypeHelper.requireNonNull(builder.type, this, "type");
    }

    public static PutExperimentsRequest of(Function<PutExperimentsRequest.Builder, ObjectBuilder<PutExperimentsRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code judgmentList}
     */
    @Nullable
    public final JsonData judgmentList() {
        return this.judgmentList;
    }

    /**
     * Required - API name: {@code querySetId}
     */
    @Nonnull
    public final String querySetId() {
        return this.querySetId;
    }

    /**
     * Required - API name: {@code searchConfigurationList}
     */
    @Nonnull
    public final JsonData searchConfigurationList() {
        return this.searchConfigurationList;
    }

    /**
     * Required - API name: {@code size}
     */
    public final int size() {
        return this.size;
    }

    /**
     * Required - API name: {@code type}
     */
    @Nonnull
    public final String type() {
        return this.type;
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
        if (this.judgmentList != null) {
            generator.writeKey("judgmentList");
            this.judgmentList.serialize(generator, mapper);
        }

        generator.writeKey("querySetId");
        generator.write(this.querySetId);

        generator.writeKey("searchConfigurationList");
        this.searchConfigurationList.serialize(generator, mapper);

        generator.writeKey("size");
        generator.write(this.size);

        generator.writeKey("type");
        generator.write(this.type);
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
     * Builder for {@link PutExperimentsRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, PutExperimentsRequest> {
        @Nullable
        private JsonData judgmentList;
        private String querySetId;
        private JsonData searchConfigurationList;
        private Integer size;
        private String type;

        public Builder() {}

        private Builder(PutExperimentsRequest o) {
            super(o);
            this.judgmentList = o.judgmentList;
            this.querySetId = o.querySetId;
            this.searchConfigurationList = o.searchConfigurationList;
            this.size = o.size;
            this.type = o.type;
        }

        private Builder(Builder o) {
            super(o);
            this.judgmentList = o.judgmentList;
            this.querySetId = o.querySetId;
            this.searchConfigurationList = o.searchConfigurationList;
            this.size = o.size;
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
         * API name: {@code judgmentList}
         */
        @Nonnull
        public final Builder judgmentList(@Nullable JsonData value) {
            this.judgmentList = value;
            return this;
        }

        /**
         * Required - API name: {@code querySetId}
         */
        @Nonnull
        public final Builder querySetId(String value) {
            this.querySetId = value;
            return this;
        }

        /**
         * Required - API name: {@code searchConfigurationList}
         */
        @Nonnull
        public final Builder searchConfigurationList(JsonData value) {
            this.searchConfigurationList = value;
            return this;
        }

        /**
         * Required - API name: {@code size}
         */
        @Nonnull
        public final Builder size(int value) {
            this.size = value;
            return this;
        }

        /**
         * Required - API name: {@code type}
         */
        @Nonnull
        public final Builder type(String value) {
            this.type = value;
            return this;
        }

        /**
         * Builds a {@link PutExperimentsRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public PutExperimentsRequest build() {
            _checkSingleUse();

            return new PutExperimentsRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link PutExperimentsRequest}
     */
    public static final JsonpDeserializer<PutExperimentsRequest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        PutExperimentsRequest::setupPutExperimentsRequestDeserializer
    );

    protected static void setupPutExperimentsRequestDeserializer(ObjectDeserializer<PutExperimentsRequest.Builder> op) {
        op.add(Builder::judgmentList, JsonData._DESERIALIZER, "judgmentList");
        op.add(Builder::querySetId, JsonpDeserializer.stringDeserializer(), "querySetId");
        op.add(Builder::searchConfigurationList, JsonData._DESERIALIZER, "searchConfigurationList");
        op.add(Builder::size, JsonpDeserializer.integerDeserializer(), "size");
        op.add(Builder::type, JsonpDeserializer.stringDeserializer(), "type");
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code search_relevance.put_experiments}".
     */
    public static final Endpoint<PutExperimentsRequest, PutExperimentsResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "PUT",
        // Request path
        request -> "/_plugins/_search_relevance/experiments",
        // Request parameters
        request -> {
            Map<String, String> params = new HashMap<>();
            request.applyQueryParameters(params);
            return params;
        },
        SimpleEndpoint.emptyMap(),
        true,
        PutExperimentsResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.judgmentList);
        result = 31 * result + this.querySetId.hashCode();
        result = 31 * result + this.searchConfigurationList.hashCode();
        result = 31 * result + Integer.hashCode(this.size);
        result = 31 * result + this.type.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        PutExperimentsRequest other = (PutExperimentsRequest) o;
        return Objects.equals(this.judgmentList, other.judgmentList)
            && this.querySetId.equals(other.querySetId)
            && this.searchConfigurationList.equals(other.searchConfigurationList)
            && this.size == other.size
            && this.type.equals(other.type);
    }
}
