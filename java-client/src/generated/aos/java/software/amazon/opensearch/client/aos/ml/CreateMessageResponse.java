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
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import software.amazon.opensearch.client.json.JsonpDeserializable;
import software.amazon.opensearch.client.json.JsonpDeserializer;
import software.amazon.opensearch.client.json.JsonpMapper;
import software.amazon.opensearch.client.json.ObjectBuilderDeserializer;
import software.amazon.opensearch.client.json.ObjectDeserializer;
import software.amazon.opensearch.client.json.PlainJsonSerializable;
import software.amazon.opensearch.client.util.ApiTypeHelper;
import software.amazon.opensearch.client.util.CopyableBuilder;
import software.amazon.opensearch.client.util.ObjectBuilder;
import software.amazon.opensearch.client.util.ObjectBuilderBase;
import software.amazon.opensearch.client.util.ToCopyableBuilder;

// typedef: ml.create_message.Response

@JsonpDeserializable
@Generated("software.amazon.opensearch.client.codegen.CodeGenerator")
public class CreateMessageResponse
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<CreateMessageResponse.Builder, CreateMessageResponse> {

    @Nonnull
    private final String messageId;

    // ---------------------------------------------------------------------------------------------

    private CreateMessageResponse(Builder builder) {
        this.messageId = ApiTypeHelper.requireNonNull(builder.messageId, this, "messageId");
    }

    public static CreateMessageResponse of(Function<CreateMessageResponse.Builder, ObjectBuilder<CreateMessageResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code message_id}
     */
    @Nonnull
    public final String messageId() {
        return this.messageId;
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
        generator.writeKey("message_id");
        generator.write(this.messageId);
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
     * Builder for {@link CreateMessageResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, CreateMessageResponse> {
        private String messageId;

        public Builder() {}

        private Builder(CreateMessageResponse o) {
            this.messageId = o.messageId;
        }

        private Builder(Builder o) {
            this.messageId = o.messageId;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
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
         * Builds a {@link CreateMessageResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public CreateMessageResponse build() {
            _checkSingleUse();

            return new CreateMessageResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link CreateMessageResponse}
     */
    public static final JsonpDeserializer<CreateMessageResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        CreateMessageResponse::setupCreateMessageResponseDeserializer
    );

    protected static void setupCreateMessageResponseDeserializer(ObjectDeserializer<CreateMessageResponse.Builder> op) {
        op.add(Builder::messageId, JsonpDeserializer.stringDeserializer(), "message_id");
    }

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
        CreateMessageResponse other = (CreateMessageResponse) o;
        return this.messageId.equals(other.messageId);
    }
}
