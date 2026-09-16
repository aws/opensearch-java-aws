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

package software.amazon.awssdk.opensearch.client.aos.cold;

import java.io.IOException;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nullable;
import software.amazon.awssdk.opensearch.client.ApiClient;
import software.amazon.awssdk.opensearch.client.errors.ErrorResponse;
import software.amazon.awssdk.opensearch.client.errors.OpenSearchException;
import software.amazon.awssdk.opensearch.client.transport.JsonEndpoint;
import software.amazon.awssdk.opensearch.client.transport.OpenSearchTransport;
import software.amazon.awssdk.opensearch.client.transport.TransportOptions;
import software.amazon.awssdk.opensearch.client.transport.endpoints.EndpointWithResponseMapperAttr;
import software.amazon.awssdk.opensearch.client.util.ObjectBuilder;

/**
 * Client for the cold namespace.
 */
@Generated("software.amazon.awssdk.opensearch.client.codegen.CodeGenerator")
public class OpenSearchColdClient extends ApiClient<OpenSearchTransport, OpenSearchColdClient> {
    public OpenSearchColdClient(OpenSearchTransport transport) {
        super(transport, null);
    }

    public OpenSearchColdClient(OpenSearchTransport transport, @Nullable TransportOptions transportOptions) {
        super(transport, transportOptions);
    }

    @Override
    public OpenSearchColdClient withTransportOptions(@Nullable TransportOptions transportOptions) {
        return new OpenSearchColdClient(this.transport, transportOptions);
    }

    // ----- Endpoint: cold.cancel_migration

    /**
     * <p>
     * AOS only. Cancels an ongoing cold tier migration for the specified index.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public CancelMigrationResponse cancelMigration(CancelMigrationRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, CancelMigrationRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * AOS only. Cancels an ongoing cold tier migration for the specified index.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link CancelMigrationRequest}
     */
    public final CancelMigrationResponse cancelMigration(Function<CancelMigrationRequest.Builder, ObjectBuilder<CancelMigrationRequest>> fn)
        throws IOException, OpenSearchException {
        return cancelMigration(fn.apply(new CancelMigrationRequest.Builder()).build());
    }

    // ----- Endpoint: cold.catalog

    /**
     * <p>
     * AOS only. Returns the cold tier catalog listing all cold indices.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public CatalogResponse catalog(CatalogRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, CatalogRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * AOS only. Returns the cold tier catalog listing all cold indices.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link CatalogRequest}
     */
    public final CatalogResponse catalog(Function<CatalogRequest.Builder, ObjectBuilder<CatalogRequest>> fn) throws IOException,
        OpenSearchException {
        return catalog(fn.apply(new CatalogRequest.Builder()).build());
    }

    /**
     * <p>
     * AOS only. Returns the cold tier catalog listing all cold indices.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public final CatalogResponse catalog() throws IOException, OpenSearchException {
        return catalog(new CatalogRequest.Builder().build());
    }

    // ----- Endpoint: cold.get_migration_status

    /**
     * <p>
     * AOS only. Returns the cold tier migration status for a specific index.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public GetMigrationStatusResponse getMigrationStatus(GetMigrationStatusRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetMigrationStatusRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * AOS only. Returns the cold tier migration status for a specific index.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link GetMigrationStatusRequest}
     */
    public final GetMigrationStatusResponse getMigrationStatus(
        Function<GetMigrationStatusRequest.Builder, ObjectBuilder<GetMigrationStatusRequest>> fn
    ) throws IOException, OpenSearchException {
        return getMigrationStatus(fn.apply(new GetMigrationStatusRequest.Builder()).build());
    }

    // ----- Endpoint: cold.list_migration_status

    /**
     * <p>
     * AOS only. Returns the cold tier migration status for all indices.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public ListMigrationStatusResponse listMigrationStatus(ListMigrationStatusRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, ListMigrationStatusRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * AOS only. Returns the cold tier migration status for all indices.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link ListMigrationStatusRequest}
     */
    public final ListMigrationStatusResponse listMigrationStatus(
        Function<ListMigrationStatusRequest.Builder, ObjectBuilder<ListMigrationStatusRequest>> fn
    ) throws IOException, OpenSearchException {
        return listMigrationStatus(fn.apply(new ListMigrationStatusRequest.Builder()).build());
    }

    /**
     * <p>
     * AOS only. Returns the cold tier migration status for all indices.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public final ListMigrationStatusResponse listMigrationStatus() throws IOException, OpenSearchException {
        return listMigrationStatus(new ListMigrationStatusRequest.Builder().build());
    }

    // ----- Endpoint: cold.migrate_to_cold

    /**
     * <p>
     * AOS only. Migrates an index from warm storage to cold storage.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public MigrateToColdResponse migrateToCold(MigrateToColdRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, MigrateToColdRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * AOS only. Migrates an index from warm storage to cold storage.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link MigrateToColdRequest}
     */
    public final MigrateToColdResponse migrateToCold(Function<MigrateToColdRequest.Builder, ObjectBuilder<MigrateToColdRequest>> fn)
        throws IOException, OpenSearchException {
        return migrateToCold(fn.apply(new MigrateToColdRequest.Builder()).build());
    }

    // ----- Endpoint: cold.migrate_to_warm

    /**
     * <p>
     * AOS only. Migrates an index from cold storage back to warm storage.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public MigrateToWarmResponse migrateToWarm(MigrateToWarmRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, MigrateToWarmRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * AOS only. Migrates an index from cold storage back to warm storage.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link MigrateToWarmRequest}
     */
    public final MigrateToWarmResponse migrateToWarm(Function<MigrateToWarmRequest.Builder, ObjectBuilder<MigrateToWarmRequest>> fn)
        throws IOException, OpenSearchException {
        return migrateToWarm(fn.apply(new MigrateToWarmRequest.Builder()).build());
    }

    // ----- Endpoint: cold.search

    /**
     * <p>
     * AOS only. Searches data stored in cold tier indices.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public <TDocument> SearchResponse<TDocument> search(SearchRequest request, Class<TDocument> tDocumentClass) throws IOException,
        OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<SearchRequest, SearchResponse<TDocument>, ErrorResponse> endpoint = (JsonEndpoint<
            SearchRequest,
            SearchResponse<TDocument>,
            ErrorResponse>) SearchRequest._ENDPOINT;
        endpoint = new EndpointWithResponseMapperAttr<>(
            endpoint,
            "software.amazon.awssdk.opensearch.client:Deserializer:cold.search.TDocument",
            getDeserializer(tDocumentClass)
        );

        return this.transport.performRequest(request, endpoint, this.transportOptions);
    }

    /**
     * <p>
     * AOS only. Searches data stored in cold tier indices.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link SearchRequest}
     */
    public final <TDocument> SearchResponse<TDocument> search(
        Function<SearchRequest.Builder, ObjectBuilder<SearchRequest>> fn,
        Class<TDocument> tDocumentClass
    ) throws IOException, OpenSearchException {
        return search(fn.apply(new SearchRequest.Builder()).build(), tDocumentClass);
    }
}
