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

package software.amazon.opensearch.client.aoss.indices;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nullable;
import software.amazon.opensearch.client.ApiClient;
import software.amazon.opensearch.client.errors.OpenSearchException;
import software.amazon.opensearch.client.transport.OpenSearchTransport;
import software.amazon.opensearch.client.transport.TransportOptions;
import software.amazon.opensearch.client.transport.endpoints.BooleanResponse;
import software.amazon.opensearch.client.util.ObjectBuilder;

/**
 * Client for the indices namespace.
 */
@Generated("software.amazon.opensearch.client.codegen.CodeGenerator")
public abstract class OpenSearchIndicesAsyncClientBase<Self extends OpenSearchIndicesAsyncClientBase<Self>> extends ApiClient<
    OpenSearchTransport,
    Self> {
    public OpenSearchIndicesAsyncClientBase(OpenSearchTransport transport, @Nullable TransportOptions transportOptions) {
        super(transport, transportOptions);
    }

    // ----- Endpoint: indices.analyze

    /**
     * Performs the analysis process on a text and return the tokens breakdown of the text.
     */
    public CompletableFuture<AnalyzeResponse> analyze(AnalyzeRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, AnalyzeRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Performs the analysis process on a text and return the tokens breakdown of the text.
     *
     * @param fn a function that initializes a builder to create the {@link AnalyzeRequest}
     */
    public final CompletableFuture<AnalyzeResponse> analyze(Function<AnalyzeRequest.Builder, ObjectBuilder<AnalyzeRequest>> fn)
        throws IOException, OpenSearchException {
        return analyze(fn.apply(new AnalyzeRequest.Builder()).build());
    }

    /**
     * Performs the analysis process on a text and return the tokens breakdown of the text.
     */
    public final CompletableFuture<AnalyzeResponse> analyze() throws IOException, OpenSearchException {
        return analyze(new AnalyzeRequest.Builder().build());
    }

    // ----- Endpoint: indices.create

    /**
     * Creates an index with optional settings and mappings.
     */
    public CompletableFuture<CreateIndexResponse> create(CreateIndexRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, CreateIndexRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Creates an index with optional settings and mappings.
     *
     * @param fn a function that initializes a builder to create the {@link CreateIndexRequest}
     */
    public final CompletableFuture<CreateIndexResponse> create(Function<CreateIndexRequest.Builder, ObjectBuilder<CreateIndexRequest>> fn)
        throws IOException, OpenSearchException {
        return create(fn.apply(new CreateIndexRequest.Builder()).build());
    }

    // ----- Endpoint: indices.delete

    /**
     * Deletes an index.
     */
    public CompletableFuture<DeleteIndexResponse> delete(DeleteIndexRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, DeleteIndexRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Deletes an index.
     *
     * @param fn a function that initializes a builder to create the {@link DeleteIndexRequest}
     */
    public final CompletableFuture<DeleteIndexResponse> delete(Function<DeleteIndexRequest.Builder, ObjectBuilder<DeleteIndexRequest>> fn)
        throws IOException, OpenSearchException {
        return delete(fn.apply(new DeleteIndexRequest.Builder()).build());
    }

    // ----- Endpoint: indices.delete_alias

    /**
     * Deletes an alias.
     */
    public CompletableFuture<DeleteAliasResponse> deleteAlias(DeleteAliasRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, DeleteAliasRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Deletes an alias.
     *
     * @param fn a function that initializes a builder to create the {@link DeleteAliasRequest}
     */
    public final CompletableFuture<DeleteAliasResponse> deleteAlias(
        Function<DeleteAliasRequest.Builder, ObjectBuilder<DeleteAliasRequest>> fn
    ) throws IOException, OpenSearchException {
        return deleteAlias(fn.apply(new DeleteAliasRequest.Builder()).build());
    }

    // ----- Endpoint: indices.delete_index_template

    /**
     * Deletes an index template.
     */
    public CompletableFuture<DeleteIndexTemplateResponse> deleteIndexTemplate(DeleteIndexTemplateRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, DeleteIndexTemplateRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Deletes an index template.
     *
     * @param fn a function that initializes a builder to create the {@link DeleteIndexTemplateRequest}
     */
    public final CompletableFuture<DeleteIndexTemplateResponse> deleteIndexTemplate(
        Function<DeleteIndexTemplateRequest.Builder, ObjectBuilder<DeleteIndexTemplateRequest>> fn
    ) throws IOException, OpenSearchException {
        return deleteIndexTemplate(fn.apply(new DeleteIndexTemplateRequest.Builder()).build());
    }

    // ----- Endpoint: indices.exists

    /**
     * Returns information about whether a particular index exists.
     */
    public CompletableFuture<BooleanResponse> exists(ExistsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, ExistsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns information about whether a particular index exists.
     *
     * @param fn a function that initializes a builder to create the {@link ExistsRequest}
     */
    public final CompletableFuture<BooleanResponse> exists(Function<ExistsRequest.Builder, ObjectBuilder<ExistsRequest>> fn)
        throws IOException, OpenSearchException {
        return exists(fn.apply(new ExistsRequest.Builder()).build());
    }

    // ----- Endpoint: indices.exists_alias

    /**
     * Returns information about whether a particular alias exists.
     */
    public CompletableFuture<BooleanResponse> existsAlias(ExistsAliasRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, ExistsAliasRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns information about whether a particular alias exists.
     *
     * @param fn a function that initializes a builder to create the {@link ExistsAliasRequest}
     */
    public final CompletableFuture<BooleanResponse> existsAlias(Function<ExistsAliasRequest.Builder, ObjectBuilder<ExistsAliasRequest>> fn)
        throws IOException, OpenSearchException {
        return existsAlias(fn.apply(new ExistsAliasRequest.Builder()).build());
    }

    // ----- Endpoint: indices.exists_index_template

    /**
     * Returns information about whether a particular index template exists.
     */
    public CompletableFuture<BooleanResponse> existsIndexTemplate(ExistsIndexTemplateRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, ExistsIndexTemplateRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns information about whether a particular index template exists.
     *
     * @param fn a function that initializes a builder to create the {@link ExistsIndexTemplateRequest}
     */
    public final CompletableFuture<BooleanResponse> existsIndexTemplate(
        Function<ExistsIndexTemplateRequest.Builder, ObjectBuilder<ExistsIndexTemplateRequest>> fn
    ) throws IOException, OpenSearchException {
        return existsIndexTemplate(fn.apply(new ExistsIndexTemplateRequest.Builder()).build());
    }

    // ----- Endpoint: indices.get

    /**
     * Returns information about one or more indexes.
     */
    public CompletableFuture<GetIndexResponse> get(GetIndexRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, GetIndexRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns information about one or more indexes.
     *
     * @param fn a function that initializes a builder to create the {@link GetIndexRequest}
     */
    public final CompletableFuture<GetIndexResponse> get(Function<GetIndexRequest.Builder, ObjectBuilder<GetIndexRequest>> fn)
        throws IOException, OpenSearchException {
        return get(fn.apply(new GetIndexRequest.Builder()).build());
    }

    // ----- Endpoint: indices.get_alias

    /**
     * Returns an alias.
     */
    public CompletableFuture<GetAliasResponse> getAlias(GetAliasRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, GetAliasRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns an alias.
     *
     * @param fn a function that initializes a builder to create the {@link GetAliasRequest}
     */
    public final CompletableFuture<GetAliasResponse> getAlias(Function<GetAliasRequest.Builder, ObjectBuilder<GetAliasRequest>> fn)
        throws IOException, OpenSearchException {
        return getAlias(fn.apply(new GetAliasRequest.Builder()).build());
    }

    /**
     * Returns an alias.
     */
    public final CompletableFuture<GetAliasResponse> getAlias() throws IOException, OpenSearchException {
        return getAlias(new GetAliasRequest.Builder().build());
    }

    // ----- Endpoint: indices.get_index_template

    /**
     * Returns an index template.
     */
    public CompletableFuture<GetIndexTemplateResponse> getIndexTemplate(GetIndexTemplateRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, GetIndexTemplateRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns an index template.
     *
     * @param fn a function that initializes a builder to create the {@link GetIndexTemplateRequest}
     */
    public final CompletableFuture<GetIndexTemplateResponse> getIndexTemplate(
        Function<GetIndexTemplateRequest.Builder, ObjectBuilder<GetIndexTemplateRequest>> fn
    ) throws IOException, OpenSearchException {
        return getIndexTemplate(fn.apply(new GetIndexTemplateRequest.Builder()).build());
    }

    /**
     * Returns an index template.
     */
    public final CompletableFuture<GetIndexTemplateResponse> getIndexTemplate() throws IOException, OpenSearchException {
        return getIndexTemplate(new GetIndexTemplateRequest.Builder().build());
    }

    // ----- Endpoint: indices.get_mapping

    /**
     * Returns mappings for one or more indexes.
     */
    public CompletableFuture<GetMappingResponse> getMapping(GetMappingRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, GetMappingRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns mappings for one or more indexes.
     *
     * @param fn a function that initializes a builder to create the {@link GetMappingRequest}
     */
    public final CompletableFuture<GetMappingResponse> getMapping(Function<GetMappingRequest.Builder, ObjectBuilder<GetMappingRequest>> fn)
        throws IOException, OpenSearchException {
        return getMapping(fn.apply(new GetMappingRequest.Builder()).build());
    }

    /**
     * Returns mappings for one or more indexes.
     */
    public final CompletableFuture<GetMappingResponse> getMapping() throws IOException, OpenSearchException {
        return getMapping(new GetMappingRequest.Builder().build());
    }

    // ----- Endpoint: indices.get_settings

    /**
     * Returns settings for one or more indexes.
     */
    public CompletableFuture<GetIndicesSettingsResponse> getSettings(GetIndicesSettingsRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, GetIndicesSettingsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns settings for one or more indexes.
     *
     * @param fn a function that initializes a builder to create the {@link GetIndicesSettingsRequest}
     */
    public final CompletableFuture<GetIndicesSettingsResponse> getSettings(
        Function<GetIndicesSettingsRequest.Builder, ObjectBuilder<GetIndicesSettingsRequest>> fn
    ) throws IOException, OpenSearchException {
        return getSettings(fn.apply(new GetIndicesSettingsRequest.Builder()).build());
    }

    /**
     * Returns settings for one or more indexes.
     */
    public final CompletableFuture<GetIndicesSettingsResponse> getSettings() throws IOException, OpenSearchException {
        return getSettings(new GetIndicesSettingsRequest.Builder().build());
    }

    // ----- Endpoint: indices.put_alias

    /**
     * Creates or updates an alias.
     */
    public CompletableFuture<PutAliasResponse> putAlias(PutAliasRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, PutAliasRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Creates or updates an alias.
     *
     * @param fn a function that initializes a builder to create the {@link PutAliasRequest}
     */
    public final CompletableFuture<PutAliasResponse> putAlias(Function<PutAliasRequest.Builder, ObjectBuilder<PutAliasRequest>> fn)
        throws IOException, OpenSearchException {
        return putAlias(fn.apply(new PutAliasRequest.Builder()).build());
    }

    // ----- Endpoint: indices.put_index_template

    /**
     * Creates or updates an index template.
     */
    public CompletableFuture<PutIndexTemplateResponse> putIndexTemplate(PutIndexTemplateRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, PutIndexTemplateRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Creates or updates an index template.
     *
     * @param fn a function that initializes a builder to create the {@link PutIndexTemplateRequest}
     */
    public final CompletableFuture<PutIndexTemplateResponse> putIndexTemplate(
        Function<PutIndexTemplateRequest.Builder, ObjectBuilder<PutIndexTemplateRequest>> fn
    ) throws IOException, OpenSearchException {
        return putIndexTemplate(fn.apply(new PutIndexTemplateRequest.Builder()).build());
    }

    // ----- Endpoint: indices.put_mapping

    /**
     * Updates the index mappings.
     */
    public CompletableFuture<PutMappingResponse> putMapping(PutMappingRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, PutMappingRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Updates the index mappings.
     *
     * @param fn a function that initializes a builder to create the {@link PutMappingRequest}
     */
    public final CompletableFuture<PutMappingResponse> putMapping(Function<PutMappingRequest.Builder, ObjectBuilder<PutMappingRequest>> fn)
        throws IOException, OpenSearchException {
        return putMapping(fn.apply(new PutMappingRequest.Builder()).build());
    }

    // ----- Endpoint: indices.put_settings

    /**
     * Updates the index settings.
     */
    public CompletableFuture<PutIndicesSettingsResponse> putSettings(PutIndicesSettingsRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, PutIndicesSettingsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Updates the index settings.
     *
     * @param fn a function that initializes a builder to create the {@link PutIndicesSettingsRequest}
     */
    public final CompletableFuture<PutIndicesSettingsResponse> putSettings(
        Function<PutIndicesSettingsRequest.Builder, ObjectBuilder<PutIndicesSettingsRequest>> fn
    ) throws IOException, OpenSearchException {
        return putSettings(fn.apply(new PutIndicesSettingsRequest.Builder()).build());
    }

    // ----- Endpoint: indices.resolve_index

    /**
     * Returns information about any matching indexes, aliases, and data streams.
     */
    public CompletableFuture<ResolveIndexResponse> resolveIndex(ResolveIndexRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, ResolveIndexRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns information about any matching indexes, aliases, and data streams.
     *
     * @param fn a function that initializes a builder to create the {@link ResolveIndexRequest}
     */
    public final CompletableFuture<ResolveIndexResponse> resolveIndex(
        Function<ResolveIndexRequest.Builder, ObjectBuilder<ResolveIndexRequest>> fn
    ) throws IOException, OpenSearchException {
        return resolveIndex(fn.apply(new ResolveIndexRequest.Builder()).build());
    }

    // ----- Endpoint: indices.update_aliases

    /**
     * Updates index aliases.
     */
    public CompletableFuture<UpdateAliasesResponse> updateAliases(UpdateAliasesRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, UpdateAliasesRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Updates index aliases.
     *
     * @param fn a function that initializes a builder to create the {@link UpdateAliasesRequest}
     */
    public final CompletableFuture<UpdateAliasesResponse> updateAliases(
        Function<UpdateAliasesRequest.Builder, ObjectBuilder<UpdateAliasesRequest>> fn
    ) throws IOException, OpenSearchException {
        return updateAliases(fn.apply(new UpdateAliasesRequest.Builder()).build());
    }

    /**
     * Updates index aliases.
     */
    public final CompletableFuture<UpdateAliasesResponse> updateAliases() throws IOException, OpenSearchException {
        return updateAliases(new UpdateAliasesRequest.Builder().build());
    }

    // ----- Endpoint: indices.validate_query

    /**
     * Allows a user to validate a potentially expensive query without executing it.
     */
    public CompletableFuture<ValidateQueryResponse> validateQuery(ValidateQueryRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, ValidateQueryRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Allows a user to validate a potentially expensive query without executing it.
     *
     * @param fn a function that initializes a builder to create the {@link ValidateQueryRequest}
     */
    public final CompletableFuture<ValidateQueryResponse> validateQuery(
        Function<ValidateQueryRequest.Builder, ObjectBuilder<ValidateQueryRequest>> fn
    ) throws IOException, OpenSearchException {
        return validateQuery(fn.apply(new ValidateQueryRequest.Builder()).build());
    }

    /**
     * Allows a user to validate a potentially expensive query without executing it.
     */
    public final CompletableFuture<ValidateQueryResponse> validateQuery() throws IOException, OpenSearchException {
        return validateQuery(new ValidateQueryRequest.Builder().build());
    }
}
