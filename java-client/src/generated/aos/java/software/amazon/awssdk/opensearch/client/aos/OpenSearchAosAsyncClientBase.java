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

package software.amazon.awssdk.opensearch.client.aos;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nullable;
import software.amazon.awssdk.opensearch.client.ApiClient;
import software.amazon.awssdk.opensearch.client.aos.cat.OpenSearchCatAsyncClient;
import software.amazon.awssdk.opensearch.client.aos.cluster.OpenSearchClusterAsyncClient;
import software.amazon.awssdk.opensearch.client.aos.cold.OpenSearchColdAsyncClient;
import software.amazon.awssdk.opensearch.client.aos.core.ClearScrollRequest;
import software.amazon.awssdk.opensearch.client.aos.core.ClearScrollResponse;
import software.amazon.awssdk.opensearch.client.aos.core.CountRequest;
import software.amazon.awssdk.opensearch.client.aos.core.CountResponse;
import software.amazon.awssdk.opensearch.client.aos.core.CreatePitRequest;
import software.amazon.awssdk.opensearch.client.aos.core.CreatePitResponse;
import software.amazon.awssdk.opensearch.client.aos.core.DeleteAllPitsRequest;
import software.amazon.awssdk.opensearch.client.aos.core.DeleteAllPitsResponse;
import software.amazon.awssdk.opensearch.client.aos.core.DeleteByQueryRequest;
import software.amazon.awssdk.opensearch.client.aos.core.DeleteByQueryResponse;
import software.amazon.awssdk.opensearch.client.aos.core.DeleteByQueryRethrottleRequest;
import software.amazon.awssdk.opensearch.client.aos.core.DeleteByQueryRethrottleResponse;
import software.amazon.awssdk.opensearch.client.aos.core.DeletePitRequest;
import software.amazon.awssdk.opensearch.client.aos.core.DeletePitResponse;
import software.amazon.awssdk.opensearch.client.aos.core.DeleteRequest;
import software.amazon.awssdk.opensearch.client.aos.core.DeleteResponse;
import software.amazon.awssdk.opensearch.client.aos.core.DeleteScriptRequest;
import software.amazon.awssdk.opensearch.client.aos.core.DeleteScriptResponse;
import software.amazon.awssdk.opensearch.client.aos.core.ExistsRequest;
import software.amazon.awssdk.opensearch.client.aos.core.ExistsSourceRequest;
import software.amazon.awssdk.opensearch.client.aos.core.ExplainRequest;
import software.amazon.awssdk.opensearch.client.aos.core.ExplainResponse;
import software.amazon.awssdk.opensearch.client.aos.core.FieldCapsRequest;
import software.amazon.awssdk.opensearch.client.aos.core.FieldCapsResponse;
import software.amazon.awssdk.opensearch.client.aos.core.GetAllPitsRequest;
import software.amazon.awssdk.opensearch.client.aos.core.GetAllPitsResponse;
import software.amazon.awssdk.opensearch.client.aos.core.GetRequest;
import software.amazon.awssdk.opensearch.client.aos.core.GetResponse;
import software.amazon.awssdk.opensearch.client.aos.core.GetScriptRequest;
import software.amazon.awssdk.opensearch.client.aos.core.GetScriptResponse;
import software.amazon.awssdk.opensearch.client.aos.core.GetSourceRequest;
import software.amazon.awssdk.opensearch.client.aos.core.GetSourceResponse;
import software.amazon.awssdk.opensearch.client.aos.core.InfoRequest;
import software.amazon.awssdk.opensearch.client.aos.core.InfoResponse;
import software.amazon.awssdk.opensearch.client.aos.core.MtermvectorsRequest;
import software.amazon.awssdk.opensearch.client.aos.core.MtermvectorsResponse;
import software.amazon.awssdk.opensearch.client.aos.core.PingRequest;
import software.amazon.awssdk.opensearch.client.aos.core.PutScriptRequest;
import software.amazon.awssdk.opensearch.client.aos.core.PutScriptResponse;
import software.amazon.awssdk.opensearch.client.aos.core.RankEvalRequest;
import software.amazon.awssdk.opensearch.client.aos.core.RankEvalResponse;
import software.amazon.awssdk.opensearch.client.aos.core.ReindexRequest;
import software.amazon.awssdk.opensearch.client.aos.core.ReindexResponse;
import software.amazon.awssdk.opensearch.client.aos.core.ReindexRethrottleRequest;
import software.amazon.awssdk.opensearch.client.aos.core.ReindexRethrottleResponse;
import software.amazon.awssdk.opensearch.client.aos.core.RenderSearchTemplateRequest;
import software.amazon.awssdk.opensearch.client.aos.core.RenderSearchTemplateResponse;
import software.amazon.awssdk.opensearch.client.aos.core.ScriptsPainlessExecuteRequest;
import software.amazon.awssdk.opensearch.client.aos.core.ScriptsPainlessExecuteResponse;
import software.amazon.awssdk.opensearch.client.aos.core.ScrollRequest;
import software.amazon.awssdk.opensearch.client.aos.core.ScrollResponse;
import software.amazon.awssdk.opensearch.client.aos.core.SearchRequest;
import software.amazon.awssdk.opensearch.client.aos.core.SearchResponse;
import software.amazon.awssdk.opensearch.client.aos.core.SearchShardsRequest;
import software.amazon.awssdk.opensearch.client.aos.core.SearchShardsResponse;
import software.amazon.awssdk.opensearch.client.aos.core.SearchTemplateRequest;
import software.amazon.awssdk.opensearch.client.aos.core.SearchTemplateResponse;
import software.amazon.awssdk.opensearch.client.aos.core.UpdateByQueryRequest;
import software.amazon.awssdk.opensearch.client.aos.core.UpdateByQueryResponse;
import software.amazon.awssdk.opensearch.client.aos.core.UpdateByQueryRethrottleRequest;
import software.amazon.awssdk.opensearch.client.aos.core.UpdateByQueryRethrottleResponse;
import software.amazon.awssdk.opensearch.client.aos.geospatial.OpenSearchGeospatialAsyncClient;
import software.amazon.awssdk.opensearch.client.aos.indices.OpenSearchIndicesAsyncClient;
import software.amazon.awssdk.opensearch.client.aos.ingest.OpenSearchIngestAsyncClient;
import software.amazon.awssdk.opensearch.client.aos.ingestion.OpenSearchIngestionAsyncClient;
import software.amazon.awssdk.opensearch.client.aos.ism.OpenSearchIsmAsyncClient;
import software.amazon.awssdk.opensearch.client.aos.knn.OpenSearchKnnAsyncClient;
import software.amazon.awssdk.opensearch.client.aos.ltr.OpenSearchLtrAsyncClient;
import software.amazon.awssdk.opensearch.client.aos.ml.OpenSearchMlAsyncClient;
import software.amazon.awssdk.opensearch.client.aos.nodes.OpenSearchNodesAsyncClient;
import software.amazon.awssdk.opensearch.client.aos.search_pipeline.OpenSearchSearchPipelineAsyncClient;
import software.amazon.awssdk.opensearch.client.aos.search_relevance.OpenSearchSearchRelevanceAsyncClient;
import software.amazon.awssdk.opensearch.client.aos.security.OpenSearchSecurityAsyncClient;
import software.amazon.awssdk.opensearch.client.aos.snapshot.OpenSearchSnapshotAsyncClient;
import software.amazon.awssdk.opensearch.client.aos.tasks.OpenSearchTasksAsyncClient;
import software.amazon.awssdk.opensearch.client.aos.ubi.OpenSearchUbiAsyncClient;
import software.amazon.awssdk.opensearch.client.aos.ultrawarm.OpenSearchUltrawarmAsyncClient;
import software.amazon.awssdk.opensearch.client.errors.ErrorResponse;
import software.amazon.awssdk.opensearch.client.errors.OpenSearchException;
import software.amazon.awssdk.opensearch.client.transport.JsonEndpoint;
import software.amazon.awssdk.opensearch.client.transport.OpenSearchTransport;
import software.amazon.awssdk.opensearch.client.transport.TransportOptions;
import software.amazon.awssdk.opensearch.client.transport.endpoints.BooleanResponse;
import software.amazon.awssdk.opensearch.client.transport.endpoints.EndpointWithResponseMapperAttr;
import software.amazon.awssdk.opensearch.client.util.ObjectBuilder;

/**
 * Client for the namespace.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public abstract class OpenSearchAosAsyncClientBase<Self extends OpenSearchAosAsyncClientBase<Self>> extends ApiClient<
    OpenSearchTransport,
    Self> {
    public OpenSearchAosAsyncClientBase(OpenSearchTransport transport, @Nullable TransportOptions transportOptions) {
        super(transport, transportOptions);
    }

    // ----- Child clients

    public OpenSearchCatAsyncClient cat() {
        return new OpenSearchCatAsyncClient(this.transport, this.transportOptions);
    }

    public OpenSearchClusterAsyncClient cluster() {
        return new OpenSearchClusterAsyncClient(this.transport, this.transportOptions);
    }

    public OpenSearchColdAsyncClient cold() {
        return new OpenSearchColdAsyncClient(this.transport, this.transportOptions);
    }

    public OpenSearchGeospatialAsyncClient geospatial() {
        return new OpenSearchGeospatialAsyncClient(this.transport, this.transportOptions);
    }

    public OpenSearchIndicesAsyncClient indices() {
        return new OpenSearchIndicesAsyncClient(this.transport, this.transportOptions);
    }

    public OpenSearchIngestAsyncClient ingest() {
        return new OpenSearchIngestAsyncClient(this.transport, this.transportOptions);
    }

    public OpenSearchIngestionAsyncClient ingestion() {
        return new OpenSearchIngestionAsyncClient(this.transport, this.transportOptions);
    }

    public OpenSearchIsmAsyncClient ism() {
        return new OpenSearchIsmAsyncClient(this.transport, this.transportOptions);
    }

    public OpenSearchKnnAsyncClient knn() {
        return new OpenSearchKnnAsyncClient(this.transport, this.transportOptions);
    }

    public OpenSearchLtrAsyncClient ltr() {
        return new OpenSearchLtrAsyncClient(this.transport, this.transportOptions);
    }

    public OpenSearchMlAsyncClient ml() {
        return new OpenSearchMlAsyncClient(this.transport, this.transportOptions);
    }

    public OpenSearchNodesAsyncClient nodes() {
        return new OpenSearchNodesAsyncClient(this.transport, this.transportOptions);
    }

    public OpenSearchSearchPipelineAsyncClient searchPipeline() {
        return new OpenSearchSearchPipelineAsyncClient(this.transport, this.transportOptions);
    }

    public OpenSearchSearchRelevanceAsyncClient searchRelevance() {
        return new OpenSearchSearchRelevanceAsyncClient(this.transport, this.transportOptions);
    }

    public OpenSearchSecurityAsyncClient security() {
        return new OpenSearchSecurityAsyncClient(this.transport, this.transportOptions);
    }

    public OpenSearchSnapshotAsyncClient snapshot() {
        return new OpenSearchSnapshotAsyncClient(this.transport, this.transportOptions);
    }

    public OpenSearchTasksAsyncClient tasks() {
        return new OpenSearchTasksAsyncClient(this.transport, this.transportOptions);
    }

    public OpenSearchUbiAsyncClient ubi() {
        return new OpenSearchUbiAsyncClient(this.transport, this.transportOptions);
    }

    public OpenSearchUltrawarmAsyncClient ultrawarm() {
        return new OpenSearchUltrawarmAsyncClient(this.transport, this.transportOptions);
    }

    // ----- Endpoint: clear_scroll

    /**
     * <p>
     * Explicitly clears the search context for a scroll.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public CompletableFuture<ClearScrollResponse> clearScroll(ClearScrollRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, ClearScrollRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Explicitly clears the search context for a scroll.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link ClearScrollRequest}
     */
    public final CompletableFuture<ClearScrollResponse> clearScroll(
        Function<ClearScrollRequest.Builder, ObjectBuilder<ClearScrollRequest>> fn
    ) throws IOException, OpenSearchException {
        return clearScroll(fn.apply(new ClearScrollRequest.Builder()).build());
    }

    /**
     * <p>
     * Explicitly clears the search context for a scroll.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public final CompletableFuture<ClearScrollResponse> clearScroll() throws IOException, OpenSearchException {
        return clearScroll(new ClearScrollRequest.Builder().build());
    }

    // ----- Endpoint: count

    /**
     * <p>
     * Returns number of documents matching a query.
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
     * Returns number of documents matching a query.
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
     * Returns number of documents matching a query.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public final CompletableFuture<CountResponse> count() throws IOException, OpenSearchException {
        return count(new CountRequest.Builder().build());
    }

    // ----- Endpoint: create_pit

    /**
     * <p>
     * Creates point in time context.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.4</code>
     * </p>
     */
    public CompletableFuture<CreatePitResponse> createPit(CreatePitRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, CreatePitRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Creates point in time context.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.4</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link CreatePitRequest}
     */
    public final CompletableFuture<CreatePitResponse> createPit(Function<CreatePitRequest.Builder, ObjectBuilder<CreatePitRequest>> fn)
        throws IOException, OpenSearchException {
        return createPit(fn.apply(new CreatePitRequest.Builder()).build());
    }

    // ----- Endpoint: delete

    /**
     * <p>
     * Removes a document from the index.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public CompletableFuture<DeleteResponse> delete(DeleteRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, DeleteRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Removes a document from the index.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link DeleteRequest}
     */
    public final CompletableFuture<DeleteResponse> delete(Function<DeleteRequest.Builder, ObjectBuilder<DeleteRequest>> fn)
        throws IOException, OpenSearchException {
        return delete(fn.apply(new DeleteRequest.Builder()).build());
    }

    // ----- Endpoint: delete_all_pits

    /**
     * <p>
     * Deletes all active point in time searches.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.4</code>
     * </p>
     */
    public CompletableFuture<DeleteAllPitsResponse> deleteAllPits(DeleteAllPitsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, DeleteAllPitsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Deletes all active point in time searches.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.4</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link DeleteAllPitsRequest}
     */
    public final CompletableFuture<DeleteAllPitsResponse> deleteAllPits(
        Function<DeleteAllPitsRequest.Builder, ObjectBuilder<DeleteAllPitsRequest>> fn
    ) throws IOException, OpenSearchException {
        return deleteAllPits(fn.apply(new DeleteAllPitsRequest.Builder()).build());
    }

    /**
     * <p>
     * Deletes all active point in time searches.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.4</code>
     * </p>
     */
    public final CompletableFuture<DeleteAllPitsResponse> deleteAllPits() throws IOException, OpenSearchException {
        return deleteAllPits(new DeleteAllPitsRequest.Builder().build());
    }

    // ----- Endpoint: delete_by_query

    /**
     * <p>
     * Deletes documents matching the provided query.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public CompletableFuture<DeleteByQueryResponse> deleteByQuery(DeleteByQueryRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, DeleteByQueryRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Deletes documents matching the provided query.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link DeleteByQueryRequest}
     */
    public final CompletableFuture<DeleteByQueryResponse> deleteByQuery(
        Function<DeleteByQueryRequest.Builder, ObjectBuilder<DeleteByQueryRequest>> fn
    ) throws IOException, OpenSearchException {
        return deleteByQuery(fn.apply(new DeleteByQueryRequest.Builder()).build());
    }

    // ----- Endpoint: delete_by_query_rethrottle

    /**
     * <p>
     * Changes the number of requests per second for a particular Delete By Query operation.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public CompletableFuture<DeleteByQueryRethrottleResponse> deleteByQueryRethrottle(DeleteByQueryRethrottleRequest request)
        throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, DeleteByQueryRethrottleRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Changes the number of requests per second for a particular Delete By Query operation.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link DeleteByQueryRethrottleRequest}
     */
    public final CompletableFuture<DeleteByQueryRethrottleResponse> deleteByQueryRethrottle(
        Function<DeleteByQueryRethrottleRequest.Builder, ObjectBuilder<DeleteByQueryRethrottleRequest>> fn
    ) throws IOException, OpenSearchException {
        return deleteByQueryRethrottle(fn.apply(new DeleteByQueryRethrottleRequest.Builder()).build());
    }

    // ----- Endpoint: delete_pit

    /**
     * <p>
     * Deletes one or more point in time searches based on the IDs passed.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.4</code>
     * </p>
     */
    public CompletableFuture<DeletePitResponse> deletePit(DeletePitRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, DeletePitRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Deletes one or more point in time searches based on the IDs passed.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.4</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link DeletePitRequest}
     */
    public final CompletableFuture<DeletePitResponse> deletePit(Function<DeletePitRequest.Builder, ObjectBuilder<DeletePitRequest>> fn)
        throws IOException, OpenSearchException {
        return deletePit(fn.apply(new DeletePitRequest.Builder()).build());
    }

    // ----- Endpoint: delete_script

    /**
     * <p>
     * Deletes a script.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public CompletableFuture<DeleteScriptResponse> deleteScript(DeleteScriptRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, DeleteScriptRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Deletes a script.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link DeleteScriptRequest}
     */
    public final CompletableFuture<DeleteScriptResponse> deleteScript(
        Function<DeleteScriptRequest.Builder, ObjectBuilder<DeleteScriptRequest>> fn
    ) throws IOException, OpenSearchException {
        return deleteScript(fn.apply(new DeleteScriptRequest.Builder()).build());
    }

    // ----- Endpoint: exists

    /**
     * <p>
     * Returns information about whether a document exists in an index.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public CompletableFuture<BooleanResponse> exists(ExistsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, ExistsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Returns information about whether a document exists in an index.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link ExistsRequest}
     */
    public final CompletableFuture<BooleanResponse> exists(Function<ExistsRequest.Builder, ObjectBuilder<ExistsRequest>> fn)
        throws IOException, OpenSearchException {
        return exists(fn.apply(new ExistsRequest.Builder()).build());
    }

    // ----- Endpoint: exists_source

    /**
     * <p>
     * Returns information about whether a document source exists in an index.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public CompletableFuture<BooleanResponse> existsSource(ExistsSourceRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, ExistsSourceRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Returns information about whether a document source exists in an index.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link ExistsSourceRequest}
     */
    public final CompletableFuture<BooleanResponse> existsSource(
        Function<ExistsSourceRequest.Builder, ObjectBuilder<ExistsSourceRequest>> fn
    ) throws IOException, OpenSearchException {
        return existsSource(fn.apply(new ExistsSourceRequest.Builder()).build());
    }

    // ----- Endpoint: explain

    /**
     * <p>
     * Returns information about why a specific document matches (or doesn't match) a query.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public <TDocument> CompletableFuture<ExplainResponse<TDocument>> explain(ExplainRequest request, Class<TDocument> tDocumentClass)
        throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<ExplainRequest, ExplainResponse<TDocument>, ErrorResponse> endpoint = (JsonEndpoint<
            ExplainRequest,
            ExplainResponse<TDocument>,
            ErrorResponse>) ExplainRequest._ENDPOINT;
        endpoint = new EndpointWithResponseMapperAttr<>(
            endpoint,
            "software.amazon.awssdk.opensearch.client:Deserializer:_global.explain.TDocument",
            getDeserializer(tDocumentClass)
        );

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * <p>
     * Returns information about why a specific document matches (or doesn't match) a query.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link ExplainRequest}
     */
    public final <TDocument> CompletableFuture<ExplainResponse<TDocument>> explain(
        Function<ExplainRequest.Builder, ObjectBuilder<ExplainRequest>> fn,
        Class<TDocument> tDocumentClass
    ) throws IOException, OpenSearchException {
        return explain(fn.apply(new ExplainRequest.Builder()).build(), tDocumentClass);
    }

    // ----- Endpoint: field_caps

    /**
     * <p>
     * Returns the information about the capabilities of fields among multiple indexes.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public CompletableFuture<FieldCapsResponse> fieldCaps(FieldCapsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, FieldCapsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Returns the information about the capabilities of fields among multiple indexes.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link FieldCapsRequest}
     */
    public final CompletableFuture<FieldCapsResponse> fieldCaps(Function<FieldCapsRequest.Builder, ObjectBuilder<FieldCapsRequest>> fn)
        throws IOException, OpenSearchException {
        return fieldCaps(fn.apply(new FieldCapsRequest.Builder()).build());
    }

    /**
     * <p>
     * Returns the information about the capabilities of fields among multiple indexes.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public final CompletableFuture<FieldCapsResponse> fieldCaps() throws IOException, OpenSearchException {
        return fieldCaps(new FieldCapsRequest.Builder().build());
    }

    // ----- Endpoint: get

    /**
     * <p>
     * Returns a document.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public <TDocument> CompletableFuture<GetResponse<TDocument>> get(GetRequest request, Class<TDocument> tDocumentClass)
        throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<GetRequest, GetResponse<TDocument>, ErrorResponse> endpoint = (JsonEndpoint<
            GetRequest,
            GetResponse<TDocument>,
            ErrorResponse>) GetRequest._ENDPOINT;
        endpoint = new EndpointWithResponseMapperAttr<>(
            endpoint,
            "software.amazon.awssdk.opensearch.client:Deserializer:_global.get.TDocument",
            getDeserializer(tDocumentClass)
        );

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * <p>
     * Returns a document.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link GetRequest}
     */
    public final <TDocument> CompletableFuture<GetResponse<TDocument>> get(
        Function<GetRequest.Builder, ObjectBuilder<GetRequest>> fn,
        Class<TDocument> tDocumentClass
    ) throws IOException, OpenSearchException {
        return get(fn.apply(new GetRequest.Builder()).build(), tDocumentClass);
    }

    // ----- Endpoint: get_all_pits

    /**
     * <p>
     * Lists all active point in time searches.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.4</code>
     * </p>
     */
    public CompletableFuture<GetAllPitsResponse> getAllPits(GetAllPitsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, GetAllPitsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Lists all active point in time searches.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.4</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link GetAllPitsRequest}
     */
    public final CompletableFuture<GetAllPitsResponse> getAllPits(Function<GetAllPitsRequest.Builder, ObjectBuilder<GetAllPitsRequest>> fn)
        throws IOException, OpenSearchException {
        return getAllPits(fn.apply(new GetAllPitsRequest.Builder()).build());
    }

    /**
     * <p>
     * Lists all active point in time searches.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.4</code>
     * </p>
     */
    public final CompletableFuture<GetAllPitsResponse> getAllPits() throws IOException, OpenSearchException {
        return getAllPits(new GetAllPitsRequest.Builder().build());
    }

    // ----- Endpoint: get_script

    /**
     * <p>
     * Returns a script.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public CompletableFuture<GetScriptResponse> getScript(GetScriptRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, GetScriptRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Returns a script.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link GetScriptRequest}
     */
    public final CompletableFuture<GetScriptResponse> getScript(Function<GetScriptRequest.Builder, ObjectBuilder<GetScriptRequest>> fn)
        throws IOException, OpenSearchException {
        return getScript(fn.apply(new GetScriptRequest.Builder()).build());
    }

    // ----- Endpoint: get_source

    /**
     * <p>
     * Returns the source of a document.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public <TDocument> CompletableFuture<GetSourceResponse<TDocument>> getSource(GetSourceRequest request, Class<TDocument> tDocumentClass)
        throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<GetSourceRequest, GetSourceResponse<TDocument>, ErrorResponse> endpoint = (JsonEndpoint<
            GetSourceRequest,
            GetSourceResponse<TDocument>,
            ErrorResponse>) GetSourceRequest._ENDPOINT;
        endpoint = new EndpointWithResponseMapperAttr<>(
            endpoint,
            "software.amazon.awssdk.opensearch.client:Deserializer:_global.get_source.TDocument",
            getDeserializer(tDocumentClass)
        );

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * <p>
     * Returns the source of a document.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link GetSourceRequest}
     */
    public final <TDocument> CompletableFuture<GetSourceResponse<TDocument>> getSource(
        Function<GetSourceRequest.Builder, ObjectBuilder<GetSourceRequest>> fn,
        Class<TDocument> tDocumentClass
    ) throws IOException, OpenSearchException {
        return getSource(fn.apply(new GetSourceRequest.Builder()).build(), tDocumentClass);
    }

    // ----- Endpoint: info

    /**
     * <p>
     * Returns basic information about the cluster.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public CompletableFuture<InfoResponse> info(InfoRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, InfoRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Returns basic information about the cluster.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link InfoRequest}
     */
    public final CompletableFuture<InfoResponse> info(Function<InfoRequest.Builder, ObjectBuilder<InfoRequest>> fn) throws IOException,
        OpenSearchException {
        return info(fn.apply(new InfoRequest.Builder()).build());
    }

    /**
     * <p>
     * Returns basic information about the cluster.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public final CompletableFuture<InfoResponse> info() throws IOException, OpenSearchException {
        return info(new InfoRequest.Builder().build());
    }

    // ----- Endpoint: mtermvectors

    /**
     * <p>
     * Returns multiple termvectors in one request.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public CompletableFuture<MtermvectorsResponse> mtermvectors(MtermvectorsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, MtermvectorsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Returns multiple termvectors in one request.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link MtermvectorsRequest}
     */
    public final CompletableFuture<MtermvectorsResponse> mtermvectors(
        Function<MtermvectorsRequest.Builder, ObjectBuilder<MtermvectorsRequest>> fn
    ) throws IOException, OpenSearchException {
        return mtermvectors(fn.apply(new MtermvectorsRequest.Builder()).build());
    }

    /**
     * <p>
     * Returns multiple termvectors in one request.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public final CompletableFuture<MtermvectorsResponse> mtermvectors() throws IOException, OpenSearchException {
        return mtermvectors(new MtermvectorsRequest.Builder().build());
    }

    // ----- Endpoint: ping

    /**
     * <p>
     * Returns whether the cluster is running.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public CompletableFuture<BooleanResponse> ping(PingRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, PingRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Returns whether the cluster is running.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link PingRequest}
     */
    public final CompletableFuture<BooleanResponse> ping(Function<PingRequest.Builder, ObjectBuilder<PingRequest>> fn) throws IOException,
        OpenSearchException {
        return ping(fn.apply(new PingRequest.Builder()).build());
    }

    /**
     * <p>
     * Returns whether the cluster is running.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public final CompletableFuture<BooleanResponse> ping() throws IOException, OpenSearchException {
        return ping(new PingRequest.Builder().build());
    }

    // ----- Endpoint: put_script

    /**
     * <p>
     * Creates or updates a script.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public CompletableFuture<PutScriptResponse> putScript(PutScriptRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, PutScriptRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Creates or updates a script.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link PutScriptRequest}
     */
    public final CompletableFuture<PutScriptResponse> putScript(Function<PutScriptRequest.Builder, ObjectBuilder<PutScriptRequest>> fn)
        throws IOException, OpenSearchException {
        return putScript(fn.apply(new PutScriptRequest.Builder()).build());
    }

    // ----- Endpoint: rank_eval

    /**
     * <p>
     * Allows to evaluate the quality of ranked search results over a set of typical search queries.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public CompletableFuture<RankEvalResponse> rankEval(RankEvalRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, RankEvalRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Allows to evaluate the quality of ranked search results over a set of typical search queries.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link RankEvalRequest}
     */
    public final CompletableFuture<RankEvalResponse> rankEval(Function<RankEvalRequest.Builder, ObjectBuilder<RankEvalRequest>> fn)
        throws IOException, OpenSearchException {
        return rankEval(fn.apply(new RankEvalRequest.Builder()).build());
    }

    // ----- Endpoint: reindex

    /**
     * <p>
     * Allows to copy documents from one index to another, optionally filtering the source documents by a query, changing the destination
     * index settings, or fetching the documents from a remote cluster.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public CompletableFuture<ReindexResponse> reindex(ReindexRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, ReindexRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Allows to copy documents from one index to another, optionally filtering the source documents by a query, changing the destination
     * index settings, or fetching the documents from a remote cluster.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link ReindexRequest}
     */
    public final CompletableFuture<ReindexResponse> reindex(Function<ReindexRequest.Builder, ObjectBuilder<ReindexRequest>> fn)
        throws IOException, OpenSearchException {
        return reindex(fn.apply(new ReindexRequest.Builder()).build());
    }

    // ----- Endpoint: reindex_rethrottle

    /**
     * <p>
     * Changes the number of requests per second for a particular reindex operation.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public CompletableFuture<ReindexRethrottleResponse> reindexRethrottle(ReindexRethrottleRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, ReindexRethrottleRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Changes the number of requests per second for a particular reindex operation.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link ReindexRethrottleRequest}
     */
    public final CompletableFuture<ReindexRethrottleResponse> reindexRethrottle(
        Function<ReindexRethrottleRequest.Builder, ObjectBuilder<ReindexRethrottleRequest>> fn
    ) throws IOException, OpenSearchException {
        return reindexRethrottle(fn.apply(new ReindexRethrottleRequest.Builder()).build());
    }

    // ----- Endpoint: render_search_template

    /**
     * <p>
     * Allows to use the Mustache language to pre-render a search definition.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public CompletableFuture<RenderSearchTemplateResponse> renderSearchTemplate(RenderSearchTemplateRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, RenderSearchTemplateRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Allows to use the Mustache language to pre-render a search definition.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link RenderSearchTemplateRequest}
     */
    public final CompletableFuture<RenderSearchTemplateResponse> renderSearchTemplate(
        Function<RenderSearchTemplateRequest.Builder, ObjectBuilder<RenderSearchTemplateRequest>> fn
    ) throws IOException, OpenSearchException {
        return renderSearchTemplate(fn.apply(new RenderSearchTemplateRequest.Builder()).build());
    }

    /**
     * <p>
     * Allows to use the Mustache language to pre-render a search definition.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public final CompletableFuture<RenderSearchTemplateResponse> renderSearchTemplate() throws IOException, OpenSearchException {
        return renderSearchTemplate(new RenderSearchTemplateRequest.Builder().build());
    }

    // ----- Endpoint: scripts_painless_execute

    /**
     * <p>
     * Allows an arbitrary script to be executed and a result to be returned.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public <TResult> CompletableFuture<ScriptsPainlessExecuteResponse<TResult>> scriptsPainlessExecute(
        ScriptsPainlessExecuteRequest request,
        Class<TResult> tResultClass
    ) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<ScriptsPainlessExecuteRequest, ScriptsPainlessExecuteResponse<TResult>, ErrorResponse> endpoint = (JsonEndpoint<
            ScriptsPainlessExecuteRequest,
            ScriptsPainlessExecuteResponse<TResult>,
            ErrorResponse>) ScriptsPainlessExecuteRequest._ENDPOINT;
        endpoint = new EndpointWithResponseMapperAttr<>(
            endpoint,
            "software.amazon.awssdk.opensearch.client:Deserializer:_global.scripts_painless_execute.TResult",
            getDeserializer(tResultClass)
        );

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * <p>
     * Allows an arbitrary script to be executed and a result to be returned.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link ScriptsPainlessExecuteRequest}
     */
    public final <TResult> CompletableFuture<ScriptsPainlessExecuteResponse<TResult>> scriptsPainlessExecute(
        Function<ScriptsPainlessExecuteRequest.Builder, ObjectBuilder<ScriptsPainlessExecuteRequest>> fn,
        Class<TResult> tResultClass
    ) throws IOException, OpenSearchException {
        return scriptsPainlessExecute(fn.apply(new ScriptsPainlessExecuteRequest.Builder()).build(), tResultClass);
    }

    // ----- Endpoint: scroll

    /**
     * <p>
     * Allows to retrieve a large numbers of results from a single search request.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public <TDocument> CompletableFuture<ScrollResponse<TDocument>> scroll(ScrollRequest request, Class<TDocument> tDocumentClass)
        throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<ScrollRequest, ScrollResponse<TDocument>, ErrorResponse> endpoint = (JsonEndpoint<
            ScrollRequest,
            ScrollResponse<TDocument>,
            ErrorResponse>) ScrollRequest._ENDPOINT;
        endpoint = new EndpointWithResponseMapperAttr<>(
            endpoint,
            "software.amazon.awssdk.opensearch.client:Deserializer:_global.scroll.TDocument",
            getDeserializer(tDocumentClass)
        );

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * <p>
     * Allows to retrieve a large numbers of results from a single search request.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link ScrollRequest}
     */
    public final <TDocument> CompletableFuture<ScrollResponse<TDocument>> scroll(
        Function<ScrollRequest.Builder, ObjectBuilder<ScrollRequest>> fn,
        Class<TDocument> tDocumentClass
    ) throws IOException, OpenSearchException {
        return scroll(fn.apply(new ScrollRequest.Builder()).build(), tDocumentClass);
    }

    // ----- Endpoint: search

    /**
     * <p>
     * Returns results matching a query.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public <TDocument> CompletableFuture<SearchResponse<TDocument>> search(SearchRequest request, Class<TDocument> tDocumentClass)
        throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<SearchRequest, SearchResponse<TDocument>, ErrorResponse> endpoint = (JsonEndpoint<
            SearchRequest,
            SearchResponse<TDocument>,
            ErrorResponse>) SearchRequest._ENDPOINT;
        endpoint = new EndpointWithResponseMapperAttr<>(
            endpoint,
            "software.amazon.awssdk.opensearch.client:Deserializer:_global.search.TDocument",
            getDeserializer(tDocumentClass)
        );

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * <p>
     * Returns results matching a query.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link SearchRequest}
     */
    public final <TDocument> CompletableFuture<SearchResponse<TDocument>> search(
        Function<SearchRequest.Builder, ObjectBuilder<SearchRequest>> fn,
        Class<TDocument> tDocumentClass
    ) throws IOException, OpenSearchException {
        return search(fn.apply(new SearchRequest.Builder()).build(), tDocumentClass);
    }

    // ----- Endpoint: search_shards

    /**
     * <p>
     * Returns information about the indexes and shards that a search request would be executed against.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public CompletableFuture<SearchShardsResponse> searchShards(SearchShardsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, SearchShardsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Returns information about the indexes and shards that a search request would be executed against.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link SearchShardsRequest}
     */
    public final CompletableFuture<SearchShardsResponse> searchShards(
        Function<SearchShardsRequest.Builder, ObjectBuilder<SearchShardsRequest>> fn
    ) throws IOException, OpenSearchException {
        return searchShards(fn.apply(new SearchShardsRequest.Builder()).build());
    }

    // ----- Endpoint: search_template

    /**
     * <p>
     * Allows to use the Mustache language to pre-render a search definition.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public <TDocument> CompletableFuture<SearchTemplateResponse<TDocument>> searchTemplate(
        SearchTemplateRequest request,
        Class<TDocument> tDocumentClass
    ) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<SearchTemplateRequest, SearchTemplateResponse<TDocument>, ErrorResponse> endpoint = (JsonEndpoint<
            SearchTemplateRequest,
            SearchTemplateResponse<TDocument>,
            ErrorResponse>) SearchTemplateRequest._ENDPOINT;
        endpoint = new EndpointWithResponseMapperAttr<>(
            endpoint,
            "software.amazon.awssdk.opensearch.client:Deserializer:_global.search_template.TDocument",
            getDeserializer(tDocumentClass)
        );

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * <p>
     * Allows to use the Mustache language to pre-render a search definition.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link SearchTemplateRequest}
     */
    public final <TDocument> CompletableFuture<SearchTemplateResponse<TDocument>> searchTemplate(
        Function<SearchTemplateRequest.Builder, ObjectBuilder<SearchTemplateRequest>> fn,
        Class<TDocument> tDocumentClass
    ) throws IOException, OpenSearchException {
        return searchTemplate(fn.apply(new SearchTemplateRequest.Builder()).build(), tDocumentClass);
    }

    // ----- Endpoint: update_by_query

    /**
     * <p>
     * Performs an update on every document in the index without changing the source, for example to pick up a mapping change.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public CompletableFuture<UpdateByQueryResponse> updateByQuery(UpdateByQueryRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, UpdateByQueryRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Performs an update on every document in the index without changing the source, for example to pick up a mapping change.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link UpdateByQueryRequest}
     */
    public final CompletableFuture<UpdateByQueryResponse> updateByQuery(
        Function<UpdateByQueryRequest.Builder, ObjectBuilder<UpdateByQueryRequest>> fn
    ) throws IOException, OpenSearchException {
        return updateByQuery(fn.apply(new UpdateByQueryRequest.Builder()).build());
    }

    // ----- Endpoint: update_by_query_rethrottle

    /**
     * <p>
     * Changes the number of requests per second for a particular Update By Query operation.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public CompletableFuture<UpdateByQueryRethrottleResponse> updateByQueryRethrottle(UpdateByQueryRethrottleRequest request)
        throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, UpdateByQueryRethrottleRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Changes the number of requests per second for a particular Update By Query operation.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link UpdateByQueryRethrottleRequest}
     */
    public final CompletableFuture<UpdateByQueryRethrottleResponse> updateByQueryRethrottle(
        Function<UpdateByQueryRethrottleRequest.Builder, ObjectBuilder<UpdateByQueryRethrottleRequest>> fn
    ) throws IOException, OpenSearchException {
        return updateByQueryRethrottle(fn.apply(new UpdateByQueryRethrottleRequest.Builder()).build());
    }
}
