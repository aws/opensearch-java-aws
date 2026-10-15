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

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.amazon.opensearch.client.aos._types.Refresh;
import software.amazon.opensearch.client.aos._types.mapping.IntegerNumberProperty;
import software.amazon.opensearch.client.aos._types.mapping.Property;
import software.amazon.opensearch.client.aos._types.mapping.TypeMapping;
import software.amazon.opensearch.client.aos._types.query_dsl.Query;
import software.amazon.opensearch.client.aos.core.BulkRequest;
import software.amazon.opensearch.client.aos.core.SearchRequest;
import software.amazon.opensearch.client.aos.core.SearchResponse;
import software.amazon.opensearch.client.aos.indices.CreateIndexRequest;
import software.amazon.opensearch.client.aos.indices.DeleteIndexRequest;
import software.amazon.opensearch.client.aos.indices.IndexSettings;
import software.amazon.opensearch.client.samples.util.IndexData;

/**
 * Run with: {@code ./gradlew :samples:run -Dsamples.mainClass=BulkBatching}
 */
public class BulkBatching {
    private static final Logger LOGGER = LogManager.getLogger(BulkBatching.class);

    public static void main(String[] args) {
        try {
            var client = SampleClient.create();

            var version = client.info().version();
            LOGGER.info("Server: {}@{}", version.distribution(), version.number());

            final var indexName = "my-index";

            if (!client.indices().exists(r -> r.index(indexName)).value()) {
                LOGGER.info("Creating index {}", indexName);
                IndexSettings settings = new IndexSettings.Builder().numberOfShards(2).numberOfReplicas(1).build();
                TypeMapping mapping = new TypeMapping.Builder().properties(
                    "age",
                    new Property.Builder().integer(new IntegerNumberProperty.Builder().build()).build()
                ).build();
                CreateIndexRequest createIndexRequest = new CreateIndexRequest.Builder().index(indexName)
                    .settings(settings)
                    .mappings(mapping)
                    .build();
                client.indices().create(createIndexRequest);
            }

            LOGGER.info("Bulk indexing documents in batches");

            IndexData doc1 = new IndexData("Document 1", "The text of document 1");
            IndexData doc2 = new IndexData("Document 2", "The text of document 2");
            IndexData doc3 = new IndexData("Document 3", "The text of document 3");
            var documents = List.of(doc1, doc2, doc3);
            final int batchSize = 2;

            // The AWS client exposes the Bulk API directly. Bound each request's operation count.
            for (int start = 0; start < documents.size(); start += batchSize) {
                var batch = new BulkRequest.Builder().index(indexName);
                for (int i = start; i < Math.min(start + batchSize, documents.size()); i++) {
                    var id = "id" + (i + 1);
                    var document = documents.get(i);
                    batch.operations(op -> op.index(b -> b.id(id).document(document)));
                }
                var result = client.bulk(batch.build());
                if (result.errors()) {
                    throw new IllegalStateException("A bulk batch contains failed operations: " + result.items());
                }
            }
            LOGGER.info("Bulk indexing completed");

            // Refresh index to make documents searchable
            client.indices().refresh(r -> r.index(indexName));

            Query query = Query.of(qb -> qb.match(mb -> mb.field("title").query(fv -> fv.stringValue("Document"))));
            final SearchRequest.Builder searchReq = new SearchRequest.Builder().allowPartialSearchResults(false)
                .index(List.of(indexName))
                .size(10)
                .source(sc -> sc.fetch(false))
                .ignoreThrottled(false)
                .query(query);

            SearchResponse<IndexData> searchResponse = client.search(searchReq.build(), IndexData.class);
            LOGGER.info("Found {} documents", searchResponse.hits().hits().size());

            LOGGER.info("Bulk update document");
            doc1.setText("Updated Document");

            var updated = client.bulk(
                b -> b.index(indexName).operations(op -> op.update(u -> u.id("id1").document(doc1))).refresh(Refresh.WaitFor)
            );
            if (updated.errors()) {
                throw new IllegalStateException("The bulk update contains failed operations: " + updated.items());
            }
            LOGGER.info("Bulk update completed");

            LOGGER.info("Deleting index {}", indexName);
            DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest.Builder().index(indexName).build();
            client.indices().delete(deleteIndexRequest);
        } catch (Exception e) {
            LOGGER.error("Unexpected exception", e);
        }
    }
}
