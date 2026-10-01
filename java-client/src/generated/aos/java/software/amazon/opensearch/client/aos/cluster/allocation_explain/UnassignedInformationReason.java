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

package software.amazon.opensearch.client.aos.cluster.allocation_explain;

import javax.annotation.Generated;
import software.amazon.opensearch.client.json.JsonEnum;
import software.amazon.opensearch.client.json.JsonpDeserializable;

// typedef: cluster.allocation_explain.UnassignedInformationReason

@JsonpDeserializable
@Generated("software.amazon.opensearch.client.codegen.CodeGenerator")
public enum UnassignedInformationReason implements JsonEnum {
    AllocationFailed("ALLOCATION_FAILED"),

    ClusterRecovered("CLUSTER_RECOVERED"),

    DanglingIndexImported("DANGLING_INDEX_IMPORTED"),

    ExistingIndexRestored("EXISTING_INDEX_RESTORED"),

    ForcedEmptyPrimary("FORCED_EMPTY_PRIMARY"),

    IndexCreated("INDEX_CREATED"),

    IndexReopened("INDEX_REOPENED"),

    ManualAllocation("MANUAL_ALLOCATION"),

    NewIndexRestored("NEW_INDEX_RESTORED"),

    NodeLeft("NODE_LEFT"),

    PrimaryFailed("PRIMARY_FAILED"),

    ReallocatedReplica("REALLOCATED_REPLICA"),

    Reinitialized("REINITIALIZED"),

    ReplicaAdded("REPLICA_ADDED"),

    RerouteCancelled("REROUTE_CANCELLED");

    private final String jsonValue;

    UnassignedInformationReason(String jsonValue) {
        this.jsonValue = jsonValue;
    }

    public String jsonValue() {
        return this.jsonValue;
    }

    public static final JsonEnum.Deserializer<UnassignedInformationReason> _DESERIALIZER = new JsonEnum.Deserializer<>(
        UnassignedInformationReason.values()
    );
}
