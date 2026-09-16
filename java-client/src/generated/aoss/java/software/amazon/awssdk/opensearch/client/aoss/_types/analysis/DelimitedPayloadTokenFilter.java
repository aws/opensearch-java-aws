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

package software.amazon.awssdk.opensearch.client.aoss._types.analysis;

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
import software.amazon.awssdk.opensearch.client.util.CopyableBuilder;
import software.amazon.awssdk.opensearch.client.util.ObjectBuilder;
import software.amazon.awssdk.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.analysis.DelimitedPayloadTokenFilter

@JsonpDeserializable
@Generated("software.amazon.awssdk.opensearch.client.codegen.CodeGenerator")
public class DelimitedPayloadTokenFilter extends TokenFilterBase
    implements
        TokenFilterDefinitionVariant,
        ToCopyableBuilder<DelimitedPayloadTokenFilter.Builder, DelimitedPayloadTokenFilter> {

    @Nullable
    private final String delimiter;

    @Nullable
    private final DelimitedPayloadEncoding encoding;

    // ---------------------------------------------------------------------------------------------

    private DelimitedPayloadTokenFilter(Builder builder) {
        super(builder);
        this.delimiter = builder.delimiter;
        this.encoding = builder.encoding;
    }

    public static DelimitedPayloadTokenFilter of(
        Function<DelimitedPayloadTokenFilter.Builder, ObjectBuilder<DelimitedPayloadTokenFilter>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link TokenFilterDefinition} variant kind.
     */
    @Override
    public TokenFilterDefinition.Kind _tokenFilterDefinitionKind() {
        return TokenFilterDefinition.Kind.DelimitedPayload;
    }

    /**
     * API name: {@code delimiter}
     */
    @Nullable
    public final String delimiter() {
        return this.delimiter;
    }

    /**
     * API name: {@code encoding}
     */
    @Nullable
    public final DelimitedPayloadEncoding encoding() {
        return this.encoding;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        generator.write("type", "delimited_payload");
        super.serializeInternal(generator, mapper);
        if (this.delimiter != null) {
            generator.writeKey("delimiter");
            generator.write(this.delimiter);
        }

        if (this.encoding != null) {
            generator.writeKey("encoding");
            this.encoding.serialize(generator, mapper);
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
     * Builder for {@link DelimitedPayloadTokenFilter}.
     */
    public static class Builder extends TokenFilterBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, DelimitedPayloadTokenFilter> {
        @Nullable
        private String delimiter;
        @Nullable
        private DelimitedPayloadEncoding encoding;

        public Builder() {}

        private Builder(DelimitedPayloadTokenFilter o) {
            super(o);
            this.delimiter = o.delimiter;
            this.encoding = o.encoding;
        }

        private Builder(Builder o) {
            super(o);
            this.delimiter = o.delimiter;
            this.encoding = o.encoding;
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
         * API name: {@code delimiter}
         */
        @Nonnull
        public final Builder delimiter(@Nullable String value) {
            this.delimiter = value;
            return this;
        }

        /**
         * API name: {@code encoding}
         */
        @Nonnull
        public final Builder encoding(@Nullable DelimitedPayloadEncoding value) {
            this.encoding = value;
            return this;
        }

        /**
         * Builds a {@link DelimitedPayloadTokenFilter}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public DelimitedPayloadTokenFilter build() {
            _checkSingleUse();

            return new DelimitedPayloadTokenFilter(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link DelimitedPayloadTokenFilter}
     */
    public static final JsonpDeserializer<DelimitedPayloadTokenFilter> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        DelimitedPayloadTokenFilter::setupDelimitedPayloadTokenFilterDeserializer
    );

    protected static void setupDelimitedPayloadTokenFilterDeserializer(ObjectDeserializer<DelimitedPayloadTokenFilter.Builder> op) {
        setupTokenFilterBaseDeserializer(op);
        op.add(Builder::delimiter, JsonpDeserializer.stringDeserializer(), "delimiter");
        op.add(Builder::encoding, DelimitedPayloadEncoding._DESERIALIZER, "encoding");

        op.ignore("type");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.delimiter);
        result = 31 * result + Objects.hashCode(this.encoding);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        DelimitedPayloadTokenFilter other = (DelimitedPayloadTokenFilter) o;
        return Objects.equals(this.delimiter, other.delimiter) && Objects.equals(this.encoding, other.encoding);
    }
}
