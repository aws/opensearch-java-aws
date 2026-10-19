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
package software.amazon.opensearch.client.transport;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * Captures one HTTP exchange on loopback without contacting AWS.
 */
public final class HttpTransportTestServer implements AutoCloseable {
    private final ServerSocket server = new ServerSocket(0, 1, InetAddress.getByName("127.0.0.1"));
    private final FutureTask<CapturedRequest> exchange;

    public HttpTransportTestServer() throws IOException {
        server.setSoTimeout(10000);
        exchange = new FutureTask<>(() -> {
            try (Socket socket = server.accept()) {
                socket.setSoTimeout(10000);
                DataInputStream input = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
                String[] requestLine = readLine(input).split(" ");
                Map<String, String> headers = new LinkedHashMap<>();
                String line;
                while (!(line = readLine(input)).isEmpty()) {
                    int colon = line.indexOf(':');
                    headers.put(line.substring(0, colon).toLowerCase(Locale.ROOT), line.substring(colon + 1).trim());
                }
                byte[] body = new byte[Integer.parseInt(headers.getOrDefault("content-length", "0"))];
                input.readFully(body);
                socket.getOutputStream()
                    .write(
                        "HTTP/1.1 200 OK\r\nContent-Type: application/json\r\nContent-Length: 2\r\nConnection: close\r\n\r\n{}".getBytes(
                            StandardCharsets.US_ASCII
                        )
                    );
                socket.getOutputStream().flush();
                return new CapturedRequest(requestLine[0], requestLine[1], headers, new String(body, StandardCharsets.UTF_8));
            }
        });
        Thread thread = new Thread(exchange, "http-transport-test");
        thread.setDaemon(true);
        thread.start();
    }

    public String baseUrl() {
        return "http://127.0.0.1:" + server.getLocalPort();
    }

    public HttpURLConnection openConnection(URI requestUri) {
        try {
            String query = requestUri.getRawQuery() == null ? "" : "?" + requestUri.getRawQuery();
            HttpURLConnection connection = (HttpURLConnection) URI.create(baseUrl() + requestUri.getRawPath() + query)
                .toURL()
                .openConnection();
            connection.setConnectTimeout(10000);
            connection.setReadTimeout(10000);
            return connection;
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public CapturedRequest awaitRequest() throws Exception {
        return exchange.get(10, TimeUnit.SECONDS);
    }

    private static String readLine(DataInputStream input) throws IOException {
        ByteArrayOutputStream line = new ByteArrayOutputStream();
        int value;
        while ((value = input.read()) != '\n') {
            if (value == -1) {
                throw new IOException("Unexpected end of HTTP headers");
            }
            if (value != '\r') {
                line.write(value);
            }
        }
        return new String(line.toByteArray(), StandardCharsets.US_ASCII);
    }

    @Override
    public void close() throws IOException {
        server.close();
    }

    public static final class CapturedRequest {
        public final String method;
        public final String path;
        public final Map<String, String> headers;
        public final String body;

        private CapturedRequest(String method, String path, Map<String, String> headers, String body) {
            this.method = method;
            this.path = path;
            this.headers = headers;
            this.body = body;
        }
    }
}
