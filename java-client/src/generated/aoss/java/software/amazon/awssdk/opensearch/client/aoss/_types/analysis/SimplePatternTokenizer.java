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

// typedef: _types.analysis.SimplePatternTokenizer

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class SimplePatternTokenizer extends TokenizerBase
    implements
        TokenizerDefinitionVariant,
        ToCopyableBuilder<SimplePatternTokenizer.Builder, SimplePatternTokenizer> {

    @Nullable
    private final String pattern;

    // ---------------------------------------------------------------------------------------------

    private SimplePatternTokenizer(Builder builder) {
        super(builder);
        this.pattern = builder.pattern;
    }

    public static SimplePatternTokenizer of(Function<SimplePatternTokenizer.Builder, ObjectBuilder<SimplePatternTokenizer>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link TokenizerDefinition} variant kind.
     */
    @Override
    public TokenizerDefinition.Kind _tokenizerDefinitionKind() {
        return TokenizerDefinition.Kind.SimplePattern;
    }

    /**
     * API name: {@code pattern}
     */
    @Nullable
    public final String pattern() {
        return this.pattern;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        generator.write("type", "simple_pattern");
        super.serializeInternal(generator, mapper);
        if (this.pattern != null) {
            generator.writeKey("pattern");
            generator.write(this.pattern);
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
     * Builder for {@link SimplePatternTokenizer}.
     */
    public static class Builder extends TokenizerBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, SimplePatternTokenizer> {
        @Nullable
        private String pattern;

        public Builder() {}

        private Builder(SimplePatternTokenizer o) {
            super(o);
            this.pattern = o.pattern;
        }

        private Builder(Builder o) {
            super(o);
            this.pattern = o.pattern;
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
         * API name: {@code pattern}
         */
        @Nonnull
        public final Builder pattern(@Nullable String value) {
            this.pattern = value;
            return this;
        }

        /**
         * Builds a {@link SimplePatternTokenizer}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public SimplePatternTokenizer build() {
            _checkSingleUse();

            return new SimplePatternTokenizer(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link SimplePatternTokenizer}
     */
    public static final JsonpDeserializer<SimplePatternTokenizer> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        SimplePatternTokenizer::setupSimplePatternTokenizerDeserializer
    );

    protected static void setupSimplePatternTokenizerDeserializer(ObjectDeserializer<SimplePatternTokenizer.Builder> op) {
        setupTokenizerBaseDeserializer(op);
        op.add(Builder::pattern, JsonpDeserializer.stringDeserializer(), "pattern");

        op.ignore("type");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.pattern);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        SimplePatternTokenizer other = (SimplePatternTokenizer) o;
        return Objects.equals(this.pattern, other.pattern);
    }
}
