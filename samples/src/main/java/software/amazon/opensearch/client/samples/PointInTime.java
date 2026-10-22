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

import java.util.Collections;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.amazon.opensearch.client.aos.OpenSearchClient;
import software.amazon.opensearch.client.aos._types.OpenSearchVersionInfo;
import software.amazon.opensearch.client.aos._types.Time;
import software.amazon.opensearch.client.aos._types.mapping.IntegerNumberProperty;
import software.amazon.opensearch.client.aos._types.mapping.Property;
import software.amazon.opensearch.client.aos._types.mapping.TypeMapping;
import software.amazon.opensearch.client.aos.core.CreatePitRequest;
import software.amazon.opensearch.client.aos.core.CreatePitResponse;
import software.amazon.opensearch.client.aos.core.DeletePitRequest;
import software.amazon.opensearch.client.aos.core.DeletePitResponse;
import software.amazon.opensearch.client.aos.core.GetAllPitsResponse;
import software.amazon.opensearch.client.aos.indices.CreateIndexRequest;
import software.amazon.opensearch.client.aos.indices.DeleteIndexRequest;
import software.amazon.opensearch.client.aos.indices.IndexSettings;

/**
 * Run with: {@code ./gradlew :samples:run -Dsamples.mainClass=PointInTime}
 */
public class PointInTime {
    private static final Logger LOGGER = LogManager.getLogger(PointInTime.class);

    public static void main(String[] args) {
        try {
            OpenSearchClient client = SampleClient.create();

            OpenSearchVersionInfo version = client.info().version();
            LOGGER.info("Server: {}@{}", version.distribution(), version.number());

            final String indexName = "my-index";

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

            CreatePitRequest createPitRequest = new CreatePitRequest.Builder().index(Collections.singletonList(indexName))
                .keepAlive(new Time.Builder().time("100m").build())
                .build();

            CreatePitResponse createPitResponse = client.createPit(createPitRequest);
            LOGGER.info("PIT created with id: {}", createPitResponse.pitId());

            GetAllPitsResponse listAllPitResponse = client.getAllPits();
            LOGGER.info("Found {} PITs", listAllPitResponse.pits().size());

            DeletePitRequest deletePitRequest = new DeletePitRequest.Builder().pitId(Collections.singletonList(createPitResponse.pitId()))
                .build();
            DeletePitResponse deletePitResponse = client.deletePit(deletePitRequest);
            LOGGER.info("Deleting PIT: {}", deletePitResponse.pits());

            LOGGER.info("Deleting index {}", indexName);
            DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest.Builder().index(indexName).build();
            client.indices().delete(deleteIndexRequest);
        } catch (Exception e) {
            LOGGER.error("Unexpected exception", e);
        }
    }
}
