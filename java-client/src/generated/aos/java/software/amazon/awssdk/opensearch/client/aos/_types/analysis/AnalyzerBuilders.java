/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
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

package software.amazon.awssdk.opensearch.client.aos._types.analysis;

import javax.annotation.Generated;

/**
 * <p>
 * Builders for {@link Analyzer} variants.
 * </p>
 * <p>
 * Variants <code>cjk</code>, <code>custom</code>, <code>dutch</code>, <code>fingerprint</code>, <code>icu_analyzer</code>,
 * <code>keyword</code>, <code>kuromoji</code>, <code>language</code>, <code>nori</code>, <code>pattern</code>, <code>phone</code>,
 * <code>phone-search</code>, <code>simple</code>, <code>smartcn</code>, <code>snowball</code>, <code>standard</code>, <code>stop</code>,
 * <code>whitespace</code> are not available here as they don't have a dedicated class. Use {@link Analyzer}'s builder for these.
 * </p>
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class AnalyzerBuilders {
    private AnalyzerBuilders() {}

    /**
     * Creates a builder for the {@link CjkAnalyzer cjk} {@code Analyzer} variant.
     */
    public static CjkAnalyzer.Builder cjk() {
        return new CjkAnalyzer.Builder();
    }

    /**
     * Creates a builder for the {@link CustomAnalyzer custom} {@code Analyzer} variant.
     */
    public static CustomAnalyzer.Builder custom() {
        return new CustomAnalyzer.Builder();
    }

    /**
     * Creates a builder for the {@link DutchAnalyzer dutch} {@code Analyzer} variant.
     */
    public static DutchAnalyzer.Builder dutch() {
        return new DutchAnalyzer.Builder();
    }

    /**
     * Creates a builder for the {@link FingerprintAnalyzer fingerprint} {@code Analyzer} variant.
     */
    public static FingerprintAnalyzer.Builder fingerprint() {
        return new FingerprintAnalyzer.Builder();
    }

    /**
     * Creates a builder for the {@link IcuAnalyzer icu_analyzer} {@code Analyzer} variant.
     */
    public static IcuAnalyzer.Builder icuAnalyzer() {
        return new IcuAnalyzer.Builder();
    }

    /**
     * Creates a builder for the {@link KeywordAnalyzer keyword} {@code Analyzer} variant.
     */
    public static KeywordAnalyzer.Builder keyword() {
        return new KeywordAnalyzer.Builder();
    }

    /**
     * Creates a builder for the {@link KuromojiAnalyzer kuromoji} {@code Analyzer} variant.
     */
    public static KuromojiAnalyzer.Builder kuromoji() {
        return new KuromojiAnalyzer.Builder();
    }

    /**
     * Creates a builder for the {@link LanguageAnalyzer language} {@code Analyzer} variant.
     */
    public static LanguageAnalyzer.Builder language() {
        return new LanguageAnalyzer.Builder();
    }

    /**
     * Creates a builder for the {@link NoriAnalyzer nori} {@code Analyzer} variant.
     */
    public static NoriAnalyzer.Builder nori() {
        return new NoriAnalyzer.Builder();
    }

    /**
     * Creates a builder for the {@link PatternAnalyzer pattern} {@code Analyzer} variant.
     */
    public static PatternAnalyzer.Builder pattern() {
        return new PatternAnalyzer.Builder();
    }

    /**
     * Creates a builder for the {@link PhoneAnalyzer phone} {@code Analyzer} variant.
     */
    public static PhoneAnalyzer.Builder phone() {
        return new PhoneAnalyzer.Builder();
    }

    /**
     * Creates a builder for the {@link PhoneSearchAnalyzer phone-search} {@code Analyzer} variant.
     */
    public static PhoneSearchAnalyzer.Builder phoneSearch() {
        return new PhoneSearchAnalyzer.Builder();
    }

    /**
     * Creates a builder for the {@link SimpleAnalyzer simple} {@code Analyzer} variant.
     */
    public static SimpleAnalyzer.Builder simple() {
        return new SimpleAnalyzer.Builder();
    }

    /**
     * Creates a builder for the {@link SmartcnAnalyzer smartcn} {@code Analyzer} variant.
     */
    public static SmartcnAnalyzer.Builder smartcn() {
        return new SmartcnAnalyzer.Builder();
    }

    /**
     * Creates a builder for the {@link SnowballAnalyzer snowball} {@code Analyzer} variant.
     */
    public static SnowballAnalyzer.Builder snowball() {
        return new SnowballAnalyzer.Builder();
    }

    /**
     * Creates a builder for the {@link StandardAnalyzer standard} {@code Analyzer} variant.
     */
    public static StandardAnalyzer.Builder standard() {
        return new StandardAnalyzer.Builder();
    }

    /**
     * Creates a builder for the {@link StopAnalyzer stop} {@code Analyzer} variant.
     */
    public static StopAnalyzer.Builder stop() {
        return new StopAnalyzer.Builder();
    }

    /**
     * Creates a builder for the {@link WhitespaceAnalyzer whitespace} {@code Analyzer} variant.
     */
    public static WhitespaceAnalyzer.Builder whitespace() {
        return new WhitespaceAnalyzer.Builder();
    }
}
