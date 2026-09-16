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

// typedef: ml.StrategyType

/**
 * The strategy type.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public enum StrategyType implements JsonEnum {
    Semantic("SEMANTIC"),

    Summary("SUMMARY"),

    UserPreference("USER_PREFERENCE");

    private final String jsonValue;

    StrategyType(String jsonValue) {
        this.jsonValue = jsonValue;
    }

    public String jsonValue() {
        return this.jsonValue;
    }

    public static final JsonEnum.Deserializer<StrategyType> _DESERIALIZER = new JsonEnum.Deserializer<>(StrategyType.values());
}
