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
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import software.amazon.awssdk.opensearch.client.json.JsonpDeserializable;
import software.amazon.awssdk.opensearch.client.json.JsonpDeserializer;
import software.amazon.awssdk.opensearch.client.json.JsonpMapper;
import software.amazon.awssdk.opensearch.client.json.ObjectBuilderDeserializer;
import software.amazon.awssdk.opensearch.client.json.ObjectDeserializer;
import software.amazon.awssdk.opensearch.client.json.PlainJsonSerializable;
import software.amazon.awssdk.opensearch.client.util.CopyableBuilder;
import software.amazon.awssdk.opensearch.client.util.ObjectBuilder;
import software.amazon.awssdk.opensearch.client.util.ObjectBuilderBase;
import software.amazon.awssdk.opensearch.client.util.ToCopyableBuilder;

// typedef: ml.Messages

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class Messages implements PlainJsonSerializable, ToCopyableBuilder<Messages.Builder, Messages> {

    @Nullable
    private final String content;

    @Nullable
    private final String role;

    // ---------------------------------------------------------------------------------------------

    private Messages(Builder builder) {
        this.content = builder.content;
        this.role = builder.role;
    }

    public static Messages of(Function<Messages.Builder, ObjectBuilder<Messages>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The content of the message.
     * <p>
     * API name: {@code content}
     * </p>
     */
    @Nullable
    public final String content() {
        return this.content;
    }

    /**
     * The role of the message.
     * <p>
     * API name: {@code role}
     * </p>
     */
    @Nullable
    public final String role() {
        return this.role;
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
        if (this.content != null) {
            generator.writeKey("content");
            generator.write(this.content);
        }

        if (this.role != null) {
            generator.writeKey("role");
            generator.write(this.role);
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
     * Builder for {@link Messages}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, Messages> {
        @Nullable
        private String content;
        @Nullable
        private String role;

        public Builder() {}

        private Builder(Messages o) {
            this.content = o.content;
            this.role = o.role;
        }

        private Builder(Builder o) {
            this.content = o.content;
            this.role = o.role;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The content of the message.
         * <p>
         * API name: {@code content}
         * </p>
         */
        @Nonnull
        public final Builder content(@Nullable String value) {
            this.content = value;
            return this;
        }

        /**
         * The role of the message.
         * <p>
         * API name: {@code role}
         * </p>
         */
        @Nonnull
        public final Builder role(@Nullable String value) {
            this.role = value;
            return this;
        }

        /**
         * Builds a {@link Messages}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public Messages build() {
            _checkSingleUse();

            return new Messages(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link Messages}
     */
    public static final JsonpDeserializer<Messages> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        Messages::setupMessagesDeserializer
    );

    protected static void setupMessagesDeserializer(ObjectDeserializer<Messages.Builder> op) {
        op.add(Builder::content, JsonpDeserializer.stringDeserializer(), "content");
        op.add(Builder::role, JsonpDeserializer.stringDeserializer(), "role");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.content);
        result = 31 * result + Objects.hashCode(this.role);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Messages other = (Messages) o;
        return Objects.equals(this.content, other.content) && Objects.equals(this.role, other.role);
    }
}
