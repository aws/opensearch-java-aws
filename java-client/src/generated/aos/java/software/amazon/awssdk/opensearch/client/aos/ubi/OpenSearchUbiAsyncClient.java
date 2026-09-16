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

package software.amazon.awssdk.opensearch.client.aos.ubi;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
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
 * Client for the ubi namespace.
 */
@Generated("software.amazon.awssdk.opensearch.client.codegen.CodeGenerator")
public class OpenSearchUbiAsyncClient extends ApiClient<OpenSearchTransport, OpenSearchUbiAsyncClient> {
    public OpenSearchUbiAsyncClient(OpenSearchTransport transport) {
        super(transport, null);
    }

    public OpenSearchUbiAsyncClient(OpenSearchTransport transport, @Nullable TransportOptions transportOptions) {
        super(transport, transportOptions);
    }

    @Override
    public OpenSearchUbiAsyncClient withTransportOptions(@Nullable TransportOptions transportOptions) {
        return new OpenSearchUbiAsyncClient(this.transport, transportOptions);
    }

    // ----- Endpoint: ubi.initialize

    /**
     * <p>
     * Initializes the UBI indexes.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public CompletableFuture<BooleanResponse> initialize(InitializeRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, InitializeRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Initializes the UBI indexes.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link InitializeRequest}
     */
    public final CompletableFuture<BooleanResponse> initialize(Function<InitializeRequest.Builder, ObjectBuilder<InitializeRequest>> fn)
        throws IOException, OpenSearchException {
        return initialize(fn.apply(new InitializeRequest.Builder()).build());
    }

    /**
     * <p>
     * Initializes the UBI indexes.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public final CompletableFuture<BooleanResponse> initialize() throws IOException, OpenSearchException {
        return initialize(new InitializeRequest.Builder().build());
    }
}
