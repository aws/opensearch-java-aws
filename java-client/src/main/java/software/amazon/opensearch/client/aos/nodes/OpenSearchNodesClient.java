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
package software.amazon.opensearch.client.aos.nodes;

import java.io.IOException;
import java.util.function.Function;
import javax.annotation.Nullable;
import software.amazon.opensearch.client.errors.ErrorResponse;
import software.amazon.opensearch.client.errors.OpenSearchException;
import software.amazon.opensearch.client.transport.JsonEndpoint;
import software.amazon.opensearch.client.transport.OpenSearchTransport;
import software.amazon.opensearch.client.transport.TransportOptions;
import software.amazon.opensearch.client.util.ObjectBuilder;

/**
 * Client for the nodes namespace.
 */
public class OpenSearchNodesClient extends OpenSearchNodesClientBase<OpenSearchNodesClient> {

    public OpenSearchNodesClient(OpenSearchTransport transport) {
        super(transport, null);
    }

    public OpenSearchNodesClient(OpenSearchTransport transport, @Nullable TransportOptions transportOptions) {
        super(transport, transportOptions);
    }

    @Override
    public OpenSearchNodesClient withTransportOptions(@Nullable TransportOptions transportOptions) {
        return new OpenSearchNodesClient(this.transport, transportOptions);
    }

    // ----- Endpoint: nodes.hot_threads

    /**
     * Returns information about hot threads on each node in the cluster.
     *
     *
     */

    public HotThreadsResponse hotThreads(HotThreadsRequest request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<HotThreadsRequest, HotThreadsResponse, ErrorResponse> endpoint = (JsonEndpoint<
            HotThreadsRequest,
            HotThreadsResponse,
            ErrorResponse>) HotThreadsRequest._ENDPOINT;

        return this.transport.performRequest(request, endpoint, this.transportOptions);
    }

    /**
     * Returns information about hot threads on each node in the cluster.
     *
     * @param fn
     *            a function that initializes a builder to create the
     *            {@link HotThreadsRequest}
     *
     */

    public final HotThreadsResponse hotThreads(Function<HotThreadsRequest.Builder, ObjectBuilder<HotThreadsRequest>> fn) throws IOException,
        OpenSearchException {
        return hotThreads(fn.apply(new HotThreadsRequest.Builder()).build());
    }

    /**
     * Returns information about hot threads on each node in the cluster.
     *
     *
     */

    public HotThreadsResponse hotThreads() throws IOException, OpenSearchException {
        return this.transport.performRequest(new HotThreadsRequest.Builder().build(), HotThreadsRequest._ENDPOINT, this.transportOptions);
    }
}
