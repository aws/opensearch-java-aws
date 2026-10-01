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

package software.amazon.opensearch.client.aoss.cluster;

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
 * Client for the cluster namespace.
 */
@Generated("software.amazon.opensearch.client.codegen.CodeGenerator")
public class OpenSearchClusterAsyncClient extends ApiClient<OpenSearchTransport, OpenSearchClusterAsyncClient> {
    public OpenSearchClusterAsyncClient(OpenSearchTransport transport) {
        super(transport, null);
    }

    public OpenSearchClusterAsyncClient(OpenSearchTransport transport, @Nullable TransportOptions transportOptions) {
        super(transport, transportOptions);
    }

    @Override
    public OpenSearchClusterAsyncClient withTransportOptions(@Nullable TransportOptions transportOptions) {
        return new OpenSearchClusterAsyncClient(this.transport, transportOptions);
    }

    // ----- Endpoint: cluster.delete_component_template

    /**
     * Deletes a component template.
     */
    public CompletableFuture<DeleteComponentTemplateResponse> deleteComponentTemplate(DeleteComponentTemplateRequest request)
        throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, DeleteComponentTemplateRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Deletes a component template.
     *
     * @param fn a function that initializes a builder to create the {@link DeleteComponentTemplateRequest}
     */
    public final CompletableFuture<DeleteComponentTemplateResponse> deleteComponentTemplate(
        Function<DeleteComponentTemplateRequest.Builder, ObjectBuilder<DeleteComponentTemplateRequest>> fn
    ) throws IOException, OpenSearchException {
        return deleteComponentTemplate(fn.apply(new DeleteComponentTemplateRequest.Builder()).build());
    }

    // ----- Endpoint: cluster.exists_component_template

    /**
     * Returns information about whether a particular component template exist.
     */
    public CompletableFuture<BooleanResponse> existsComponentTemplate(ExistsComponentTemplateRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, ExistsComponentTemplateRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns information about whether a particular component template exist.
     *
     * @param fn a function that initializes a builder to create the {@link ExistsComponentTemplateRequest}
     */
    public final CompletableFuture<BooleanResponse> existsComponentTemplate(
        Function<ExistsComponentTemplateRequest.Builder, ObjectBuilder<ExistsComponentTemplateRequest>> fn
    ) throws IOException, OpenSearchException {
        return existsComponentTemplate(fn.apply(new ExistsComponentTemplateRequest.Builder()).build());
    }

    // ----- Endpoint: cluster.get_component_template

    /**
     * Returns one or more component templates.
     */
    public CompletableFuture<GetComponentTemplateResponse> getComponentTemplate(GetComponentTemplateRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, GetComponentTemplateRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns one or more component templates.
     *
     * @param fn a function that initializes a builder to create the {@link GetComponentTemplateRequest}
     */
    public final CompletableFuture<GetComponentTemplateResponse> getComponentTemplate(
        Function<GetComponentTemplateRequest.Builder, ObjectBuilder<GetComponentTemplateRequest>> fn
    ) throws IOException, OpenSearchException {
        return getComponentTemplate(fn.apply(new GetComponentTemplateRequest.Builder()).build());
    }

    /**
     * Returns one or more component templates.
     */
    public final CompletableFuture<GetComponentTemplateResponse> getComponentTemplate() throws IOException, OpenSearchException {
        return getComponentTemplate(new GetComponentTemplateRequest.Builder().build());
    }

    // ----- Endpoint: cluster.put_component_template

    /**
     * Creates or updates a component template.
     */
    public CompletableFuture<PutComponentTemplateResponse> putComponentTemplate(PutComponentTemplateRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, PutComponentTemplateRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Creates or updates a component template.
     *
     * @param fn a function that initializes a builder to create the {@link PutComponentTemplateRequest}
     */
    public final CompletableFuture<PutComponentTemplateResponse> putComponentTemplate(
        Function<PutComponentTemplateRequest.Builder, ObjectBuilder<PutComponentTemplateRequest>> fn
    ) throws IOException, OpenSearchException {
        return putComponentTemplate(fn.apply(new PutComponentTemplateRequest.Builder()).build());
    }
}
