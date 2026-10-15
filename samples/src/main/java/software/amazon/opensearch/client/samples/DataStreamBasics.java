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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.amazon.opensearch.client.aos.indices.CreateDataStreamRequest;
import software.amazon.opensearch.client.aos.indices.DataStreamsStatsRequest;
import software.amazon.opensearch.client.aos.indices.DataStreamsStatsResponse;
import software.amazon.opensearch.client.aos.indices.DeleteDataStreamRequest;
import software.amazon.opensearch.client.aos.indices.GetDataStreamRequest;
import software.amazon.opensearch.client.aos.indices.GetDataStreamResponse;
import software.amazon.opensearch.client.aos.indices.PutIndexTemplateRequest;

/**
 * Run with: {@code ./gradlew :samples:run -Dsamples.mainClass=DataStreamBasics}
 */
public class DataStreamBasics {
    private static final Logger LOGGER = LogManager.getLogger(DataStreamBasics.class);

    public static void main(String[] args) {
        try {
            var client = SampleClient.create();

            var version = client.info().version();
            LOGGER.info("Server: {}@{}", version.distribution(), version.number());

            String dataStreamIndexTemplateName = "sample-data-stream-template";
            String timestampFieldName = "my_timestamp_field";
            String namePattern = "sample-data-stream-*";
            String dataStreamName = "sample-data-stream-1";

            // Create an index template which configures data stream
            PutIndexTemplateRequest putIndexTemplateRequest = new PutIndexTemplateRequest.Builder().name(dataStreamIndexTemplateName)
                .indexPatterns(namePattern)
                .dataStream(ds -> ds.timestampField(t -> t.name(timestampFieldName)))
                .build();
            client.indices().putIndexTemplate(putIndexTemplateRequest);

            // Create a data stream
            CreateDataStreamRequest createDataStreamRequest = new CreateDataStreamRequest.Builder().name(dataStreamName).build();
            client.indices().createDataStream(createDataStreamRequest);
            LOGGER.info("Created a data stream");

            GetDataStreamRequest getDataStreamRequest = new GetDataStreamRequest.Builder().name(dataStreamName).build();
            GetDataStreamResponse getDataStreamResponse = client.indices().getDataStream(getDataStreamRequest);
            LOGGER.info("Found {} data streams", getDataStreamResponse.dataStreams().size());

            DataStreamsStatsRequest dataStreamsStatsRequest = new DataStreamsStatsRequest.Builder().name(dataStreamName).build();
            DataStreamsStatsResponse dataStreamsStatsResponse = client.indices().dataStreamsStats(dataStreamsStatsRequest);
            LOGGER.info("Data stream stats:");
            LOGGER.info("Shards: {}", dataStreamsStatsResponse.shards());
            LOGGER.info("Data stream count: {}", dataStreamsStatsResponse.dataStreamCount());
            LOGGER.info("Backing indices: {}", dataStreamsStatsResponse.backingIndices());
            LOGGER.info("Total store size: {}", dataStreamsStatsResponse.totalStoreSize());
            LOGGER.info("Data stream name: {}", dataStreamsStatsResponse.dataStreams().get(0).dataStream());

            LOGGER.info("Deleting data stream");
            DeleteDataStreamRequest deleteDataStreamRequest = new DeleteDataStreamRequest.Builder().name(dataStreamName).build();
            client.indices().deleteDataStream(deleteDataStreamRequest);
        } catch (Exception e) {
            LOGGER.error("Unexpected exception", e);
        }
    }
}
