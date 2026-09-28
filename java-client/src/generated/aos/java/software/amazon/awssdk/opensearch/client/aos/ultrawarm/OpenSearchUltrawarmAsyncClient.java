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

package software.amazon.awssdk.opensearch.client.aos.ultrawarm;

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
 * Client for the ultrawarm namespace.
 */
@Generated("software.amazon.awssdk.opensearch.client.codegen.CodeGenerator")
public class OpenSearchUltrawarmAsyncClient extends ApiClient<OpenSearchTransport, OpenSearchUltrawarmAsyncClient> {
    public OpenSearchUltrawarmAsyncClient(OpenSearchTransport transport) {
        super(transport, null);
    }

    public OpenSearchUltrawarmAsyncClient(OpenSearchTransport transport, @Nullable TransportOptions transportOptions) {
        super(transport, transportOptions);
    }

    @Override
    public OpenSearchUltrawarmAsyncClient withTransportOptions(@Nullable TransportOptions transportOptions) {
        return new OpenSearchUltrawarmAsyncClient(this.transport, transportOptions);
    }

    // ----- Endpoint: ultrawarm.cancel

    /**
     * Cancel an in-progress UltraWarm migration.
     */
    public CompletableFuture<CancelResponse> cancel(CancelRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, CancelRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Cancel an in-progress UltraWarm migration.
     *
     * @param fn a function that initializes a builder to create the {@link CancelRequest}
     */
    public final CompletableFuture<CancelResponse> cancel(Function<CancelRequest.Builder, ObjectBuilder<CancelRequest>> fn)
        throws IOException, OpenSearchException {
        return cancel(fn.apply(new CancelRequest.Builder()).build());
    }

    // ----- Endpoint: ultrawarm.get_status

    /**
     * Migration status for a single index.
     */
    public CompletableFuture<GetStatusResponse> getStatus(GetStatusRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, GetStatusRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Migration status for a single index.
     *
     * @param fn a function that initializes a builder to create the {@link GetStatusRequest}
     */
    public final CompletableFuture<GetStatusResponse> getStatus(Function<GetStatusRequest.Builder, ObjectBuilder<GetStatusRequest>> fn)
        throws IOException, OpenSearchException {
        return getStatus(fn.apply(new GetStatusRequest.Builder()).build());
    }

    // ----- Endpoint: ultrawarm.list_status

    /**
     * List all in-progress UltraWarm migrations.
     */
    public CompletableFuture<ListStatusResponse> listStatus(ListStatusRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, ListStatusRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * List all in-progress UltraWarm migrations.
     *
     * @param fn a function that initializes a builder to create the {@link ListStatusRequest}
     */
    public final CompletableFuture<ListStatusResponse> listStatus(Function<ListStatusRequest.Builder, ObjectBuilder<ListStatusRequest>> fn)
        throws IOException, OpenSearchException {
        return listStatus(fn.apply(new ListStatusRequest.Builder()).build());
    }

    /**
     * List all in-progress UltraWarm migrations.
     */
    public final CompletableFuture<ListStatusResponse> listStatus() throws IOException, OpenSearchException {
        return listStatus(new ListStatusRequest.Builder().build());
    }

    // ----- Endpoint: ultrawarm.to_cold

    /**
     * Migrate a warm index to cold storage. Requires start_time and end_time query parameters bounding the index's data.
     */
    public CompletableFuture<ToColdResponse> toCold(ToColdRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, ToColdRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Migrate a warm index to cold storage. Requires start_time and end_time query parameters bounding the index's data.
     *
     * @param fn a function that initializes a builder to create the {@link ToColdRequest}
     */
    public final CompletableFuture<ToColdResponse> toCold(Function<ToColdRequest.Builder, ObjectBuilder<ToColdRequest>> fn)
        throws IOException, OpenSearchException {
        return toCold(fn.apply(new ToColdRequest.Builder()).build());
    }

    // ----- Endpoint: ultrawarm.to_hot

    /**
     * Migrate an index from warm back to hot storage.
     */
    public CompletableFuture<ToHotResponse> toHot(ToHotRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, ToHotRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Migrate an index from warm back to hot storage.
     *
     * @param fn a function that initializes a builder to create the {@link ToHotRequest}
     */
    public final CompletableFuture<ToHotResponse> toHot(Function<ToHotRequest.Builder, ObjectBuilder<ToHotRequest>> fn) throws IOException,
        OpenSearchException {
        return toHot(fn.apply(new ToHotRequest.Builder()).build());
    }

    // ----- Endpoint: ultrawarm.to_warm

    /**
     * Migrate an index from hot to warm storage.
     */
    public CompletableFuture<ToWarmResponse> toWarm(ToWarmRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, ToWarmRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Migrate an index from hot to warm storage.
     *
     * @param fn a function that initializes a builder to create the {@link ToWarmRequest}
     */
    public final CompletableFuture<ToWarmResponse> toWarm(Function<ToWarmRequest.Builder, ObjectBuilder<ToWarmRequest>> fn)
        throws IOException, OpenSearchException {
        return toWarm(fn.apply(new ToWarmRequest.Builder()).build());
    }
}
