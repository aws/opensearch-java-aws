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

import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import software.amazon.awssdk.opensearch.client.json.JsonpDeserializable;
import software.amazon.awssdk.opensearch.client.json.JsonpDeserializer;
import software.amazon.awssdk.opensearch.client.json.ObjectBuilderDeserializer;
import software.amazon.awssdk.opensearch.client.json.ObjectDeserializer;
import software.amazon.awssdk.opensearch.client.transport.endpoints.DictionaryResponse;
import software.amazon.awssdk.opensearch.client.util.ObjectBuilder;

// typedef: ml.undeploy_model.Response

@JsonpDeserializable
@Generated("software.amazon.awssdk.opensearch.client.codegen.CodeGenerator")
public class UndeployModelResponse extends DictionaryResponse<String, UndeployModelNode> {
    // ---------------------------------------------------------------------------------------------

    private UndeployModelResponse(Builder builder) {
        super(builder);
    }

    public static UndeployModelResponse of(Function<UndeployModelResponse.Builder, ObjectBuilder<UndeployModelResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Builder for {@link UndeployModelResponse}.
     */
    public static class Builder extends DictionaryResponse.AbstractBuilder<String, UndeployModelNode, Builder>
        implements
            ObjectBuilder<UndeployModelResponse> {
        @Override
        @Nonnull
        protected Builder self() {
            return this;
        }

        /**
         * Builds a {@link UndeployModelResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public UndeployModelResponse build() {
            _checkSingleUse();
            super.tKeySerializer(null);
            super.tValueSerializer(null);

            return new UndeployModelResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link UndeployModelResponse}
     */
    public static final JsonpDeserializer<UndeployModelResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        UndeployModelResponse::setupUndeployModelResponseDeserializer
    );

    protected static void setupUndeployModelResponseDeserializer(ObjectDeserializer<UndeployModelResponse.Builder> op) {
        setupDictionaryResponseDeserializer(op, JsonpDeserializer.stringDeserializer(), UndeployModelNode._DESERIALIZER);
    }
}
