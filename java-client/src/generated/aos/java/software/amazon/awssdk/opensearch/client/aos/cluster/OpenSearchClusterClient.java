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

package software.amazon.awssdk.opensearch.client.aos.cluster;

import java.io.IOException;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nullable;
import software.amazon.awssdk.opensearch.client.ApiClient;
import software.amazon.awssdk.opensearch.client.errors.OpenSearchException;
import software.amazon.awssdk.opensearch.client.transport.OpenSearchTransport;
import software.amazon.awssdk.opensearch.client.transport.TransportOptions;
import software.amazon.awssdk.opensearch.client.transport.endpoints.BooleanResponse;
import software.amazon.awssdk.opensearch.client.util.ObjectBuilder;

/**
 * Client for the cluster namespace.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class OpenSearchClusterClient extends ApiClient<OpenSearchTransport, OpenSearchClusterClient> {
    public OpenSearchClusterClient(OpenSearchTransport transport) {
        super(transport, null);
    }

    public OpenSearchClusterClient(OpenSearchTransport transport, @Nullable TransportOptions transportOptions) {
        super(transport, transportOptions);
    }

    @Override
    public OpenSearchClusterClient withTransportOptions(@Nullable TransportOptions transportOptions) {
        return new OpenSearchClusterClient(this.transport, transportOptions);
    }

    // ----- Endpoint: cluster.allocation_explain

    /**
     * <p>
     * Explains how shards are allocated in the current cluster and provides an explanation for why unassigned shards can't be allocated to
     * a node.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public AllocationExplainResponse allocationExplain(AllocationExplainRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, AllocationExplainRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Explains how shards are allocated in the current cluster and provides an explanation for why unassigned shards can't be allocated to
     * a node.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link AllocationExplainRequest}
     */
    public final AllocationExplainResponse allocationExplain(
        Function<AllocationExplainRequest.Builder, ObjectBuilder<AllocationExplainRequest>> fn
    ) throws IOException, OpenSearchException {
        return allocationExplain(fn.apply(new AllocationExplainRequest.Builder()).build());
    }

    /**
     * <p>
     * Explains how shards are allocated in the current cluster and provides an explanation for why unassigned shards can't be allocated to
     * a node.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public final AllocationExplainResponse allocationExplain() throws IOException, OpenSearchException {
        return allocationExplain(new AllocationExplainRequest.Builder().build());
    }

    // ----- Endpoint: cluster.delete_component_template

    /**
     * <p>
     * Deletes a component template.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public DeleteComponentTemplateResponse deleteComponentTemplate(DeleteComponentTemplateRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequest(request, DeleteComponentTemplateRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Deletes a component template.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link DeleteComponentTemplateRequest}
     */
    public final DeleteComponentTemplateResponse deleteComponentTemplate(
        Function<DeleteComponentTemplateRequest.Builder, ObjectBuilder<DeleteComponentTemplateRequest>> fn
    ) throws IOException, OpenSearchException {
        return deleteComponentTemplate(fn.apply(new DeleteComponentTemplateRequest.Builder()).build());
    }

    // ----- Endpoint: cluster.exists_component_template

    /**
     * <p>
     * Returns information about whether a particular component template exist.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public BooleanResponse existsComponentTemplate(ExistsComponentTemplateRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, ExistsComponentTemplateRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Returns information about whether a particular component template exist.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link ExistsComponentTemplateRequest}
     */
    public final BooleanResponse existsComponentTemplate(
        Function<ExistsComponentTemplateRequest.Builder, ObjectBuilder<ExistsComponentTemplateRequest>> fn
    ) throws IOException, OpenSearchException {
        return existsComponentTemplate(fn.apply(new ExistsComponentTemplateRequest.Builder()).build());
    }

    // ----- Endpoint: cluster.get_component_template

    /**
     * <p>
     * Returns one or more component templates.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public GetComponentTemplateResponse getComponentTemplate(GetComponentTemplateRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetComponentTemplateRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Returns one or more component templates.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link GetComponentTemplateRequest}
     */
    public final GetComponentTemplateResponse getComponentTemplate(
        Function<GetComponentTemplateRequest.Builder, ObjectBuilder<GetComponentTemplateRequest>> fn
    ) throws IOException, OpenSearchException {
        return getComponentTemplate(fn.apply(new GetComponentTemplateRequest.Builder()).build());
    }

    /**
     * <p>
     * Returns one or more component templates.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public final GetComponentTemplateResponse getComponentTemplate() throws IOException, OpenSearchException {
        return getComponentTemplate(new GetComponentTemplateRequest.Builder().build());
    }

    // ----- Endpoint: cluster.get_settings

    /**
     * <p>
     * Returns cluster settings.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public GetClusterSettingsResponse getSettings(GetClusterSettingsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetClusterSettingsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Returns cluster settings.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link GetClusterSettingsRequest}
     */
    public final GetClusterSettingsResponse getSettings(
        Function<GetClusterSettingsRequest.Builder, ObjectBuilder<GetClusterSettingsRequest>> fn
    ) throws IOException, OpenSearchException {
        return getSettings(fn.apply(new GetClusterSettingsRequest.Builder()).build());
    }

    /**
     * <p>
     * Returns cluster settings.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public final GetClusterSettingsResponse getSettings() throws IOException, OpenSearchException {
        return getSettings(new GetClusterSettingsRequest.Builder().build());
    }

    // ----- Endpoint: cluster.health

    /**
     * <p>
     * Returns basic information about the health of the cluster.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public HealthResponse health(HealthRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, HealthRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Returns basic information about the health of the cluster.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link HealthRequest}
     */
    public final HealthResponse health(Function<HealthRequest.Builder, ObjectBuilder<HealthRequest>> fn) throws IOException,
        OpenSearchException {
        return health(fn.apply(new HealthRequest.Builder()).build());
    }

    /**
     * <p>
     * Returns basic information about the health of the cluster.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public final HealthResponse health() throws IOException, OpenSearchException {
        return health(new HealthRequest.Builder().build());
    }

    // ----- Endpoint: cluster.pending_tasks

    /**
     * <p>
     * Returns a list of pending cluster-level tasks, such as index creation, mapping updates, or new allocations.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public PendingTasksResponse pendingTasks(PendingTasksRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, PendingTasksRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Returns a list of pending cluster-level tasks, such as index creation, mapping updates, or new allocations.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link PendingTasksRequest}
     */
    public final PendingTasksResponse pendingTasks(Function<PendingTasksRequest.Builder, ObjectBuilder<PendingTasksRequest>> fn)
        throws IOException, OpenSearchException {
        return pendingTasks(fn.apply(new PendingTasksRequest.Builder()).build());
    }

    /**
     * <p>
     * Returns a list of pending cluster-level tasks, such as index creation, mapping updates, or new allocations.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public final PendingTasksResponse pendingTasks() throws IOException, OpenSearchException {
        return pendingTasks(new PendingTasksRequest.Builder().build());
    }

    // ----- Endpoint: cluster.put_component_template

    /**
     * <p>
     * Creates or updates a component template.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public PutComponentTemplateResponse putComponentTemplate(PutComponentTemplateRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, PutComponentTemplateRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Creates or updates a component template.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link PutComponentTemplateRequest}
     */
    public final PutComponentTemplateResponse putComponentTemplate(
        Function<PutComponentTemplateRequest.Builder, ObjectBuilder<PutComponentTemplateRequest>> fn
    ) throws IOException, OpenSearchException {
        return putComponentTemplate(fn.apply(new PutComponentTemplateRequest.Builder()).build());
    }

    // ----- Endpoint: cluster.put_settings

    /**
     * <p>
     * Updates the cluster settings.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public PutClusterSettingsResponse putSettings(PutClusterSettingsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, PutClusterSettingsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Updates the cluster settings.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link PutClusterSettingsRequest}
     */
    public final PutClusterSettingsResponse putSettings(
        Function<PutClusterSettingsRequest.Builder, ObjectBuilder<PutClusterSettingsRequest>> fn
    ) throws IOException, OpenSearchException {
        return putSettings(fn.apply(new PutClusterSettingsRequest.Builder()).build());
    }

    /**
     * <p>
     * Updates the cluster settings.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public final PutClusterSettingsResponse putSettings() throws IOException, OpenSearchException {
        return putSettings(new PutClusterSettingsRequest.Builder().build());
    }

    // ----- Endpoint: cluster.remote_info

    /**
     * <p>
     * Returns the information about configured remote clusters.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public RemoteInfoResponse remoteInfo(RemoteInfoRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, RemoteInfoRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Returns the information about configured remote clusters.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link RemoteInfoRequest}
     */
    public final RemoteInfoResponse remoteInfo(Function<RemoteInfoRequest.Builder, ObjectBuilder<RemoteInfoRequest>> fn) throws IOException,
        OpenSearchException {
        return remoteInfo(fn.apply(new RemoteInfoRequest.Builder()).build());
    }

    /**
     * <p>
     * Returns the information about configured remote clusters.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public final RemoteInfoResponse remoteInfo() throws IOException, OpenSearchException {
        return remoteInfo(new RemoteInfoRequest.Builder().build());
    }

    // ----- Endpoint: cluster.state

    /**
     * <p>
     * Returns comprehensive information about the state of the cluster.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public StateResponse state(StateRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, StateRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Returns comprehensive information about the state of the cluster.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link StateRequest}
     */
    public final StateResponse state(Function<StateRequest.Builder, ObjectBuilder<StateRequest>> fn) throws IOException,
        OpenSearchException {
        return state(fn.apply(new StateRequest.Builder()).build());
    }

    /**
     * <p>
     * Returns comprehensive information about the state of the cluster.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public final StateResponse state() throws IOException, OpenSearchException {
        return state(new StateRequest.Builder().build());
    }

    // ----- Endpoint: cluster.stats

    /**
     * <p>
     * Returns a high-level overview of cluster statistics.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public ClusterStatsResponse stats(ClusterStatsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, ClusterStatsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Returns a high-level overview of cluster statistics.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link ClusterStatsRequest}
     */
    public final ClusterStatsResponse stats(Function<ClusterStatsRequest.Builder, ObjectBuilder<ClusterStatsRequest>> fn)
        throws IOException, OpenSearchException {
        return stats(fn.apply(new ClusterStatsRequest.Builder()).build());
    }

    /**
     * <p>
     * Returns a high-level overview of cluster statistics.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public final ClusterStatsResponse stats() throws IOException, OpenSearchException {
        return stats(new ClusterStatsRequest.Builder().build());
    }
}
