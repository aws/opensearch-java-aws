/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package software.amazon.awssdk.opensearch.client.aos;

import javax.annotation.Nullable;
import software.amazon.awssdk.http.SdkHttpClient;
import software.amazon.awssdk.opensearch.client.transport.OpenSearchTransport;
import software.amazon.awssdk.opensearch.client.transport.TransportOptions;
import software.amazon.awssdk.opensearch.client.transport.aws.AwsSdk2Transport;
import software.amazon.awssdk.opensearch.client.transport.aws.AwsSdk2TransportOptions;
import software.amazon.awssdk.regions.Region;

/**
 * Synchronous data-plane client for Amazon OpenSearch Service.
 */
public class OpenSearchAosClient extends OpenSearchAosClientBase<OpenSearchAosClient> {
    public OpenSearchAosClient(OpenSearchTransport transport) {
        this(transport, null);
    }

    public OpenSearchAosClient(OpenSearchTransport transport, @Nullable TransportOptions transportOptions) {
        super(transport, transportOptions);
    }

    /**
     * Creates an IAM-authenticated AOS client. Requests are signed with the {@code es} service name.
     */
    public static OpenSearchAosClient create(
        @Nullable SdkHttpClient httpClient,
        String host,
        Region region,
        @Nullable AwsSdk2TransportOptions options
    ) {
        return new OpenSearchAosClient(new AwsSdk2Transport(httpClient, host, "es", region, options));
    }

    @Override
    public OpenSearchAosClient withTransportOptions(@Nullable TransportOptions transportOptions) {
        return new OpenSearchAosClient(this.transport, transportOptions);
    }
}
