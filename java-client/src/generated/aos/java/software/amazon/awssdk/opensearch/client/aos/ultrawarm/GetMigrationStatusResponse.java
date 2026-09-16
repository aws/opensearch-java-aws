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

package software.amazon.awssdk.opensearch.client.aos.ultrawarm;

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
import software.amazon.awssdk.opensearch.client.json.PlainJsonSerializable;
import software.amazon.awssdk.opensearch.client.util.CopyableBuilder;
import software.amazon.awssdk.opensearch.client.util.ObjectBuilder;
import software.amazon.awssdk.opensearch.client.util.ObjectBuilderBase;
import software.amazon.awssdk.opensearch.client.util.ToCopyableBuilder;

// typedef: ultrawarm.get_migration_status.Response

/**
 * Response from GET /_ultrawarm/migration/{index}/_status. Contains the current migration state wrapped in a migration_status object.
 */
@JsonpDeserializable
@Generated("software.amazon.awssdk.opensearch.client.codegen.CodeGenerator")
public class GetMigrationStatusResponse
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<GetMigrationStatusResponse.Builder, GetMigrationStatusResponse> {

    @Nullable
    private final MigrationStatus migrationStatus;

    // ---------------------------------------------------------------------------------------------

    private GetMigrationStatusResponse(Builder builder) {
        this.migrationStatus = builder.migrationStatus;
    }

    public static GetMigrationStatusResponse of(
        Function<GetMigrationStatusResponse.Builder, ObjectBuilder<GetMigrationStatusResponse>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code migration_status}
     */
    @Nullable
    public final MigrationStatus migrationStatus() {
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
        if (this.migrationStatus != null) {
            generator.writeKey("migration_status");
            this.migrationStatus.serialize(generator, mapper);
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
     * Builder for {@link GetMigrationStatusResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, GetMigrationStatusResponse> {
        @Nullable
        private MigrationStatus migrationStatus;

        public Builder() {}

        private Builder(GetMigrationStatusResponse o) {
            this.migrationStatus = o.migrationStatus;
        }

        private Builder(Builder o) {
            this.migrationStatus = o.migrationStatus;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code migration_status}
         */
        @Nonnull
        public final Builder migrationStatus(@Nullable MigrationStatus value) {
            this.migrationStatus = value;
            return this;
        }

        /**
         * API name: {@code migration_status}
         */
        @Nonnull
        public final Builder migrationStatus(Function<MigrationStatus.Builder, ObjectBuilder<MigrationStatus>> fn) {
            return migrationStatus(fn.apply(new MigrationStatus.Builder()).build());
        }

        /**
         * Builds a {@link GetMigrationStatusResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GetMigrationStatusResponse build() {
            _checkSingleUse();

            return new GetMigrationStatusResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link GetMigrationStatusResponse}
     */
    public static final JsonpDeserializer<GetMigrationStatusResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        GetMigrationStatusResponse::setupGetMigrationStatusResponseDeserializer
    );

    protected static void setupGetMigrationStatusResponseDeserializer(ObjectDeserializer<GetMigrationStatusResponse.Builder> op) {
        op.add(Builder::migrationStatus, MigrationStatus._DESERIALIZER, "migration_status");
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
        GetMigrationStatusResponse other = (GetMigrationStatusResponse) o;
        return Objects.equals(this.migrationStatus, other.migrationStatus);
    }
}
