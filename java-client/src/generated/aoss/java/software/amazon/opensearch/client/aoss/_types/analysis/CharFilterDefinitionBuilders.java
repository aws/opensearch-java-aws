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

package software.amazon.opensearch.client.aoss._types.analysis;

import javax.annotation.Generated;

/**
 * <p>
 * Builders for {@link CharFilterDefinition} variants.
 * </p>
 * <p>
 * Variants <code>html_strip</code>, <code>icu_normalizer</code>, <code>kuromoji_iteration_mark</code>, <code>mapping</code>,
 * <code>pattern_replace</code> are not available here as they don't have a dedicated class. Use {@link CharFilterDefinition}'s builder for
 * these.
 * </p>
 */
@Generated("software.amazon.opensearch.client.codegen.CodeGenerator")
public class CharFilterDefinitionBuilders {
    private CharFilterDefinitionBuilders() {}

    /**
     * Creates a builder for the {@link HtmlStripCharFilter html_strip} {@code CharFilterDefinition} variant.
     */
    public static HtmlStripCharFilter.Builder htmlStrip() {
        return new HtmlStripCharFilter.Builder();
    }

    /**
     * Creates a builder for the {@link IcuNormalizationCharFilter icu_normalizer} {@code CharFilterDefinition} variant.
     */
    public static IcuNormalizationCharFilter.Builder icuNormalizer() {
        return new IcuNormalizationCharFilter.Builder();
    }

    /**
     * Creates a builder for the {@link KuromojiIterationMarkCharFilter kuromoji_iteration_mark} {@code CharFilterDefinition} variant.
     */
    public static KuromojiIterationMarkCharFilter.Builder kuromojiIterationMark() {
        return new KuromojiIterationMarkCharFilter.Builder();
    }

    /**
     * Creates a builder for the {@link MappingCharFilter mapping} {@code CharFilterDefinition} variant.
     */
    public static MappingCharFilter.Builder mapping() {
        return new MappingCharFilter.Builder();
    }

    /**
     * Creates a builder for the {@link PatternReplaceCharFilter pattern_replace} {@code CharFilterDefinition} variant.
     */
    public static PatternReplaceCharFilter.Builder patternReplace() {
        return new PatternReplaceCharFilter.Builder();
    }
}
