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

package software.amazon.awssdk.opensearch.client.aos.indices;

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
 * Client for the indices namespace.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public abstract class OpenSearchIndicesClientBase<Self extends OpenSearchIndicesClientBase<Self>> extends ApiClient<
    OpenSearchTransport,
    Self> {
    public OpenSearchIndicesClientBase(OpenSearchTransport transport, @Nullable TransportOptions transportOptions) {
        super(transport, transportOptions);
    }

    // ----- Endpoint: indices.add_block

    /**
     * <p>
     * Adds a block to an index.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public AddBlockResponse addBlock(AddBlockRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, AddBlockRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Adds a block to an index.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link AddBlockRequest}
     */
    public final AddBlockResponse addBlock(Function<AddBlockRequest.Builder, ObjectBuilder<AddBlockRequest>> fn) throws IOException,
        OpenSearchException {
        return addBlock(fn.apply(new AddBlockRequest.Builder()).build());
    }

    // ----- Endpoint: indices.analyze

    /**
     * <p>
     * Performs the analysis process on a text and return the tokens breakdown of the text.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public AnalyzeResponse analyze(AnalyzeRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, AnalyzeRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Performs the analysis process on a text and return the tokens breakdown of the text.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link AnalyzeRequest}
     */
    public final AnalyzeResponse analyze(Function<AnalyzeRequest.Builder, ObjectBuilder<AnalyzeRequest>> fn) throws IOException,
        OpenSearchException {
        return analyze(fn.apply(new AnalyzeRequest.Builder()).build());
    }

    /**
     * <p>
     * Performs the analysis process on a text and return the tokens breakdown of the text.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public final AnalyzeResponse analyze() throws IOException, OpenSearchException {
        return analyze(new AnalyzeRequest.Builder().build());
    }

    // ----- Endpoint: indices.clear_cache

    /**
     * <p>
     * Clears all or specific caches for one or more indexes.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public ClearCacheResponse clearCache(ClearCacheRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, ClearCacheRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Clears all or specific caches for one or more indexes.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link ClearCacheRequest}
     */
    public final ClearCacheResponse clearCache(Function<ClearCacheRequest.Builder, ObjectBuilder<ClearCacheRequest>> fn) throws IOException,
        OpenSearchException {
        return clearCache(fn.apply(new ClearCacheRequest.Builder()).build());
    }

    // ----- Endpoint: indices.clone

    /**
     * <p>
     * Clones an index.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public CloneIndexResponse clone(CloneIndexRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, CloneIndexRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Clones an index.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link CloneIndexRequest}
     */
    public final CloneIndexResponse clone(Function<CloneIndexRequest.Builder, ObjectBuilder<CloneIndexRequest>> fn) throws IOException,
        OpenSearchException {
        return clone(fn.apply(new CloneIndexRequest.Builder()).build());
    }

    // ----- Endpoint: indices.close

    /**
     * <p>
     * Closes an index.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public CloseIndexResponse close(CloseIndexRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, CloseIndexRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Closes an index.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link CloseIndexRequest}
     */
    public final CloseIndexResponse close(Function<CloseIndexRequest.Builder, ObjectBuilder<CloseIndexRequest>> fn) throws IOException,
        OpenSearchException {
        return close(fn.apply(new CloseIndexRequest.Builder()).build());
    }

    // ----- Endpoint: indices.create

    /**
     * <p>
     * Creates an index with optional settings and mappings.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public CreateIndexResponse create(CreateIndexRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, CreateIndexRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Creates an index with optional settings and mappings.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link CreateIndexRequest}
     */
    public final CreateIndexResponse create(Function<CreateIndexRequest.Builder, ObjectBuilder<CreateIndexRequest>> fn) throws IOException,
        OpenSearchException {
        return create(fn.apply(new CreateIndexRequest.Builder()).build());
    }

    // ----- Endpoint: indices.create_data_stream

    /**
     * <p>
     * Creates or updates a data stream.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public CreateDataStreamResponse createDataStream(CreateDataStreamRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, CreateDataStreamRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Creates or updates a data stream.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link CreateDataStreamRequest}
     */
    public final CreateDataStreamResponse createDataStream(
        Function<CreateDataStreamRequest.Builder, ObjectBuilder<CreateDataStreamRequest>> fn
    ) throws IOException, OpenSearchException {
        return createDataStream(fn.apply(new CreateDataStreamRequest.Builder()).build());
    }

    // ----- Endpoint: indices.data_streams_stats

    /**
     * <p>
     * Provides statistics on operations happening in a data stream.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public DataStreamsStatsResponse dataStreamsStats(DataStreamsStatsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, DataStreamsStatsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Provides statistics on operations happening in a data stream.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link DataStreamsStatsRequest}
     */
    public final DataStreamsStatsResponse dataStreamsStats(
        Function<DataStreamsStatsRequest.Builder, ObjectBuilder<DataStreamsStatsRequest>> fn
    ) throws IOException, OpenSearchException {
        return dataStreamsStats(fn.apply(new DataStreamsStatsRequest.Builder()).build());
    }

    /**
     * <p>
     * Provides statistics on operations happening in a data stream.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public final DataStreamsStatsResponse dataStreamsStats() throws IOException, OpenSearchException {
        return dataStreamsStats(new DataStreamsStatsRequest.Builder().build());
    }

    // ----- Endpoint: indices.delete

    /**
     * <p>
     * Deletes an index.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public DeleteIndexResponse delete(DeleteIndexRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, DeleteIndexRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Deletes an index.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link DeleteIndexRequest}
     */
    public final DeleteIndexResponse delete(Function<DeleteIndexRequest.Builder, ObjectBuilder<DeleteIndexRequest>> fn) throws IOException,
        OpenSearchException {
        return delete(fn.apply(new DeleteIndexRequest.Builder()).build());
    }

    // ----- Endpoint: indices.delete_alias

    /**
     * <p>
     * Deletes an alias.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public DeleteAliasResponse deleteAlias(DeleteAliasRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, DeleteAliasRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Deletes an alias.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link DeleteAliasRequest}
     */
    public final DeleteAliasResponse deleteAlias(Function<DeleteAliasRequest.Builder, ObjectBuilder<DeleteAliasRequest>> fn)
        throws IOException, OpenSearchException {
        return deleteAlias(fn.apply(new DeleteAliasRequest.Builder()).build());
    }

    // ----- Endpoint: indices.delete_data_stream

    /**
     * <p>
     * Deletes a data stream.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public DeleteDataStreamResponse deleteDataStream(DeleteDataStreamRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, DeleteDataStreamRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Deletes a data stream.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link DeleteDataStreamRequest}
     */
    public final DeleteDataStreamResponse deleteDataStream(
        Function<DeleteDataStreamRequest.Builder, ObjectBuilder<DeleteDataStreamRequest>> fn
    ) throws IOException, OpenSearchException {
        return deleteDataStream(fn.apply(new DeleteDataStreamRequest.Builder()).build());
    }

    // ----- Endpoint: indices.delete_index_template

    /**
     * <p>
     * Deletes an index template.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public DeleteIndexTemplateResponse deleteIndexTemplate(DeleteIndexTemplateRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, DeleteIndexTemplateRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Deletes an index template.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link DeleteIndexTemplateRequest}
     */
    public final DeleteIndexTemplateResponse deleteIndexTemplate(
        Function<DeleteIndexTemplateRequest.Builder, ObjectBuilder<DeleteIndexTemplateRequest>> fn
    ) throws IOException, OpenSearchException {
        return deleteIndexTemplate(fn.apply(new DeleteIndexTemplateRequest.Builder()).build());
    }

    // ----- Endpoint: indices.delete_template

    /**
     * <p>
     * Deletes an index template.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public DeleteTemplateResponse deleteTemplate(DeleteTemplateRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, DeleteTemplateRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Deletes an index template.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link DeleteTemplateRequest}
     */
    public final DeleteTemplateResponse deleteTemplate(Function<DeleteTemplateRequest.Builder, ObjectBuilder<DeleteTemplateRequest>> fn)
        throws IOException, OpenSearchException {
        return deleteTemplate(fn.apply(new DeleteTemplateRequest.Builder()).build());
    }

    // ----- Endpoint: indices.exists

    /**
     * <p>
     * Returns information about whether a particular index exists.
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
     * Returns information about whether a particular index exists.
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

    // ----- Endpoint: indices.exists_alias

    /**
     * <p>
     * Returns information about whether a particular alias exists.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public BooleanResponse existsAlias(ExistsAliasRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, ExistsAliasRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Returns information about whether a particular alias exists.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link ExistsAliasRequest}
     */
    public final BooleanResponse existsAlias(Function<ExistsAliasRequest.Builder, ObjectBuilder<ExistsAliasRequest>> fn) throws IOException,
        OpenSearchException {
        return existsAlias(fn.apply(new ExistsAliasRequest.Builder()).build());
    }

    // ----- Endpoint: indices.exists_index_template

    /**
     * <p>
     * Returns information about whether a particular index template exists.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public BooleanResponse existsIndexTemplate(ExistsIndexTemplateRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, ExistsIndexTemplateRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Returns information about whether a particular index template exists.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link ExistsIndexTemplateRequest}
     */
    public final BooleanResponse existsIndexTemplate(
        Function<ExistsIndexTemplateRequest.Builder, ObjectBuilder<ExistsIndexTemplateRequest>> fn
    ) throws IOException, OpenSearchException {
        return existsIndexTemplate(fn.apply(new ExistsIndexTemplateRequest.Builder()).build());
    }

    // ----- Endpoint: indices.exists_template

    /**
     * <p>
     * Returns information about whether a particular index template exists.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public BooleanResponse existsTemplate(ExistsTemplateRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, ExistsTemplateRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Returns information about whether a particular index template exists.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link ExistsTemplateRequest}
     */
    public final BooleanResponse existsTemplate(Function<ExistsTemplateRequest.Builder, ObjectBuilder<ExistsTemplateRequest>> fn)
        throws IOException, OpenSearchException {
        return existsTemplate(fn.apply(new ExistsTemplateRequest.Builder()).build());
    }

    // ----- Endpoint: indices.flush

    /**
     * <p>
     * Performs the flush operation on one or more indexes.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public FlushResponse flush(FlushRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, FlushRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Performs the flush operation on one or more indexes.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link FlushRequest}
     */
    public final FlushResponse flush(Function<FlushRequest.Builder, ObjectBuilder<FlushRequest>> fn) throws IOException,
        OpenSearchException {
        return flush(fn.apply(new FlushRequest.Builder()).build());
    }

    /**
     * <p>
     * Performs the flush operation on one or more indexes.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public final FlushResponse flush() throws IOException, OpenSearchException {
        return flush(new FlushRequest.Builder().build());
    }

    // ----- Endpoint: indices.forcemerge

    /**
     * <p>
     * Performs the force merge operation on one or more indexes.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public ForcemergeResponse forcemerge(ForcemergeRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, ForcemergeRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Performs the force merge operation on one or more indexes.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link ForcemergeRequest}
     */
    public final ForcemergeResponse forcemerge(Function<ForcemergeRequest.Builder, ObjectBuilder<ForcemergeRequest>> fn) throws IOException,
        OpenSearchException {
        return forcemerge(fn.apply(new ForcemergeRequest.Builder()).build());
    }

    // ----- Endpoint: indices.get

    /**
     * <p>
     * Returns information about one or more indexes.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public GetIndexResponse get(GetIndexRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetIndexRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Returns information about one or more indexes.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link GetIndexRequest}
     */
    public final GetIndexResponse get(Function<GetIndexRequest.Builder, ObjectBuilder<GetIndexRequest>> fn) throws IOException,
        OpenSearchException {
        return get(fn.apply(new GetIndexRequest.Builder()).build());
    }

    // ----- Endpoint: indices.get_alias

    /**
     * <p>
     * Returns an alias.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public GetAliasResponse getAlias(GetAliasRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetAliasRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Returns an alias.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link GetAliasRequest}
     */
    public final GetAliasResponse getAlias(Function<GetAliasRequest.Builder, ObjectBuilder<GetAliasRequest>> fn) throws IOException,
        OpenSearchException {
        return getAlias(fn.apply(new GetAliasRequest.Builder()).build());
    }

    /**
     * <p>
     * Returns an alias.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public final GetAliasResponse getAlias() throws IOException, OpenSearchException {
        return getAlias(new GetAliasRequest.Builder().build());
    }

    // ----- Endpoint: indices.get_data_stream

    /**
     * <p>
     * Returns data streams.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public GetDataStreamResponse getDataStream(GetDataStreamRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetDataStreamRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Returns data streams.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link GetDataStreamRequest}
     */
    public final GetDataStreamResponse getDataStream(Function<GetDataStreamRequest.Builder, ObjectBuilder<GetDataStreamRequest>> fn)
        throws IOException, OpenSearchException {
        return getDataStream(fn.apply(new GetDataStreamRequest.Builder()).build());
    }

    /**
     * <p>
     * Returns data streams.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public final GetDataStreamResponse getDataStream() throws IOException, OpenSearchException {
        return getDataStream(new GetDataStreamRequest.Builder().build());
    }

    // ----- Endpoint: indices.get_index_template

    /**
     * <p>
     * Returns an index template.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public GetIndexTemplateResponse getIndexTemplate(GetIndexTemplateRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetIndexTemplateRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Returns an index template.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link GetIndexTemplateRequest}
     */
    public final GetIndexTemplateResponse getIndexTemplate(
        Function<GetIndexTemplateRequest.Builder, ObjectBuilder<GetIndexTemplateRequest>> fn
    ) throws IOException, OpenSearchException {
        return getIndexTemplate(fn.apply(new GetIndexTemplateRequest.Builder()).build());
    }

    /**
     * <p>
     * Returns an index template.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public final GetIndexTemplateResponse getIndexTemplate() throws IOException, OpenSearchException {
        return getIndexTemplate(new GetIndexTemplateRequest.Builder().build());
    }

    // ----- Endpoint: indices.get_mapping

    /**
     * <p>
     * Returns mappings for one or more indexes.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public GetMappingResponse getMapping(GetMappingRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetMappingRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Returns mappings for one or more indexes.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link GetMappingRequest}
     */
    public final GetMappingResponse getMapping(Function<GetMappingRequest.Builder, ObjectBuilder<GetMappingRequest>> fn) throws IOException,
        OpenSearchException {
        return getMapping(fn.apply(new GetMappingRequest.Builder()).build());
    }

    /**
     * <p>
     * Returns mappings for one or more indexes.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public final GetMappingResponse getMapping() throws IOException, OpenSearchException {
        return getMapping(new GetMappingRequest.Builder().build());
    }

    // ----- Endpoint: indices.get_settings

    /**
     * <p>
     * Returns settings for one or more indexes.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public GetIndicesSettingsResponse getSettings(GetIndicesSettingsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetIndicesSettingsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Returns settings for one or more indexes.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link GetIndicesSettingsRequest}
     */
    public final GetIndicesSettingsResponse getSettings(
        Function<GetIndicesSettingsRequest.Builder, ObjectBuilder<GetIndicesSettingsRequest>> fn
    ) throws IOException, OpenSearchException {
        return getSettings(fn.apply(new GetIndicesSettingsRequest.Builder()).build());
    }

    /**
     * <p>
     * Returns settings for one or more indexes.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public final GetIndicesSettingsResponse getSettings() throws IOException, OpenSearchException {
        return getSettings(new GetIndicesSettingsRequest.Builder().build());
    }

    // ----- Endpoint: indices.get_template

    /**
     * <p>
     * Returns an index template.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public GetTemplateResponse getTemplate(GetTemplateRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetTemplateRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Returns an index template.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link GetTemplateRequest}
     */
    public final GetTemplateResponse getTemplate(Function<GetTemplateRequest.Builder, ObjectBuilder<GetTemplateRequest>> fn)
        throws IOException, OpenSearchException {
        return getTemplate(fn.apply(new GetTemplateRequest.Builder()).build());
    }

    /**
     * <p>
     * Returns an index template.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public final GetTemplateResponse getTemplate() throws IOException, OpenSearchException {
        return getTemplate(new GetTemplateRequest.Builder().build());
    }

    // ----- Endpoint: indices.modify_data_stream

    /**
     * <p>
     * Adds or removes backing indexes of a data stream with metadata-only actions. This is an experimental API.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>3.8</code>
     * </p>
     */
    public ModifyDataStreamResponse modifyDataStream(ModifyDataStreamRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, ModifyDataStreamRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Adds or removes backing indexes of a data stream with metadata-only actions. This is an experimental API.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>3.8</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link ModifyDataStreamRequest}
     */
    public final ModifyDataStreamResponse modifyDataStream(
        Function<ModifyDataStreamRequest.Builder, ObjectBuilder<ModifyDataStreamRequest>> fn
    ) throws IOException, OpenSearchException {
        return modifyDataStream(fn.apply(new ModifyDataStreamRequest.Builder()).build());
    }

    // ----- Endpoint: indices.open

    /**
     * <p>
     * Opens an index.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public OpenResponse open(OpenRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, OpenRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Opens an index.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link OpenRequest}
     */
    public final OpenResponse open(Function<OpenRequest.Builder, ObjectBuilder<OpenRequest>> fn) throws IOException, OpenSearchException {
        return open(fn.apply(new OpenRequest.Builder()).build());
    }

    // ----- Endpoint: indices.put_alias

    /**
     * <p>
     * Creates or updates an alias.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public PutAliasResponse putAlias(PutAliasRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, PutAliasRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Creates or updates an alias.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link PutAliasRequest}
     */
    public final PutAliasResponse putAlias(Function<PutAliasRequest.Builder, ObjectBuilder<PutAliasRequest>> fn) throws IOException,
        OpenSearchException {
        return putAlias(fn.apply(new PutAliasRequest.Builder()).build());
    }

    /**
     * <p>
     * Creates or updates an alias.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public final PutAliasResponse putAlias() throws IOException, OpenSearchException {
        return putAlias(new PutAliasRequest.Builder().build());
    }

    // ----- Endpoint: indices.put_index_template

    /**
     * <p>
     * Creates or updates an index template.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public PutIndexTemplateResponse putIndexTemplate(PutIndexTemplateRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, PutIndexTemplateRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Creates or updates an index template.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link PutIndexTemplateRequest}
     */
    public final PutIndexTemplateResponse putIndexTemplate(
        Function<PutIndexTemplateRequest.Builder, ObjectBuilder<PutIndexTemplateRequest>> fn
    ) throws IOException, OpenSearchException {
        return putIndexTemplate(fn.apply(new PutIndexTemplateRequest.Builder()).build());
    }

    // ----- Endpoint: indices.put_mapping

    /**
     * <p>
     * Updates the index mappings.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public PutMappingResponse putMapping(PutMappingRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, PutMappingRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Updates the index mappings.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link PutMappingRequest}
     */
    public final PutMappingResponse putMapping(Function<PutMappingRequest.Builder, ObjectBuilder<PutMappingRequest>> fn) throws IOException,
        OpenSearchException {
        return putMapping(fn.apply(new PutMappingRequest.Builder()).build());
    }

    // ----- Endpoint: indices.put_settings

    /**
     * <p>
     * Updates the index settings.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public PutIndicesSettingsResponse putSettings(PutIndicesSettingsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, PutIndicesSettingsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Updates the index settings.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link PutIndicesSettingsRequest}
     */
    public final PutIndicesSettingsResponse putSettings(
        Function<PutIndicesSettingsRequest.Builder, ObjectBuilder<PutIndicesSettingsRequest>> fn
    ) throws IOException, OpenSearchException {
        return putSettings(fn.apply(new PutIndicesSettingsRequest.Builder()).build());
    }

    // ----- Endpoint: indices.put_template

    /**
     * <p>
     * Creates or updates an index template.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public PutTemplateResponse putTemplate(PutTemplateRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, PutTemplateRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Creates or updates an index template.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link PutTemplateRequest}
     */
    public final PutTemplateResponse putTemplate(Function<PutTemplateRequest.Builder, ObjectBuilder<PutTemplateRequest>> fn)
        throws IOException, OpenSearchException {
        return putTemplate(fn.apply(new PutTemplateRequest.Builder()).build());
    }

    // ----- Endpoint: indices.recovery

    /**
     * <p>
     * Returns information about ongoing index shard recoveries.
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
     * Returns information about ongoing index shard recoveries.
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
     * Returns information about ongoing index shard recoveries.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public final RecoveryResponse recovery() throws IOException, OpenSearchException {
        return recovery(new RecoveryRequest.Builder().build());
    }

    // ----- Endpoint: indices.refresh

    /**
     * <p>
     * Performs the refresh operation in one or more indexes.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public RefreshResponse refresh(RefreshRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, RefreshRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Performs the refresh operation in one or more indexes.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link RefreshRequest}
     */
    public final RefreshResponse refresh(Function<RefreshRequest.Builder, ObjectBuilder<RefreshRequest>> fn) throws IOException,
        OpenSearchException {
        return refresh(fn.apply(new RefreshRequest.Builder()).build());
    }

    /**
     * <p>
     * Performs the refresh operation in one or more indexes.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public final RefreshResponse refresh() throws IOException, OpenSearchException {
        return refresh(new RefreshRequest.Builder().build());
    }

    // ----- Endpoint: indices.resolve_index

    /**
     * <p>
     * Returns information about any matching indexes, aliases, and data streams.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public ResolveIndexResponse resolveIndex(ResolveIndexRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, ResolveIndexRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Returns information about any matching indexes, aliases, and data streams.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link ResolveIndexRequest}
     */
    public final ResolveIndexResponse resolveIndex(Function<ResolveIndexRequest.Builder, ObjectBuilder<ResolveIndexRequest>> fn)
        throws IOException, OpenSearchException {
        return resolveIndex(fn.apply(new ResolveIndexRequest.Builder()).build());
    }

    // ----- Endpoint: indices.rollover

    /**
     * <p>
     * Updates an alias to point to a new index when the existing index is considered to be too large or too old.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public RolloverResponse rollover(RolloverRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, RolloverRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Updates an alias to point to a new index when the existing index is considered to be too large or too old.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link RolloverRequest}
     */
    public final RolloverResponse rollover(Function<RolloverRequest.Builder, ObjectBuilder<RolloverRequest>> fn) throws IOException,
        OpenSearchException {
        return rollover(fn.apply(new RolloverRequest.Builder()).build());
    }

    // ----- Endpoint: indices.shard_stores

    /**
     * <p>
     * Provides store information for shard copies of indexes.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public ShardStoresResponse shardStores(ShardStoresRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, ShardStoresRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Provides store information for shard copies of indexes.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link ShardStoresRequest}
     */
    public final ShardStoresResponse shardStores(Function<ShardStoresRequest.Builder, ObjectBuilder<ShardStoresRequest>> fn)
        throws IOException, OpenSearchException {
        return shardStores(fn.apply(new ShardStoresRequest.Builder()).build());
    }

    /**
     * <p>
     * Provides store information for shard copies of indexes.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public final ShardStoresResponse shardStores() throws IOException, OpenSearchException {
        return shardStores(new ShardStoresRequest.Builder().build());
    }

    // ----- Endpoint: indices.shrink

    /**
     * <p>
     * Allow to shrink an existing index into a new index with fewer primary shards.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public ShrinkResponse shrink(ShrinkRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, ShrinkRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Allow to shrink an existing index into a new index with fewer primary shards.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link ShrinkRequest}
     */
    public final ShrinkResponse shrink(Function<ShrinkRequest.Builder, ObjectBuilder<ShrinkRequest>> fn) throws IOException,
        OpenSearchException {
        return shrink(fn.apply(new ShrinkRequest.Builder()).build());
    }

    // ----- Endpoint: indices.simulate_index_template

    /**
     * <p>
     * Simulate matching the given index name against the index templates in the system.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public SimulateIndexTemplateResponse simulateIndexTemplate(SimulateIndexTemplateRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequest(request, SimulateIndexTemplateRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Simulate matching the given index name against the index templates in the system.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link SimulateIndexTemplateRequest}
     */
    public final SimulateIndexTemplateResponse simulateIndexTemplate(
        Function<SimulateIndexTemplateRequest.Builder, ObjectBuilder<SimulateIndexTemplateRequest>> fn
    ) throws IOException, OpenSearchException {
        return simulateIndexTemplate(fn.apply(new SimulateIndexTemplateRequest.Builder()).build());
    }

    // ----- Endpoint: indices.simulate_template

    /**
     * <p>
     * Simulate resolving the given template name or body.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public SimulateTemplateResponse simulateTemplate(SimulateTemplateRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, SimulateTemplateRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Simulate resolving the given template name or body.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link SimulateTemplateRequest}
     */
    public final SimulateTemplateResponse simulateTemplate(
        Function<SimulateTemplateRequest.Builder, ObjectBuilder<SimulateTemplateRequest>> fn
    ) throws IOException, OpenSearchException {
        return simulateTemplate(fn.apply(new SimulateTemplateRequest.Builder()).build());
    }

    // ----- Endpoint: indices.split

    /**
     * <p>
     * Allows you to split an existing index into a new index with more primary shards.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public SplitResponse split(SplitRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, SplitRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Allows you to split an existing index into a new index with more primary shards.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link SplitRequest}
     */
    public final SplitResponse split(Function<SplitRequest.Builder, ObjectBuilder<SplitRequest>> fn) throws IOException,
        OpenSearchException {
        return split(fn.apply(new SplitRequest.Builder()).build());
    }

    // ----- Endpoint: indices.stats

    /**
     * <p>
     * Provides statistics on operations happening in an index.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public IndicesStatsResponse stats(IndicesStatsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, IndicesStatsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Provides statistics on operations happening in an index.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link IndicesStatsRequest}
     */
    public final IndicesStatsResponse stats(Function<IndicesStatsRequest.Builder, ObjectBuilder<IndicesStatsRequest>> fn)
        throws IOException, OpenSearchException {
        return stats(fn.apply(new IndicesStatsRequest.Builder()).build());
    }

    /**
     * <p>
     * Provides statistics on operations happening in an index.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public final IndicesStatsResponse stats() throws IOException, OpenSearchException {
        return stats(new IndicesStatsRequest.Builder().build());
    }

    // ----- Endpoint: indices.update_aliases

    /**
     * <p>
     * Updates index aliases.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public UpdateAliasesResponse updateAliases(UpdateAliasesRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, UpdateAliasesRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Updates index aliases.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link UpdateAliasesRequest}
     */
    public final UpdateAliasesResponse updateAliases(Function<UpdateAliasesRequest.Builder, ObjectBuilder<UpdateAliasesRequest>> fn)
        throws IOException, OpenSearchException {
        return updateAliases(fn.apply(new UpdateAliasesRequest.Builder()).build());
    }

    /**
     * <p>
     * Updates index aliases.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public final UpdateAliasesResponse updateAliases() throws IOException, OpenSearchException {
        return updateAliases(new UpdateAliasesRequest.Builder().build());
    }

    // ----- Endpoint: indices.validate_query

    /**
     * <p>
     * Allows a user to validate a potentially expensive query without executing it.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public ValidateQueryResponse validateQuery(ValidateQueryRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, ValidateQueryRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Allows a user to validate a potentially expensive query without executing it.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link ValidateQueryRequest}
     */
    public final ValidateQueryResponse validateQuery(Function<ValidateQueryRequest.Builder, ObjectBuilder<ValidateQueryRequest>> fn)
        throws IOException, OpenSearchException {
        return validateQuery(fn.apply(new ValidateQueryRequest.Builder()).build());
    }

    /**
     * <p>
     * Allows a user to validate a potentially expensive query without executing it.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public final ValidateQueryResponse validateQuery() throws IOException, OpenSearchException {
        return validateQuery(new ValidateQueryRequest.Builder().build());
    }
}
