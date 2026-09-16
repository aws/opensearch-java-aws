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

package software.amazon.awssdk.opensearch.client.aos.cold;

import jakarta.json.stream.JsonGenerator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import software.amazon.awssdk.opensearch.client.aos._types.DerivedField;
import software.amazon.awssdk.opensearch.client.aos._types.FieldValue;
import software.amazon.awssdk.opensearch.client.aos._types.RequestBase;
import software.amazon.awssdk.opensearch.client.aos._types.ScriptField;
import software.amazon.awssdk.opensearch.client.aos._types.SlicedScroll;
import software.amazon.awssdk.opensearch.client.aos._types.SortOptions;
import software.amazon.awssdk.opensearch.client.aos._types.aggregations.Aggregation;
import software.amazon.awssdk.opensearch.client.aos._types.query_dsl.FieldAndFormat;
import software.amazon.awssdk.opensearch.client.aos._types.query_dsl.Query;
import software.amazon.awssdk.opensearch.client.aos.core.search.FieldCollapse;
import software.amazon.awssdk.opensearch.client.aos.core.search.Highlight;
import software.amazon.awssdk.opensearch.client.aos.core.search.PointInTimeReference;
import software.amazon.awssdk.opensearch.client.aos.core.search.Rescore;
import software.amazon.awssdk.opensearch.client.aos.core.search.SourceConfig;
import software.amazon.awssdk.opensearch.client.aos.core.search.Suggester;
import software.amazon.awssdk.opensearch.client.aos.core.search.TrackHits;
import software.amazon.awssdk.opensearch.client.errors.ErrorResponse;
import software.amazon.awssdk.opensearch.client.json.JsonData;
import software.amazon.awssdk.opensearch.client.json.JsonpDeserializable;
import software.amazon.awssdk.opensearch.client.json.JsonpDeserializer;
import software.amazon.awssdk.opensearch.client.json.JsonpMapper;
import software.amazon.awssdk.opensearch.client.json.ObjectBuilderDeserializer;
import software.amazon.awssdk.opensearch.client.json.ObjectDeserializer;
import software.amazon.awssdk.opensearch.client.json.PlainJsonSerializable;
import software.amazon.awssdk.opensearch.client.transport.Endpoint;
import software.amazon.awssdk.opensearch.client.transport.endpoints.SimpleEndpoint;
import software.amazon.awssdk.opensearch.client.util.ApiTypeHelper;
import software.amazon.awssdk.opensearch.client.util.CopyableBuilder;
import software.amazon.awssdk.opensearch.client.util.ObjectBuilder;
import software.amazon.awssdk.opensearch.client.util.ToCopyableBuilder;

// typedef: cold.search.Request

/**
 * <p>
 * AOS only. Searches data stored in cold tier indices.
 * </p>
 * <p>
 * <strong>Minimum version:</strong> <code>1.0</code>
 * </p>
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public final class SearchRequest extends RequestBase
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<SearchRequest.Builder, SearchRequest> {

    @Nonnull
    private final Map<String, Aggregation> aggregations;

    @Nullable
    private final FieldCollapse collapse;

    @Nonnull
    private final Map<String, DerivedField> derived;

    @Nonnull
    private final List<FieldAndFormat> docvalueFields;

    @Nullable
    private final Boolean explain;

    @Nonnull
    private final Map<String, JsonData> ext;

    @Nonnull
    private final List<FieldAndFormat> fields;

    @Nullable
    private final Integer from;

    @Nullable
    private final Highlight highlight;

    @Nonnull
    private final List<Map<String, Float>> indicesBoost;

    @Nullable
    private final Float minScore;

    @Nullable
    private final PointInTimeReference pit;

    @Nullable
    private final Query postFilter;

    @Nullable
    private final Boolean profile;

    @Nullable
    private final Query query;

    @Nonnull
    private final List<Rescore> rescore;

    @Nonnull
    private final Map<String, ScriptField> scriptFields;

    @Nonnull
    private final List<FieldValue> searchAfter;

    @Nullable
    private final String searchPipeline;

    @Nullable
    private final Boolean seqNoPrimaryTerm;

    @Nullable
    private final Integer size;

    @Nullable
    private final SlicedScroll slice;

    @Nonnull
    private final List<SortOptions> sort;

    @Nullable
    private final SourceConfig source;

    @Nonnull
    private final List<String> stats;

    @Nonnull
    private final List<String> storedFields;

    @Nullable
    private final Suggester suggest;

    @Nullable
    private final Integer terminateAfter;

    @Nullable
    private final String timeout;

    @Nullable
    private final Boolean trackScores;

    @Nullable
    private final TrackHits trackTotalHits;

    @Nullable
    private final Boolean verbosePipeline;

    @Nullable
    private final Boolean version;

    // ---------------------------------------------------------------------------------------------

    private SearchRequest(Builder builder) {
        super(builder);
        this.aggregations = ApiTypeHelper.unmodifiable(builder.aggregations);
        this.collapse = builder.collapse;
        this.derived = ApiTypeHelper.unmodifiable(builder.derived);
        this.docvalueFields = ApiTypeHelper.unmodifiable(builder.docvalueFields);
        this.explain = builder.explain;
        this.ext = ApiTypeHelper.unmodifiable(builder.ext);
        this.fields = ApiTypeHelper.unmodifiable(builder.fields);
        this.from = builder.from;
        this.highlight = builder.highlight;
        this.indicesBoost = ApiTypeHelper.unmodifiable(builder.indicesBoost);
        this.minScore = builder.minScore;
        this.pit = builder.pit;
        this.postFilter = builder.postFilter;
        this.profile = builder.profile;
        this.query = builder.query;
        this.rescore = ApiTypeHelper.unmodifiable(builder.rescore);
        this.scriptFields = ApiTypeHelper.unmodifiable(builder.scriptFields);
        this.searchAfter = ApiTypeHelper.unmodifiable(builder.searchAfter);
        this.searchPipeline = builder.searchPipeline;
        this.seqNoPrimaryTerm = builder.seqNoPrimaryTerm;
        this.size = builder.size;
        this.slice = builder.slice;
        this.sort = ApiTypeHelper.unmodifiable(builder.sort);
        this.source = builder.source;
        this.stats = ApiTypeHelper.unmodifiable(builder.stats);
        this.storedFields = ApiTypeHelper.unmodifiable(builder.storedFields);
        this.suggest = builder.suggest;
        this.terminateAfter = builder.terminateAfter;
        this.timeout = builder.timeout;
        this.trackScores = builder.trackScores;
        this.trackTotalHits = builder.trackTotalHits;
        this.verbosePipeline = builder.verbosePipeline;
        this.version = builder.version;
    }

    public static SearchRequest of(Function<SearchRequest.Builder, ObjectBuilder<SearchRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Defines the aggregations that are run as part of the search request.
     * <p>
     * API name: {@code aggregations}
     * </p>
     */
    @Nonnull
    public final Map<String, Aggregation> aggregations() {
        return this.aggregations;
    }

    /**
     * API name: {@code collapse}
     */
    @Nullable
    public final FieldCollapse collapse() {
        return this.collapse;
    }

    /**
     * API name: {@code derived}
     */
    @Nonnull
    public final Map<String, DerivedField> derived() {
        return this.derived;
    }

    /**
     * Array of wildcard (<code>*</code>) patterns. The request returns doc values for field names matching these patterns in the
     * <code>hits.fields</code> property of the response.
     * <p>
     * API name: {@code docvalue_fields}
     * </p>
     */
    @Nonnull
    public final List<FieldAndFormat> docvalueFields() {
        return this.docvalueFields;
    }

    /**
     * If <code>true</code>, returns detailed information about score computation as part of a hit.
     * <p>
     * API name: {@code explain}
     * </p>
     */
    @Nullable
    public final Boolean explain() {
        return this.explain;
    }

    /**
     * Configuration of search extensions defined by OpenSearch plugins.
     * <p>
     * API name: {@code ext}
     * </p>
     */
    @Nonnull
    public final Map<String, JsonData> ext() {
        return this.ext;
    }

    /**
     * Array of wildcard (<code>*</code>) patterns. The request returns values for field names matching these patterns in the
     * <code>hits.fields</code> property of the response.
     * <p>
     * API name: {@code fields}
     * </p>
     */
    @Nonnull
    public final List<FieldAndFormat> fields() {
        return this.fields;
    }

    /**
     * Starting document offset. Needs to be non-negative. By default, you cannot page through more than 10,000 hits using the
     * <code>from</code> and <code>size</code> parameters. To page through more hits, use the <code>search_after</code> parameter.
     * <p>
     * API name: {@code from}
     * </p>
     */
    @Nullable
    public final Integer from() {
        return this.from;
    }

    /**
     * API name: {@code highlight}
     */
    @Nullable
    public final Highlight highlight() {
        return this.highlight;
    }

    /**
     * Boosts the <code>_score</code> of documents from specified indexes.
     * <p>
     * API name: {@code indices_boost}
     * </p>
     */
    @Nonnull
    public final List<Map<String, Float>> indicesBoost() {
        return this.indicesBoost;
    }

    /**
     * Minimum <code>_score</code> for matching documents. Documents with a lower <code>_score</code> are not included in the search
     * results.
     * <p>
     * API name: {@code min_score}
     * </p>
     */
    @Nullable
    public final Float minScore() {
        return this.minScore;
    }

    /**
     * API name: {@code pit}
     */
    @Nullable
    public final PointInTimeReference pit() {
        return this.pit;
    }

    /**
     * API name: {@code post_filter}
     */
    @Nullable
    public final Query postFilter() {
        return this.postFilter;
    }

    /**
     * Set to <code>true</code> to return detailed timing information about the execution of individual components in a search request.
     * NOTE: This is a debugging tool and adds significant overhead to search execution.
     * <p>
     * API name: {@code profile}
     * </p>
     */
    @Nullable
    public final Boolean profile() {
        return this.profile;
    }

    /**
     * API name: {@code query}
     */
    @Nullable
    public final Query query() {
        return this.query;
    }

    /**
     * Can be used to improve precision by reordering just the top (for example 100 - 500) documents returned by the <code>query</code> and
     * <code>post_filter</code> phases.
     * <p>
     * API name: {@code rescore}
     * </p>
     */
    @Nonnull
    public final List<Rescore> rescore() {
        return this.rescore;
    }

    /**
     * Retrieve a script evaluation (based on different fields) for each hit.
     * <p>
     * API name: {@code script_fields}
     * </p>
     */
    @Nonnull
    public final Map<String, ScriptField> scriptFields() {
        return this.scriptFields;
    }

    /**
     * API name: {@code search_after}
     */
    @Nonnull
    public final List<FieldValue> searchAfter() {
        return this.searchAfter;
    }

    /**
     * Customizable sequence of processing stages applied to search queries.
     * <p>
     * API name: {@code search_pipeline}
     * </p>
     */
    @Nullable
    public final String searchPipeline() {
        return this.searchPipeline;
    }

    /**
     * If <code>true</code>, returns sequence number and primary term of the last modification of each hit.
     * <p>
     * API name: {@code seq_no_primary_term}
     * </p>
     */
    @Nullable
    public final Boolean seqNoPrimaryTerm() {
        return this.seqNoPrimaryTerm;
    }

    /**
     * The number of hits to return. By default, you cannot page through more than 10,000 hits using the <code>from</code> and
     * <code>size</code> parameters. To page through more hits, use the <code>search_after</code> parameter.
     * <p>
     * API name: {@code size}
     * </p>
     */
    @Nullable
    public final Integer size() {
        return this.size;
    }

    /**
     * API name: {@code slice}
     */
    @Nullable
    public final SlicedScroll slice() {
        return this.slice;
    }

    /**
     * API name: {@code sort}
     */
    @Nonnull
    public final List<SortOptions> sort() {
        return this.sort;
    }

    /**
     * API name: {@code _source}
     */
    @Nullable
    public final SourceConfig source() {
        return this.source;
    }

    /**
     * Stats groups to associate with the search. Each group maintains a statistics aggregation for its associated searches. You can
     * retrieve these stats using the indexes stats API.
     * <p>
     * API name: {@code stats}
     * </p>
     */
    @Nonnull
    public final List<String> stats() {
        return this.stats;
    }

    /**
     * API name: {@code stored_fields}
     */
    @Nonnull
    public final List<String> storedFields() {
        return this.storedFields;
    }

    /**
     * API name: {@code suggest}
     */
    @Nullable
    public final Suggester suggest() {
        return this.suggest;
    }

    /**
     * Maximum number of documents to collect for each shard. If a query reaches this limit, OpenSearch terminates the query early.
     * OpenSearch collects documents before sorting. Use with caution. OpenSearch applies this parameter to each shard handling the request.
     * When possible, let OpenSearch perform early termination automatically. Avoid specifying this parameter for requests that target data
     * streams with backing indexes across multiple data tiers. If set to <code>0</code> (default), the query does not terminate early.
     * <p>
     * API name: {@code terminate_after}
     * </p>
     */
    @Nullable
    public final Integer terminateAfter() {
        return this.terminateAfter;
    }

    /**
     * Specifies the period of time to wait for a response from each shard. If no response is received before the timeout expires, the
     * request fails and returns an error. Defaults to no timeout.
     * <p>
     * API name: {@code timeout}
     * </p>
     */
    @Nullable
    public final String timeout() {
        return this.timeout;
    }

    /**
     * If <code>true</code>, calculate and return document scores, even if the scores are not used for sorting.
     * <p>
     * API name: {@code track_scores}
     * </p>
     */
    @Nullable
    public final Boolean trackScores() {
        return this.trackScores;
    }

    /**
     * API name: {@code track_total_hits}
     */
    @Nullable
    public final TrackHits trackTotalHits() {
        return this.trackTotalHits;
    }

    /**
     * Enables or disables verbose mode for the search pipeline.
     * <p>
     * API name: {@code verbose_pipeline}
     * </p>
     */
    @Nullable
    public final Boolean verbosePipeline() {
        return this.verbosePipeline;
    }

    /**
     * If <code>true</code>, returns document version as part of a hit.
     * <p>
     * API name: {@code version}
     * </p>
     */
    @Nullable
    public final Boolean version() {
        return this.version;
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
        if (ApiTypeHelper.isDefined(this.aggregations)) {
            generator.writeKey("aggregations");
            generator.writeStartObject();
            for (Map.Entry<String, Aggregation> item0 : this.aggregations.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.collapse != null) {
            generator.writeKey("collapse");
            this.collapse.serialize(generator, mapper);
        }

        if (ApiTypeHelper.isDefined(this.derived)) {
            generator.writeKey("derived");
            generator.writeStartObject();
            for (Map.Entry<String, DerivedField> item0 : this.derived.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.docvalueFields)) {
            generator.writeKey("docvalue_fields");
            generator.writeStartArray();
            for (FieldAndFormat item0 : this.docvalueFields) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.explain != null) {
            generator.writeKey("explain");
            generator.write(this.explain);
        }

        if (ApiTypeHelper.isDefined(this.ext)) {
            generator.writeKey("ext");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.ext.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.fields)) {
            generator.writeKey("fields");
            generator.writeStartArray();
            for (FieldAndFormat item0 : this.fields) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.from != null) {
            generator.writeKey("from");
            generator.write(this.from);
        }

        if (this.highlight != null) {
            generator.writeKey("highlight");
            this.highlight.serialize(generator, mapper);
        }

        if (ApiTypeHelper.isDefined(this.indicesBoost)) {
            generator.writeKey("indices_boost");
            generator.writeStartArray();
            for (Map<String, Float> item0 : this.indicesBoost) {
                generator.writeStartObject();
                if (item0 != null) {
                    for (Map.Entry<String, Float> item1 : item0.entrySet()) {
                        generator.writeKey(item1.getKey());
                        generator.write(item1.getValue());
                    }
                }
                generator.writeEnd();
            }
            generator.writeEnd();
        }

        if (this.minScore != null) {
            generator.writeKey("min_score");
            generator.write(this.minScore);
        }

        if (this.pit != null) {
            generator.writeKey("pit");
            this.pit.serialize(generator, mapper);
        }

        if (this.postFilter != null) {
            generator.writeKey("post_filter");
            this.postFilter.serialize(generator, mapper);
        }

        if (this.profile != null) {
            generator.writeKey("profile");
            generator.write(this.profile);
        }

        if (this.query != null) {
            generator.writeKey("query");
            this.query.serialize(generator, mapper);
        }

        if (ApiTypeHelper.isDefined(this.rescore)) {
            generator.writeKey("rescore");
            generator.writeStartArray();
            for (Rescore item0 : this.rescore) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.scriptFields)) {
            generator.writeKey("script_fields");
            generator.writeStartObject();
            for (Map.Entry<String, ScriptField> item0 : this.scriptFields.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.searchAfter)) {
            generator.writeKey("search_after");
            generator.writeStartArray();
            for (FieldValue item0 : this.searchAfter) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.searchPipeline != null) {
            generator.writeKey("search_pipeline");
            generator.write(this.searchPipeline);
        }

        if (this.seqNoPrimaryTerm != null) {
            generator.writeKey("seq_no_primary_term");
            generator.write(this.seqNoPrimaryTerm);
        }

        if (this.size != null) {
            generator.writeKey("size");
            generator.write(this.size);
        }

        if (this.slice != null) {
            generator.writeKey("slice");
            this.slice.serialize(generator, mapper);
        }

        if (ApiTypeHelper.isDefined(this.sort)) {
            generator.writeKey("sort");
            generator.writeStartArray();
            for (SortOptions item0 : this.sort) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.source != null) {
            generator.writeKey("_source");
            this.source.serialize(generator, mapper);
        }

        if (ApiTypeHelper.isDefined(this.stats)) {
            generator.writeKey("stats");
            generator.writeStartArray();
            for (String item0 : this.stats) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.storedFields)) {
            generator.writeKey("stored_fields");
            generator.writeStartArray();
            for (String item0 : this.storedFields) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (this.suggest != null) {
            generator.writeKey("suggest");
            this.suggest.serialize(generator, mapper);
        }

        if (this.terminateAfter != null) {
            generator.writeKey("terminate_after");
            generator.write(this.terminateAfter);
        }

        if (this.timeout != null) {
            generator.writeKey("timeout");
            generator.write(this.timeout);
        }

        if (this.trackScores != null) {
            generator.writeKey("track_scores");
            generator.write(this.trackScores);
        }

        if (this.trackTotalHits != null) {
            generator.writeKey("track_total_hits");
            this.trackTotalHits.serialize(generator, mapper);
        }

        if (this.verbosePipeline != null) {
            generator.writeKey("verbose_pipeline");
            generator.write(this.verbosePipeline);
        }

        if (this.version != null) {
            generator.writeKey("version");
            generator.write(this.version);
        }
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
     * Builder for {@link SearchRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, SearchRequest> {
        @Nullable
        private Map<String, Aggregation> aggregations;
        @Nullable
        private FieldCollapse collapse;
        @Nullable
        private Map<String, DerivedField> derived;
        @Nullable
        private List<FieldAndFormat> docvalueFields;
        @Nullable
        private Boolean explain;
        @Nullable
        private Map<String, JsonData> ext;
        @Nullable
        private List<FieldAndFormat> fields;
        @Nullable
        private Integer from;
        @Nullable
        private Highlight highlight;
        @Nullable
        private List<Map<String, Float>> indicesBoost;
        @Nullable
        private Float minScore;
        @Nullable
        private PointInTimeReference pit;
        @Nullable
        private Query postFilter;
        @Nullable
        private Boolean profile;
        @Nullable
        private Query query;
        @Nullable
        private List<Rescore> rescore;
        @Nullable
        private Map<String, ScriptField> scriptFields;
        @Nullable
        private List<FieldValue> searchAfter;
        @Nullable
        private String searchPipeline;
        @Nullable
        private Boolean seqNoPrimaryTerm;
        @Nullable
        private Integer size;
        @Nullable
        private SlicedScroll slice;
        @Nullable
        private List<SortOptions> sort;
        @Nullable
        private SourceConfig source;
        @Nullable
        private List<String> stats;
        @Nullable
        private List<String> storedFields;
        @Nullable
        private Suggester suggest;
        @Nullable
        private Integer terminateAfter;
        @Nullable
        private String timeout;
        @Nullable
        private Boolean trackScores;
        @Nullable
        private TrackHits trackTotalHits;
        @Nullable
        private Boolean verbosePipeline;
        @Nullable
        private Boolean version;

        public Builder() {}

        private Builder(SearchRequest o) {
            super(o);
            this.aggregations = _mapCopy(o.aggregations);
            this.collapse = o.collapse;
            this.derived = _mapCopy(o.derived);
            this.docvalueFields = _listCopy(o.docvalueFields);
            this.explain = o.explain;
            this.ext = _mapCopy(o.ext);
            this.fields = _listCopy(o.fields);
            this.from = o.from;
            this.highlight = o.highlight;
            this.indicesBoost = _listCopy(o.indicesBoost);
            this.minScore = o.minScore;
            this.pit = o.pit;
            this.postFilter = o.postFilter;
            this.profile = o.profile;
            this.query = o.query;
            this.rescore = _listCopy(o.rescore);
            this.scriptFields = _mapCopy(o.scriptFields);
            this.searchAfter = _listCopy(o.searchAfter);
            this.searchPipeline = o.searchPipeline;
            this.seqNoPrimaryTerm = o.seqNoPrimaryTerm;
            this.size = o.size;
            this.slice = o.slice;
            this.sort = _listCopy(o.sort);
            this.source = o.source;
            this.stats = _listCopy(o.stats);
            this.storedFields = _listCopy(o.storedFields);
            this.suggest = o.suggest;
            this.terminateAfter = o.terminateAfter;
            this.timeout = o.timeout;
            this.trackScores = o.trackScores;
            this.trackTotalHits = o.trackTotalHits;
            this.verbosePipeline = o.verbosePipeline;
            this.version = o.version;
        }

        private Builder(Builder o) {
            super(o);
            this.aggregations = _mapCopy(o.aggregations);
            this.collapse = o.collapse;
            this.derived = _mapCopy(o.derived);
            this.docvalueFields = _listCopy(o.docvalueFields);
            this.explain = o.explain;
            this.ext = _mapCopy(o.ext);
            this.fields = _listCopy(o.fields);
            this.from = o.from;
            this.highlight = o.highlight;
            this.indicesBoost = _listCopy(o.indicesBoost);
            this.minScore = o.minScore;
            this.pit = o.pit;
            this.postFilter = o.postFilter;
            this.profile = o.profile;
            this.query = o.query;
            this.rescore = _listCopy(o.rescore);
            this.scriptFields = _mapCopy(o.scriptFields);
            this.searchAfter = _listCopy(o.searchAfter);
            this.searchPipeline = o.searchPipeline;
            this.seqNoPrimaryTerm = o.seqNoPrimaryTerm;
            this.size = o.size;
            this.slice = o.slice;
            this.sort = _listCopy(o.sort);
            this.source = o.source;
            this.stats = _listCopy(o.stats);
            this.storedFields = _listCopy(o.storedFields);
            this.suggest = o.suggest;
            this.terminateAfter = o.terminateAfter;
            this.timeout = o.timeout;
            this.trackScores = o.trackScores;
            this.trackTotalHits = o.trackTotalHits;
            this.verbosePipeline = o.verbosePipeline;
            this.version = o.version;
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
         * Defines the aggregations that are run as part of the search request.
         * <p>
         * API name: {@code aggregations}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>aggregations</code>.
         * </p>
         */
        @Nonnull
        public final Builder aggregations(Map<String, Aggregation> map) {
            this.aggregations = _mapPutAll(this.aggregations, map);
            return this;
        }

        /**
         * Defines the aggregations that are run as part of the search request.
         * <p>
         * API name: {@code aggregations}
         * </p>
         *
         * <p>
         * Adds an entry to <code>aggregations</code>.
         * </p>
         */
        @Nonnull
        public final Builder aggregations(String key, Aggregation value) {
            this.aggregations = _mapPut(this.aggregations, key, value);
            return this;
        }

        /**
         * Defines the aggregations that are run as part of the search request.
         * <p>
         * API name: {@code aggregations}
         * </p>
         *
         * <p>
         * Adds a value to <code>aggregations</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder aggregations(String key, Function<Aggregation.Builder, ObjectBuilder<Aggregation>> fn) {
            return aggregations(key, fn.apply(new Aggregation.Builder()).build());
        }

        /**
         * API name: {@code collapse}
         */
        @Nonnull
        public final Builder collapse(@Nullable FieldCollapse value) {
            this.collapse = value;
            return this;
        }

        /**
         * API name: {@code collapse}
         */
        @Nonnull
        public final Builder collapse(Function<FieldCollapse.Builder, ObjectBuilder<FieldCollapse>> fn) {
            return collapse(fn.apply(new FieldCollapse.Builder()).build());
        }

        /**
         * API name: {@code derived}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>derived</code>.
         * </p>
         */
        @Nonnull
        public final Builder derived(Map<String, DerivedField> map) {
            this.derived = _mapPutAll(this.derived, map);
            return this;
        }

        /**
         * API name: {@code derived}
         *
         * <p>
         * Adds an entry to <code>derived</code>.
         * </p>
         */
        @Nonnull
        public final Builder derived(String key, DerivedField value) {
            this.derived = _mapPut(this.derived, key, value);
            return this;
        }

        /**
         * API name: {@code derived}
         *
         * <p>
         * Adds a value to <code>derived</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder derived(String key, Function<DerivedField.Builder, ObjectBuilder<DerivedField>> fn) {
            return derived(key, fn.apply(new DerivedField.Builder()).build());
        }

        /**
         * Array of wildcard (<code>*</code>) patterns. The request returns doc values for field names matching these patterns in the
         * <code>hits.fields</code> property of the response.
         * <p>
         * API name: {@code docvalue_fields}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>docvalueFields</code>.
         * </p>
         */
        @Nonnull
        public final Builder docvalueFields(List<FieldAndFormat> list) {
            this.docvalueFields = _listAddAll(this.docvalueFields, list);
            return this;
        }

        /**
         * Array of wildcard (<code>*</code>) patterns. The request returns doc values for field names matching these patterns in the
         * <code>hits.fields</code> property of the response.
         * <p>
         * API name: {@code docvalue_fields}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>docvalueFields</code>.
         * </p>
         */
        @Nonnull
        public final Builder docvalueFields(FieldAndFormat value, FieldAndFormat... values) {
            this.docvalueFields = _listAdd(this.docvalueFields, value, values);
            return this;
        }

        /**
         * Array of wildcard (<code>*</code>) patterns. The request returns doc values for field names matching these patterns in the
         * <code>hits.fields</code> property of the response.
         * <p>
         * API name: {@code docvalue_fields}
         * </p>
         *
         * <p>
         * Adds a value to <code>docvalueFields</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder docvalueFields(Function<FieldAndFormat.Builder, ObjectBuilder<FieldAndFormat>> fn) {
            return docvalueFields(fn.apply(new FieldAndFormat.Builder()).build());
        }

        /**
         * If <code>true</code>, returns detailed information about score computation as part of a hit.
         * <p>
         * API name: {@code explain}
         * </p>
         */
        @Nonnull
        public final Builder explain(@Nullable Boolean value) {
            this.explain = value;
            return this;
        }

        /**
         * Configuration of search extensions defined by OpenSearch plugins.
         * <p>
         * API name: {@code ext}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>ext</code>.
         * </p>
         */
        @Nonnull
        public final Builder ext(Map<String, JsonData> map) {
            this.ext = _mapPutAll(this.ext, map);
            return this;
        }

        /**
         * Configuration of search extensions defined by OpenSearch plugins.
         * <p>
         * API name: {@code ext}
         * </p>
         *
         * <p>
         * Adds an entry to <code>ext</code>.
         * </p>
         */
        @Nonnull
        public final Builder ext(String key, JsonData value) {
            this.ext = _mapPut(this.ext, key, value);
            return this;
        }

        /**
         * Array of wildcard (<code>*</code>) patterns. The request returns values for field names matching these patterns in the
         * <code>hits.fields</code> property of the response.
         * <p>
         * API name: {@code fields}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>fields</code>.
         * </p>
         */
        @Nonnull
        public final Builder fields(List<FieldAndFormat> list) {
            this.fields = _listAddAll(this.fields, list);
            return this;
        }

        /**
         * Array of wildcard (<code>*</code>) patterns. The request returns values for field names matching these patterns in the
         * <code>hits.fields</code> property of the response.
         * <p>
         * API name: {@code fields}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>fields</code>.
         * </p>
         */
        @Nonnull
        public final Builder fields(FieldAndFormat value, FieldAndFormat... values) {
            this.fields = _listAdd(this.fields, value, values);
            return this;
        }

        /**
         * Array of wildcard (<code>*</code>) patterns. The request returns values for field names matching these patterns in the
         * <code>hits.fields</code> property of the response.
         * <p>
         * API name: {@code fields}
         * </p>
         *
         * <p>
         * Adds a value to <code>fields</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder fields(Function<FieldAndFormat.Builder, ObjectBuilder<FieldAndFormat>> fn) {
            return fields(fn.apply(new FieldAndFormat.Builder()).build());
        }

        /**
         * Starting document offset. Needs to be non-negative. By default, you cannot page through more than 10,000 hits using the
         * <code>from</code> and <code>size</code> parameters. To page through more hits, use the <code>search_after</code> parameter.
         * <p>
         * API name: {@code from}
         * </p>
         */
        @Nonnull
        public final Builder from(@Nullable Integer value) {
            this.from = value;
            return this;
        }

        /**
         * API name: {@code highlight}
         */
        @Nonnull
        public final Builder highlight(@Nullable Highlight value) {
            this.highlight = value;
            return this;
        }

        /**
         * API name: {@code highlight}
         */
        @Nonnull
        public final Builder highlight(Function<Highlight.Builder, ObjectBuilder<Highlight>> fn) {
            return highlight(fn.apply(new Highlight.Builder()).build());
        }

        /**
         * Boosts the <code>_score</code> of documents from specified indexes.
         * <p>
         * API name: {@code indices_boost}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>indicesBoost</code>.
         * </p>
         */
        @Nonnull
        public final Builder indicesBoost(List<Map<String, Float>> list) {
            this.indicesBoost = _listAddAll(this.indicesBoost, list);
            return this;
        }

        /**
         * Boosts the <code>_score</code> of documents from specified indexes.
         * <p>
         * API name: {@code indices_boost}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>indicesBoost</code>.
         * </p>
         */
        @Nonnull
        public final Builder indicesBoost(Map<String, Float> value, Map<String, Float>... values) {
            this.indicesBoost = _listAdd(this.indicesBoost, value, values);
            return this;
        }

        /**
         * Minimum <code>_score</code> for matching documents. Documents with a lower <code>_score</code> are not included in the search
         * results.
         * <p>
         * API name: {@code min_score}
         * </p>
         */
        @Nonnull
        public final Builder minScore(@Nullable Float value) {
            this.minScore = value;
            return this;
        }

        /**
         * API name: {@code pit}
         */
        @Nonnull
        public final Builder pit(@Nullable PointInTimeReference value) {
            this.pit = value;
            return this;
        }

        /**
         * API name: {@code pit}
         */
        @Nonnull
        public final Builder pit(Function<PointInTimeReference.Builder, ObjectBuilder<PointInTimeReference>> fn) {
            return pit(fn.apply(new PointInTimeReference.Builder()).build());
        }

        /**
         * API name: {@code post_filter}
         */
        @Nonnull
        public final Builder postFilter(@Nullable Query value) {
            this.postFilter = value;
            return this;
        }

        /**
         * API name: {@code post_filter}
         */
        @Nonnull
        public final Builder postFilter(Function<Query.Builder, ObjectBuilder<Query>> fn) {
            return postFilter(fn.apply(new Query.Builder()).build());
        }

        /**
         * Set to <code>true</code> to return detailed timing information about the execution of individual components in a search request.
         * NOTE: This is a debugging tool and adds significant overhead to search execution.
         * <p>
         * API name: {@code profile}
         * </p>
         */
        @Nonnull
        public final Builder profile(@Nullable Boolean value) {
            this.profile = value;
            return this;
        }

        /**
         * API name: {@code query}
         */
        @Nonnull
        public final Builder query(@Nullable Query value) {
            this.query = value;
            return this;
        }

        /**
         * API name: {@code query}
         */
        @Nonnull
        public final Builder query(Function<Query.Builder, ObjectBuilder<Query>> fn) {
            return query(fn.apply(new Query.Builder()).build());
        }

        /**
         * Can be used to improve precision by reordering just the top (for example 100 - 500) documents returned by the <code>query</code>
         * and <code>post_filter</code> phases.
         * <p>
         * API name: {@code rescore}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>rescore</code>.
         * </p>
         */
        @Nonnull
        public final Builder rescore(List<Rescore> list) {
            this.rescore = _listAddAll(this.rescore, list);
            return this;
        }

        /**
         * Can be used to improve precision by reordering just the top (for example 100 - 500) documents returned by the <code>query</code>
         * and <code>post_filter</code> phases.
         * <p>
         * API name: {@code rescore}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>rescore</code>.
         * </p>
         */
        @Nonnull
        public final Builder rescore(Rescore value, Rescore... values) {
            this.rescore = _listAdd(this.rescore, value, values);
            return this;
        }

        /**
         * Can be used to improve precision by reordering just the top (for example 100 - 500) documents returned by the <code>query</code>
         * and <code>post_filter</code> phases.
         * <p>
         * API name: {@code rescore}
         * </p>
         *
         * <p>
         * Adds a value to <code>rescore</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder rescore(Function<Rescore.Builder, ObjectBuilder<Rescore>> fn) {
            return rescore(fn.apply(new Rescore.Builder()).build());
        }

        /**
         * Retrieve a script evaluation (based on different fields) for each hit.
         * <p>
         * API name: {@code script_fields}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>scriptFields</code>.
         * </p>
         */
        @Nonnull
        public final Builder scriptFields(Map<String, ScriptField> map) {
            this.scriptFields = _mapPutAll(this.scriptFields, map);
            return this;
        }

        /**
         * Retrieve a script evaluation (based on different fields) for each hit.
         * <p>
         * API name: {@code script_fields}
         * </p>
         *
         * <p>
         * Adds an entry to <code>scriptFields</code>.
         * </p>
         */
        @Nonnull
        public final Builder scriptFields(String key, ScriptField value) {
            this.scriptFields = _mapPut(this.scriptFields, key, value);
            return this;
        }

        /**
         * Retrieve a script evaluation (based on different fields) for each hit.
         * <p>
         * API name: {@code script_fields}
         * </p>
         *
         * <p>
         * Adds a value to <code>scriptFields</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder scriptFields(String key, Function<ScriptField.Builder, ObjectBuilder<ScriptField>> fn) {
            return scriptFields(key, fn.apply(new ScriptField.Builder()).build());
        }

        /**
         * API name: {@code search_after}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>searchAfter</code>.
         * </p>
         */
        @Nonnull
        public final Builder searchAfter(List<FieldValue> list) {
            this.searchAfter = _listAddAll(this.searchAfter, list);
            return this;
        }

        /**
         * API name: {@code search_after}
         *
         * <p>
         * Adds one or more values to <code>searchAfter</code>.
         * </p>
         */
        @Nonnull
        public final Builder searchAfter(FieldValue value, FieldValue... values) {
            this.searchAfter = _listAdd(this.searchAfter, value, values);
            return this;
        }

        /**
         * API name: {@code search_after}
         *
         * <p>
         * Adds a value to <code>searchAfter</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder searchAfter(Function<FieldValue.Builder, ObjectBuilder<FieldValue>> fn) {
            return searchAfter(fn.apply(new FieldValue.Builder()).build());
        }

        /**
         * Customizable sequence of processing stages applied to search queries.
         * <p>
         * API name: {@code search_pipeline}
         * </p>
         */
        @Nonnull
        public final Builder searchPipeline(@Nullable String value) {
            this.searchPipeline = value;
            return this;
        }

        /**
         * If <code>true</code>, returns sequence number and primary term of the last modification of each hit.
         * <p>
         * API name: {@code seq_no_primary_term}
         * </p>
         */
        @Nonnull
        public final Builder seqNoPrimaryTerm(@Nullable Boolean value) {
            this.seqNoPrimaryTerm = value;
            return this;
        }

        /**
         * The number of hits to return. By default, you cannot page through more than 10,000 hits using the <code>from</code> and
         * <code>size</code> parameters. To page through more hits, use the <code>search_after</code> parameter.
         * <p>
         * API name: {@code size}
         * </p>
         */
        @Nonnull
        public final Builder size(@Nullable Integer value) {
            this.size = value;
            return this;
        }

        /**
         * API name: {@code slice}
         */
        @Nonnull
        public final Builder slice(@Nullable SlicedScroll value) {
            this.slice = value;
            return this;
        }

        /**
         * API name: {@code slice}
         */
        @Nonnull
        public final Builder slice(Function<SlicedScroll.Builder, ObjectBuilder<SlicedScroll>> fn) {
            return slice(fn.apply(new SlicedScroll.Builder()).build());
        }

        /**
         * API name: {@code sort}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>sort</code>.
         * </p>
         */
        @Nonnull
        public final Builder sort(List<SortOptions> list) {
            this.sort = _listAddAll(this.sort, list);
            return this;
        }

        /**
         * API name: {@code sort}
         *
         * <p>
         * Adds one or more values to <code>sort</code>.
         * </p>
         */
        @Nonnull
        public final Builder sort(SortOptions value, SortOptions... values) {
            this.sort = _listAdd(this.sort, value, values);
            return this;
        }

        /**
         * API name: {@code sort}
         *
         * <p>
         * Adds a value to <code>sort</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder sort(Function<SortOptions.Builder, ObjectBuilder<SortOptions>> fn) {
            return sort(fn.apply(new SortOptions.Builder()).build());
        }

        /**
         * API name: {@code _source}
         */
        @Nonnull
        public final Builder source(@Nullable SourceConfig value) {
            this.source = value;
            return this;
        }

        /**
         * API name: {@code _source}
         */
        @Nonnull
        public final Builder source(Function<SourceConfig.Builder, ObjectBuilder<SourceConfig>> fn) {
            return source(fn.apply(new SourceConfig.Builder()).build());
        }

        /**
         * Stats groups to associate with the search. Each group maintains a statistics aggregation for its associated searches. You can
         * retrieve these stats using the indexes stats API.
         * <p>
         * API name: {@code stats}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>stats</code>.
         * </p>
         */
        @Nonnull
        public final Builder stats(List<String> list) {
            this.stats = _listAddAll(this.stats, list);
            return this;
        }

        /**
         * Stats groups to associate with the search. Each group maintains a statistics aggregation for its associated searches. You can
         * retrieve these stats using the indexes stats API.
         * <p>
         * API name: {@code stats}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>stats</code>.
         * </p>
         */
        @Nonnull
        public final Builder stats(String value, String... values) {
            this.stats = _listAdd(this.stats, value, values);
            return this;
        }

        /**
         * API name: {@code stored_fields}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>storedFields</code>.
         * </p>
         */
        @Nonnull
        public final Builder storedFields(List<String> list) {
            this.storedFields = _listAddAll(this.storedFields, list);
            return this;
        }

        /**
         * API name: {@code stored_fields}
         *
         * <p>
         * Adds one or more values to <code>storedFields</code>.
         * </p>
         */
        @Nonnull
        public final Builder storedFields(String value, String... values) {
            this.storedFields = _listAdd(this.storedFields, value, values);
            return this;
        }

        /**
         * API name: {@code suggest}
         */
        @Nonnull
        public final Builder suggest(@Nullable Suggester value) {
            this.suggest = value;
            return this;
        }

        /**
         * API name: {@code suggest}
         */
        @Nonnull
        public final Builder suggest(Function<Suggester.Builder, ObjectBuilder<Suggester>> fn) {
            return suggest(fn.apply(new Suggester.Builder()).build());
        }

        /**
         * Maximum number of documents to collect for each shard. If a query reaches this limit, OpenSearch terminates the query early.
         * OpenSearch collects documents before sorting. Use with caution. OpenSearch applies this parameter to each shard handling the
         * request. When possible, let OpenSearch perform early termination automatically. Avoid specifying this parameter for requests that
         * target data streams with backing indexes across multiple data tiers. If set to <code>0</code> (default), the query does not
         * terminate early.
         * <p>
         * API name: {@code terminate_after}
         * </p>
         */
        @Nonnull
        public final Builder terminateAfter(@Nullable Integer value) {
            this.terminateAfter = value;
            return this;
        }

        /**
         * Specifies the period of time to wait for a response from each shard. If no response is received before the timeout expires, the
         * request fails and returns an error. Defaults to no timeout.
         * <p>
         * API name: {@code timeout}
         * </p>
         */
        @Nonnull
        public final Builder timeout(@Nullable String value) {
            this.timeout = value;
            return this;
        }

        /**
         * If <code>true</code>, calculate and return document scores, even if the scores are not used for sorting.
         * <p>
         * API name: {@code track_scores}
         * </p>
         */
        @Nonnull
        public final Builder trackScores(@Nullable Boolean value) {
            this.trackScores = value;
            return this;
        }

        /**
         * API name: {@code track_total_hits}
         */
        @Nonnull
        public final Builder trackTotalHits(@Nullable TrackHits value) {
            this.trackTotalHits = value;
            return this;
        }

        /**
         * API name: {@code track_total_hits}
         */
        @Nonnull
        public final Builder trackTotalHits(Function<TrackHits.Builder, ObjectBuilder<TrackHits>> fn) {
            return trackTotalHits(fn.apply(new TrackHits.Builder()).build());
        }

        /**
         * Enables or disables verbose mode for the search pipeline.
         * <p>
         * API name: {@code verbose_pipeline}
         * </p>
         */
        @Nonnull
        public final Builder verbosePipeline(@Nullable Boolean value) {
            this.verbosePipeline = value;
            return this;
        }

        /**
         * If <code>true</code>, returns document version as part of a hit.
         * <p>
         * API name: {@code version}
         * </p>
         */
        @Nonnull
        public final Builder version(@Nullable Boolean value) {
            this.version = value;
            return this;
        }

        /**
         * Builds a {@link SearchRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public SearchRequest build() {
            _checkSingleUse();

            return new SearchRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link SearchRequest}
     */
    public static final JsonpDeserializer<SearchRequest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        SearchRequest::setupSearchRequestDeserializer
    );

    protected static void setupSearchRequestDeserializer(ObjectDeserializer<SearchRequest.Builder> op) {
        op.add(Builder::aggregations, JsonpDeserializer.stringMapDeserializer(Aggregation._DESERIALIZER), "aggregations", "aggs");
        op.add(Builder::collapse, FieldCollapse._DESERIALIZER, "collapse");
        op.add(Builder::derived, JsonpDeserializer.stringMapDeserializer(DerivedField._DESERIALIZER), "derived");
        op.add(Builder::docvalueFields, JsonpDeserializer.arrayDeserializer(FieldAndFormat._DESERIALIZER), "docvalue_fields");
        op.add(Builder::explain, JsonpDeserializer.booleanDeserializer(), "explain");
        op.add(Builder::ext, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "ext");
        op.add(Builder::fields, JsonpDeserializer.arrayDeserializer(FieldAndFormat._DESERIALIZER), "fields");
        op.add(Builder::from, JsonpDeserializer.integerDeserializer(), "from");
        op.add(Builder::highlight, Highlight._DESERIALIZER, "highlight");
        op.add(
            Builder::indicesBoost,
            JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringMapDeserializer(JsonpDeserializer.floatDeserializer())),
            "indices_boost"
        );
        op.add(Builder::minScore, JsonpDeserializer.floatDeserializer(), "min_score");
        op.add(Builder::pit, PointInTimeReference._DESERIALIZER, "pit");
        op.add(Builder::postFilter, Query._DESERIALIZER, "post_filter");
        op.add(Builder::profile, JsonpDeserializer.booleanDeserializer(), "profile");
        op.add(Builder::query, Query._DESERIALIZER, "query");
        op.add(Builder::rescore, JsonpDeserializer.arrayDeserializer(Rescore._DESERIALIZER), "rescore");
        op.add(Builder::scriptFields, JsonpDeserializer.stringMapDeserializer(ScriptField._DESERIALIZER), "script_fields");
        op.add(Builder::searchAfter, JsonpDeserializer.arrayDeserializer(FieldValue._DESERIALIZER), "search_after");
        op.add(Builder::searchPipeline, JsonpDeserializer.stringDeserializer(), "search_pipeline");
        op.add(Builder::seqNoPrimaryTerm, JsonpDeserializer.booleanDeserializer(), "seq_no_primary_term");
        op.add(Builder::size, JsonpDeserializer.integerDeserializer(), "size");
        op.add(Builder::slice, SlicedScroll._DESERIALIZER, "slice");
        op.add(Builder::sort, JsonpDeserializer.arrayDeserializer(SortOptions._DESERIALIZER), "sort");
        op.add(Builder::source, SourceConfig._DESERIALIZER, "_source");
        op.add(Builder::stats, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "stats");
        op.add(Builder::storedFields, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "stored_fields");
        op.add(Builder::suggest, Suggester._DESERIALIZER, "suggest");
        op.add(Builder::terminateAfter, JsonpDeserializer.integerDeserializer(), "terminate_after");
        op.add(Builder::timeout, JsonpDeserializer.stringDeserializer(), "timeout");
        op.add(Builder::trackScores, JsonpDeserializer.booleanDeserializer(), "track_scores");
        op.add(Builder::trackTotalHits, TrackHits._DESERIALIZER, "track_total_hits");
        op.add(Builder::verbosePipeline, JsonpDeserializer.booleanDeserializer(), "verbose_pipeline");
        op.add(Builder::version, JsonpDeserializer.booleanDeserializer(), "version");
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code cold.search}".
     */
    public static final SimpleEndpoint<SearchRequest, ?> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "POST",
        // Request path
        request -> "/_cold/indices/_search",
        // Request parameters
        request -> {
            Map<String, String> params = new HashMap<>();
            request.applyQueryParameters(params);
            return params;
        },
        SimpleEndpoint.emptyMap(),
        true,
        SearchResponse._DESERIALIZER
    );

    /**
     * Create an "{@code cold.search}" endpoint.
     */
    public static <TDocument> Endpoint<SearchRequest, SearchResponse<TDocument>, ErrorResponse> createColdSearchEndpoint(
        JsonpDeserializer<TDocument> tDocumentDeserializer
    ) {
        return _ENDPOINT.withResponseDeserializer(SearchResponse.createSearchResponseDeserializer(tDocumentDeserializer));
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.aggregations);
        result = 31 * result + Objects.hashCode(this.collapse);
        result = 31 * result + Objects.hashCode(this.derived);
        result = 31 * result + Objects.hashCode(this.docvalueFields);
        result = 31 * result + Objects.hashCode(this.explain);
        result = 31 * result + Objects.hashCode(this.ext);
        result = 31 * result + Objects.hashCode(this.fields);
        result = 31 * result + Objects.hashCode(this.from);
        result = 31 * result + Objects.hashCode(this.highlight);
        result = 31 * result + Objects.hashCode(this.indicesBoost);
        result = 31 * result + Objects.hashCode(this.minScore);
        result = 31 * result + Objects.hashCode(this.pit);
        result = 31 * result + Objects.hashCode(this.postFilter);
        result = 31 * result + Objects.hashCode(this.profile);
        result = 31 * result + Objects.hashCode(this.query);
        result = 31 * result + Objects.hashCode(this.rescore);
        result = 31 * result + Objects.hashCode(this.scriptFields);
        result = 31 * result + Objects.hashCode(this.searchAfter);
        result = 31 * result + Objects.hashCode(this.searchPipeline);
        result = 31 * result + Objects.hashCode(this.seqNoPrimaryTerm);
        result = 31 * result + Objects.hashCode(this.size);
        result = 31 * result + Objects.hashCode(this.slice);
        result = 31 * result + Objects.hashCode(this.sort);
        result = 31 * result + Objects.hashCode(this.source);
        result = 31 * result + Objects.hashCode(this.stats);
        result = 31 * result + Objects.hashCode(this.storedFields);
        result = 31 * result + Objects.hashCode(this.suggest);
        result = 31 * result + Objects.hashCode(this.terminateAfter);
        result = 31 * result + Objects.hashCode(this.timeout);
        result = 31 * result + Objects.hashCode(this.trackScores);
        result = 31 * result + Objects.hashCode(this.trackTotalHits);
        result = 31 * result + Objects.hashCode(this.verbosePipeline);
        result = 31 * result + Objects.hashCode(this.version);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        SearchRequest other = (SearchRequest) o;
        return Objects.equals(this.aggregations, other.aggregations)
            && Objects.equals(this.collapse, other.collapse)
            && Objects.equals(this.derived, other.derived)
            && Objects.equals(this.docvalueFields, other.docvalueFields)
            && Objects.equals(this.explain, other.explain)
            && Objects.equals(this.ext, other.ext)
            && Objects.equals(this.fields, other.fields)
            && Objects.equals(this.from, other.from)
            && Objects.equals(this.highlight, other.highlight)
            && Objects.equals(this.indicesBoost, other.indicesBoost)
            && Objects.equals(this.minScore, other.minScore)
            && Objects.equals(this.pit, other.pit)
            && Objects.equals(this.postFilter, other.postFilter)
            && Objects.equals(this.profile, other.profile)
            && Objects.equals(this.query, other.query)
            && Objects.equals(this.rescore, other.rescore)
            && Objects.equals(this.scriptFields, other.scriptFields)
            && Objects.equals(this.searchAfter, other.searchAfter)
            && Objects.equals(this.searchPipeline, other.searchPipeline)
            && Objects.equals(this.seqNoPrimaryTerm, other.seqNoPrimaryTerm)
            && Objects.equals(this.size, other.size)
            && Objects.equals(this.slice, other.slice)
            && Objects.equals(this.sort, other.sort)
            && Objects.equals(this.source, other.source)
            && Objects.equals(this.stats, other.stats)
            && Objects.equals(this.storedFields, other.storedFields)
            && Objects.equals(this.suggest, other.suggest)
            && Objects.equals(this.terminateAfter, other.terminateAfter)
            && Objects.equals(this.timeout, other.timeout)
            && Objects.equals(this.trackScores, other.trackScores)
            && Objects.equals(this.trackTotalHits, other.trackTotalHits)
            && Objects.equals(this.verbosePipeline, other.verbosePipeline)
            && Objects.equals(this.version, other.version);
    }
}
