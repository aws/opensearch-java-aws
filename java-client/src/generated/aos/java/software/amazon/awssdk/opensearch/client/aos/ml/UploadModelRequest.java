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

import jakarta.json.stream.JsonGenerator;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import software.amazon.awssdk.opensearch.client.aos._types.RequestBase;
import software.amazon.awssdk.opensearch.client.errors.ErrorResponse;
import software.amazon.awssdk.opensearch.client.json.JsonpDeserializable;
import software.amazon.awssdk.opensearch.client.json.JsonpDeserializer;
import software.amazon.awssdk.opensearch.client.json.JsonpMapper;
import software.amazon.awssdk.opensearch.client.json.ObjectBuilderDeserializer;
import software.amazon.awssdk.opensearch.client.json.ObjectDeserializer;
import software.amazon.awssdk.opensearch.client.json.PlainJsonSerializable;
import software.amazon.awssdk.opensearch.client.transport.Endpoint;
import software.amazon.awssdk.opensearch.client.transport.endpoints.SimpleEndpoint;
import software.amazon.awssdk.opensearch.client.util.ApiTypeHelper;
import software.amazon.awssdk.opensearch.client.util.CopyableBuilder;
import software.amazon.awssdk.opensearch.client.util.ObjectBuilder;
import software.amazon.awssdk.opensearch.client.util.ToCopyableBuilder;

// typedef: ml.upload_model.Request

/**
 * Registers a model.
 */
@JsonpDeserializable
@Generated("software.amazon.awssdk.opensearch.client.codegen.CodeGenerator")
public final class UploadModelRequest extends RequestBase
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<UploadModelRequest.Builder, UploadModelRequest> {

    @Nullable
    private final String description;

    @Nullable
    private final ModelFormat modelFormat;

    @Nullable
    private final String modelGroupId;

    @Nonnull
    private final String name;

    @Nonnull
    private final String version;

    // ---------------------------------------------------------------------------------------------

    private UploadModelRequest(Builder builder) {
        super(builder);
        this.description = builder.description;
        this.modelFormat = builder.modelFormat;
        this.modelGroupId = builder.modelGroupId;
        this.name = ApiTypeHelper.requireNonNull(builder.name, this, "name");
        this.version = ApiTypeHelper.requireNonNull(builder.version, this, "version");
    }

    public static UploadModelRequest of(Function<UploadModelRequest.Builder, ObjectBuilder<UploadModelRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The model description.
     * <p>
     * API name: {@code description}
     * </p>
     */
    @Nullable
    public final String description() {
        return this.description;
    }

    /**
     * API name: {@code model_format}
     */
    @Nullable
    public final ModelFormat modelFormat() {
        return this.modelFormat;
    }

    /**
     * API name: {@code model_group_id}
     */
    @Nullable
    public final String modelGroupId() {
        return this.modelGroupId;
    }

    /**
     * Required - The model name.
     * <p>
     * API name: {@code name}
     * </p>
     */
    @Nonnull
    public final String name() {
        return this.name;
    }

    /**
     * Required - API name: {@code version}
     */
    @Nonnull
    public final String version() {
        return this.version;
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
        if (this.description != null) {
            generator.writeKey("description");
            generator.write(this.description);
        }

        if (this.modelFormat != null) {
            generator.writeKey("model_format");
            this.modelFormat.serialize(generator, mapper);
        }

        if (this.modelGroupId != null) {
            generator.writeKey("model_group_id");
            generator.write(this.modelGroupId);
        }

        generator.writeKey("name");
        generator.write(this.name);

        generator.writeKey("version");
        generator.write(this.version);
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
     * Builder for {@link UploadModelRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, UploadModelRequest> {
        @Nullable
        private String description;
        @Nullable
        private ModelFormat modelFormat;
        @Nullable
        private String modelGroupId;
        private String name;
        private String version;

        public Builder() {}

        private Builder(UploadModelRequest o) {
            super(o);
            this.description = o.description;
            this.modelFormat = o.modelFormat;
            this.modelGroupId = o.modelGroupId;
            this.name = o.name;
            this.version = o.version;
        }

        private Builder(Builder o) {
            super(o);
            this.description = o.description;
            this.modelFormat = o.modelFormat;
            this.modelGroupId = o.modelGroupId;
            this.name = o.name;
            this.version = o.version;
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
         * The model description.
         * <p>
         * API name: {@code description}
         * </p>
         */
        @Nonnull
        public final Builder description(@Nullable String value) {
            this.description = value;
            return this;
        }

        /**
         * API name: {@code model_format}
         */
        @Nonnull
        public final Builder modelFormat(@Nullable ModelFormat value) {
            this.modelFormat = value;
            return this;
        }

        /**
         * API name: {@code model_group_id}
         */
        @Nonnull
        public final Builder modelGroupId(@Nullable String value) {
            this.modelGroupId = value;
            return this;
        }

        /**
         * Required - The model name.
         * <p>
         * API name: {@code name}
         * </p>
         */
        @Nonnull
        public final Builder name(String value) {
            this.name = value;
            return this;
        }

        /**
         * Required - API name: {@code version}
         */
        @Nonnull
        public final Builder version(String value) {
            this.version = value;
            return this;
        }

        /**
         * Builds a {@link UploadModelRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public UploadModelRequest build() {
            _checkSingleUse();

            return new UploadModelRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link UploadModelRequest}
     */
    public static final JsonpDeserializer<UploadModelRequest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        UploadModelRequest::setupUploadModelRequestDeserializer
    );

    protected static void setupUploadModelRequestDeserializer(ObjectDeserializer<UploadModelRequest.Builder> op) {
        op.add(Builder::description, JsonpDeserializer.stringDeserializer(), "description");
        op.add(Builder::modelFormat, ModelFormat._DESERIALIZER, "model_format");
        op.add(Builder::modelGroupId, JsonpDeserializer.stringDeserializer(), "model_group_id");
        op.add(Builder::name, JsonpDeserializer.stringDeserializer(), "name");
        op.add(Builder::version, JsonpDeserializer.stringDeserializer(), "version");
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code ml.upload_model}".
     */
    public static final Endpoint<UploadModelRequest, UploadModelResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "POST",
        // Request path
        request -> "/_plugins/_ml/models/_upload",
        // Request parameters
        request -> {
            Map<String, String> params = new HashMap<>();
            request.applyQueryParameters(params);
            return params;
        },
        SimpleEndpoint.emptyMap(),
        true,
        UploadModelResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.description);
        result = 31 * result + Objects.hashCode(this.modelFormat);
        result = 31 * result + Objects.hashCode(this.modelGroupId);
        result = 31 * result + this.name.hashCode();
        result = 31 * result + this.version.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        UploadModelRequest other = (UploadModelRequest) o;
        return Objects.equals(this.description, other.description)
            && Objects.equals(this.modelFormat, other.modelFormat)
            && Objects.equals(this.modelGroupId, other.modelGroupId)
            && this.name.equals(other.name)
            && this.version.equals(other.version);
    }
}
