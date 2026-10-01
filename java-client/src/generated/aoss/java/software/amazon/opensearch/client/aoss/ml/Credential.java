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

package software.amazon.opensearch.client.aoss.ml;

import jakarta.json.stream.JsonGenerator;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import software.amazon.opensearch.client.json.JsonData;
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

// typedef: ml.Credential

@JsonpDeserializable
@Generated("software.amazon.opensearch.client.codegen.CodeGenerator")
public class Credential implements PlainJsonSerializable, ToCopyableBuilder<Credential.Builder, Credential> {

    @Nullable
    private final String accessKey;

    @Nonnull
    private final Map<String, JsonData> metadata;

    @Nullable
    private final String secretKey;

    @Nullable
    private final String sessionToken;

    // ---------------------------------------------------------------------------------------------

    private Credential(Builder builder) {
        this.accessKey = builder.accessKey;
        this.metadata = ApiTypeHelper.unmodifiable(builder.metadata);
        this.secretKey = builder.secretKey;
        this.sessionToken = builder.sessionToken;
    }

    public static Credential of(Function<Credential.Builder, ObjectBuilder<Credential>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code access_key}
     */
    @Nullable
    public final String accessKey() {
        return this.accessKey;
    }

    @Nonnull
    public final Map<String, JsonData> metadata() {
        return this.metadata;
    }

    /**
     * API name: {@code secret_key}
     */
    @Nullable
    public final String secretKey() {
        return this.secretKey;
    }

    /**
     * API name: {@code session_token}
     */
    @Nullable
    public final String sessionToken() {
        return this.sessionToken;
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
        for (Map.Entry<String, JsonData> item0 : this.metadata.entrySet()) {
            generator.writeKey(item0.getKey());
            item0.getValue().serialize(generator, mapper);
        }
        if (this.accessKey != null) {
            generator.writeKey("access_key");
            generator.write(this.accessKey);
        }

        if (this.secretKey != null) {
            generator.writeKey("secret_key");
            generator.write(this.secretKey);
        }

        if (this.sessionToken != null) {
            generator.writeKey("session_token");
            generator.write(this.sessionToken);
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
     * Builder for {@link Credential}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, Credential> {
        @Nullable
        private String accessKey;
        @Nullable
        private Map<String, JsonData> metadata;
        @Nullable
        private String secretKey;
        @Nullable
        private String sessionToken;

        public Builder() {}

        private Builder(Credential o) {
            this.accessKey = o.accessKey;
            this.metadata = _mapCopy(o.metadata);
            this.secretKey = o.secretKey;
            this.sessionToken = o.sessionToken;
        }

        private Builder(Builder o) {
            this.accessKey = o.accessKey;
            this.metadata = _mapCopy(o.metadata);
            this.secretKey = o.secretKey;
            this.sessionToken = o.sessionToken;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code access_key}
         */
        @Nonnull
        public final Builder accessKey(@Nullable String value) {
            this.accessKey = value;
            return this;
        }

        /**
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>metadata</code>.
         * </p>
         */
        @Nonnull
        public final Builder metadata(Map<String, JsonData> map) {
            this.metadata = _mapPutAll(this.metadata, map);
            return this;
        }

        /**
         *
         * <p>
         * Adds an entry to <code>metadata</code>.
         * </p>
         */
        @Nonnull
        public final Builder metadata(String key, JsonData value) {
            this.metadata = _mapPut(this.metadata, key, value);
            return this;
        }

        /**
         * API name: {@code secret_key}
         */
        @Nonnull
        public final Builder secretKey(@Nullable String value) {
            this.secretKey = value;
            return this;
        }

        /**
         * API name: {@code session_token}
         */
        @Nonnull
        public final Builder sessionToken(@Nullable String value) {
            this.sessionToken = value;
            return this;
        }

        /**
         * Builds a {@link Credential}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public Credential build() {
            _checkSingleUse();

            return new Credential(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link Credential}
     */
    public static final JsonpDeserializer<Credential> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        Credential::setupCredentialDeserializer
    );

    protected static void setupCredentialDeserializer(ObjectDeserializer<Credential.Builder> op) {
        op.add(Builder::accessKey, JsonpDeserializer.stringDeserializer(), "access_key");
        op.add(Builder::secretKey, JsonpDeserializer.stringDeserializer(), "secret_key");
        op.add(Builder::sessionToken, JsonpDeserializer.stringDeserializer(), "session_token");
        op.setUnknownFieldHandler((builder, name, parser, mapper) -> {
            if (builder.metadata == null) {
                builder.metadata = new HashMap<>();
            }
            builder.metadata.put(name, JsonData._DESERIALIZER.deserialize(parser, mapper));
        });
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.accessKey);
        result = 31 * result + Objects.hashCode(this.metadata);
        result = 31 * result + Objects.hashCode(this.secretKey);
        result = 31 * result + Objects.hashCode(this.sessionToken);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Credential other = (Credential) o;
        return Objects.equals(this.accessKey, other.accessKey)
            && Objects.equals(this.metadata, other.metadata)
            && Objects.equals(this.secretKey, other.secretKey)
            && Objects.equals(this.sessionToken, other.sessionToken);
    }
}
