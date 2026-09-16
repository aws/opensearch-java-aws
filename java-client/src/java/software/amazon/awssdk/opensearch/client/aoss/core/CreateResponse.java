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

/*
 * Licensed to Elasticsearch B.V. under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch B.V. licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

/*
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
 */
package software.amazon.awssdk.opensearch.client.aoss.core;

import java.util.function.Function;
import software.amazon.awssdk.opensearch.client.aoss._types.WriteResponseBase;
import software.amazon.awssdk.opensearch.client.json.JsonpDeserializable;
import software.amazon.awssdk.opensearch.client.json.JsonpDeserializer;
import software.amazon.awssdk.opensearch.client.json.ObjectBuilderDeserializer;
import software.amazon.awssdk.opensearch.client.json.ObjectDeserializer;
import software.amazon.awssdk.opensearch.client.util.ObjectBuilder;

// typedef: _global.create.Response

@JsonpDeserializable
public class CreateResponse extends WriteResponseBase {
    // ---------------------------------------------------------------------------------------------

    private CreateResponse(Builder builder) {
        super(builder);

    }

    public static CreateResponse of(Function<Builder, ObjectBuilder<CreateResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Builder for {@link CreateResponse}.
     */

    public static class Builder extends WriteResponseBase.AbstractBuilder<Builder> implements ObjectBuilder<CreateResponse> {
        @Override
        protected Builder self() {
            return this;
        }

        /**
         * Builds a {@link CreateResponse}.
         *
         * @throws NullPointerException
         *             if some of the required fields are null.
         */
        public CreateResponse build() {
            _checkSingleUse();

            return new CreateResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link CreateResponse}
     */
    public static final JsonpDeserializer<CreateResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        CreateResponse::setupCreateResponseDeserializer
    );

    protected static void setupCreateResponseDeserializer(ObjectDeserializer<CreateResponse.Builder> op) {
        WriteResponseBase.setupWriteResponseBaseDeserializer(op);

    }

}
