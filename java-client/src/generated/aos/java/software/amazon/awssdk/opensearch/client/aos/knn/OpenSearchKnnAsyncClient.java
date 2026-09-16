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

package software.amazon.awssdk.opensearch.client.aos.knn;

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
 * Client for the knn namespace.
 */
@Generated("software.amazon.awssdk.opensearch.client.codegen.CodeGenerator")
public class OpenSearchKnnAsyncClient extends ApiClient<OpenSearchTransport, OpenSearchKnnAsyncClient> {
    public OpenSearchKnnAsyncClient(OpenSearchTransport transport) {
        super(transport, null);
    }

    public OpenSearchKnnAsyncClient(OpenSearchTransport transport, @Nullable TransportOptions transportOptions) {
        super(transport, transportOptions);
    }

    @Override
    public OpenSearchKnnAsyncClient withTransportOptions(@Nullable TransportOptions transportOptions) {
        return new OpenSearchKnnAsyncClient(this.transport, transportOptions);
    }

    // ----- Endpoint: knn.delete_model

    /**
     * <p>
     * Used to delete a particular model in the cluster.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public CompletableFuture<DeleteModelResponse> deleteModel(DeleteModelRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, DeleteModelRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Used to delete a particular model in the cluster.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link DeleteModelRequest}
     */
    public final CompletableFuture<DeleteModelResponse> deleteModel(
        Function<DeleteModelRequest.Builder, ObjectBuilder<DeleteModelRequest>> fn
    ) throws IOException, OpenSearchException {
        return deleteModel(fn.apply(new DeleteModelRequest.Builder()).build());
    }

    // ----- Endpoint: knn.get_model

    /**
     * <p>
     * Used to retrieve information about models present in the cluster.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public CompletableFuture<GetModelResponse> getModel(GetModelRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, GetModelRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Used to retrieve information about models present in the cluster.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link GetModelRequest}
     */
    public final CompletableFuture<GetModelResponse> getModel(Function<GetModelRequest.Builder, ObjectBuilder<GetModelRequest>> fn)
        throws IOException, OpenSearchException {
        return getModel(fn.apply(new GetModelRequest.Builder()).build());
    }

    // ----- Endpoint: knn.search_models

    /**
     * <p>
     * Use an OpenSearch query to search for models in the index.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public CompletableFuture<SearchModelsResponse> searchModels(SearchModelsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, SearchModelsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Use an OpenSearch query to search for models in the index.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link SearchModelsRequest}
     */
    public final CompletableFuture<SearchModelsResponse> searchModels(
        Function<SearchModelsRequest.Builder, ObjectBuilder<SearchModelsRequest>> fn
    ) throws IOException, OpenSearchException {
        return searchModels(fn.apply(new SearchModelsRequest.Builder()).build());
    }

    /**
     * <p>
     * Use an OpenSearch query to search for models in the index.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public final CompletableFuture<SearchModelsResponse> searchModels() throws IOException, OpenSearchException {
        return searchModels(new SearchModelsRequest.Builder().build());
    }

    // ----- Endpoint: knn.stats

    /**
     * <p>
     * Provides information about the current status of the k-NN plugin.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public CompletableFuture<KnnStatsResponse> stats(KnnStatsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, KnnStatsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Provides information about the current status of the k-NN plugin.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link KnnStatsRequest}
     */
    public final CompletableFuture<KnnStatsResponse> stats(Function<KnnStatsRequest.Builder, ObjectBuilder<KnnStatsRequest>> fn)
        throws IOException, OpenSearchException {
        return stats(fn.apply(new KnnStatsRequest.Builder()).build());
    }

    /**
     * <p>
     * Provides information about the current status of the k-NN plugin.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public final CompletableFuture<KnnStatsResponse> stats() throws IOException, OpenSearchException {
        return stats(new KnnStatsRequest.Builder().build());
    }

    // ----- Endpoint: knn.train_model

    /**
     * <p>
     * Create and train a model that can be used for initializing k-NN native library indexes during indexing.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public CompletableFuture<TrainModelResponse> trainModel(TrainModelRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, TrainModelRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Create and train a model that can be used for initializing k-NN native library indexes during indexing.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link TrainModelRequest}
     */
    public final CompletableFuture<TrainModelResponse> trainModel(Function<TrainModelRequest.Builder, ObjectBuilder<TrainModelRequest>> fn)
        throws IOException, OpenSearchException {
        return trainModel(fn.apply(new TrainModelRequest.Builder()).build());
    }

    // ----- Endpoint: knn.warmup

    /**
     * <p>
     * Preloads native library files into memory, reducing initial search latency for specified indexes.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public CompletableFuture<WarmupResponse> warmup(WarmupRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, WarmupRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Preloads native library files into memory, reducing initial search latency for specified indexes.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link WarmupRequest}
     */
    public final CompletableFuture<WarmupResponse> warmup(Function<WarmupRequest.Builder, ObjectBuilder<WarmupRequest>> fn)
        throws IOException, OpenSearchException {
        return warmup(fn.apply(new WarmupRequest.Builder()).build());
    }
}
