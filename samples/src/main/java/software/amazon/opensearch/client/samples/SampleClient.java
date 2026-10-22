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

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import javax.net.ssl.SSLContext;
import org.apache.hc.client5.http.auth.AuthScope;
import org.apache.hc.client5.http.auth.UsernamePasswordCredentials;
import org.apache.hc.client5.http.impl.auth.BasicCredentialsProvider;
import org.apache.hc.client5.http.impl.nio.PoolingAsyncClientConnectionManager;
import org.apache.hc.client5.http.impl.nio.PoolingAsyncClientConnectionManagerBuilder;
import org.apache.hc.client5.http.ssl.ClientTlsStrategyBuilder;
import org.apache.hc.client5.http.ssl.NoopHostnameVerifier;
import org.apache.hc.core5.http.HttpHost;
import org.apache.hc.core5.http.nio.ssl.TlsStrategy;
import org.apache.hc.core5.ssl.SSLContextBuilder;
import software.amazon.opensearch.client.aos.OpenSearchClient;
import software.amazon.opensearch.client.json.jackson.JacksonJsonpMapper;
import software.amazon.opensearch.client.transport.httpclient5.ApacheHttpClient5Transport;
import software.amazon.opensearch.client.transport.httpclient5.ApacheHttpClient5TransportBuilder;

public class SampleClient {
    public static OpenSearchClient create() throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        Map<String, String> env = System.getenv();
        boolean https = Boolean.parseBoolean(env.getOrDefault("HTTPS", "true"));
        String hostname = env.getOrDefault("HOST", "localhost");
        int port = Integer.parseInt(env.getOrDefault("PORT", "9200"));
        String user = env.getOrDefault("USERNAME", "admin");
        String pass = env.getOrDefault("PASSWORD", "admin");

        final HttpHost[] hosts = new HttpHost[] { new HttpHost(https ? "https" : "http", hostname, port) };

        final SSLContext sslContext = SSLContextBuilder.create().loadTrustMaterial(null, (chains, authType) -> true).build();

        final ApacheHttpClient5Transport transport = ApacheHttpClient5TransportBuilder.builder(hosts)
            .setMapper(new JacksonJsonpMapper())
            .setHttpClientConfigCallback(httpClientBuilder -> {
                final BasicCredentialsProvider credentialsProvider = new BasicCredentialsProvider();
                for (final HttpHost host : hosts) {
                    credentialsProvider.setCredentials(new AuthScope(host), new UsernamePasswordCredentials(user, pass.toCharArray()));
                }

                // Disable SSL/TLS verification as our local testing clusters use self-signed certificates
                final TlsStrategy tlsStrategy = ClientTlsStrategyBuilder.create()
                    .setSslContext(sslContext)
                    .setHostnameVerifier(NoopHostnameVerifier.INSTANCE)
                    .build();

                final PoolingAsyncClientConnectionManager connectionManager = PoolingAsyncClientConnectionManagerBuilder.create()
                    .setTlsStrategy(tlsStrategy)
                    .build();

                return httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider).setConnectionManager(connectionManager);
            })
            .build();
        return new OpenSearchClient(transport);
    }
}
