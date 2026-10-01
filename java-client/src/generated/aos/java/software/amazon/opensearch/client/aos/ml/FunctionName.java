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

// typedef: ml.FunctionName

/**
 * The function name.
 */
@JsonpDeserializable
@Generated("software.amazon.opensearch.client.codegen.CodeGenerator")
public enum FunctionName implements JsonEnum {
    AdLibsvm("AD_LIBSVM", "ad_libsvm"),

    Agent("AGENT", "agent"),

    AnomalyLocalization("ANOMALY_LOCALIZATION", "anomaly_localization"),

    BatchRcf("BATCH_RCF", "batch_rcf"),

    Connector("CONNECTOR", "connector"),

    FitRcf("FIT_RCF", "fit_rcf"),

    Kmeans("KMEANS", "kmeans"),

    LinearRegression("LINEAR_REGRESSION", "linear_regression"),

    LocalSampleCalculator("LOCAL_SAMPLE_CALCULATOR", "local_sample_calculator"),

    LogisticRegression("LOGISTIC_REGRESSION", "logistic_regression"),

    MetricsCorrelation("METRICS_CORRELATION", "metrics_correlation"),

    QuestionAnswering("QUESTION_ANSWERING", "question_answering"),

    RcfSummarize("RCF_SUMMARIZE", "rcf_summarize"),

    Remote("REMOTE", "remote"),

    SampleAlgo("SAMPLE_ALGO", "sample_algo"),

    SparseEncoding("SPARSE_ENCODING", "sparse_encoding"),

    SparseTokenize("SPARSE_TOKENIZE", "sparse_tokenize"),

    TextEmbedding("TEXT_EMBEDDING", "text_embedding"),

    TextSimilarity("TEXT_SIMILARITY", "text_similarity");

    private final String jsonValue;
    private final String[] aliases;

    FunctionName(String jsonValue, String... aliases) {
        this.jsonValue = jsonValue;
        this.aliases = aliases;
    }

    public String jsonValue() {
        return this.jsonValue;
    }

    public String[] aliases() {
        return this.aliases;
    }

    public static final JsonEnum.Deserializer<FunctionName> _DESERIALIZER = new JsonEnum.Deserializer<>(FunctionName.values());
}
