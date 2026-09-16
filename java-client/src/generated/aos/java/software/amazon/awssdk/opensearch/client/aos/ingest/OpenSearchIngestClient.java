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

package software.amazon.awssdk.opensearch.client.aos.ingest;

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
 * Client for the ingest namespace.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class OpenSearchIngestClient extends ApiClient<OpenSearchTransport, OpenSearchIngestClient> {
    public OpenSearchIngestClient(OpenSearchTransport transport) {
        super(transport, null);
    }

    public OpenSearchIngestClient(OpenSearchTransport transport, @Nullable TransportOptions transportOptions) {
        super(transport, transportOptions);
    }

    @Override
    public OpenSearchIngestClient withTransportOptions(@Nullable TransportOptions transportOptions) {
        return new OpenSearchIngestClient(this.transport, transportOptions);
    }

    // ----- Endpoint: ingest.delete_pipeline

    /**
     * <p>
     * Deletes an ingest pipeline.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public DeletePipelineResponse deletePipeline(DeletePipelineRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, DeletePipelineRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Deletes an ingest pipeline.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link DeletePipelineRequest}
     */
    public final DeletePipelineResponse deletePipeline(Function<DeletePipelineRequest.Builder, ObjectBuilder<DeletePipelineRequest>> fn)
        throws IOException, OpenSearchException {
        return deletePipeline(fn.apply(new DeletePipelineRequest.Builder()).build());
    }

    // ----- Endpoint: ingest.get_pipeline

    /**
     * <p>
     * Returns an ingest pipeline.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public GetPipelineResponse getPipeline(GetPipelineRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetPipelineRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Returns an ingest pipeline.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link GetPipelineRequest}
     */
    public final GetPipelineResponse getPipeline(Function<GetPipelineRequest.Builder, ObjectBuilder<GetPipelineRequest>> fn)
        throws IOException, OpenSearchException {
        return getPipeline(fn.apply(new GetPipelineRequest.Builder()).build());
    }

    /**
     * <p>
     * Returns an ingest pipeline.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public final GetPipelineResponse getPipeline() throws IOException, OpenSearchException {
        return getPipeline(new GetPipelineRequest.Builder().build());
    }

    // ----- Endpoint: ingest.put_pipeline

    /**
     * <p>
     * Creates or updates an ingest pipeline.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public PutPipelineResponse putPipeline(PutPipelineRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, PutPipelineRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Creates or updates an ingest pipeline.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link PutPipelineRequest}
     */
    public final PutPipelineResponse putPipeline(Function<PutPipelineRequest.Builder, ObjectBuilder<PutPipelineRequest>> fn)
        throws IOException, OpenSearchException {
        return putPipeline(fn.apply(new PutPipelineRequest.Builder()).build());
    }

    // ----- Endpoint: ingest.simulate

    /**
     * <p>
     * Simulates an ingest pipeline with example documents.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public SimulateResponse simulate(SimulateRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, SimulateRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Simulates an ingest pipeline with example documents.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link SimulateRequest}
     */
    public final SimulateResponse simulate(Function<SimulateRequest.Builder, ObjectBuilder<SimulateRequest>> fn) throws IOException,
        OpenSearchException {
        return simulate(fn.apply(new SimulateRequest.Builder()).build());
    }

    /**
     * <p>
     * Simulates an ingest pipeline with example documents.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public final SimulateResponse simulate() throws IOException, OpenSearchException {
        return simulate(new SimulateRequest.Builder().build());
    }
}
