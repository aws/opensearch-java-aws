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

package software.amazon.awssdk.opensearch.client.aos.cat;

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
 * Client for the cat namespace.
 */
@Generated("software.amazon.awssdk.opensearch.client.codegen.CodeGenerator")
public abstract class OpenSearchCatClientBase<Self extends OpenSearchCatClientBase<Self>> extends ApiClient<OpenSearchTransport, Self> {
    public OpenSearchCatClientBase(OpenSearchTransport transport, @Nullable TransportOptions transportOptions) {
        super(transport, transportOptions);
    }

    // ----- Endpoint: cat.aliases

    /**
     * <p>
     * Shows information about aliases currently configured to indexes, including filter and routing information.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public AliasesResponse aliases(AliasesRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, AliasesRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Shows information about aliases currently configured to indexes, including filter and routing information.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link AliasesRequest}
     */
    public final AliasesResponse aliases(Function<AliasesRequest.Builder, ObjectBuilder<AliasesRequest>> fn) throws IOException,
        OpenSearchException {
        return aliases(fn.apply(new AliasesRequest.Builder()).build());
    }

    /**
     * <p>
     * Shows information about aliases currently configured to indexes, including filter and routing information.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public final AliasesResponse aliases() throws IOException, OpenSearchException {
        return aliases(new AliasesRequest.Builder().build());
    }

    // ----- Endpoint: cat.all_pit_segments

    /**
     * <p>
     * Lists all active CAT point-in-time segments.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.4</code>
     * </p>
     */
    public AllPitSegmentsResponse allPitSegments(AllPitSegmentsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, AllPitSegmentsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Lists all active CAT point-in-time segments.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.4</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link AllPitSegmentsRequest}
     */
    public final AllPitSegmentsResponse allPitSegments(Function<AllPitSegmentsRequest.Builder, ObjectBuilder<AllPitSegmentsRequest>> fn)
        throws IOException, OpenSearchException {
        return allPitSegments(fn.apply(new AllPitSegmentsRequest.Builder()).build());
    }

    /**
     * <p>
     * Lists all active CAT point-in-time segments.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.4</code>
     * </p>
     */
    public final AllPitSegmentsResponse allPitSegments() throws IOException, OpenSearchException {
        return allPitSegments(new AllPitSegmentsRequest.Builder().build());
    }

    // ----- Endpoint: cat.allocation

    /**
     * <p>
     * Provides a snapshot of how many shards are allocated to each data node and how much disk space they are using.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public AllocationResponse allocation(AllocationRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, AllocationRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Provides a snapshot of how many shards are allocated to each data node and how much disk space they are using.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link AllocationRequest}
     */
    public final AllocationResponse allocation(Function<AllocationRequest.Builder, ObjectBuilder<AllocationRequest>> fn) throws IOException,
        OpenSearchException {
        return allocation(fn.apply(new AllocationRequest.Builder()).build());
    }

    /**
     * <p>
     * Provides a snapshot of how many shards are allocated to each data node and how much disk space they are using.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public final AllocationResponse allocation() throws IOException, OpenSearchException {
        return allocation(new AllocationRequest.Builder().build());
    }

    // ----- Endpoint: cat.cluster_manager

    /**
     * <p>
     * Returns information about the cluster-manager node.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.0</code>
     * </p>
     */
    public ClusterManagerResponse clusterManager(ClusterManagerRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, ClusterManagerRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Returns information about the cluster-manager node.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link ClusterManagerRequest}
     */
    public final ClusterManagerResponse clusterManager(Function<ClusterManagerRequest.Builder, ObjectBuilder<ClusterManagerRequest>> fn)
        throws IOException, OpenSearchException {
        return clusterManager(fn.apply(new ClusterManagerRequest.Builder()).build());
    }

    /**
     * <p>
     * Returns information about the cluster-manager node.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.0</code>
     * </p>
     */
    public final ClusterManagerResponse clusterManager() throws IOException, OpenSearchException {
        return clusterManager(new ClusterManagerRequest.Builder().build());
    }

    // ----- Endpoint: cat.count

    /**
     * <p>
     * Provides quick access to the document count of the entire cluster or of an individual index.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public CountResponse count(CountRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, CountRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Provides quick access to the document count of the entire cluster or of an individual index.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link CountRequest}
     */
    public final CountResponse count(Function<CountRequest.Builder, ObjectBuilder<CountRequest>> fn) throws IOException,
        OpenSearchException {
        return count(fn.apply(new CountRequest.Builder()).build());
    }

    /**
     * <p>
     * Provides quick access to the document count of the entire cluster or of an individual index.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public final CountResponse count() throws IOException, OpenSearchException {
        return count(new CountRequest.Builder().build());
    }

    // ----- Endpoint: cat.fielddata

    /**
     * <p>
     * Shows how much heap memory is currently being used by field data on every data node in the cluster.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public FielddataResponse fielddata(FielddataRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, FielddataRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Shows how much heap memory is currently being used by field data on every data node in the cluster.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link FielddataRequest}
     */
    public final FielddataResponse fielddata(Function<FielddataRequest.Builder, ObjectBuilder<FielddataRequest>> fn) throws IOException,
        OpenSearchException {
        return fielddata(fn.apply(new FielddataRequest.Builder()).build());
    }

    /**
     * <p>
     * Shows how much heap memory is currently being used by field data on every data node in the cluster.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public final FielddataResponse fielddata() throws IOException, OpenSearchException {
        return fielddata(new FielddataRequest.Builder().build());
    }

    // ----- Endpoint: cat.health

    /**
     * <p>
     * Returns a concise representation of the cluster health.
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
     * Returns a concise representation of the cluster health.
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
     * Returns a concise representation of the cluster health.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public final HealthResponse health() throws IOException, OpenSearchException {
        return health(new HealthRequest.Builder().build());
    }

    // ----- Endpoint: cat.indices

    /**
     * <p>
     * Lists information related to indexes, that is, how much disk space they are using, how many shards they have, their health status,
     * and so on.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public IndicesResponse indices(IndicesRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, IndicesRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Lists information related to indexes, that is, how much disk space they are using, how many shards they have, their health status,
     * and so on.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link IndicesRequest}
     */
    public final IndicesResponse indices(Function<IndicesRequest.Builder, ObjectBuilder<IndicesRequest>> fn) throws IOException,
        OpenSearchException {
        return indices(fn.apply(new IndicesRequest.Builder()).build());
    }

    /**
     * <p>
     * Lists information related to indexes, that is, how much disk space they are using, how many shards they have, their health status,
     * and so on.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public final IndicesResponse indices() throws IOException, OpenSearchException {
        return indices(new IndicesRequest.Builder().build());
    }

    // ----- Endpoint: cat.nodes

    /**
     * <p>
     * Returns basic statistics about the performance of cluster nodes.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public NodesResponse nodes(NodesRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, NodesRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Returns basic statistics about the performance of cluster nodes.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link NodesRequest}
     */
    public final NodesResponse nodes(Function<NodesRequest.Builder, ObjectBuilder<NodesRequest>> fn) throws IOException,
        OpenSearchException {
        return nodes(fn.apply(new NodesRequest.Builder()).build());
    }

    /**
     * <p>
     * Returns basic statistics about the performance of cluster nodes.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public final NodesResponse nodes() throws IOException, OpenSearchException {
        return nodes(new NodesRequest.Builder().build());
    }

    // ----- Endpoint: cat.pending_tasks

    /**
     * <p>
     * Returns a concise representation of the cluster's pending tasks.
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
     * Returns a concise representation of the cluster's pending tasks.
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
     * Returns a concise representation of the cluster's pending tasks.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public final PendingTasksResponse pendingTasks() throws IOException, OpenSearchException {
        return pendingTasks(new PendingTasksRequest.Builder().build());
    }

    // ----- Endpoint: cat.pit_segments

    /**
     * <p>
     * Lists one or several CAT point-in-time segments.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.4</code>
     * </p>
     */
    public PitSegmentsResponse pitSegments(PitSegmentsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, PitSegmentsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Lists one or several CAT point-in-time segments.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.4</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link PitSegmentsRequest}
     */
    public final PitSegmentsResponse pitSegments(Function<PitSegmentsRequest.Builder, ObjectBuilder<PitSegmentsRequest>> fn)
        throws IOException, OpenSearchException {
        return pitSegments(fn.apply(new PitSegmentsRequest.Builder()).build());
    }

    // ----- Endpoint: cat.plugins

    /**
     * <p>
     * Returns information about the names, components, and versions of the installed plugins.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public PluginsResponse plugins(PluginsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, PluginsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Returns information about the names, components, and versions of the installed plugins.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link PluginsRequest}
     */
    public final PluginsResponse plugins(Function<PluginsRequest.Builder, ObjectBuilder<PluginsRequest>> fn) throws IOException,
        OpenSearchException {
        return plugins(fn.apply(new PluginsRequest.Builder()).build());
    }

    /**
     * <p>
     * Returns information about the names, components, and versions of the installed plugins.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public final PluginsResponse plugins() throws IOException, OpenSearchException {
        return plugins(new PluginsRequest.Builder().build());
    }

    // ----- Endpoint: cat.recovery

    /**
     * <p>
     * Returns all completed and ongoing index and shard recoveries.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public RecoveryResponse recovery(RecoveryRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, RecoveryRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Returns all completed and ongoing index and shard recoveries.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link RecoveryRequest}
     */
    public final RecoveryResponse recovery(Function<RecoveryRequest.Builder, ObjectBuilder<RecoveryRequest>> fn) throws IOException,
        OpenSearchException {
        return recovery(fn.apply(new RecoveryRequest.Builder()).build());
    }

    /**
     * <p>
     * Returns all completed and ongoing index and shard recoveries.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public final RecoveryResponse recovery() throws IOException, OpenSearchException {
        return recovery(new RecoveryRequest.Builder().build());
    }

    // ----- Endpoint: cat.repositories

    /**
     * <p>
     * Returns information about all snapshot repositories for a cluster.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public RepositoriesResponse repositories(RepositoriesRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, RepositoriesRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Returns information about all snapshot repositories for a cluster.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link RepositoriesRequest}
     */
    public final RepositoriesResponse repositories(Function<RepositoriesRequest.Builder, ObjectBuilder<RepositoriesRequest>> fn)
        throws IOException, OpenSearchException {
        return repositories(fn.apply(new RepositoriesRequest.Builder()).build());
    }

    /**
     * <p>
     * Returns information about all snapshot repositories for a cluster.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public final RepositoriesResponse repositories() throws IOException, OpenSearchException {
        return repositories(new RepositoriesRequest.Builder().build());
    }

    // ----- Endpoint: cat.segment_replication

    /**
     * <p>
     * Returns information about active and last-completed segment replication events on each replica shard, including related shard-level
     * metrics. These metrics provide information about how far behind the primary shard the replicas are lagging.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.6</code>
     * </p>
     */
    public SegmentReplicationResponse segmentReplication(SegmentReplicationRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, SegmentReplicationRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Returns information about active and last-completed segment replication events on each replica shard, including related shard-level
     * metrics. These metrics provide information about how far behind the primary shard the replicas are lagging.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.6</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link SegmentReplicationRequest}
     */
    public final SegmentReplicationResponse segmentReplication(
        Function<SegmentReplicationRequest.Builder, ObjectBuilder<SegmentReplicationRequest>> fn
    ) throws IOException, OpenSearchException {
        return segmentReplication(fn.apply(new SegmentReplicationRequest.Builder()).build());
    }

    /**
     * <p>
     * Returns information about active and last-completed segment replication events on each replica shard, including related shard-level
     * metrics. These metrics provide information about how far behind the primary shard the replicas are lagging.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.6</code>
     * </p>
     */
    public final SegmentReplicationResponse segmentReplication() throws IOException, OpenSearchException {
        return segmentReplication(new SegmentReplicationRequest.Builder().build());
    }

    // ----- Endpoint: cat.segments

    /**
     * <p>
     * Provides low-level information about the segments in the shards of an index.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public SegmentsResponse segments(SegmentsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, SegmentsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Provides low-level information about the segments in the shards of an index.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link SegmentsRequest}
     */
    public final SegmentsResponse segments(Function<SegmentsRequest.Builder, ObjectBuilder<SegmentsRequest>> fn) throws IOException,
        OpenSearchException {
        return segments(fn.apply(new SegmentsRequest.Builder()).build());
    }

    /**
     * <p>
     * Provides low-level information about the segments in the shards of an index.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public final SegmentsResponse segments() throws IOException, OpenSearchException {
        return segments(new SegmentsRequest.Builder().build());
    }

    // ----- Endpoint: cat.shards

    /**
     * <p>
     * Lists the states of all primary and replica shards and how they are distributed.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public ShardsResponse shards(ShardsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, ShardsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Lists the states of all primary and replica shards and how they are distributed.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link ShardsRequest}
     */
    public final ShardsResponse shards(Function<ShardsRequest.Builder, ObjectBuilder<ShardsRequest>> fn) throws IOException,
        OpenSearchException {
        return shards(fn.apply(new ShardsRequest.Builder()).build());
    }

    /**
     * <p>
     * Lists the states of all primary and replica shards and how they are distributed.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public final ShardsResponse shards() throws IOException, OpenSearchException {
        return shards(new ShardsRequest.Builder().build());
    }

    // ----- Endpoint: cat.snapshots

    /**
     * <p>
     * Lists all of the snapshots stored in a specific repository.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public SnapshotsResponse snapshots(SnapshotsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, SnapshotsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Lists all of the snapshots stored in a specific repository.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link SnapshotsRequest}
     */
    public final SnapshotsResponse snapshots(Function<SnapshotsRequest.Builder, ObjectBuilder<SnapshotsRequest>> fn) throws IOException,
        OpenSearchException {
        return snapshots(fn.apply(new SnapshotsRequest.Builder()).build());
    }

    /**
     * <p>
     * Lists all of the snapshots stored in a specific repository.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public final SnapshotsResponse snapshots() throws IOException, OpenSearchException {
        return snapshots(new SnapshotsRequest.Builder().build());
    }

    // ----- Endpoint: cat.tasks

    /**
     * <p>
     * Lists the progress of all tasks currently running on the cluster.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public TasksResponse tasks(TasksRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, TasksRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Lists the progress of all tasks currently running on the cluster.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link TasksRequest}
     */
    public final TasksResponse tasks(Function<TasksRequest.Builder, ObjectBuilder<TasksRequest>> fn) throws IOException,
        OpenSearchException {
        return tasks(fn.apply(new TasksRequest.Builder()).build());
    }

    /**
     * <p>
     * Lists the progress of all tasks currently running on the cluster.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public final TasksResponse tasks() throws IOException, OpenSearchException {
        return tasks(new TasksRequest.Builder().build());
    }

    // ----- Endpoint: cat.templates

    /**
     * <p>
     * Lists the names, patterns, order numbers, and version numbers of index templates.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public TemplatesResponse templates(TemplatesRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, TemplatesRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Lists the names, patterns, order numbers, and version numbers of index templates.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link TemplatesRequest}
     */
    public final TemplatesResponse templates(Function<TemplatesRequest.Builder, ObjectBuilder<TemplatesRequest>> fn) throws IOException,
        OpenSearchException {
        return templates(fn.apply(new TemplatesRequest.Builder()).build());
    }

    /**
     * <p>
     * Lists the names, patterns, order numbers, and version numbers of index templates.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public final TemplatesResponse templates() throws IOException, OpenSearchException {
        return templates(new TemplatesRequest.Builder().build());
    }

    // ----- Endpoint: cat.thread_pool

    /**
     * <p>
     * Returns cluster-wide thread pool statistics per node. By default the active, queued, and rejected statistics are returned for all
     * thread pools.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public ThreadPoolResponse threadPool(ThreadPoolRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, ThreadPoolRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Returns cluster-wide thread pool statistics per node. By default the active, queued, and rejected statistics are returned for all
     * thread pools.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link ThreadPoolRequest}
     */
    public final ThreadPoolResponse threadPool(Function<ThreadPoolRequest.Builder, ObjectBuilder<ThreadPoolRequest>> fn) throws IOException,
        OpenSearchException {
        return threadPool(fn.apply(new ThreadPoolRequest.Builder()).build());
    }

    /**
     * <p>
     * Returns cluster-wide thread pool statistics per node. By default the active, queued, and rejected statistics are returned for all
     * thread pools.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public final ThreadPoolResponse threadPool() throws IOException, OpenSearchException {
        return threadPool(new ThreadPoolRequest.Builder().build());
    }
}
