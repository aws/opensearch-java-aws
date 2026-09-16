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

package org.opensearch.client.samples.json;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.opensearch.client.opensearch.OpenSearchClient;
import org.opensearch.client.opensearch.indices.PutIndexTemplateRequest;
import org.opensearch.client.opensearch.indices.PutIndexTemplateResponse;
import org.opensearch.client.opensearch.indices.put_index_template.IndexTemplateMapping;
import org.opensearch.client.samples.SampleClient;
import org.opensearch.client.samples.Search;

public class DeserializationBasics {
    private static final Logger LOGGER = LogManager.getLogger(Search.class);

    private static OpenSearchClient client;

    public static void main(String[] args) {
        try {
            client = SampleClient.create();

            var version = client.info().version();
            LOGGER.info("Server: {}@{}.", version.distribution(), version.number());

            final var indexTemplateName = "my-index";

            // Use Json String/File for storing template.
            String stringTemplate =
                "{\"mappings\":{\"properties\":{\"age\":{\"type\":\"integer\"}}},\"settings\":{\"number_of_shards\":\"2\",\"number_of_replicas\":\"1\"}}";
            // Create Input Stream for the above json template
            InputStream inputStream = new ByteArrayInputStream(stringTemplate.getBytes(StandardCharsets.UTF_8));

            // Create Index Template Request for index 'my-index'.
            PutIndexTemplateRequest putIndexTemplateRequest = new PutIndexTemplateRequest.Builder().name(indexTemplateName)
                .template(new IndexTemplateMapping.Builder().withJson(inputStream).build()) // Use the Builder.withJson method to
                                                                                            // deserialize the inputStream into an instance
                                                                                            // of the IndexTemplateMapping class.
                .build();

            LOGGER.info("Creating index template {}.", indexTemplateName);

            // Use toJsonString method to log Request and Response string.
            LOGGER.debug("Index Template Request: {}.", putIndexTemplateRequest.toJsonString());
            PutIndexTemplateResponse response = client.indices().putIndexTemplate(putIndexTemplateRequest);
            LOGGER.info("Index Template Response: {}.", response.toJsonString());

        } catch (Exception e) {
            LOGGER.error("Exception occurred.", e);
        }
    }
}
