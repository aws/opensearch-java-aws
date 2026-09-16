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

import javax.annotation.Generated;

/**
 * <p>
 * Builders for {@link SpanQuery} variants.
 * </p>
 * <p>
 * Variants <code>field_masking_span</code>, <code>span_containing</code>, <code>span_first</code>, <code>span_gap</code>,
 * <code>span_multi</code>, <code>span_near</code>, <code>span_not</code>, <code>span_or</code>, <code>span_term</code>,
 * <code>span_within</code> are not available here as they don't have a dedicated class. Use {@link SpanQuery}'s builder for these.
 * </p>
 */
@Generated("software.amazon.awssdk.opensearch.client.codegen.CodeGenerator")
public class SpanQueryBuilders {
    private SpanQueryBuilders() {}

    /**
     * Creates a builder for the {@link SpanFieldMaskingQuery field_masking_span} {@code SpanQuery} variant.
     */
    public static SpanFieldMaskingQuery.Builder fieldMaskingSpan() {
        return new SpanFieldMaskingQuery.Builder();
    }

    /**
     * Creates a builder for the {@link SpanContainingQuery span_containing} {@code SpanQuery} variant.
     */
    public static SpanContainingQuery.Builder spanContaining() {
        return new SpanContainingQuery.Builder();
    }

    /**
     * Creates a builder for the {@link SpanFirstQuery span_first} {@code SpanQuery} variant.
     */
    public static SpanFirstQuery.Builder spanFirst() {
        return new SpanFirstQuery.Builder();
    }

    /**
     * Creates a builder for the {@link SpanGapQuery span_gap} {@code SpanQuery} variant.
     */
    public static SpanGapQuery.Builder spanGap() {
        return new SpanGapQuery.Builder();
    }

    /**
     * Creates a builder for the {@link SpanMultiTermQuery span_multi} {@code SpanQuery} variant.
     */
    public static SpanMultiTermQuery.Builder spanMulti() {
        return new SpanMultiTermQuery.Builder();
    }

    /**
     * Creates a builder for the {@link SpanNearQuery span_near} {@code SpanQuery} variant.
     */
    public static SpanNearQuery.Builder spanNear() {
        return new SpanNearQuery.Builder();
    }

    /**
     * Creates a builder for the {@link SpanNotQuery span_not} {@code SpanQuery} variant.
     */
    public static SpanNotQuery.Builder spanNot() {
        return new SpanNotQuery.Builder();
    }

    /**
     * Creates a builder for the {@link SpanOrQuery span_or} {@code SpanQuery} variant.
     */
    public static SpanOrQuery.Builder spanOr() {
        return new SpanOrQuery.Builder();
    }

    /**
     * Creates a builder for the {@link SpanTermQuery span_term} {@code SpanQuery} variant.
     */
    public static SpanTermQuery.Builder spanTerm() {
        return new SpanTermQuery.Builder();
    }

    /**
     * Creates a builder for the {@link SpanWithinQuery span_within} {@code SpanQuery} variant.
     */
    public static SpanWithinQuery.Builder spanWithin() {
        return new SpanWithinQuery.Builder();
    }
}
