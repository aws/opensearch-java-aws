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

package software.amazon.awssdk.opensearch.client.aos.cat;

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
 * Client for the cat namespace.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public abstract class OpenSearchCatAsyncClientBase<Self extends OpenSearchCatAsyncClientBase<Self>> extends ApiClient<
    OpenSearchTransport,
    Self> {
    public OpenSearchCatAsyncClientBase(OpenSearchTransport transport, @Nullable TransportOptions transportOptions) {
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
    public CompletableFuture<AliasesResponse> aliases(AliasesRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, AliasesRequest._ENDPOINT, this.transportOptions);
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
    public final CompletableFuture<AliasesResponse> aliases(Function<AliasesRequest.Builder, ObjectBuilder<AliasesRequest>> fn)
        throws IOException, OpenSearchException {
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
    public final CompletableFuture<AliasesResponse> aliases() throws IOException, OpenSearchException {
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
    public CompletableFuture<AllPitSegmentsResponse> allPitSegments(AllPitSegmentsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, AllPitSegmentsRequest._ENDPOINT, this.transportOptions);
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
    public final CompletableFuture<AllPitSegmentsResponse> allPitSegments(
        Function<AllPitSegmentsRequest.Builder, ObjectBuilder<AllPitSegmentsRequest>> fn
    ) throws IOException, OpenSearchException {
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
    public final CompletableFuture<AllPitSegmentsResponse> allPitSegments() throws IOException, OpenSearchException {
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
    public CompletableFuture<AllocationResponse> allocation(AllocationRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, AllocationRequest._ENDPOINT, this.transportOptions);
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
    public final CompletableFuture<AllocationResponse> allocation(Function<AllocationRequest.Builder, ObjectBuilder<AllocationRequest>> fn)
        throws IOException, OpenSearchException {
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
    public final CompletableFuture<AllocationResponse> allocation() throws IOException, OpenSearchException {
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
    public CompletableFuture<ClusterManagerResponse> clusterManager(ClusterManagerRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, ClusterManagerRequest._ENDPOINT, this.transportOptions);
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
    public final CompletableFuture<ClusterManagerResponse> clusterManager(
        Function<ClusterManagerRequest.Builder, ObjectBuilder<ClusterManagerRequest>> fn
    ) throws IOException, OpenSearchException {
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
    public final CompletableFuture<ClusterManagerResponse> clusterManager() throws IOException, OpenSearchException {
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
    public CompletableFuture<CountResponse> count(CountRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, CountRequest._ENDPOINT, this.transportOptions);
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
    public final CompletableFuture<CountResponse> count(Function<CountRequest.Builder, ObjectBuilder<CountRequest>> fn) throws IOException,
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
    public final CompletableFuture<CountResponse> count() throws IOException, OpenSearchException {
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
    public CompletableFuture<FielddataResponse> fielddata(FielddataRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, FielddataRequest._ENDPOINT, this.transportOptions);
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
    public final CompletableFuture<FielddataResponse> fielddata(Function<FielddataRequest.Builder, ObjectBuilder<FielddataRequest>> fn)
        throws IOException, OpenSearchException {
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
    public final CompletableFuture<FielddataResponse> fielddata() throws IOException, OpenSearchException {
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
    public CompletableFuture<HealthResponse> health(HealthRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, HealthRequest._ENDPOINT, this.transportOptions);
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
    public final CompletableFuture<HealthResponse> health(Function<HealthRequest.Builder, ObjectBuilder<HealthRequest>> fn)
        throws IOException, OpenSearchException {
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
    public final CompletableFuture<HealthResponse> health() throws IOException, OpenSearchException {
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
    public CompletableFuture<IndicesResponse> indices(IndicesRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, IndicesRequest._ENDPOINT, this.transportOptions);
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
    public final CompletableFuture<IndicesResponse> indices(Function<IndicesRequest.Builder, ObjectBuilder<IndicesRequest>> fn)
        throws IOException, OpenSearchException {
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
    public final CompletableFuture<IndicesResponse> indices() throws IOException, OpenSearchException {
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
    public CompletableFuture<NodesResponse> nodes(NodesRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, NodesRequest._ENDPOINT, this.transportOptions);
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
    public final CompletableFuture<NodesResponse> nodes(Function<NodesRequest.Builder, ObjectBuilder<NodesRequest>> fn) throws IOException,
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
    public final CompletableFuture<NodesResponse> nodes() throws IOException, OpenSearchException {
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
    public CompletableFuture<PendingTasksResponse> pendingTasks(PendingTasksRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, PendingTasksRequest._ENDPOINT, this.transportOptions);
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
    public final CompletableFuture<PendingTasksResponse> pendingTasks(
        Function<PendingTasksRequest.Builder, ObjectBuilder<PendingTasksRequest>> fn
    ) throws IOException, OpenSearchException {
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
    public final CompletableFuture<PendingTasksResponse> pendingTasks() throws IOException, OpenSearchException {
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
    public CompletableFuture<PitSegmentsResponse> pitSegments(PitSegmentsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, PitSegmentsRequest._ENDPOINT, this.transportOptions);
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
    public final CompletableFuture<PitSegmentsResponse> pitSegments(
        Function<PitSegmentsRequest.Builder, ObjectBuilder<PitSegmentsRequest>> fn
    ) throws IOException, OpenSearchException {
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
    public CompletableFuture<PluginsResponse> plugins(PluginsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, PluginsRequest._ENDPOINT, this.transportOptions);
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
    public final CompletableFuture<PluginsResponse> plugins(Function<PluginsRequest.Builder, ObjectBuilder<PluginsRequest>> fn)
        throws IOException, OpenSearchException {
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
    public final CompletableFuture<PluginsResponse> plugins() throws IOException, OpenSearchException {
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
    public CompletableFuture<RecoveryResponse> recovery(RecoveryRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, RecoveryRequest._ENDPOINT, this.transportOptions);
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
    public final CompletableFuture<RecoveryResponse> recovery(Function<RecoveryRequest.Builder, ObjectBuilder<RecoveryRequest>> fn)
        throws IOException, OpenSearchException {
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
    public final CompletableFuture<RecoveryResponse> recovery() throws IOException, OpenSearchException {
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
    public CompletableFuture<RepositoriesResponse> repositories(RepositoriesRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, RepositoriesRequest._ENDPOINT, this.transportOptions);
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
    public final CompletableFuture<RepositoriesResponse> repositories(
        Function<RepositoriesRequest.Builder, ObjectBuilder<RepositoriesRequest>> fn
    ) throws IOException, OpenSearchException {
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
    public final CompletableFuture<RepositoriesResponse> repositories() throws IOException, OpenSearchException {
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
    public CompletableFuture<SegmentReplicationResponse> segmentReplication(SegmentReplicationRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, SegmentReplicationRequest._ENDPOINT, this.transportOptions);
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
    public final CompletableFuture<SegmentReplicationResponse> segmentReplication(
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
    public final CompletableFuture<SegmentReplicationResponse> segmentReplication() throws IOException, OpenSearchException {
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
    public CompletableFuture<SegmentsResponse> segments(SegmentsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, SegmentsRequest._ENDPOINT, this.transportOptions);
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
    public final CompletableFuture<SegmentsResponse> segments(Function<SegmentsRequest.Builder, ObjectBuilder<SegmentsRequest>> fn)
        throws IOException, OpenSearchException {
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
    public final CompletableFuture<SegmentsResponse> segments() throws IOException, OpenSearchException {
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
    public CompletableFuture<ShardsResponse> shards(ShardsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, ShardsRequest._ENDPOINT, this.transportOptions);
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
    public final CompletableFuture<ShardsResponse> shards(Function<ShardsRequest.Builder, ObjectBuilder<ShardsRequest>> fn)
        throws IOException, OpenSearchException {
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
    public final CompletableFuture<ShardsResponse> shards() throws IOException, OpenSearchException {
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
    public CompletableFuture<SnapshotsResponse> snapshots(SnapshotsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, SnapshotsRequest._ENDPOINT, this.transportOptions);
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
    public final CompletableFuture<SnapshotsResponse> snapshots(Function<SnapshotsRequest.Builder, ObjectBuilder<SnapshotsRequest>> fn)
        throws IOException, OpenSearchException {
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
    public final CompletableFuture<SnapshotsResponse> snapshots() throws IOException, OpenSearchException {
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
    public CompletableFuture<TasksResponse> tasks(TasksRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, TasksRequest._ENDPOINT, this.transportOptions);
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
    public final CompletableFuture<TasksResponse> tasks(Function<TasksRequest.Builder, ObjectBuilder<TasksRequest>> fn) throws IOException,
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
    public final CompletableFuture<TasksResponse> tasks() throws IOException, OpenSearchException {
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
    public CompletableFuture<TemplatesResponse> templates(TemplatesRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, TemplatesRequest._ENDPOINT, this.transportOptions);
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
    public final CompletableFuture<TemplatesResponse> templates(Function<TemplatesRequest.Builder, ObjectBuilder<TemplatesRequest>> fn)
        throws IOException, OpenSearchException {
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
    public final CompletableFuture<TemplatesResponse> templates() throws IOException, OpenSearchException {
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
    public CompletableFuture<ThreadPoolResponse> threadPool(ThreadPoolRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, ThreadPoolRequest._ENDPOINT, this.transportOptions);
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
    public final CompletableFuture<ThreadPoolResponse> threadPool(Function<ThreadPoolRequest.Builder, ObjectBuilder<ThreadPoolRequest>> fn)
        throws IOException, OpenSearchException {
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
    public final CompletableFuture<ThreadPoolResponse> threadPool() throws IOException, OpenSearchException {
        return threadPool(new ThreadPoolRequest.Builder().build());
    }
}
