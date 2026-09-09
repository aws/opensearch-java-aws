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

package software.amazon.awssdk.opensearch.client.aos.tasks;

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
 * Client for the tasks namespace.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class OpenSearchTasksClient extends ApiClient<OpenSearchTransport, OpenSearchTasksClient> {
    public OpenSearchTasksClient(OpenSearchTransport transport) {
        super(transport, null);
    }

    public OpenSearchTasksClient(OpenSearchTransport transport, @Nullable TransportOptions transportOptions) {
        super(transport, transportOptions);
    }

    @Override
    public OpenSearchTasksClient withTransportOptions(@Nullable TransportOptions transportOptions) {
        return new OpenSearchTasksClient(this.transport, transportOptions);
    }

    // ----- Endpoint: tasks.cancel

    /**
     * <p>
     * Cancels a task, if it can be cancelled through an API.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public CancelResponse cancel(CancelRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, CancelRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Cancels a task, if it can be cancelled through an API.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link CancelRequest}
     */
    public final CancelResponse cancel(Function<CancelRequest.Builder, ObjectBuilder<CancelRequest>> fn) throws IOException,
        OpenSearchException {
        return cancel(fn.apply(new CancelRequest.Builder()).build());
    }

    /**
     * <p>
     * Cancels a task, if it can be cancelled through an API.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public final CancelResponse cancel() throws IOException, OpenSearchException {
        return cancel(new CancelRequest.Builder().build());
    }

    // ----- Endpoint: tasks.delete

    /**
     * <p>
     * Deletes a stored completed task result.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>3.9</code>
     * </p>
     */
    public DeleteTasksResponse delete(DeleteTasksRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, DeleteTasksRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Deletes a stored completed task result.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>3.9</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link DeleteTasksRequest}
     */
    public final DeleteTasksResponse delete(Function<DeleteTasksRequest.Builder, ObjectBuilder<DeleteTasksRequest>> fn) throws IOException,
        OpenSearchException {
        return delete(fn.apply(new DeleteTasksRequest.Builder()).build());
    }

    // ----- Endpoint: tasks.get

    /**
     * <p>
     * Returns information about a task.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public GetTasksResponse get(GetTasksRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetTasksRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Returns information about a task.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link GetTasksRequest}
     */
    public final GetTasksResponse get(Function<GetTasksRequest.Builder, ObjectBuilder<GetTasksRequest>> fn) throws IOException,
        OpenSearchException {
        return get(fn.apply(new GetTasksRequest.Builder()).build());
    }

    // ----- Endpoint: tasks.list

    /**
     * <p>
     * Returns a list of tasks.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public ListResponse list(ListRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, ListRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Returns a list of tasks.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link ListRequest}
     */
    public final ListResponse list(Function<ListRequest.Builder, ObjectBuilder<ListRequest>> fn) throws IOException, OpenSearchException {
        return list(fn.apply(new ListRequest.Builder()).build());
    }

    /**
     * <p>
     * Returns a list of tasks.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public final ListResponse list() throws IOException, OpenSearchException {
        return list(new ListRequest.Builder().build());
    }
}
