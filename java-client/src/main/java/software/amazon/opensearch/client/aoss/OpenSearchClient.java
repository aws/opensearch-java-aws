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
package software.amazon.opensearch.client.aoss;

import java.io.IOException;
import java.util.function.Function;
import javax.annotation.Nullable;
import software.amazon.awssdk.http.SdkHttpClient;
import software.amazon.awssdk.regions.Region;
import software.amazon.opensearch.client.aoss.core.BulkRequest;
import software.amazon.opensearch.client.aoss.core.BulkResponse;
import software.amazon.opensearch.client.aoss.core.CreateRequest;
import software.amazon.opensearch.client.aoss.core.CreateResponse;
import software.amazon.opensearch.client.aoss.core.IndexRequest;
import software.amazon.opensearch.client.aoss.core.IndexResponse;
import software.amazon.opensearch.client.aoss.core.MgetRequest;
import software.amazon.opensearch.client.aoss.core.MgetResponse;
import software.amazon.opensearch.client.aoss.core.MsearchRequest;
import software.amazon.opensearch.client.aoss.core.MsearchResponse;
import software.amazon.opensearch.client.aoss.core.UpdateRequest;
import software.amazon.opensearch.client.aoss.core.UpdateResponse;
import software.amazon.opensearch.client.errors.ErrorResponse;
import software.amazon.opensearch.client.errors.OpenSearchException;
import software.amazon.opensearch.client.generic.OpenSearchGenericClient;
import software.amazon.opensearch.client.transport.JsonEndpoint;
import software.amazon.opensearch.client.transport.OpenSearchTransport;
import software.amazon.opensearch.client.transport.TransportOptions;
import software.amazon.opensearch.client.transport.aws.AwsSdk2Transport;
import software.amazon.opensearch.client.transport.aws.AwsSdk2TransportOptions;
import software.amazon.opensearch.client.transport.endpoints.EndpointWithResponseMapperAttr;
import software.amazon.opensearch.client.util.ObjectBuilder;

/**
 * Client for the namespace.
 */
public class OpenSearchClient extends OpenSearchAossClientBase<OpenSearchClient> {
    public OpenSearchClient(OpenSearchTransport transport) {
        super(transport, null);
    }

    public OpenSearchClient(OpenSearchTransport transport, @Nullable TransportOptions transportOptions) {
        super(transport, transportOptions);
    }

    /**
     * Creates an IAM-authenticated AOSS client. Requests are signed with the {@code aoss} service name.
     */
    public static OpenSearchClient create(
        @Nullable SdkHttpClient httpClient,
        String host,
        Region region,
        @Nullable AwsSdk2TransportOptions options
    ) {
        return new OpenSearchClient(new AwsSdk2Transport(httpClient, host, "aoss", region, options));
    }

    @Override
    public OpenSearchClient withTransportOptions(@Nullable TransportOptions transportOptions) {
        return new OpenSearchClient(this.transport, transportOptions);
    }

    // ----- Child clients
    public OpenSearchGenericClient generic() {
        return new OpenSearchGenericClient(this.transport, this.transportOptions);
    }

    // ----- Endpoint: bulk

    /**
     * Allows to perform multiple index/update/delete operations in a single
     * request.
     *
     *
     */

    public BulkResponse bulk(BulkRequest request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<BulkRequest, BulkResponse, ErrorResponse> endpoint = (JsonEndpoint<
            BulkRequest,
            BulkResponse,
            ErrorResponse>) BulkRequest._ENDPOINT;

        return this.transport.performRequest(request, endpoint, this.transportOptions);
    }

    /**
     * Allows to perform multiple index/update/delete operations in a single
     * request.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link BulkRequest}
     *
     */

    public final BulkResponse bulk(Function<BulkRequest.Builder, ObjectBuilder<BulkRequest>> fn) throws IOException, OpenSearchException {
        return bulk(fn.apply(new BulkRequest.Builder()).build());
    }

    /**
     * Allows to perform multiple index/update/delete operations in a single
     * request.
     *
     *
     */

    public BulkResponse bulk() throws IOException, OpenSearchException {
        return this.transport.performRequest(new BulkRequest.Builder().build(), BulkRequest._ENDPOINT, this.transportOptions);
    }

    // ----- Endpoint: create

    /**
     * Creates a new document in the index.
     * <p>
     * Returns a 409 response when a document with a same ID already exists in the
     * index.
     *
     *
     */

    public <TDocument> CreateResponse create(CreateRequest<TDocument> request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<CreateRequest<?>, CreateResponse, ErrorResponse> endpoint = (JsonEndpoint<
            CreateRequest<?>,
            CreateResponse,
            ErrorResponse>) CreateRequest._ENDPOINT;

        return this.transport.performRequest(request, endpoint, this.transportOptions);
    }

    /**
     * Creates a new document in the index.
     * <p>
     * Returns a 409 response when a document with a same ID already exists in the
     * index.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link CreateRequest}
     *
     */

    public final <TDocument> CreateResponse create(Function<CreateRequest.Builder<TDocument>, ObjectBuilder<CreateRequest<TDocument>>> fn)
        throws IOException, OpenSearchException {
        return create(fn.apply(new CreateRequest.Builder<TDocument>()).build());
    }

    // ----- Endpoint: index

    /**
     * Creates or updates a document in an index.
     *
     *
     */

    public <TDocument> IndexResponse index(IndexRequest<TDocument> request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<IndexRequest<?>, IndexResponse, ErrorResponse> endpoint = (JsonEndpoint<
            IndexRequest<?>,
            IndexResponse,
            ErrorResponse>) IndexRequest._ENDPOINT;

        return this.transport.performRequest(request, endpoint, this.transportOptions);
    }

    /**
     * Creates or updates a document in an index.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link IndexRequest}
     *
     */

    public final <TDocument> IndexResponse index(Function<IndexRequest.Builder<TDocument>, ObjectBuilder<IndexRequest<TDocument>>> fn)
        throws IOException, OpenSearchException {
        return index(fn.apply(new IndexRequest.Builder<TDocument>()).build());
    }

    // ----- Endpoint: mget

    /**
     * Allows to get multiple documents in one request.
     *
     *
     */

    public <TDocument> MgetResponse<TDocument> mget(MgetRequest request, Class<TDocument> tDocumentClass) throws IOException,
        OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<MgetRequest, MgetResponse<TDocument>, ErrorResponse> endpoint = (JsonEndpoint<
            MgetRequest,
            MgetResponse<TDocument>,
            ErrorResponse>) MgetRequest._ENDPOINT;
        endpoint = new EndpointWithResponseMapperAttr<>(
            endpoint,
            "software.amazon.opensearch.client:Deserializer:_global.mget.TDocument",
            getDeserializer(tDocumentClass)
        );

        return this.transport.performRequest(request, endpoint, this.transportOptions);
    }

    /**
     * Allows to get multiple documents in one request.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link MgetRequest}
     *
     */

    public final <TDocument> MgetResponse<TDocument> mget(
        Function<MgetRequest.Builder, ObjectBuilder<MgetRequest>> fn,
        Class<TDocument> tDocumentClass
    ) throws IOException, OpenSearchException {
        return mget(fn.apply(new MgetRequest.Builder()).build(), tDocumentClass);
    }

    // ----- Endpoint: msearch

    /**
     * Allows to execute several search operations in one request.
     *
     *
     */

    public <TDocument> MsearchResponse<TDocument> msearch(MsearchRequest request, Class<TDocument> tDocumentClass) throws IOException,
        OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<MsearchRequest, MsearchResponse<TDocument>, ErrorResponse> endpoint = (JsonEndpoint<
            MsearchRequest,
            MsearchResponse<TDocument>,
            ErrorResponse>) MsearchRequest._ENDPOINT;
        endpoint = new EndpointWithResponseMapperAttr<>(
            endpoint,
            "software.amazon.opensearch.client:Deserializer:_global.msearch.TDocument",
            getDeserializer(tDocumentClass)
        );

        return this.transport.performRequest(request, endpoint, this.transportOptions);
    }

    /**
     * Allows to execute several search operations in one request.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link MsearchRequest}
     *
     */

    public final <TDocument> MsearchResponse<TDocument> msearch(
        Function<MsearchRequest.Builder, ObjectBuilder<MsearchRequest>> fn,
        Class<TDocument> tDocumentClass
    ) throws IOException, OpenSearchException {
        return msearch(fn.apply(new MsearchRequest.Builder()).build(), tDocumentClass);
    }

    // ----- Endpoint: update

    /**
     * Updates a document with a script or partial document.
     *
     *
     */

    public <TDocument, TPartialDocument> UpdateResponse<TDocument> update(
        UpdateRequest<TDocument, TPartialDocument> request,
        Class<TDocument> tDocumentClass
    ) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<UpdateRequest<?, ?>, UpdateResponse<TDocument>, ErrorResponse> endpoint = (JsonEndpoint<
            UpdateRequest<?, ?>,
            UpdateResponse<TDocument>,
            ErrorResponse>) UpdateRequest._ENDPOINT;
        endpoint = new EndpointWithResponseMapperAttr<>(
            endpoint,
            "software.amazon.opensearch.client:Deserializer:_global.update.TDocument",
            getDeserializer(tDocumentClass)
        );

        return this.transport.performRequest(request, endpoint, this.transportOptions);
    }

    /**
     * Updates a document with a script or partial document.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link UpdateRequest}
     *
     */

    public final <TDocument, TPartialDocument> UpdateResponse<TDocument> update(

        Function<UpdateRequest.Builder<TDocument, TPartialDocument>, ObjectBuilder<UpdateRequest<TDocument, TPartialDocument>>> fn,
        Class<TDocument> tDocumentClass
    ) throws IOException, OpenSearchException {
        return update(fn.apply(new UpdateRequest.Builder<TDocument, TPartialDocument>()).build(), tDocumentClass);
    }
}
