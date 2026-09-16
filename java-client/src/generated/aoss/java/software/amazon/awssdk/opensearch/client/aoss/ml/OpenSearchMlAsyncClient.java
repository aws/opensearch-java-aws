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
//----------------------------------------------------
// THIS CODE IS GENERATED. MANUAL EDITS WILL BE LOST.
//----------------------------------------------------

package software.amazon.awssdk.opensearch.client.aoss.ml;

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
 * Client for the ml namespace.
 */
@Generated("software.amazon.awssdk.opensearch.client.codegen.CodeGenerator")
public class OpenSearchMlAsyncClient extends ApiClient<OpenSearchTransport, OpenSearchMlAsyncClient> {
    public OpenSearchMlAsyncClient(OpenSearchTransport transport) {
        super(transport, null);
    }

    public OpenSearchMlAsyncClient(OpenSearchTransport transport, @Nullable TransportOptions transportOptions) {
        super(transport, transportOptions);
    }

    @Override
    public OpenSearchMlAsyncClient withTransportOptions(@Nullable TransportOptions transportOptions) {
        return new OpenSearchMlAsyncClient(this.transport, transportOptions);
    }

    // ----- Endpoint: ml.add_agentic_memory

    /**
     * Add agentic memory to a memory container.
     */
    public CompletableFuture<AddAgenticMemoryResponse> addAgenticMemory(AddAgenticMemoryRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, AddAgenticMemoryRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Add agentic memory to a memory container.
     *
     * @param fn a function that initializes a builder to create the {@link AddAgenticMemoryRequest}
     */
    public final CompletableFuture<AddAgenticMemoryResponse> addAgenticMemory(
        Function<AddAgenticMemoryRequest.Builder, ObjectBuilder<AddAgenticMemoryRequest>> fn
    ) throws IOException, OpenSearchException {
        return addAgenticMemory(fn.apply(new AddAgenticMemoryRequest.Builder()).build());
    }

    // ----- Endpoint: ml.create_connector

    /**
     * Creates a standalone connector.
     */
    public CompletableFuture<CreateConnectorResponse> createConnector(CreateConnectorRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, CreateConnectorRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Creates a standalone connector.
     *
     * @param fn a function that initializes a builder to create the {@link CreateConnectorRequest}
     */
    public final CompletableFuture<CreateConnectorResponse> createConnector(
        Function<CreateConnectorRequest.Builder, ObjectBuilder<CreateConnectorRequest>> fn
    ) throws IOException, OpenSearchException {
        return createConnector(fn.apply(new CreateConnectorRequest.Builder()).build());
    }

    // ----- Endpoint: ml.create_memory_container

    /**
     * Create a memory container.
     */
    public CompletableFuture<CreateMemoryContainerResponse> createMemoryContainer(CreateMemoryContainerRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, CreateMemoryContainerRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Create a memory container.
     *
     * @param fn a function that initializes a builder to create the {@link CreateMemoryContainerRequest}
     */
    public final CompletableFuture<CreateMemoryContainerResponse> createMemoryContainer(
        Function<CreateMemoryContainerRequest.Builder, ObjectBuilder<CreateMemoryContainerRequest>> fn
    ) throws IOException, OpenSearchException {
        return createMemoryContainer(fn.apply(new CreateMemoryContainerRequest.Builder()).build());
    }

    // ----- Endpoint: ml.create_memory_container_session

    /**
     * Create session in a memory container.
     */
    public CompletableFuture<CreateMemoryContainerSessionResponse> createMemoryContainerSession(CreateMemoryContainerSessionRequest request)
        throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, CreateMemoryContainerSessionRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Create session in a memory container.
     *
     * @param fn a function that initializes a builder to create the {@link CreateMemoryContainerSessionRequest}
     */
    public final CompletableFuture<CreateMemoryContainerSessionResponse> createMemoryContainerSession(
        Function<CreateMemoryContainerSessionRequest.Builder, ObjectBuilder<CreateMemoryContainerSessionRequest>> fn
    ) throws IOException, OpenSearchException {
        return createMemoryContainerSession(fn.apply(new CreateMemoryContainerSessionRequest.Builder()).build());
    }

    // ----- Endpoint: ml.delete_agent

    /**
     * Delete an agent.
     */
    public CompletableFuture<DeleteAgentResponse> deleteAgent(DeleteAgentRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, DeleteAgentRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Delete an agent.
     *
     * @param fn a function that initializes a builder to create the {@link DeleteAgentRequest}
     */
    public final CompletableFuture<DeleteAgentResponse> deleteAgent(
        Function<DeleteAgentRequest.Builder, ObjectBuilder<DeleteAgentRequest>> fn
    ) throws IOException, OpenSearchException {
        return deleteAgent(fn.apply(new DeleteAgentRequest.Builder()).build());
    }

    // ----- Endpoint: ml.delete_agentic_memory

    /**
     * Delete a specific memory by its type and ID.
     */
    public CompletableFuture<DeleteAgenticMemoryResponse> deleteAgenticMemory(DeleteAgenticMemoryRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, DeleteAgenticMemoryRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Delete a specific memory by its type and ID.
     *
     * @param fn a function that initializes a builder to create the {@link DeleteAgenticMemoryRequest}
     */
    public final CompletableFuture<DeleteAgenticMemoryResponse> deleteAgenticMemory(
        Function<DeleteAgenticMemoryRequest.Builder, ObjectBuilder<DeleteAgenticMemoryRequest>> fn
    ) throws IOException, OpenSearchException {
        return deleteAgenticMemory(fn.apply(new DeleteAgenticMemoryRequest.Builder()).build());
    }

    // ----- Endpoint: ml.delete_connector

    /**
     * Deletes a standalone connector.
     */
    public CompletableFuture<DeleteConnectorResponse> deleteConnector(DeleteConnectorRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, DeleteConnectorRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Deletes a standalone connector.
     *
     * @param fn a function that initializes a builder to create the {@link DeleteConnectorRequest}
     */
    public final CompletableFuture<DeleteConnectorResponse> deleteConnector(
        Function<DeleteConnectorRequest.Builder, ObjectBuilder<DeleteConnectorRequest>> fn
    ) throws IOException, OpenSearchException {
        return deleteConnector(fn.apply(new DeleteConnectorRequest.Builder()).build());
    }

    // ----- Endpoint: ml.delete_memory_container

    /**
     * Delete a memory container.
     */
    public CompletableFuture<DeleteMemoryContainerResponse> deleteMemoryContainer(DeleteMemoryContainerRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, DeleteMemoryContainerRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Delete a memory container.
     *
     * @param fn a function that initializes a builder to create the {@link DeleteMemoryContainerRequest}
     */
    public final CompletableFuture<DeleteMemoryContainerResponse> deleteMemoryContainer(
        Function<DeleteMemoryContainerRequest.Builder, ObjectBuilder<DeleteMemoryContainerRequest>> fn
    ) throws IOException, OpenSearchException {
        return deleteMemoryContainer(fn.apply(new DeleteMemoryContainerRequest.Builder()).build());
    }

    // ----- Endpoint: ml.delete_model

    /**
     * Deletes a model.
     */
    public CompletableFuture<DeleteModelResponse> deleteModel(DeleteModelRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, DeleteModelRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Deletes a model.
     *
     * @param fn a function that initializes a builder to create the {@link DeleteModelRequest}
     */
    public final CompletableFuture<DeleteModelResponse> deleteModel(
        Function<DeleteModelRequest.Builder, ObjectBuilder<DeleteModelRequest>> fn
    ) throws IOException, OpenSearchException {
        return deleteModel(fn.apply(new DeleteModelRequest.Builder()).build());
    }

    // ----- Endpoint: ml.delete_model_group

    /**
     * Deletes a model group.
     */
    public CompletableFuture<DeleteModelGroupResponse> deleteModelGroup(DeleteModelGroupRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, DeleteModelGroupRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Deletes a model group.
     *
     * @param fn a function that initializes a builder to create the {@link DeleteModelGroupRequest}
     */
    public final CompletableFuture<DeleteModelGroupResponse> deleteModelGroup(
        Function<DeleteModelGroupRequest.Builder, ObjectBuilder<DeleteModelGroupRequest>> fn
    ) throws IOException, OpenSearchException {
        return deleteModelGroup(fn.apply(new DeleteModelGroupRequest.Builder()).build());
    }

    // ----- Endpoint: ml.delete_task

    /**
     * Deletes a task.
     */
    public CompletableFuture<DeleteTaskResponse> deleteTask(DeleteTaskRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, DeleteTaskRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Deletes a task.
     *
     * @param fn a function that initializes a builder to create the {@link DeleteTaskRequest}
     */
    public final CompletableFuture<DeleteTaskResponse> deleteTask(Function<DeleteTaskRequest.Builder, ObjectBuilder<DeleteTaskRequest>> fn)
        throws IOException, OpenSearchException {
        return deleteTask(fn.apply(new DeleteTaskRequest.Builder()).build());
    }

    // ----- Endpoint: ml.deploy_model

    /**
     * Deploys a model.
     */
    public CompletableFuture<DeployModelResponse> deployModel(DeployModelRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, DeployModelRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Deploys a model.
     *
     * @param fn a function that initializes a builder to create the {@link DeployModelRequest}
     */
    public final CompletableFuture<DeployModelResponse> deployModel(
        Function<DeployModelRequest.Builder, ObjectBuilder<DeployModelRequest>> fn
    ) throws IOException, OpenSearchException {
        return deployModel(fn.apply(new DeployModelRequest.Builder()).build());
    }

    // ----- Endpoint: ml.execute_agent

    /**
     * Execute an agent.
     */
    public CompletableFuture<ExecuteAgentResponse> executeAgent(ExecuteAgentRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, ExecuteAgentRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Execute an agent.
     *
     * @param fn a function that initializes a builder to create the {@link ExecuteAgentRequest}
     */
    public final CompletableFuture<ExecuteAgentResponse> executeAgent(
        Function<ExecuteAgentRequest.Builder, ObjectBuilder<ExecuteAgentRequest>> fn
    ) throws IOException, OpenSearchException {
        return executeAgent(fn.apply(new ExecuteAgentRequest.Builder()).build());
    }

    // ----- Endpoint: ml.get_agent

    /**
     * Get an agent.
     */
    public CompletableFuture<GetAgentResponse> getAgent(GetAgentRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, GetAgentRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Get an agent.
     *
     * @param fn a function that initializes a builder to create the {@link GetAgentRequest}
     */
    public final CompletableFuture<GetAgentResponse> getAgent(Function<GetAgentRequest.Builder, ObjectBuilder<GetAgentRequest>> fn)
        throws IOException, OpenSearchException {
        return getAgent(fn.apply(new GetAgentRequest.Builder()).build());
    }

    // ----- Endpoint: ml.get_agentic_memory

    /**
     * Get a specific memory by its type and ID.
     */
    public CompletableFuture<GetAgenticMemoryResponse> getAgenticMemory(GetAgenticMemoryRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, GetAgenticMemoryRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Get a specific memory by its type and ID.
     *
     * @param fn a function that initializes a builder to create the {@link GetAgenticMemoryRequest}
     */
    public final CompletableFuture<GetAgenticMemoryResponse> getAgenticMemory(
        Function<GetAgenticMemoryRequest.Builder, ObjectBuilder<GetAgenticMemoryRequest>> fn
    ) throws IOException, OpenSearchException {
        return getAgenticMemory(fn.apply(new GetAgenticMemoryRequest.Builder()).build());
    }

    // ----- Endpoint: ml.get_connector

    /**
     * Retrieves a standalone connector.
     */
    public CompletableFuture<GetConnectorResponse> getConnector(GetConnectorRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, GetConnectorRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Retrieves a standalone connector.
     *
     * @param fn a function that initializes a builder to create the {@link GetConnectorRequest}
     */
    public final CompletableFuture<GetConnectorResponse> getConnector(
        Function<GetConnectorRequest.Builder, ObjectBuilder<GetConnectorRequest>> fn
    ) throws IOException, OpenSearchException {
        return getConnector(fn.apply(new GetConnectorRequest.Builder()).build());
    }

    // ----- Endpoint: ml.get_memory_container

    /**
     * Get a memory container.
     */
    public CompletableFuture<GetMemoryContainerResponse> getMemoryContainer(GetMemoryContainerRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, GetMemoryContainerRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Get a memory container.
     *
     * @param fn a function that initializes a builder to create the {@link GetMemoryContainerRequest}
     */
    public final CompletableFuture<GetMemoryContainerResponse> getMemoryContainer(
        Function<GetMemoryContainerRequest.Builder, ObjectBuilder<GetMemoryContainerRequest>> fn
    ) throws IOException, OpenSearchException {
        return getMemoryContainer(fn.apply(new GetMemoryContainerRequest.Builder()).build());
    }

    // ----- Endpoint: ml.get_model

    /**
     * Retrieves a model.
     */
    public CompletableFuture<GetModelResponse> getModel(GetModelRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, GetModelRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Retrieves a model.
     *
     * @param fn a function that initializes a builder to create the {@link GetModelRequest}
     */
    public final CompletableFuture<GetModelResponse> getModel(Function<GetModelRequest.Builder, ObjectBuilder<GetModelRequest>> fn)
        throws IOException, OpenSearchException {
        return getModel(fn.apply(new GetModelRequest.Builder()).build());
    }

    // ----- Endpoint: ml.get_model_group

    /**
     * Retrieves a model group.
     */
    public CompletableFuture<GetModelGroupResponse> getModelGroup(GetModelGroupRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, GetModelGroupRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Retrieves a model group.
     *
     * @param fn a function that initializes a builder to create the {@link GetModelGroupRequest}
     */
    public final CompletableFuture<GetModelGroupResponse> getModelGroup(
        Function<GetModelGroupRequest.Builder, ObjectBuilder<GetModelGroupRequest>> fn
    ) throws IOException, OpenSearchException {
        return getModelGroup(fn.apply(new GetModelGroupRequest.Builder()).build());
    }

    // ----- Endpoint: ml.get_task

    /**
     * Retrieves a task.
     */
    public CompletableFuture<GetTaskResponse> getTask(GetTaskRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, GetTaskRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Retrieves a task.
     *
     * @param fn a function that initializes a builder to create the {@link GetTaskRequest}
     */
    public final CompletableFuture<GetTaskResponse> getTask(Function<GetTaskRequest.Builder, ObjectBuilder<GetTaskRequest>> fn)
        throws IOException, OpenSearchException {
        return getTask(fn.apply(new GetTaskRequest.Builder()).build());
    }

    // ----- Endpoint: ml.register_agents

    /**
     * Register an agent.
     */
    public CompletableFuture<RegisterAgentsResponse> registerAgents(RegisterAgentsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, RegisterAgentsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Register an agent.
     *
     * @param fn a function that initializes a builder to create the {@link RegisterAgentsRequest}
     */
    public final CompletableFuture<RegisterAgentsResponse> registerAgents(
        Function<RegisterAgentsRequest.Builder, ObjectBuilder<RegisterAgentsRequest>> fn
    ) throws IOException, OpenSearchException {
        return registerAgents(fn.apply(new RegisterAgentsRequest.Builder()).build());
    }

    // ----- Endpoint: ml.register_model

    /**
     * Registers a model.
     */
    public CompletableFuture<RegisterModelResponse> registerModel(RegisterModelRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, RegisterModelRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Registers a model.
     *
     * @param fn a function that initializes a builder to create the {@link RegisterModelRequest}
     */
    public final CompletableFuture<RegisterModelResponse> registerModel(
        Function<RegisterModelRequest.Builder, ObjectBuilder<RegisterModelRequest>> fn
    ) throws IOException, OpenSearchException {
        return registerModel(fn.apply(new RegisterModelRequest.Builder()).build());
    }

    // ----- Endpoint: ml.register_model_group

    /**
     * Registers a model group.
     */
    public CompletableFuture<RegisterModelGroupResponse> registerModelGroup(RegisterModelGroupRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, RegisterModelGroupRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Registers a model group.
     *
     * @param fn a function that initializes a builder to create the {@link RegisterModelGroupRequest}
     */
    public final CompletableFuture<RegisterModelGroupResponse> registerModelGroup(
        Function<RegisterModelGroupRequest.Builder, ObjectBuilder<RegisterModelGroupRequest>> fn
    ) throws IOException, OpenSearchException {
        return registerModelGroup(fn.apply(new RegisterModelGroupRequest.Builder()).build());
    }

    // ----- Endpoint: ml.undeploy_model

    /**
     * Undeploys a model.
     */
    public CompletableFuture<UndeployModelResponse> undeployModel(UndeployModelRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, UndeployModelRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Undeploys a model.
     *
     * @param fn a function that initializes a builder to create the {@link UndeployModelRequest}
     */
    public final CompletableFuture<UndeployModelResponse> undeployModel(
        Function<UndeployModelRequest.Builder, ObjectBuilder<UndeployModelRequest>> fn
    ) throws IOException, OpenSearchException {
        return undeployModel(fn.apply(new UndeployModelRequest.Builder()).build());
    }

    // ----- Endpoint: ml.update_agentic_memory

    /**
     * Update a specific memory by its type and ID.
     */
    public CompletableFuture<UpdateAgenticMemoryResponse> updateAgenticMemory(UpdateAgenticMemoryRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, UpdateAgenticMemoryRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Update a specific memory by its type and ID.
     *
     * @param fn a function that initializes a builder to create the {@link UpdateAgenticMemoryRequest}
     */
    public final CompletableFuture<UpdateAgenticMemoryResponse> updateAgenticMemory(
        Function<UpdateAgenticMemoryRequest.Builder, ObjectBuilder<UpdateAgenticMemoryRequest>> fn
    ) throws IOException, OpenSearchException {
        return updateAgenticMemory(fn.apply(new UpdateAgenticMemoryRequest.Builder()).build());
    }

    // ----- Endpoint: ml.update_connector

    /**
     * Updates a standalone connector.
     */
    public CompletableFuture<UpdateConnectorResponse> updateConnector(UpdateConnectorRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, UpdateConnectorRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Updates a standalone connector.
     *
     * @param fn a function that initializes a builder to create the {@link UpdateConnectorRequest}
     */
    public final CompletableFuture<UpdateConnectorResponse> updateConnector(
        Function<UpdateConnectorRequest.Builder, ObjectBuilder<UpdateConnectorRequest>> fn
    ) throws IOException, OpenSearchException {
        return updateConnector(fn.apply(new UpdateConnectorRequest.Builder()).build());
    }

    // ----- Endpoint: ml.update_memory_container

    /**
     * Update a memory container.
     */
    public CompletableFuture<UpdateMemoryContainerResponse> updateMemoryContainer(UpdateMemoryContainerRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, UpdateMemoryContainerRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Update a memory container.
     *
     * @param fn a function that initializes a builder to create the {@link UpdateMemoryContainerRequest}
     */
    public final CompletableFuture<UpdateMemoryContainerResponse> updateMemoryContainer(
        Function<UpdateMemoryContainerRequest.Builder, ObjectBuilder<UpdateMemoryContainerRequest>> fn
    ) throws IOException, OpenSearchException {
        return updateMemoryContainer(fn.apply(new UpdateMemoryContainerRequest.Builder()).build());
    }

    // ----- Endpoint: ml.update_model

    /**
     * Updates a model.
     */
    public CompletableFuture<UpdateModelResponse> updateModel(UpdateModelRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, UpdateModelRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Updates a model.
     *
     * @param fn a function that initializes a builder to create the {@link UpdateModelRequest}
     */
    public final CompletableFuture<UpdateModelResponse> updateModel(
        Function<UpdateModelRequest.Builder, ObjectBuilder<UpdateModelRequest>> fn
    ) throws IOException, OpenSearchException {
        return updateModel(fn.apply(new UpdateModelRequest.Builder()).build());
    }

    // ----- Endpoint: ml.update_model_group

    /**
     * Updates a model group.
     */
    public CompletableFuture<UpdateModelGroupResponse> updateModelGroup(UpdateModelGroupRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, UpdateModelGroupRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Updates a model group.
     *
     * @param fn a function that initializes a builder to create the {@link UpdateModelGroupRequest}
     */
    public final CompletableFuture<UpdateModelGroupResponse> updateModelGroup(
        Function<UpdateModelGroupRequest.Builder, ObjectBuilder<UpdateModelGroupRequest>> fn
    ) throws IOException, OpenSearchException {
        return updateModelGroup(fn.apply(new UpdateModelGroupRequest.Builder()).build());
    }
}
