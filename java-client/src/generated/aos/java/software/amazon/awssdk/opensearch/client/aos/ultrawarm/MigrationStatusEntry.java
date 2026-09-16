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

// typedef: ultrawarm.MigrationStatusEntry

/**
 * A single entry in the cluster-wide migration status list.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class MigrationStatusEntry implements PlainJsonSerializable, ToCopyableBuilder<MigrationStatusEntry.Builder, MigrationStatusEntry> {

    @Nullable
    private final String index;

    @Nullable
    private final String migrationType;

    @Nullable
    private final String state;

    // ---------------------------------------------------------------------------------------------

    private MigrationStatusEntry(Builder builder) {
        this.index = builder.index;
        this.migrationType = builder.migrationType;
        this.state = builder.state;
    }

    public static MigrationStatusEntry of(Function<MigrationStatusEntry.Builder, ObjectBuilder<MigrationStatusEntry>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Index name.
     * <p>
     * API name: {@code index}
     * </p>
     */
    @Nullable
    public final String index() {
        return this.index;
    }

    /**
     * Migration direction (HOT_TO_WARM, WARM_TO_HOT, WARM_TO_COLD).
     * <p>
     * API name: {@code migration_type}
     * </p>
     */
    @Nullable
    public final String migrationType() {
        return this.migrationType;
    }

    /**
     * Current migration state.
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
        if (this.index != null) {
            generator.writeKey("index");
            generator.write(this.index);
        }

        if (this.migrationType != null) {
            generator.writeKey("migration_type");
            generator.write(this.migrationType);
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
     * Builder for {@link MigrationStatusEntry}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, MigrationStatusEntry> {
        @Nullable
        private String index;
        @Nullable
        private String migrationType;
        @Nullable
        private String state;

        public Builder() {}

        private Builder(MigrationStatusEntry o) {
            this.index = o.index;
            this.migrationType = o.migrationType;
            this.state = o.state;
        }

        private Builder(Builder o) {
            this.index = o.index;
            this.migrationType = o.migrationType;
            this.state = o.state;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Index name.
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
         * Migration direction (HOT_TO_WARM, WARM_TO_HOT, WARM_TO_COLD).
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
         * Current migration state.
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
         * Builds a {@link MigrationStatusEntry}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public MigrationStatusEntry build() {
            _checkSingleUse();

            return new MigrationStatusEntry(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link MigrationStatusEntry}
     */
    public static final JsonpDeserializer<MigrationStatusEntry> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        MigrationStatusEntry::setupMigrationStatusEntryDeserializer
    );

    protected static void setupMigrationStatusEntryDeserializer(ObjectDeserializer<MigrationStatusEntry.Builder> op) {
        op.add(Builder::index, JsonpDeserializer.stringDeserializer(), "index");
        op.add(Builder::migrationType, JsonpDeserializer.stringDeserializer(), "migration_type");
        op.add(Builder::state, JsonpDeserializer.stringDeserializer(), "state");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.index);
        result = 31 * result + Objects.hashCode(this.migrationType);
        result = 31 * result + Objects.hashCode(this.state);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        MigrationStatusEntry other = (MigrationStatusEntry) o;
        return Objects.equals(this.index, other.index)
            && Objects.equals(this.migrationType, other.migrationType)
            && Objects.equals(this.state, other.state);
    }
}
