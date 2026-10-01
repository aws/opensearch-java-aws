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
//----------------------------------------------------
// THIS CODE IS GENERATED. MANUAL EDITS WILL BE LOST.
//----------------------------------------------------

package software.amazon.opensearch.client.aos.indices;

import jakarta.json.stream.JsonGenerator;
import java.util.List;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import software.amazon.opensearch.client.aos.indices.get_index_template.IndexTemplateItem;
import software.amazon.opensearch.client.json.JsonpDeserializable;
import software.amazon.opensearch.client.json.JsonpDeserializer;
import software.amazon.opensearch.client.json.JsonpMapper;
import software.amazon.opensearch.client.json.ObjectBuilderDeserializer;
import software.amazon.opensearch.client.json.ObjectDeserializer;
import software.amazon.opensearch.client.json.PlainJsonSerializable;
import software.amazon.opensearch.client.util.ApiTypeHelper;
import software.amazon.opensearch.client.util.CopyableBuilder;
import software.amazon.opensearch.client.util.ObjectBuilder;
import software.amazon.opensearch.client.util.ObjectBuilderBase;
import software.amazon.opensearch.client.util.ToCopyableBuilder;

// typedef: indices.get_index_template.Response

@JsonpDeserializable
@Generated("software.amazon.opensearch.client.codegen.CodeGenerator")
public class GetIndexTemplateResponse
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<GetIndexTemplateResponse.Builder, GetIndexTemplateResponse> {

    @Nonnull
    private final List<IndexTemplateItem> indexTemplates;

    // ---------------------------------------------------------------------------------------------

    private GetIndexTemplateResponse(Builder builder) {
        this.indexTemplates = ApiTypeHelper.unmodifiableRequired(builder.indexTemplates, this, "indexTemplates");
    }

    public static GetIndexTemplateResponse of(Function<GetIndexTemplateResponse.Builder, ObjectBuilder<GetIndexTemplateResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code index_templates}
     */
    @Nonnull
    public final List<IndexTemplateItem> indexTemplates() {
        return this.indexTemplates;
    }

    /**
     * Serialize this object to JSON.
     */
    @Override
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
        serializeInternal(generator, mapper);
        generator.writeEnd();
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeKey("index_templates");
        generator.writeStartArray();
        for (IndexTemplateItem item0 : this.indexTemplates) {
            item0.serialize(generator, mapper);
        }
        generator.writeEnd();
    }

    // ---------------------------------------------------------------------------------------------

    @Override
    @Nonnull
    public Builder toBuilder() {
        return new Builder(this);
    }

    @Nonnull
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builder for {@link GetIndexTemplateResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, GetIndexTemplateResponse> {
        private List<IndexTemplateItem> indexTemplates;

        public Builder() {}

        private Builder(GetIndexTemplateResponse o) {
            this.indexTemplates = _listCopy(o.indexTemplates);
        }

        private Builder(Builder o) {
            this.indexTemplates = _listCopy(o.indexTemplates);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code index_templates}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>indexTemplates</code>.
         * </p>
         */
        @Nonnull
        public final Builder indexTemplates(List<IndexTemplateItem> list) {
            this.indexTemplates = _listAddAll(this.indexTemplates, list);
            return this;
        }

        /**
         * Required - API name: {@code index_templates}
         *
         * <p>
         * Adds one or more values to <code>indexTemplates</code>.
         * </p>
         */
        @Nonnull
        public final Builder indexTemplates(IndexTemplateItem value, IndexTemplateItem... values) {
            this.indexTemplates = _listAdd(this.indexTemplates, value, values);
            return this;
        }

        /**
         * Required - API name: {@code index_templates}
         *
         * <p>
         * Adds a value to <code>indexTemplates</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder indexTemplates(Function<IndexTemplateItem.Builder, ObjectBuilder<IndexTemplateItem>> fn) {
            return indexTemplates(fn.apply(new IndexTemplateItem.Builder()).build());
        }

        /**
         * Builds a {@link GetIndexTemplateResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GetIndexTemplateResponse build() {
            _checkSingleUse();

            return new GetIndexTemplateResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link GetIndexTemplateResponse}
     */
    public static final JsonpDeserializer<GetIndexTemplateResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        GetIndexTemplateResponse::setupGetIndexTemplateResponseDeserializer
    );

    protected static void setupGetIndexTemplateResponseDeserializer(ObjectDeserializer<GetIndexTemplateResponse.Builder> op) {
        op.add(Builder::indexTemplates, JsonpDeserializer.arrayDeserializer(IndexTemplateItem._DESERIALIZER), "index_templates");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.indexTemplates.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        GetIndexTemplateResponse other = (GetIndexTemplateResponse) o;
        return this.indexTemplates.equals(other.indexTemplates);
    }
}
