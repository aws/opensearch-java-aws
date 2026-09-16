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

package software.amazon.awssdk.opensearch.client.aos.security;

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
 * Client for the security namespace.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class OpenSearchSecurityAsyncClient extends ApiClient<OpenSearchTransport, OpenSearchSecurityAsyncClient> {
    public OpenSearchSecurityAsyncClient(OpenSearchTransport transport) {
        super(transport, null);
    }

    public OpenSearchSecurityAsyncClient(OpenSearchTransport transport, @Nullable TransportOptions transportOptions) {
        super(transport, transportOptions);
    }

    @Override
    public OpenSearchSecurityAsyncClient withTransportOptions(@Nullable TransportOptions transportOptions) {
        return new OpenSearchSecurityAsyncClient(this.transport, transportOptions);
    }

    // ----- Endpoint: security.authinfo

    /**
     * <p>
     * Returns or updates authentication information for the currently authenticated user.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public CompletableFuture<AuthinfoResponse> authinfo(AuthinfoRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, AuthinfoRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Returns or updates authentication information for the currently authenticated user.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link AuthinfoRequest}
     */
    public final CompletableFuture<AuthinfoResponse> authinfo(Function<AuthinfoRequest.Builder, ObjectBuilder<AuthinfoRequest>> fn)
        throws IOException, OpenSearchException {
        return authinfo(fn.apply(new AuthinfoRequest.Builder()).build());
    }

    /**
     * <p>
     * Returns or updates authentication information for the currently authenticated user.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public final CompletableFuture<AuthinfoResponse> authinfo() throws IOException, OpenSearchException {
        return authinfo(new AuthinfoRequest.Builder().build());
    }

    // ----- Endpoint: security.authtoken

    /**
     * <p>
     * Returns the authorization token for the current user.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public CompletableFuture<AuthtokenResponse> authtoken(AuthtokenRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, AuthtokenRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Returns the authorization token for the current user.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link AuthtokenRequest}
     */
    public final CompletableFuture<AuthtokenResponse> authtoken(Function<AuthtokenRequest.Builder, ObjectBuilder<AuthtokenRequest>> fn)
        throws IOException, OpenSearchException {
        return authtoken(fn.apply(new AuthtokenRequest.Builder()).build());
    }

    /**
     * <p>
     * Returns the authorization token for the current user.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public final CompletableFuture<AuthtokenResponse> authtoken() throws IOException, OpenSearchException {
        return authtoken(new AuthtokenRequest.Builder().build());
    }

    // ----- Endpoint: security.change_password

    /**
     * <p>
     * Changes the password for the current user.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public CompletableFuture<ChangePasswordResponse> changePassword(ChangePasswordRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, ChangePasswordRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Changes the password for the current user.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link ChangePasswordRequest}
     */
    public final CompletableFuture<ChangePasswordResponse> changePassword(
        Function<ChangePasswordRequest.Builder, ObjectBuilder<ChangePasswordRequest>> fn
    ) throws IOException, OpenSearchException {
        return changePassword(fn.apply(new ChangePasswordRequest.Builder()).build());
    }

    // ----- Endpoint: security.config_upgrade_check

    /**
     * <p>
     * Checks whether or not an upgrade can be performed and which security resources can be updated.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.14</code>
     * </p>
     */
    public CompletableFuture<ConfigUpgradeCheckResponse> configUpgradeCheck(ConfigUpgradeCheckRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, ConfigUpgradeCheckRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Checks whether or not an upgrade can be performed and which security resources can be updated.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.14</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link ConfigUpgradeCheckRequest}
     */
    public final CompletableFuture<ConfigUpgradeCheckResponse> configUpgradeCheck(
        Function<ConfigUpgradeCheckRequest.Builder, ObjectBuilder<ConfigUpgradeCheckRequest>> fn
    ) throws IOException, OpenSearchException {
        return configUpgradeCheck(fn.apply(new ConfigUpgradeCheckRequest.Builder()).build());
    }

    /**
     * <p>
     * Checks whether or not an upgrade can be performed and which security resources can be updated.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.14</code>
     * </p>
     */
    public final CompletableFuture<ConfigUpgradeCheckResponse> configUpgradeCheck() throws IOException, OpenSearchException {
        return configUpgradeCheck(new ConfigUpgradeCheckRequest.Builder().build());
    }

    // ----- Endpoint: security.config_upgrade_perform

    /**
     * <p>
     * Assists the cluster operator with upgrading missing default values and stale default definitions.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.14</code>
     * </p>
     */
    public CompletableFuture<ConfigUpgradePerformResponse> configUpgradePerform(ConfigUpgradePerformRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, ConfigUpgradePerformRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Assists the cluster operator with upgrading missing default values and stale default definitions.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.14</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link ConfigUpgradePerformRequest}
     */
    public final CompletableFuture<ConfigUpgradePerformResponse> configUpgradePerform(
        Function<ConfigUpgradePerformRequest.Builder, ObjectBuilder<ConfigUpgradePerformRequest>> fn
    ) throws IOException, OpenSearchException {
        return configUpgradePerform(fn.apply(new ConfigUpgradePerformRequest.Builder()).build());
    }

    /**
     * <p>
     * Assists the cluster operator with upgrading missing default values and stale default definitions.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.14</code>
     * </p>
     */
    public final CompletableFuture<ConfigUpgradePerformResponse> configUpgradePerform() throws IOException, OpenSearchException {
        return configUpgradePerform(new ConfigUpgradePerformRequest.Builder().build());
    }

    // ----- Endpoint: security.create_action_group

    /**
     * <p>
     * Creates or replaces the specified action group.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public CompletableFuture<CreateActionGroupResponse> createActionGroup(CreateActionGroupRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, CreateActionGroupRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Creates or replaces the specified action group.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link CreateActionGroupRequest}
     */
    public final CompletableFuture<CreateActionGroupResponse> createActionGroup(
        Function<CreateActionGroupRequest.Builder, ObjectBuilder<CreateActionGroupRequest>> fn
    ) throws IOException, OpenSearchException {
        return createActionGroup(fn.apply(new CreateActionGroupRequest.Builder()).build());
    }

    // ----- Endpoint: security.create_allowlist

    /**
     * <p>
     * Creates or replaces APIs permitted for users on the allow list. Requires a super admin certificate or REST API permissions.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.1</code>
     * </p>
     */
    public CompletableFuture<CreateAllowlistResponse> createAllowlist(CreateAllowlistRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, CreateAllowlistRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Creates or replaces APIs permitted for users on the allow list. Requires a super admin certificate or REST API permissions.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.1</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link CreateAllowlistRequest}
     */
    public final CompletableFuture<CreateAllowlistResponse> createAllowlist(
        Function<CreateAllowlistRequest.Builder, ObjectBuilder<CreateAllowlistRequest>> fn
    ) throws IOException, OpenSearchException {
        return createAllowlist(fn.apply(new CreateAllowlistRequest.Builder()).build());
    }

    /**
     * <p>
     * Creates or replaces APIs permitted for users on the allow list. Requires a super admin certificate or REST API permissions.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.1</code>
     * </p>
     */
    public final CompletableFuture<CreateAllowlistResponse> createAllowlist() throws IOException, OpenSearchException {
        return createAllowlist(new CreateAllowlistRequest.Builder().build());
    }

    // ----- Endpoint: security.create_role

    /**
     * <p>
     * Creates or replaces the specified role.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public CompletableFuture<CreateRoleResponse> createRole(CreateRoleRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, CreateRoleRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Creates or replaces the specified role.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link CreateRoleRequest}
     */
    public final CompletableFuture<CreateRoleResponse> createRole(Function<CreateRoleRequest.Builder, ObjectBuilder<CreateRoleRequest>> fn)
        throws IOException, OpenSearchException {
        return createRole(fn.apply(new CreateRoleRequest.Builder()).build());
    }

    // ----- Endpoint: security.create_role_mapping

    /**
     * <p>
     * Creates or replaces the specified role mapping.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public CompletableFuture<CreateRoleMappingResponse> createRoleMapping(CreateRoleMappingRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, CreateRoleMappingRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Creates or replaces the specified role mapping.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link CreateRoleMappingRequest}
     */
    public final CompletableFuture<CreateRoleMappingResponse> createRoleMapping(
        Function<CreateRoleMappingRequest.Builder, ObjectBuilder<CreateRoleMappingRequest>> fn
    ) throws IOException, OpenSearchException {
        return createRoleMapping(fn.apply(new CreateRoleMappingRequest.Builder()).build());
    }

    // ----- Endpoint: security.create_tenant

    /**
     * <p>
     * Creates or replaces the specified tenant.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public CompletableFuture<CreateTenantResponse> createTenant(CreateTenantRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, CreateTenantRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Creates or replaces the specified tenant.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link CreateTenantRequest}
     */
    public final CompletableFuture<CreateTenantResponse> createTenant(
        Function<CreateTenantRequest.Builder, ObjectBuilder<CreateTenantRequest>> fn
    ) throws IOException, OpenSearchException {
        return createTenant(fn.apply(new CreateTenantRequest.Builder()).build());
    }

    // ----- Endpoint: security.create_update_tenancy_config

    /**
     * <p>
     * Creates or replaces the multi-tenancy configuration. Requires super admin or REST API permissions.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.7</code>
     * </p>
     */
    public CompletableFuture<CreateUpdateTenancyConfigResponse> createUpdateTenancyConfig(CreateUpdateTenancyConfigRequest request)
        throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, CreateUpdateTenancyConfigRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Creates or replaces the multi-tenancy configuration. Requires super admin or REST API permissions.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.7</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link CreateUpdateTenancyConfigRequest}
     */
    public final CompletableFuture<CreateUpdateTenancyConfigResponse> createUpdateTenancyConfig(
        Function<CreateUpdateTenancyConfigRequest.Builder, ObjectBuilder<CreateUpdateTenancyConfigRequest>> fn
    ) throws IOException, OpenSearchException {
        return createUpdateTenancyConfig(fn.apply(new CreateUpdateTenancyConfigRequest.Builder()).build());
    }

    /**
     * <p>
     * Creates or replaces the multi-tenancy configuration. Requires super admin or REST API permissions.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.7</code>
     * </p>
     */
    public final CompletableFuture<CreateUpdateTenancyConfigResponse> createUpdateTenancyConfig() throws IOException, OpenSearchException {
        return createUpdateTenancyConfig(new CreateUpdateTenancyConfigRequest.Builder().build());
    }

    // ----- Endpoint: security.create_user

    /**
     * <p>
     * Creates or replaces the specified user.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public CompletableFuture<CreateUserResponse> createUser(CreateUserRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, CreateUserRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Creates or replaces the specified user.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link CreateUserRequest}
     */
    public final CompletableFuture<CreateUserResponse> createUser(Function<CreateUserRequest.Builder, ObjectBuilder<CreateUserRequest>> fn)
        throws IOException, OpenSearchException {
        return createUser(fn.apply(new CreateUserRequest.Builder()).build());
    }

    // ----- Endpoint: security.create_user_legacy

    /**
     * <p>
     * Creates or replaces the specified user. Legacy API.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public CompletableFuture<CreateUserLegacyResponse> createUserLegacy(CreateUserLegacyRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, CreateUserLegacyRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Creates or replaces the specified user. Legacy API.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link CreateUserLegacyRequest}
     */
    public final CompletableFuture<CreateUserLegacyResponse> createUserLegacy(
        Function<CreateUserLegacyRequest.Builder, ObjectBuilder<CreateUserLegacyRequest>> fn
    ) throws IOException, OpenSearchException {
        return createUserLegacy(fn.apply(new CreateUserLegacyRequest.Builder()).build());
    }

    // ----- Endpoint: security.delete_action_group

    /**
     * <p>
     * Deletes the specified action group.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public CompletableFuture<DeleteActionGroupResponse> deleteActionGroup(DeleteActionGroupRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, DeleteActionGroupRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Deletes the specified action group.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link DeleteActionGroupRequest}
     */
    public final CompletableFuture<DeleteActionGroupResponse> deleteActionGroup(
        Function<DeleteActionGroupRequest.Builder, ObjectBuilder<DeleteActionGroupRequest>> fn
    ) throws IOException, OpenSearchException {
        return deleteActionGroup(fn.apply(new DeleteActionGroupRequest.Builder()).build());
    }

    // ----- Endpoint: security.delete_distinguished_name

    /**
     * <p>
     * Deletes all distinguished names in the specified cluster or node allowlist. Requires super admin or REST API permissions.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public CompletableFuture<DeleteDistinguishedNameResponse> deleteDistinguishedName(DeleteDistinguishedNameRequest request)
        throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, DeleteDistinguishedNameRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Deletes all distinguished names in the specified cluster or node allowlist. Requires super admin or REST API permissions.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link DeleteDistinguishedNameRequest}
     */
    public final CompletableFuture<DeleteDistinguishedNameResponse> deleteDistinguishedName(
        Function<DeleteDistinguishedNameRequest.Builder, ObjectBuilder<DeleteDistinguishedNameRequest>> fn
    ) throws IOException, OpenSearchException {
        return deleteDistinguishedName(fn.apply(new DeleteDistinguishedNameRequest.Builder()).build());
    }

    // ----- Endpoint: security.delete_role

    /**
     * <p>
     * Deletes the specified role.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public CompletableFuture<DeleteRoleResponse> deleteRole(DeleteRoleRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, DeleteRoleRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Deletes the specified role.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link DeleteRoleRequest}
     */
    public final CompletableFuture<DeleteRoleResponse> deleteRole(Function<DeleteRoleRequest.Builder, ObjectBuilder<DeleteRoleRequest>> fn)
        throws IOException, OpenSearchException {
        return deleteRole(fn.apply(new DeleteRoleRequest.Builder()).build());
    }

    // ----- Endpoint: security.delete_role_mapping

    /**
     * <p>
     * Deletes the specified role mapping.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public CompletableFuture<DeleteRoleMappingResponse> deleteRoleMapping(DeleteRoleMappingRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, DeleteRoleMappingRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Deletes the specified role mapping.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link DeleteRoleMappingRequest}
     */
    public final CompletableFuture<DeleteRoleMappingResponse> deleteRoleMapping(
        Function<DeleteRoleMappingRequest.Builder, ObjectBuilder<DeleteRoleMappingRequest>> fn
    ) throws IOException, OpenSearchException {
        return deleteRoleMapping(fn.apply(new DeleteRoleMappingRequest.Builder()).build());
    }

    // ----- Endpoint: security.delete_tenant

    /**
     * <p>
     * Deletes the specified tenant.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public CompletableFuture<DeleteTenantResponse> deleteTenant(DeleteTenantRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, DeleteTenantRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Deletes the specified tenant.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link DeleteTenantRequest}
     */
    public final CompletableFuture<DeleteTenantResponse> deleteTenant(
        Function<DeleteTenantRequest.Builder, ObjectBuilder<DeleteTenantRequest>> fn
    ) throws IOException, OpenSearchException {
        return deleteTenant(fn.apply(new DeleteTenantRequest.Builder()).build());
    }

    // ----- Endpoint: security.delete_user

    /**
     * <p>
     * Deletes the specified internal user.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public CompletableFuture<DeleteUserResponse> deleteUser(DeleteUserRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, DeleteUserRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Deletes the specified internal user.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link DeleteUserRequest}
     */
    public final CompletableFuture<DeleteUserResponse> deleteUser(Function<DeleteUserRequest.Builder, ObjectBuilder<DeleteUserRequest>> fn)
        throws IOException, OpenSearchException {
        return deleteUser(fn.apply(new DeleteUserRequest.Builder()).build());
    }

    // ----- Endpoint: security.delete_user_legacy

    /**
     * <p>
     * Delete the specified user. Legacy API.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public CompletableFuture<DeleteUserLegacyResponse> deleteUserLegacy(DeleteUserLegacyRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, DeleteUserLegacyRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Delete the specified user. Legacy API.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link DeleteUserLegacyRequest}
     */
    public final CompletableFuture<DeleteUserLegacyResponse> deleteUserLegacy(
        Function<DeleteUserLegacyRequest.Builder, ObjectBuilder<DeleteUserLegacyRequest>> fn
    ) throws IOException, OpenSearchException {
        return deleteUserLegacy(fn.apply(new DeleteUserLegacyRequest.Builder()).build());
    }

    // ----- Endpoint: security.flush_cache

    /**
     * <p>
     * Flushes the Security plugin's user, authentication, and authorization cache.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public CompletableFuture<FlushCacheResponse> flushCache(FlushCacheRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, FlushCacheRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Flushes the Security plugin's user, authentication, and authorization cache.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link FlushCacheRequest}
     */
    public final CompletableFuture<FlushCacheResponse> flushCache(Function<FlushCacheRequest.Builder, ObjectBuilder<FlushCacheRequest>> fn)
        throws IOException, OpenSearchException {
        return flushCache(fn.apply(new FlushCacheRequest.Builder()).build());
    }

    /**
     * <p>
     * Flushes the Security plugin's user, authentication, and authorization cache.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public final CompletableFuture<FlushCacheResponse> flushCache() throws IOException, OpenSearchException {
        return flushCache(new FlushCacheRequest.Builder().build());
    }

    // ----- Endpoint: security.generate_obo_token

    /**
     * <p>
     * Generates a <code>On-Behalf-Of</code> token for the current user.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.12</code>
     * </p>
     */
    public CompletableFuture<GenerateOboTokenResponse> generateOboToken(GenerateOboTokenRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, GenerateOboTokenRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Generates a <code>On-Behalf-Of</code> token for the current user.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.12</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link GenerateOboTokenRequest}
     */
    public final CompletableFuture<GenerateOboTokenResponse> generateOboToken(
        Function<GenerateOboTokenRequest.Builder, ObjectBuilder<GenerateOboTokenRequest>> fn
    ) throws IOException, OpenSearchException {
        return generateOboToken(fn.apply(new GenerateOboTokenRequest.Builder()).build());
    }

    // ----- Endpoint: security.generate_user_token

    /**
     * <p>
     * Generates an authorization token for the specified user.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.7</code>
     * </p>
     */
    public CompletableFuture<GenerateUserTokenResponse> generateUserToken(GenerateUserTokenRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, GenerateUserTokenRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Generates an authorization token for the specified user.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.7</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link GenerateUserTokenRequest}
     */
    public final CompletableFuture<GenerateUserTokenResponse> generateUserToken(
        Function<GenerateUserTokenRequest.Builder, ObjectBuilder<GenerateUserTokenRequest>> fn
    ) throws IOException, OpenSearchException {
        return generateUserToken(fn.apply(new GenerateUserTokenRequest.Builder()).build());
    }

    // ----- Endpoint: security.generate_user_token_legacy

    /**
     * <p>
     * Generates authorization token for the given user. Legacy API. Not Implemented.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.7</code>
     * </p>
     */
    public CompletableFuture<BooleanResponse> generateUserTokenLegacy(GenerateUserTokenLegacyRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, GenerateUserTokenLegacyRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Generates authorization token for the given user. Legacy API. Not Implemented.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.7</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link GenerateUserTokenLegacyRequest}
     */
    public final CompletableFuture<BooleanResponse> generateUserTokenLegacy(
        Function<GenerateUserTokenLegacyRequest.Builder, ObjectBuilder<GenerateUserTokenLegacyRequest>> fn
    ) throws IOException, OpenSearchException {
        return generateUserTokenLegacy(fn.apply(new GenerateUserTokenLegacyRequest.Builder()).build());
    }

    // ----- Endpoint: security.get_account_details

    /**
     * <p>
     * Returns account information for the current user.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public CompletableFuture<GetAccountDetailsResponse> getAccountDetails(GetAccountDetailsRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, GetAccountDetailsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Returns account information for the current user.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link GetAccountDetailsRequest}
     */
    public final CompletableFuture<GetAccountDetailsResponse> getAccountDetails(
        Function<GetAccountDetailsRequest.Builder, ObjectBuilder<GetAccountDetailsRequest>> fn
    ) throws IOException, OpenSearchException {
        return getAccountDetails(fn.apply(new GetAccountDetailsRequest.Builder()).build());
    }

    /**
     * <p>
     * Returns account information for the current user.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public final CompletableFuture<GetAccountDetailsResponse> getAccountDetails() throws IOException, OpenSearchException {
        return getAccountDetails(new GetAccountDetailsRequest.Builder().build());
    }

    // ----- Endpoint: security.get_action_group

    /**
     * <p>
     * Retrieves one action group.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public CompletableFuture<GetActionGroupResponse> getActionGroup(GetActionGroupRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, GetActionGroupRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Retrieves one action group.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link GetActionGroupRequest}
     */
    public final CompletableFuture<GetActionGroupResponse> getActionGroup(
        Function<GetActionGroupRequest.Builder, ObjectBuilder<GetActionGroupRequest>> fn
    ) throws IOException, OpenSearchException {
        return getActionGroup(fn.apply(new GetActionGroupRequest.Builder()).build());
    }

    // ----- Endpoint: security.get_action_groups

    /**
     * <p>
     * Retrieves all action groups.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public CompletableFuture<GetActionGroupsResponse> getActionGroups(GetActionGroupsRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, GetActionGroupsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Retrieves all action groups.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link GetActionGroupsRequest}
     */
    public final CompletableFuture<GetActionGroupsResponse> getActionGroups(
        Function<GetActionGroupsRequest.Builder, ObjectBuilder<GetActionGroupsRequest>> fn
    ) throws IOException, OpenSearchException {
        return getActionGroups(fn.apply(new GetActionGroupsRequest.Builder()).build());
    }

    /**
     * <p>
     * Retrieves all action groups.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public final CompletableFuture<GetActionGroupsResponse> getActionGroups() throws IOException, OpenSearchException {
        return getActionGroups(new GetActionGroupsRequest.Builder().build());
    }

    // ----- Endpoint: security.get_all_certificates

    /**
     * <p>
     * Retrieves the cluster security certificates.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.15</code>
     * </p>
     */
    public CompletableFuture<GetAllCertificatesResponse> getAllCertificates(GetAllCertificatesRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, GetAllCertificatesRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Retrieves the cluster security certificates.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.15</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link GetAllCertificatesRequest}
     */
    public final CompletableFuture<GetAllCertificatesResponse> getAllCertificates(
        Function<GetAllCertificatesRequest.Builder, ObjectBuilder<GetAllCertificatesRequest>> fn
    ) throws IOException, OpenSearchException {
        return getAllCertificates(fn.apply(new GetAllCertificatesRequest.Builder()).build());
    }

    /**
     * <p>
     * Retrieves the cluster security certificates.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.15</code>
     * </p>
     */
    public final CompletableFuture<GetAllCertificatesResponse> getAllCertificates() throws IOException, OpenSearchException {
        return getAllCertificates(new GetAllCertificatesRequest.Builder().build());
    }

    // ----- Endpoint: security.get_allowlist

    /**
     * <p>
     * Retrieves the current list of allowed APIs accessible to a normal user.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.1</code>
     * </p>
     */
    public CompletableFuture<GetAllowlistResponse> getAllowlist(GetAllowlistRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, GetAllowlistRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Retrieves the current list of allowed APIs accessible to a normal user.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.1</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link GetAllowlistRequest}
     */
    public final CompletableFuture<GetAllowlistResponse> getAllowlist(
        Function<GetAllowlistRequest.Builder, ObjectBuilder<GetAllowlistRequest>> fn
    ) throws IOException, OpenSearchException {
        return getAllowlist(fn.apply(new GetAllowlistRequest.Builder()).build());
    }

    /**
     * <p>
     * Retrieves the current list of allowed APIs accessible to a normal user.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.1</code>
     * </p>
     */
    public final CompletableFuture<GetAllowlistResponse> getAllowlist() throws IOException, OpenSearchException {
        return getAllowlist(new GetAllowlistRequest.Builder().build());
    }

    // ----- Endpoint: security.get_audit_configuration

    /**
     * <p>
     * Retrieves the audit configuration.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public CompletableFuture<GetAuditConfigurationResponse> getAuditConfiguration(GetAuditConfigurationRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, GetAuditConfigurationRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Retrieves the audit configuration.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link GetAuditConfigurationRequest}
     */
    public final CompletableFuture<GetAuditConfigurationResponse> getAuditConfiguration(
        Function<GetAuditConfigurationRequest.Builder, ObjectBuilder<GetAuditConfigurationRequest>> fn
    ) throws IOException, OpenSearchException {
        return getAuditConfiguration(fn.apply(new GetAuditConfigurationRequest.Builder()).build());
    }

    /**
     * <p>
     * Retrieves the audit configuration.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public final CompletableFuture<GetAuditConfigurationResponse> getAuditConfiguration() throws IOException, OpenSearchException {
        return getAuditConfiguration(new GetAuditConfigurationRequest.Builder().build());
    }

    // ----- Endpoint: security.get_certificates

    /**
     * <p>
     * Retrieves the cluster security certificates.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.0</code>
     * </p>
     */
    public CompletableFuture<GetCertificatesResponse> getCertificates(GetCertificatesRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, GetCertificatesRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Retrieves the cluster security certificates.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link GetCertificatesRequest}
     */
    public final CompletableFuture<GetCertificatesResponse> getCertificates(
        Function<GetCertificatesRequest.Builder, ObjectBuilder<GetCertificatesRequest>> fn
    ) throws IOException, OpenSearchException {
        return getCertificates(fn.apply(new GetCertificatesRequest.Builder()).build());
    }

    /**
     * <p>
     * Retrieves the cluster security certificates.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.0</code>
     * </p>
     */
    public final CompletableFuture<GetCertificatesResponse> getCertificates() throws IOException, OpenSearchException {
        return getCertificates(new GetCertificatesRequest.Builder().build());
    }

    // ----- Endpoint: security.get_configuration

    /**
     * <p>
     * Returns the current Security plugin configuration in a JSON format.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.10</code>
     * </p>
     */
    public CompletableFuture<GetConfigurationResponse> getConfiguration(GetConfigurationRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, GetConfigurationRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Returns the current Security plugin configuration in a JSON format.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.10</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link GetConfigurationRequest}
     */
    public final CompletableFuture<GetConfigurationResponse> getConfiguration(
        Function<GetConfigurationRequest.Builder, ObjectBuilder<GetConfigurationRequest>> fn
    ) throws IOException, OpenSearchException {
        return getConfiguration(fn.apply(new GetConfigurationRequest.Builder()).build());
    }

    /**
     * <p>
     * Returns the current Security plugin configuration in a JSON format.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.10</code>
     * </p>
     */
    public final CompletableFuture<GetConfigurationResponse> getConfiguration() throws IOException, OpenSearchException {
        return getConfiguration(new GetConfigurationRequest.Builder().build());
    }

    // ----- Endpoint: security.get_dashboards_info

    /**
     * <p>
     * Retrieves the current values for dynamic security settings for OpenSearch Dashboards.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public CompletableFuture<GetDashboardsInfoResponse> getDashboardsInfo(GetDashboardsInfoRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, GetDashboardsInfoRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Retrieves the current values for dynamic security settings for OpenSearch Dashboards.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link GetDashboardsInfoRequest}
     */
    public final CompletableFuture<GetDashboardsInfoResponse> getDashboardsInfo(
        Function<GetDashboardsInfoRequest.Builder, ObjectBuilder<GetDashboardsInfoRequest>> fn
    ) throws IOException, OpenSearchException {
        return getDashboardsInfo(fn.apply(new GetDashboardsInfoRequest.Builder()).build());
    }

    /**
     * <p>
     * Retrieves the current values for dynamic security settings for OpenSearch Dashboards.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public final CompletableFuture<GetDashboardsInfoResponse> getDashboardsInfo() throws IOException, OpenSearchException {
        return getDashboardsInfo(new GetDashboardsInfoRequest.Builder().build());
    }

    // ----- Endpoint: security.get_distinguished_name

    /**
     * <p>
     * Retrieves all node distinguished names. Requires super admin or REST API permissions.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public CompletableFuture<GetDistinguishedNameResponse> getDistinguishedName(GetDistinguishedNameRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, GetDistinguishedNameRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Retrieves all node distinguished names. Requires super admin or REST API permissions.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link GetDistinguishedNameRequest}
     */
    public final CompletableFuture<GetDistinguishedNameResponse> getDistinguishedName(
        Function<GetDistinguishedNameRequest.Builder, ObjectBuilder<GetDistinguishedNameRequest>> fn
    ) throws IOException, OpenSearchException {
        return getDistinguishedName(fn.apply(new GetDistinguishedNameRequest.Builder()).build());
    }

    // ----- Endpoint: security.get_distinguished_names

    /**
     * <p>
     * Retrieves all node distinguished names. Requires super admin or REST API permissions.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public CompletableFuture<GetDistinguishedNamesResponse> getDistinguishedNames(GetDistinguishedNamesRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, GetDistinguishedNamesRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Retrieves all node distinguished names. Requires super admin or REST API permissions.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link GetDistinguishedNamesRequest}
     */
    public final CompletableFuture<GetDistinguishedNamesResponse> getDistinguishedNames(
        Function<GetDistinguishedNamesRequest.Builder, ObjectBuilder<GetDistinguishedNamesRequest>> fn
    ) throws IOException, OpenSearchException {
        return getDistinguishedNames(fn.apply(new GetDistinguishedNamesRequest.Builder()).build());
    }

    /**
     * <p>
     * Retrieves all node distinguished names. Requires super admin or REST API permissions.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public final CompletableFuture<GetDistinguishedNamesResponse> getDistinguishedNames() throws IOException, OpenSearchException {
        return getDistinguishedNames(new GetDistinguishedNamesRequest.Builder().build());
    }

    // ----- Endpoint: security.get_node_certificates

    /**
     * <p>
     * Retrieves the specified node's security certificates.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.15</code>
     * </p>
     */
    public CompletableFuture<GetNodeCertificatesResponse> getNodeCertificates(GetNodeCertificatesRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, GetNodeCertificatesRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Retrieves the specified node's security certificates.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.15</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link GetNodeCertificatesRequest}
     */
    public final CompletableFuture<GetNodeCertificatesResponse> getNodeCertificates(
        Function<GetNodeCertificatesRequest.Builder, ObjectBuilder<GetNodeCertificatesRequest>> fn
    ) throws IOException, OpenSearchException {
        return getNodeCertificates(fn.apply(new GetNodeCertificatesRequest.Builder()).build());
    }

    // ----- Endpoint: security.get_permissions_info

    /**
     * <p>
     * Retrieves the evaluated REST API permissions for the currently logged in user.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public CompletableFuture<GetPermissionsInfoResponse> getPermissionsInfo(GetPermissionsInfoRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, GetPermissionsInfoRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Retrieves the evaluated REST API permissions for the currently logged in user.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link GetPermissionsInfoRequest}
     */
    public final CompletableFuture<GetPermissionsInfoResponse> getPermissionsInfo(
        Function<GetPermissionsInfoRequest.Builder, ObjectBuilder<GetPermissionsInfoRequest>> fn
    ) throws IOException, OpenSearchException {
        return getPermissionsInfo(fn.apply(new GetPermissionsInfoRequest.Builder()).build());
    }

    /**
     * <p>
     * Retrieves the evaluated REST API permissions for the currently logged in user.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public final CompletableFuture<GetPermissionsInfoResponse> getPermissionsInfo() throws IOException, OpenSearchException {
        return getPermissionsInfo(new GetPermissionsInfoRequest.Builder().build());
    }

    // ----- Endpoint: security.get_role

    /**
     * <p>
     * Retrieves one role.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public CompletableFuture<GetRoleResponse> getRole(GetRoleRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, GetRoleRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Retrieves one role.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link GetRoleRequest}
     */
    public final CompletableFuture<GetRoleResponse> getRole(Function<GetRoleRequest.Builder, ObjectBuilder<GetRoleRequest>> fn)
        throws IOException, OpenSearchException {
        return getRole(fn.apply(new GetRoleRequest.Builder()).build());
    }

    // ----- Endpoint: security.get_role_mapping

    /**
     * <p>
     * Retrieves the specified role mapping.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public CompletableFuture<GetRoleMappingResponse> getRoleMapping(GetRoleMappingRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, GetRoleMappingRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Retrieves the specified role mapping.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link GetRoleMappingRequest}
     */
    public final CompletableFuture<GetRoleMappingResponse> getRoleMapping(
        Function<GetRoleMappingRequest.Builder, ObjectBuilder<GetRoleMappingRequest>> fn
    ) throws IOException, OpenSearchException {
        return getRoleMapping(fn.apply(new GetRoleMappingRequest.Builder()).build());
    }

    // ----- Endpoint: security.get_role_mappings

    /**
     * <p>
     * Retrieves all role mappings.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public CompletableFuture<GetRoleMappingsResponse> getRoleMappings(GetRoleMappingsRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, GetRoleMappingsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Retrieves all role mappings.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link GetRoleMappingsRequest}
     */
    public final CompletableFuture<GetRoleMappingsResponse> getRoleMappings(
        Function<GetRoleMappingsRequest.Builder, ObjectBuilder<GetRoleMappingsRequest>> fn
    ) throws IOException, OpenSearchException {
        return getRoleMappings(fn.apply(new GetRoleMappingsRequest.Builder()).build());
    }

    /**
     * <p>
     * Retrieves all role mappings.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public final CompletableFuture<GetRoleMappingsResponse> getRoleMappings() throws IOException, OpenSearchException {
        return getRoleMappings(new GetRoleMappingsRequest.Builder().build());
    }

    // ----- Endpoint: security.get_roles

    /**
     * <p>
     * Retrieves all roles.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public CompletableFuture<GetRolesResponse> getRoles(GetRolesRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, GetRolesRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Retrieves all roles.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link GetRolesRequest}
     */
    public final CompletableFuture<GetRolesResponse> getRoles(Function<GetRolesRequest.Builder, ObjectBuilder<GetRolesRequest>> fn)
        throws IOException, OpenSearchException {
        return getRoles(fn.apply(new GetRolesRequest.Builder()).build());
    }

    /**
     * <p>
     * Retrieves all roles.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public final CompletableFuture<GetRolesResponse> getRoles() throws IOException, OpenSearchException {
        return getRoles(new GetRolesRequest.Builder().build());
    }

    // ----- Endpoint: security.get_sslinfo

    /**
     * <p>
     * Retrieves information about the SSL configuration.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public CompletableFuture<GetSslinfoResponse> getSslinfo(GetSslinfoRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, GetSslinfoRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Retrieves information about the SSL configuration.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link GetSslinfoRequest}
     */
    public final CompletableFuture<GetSslinfoResponse> getSslinfo(Function<GetSslinfoRequest.Builder, ObjectBuilder<GetSslinfoRequest>> fn)
        throws IOException, OpenSearchException {
        return getSslinfo(fn.apply(new GetSslinfoRequest.Builder()).build());
    }

    /**
     * <p>
     * Retrieves information about the SSL configuration.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public final CompletableFuture<GetSslinfoResponse> getSslinfo() throws IOException, OpenSearchException {
        return getSslinfo(new GetSslinfoRequest.Builder().build());
    }

    // ----- Endpoint: security.get_tenancy_config

    /**
     * <p>
     * Retrieves the multi-tenancy configuration. Requires super admin or REST API permissions.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.7</code>
     * </p>
     */
    public CompletableFuture<GetTenancyConfigResponse> getTenancyConfig(GetTenancyConfigRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, GetTenancyConfigRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Retrieves the multi-tenancy configuration. Requires super admin or REST API permissions.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.7</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link GetTenancyConfigRequest}
     */
    public final CompletableFuture<GetTenancyConfigResponse> getTenancyConfig(
        Function<GetTenancyConfigRequest.Builder, ObjectBuilder<GetTenancyConfigRequest>> fn
    ) throws IOException, OpenSearchException {
        return getTenancyConfig(fn.apply(new GetTenancyConfigRequest.Builder()).build());
    }

    /**
     * <p>
     * Retrieves the multi-tenancy configuration. Requires super admin or REST API permissions.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.7</code>
     * </p>
     */
    public final CompletableFuture<GetTenancyConfigResponse> getTenancyConfig() throws IOException, OpenSearchException {
        return getTenancyConfig(new GetTenancyConfigRequest.Builder().build());
    }

    // ----- Endpoint: security.get_tenant

    /**
     * <p>
     * Retrieves the specified tenant.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public CompletableFuture<GetTenantResponse> getTenant(GetTenantRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, GetTenantRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Retrieves the specified tenant.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link GetTenantRequest}
     */
    public final CompletableFuture<GetTenantResponse> getTenant(Function<GetTenantRequest.Builder, ObjectBuilder<GetTenantRequest>> fn)
        throws IOException, OpenSearchException {
        return getTenant(fn.apply(new GetTenantRequest.Builder()).build());
    }

    // ----- Endpoint: security.get_tenants

    /**
     * <p>
     * Retrieves all tenants.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public CompletableFuture<GetTenantsResponse> getTenants(GetTenantsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, GetTenantsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Retrieves all tenants.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link GetTenantsRequest}
     */
    public final CompletableFuture<GetTenantsResponse> getTenants(Function<GetTenantsRequest.Builder, ObjectBuilder<GetTenantsRequest>> fn)
        throws IOException, OpenSearchException {
        return getTenants(fn.apply(new GetTenantsRequest.Builder()).build());
    }

    /**
     * <p>
     * Retrieves all tenants.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public final CompletableFuture<GetTenantsResponse> getTenants() throws IOException, OpenSearchException {
        return getTenants(new GetTenantsRequest.Builder().build());
    }

    // ----- Endpoint: security.get_user

    /**
     * <p>
     * Retrieve information about the specified internal user.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public CompletableFuture<GetUserResponse> getUser(GetUserRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, GetUserRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Retrieve information about the specified internal user.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link GetUserRequest}
     */
    public final CompletableFuture<GetUserResponse> getUser(Function<GetUserRequest.Builder, ObjectBuilder<GetUserRequest>> fn)
        throws IOException, OpenSearchException {
        return getUser(fn.apply(new GetUserRequest.Builder()).build());
    }

    // ----- Endpoint: security.get_user_legacy

    /**
     * <p>
     * Retrieve one user. Legacy API.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public CompletableFuture<GetUserLegacyResponse> getUserLegacy(GetUserLegacyRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, GetUserLegacyRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Retrieve one user. Legacy API.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link GetUserLegacyRequest}
     */
    public final CompletableFuture<GetUserLegacyResponse> getUserLegacy(
        Function<GetUserLegacyRequest.Builder, ObjectBuilder<GetUserLegacyRequest>> fn
    ) throws IOException, OpenSearchException {
        return getUserLegacy(fn.apply(new GetUserLegacyRequest.Builder()).build());
    }

    // ----- Endpoint: security.get_users

    /**
     * <p>
     * Retrieve all internal users.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public CompletableFuture<GetUsersResponse> getUsers(GetUsersRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, GetUsersRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Retrieve all internal users.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link GetUsersRequest}
     */
    public final CompletableFuture<GetUsersResponse> getUsers(Function<GetUsersRequest.Builder, ObjectBuilder<GetUsersRequest>> fn)
        throws IOException, OpenSearchException {
        return getUsers(fn.apply(new GetUsersRequest.Builder()).build());
    }

    /**
     * <p>
     * Retrieve all internal users.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public final CompletableFuture<GetUsersResponse> getUsers() throws IOException, OpenSearchException {
        return getUsers(new GetUsersRequest.Builder().build());
    }

    // ----- Endpoint: security.get_users_legacy

    /**
     * <p>
     * Retrieve all internal users. Legacy API.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public CompletableFuture<GetUsersLegacyResponse> getUsersLegacy(GetUsersLegacyRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, GetUsersLegacyRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Retrieve all internal users. Legacy API.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link GetUsersLegacyRequest}
     */
    public final CompletableFuture<GetUsersLegacyResponse> getUsersLegacy(
        Function<GetUsersLegacyRequest.Builder, ObjectBuilder<GetUsersLegacyRequest>> fn
    ) throws IOException, OpenSearchException {
        return getUsersLegacy(fn.apply(new GetUsersLegacyRequest.Builder()).build());
    }

    /**
     * <p>
     * Retrieve all internal users. Legacy API.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public final CompletableFuture<GetUsersLegacyResponse> getUsersLegacy() throws IOException, OpenSearchException {
        return getUsersLegacy(new GetUsersLegacyRequest.Builder().build());
    }

    // ----- Endpoint: security.health

    /**
     * <p>
     * Checks to see if the Security plugin is running.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public CompletableFuture<HealthResponse> health(HealthRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, HealthRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Checks to see if the Security plugin is running.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link HealthRequest}
     */
    public final CompletableFuture<HealthResponse> health(Function<HealthRequest.Builder, ObjectBuilder<HealthRequest>> fn)
        throws IOException, OpenSearchException {
        return health(fn.apply(new HealthRequest.Builder()).build());
    }

    /**
     * <p>
     * Checks to see if the Security plugin is running.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public final CompletableFuture<HealthResponse> health() throws IOException, OpenSearchException {
        return health(new HealthRequest.Builder().build());
    }

    // ----- Endpoint: security.migrate

    /**
     * <p>
     * Migrates the security configuration from v6 to v7.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public CompletableFuture<MigrateResponse> migrate(MigrateRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, MigrateRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Migrates the security configuration from v6 to v7.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link MigrateRequest}
     */
    public final CompletableFuture<MigrateResponse> migrate(Function<MigrateRequest.Builder, ObjectBuilder<MigrateRequest>> fn)
        throws IOException, OpenSearchException {
        return migrate(fn.apply(new MigrateRequest.Builder()).build());
    }

    /**
     * <p>
     * Migrates the security configuration from v6 to v7.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public final CompletableFuture<MigrateResponse> migrate() throws IOException, OpenSearchException {
        return migrate(new MigrateRequest.Builder().build());
    }

    // ----- Endpoint: security.patch_action_group

    /**
     * <p>
     * Updates the individual attributes of an action group.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public CompletableFuture<PatchActionGroupResponse> patchActionGroup(PatchActionGroupRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, PatchActionGroupRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Updates the individual attributes of an action group.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link PatchActionGroupRequest}
     */
    public final CompletableFuture<PatchActionGroupResponse> patchActionGroup(
        Function<PatchActionGroupRequest.Builder, ObjectBuilder<PatchActionGroupRequest>> fn
    ) throws IOException, OpenSearchException {
        return patchActionGroup(fn.apply(new PatchActionGroupRequest.Builder()).build());
    }

    // ----- Endpoint: security.patch_action_groups

    /**
     * <p>
     * Creates, updates, or deletes multiple action groups in a single request.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public CompletableFuture<PatchActionGroupsResponse> patchActionGroups(PatchActionGroupsRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, PatchActionGroupsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Creates, updates, or deletes multiple action groups in a single request.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link PatchActionGroupsRequest}
     */
    public final CompletableFuture<PatchActionGroupsResponse> patchActionGroups(
        Function<PatchActionGroupsRequest.Builder, ObjectBuilder<PatchActionGroupsRequest>> fn
    ) throws IOException, OpenSearchException {
        return patchActionGroups(fn.apply(new PatchActionGroupsRequest.Builder()).build());
    }

    // ----- Endpoint: security.patch_allowlist

    /**
     * <p>
     * Updates the current list of APIs accessible for users on the allow list.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.1</code>
     * </p>
     */
    public CompletableFuture<PatchAllowlistResponse> patchAllowlist(PatchAllowlistRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, PatchAllowlistRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Updates the current list of APIs accessible for users on the allow list.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.1</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link PatchAllowlistRequest}
     */
    public final CompletableFuture<PatchAllowlistResponse> patchAllowlist(
        Function<PatchAllowlistRequest.Builder, ObjectBuilder<PatchAllowlistRequest>> fn
    ) throws IOException, OpenSearchException {
        return patchAllowlist(fn.apply(new PatchAllowlistRequest.Builder()).build());
    }

    // ----- Endpoint: security.patch_audit_configuration

    /**
     * <p>
     * Updates the specified fields in the audit configuration.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public CompletableFuture<PatchAuditConfigurationResponse> patchAuditConfiguration(PatchAuditConfigurationRequest request)
        throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, PatchAuditConfigurationRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Updates the specified fields in the audit configuration.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link PatchAuditConfigurationRequest}
     */
    public final CompletableFuture<PatchAuditConfigurationResponse> patchAuditConfiguration(
        Function<PatchAuditConfigurationRequest.Builder, ObjectBuilder<PatchAuditConfigurationRequest>> fn
    ) throws IOException, OpenSearchException {
        return patchAuditConfiguration(fn.apply(new PatchAuditConfigurationRequest.Builder()).build());
    }

    // ----- Endpoint: security.patch_configuration

    /**
     * <p>
     * Updates the existing security configuration using the REST API. Requires super admin or REST API permissions.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.10</code>
     * </p>
     */
    public CompletableFuture<PatchConfigurationResponse> patchConfiguration(PatchConfigurationRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, PatchConfigurationRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Updates the existing security configuration using the REST API. Requires super admin or REST API permissions.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.10</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link PatchConfigurationRequest}
     */
    public final CompletableFuture<PatchConfigurationResponse> patchConfiguration(
        Function<PatchConfigurationRequest.Builder, ObjectBuilder<PatchConfigurationRequest>> fn
    ) throws IOException, OpenSearchException {
        return patchConfiguration(fn.apply(new PatchConfigurationRequest.Builder()).build());
    }

    // ----- Endpoint: security.patch_distinguished_name

    /**
     * <p>
     * Updates the distinguished cluster name for the specified cluster. Requires super admin or REST API permissions.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public CompletableFuture<PatchDistinguishedNameResponse> patchDistinguishedName(PatchDistinguishedNameRequest request)
        throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, PatchDistinguishedNameRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Updates the distinguished cluster name for the specified cluster. Requires super admin or REST API permissions.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link PatchDistinguishedNameRequest}
     */
    public final CompletableFuture<PatchDistinguishedNameResponse> patchDistinguishedName(
        Function<PatchDistinguishedNameRequest.Builder, ObjectBuilder<PatchDistinguishedNameRequest>> fn
    ) throws IOException, OpenSearchException {
        return patchDistinguishedName(fn.apply(new PatchDistinguishedNameRequest.Builder()).build());
    }

    // ----- Endpoint: security.patch_distinguished_names

    /**
     * <p>
     * Bulk updates specified node distinguished names. Requires super admin or REST API permissions.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public CompletableFuture<PatchDistinguishedNamesResponse> patchDistinguishedNames(PatchDistinguishedNamesRequest request)
        throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, PatchDistinguishedNamesRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Bulk updates specified node distinguished names. Requires super admin or REST API permissions.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link PatchDistinguishedNamesRequest}
     */
    public final CompletableFuture<PatchDistinguishedNamesResponse> patchDistinguishedNames(
        Function<PatchDistinguishedNamesRequest.Builder, ObjectBuilder<PatchDistinguishedNamesRequest>> fn
    ) throws IOException, OpenSearchException {
        return patchDistinguishedNames(fn.apply(new PatchDistinguishedNamesRequest.Builder()).build());
    }

    // ----- Endpoint: security.patch_role

    /**
     * <p>
     * Updates the individual attributes of a role.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public CompletableFuture<PatchRoleResponse> patchRole(PatchRoleRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, PatchRoleRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Updates the individual attributes of a role.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link PatchRoleRequest}
     */
    public final CompletableFuture<PatchRoleResponse> patchRole(Function<PatchRoleRequest.Builder, ObjectBuilder<PatchRoleRequest>> fn)
        throws IOException, OpenSearchException {
        return patchRole(fn.apply(new PatchRoleRequest.Builder()).build());
    }

    // ----- Endpoint: security.patch_role_mapping

    /**
     * <p>
     * Updates the individual attributes of a role mapping.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public CompletableFuture<PatchRoleMappingResponse> patchRoleMapping(PatchRoleMappingRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, PatchRoleMappingRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Updates the individual attributes of a role mapping.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link PatchRoleMappingRequest}
     */
    public final CompletableFuture<PatchRoleMappingResponse> patchRoleMapping(
        Function<PatchRoleMappingRequest.Builder, ObjectBuilder<PatchRoleMappingRequest>> fn
    ) throws IOException, OpenSearchException {
        return patchRoleMapping(fn.apply(new PatchRoleMappingRequest.Builder()).build());
    }

    // ----- Endpoint: security.patch_role_mappings

    /**
     * <p>
     * Creates or updates multiple role mappings in a single request.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public CompletableFuture<PatchRoleMappingsResponse> patchRoleMappings(PatchRoleMappingsRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, PatchRoleMappingsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Creates or updates multiple role mappings in a single request.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link PatchRoleMappingsRequest}
     */
    public final CompletableFuture<PatchRoleMappingsResponse> patchRoleMappings(
        Function<PatchRoleMappingsRequest.Builder, ObjectBuilder<PatchRoleMappingsRequest>> fn
    ) throws IOException, OpenSearchException {
        return patchRoleMappings(fn.apply(new PatchRoleMappingsRequest.Builder()).build());
    }

    // ----- Endpoint: security.patch_roles

    /**
     * <p>
     * Creates, updates, or deletes multiple roles in a single call.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public CompletableFuture<PatchRolesResponse> patchRoles(PatchRolesRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, PatchRolesRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Creates, updates, or deletes multiple roles in a single call.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link PatchRolesRequest}
     */
    public final CompletableFuture<PatchRolesResponse> patchRoles(Function<PatchRolesRequest.Builder, ObjectBuilder<PatchRolesRequest>> fn)
        throws IOException, OpenSearchException {
        return patchRoles(fn.apply(new PatchRolesRequest.Builder()).build());
    }

    // ----- Endpoint: security.patch_tenant

    /**
     * <p>
     * Adds, deletes, or modifies a single tenant.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public CompletableFuture<PatchTenantResponse> patchTenant(PatchTenantRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, PatchTenantRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Adds, deletes, or modifies a single tenant.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link PatchTenantRequest}
     */
    public final CompletableFuture<PatchTenantResponse> patchTenant(
        Function<PatchTenantRequest.Builder, ObjectBuilder<PatchTenantRequest>> fn
    ) throws IOException, OpenSearchException {
        return patchTenant(fn.apply(new PatchTenantRequest.Builder()).build());
    }

    // ----- Endpoint: security.patch_tenants

    /**
     * <p>
     * Adds, deletes, or modifies multiple tenants in a single request.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public CompletableFuture<PatchTenantsResponse> patchTenants(PatchTenantsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, PatchTenantsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Adds, deletes, or modifies multiple tenants in a single request.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link PatchTenantsRequest}
     */
    public final CompletableFuture<PatchTenantsResponse> patchTenants(
        Function<PatchTenantsRequest.Builder, ObjectBuilder<PatchTenantsRequest>> fn
    ) throws IOException, OpenSearchException {
        return patchTenants(fn.apply(new PatchTenantsRequest.Builder()).build());
    }

    // ----- Endpoint: security.patch_user

    /**
     * <p>
     * Updates individual attributes for an internal user.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public CompletableFuture<PatchUserResponse> patchUser(PatchUserRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, PatchUserRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Updates individual attributes for an internal user.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link PatchUserRequest}
     */
    public final CompletableFuture<PatchUserResponse> patchUser(Function<PatchUserRequest.Builder, ObjectBuilder<PatchUserRequest>> fn)
        throws IOException, OpenSearchException {
        return patchUser(fn.apply(new PatchUserRequest.Builder()).build());
    }

    // ----- Endpoint: security.patch_users

    /**
     * <p>
     * Creates, updates, or deletes multiple internal users in a single request.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public CompletableFuture<PatchUsersResponse> patchUsers(PatchUsersRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, PatchUsersRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Creates, updates, or deletes multiple internal users in a single request.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link PatchUsersRequest}
     */
    public final CompletableFuture<PatchUsersResponse> patchUsers(Function<PatchUsersRequest.Builder, ObjectBuilder<PatchUsersRequest>> fn)
        throws IOException, OpenSearchException {
        return patchUsers(fn.apply(new PatchUsersRequest.Builder()).build());
    }

    // ----- Endpoint: security.post_dashboards_info

    /**
     * <p>
     * Retrieves the current values for dynamic security settings for OpenSearch Dashboards.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public CompletableFuture<PostDashboardsInfoResponse> postDashboardsInfo(PostDashboardsInfoRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, PostDashboardsInfoRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Retrieves the current values for dynamic security settings for OpenSearch Dashboards.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link PostDashboardsInfoRequest}
     */
    public final CompletableFuture<PostDashboardsInfoResponse> postDashboardsInfo(
        Function<PostDashboardsInfoRequest.Builder, ObjectBuilder<PostDashboardsInfoRequest>> fn
    ) throws IOException, OpenSearchException {
        return postDashboardsInfo(fn.apply(new PostDashboardsInfoRequest.Builder()).build());
    }

    /**
     * <p>
     * Retrieves the current values for dynamic security settings for OpenSearch Dashboards.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public final CompletableFuture<PostDashboardsInfoResponse> postDashboardsInfo() throws IOException, OpenSearchException {
        return postDashboardsInfo(new PostDashboardsInfoRequest.Builder().build());
    }

    // ----- Endpoint: security.reload_http_certificates

    /**
     * <p>
     * Reloads the HTTP communication certificates.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.8</code>
     * </p>
     */
    public CompletableFuture<ReloadHttpCertificatesResponse> reloadHttpCertificates(ReloadHttpCertificatesRequest request)
        throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, ReloadHttpCertificatesRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Reloads the HTTP communication certificates.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.8</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link ReloadHttpCertificatesRequest}
     */
    public final CompletableFuture<ReloadHttpCertificatesResponse> reloadHttpCertificates(
        Function<ReloadHttpCertificatesRequest.Builder, ObjectBuilder<ReloadHttpCertificatesRequest>> fn
    ) throws IOException, OpenSearchException {
        return reloadHttpCertificates(fn.apply(new ReloadHttpCertificatesRequest.Builder()).build());
    }

    /**
     * <p>
     * Reloads the HTTP communication certificates.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.8</code>
     * </p>
     */
    public final CompletableFuture<ReloadHttpCertificatesResponse> reloadHttpCertificates() throws IOException, OpenSearchException {
        return reloadHttpCertificates(new ReloadHttpCertificatesRequest.Builder().build());
    }

    // ----- Endpoint: security.reload_transport_certificates

    /**
     * <p>
     * Reloads the transport communication certificates.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.8</code>
     * </p>
     */
    public CompletableFuture<ReloadTransportCertificatesResponse> reloadTransportCertificates(ReloadTransportCertificatesRequest request)
        throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, ReloadTransportCertificatesRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Reloads the transport communication certificates.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.8</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link ReloadTransportCertificatesRequest}
     */
    public final CompletableFuture<ReloadTransportCertificatesResponse> reloadTransportCertificates(
        Function<ReloadTransportCertificatesRequest.Builder, ObjectBuilder<ReloadTransportCertificatesRequest>> fn
    ) throws IOException, OpenSearchException {
        return reloadTransportCertificates(fn.apply(new ReloadTransportCertificatesRequest.Builder()).build());
    }

    /**
     * <p>
     * Reloads the transport communication certificates.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.8</code>
     * </p>
     */
    public final CompletableFuture<ReloadTransportCertificatesResponse> reloadTransportCertificates() throws IOException,
        OpenSearchException {
        return reloadTransportCertificates(new ReloadTransportCertificatesRequest.Builder().build());
    }

    // ----- Endpoint: security.tenant_info

    /**
     * <p>
     * Retrieves the names of current tenants. Requires super admin or <code>kibanaserver</code> permissions.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public CompletableFuture<TenantInfoResponse> tenantInfo(TenantInfoRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, TenantInfoRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Retrieves the names of current tenants. Requires super admin or <code>kibanaserver</code> permissions.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link TenantInfoRequest}
     */
    public final CompletableFuture<TenantInfoResponse> tenantInfo(Function<TenantInfoRequest.Builder, ObjectBuilder<TenantInfoRequest>> fn)
        throws IOException, OpenSearchException {
        return tenantInfo(fn.apply(new TenantInfoRequest.Builder()).build());
    }

    /**
     * <p>
     * Retrieves the names of current tenants. Requires super admin or <code>kibanaserver</code> permissions.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public final CompletableFuture<TenantInfoResponse> tenantInfo() throws IOException, OpenSearchException {
        return tenantInfo(new TenantInfoRequest.Builder().build());
    }

    // ----- Endpoint: security.update_audit_configuration

    /**
     * <p>
     * Updates the audit configuration.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public CompletableFuture<UpdateAuditConfigurationResponse> updateAuditConfiguration(UpdateAuditConfigurationRequest request)
        throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, UpdateAuditConfigurationRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Updates the audit configuration.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link UpdateAuditConfigurationRequest}
     */
    public final CompletableFuture<UpdateAuditConfigurationResponse> updateAuditConfiguration(
        Function<UpdateAuditConfigurationRequest.Builder, ObjectBuilder<UpdateAuditConfigurationRequest>> fn
    ) throws IOException, OpenSearchException {
        return updateAuditConfiguration(fn.apply(new UpdateAuditConfigurationRequest.Builder()).build());
    }

    /**
     * <p>
     * Updates the audit configuration.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public final CompletableFuture<UpdateAuditConfigurationResponse> updateAuditConfiguration() throws IOException, OpenSearchException {
        return updateAuditConfiguration(new UpdateAuditConfigurationRequest.Builder().build());
    }

    // ----- Endpoint: security.update_configuration

    /**
     * <p>
     * Updates the settings for an existing security configuration. Requires super admin or REST API permissions.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.10</code>
     * </p>
     */
    public CompletableFuture<UpdateConfigurationResponse> updateConfiguration(UpdateConfigurationRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, UpdateConfigurationRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Updates the settings for an existing security configuration. Requires super admin or REST API permissions.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.10</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link UpdateConfigurationRequest}
     */
    public final CompletableFuture<UpdateConfigurationResponse> updateConfiguration(
        Function<UpdateConfigurationRequest.Builder, ObjectBuilder<UpdateConfigurationRequest>> fn
    ) throws IOException, OpenSearchException {
        return updateConfiguration(fn.apply(new UpdateConfigurationRequest.Builder()).build());
    }

    /**
     * <p>
     * Updates the settings for an existing security configuration. Requires super admin or REST API permissions.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.10</code>
     * </p>
     */
    public final CompletableFuture<UpdateConfigurationResponse> updateConfiguration() throws IOException, OpenSearchException {
        return updateConfiguration(new UpdateConfigurationRequest.Builder().build());
    }

    // ----- Endpoint: security.update_distinguished_name

    /**
     * <p>
     * Adds or updates the specified distinguished names in the cluster or node allowlist. Requires super admin or REST API permissions.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public CompletableFuture<UpdateDistinguishedNameResponse> updateDistinguishedName(UpdateDistinguishedNameRequest request)
        throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, UpdateDistinguishedNameRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Adds or updates the specified distinguished names in the cluster or node allowlist. Requires super admin or REST API permissions.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link UpdateDistinguishedNameRequest}
     */
    public final CompletableFuture<UpdateDistinguishedNameResponse> updateDistinguishedName(
        Function<UpdateDistinguishedNameRequest.Builder, ObjectBuilder<UpdateDistinguishedNameRequest>> fn
    ) throws IOException, OpenSearchException {
        return updateDistinguishedName(fn.apply(new UpdateDistinguishedNameRequest.Builder()).build());
    }

    // ----- Endpoint: security.validate

    /**
     * <p>
     * Checks whether the v6 security configuration is valid and ready to be migrated to v7.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public CompletableFuture<ValidateResponse> validate(ValidateRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, ValidateRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Checks whether the v6 security configuration is valid and ready to be migrated to v7.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link ValidateRequest}
     */
    public final CompletableFuture<ValidateResponse> validate(Function<ValidateRequest.Builder, ObjectBuilder<ValidateRequest>> fn)
        throws IOException, OpenSearchException {
        return validate(fn.apply(new ValidateRequest.Builder()).build());
    }

    /**
     * <p>
     * Checks whether the v6 security configuration is valid and ready to be migrated to v7.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>1.0</code>
     * </p>
     */
    public final CompletableFuture<ValidateResponse> validate() throws IOException, OpenSearchException {
        return validate(new ValidateRequest.Builder().build());
    }

    // ----- Endpoint: security.who_am_i

    /**
     * <p>
     * Gets the identity information for the user currently logged in.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.0</code>
     * </p>
     */
    public CompletableFuture<WhoAmIResponse> whoAmI(WhoAmIRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, WhoAmIRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Gets the identity information for the user currently logged in.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.0</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link WhoAmIRequest}
     */
    public final CompletableFuture<WhoAmIResponse> whoAmI(Function<WhoAmIRequest.Builder, ObjectBuilder<WhoAmIRequest>> fn)
        throws IOException, OpenSearchException {
        return whoAmI(fn.apply(new WhoAmIRequest.Builder()).build());
    }

    /**
     * <p>
     * Gets the identity information for the user currently logged in.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.0</code>
     * </p>
     */
    public final CompletableFuture<WhoAmIResponse> whoAmI() throws IOException, OpenSearchException {
        return whoAmI(new WhoAmIRequest.Builder().build());
    }

    // ----- Endpoint: security.who_am_i_protected

    /**
     * <p>
     * Gets the identity information for the user currently logged in. To use this operation, you must have access to this endpoint when
     * authorization at REST layer is enabled.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.11</code>
     * </p>
     */
    public CompletableFuture<WhoAmIProtectedResponse> whoAmIProtected(WhoAmIProtectedRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, WhoAmIProtectedRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Gets the identity information for the user currently logged in. To use this operation, you must have access to this endpoint when
     * authorization at REST layer is enabled.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.11</code>
     * </p>
     *
     * @param fn a function that initializes a builder to create the {@link WhoAmIProtectedRequest}
     */
    public final CompletableFuture<WhoAmIProtectedResponse> whoAmIProtected(
        Function<WhoAmIProtectedRequest.Builder, ObjectBuilder<WhoAmIProtectedRequest>> fn
    ) throws IOException, OpenSearchException {
        return whoAmIProtected(fn.apply(new WhoAmIProtectedRequest.Builder()).build());
    }

    /**
     * <p>
     * Gets the identity information for the user currently logged in. To use this operation, you must have access to this endpoint when
     * authorization at REST layer is enabled.
     * </p>
     * <p>
     * <strong>Minimum version:</strong> <code>2.11</code>
     * </p>
     */
    public final CompletableFuture<WhoAmIProtectedResponse> whoAmIProtected() throws IOException, OpenSearchException {
        return whoAmIProtected(new WhoAmIProtectedRequest.Builder().build());
    }
}
