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
package software.amazon.opensearch.client.samples;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.amazon.opensearch.client.aos.OpenSearchClient;
import software.amazon.opensearch.client.aos._types.FieldValue;
import software.amazon.opensearch.client.aos._types.Refresh;
import software.amazon.opensearch.client.aos._types.SortOrder;
import software.amazon.opensearch.client.aos._types.aggregations.Aggregate;
import software.amazon.opensearch.client.aos._types.aggregations.Aggregation;
import software.amazon.opensearch.client.aos._types.aggregations.CompositeAggregationFields;
import software.amazon.opensearch.client.aos._types.aggregations.CompositeAggregationSource;
import software.amazon.opensearch.client.aos._types.analysis.Analyzer;
import software.amazon.opensearch.client.aos._types.analysis.CustomAnalyzer;
import software.amazon.opensearch.client.aos._types.analysis.ShingleTokenFilter;
import software.amazon.opensearch.client.aos._types.analysis.TokenFilter;
import software.amazon.opensearch.client.aos._types.analysis.TokenFilterDefinition;
import software.amazon.opensearch.client.aos._types.mapping.Property;
import software.amazon.opensearch.client.aos._types.mapping.TextProperty;
import software.amazon.opensearch.client.aos._types.mapping.TypeMapping;
import software.amazon.opensearch.client.aos._types.query_dsl.MatchQuery;
import software.amazon.opensearch.client.aos._types.query_dsl.Query;
import software.amazon.opensearch.client.aos.core.IndexRequest;
import software.amazon.opensearch.client.aos.core.SearchRequest;
import software.amazon.opensearch.client.aos.core.SearchResponse;
import software.amazon.opensearch.client.aos.core.search.CompletionSuggester;
import software.amazon.opensearch.client.aos.core.search.FieldSuggester;
import software.amazon.opensearch.client.aos.core.search.FieldSuggesterBuilders;
import software.amazon.opensearch.client.aos.core.search.PhraseSuggester;
import software.amazon.opensearch.client.aos.core.search.Suggester;
import software.amazon.opensearch.client.aos.core.search.TermSuggester;
import software.amazon.opensearch.client.aos.indices.CreateIndexRequest;
import software.amazon.opensearch.client.aos.indices.DeleteIndexRequest;
import software.amazon.opensearch.client.aos.indices.IndexSettings;
import software.amazon.opensearch.client.aos.indices.IndexSettingsAnalysis;
import software.amazon.opensearch.client.samples.util.AppData;
import software.amazon.opensearch.client.samples.util.IndexData;

/**
 * Run with: {@code ./gradlew :samples:run -Dsamples.mainClass=Search}
 */
public class Search {
    private static final Logger LOGGER = LogManager.getLogger(Search.class);

    private static OpenSearchClient client;

    public static void main(String[] args) {
        try {
            client = SampleClient.create();

            var version = client.info().version();
            LOGGER.info("Server: {}@{}", version.distribution(), version.number());

            final var indexName = "my-index";

            if (!client.indices().exists(r -> r.index(indexName)).value()) {
                LOGGER.info("Creating index {}", indexName);
                CreateIndexRequest createIndexRequest = new CreateIndexRequest.Builder().index(indexName).build();
                client.indices().create(createIndexRequest);
            }

            LOGGER.info("Indexing documents");
            IndexData indexData = new IndexData("Document 1", "Text for document 1");
            IndexRequest<IndexData> indexRequest = new IndexRequest.Builder<IndexData>().index(indexName)
                .id("1")
                .document(indexData)
                .build();
            client.index(indexRequest);

            indexData = new IndexData("Document 2", "Text for document 2");
            indexRequest = new IndexRequest.Builder<IndexData>().index(indexName).id("2").document(indexData).build();
            client.index(indexRequest);

            // wait for the document to index
            Thread.sleep(3000);

            SearchResponse<IndexData> searchResponse = client.search(s -> s.index(indexName), IndexData.class);
            for (var hit : searchResponse.hits().hits()) {
                LOGGER.info("Found {} with score {}", hit.source(), hit.score());
            }

            SearchRequest searchRequest = new SearchRequest.Builder().query(
                q -> q.match(m -> m.field("text").query(FieldValue.of("Text for document 2")))
            ).build();

            searchResponse = client.search(searchRequest, IndexData.class);
            for (var hit : searchResponse.hits().hits()) {
                LOGGER.info("Found {} with score {}", hit.source(), hit.score());
            }

            searchRequest = new SearchRequest.Builder().query(q -> q.match(m -> m.field("title").query(FieldValue.of("Document 1"))))
                .aggregations("titles", new Aggregation.Builder().terms(t -> t.field("title.keyword")).build())
                .build();

            searchResponse = client.search(searchRequest, IndexData.class);
            for (Map.Entry<String, Aggregate> entry : searchResponse.aggregations().entrySet()) {
                LOGGER.info("Agg - {}", entry.getKey());
                entry.getValue().sterms().buckets().array().forEach(b -> {
                    var bucket = b.toJson().asJsonObject();
                    LOGGER.info("{} : {}", bucket.getString("key"), bucket.getJsonNumber("doc_count").longValue());
                });
            }

            // Custom Aggregations
            final Map<String, CompositeAggregationSource> comAggrSrcMap = new HashMap<>();
            CompositeAggregationSource compositeAggregationSource1 = new CompositeAggregationSource.Builder().terms(
                termsAggrBuilder -> termsAggrBuilder.field("title.keyword").missingBucket(false).order(SortOrder.Asc)
            ).build();
            comAggrSrcMap.put("titles", compositeAggregationSource1);

            CompositeAggregationFields compAgg = new CompositeAggregationFields.Builder().sources(comAggrSrcMap).build();
            Aggregation aggregation = new Aggregation.Builder().composite(compAgg).build();

            SearchRequest request = SearchRequest.of(
                r -> r.index(indexName)
                    .query(q -> q.match(m -> m.field("title").query(FieldValue.of("Document 1"))))
                    .aggregations("my_buckets", aggregation)
            );
            SearchResponse<IndexData> response = client.search(request, IndexData.class);
            for (Map.Entry<String, Aggregate> entry : response.aggregations().entrySet()) {
                LOGGER.info("Agg - {}", entry.getKey());
                entry.getValue().composite().buckets().array().forEach(b -> LOGGER.info("{} : {}", b.key(), b.docCount()));
            }

            // HybridSearch
            Query searchQuery = Query.of(
                h -> h.hybrid(
                    q -> q.queries(
                        Arrays.asList(new MatchQuery.Builder().field("text").query(FieldValue.of("Text for document 2")).build().toQuery())
                    )
                )
            );
            searchRequest = new SearchRequest.Builder().query(searchQuery).build();
            searchResponse = client.search(searchRequest, IndexData.class);
            for (var hit : searchResponse.hits().hits()) {
                LOGGER.info("Found {} with score {}", hit.source(), hit.score());
            }

            LOGGER.info("Deleting index {}", indexName);
            DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest.Builder().index(indexName).build();
            client.indices().delete(deleteIndexRequest);

            searchWithCompletionSuggester();
            searchWithTermSuggester();
            searchWithPhraseSuggester();
        } catch (Exception e) {
            LOGGER.error("Unexpected exception", e);
        }
    }

    public static void searchWithCompletionSuggester() {
        try {
            var index = "completion-suggester";
            Property intValueProp = new Property.Builder().long_(v -> v).build();
            Property msgCompletionProp = new Property.Builder().completion(c -> c).build();
            client.indices()
                .create(c -> c.index(index).mappings(m -> m.properties("intValue", intValueProp).properties("msg", msgCompletionProp)));

            AppData appData = new AppData();
            appData.setIntValue(1337);
            appData.setMsg("foo");

            client.index(b -> b.index(index).id("1").document(appData).refresh(Refresh.True));

            appData.setIntValue(1338);
            appData.setMsg("foobar");

            client.index(b -> b.index(index).id("2").document(appData).refresh(Refresh.True));

            String suggesterName = "msgSuggester";

            CompletionSuggester completionSuggester = FieldSuggesterBuilders.completion().field("msg").size(1).build();
            FieldSuggester fieldSuggester = new FieldSuggester.Builder().prefix("foo").completion(completionSuggester).build();
            Suggester suggester = new Suggester.Builder().suggesters(Collections.singletonMap(suggesterName, fieldSuggester)).build();
            SearchRequest searchRequest = new SearchRequest.Builder().index(index).suggest(suggester).build();

            SearchResponse<AppData> searchResponse = client.search(searchRequest, AppData.class);
            LOGGER.info("Suggester response size {}", searchResponse.suggest().get(suggesterName).size());

            client.indices().delete(new DeleteIndexRequest.Builder().index(index).build());
        } catch (Exception e) {
            LOGGER.error("Unexpected exception", e);
        }
    }

    public static void searchWithTermSuggester() {
        try {
            String index = "term-suggester";

            // term suggester does not require a special mapping
            client.indices().create(c -> c.index(index));

            AppData appData = new AppData();
            appData.setIntValue(1337);
            appData.setMsg("foo");

            client.index(b -> b.index(index).id("1").document(appData).refresh(Refresh.True));

            appData.setIntValue(1338);
            appData.setMsg("foobar");

            client.index(b -> b.index(index).id("2").document(appData).refresh(Refresh.True));

            String suggesterName = "msgSuggester";

            TermSuggester termSuggester = FieldSuggesterBuilders.term().field("msg").size(1).build();
            FieldSuggester fieldSuggester = new FieldSuggester.Builder().text("fool").term(termSuggester).build();
            Suggester suggester = new Suggester.Builder().suggesters(Collections.singletonMap(suggesterName, fieldSuggester)).build();
            SearchRequest searchRequest = new SearchRequest.Builder().index(index).suggest(suggester).build();

            SearchResponse<AppData> searchResponse = client.search(searchRequest, AppData.class);
            LOGGER.info("Suggester response size {}", searchResponse.suggest().get(suggesterName).size());

            client.indices().delete(new DeleteIndexRequest.Builder().index(index).build());
        } catch (Exception e) {
            LOGGER.error("Unexpected exception", e);
        }
    }

    public static void searchWithPhraseSuggester() {
        try {
            String index = "test-phrase-suggester";

            ShingleTokenFilter shingleTokenFilter = new ShingleTokenFilter.Builder().minShingleSize(2).maxShingleSize(3).build();

            Analyzer analyzer = new Analyzer.Builder().custom(
                new CustomAnalyzer.Builder().tokenizer("standard").filter(Arrays.asList("lowercase", "shingle")).build()
            ).build();

            TokenFilter tokenFilter = new TokenFilter.Builder().definition(
                new TokenFilterDefinition.Builder().shingle(shingleTokenFilter).build()
            ).build();

            IndexSettingsAnalysis indexSettingsAnalysis = new IndexSettingsAnalysis.Builder().analyzer("trigram", analyzer)
                .filter("shingle", tokenFilter)
                .build();

            IndexSettings settings = new IndexSettings.Builder().analysis(indexSettingsAnalysis).build();

            TypeMapping mapping = new TypeMapping.Builder().properties(
                "msg",
                new Property.Builder().text(
                    new TextProperty.Builder().fields(
                        "trigram",
                        new Property.Builder().text(new TextProperty.Builder().analyzer("trigram").build()).build()
                    ).build()
                ).build()
            ).build();

            client.indices().create(c -> c.index(index).settings(settings).mappings(mapping));

            AppData appData = new AppData();
            appData.setIntValue(1337);
            appData.setMsg("Design Patterns");

            client.index(b -> b.index(index).id("1").document(appData).refresh(Refresh.True));

            appData.setIntValue(1338);
            appData.setMsg("Software Architecture Patterns Explained");

            client.index(b -> b.index(index).id("2").document(appData).refresh(Refresh.True));

            String suggesterName = "msgSuggester";

            PhraseSuggester phraseSuggester = FieldSuggesterBuilders.phrase().field("msg.trigram").build();
            FieldSuggester fieldSuggester = new FieldSuggester.Builder().text("design paterns").phrase(phraseSuggester).build();
            Suggester suggester = new Suggester.Builder().suggesters(Collections.singletonMap(suggesterName, fieldSuggester)).build();
            SearchRequest searchRequest = new SearchRequest.Builder().index(index).suggest(suggester).build();

            SearchResponse<AppData> searchResponse = client.search(searchRequest, AppData.class);
            LOGGER.info("Suggester response size {}", searchResponse.suggest().get(suggesterName).size());

            client.indices().delete(new DeleteIndexRequest.Builder().index(index).build());
        } catch (Exception e) {
            LOGGER.error("Unexpected exception", e);
        }
    }
}
