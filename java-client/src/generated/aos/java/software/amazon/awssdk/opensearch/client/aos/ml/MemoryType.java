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

// typedef: ml.MemoryType

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public enum MemoryType implements JsonEnum {
    History("history"),

    LongTerm("long-term"),

    Sessions("sessions"),

    Working("working");

    private final String jsonValue;

    MemoryType(String jsonValue) {
        this.jsonValue = jsonValue;
    }

    public String jsonValue() {
        return this.jsonValue;
    }

    public static final JsonEnum.Deserializer<MemoryType> _DESERIALIZER = new JsonEnum.Deserializer<>(MemoryType.values());
}
