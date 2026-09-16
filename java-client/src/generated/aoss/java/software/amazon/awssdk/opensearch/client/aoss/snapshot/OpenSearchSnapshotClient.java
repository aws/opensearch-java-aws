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

package software.amazon.awssdk.opensearch.client.aoss.snapshot;

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
 * Client for the snapshot namespace.
 */
@Generated("software.amazon.awssdk.opensearch.client.codegen.CodeGenerator")
public class OpenSearchSnapshotClient extends ApiClient<OpenSearchTransport, OpenSearchSnapshotClient> {
    public OpenSearchSnapshotClient(OpenSearchTransport transport) {
        super(transport, null);
    }

    public OpenSearchSnapshotClient(OpenSearchTransport transport, @Nullable TransportOptions transportOptions) {
        super(transport, transportOptions);
    }

    @Override
    public OpenSearchSnapshotClient withTransportOptions(@Nullable TransportOptions transportOptions) {
        return new OpenSearchSnapshotClient(this.transport, transportOptions);
    }

    // ----- Endpoint: snapshot.create

    /**
     * Creates a snapshot within an existing repository.
     */
    public CreateSnapshotResponse create(CreateSnapshotRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, CreateSnapshotRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Creates a snapshot within an existing repository.
     *
     * @param fn a function that initializes a builder to create the {@link CreateSnapshotRequest}
     */
    public final CreateSnapshotResponse create(Function<CreateSnapshotRequest.Builder, ObjectBuilder<CreateSnapshotRequest>> fn)
        throws IOException, OpenSearchException {
        return create(fn.apply(new CreateSnapshotRequest.Builder()).build());
    }

    // ----- Endpoint: snapshot.delete

    /**
     * Deletes a snapshot.
     */
    public DeleteSnapshotResponse delete(DeleteSnapshotRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, DeleteSnapshotRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Deletes a snapshot.
     *
     * @param fn a function that initializes a builder to create the {@link DeleteSnapshotRequest}
     */
    public final DeleteSnapshotResponse delete(Function<DeleteSnapshotRequest.Builder, ObjectBuilder<DeleteSnapshotRequest>> fn)
        throws IOException, OpenSearchException {
        return delete(fn.apply(new DeleteSnapshotRequest.Builder()).build());
    }

    // ----- Endpoint: snapshot.get

    /**
     * Returns information about a snapshot.
     */
    public GetSnapshotResponse get(GetSnapshotRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetSnapshotRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Returns information about a snapshot.
     *
     * @param fn a function that initializes a builder to create the {@link GetSnapshotRequest}
     */
    public final GetSnapshotResponse get(Function<GetSnapshotRequest.Builder, ObjectBuilder<GetSnapshotRequest>> fn) throws IOException,
        OpenSearchException {
        return get(fn.apply(new GetSnapshotRequest.Builder()).build());
    }

    // ----- Endpoint: snapshot.restore

    /**
     * Restores a snapshot.
     */
    public RestoreSnapshotResponse restore(RestoreSnapshotRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, RestoreSnapshotRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Restores a snapshot.
     *
     * @param fn a function that initializes a builder to create the {@link RestoreSnapshotRequest}
     */
    public final RestoreSnapshotResponse restore(Function<RestoreSnapshotRequest.Builder, ObjectBuilder<RestoreSnapshotRequest>> fn)
        throws IOException, OpenSearchException {
        return restore(fn.apply(new RestoreSnapshotRequest.Builder()).build());
    }
}
