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

package software.amazon.opensearch.client.aos.ism;

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
import software.amazon.opensearch.client.util.CopyableBuilder;
import software.amazon.opensearch.client.util.ObjectBuilder;
import software.amazon.opensearch.client.util.ToCopyableBuilder;

// typedef: ism.put_policies.Response

@JsonpDeserializable
@Generated("software.amazon.opensearch.client.codegen.CodeGenerator")
public class PutPoliciesResponse extends Metadata implements ToCopyableBuilder<PutPoliciesResponse.Builder, PutPoliciesResponse> {

    @Nullable
    private final PolicyEnvelope policy;

    // ---------------------------------------------------------------------------------------------

    private PutPoliciesResponse(Builder builder) {
        super(builder);
        this.policy = builder.policy;
    }

    public static PutPoliciesResponse of(Function<PutPoliciesResponse.Builder, ObjectBuilder<PutPoliciesResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code policy}
     */
    @Nullable
    public final PolicyEnvelope policy() {
        return this.policy;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (this.policy != null) {
            generator.writeKey("policy");
            this.policy.serialize(generator, mapper);
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
     * Builder for {@link PutPoliciesResponse}.
     */
    public static class Builder extends Metadata.AbstractBuilder<Builder> implements CopyableBuilder<Builder, PutPoliciesResponse> {
        @Nullable
        private PolicyEnvelope policy;

        public Builder() {}

        private Builder(PutPoliciesResponse o) {
            super(o);
            this.policy = o.policy;
        }

        private Builder(Builder o) {
            super(o);
            this.policy = o.policy;
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
         * API name: {@code policy}
         */
        @Nonnull
        public final Builder policy(@Nullable PolicyEnvelope value) {
            this.policy = value;
            return this;
        }

        /**
         * API name: {@code policy}
         */
        @Nonnull
        public final Builder policy(Function<PolicyEnvelope.Builder, ObjectBuilder<PolicyEnvelope>> fn) {
            return policy(fn.apply(new PolicyEnvelope.Builder()).build());
        }

        /**
         * Builds a {@link PutPoliciesResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public PutPoliciesResponse build() {
            _checkSingleUse();

            return new PutPoliciesResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link PutPoliciesResponse}
     */
    public static final JsonpDeserializer<PutPoliciesResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        PutPoliciesResponse::setupPutPoliciesResponseDeserializer
    );

    protected static void setupPutPoliciesResponseDeserializer(ObjectDeserializer<PutPoliciesResponse.Builder> op) {
        setupMetadataDeserializer(op);
        op.add(Builder::policy, PolicyEnvelope._DESERIALIZER, "policy");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.policy);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        PutPoliciesResponse other = (PutPoliciesResponse) o;
        return Objects.equals(this.policy, other.policy);
    }
}
