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

// typedef: ml.MlTaskType

/**
 * Task type.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public enum MlTaskType implements JsonEnum {
    BatchIngest("BATCH_INGEST"),

    BatchPrediction("BATCH_PREDICTION"),

    DeployModel("DEPLOY_MODEL"),

    Execution("EXECUTION"),

    Prediction("PREDICTION"),

    RegisterModel("REGISTER_MODEL"),

    Training("TRAINING"),

    TrainingAndPrediction("TRAINING_AND_PREDICTION");

    private final String jsonValue;

    MlTaskType(String jsonValue) {
        this.jsonValue = jsonValue;
    }

    public String jsonValue() {
        return this.jsonValue;
    }

    public static final JsonEnum.Deserializer<MlTaskType> _DESERIALIZER = new JsonEnum.Deserializer<>(MlTaskType.values());
}
