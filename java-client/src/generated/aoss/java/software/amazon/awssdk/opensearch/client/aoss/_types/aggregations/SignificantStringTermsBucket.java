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

package software.amazon.awssdk.opensearch.client.aoss._types.aggregations;

import jakarta.json.stream.JsonGenerator;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import software.amazon.awssdk.opensearch.client.json.JsonpDeserializable;
import software.amazon.awssdk.opensearch.client.json.JsonpDeserializer;
import software.amazon.awssdk.opensearch.client.json.JsonpMapper;
import software.amazon.awssdk.opensearch.client.json.ObjectBuilderDeserializer;
import software.amazon.awssdk.opensearch.client.json.ObjectDeserializer;
import software.amazon.awssdk.opensearch.client.util.ApiTypeHelper;
import software.amazon.awssdk.opensearch.client.util.CopyableBuilder;
import software.amazon.awssdk.opensearch.client.util.ObjectBuilder;
import software.amazon.awssdk.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.aggregations.SignificantStringTermsBucket

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class SignificantStringTermsBucket extends SignificantTermsBucketBase
    implements
        ToCopyableBuilder<SignificantStringTermsBucket.Builder, SignificantStringTermsBucket> {

    @Nonnull
    private final String key;

    // ---------------------------------------------------------------------------------------------

    private SignificantStringTermsBucket(Builder builder) {
        super(builder);
        this.key = ApiTypeHelper.requireNonNull(builder.key, this, "key");
    }

    public static SignificantStringTermsBucket of(
        Function<SignificantStringTermsBucket.Builder, ObjectBuilder<SignificantStringTermsBucket>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code key}
     */
    @Nonnull
    public final String key() {
        return this.key;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        generator.writeKey("key");
        generator.write(this.key);
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
     * Builder for {@link SignificantStringTermsBucket}.
     */
    public static class Builder extends SignificantTermsBucketBase.AbstractBuilder<Builder>
        implements
            CopyableBuilder<Builder, SignificantStringTermsBucket> {
        private String key;

        public Builder() {}

        private Builder(SignificantStringTermsBucket o) {
            super(o);
            this.key = o.key;
        }

        private Builder(Builder o) {
            super(o);
            this.key = o.key;
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
         * Required - API name: {@code key}
         */
        @Nonnull
        public final Builder key(String value) {
            this.key = value;
            return this;
        }

        /**
         * Builds a {@link SignificantStringTermsBucket}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public SignificantStringTermsBucket build() {
            _checkSingleUse();

            return new SignificantStringTermsBucket(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link SignificantStringTermsBucket}
     */
    public static final JsonpDeserializer<SignificantStringTermsBucket> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        SignificantStringTermsBucket::setupSignificantStringTermsBucketDeserializer
    );

    protected static void setupSignificantStringTermsBucketDeserializer(ObjectDeserializer<SignificantStringTermsBucket.Builder> op) {
        setupSignificantTermsBucketBaseDeserializer(op);
        op.add(Builder::key, JsonpDeserializer.stringDeserializer(), "key");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + this.key.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        SignificantStringTermsBucket other = (SignificantStringTermsBucket) o;
        return this.key.equals(other.key);
    }
}
