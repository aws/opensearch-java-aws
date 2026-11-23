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

package software.amazon.opensearch.client.aos.search_relevance;

import jakarta.json.stream.JsonGenerator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import software.amazon.opensearch.client.aos._types.RequestBase;
import software.amazon.opensearch.client.errors.ErrorResponse;
import software.amazon.opensearch.client.json.JsonData;
import software.amazon.opensearch.client.json.JsonpDeserializable;
import software.amazon.opensearch.client.json.JsonpDeserializer;
import software.amazon.opensearch.client.json.JsonpMapper;
import software.amazon.opensearch.client.json.ObjectBuilderDeserializer;
import software.amazon.opensearch.client.json.ObjectDeserializer;
import software.amazon.opensearch.client.json.PlainJsonSerializable;
import software.amazon.opensearch.client.transport.Endpoint;
import software.amazon.opensearch.client.transport.endpoints.SimpleEndpoint;
import software.amazon.opensearch.client.util.ApiTypeHelper;
import software.amazon.opensearch.client.util.CopyableBuilder;
import software.amazon.opensearch.client.util.ObjectBuilder;
import software.amazon.opensearch.client.util.ToCopyableBuilder;

// typedef: search_relevance.put_judgments.Request

/**
 * Creates a judgment.
 */
@JsonpDeserializable
@Generated("software.amazon.opensearch.client.codegen.CodeGenerator")
public final class PutJudgmentsRequest extends RequestBase
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<PutJudgmentsRequest.Builder, PutJudgmentsRequest> {

    @Nullable
    private final String clickModel;

    @Nonnull
    private final List<String> contextFields;

    @Nullable
    private final String description;

    @Nullable
    private final String endDate;

    @Nullable
    private final Boolean ignoreFailure;

    @Nonnull
    private final List<Map<String, JsonData>> judgmentRatings;

    @Nullable
    private final LLMJudgmentRatingType llmJudgmentRatingType;

    @Nullable
    private final Integer maxRank;

    @Nullable
    private final String modelId;

    @Nonnull
    private final String name;

    @Nullable
    private final Boolean overwriteCache;

    @Nullable
    private final String promptTemplate;

    @Nullable
    private final String querySetId;

    @Nonnull
    private final List<String> searchConfigurationList;

    @Nullable
    private final Integer size;

    @Nullable
    private final String startDate;

    @Nullable
    private final Integer tokenLimit;

    @Nonnull
    private final String type;

    @Nullable
    private final String ubiEventsIndex;

    // ---------------------------------------------------------------------------------------------

    private PutJudgmentsRequest(Builder builder) {
        super(builder);
        this.clickModel = builder.clickModel;
        this.contextFields = ApiTypeHelper.unmodifiable(builder.contextFields);
        this.description = builder.description;
        this.endDate = builder.endDate;
        this.ignoreFailure = builder.ignoreFailure;
        this.judgmentRatings = ApiTypeHelper.unmodifiable(builder.judgmentRatings);
        this.llmJudgmentRatingType = builder.llmJudgmentRatingType;
        this.maxRank = builder.maxRank;
        this.modelId = builder.modelId;
        this.name = ApiTypeHelper.requireNonNull(builder.name, this, "name");
        this.overwriteCache = builder.overwriteCache;
        this.promptTemplate = builder.promptTemplate;
        this.querySetId = builder.querySetId;
        this.searchConfigurationList = ApiTypeHelper.unmodifiable(builder.searchConfigurationList);
        this.size = builder.size;
        this.startDate = builder.startDate;
        this.tokenLimit = builder.tokenLimit;
        this.type = ApiTypeHelper.requireNonNull(builder.type, this, "type");
        this.ubiEventsIndex = builder.ubiEventsIndex;
    }

    public static PutJudgmentsRequest of(Function<PutJudgmentsRequest.Builder, ObjectBuilder<PutJudgmentsRequest>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code clickModel}
     */
    @Nullable
    public final String clickModel() {
        return this.clickModel;
    }

    /**
     * API name: {@code contextFields}
     */
    @Nonnull
    public final List<String> contextFields() {
        return this.contextFields;
    }

    /**
     * API name: {@code description}
     */
    @Nullable
    public final String description() {
        return this.description;
    }

    /**
     * The end of the UBI events date range (inclusive).
     * <p>
     * API name: {@code endDate}
     * </p>
     */
    @Nullable
    public final String endDate() {
        return this.endDate;
    }

    /**
     * Whether to continue when individual documents fail to be rated. Defaults to <code>false</code>.
     * <p>
     * API name: {@code ignoreFailure}
     * </p>
     */
    @Nullable
    public final Boolean ignoreFailure() {
        return this.ignoreFailure;
    }

    /**
     * API name: {@code judgmentRatings}
     */
    @Nonnull
    public final List<Map<String, JsonData>> judgmentRatings() {
        return this.judgmentRatings;
    }

    /**
     * API name: {@code llmJudgmentRatingType}
     */
    @Nullable
    public final LLMJudgmentRatingType llmJudgmentRatingType() {
        return this.llmJudgmentRatingType;
    }

    /**
     * API name: {@code maxRank}
     */
    @Nullable
    public final Integer maxRank() {
        return this.maxRank;
    }

    /**
     * API name: {@code modelId}
     */
    @Nullable
    public final String modelId() {
        return this.modelId;
    }

    /**
     * Required - API name: {@code name}
     */
    @Nonnull
    public final String name() {
        return this.name;
    }

    /**
     * Deprecated and ignored. The global judgment cache was removed; use <code>existingJudgments</code> to reuse ratings or the
     * <code>_retry</code> endpoint to re-score failed documents.
     * <p>
     * API name: {@code overwriteCache}
     * </p>
     */
    @Nullable
    public final Boolean overwriteCache() {
        return this.overwriteCache;
    }

    /**
     * The prompt template to use. Must contain a <code>{{hits}}</code> or <code>{{results}}</code> placeholder and a
     * <code>{{queryText}}</code> or <code>{{searchText}}</code> placeholder. A default template is used when omitted.
     * <p>
     * API name: {@code promptTemplate}
     * </p>
     */
    @Nullable
    public final String promptTemplate() {
        return this.promptTemplate;
    }

    /**
     * API name: {@code querySetId}
     */
    @Nullable
    public final String querySetId() {
        return this.querySetId;
    }

    /**
     * API name: {@code searchConfigurationList}
     */
    @Nonnull
    public final List<String> searchConfigurationList() {
        return this.searchConfigurationList;
    }

    /**
     * API name: {@code size}
     */
    @Nullable
    public final Integer size() {
        return this.size;
    }

    /**
     * The start of the UBI events date range (inclusive).
     * <p>
     * API name: {@code startDate}
     * </p>
     */
    @Nullable
    public final String startDate() {
        return this.startDate;
    }

    /**
     * The maximum number of tokens allowed for the LLM prompt. Defaults to 4000.
     * <p>
     * API name: {@code tokenLimit}
     * </p>
     */
    @Nullable
    public final Integer tokenLimit() {
        return this.tokenLimit;
    }

    /**
     * Required - API name: {@code type}
     */
    @Nonnull
    public final String type() {
        return this.type;
    }

    /**
     * The name of the UBI events index to source click data from.
     * <p>
     * API name: {@code ubiEventsIndex}
     * </p>
     */
    @Nullable
    public final String ubiEventsIndex() {
        return this.ubiEventsIndex;
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
        if (this.clickModel != null) {
            generator.writeKey("clickModel");
            generator.write(this.clickModel);
        }

        if (ApiTypeHelper.isDefined(this.contextFields)) {
            generator.writeKey("contextFields");
            generator.writeStartArray();
            for (String item0 : this.contextFields) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (this.description != null) {
            generator.writeKey("description");
            generator.write(this.description);
        }

        if (this.endDate != null) {
            generator.writeKey("endDate");
            generator.write(this.endDate);
        }

        if (this.ignoreFailure != null) {
            generator.writeKey("ignoreFailure");
            generator.write(this.ignoreFailure);
        }

        if (ApiTypeHelper.isDefined(this.judgmentRatings)) {
            generator.writeKey("judgmentRatings");
            generator.writeStartArray();
            for (Map<String, JsonData> item0 : this.judgmentRatings) {
                generator.writeStartObject();
                if (item0 != null) {
                    for (Map.Entry<String, JsonData> item1 : item0.entrySet()) {
                        generator.writeKey(item1.getKey());
                        item1.getValue().serialize(generator, mapper);
                    }
                }
                generator.writeEnd();
            }
            generator.writeEnd();
        }

        if (this.llmJudgmentRatingType != null) {
            generator.writeKey("llmJudgmentRatingType");
            this.llmJudgmentRatingType.serialize(generator, mapper);
        }

        if (this.maxRank != null) {
            generator.writeKey("maxRank");
            generator.write(this.maxRank);
        }

        if (this.modelId != null) {
            generator.writeKey("modelId");
            generator.write(this.modelId);
        }

        generator.writeKey("name");
        generator.write(this.name);

        if (this.overwriteCache != null) {
            generator.writeKey("overwriteCache");
            generator.write(this.overwriteCache);
        }

        if (this.promptTemplate != null) {
            generator.writeKey("promptTemplate");
            generator.write(this.promptTemplate);
        }

        if (this.querySetId != null) {
            generator.writeKey("querySetId");
            generator.write(this.querySetId);
        }

        if (ApiTypeHelper.isDefined(this.searchConfigurationList)) {
            generator.writeKey("searchConfigurationList");
            generator.writeStartArray();
            for (String item0 : this.searchConfigurationList) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (this.size != null) {
            generator.writeKey("size");
            generator.write(this.size);
        }

        if (this.startDate != null) {
            generator.writeKey("startDate");
            generator.write(this.startDate);
        }

        if (this.tokenLimit != null) {
            generator.writeKey("tokenLimit");
            generator.write(this.tokenLimit);
        }

        generator.writeKey("type");
        generator.write(this.type);

        if (this.ubiEventsIndex != null) {
            generator.writeKey("ubiEventsIndex");
            generator.write(this.ubiEventsIndex);
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
     * Builder for {@link PutJudgmentsRequest}.
     */
    public static class Builder extends RequestBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, PutJudgmentsRequest> {
        @Nullable
        private String clickModel;
        @Nullable
        private List<String> contextFields;
        @Nullable
        private String description;
        @Nullable
        private String endDate;
        @Nullable
        private Boolean ignoreFailure;
        @Nullable
        private List<Map<String, JsonData>> judgmentRatings;
        @Nullable
        private LLMJudgmentRatingType llmJudgmentRatingType;
        @Nullable
        private Integer maxRank;
        @Nullable
        private String modelId;
        private String name;
        @Nullable
        private Boolean overwriteCache;
        @Nullable
        private String promptTemplate;
        @Nullable
        private String querySetId;
        @Nullable
        private List<String> searchConfigurationList;
        @Nullable
        private Integer size;
        @Nullable
        private String startDate;
        @Nullable
        private Integer tokenLimit;
        private String type;
        @Nullable
        private String ubiEventsIndex;

        public Builder() {}

        private Builder(PutJudgmentsRequest o) {
            super(o);
            this.clickModel = o.clickModel;
            this.contextFields = _listCopy(o.contextFields);
            this.description = o.description;
            this.endDate = o.endDate;
            this.ignoreFailure = o.ignoreFailure;
            this.judgmentRatings = _listCopy(o.judgmentRatings);
            this.llmJudgmentRatingType = o.llmJudgmentRatingType;
            this.maxRank = o.maxRank;
            this.modelId = o.modelId;
            this.name = o.name;
            this.overwriteCache = o.overwriteCache;
            this.promptTemplate = o.promptTemplate;
            this.querySetId = o.querySetId;
            this.searchConfigurationList = _listCopy(o.searchConfigurationList);
            this.size = o.size;
            this.startDate = o.startDate;
            this.tokenLimit = o.tokenLimit;
            this.type = o.type;
            this.ubiEventsIndex = o.ubiEventsIndex;
        }

        private Builder(Builder o) {
            super(o);
            this.clickModel = o.clickModel;
            this.contextFields = _listCopy(o.contextFields);
            this.description = o.description;
            this.endDate = o.endDate;
            this.ignoreFailure = o.ignoreFailure;
            this.judgmentRatings = _listCopy(o.judgmentRatings);
            this.llmJudgmentRatingType = o.llmJudgmentRatingType;
            this.maxRank = o.maxRank;
            this.modelId = o.modelId;
            this.name = o.name;
            this.overwriteCache = o.overwriteCache;
            this.promptTemplate = o.promptTemplate;
            this.querySetId = o.querySetId;
            this.searchConfigurationList = _listCopy(o.searchConfigurationList);
            this.size = o.size;
            this.startDate = o.startDate;
            this.tokenLimit = o.tokenLimit;
            this.type = o.type;
            this.ubiEventsIndex = o.ubiEventsIndex;
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
         * API name: {@code clickModel}
         */
        @Nonnull
        public final Builder clickModel(@Nullable String value) {
            this.clickModel = value;
            return this;
        }

        /**
         * API name: {@code contextFields}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>contextFields</code>.
         * </p>
         */
        @Nonnull
        public final Builder contextFields(List<String> list) {
            this.contextFields = _listAddAll(this.contextFields, list);
            return this;
        }

        /**
         * API name: {@code contextFields}
         *
         * <p>
         * Adds one or more values to <code>contextFields</code>.
         * </p>
         */
        @Nonnull
        public final Builder contextFields(String value, String... values) {
            this.contextFields = _listAdd(this.contextFields, value, values);
            return this;
        }

        /**
         * API name: {@code description}
         */
        @Nonnull
        public final Builder description(@Nullable String value) {
            this.description = value;
            return this;
        }

        /**
         * The end of the UBI events date range (inclusive).
         * <p>
         * API name: {@code endDate}
         * </p>
         */
        @Nonnull
        public final Builder endDate(@Nullable String value) {
            this.endDate = value;
            return this;
        }

        /**
         * Whether to continue when individual documents fail to be rated. Defaults to <code>false</code>.
         * <p>
         * API name: {@code ignoreFailure}
         * </p>
         */
        @Nonnull
        public final Builder ignoreFailure(@Nullable Boolean value) {
            this.ignoreFailure = value;
            return this;
        }

        /**
         * API name: {@code judgmentRatings}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>judgmentRatings</code>.
         * </p>
         */
        @Nonnull
        public final Builder judgmentRatings(List<Map<String, JsonData>> list) {
            this.judgmentRatings = _listAddAll(this.judgmentRatings, list);
            return this;
        }

        /**
         * API name: {@code judgmentRatings}
         *
         * <p>
         * Adds one or more values to <code>judgmentRatings</code>.
         * </p>
         */
        @Nonnull
        public final Builder judgmentRatings(Map<String, JsonData> value, Map<String, JsonData>... values) {
            this.judgmentRatings = _listAdd(this.judgmentRatings, value, values);
            return this;
        }

        /**
         * API name: {@code llmJudgmentRatingType}
         */
        @Nonnull
        public final Builder llmJudgmentRatingType(@Nullable LLMJudgmentRatingType value) {
            this.llmJudgmentRatingType = value;
            return this;
        }

        /**
         * API name: {@code maxRank}
         */
        @Nonnull
        public final Builder maxRank(@Nullable Integer value) {
            this.maxRank = value;
            return this;
        }

        /**
         * API name: {@code modelId}
         */
        @Nonnull
        public final Builder modelId(@Nullable String value) {
            this.modelId = value;
            return this;
        }

        /**
         * Required - API name: {@code name}
         */
        @Nonnull
        public final Builder name(String value) {
            this.name = value;
            return this;
        }

        /**
         * Deprecated and ignored. The global judgment cache was removed; use <code>existingJudgments</code> to reuse ratings or the
         * <code>_retry</code> endpoint to re-score failed documents.
         * <p>
         * API name: {@code overwriteCache}
         * </p>
         */
        @Nonnull
        public final Builder overwriteCache(@Nullable Boolean value) {
            this.overwriteCache = value;
            return this;
        }

        /**
         * The prompt template to use. Must contain a <code>{{hits}}</code> or <code>{{results}}</code> placeholder and a
         * <code>{{queryText}}</code> or <code>{{searchText}}</code> placeholder. A default template is used when omitted.
         * <p>
         * API name: {@code promptTemplate}
         * </p>
         */
        @Nonnull
        public final Builder promptTemplate(@Nullable String value) {
            this.promptTemplate = value;
            return this;
        }

        /**
         * API name: {@code querySetId}
         */
        @Nonnull
        public final Builder querySetId(@Nullable String value) {
            this.querySetId = value;
            return this;
        }

        /**
         * API name: {@code searchConfigurationList}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>searchConfigurationList</code>.
         * </p>
         */
        @Nonnull
        public final Builder searchConfigurationList(List<String> list) {
            this.searchConfigurationList = _listAddAll(this.searchConfigurationList, list);
            return this;
        }

        /**
         * API name: {@code searchConfigurationList}
         *
         * <p>
         * Adds one or more values to <code>searchConfigurationList</code>.
         * </p>
         */
        @Nonnull
        public final Builder searchConfigurationList(String value, String... values) {
            this.searchConfigurationList = _listAdd(this.searchConfigurationList, value, values);
            return this;
        }

        /**
         * API name: {@code size}
         */
        @Nonnull
        public final Builder size(@Nullable Integer value) {
            this.size = value;
            return this;
        }

        /**
         * The start of the UBI events date range (inclusive).
         * <p>
         * API name: {@code startDate}
         * </p>
         */
        @Nonnull
        public final Builder startDate(@Nullable String value) {
            this.startDate = value;
            return this;
        }

        /**
         * The maximum number of tokens allowed for the LLM prompt. Defaults to 4000.
         * <p>
         * API name: {@code tokenLimit}
         * </p>
         */
        @Nonnull
        public final Builder tokenLimit(@Nullable Integer value) {
            this.tokenLimit = value;
            return this;
        }

        /**
         * Required - API name: {@code type}
         */
        @Nonnull
        public final Builder type(String value) {
            this.type = value;
            return this;
        }

        /**
         * The name of the UBI events index to source click data from.
         * <p>
         * API name: {@code ubiEventsIndex}
         * </p>
         */
        @Nonnull
        public final Builder ubiEventsIndex(@Nullable String value) {
            this.ubiEventsIndex = value;
            return this;
        }

        /**
         * Builds a {@link PutJudgmentsRequest}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public PutJudgmentsRequest build() {
            _checkSingleUse();

            return new PutJudgmentsRequest(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link PutJudgmentsRequest}
     */
    public static final JsonpDeserializer<PutJudgmentsRequest> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        PutJudgmentsRequest::setupPutJudgmentsRequestDeserializer
    );

    protected static void setupPutJudgmentsRequestDeserializer(ObjectDeserializer<PutJudgmentsRequest.Builder> op) {
        op.add(Builder::clickModel, JsonpDeserializer.stringDeserializer(), "clickModel");
        op.add(Builder::contextFields, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "contextFields");
        op.add(Builder::description, JsonpDeserializer.stringDeserializer(), "description");
        op.add(Builder::endDate, JsonpDeserializer.stringDeserializer(), "endDate");
        op.add(Builder::ignoreFailure, JsonpDeserializer.booleanDeserializer(), "ignoreFailure");
        op.add(
            Builder::judgmentRatings,
            JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER)),
            "judgmentRatings"
        );
        op.add(Builder::llmJudgmentRatingType, LLMJudgmentRatingType._DESERIALIZER, "llmJudgmentRatingType");
        op.add(Builder::maxRank, JsonpDeserializer.integerDeserializer(), "maxRank");
        op.add(Builder::modelId, JsonpDeserializer.stringDeserializer(), "modelId");
        op.add(Builder::name, JsonpDeserializer.stringDeserializer(), "name");
        op.add(Builder::overwriteCache, JsonpDeserializer.booleanDeserializer(), "overwriteCache");
        op.add(Builder::promptTemplate, JsonpDeserializer.stringDeserializer(), "promptTemplate");
        op.add(Builder::querySetId, JsonpDeserializer.stringDeserializer(), "querySetId");
        op.add(
            Builder::searchConfigurationList,
            JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()),
            "searchConfigurationList"
        );
        op.add(Builder::size, JsonpDeserializer.integerDeserializer(), "size");
        op.add(Builder::startDate, JsonpDeserializer.stringDeserializer(), "startDate");
        op.add(Builder::tokenLimit, JsonpDeserializer.integerDeserializer(), "tokenLimit");
        op.add(Builder::type, JsonpDeserializer.stringDeserializer(), "type");
        op.add(Builder::ubiEventsIndex, JsonpDeserializer.stringDeserializer(), "ubiEventsIndex");
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code search_relevance.put_judgments}".
     */
    public static final Endpoint<PutJudgmentsRequest, PutJudgmentsResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "PUT",
        // Request path
        request -> "/_plugins/_search_relevance/judgments",
        // Request parameters
        request -> {
            Map<String, String> params = new HashMap<>();
            request.applyQueryParameters(params);
            return params;
        },
        SimpleEndpoint.emptyMap(),
        true,
        PutJudgmentsResponse._DESERIALIZER
    );

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.clickModel);
        result = 31 * result + Objects.hashCode(this.contextFields);
        result = 31 * result + Objects.hashCode(this.description);
        result = 31 * result + Objects.hashCode(this.endDate);
        result = 31 * result + Objects.hashCode(this.ignoreFailure);
        result = 31 * result + Objects.hashCode(this.judgmentRatings);
        result = 31 * result + Objects.hashCode(this.llmJudgmentRatingType);
        result = 31 * result + Objects.hashCode(this.maxRank);
        result = 31 * result + Objects.hashCode(this.modelId);
        result = 31 * result + this.name.hashCode();
        result = 31 * result + Objects.hashCode(this.overwriteCache);
        result = 31 * result + Objects.hashCode(this.promptTemplate);
        result = 31 * result + Objects.hashCode(this.querySetId);
        result = 31 * result + Objects.hashCode(this.searchConfigurationList);
        result = 31 * result + Objects.hashCode(this.size);
        result = 31 * result + Objects.hashCode(this.startDate);
        result = 31 * result + Objects.hashCode(this.tokenLimit);
        result = 31 * result + this.type.hashCode();
        result = 31 * result + Objects.hashCode(this.ubiEventsIndex);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        PutJudgmentsRequest other = (PutJudgmentsRequest) o;
        return Objects.equals(this.clickModel, other.clickModel)
            && Objects.equals(this.contextFields, other.contextFields)
            && Objects.equals(this.description, other.description)
            && Objects.equals(this.endDate, other.endDate)
            && Objects.equals(this.ignoreFailure, other.ignoreFailure)
            && Objects.equals(this.judgmentRatings, other.judgmentRatings)
            && Objects.equals(this.llmJudgmentRatingType, other.llmJudgmentRatingType)
            && Objects.equals(this.maxRank, other.maxRank)
            && Objects.equals(this.modelId, other.modelId)
            && this.name.equals(other.name)
            && Objects.equals(this.overwriteCache, other.overwriteCache)
            && Objects.equals(this.promptTemplate, other.promptTemplate)
            && Objects.equals(this.querySetId, other.querySetId)
            && Objects.equals(this.searchConfigurationList, other.searchConfigurationList)
            && Objects.equals(this.size, other.size)
            && Objects.equals(this.startDate, other.startDate)
            && Objects.equals(this.tokenLimit, other.tokenLimit)
            && this.type.equals(other.type)
            && Objects.equals(this.ubiEventsIndex, other.ubiEventsIndex);
    }
}
