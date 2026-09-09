/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package software.amazon.awssdk.opensearch.client.aoss;

import javax.annotation.Nullable;
import software.amazon.awssdk.http.SdkHttpClient;
import software.amazon.awssdk.opensearch.client.transport.OpenSearchTransport;
import software.amazon.awssdk.opensearch.client.transport.TransportOptions;
import software.amazon.awssdk.opensearch.client.transport.aws.AwsSdk2Transport;
import software.amazon.awssdk.opensearch.client.transport.aws.AwsSdk2TransportOptions;
import software.amazon.awssdk.regions.Region;

/**
 * Synchronous data-plane client for Amazon OpenSearch Serverless.
 */
public class OpenSearchAossClient extends OpenSearchAossClientBase<OpenSearchAossClient> {
    public OpenSearchAossClient(OpenSearchTransport transport) {
        this(transport, null);
    }

    public OpenSearchAossClient(OpenSearchTransport transport, @Nullable TransportOptions transportOptions) {
        super(transport, transportOptions);
    }

    /**
     * Creates an IAM-authenticated AOSS client. Requests are signed with the {@code aoss} service name.
     */
    public static OpenSearchAossClient create(
        @Nullable SdkHttpClient httpClient,
        String host,
        Region region,
        @Nullable AwsSdk2TransportOptions options
    ) {
        return new OpenSearchAossClient(new AwsSdk2Transport(httpClient, host, "aoss", region, options));
    }

    @Override
    public OpenSearchAossClient withTransportOptions(@Nullable TransportOptions transportOptions) {
        return new OpenSearchAossClient(this.transport, transportOptions);
    }
}
