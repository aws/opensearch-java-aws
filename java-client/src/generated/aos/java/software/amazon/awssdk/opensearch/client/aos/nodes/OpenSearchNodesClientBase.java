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

package software.amazon.awssdk.opensearch.client.aos.nodes;

import java.io.IOException;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nullable;
import software.amazon.awssdk.opensearch.client.ApiClient;
import software.amazon.awssdk.opensearch.client.errors.OpenSearchException;
import software.amazon.awssdk.opensearch.client.transport.OpenSearchTransport;
import software.amazon.awssdk.opensearch.client.transport.TransportOptions;
import software.amazon.awssdk.opensearch.client.util.ObjectBuilder;

/**
 * Client for the nodes namespace.
 */
@Generated("software.amazon.awssdk.opensearch.client.codegen.CodeGenerator")
public abstract class OpenSearchNodesClientBase<Self extends OpenSearchNodesClientBase<Self>> extends ApiClient<OpenSearchTransport, Self> {
    public OpenSearchNodesClientBase(OpenSearchTransport transport, @Nullable TransportOptions transportOptions) {
        super(transport, transportOptions);
    }

    // ----- Endpoint: nodes.info

    /**
     * <p>
     * Returns information about nodes in the cluster.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public NodesInfoResponse info(NodesInfoRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, NodesInfoRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Returns information about nodes in the cluster.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link NodesInfoRequest}
     */
    public final NodesInfoResponse info(Function<NodesInfoRequest.Builder, ObjectBuilder<NodesInfoRequest>> fn) throws IOException,
        OpenSearchException {
        return info(fn.apply(new NodesInfoRequest.Builder()).build());
    }

    /**
     * <p>
     * Returns information about nodes in the cluster.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public final NodesInfoResponse info() throws IOException, OpenSearchException {
        return info(new NodesInfoRequest.Builder().build());
    }

    // ----- Endpoint: nodes.reload_secure_settings

    /**
     * <p>
     * Reloads secure settings.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public ReloadSecureSettingsResponse reloadSecureSettings(ReloadSecureSettingsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, ReloadSecureSettingsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Reloads secure settings.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link ReloadSecureSettingsRequest}
     */
    public final ReloadSecureSettingsResponse reloadSecureSettings(
        Function<ReloadSecureSettingsRequest.Builder, ObjectBuilder<ReloadSecureSettingsRequest>> fn
    ) throws IOException, OpenSearchException {
        return reloadSecureSettings(fn.apply(new ReloadSecureSettingsRequest.Builder()).build());
    }

    /**
     * <p>
     * Reloads secure settings.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public final ReloadSecureSettingsResponse reloadSecureSettings() throws IOException, OpenSearchException {
        return reloadSecureSettings(new ReloadSecureSettingsRequest.Builder().build());
    }

    // ----- Endpoint: nodes.stats

    /**
     * <p>
     * Returns statistical information about nodes in the cluster.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public NodesStatsResponse stats(NodesStatsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, NodesStatsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Returns statistical information about nodes in the cluster.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link NodesStatsRequest}
     */
    public final NodesStatsResponse stats(Function<NodesStatsRequest.Builder, ObjectBuilder<NodesStatsRequest>> fn) throws IOException,
        OpenSearchException {
        return stats(fn.apply(new NodesStatsRequest.Builder()).build());
    }

    /**
     * <p>
     * Returns statistical information about nodes in the cluster.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public final NodesStatsResponse stats() throws IOException, OpenSearchException {
        return stats(new NodesStatsRequest.Builder().build());
    }

    // ----- Endpoint: nodes.usage

    /**
     * <p>
     * Returns low-level information about REST actions usage on nodes.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public NodesUsageResponse usage(NodesUsageRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, NodesUsageRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Returns low-level information about REST actions usage on nodes.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link NodesUsageRequest}
     */
    public final NodesUsageResponse usage(Function<NodesUsageRequest.Builder, ObjectBuilder<NodesUsageRequest>> fn) throws IOException,
        OpenSearchException {
        return usage(fn.apply(new NodesUsageRequest.Builder()).build());
    }

    /**
     * <p>
     * Returns low-level information about REST actions usage on nodes.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public final NodesUsageResponse usage() throws IOException, OpenSearchException {
        return usage(new NodesUsageRequest.Builder().build());
    }
}
