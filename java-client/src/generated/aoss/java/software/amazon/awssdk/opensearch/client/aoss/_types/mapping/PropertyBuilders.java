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

package software.amazon.awssdk.opensearch.client.aoss._types.mapping;

import javax.annotation.Generated;

/**
 * <p>
 * Builders for {@link Property} variants.
 * </p>
 * <p>
 * Variants <code>aggregate_metric_double</code>, <code>alias</code>, <code>binary</code>, <code>boolean</code>, <code>byte</code>,
 * <code>completion</code>, <code>constant_keyword</code>, <code>date</code>, <code>date_nanos</code>, <code>date_range</code>,
 * <code>double</code>, <code>double_range</code>, <code>flat_object</code>, <code>float</code>, <code>float_range</code>,
 * <code>geo_point</code>, <code>geo_shape</code>, <code>half_float</code>, <code>histogram</code>, <code>icu_collation_keyword</code>,
 * <code>integer</code>, <code>integer_range</code>, <code>ip</code>, <code>ip_range</code>, <code>join</code>, <code>keyword</code>,
 * <code>knn_vector</code>, <code>long</code>, <code>long_range</code>, <code>match_only_text</code>, <code>murmur3</code>,
 * <code>nested</code>, <code>object</code>, <code>percolator</code>, <code>rank_feature</code>, <code>rank_features</code>,
 * <code>scaled_float</code>, <code>search_as_you_type</code>, <code>semantic</code>, <code>short</code>, <code>text</code>,
 * <code>token_count</code>, <code>unsigned_long</code>, <code>version</code>, <code>wildcard</code>, <code>xy_point</code>,
 * <code>xy_shape</code> are not available here as they don't have a dedicated class. Use {@link Property}'s builder for these.
 * </p>
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class PropertyBuilders {
    private PropertyBuilders() {}

    /**
     * Creates a builder for the {@link AggregateMetricDoubleProperty aggregate_metric_double} {@code Property} variant.
     */
    public static AggregateMetricDoubleProperty.Builder aggregateMetricDouble() {
        return new AggregateMetricDoubleProperty.Builder();
    }

    /**
     * Creates a builder for the {@link FieldAliasProperty alias} {@code Property} variant.
     */
    public static FieldAliasProperty.Builder alias() {
        return new FieldAliasProperty.Builder();
    }

    /**
     * Creates a builder for the {@link BinaryProperty binary} {@code Property} variant.
     */
    public static BinaryProperty.Builder binary() {
        return new BinaryProperty.Builder();
    }

    /**
     * Creates a builder for the {@link BooleanProperty boolean} {@code Property} variant.
     */
    public static BooleanProperty.Builder boolean_() {
        return new BooleanProperty.Builder();
    }

    /**
     * Creates a builder for the {@link ByteNumberProperty byte} {@code Property} variant.
     */
    public static ByteNumberProperty.Builder byte_() {
        return new ByteNumberProperty.Builder();
    }

    /**
     * Creates a builder for the {@link CompletionProperty completion} {@code Property} variant.
     */
    public static CompletionProperty.Builder completion() {
        return new CompletionProperty.Builder();
    }

    /**
     * Creates a builder for the {@link ConstantKeywordProperty constant_keyword} {@code Property} variant.
     */
    public static ConstantKeywordProperty.Builder constantKeyword() {
        return new ConstantKeywordProperty.Builder();
    }

    /**
     * Creates a builder for the {@link DateProperty date} {@code Property} variant.
     */
    public static DateProperty.Builder date() {
        return new DateProperty.Builder();
    }

    /**
     * Creates a builder for the {@link DateNanosProperty date_nanos} {@code Property} variant.
     */
    public static DateNanosProperty.Builder dateNanos() {
        return new DateNanosProperty.Builder();
    }

    /**
     * Creates a builder for the {@link DateRangeProperty date_range} {@code Property} variant.
     */
    public static DateRangeProperty.Builder dateRange() {
        return new DateRangeProperty.Builder();
    }

    /**
     * Creates a builder for the {@link DoubleNumberProperty double} {@code Property} variant.
     */
    public static DoubleNumberProperty.Builder double_() {
        return new DoubleNumberProperty.Builder();
    }

    /**
     * Creates a builder for the {@link DoubleRangeProperty double_range} {@code Property} variant.
     */
    public static DoubleRangeProperty.Builder doubleRange() {
        return new DoubleRangeProperty.Builder();
    }

    /**
     * Creates a builder for the {@link FlatObjectProperty flat_object} {@code Property} variant.
     */
    public static FlatObjectProperty.Builder flatObject() {
        return new FlatObjectProperty.Builder();
    }

    /**
     * Creates a builder for the {@link FloatNumberProperty float} {@code Property} variant.
     */
    public static FloatNumberProperty.Builder float_() {
        return new FloatNumberProperty.Builder();
    }

    /**
     * Creates a builder for the {@link FloatRangeProperty float_range} {@code Property} variant.
     */
    public static FloatRangeProperty.Builder floatRange() {
        return new FloatRangeProperty.Builder();
    }

    /**
     * Creates a builder for the {@link GeoPointProperty geo_point} {@code Property} variant.
     */
    public static GeoPointProperty.Builder geoPoint() {
        return new GeoPointProperty.Builder();
    }

    /**
     * Creates a builder for the {@link GeoShapeProperty geo_shape} {@code Property} variant.
     */
    public static GeoShapeProperty.Builder geoShape() {
        return new GeoShapeProperty.Builder();
    }

    /**
     * Creates a builder for the {@link HalfFloatNumberProperty half_float} {@code Property} variant.
     */
    public static HalfFloatNumberProperty.Builder halfFloat() {
        return new HalfFloatNumberProperty.Builder();
    }

    /**
     * Creates a builder for the {@link HistogramProperty histogram} {@code Property} variant.
     */
    public static HistogramProperty.Builder histogram() {
        return new HistogramProperty.Builder();
    }

    /**
     * Creates a builder for the {@link IcuCollationKeywordProperty icu_collation_keyword} {@code Property} variant.
     */
    public static IcuCollationKeywordProperty.Builder icuCollationKeyword() {
        return new IcuCollationKeywordProperty.Builder();
    }

    /**
     * Creates a builder for the {@link IntegerNumberProperty integer} {@code Property} variant.
     */
    public static IntegerNumberProperty.Builder integer() {
        return new IntegerNumberProperty.Builder();
    }

    /**
     * Creates a builder for the {@link IntegerRangeProperty integer_range} {@code Property} variant.
     */
    public static IntegerRangeProperty.Builder integerRange() {
        return new IntegerRangeProperty.Builder();
    }

    /**
     * Creates a builder for the {@link IpProperty ip} {@code Property} variant.
     */
    public static IpProperty.Builder ip() {
        return new IpProperty.Builder();
    }

    /**
     * Creates a builder for the {@link IpRangeProperty ip_range} {@code Property} variant.
     */
    public static IpRangeProperty.Builder ipRange() {
        return new IpRangeProperty.Builder();
    }

    /**
     * Creates a builder for the {@link JoinProperty join} {@code Property} variant.
     */
    public static JoinProperty.Builder join() {
        return new JoinProperty.Builder();
    }

    /**
     * Creates a builder for the {@link KeywordProperty keyword} {@code Property} variant.
     */
    public static KeywordProperty.Builder keyword() {
        return new KeywordProperty.Builder();
    }

    /**
     * Creates a builder for the {@link KnnVectorProperty knn_vector} {@code Property} variant.
     */
    public static KnnVectorProperty.Builder knnVector() {
        return new KnnVectorProperty.Builder();
    }

    /**
     * Creates a builder for the {@link LongNumberProperty long} {@code Property} variant.
     */
    public static LongNumberProperty.Builder long_() {
        return new LongNumberProperty.Builder();
    }

    /**
     * Creates a builder for the {@link LongRangeProperty long_range} {@code Property} variant.
     */
    public static LongRangeProperty.Builder longRange() {
        return new LongRangeProperty.Builder();
    }

    /**
     * Creates a builder for the {@link MatchOnlyTextProperty match_only_text} {@code Property} variant.
     */
    public static MatchOnlyTextProperty.Builder matchOnlyText() {
        return new MatchOnlyTextProperty.Builder();
    }

    /**
     * Creates a builder for the {@link Murmur3HashProperty murmur3} {@code Property} variant.
     */
    public static Murmur3HashProperty.Builder murmur3() {
        return new Murmur3HashProperty.Builder();
    }

    /**
     * Creates a builder for the {@link NestedProperty nested} {@code Property} variant.
     */
    public static NestedProperty.Builder nested() {
        return new NestedProperty.Builder();
    }

    /**
     * Creates a builder for the {@link ObjectProperty object} {@code Property} variant.
     */
    public static ObjectProperty.Builder object() {
        return new ObjectProperty.Builder();
    }

    /**
     * Creates a builder for the {@link PercolatorProperty percolator} {@code Property} variant.
     */
    public static PercolatorProperty.Builder percolator() {
        return new PercolatorProperty.Builder();
    }

    /**
     * Creates a builder for the {@link RankFeatureProperty rank_feature} {@code Property} variant.
     */
    public static RankFeatureProperty.Builder rankFeature() {
        return new RankFeatureProperty.Builder();
    }

    /**
     * Creates a builder for the {@link RankFeaturesProperty rank_features} {@code Property} variant.
     */
    public static RankFeaturesProperty.Builder rankFeatures() {
        return new RankFeaturesProperty.Builder();
    }

    /**
     * Creates a builder for the {@link ScaledFloatNumberProperty scaled_float} {@code Property} variant.
     */
    public static ScaledFloatNumberProperty.Builder scaledFloat() {
        return new ScaledFloatNumberProperty.Builder();
    }

    /**
     * Creates a builder for the {@link SearchAsYouTypeProperty search_as_you_type} {@code Property} variant.
     */
    public static SearchAsYouTypeProperty.Builder searchAsYouType() {
        return new SearchAsYouTypeProperty.Builder();
    }

    /**
     * Creates a builder for the {@link SemanticProperty semantic} {@code Property} variant.
     */
    public static SemanticProperty.Builder semantic() {
        return new SemanticProperty.Builder();
    }

    /**
     * Creates a builder for the {@link ShortNumberProperty short} {@code Property} variant.
     */
    public static ShortNumberProperty.Builder short_() {
        return new ShortNumberProperty.Builder();
    }

    /**
     * Creates a builder for the {@link TextProperty text} {@code Property} variant.
     */
    public static TextProperty.Builder text() {
        return new TextProperty.Builder();
    }

    /**
     * Creates a builder for the {@link TokenCountProperty token_count} {@code Property} variant.
     */
    public static TokenCountProperty.Builder tokenCount() {
        return new TokenCountProperty.Builder();
    }

    /**
     * Creates a builder for the {@link UnsignedLongNumberProperty unsigned_long} {@code Property} variant.
     */
    public static UnsignedLongNumberProperty.Builder unsignedLong() {
        return new UnsignedLongNumberProperty.Builder();
    }

    /**
     * Creates a builder for the {@link VersionProperty version} {@code Property} variant.
     */
    public static VersionProperty.Builder version() {
        return new VersionProperty.Builder();
    }

    /**
     * Creates a builder for the {@link WildcardProperty wildcard} {@code Property} variant.
     */
    public static WildcardProperty.Builder wildcard() {
        return new WildcardProperty.Builder();
    }

    /**
     * Creates a builder for the {@link XyPointProperty xy_point} {@code Property} variant.
     */
    public static XyPointProperty.Builder xyPoint() {
        return new XyPointProperty.Builder();
    }

    /**
     * Creates a builder for the {@link XyShapeProperty xy_shape} {@code Property} variant.
     */
    public static XyShapeProperty.Builder xyShape() {
        return new XyShapeProperty.Builder();
    }
}
