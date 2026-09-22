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
@Generated("software.amazon.awssdk.opensearch.client.codegen.CodeGenerator")
public class OpenSearchUltrawarmClient extends ApiClient<OpenSearchTransport, OpenSearchUltrawarmClient> {
    public OpenSearchUltrawarmClient(OpenSearchTransport transport) {
        super(transport, null);
    }

    public OpenSearchUltrawarmClient(OpenSearchTransport transport, @Nullable TransportOptions transportOptions) {
        super(transport, transportOptions);
    }

    @Override
    public OpenSearchUltrawarmClient withTransportOptions(@Nullable TransportOptions transportOptions) {
        return new OpenSearchUltrawarmClient(this.transport, transportOptions);
    }

    // ----- Endpoint: ultrawarm.cancel_migration

    /**
     * AOS only. Cancels an in-progress UltraWarm index migration. Only one index can be cancelled per request.
     */
    public CancelMigrationResponse cancelMigration(CancelMigrationRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, CancelMigrationRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * AOS only. Cancels an in-progress UltraWarm index migration. Only one index can be cancelled per request.
     *
     * @param fn a function that initializes a builder to create the {@link CancelMigrationRequest}
     */
    public final CancelMigrationResponse cancelMigration(Function<CancelMigrationRequest.Builder, ObjectBuilder<CancelMigrationRequest>> fn)
        throws IOException, OpenSearchException {
        return cancelMigration(fn.apply(new CancelMigrationRequest.Builder()).build());
    }

    // ----- Endpoint: ultrawarm.get_migration_status

    /**
     * AOS only. Returns the migration status for a specific index. Returns HTTP 400 when no migration is currently active for the index.
     */
    public GetMigrationStatusResponse getMigrationStatus(GetMigrationStatusRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetMigrationStatusRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * AOS only. Returns the migration status for a specific index. Returns HTTP 400 when no migration is currently active for the index.
     *
     * @param fn a function that initializes a builder to create the {@link GetMigrationStatusRequest}
     */
    public final GetMigrationStatusResponse getMigrationStatus(
        Function<GetMigrationStatusRequest.Builder, ObjectBuilder<GetMigrationStatusRequest>> fn
    ) throws IOException, OpenSearchException {
        return getMigrationStatus(fn.apply(new GetMigrationStatusRequest.Builder()).build());
    }

    // ----- Endpoint: ultrawarm.list_migration_status

    /**
     * AOS only. Returns the migration status for all indices currently undergoing UltraWarm migration. Equivalent to /_cat/ultrawarm but
     * returns JSON.
     */
    public ListMigrationStatusResponse listMigrationStatus(ListMigrationStatusRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, ListMigrationStatusRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * AOS only. Returns the migration status for all indices currently undergoing UltraWarm migration. Equivalent to /_cat/ultrawarm but
     * returns JSON.
     *
     * @param fn a function that initializes a builder to create the {@link ListMigrationStatusRequest}
     */
    public final ListMigrationStatusResponse listMigrationStatus(
        Function<ListMigrationStatusRequest.Builder, ObjectBuilder<ListMigrationStatusRequest>> fn
    ) throws IOException, OpenSearchException {
        return listMigrationStatus(fn.apply(new ListMigrationStatusRequest.Builder()).build());
    }

    /**
     * AOS only. Returns the migration status for all indices currently undergoing UltraWarm migration. Equivalent to /_cat/ultrawarm but
     * returns JSON.
     */
    public final ListMigrationStatusResponse listMigrationStatus() throws IOException, OpenSearchException {
        return listMigrationStatus(new ListMigrationStatusRequest.Builder().build());
    }

    // ----- Endpoint: ultrawarm.migrate_to_cold

    /**
     * AOS only. Migrates an index from UltraWarm (warm) storage to Cold storage. The operation is asynchronous.
     */
    public MigrateToColdResponse migrateToCold(MigrateToColdRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, MigrateToColdRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * AOS only. Migrates an index from UltraWarm (warm) storage to Cold storage. The operation is asynchronous.
     *
     * @param fn a function that initializes a builder to create the {@link MigrateToColdRequest}
     */
    public final MigrateToColdResponse migrateToCold(Function<MigrateToColdRequest.Builder, ObjectBuilder<MigrateToColdRequest>> fn)
        throws IOException, OpenSearchException {
        return migrateToCold(fn.apply(new MigrateToColdRequest.Builder()).build());
    }

    // ----- Endpoint: ultrawarm.migrate_to_hot

    /**
     * AOS only. Migrates an index from UltraWarm (warm) storage back to hot storage. The operation is asynchronous.
     */
    public MigrateToHotResponse migrateToHot(MigrateToHotRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, MigrateToHotRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * AOS only. Migrates an index from UltraWarm (warm) storage back to hot storage. The operation is asynchronous.
     *
     * @param fn a function that initializes a builder to create the {@link MigrateToHotRequest}
     */
    public final MigrateToHotResponse migrateToHot(Function<MigrateToHotRequest.Builder, ObjectBuilder<MigrateToHotRequest>> fn)
        throws IOException, OpenSearchException {
        return migrateToHot(fn.apply(new MigrateToHotRequest.Builder()).build());
    }

    // ----- Endpoint: ultrawarm.migrate_to_warm

    /**
     * AOS only. Migrates an index from hot storage to UltraWarm (warm) storage. The operation is asynchronous -- use GET
     * /_ultrawarm/migration/{index}/_status to poll migration progress.
     */
    public MigrateToWarmResponse migrateToWarm(MigrateToWarmRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, MigrateToWarmRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * AOS only. Migrates an index from hot storage to UltraWarm (warm) storage. The operation is asynchronous -- use GET
     * /_ultrawarm/migration/{index}/_status to poll migration progress.
     *
     * @param fn a function that initializes a builder to create the {@link MigrateToWarmRequest}
     */
    public final MigrateToWarmResponse migrateToWarm(Function<MigrateToWarmRequest.Builder, ObjectBuilder<MigrateToWarmRequest>> fn)
        throws IOException, OpenSearchException {
        return migrateToWarm(fn.apply(new MigrateToWarmRequest.Builder()).build());
    }

    // ----- Endpoint: ultrawarm.update_migration

    /**
     * AOS only. Updates the configuration of an in-progress UltraWarm migration.
     */
    public UpdateMigrationResponse updateMigration(UpdateMigrationRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, UpdateMigrationRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * AOS only. Updates the configuration of an in-progress UltraWarm migration.
     *
     * @param fn a function that initializes a builder to create the {@link UpdateMigrationRequest}
     */
    public final UpdateMigrationResponse updateMigration(Function<UpdateMigrationRequest.Builder, ObjectBuilder<UpdateMigrationRequest>> fn)
        throws IOException, OpenSearchException {
        return updateMigration(fn.apply(new UpdateMigrationRequest.Builder()).build());
    }
}
