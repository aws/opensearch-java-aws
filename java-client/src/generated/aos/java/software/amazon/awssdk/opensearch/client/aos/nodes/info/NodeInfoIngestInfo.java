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

package software.amazon.awssdk.opensearch.client.aos.nodes.info;

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

// typedef: nodes.info.NodeInfoIngestInfo

/**
 * The ingest processor configuration details.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class NodeInfoIngestInfo implements PlainJsonSerializable, ToCopyableBuilder<NodeInfoIngestInfo.Builder, NodeInfoIngestInfo> {

    @Nonnull
    private final NodeInfoIngestDownloader downloader;

    // ---------------------------------------------------------------------------------------------

    private NodeInfoIngestInfo(Builder builder) {
        this.downloader = ApiTypeHelper.requireNonNull(builder.downloader, this, "downloader");
    }

    public static NodeInfoIngestInfo of(Function<NodeInfoIngestInfo.Builder, ObjectBuilder<NodeInfoIngestInfo>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code downloader}
     */
    @Nonnull
    public final NodeInfoIngestDownloader downloader() {
        return this.downloader;
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
        generator.writeKey("downloader");
        this.downloader.serialize(generator, mapper);
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
     * Builder for {@link NodeInfoIngestInfo}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, NodeInfoIngestInfo> {
        private NodeInfoIngestDownloader downloader;

        public Builder() {}

        private Builder(NodeInfoIngestInfo o) {
            this.downloader = o.downloader;
        }

        private Builder(Builder o) {
            this.downloader = o.downloader;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code downloader}
         */
        @Nonnull
        public final Builder downloader(NodeInfoIngestDownloader value) {
            this.downloader = value;
            return this;
        }

        /**
         * Required - API name: {@code downloader}
         */
        @Nonnull
        public final Builder downloader(Function<NodeInfoIngestDownloader.Builder, ObjectBuilder<NodeInfoIngestDownloader>> fn) {
            return downloader(fn.apply(new NodeInfoIngestDownloader.Builder()).build());
        }

        /**
         * Builds a {@link NodeInfoIngestInfo}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public NodeInfoIngestInfo build() {
            _checkSingleUse();

            return new NodeInfoIngestInfo(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link NodeInfoIngestInfo}
     */
    public static final JsonpDeserializer<NodeInfoIngestInfo> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        NodeInfoIngestInfo::setupNodeInfoIngestInfoDeserializer
    );

    protected static void setupNodeInfoIngestInfoDeserializer(ObjectDeserializer<NodeInfoIngestInfo.Builder> op) {
        op.add(Builder::downloader, NodeInfoIngestDownloader._DESERIALIZER, "downloader");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.downloader.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        NodeInfoIngestInfo other = (NodeInfoIngestInfo) o;
        return this.downloader.equals(other.downloader);
    }
}
