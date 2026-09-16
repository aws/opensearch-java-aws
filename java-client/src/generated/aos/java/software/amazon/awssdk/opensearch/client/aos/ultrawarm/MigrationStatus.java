/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
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

// typedef: ultrawarm.MigrationStatus

/**
 * Migration status for a single index.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class MigrationStatus implements PlainJsonSerializable, ToCopyableBuilder<MigrationStatus.Builder, MigrationStatus> {

    @Nullable
    private final String failureReason;

    @Nullable
    private final String index;

    @Nullable
    private final String migrationType;

    @Nullable
    private final ShardLevelStatus shardLevelStatus;

    @Nullable
    private final String state;

    // ---------------------------------------------------------------------------------------------

    private MigrationStatus(Builder builder) {
        this.failureReason = builder.failureReason;
        this.index = builder.index;
        this.migrationType = builder.migrationType;
        this.shardLevelStatus = builder.shardLevelStatus;
        this.state = builder.state;
    }

    public static MigrationStatus of(Function<MigrationStatus.Builder, ObjectBuilder<MigrationStatus>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Reason for failure when state begins with FAILED.
     * <p>
     * API name: {@code failure_reason}
     * </p>
     */
    @Nullable
    public final String failureReason() {
        return this.failureReason;
    }

    /**
     * The index name.
     * <p>
     * API name: {@code index}
     * </p>
     */
    @Nullable
    public final String index() {
        return this.index;
    }

    /**
     * Migration direction.
     * <p>
     * API name: {@code migration_type}
     * </p>
     */
    @Nullable
    public final String migrationType() {
        return this.migrationType;
    }

    /**
     * API name: {@code shard_level_status}
     */
    @Nullable
    public final ShardLevelStatus shardLevelStatus() {
        return this.shardLevelStatus;
    }

    /**
     * Current migration state. Values include: PENDING_FORCE_MERGE, RUNNING_FORCE_MERGE, PENDING_FULL_SNAPSHOT, RUNNING_FULL_SNAPSHOT,
     * FINISHED_SHARD_RELOCATION, FAILED, FAILED_*.
     * <p>
     * API name: {@code state}
     * </p>
     */
    @Nullable
    public final String state() {
        return this.state;
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
        if (this.failureReason != null) {
            generator.writeKey("failure_reason");
            generator.write(this.failureReason);
        }

        if (this.index != null) {
            generator.writeKey("index");
            generator.write(this.index);
        }

        if (this.migrationType != null) {
            generator.writeKey("migration_type");
            generator.write(this.migrationType);
        }

        if (this.shardLevelStatus != null) {
            generator.writeKey("shard_level_status");
            this.shardLevelStatus.serialize(generator, mapper);
        }

        if (this.state != null) {
            generator.writeKey("state");
            generator.write(this.state);
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
     * Builder for {@link MigrationStatus}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, MigrationStatus> {
        @Nullable
        private String failureReason;
        @Nullable
        private String index;
        @Nullable
        private String migrationType;
        @Nullable
        private ShardLevelStatus shardLevelStatus;
        @Nullable
        private String state;

        public Builder() {}

        private Builder(MigrationStatus o) {
            this.failureReason = o.failureReason;
            this.index = o.index;
            this.migrationType = o.migrationType;
            this.shardLevelStatus = o.shardLevelStatus;
            this.state = o.state;
        }

        private Builder(Builder o) {
            this.failureReason = o.failureReason;
            this.index = o.index;
            this.migrationType = o.migrationType;
            this.shardLevelStatus = o.shardLevelStatus;
            this.state = o.state;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Reason for failure when state begins with FAILED.
         * <p>
         * API name: {@code failure_reason}
         * </p>
         */
        @Nonnull
        public final Builder failureReason(@Nullable String value) {
            this.failureReason = value;
            return this;
        }

        /**
         * The index name.
         * <p>
         * API name: {@code index}
         * </p>
         */
        @Nonnull
        public final Builder index(@Nullable String value) {
            this.index = value;
            return this;
        }

        /**
         * Migration direction.
         * <p>
         * API name: {@code migration_type}
         * </p>
         */
        @Nonnull
        public final Builder migrationType(@Nullable String value) {
            this.migrationType = value;
            return this;
        }

        /**
         * API name: {@code shard_level_status}
         */
        @Nonnull
        public final Builder shardLevelStatus(@Nullable ShardLevelStatus value) {
            this.shardLevelStatus = value;
            return this;
        }

        /**
         * API name: {@code shard_level_status}
         */
        @Nonnull
        public final Builder shardLevelStatus(Function<ShardLevelStatus.Builder, ObjectBuilder<ShardLevelStatus>> fn) {
            return shardLevelStatus(fn.apply(new ShardLevelStatus.Builder()).build());
        }

        /**
         * Current migration state. Values include: PENDING_FORCE_MERGE, RUNNING_FORCE_MERGE, PENDING_FULL_SNAPSHOT, RUNNING_FULL_SNAPSHOT,
         * FINISHED_SHARD_RELOCATION, FAILED, FAILED_*.
         * <p>
         * API name: {@code state}
         * </p>
         */
        @Nonnull
        public final Builder state(@Nullable String value) {
            this.state = value;
            return this;
        }

        /**
         * Builds a {@link MigrationStatus}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public MigrationStatus build() {
            _checkSingleUse();

            return new MigrationStatus(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link MigrationStatus}
     */
    public static final JsonpDeserializer<MigrationStatus> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        MigrationStatus::setupMigrationStatusDeserializer
    );

    protected static void setupMigrationStatusDeserializer(ObjectDeserializer<MigrationStatus.Builder> op) {
        op.add(Builder::failureReason, JsonpDeserializer.stringDeserializer(), "failure_reason");
        op.add(Builder::index, JsonpDeserializer.stringDeserializer(), "index");
        op.add(Builder::migrationType, JsonpDeserializer.stringDeserializer(), "migration_type");
        op.add(Builder::shardLevelStatus, ShardLevelStatus._DESERIALIZER, "shard_level_status");
        op.add(Builder::state, JsonpDeserializer.stringDeserializer(), "state");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.failureReason);
        result = 31 * result + Objects.hashCode(this.index);
        result = 31 * result + Objects.hashCode(this.migrationType);
        result = 31 * result + Objects.hashCode(this.shardLevelStatus);
        result = 31 * result + Objects.hashCode(this.state);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        MigrationStatus other = (MigrationStatus) o;
        return Objects.equals(this.failureReason, other.failureReason)
            && Objects.equals(this.index, other.index)
            && Objects.equals(this.migrationType, other.migrationType)
            && Objects.equals(this.shardLevelStatus, other.shardLevelStatus)
            && Objects.equals(this.state, other.state);
    }
}
