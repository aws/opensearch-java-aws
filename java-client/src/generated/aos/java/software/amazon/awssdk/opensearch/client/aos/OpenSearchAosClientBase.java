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
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nullable;
import software.amazon.awssdk.opensearch.client.ApiClient;
import software.amazon.awssdk.opensearch.client.aos.cat.OpenSearchCatClient;
import software.amazon.awssdk.opensearch.client.aos.cluster.OpenSearchClusterClient;
import software.amazon.awssdk.opensearch.client.aos.cold.OpenSearchColdClient;
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
import software.amazon.awssdk.opensearch.client.aos.geospatial.OpenSearchGeospatialClient;
import software.amazon.awssdk.opensearch.client.aos.indices.OpenSearchIndicesClient;
import software.amazon.awssdk.opensearch.client.aos.ingest.OpenSearchIngestClient;
import software.amazon.awssdk.opensearch.client.aos.ingestion.OpenSearchIngestionClient;
import software.amazon.awssdk.opensearch.client.aos.ism.OpenSearchIsmClient;
import software.amazon.awssdk.opensearch.client.aos.knn.OpenSearchKnnClient;
import software.amazon.awssdk.opensearch.client.aos.ltr.OpenSearchLtrClient;
import software.amazon.awssdk.opensearch.client.aos.ml.OpenSearchMlClient;
import software.amazon.awssdk.opensearch.client.aos.nodes.OpenSearchNodesClient;
import software.amazon.awssdk.opensearch.client.aos.search_pipeline.OpenSearchSearchPipelineClient;
import software.amazon.awssdk.opensearch.client.aos.search_relevance.OpenSearchSearchRelevanceClient;
import software.amazon.awssdk.opensearch.client.aos.security.OpenSearchSecurityClient;
import software.amazon.awssdk.opensearch.client.aos.snapshot.OpenSearchSnapshotClient;
import software.amazon.awssdk.opensearch.client.aos.tasks.OpenSearchTasksClient;
import software.amazon.awssdk.opensearch.client.aos.ubi.OpenSearchUbiClient;
import software.amazon.awssdk.opensearch.client.aos.ultrawarm.OpenSearchUltrawarmClient;
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
public abstract class OpenSearchAosClientBase<Self extends OpenSearchAosClientBase<Self>> extends ApiClient<OpenSearchTransport, Self> {
    public OpenSearchAosClientBase(OpenSearchTransport transport, @Nullable TransportOptions transportOptions) {
        super(transport, transportOptions);
    }

    // ----- Child clients

    public OpenSearchCatClient cat() {
        return new OpenSearchCatClient(this.transport, this.transportOptions);
    }

    public OpenSearchClusterClient cluster() {
        return new OpenSearchClusterClient(this.transport, this.transportOptions);
    }

    public OpenSearchColdClient cold() {
        return new OpenSearchColdClient(this.transport, this.transportOptions);
    }

    public OpenSearchGeospatialClient geospatial() {
        return new OpenSearchGeospatialClient(this.transport, this.transportOptions);
    }

    public OpenSearchIndicesClient indices() {
        return new OpenSearchIndicesClient(this.transport, this.transportOptions);
    }

    public OpenSearchIngestClient ingest() {
        return new OpenSearchIngestClient(this.transport, this.transportOptions);
    }

    public OpenSearchIngestionClient ingestion() {
        return new OpenSearchIngestionClient(this.transport, this.transportOptions);
    }

    public OpenSearchIsmClient ism() {
        return new OpenSearchIsmClient(this.transport, this.transportOptions);
    }

    public OpenSearchKnnClient knn() {
        return new OpenSearchKnnClient(this.transport, this.transportOptions);
    }

    public OpenSearchLtrClient ltr() {
        return new OpenSearchLtrClient(this.transport, this.transportOptions);
    }

    public OpenSearchMlClient ml() {
        return new OpenSearchMlClient(this.transport, this.transportOptions);
    }

    public OpenSearchNodesClient nodes() {
        return new OpenSearchNodesClient(this.transport, this.transportOptions);
    }

    public OpenSearchSearchPipelineClient searchPipeline() {
        return new OpenSearchSearchPipelineClient(this.transport, this.transportOptions);
    }

    public OpenSearchSearchRelevanceClient searchRelevance() {
        return new OpenSearchSearchRelevanceClient(this.transport, this.transportOptions);
    }

    public OpenSearchSecurityClient security() {
        return new OpenSearchSecurityClient(this.transport, this.transportOptions);
    }

    public OpenSearchSnapshotClient snapshot() {
        return new OpenSearchSnapshotClient(this.transport, this.transportOptions);
    }

    public OpenSearchTasksClient tasks() {
        return new OpenSearchTasksClient(this.transport, this.transportOptions);
    }

    public OpenSearchUbiClient ubi() {
        return new OpenSearchUbiClient(this.transport, this.transportOptions);
    }

    public OpenSearchUltrawarmClient ultrawarm() {
        return new OpenSearchUltrawarmClient(this.transport, this.transportOptions);
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
    public ClearScrollResponse clearScroll(ClearScrollRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, ClearScrollRequest._ENDPOINT, this.transportOptions);
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
    public final ClearScrollResponse clearScroll(Function<ClearScrollRequest.Builder, ObjectBuilder<ClearScrollRequest>> fn)
        throws IOException, OpenSearchException {
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
    public final ClearScrollResponse clearScroll() throws IOException, OpenSearchException {
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
    public CountResponse count(CountRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, CountRequest._ENDPOINT, this.transportOptions);
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
    public final CountResponse count(Function<CountRequest.Builder, ObjectBuilder<CountRequest>> fn) throws IOException,
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
    public final CountResponse count() throws IOException, OpenSearchException {
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
    public CreatePitResponse createPit(CreatePitRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, CreatePitRequest._ENDPOINT, this.transportOptions);
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
    public final CreatePitResponse createPit(Function<CreatePitRequest.Builder, ObjectBuilder<CreatePitRequest>> fn) throws IOException,
        OpenSearchException {
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
    public DeleteResponse delete(DeleteRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, DeleteRequest._ENDPOINT, this.transportOptions);
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
    public final DeleteResponse delete(Function<DeleteRequest.Builder, ObjectBuilder<DeleteRequest>> fn) throws IOException,
        OpenSearchException {
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
    public DeleteAllPitsResponse deleteAllPits(DeleteAllPitsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, DeleteAllPitsRequest._ENDPOINT, this.transportOptions);
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
    public final DeleteAllPitsResponse deleteAllPits(Function<DeleteAllPitsRequest.Builder, ObjectBuilder<DeleteAllPitsRequest>> fn)
        throws IOException, OpenSearchException {
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
    public final DeleteAllPitsResponse deleteAllPits() throws IOException, OpenSearchException {
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
    public DeleteByQueryResponse deleteByQuery(DeleteByQueryRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, DeleteByQueryRequest._ENDPOINT, this.transportOptions);
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
    public final DeleteByQueryResponse deleteByQuery(Function<DeleteByQueryRequest.Builder, ObjectBuilder<DeleteByQueryRequest>> fn)
        throws IOException, OpenSearchException {
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
    public DeleteByQueryRethrottleResponse deleteByQueryRethrottle(DeleteByQueryRethrottleRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequest(request, DeleteByQueryRethrottleRequest._ENDPOINT, this.transportOptions);
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
    public final DeleteByQueryRethrottleResponse deleteByQueryRethrottle(
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
    public DeletePitResponse deletePit(DeletePitRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, DeletePitRequest._ENDPOINT, this.transportOptions);
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
    public final DeletePitResponse deletePit(Function<DeletePitRequest.Builder, ObjectBuilder<DeletePitRequest>> fn) throws IOException,
        OpenSearchException {
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
    public DeleteScriptResponse deleteScript(DeleteScriptRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, DeleteScriptRequest._ENDPOINT, this.transportOptions);
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
    public final DeleteScriptResponse deleteScript(Function<DeleteScriptRequest.Builder, ObjectBuilder<DeleteScriptRequest>> fn)
        throws IOException, OpenSearchException {
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
    public BooleanResponse exists(ExistsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, ExistsRequest._ENDPOINT, this.transportOptions);
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
    public final BooleanResponse exists(Function<ExistsRequest.Builder, ObjectBuilder<ExistsRequest>> fn) throws IOException,
        OpenSearchException {
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
    public BooleanResponse existsSource(ExistsSourceRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, ExistsSourceRequest._ENDPOINT, this.transportOptions);
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
    public final BooleanResponse existsSource(Function<ExistsSourceRequest.Builder, ObjectBuilder<ExistsSourceRequest>> fn)
        throws IOException, OpenSearchException {
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
    public <TDocument> ExplainResponse<TDocument> explain(ExplainRequest request, Class<TDocument> tDocumentClass) throws IOException,
        OpenSearchException {
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

        return this.transport.performRequest(request, endpoint, this.transportOptions);
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
    public final <TDocument> ExplainResponse<TDocument> explain(
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
    public FieldCapsResponse fieldCaps(FieldCapsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, FieldCapsRequest._ENDPOINT, this.transportOptions);
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
    public final FieldCapsResponse fieldCaps(Function<FieldCapsRequest.Builder, ObjectBuilder<FieldCapsRequest>> fn) throws IOException,
        OpenSearchException {
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
    public final FieldCapsResponse fieldCaps() throws IOException, OpenSearchException {
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
    public <TDocument> GetResponse<TDocument> get(GetRequest request, Class<TDocument> tDocumentClass) throws IOException,
        OpenSearchException {
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

        return this.transport.performRequest(request, endpoint, this.transportOptions);
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
    public final <TDocument> GetResponse<TDocument> get(
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
    public GetAllPitsResponse getAllPits(GetAllPitsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetAllPitsRequest._ENDPOINT, this.transportOptions);
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
    public final GetAllPitsResponse getAllPits(Function<GetAllPitsRequest.Builder, ObjectBuilder<GetAllPitsRequest>> fn) throws IOException,
        OpenSearchException {
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
    public final GetAllPitsResponse getAllPits() throws IOException, OpenSearchException {
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
    public GetScriptResponse getScript(GetScriptRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetScriptRequest._ENDPOINT, this.transportOptions);
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
    public final GetScriptResponse getScript(Function<GetScriptRequest.Builder, ObjectBuilder<GetScriptRequest>> fn) throws IOException,
        OpenSearchException {
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
    public <TDocument> GetSourceResponse<TDocument> getSource(GetSourceRequest request, Class<TDocument> tDocumentClass) throws IOException,
        OpenSearchException {
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

        return this.transport.performRequest(request, endpoint, this.transportOptions);
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
    public final <TDocument> GetSourceResponse<TDocument> getSource(
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
    public InfoResponse info(InfoRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, InfoRequest._ENDPOINT, this.transportOptions);
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
    public final InfoResponse info(Function<InfoRequest.Builder, ObjectBuilder<InfoRequest>> fn) throws IOException, OpenSearchException {
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
    public final InfoResponse info() throws IOException, OpenSearchException {
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
    public MtermvectorsResponse mtermvectors(MtermvectorsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, MtermvectorsRequest._ENDPOINT, this.transportOptions);
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
    public final MtermvectorsResponse mtermvectors(Function<MtermvectorsRequest.Builder, ObjectBuilder<MtermvectorsRequest>> fn)
        throws IOException, OpenSearchException {
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
    public final MtermvectorsResponse mtermvectors() throws IOException, OpenSearchException {
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
    public BooleanResponse ping(PingRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, PingRequest._ENDPOINT, this.transportOptions);
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
    public final BooleanResponse ping(Function<PingRequest.Builder, ObjectBuilder<PingRequest>> fn) throws IOException,
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
    public final BooleanResponse ping() throws IOException, OpenSearchException {
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
    public PutScriptResponse putScript(PutScriptRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, PutScriptRequest._ENDPOINT, this.transportOptions);
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
    public final PutScriptResponse putScript(Function<PutScriptRequest.Builder, ObjectBuilder<PutScriptRequest>> fn) throws IOException,
        OpenSearchException {
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
    public RankEvalResponse rankEval(RankEvalRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, RankEvalRequest._ENDPOINT, this.transportOptions);
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
    public final RankEvalResponse rankEval(Function<RankEvalRequest.Builder, ObjectBuilder<RankEvalRequest>> fn) throws IOException,
        OpenSearchException {
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
    public ReindexResponse reindex(ReindexRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, ReindexRequest._ENDPOINT, this.transportOptions);
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
    public final ReindexResponse reindex(Function<ReindexRequest.Builder, ObjectBuilder<ReindexRequest>> fn) throws IOException,
        OpenSearchException {
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
    public ReindexRethrottleResponse reindexRethrottle(ReindexRethrottleRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, ReindexRethrottleRequest._ENDPOINT, this.transportOptions);
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
    public final ReindexRethrottleResponse reindexRethrottle(
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
    public RenderSearchTemplateResponse renderSearchTemplate(RenderSearchTemplateRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, RenderSearchTemplateRequest._ENDPOINT, this.transportOptions);
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
    public final RenderSearchTemplateResponse renderSearchTemplate(
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
    public final RenderSearchTemplateResponse renderSearchTemplate() throws IOException, OpenSearchException {
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
    public <TResult> ScriptsPainlessExecuteResponse<TResult> scriptsPainlessExecute(
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

        return this.transport.performRequest(request, endpoint, this.transportOptions);
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
    public final <TResult> ScriptsPainlessExecuteResponse<TResult> scriptsPainlessExecute(
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
    public <TDocument> ScrollResponse<TDocument> scroll(ScrollRequest request, Class<TDocument> tDocumentClass) throws IOException,
        OpenSearchException {
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

        return this.transport.performRequest(request, endpoint, this.transportOptions);
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
    public final <TDocument> ScrollResponse<TDocument> scroll(
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
    public <TDocument> SearchResponse<TDocument> search(SearchRequest request, Class<TDocument> tDocumentClass) throws IOException,
        OpenSearchException {
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

        return this.transport.performRequest(request, endpoint, this.transportOptions);
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
    public final <TDocument> SearchResponse<TDocument> search(
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
    public SearchShardsResponse searchShards(SearchShardsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, SearchShardsRequest._ENDPOINT, this.transportOptions);
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
    public final SearchShardsResponse searchShards(Function<SearchShardsRequest.Builder, ObjectBuilder<SearchShardsRequest>> fn)
        throws IOException, OpenSearchException {
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
    public <TDocument> SearchTemplateResponse<TDocument> searchTemplate(SearchTemplateRequest request, Class<TDocument> tDocumentClass)
        throws IOException, OpenSearchException {
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

        return this.transport.performRequest(request, endpoint, this.transportOptions);
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
    public final <TDocument> SearchTemplateResponse<TDocument> searchTemplate(
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
    public UpdateByQueryResponse updateByQuery(UpdateByQueryRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, UpdateByQueryRequest._ENDPOINT, this.transportOptions);
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
    public final UpdateByQueryResponse updateByQuery(Function<UpdateByQueryRequest.Builder, ObjectBuilder<UpdateByQueryRequest>> fn)
        throws IOException, OpenSearchException {
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
    public UpdateByQueryRethrottleResponse updateByQueryRethrottle(UpdateByQueryRethrottleRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequest(request, UpdateByQueryRethrottleRequest._ENDPOINT, this.transportOptions);
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
    public final UpdateByQueryRethrottleResponse updateByQueryRethrottle(
        Function<UpdateByQueryRethrottleRequest.Builder, ObjectBuilder<UpdateByQueryRethrottleRequest>> fn
    ) throws IOException, OpenSearchException {
        return updateByQueryRethrottle(fn.apply(new UpdateByQueryRethrottleRequest.Builder()).build());
    }
}
