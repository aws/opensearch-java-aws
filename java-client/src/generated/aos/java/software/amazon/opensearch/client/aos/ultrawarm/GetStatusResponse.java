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

package software.amazon.opensearch.client.aos.ultrawarm;

import jakarta.json.stream.JsonGenerator;
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

// typedef: ultrawarm.get_status.Response

@JsonpDeserializable
@Generated("software.amazon.opensearch.client.codegen.CodeGenerator")
public class GetStatusResponse implements PlainJsonSerializable, ToCopyableBuilder<GetStatusResponse.Builder, GetStatusResponse> {

    @Nonnull
    private final Map<String, JsonData> migrationStatus;

    // ---------------------------------------------------------------------------------------------

    private GetStatusResponse(Builder builder) {
        this.migrationStatus = ApiTypeHelper.unmodifiable(builder.migrationStatus);
    }

    public static GetStatusResponse of(Function<GetStatusResponse.Builder, ObjectBuilder<GetStatusResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code migration_status}
     */
    @Nonnull
    public final Map<String, JsonData> migrationStatus() {
        return this.migrationStatus;
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
        if (ApiTypeHelper.isDefined(this.migrationStatus)) {
            generator.writeKey("migration_status");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.migrationStatus.entrySet()) {
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
     * Builder for {@link GetStatusResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, GetStatusResponse> {
        @Nullable
        private Map<String, JsonData> migrationStatus;

        public Builder() {}

        private Builder(GetStatusResponse o) {
            this.migrationStatus = _mapCopy(o.migrationStatus);
        }

        private Builder(Builder o) {
            this.migrationStatus = _mapCopy(o.migrationStatus);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code migration_status}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>migrationStatus</code>.
         * </p>
         */
        @Nonnull
        public final Builder migrationStatus(Map<String, JsonData> map) {
            this.migrationStatus = _mapPutAll(this.migrationStatus, map);
            return this;
        }

        /**
         * API name: {@code migration_status}
         *
         * <p>
         * Adds an entry to <code>migrationStatus</code>.
         * </p>
         */
        @Nonnull
        public final Builder migrationStatus(String key, JsonData value) {
            this.migrationStatus = _mapPut(this.migrationStatus, key, value);
            return this;
        }

        /**
         * Builds a {@link GetStatusResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GetStatusResponse build() {
            _checkSingleUse();

            return new GetStatusResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link GetStatusResponse}
     */
    public static final JsonpDeserializer<GetStatusResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        GetStatusResponse::setupGetStatusResponseDeserializer
    );

    protected static void setupGetStatusResponseDeserializer(ObjectDeserializer<GetStatusResponse.Builder> op) {
        op.add(Builder::migrationStatus, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "migration_status");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.migrationStatus);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GetStatusResponse other = (GetStatusResponse) o;
        return Objects.equals(this.migrationStatus, other.migrationStatus);
    }
}
