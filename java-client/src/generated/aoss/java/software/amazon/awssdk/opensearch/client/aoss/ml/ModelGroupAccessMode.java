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

package software.amazon.awssdk.opensearch.client.aoss.ml;

import javax.annotation.Generated;
import software.amazon.awssdk.opensearch.client.json.JsonEnum;
import software.amazon.awssdk.opensearch.client.json.JsonpDeserializable;

// typedef: ml.ModelGroupAccessMode

/**
 * The model group access mode.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public enum ModelGroupAccessMode implements JsonEnum {
    Private("private"),

    Public("public"),

    Restricted("restricted");

    private final String jsonValue;

    ModelGroupAccessMode(String jsonValue) {
        this.jsonValue = jsonValue;
    }

    public String jsonValue() {
        return this.jsonValue;
    }

    public static final JsonEnum.Deserializer<ModelGroupAccessMode> _DESERIALIZER = new JsonEnum.Deserializer<>(
        ModelGroupAccessMode.values()
    );
}
