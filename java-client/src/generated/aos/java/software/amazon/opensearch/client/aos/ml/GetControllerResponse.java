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
import java.util.Map;
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
import software.amazon.opensearch.client.util.ApiTypeHelper;
import software.amazon.opensearch.client.util.CopyableBuilder;
import software.amazon.opensearch.client.util.ObjectBuilder;
import software.amazon.opensearch.client.util.ObjectBuilderBase;
import software.amazon.opensearch.client.util.ToCopyableBuilder;

// typedef: ml.get_controller.Response

@JsonpDeserializable
@Generated("software.amazon.opensearch.client.codegen.CodeGenerator")
public class GetControllerResponse
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<GetControllerResponse.Builder, GetControllerResponse> {

    @Nullable
    private final String modelId;

    @Nonnull
    private final Map<String, RateLimiter> userRateLimiter;

    // ---------------------------------------------------------------------------------------------

    private GetControllerResponse(Builder builder) {
        this.modelId = builder.modelId;
        this.userRateLimiter = ApiTypeHelper.unmodifiable(builder.userRateLimiter);
    }

    public static GetControllerResponse of(Function<GetControllerResponse.Builder, ObjectBuilder<GetControllerResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code model_id}
     */
    @Nullable
    public final String modelId() {
        return this.modelId;
    }

    /**
     * API name: {@code user_rate_limiter}
     */
    @Nonnull
    public final Map<String, RateLimiter> userRateLimiter() {
        return this.userRateLimiter;
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
        if (this.modelId != null) {
            generator.writeKey("model_id");
            generator.write(this.modelId);
        }

        if (ApiTypeHelper.isDefined(this.userRateLimiter)) {
            generator.writeKey("user_rate_limiter");
            generator.writeStartObject();
            for (Map.Entry<String, RateLimiter> item0 : this.userRateLimiter.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
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
     * Builder for {@link GetControllerResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, GetControllerResponse> {
        @Nullable
        private String modelId;
        @Nullable
        private Map<String, RateLimiter> userRateLimiter;

        public Builder() {}

        private Builder(GetControllerResponse o) {
            this.modelId = o.modelId;
            this.userRateLimiter = _mapCopy(o.userRateLimiter);
        }

        private Builder(Builder o) {
            this.modelId = o.modelId;
            this.userRateLimiter = _mapCopy(o.userRateLimiter);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code model_id}
         */
        @Nonnull
        public final Builder modelId(@Nullable String value) {
            this.modelId = value;
            return this;
        }

        /**
         * API name: {@code user_rate_limiter}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>userRateLimiter</code>.
         * </p>
         */
        @Nonnull
        public final Builder userRateLimiter(Map<String, RateLimiter> map) {
            this.userRateLimiter = _mapPutAll(this.userRateLimiter, map);
            return this;
        }

        /**
         * API name: {@code user_rate_limiter}
         *
         * <p>
         * Adds an entry to <code>userRateLimiter</code>.
         * </p>
         */
        @Nonnull
        public final Builder userRateLimiter(String key, RateLimiter value) {
            this.userRateLimiter = _mapPut(this.userRateLimiter, key, value);
            return this;
        }

        /**
         * API name: {@code user_rate_limiter}
         *
         * <p>
         * Adds a value to <code>userRateLimiter</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder userRateLimiter(String key, Function<RateLimiter.Builder, ObjectBuilder<RateLimiter>> fn) {
            return userRateLimiter(key, fn.apply(new RateLimiter.Builder()).build());
        }

        /**
         * Builds a {@link GetControllerResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GetControllerResponse build() {
            _checkSingleUse();

            return new GetControllerResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link GetControllerResponse}
     */
    public static final JsonpDeserializer<GetControllerResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        GetControllerResponse::setupGetControllerResponseDeserializer
    );

    protected static void setupGetControllerResponseDeserializer(ObjectDeserializer<GetControllerResponse.Builder> op) {
        op.add(Builder::modelId, JsonpDeserializer.stringDeserializer(), "model_id");
        op.add(Builder::userRateLimiter, JsonpDeserializer.stringMapDeserializer(RateLimiter._DESERIALIZER), "user_rate_limiter");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.modelId);
        result = 31 * result + Objects.hashCode(this.userRateLimiter);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GetControllerResponse other = (GetControllerResponse) o;
        return Objects.equals(this.modelId, other.modelId) && Objects.equals(this.userRateLimiter, other.userRateLimiter);
    }
}
