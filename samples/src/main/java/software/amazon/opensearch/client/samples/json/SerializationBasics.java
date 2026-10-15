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
package software.amazon.opensearch.client.samples.json;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.amazon.opensearch.client.aos.OpenSearchClient;
import software.amazon.opensearch.client.aos.indices.PutIndexTemplateRequest;
import software.amazon.opensearch.client.aos.indices.PutIndexTemplateResponse;
import software.amazon.opensearch.client.samples.SampleClient;
import software.amazon.opensearch.client.samples.Search;

public class SerializationBasics {

    private static final Logger LOGGER = LogManager.getLogger(Search.class);

    private static OpenSearchClient client;

    public static void main(String[] args) {
        try {
            client = SampleClient.create();

            var version = client.info().version();
            LOGGER.info("Server: {}@{}.", version.distribution(), version.number());

            final var indexTemplateName = "my-index";
            final var indexSettingsComponentTemplate = "index-settings";
            final var indexMappingsComponentTemplate = "index-mappings";

            // Create Index Template Request for index 'my-index'.
            PutIndexTemplateRequest putIndexTemplateRequest = PutIndexTemplateRequest.of(
                it -> it.name(indexTemplateName)
                    .indexPatterns("my-index-*")
                    .composedOf(List.of(indexSettingsComponentTemplate, indexMappingsComponentTemplate))
            );

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
