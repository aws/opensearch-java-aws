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

package software.amazon.opensearch.client.aos.nodes.info;

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

// typedef: nodes.info.NodeInfoRepositoriesUrl

/**
 * Specifies allowed repository URLs.
 */
@JsonpDeserializable
@Generated("software.amazon.opensearch.client.codegen.CodeGenerator")
public class NodeInfoRepositoriesUrl
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<NodeInfoRepositoriesUrl.Builder, NodeInfoRepositoriesUrl> {

    @Nonnull
    private final String allowedUrls;

    // ---------------------------------------------------------------------------------------------

    private NodeInfoRepositoriesUrl(Builder builder) {
        this.allowedUrls = ApiTypeHelper.requireNonNull(builder.allowedUrls, this, "allowedUrls");
    }

    public static NodeInfoRepositoriesUrl of(Function<NodeInfoRepositoriesUrl.Builder, ObjectBuilder<NodeInfoRepositoriesUrl>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - The pattern for allowed repository URLs.
     * <p>
     * API name: {@code allowed_urls}
     * </p>
     */
    @Nonnull
    public final String allowedUrls() {
        return this.allowedUrls;
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
        generator.writeKey("allowed_urls");
        generator.write(this.allowedUrls);
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
     * Builder for {@link NodeInfoRepositoriesUrl}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, NodeInfoRepositoriesUrl> {
        private String allowedUrls;

        public Builder() {}

        private Builder(NodeInfoRepositoriesUrl o) {
            this.allowedUrls = o.allowedUrls;
        }

        private Builder(Builder o) {
            this.allowedUrls = o.allowedUrls;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - The pattern for allowed repository URLs.
         * <p>
         * API name: {@code allowed_urls}
         * </p>
         */
        @Nonnull
        public final Builder allowedUrls(String value) {
            this.allowedUrls = value;
            return this;
        }

        /**
         * Builds a {@link NodeInfoRepositoriesUrl}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public NodeInfoRepositoriesUrl build() {
            _checkSingleUse();

            return new NodeInfoRepositoriesUrl(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link NodeInfoRepositoriesUrl}
     */
    public static final JsonpDeserializer<NodeInfoRepositoriesUrl> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        NodeInfoRepositoriesUrl::setupNodeInfoRepositoriesUrlDeserializer
    );

    protected static void setupNodeInfoRepositoriesUrlDeserializer(ObjectDeserializer<NodeInfoRepositoriesUrl.Builder> op) {
        op.add(Builder::allowedUrls, JsonpDeserializer.stringDeserializer(), "allowed_urls");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.allowedUrls.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        NodeInfoRepositoriesUrl other = (NodeInfoRepositoriesUrl) o;
        return this.allowedUrls.equals(other.allowedUrls);
    }
}
