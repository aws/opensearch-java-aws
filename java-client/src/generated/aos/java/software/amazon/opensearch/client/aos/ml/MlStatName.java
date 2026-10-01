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

// typedef: ml.MlStatName

@JsonpDeserializable
@Generated("software.amazon.opensearch.client.codegen.CodeGenerator")
public enum MlStatName implements JsonEnum {
    MlConfigIndexStatus("ml_config_index_status"),

    MlConnectorCount("ml_connector_count"),

    MlConnectorIndexStatus("ml_connector_index_status"),

    MlControllerIndexStatus("ml_controller_index_status"),

    MlModelCount("ml_model_count"),

    MlModelIndexStatus("ml_model_index_status"),

    MlTaskIndexStatus("ml_task_index_status");

    private final String jsonValue;

    MlStatName(String jsonValue) {
        this.jsonValue = jsonValue;
    }

    public String jsonValue() {
        return this.jsonValue;
    }

    public static final JsonEnum.Deserializer<MlStatName> _DESERIALIZER = new JsonEnum.Deserializer<>(MlStatName.values());
}
