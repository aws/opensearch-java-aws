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

import javax.annotation.Generated;
import software.amazon.awssdk.opensearch.client.json.JsonEnum;
import software.amazon.awssdk.opensearch.client.json.JsonpDeserializable;

// typedef: ml.MlResultDataType

/**
 * The result data type.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public enum MlResultDataType implements JsonEnum {
    Boolean("BOOLEAN"),

    Float16("FLOAT16"),

    Float32("FLOAT32"),

    Float64("FLOAT64"),

    Int32("INT32"),

    Int64("INT64"),

    Int8("INT8"),

    String("STRING"),

    Uint8("UINT8"),

    Unknown("UNKNOWN");

    private final String jsonValue;

    MlResultDataType(String jsonValue) {
        this.jsonValue = jsonValue;
    }

    public String jsonValue() {
        return this.jsonValue;
    }

    public static final JsonEnum.Deserializer<MlResultDataType> _DESERIALIZER = new JsonEnum.Deserializer<>(MlResultDataType.values());
}
