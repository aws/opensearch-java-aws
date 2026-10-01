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
package software.amazon.opensearch.client.aoss.core;

import java.util.function.Function;
import java.util.function.Supplier;
import software.amazon.opensearch.client.aoss.core.msearch.MultiSearchResult;
import software.amazon.opensearch.client.json.JsonpDeserializable;
import software.amazon.opensearch.client.json.JsonpDeserializer;
import software.amazon.opensearch.client.json.NamedDeserializer;
import software.amazon.opensearch.client.json.ObjectBuilderDeserializer;
import software.amazon.opensearch.client.json.ObjectDeserializer;
import software.amazon.opensearch.client.util.ObjectBuilder;

// typedef: _global.msearch.Response

@JsonpDeserializable
public class MsearchResponse<TDocument> extends MultiSearchResult<TDocument> {
    // ---------------------------------------------------------------------------------------------

    private MsearchResponse(Builder<TDocument> builder) {
        super(builder);

    }

    public static <TDocument> MsearchResponse<TDocument> of(Function<Builder<TDocument>, ObjectBuilder<MsearchResponse<TDocument>>> fn) {
        return fn.apply(new Builder<>()).build();
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Builder for {@link MsearchResponse}.
     */

    public static class Builder<TDocument> extends MultiSearchResult.AbstractBuilder<TDocument, Builder<TDocument>>
        implements
            ObjectBuilder<MsearchResponse<TDocument>> {
        @Override
        protected Builder<TDocument> self() {
            return this;
        }

        /**
         * Builds a {@link MsearchResponse}.
         *
         * @throws NullPointerException
         *             if some of the required fields are null.
         */
        public MsearchResponse<TDocument> build() {
            _checkSingleUse();

            return new MsearchResponse<TDocument>(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Create a JSON deserializer for MsearchResponse
     */
    public static <TDocument> JsonpDeserializer<MsearchResponse<TDocument>> createMsearchResponseDeserializer(
        JsonpDeserializer<TDocument> tDocumentDeserializer
    ) {
        return ObjectBuilderDeserializer.createForObject(
            (Supplier<Builder<TDocument>>) Builder::new,
            op -> MsearchResponse.setupMsearchResponseDeserializer(op, tDocumentDeserializer)
        );
    };

    /**
     * Json deserializer for {@link MsearchResponse} based on named deserializers
     * provided by the calling {@code JsonMapper}.
     */
    public static final JsonpDeserializer<MsearchResponse<Object>> _DESERIALIZER = createMsearchResponseDeserializer(
        new NamedDeserializer<>("software.amazon.opensearch.client:Deserializer:_global.msearch.TDocument")
    );

    protected static <TDocument> void setupMsearchResponseDeserializer(
        ObjectDeserializer<MsearchResponse.Builder<TDocument>> op,
        JsonpDeserializer<TDocument> tDocumentDeserializer
    ) {
        MultiSearchResult.setupMultiSearchResultDeserializer(op, tDocumentDeserializer);

    }

}
