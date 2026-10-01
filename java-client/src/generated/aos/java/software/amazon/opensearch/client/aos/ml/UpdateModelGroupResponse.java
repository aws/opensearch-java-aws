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
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import software.amazon.opensearch.client.json.JsonpDeserializable;
import software.amazon.opensearch.client.json.JsonpDeserializer;
import software.amazon.opensearch.client.json.JsonpMapper;
import software.amazon.opensearch.client.json.ObjectBuilderDeserializer;
import software.amazon.opensearch.client.json.ObjectDeserializer;
import software.amazon.opensearch.client.json.PlainJsonSerializable;
import software.amazon.opensearch.client.util.CopyableBuilder;
import software.amazon.opensearch.client.util.ObjectBuilder;
import software.amazon.opensearch.client.util.ObjectBuilderBase;
import software.amazon.opensearch.client.util.ToCopyableBuilder;

// typedef: ml.update_model_group.Response

@JsonpDeserializable
@Generated("software.amazon.opensearch.client.codegen.CodeGenerator")
public class UpdateModelGroupResponse
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<UpdateModelGroupResponse.Builder, UpdateModelGroupResponse> {

    @Nullable
    private final String status;

    // ---------------------------------------------------------------------------------------------

    private UpdateModelGroupResponse(Builder builder) {
        this.status = builder.status;
    }

    public static UpdateModelGroupResponse of(Function<UpdateModelGroupResponse.Builder, ObjectBuilder<UpdateModelGroupResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The status.
     * <p>
     * API name: {@code status}
     * </p>
     */
    @Nullable
    public final String status() {
        return this.status;
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
        if (this.status != null) {
            generator.writeKey("status");
            generator.write(this.status);
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
     * Builder for {@link UpdateModelGroupResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, UpdateModelGroupResponse> {
        @Nullable
        private String status;

        public Builder() {}

        private Builder(UpdateModelGroupResponse o) {
            this.status = o.status;
        }

        private Builder(Builder o) {
            this.status = o.status;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The status.
         * <p>
         * API name: {@code status}
         * </p>
         */
        @Nonnull
        public final Builder status(@Nullable String value) {
            this.status = value;
            return this;
        }

        /**
         * Builds a {@link UpdateModelGroupResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public UpdateModelGroupResponse build() {
            _checkSingleUse();

            return new UpdateModelGroupResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link UpdateModelGroupResponse}
     */
    public static final JsonpDeserializer<UpdateModelGroupResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        UpdateModelGroupResponse::setupUpdateModelGroupResponseDeserializer
    );

    protected static void setupUpdateModelGroupResponseDeserializer(ObjectDeserializer<UpdateModelGroupResponse.Builder> op) {
        op.add(Builder::status, JsonpDeserializer.stringDeserializer(), "status");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.status);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        UpdateModelGroupResponse other = (UpdateModelGroupResponse) o;
        return Objects.equals(this.status, other.status);
    }
}
