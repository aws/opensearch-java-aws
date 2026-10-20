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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.amazon.opensearch.client.aos.OpenSearchClient;
import software.amazon.opensearch.client.aos._types.FieldValue;
import software.amazon.opensearch.client.aos._types.OpenSearchVersionInfo;
import software.amazon.opensearch.client.aos._types.mapping.FlatObjectProperty;
import software.amazon.opensearch.client.aos._types.mapping.Property;
import software.amazon.opensearch.client.aos.core.IndexRequest;
import software.amazon.opensearch.client.aos.core.SearchRequest;
import software.amazon.opensearch.client.aos.core.SearchResponse;
import software.amazon.opensearch.client.aos.core.search.Hit;
import software.amazon.opensearch.client.aos.indices.CreateIndexRequest;
import software.amazon.opensearch.client.samples.util.IssueDocument;

public class FlatObjectBasics {
    private static final Logger LOGGER = LogManager.getLogger(IndexingBasics.class);

    public static void main(String[] args) {
        try {
            OpenSearchClient client = SampleClient.create();

            OpenSearchVersionInfo version = client.info().version();
            LOGGER.info("Server: {}@{}", version.distribution(), version.number());

            final String indexName = "flat_object-sample";

            // Create a new index with an "issue" field with flat_object type
            if (!client.indices().exists(e -> e.index(indexName)).value()) {
                final CreateIndexRequest createIndexRequest = new CreateIndexRequest.Builder().index(indexName)
                    .mappings(m -> m.properties("issue", Property.of(p -> p.flatObject(new FlatObjectProperty.Builder().build()))))
                    .build();
                client.indices().create(createIndexRequest);
            }

            // Index some flat object documents
            final IssueDocument issueDocument = new IssueDocument();
            final IssueDocument.Issue issue = new IssueDocument.Issue();
            issue.setNumber("123456");
            final IssueDocument.Labels labels = new IssueDocument.Labels();
            labels.setBackport(Arrays.asList("1.3", "2.0"));
            labels.setVersion("2.1");
            final IssueDocument.Category category = new IssueDocument.Category();
            category.setType("API");
            category.setLevel("enhancement");

            labels.setCategory(category);
            issue.setLabels(labels);

            issueDocument.setIssue(issue);
            final IndexRequest<IssueDocument> indexRequest = new IndexRequest.Builder<IssueDocument>().index(indexName)
                .id("1")
                .document(issueDocument)
                .build();

            client.index(indexRequest);

            // Index second document
            final IssueDocument document2 = new IssueDocument();
            final IssueDocument.Issue issue2 = new IssueDocument.Issue();
            issue2.setNumber("123457");

            IssueDocument.Labels labels2 = new IssueDocument.Labels();
            labels2.setVersion("2.2");

            IssueDocument.Category category2 = new IssueDocument.Category();
            category2.setType("API");
            category2.setLevel("bug");

            labels2.setCategory(category2);
            issue2.setLabels(labels2);

            document2.setIssue(issue2);

            final IndexRequest<IssueDocument> indexRequest2 = new IndexRequest.Builder<IssueDocument>().index(indexName)
                .id("2")
                .document(document2)
                .build();

            client.index(indexRequest2);

            // wait for the document to index - as refresh period is set to 3s
            Thread.sleep(3000);

            // Search for the documents
            // Ref: https://opensearch.org/docs/latest/field-types/supported-field-types/flat-object/
            // Even if you don’t know the field names, you can search for a leaf value in the entire flat object.
            // For example, the following request searches for all issues labeled as bugs
            SearchRequest searchRequest = new SearchRequest.Builder().index(indexName)
                .query(q -> q.match(m -> m.field("issue").query(FieldValue.of("bug"))))
                .build();

            SearchResponse<IssueDocument> searchResponse = client.search(searchRequest, IssueDocument.class);
            for (Hit<IssueDocument> hit : searchResponse.hits().hits()) {
                LOGGER.info("Found {} with score {}", hit.source(), hit.score());
            }

            // Alternatively, if you know the subfield name in which to search, provide the field’s path in dot notation
            SearchRequest searchRequest2 = new SearchRequest.Builder().index(indexName)
                .query(q -> q.match(m -> m.field("issue.labels.category.level").query(FieldValue.of("bug"))))
                .build();

            SearchResponse<IssueDocument> searchResponse2 = client.search(searchRequest2, IssueDocument.class);
            for (Hit<IssueDocument> hit : searchResponse2.hits().hits()) {
                LOGGER.info("Found {} with score {}", hit.source(), hit.score());
            }

        } catch (Exception e) {
            LOGGER.error("Unexpected exception", e);
        }
    }
}
