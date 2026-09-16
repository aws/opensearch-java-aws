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

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nullable;
import software.amazon.awssdk.opensearch.client.ApiClient;
import software.amazon.awssdk.opensearch.client.errors.OpenSearchException;
import software.amazon.awssdk.opensearch.client.transport.OpenSearchTransport;
import software.amazon.awssdk.opensearch.client.transport.TransportOptions;
import software.amazon.awssdk.opensearch.client.util.ObjectBuilder;

/**
 * Client for the ultrawarm namespace.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class OpenSearchUltrawarmAsyncClient extends ApiClient<OpenSearchTransport, OpenSearchUltrawarmAsyncClient> {
    public OpenSearchUltrawarmAsyncClient(OpenSearchTransport transport) {
        super(transport, null);
    }

    public OpenSearchUltrawarmAsyncClient(OpenSearchTransport transport, @Nullable TransportOptions transportOptions) {
        super(transport, transportOptions);
    }

    @Override
    public OpenSearchUltrawarmAsyncClient withTransportOptions(@Nullable TransportOptions transportOptions) {
        return new OpenSearchUltrawarmAsyncClient(this.transport, transportOptions);
    }

    // ----- Endpoint: ultrawarm.cancel_migration

    /**
     * <p>
     * AOS only. Cancels an in-progress UltraWarm index migration. Only one index can be cancelled per request.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>7.1</code>
     * </p>
     */
    public CompletableFuture<CancelMigrationResponse> cancelMigration(CancelMigrationRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, CancelMigrationRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * AOS only. Cancels an in-progress UltraWarm index migration. Only one index can be cancelled per request.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>7.1</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link CancelMigrationRequest}
     */
    public final CompletableFuture<CancelMigrationResponse> cancelMigration(
        Function<CancelMigrationRequest.Builder, ObjectBuilder<CancelMigrationRequest>> fn
    ) throws IOException, OpenSearchException {
        return cancelMigration(fn.apply(new CancelMigrationRequest.Builder()).build());
    }

    // ----- Endpoint: ultrawarm.get_migration_status

    /**
     * <p>
     * AOS only. Returns the migration status for a specific index. Returns HTTP 400 when no migration is currently active for the index.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>7.1</code>
     * </p>
     */
    public CompletableFuture<GetMigrationStatusResponse> getMigrationStatus(GetMigrationStatusRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, GetMigrationStatusRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * AOS only. Returns the migration status for a specific index. Returns HTTP 400 when no migration is currently active for the index.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>7.1</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link GetMigrationStatusRequest}
     */
    public final CompletableFuture<GetMigrationStatusResponse> getMigrationStatus(
        Function<GetMigrationStatusRequest.Builder, ObjectBuilder<GetMigrationStatusRequest>> fn
    ) throws IOException, OpenSearchException {
        return getMigrationStatus(fn.apply(new GetMigrationStatusRequest.Builder()).build());
    }

    // ----- Endpoint: ultrawarm.list_migration_status

    /**
     * <p>
     * AOS only. Returns the migration status for all indices currently undergoing UltraWarm migration. Equivalent to /_cat/ultrawarm but
     * returns JSON.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>7.1</code>
     * </p>
     */
    public CompletableFuture<ListMigrationStatusResponse> listMigrationStatus(ListMigrationStatusRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, ListMigrationStatusRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * AOS only. Returns the migration status for all indices currently undergoing UltraWarm migration. Equivalent to /_cat/ultrawarm but
     * returns JSON.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>7.1</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link ListMigrationStatusRequest}
     */
    public final CompletableFuture<ListMigrationStatusResponse> listMigrationStatus(
        Function<ListMigrationStatusRequest.Builder, ObjectBuilder<ListMigrationStatusRequest>> fn
    ) throws IOException, OpenSearchException {
        return listMigrationStatus(fn.apply(new ListMigrationStatusRequest.Builder()).build());
    }

    /**
     * <p>
     * AOS only. Returns the migration status for all indices currently undergoing UltraWarm migration. Equivalent to /_cat/ultrawarm but
     * returns JSON.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>7.1</code>
     * </p>
     */
    public final CompletableFuture<ListMigrationStatusResponse> listMigrationStatus() throws IOException, OpenSearchException {
        return listMigrationStatus(new ListMigrationStatusRequest.Builder().build());
    }

    // ----- Endpoint: ultrawarm.migrate_to_cold

    /**
     * <p>
     * AOS only. Migrates an index from UltraWarm (warm) storage to Cold storage. The operation is asynchronous.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>7.10</code>
     * </p>
     */
    public CompletableFuture<MigrateToColdResponse> migrateToCold(MigrateToColdRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, MigrateToColdRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * AOS only. Migrates an index from UltraWarm (warm) storage to Cold storage. The operation is asynchronous.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>7.10</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link MigrateToColdRequest}
     */
    public final CompletableFuture<MigrateToColdResponse> migrateToCold(
        Function<MigrateToColdRequest.Builder, ObjectBuilder<MigrateToColdRequest>> fn
    ) throws IOException, OpenSearchException {
        return migrateToCold(fn.apply(new MigrateToColdRequest.Builder()).build());
    }

    // ----- Endpoint: ultrawarm.migrate_to_hot

    /**
     * <p>
     * AOS only. Migrates an index from UltraWarm (warm) storage back to hot storage. The operation is asynchronous.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>7.1</code>
     * </p>
     */
    public CompletableFuture<MigrateToHotResponse> migrateToHot(MigrateToHotRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, MigrateToHotRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * AOS only. Migrates an index from UltraWarm (warm) storage back to hot storage. The operation is asynchronous.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>7.1</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link MigrateToHotRequest}
     */
    public final CompletableFuture<MigrateToHotResponse> migrateToHot(
        Function<MigrateToHotRequest.Builder, ObjectBuilder<MigrateToHotRequest>> fn
    ) throws IOException, OpenSearchException {
        return migrateToHot(fn.apply(new MigrateToHotRequest.Builder()).build());
    }

    // ----- Endpoint: ultrawarm.migrate_to_warm

    /**
     * <p>
     * AOS only. Migrates an index from hot storage to UltraWarm (warm) storage. The operation is asynchronous -- use GET
     * /_ultrawarm/migration/{index}/_status to poll migration progress.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>7.1</code>
     * </p>
     */
    public CompletableFuture<MigrateToWarmResponse> migrateToWarm(MigrateToWarmRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, MigrateToWarmRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * AOS only. Migrates an index from hot storage to UltraWarm (warm) storage. The operation is asynchronous -- use GET
     * /_ultrawarm/migration/{index}/_status to poll migration progress.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>7.1</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link MigrateToWarmRequest}
     */
    public final CompletableFuture<MigrateToWarmResponse> migrateToWarm(
        Function<MigrateToWarmRequest.Builder, ObjectBuilder<MigrateToWarmRequest>> fn
    ) throws IOException, OpenSearchException {
        return migrateToWarm(fn.apply(new MigrateToWarmRequest.Builder()).build());
    }

    // ----- Endpoint: ultrawarm.update_migration

    /**
     * <p>
     * AOS only. Updates the configuration of an in-progress UltraWarm migration.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>7.1</code>
     * </p>
     */
    public CompletableFuture<UpdateMigrationResponse> updateMigration(UpdateMigrationRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, UpdateMigrationRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * AOS only. Updates the configuration of an in-progress UltraWarm migration.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>7.1</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link UpdateMigrationRequest}
     */
    public final CompletableFuture<UpdateMigrationResponse> updateMigration(
        Function<UpdateMigrationRequest.Builder, ObjectBuilder<UpdateMigrationRequest>> fn
    ) throws IOException, OpenSearchException {
        return updateMigration(fn.apply(new UpdateMigrationRequest.Builder()).build());
    }
}
