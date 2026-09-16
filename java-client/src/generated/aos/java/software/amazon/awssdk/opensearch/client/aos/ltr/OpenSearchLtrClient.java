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

package software.amazon.awssdk.opensearch.client.aos.ltr;

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
 * Client for the ltr namespace.
 */
@Generated("software.amazon.awssdk.opensearch.client.codegen.CodeGenerator")
public class OpenSearchLtrClient extends ApiClient<OpenSearchTransport, OpenSearchLtrClient> {
    public OpenSearchLtrClient(OpenSearchTransport transport) {
        super(transport, null);
    }

    public OpenSearchLtrClient(OpenSearchTransport transport, @Nullable TransportOptions transportOptions) {
        super(transport, transportOptions);
    }

    @Override
    public OpenSearchLtrClient withTransportOptions(@Nullable TransportOptions transportOptions) {
        return new OpenSearchLtrClient(this.transport, transportOptions);
    }

    // ----- Endpoint: ltr.add_features_to_set

    /**
     * <p>
     * Add features to an existing feature set in the default feature store.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.19</code>
     * </p>
     */
    public AddFeaturesToSetResponse addFeaturesToSet(AddFeaturesToSetRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, AddFeaturesToSetRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Add features to an existing feature set in the default feature store.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.19</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link AddFeaturesToSetRequest}
     */
    public final AddFeaturesToSetResponse addFeaturesToSet(
        Function<AddFeaturesToSetRequest.Builder, ObjectBuilder<AddFeaturesToSetRequest>> fn
    ) throws IOException, OpenSearchException {
        return addFeaturesToSet(fn.apply(new AddFeaturesToSetRequest.Builder()).build());
    }

    // ----- Endpoint: ltr.add_features_to_set_by_query

    /**
     * <p>
     * Add features to an existing feature set in the default feature store.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.19</code>
     * </p>
     */
    public AddFeaturesToSetByQueryResponse addFeaturesToSetByQuery(AddFeaturesToSetByQueryRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequest(request, AddFeaturesToSetByQueryRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Add features to an existing feature set in the default feature store.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.19</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link AddFeaturesToSetByQueryRequest}
     */
    public final AddFeaturesToSetByQueryResponse addFeaturesToSetByQuery(
        Function<AddFeaturesToSetByQueryRequest.Builder, ObjectBuilder<AddFeaturesToSetByQueryRequest>> fn
    ) throws IOException, OpenSearchException {
        return addFeaturesToSetByQuery(fn.apply(new AddFeaturesToSetByQueryRequest.Builder()).build());
    }

    // ----- Endpoint: ltr.cache_stats

    /**
     * <p>
     * Retrieves cache statistics for all feature stores.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.19</code>
     * </p>
     */
    public CacheStatsResponse cacheStats(CacheStatsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, CacheStatsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Retrieves cache statistics for all feature stores.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.19</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link CacheStatsRequest}
     */
    public final CacheStatsResponse cacheStats(Function<CacheStatsRequest.Builder, ObjectBuilder<CacheStatsRequest>> fn) throws IOException,
        OpenSearchException {
        return cacheStats(fn.apply(new CacheStatsRequest.Builder()).build());
    }

    /**
     * <p>
     * Retrieves cache statistics for all feature stores.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.19</code>
     * </p>
     */
    public final CacheStatsResponse cacheStats() throws IOException, OpenSearchException {
        return cacheStats(new CacheStatsRequest.Builder().build());
    }

    // ----- Endpoint: ltr.clear_cache

    /**
     * <p>
     * Clears the store caches.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.19</code>
     * </p>
     */
    public ClearCacheResponse clearCache(ClearCacheRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, ClearCacheRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Clears the store caches.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.19</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link ClearCacheRequest}
     */
    public final ClearCacheResponse clearCache(Function<ClearCacheRequest.Builder, ObjectBuilder<ClearCacheRequest>> fn) throws IOException,
        OpenSearchException {
        return clearCache(fn.apply(new ClearCacheRequest.Builder()).build());
    }

    /**
     * <p>
     * Clears the store caches.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.19</code>
     * </p>
     */
    public final ClearCacheResponse clearCache() throws IOException, OpenSearchException {
        return clearCache(new ClearCacheRequest.Builder().build());
    }

    // ----- Endpoint: ltr.create_default_store

    /**
     * <p>
     * Creates the default feature store.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.17.1</code>
     * </p>
     */
    public CreateDefaultStoreResponse createDefaultStore(CreateDefaultStoreRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, CreateDefaultStoreRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Creates the default feature store.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.17.1</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link CreateDefaultStoreRequest}
     */
    public final CreateDefaultStoreResponse createDefaultStore(
        Function<CreateDefaultStoreRequest.Builder, ObjectBuilder<CreateDefaultStoreRequest>> fn
    ) throws IOException, OpenSearchException {
        return createDefaultStore(fn.apply(new CreateDefaultStoreRequest.Builder()).build());
    }

    /**
     * <p>
     * Creates the default feature store.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.17.1</code>
     * </p>
     */
    public final CreateDefaultStoreResponse createDefaultStore() throws IOException, OpenSearchException {
        return createDefaultStore(new CreateDefaultStoreRequest.Builder().build());
    }

    // ----- Endpoint: ltr.create_feature

    /**
     * <p>
     * Create or update a feature in the default feature store.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.19</code>
     * </p>
     */
    public CreateFeatureResponse createFeature(CreateFeatureRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, CreateFeatureRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Create or update a feature in the default feature store.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.19</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link CreateFeatureRequest}
     */
    public final CreateFeatureResponse createFeature(Function<CreateFeatureRequest.Builder, ObjectBuilder<CreateFeatureRequest>> fn)
        throws IOException, OpenSearchException {
        return createFeature(fn.apply(new CreateFeatureRequest.Builder()).build());
    }

    // ----- Endpoint: ltr.create_featureset

    /**
     * <p>
     * Create or update a feature set in the default feature store.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.19</code>
     * </p>
     */
    public CreateFeaturesetResponse createFeatureset(CreateFeaturesetRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, CreateFeaturesetRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Create or update a feature set in the default feature store.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.19</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link CreateFeaturesetRequest}
     */
    public final CreateFeaturesetResponse createFeatureset(
        Function<CreateFeaturesetRequest.Builder, ObjectBuilder<CreateFeaturesetRequest>> fn
    ) throws IOException, OpenSearchException {
        return createFeatureset(fn.apply(new CreateFeaturesetRequest.Builder()).build());
    }

    // ----- Endpoint: ltr.create_model

    /**
     * <p>
     * Create or update a model in the default feature store.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.19</code>
     * </p>
     */
    public CreateModelResponse createModel(CreateModelRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, CreateModelRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Create or update a model in the default feature store.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.19</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link CreateModelRequest}
     */
    public final CreateModelResponse createModel(Function<CreateModelRequest.Builder, ObjectBuilder<CreateModelRequest>> fn)
        throws IOException, OpenSearchException {
        return createModel(fn.apply(new CreateModelRequest.Builder()).build());
    }

    // ----- Endpoint: ltr.create_model_from_set

    /**
     * <p>
     * Create a model from an existing feature set in the default feature store.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.19</code>
     * </p>
     */
    public CreateModelFromSetResponse createModelFromSet(CreateModelFromSetRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, CreateModelFromSetRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Create a model from an existing feature set in the default feature store.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.19</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link CreateModelFromSetRequest}
     */
    public final CreateModelFromSetResponse createModelFromSet(
        Function<CreateModelFromSetRequest.Builder, ObjectBuilder<CreateModelFromSetRequest>> fn
    ) throws IOException, OpenSearchException {
        return createModelFromSet(fn.apply(new CreateModelFromSetRequest.Builder()).build());
    }

    // ----- Endpoint: ltr.create_store

    /**
     * <p>
     * Creates a new feature store with the specified name.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.17.1</code>
     * </p>
     */
    public CreateStoreResponse createStore(CreateStoreRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, CreateStoreRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Creates a new feature store with the specified name.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.17.1</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link CreateStoreRequest}
     */
    public final CreateStoreResponse createStore(Function<CreateStoreRequest.Builder, ObjectBuilder<CreateStoreRequest>> fn)
        throws IOException, OpenSearchException {
        return createStore(fn.apply(new CreateStoreRequest.Builder()).build());
    }

    // ----- Endpoint: ltr.delete_default_store

    /**
     * <p>
     * Deletes the default feature store.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.17.1</code>
     * </p>
     */
    public DeleteDefaultStoreResponse deleteDefaultStore(DeleteDefaultStoreRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, DeleteDefaultStoreRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Deletes the default feature store.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.17.1</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link DeleteDefaultStoreRequest}
     */
    public final DeleteDefaultStoreResponse deleteDefaultStore(
        Function<DeleteDefaultStoreRequest.Builder, ObjectBuilder<DeleteDefaultStoreRequest>> fn
    ) throws IOException, OpenSearchException {
        return deleteDefaultStore(fn.apply(new DeleteDefaultStoreRequest.Builder()).build());
    }

    /**
     * <p>
     * Deletes the default feature store.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.17.1</code>
     * </p>
     */
    public final DeleteDefaultStoreResponse deleteDefaultStore() throws IOException, OpenSearchException {
        return deleteDefaultStore(new DeleteDefaultStoreRequest.Builder().build());
    }

    // ----- Endpoint: ltr.delete_feature

    /**
     * <p>
     * Delete a feature from the default feature store.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.19</code>
     * </p>
     */
    public DeleteFeatureResponse deleteFeature(DeleteFeatureRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, DeleteFeatureRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Delete a feature from the default feature store.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.19</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link DeleteFeatureRequest}
     */
    public final DeleteFeatureResponse deleteFeature(Function<DeleteFeatureRequest.Builder, ObjectBuilder<DeleteFeatureRequest>> fn)
        throws IOException, OpenSearchException {
        return deleteFeature(fn.apply(new DeleteFeatureRequest.Builder()).build());
    }

    // ----- Endpoint: ltr.delete_featureset

    /**
     * <p>
     * Delete a feature set from the default feature store.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.19</code>
     * </p>
     */
    public DeleteFeaturesetResponse deleteFeatureset(DeleteFeaturesetRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, DeleteFeaturesetRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Delete a feature set from the default feature store.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.19</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link DeleteFeaturesetRequest}
     */
    public final DeleteFeaturesetResponse deleteFeatureset(
        Function<DeleteFeaturesetRequest.Builder, ObjectBuilder<DeleteFeaturesetRequest>> fn
    ) throws IOException, OpenSearchException {
        return deleteFeatureset(fn.apply(new DeleteFeaturesetRequest.Builder()).build());
    }

    // ----- Endpoint: ltr.delete_model

    /**
     * <p>
     * Delete a model from the default feature store.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.19</code>
     * </p>
     */
    public DeleteModelResponse deleteModel(DeleteModelRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, DeleteModelRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Delete a model from the default feature store.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.19</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link DeleteModelRequest}
     */
    public final DeleteModelResponse deleteModel(Function<DeleteModelRequest.Builder, ObjectBuilder<DeleteModelRequest>> fn)
        throws IOException, OpenSearchException {
        return deleteModel(fn.apply(new DeleteModelRequest.Builder()).build());
    }

    // ----- Endpoint: ltr.delete_store

    /**
     * <p>
     * Deletes a feature store with the specified name.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.17.1</code>
     * </p>
     */
    public DeleteStoreResponse deleteStore(DeleteStoreRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, DeleteStoreRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Deletes a feature store with the specified name.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.17.1</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link DeleteStoreRequest}
     */
    public final DeleteStoreResponse deleteStore(Function<DeleteStoreRequest.Builder, ObjectBuilder<DeleteStoreRequest>> fn)
        throws IOException, OpenSearchException {
        return deleteStore(fn.apply(new DeleteStoreRequest.Builder()).build());
    }

    // ----- Endpoint: ltr.get_feature

    /**
     * <p>
     * Get a feature from the default feature store.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.19</code>
     * </p>
     */
    public GetFeatureResponse getFeature(GetFeatureRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetFeatureRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Get a feature from the default feature store.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.19</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link GetFeatureRequest}
     */
    public final GetFeatureResponse getFeature(Function<GetFeatureRequest.Builder, ObjectBuilder<GetFeatureRequest>> fn) throws IOException,
        OpenSearchException {
        return getFeature(fn.apply(new GetFeatureRequest.Builder()).build());
    }

    // ----- Endpoint: ltr.get_featureset

    /**
     * <p>
     * Get a feature set from the default feature store.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.19</code>
     * </p>
     */
    public GetFeaturesetResponse getFeatureset(GetFeaturesetRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetFeaturesetRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Get a feature set from the default feature store.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.19</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link GetFeaturesetRequest}
     */
    public final GetFeaturesetResponse getFeatureset(Function<GetFeaturesetRequest.Builder, ObjectBuilder<GetFeaturesetRequest>> fn)
        throws IOException, OpenSearchException {
        return getFeatureset(fn.apply(new GetFeaturesetRequest.Builder()).build());
    }

    // ----- Endpoint: ltr.get_model

    /**
     * <p>
     * Get a model from the default feature store.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.19</code>
     * </p>
     */
    public GetModelResponse getModel(GetModelRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetModelRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Get a model from the default feature store.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.19</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link GetModelRequest}
     */
    public final GetModelResponse getModel(Function<GetModelRequest.Builder, ObjectBuilder<GetModelRequest>> fn) throws IOException,
        OpenSearchException {
        return getModel(fn.apply(new GetModelRequest.Builder()).build());
    }

    // ----- Endpoint: ltr.get_store

    /**
     * <p>
     * Checks if a store exists.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.17.1</code>
     * </p>
     */
    public GetStoreResponse getStore(GetStoreRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetStoreRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Checks if a store exists.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.17.1</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link GetStoreRequest}
     */
    public final GetStoreResponse getStore(Function<GetStoreRequest.Builder, ObjectBuilder<GetStoreRequest>> fn) throws IOException,
        OpenSearchException {
        return getStore(fn.apply(new GetStoreRequest.Builder()).build());
    }

    // ----- Endpoint: ltr.list_stores

    /**
     * <p>
     * Lists all available feature stores.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.17.1</code>
     * </p>
     */
    public ListStoresResponse listStores(ListStoresRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, ListStoresRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Lists all available feature stores.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.17.1</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link ListStoresRequest}
     */
    public final ListStoresResponse listStores(Function<ListStoresRequest.Builder, ObjectBuilder<ListStoresRequest>> fn) throws IOException,
        OpenSearchException {
        return listStores(fn.apply(new ListStoresRequest.Builder()).build());
    }

    /**
     * <p>
     * Lists all available feature stores.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.17.1</code>
     * </p>
     */
    public final ListStoresResponse listStores() throws IOException, OpenSearchException {
        return listStores(new ListStoresRequest.Builder().build());
    }

    // ----- Endpoint: ltr.search_features

    /**
     * <p>
     * Search for features in a feature store.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.19</code>
     * </p>
     */
    public SearchFeaturesResponse searchFeatures(SearchFeaturesRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, SearchFeaturesRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Search for features in a feature store.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.19</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link SearchFeaturesRequest}
     */
    public final SearchFeaturesResponse searchFeatures(Function<SearchFeaturesRequest.Builder, ObjectBuilder<SearchFeaturesRequest>> fn)
        throws IOException, OpenSearchException {
        return searchFeatures(fn.apply(new SearchFeaturesRequest.Builder()).build());
    }

    /**
     * <p>
     * Search for features in a feature store.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.19</code>
     * </p>
     */
    public final SearchFeaturesResponse searchFeatures() throws IOException, OpenSearchException {
        return searchFeatures(new SearchFeaturesRequest.Builder().build());
    }

    // ----- Endpoint: ltr.search_featuresets

    /**
     * <p>
     * Search for feature sets in a feature store.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.19</code>
     * </p>
     */
    public SearchFeaturesetsResponse searchFeaturesets(SearchFeaturesetsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, SearchFeaturesetsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Search for feature sets in a feature store.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.19</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link SearchFeaturesetsRequest}
     */
    public final SearchFeaturesetsResponse searchFeaturesets(
        Function<SearchFeaturesetsRequest.Builder, ObjectBuilder<SearchFeaturesetsRequest>> fn
    ) throws IOException, OpenSearchException {
        return searchFeaturesets(fn.apply(new SearchFeaturesetsRequest.Builder()).build());
    }

    /**
     * <p>
     * Search for feature sets in a feature store.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.19</code>
     * </p>
     */
    public final SearchFeaturesetsResponse searchFeaturesets() throws IOException, OpenSearchException {
        return searchFeaturesets(new SearchFeaturesetsRequest.Builder().build());
    }

    // ----- Endpoint: ltr.search_models

    /**
     * <p>
     * Search for models in a feature store.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.19</code>
     * </p>
     */
    public SearchModelsResponse searchModels(SearchModelsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, SearchModelsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Search for models in a feature store.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.19</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link SearchModelsRequest}
     */
    public final SearchModelsResponse searchModels(Function<SearchModelsRequest.Builder, ObjectBuilder<SearchModelsRequest>> fn)
        throws IOException, OpenSearchException {
        return searchModels(fn.apply(new SearchModelsRequest.Builder()).build());
    }

    /**
     * <p>
     * Search for models in a feature store.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.19</code>
     * </p>
     */
    public final SearchModelsResponse searchModels() throws IOException, OpenSearchException {
        return searchModels(new SearchModelsRequest.Builder().build());
    }

    // ----- Endpoint: ltr.stats

    /**
     * <p>
     * Provides information about the current status of the LTR plugin.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.19</code>
     * </p>
     */
    public LtrStatsResponse stats(LtrStatsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, LtrStatsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Provides information about the current status of the LTR plugin.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.19</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link LtrStatsRequest}
     */
    public final LtrStatsResponse stats(Function<LtrStatsRequest.Builder, ObjectBuilder<LtrStatsRequest>> fn) throws IOException,
        OpenSearchException {
        return stats(fn.apply(new LtrStatsRequest.Builder()).build());
    }

    /**
     * <p>
     * Provides information about the current status of the LTR plugin.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.19</code>
     * </p>
     */
    public final LtrStatsResponse stats() throws IOException, OpenSearchException {
        return stats(new LtrStatsRequest.Builder().build());
    }

    // ----- Endpoint: ltr.update_feature

    /**
     * <p>
     * Update a feature in the default feature store.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.19</code>
     * </p>
     */
    public UpdateFeatureResponse updateFeature(UpdateFeatureRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, UpdateFeatureRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Update a feature in the default feature store.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.19</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link UpdateFeatureRequest}
     */
    public final UpdateFeatureResponse updateFeature(Function<UpdateFeatureRequest.Builder, ObjectBuilder<UpdateFeatureRequest>> fn)
        throws IOException, OpenSearchException {
        return updateFeature(fn.apply(new UpdateFeatureRequest.Builder()).build());
    }

    // ----- Endpoint: ltr.update_featureset

    /**
     * <p>
     * Update a feature set in the default feature store.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.19</code>
     * </p>
     */
    public UpdateFeaturesetResponse updateFeatureset(UpdateFeaturesetRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, UpdateFeaturesetRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Update a feature set in the default feature store.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.19</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link UpdateFeaturesetRequest}
     */
    public final UpdateFeaturesetResponse updateFeatureset(
        Function<UpdateFeaturesetRequest.Builder, ObjectBuilder<UpdateFeaturesetRequest>> fn
    ) throws IOException, OpenSearchException {
        return updateFeatureset(fn.apply(new UpdateFeaturesetRequest.Builder()).build());
    }
}
