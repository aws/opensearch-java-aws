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
public class OpenSearchSecurityClient extends ApiClient<OpenSearchTransport, OpenSearchSecurityClient> {
    public OpenSearchSecurityClient(OpenSearchTransport transport) {
        super(transport, null);
    }

    public OpenSearchSecurityClient(OpenSearchTransport transport, @Nullable TransportOptions transportOptions) {
        super(transport, transportOptions);
    }

    @Override
    public OpenSearchSecurityClient withTransportOptions(@Nullable TransportOptions transportOptions) {
        return new OpenSearchSecurityClient(this.transport, transportOptions);
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
    public AuthinfoResponse authinfo(AuthinfoRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, AuthinfoRequest._ENDPOINT, this.transportOptions);
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
    public final AuthinfoResponse authinfo(Function<AuthinfoRequest.Builder, ObjectBuilder<AuthinfoRequest>> fn) throws IOException,
        OpenSearchException {
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
    public final AuthinfoResponse authinfo() throws IOException, OpenSearchException {
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
    public AuthtokenResponse authtoken(AuthtokenRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, AuthtokenRequest._ENDPOINT, this.transportOptions);
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
    public final AuthtokenResponse authtoken(Function<AuthtokenRequest.Builder, ObjectBuilder<AuthtokenRequest>> fn) throws IOException,
        OpenSearchException {
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
    public final AuthtokenResponse authtoken() throws IOException, OpenSearchException {
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
    public ChangePasswordResponse changePassword(ChangePasswordRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, ChangePasswordRequest._ENDPOINT, this.transportOptions);
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
    public final ChangePasswordResponse changePassword(Function<ChangePasswordRequest.Builder, ObjectBuilder<ChangePasswordRequest>> fn)
        throws IOException, OpenSearchException {
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
    public ConfigUpgradeCheckResponse configUpgradeCheck(ConfigUpgradeCheckRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, ConfigUpgradeCheckRequest._ENDPOINT, this.transportOptions);
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
    public final ConfigUpgradeCheckResponse configUpgradeCheck(
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
    public final ConfigUpgradeCheckResponse configUpgradeCheck() throws IOException, OpenSearchException {
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
    public ConfigUpgradePerformResponse configUpgradePerform(ConfigUpgradePerformRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, ConfigUpgradePerformRequest._ENDPOINT, this.transportOptions);
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
    public final ConfigUpgradePerformResponse configUpgradePerform(
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
    public final ConfigUpgradePerformResponse configUpgradePerform() throws IOException, OpenSearchException {
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
    public CreateActionGroupResponse createActionGroup(CreateActionGroupRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, CreateActionGroupRequest._ENDPOINT, this.transportOptions);
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
    public final CreateActionGroupResponse createActionGroup(
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
    public CreateAllowlistResponse createAllowlist(CreateAllowlistRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, CreateAllowlistRequest._ENDPOINT, this.transportOptions);
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
    public final CreateAllowlistResponse createAllowlist(Function<CreateAllowlistRequest.Builder, ObjectBuilder<CreateAllowlistRequest>> fn)
        throws IOException, OpenSearchException {
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
    public final CreateAllowlistResponse createAllowlist() throws IOException, OpenSearchException {
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
    public CreateRoleResponse createRole(CreateRoleRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, CreateRoleRequest._ENDPOINT, this.transportOptions);
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
    public final CreateRoleResponse createRole(Function<CreateRoleRequest.Builder, ObjectBuilder<CreateRoleRequest>> fn) throws IOException,
        OpenSearchException {
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
    public CreateRoleMappingResponse createRoleMapping(CreateRoleMappingRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, CreateRoleMappingRequest._ENDPOINT, this.transportOptions);
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
    public final CreateRoleMappingResponse createRoleMapping(
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
    public CreateTenantResponse createTenant(CreateTenantRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, CreateTenantRequest._ENDPOINT, this.transportOptions);
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
    public final CreateTenantResponse createTenant(Function<CreateTenantRequest.Builder, ObjectBuilder<CreateTenantRequest>> fn)
        throws IOException, OpenSearchException {
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
    public CreateUpdateTenancyConfigResponse createUpdateTenancyConfig(CreateUpdateTenancyConfigRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequest(request, CreateUpdateTenancyConfigRequest._ENDPOINT, this.transportOptions);
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
    public final CreateUpdateTenancyConfigResponse createUpdateTenancyConfig(
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
    public final CreateUpdateTenancyConfigResponse createUpdateTenancyConfig() throws IOException, OpenSearchException {
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
    public CreateUserResponse createUser(CreateUserRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, CreateUserRequest._ENDPOINT, this.transportOptions);
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
    public final CreateUserResponse createUser(Function<CreateUserRequest.Builder, ObjectBuilder<CreateUserRequest>> fn) throws IOException,
        OpenSearchException {
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
    public CreateUserLegacyResponse createUserLegacy(CreateUserLegacyRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, CreateUserLegacyRequest._ENDPOINT, this.transportOptions);
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
    public final CreateUserLegacyResponse createUserLegacy(
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
    public DeleteActionGroupResponse deleteActionGroup(DeleteActionGroupRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, DeleteActionGroupRequest._ENDPOINT, this.transportOptions);
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
    public final DeleteActionGroupResponse deleteActionGroup(
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
    public DeleteDistinguishedNameResponse deleteDistinguishedName(DeleteDistinguishedNameRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequest(request, DeleteDistinguishedNameRequest._ENDPOINT, this.transportOptions);
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
    public final DeleteDistinguishedNameResponse deleteDistinguishedName(
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
    public DeleteRoleResponse deleteRole(DeleteRoleRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, DeleteRoleRequest._ENDPOINT, this.transportOptions);
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
    public final DeleteRoleResponse deleteRole(Function<DeleteRoleRequest.Builder, ObjectBuilder<DeleteRoleRequest>> fn) throws IOException,
        OpenSearchException {
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
    public DeleteRoleMappingResponse deleteRoleMapping(DeleteRoleMappingRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, DeleteRoleMappingRequest._ENDPOINT, this.transportOptions);
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
    public final DeleteRoleMappingResponse deleteRoleMapping(
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
    public DeleteTenantResponse deleteTenant(DeleteTenantRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, DeleteTenantRequest._ENDPOINT, this.transportOptions);
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
    public final DeleteTenantResponse deleteTenant(Function<DeleteTenantRequest.Builder, ObjectBuilder<DeleteTenantRequest>> fn)
        throws IOException, OpenSearchException {
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
    public DeleteUserResponse deleteUser(DeleteUserRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, DeleteUserRequest._ENDPOINT, this.transportOptions);
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
    public final DeleteUserResponse deleteUser(Function<DeleteUserRequest.Builder, ObjectBuilder<DeleteUserRequest>> fn) throws IOException,
        OpenSearchException {
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
    public DeleteUserLegacyResponse deleteUserLegacy(DeleteUserLegacyRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, DeleteUserLegacyRequest._ENDPOINT, this.transportOptions);
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
    public final DeleteUserLegacyResponse deleteUserLegacy(
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
    public FlushCacheResponse flushCache(FlushCacheRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, FlushCacheRequest._ENDPOINT, this.transportOptions);
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
    public final FlushCacheResponse flushCache(Function<FlushCacheRequest.Builder, ObjectBuilder<FlushCacheRequest>> fn) throws IOException,
        OpenSearchException {
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
    public final FlushCacheResponse flushCache() throws IOException, OpenSearchException {
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
    public GenerateOboTokenResponse generateOboToken(GenerateOboTokenRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GenerateOboTokenRequest._ENDPOINT, this.transportOptions);
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
    public final GenerateOboTokenResponse generateOboToken(
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
    public GenerateUserTokenResponse generateUserToken(GenerateUserTokenRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GenerateUserTokenRequest._ENDPOINT, this.transportOptions);
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
    public final GenerateUserTokenResponse generateUserToken(
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
    public BooleanResponse generateUserTokenLegacy(GenerateUserTokenLegacyRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GenerateUserTokenLegacyRequest._ENDPOINT, this.transportOptions);
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
    public final BooleanResponse generateUserTokenLegacy(
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
    public GetAccountDetailsResponse getAccountDetails(GetAccountDetailsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetAccountDetailsRequest._ENDPOINT, this.transportOptions);
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
    public final GetAccountDetailsResponse getAccountDetails(
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
    public final GetAccountDetailsResponse getAccountDetails() throws IOException, OpenSearchException {
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
    public GetActionGroupResponse getActionGroup(GetActionGroupRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetActionGroupRequest._ENDPOINT, this.transportOptions);
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
    public final GetActionGroupResponse getActionGroup(Function<GetActionGroupRequest.Builder, ObjectBuilder<GetActionGroupRequest>> fn)
        throws IOException, OpenSearchException {
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
    public GetActionGroupsResponse getActionGroups(GetActionGroupsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetActionGroupsRequest._ENDPOINT, this.transportOptions);
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
    public final GetActionGroupsResponse getActionGroups(Function<GetActionGroupsRequest.Builder, ObjectBuilder<GetActionGroupsRequest>> fn)
        throws IOException, OpenSearchException {
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
    public final GetActionGroupsResponse getActionGroups() throws IOException, OpenSearchException {
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
    public GetAllCertificatesResponse getAllCertificates(GetAllCertificatesRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetAllCertificatesRequest._ENDPOINT, this.transportOptions);
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
    public final GetAllCertificatesResponse getAllCertificates(
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
    public final GetAllCertificatesResponse getAllCertificates() throws IOException, OpenSearchException {
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
    public GetAllowlistResponse getAllowlist(GetAllowlistRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetAllowlistRequest._ENDPOINT, this.transportOptions);
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
    public final GetAllowlistResponse getAllowlist(Function<GetAllowlistRequest.Builder, ObjectBuilder<GetAllowlistRequest>> fn)
        throws IOException, OpenSearchException {
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
    public final GetAllowlistResponse getAllowlist() throws IOException, OpenSearchException {
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
    public GetAuditConfigurationResponse getAuditConfiguration(GetAuditConfigurationRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequest(request, GetAuditConfigurationRequest._ENDPOINT, this.transportOptions);
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
    public final GetAuditConfigurationResponse getAuditConfiguration(
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
    public final GetAuditConfigurationResponse getAuditConfiguration() throws IOException, OpenSearchException {
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
    public GetCertificatesResponse getCertificates(GetCertificatesRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetCertificatesRequest._ENDPOINT, this.transportOptions);
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
    public final GetCertificatesResponse getCertificates(Function<GetCertificatesRequest.Builder, ObjectBuilder<GetCertificatesRequest>> fn)
        throws IOException, OpenSearchException {
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
    public final GetCertificatesResponse getCertificates() throws IOException, OpenSearchException {
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
    public GetConfigurationResponse getConfiguration(GetConfigurationRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetConfigurationRequest._ENDPOINT, this.transportOptions);
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
    public final GetConfigurationResponse getConfiguration(
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
    public final GetConfigurationResponse getConfiguration() throws IOException, OpenSearchException {
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
    public GetDashboardsInfoResponse getDashboardsInfo(GetDashboardsInfoRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetDashboardsInfoRequest._ENDPOINT, this.transportOptions);
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
    public final GetDashboardsInfoResponse getDashboardsInfo(
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
    public final GetDashboardsInfoResponse getDashboardsInfo() throws IOException, OpenSearchException {
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
    public GetDistinguishedNameResponse getDistinguishedName(GetDistinguishedNameRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetDistinguishedNameRequest._ENDPOINT, this.transportOptions);
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
    public final GetDistinguishedNameResponse getDistinguishedName(
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
    public GetDistinguishedNamesResponse getDistinguishedNames(GetDistinguishedNamesRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequest(request, GetDistinguishedNamesRequest._ENDPOINT, this.transportOptions);
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
    public final GetDistinguishedNamesResponse getDistinguishedNames(
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
    public final GetDistinguishedNamesResponse getDistinguishedNames() throws IOException, OpenSearchException {
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
    public GetNodeCertificatesResponse getNodeCertificates(GetNodeCertificatesRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetNodeCertificatesRequest._ENDPOINT, this.transportOptions);
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
    public final GetNodeCertificatesResponse getNodeCertificates(
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
    public GetPermissionsInfoResponse getPermissionsInfo(GetPermissionsInfoRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetPermissionsInfoRequest._ENDPOINT, this.transportOptions);
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
    public final GetPermissionsInfoResponse getPermissionsInfo(
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
    public final GetPermissionsInfoResponse getPermissionsInfo() throws IOException, OpenSearchException {
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
    public GetRoleResponse getRole(GetRoleRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetRoleRequest._ENDPOINT, this.transportOptions);
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
    public final GetRoleResponse getRole(Function<GetRoleRequest.Builder, ObjectBuilder<GetRoleRequest>> fn) throws IOException,
        OpenSearchException {
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
    public GetRoleMappingResponse getRoleMapping(GetRoleMappingRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetRoleMappingRequest._ENDPOINT, this.transportOptions);
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
    public final GetRoleMappingResponse getRoleMapping(Function<GetRoleMappingRequest.Builder, ObjectBuilder<GetRoleMappingRequest>> fn)
        throws IOException, OpenSearchException {
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
    public GetRoleMappingsResponse getRoleMappings(GetRoleMappingsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetRoleMappingsRequest._ENDPOINT, this.transportOptions);
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
    public final GetRoleMappingsResponse getRoleMappings(Function<GetRoleMappingsRequest.Builder, ObjectBuilder<GetRoleMappingsRequest>> fn)
        throws IOException, OpenSearchException {
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
    public final GetRoleMappingsResponse getRoleMappings() throws IOException, OpenSearchException {
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
    public GetRolesResponse getRoles(GetRolesRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetRolesRequest._ENDPOINT, this.transportOptions);
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
    public final GetRolesResponse getRoles(Function<GetRolesRequest.Builder, ObjectBuilder<GetRolesRequest>> fn) throws IOException,
        OpenSearchException {
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
    public final GetRolesResponse getRoles() throws IOException, OpenSearchException {
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
    public GetSslinfoResponse getSslinfo(GetSslinfoRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetSslinfoRequest._ENDPOINT, this.transportOptions);
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
    public final GetSslinfoResponse getSslinfo(Function<GetSslinfoRequest.Builder, ObjectBuilder<GetSslinfoRequest>> fn) throws IOException,
        OpenSearchException {
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
    public final GetSslinfoResponse getSslinfo() throws IOException, OpenSearchException {
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
    public GetTenancyConfigResponse getTenancyConfig(GetTenancyConfigRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetTenancyConfigRequest._ENDPOINT, this.transportOptions);
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
    public final GetTenancyConfigResponse getTenancyConfig(
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
    public final GetTenancyConfigResponse getTenancyConfig() throws IOException, OpenSearchException {
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
    public GetTenantResponse getTenant(GetTenantRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetTenantRequest._ENDPOINT, this.transportOptions);
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
    public final GetTenantResponse getTenant(Function<GetTenantRequest.Builder, ObjectBuilder<GetTenantRequest>> fn) throws IOException,
        OpenSearchException {
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
    public GetTenantsResponse getTenants(GetTenantsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetTenantsRequest._ENDPOINT, this.transportOptions);
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
    public final GetTenantsResponse getTenants(Function<GetTenantsRequest.Builder, ObjectBuilder<GetTenantsRequest>> fn) throws IOException,
        OpenSearchException {
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
    public final GetTenantsResponse getTenants() throws IOException, OpenSearchException {
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
    public GetUserResponse getUser(GetUserRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetUserRequest._ENDPOINT, this.transportOptions);
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
    public final GetUserResponse getUser(Function<GetUserRequest.Builder, ObjectBuilder<GetUserRequest>> fn) throws IOException,
        OpenSearchException {
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
    public GetUserLegacyResponse getUserLegacy(GetUserLegacyRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetUserLegacyRequest._ENDPOINT, this.transportOptions);
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
    public final GetUserLegacyResponse getUserLegacy(Function<GetUserLegacyRequest.Builder, ObjectBuilder<GetUserLegacyRequest>> fn)
        throws IOException, OpenSearchException {
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
    public GetUsersResponse getUsers(GetUsersRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetUsersRequest._ENDPOINT, this.transportOptions);
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
    public final GetUsersResponse getUsers(Function<GetUsersRequest.Builder, ObjectBuilder<GetUsersRequest>> fn) throws IOException,
        OpenSearchException {
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
    public final GetUsersResponse getUsers() throws IOException, OpenSearchException {
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
    public GetUsersLegacyResponse getUsersLegacy(GetUsersLegacyRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetUsersLegacyRequest._ENDPOINT, this.transportOptions);
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
    public final GetUsersLegacyResponse getUsersLegacy(Function<GetUsersLegacyRequest.Builder, ObjectBuilder<GetUsersLegacyRequest>> fn)
        throws IOException, OpenSearchException {
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
    public final GetUsersLegacyResponse getUsersLegacy() throws IOException, OpenSearchException {
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
    public HealthResponse health(HealthRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, HealthRequest._ENDPOINT, this.transportOptions);
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
    public final HealthResponse health(Function<HealthRequest.Builder, ObjectBuilder<HealthRequest>> fn) throws IOException,
        OpenSearchException {
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
    public final HealthResponse health() throws IOException, OpenSearchException {
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
    public MigrateResponse migrate(MigrateRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, MigrateRequest._ENDPOINT, this.transportOptions);
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
    public final MigrateResponse migrate(Function<MigrateRequest.Builder, ObjectBuilder<MigrateRequest>> fn) throws IOException,
        OpenSearchException {
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
    public final MigrateResponse migrate() throws IOException, OpenSearchException {
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
    public PatchActionGroupResponse patchActionGroup(PatchActionGroupRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, PatchActionGroupRequest._ENDPOINT, this.transportOptions);
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
    public final PatchActionGroupResponse patchActionGroup(
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
    public PatchActionGroupsResponse patchActionGroups(PatchActionGroupsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, PatchActionGroupsRequest._ENDPOINT, this.transportOptions);
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
    public final PatchActionGroupsResponse patchActionGroups(
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
    public PatchAllowlistResponse patchAllowlist(PatchAllowlistRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, PatchAllowlistRequest._ENDPOINT, this.transportOptions);
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
    public final PatchAllowlistResponse patchAllowlist(Function<PatchAllowlistRequest.Builder, ObjectBuilder<PatchAllowlistRequest>> fn)
        throws IOException, OpenSearchException {
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
    public PatchAuditConfigurationResponse patchAuditConfiguration(PatchAuditConfigurationRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequest(request, PatchAuditConfigurationRequest._ENDPOINT, this.transportOptions);
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
    public final PatchAuditConfigurationResponse patchAuditConfiguration(
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
    public PatchConfigurationResponse patchConfiguration(PatchConfigurationRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, PatchConfigurationRequest._ENDPOINT, this.transportOptions);
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
    public final PatchConfigurationResponse patchConfiguration(
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
    public PatchDistinguishedNameResponse patchDistinguishedName(PatchDistinguishedNameRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequest(request, PatchDistinguishedNameRequest._ENDPOINT, this.transportOptions);
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
    public final PatchDistinguishedNameResponse patchDistinguishedName(
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
    public PatchDistinguishedNamesResponse patchDistinguishedNames(PatchDistinguishedNamesRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequest(request, PatchDistinguishedNamesRequest._ENDPOINT, this.transportOptions);
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
    public final PatchDistinguishedNamesResponse patchDistinguishedNames(
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
    public PatchRoleResponse patchRole(PatchRoleRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, PatchRoleRequest._ENDPOINT, this.transportOptions);
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
    public final PatchRoleResponse patchRole(Function<PatchRoleRequest.Builder, ObjectBuilder<PatchRoleRequest>> fn) throws IOException,
        OpenSearchException {
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
    public PatchRoleMappingResponse patchRoleMapping(PatchRoleMappingRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, PatchRoleMappingRequest._ENDPOINT, this.transportOptions);
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
    public final PatchRoleMappingResponse patchRoleMapping(
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
    public PatchRoleMappingsResponse patchRoleMappings(PatchRoleMappingsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, PatchRoleMappingsRequest._ENDPOINT, this.transportOptions);
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
    public final PatchRoleMappingsResponse patchRoleMappings(
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
    public PatchRolesResponse patchRoles(PatchRolesRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, PatchRolesRequest._ENDPOINT, this.transportOptions);
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
    public final PatchRolesResponse patchRoles(Function<PatchRolesRequest.Builder, ObjectBuilder<PatchRolesRequest>> fn) throws IOException,
        OpenSearchException {
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
    public PatchTenantResponse patchTenant(PatchTenantRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, PatchTenantRequest._ENDPOINT, this.transportOptions);
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
    public final PatchTenantResponse patchTenant(Function<PatchTenantRequest.Builder, ObjectBuilder<PatchTenantRequest>> fn)
        throws IOException, OpenSearchException {
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
    public PatchTenantsResponse patchTenants(PatchTenantsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, PatchTenantsRequest._ENDPOINT, this.transportOptions);
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
    public final PatchTenantsResponse patchTenants(Function<PatchTenantsRequest.Builder, ObjectBuilder<PatchTenantsRequest>> fn)
        throws IOException, OpenSearchException {
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
    public PatchUserResponse patchUser(PatchUserRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, PatchUserRequest._ENDPOINT, this.transportOptions);
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
    public final PatchUserResponse patchUser(Function<PatchUserRequest.Builder, ObjectBuilder<PatchUserRequest>> fn) throws IOException,
        OpenSearchException {
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
    public PatchUsersResponse patchUsers(PatchUsersRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, PatchUsersRequest._ENDPOINT, this.transportOptions);
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
    public final PatchUsersResponse patchUsers(Function<PatchUsersRequest.Builder, ObjectBuilder<PatchUsersRequest>> fn) throws IOException,
        OpenSearchException {
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
    public PostDashboardsInfoResponse postDashboardsInfo(PostDashboardsInfoRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, PostDashboardsInfoRequest._ENDPOINT, this.transportOptions);
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
    public final PostDashboardsInfoResponse postDashboardsInfo(
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
    public final PostDashboardsInfoResponse postDashboardsInfo() throws IOException, OpenSearchException {
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
    public ReloadHttpCertificatesResponse reloadHttpCertificates(ReloadHttpCertificatesRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequest(request, ReloadHttpCertificatesRequest._ENDPOINT, this.transportOptions);
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
    public final ReloadHttpCertificatesResponse reloadHttpCertificates(
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
    public final ReloadHttpCertificatesResponse reloadHttpCertificates() throws IOException, OpenSearchException {
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
    public ReloadTransportCertificatesResponse reloadTransportCertificates(ReloadTransportCertificatesRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequest(request, ReloadTransportCertificatesRequest._ENDPOINT, this.transportOptions);
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
    public final ReloadTransportCertificatesResponse reloadTransportCertificates(
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
    public final ReloadTransportCertificatesResponse reloadTransportCertificates() throws IOException, OpenSearchException {
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
    public TenantInfoResponse tenantInfo(TenantInfoRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, TenantInfoRequest._ENDPOINT, this.transportOptions);
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
    public final TenantInfoResponse tenantInfo(Function<TenantInfoRequest.Builder, ObjectBuilder<TenantInfoRequest>> fn) throws IOException,
        OpenSearchException {
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
    public final TenantInfoResponse tenantInfo() throws IOException, OpenSearchException {
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
    public UpdateAuditConfigurationResponse updateAuditConfiguration(UpdateAuditConfigurationRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequest(request, UpdateAuditConfigurationRequest._ENDPOINT, this.transportOptions);
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
    public final UpdateAuditConfigurationResponse updateAuditConfiguration(
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
    public final UpdateAuditConfigurationResponse updateAuditConfiguration() throws IOException, OpenSearchException {
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
    public UpdateConfigurationResponse updateConfiguration(UpdateConfigurationRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, UpdateConfigurationRequest._ENDPOINT, this.transportOptions);
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
    public final UpdateConfigurationResponse updateConfiguration(
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
    public final UpdateConfigurationResponse updateConfiguration() throws IOException, OpenSearchException {
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
    public UpdateDistinguishedNameResponse updateDistinguishedName(UpdateDistinguishedNameRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequest(request, UpdateDistinguishedNameRequest._ENDPOINT, this.transportOptions);
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
    public final UpdateDistinguishedNameResponse updateDistinguishedName(
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
    public ValidateResponse validate(ValidateRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, ValidateRequest._ENDPOINT, this.transportOptions);
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
    public final ValidateResponse validate(Function<ValidateRequest.Builder, ObjectBuilder<ValidateRequest>> fn) throws IOException,
        OpenSearchException {
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
    public final ValidateResponse validate() throws IOException, OpenSearchException {
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
    public WhoAmIResponse whoAmI(WhoAmIRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, WhoAmIRequest._ENDPOINT, this.transportOptions);
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
    public final WhoAmIResponse whoAmI(Function<WhoAmIRequest.Builder, ObjectBuilder<WhoAmIRequest>> fn) throws IOException,
        OpenSearchException {
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
    public final WhoAmIResponse whoAmI() throws IOException, OpenSearchException {
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
    public WhoAmIProtectedResponse whoAmIProtected(WhoAmIProtectedRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, WhoAmIProtectedRequest._ENDPOINT, this.transportOptions);
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
    public final WhoAmIProtectedResponse whoAmIProtected(Function<WhoAmIProtectedRequest.Builder, ObjectBuilder<WhoAmIProtectedRequest>> fn)
        throws IOException, OpenSearchException {
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
    public final WhoAmIProtectedResponse whoAmIProtected() throws IOException, OpenSearchException {
        return whoAmIProtected(new WhoAmIProtectedRequest.Builder().build());
    }
}
