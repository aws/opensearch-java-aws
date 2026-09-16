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

package software.amazon.awssdk.opensearch.client.aos.search_pipeline;

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
 * Client for the search_pipeline namespace.
 */
@Generated("software.amazon.awssdk.opensearch.client.codegen.CodeGenerator")
public class OpenSearchSearchPipelineAsyncClient extends ApiClient<OpenSearchTransport, OpenSearchSearchPipelineAsyncClient> {
    public OpenSearchSearchPipelineAsyncClient(OpenSearchTransport transport) {
        super(transport, null);
    }

    public OpenSearchSearchPipelineAsyncClient(OpenSearchTransport transport, @Nullable TransportOptions transportOptions) {
        super(transport, transportOptions);
    }

    @Override
    public OpenSearchSearchPipelineAsyncClient withTransportOptions(@Nullable TransportOptions transportOptions) {
        return new OpenSearchSearchPipelineAsyncClient(this.transport, transportOptions);
    }

    // ----- Endpoint: search_pipeline.delete

    /**
     * <p>
     * Deletes the specified search pipeline.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.9</code>
     * </p>
     */
    public CompletableFuture<DeleteSearchPipelineResponse> delete(DeleteSearchPipelineRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, DeleteSearchPipelineRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Deletes the specified search pipeline.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.9</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link DeleteSearchPipelineRequest}
     */
    public final CompletableFuture<DeleteSearchPipelineResponse> delete(
        Function<DeleteSearchPipelineRequest.Builder, ObjectBuilder<DeleteSearchPipelineRequest>> fn
    ) throws IOException, OpenSearchException {
        return delete(fn.apply(new DeleteSearchPipelineRequest.Builder()).build());
    }

    // ----- Endpoint: search_pipeline.get

    /**
     * <p>
     * Retrieves information about a specified search pipeline.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.9</code>
     * </p>
     */
    public CompletableFuture<GetSearchPipelineResponse> get(GetSearchPipelineRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, GetSearchPipelineRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Retrieves information about a specified search pipeline.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.9</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link GetSearchPipelineRequest}
     */
    public final CompletableFuture<GetSearchPipelineResponse> get(
        Function<GetSearchPipelineRequest.Builder, ObjectBuilder<GetSearchPipelineRequest>> fn
    ) throws IOException, OpenSearchException {
        return get(fn.apply(new GetSearchPipelineRequest.Builder()).build());
    }

    /**
     * <p>
     * Retrieves information about a specified search pipeline.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.9</code>
     * </p>
     */
    public final CompletableFuture<GetSearchPipelineResponse> get() throws IOException, OpenSearchException {
        return get(new GetSearchPipelineRequest.Builder().build());
    }

    // ----- Endpoint: search_pipeline.put

    /**
     * <p>
     * Creates or replaces the specified search pipeline.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.9</code>
     * </p>
     */
    public CompletableFuture<PutSearchPipelineResponse> put(PutSearchPipelineRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, PutSearchPipelineRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Creates or replaces the specified search pipeline.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.9</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link PutSearchPipelineRequest}
     */
    public final CompletableFuture<PutSearchPipelineResponse> put(
        Function<PutSearchPipelineRequest.Builder, ObjectBuilder<PutSearchPipelineRequest>> fn
    ) throws IOException, OpenSearchException {
        return put(fn.apply(new PutSearchPipelineRequest.Builder()).build());
    }
}
