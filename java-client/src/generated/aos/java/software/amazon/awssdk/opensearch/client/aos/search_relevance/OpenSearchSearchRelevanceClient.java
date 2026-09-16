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

package software.amazon.awssdk.opensearch.client.aos.search_relevance;

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
 * Client for the search_relevance namespace.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class OpenSearchSearchRelevanceClient extends ApiClient<OpenSearchTransport, OpenSearchSearchRelevanceClient> {
    public OpenSearchSearchRelevanceClient(OpenSearchTransport transport) {
        super(transport, null);
    }

    public OpenSearchSearchRelevanceClient(OpenSearchTransport transport, @Nullable TransportOptions transportOptions) {
        super(transport, transportOptions);
    }

    @Override
    public OpenSearchSearchRelevanceClient withTransportOptions(@Nullable TransportOptions transportOptions) {
        return new OpenSearchSearchRelevanceClient(this.transport, transportOptions);
    }

    // ----- Endpoint: search_relevance.delete_experiments

    /**
     * <p>
     * Deletes a specified experiment.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>3.1</code>
     * </p>
     */
    public DeleteExperimentsResponse deleteExperiments(DeleteExperimentsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, DeleteExperimentsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Deletes a specified experiment.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>3.1</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link DeleteExperimentsRequest}
     */
    public final DeleteExperimentsResponse deleteExperiments(
        Function<DeleteExperimentsRequest.Builder, ObjectBuilder<DeleteExperimentsRequest>> fn
    ) throws IOException, OpenSearchException {
        return deleteExperiments(fn.apply(new DeleteExperimentsRequest.Builder()).build());
    }

    // ----- Endpoint: search_relevance.delete_judgments

    /**
     * <p>
     * Deletes a specified judgment.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>3.1</code>
     * </p>
     */
    public DeleteJudgmentsResponse deleteJudgments(DeleteJudgmentsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, DeleteJudgmentsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Deletes a specified judgment.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>3.1</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link DeleteJudgmentsRequest}
     */
    public final DeleteJudgmentsResponse deleteJudgments(Function<DeleteJudgmentsRequest.Builder, ObjectBuilder<DeleteJudgmentsRequest>> fn)
        throws IOException, OpenSearchException {
        return deleteJudgments(fn.apply(new DeleteJudgmentsRequest.Builder()).build());
    }

    // ----- Endpoint: search_relevance.delete_query_sets

    /**
     * <p>
     * Deletes a query set.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>3.1</code>
     * </p>
     */
    public DeleteQuerySetsResponse deleteQuerySets(DeleteQuerySetsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, DeleteQuerySetsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Deletes a query set.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>3.1</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link DeleteQuerySetsRequest}
     */
    public final DeleteQuerySetsResponse deleteQuerySets(Function<DeleteQuerySetsRequest.Builder, ObjectBuilder<DeleteQuerySetsRequest>> fn)
        throws IOException, OpenSearchException {
        return deleteQuerySets(fn.apply(new DeleteQuerySetsRequest.Builder()).build());
    }

    // ----- Endpoint: search_relevance.delete_scheduled_experiments

    /**
     * <p>
     * Deletes a specified scheduled experiment.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>3.4</code>
     * </p>
     */
    public DeleteScheduledExperimentsResponse deleteScheduledExperiments(DeleteScheduledExperimentsRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequest(request, DeleteScheduledExperimentsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Deletes a specified scheduled experiment.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>3.4</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link DeleteScheduledExperimentsRequest}
     */
    public final DeleteScheduledExperimentsResponse deleteScheduledExperiments(
        Function<DeleteScheduledExperimentsRequest.Builder, ObjectBuilder<DeleteScheduledExperimentsRequest>> fn
    ) throws IOException, OpenSearchException {
        return deleteScheduledExperiments(fn.apply(new DeleteScheduledExperimentsRequest.Builder()).build());
    }

    // ----- Endpoint: search_relevance.delete_search_configurations

    /**
     * <p>
     * Deletes a specified search configuration.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>3.1</code>
     * </p>
     */
    public DeleteSearchConfigurationsResponse deleteSearchConfigurations(DeleteSearchConfigurationsRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequest(request, DeleteSearchConfigurationsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Deletes a specified search configuration.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>3.1</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link DeleteSearchConfigurationsRequest}
     */
    public final DeleteSearchConfigurationsResponse deleteSearchConfigurations(
        Function<DeleteSearchConfigurationsRequest.Builder, ObjectBuilder<DeleteSearchConfigurationsRequest>> fn
    ) throws IOException, OpenSearchException {
        return deleteSearchConfigurations(fn.apply(new DeleteSearchConfigurationsRequest.Builder()).build());
    }

    // ----- Endpoint: search_relevance.experiments_search

    /**
     * <p>
     * Searches for experiments.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>3.5</code>
     * </p>
     */
    public <TDocument> ExperimentsSearchResponse<TDocument> experimentsSearch(
        ExperimentsSearchRequest request,
        Class<TDocument> tDocumentClass
    ) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<ExperimentsSearchRequest, ExperimentsSearchResponse<TDocument>, ErrorResponse> endpoint = (JsonEndpoint<
            ExperimentsSearchRequest,
            ExperimentsSearchResponse<TDocument>,
            ErrorResponse>) ExperimentsSearchRequest._ENDPOINT;
        endpoint = new EndpointWithResponseMapperAttr<>(
            endpoint,
            "software.amazon.awssdk.opensearch.client:Deserializer:search_relevance.experiments_search.TDocument",
            getDeserializer(tDocumentClass)
        );

        return this.transport.performRequest(request, endpoint, this.transportOptions);
    }

    /**
     * <p>
     * Searches for experiments.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>3.5</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link ExperimentsSearchRequest}
     */
    public final <TDocument> ExperimentsSearchResponse<TDocument> experimentsSearch(
        Function<ExperimentsSearchRequest.Builder, ObjectBuilder<ExperimentsSearchRequest>> fn,
        Class<TDocument> tDocumentClass
    ) throws IOException, OpenSearchException {
        return experimentsSearch(fn.apply(new ExperimentsSearchRequest.Builder()).build(), tDocumentClass);
    }

    // ----- Endpoint: search_relevance.get_experiments

    /**
     * <p>
     * Gets experiments.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>3.1</code>
     * </p>
     */
    public <TDocument> GetExperimentsResponse<TDocument> getExperiments(GetExperimentsRequest request, Class<TDocument> tDocumentClass)
        throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<GetExperimentsRequest, GetExperimentsResponse<TDocument>, ErrorResponse> endpoint = (JsonEndpoint<
            GetExperimentsRequest,
            GetExperimentsResponse<TDocument>,
            ErrorResponse>) GetExperimentsRequest._ENDPOINT;
        endpoint = new EndpointWithResponseMapperAttr<>(
            endpoint,
            "software.amazon.awssdk.opensearch.client:Deserializer:search_relevance.get_experiments.TDocument",
            getDeserializer(tDocumentClass)
        );

        return this.transport.performRequest(request, endpoint, this.transportOptions);
    }

    /**
     * <p>
     * Gets experiments.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>3.1</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link GetExperimentsRequest}
     */
    public final <TDocument> GetExperimentsResponse<TDocument> getExperiments(
        Function<GetExperimentsRequest.Builder, ObjectBuilder<GetExperimentsRequest>> fn,
        Class<TDocument> tDocumentClass
    ) throws IOException, OpenSearchException {
        return getExperiments(fn.apply(new GetExperimentsRequest.Builder()).build(), tDocumentClass);
    }

    // ----- Endpoint: search_relevance.get_judgments

    /**
     * <p>
     * Gets judgments.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>3.1</code>
     * </p>
     */
    public <TDocument> GetJudgmentsResponse<TDocument> getJudgments(GetJudgmentsRequest request, Class<TDocument> tDocumentClass)
        throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<GetJudgmentsRequest, GetJudgmentsResponse<TDocument>, ErrorResponse> endpoint = (JsonEndpoint<
            GetJudgmentsRequest,
            GetJudgmentsResponse<TDocument>,
            ErrorResponse>) GetJudgmentsRequest._ENDPOINT;
        endpoint = new EndpointWithResponseMapperAttr<>(
            endpoint,
            "software.amazon.awssdk.opensearch.client:Deserializer:search_relevance.get_judgments.TDocument",
            getDeserializer(tDocumentClass)
        );

        return this.transport.performRequest(request, endpoint, this.transportOptions);
    }

    /**
     * <p>
     * Gets judgments.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>3.1</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link GetJudgmentsRequest}
     */
    public final <TDocument> GetJudgmentsResponse<TDocument> getJudgments(
        Function<GetJudgmentsRequest.Builder, ObjectBuilder<GetJudgmentsRequest>> fn,
        Class<TDocument> tDocumentClass
    ) throws IOException, OpenSearchException {
        return getJudgments(fn.apply(new GetJudgmentsRequest.Builder()).build(), tDocumentClass);
    }

    // ----- Endpoint: search_relevance.get_node_stats

    /**
     * <p>
     * Gets stats by node.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>3.1</code>
     * </p>
     */
    public GetNodeStatsResponse getNodeStats(GetNodeStatsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetNodeStatsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Gets stats by node.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>3.1</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link GetNodeStatsRequest}
     */
    public final GetNodeStatsResponse getNodeStats(Function<GetNodeStatsRequest.Builder, ObjectBuilder<GetNodeStatsRequest>> fn)
        throws IOException, OpenSearchException {
        return getNodeStats(fn.apply(new GetNodeStatsRequest.Builder()).build());
    }

    // ----- Endpoint: search_relevance.get_query_sets

    /**
     * <p>
     * Lists the current query sets available.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>3.1</code>
     * </p>
     */
    public <TDocument> GetQuerySetsResponse<TDocument> getQuerySets(GetQuerySetsRequest request, Class<TDocument> tDocumentClass)
        throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<GetQuerySetsRequest, GetQuerySetsResponse<TDocument>, ErrorResponse> endpoint = (JsonEndpoint<
            GetQuerySetsRequest,
            GetQuerySetsResponse<TDocument>,
            ErrorResponse>) GetQuerySetsRequest._ENDPOINT;
        endpoint = new EndpointWithResponseMapperAttr<>(
            endpoint,
            "software.amazon.awssdk.opensearch.client:Deserializer:search_relevance.get_query_sets.TDocument",
            getDeserializer(tDocumentClass)
        );

        return this.transport.performRequest(request, endpoint, this.transportOptions);
    }

    /**
     * <p>
     * Lists the current query sets available.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>3.1</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link GetQuerySetsRequest}
     */
    public final <TDocument> GetQuerySetsResponse<TDocument> getQuerySets(
        Function<GetQuerySetsRequest.Builder, ObjectBuilder<GetQuerySetsRequest>> fn,
        Class<TDocument> tDocumentClass
    ) throws IOException, OpenSearchException {
        return getQuerySets(fn.apply(new GetQuerySetsRequest.Builder()).build(), tDocumentClass);
    }

    // ----- Endpoint: search_relevance.get_scheduled_experiments

    /**
     * <p>
     * Gets the scheduled experiments.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>3.4</code>
     * </p>
     */
    public <TDocument> GetScheduledExperimentsResponse<TDocument> getScheduledExperiments(
        GetScheduledExperimentsRequest request,
        Class<TDocument> tDocumentClass
    ) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<GetScheduledExperimentsRequest, GetScheduledExperimentsResponse<TDocument>, ErrorResponse> endpoint = (JsonEndpoint<
            GetScheduledExperimentsRequest,
            GetScheduledExperimentsResponse<TDocument>,
            ErrorResponse>) GetScheduledExperimentsRequest._ENDPOINT;
        endpoint = new EndpointWithResponseMapperAttr<>(
            endpoint,
            "software.amazon.awssdk.opensearch.client:Deserializer:search_relevance.get_scheduled_experiments.TDocument",
            getDeserializer(tDocumentClass)
        );

        return this.transport.performRequest(request, endpoint, this.transportOptions);
    }

    /**
     * <p>
     * Gets the scheduled experiments.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>3.4</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link GetScheduledExperimentsRequest}
     */
    public final <TDocument> GetScheduledExperimentsResponse<TDocument> getScheduledExperiments(
        Function<GetScheduledExperimentsRequest.Builder, ObjectBuilder<GetScheduledExperimentsRequest>> fn,
        Class<TDocument> tDocumentClass
    ) throws IOException, OpenSearchException {
        return getScheduledExperiments(fn.apply(new GetScheduledExperimentsRequest.Builder()).build(), tDocumentClass);
    }

    // ----- Endpoint: search_relevance.get_search_configurations

    /**
     * <p>
     * Gets the search configurations.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>3.1</code>
     * </p>
     */
    public <TDocument> GetSearchConfigurationsResponse<TDocument> getSearchConfigurations(
        GetSearchConfigurationsRequest request,
        Class<TDocument> tDocumentClass
    ) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<GetSearchConfigurationsRequest, GetSearchConfigurationsResponse<TDocument>, ErrorResponse> endpoint = (JsonEndpoint<
            GetSearchConfigurationsRequest,
            GetSearchConfigurationsResponse<TDocument>,
            ErrorResponse>) GetSearchConfigurationsRequest._ENDPOINT;
        endpoint = new EndpointWithResponseMapperAttr<>(
            endpoint,
            "software.amazon.awssdk.opensearch.client:Deserializer:search_relevance.get_search_configurations.TDocument",
            getDeserializer(tDocumentClass)
        );

        return this.transport.performRequest(request, endpoint, this.transportOptions);
    }

    /**
     * <p>
     * Gets the search configurations.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>3.1</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link GetSearchConfigurationsRequest}
     */
    public final <TDocument> GetSearchConfigurationsResponse<TDocument> getSearchConfigurations(
        Function<GetSearchConfigurationsRequest.Builder, ObjectBuilder<GetSearchConfigurationsRequest>> fn,
        Class<TDocument> tDocumentClass
    ) throws IOException, OpenSearchException {
        return getSearchConfigurations(fn.apply(new GetSearchConfigurationsRequest.Builder()).build(), tDocumentClass);
    }

    // ----- Endpoint: search_relevance.get_stats

    /**
     * <p>
     * Gets stats.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>3.1</code>
     * </p>
     */
    public GetStatsResponse getStats(GetStatsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetStatsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Gets stats.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>3.1</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link GetStatsRequest}
     */
    public final GetStatsResponse getStats(Function<GetStatsRequest.Builder, ObjectBuilder<GetStatsRequest>> fn) throws IOException,
        OpenSearchException {
        return getStats(fn.apply(new GetStatsRequest.Builder()).build());
    }

    /**
     * <p>
     * Gets stats.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>3.1</code>
     * </p>
     */
    public final GetStatsResponse getStats() throws IOException, OpenSearchException {
        return getStats(new GetStatsRequest.Builder().build());
    }

    // ----- Endpoint: search_relevance.judgments_search

    /**
     * <p>
     * Searches for judgments.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>3.5</code>
     * </p>
     */
    public <TDocument> JudgmentsSearchResponse<TDocument> judgmentsSearch(JudgmentsSearchRequest request, Class<TDocument> tDocumentClass)
        throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<JudgmentsSearchRequest, JudgmentsSearchResponse<TDocument>, ErrorResponse> endpoint = (JsonEndpoint<
            JudgmentsSearchRequest,
            JudgmentsSearchResponse<TDocument>,
            ErrorResponse>) JudgmentsSearchRequest._ENDPOINT;
        endpoint = new EndpointWithResponseMapperAttr<>(
            endpoint,
            "software.amazon.awssdk.opensearch.client:Deserializer:search_relevance.judgments_search.TDocument",
            getDeserializer(tDocumentClass)
        );

        return this.transport.performRequest(request, endpoint, this.transportOptions);
    }

    /**
     * <p>
     * Searches for judgments.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>3.5</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link JudgmentsSearchRequest}
     */
    public final <TDocument> JudgmentsSearchResponse<TDocument> judgmentsSearch(
        Function<JudgmentsSearchRequest.Builder, ObjectBuilder<JudgmentsSearchRequest>> fn,
        Class<TDocument> tDocumentClass
    ) throws IOException, OpenSearchException {
        return judgmentsSearch(fn.apply(new JudgmentsSearchRequest.Builder()).build(), tDocumentClass);
    }

    // ----- Endpoint: search_relevance.post_query_sets

    /**
     * <p>
     * Creates a new query set by sampling queries from the user behavior data.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>3.1</code>
     * </p>
     */
    public PostQuerySetsResponse postQuerySets(PostQuerySetsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, PostQuerySetsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Creates a new query set by sampling queries from the user behavior data.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>3.1</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link PostQuerySetsRequest}
     */
    public final PostQuerySetsResponse postQuerySets(Function<PostQuerySetsRequest.Builder, ObjectBuilder<PostQuerySetsRequest>> fn)
        throws IOException, OpenSearchException {
        return postQuerySets(fn.apply(new PostQuerySetsRequest.Builder()).build());
    }

    /**
     * <p>
     * Creates a new query set by sampling queries from the user behavior data.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>3.1</code>
     * </p>
     */
    public final PostQuerySetsResponse postQuerySets() throws IOException, OpenSearchException {
        return postQuerySets(new PostQuerySetsRequest.Builder().build());
    }

    // ----- Endpoint: search_relevance.post_scheduled_experiments

    /**
     * <p>
     * Creates a scheduled experiment.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>3.4</code>
     * </p>
     */
    public PostScheduledExperimentsResponse postScheduledExperiments(PostScheduledExperimentsRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequest(request, PostScheduledExperimentsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Creates a scheduled experiment.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>3.4</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link PostScheduledExperimentsRequest}
     */
    public final PostScheduledExperimentsResponse postScheduledExperiments(
        Function<PostScheduledExperimentsRequest.Builder, ObjectBuilder<PostScheduledExperimentsRequest>> fn
    ) throws IOException, OpenSearchException {
        return postScheduledExperiments(fn.apply(new PostScheduledExperimentsRequest.Builder()).build());
    }

    /**
     * <p>
     * Creates a scheduled experiment.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>3.4</code>
     * </p>
     */
    public final PostScheduledExperimentsResponse postScheduledExperiments() throws IOException, OpenSearchException {
        return postScheduledExperiments(new PostScheduledExperimentsRequest.Builder().build());
    }

    // ----- Endpoint: search_relevance.put_experiments

    /**
     * <p>
     * Creates an experiment.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>3.1</code>
     * </p>
     */
    public PutExperimentsResponse putExperiments(PutExperimentsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, PutExperimentsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Creates an experiment.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>3.1</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link PutExperimentsRequest}
     */
    public final PutExperimentsResponse putExperiments(Function<PutExperimentsRequest.Builder, ObjectBuilder<PutExperimentsRequest>> fn)
        throws IOException, OpenSearchException {
        return putExperiments(fn.apply(new PutExperimentsRequest.Builder()).build());
    }

    /**
     * <p>
     * Creates an experiment.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>3.1</code>
     * </p>
     */
    public final PutExperimentsResponse putExperiments() throws IOException, OpenSearchException {
        return putExperiments(new PutExperimentsRequest.Builder().build());
    }

    // ----- Endpoint: search_relevance.put_judgments

    /**
     * <p>
     * Creates a judgment.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>3.1</code>
     * </p>
     */
    public PutJudgmentsResponse putJudgments(PutJudgmentsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, PutJudgmentsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Creates a judgment.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>3.1</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link PutJudgmentsRequest}
     */
    public final PutJudgmentsResponse putJudgments(Function<PutJudgmentsRequest.Builder, ObjectBuilder<PutJudgmentsRequest>> fn)
        throws IOException, OpenSearchException {
        return putJudgments(fn.apply(new PutJudgmentsRequest.Builder()).build());
    }

    /**
     * <p>
     * Creates a judgment.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>3.1</code>
     * </p>
     */
    public final PutJudgmentsResponse putJudgments() throws IOException, OpenSearchException {
        return putJudgments(new PutJudgmentsRequest.Builder().build());
    }

    // ----- Endpoint: search_relevance.put_query_sets

    /**
     * <p>
     * Creates a new query set by uploading manually.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>3.1</code>
     * </p>
     */
    public PutQuerySetsResponse putQuerySets(PutQuerySetsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, PutQuerySetsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Creates a new query set by uploading manually.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>3.1</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link PutQuerySetsRequest}
     */
    public final PutQuerySetsResponse putQuerySets(Function<PutQuerySetsRequest.Builder, ObjectBuilder<PutQuerySetsRequest>> fn)
        throws IOException, OpenSearchException {
        return putQuerySets(fn.apply(new PutQuerySetsRequest.Builder()).build());
    }

    /**
     * <p>
     * Creates a new query set by uploading manually.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>3.1</code>
     * </p>
     */
    public final PutQuerySetsResponse putQuerySets() throws IOException, OpenSearchException {
        return putQuerySets(new PutQuerySetsRequest.Builder().build());
    }

    // ----- Endpoint: search_relevance.put_search_configurations

    /**
     * <p>
     * Creates a search configuration.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>3.1</code>
     * </p>
     */
    public PutSearchConfigurationsResponse putSearchConfigurations(PutSearchConfigurationsRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequest(request, PutSearchConfigurationsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Creates a search configuration.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>3.1</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link PutSearchConfigurationsRequest}
     */
    public final PutSearchConfigurationsResponse putSearchConfigurations(
        Function<PutSearchConfigurationsRequest.Builder, ObjectBuilder<PutSearchConfigurationsRequest>> fn
    ) throws IOException, OpenSearchException {
        return putSearchConfigurations(fn.apply(new PutSearchConfigurationsRequest.Builder()).build());
    }

    /**
     * <p>
     * Creates a search configuration.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>3.1</code>
     * </p>
     */
    public final PutSearchConfigurationsResponse putSearchConfigurations() throws IOException, OpenSearchException {
        return putSearchConfigurations(new PutSearchConfigurationsRequest.Builder().build());
    }

    // ----- Endpoint: search_relevance.query_sets_search

    /**
     * <p>
     * Searches for queries in the query sets.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>3.5</code>
     * </p>
     */
    public <TDocument> QuerySetsSearchResponse<TDocument> querySetsSearch(QuerySetsSearchRequest request, Class<TDocument> tDocumentClass)
        throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<QuerySetsSearchRequest, QuerySetsSearchResponse<TDocument>, ErrorResponse> endpoint = (JsonEndpoint<
            QuerySetsSearchRequest,
            QuerySetsSearchResponse<TDocument>,
            ErrorResponse>) QuerySetsSearchRequest._ENDPOINT;
        endpoint = new EndpointWithResponseMapperAttr<>(
            endpoint,
            "software.amazon.awssdk.opensearch.client:Deserializer:search_relevance.query_sets_search.TDocument",
            getDeserializer(tDocumentClass)
        );

        return this.transport.performRequest(request, endpoint, this.transportOptions);
    }

    /**
     * <p>
     * Searches for queries in the query sets.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>3.5</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link QuerySetsSearchRequest}
     */
    public final <TDocument> QuerySetsSearchResponse<TDocument> querySetsSearch(
        Function<QuerySetsSearchRequest.Builder, ObjectBuilder<QuerySetsSearchRequest>> fn,
        Class<TDocument> tDocumentClass
    ) throws IOException, OpenSearchException {
        return querySetsSearch(fn.apply(new QuerySetsSearchRequest.Builder()).build(), tDocumentClass);
    }

    // ----- Endpoint: search_relevance.search_configurations_search

    /**
     * <p>
     * Searches for search configurations.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>3.5</code>
     * </p>
     */
    public <TDocument> SearchConfigurationsSearchResponse<TDocument> searchConfigurationsSearch(
        SearchConfigurationsSearchRequest request,
        Class<TDocument> tDocumentClass
    ) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<SearchConfigurationsSearchRequest, SearchConfigurationsSearchResponse<TDocument>, ErrorResponse> endpoint =
            (JsonEndpoint<
                SearchConfigurationsSearchRequest,
                SearchConfigurationsSearchResponse<TDocument>,
                ErrorResponse>) SearchConfigurationsSearchRequest._ENDPOINT;
        endpoint = new EndpointWithResponseMapperAttr<>(
            endpoint,
            "software.amazon.awssdk.opensearch.client:Deserializer:search_relevance.search_configurations_search.TDocument",
            getDeserializer(tDocumentClass)
        );

        return this.transport.performRequest(request, endpoint, this.transportOptions);
    }

    /**
     * <p>
     * Searches for search configurations.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>3.5</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link SearchConfigurationsSearchRequest}
     */
    public final <TDocument> SearchConfigurationsSearchResponse<TDocument> searchConfigurationsSearch(
        Function<SearchConfigurationsSearchRequest.Builder, ObjectBuilder<SearchConfigurationsSearchRequest>> fn,
        Class<TDocument> tDocumentClass
    ) throws IOException, OpenSearchException {
        return searchConfigurationsSearch(fn.apply(new SearchConfigurationsSearchRequest.Builder()).build(), tDocumentClass);
    }
}
