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

// typedef: ml.ModelFormat

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public enum ModelFormat implements JsonEnum {
    Onnx("ONNX"),

    TorchScript("TORCH_SCRIPT");

    private final String jsonValue;

    ModelFormat(String jsonValue) {
        this.jsonValue = jsonValue;
    }

    public String jsonValue() {
        return this.jsonValue;
    }

    public static final JsonEnum.Deserializer<ModelFormat> _DESERIALIZER = new JsonEnum.Deserializer<>(ModelFormat.values());
}
