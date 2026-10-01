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
package software.amazon.opensearch.client.aos._types;

import jakarta.json.stream.JsonGenerator;
import java.util.function.Function;
import javax.annotation.Nullable;
import software.amazon.opensearch.client.json.JsonpDeserializable;
import software.amazon.opensearch.client.json.JsonpDeserializer;
import software.amazon.opensearch.client.json.JsonpMapper;
import software.amazon.opensearch.client.json.JsonpSerializable;
import software.amazon.opensearch.client.json.ObjectBuilderDeserializer;
import software.amazon.opensearch.client.json.ObjectDeserializer;
import software.amazon.opensearch.client.util.ObjectBuilder;
import software.amazon.opensearch.client.util.ObjectBuilderBase;

// typedef: _types.ScoreSort

@JsonpDeserializable
public class ScoreSort implements SortOptionsVariant, JsonpSerializable {
    @Nullable
    private final SortOrder order;

    // ---------------------------------------------------------------------------------------------

    private ScoreSort(Builder builder) {

        this.order = builder.order;

    }

    public static ScoreSort of(Function<Builder, ObjectBuilder<ScoreSort>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * SortOptions variant kind.
     */
    @Override
    public SortOptions.Kind _sortOptionsKind() {
        return SortOptions.Kind.Doc;
    }

    /**
     * API name: {@code order}
     */
    @Nullable
    public final SortOrder order() {
        return this.order;
    }

    /**
     * Serialize this object to JSON.
     */
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
        serializeInternal(generator, mapper);
        generator.writeEnd();
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {

        if (this.order != null) {
            generator.writeKey("order");
            this.order.serialize(generator, mapper);
        }

    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Builder for {@link ScoreSort}.
     */

    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<ScoreSort> {
        @Nullable
        private SortOrder order;

        /**
         * API name: {@code order}
         */
        public final Builder order(@Nullable SortOrder value) {
            this.order = value;
            return this;
        }

        /**
         * Builds a {@link ScoreSort}.
         *
         * @throws NullPointerException
         *             if some of the required fields are null.
         */
        public ScoreSort build() {
            _checkSingleUse();

            return new ScoreSort(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ScoreSort}
     */
    public static final JsonpDeserializer<ScoreSort> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ScoreSort::setupScoreSortDeserializer
    );

    protected static void setupScoreSortDeserializer(ObjectDeserializer<ScoreSort.Builder> op) {

        op.add(Builder::order, SortOrder._DESERIALIZER, "order");

    }

}
