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
package software.amazon.awssdk.opensearch.client.generic;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;

/**
 * Generic HTTP response from OpenSearch
 */
public interface Response extends AutoCloseable {
    /**
     * The optional body of the response. If {@code Optional.empty()} then no body
     * was sent with the response.
     * @return optional body of the response
     */
    Optional<Body> getBody();

    /**
     * The HTTP protocol version
     * @return HTTP protocol version
     */
    String getProtocol();

    /**
     * The HTTP method
     * @return HTTP method
     */
    String getMethod();

    /**
     * The status message
     * @return status message
     */
    String getReason();

    /**
     * The status code
     * @return status code
     */
    int getStatus();

    /**
     * Full URI of the request
     * @return full URI of the request
     */
    String getUri();

    /**
     * List of headers
     * @return list of headers
     */
    Collection<Map.Entry<String, String>> getHeaders();

    /**
     * Releases all resources associated with this body stream.
     */
    void close() throws IOException;
}
