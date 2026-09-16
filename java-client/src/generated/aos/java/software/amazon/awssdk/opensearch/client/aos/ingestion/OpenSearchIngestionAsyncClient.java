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

package software.amazon.awssdk.opensearch.client.aos.ingestion;

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
 * Client for the ingestion namespace.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class OpenSearchIngestionAsyncClient extends ApiClient<OpenSearchTransport, OpenSearchIngestionAsyncClient> {
    public OpenSearchIngestionAsyncClient(OpenSearchTransport transport) {
        super(transport, null);
    }

    public OpenSearchIngestionAsyncClient(OpenSearchTransport transport, @Nullable TransportOptions transportOptions) {
        super(transport, transportOptions);
    }

    @Override
    public OpenSearchIngestionAsyncClient withTransportOptions(@Nullable TransportOptions transportOptions) {
        return new OpenSearchIngestionAsyncClient(this.transport, transportOptions);
    }

    // ----- Endpoint: ingestion.get_state

    /**
     * <p>
     * Use this API to retrieve the ingestion state for a given index.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>3.1</code>
     * </p>
     */
    public CompletableFuture<GetStateResponse> getState(GetStateRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, GetStateRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Use this API to retrieve the ingestion state for a given index.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>3.1</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link GetStateRequest}
     */
    public final CompletableFuture<GetStateResponse> getState(Function<GetStateRequest.Builder, ObjectBuilder<GetStateRequest>> fn)
        throws IOException, OpenSearchException {
        return getState(fn.apply(new GetStateRequest.Builder()).build());
    }

    // ----- Endpoint: ingestion.pause

    /**
     * <p>
     * Use this API to pause ingestion for a given index.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>3.1</code>
     * </p>
     */
    public CompletableFuture<PauseResponse> pause(PauseRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, PauseRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Use this API to pause ingestion for a given index.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>3.1</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link PauseRequest}
     */
    public final CompletableFuture<PauseResponse> pause(Function<PauseRequest.Builder, ObjectBuilder<PauseRequest>> fn) throws IOException,
        OpenSearchException {
        return pause(fn.apply(new PauseRequest.Builder()).build());
    }

    // ----- Endpoint: ingestion.resume

    /**
     * <p>
     * Use this API to resume ingestion for the given index.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>3.1</code>
     * </p>
     */
    public CompletableFuture<ResumeResponse> resume(ResumeRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, ResumeRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Use this API to resume ingestion for the given index.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>3.1</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link ResumeRequest}
     */
    public final CompletableFuture<ResumeResponse> resume(Function<ResumeRequest.Builder, ObjectBuilder<ResumeRequest>> fn)
        throws IOException, OpenSearchException {
        return resume(fn.apply(new ResumeRequest.Builder()).build());
    }
}
