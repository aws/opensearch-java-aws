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

package software.amazon.opensearch.client.aos._types;

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

// typedef: _types.RemoteStoreStats

/**
 * The statistics related to remote segment store operations.
 */
@JsonpDeserializable
@Generated("software.amazon.opensearch.client.codegen.CodeGenerator")
public class RemoteStoreStats implements PlainJsonSerializable, ToCopyableBuilder<RemoteStoreStats.Builder, RemoteStoreStats> {

    @Nonnull
    private final RemoteStoreDownloadStats download;

    @Nonnull
    private final RemoteStoreUploadStats upload;

    // ---------------------------------------------------------------------------------------------

    private RemoteStoreStats(Builder builder) {
        this.download = ApiTypeHelper.requireNonNull(builder.download, this, "download");
        this.upload = ApiTypeHelper.requireNonNull(builder.upload, this, "upload");
    }

    public static RemoteStoreStats of(Function<RemoteStoreStats.Builder, ObjectBuilder<RemoteStoreStats>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code download}
     */
    @Nonnull
    public final RemoteStoreDownloadStats download() {
        return this.download;
    }

    /**
     * Required - API name: {@code upload}
     */
    @Nonnull
    public final RemoteStoreUploadStats upload() {
        return this.upload;
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
        generator.writeKey("download");
        this.download.serialize(generator, mapper);

        generator.writeKey("upload");
        this.upload.serialize(generator, mapper);
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
     * Builder for {@link RemoteStoreStats}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, RemoteStoreStats> {
        private RemoteStoreDownloadStats download;
        private RemoteStoreUploadStats upload;

        public Builder() {}

        private Builder(RemoteStoreStats o) {
            this.download = o.download;
            this.upload = o.upload;
        }

        private Builder(Builder o) {
            this.download = o.download;
            this.upload = o.upload;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code download}
         */
        @Nonnull
        public final Builder download(RemoteStoreDownloadStats value) {
            this.download = value;
            return this;
        }

        /**
         * Required - API name: {@code download}
         */
        @Nonnull
        public final Builder download(Function<RemoteStoreDownloadStats.Builder, ObjectBuilder<RemoteStoreDownloadStats>> fn) {
            return download(fn.apply(new RemoteStoreDownloadStats.Builder()).build());
        }

        /**
         * Required - API name: {@code upload}
         */
        @Nonnull
        public final Builder upload(RemoteStoreUploadStats value) {
            this.upload = value;
            return this;
        }

        /**
         * Required - API name: {@code upload}
         */
        @Nonnull
        public final Builder upload(Function<RemoteStoreUploadStats.Builder, ObjectBuilder<RemoteStoreUploadStats>> fn) {
            return upload(fn.apply(new RemoteStoreUploadStats.Builder()).build());
        }

        /**
         * Builds a {@link RemoteStoreStats}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public RemoteStoreStats build() {
            _checkSingleUse();

            return new RemoteStoreStats(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link RemoteStoreStats}
     */
    public static final JsonpDeserializer<RemoteStoreStats> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        RemoteStoreStats::setupRemoteStoreStatsDeserializer
    );

    protected static void setupRemoteStoreStatsDeserializer(ObjectDeserializer<RemoteStoreStats.Builder> op) {
        op.add(Builder::download, RemoteStoreDownloadStats._DESERIALIZER, "download");
        op.add(Builder::upload, RemoteStoreUploadStats._DESERIALIZER, "upload");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.download.hashCode();
        result = 31 * result + this.upload.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        RemoteStoreStats other = (RemoteStoreStats) o;
        return this.download.equals(other.download) && this.upload.equals(other.upload);
    }
}
