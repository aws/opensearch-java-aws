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

import jakarta.json.stream.JsonGenerator;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import software.amazon.opensearch.client.aos._types.RequestBase;
import software.amazon.opensearch.client.aos._types.query_dsl.Query;
import software.amazon.opensearch.client.errors.ErrorResponse;
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

// typedef: ml.delete_agentic_memory_query.Request

/**
 * Delete multiple memories using a query to match specific criteria.
 */
@JsonpDeserializable
@Generated("software.amazon.opensearch.client.codegen.CodeGenerator")
public final class DeleteAgenticMemoryQueryRequest extends RequestBase
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<DeleteAgenticMemoryQueryRequest.Builder, DeleteAgenticMemoryQueryRequest> {

    @Nonnull
    private final String memoryContainerId;

    @Nullable
    private final Query query;

    @Nonnull
    private final MemoryType type;

    // ---------------------------------------------------------------------------------------------

    private DeleteAgenticMemoryQueryRequest(Builder builder) {
        super(builder);
        this.memoryContainerId = ApiTypeHelper.requireNonNull(builder.memoryContainerId, this, "memoryContainerId");
        this.query = builder.query;
        this.type = ApiTypeHelper.requireNonNull(builder.type, this, "type");
    }

    public static DeleteAgenticMemoryQueryRequest of(
        Function<DeleteAgenticMemoryQueryRequest.Builder, ObjectBuilder<DeleteAgenticMemoryQueryRequest>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code memory_container_id}
     */
    @Nonnull
    public final String memoryContainerId() {
        return this.memoryContainerId;
    }

    /**
     * API name: {@code query}
     */
    @Nullable
    public final Query query() {
        return this.query;
    }

    /**
     * Required - API name: {@code type}
     */
    @Nonnull
    public final MemoryType type() {
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
        if (this.query != null) {
            generator.writeKey("query");
            this.query.serialize(generator, mapper);
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
     * Builder for {@link DeleteAgenticMemoryQueryRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, DeleteAgenticMemoryQueryRequest> {
        private String memoryContainerId;
        @Nullable
        private Query query;
        private MemoryType type;

        public Builder() {}

        private Builder(DeleteAgenticMemoryQueryRequest o) {
            super(o);
            this.memoryContainerId = o.memoryContainerId;
            this.query = o.query;
            this.type = o.type;
        }

        private Builder(Builder o) {
            super(o);
            this.memoryContainerId = o.memoryContainerId;
            this.query = o.query;
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
         * Required - API name: {@code memory_container_id}
         */
        @Nonnull
        public final Builder memoryContainerId(String value) {
            this.memoryContainerId = value;
            return this;
        }

        /**
         * API name: {@code query}
         */
        @Nonnull
        public final Builder query(@Nullable Query value) {
            this.query = value;
            return this;
        }

        /**
         * API name: {@code query}
         */
        @Nonnull
        public final Builder query(Function<Query.Builder, ObjectBuilder<Query>> fn) {
            return query(fn.apply(new Query.Builder()).build());
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
         * Builds a {@link DeleteAgenticMemoryQueryRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public DeleteAgenticMemoryQueryRequest build() {
            _checkSingleUse();

            return new DeleteAgenticMemoryQueryRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link DeleteAgenticMemoryQueryRequest}
     */
    public static final JsonpDeserializer<DeleteAgenticMemoryQueryRequest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        DeleteAgenticMemoryQueryRequest::setupDeleteAgenticMemoryQueryRequestDeserializer
    );

    protected static void setupDeleteAgenticMemoryQueryRequestDeserializer(ObjectDeserializer<DeleteAgenticMemoryQueryRequest.Builder> op) {
        op.add(Builder::query, Query._DESERIALIZER, "query");
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code ml.delete_agentic_memory_query}".
     */
    public static final Endpoint<DeleteAgenticMemoryQueryRequest, DeleteAgenticMemoryQueryResponse, ErrorResponse> _ENDPOINT =
        new SimpleEndpoint<>(
            // Request method
            request -> "POST",
            // Request path
            request -> {
                StringBuilder buf = new StringBuilder();
                buf.append("/_plugins/_ml/memory_containers/");
                SimpleEndpoint.pathEncode(request.memoryContainerId, buf);
                buf.append("/memories/");
                SimpleEndpoint.pathEncode(request.type.jsonValue(), buf);
                buf.append("/_delete_by_query");
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
            DeleteAgenticMemoryQueryResponse._DESERIALIZER
        );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.memoryContainerId.hashCode();
        result = 31 * result + Objects.hashCode(this.query);
        result = 31 * result + this.type.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        DeleteAgenticMemoryQueryRequest other = (DeleteAgenticMemoryQueryRequest) o;
        return this.memoryContainerId.equals(other.memoryContainerId)
            && Objects.equals(this.query, other.query)
            && this.type.equals(other.type);
    }
}
