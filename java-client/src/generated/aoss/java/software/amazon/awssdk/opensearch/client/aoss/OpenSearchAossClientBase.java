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

package software.amazon.awssdk.opensearch.client.aoss;

import java.io.IOException;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nullable;
import software.amazon.awssdk.opensearch.client.ApiClient;
import software.amazon.awssdk.opensearch.client.aoss.cat.OpenSearchCatClient;
import software.amazon.awssdk.opensearch.client.aoss.cluster.OpenSearchClusterClient;
import software.amazon.awssdk.opensearch.client.aoss.core.CountRequest;
import software.amazon.awssdk.opensearch.client.aoss.core.CountResponse;
import software.amazon.awssdk.opensearch.client.aoss.core.CreatePitRequest;
import software.amazon.awssdk.opensearch.client.aoss.core.CreatePitResponse;
import software.amazon.awssdk.opensearch.client.aoss.core.DeleteAllPitsRequest;
import software.amazon.awssdk.opensearch.client.aoss.core.DeleteAllPitsResponse;
import software.amazon.awssdk.opensearch.client.aoss.core.DeletePitRequest;
import software.amazon.awssdk.opensearch.client.aoss.core.DeletePitResponse;
import software.amazon.awssdk.opensearch.client.aoss.core.DeleteRequest;
import software.amazon.awssdk.opensearch.client.aoss.core.DeleteResponse;
import software.amazon.awssdk.opensearch.client.aoss.core.ExistsRequest;
import software.amazon.awssdk.opensearch.client.aoss.core.ExistsSourceRequest;
import software.amazon.awssdk.opensearch.client.aoss.core.ExplainRequest;
import software.amazon.awssdk.opensearch.client.aoss.core.ExplainResponse;
import software.amazon.awssdk.opensearch.client.aoss.core.FieldCapsRequest;
import software.amazon.awssdk.opensearch.client.aoss.core.FieldCapsResponse;
import software.amazon.awssdk.opensearch.client.aoss.core.GetAllPitsRequest;
import software.amazon.awssdk.opensearch.client.aoss.core.GetAllPitsResponse;
import software.amazon.awssdk.opensearch.client.aoss.core.GetRequest;
import software.amazon.awssdk.opensearch.client.aoss.core.GetResponse;
import software.amazon.awssdk.opensearch.client.aoss.core.GetSourceRequest;
import software.amazon.awssdk.opensearch.client.aoss.core.GetSourceResponse;
import software.amazon.awssdk.opensearch.client.aoss.core.RankEvalRequest;
import software.amazon.awssdk.opensearch.client.aoss.core.RankEvalResponse;
import software.amazon.awssdk.opensearch.client.aoss.core.SearchRequest;
import software.amazon.awssdk.opensearch.client.aoss.core.SearchResponse;
import software.amazon.awssdk.opensearch.client.aoss.indices.OpenSearchIndicesClient;
import software.amazon.awssdk.opensearch.client.aoss.ingest.OpenSearchIngestClient;
import software.amazon.awssdk.opensearch.client.aoss.ml.OpenSearchMlClient;
import software.amazon.awssdk.opensearch.client.aoss.search_pipeline.OpenSearchSearchPipelineClient;
import software.amazon.awssdk.opensearch.client.aoss.snapshot.OpenSearchSnapshotClient;
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
public abstract class OpenSearchAossClientBase<Self extends OpenSearchAossClientBase<Self>> extends ApiClient<OpenSearchTransport, Self> {
    public OpenSearchAossClientBase(OpenSearchTransport transport, @Nullable TransportOptions transportOptions) {
        super(transport, transportOptions);
    }

    // ----- Child clients

    public OpenSearchCatClient cat() {
        return new OpenSearchCatClient(this.transport, this.transportOptions);
    }

    public OpenSearchClusterClient cluster() {
        return new OpenSearchClusterClient(this.transport, this.transportOptions);
    }

    public OpenSearchIndicesClient indices() {
        return new OpenSearchIndicesClient(this.transport, this.transportOptions);
    }

    public OpenSearchIngestClient ingest() {
        return new OpenSearchIngestClient(this.transport, this.transportOptions);
    }

    public OpenSearchMlClient ml() {
        return new OpenSearchMlClient(this.transport, this.transportOptions);
    }

    public OpenSearchSearchPipelineClient searchPipeline() {
        return new OpenSearchSearchPipelineClient(this.transport, this.transportOptions);
    }

    public OpenSearchSnapshotClient snapshot() {
        return new OpenSearchSnapshotClient(this.transport, this.transportOptions);
    }

    // ----- Endpoint: count

    /**
     * Returns number of documents matching a query.
     */
    public CountResponse count(CountRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, CountRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns number of documents matching a query.
     *
     * @param fn a function that initializes a builder to create the {@link CountRequest}
     */
    public final CountResponse count(Function<CountRequest.Builder, ObjectBuilder<CountRequest>> fn) throws IOException,
        OpenSearchException {
        return count(fn.apply(new CountRequest.Builder()).build());
    }

    /**
     * Returns number of documents matching a query.
     */
    public final CountResponse count() throws IOException, OpenSearchException {
        return count(new CountRequest.Builder().build());
    }

    // ----- Endpoint: create_pit

    /**
     * Creates point in time context.
     */
    public CreatePitResponse createPit(CreatePitRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, CreatePitRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Creates point in time context.
     *
     * @param fn a function that initializes a builder to create the {@link CreatePitRequest}
     */
    public final CreatePitResponse createPit(Function<CreatePitRequest.Builder, ObjectBuilder<CreatePitRequest>> fn) throws IOException,
        OpenSearchException {
        return createPit(fn.apply(new CreatePitRequest.Builder()).build());
    }

    // ----- Endpoint: delete

    /**
     * Removes a document from the index.
     */
    public DeleteResponse delete(DeleteRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, DeleteRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Removes a document from the index.
     *
     * @param fn a function that initializes a builder to create the {@link DeleteRequest}
     */
    public final DeleteResponse delete(Function<DeleteRequest.Builder, ObjectBuilder<DeleteRequest>> fn) throws IOException,
        OpenSearchException {
        return delete(fn.apply(new DeleteRequest.Builder()).build());
    }

    // ----- Endpoint: delete_all_pits

    /**
     * Deletes all active point in time searches.
     */
    public DeleteAllPitsResponse deleteAllPits(DeleteAllPitsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, DeleteAllPitsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Deletes all active point in time searches.
     *
     * @param fn a function that initializes a builder to create the {@link DeleteAllPitsRequest}
     */
    public final DeleteAllPitsResponse deleteAllPits(Function<DeleteAllPitsRequest.Builder, ObjectBuilder<DeleteAllPitsRequest>> fn)
        throws IOException, OpenSearchException {
        return deleteAllPits(fn.apply(new DeleteAllPitsRequest.Builder()).build());
    }

    /**
     * Deletes all active point in time searches.
     */
    public final DeleteAllPitsResponse deleteAllPits() throws IOException, OpenSearchException {
        return deleteAllPits(new DeleteAllPitsRequest.Builder().build());
    }

    // ----- Endpoint: delete_pit

    /**
     * Deletes one or more point in time searches based on the IDs passed.
     */
    public DeletePitResponse deletePit(DeletePitRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, DeletePitRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Deletes one or more point in time searches based on the IDs passed.
     *
     * @param fn a function that initializes a builder to create the {@link DeletePitRequest}
     */
    public final DeletePitResponse deletePit(Function<DeletePitRequest.Builder, ObjectBuilder<DeletePitRequest>> fn) throws IOException,
        OpenSearchException {
        return deletePit(fn.apply(new DeletePitRequest.Builder()).build());
    }

    // ----- Endpoint: exists

    /**
     * Returns information about whether a document exists in an index.
     */
    public BooleanResponse exists(ExistsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, ExistsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns information about whether a document exists in an index.
     *
     * @param fn a function that initializes a builder to create the {@link ExistsRequest}
     */
    public final BooleanResponse exists(Function<ExistsRequest.Builder, ObjectBuilder<ExistsRequest>> fn) throws IOException,
        OpenSearchException {
        return exists(fn.apply(new ExistsRequest.Builder()).build());
    }

    // ----- Endpoint: exists_source

    /**
     * Returns information about whether a document source exists in an index.
     */
    public BooleanResponse existsSource(ExistsSourceRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, ExistsSourceRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns information about whether a document source exists in an index.
     *
     * @param fn a function that initializes a builder to create the {@link ExistsSourceRequest}
     */
    public final BooleanResponse existsSource(Function<ExistsSourceRequest.Builder, ObjectBuilder<ExistsSourceRequest>> fn)
        throws IOException, OpenSearchException {
        return existsSource(fn.apply(new ExistsSourceRequest.Builder()).build());
    }

    // ----- Endpoint: explain

    /**
     * Returns information about why a specific document matches (or doesn't match) a query.
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
     * Returns information about why a specific document matches (or doesn't match) a query.
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
     * Returns the information about the capabilities of fields among multiple indexes.
     */
    public FieldCapsResponse fieldCaps(FieldCapsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, FieldCapsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns the information about the capabilities of fields among multiple indexes.
     *
     * @param fn a function that initializes a builder to create the {@link FieldCapsRequest}
     */
    public final FieldCapsResponse fieldCaps(Function<FieldCapsRequest.Builder, ObjectBuilder<FieldCapsRequest>> fn) throws IOException,
        OpenSearchException {
        return fieldCaps(fn.apply(new FieldCapsRequest.Builder()).build());
    }

    /**
     * Returns the information about the capabilities of fields among multiple indexes.
     */
    public final FieldCapsResponse fieldCaps() throws IOException, OpenSearchException {
        return fieldCaps(new FieldCapsRequest.Builder().build());
    }

    // ----- Endpoint: get

    /**
     * Returns a document.
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
     * Returns a document.
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
     * Lists all active point in time searches.
     */
    public GetAllPitsResponse getAllPits(GetAllPitsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetAllPitsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Lists all active point in time searches.
     *
     * @param fn a function that initializes a builder to create the {@link GetAllPitsRequest}
     */
    public final GetAllPitsResponse getAllPits(Function<GetAllPitsRequest.Builder, ObjectBuilder<GetAllPitsRequest>> fn) throws IOException,
        OpenSearchException {
        return getAllPits(fn.apply(new GetAllPitsRequest.Builder()).build());
    }

    /**
     * Lists all active point in time searches.
     */
    public final GetAllPitsResponse getAllPits() throws IOException, OpenSearchException {
        return getAllPits(new GetAllPitsRequest.Builder().build());
    }

    // ----- Endpoint: get_source

    /**
     * Returns the source of a document.
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
     * Returns the source of a document.
     *
     * @param fn a function that initializes a builder to create the {@link GetSourceRequest}
     */
    public final <TDocument> GetSourceResponse<TDocument> getSource(
        Function<GetSourceRequest.Builder, ObjectBuilder<GetSourceRequest>> fn,
        Class<TDocument> tDocumentClass
    ) throws IOException, OpenSearchException {
        return getSource(fn.apply(new GetSourceRequest.Builder()).build(), tDocumentClass);
    }

    // ----- Endpoint: rank_eval

    /**
     * Allows to evaluate the quality of ranked search results over a set of typical search queries.
     */
    public RankEvalResponse rankEval(RankEvalRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, RankEvalRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Allows to evaluate the quality of ranked search results over a set of typical search queries.
     *
     * @param fn a function that initializes a builder to create the {@link RankEvalRequest}
     */
    public final RankEvalResponse rankEval(Function<RankEvalRequest.Builder, ObjectBuilder<RankEvalRequest>> fn) throws IOException,
        OpenSearchException {
        return rankEval(fn.apply(new RankEvalRequest.Builder()).build());
    }

    // ----- Endpoint: search

    /**
     * Returns results matching a query.
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
     * Returns results matching a query.
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
