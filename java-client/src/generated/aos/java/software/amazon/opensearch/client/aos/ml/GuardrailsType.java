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

package software.amazon.opensearch.client.aos.ml;

import javax.annotation.Generated;
import software.amazon.opensearch.client.json.JsonEnum;
import software.amazon.opensearch.client.json.JsonpDeserializable;

// typedef: ml.GuardrailsType

/**
 * The guardrails type.
 */
@JsonpDeserializable
@Generated("software.amazon.opensearch.client.codegen.CodeGenerator")
public enum GuardrailsType implements JsonEnum {
    LocalRegex("local_regex"),

    Model("model");

    private final String jsonValue;

    GuardrailsType(String jsonValue) {
        this.jsonValue = jsonValue;
    }

    public String jsonValue() {
        return this.jsonValue;
    }

    public static final JsonEnum.Deserializer<GuardrailsType> _DESERIALIZER = new JsonEnum.Deserializer<>(GuardrailsType.values());
}
