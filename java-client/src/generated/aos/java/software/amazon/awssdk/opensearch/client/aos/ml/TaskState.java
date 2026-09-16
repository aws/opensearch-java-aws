/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

//----------------------------------------------------
// THIS CODE IS GENERATED. MANUAL EDITS WILL BE LOST.
//----------------------------------------------------

package software.amazon.awssdk.opensearch.client.aos.ml;

import javax.annotation.Generated;
import software.amazon.awssdk.opensearch.client.json.JsonEnum;
import software.amazon.awssdk.opensearch.client.json.JsonpDeserializable;

// typedef: ml.TaskState

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public enum TaskState implements JsonEnum {
    Cancelled("CANCELLED"),

    Cancelling("CANCELLING"),

    Completed("COMPLETED"),

    CompletedWithError("COMPLETED_WITH_ERROR"),

    Created("CREATED"),

    Expired("EXPIRED"),

    Failed("FAILED"),

    Running("RUNNING");

    private final String jsonValue;

    TaskState(String jsonValue) {
        this.jsonValue = jsonValue;
    }

    public String jsonValue() {
        return this.jsonValue;
    }

    public static final JsonEnum.Deserializer<TaskState> _DESERIALIZER = new JsonEnum.Deserializer<>(TaskState.values());
}
