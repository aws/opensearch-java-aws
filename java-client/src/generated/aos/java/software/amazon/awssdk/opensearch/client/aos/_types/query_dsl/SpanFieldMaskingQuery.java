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

package software.amazon.awssdk.opensearch.client.aos._types.query_dsl;

import jakarta.json.stream.JsonGenerator;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import software.amazon.awssdk.opensearch.client.json.JsonpDeserializable;
import software.amazon.awssdk.opensearch.client.json.JsonpDeserializer;
import software.amazon.awssdk.opensearch.client.json.JsonpMapper;
import software.amazon.awssdk.opensearch.client.json.ObjectBuilderDeserializer;
import software.amazon.awssdk.opensearch.client.json.ObjectDeserializer;
import software.amazon.awssdk.opensearch.client.util.ApiTypeHelper;
import software.amazon.awssdk.opensearch.client.util.CopyableBuilder;
import software.amazon.awssdk.opensearch.client.util.ObjectBuilder;
import software.amazon.awssdk.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.query_dsl.SpanFieldMaskingQuery

@JsonpDeserializable
@Generated("software.amazon.awssdk.opensearch.client.codegen.CodeGenerator")
public class SpanFieldMaskingQuery extends QueryBase
    implements
        QueryVariant,
        SpanQueryVariant,
        ToCopyableBuilder<SpanFieldMaskingQuery.Builder, SpanFieldMaskingQuery> {

    @Nonnull
    private final String field;

    @Nonnull
    private final SpanQuery query;

    // ---------------------------------------------------------------------------------------------

    private SpanFieldMaskingQuery(Builder builder) {
        super(builder);
        this.field = ApiTypeHelper.requireNonNull(builder.field, this, "field");
        this.query = ApiTypeHelper.requireNonNull(builder.query, this, "query");
    }

    public static SpanFieldMaskingQuery of(Function<SpanFieldMaskingQuery.Builder, ObjectBuilder<SpanFieldMaskingQuery>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Query} variant kind.
     */
    @Override
    public Query.Kind _queryKind() {
        return Query.Kind.FieldMaskingSpan;
    }

    /**
     * {@link SpanQuery} variant kind.
     */
    @Override
    public SpanQuery.Kind _spanQueryKind() {
        return SpanQuery.Kind.FieldMaskingSpan;
    }

    /**
     * Required - API name: {@code field}
     */
    @Nonnull
    public final String field() {
        return this.field;
    }

    /**
     * Required - API name: {@code query}
     */
    @Nonnull
    public final SpanQuery query() {
        return this.query;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        generator.writeKey("field");
        generator.write(this.field);

        generator.writeKey("query");
        this.query.serialize(generator, mapper);
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
     * Builder for {@link SpanFieldMaskingQuery}.
     */
    public static class Builder extends QueryBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, SpanFieldMaskingQuery> {
        private String field;
        private SpanQuery query;

        public Builder() {}

        private Builder(SpanFieldMaskingQuery o) {
            super(o);
            this.field = o.field;
            this.query = o.query;
        }

        private Builder(Builder o) {
            super(o);
            this.field = o.field;
            this.query = o.query;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        @Override
        @Nonnull
        protected Builder self() {
            return this;
        }

        /**
         * Required - API name: {@code field}
         */
        @Nonnull
        public final Builder field(String value) {
            this.field = value;
            return this;
        }

        /**
         * Required - API name: {@code query}
         */
        @Nonnull
        public final Builder query(SpanQuery value) {
            this.query = value;
            return this;
        }

        /**
         * Required - API name: {@code query}
         */
        @Nonnull
        public final Builder query(Function<SpanQuery.Builder, ObjectBuilder<SpanQuery>> fn) {
            return query(fn.apply(new SpanQuery.Builder()).build());
        }

        /**
         * Builds a {@link SpanFieldMaskingQuery}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public SpanFieldMaskingQuery build() {
            _checkSingleUse();

            return new SpanFieldMaskingQuery(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link SpanFieldMaskingQuery}
     */
    public static final JsonpDeserializer<SpanFieldMaskingQuery> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        SpanFieldMaskingQuery::setupSpanFieldMaskingQueryDeserializer
    );

    protected static void setupSpanFieldMaskingQueryDeserializer(ObjectDeserializer<SpanFieldMaskingQuery.Builder> op) {
        setupQueryBaseDeserializer(op);
        op.add(Builder::field, JsonpDeserializer.stringDeserializer(), "field");
        op.add(Builder::query, SpanQuery._DESERIALIZER, "query");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + this.field.hashCode();
        result = 31 * result + this.query.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        SpanFieldMaskingQuery other = (SpanFieldMaskingQuery) o;
        return this.field.equals(other.field) && this.query.equals(other.query);
    }
}
