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
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import software.amazon.awssdk.opensearch.client.json.JsonpDeserializable;
import software.amazon.awssdk.opensearch.client.json.JsonpDeserializer;
import software.amazon.awssdk.opensearch.client.json.JsonpMapper;
import software.amazon.awssdk.opensearch.client.json.ObjectBuilderDeserializer;
import software.amazon.awssdk.opensearch.client.json.ObjectDeserializer;
import software.amazon.awssdk.opensearch.client.json.PlainJsonSerializable;
import software.amazon.awssdk.opensearch.client.util.ApiTypeHelper;
import software.amazon.awssdk.opensearch.client.util.CopyableBuilder;
import software.amazon.awssdk.opensearch.client.util.ObjectBuilder;
import software.amazon.awssdk.opensearch.client.util.ObjectBuilderBase;
import software.amazon.awssdk.opensearch.client.util.ToCopyableBuilder;

// typedef: ml.load_model.Response

@JsonpDeserializable
@Generated("software.amazon.awssdk.opensearch.client.codegen.CodeGenerator")
public class LoadModelResponse implements PlainJsonSerializable, ToCopyableBuilder<LoadModelResponse.Builder, LoadModelResponse> {

    @Nonnull
    private final String status;

    @Nonnull
    private final String taskId;

    @Nonnull
    private final MlTaskType taskType;

    // ---------------------------------------------------------------------------------------------

    private LoadModelResponse(Builder builder) {
        this.status = ApiTypeHelper.requireNonNull(builder.status, this, "status");
        this.taskId = ApiTypeHelper.requireNonNull(builder.taskId, this, "taskId");
        this.taskType = ApiTypeHelper.requireNonNull(builder.taskType, this, "taskType");
    }

    public static LoadModelResponse of(Function<LoadModelResponse.Builder, ObjectBuilder<LoadModelResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code status}
     */
    @Nonnull
    public final String status() {
        return this.status;
    }

    /**
     * Required - API name: {@code task_id}
     */
    @Nonnull
    public final String taskId() {
        return this.taskId;
    }

    /**
     * Required - API name: {@code task_type}
     */
    @Nonnull
    public final MlTaskType taskType() {
        return this.taskType;
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
        generator.writeKey("status");
        generator.write(this.status);

        generator.writeKey("task_id");
        generator.write(this.taskId);

        generator.writeKey("task_type");
        this.taskType.serialize(generator, mapper);
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
     * Builder for {@link LoadModelResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, LoadModelResponse> {
        private String status;
        private String taskId;
        private MlTaskType taskType;

        public Builder() {}

        private Builder(LoadModelResponse o) {
            this.status = o.status;
            this.taskId = o.taskId;
            this.taskType = o.taskType;
        }

        private Builder(Builder o) {
            this.status = o.status;
            this.taskId = o.taskId;
            this.taskType = o.taskType;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code status}
         */
        @Nonnull
        public final Builder status(String value) {
            this.status = value;
            return this;
        }

        /**
         * Required - API name: {@code task_id}
         */
        @Nonnull
        public final Builder taskId(String value) {
            this.taskId = value;
            return this;
        }

        /**
         * Required - API name: {@code task_type}
         */
        @Nonnull
        public final Builder taskType(MlTaskType value) {
            this.taskType = value;
            return this;
        }

        /**
         * Builds a {@link LoadModelResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public LoadModelResponse build() {
            _checkSingleUse();

            return new LoadModelResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link LoadModelResponse}
     */
    public static final JsonpDeserializer<LoadModelResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        LoadModelResponse::setupLoadModelResponseDeserializer
    );

    protected static void setupLoadModelResponseDeserializer(ObjectDeserializer<LoadModelResponse.Builder> op) {
        op.add(Builder::status, JsonpDeserializer.stringDeserializer(), "status");
        op.add(Builder::taskId, JsonpDeserializer.stringDeserializer(), "task_id");
        op.add(Builder::taskType, MlTaskType._DESERIALIZER, "task_type");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.status.hashCode();
        result = 31 * result + this.taskId.hashCode();
        result = 31 * result + this.taskType.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        LoadModelResponse other = (LoadModelResponse) o;
        return this.status.equals(other.status) && this.taskId.equals(other.taskId) && this.taskType.equals(other.taskType);
    }
}
