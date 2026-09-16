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

package software.amazon.awssdk.opensearch.client.aos.ml;

import javax.annotation.Generated;
import software.amazon.awssdk.opensearch.client.json.JsonEnum;
import software.amazon.awssdk.opensearch.client.json.JsonpDeserializable;

// typedef: ml.ToolName

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public enum ToolName implements JsonEnum {
    AgentTool("AgentTool"),

    CatIndexTool("CatIndexTool"),

    ConnectorTool("ConnectorTool"),

    CreateAnomalyDetectorTool("CreateAnomalyDetectorTool"),

    IndexMappingTool("IndexMappingTool"),

    ListIndexTool("ListIndexTool"),

    LogPatternTool("LogPatternTool"),

    MlModelTool("MLModelTool"),

    NeuralSparseSearchTool("NeuralSparseSearchTool"),

    PplTool("PPLTool"),

    QueryPlanningTool("QueryPlanningTool"),

    RagTool("RAGTool"),

    ReadFromScratchPadTool("ReadFromScratchPadTool"),

    SearchAlertsTool("SearchAlertsTool"),

    SearchAnomalyDetectorsTool("SearchAnomalyDetectorsTool"),

    SearchAnomalyResultsTool("SearchAnomalyResultsTool"),

    SearchIndexTool("SearchIndexTool"),

    SearchMonitorsTool("SearchMonitorsTool"),

    VectorDbTool("VectorDBTool"),

    VisualizationTool("VisualizationTool"),

    WriteToScratchPadTool("WriteToScratchPadTool");

    private final String jsonValue;

    ToolName(String jsonValue) {
        this.jsonValue = jsonValue;
    }

    public String jsonValue() {
        return this.jsonValue;
    }

    public static final JsonEnum.Deserializer<ToolName> _DESERIALIZER = new JsonEnum.Deserializer<>(ToolName.values());
}
